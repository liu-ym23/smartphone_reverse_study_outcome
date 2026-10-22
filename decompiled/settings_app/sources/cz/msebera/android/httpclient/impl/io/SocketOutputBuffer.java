package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.Socket;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class SocketOutputBuffer extends AbstractSessionOutputBuffer {
    public SocketOutputBuffer(Socket r2, int r3, HttpParams r4) throws IOException {
        Args.notNull(r2, "Socket");
        if (r3 >= 0) goto L6;
        r3 = r2.getSendBufferSize();
    L6:
        if (r3 >= 1024) goto L8;
        r3 = 1024;
    L8:
        init(r2.getOutputStream(), r3, r4);
    }
}
