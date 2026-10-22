package okhttp3.internal.http2;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
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

/* JADX INFO: compiled from: Http2Stream.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 _2\u00020\u0001:\u0004_`abB1\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020#J\r\u0010C\u001a\u00020AH\u0000¢\u0006\u0002\bDJ\r\u0010E\u001a\u00020AH\u0000¢\u0006\u0002\bFJ\u0018\u0010G\u001a\u00020A2\u0006\u0010H\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u001a\u0010I\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u000e\u0010J\u001a\u00020A2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010K\u001a\u00020A2\u0006\u0010L\u001a\u00020\nJ\u0006\u0010M\u001a\u00020NJ\u0006\u0010O\u001a\u00020PJ\u0006\u0010,\u001a\u00020QJ\u0016\u0010R\u001a\u00020A2\u0006\u00104\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010U\u001a\u00020A2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010V\u001a\u00020A2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010W\u001a\u00020\nJ\u0006\u0010L\u001a\u00020\nJ\r\u0010X\u001a\u00020AH\u0000¢\u0006\u0002\bYJ$\u0010Z\u001a\u00020A2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010^\u001a\u00020\u0007J\u0006\u0010>\u001a\u00020QR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b!\u0010 R$\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u0018\u0010,\u001a\u00060-R\u00020\u0000X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u00100\u001a\u000601R\u00020\u0000X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0018\u00104\u001a\u000605R\u00020\u0000X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R$\u00108\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010&\"\u0004\b:\u0010(R$\u0010;\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010&\"\u0004\b=\u0010(R\u0018\u0010>\u001a\u00060-R\u00020\u0000X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010/¨\u0006c"}, d2 = {"Lokhttp3/internal/http2/Http2Stream;", "", "id", "", WsConstants.KEY_CONNECTION, "Lokhttp3/internal/http2/Http2Connection;", "outFinished", "", "inFinished", "headers", "Lokhttp3/Headers;", "(ILokhttp3/internal/http2/Http2Connection;ZZLokhttp3/Headers;)V", "getConnection", "()Lokhttp3/internal/http2/Http2Connection;", AccountConst.KEY_ERROR_CODE, "Lokhttp3/internal/http2/ErrorCode;", "getErrorCode$okhttp", "()Lokhttp3/internal/http2/ErrorCode;", "setErrorCode$okhttp", "(Lokhttp3/internal/http2/ErrorCode;)V", "errorException", "Ljava/io/IOException;", "getErrorException$okhttp", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "hasResponseHeaders", "headersQueue", "Ljava/util/ArrayDeque;", "getId", "()I", "isLocallyInitiated", "()Z", "isOpen", "<set-?>", "", "readBytesAcknowledged", "getReadBytesAcknowledged", "()J", "setReadBytesAcknowledged$okhttp", "(J)V", "readBytesTotal", "getReadBytesTotal", "setReadBytesTotal$okhttp", "readTimeout", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "getReadTimeout$okhttp", "()Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "sink", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "getSink$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSink;", "source", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "getSource$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSource;", "writeBytesMaximum", "getWriteBytesMaximum", "setWriteBytesMaximum$okhttp", "writeBytesTotal", "getWriteBytesTotal", "setWriteBytesTotal$okhttp", "writeTimeout", "getWriteTimeout$okhttp", "addBytesToWriteWindow", "", "delta", "cancelStreamIfNecessary", "cancelStreamIfNecessary$okhttp", "checkOutNotClosed", "checkOutNotClosed$okhttp", "close", "rstStatusCode", "closeInternal", "closeLater", "enqueueTrailers", "trailers", "getSink", "Lokio/Sink;", "getSource", "Lokio/Source;", "Lokio/Timeout;", "receiveData", "Lokio/BufferedSource;", "length", "receiveHeaders", "receiveRstStream", "takeHeaders", "waitForIo", "waitForIo$okhttp", "writeHeaders", "responseHeaders", "", "Lokhttp3/internal/http2/Header;", "flushHeaders", "Companion", "FramingSink", "FramingSource", "StreamTimeout", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Http2Stream {
    public static final Companion Companion = null;
    public static final long EMIT_BUFFER_SIZE = 16384;
    private final Http2Connection connection;
    private ErrorCode errorCode;
    private IOException errorException;
    private boolean hasResponseHeaders;
    private final ArrayDeque<Headers> headersQueue;
    private final int id;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final StreamTimeout readTimeout;
    private final FramingSink sink;
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final StreamTimeout writeTimeout;

    /* JADX INFO: compiled from: Http2Stream.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$Companion;", "", "()V", "EMIT_BUFFER_SIZE", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: Http2Stream.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSink;", "Lokio/Sink;", "finished", "", "(Lokhttp3/internal/http2/Http2Stream;Z)V", "closed", "getClosed", "()Z", "setClosed", "(Z)V", "getFinished", "setFinished", "sendBuffer", "Lokio/Buffer;", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "close", "", "emitFrame", "outFinishedOnLastFrame", "flush", "timeout", "Lokio/Timeout;", "write", "source", "byteCount", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class FramingSink implements Sink {
        private boolean closed;
        private boolean finished;
        private final Buffer sendBuffer;
        final /* synthetic */ Http2Stream this$0;
        private Headers trailers;

        public FramingSink(Http2Stream r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.this$0 = r2;
            this.finished = r3;
            this.sendBuffer = new Buffer();
        }

        public /* synthetic */ FramingSink(Http2Stream r1, boolean r2, int r3, DefaultConstructorMarker r4) {
            this.this$0 = r1;
            if ((r3 & 1) == 0) goto L5;
            r2 = false;
        L5:
            this(r1, r2);
        }

        public final boolean getFinished() {
            return this.finished;
        }

        public final void setFinished(boolean r1) {
            this.finished = r1;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setTrailers(Headers r1) {
            this.trailers = r1;
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final void setClosed(boolean r1) {
            this.closed = r1;
        }

        @Override // okio.Sink
        public void write(Buffer r3, long r4) throws IOException {
            Intrinsics.checkNotNullParameter(r3, "source");
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
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r0);
        }

        private final void emitFrame(boolean r12) throws IOException {
            Http2Stream r0 = this.this$0;
            monitor-enter(r0);
            r0.getWriteTimeout$okhttp().enter();     // Catch: Throwable -> L33
        L36:
        L30:
            th = move-exception;
            r0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();     // Catch: Throwable -> L33
            throw th;     // Catch: Throwable -> L33
        L6:
            if (r0.getWriteBytesTotal() < r0.getWriteBytesMaximum()) goto L15;
            if (getFinished() == true) goto L15;
            if (getClosed() == true) goto L15;
            if (r0.getErrorCode$okhttp() != null) goto L15;
            r0.waitForIo$okhttp();     // Catch: Throwable -> L30
        L15:
            r0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();     // Catch: Throwable -> L33
            r0.checkOutNotClosed$okhttp();     // Catch: Throwable -> L33
            long r9 = Math.min(r0.getWriteBytesMaximum() - r0.getWriteBytesTotal(), this.sendBuffer.size());     // Catch: Throwable -> L33
            r0.setWriteBytesTotal$okhttp(r0.getWriteBytesTotal() + r9);     // Catch: Throwable -> L33
            if (r12 == true) goto L18;
        L20:
            boolean r13 = false;
        L21:
            boolean r7 = r13;
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L33
            monitor-exit(r0);
            this.this$0.getWriteTimeout$okhttp().enter();
            this.this$0.getConnection().writeData(this.this$0.getId(), r7, this.sendBuffer, r9);     // Catch: Throwable -> L27
            this.this$0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            return;
        L27:
            th = move-exception;
            this.this$0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            throw th;
        L18:
            if (r9 != this.sendBuffer.size()) goto L20;
            r13 = true;
        L33:
            th = move-exception;
            throw th;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Http2Stream r0 = this.this$0;
            if (Util.assertionsEnabled == true) goto L5;
        L9:
            Http2Stream r1 = this.this$0;
            monitor-enter(r1);
            r1.checkOutNotClosed$okhttp();     // Catch: Throwable -> L17
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L17
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
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r0);
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.this$0.getWriteTimeout$okhttp();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Http2Stream r0 = this.this$0;
            if (Util.assertionsEnabled == true) goto L5;
        L9:
            Http2Stream r1 = this.this$0;
            monitor-enter(r1);
        L51:
            th = move-exception;
            throw th;
        L12:
            if (getClosed() == false) goto L16;
            monitor-exit(r1);
            return;
        L16:
            if (r1.getErrorCode$okhttp() != null) goto L18;
            boolean r2 = true;
        L19:
            Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L51
            monitor-exit(r1);
            if (this.this$0.getSink$okhttp().finished == false) goto L24;
        L42:
            Http2Stream r3 = this.this$0;
            monitor-enter(r3);
            setClosed(true);     // Catch: Throwable -> L48
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L48
            monitor-exit(r3);
            this.this$0.getConnection().flush();
            this.this$0.cancelStreamIfNecessary$okhttp();
            return;
        L48:
            th = move-exception;
            throw th;
        L24:
            if (this.sendBuffer.size() <= 0) goto L26;
            boolean r6 = true;
        L28:
            if (this.trailers == null) goto L30;
            boolean r7 = true;
        L31:
            if (r7 == true) goto L33;
            if (r6 == true) goto L38;
            if (r2 == false) goto L42;
            this.this$0.getConnection().writeData(this.this$0.getId(), true, null, 0);
        L38:
            if (this.sendBuffer.size() <= 0) goto L42;
            emitFrame(true);
        L33:
            if (this.sendBuffer.size() <= 0) goto L35;
            emitFrame(false);
            goto L33
        L35:
            Http2Connection r8 = this.this$0.getConnection();
            int r9 = this.this$0.getId();
            Headers r10 = this.trailers;
            Intrinsics.checkNotNull(r10);
            r8.writeHeaders$okhttp(r9, r2, Util.toHeaderList(r10));
            goto L42
        L30:
            r7 = false;
            goto L31
        L26:
            r6 = false;
            goto L28
        L18:
            r2 = false;
            goto L19
        L5:
            if (Thread.holdsLock(r0) == false) goto L9;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r0);
        }
    }

    /* JADX INFO: compiled from: Http2Stream.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u001d\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\"J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002R\u001a\u0010\u0007\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokio/Source;", "maxByteCount", "", "finished", "", "(Lokhttp3/internal/http2/Http2Stream;JZ)V", "closed", "getClosed$okhttp", "()Z", "setClosed$okhttp", "(Z)V", "getFinished$okhttp", "setFinished$okhttp", "readBuffer", "Lokio/Buffer;", "getReadBuffer", "()Lokio/Buffer;", "receiveBuffer", "getReceiveBuffer", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "close", "", "read", "sink", "byteCount", "receive", "source", "Lokio/BufferedSource;", "receive$okhttp", "timeout", "Lokio/Timeout;", "updateConnectionFlowControl", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class FramingSource implements Source {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private final Buffer readBuffer;
        private final Buffer receiveBuffer;
        final /* synthetic */ Http2Stream this$0;
        private Headers trailers;

        public FramingSource(Http2Stream r2, long r3, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.this$0 = r2;
            this.maxByteCount = r3;
            this.finished = r5;
            this.receiveBuffer = new Buffer();
            this.readBuffer = new Buffer();
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        public final void setFinished$okhttp(boolean r1) {
            this.finished = r1;
        }

        public final Buffer getReceiveBuffer() {
            return this.receiveBuffer;
        }

        public final Buffer getReadBuffer() {
            return this.readBuffer;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setTrailers(Headers r1) {
            this.trailers = r1;
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final void setClosed$okhttp(boolean r1) {
            this.closed = r1;
        }

        @Override // okio.Source
        public long read(Buffer r18, long r19) throws IOException {
            Intrinsics.checkNotNullParameter(r18, "sink");
            long r4 = 0;
            if (r19 < 0) goto L5;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L55;
        L7:
            Http2Stream r7 = this.this$0;
            monitor-enter(r7);
            r7.getReadTimeout$okhttp().enter();     // Catch: Throwable -> L51
        L48:
            th = move-exception;
            r7.getReadTimeout$okhttp().exitAndThrowIfTimedOut();     // Catch: Throwable -> L51
            throw th;     // Catch: Throwable -> L51
        L11:
            if (r7.getErrorCode$okhttp() != null) goto L13;
        L17:
            StreamResetException r9 = null;
        L19:
            if (getClosed$okhttp() == true) goto L47;
            if (getReadBuffer().size() <= r4) goto L28;
            long r13 = getReadBuffer().read(r18, Math.min(r19, getReadBuffer().size()));     // Catch: Throwable -> L48
            r7.setReadBytesTotal$okhttp(r7.getReadBytesTotal() + r13);     // Catch: Throwable -> L48
            long r5 = r7.getReadBytesTotal() - r7.getReadBytesAcknowledged();     // Catch: Throwable -> L48
            if (r9 == null) goto L25;
        L33:
            boolean r8 = false;
        L34:
            r7.getReadTimeout$okhttp().exitAndThrowIfTimedOut();     // Catch: Throwable -> L51
            Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L51
            monitor-exit(r7);
            if (r8 == false) goto L39;
            r4 = 0;
            goto L7
        L39:
            if (r13 == (-1)) goto L42;
            updateConnectionFlowControl(r13);
            return r13;
        L42:
            if (r9 != null) goto L45;
            return -1;
        L45:
            throw r9;
        L25:
            if (r5 < (r7.getConnection().getOkHttpSettings().getInitialWindowSize() / 2)) goto L33;
            r7.getConnection().writeWindowUpdateLater$okhttp(r7.getId(), r5);     // Catch: Throwable -> L48
            r7.setReadBytesAcknowledged$okhttp(r7.getReadBytesTotal());     // Catch: Throwable -> L48
            goto L33
        L28:
            if (getFinished$okhttp() == true) goto L32;
            if (r9 != null) goto L32;
            r7.waitForIo$okhttp();     // Catch: Throwable -> L48
            r13 = -1;
            r8 = true;
        L32:
            r13 = -1;
            goto L33
        L47:
            throw new IOException("stream closed");     // Catch: Throwable -> L48
        L13:
            if (getFinished$okhttp() == true) goto L17;
            r9 = r7.getErrorException$okhttp();     // Catch: Throwable -> L48
            if (r9 != null) goto L19;
            ErrorCode r11 = r7.getErrorCode$okhttp();     // Catch: Throwable -> L48
            Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L48
            r9 = new StreamResetException(r11);     // Catch: Throwable -> L48
        L51:
            th = move-exception;
            throw th;
        L55:
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(r19)).toString());
        L5:
            r6 = false;
            goto L6
        }

        private final void updateConnectionFlowControl(long r3) {
            Http2Stream r0 = this.this$0;
            if (Util.assertionsEnabled == true) goto L5;
        L9:
            this.this$0.getConnection().updateConnectionFlowControl$okhttp(r3);
            return;
        L5:
            if (Thread.holdsLock(r0) == false) goto L9;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r0);
        }

        public final void receive$okhttp(BufferedSource r10, long r11) throws IOException {
            Intrinsics.checkNotNullParameter(r10, "source");
            Http2Stream r0 = this.this$0;
            if (Util.assertionsEnabled == false) goto L10;
            if (Thread.holdsLock(r0) == false) goto L10;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r0);
        L10:
            if (r11 <= 0) goto L53;
            Http2Stream r2 = this.this$0;
            monitor-enter(r2);
            boolean r3 = getFinished$okhttp();     // Catch: Throwable -> L50
            boolean r5 = true;
            if ((getReadBuffer().size() + r11) <= this.maxByteCount) goto L16;
            boolean r4 = true;
        L17:
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L50
            monitor-exit(r2);
            if (r4 == true) goto L20;
            if (r3 == true) goto L23;
            long r6 = r10.read(this.receiveBuffer, r11);
            if (r6 == (-1)) goto L49;
            r11 = r11 - r6;
            Http2Stream r8 = this.this$0;
            monitor-enter(r8);
            if (getClosed$okhttp() == false) goto L33;
            long r9 = getReceiveBuffer().size();     // Catch: Throwable -> L45
            getReceiveBuffer().clear();     // Catch: Throwable -> L45
        L40:
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L45
            monitor-exit(r8);
            if (r9 <= 0) goto L10;
            updateConnectionFlowControl(r9);
            goto L10
        L33:
            if (getReadBuffer().size() == 0) goto L36;
            r5 = false;
        L36:
            getReadBuffer().writeAll(getReceiveBuffer());     // Catch: Throwable -> L45
            if (r5 == false) goto L39;
            r8.notifyAll();     // Catch: Throwable -> L45
        L39:
            r9 = 0;
        L45:
            th = move-exception;
            throw th;
        L49:
            throw new EOFException();
        L23:
            r10.skip(r11);
            return;
        L20:
            r10.skip(r11);
            this.this$0.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
            return;
        L16:
            r4 = false;
        L50:
            th = move-exception;
            throw th;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.this$0.getReadTimeout$okhttp();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Http2Stream r0 = this.this$0;
            monitor-enter(r0);
            setClosed$okhttp(true);     // Catch: Throwable -> L12
            long r1 = getReadBuffer().size();     // Catch: Throwable -> L12
            getReadBuffer().clear();     // Catch: Throwable -> L12
            r0.notifyAll();     // Catch: Throwable -> L12
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(r0);
            if (r1 <= 0) goto L10;
            updateConnectionFlowControl(r1);
        L10:
            this.this$0.cancelStreamIfNecessary$okhttp();
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: Http2Stream.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014¨\u0006\t"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Lokio/AsyncTimeout;", "(Lokhttp3/internal/http2/Http2Stream;)V", "exitAndThrowIfTimedOut", "", "newTimeoutException", "Ljava/io/IOException;", "cause", "timedOut", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class StreamTimeout extends AsyncTimeout {
        final /* synthetic */ Http2Stream this$0;

        public StreamTimeout(Http2Stream r2) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.this$0 = r2;
        }

        @Override // okio.AsyncTimeout
        protected void timedOut() {
            this.this$0.closeLater(ErrorCode.CANCEL);
            this.this$0.getConnection().sendDegradedPingLater$okhttp();
        }

        @Override // okio.AsyncTimeout
        protected IOException newTimeoutException(IOException r2) {
            SocketTimeoutException r1 = new SocketTimeoutException("timeout");
            if (r2 == null) goto L6;
            r1.initCause(r2);
        L6:
            return r1;
        }

        public final void exitAndThrowIfTimedOut() throws IOException {
            if (exit() == true) goto L6;
            return;
        L6:
            throw newTimeoutException(null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Http2Stream(int r4, Http2Connection r5, boolean r6, boolean r7, Headers r8) {
        Intrinsics.checkNotNullParameter(r5, WsConstants.KEY_CONNECTION);
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

    public final int getId() {
        return this.id;
    }

    public final Http2Connection getConnection() {
        return this.connection;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final void setReadBytesTotal$okhttp(long r1) {
        this.readBytesTotal = r1;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final void setReadBytesAcknowledged$okhttp(long r1) {
        this.readBytesAcknowledged = r1;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final void setWriteBytesTotal$okhttp(long r1) {
        this.writeBytesTotal = r1;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final void setWriteBytesMaximum$okhttp(long r1) {
        this.writeBytesMaximum = r1;
    }

    public final FramingSource getSource$okhttp() {
        return this.source;
    }

    public final FramingSink getSink$okhttp() {
        return this.sink;
    }

    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final synchronized ErrorCode getErrorCode$okhttp() {
        monitor-enter(this);
        ErrorCode r0 = this.errorCode;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final void setErrorCode$okhttp(ErrorCode r1) {
        this.errorCode = r1;
    }

    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final void setErrorException$okhttp(IOException r1) {
        this.errorException = r1;
    }

    public final synchronized boolean isOpen() {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (this.errorCode == null) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (this.source.getFinished$okhttp() == true) goto L13;
        if (this.source.getClosed$okhttp() == true) goto L13;
    L20:
        monitor-exit(this);
        return true;
    L13:
        if (this.sink.getFinished() == false) goto L15;
    L16:
        if (this.hasResponseHeaders == false) goto L20;
        monitor-exit(this);
        return false;
    L15:
        if (this.sink.getClosed() == false) goto L20;
        goto L16
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

    public final synchronized Headers takeHeaders() throws IOException {
        monitor-enter(this);
        this.readTimeout.enter();     // Catch: Throwable -> L23
    L26:
    L20:
        th = move-exception;
        this.readTimeout.exitAndThrowIfTimedOut();     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L5:
        if (this.headersQueue.isEmpty() == false) goto L10;
        if (this.errorCode != null) goto L10;
        waitForIo$okhttp();     // Catch: Throwable -> L20
    L10:
        this.readTimeout.exitAndThrowIfTimedOut();     // Catch: Throwable -> L23
        if ((!this.headersQueue.isEmpty()) == false) goto L15;
        Headers r0 = this.headersQueue.removeFirst();     // Catch: Throwable -> L23
        Intrinsics.checkNotNullExpressionValue(r0, "headersQueue.removeFirst()");     // Catch: Throwable -> L23
        Headers r1 = r0;     // Catch: Throwable -> L23
        monitor-exit(this);
        return r1;
    L15:
        Throwable r2 = this.errorException;     // Catch: Throwable -> L23
        if (r2 != null) goto L19;
        ErrorCode r3 = this.errorCode;     // Catch: Throwable -> L23
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L23
        r2 = new StreamResetException(r3);     // Catch: Throwable -> L23
    L19:
        throw r2;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public final synchronized Headers trailers() throws IOException {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.source.getFinished$okhttp() == false) goto L15;
        if (this.source.getReceiveBuffer().exhausted() == false) goto L15;
        if (this.source.getReadBuffer().exhausted() == false) goto L15;
        Headers r0 = this.source.getTrailers();     // Catch: Throwable -> L23
        if (r0 != null) goto L12;
        r0 = Util.EMPTY_HEADERS;     // Catch: Throwable -> L23
    L12:
        monitor-exit(this);
        return r0;
    L15:
        if (this.errorCode == null) goto L22;
        Throwable r1 = this.errorException;     // Catch: Throwable -> L23
        if (r1 != null) goto L20;
        ErrorCode r2 = this.errorCode;     // Catch: Throwable -> L23
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L23
        r1 = new StreamResetException(r2);     // Catch: Throwable -> L23
    L20:
        throw r1;     // Catch: Throwable -> L23
    L22:
        throw new IllegalStateException("too early; can't read the trailers yet");     // Catch: Throwable -> L23
    }

    public final void enqueueTrailers(Headers r3) {
        Intrinsics.checkNotNullParameter(r3, "trailers");
        monitor-enter(this);
        boolean r1 = true;
        if ((!getSink$okhttp().getFinished()) == false) goto L17;
        if (r3.size() != 0) goto L10;
        r1 = false;
    L10:
        if (r1 == false) goto L15;
        getSink$okhttp().setTrailers(r3);     // Catch: Throwable -> L18
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L15:
        throw new IllegalArgumentException("trailers.size() == 0".toString());     // Catch: Throwable -> L18
    L17:
        throw new IllegalStateException("already finished".toString());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public final Timeout readTimeout() {
        return this.readTimeout;
    }

    public final Timeout writeTimeout() {
        return this.writeTimeout;
    }

    public final Source getSource() {
        return this.source;
    }

    public final Sink getSink() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.hasResponseHeaders == false) goto L6;
    L9:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L16;
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        return this.sink;
    L16:
        throw new IllegalStateException("reply before requesting the sink".toString());     // Catch: Throwable -> L17
    L6:
        if (isLocallyInitiated() == true) goto L9;
        r0 = false;
        goto L10
    }

    public final void close(ErrorCode r2, IOException r3) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "rstStatusCode");
        if (closeInternal(r2, r3) == true) goto L5;
        return;
    L5:
        this.connection.writeSynReset$okhttp(this.id, r2);
    }

    public final void closeLater(ErrorCode r2) {
        Intrinsics.checkNotNullParameter(r2, AccountConst.KEY_ERROR_CODE);
        if (closeInternal(r2, null) == true) goto L5;
        return;
    L5:
        this.connection.writeSynResetLater$okhttp(this.id, r2);
    }

    public final synchronized void receiveRstStream(ErrorCode r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, AccountConst.KEY_ERROR_CODE);     // Catch: Throwable -> L8
        if (this.errorCode != null) goto L6;
        this.errorCode = r2;     // Catch: Throwable -> L8
        notifyAll();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void addBytesToWriteWindow(long r3) {
        this.writeBytesMaximum += r3;
        if (r3 <= 0) goto L6;
        notifyAll();
        return;
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        if (this.sink.getClosed() == true) goto L17;
        if (this.sink.getFinished() == true) goto L15;
        if (this.errorCode == null) goto L13;
        Throwable r0 = this.errorException;
        if (r0 != null) goto L12;
        ErrorCode r1 = this.errorCode;
        Intrinsics.checkNotNull(r1);
        r0 = new StreamResetException(r1);
    L12:
        throw r0;
    L13:
        return;
    L15:
        throw new IOException("stream finished");
    L17:
        throw new IOException("stream closed");
    }

    public final void writeHeaders(List<Header> r6, boolean r7, boolean r8) throws IOException {
        Intrinsics.checkNotNullParameter(r6, "responseHeaders");
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        monitor-enter(this);
        boolean r0 = true;
        this.hasResponseHeaders = true;     // Catch: Throwable -> L33
        if (r7 == false) goto L14;
        getSink$okhttp().setFinished(true);     // Catch: Throwable -> L33
    L14:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(this);
        if (r8 == true) goto L29;
        Http2Connection r9 = this.connection;
        monitor-enter(r9);
    L26:
        th = move-exception;
        throw th;
    L20:
        if (getConnection().getWriteBytesTotal() >= getConnection().getWriteBytesMaximum()) goto L23;
        r0 = false;
    L23:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r9);
        r8 = r0;
    L29:
        this.connection.writeHeaders$okhttp(this.id, r7, r6);
        if (r8 == false) goto L40;
        this.connection.flush();
        return;
    L40:
        return;
    L33:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    private final boolean closeInternal(ErrorCode r3, IOException r4) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L12:
        if (getErrorCode$okhttp() == null) goto L16;
        monitor-exit(this);
        return false;
    L16:
        if (getSource$okhttp().getFinished$okhttp() == true) goto L18;
    L21:
        setErrorCode$okhttp(r3);     // Catch: Throwable -> L25
        setErrorException$okhttp(r4);     // Catch: Throwable -> L25
        notifyAll();     // Catch: Throwable -> L25
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(this);
        this.connection.removeStream$okhttp(this.id);
        return true;
    L18:
        if (getSink$okhttp().getFinished() == false) goto L21;
        monitor-exit(this);
        return false;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void receiveData(BufferedSource r3, int r4) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "source");
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        this.source.receive$okhttp(r3, r4);
        return;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void receiveHeaders(Headers r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "headers");
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L11:
        if (this.hasResponseHeaders == false) goto L15;
        if (r4 == false) goto L15;
        getSource$okhttp().setTrailers(r3);     // Catch: Throwable -> L23
    L16:
        if (r4 == false) goto L18;
        getSource$okhttp().setFinished$okhttp(true);     // Catch: Throwable -> L23
    L18:
        boolean r5 = isOpen();     // Catch: Throwable -> L23
        notifyAll();     // Catch: Throwable -> L23
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(this);
        if (r5 == true) goto L28;
        this.connection.removeStream$okhttp(this.id);
        return;
    L28:
        return;
    L15:
        this.hasResponseHeaders = true;     // Catch: Throwable -> L23
        this.headersQueue.add(r3);     // Catch: Throwable -> L23
        goto L16
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void cancelStreamIfNecessary$okhttp() throws IOException {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L11:
        if (getSource$okhttp().getFinished$okhttp() == false) goto L13;
    L19:
        boolean r0 = false;
    L20:
        boolean r1 = isOpen();     // Catch: Throwable -> L27
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(this);
        if (r0 == false) goto L24;
        close(ErrorCode.CANCEL, null);
        return;
    L24:
        if (r1 == true) goto L33;
        this.connection.removeStream$okhttp(this.id);
        return;
    L33:
        return;
    L13:
        if (getSource$okhttp().getClosed$okhttp() == false) goto L19;
        if (getSink$okhttp().getFinished() == false) goto L17;
    L18:
        r0 = true;
        goto L20
    L17:
        if (getSink$okhttp().getClosed() == false) goto L19;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void waitForIo$okhttp() throws InterruptedIOException {
        wait();     // Catch: InterruptedException -> L4
        return;
    L4:
        Thread.currentThread().interrupt();
        throw new InterruptedIOException();
    }
}
