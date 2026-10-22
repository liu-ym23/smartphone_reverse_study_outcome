package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.params.CoreConnectionPNames;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.Socket;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class DefaultHttpServerConnection extends SocketHttpServerConnection {
    public DefaultHttpServerConnection() {
    }

    @Override // cz.msebera.android.httpclient.impl.SocketHttpServerConnection
    public void bind(Socket r5, HttpParams r6) throws IOException {
        Args.notNull(r5, "Socket");
        Args.notNull(r6, "HTTP parameters");
        assertNotOpen();
        boolean r1 = true;
        r5.setTcpNoDelay(r6.getBooleanParameter(CoreConnectionPNames.TCP_NODELAY, true));
        r5.setSoTimeout(r6.getIntParameter(CoreConnectionPNames.SO_TIMEOUT, 0));
        r5.setKeepAlive(r6.getBooleanParameter(CoreConnectionPNames.SO_KEEPALIVE, false));
        int r0 = r6.getIntParameter(CoreConnectionPNames.SO_LINGER, -1);
        if (r0 < 0) goto L8;
        if (r0 <= 0) goto L6;
        boolean r3 = true;
    L7:
        r5.setSoLinger(r3, r0);
        goto L8
    L6:
        r3 = false;
    L8:
        if (r0 < 0) goto L13;
        if (r0 > 0) goto L12;
        r1 = false;
    L12:
        r5.setSoLinger(r1, r0);
    L13:
        super.bind(r5, r6);
    }
}
