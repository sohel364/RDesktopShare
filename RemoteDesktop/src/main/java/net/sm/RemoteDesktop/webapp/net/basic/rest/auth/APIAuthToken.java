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

/**
 * A simple object to represent an auth token/userID pair in the API.
 * 
 * @author James Muehlner
 */
public class APIAuthToken {
    
    /**
     * The auth token.
     */
    private final String authToken;
    
    
    /**
     * The user ID.
     */
    private final String userID;

    /**
     * Get the auth token.
     * @return The auth token. 
     */
    public String getAuthToken() {
        return authToken;
    }
    
    /**
     * Get the user ID.
     * @return The user ID.
     */
    public String getUserID() {
        return userID;
    }
    
    /**
     * Create a new APIAuthToken Object with the given auth token.
     * 
     * @param authToken The auth token to create the new APIAuthToken with.
     * @param userID The ID of the user owning the given token.
     */
    public APIAuthToken(String authToken, String userID) {
        this.authToken = authToken;
        this.userID = userID;
    }
}
