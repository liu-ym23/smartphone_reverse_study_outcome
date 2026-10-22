package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes5.dex */
final class Http2Writer implements Closeable {
    private static final Logger logger = null;
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    static {
        logger = Logger.getLogger(Http2.class.getName());
    }

    Http2Writer(BufferedSink r1, boolean r2) {
        this.sink = r1;
        this.client = r2;
        Buffer r3 = new Buffer();
        this.hpackBuffer = r3;
        this.hpackWriter = new Hpack.Writer(r3);
        this.maxFrameSize = 16384;
    }

    public synchronized void connectionPreface() throws IOException {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L16;
        if (this.client == true) goto L9;
        monitor-exit(this);
        return;
    L9:
        Logger r0 = logger;     // Catch: Throwable -> L17
        if (r0.isLoggable(Level.FINE) == false) goto L12;
        r0.fine(Util.format(">> CONNECTION %s", new Object[]{Http2.CONNECTION_PREFACE.hex()}));     // Catch: Throwable -> L17
    L12:
        this.sink.write(Http2.CONNECTION_PREFACE.toByteArray());     // Catch: Throwable -> L17
        this.sink.flush();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L16:
        throw new IOException("closed");     // Catch: Throwable -> L17
    }

    public synchronized void applyAndAckSettings(Settings r3) throws IOException {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L12;
        this.maxFrameSize = r3.getMaxFrameSize(this.maxFrameSize);     // Catch: Throwable -> L13
        if (r3.getHeaderTableSize() == (-1)) goto L8;
        this.hpackWriter.setHeaderTableSizeSetting(r3.getHeaderTableSize());     // Catch: Throwable -> L13
    L8:
        frameHeader(0, 0, (byte) 4, (byte) 1);     // Catch: Throwable -> L13
        this.sink.flush();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L12:
        throw new IOException("closed");     // Catch: Throwable -> L13
    }

    public synchronized void pushPromise(int r8, int r9, List<Header> r10) throws IOException {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L15;
        this.hpackWriter.writeHeaders(r10);     // Catch: Throwable -> L16
        long r0 = this.hpackBuffer.size();     // Catch: Throwable -> L16
        int r11 = (int) Math.min(this.maxFrameSize - 4, r0);     // Catch: Throwable -> L16
        long r3 = r11;
        if (r0 != r3) goto L8;
        byte r6 = 4;
    L9:
        frameHeader(r8, r11 + 4, (byte) 5, r6);     // Catch: Throwable -> L16
        this.sink.writeInt(r9 & Integer.MAX_VALUE);     // Catch: Throwable -> L16
        this.sink.write(this.hpackBuffer, r3);     // Catch: Throwable -> L16
        if (r0 <= r3) goto L12;
        writeContinuationFrames(r8, r0 - r3);     // Catch: Throwable -> L16
    L12:
        monitor-exit(this);
        return;
    L8:
        r6 = 0;
        goto L9
    L15:
        throw new IOException("closed");     // Catch: Throwable -> L16
    }

