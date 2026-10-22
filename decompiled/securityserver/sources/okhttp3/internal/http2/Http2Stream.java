package okhttp3.internal.http2;

import a.a;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Http2Stream {
    public static final Companion Companion = null;
    public static final long EMIT_BUFFER_SIZE = 16384;

    @NotNull
    private final Http2Connection connection;

    @Nullable
    private ErrorCode errorCode;

    @Nullable
    private IOException errorException;
    private boolean hasResponseHeaders;
    private final ArrayDeque<Headers> headersQueue;
    private final int id;
    private long readBytesAcknowledged;
    private long readBytesTotal;

    @NotNull
    private final StreamTimeout readTimeout;

    @NotNull
    private final FramingSink sink;

    @NotNull
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;

    @NotNull
    private final StreamTimeout writeTimeout;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public final class FramingSink implements Sink {
        private boolean closed;
        private boolean finished;
        private final Buffer sendBuffer;
        final /* synthetic */ Http2Stream this$0;

        @Nullable
        private Headers trailers;

        public FramingSink(Http2Stream r1, boolean r2) {
            this.this$0 = r1;
            this.finished = r2;
            this.sendBuffer = new Buffer();
        }

        private final void emitFrame(boolean r12) {
            Http2Stream r0 = this.this$0;
            monitor-enter(r0);
            this.this$0.getWriteTimeout$okhttp().enter();     // Catch: Throwable -> L24
        L39:
        L15:
            th = move-exception;
            this.this$0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();     // Catch: Throwable -> L24
            throw th;     // Catch: Throwable -> L24
        L6:
            if (this.this$0.getWriteBytesTotal() < this.this$0.getWriteBytesMaximum()) goto L17;
            if (this.finished == true) goto L17;
            if (this.closed == true) goto L17;
            if (this.this$0.getErrorCode$okhttp() != null) goto L17;
            this.this$0.waitForIo$okhttp();     // Catch: Throwable -> L15
        L17:
            this.this$0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();     // Catch: Throwable -> L24
            this.this$0.checkOutNotClosed$okhttp();     // Catch: Throwable -> L24
            long r9 = Math.min(this.this$0.getWriteBytesMaximum() - this.this$0.getWriteBytesTotal(), this.sendBuffer.size());     // Catch: Throwable -> L24
            Http2Stream r1 = this.this$0;     // Catch: Throwable -> L24
            r1.setWriteBytesTotal$okhttp(r1.getWriteBytesTotal() + r9);     // Catch: Throwable -> L24
            if (r12 == true) goto L21;
        L26:
            boolean r13 = false;
        L23:
            boolean r7 = r13;
            monitor-exit(r0);
            this.this$0.getWriteTimeout$okhttp().enter();
            this.this$0.getConnection().writeData(this.this$0.getId(), r7, this.sendBuffer, r9);     // Catch: Throwable -> L32
            this.this$0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            return;
        L32:
            th = move-exception;
            this.this$0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            throw th;
        L21:
            if (r9 != this.sendBuffer.size()) goto L26;
            r13 = true;
        L24:
            th = move-exception;
            throw th;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Http2Stream r0 = this.this$0;
            if (Util.assertionsEnabled == true) goto L5;
        L9:
            Http2Stream r1 = this.this$0;
            monitor-enter(r1);
        L48:
            th = move-exception;
            throw th;
        L12:
            if (this.closed == false) goto L15;
            monitor-exit(r1);
            return;
        L15:
            if (this.this$0.getErrorCode$okhttp() != null) goto L19;
            boolean r2 = true;
        L20:
            monitor-exit(r1);
            if (this.this$0.getSink$okhttp().finished == false) goto L24;
        L39:
            Http2Stream r3 = this.this$0;
            monitor-enter(r3);
            this.closed = true;     // Catch: Throwable -> L45
            monitor-exit(r3);
            this.this$0.getConnection().flush();
            this.this$0.cancelStreamIfNecessary$okhttp();
            return;
        L45:
            th = move-exception;
            throw th;
        L24:
            if (this.sendBuffer.size() <= 0) goto L26;
            boolean r4 = true;
        L28:
            if (this.trailers != null) goto L30;
            if (r4 == true) goto L35;
            if (r2 == false) goto L39;
            this.this$0.getConnection().writeData(this.this$0.getId(), true, null, 0);
        L35:
            if (this.sendBuffer.size() <= 0) goto L39;
            emitFrame(true);
        L30:
            if (this.sendBuffer.size() <= 0) goto L32;
            emitFrame(false);
            goto L30
        L32:
            Http2Connection r5 = this.this$0.getConnection();
            int r6 = this.this$0.getId();
            Headers r7 = this.trailers;
            Intrinsics.c(r7);
            r5.writeHeaders$okhttp(r6, r2, Util.toHeaderList(r7));
            goto L39
        L26:
            r4 = false;
            goto L28
        L19:
            r2 = false;
            goto L20
        L5:
            if (Thread.holdsLock(r0) == false) goto L9;
            StringBuilder r8 = new StringBuilder("Thread ");
            Thread r9 = Thread.currentThread();
            Intrinsics.e(r9, "Thread.currentThread()");
            r8.append(r9.getName());
            r8.append(" MUST NOT hold lock on ");
            r8.append(r0);
            throw new AssertionError(r8.toString());
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            Http2Stream r0 = this.this$0;
            if (Util.assertionsEnabled == true) goto L5;
        L9:
            Http2Stream r1 = this.this$0;
            monitor-enter(r1);
            this.this$0.checkOutNotClosed$okhttp();     // Catch: Throwable -> L17
            monitor-exit(r1);
        L14:
            if (this.sendBuffer.size() <= 0) goto L16;
            emitFrame(false);
            this.this$0.getConnection().flush();
            goto L14
        L16:
            return;
        L17:
            th = move-exception;
            throw th;
        L5:
            if (Thread.holdsLock(r0) == false) goto L9;
            StringBuilder r2 = new StringBuilder("Thread ");
            Thread r3 = Thread.currentThread();
            Intrinsics.e(r3, "Thread.currentThread()");
            r2.append(r3.getName());
            r2.append(" MUST NOT hold lock on ");
            r2.append(r0);
            throw new AssertionError(r2.toString());
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        @Nullable
        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setClosed(boolean r1) {
            this.closed = r1;
        }

        public final void setFinished(boolean r1) {
            this.finished = r1;
        }

        public final void setTrailers(@Nullable Headers r1) {
            this.trailers = r1;
        }

        @Override // okio.Sink
        @NotNull
        public Timeout timeout() {
            return this.this$0.getWriteTimeout$okhttp();
        }

        @Override // okio.Sink
        public void write(@NotNull Buffer r3, long r4) {
            Intrinsics.f(r3, DBHelper.BATTERY_COL_SOURCE);
            Http2Stream r0 = this.this$0;
            if (Util.assertionsEnabled == true) goto L5;
        L9:
            this.sendBuffer.write(r3, r4);
        L11:
            if (this.sendBuffer.size() < 16384) goto L13;
            emitFrame(false);
            goto L11
        L13:
            return;
        L5:
            if (Thread.holdsLock(r0) == false) goto L9;
            StringBuilder r5 = new StringBuilder("Thread ");
            Thread r6 = Thread.currentThread();
            Intrinsics.e(r6, "Thread.currentThread()");
            r5.append(r6.getName());
            r5.append(" MUST NOT hold lock on ");
            r5.append(r0);
            throw new AssertionError(r5.toString());
        }

        public /* synthetic */ FramingSink(Http2Stream r1, boolean r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L5;
            r2 = false;
        L5:
            this(r1, r2);
        }
    }

    @Metadata
    public final class FramingSource implements Source {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;

        @NotNull
        private final Buffer readBuffer;

        @NotNull
        private final Buffer receiveBuffer;
        final /* synthetic */ Http2Stream this$0;

        @Nullable
        private Headers trailers;

        public FramingSource(Http2Stream r1, long r2, boolean r4) {
            this.this$0 = r1;
            this.maxByteCount = r2;
            this.finished = r4;
            this.receiveBuffer = new Buffer();
            this.readBuffer = new Buffer();
        }

        private final void updateConnectionFlowControl(long r3) {
            Http2Stream r0 = this.this$0;
            if (Util.assertionsEnabled == true) goto L5;
        L9:
            this.this$0.getConnection().updateConnectionFlowControl$okhttp(r3);
            return;
        L5:
            if (Thread.holdsLock(r0) == false) goto L9;
            StringBuilder r4 = new StringBuilder("Thread ");
            Thread r5 = Thread.currentThread();
            Intrinsics.e(r5, "Thread.currentThread()");
            r4.append(r5.getName());
            r4.append(" MUST NOT hold lock on ");
            r4.append(r0);
            throw new AssertionError(r4.toString());
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Http2Stream r0 = this.this$0;
            monitor-enter(r0);
            this.closed = true;     // Catch: Throwable -> L14
            long r1 = this.readBuffer.size();     // Catch: Throwable -> L14
            this.readBuffer.clear();     // Catch: Throwable -> L14
            Http2Stream r3 = this.this$0;     // Catch: Throwable -> L14
            if (r3 == null) goto L17;
            r3.notifyAll();     // Catch: Throwable -> L14
            monitor-exit(r0);
            if (r1 <= 0) goto L12;
            updateConnectionFlowControl(r1);
        L12:
            this.this$0.cancelStreamIfNecessary$okhttp();
            return;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            throw th;
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        @NotNull
        public final Buffer getReadBuffer() {
            return this.readBuffer;
        }

        @NotNull
        public final Buffer getReceiveBuffer() {
            return this.receiveBuffer;
        }

        @Nullable
        public final Headers getTrailers() {
            return this.trailers;
        }

        @Override // okio.Source
        public long read(@NotNull Buffer r18, long r19) {
            Intrinsics.f(r18, "sink");
            long r4 = 0;
            if (r19 < 0) goto L5;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L55;
        L7:
            Http2Stream r7 = this.this$0;
            monitor-enter(r7);
            this.this$0.getReadTimeout$okhttp().enter();     // Catch: Throwable -> L46
        L16:
            th = move-exception;
            this.this$0.getReadTimeout$okhttp().exitAndThrowIfTimedOut();     // Catch: Throwable -> L46
            throw th;     // Catch: Throwable -> L46
        L11:
            if (this.this$0.getErrorCode$okhttp() == null) goto L18;
            IOException r9 = this.this$0.getErrorException$okhttp();     // Catch: Throwable -> L16
            if (r9 != null) goto L20;
            ErrorCode r10 = this.this$0.getErrorCode$okhttp();     // Catch: Throwable -> L16
            Intrinsics.c(r10);     // Catch: Throwable -> L16
            r9 = new StreamResetException(r10);     // Catch: Throwable -> L16
        L20:
            if (this.closed == true) goto L49;
            if (this.readBuffer.size() <= r4) goto L30;
            Buffer r11 = this.readBuffer;     // Catch: Throwable -> L16
            long r13 = r11.read(r18, Math.min(r19, r11.size()));     // Catch: Throwable -> L16
            Http2Stream r12 = this.this$0;     // Catch: Throwable -> L16
            r12.setReadBytesTotal$okhttp(r12.getReadBytesTotal() + r13);     // Catch: Throwable -> L16
            long r5 = this.this$0.getReadBytesTotal() - this.this$0.getReadBytesAcknowledged();     // Catch: Throwable -> L16
            if (r9 == null) goto L26;
        L28:
            boolean r8 = false;
        L35:
            this.this$0.getReadTimeout$okhttp().exitAndThrowIfTimedOut();     // Catch: Throwable -> L46
            monitor-exit(r7);
            if (r8 == false) goto L40;
            r4 = 0;
            goto L7
        L40:
            if (r13 == (-1)) goto L43;
            updateConnectionFlowControl(r13);
            return r13;
        L43:
            if (r9 != null) goto L45;
            return -1;
        L45:
            throw r9;
        L26:
            if (r5 < (this.this$0.getConnection().getOkHttpSettings().getInitialWindowSize() / 2)) goto L28;
            this.this$0.getConnection().writeWindowUpdateLater$okhttp(this.this$0.getId(), r5);     // Catch: Throwable -> L16
            Http2Stream r14 = this.this$0;     // Catch: Throwable -> L16
            r14.setReadBytesAcknowledged$okhttp(r14.getReadBytesTotal());     // Catch: Throwable -> L16
            goto L28
        L30:
            if (this.finished == true) goto L34;
            if (r9 != null) goto L34;
            this.this$0.waitForIo$okhttp();     // Catch: Throwable -> L16
            r13 = -1;
            r8 = true;
        L34:
            r13 = -1;
            goto L28
        L49:
            throw new IOException("stream closed");     // Catch: Throwable -> L16
        L18:
            r9 = null;
        L46:
            th = move-exception;
            throw th;
        L55:
            throw new IllegalArgumentException(a.h("byteCount < 0: ", r19).toString());
        L5:
            r6 = false;
            goto L6
        }

        public final void receive$okhttp(@NotNull BufferedSource r10, long r11) {
            Intrinsics.f(r10, DBHelper.BATTERY_COL_SOURCE);
            Http2Stream r0 = this.this$0;
            if (Util.assertionsEnabled == false) goto L10;
            if (Thread.holdsLock(r0) == false) goto L10;
            StringBuilder r12 = new StringBuilder("Thread ");
            Thread r13 = Thread.currentThread();
            Intrinsics.e(r13, "Thread.currentThread()");
            r12.append(r13.getName());
            r12.append(" MUST NOT hold lock on ");
            r12.append(r0);
            throw new AssertionError(r12.toString());
        L10:
            if (r11 <= 0) goto L56;
            Http2Stream r2 = this.this$0;
            monitor-enter(r2);
            boolean r3 = this.finished;     // Catch: Throwable -> L53
            boolean r5 = false;
            if ((this.readBuffer.size() + r11) <= this.maxByteCount) goto L17;
            boolean r4 = true;
        L18:
            monitor-exit(r2);
            if (r4 == true) goto L20;
            if (r3 == true) goto L23;
            long r6 = r10.read(this.receiveBuffer, r11);
            if (r6 == (-1)) goto L52;
            r11 = r11 - r6;
            Http2Stream r7 = this.this$0;
            monitor-enter(r7);
        L32:
            th = move-exception;
            throw th;
        L30:
            if (this.closed == false) goto L35;
            long r8 = this.receiveBuffer.size();     // Catch: Throwable -> L32
            this.receiveBuffer.clear();     // Catch: Throwable -> L32
        L45:
            monitor-exit(r7);
            if (r8 <= 0) goto L10;
            updateConnectionFlowControl(r8);
            goto L10
        L35:
            if (this.readBuffer.size() != 0) goto L37;
            r5 = true;
        L37:
            this.readBuffer.writeAll(this.receiveBuffer);     // Catch: Throwable -> L32
            if (r5 == false) goto L44;
            Http2Stream r9 = this.this$0;     // Catch: Throwable -> L32
            if (r9 == null) goto L43;
            r9.notifyAll();     // Catch: Throwable -> L32
            goto L44
        L43:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L32
        L44:
            r8 = 0;
            goto L45
        L52:
            throw new EOFException();
        L23:
            r10.skip(r11);
            return;
        L20:
            r10.skip(r11);
            this.this$0.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
            return;
        L17:
            r4 = false;
        L53:
            th = move-exception;
            throw th;
        }

        public final void setClosed$okhttp(boolean r1) {
            this.closed = r1;
        }

        public final void setFinished$okhttp(boolean r1) {
            this.finished = r1;
        }

        public final void setTrailers(@Nullable Headers r1) {
            this.trailers = r1;
        }

        @Override // okio.Source
        @NotNull
        public Timeout timeout() {
            return this.this$0.getReadTimeout$okhttp();
        }
    }

    @Metadata
    public final class StreamTimeout extends AsyncTimeout {
        final /* synthetic */ Http2Stream this$0;

        public StreamTimeout(Http2Stream r1) {
            this.this$0 = r1;
        }

        public final void exitAndThrowIfTimedOut() {
            if (exit() == true) goto L6;
            return;
        L6:
            throw newTimeoutException(null);
        }

        @Override // okio.AsyncTimeout
        @NotNull
        public IOException newTimeoutException(@Nullable IOException r2) {
            SocketTimeoutException r1 = new SocketTimeoutException("timeout");
            if (r2 == null) goto L5;
            r1.initCause(r2);
        L5:
            return r1;
        }

        @Override // okio.AsyncTimeout
        public void timedOut() {
            this.this$0.closeLater(ErrorCode.CANCEL);
            this.this$0.getConnection().sendDegradedPingLater$okhttp();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Http2Stream(int r4, @NotNull Http2Connection r5, boolean r6, boolean r7, @Nullable Headers r8) {
        Intrinsics.f(r5, WsConstants.KEY_CONNECTION);
        this.id = r4;
        this.connection = r5;
        this.writeBytesMaximum = r5.getPeerSettings().getInitialWindowSize();
        ArrayDeque<Headers> r9 = new ArrayDeque();
        this.headersQueue = r9;
        this.source = new FramingSource(this, r5.getOkHttpSettings().getInitialWindowSize(), r7);
        this.sink = new FramingSink(this, r6);
        this.readTimeout = new StreamTimeout(this);
        this.writeTimeout = new StreamTimeout(this);
        if (r8 == null) goto L10;
        if ((!isLocallyInitiated()) == false) goto L8;
        r9.add(r8);
        return;
    L8:
        throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
    L10:
        if (isLocallyInitiated() == false) goto L13;
        return;
    L13:
        throw new IllegalStateException("remotely-initiated streams should have headers".toString());
    }

    private final boolean closeInternal(ErrorCode r3, IOException r4) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L12:
        if (this.errorCode == null) goto L16;
        monitor-exit(this);
        return false;
    L16:
        if (this.source.getFinished$okhttp() == true) goto L18;
    L23:
        this.errorCode = r3;     // Catch: Throwable -> L21
        this.errorException = r4;     // Catch: Throwable -> L21
        notifyAll();     // Catch: Throwable -> L21
        monitor-exit(this);
        this.connection.removeStream$okhttp(this.id);
        return true;
    L18:
        if (this.sink.getFinished() == false) goto L23;
        monitor-exit(this);
        return false;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        StringBuilder r5 = new StringBuilder("Thread ");
        Thread r0 = Thread.currentThread();
        Intrinsics.e(r0, "Thread.currentThread()");
        r5.append(r0.getName());
        r5.append(" MUST NOT hold lock on ");
        r5.append(this);
        throw new AssertionError(r5.toString());
    }

    public final void addBytesToWriteWindow(long r3) {
        this.writeBytesMaximum += r3;
        if (r3 <= 0) goto L6;
        notifyAll();
        return;
    }

    public final void cancelStreamIfNecessary$okhttp() {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L11:
        if (this.source.getFinished$okhttp() == false) goto L13;
    L22:
        boolean r0 = false;
    L23:
        boolean r1 = isOpen();     // Catch: Throwable -> L19
        monitor-exit(this);
        if (r0 == false) goto L27;
        close(ErrorCode.CANCEL, null);
        return;
    L27:
        if (r1 == true) goto L35;
        this.connection.removeStream$okhttp(this.id);
        return;
    L35:
        return;
    L13:
        if (this.source.getClosed$okhttp() == false) goto L22;
        if (this.sink.getFinished() == false) goto L17;
    L21:
        r0 = true;
        goto L23
    L17:
        if (this.sink.getClosed() == false) goto L22;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        StringBuilder r2 = new StringBuilder("Thread ");
        Thread r3 = Thread.currentThread();
        Intrinsics.e(r3, "Thread.currentThread()");
        r2.append(r3.getName());
        r2.append(" MUST NOT hold lock on ");
        r2.append(this);
        throw new AssertionError(r2.toString());
    }

    public final void checkOutNotClosed$okhttp() {
        if (this.sink.getClosed() == true) goto L17;
        if (this.sink.getFinished() == true) goto L15;
        if (this.errorCode == null) goto L13;
        IOException r0 = this.errorException;
        if (r0 != null) goto L18;
        ErrorCode r1 = this.errorCode;
        Intrinsics.c(r1);
        throw new StreamResetException(r1);
    L18:
        throw r0;
    L13:
        return;
    L15:
        throw new IOException("stream finished");
    L17:
        throw new IOException("stream closed");
    }

    public final void close(@NotNull ErrorCode r2, @Nullable IOException r3) {
        Intrinsics.f(r2, "rstStatusCode");
        if (closeInternal(r2, r3) == true) goto L5;
        return;
    L5:
        this.connection.writeSynReset$okhttp(this.id, r2);
    }

    public final void closeLater(@NotNull ErrorCode r2) {
        Intrinsics.f(r2, AccountConst.KEY_ERROR_CODE);
        if (closeInternal(r2, null) == true) goto L5;
        return;
    L5:
        this.connection.writeSynResetLater$okhttp(this.id, r2);
    }

    public final void enqueueTrailers(@NotNull Headers r3) {
        Intrinsics.f(r3, "trailers");
        monitor-enter(this);
        boolean r1 = true;
        if ((!this.sink.getFinished()) == false) goto L19;
        if (r3.size() != 0) goto L10;
        r1 = false;
    L10:
        if (r1 == false) goto L17;
        this.sink.setTrailers(r3);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L17:
        throw new IllegalArgumentException("trailers.size() == 0".toString());     // Catch: Throwable -> L14
    L19:
        throw new IllegalStateException("already finished".toString());     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @NotNull
    public final Http2Connection getConnection() {
        return this.connection;
    }

    @Nullable
    public final synchronized ErrorCode getErrorCode$okhttp() {
        monitor-enter(this);
        ErrorCode r0 = this.errorCode;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final int getId() {
        return this.id;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    @NotNull
    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    @NotNull
    public final Sink getSink() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.hasResponseHeaders == false) goto L6;
    L11:
        boolean r0 = true;
    L12:
        if (r0 == false) goto L17;
        monitor-exit(this);
        return this.sink;
    L17:
        throw new IllegalStateException("reply before requesting the sink".toString());     // Catch: Throwable -> L9
    L6:
        if (isLocallyInitiated() == true) goto L11;
        r0 = false;
        goto L12
    }

    @NotNull
    public final FramingSink getSink$okhttp() {
        return this.sink;
    }

    @NotNull
    public final Source getSource() {
        return this.source;
    }

    @NotNull
    public final FramingSource getSource$okhttp() {
        return this.source;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    @NotNull
    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final boolean isLocallyInitiated() {
        if ((this.id & 1) != 1) goto L5;
        boolean r0 = true;
    L7:
        if (this.connection.getClient$okhttp() != r0) goto L10;
        return true;
    L10:
        return false;
    L5:
        r0 = false;
        goto L7
    }

    public final synchronized boolean isOpen() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.errorCode == null) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (this.source.getFinished$okhttp() == true) goto L16;
        if (this.source.getClosed$okhttp() == true) goto L16;
    L23:
        monitor-exit(this);
        return true;
    L16:
        if (this.sink.getFinished() == false) goto L18;
    L19:
        if (this.hasResponseHeaders == false) goto L23;
        monitor-exit(this);
        return false;
    L18:
        if (this.sink.getClosed() == false) goto L23;
        goto L19
    }

    @NotNull
    public final Timeout readTimeout() {
        return this.readTimeout;
    }

    public final void receiveData(@NotNull BufferedSource r3, int r4) {
        Intrinsics.f(r3, DBHelper.BATTERY_COL_SOURCE);
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        this.source.receive$okhttp(r3, r4);
        return;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        StringBuilder r5 = new StringBuilder("Thread ");
        Thread r0 = Thread.currentThread();
        Intrinsics.e(r0, "Thread.currentThread()");
        r5.append(r0.getName());
        r5.append(" MUST NOT hold lock on ");
        r5.append(this);
        throw new AssertionError(r5.toString());
    }

    public final void receiveHeaders(@NotNull Headers r3, boolean r4) {
        Intrinsics.f(r3, "headers");
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (this.hasResponseHeaders == false) goto L17;
        if (r4 == false) goto L17;
        this.source.setTrailers(r3);     // Catch: Throwable -> L15
    L18:
        if (r4 == false) goto L20;
        this.source.setFinished$okhttp(true);     // Catch: Throwable -> L15
    L20:
        boolean r5 = isOpen();     // Catch: Throwable -> L15
        notifyAll();     // Catch: Throwable -> L15
        monitor-exit(this);
        if (r5 == true) goto L29;
        this.connection.removeStream$okhttp(this.id);
        return;
    L29:
        return;
    L17:
        this.hasResponseHeaders = true;     // Catch: Throwable -> L15
        this.headersQueue.add(r3);     // Catch: Throwable -> L15
        goto L18
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        StringBuilder r6 = new StringBuilder("Thread ");
        Thread r0 = Thread.currentThread();
        Intrinsics.e(r0, "Thread.currentThread()");
        r6.append(r0.getName());
        r6.append(" MUST NOT hold lock on ");
        r6.append(this);
        throw new AssertionError(r6.toString());
    }

    public final synchronized void receiveRstStream(@NotNull ErrorCode r2) {
        monitor-enter(this);
        Intrinsics.f(r2, AccountConst.KEY_ERROR_CODE);     // Catch: Throwable -> L7
        if (this.errorCode != null) goto L9;
        this.errorCode = r2;     // Catch: Throwable -> L7
        notifyAll();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void setErrorCode$okhttp(@Nullable ErrorCode r1) {
        this.errorCode = r1;
    }

    public final void setErrorException$okhttp(@Nullable IOException r1) {
        this.errorException = r1;
    }

    public final void setReadBytesAcknowledged$okhttp(long r1) {
        this.readBytesAcknowledged = r1;
    }

    public final void setReadBytesTotal$okhttp(long r1) {
        this.readBytesTotal = r1;
    }

    public final void setWriteBytesMaximum$okhttp(long r1) {
        this.writeBytesMaximum = r1;
    }

    public final void setWriteBytesTotal$okhttp(long r1) {
        this.writeBytesTotal = r1;
    }

    @NotNull
    public final synchronized Headers takeHeaders() {
        monitor-enter(this);
        this.readTimeout.enter();     // Catch: Throwable -> L17
    L28:
    L10:
        th = move-exception;
        this.readTimeout.exitAndThrowIfTimedOut();     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L5:
        if (this.headersQueue.isEmpty() == false) goto L12;
        if (this.errorCode != null) goto L12;
        waitForIo$okhttp();     // Catch: Throwable -> L10
    L12:
        this.readTimeout.exitAndThrowIfTimedOut();     // Catch: Throwable -> L17
        if ((!this.headersQueue.isEmpty()) == false) goto L19;
        Headers r0 = this.headersQueue.removeFirst();     // Catch: Throwable -> L17
        Intrinsics.e(r0, "headersQueue.removeFirst()");     // Catch: Throwable -> L17
        Headers r1 = r0;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r1;
    L19:
        IOException r2 = this.errorException;     // Catch: Throwable -> L17
        if (r2 != null) goto L34;
        ErrorCode r3 = this.errorCode;     // Catch: Throwable -> L17
        Intrinsics.c(r3);     // Catch: Throwable -> L17
        throw new StreamResetException(r3);     // Catch: Throwable -> L17
    L34:
        throw r2;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @NotNull
    public final synchronized Headers trailers() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.source.getFinished$okhttp() == false) goto L18;
        if (this.source.getReceiveBuffer().exhausted() == false) goto L18;
        if (this.source.getReadBuffer().exhausted() == false) goto L18;
        Headers r0 = this.source.getTrailers();     // Catch: Throwable -> L15
        if (r0 != null) goto L13;
        r0 = Util.EMPTY_HEADERS;     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return r0;
    L18:
        if (this.errorCode == null) goto L25;
        IOException r1 = this.errorException;     // Catch: Throwable -> L15
        if (r1 != null) goto L29;
        ErrorCode r2 = this.errorCode;     // Catch: Throwable -> L15
        Intrinsics.c(r2);     // Catch: Throwable -> L15
        throw new StreamResetException(r2);     // Catch: Throwable -> L15
    L29:
        throw r1;     // Catch: Throwable -> L15
    L25:
        throw new IllegalStateException("too early; can't read the trailers yet");     // Catch: Throwable -> L15
    }

    public final void waitForIo$okhttp() {
        wait();     // Catch: InterruptedException -> L4
        return;
    L4:
        Thread.currentThread().interrupt();
        throw new InterruptedIOException();
    }

    public final void writeHeaders(@NotNull List<Header> r6, boolean r7, boolean r8) {
        Intrinsics.f(r6, "responseHeaders");
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        monitor-enter(this);
        boolean r0 = true;
        this.hasResponseHeaders = true;     // Catch: Throwable -> L15
        if (r7 == false) goto L17;
        this.sink.setFinished(true);     // Catch: Throwable -> L15
    L17:
        monitor-exit(this);
        if (r8 == true) goto L31;
        Http2Connection r9 = this.connection;
        monitor-enter(r9);
        if (this.connection.getWriteBytesTotal() >= this.connection.getWriteBytesMaximum()) goto L26;
        r0 = false;
    L26:
        monitor-exit(r9);
        r8 = r0;
    L28:
        th = move-exception;
        throw th;
    L31:
        this.connection.writeHeaders$okhttp(this.id, r7, r6);
        if (r8 == false) goto L41;
        this.connection.flush();
        return;
    L41:
        return;
    L15:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        StringBuilder r10 = new StringBuilder("Thread ");
        Thread r11 = Thread.currentThread();
        Intrinsics.e(r11, "Thread.currentThread()");
        r10.append(r11.getName());
        r10.append(" MUST NOT hold lock on ");
        r10.append(this);
        throw new AssertionError(r10.toString());
    }

    @NotNull
    public final Timeout writeTimeout() {
        return this.writeTimeout;
    }
}
