package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.io.EofSensor;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class LoggingSessionInputBuffer implements SessionInputBuffer, EofSensor {
    private final String charset;
    private final EofSensor eofSensor;
    private final SessionInputBuffer in;
    private final Wire wire;

    public LoggingSessionInputBuffer(SessionInputBuffer r2, Wire r3, String r4) {
        this.in = r2;
        if ((r2 instanceof EofSensor) == false) goto L5;
        EofSensor r5 = (EofSensor) r2;
    L6:
        this.eofSensor = r5;
        this.wire = r3;
        if (r4 != null) goto L10;
        r4 = Consts.ASCII.name();
    L10:
        this.charset = r4;
        return;
    L5:
        r5 = null;
        goto L6
    }

    public LoggingSessionInputBuffer(SessionInputBuffer r2, Wire r3) {
        this(r2, r3, null);
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public boolean isDataAvailable(int r1) throws IOException {
        return this.in.isDataAvailable(r1);
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public int read(byte[] r2, int r3, int r4) throws IOException {
        int r5 = this.in.read(r2, r3, r4);
        if (this.wire.enabled() == false) goto L6;
        if (r5 <= 0) goto L6;
        this.wire.input(r2, r3, r5);
    L6:
        return r5;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public int read() throws IOException {
        int r0 = this.in.read();
        if (this.wire.enabled() == true) goto L5;
    L7:
        return r0;
    L5:
        if (r0 == (-1)) goto L7;
        this.wire.input(r0);
        goto L7
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public int read(byte[] r3) throws IOException {
        int r0 = this.in.read(r3);
        if (this.wire.enabled() == false) goto L6;
        if (r0 <= 0) goto L6;
        this.wire.input(r3, 0, r0);
    L6:
        return r0;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public String readLine() throws IOException {
        String r0 = this.in.readLine();
        if (this.wire.enabled() == false) goto L6;
        if (r0 == null) goto L6;
        this.wire.input((r0 + "\r\n").getBytes(this.charset));
    L6:
        return r0;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public int readLine(CharArrayBuffer r4) throws IOException {
        int r0 = this.in.readLine(r4);
        if (this.wire.enabled() == false) goto L6;
        if (r0 < 0) goto L6;
        int r1 = r4.length() - r0;
        String r5 = new String(r4.buffer(), r1, r0).concat("\r\n");
        this.wire.input(r5.getBytes(this.charset));
    L6:
        return r0;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.in.getMetrics();
    }

    @Override // cz.msebera.android.httpclient.io.EofSensor
    public boolean isEof() {
        EofSensor r0 = this.eofSensor;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isEof();
    }
}