    public synchronized void flush() throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L9;
        this.sink.flush();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IOException("closed");     // Catch: Throwable -> L10
    }

    public synchronized void synStream(boolean r1, int r2, int r3, List<Header> r4) throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L9;
        headers(r1, r2, r4);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IOException("closed");     // Catch: Throwable -> L10
    }

    public synchronized void synReply(boolean r2, int r3, List<Header> r4) throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L9;
        headers(r2, r3, r4);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IOException("closed");     // Catch: Throwable -> L10
    }

    public synchronized void headers(int r2, List<Header> r3) throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L9;
        headers(false, r2, r3);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IOException("closed");     // Catch: Throwable -> L10
    }

    public synchronized void rstStream(int r4, ErrorCode r5) throws IOException {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L13;
        if (r5.httpCode == (-1)) goto L11;
        frameHeader(r4, 4, (byte) 3, (byte) 0);     // Catch: Throwable -> L14
        this.sink.writeInt(r5.httpCode);     // Catch: Throwable -> L14
        this.sink.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L11:
        throw new IllegalArgumentException();     // Catch: Throwable -> L14
    L13:
        throw new IOException("closed");     // Catch: Throwable -> L14
    }

    public int maxDataLength() {
        return this.maxFrameSize;
    }

    public synchronized void data(boolean r2, int r3, Buffer r4, int r5) throws IOException {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L12;
        if (r2 == false) goto L7;
        byte r6 = (byte) 1;     // Catch: Throwable -> L13
    L8:
        dataFrame(r3, r6, r4, r5);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L7:
        r6 = 0;
        goto L8
    L12:
        throw new IOException("closed");     // Catch: Throwable -> L13
    }

    void dataFrame(int r2, byte r3, Buffer r4, int r5) throws IOException {
        frameHeader(r2, r5, (byte) 0, r3);
        if (r5 <= 0) goto L6;
        this.sink.write(r4, r5);
        return;
    }

    public synchronized void settings(Settings r5) throws IOException {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L23;
        int r1 = 0;
        frameHeader(0, r5.size() * 6, (byte) 4, (byte) 0);     // Catch: Throwable -> L24
    L7:
        if (r1 >= 10) goto L19;
        if (r5.isSet(r1) == false) goto L18;
        if (r1 != 4) goto L14;
        int r0 = 3;
    L17:
        this.sink.writeShort(r0);     // Catch: Throwable -> L24
        this.sink.writeInt(r5.get(r1));     // Catch: Throwable -> L24
        goto L18
    L14:
        if (r1 != 7) goto L16;
        r0 = 4;
        goto L17
    L16:
        r0 = r1;
    L18:
        r1 = r1 + 1;     // Catch: Throwable -> L24
        goto L7
    L19:
        this.sink.flush();     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L23:
        throw new IOException("closed");     // Catch: Throwable -> L24
    }

    public synchronized void ping(boolean r4, int r5, int r6) throws IOException {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L13;
        if (r4 == false) goto L8;
        byte r7 = 1;
    L9:
        frameHeader(0, 8, (byte) 6, r7);     // Catch: Throwable -> L14
        this.sink.writeInt(r5);     // Catch: Throwable -> L14
        this.sink.writeInt(r6);     // Catch: Throwable -> L14
        this.sink.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L8:
        r7 = 0;
        goto L9
    L13:
        throw new IOException("closed");     // Catch: Throwable -> L14
    }

    public synchronized void goAway(int r4, ErrorCode r5, byte[] r6) throws IOException {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L16;
        if (r5.httpCode == (-1)) goto L14;
        frameHeader(0, r6.length + 8, (byte) 7, (byte) 0);     // Catch: Throwable -> L17
        this.sink.writeInt(r4);     // Catch: Throwable -> L17
        this.sink.writeInt(r5.httpCode);     // Catch: Throwable -> L17
        if (r6.length <= 0) goto L10;
        this.sink.write(r6);     // Catch: Throwable -> L17
    L10:
        this.sink.flush();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L14:
        throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);     // Catch: Throwable -> L17
    L16:
        throw new IOException("closed");     // Catch: Throwable -> L17
    }

    public synchronized void windowUpdate(int r5, long r6) throws IOException {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L15;
        if (r6 == 0) goto L13;
        if (r6 > 2147483647L) goto L13;
        frameHeader(r5, 4, (byte) 8, (byte) 0);     // Catch: Throwable -> L16
        this.sink.writeInt((int) r6);     // Catch: Throwable -> L16
        this.sink.flush();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L13:
        throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[]{Long.valueOf(r6)});     // Catch: Throwable -> L16
    L15:
        throw new IOException("closed");     // Catch: Throwable -> L16
    }

    public void frameHeader(int r4, int r5, byte r6, byte r7) throws IOException {
        Logger r0 = logger;
        if (r0.isLoggable(Level.FINE) == false) goto L5;
        r0.fine(Http2.frameLog(false, r4, r5, r6, r7));
    L5:
        int r1 = this.maxFrameSize;
        if (r5 > r1) goto L14;
        if ((Integer.MIN_VALUE & r4) != 0) goto L12;
        writeMedium(this.sink, r5);
        this.sink.writeByte(r6 & UByte.MAX_VALUE);
        this.sink.writeByte(r7 & UByte.MAX_VALUE);
        this.sink.writeInt(r4 & Integer.MAX_VALUE);
        return;
    L12:
        throw Http2.illegalArgument("reserved bit set: %s", new Object[]{Integer.valueOf(r4)});
    L14:
        throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", new Object[]{Integer.valueOf(r1), Integer.valueOf(r5)});
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
        this.closed = true;     // Catch: Throwable -> L7
        this.sink.close();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void writeMedium(BufferedSink r1, int r2) throws IOException {
        r1.writeByte((r2 >>> 16) & 255);
        r1.writeByte((r2 >>> 8) & 255);
        r1.writeByte(r2 & 255);
    }

    private void writeContinuationFrames(int r6, long r7) throws IOException {
    L3:
        if (r7 <= 0) goto L9;
        int r2 = (int) Math.min(this.maxFrameSize, r7);
        long r3 = r2;
        r7 = r7 - r3;
        if (r7 != 0) goto L7;
        byte r0 = 4;
    L8:
        frameHeader(r6, r2, (byte) 9, r0);
        this.sink.write(this.hpackBuffer, r3);
        goto L3
    L7:
        r0 = 0;
        goto L8
    }

    void headers(boolean r7, int r8, List<Header> r9) throws IOException {
        if (this.closed == true) goto L15;
        this.hpackWriter.writeHeaders(r9);
        long r0 = this.hpackBuffer.size();
        int r10 = (int) Math.min(this.maxFrameSize, r0);
        long r2 = r10;
        if (r0 != r2) goto L7;
        byte r5 = 4;
    L8:
        if (r7 == false) goto L10;
        r5 = (byte) (r5 | 1);
    L10:
        frameHeader(r8, r10, (byte) 1, r5);
        this.sink.write(this.hpackBuffer, r2);
        if (r0 <= r2) goto L16;
        writeContinuationFrames(r8, r0 - r2);
        return;
    L16:
        return;
    L7:
        r5 = 0;
        goto L8
    L15:
        throw new IOException("closed");
    }
}
