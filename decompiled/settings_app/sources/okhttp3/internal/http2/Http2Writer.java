package okhttp3.internal.http2;

import com.android.launcher3.icons.cache.BaseIconCache;
import com.android.settings.deviceinfo.DeviceInfoProvider;
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

/* JADX INFO: compiled from: Http2Writer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 :2\u00020\u0001:\u0001:B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0006\u0010\u0015\u001a\u00020\u0011J(\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u000fJ(\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u000fJ\u0006\u0010\u001e\u001a\u00020\u0011J&\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fJ\u001e\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J$\u0010(\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*J\u0006\u0010,\u001a\u00020\u000fJ\u001e\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000fJ$\u00101\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u000f2\f\u00103\u001a\b\u0012\u0004\u0012\u00020+0*J\u0016\u00104\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%J\u000e\u00105\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u0013J\u0016\u00106\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u00107\u001a\u000208J\u0018\u00109\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u000208H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lokhttp3/internal/http2/Http2Writer;", "Ljava/io/Closeable;", "sink", "Lokio/BufferedSink;", DeviceInfoProvider.CLIENT, "", "(Lokio/BufferedSink;Z)V", "closed", "hpackBuffer", "Lokio/Buffer;", "hpackWriter", "Lokhttp3/internal/http2/Hpack$Writer;", "getHpackWriter", "()Lokhttp3/internal/http2/Hpack$Writer;", "maxFrameSize", "", "applyAndAckSettings", "", "peerSettings", "Lokhttp3/internal/http2/Settings;", "close", "connectionPreface", "data", "outFinished", "streamId", "source", "byteCount", "dataFrame", BaseIconCache.IconDB.COLUMN_FLAGS, "buffer", "flush", "frameHeader", "length", "type", "goAway", "lastGoodStreamId", AccountConst.KEY_ERROR_CODE, "Lokhttp3/internal/http2/ErrorCode;", "debugData", "", "headers", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "maxDataLength", "ping", "ack", "payload1", "payload2", "pushPromise", "promisedStreamId", "requestHeaders", "rstStream", "settings", "windowUpdate", "windowSizeIncrement", "", "writeContinuationFrames", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Http2Writer implements Closeable {
    public static final Companion Companion = null;
    private static final Logger logger = null;
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    /* JADX INFO: compiled from: Http2Writer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lokhttp3/internal/http2/Http2Writer$Companion;", "", "()V", "logger", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public Http2Writer(BufferedSink r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "sink");
        this.sink = r8;
        this.client = r9;
        Buffer r4 = new Buffer();
        this.hpackBuffer = r4;
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(0, false, r4, 3, null);
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void connectionPreface() throws IOException {
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
        r0.fine(Util.format(Intrinsics.stringPlus(">> CONNECTION ", Http2.CONNECTION_PREFACE.hex()), new Object[0]));     // Catch: Throwable -> L17
    L12:
        this.sink.write(Http2.CONNECTION_PREFACE);     // Catch: Throwable -> L17
        this.sink.flush();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L16:
        throw new IOException("closed");     // Catch: Throwable -> L17
    }

    public final synchronized void applyAndAckSettings(Settings r3) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "peerSettings");     // Catch: Throwable -> L13
        if (this.closed == true) goto L12;
        this.maxFrameSize = r3.getMaxFrameSize(this.maxFrameSize);     // Catch: Throwable -> L13
        if (r3.getHeaderTableSize() == (-1)) goto L8;
        this.hpackWriter.resizeHeaderTable(r3.getHeaderTableSize());     // Catch: Throwable -> L13
    L8:
        frameHeader(0, 0, 4, 1);     // Catch: Throwable -> L13
        this.sink.flush();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L12:
        throw new IOException("closed");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void pushPromise(int r8, int r9, List<Header> r10) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "requestHeaders");     // Catch: Throwable -> L16
        if (this.closed == true) goto L15;
        this.hpackWriter.writeHeaders(r10);     // Catch: Throwable -> L16
        long r0 = this.hpackBuffer.size();     // Catch: Throwable -> L16
        int r11 = (int) Math.min(((long) this.maxFrameSize) - 4, r0);     // Catch: Throwable -> L16
        int r2 = r11 + 4;     // Catch: Throwable -> L16
        long r3 = r11;
        if (r0 != r3) goto L8;
        int r5 = 4;
    L9:
        frameHeader(r8, r2, 5, r5);     // Catch: Throwable -> L16
        this.sink.writeInt(r9 & Integer.MAX_VALUE);     // Catch: Throwable -> L16
        this.sink.write(this.hpackBuffer, r3);     // Catch: Throwable -> L16
        if (r0 <= r3) goto L12;
        writeContinuationFrames(r8, r0 - r3);     // Catch: Throwable -> L16
    L12:
        monitor-exit(this);
        return;
    L8:
        r5 = 0;
        goto L9
    L15:
        throw new IOException("closed");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized void flush() throws IOException {
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

    public final synchronized void rstStream(int r4, ErrorCode r5) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, AccountConst.KEY_ERROR_CODE);     // Catch: Throwable -> L17
        if (this.closed == true) goto L16;
        if (r5.getHttpCode() == (-1)) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L14;
        frameHeader(r4, 4, 3, 0);     // Catch: Throwable -> L17
        this.sink.writeInt(r5.getHttpCode());     // Catch: Throwable -> L17
        this.sink.flush();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L14:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L17
    L8:
        r0 = false;
        goto L9
    L16:
        throw new IOException("closed");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void data(boolean r2, int r3, Buffer r4, int r5) throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L9;
        dataFrame(r3, r2 ? 1 : 0, r4, r5);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IOException("closed");     // Catch: Throwable -> L10
    }

    public final void dataFrame(int r2, int r3, Buffer r4, int r5) throws IOException {
        frameHeader(r2, r5, 0, r3);
        if (r5 <= 0) goto L6;
        BufferedSink r1 = this.sink;
        Intrinsics.checkNotNull(r4);
        r1.write(r4, r5);
        return;
    }

    public final synchronized void settings(Settings r6) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "settings");     // Catch: Throwable -> L24
        if (this.closed == true) goto L23;
        int r2 = 0;
        frameHeader(0, r6.size() * 6, 4, 0);     // Catch: Throwable -> L24
    L7:
        if (r2 >= 10) goto L19;
        int r0 = r2 + 1;     // Catch: Throwable -> L24
        if (r6.isSet(r2) == false) goto L18;
        if (r2 != 4) goto L13;
        int r3 = 3;
    L17:
        this.sink.writeShort(r3);     // Catch: Throwable -> L24
        this.sink.writeInt(r6.get(r2));     // Catch: Throwable -> L24
        goto L18
    L13:
        if (r2 == 7) goto L15;
        r3 = r2;
        goto L17
    L15:
        r3 = 4;
    L18:
        r2 = r0;
        goto L7
    L19:
        this.sink.flush();     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L23:
        throw new IOException("closed");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public final synchronized void ping(boolean r4, int r5, int r6) throws IOException {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L13;
        if (r4 == false) goto L8;
        int r7 = 1;
    L9:
        frameHeader(0, 8, 6, r7);     // Catch: Throwable -> L14
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

    public final synchronized void goAway(int r5, ErrorCode r6, byte[] r7) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, AccountConst.KEY_ERROR_CODE);     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r7, "debugData");     // Catch: Throwable -> L23
        if (this.closed == true) goto L22;
        boolean r3 = false;
        if (r6.getHttpCode() == (-1)) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L20;
        frameHeader(0, r7.length + 8, 7, 0);     // Catch: Throwable -> L23
        this.sink.writeInt(r5);     // Catch: Throwable -> L23
        this.sink.writeInt(r6.getHttpCode());     // Catch: Throwable -> L23
        if (r7.length != 0) goto L14;
        r3 = true;
    L14:
        if ((!r3) == false) goto L16;
        this.sink.write(r7);     // Catch: Throwable -> L23
    L16:
        this.sink.flush();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L20:
        throw new IllegalArgumentException("errorCode.httpCode == -1".toString());     // Catch: Throwable -> L23
    L8:
        r0 = false;
        goto L9
    L22:
        throw new IOException("closed");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public final synchronized void windowUpdate(int r5, long r6) throws IOException {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L18;
        if (r6 != 0) goto L8;
    L10:
        boolean r0 = false;
    L11:
        if (r0 == false) goto L16;
        frameHeader(r5, 4, 8, 0);     // Catch: Throwable -> L19
        this.sink.writeInt((int) r6);     // Catch: Throwable -> L19
        this.sink.flush();     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L16:
        throw new IllegalArgumentException(Intrinsics.stringPlus("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: ", Long.valueOf(r6)).toString());     // Catch: Throwable -> L19
    L8:
        if (r6 > 2147483647L) goto L10;
        r0 = true;
        goto L11
    L18:
        throw new IOException("closed");     // Catch: Throwable -> L19
    }

    public final void frameHeader(int r9, int r10, int r11, int r12) throws IOException {
        Logger r0 = logger;
        if (r0.isLoggable(Level.FINE) == false) goto L5;
        r0.fine(Http2.INSTANCE.frameLog(false, r9, r10, r11, r12));
    L5:
        boolean r1 = true;
        if (r10 > this.maxFrameSize) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L20;
        if ((Integer.MIN_VALUE & r9) == 0) goto L14;
        r1 = false;
    L14:
        if (r1 == false) goto L18;
        Util.writeMedium(this.sink, r10);
        this.sink.writeByte(r11 & 255);
        this.sink.writeByte(r12 & 255);
        this.sink.writeInt(r9 & Integer.MAX_VALUE);
        return;
    L18:
        throw new IllegalArgumentException(Intrinsics.stringPlus("reserved bit set: ", Integer.valueOf(r9)).toString());
    L20:
        throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + r10).toString());
    L8:
        r2 = false;
        goto L9
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

    private final void writeContinuationFrames(int r6, long r7) throws IOException {
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

    public final synchronized void headers(boolean r7, int r8, List<Header> r9) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r9, "headerBlock");     // Catch: Throwable -> L18
        if (this.closed == true) goto L17;
        this.hpackWriter.writeHeaders(r9);     // Catch: Throwable -> L18
        long r0 = this.hpackBuffer.size();     // Catch: Throwable -> L18
        long r2 = Math.min(this.maxFrameSize, r0);     // Catch: Throwable -> L18
        if (r0 != r2) goto L8;
        int r4 = 4;
    L9:
        if (r7 == false) goto L11;
        r4 = r4 | 1;     // Catch: Throwable -> L18
    L11:
        frameHeader(r8, (int) r2, 1, r4);     // Catch: Throwable -> L18
        this.sink.write(this.hpackBuffer, r2);     // Catch: Throwable -> L18
        if (r0 <= r2) goto L14;
        writeContinuationFrames(r8, r0 - r2);     // Catch: Throwable -> L18
    L14:
        monitor-exit(this);
        return;
    L8:
        r4 = 0;
        goto L9
    L17:
        throw new IOException("closed");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    static {
        Companion = new Companion(null);
        logger = Logger.getLogger(Http2.class.getName());
    }
}
