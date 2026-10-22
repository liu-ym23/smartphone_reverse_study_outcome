package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.io.EofSensor;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.Socket;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class SocketInputBuffer extends AbstractSessionInputBuffer implements EofSensor {
    private boolean eof;
    private final Socket socket;

    public SocketInputBuffer(Socket r2, int r3, HttpParams r4) throws IOException {
        Args.notNull(r2, "Socket");
        this.socket = r2;
        this.eof = false;
        if (r3 >= 0) goto L6;
        r3 = r2.getReceiveBufferSize();
    L6:
        if (r3 >= 1024) goto L8;
        r3 = 1024;
    L8:
        init(r2.getInputStream(), r3, r4);
    }

    @Override // cz.msebera.android.httpclient.impl.io.AbstractSessionInputBuffer
    protected int fillBuffer() throws IOException {
        int r0 = super.fillBuffer();
        if (r0 != (-1)) goto L5;
        boolean r1 = true;
    L6:
        this.eof = r1;
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public boolean isDataAvailable(int r3) throws IOException {
        boolean r0 = hasBufferedData();
        if (r0 == true) goto L10;
        int r1 = this.socket.getSoTimeout();
        this.socket.setSoTimeout(r3);     // Catch: Throwable -> L7
        fillBuffer();     // Catch: Throwable -> L7
        boolean r4 = hasBufferedData();     // Catch: Throwable -> L7
        this.socket.setSoTimeout(r1);
        return r4;
    L7:
        th = move-exception;
        this.socket.setSoTimeout(r1);
        throw th;
    L10:
        return r0;
    }

    @Override // cz.msebera.android.httpclient.io.EofSensor
    public boolean isEof() {
        return this.eof;
    }
}
