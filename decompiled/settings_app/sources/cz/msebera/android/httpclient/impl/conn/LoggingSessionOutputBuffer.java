package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class LoggingSessionOutputBuffer implements SessionOutputBuffer {
    private final String charset;
    private final SessionOutputBuffer out;
    private final Wire wire;

    public LoggingSessionOutputBuffer(SessionOutputBuffer r1, Wire r2, String r3) {
        this.out = r1;
        this.wire = r2;
        if (r3 != null) goto L6;
        r3 = Consts.ASCII.name();
    L6:
        this.charset = r3;
    }

    public LoggingSessionOutputBuffer(SessionOutputBuffer r2, Wire r3) {
        this(r2, r3, null);
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void write(byte[] r2, int r3, int r4) throws IOException {
        this.out.write(r2, r3, r4);
        if (this.wire.enabled() == false) goto L6;
        this.wire.output(r2, r3, r4);
        return;
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void write(int r2) throws IOException {
        this.out.write(r2);
        if (this.wire.enabled() == false) goto L6;
        this.wire.output(r2);
        return;
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void write(byte[] r2) throws IOException {
        this.out.write(r2);
        if (this.wire.enabled() == false) goto L6;
        this.wire.output(r2);
        return;
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void writeLine(CharArrayBuffer r4) throws IOException {
        this.out.writeLine(r4);
        if (this.wire.enabled() == false) goto L6;
        String r5 = new String(r4.buffer(), 0, r4.length()).concat("\r\n");
        this.wire.output(r5.getBytes(this.charset));
        return;
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void writeLine(String r2) throws IOException {
        this.out.writeLine(r2);
        if (this.wire.enabled() == false) goto L6;
        this.wire.output((r2 + "\r\n").getBytes(this.charset));
        return;
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.out.getMetrics();
    }
}
