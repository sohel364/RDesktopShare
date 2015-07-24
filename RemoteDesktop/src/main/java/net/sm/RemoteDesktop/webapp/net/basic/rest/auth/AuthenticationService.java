/*
 * Copyright (C) 2014 Glyptodon LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package net.sm.RemoteDesktop.webapp.net.basic.rest.auth;

import com.google.inject.Inject;

import net.sm.RemoteDesktop.webapp.net.basic.GuacamoleSession;

import org.glyptodon.guacamole.GuacamoleException;
import org.glyptodon.guacamole.GuacamoleUnauthorizedException;
import org.glyptodon.guacamole.net.auth.UserContext;

/**
 * A service for performing authentication checks in REST endpoints.
 * 
 * @author James Muehlner
 */
public class AuthenticationService {
    
    /**
     * The map of auth tokens to sessions for the REST endpoints.
     */
    @Inject
    private TokenSessionMap tokenSessionMap;
    
    /**
     * Finds the Guacamole session for a given auth token, if the auth token
     * represents a currently logged in user. Throws an unauthorized error
     * otherwise.
      * 
     * @param authToken The auth token to check against the map of logged in users.
     * @return The session that corresponds to the provided auth token.
     * @throws GuacamoleException If the auth token does not correspond to any
     *                            logged in user.
     */
    public GuacamoleSession getGuacamoleSession(String authToken) 
            throws GuacamoleException {
        
        // Try to get the session from the map of logged in users.
        GuacamoleSession session = tokenSessionMap.get(authToken);
       
        // Authentication failed.
        if (session == null)
            throw new GuacamoleUnauthorizedException("Permission Denied.");
        
        return session;

    }

    /**
     * Finds the UserContext for a given auth token, if the auth token represents
     * a currently logged in user. Throws an unauthorized error otherwise.
     * 
     * @param authToken The auth token to check against the map of logged in users.
     * @return The user context that corresponds to the provided auth token.
     * @throws GuacamoleException If the auth token does not correspond to any
     *                            logged in user.
     */
    public UserContext getUserContext(String authToken)  throws GuacamoleException {
        return getGuacamoleSession(authToken).getUserContext();
    }
    
}
