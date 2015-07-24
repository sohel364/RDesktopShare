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

package net.sm.RemoteDesktop.webapp.net.basic.websocket.jetty9;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.eclipse.jetty.websocket.api.UpgradeRequest;

import net.sm.RemoteDesktop.webapp.net.basic.TunnelRequest;

/**
 * Jetty 9 WebSocket-specific implementation of TunnelRequest.
 *
 * @author Michael Jumper
 */
public class WebSocketTunnelRequest implements TunnelRequest {

    /**
     * All parameters passed via HTTP to the WebSocket handshake.
     */
    private final Map<String, String[]> handshakeParameters;
    
    /**
     * Creates a TunnelRequest implementation which delegates parameter and
     * session retrieval to the given UpgradeRequest.
     *
     * @param request The UpgradeRequest to wrap.
     */
    public WebSocketTunnelRequest(UpgradeRequest request) {
        this.handshakeParameters = request.getParameterMap();
    }

    @Override
    public String getParameter(String name) {

        // Pull list of values, if present
        List<String> values = getParameterValues(name);
        if (values == null || values.isEmpty())
            return null;

        // Return first parameter value arbitrarily
        return values.get(0);

    }

    @Override
    public List<String> getParameterValues(String name) {

        String[] values = handshakeParameters.get(name);
        if (values == null)
            return null;

        return Arrays.asList(values);
    }
    
}
