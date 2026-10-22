package cz.msebera.android.httpclient.params;

import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.config.SocketConfig;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class HttpParamConfig {
    private HttpParamConfig() {
    }

    public static SocketConfig getSocketConfig(HttpParams r3) {
        return SocketConfig.custom().setSoTimeout(r3.getIntParameter(CoreConnectionPNames.SO_TIMEOUT, 0)).setSoReuseAddress(r3.getBooleanParameter(CoreConnectionPNames.SO_REUSEADDR, false)).setSoKeepAlive(r3.getBooleanParameter(CoreConnectionPNames.SO_KEEPALIVE, false)).setSoLinger(r3.getIntParameter(CoreConnectionPNames.SO_LINGER, -1)).setTcpNoDelay(r3.getBooleanParameter(CoreConnectionPNames.TCP_NODELAY, true)).build();
    }

    public static MessageConstraints getMessageConstraints(HttpParams r3) {
        return MessageConstraints.custom().setMaxHeaderCount(r3.getIntParameter(CoreConnectionPNames.MAX_HEADER_COUNT, -1)).setMaxLineLength(r3.getIntParameter(CoreConnectionPNames.MAX_LINE_LENGTH, -1)).build();
    }

    public static ConnectionConfig getConnectionConfig(HttpParams r3) {
        MessageConstraints r0 = getMessageConstraints(r3);
        String r1 = (String) r3.getParameter("http.protocol.element-charset");
        ConnectionConfig.Builder r2 = ConnectionConfig.custom();
        if (r1 == null) goto L5;
        Charset r4 = Charset.forName(r1);
    L7:
        return r2.setCharset(r4).setMalformedInputAction((CodingErrorAction) r3.getParameter(CoreProtocolPNames.HTTP_MALFORMED_INPUT_ACTION)).setMalformedInputAction((CodingErrorAction) r3.getParameter(CoreProtocolPNames.HTTP_UNMAPPABLE_INPUT_ACTION)).setMessageConstraints(r0).build();
    L5:
        r4 = null;
        goto L7
    }
}
