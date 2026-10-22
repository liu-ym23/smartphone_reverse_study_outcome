package okhttp3.internal.http2;

import a.a;
import androidx.appcompat.widget.ActivityChooserView;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Http2Writer implements Closeable {
    public static final Companion Companion = null;
    private static final Logger logger = null;
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;

    @NotNull
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        logger = Logger.getLogger(Http2.class.getName());
    }

    public Http2Writer(@NotNull BufferedSink r8, boolean r9) {
        Intrinsics.f(r8, "sink");
        this.sink = r8;
        this.client = r9;
        Buffer r4 = new Buffer();
        this.hpackBuffer = r4;
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(0, false, r4, 3, null);
    }

    private final void writeContinuationFrames(int r6, long r7) {
    L3:
        if (r7 <= 0) goto L9;
        long r2 = Math.min(this.maxFrameSize, r7);
        r7 = r7 - r2;
        int r4 = (int) r2;
        if (r7 != 0) goto L7;
        int r0 = 4;
    L8:
        frameHeader(r6, r4, 9, r0);
        this.sink.write(this.hpackBuffer, r2);
        goto L3
    L7:
        r0 = 0;
        goto L8
    }

    public final synchronized void applyAndAckSettings(@NotNull Settings r3) {
        monitor-enter(this);
        Intrinsics.f(r3, "peerSettings");     // Catch: Throwable -> L8
        if (this.closed == true) goto L14;
        this.maxFrameSize = r3.getMaxFrameSize(this.maxFrameSize);     // Catch: Throwable -> L8
        if (r3.getHeaderTableSize() == (-1)) goto L10;
        this.hpackWriter.resizeHeaderTable(r3.getHeaderTableSize());     // Catch: Throwable -> L8
    L10:
        frameHeader(0, 0, 4, 1);     // Catch: Throwable -> L8
        this.sink.flush();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L14:
        throw new IOException("closed");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
        this.closed = true;     // Catch: Throwable -> L7
        this.sink.close();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void connectionPreface() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.closed == true) goto L19;
        if (this.client == true) goto L10;
        monitor-exit(this);
        return;
    L10:
        Logger r1 = logger;     // Catch: Throwable -> L13
        if (r1.isLoggable(Level.FINE) == false) goto L15;
        r1.fine(Util.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));     // Catch: Throwable -> L13
    L15:
        this.sink.write(Http2.CONNECTION_PREFACE);     // Catch: Throwable -> L13
        this.sink.flush();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L19:
        throw new IOException("closed");     // Catch: Throwable -> L13
    }

    public final synchronized void data(boolean r2, int r3, @Nullable Buffer r4, int r5) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L11;
        dataFrame(r3, r2 ? 1 : 0, r4, r5);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IOException("closed");     // Catch: Throwable -> L8
    }

    public final void dataFrame(int r2, int r3, @Nullable Buffer r4, int r5) {
        frameHeader(r2, r5, 0, r3);
        if (r5 <= 0) goto L6;
        BufferedSink r1 = this.sink;
        Intrinsics.c(r4);
        r1.write(r4, r5);
        return;
    }

    public final synchronized void flush() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L11;
        this.sink.flush();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IOException("closed");     // Catch: Throwable -> L8
    }

    public final void frameHeader(int r9, int r10, int r11, int r12) {
        Logger r0 = logger;
        if (r0.isLoggable(Level.FINE) == false) goto L5;
        r0.fine(Http2.INSTANCE.frameLog(false, r9, r10, r11, r12));
    L5:
        boolean r1 = false;
        if (r10 > this.maxFrameSize) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L19;
        if ((((int) 2147483648L) & r9) != 0) goto L13;
        r1 = true;
    L13:
        if (r1 == false) goto L17;
        Util.writeMedium(this.sink, r10);
        this.sink.writeByte(r11 & 255);
        this.sink.writeByte(r12 & 255);
        this.sink.writeInt(r9 & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        return;
    L17:
        throw new IllegalArgumentException(a.e(r9, "reserved bit set: ").toString());
    L19:
        throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + r10).toString());
    L8:
        r2 = false;
        goto L9
    }

    @NotNull
    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int r5, @NotNull ErrorCode r6, @NotNull byte[] r7) {
        monitor-enter(this);
        Intrinsics.f(r6, AccountConst.KEY_ERROR_CODE);     // Catch: Throwable -> L16
        Intrinsics.f(r7, "debugData");     // Catch: Throwable -> L16
        if (this.closed == true) goto L24;
        boolean r3 = false;
        if (r6.getHttpCode() == (-1)) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L22;
        frameHeader(0, r7.length + 8, 7, 0);     // Catch: Throwable -> L16
        this.sink.writeInt(r5);     // Catch: Throwable -> L16
        this.sink.writeInt(r6.getHttpCode());     // Catch: Throwable -> L16
        if (r7.length != 0) goto L14;
        r3 = true;
    L14:
        if ((!r3) == false) goto L18;
        this.sink.write(r7);     // Catch: Throwable -> L16
    L18:
        this.sink.flush();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L22:
        throw new IllegalArgumentException("errorCode.httpCode == -1".toString());     // Catch: Throwable -> L16
    L8:
        r0 = false;
        goto L9
    L24:
        throw new IOException("closed");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized void headers(boolean r7, int r8, @NotNull List<Header> r9) {
        monitor-enter(this);
        Intrinsics.f(r9, "headerBlock");     // Catch: Throwable -> L15
        if (this.closed == true) goto L20;
        this.hpackWriter.writeHeaders(r9);     // Catch: Throwable -> L15
        long r0 = this.hpackBuffer.size();     // Catch: Throwable -> L15
        long r2 = Math.min(this.maxFrameSize, r0);     // Catch: Throwable -> L15
        if (r0 != r2) goto L8;
        int r4 = 4;
    L9:
        if (r7 == false) goto L11;
        r4 = r4 | 1;     // Catch: Throwable -> L15
    L11:
        frameHeader(r8, (int) r2, 1, r4);     // Catch: Throwable -> L15
        this.sink.write(this.hpackBuffer, r2);     // Catch: Throwable -> L15
        if (r0 <= r2) goto L17;
        writeContinuationFrames(r8, r0 - r2);     // Catch: Throwable -> L15
    L17:
        monitor-exit(this);
        return;
    L8:
        r4 = 0;
        goto L9
    L20:
        throw new IOException("closed");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void ping(boolean r4, int r5, int r6) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L11;
        frameHeader(0, 8, 6, r4 ? 1 : 0);     // Catch: Throwable -> L8
        this.sink.writeInt(r5);     // Catch: Throwable -> L8
        this.sink.writeInt(r6);     // Catch: Throwable -> L8
        this.sink.flush();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IOException("closed");     // Catch: Throwable -> L8
    }

    public final synchronized void pushPromise(int r8, int r9, @NotNull List<Header> r10) {
        monitor-enter(this);
        Intrinsics.f(r10, "requestHeaders");     // Catch: Throwable -> L13
        if (this.closed == true) goto L18;
        this.hpackWriter.writeHeaders(r10);     // Catch: Throwable -> L13
        long r0 = this.hpackBuffer.size();     // Catch: Throwable -> L13
        int r11 = (int) Math.min(((long) this.maxFrameSize) - 4, r0);     // Catch: Throwable -> L13
        int r2 = r11 + 4;     // Catch: Throwable -> L13
        long r3 = r11;
        if (r0 != r3) goto L8;
        int r5 = 4;
    L9:
        frameHeader(r8, r2, 5, r5);     // Catch: Throwable -> L13
        this.sink.writeInt(r9 & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);     // Catch: Throwable -> L13
        this.sink.write(this.hpackBuffer, r3);     // Catch: Throwable -> L13
        if (r0 <= r3) goto L15;
        writeContinuationFrames(r8, r0 - r3);     // Catch: Throwable -> L13
    L15:
        monitor-exit(this);
        return;
    L8:
        r5 = 0;
        goto L9
    L18:
        throw new IOException("closed");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void rstStream(int r4, @NotNull ErrorCode r5) {
        monitor-enter(this);
        Intrinsics.f(r5, AccountConst.KEY_ERROR_CODE);     // Catch: Throwable -> L13
        if (this.closed == true) goto L18;
        if (r5.getHttpCode() == (-1)) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L16;
        frameHeader(r4, 4, 3, 0);     // Catch: Throwable -> L13
        this.sink.writeInt(r5.getHttpCode());     // Catch: Throwable -> L13
        this.sink.flush();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L16:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L13
    L8:
        r0 = false;
        goto L9
    L18:
        throw new IOException("closed");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void settings(@NotNull Settings r5) {
        monitor-enter(this);
        Intrinsics.f(r5, "settings");     // Catch: Throwable -> L19
        if (this.closed == true) goto L25;
        int r2 = 0;
        frameHeader(0, r5.size() * 6, 4, 0);     // Catch: Throwable -> L19
    L7:
        if (r2 >= 10) goto L21;
        if (r5.isSet(r2) == false) goto L18;
        if (r2 != 4) goto L13;
        int r0 = 3;
    L17:
        this.sink.writeShort(r0);     // Catch: Throwable -> L19
        this.sink.writeInt(r5.get(r2));     // Catch: Throwable -> L19
        goto L18
    L13:
        if (r2 == 7) goto L15;
        r0 = r2;
        goto L17
    L15:
        r0 = 4;
    L18:
        r2 = r2 + 1;     // Catch: Throwable -> L19
        goto L7
    L21:
        this.sink.flush();     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L25:
        throw new IOException("closed");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized void windowUpdate(int r6, long r7) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.closed == true) goto L21;
        if (r7 != 0) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L19;
        frameHeader(r6, 4, 8, 0);     // Catch: Throwable -> L16
        this.sink.writeInt((int) r7);     // Catch: Throwable -> L16
        this.sink.flush();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L19:
        throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + r7).toString());     // Catch: Throwable -> L16
    L9:
        if (r7 > 2147483647L) goto L11;
        r1 = true;
        goto L12
    L21:
        throw new IOException("closed");     // Catch: Throwable -> L16
    }
}
