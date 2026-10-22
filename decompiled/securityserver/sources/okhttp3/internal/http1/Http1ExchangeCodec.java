package okhttp3.internal.http1;

import a.a;
import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Http1ExchangeCodec implements ExchangeCodec {
    public static final Companion Companion = null;
    private static final long NO_CHUNK_YET = -1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final OkHttpClient client;

    @NotNull
    private final RealConnection connection;
    private final HeadersReader headersReader;
    private final BufferedSink sink;
    private final BufferedSource source;
    private int state;
    private Headers trailers;

    @Metadata
    public abstract class AbstractSource implements Source {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;

        @NotNull
        private final ForwardingTimeout timeout;

        public AbstractSource(Http1ExchangeCodec r2) {
            this.this$0 = r2;
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.access$getSource$p(r2).timeout());
        }

        public final boolean getClosed() {
            return this.closed;
        }

        @NotNull
        public final ForwardingTimeout getTimeout() {
            return this.timeout;
        }

        @Override // okio.Source
        public long read(@NotNull Buffer r2, long r3) {
            Intrinsics.f(r2, "sink");
            return Http1ExchangeCodec.access$getSource$p(this.this$0).read(r2, r3);
        L5:
            e = move-exception;
            this.this$0.getConnection().noNewExchanges$okhttp();
            responseBodyComplete();
            throw e;
        }

        public final void responseBodyComplete() {
            if (Http1ExchangeCodec.access$getState$p(this.this$0) != 6) goto L6;
            return;
        L6:
            if (Http1ExchangeCodec.access$getState$p(this.this$0) != 5) goto L10;
            Http1ExchangeCodec.access$detachTimeout(this.this$0, this.timeout);
            Http1ExchangeCodec.access$setState$p(this.this$0, 6);
            return;
        L10:
            throw new IllegalStateException("state: " + Http1ExchangeCodec.access$getState$p(this.this$0));
        }

        public final void setClosed(boolean r1) {
            this.closed = r1;
        }

        @Override // okio.Source
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }
    }

    @Metadata
    public final class ChunkedSink implements Sink {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final ForwardingTimeout timeout;

        public ChunkedSink(Http1ExchangeCodec r2) {
            this.this$0 = r2;
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.access$getSink$p(r2).timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.closed == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.closed = true;     // Catch: Throwable -> L11
            Http1ExchangeCodec.access$getSink$p(this.this$0).writeUtf8("0\r\n\r\n");     // Catch: Throwable -> L11
            Http1ExchangeCodec.access$detachTimeout(this.this$0, this.timeout);     // Catch: Throwable -> L11
            Http1ExchangeCodec.access$setState$p(this.this$0, 3);     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.closed == false) goto L7;
            monitor-exit(this);
            return;
        L7:
            Http1ExchangeCodec.access$getSink$p(this.this$0).flush();     // Catch: Throwable -> L10
            monitor-exit(this);
        }

        @Override // okio.Sink
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(@NotNull Buffer r3, long r4) {
            Intrinsics.f(r3, DBHelper.BATTERY_COL_SOURCE);
            if ((!this.closed) == false) goto L10;
            if (r4 != 0) goto L7;
            return;
        L7:
            Http1ExchangeCodec.access$getSink$p(this.this$0).writeHexadecimalUnsignedLong(r4);
            Http1ExchangeCodec.access$getSink$p(this.this$0).writeUtf8("\r\n");
            Http1ExchangeCodec.access$getSink$p(this.this$0).write(r3, r4);
            Http1ExchangeCodec.access$getSink$p(this.this$0).writeUtf8("\r\n");
            return;
        L10:
            throw new IllegalStateException("closed".toString());
        }
    }

    @Metadata
    public final class ChunkedSource extends AbstractSource {
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final HttpUrl url;

        public ChunkedSource(@NotNull Http1ExchangeCodec r2, HttpUrl r3) {
            Intrinsics.f(r3, "url");
            this.this$0 = r2;
            super(r2);
            this.url = r3;
            this.bytesRemainingInChunk = -1;
            this.hasMoreChunks = true;
        }

        private final void readChunkSize() {
            if (this.bytesRemainingInChunk == (-1)) goto L26;
            Http1ExchangeCodec.access$getSource$p(this.this$0).readUtf8LineStrict();
        L26:
            this.bytesRemainingInChunk = Http1ExchangeCodec.access$getSource$p(this.this$0).readHexadecimalUnsignedLong();     // Catch: NumberFormatException -> L14
            String r1 = Http1ExchangeCodec.access$getSource$p(this.this$0).readUtf8LineStrict();     // Catch: NumberFormatException -> L14
            if (r1 == null) goto L23;
            String r2 = StringsKt.J(r1).toString();     // Catch: NumberFormatException -> L14
            if (this.bytesRemainingInChunk < 0) goto L21;
            if (r2.length() <= 0) goto L17;
            if (StringsKt.F(r2, ";", false) == false) goto L21;
        L17:
            if (this.bytesRemainingInChunk != 0) goto L27;
            this.hasMoreChunks = false;
            Http1ExchangeCodec r0 = this.this$0;
            Http1ExchangeCodec.access$setTrailers$p(r0, Http1ExchangeCodec.access$getHeadersReader$p(r0).readHeaders());
            OkHttpClient r3 = Http1ExchangeCodec.access$getClient$p(this.this$0);
            Intrinsics.c(r3);
            CookieJar r4 = r3.cookieJar();
            HttpUrl r5 = this.url;
            Headers r6 = Http1ExchangeCodec.access$getTrailers$p(this.this$0);
            Intrinsics.c(r6);
            HttpHeaders.receiveHeaders(r4, r5, r6);
            responseBodyComplete();
            return;
        L27:
            return;
        L21:
            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + r2 + '\"');     // Catch: NumberFormatException -> L14
        L23:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: NumberFormatException -> L14
        L14:
            e = move-exception;
            throw new ProtocolException(e.getMessage());
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed() == false) goto L6;
            return;
        L6:
            if (this.hasMoreChunks == true) goto L8;
        L10:
            setClosed(true);
            return;
        L8:
            if (Util.discard(this, 100, TimeUnit.MILLISECONDS) == true) goto L10;
            this.this$0.getConnection().noNewExchanges$okhttp();
            responseBodyComplete();
            goto L10
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(@NotNull Buffer r8, long r9) {
            Intrinsics.f(r8, "sink");
            if (r9 < 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L28;
            if ((!getClosed()) == false) goto L26;
            if (this.hasMoreChunks == true) goto L12;
            return -1;
        L12:
            long r5 = this.bytesRemainingInChunk;
            if (r5 != 0) goto L15;
        L16:
            readChunkSize();
            if (this.hasMoreChunks == true) goto L19;
            return -1;
        L19:
            long r10 = super.read(r8, Math.min(r9, this.bytesRemainingInChunk));
            if (r10 == (-1)) goto L23;
            this.bytesRemainingInChunk -= r10;
            return r10;
        L23:
            this.this$0.getConnection().noNewExchanges$okhttp();
            ProtocolException r11 = new ProtocolException("unexpected end of stream");
            responseBodyComplete();
            throw r11;
        L15:
            if (r5 != (-1)) goto L19;
        L26:
            throw new IllegalStateException("closed".toString());
        L28:
            throw new IllegalArgumentException(a.h("byteCount < 0: ", r9).toString());
        L5:
            r2 = false;
            goto L6
        }
    }

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public final class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;
        final /* synthetic */ Http1ExchangeCodec this$0;

        public FixedLengthSource(Http1ExchangeCodec r3, long r4) {
            this.this$0 = r3;
            super(r3);
            this.bytesRemaining = r4;
            if (r4 != 0) goto L6;
            responseBodyComplete();
            return;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed() == false) goto L6;
            return;
        L6:
            if (this.bytesRemaining != 0) goto L8;
        L10:
            setClosed(true);
            return;
        L8:
            if (Util.discard(this, 100, TimeUnit.MILLISECONDS) == true) goto L10;
            this.this$0.getConnection().noNewExchanges$okhttp();
            responseBodyComplete();
            goto L10
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(@NotNull Buffer r8, long r9) {
            Intrinsics.f(r8, "sink");
            if (r9 < 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L23;
            if ((!getClosed()) == false) goto L21;
            long r3 = this.bytesRemaining;
            if (r3 != 0) goto L12;
            return -1;
        L12:
            long r10 = super.read(r8, Math.min(r3, r9));
            if (r10 == (-1)) goto L18;
            long r4 = this.bytesRemaining - r10;
            this.bytesRemaining = r4;
            if (r4 != 0) goto L17;
            responseBodyComplete();
        L17:
            return r10;
        L18:
            this.this$0.getConnection().noNewExchanges$okhttp();
            ProtocolException r11 = new ProtocolException("unexpected end of stream");
            responseBodyComplete();
            throw r11;
        L21:
            throw new IllegalStateException("closed".toString());
        L23:
            throw new IllegalArgumentException(a.h("byteCount < 0: ", r9).toString());
        L5:
            r2 = false;
            goto L6
        }
    }

    @Metadata
    public final class KnownLengthSink implements Sink {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final ForwardingTimeout timeout;

        public KnownLengthSink(Http1ExchangeCodec r2) {
            this.this$0 = r2;
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.access$getSink$p(r2).timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed == false) goto L5;
            return;
        L5:
            this.closed = true;
            Http1ExchangeCodec.access$detachTimeout(this.this$0, this.timeout);
            Http1ExchangeCodec.access$setState$p(this.this$0, 3);
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (this.closed == false) goto L5;
            return;
        L5:
            Http1ExchangeCodec.access$getSink$p(this.this$0).flush();
        }

        @Override // okio.Sink
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(@NotNull Buffer r8, long r9) {
            Intrinsics.f(r8, DBHelper.BATTERY_COL_SOURCE);
            if ((!this.closed) == false) goto L7;
            Util.checkOffsetAndCount(r8.size(), 0, r9);
            Http1ExchangeCodec.access$getSink$p(this.this$0).write(r8, r9);
            return;
        L7:
            throw new IllegalStateException("closed".toString());
        }
    }

    @Metadata
    public final class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;
        final /* synthetic */ Http1ExchangeCodec this$0;

        public UnknownLengthSource(Http1ExchangeCodec r1) {
            this.this$0 = r1;
            super(r1);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed() == false) goto L6;
            return;
        L6:
            if (this.inputExhausted == true) goto L8;
            responseBodyComplete();
        L8:
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(@NotNull Buffer r5, long r6) {
            Intrinsics.f(r5, "sink");
            if (r6 < 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L20;
            if ((!getClosed()) == false) goto L18;
            if (this.inputExhausted == false) goto L12;
            return -1;
        L12:
            long r7 = super.read(r5, r6);
            if (r7 != (-1)) goto L16;
            this.inputExhausted = true;
            responseBodyComplete();
            return -1;
        L16:
            return r7;
        L18:
            throw new IllegalStateException("closed".toString());
        L20:
            throw new IllegalArgumentException(a.h("byteCount < 0: ", r6).toString());
        L5:
            r0 = false;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Http1ExchangeCodec(@Nullable OkHttpClient r2, @NotNull RealConnection r3, @NotNull BufferedSource r4, @NotNull BufferedSink r5) {
        Intrinsics.f(r3, WsConstants.KEY_CONNECTION);
        Intrinsics.f(r4, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.f(r5, "sink");
        this.client = r2;
        this.connection = r3;
        this.source = r4;
        this.sink = r5;
        this.headersReader = new HeadersReader(r4);
    }

    public static final /* synthetic */ void access$detachTimeout(Http1ExchangeCodec r0, ForwardingTimeout r1) {
        r0.detachTimeout(r1);
    }

    public static final /* synthetic */ OkHttpClient access$getClient$p(Http1ExchangeCodec r0) {
        return r0.client;
    }

    public static final /* synthetic */ HeadersReader access$getHeadersReader$p(Http1ExchangeCodec r0) {
        return r0.headersReader;
    }

    public static final /* synthetic */ BufferedSink access$getSink$p(Http1ExchangeCodec r0) {
        return r0.sink;
    }

    public static final /* synthetic */ BufferedSource access$getSource$p(Http1ExchangeCodec r0) {
        return r0.source;
    }

    public static final /* synthetic */ int access$getState$p(Http1ExchangeCodec r0) {
        return r0.state;
    }

    public static final /* synthetic */ Headers access$getTrailers$p(Http1ExchangeCodec r0) {
        return r0.trailers;
    }

    public static final /* synthetic */ void access$setState$p(Http1ExchangeCodec r0, int r1) {
        r0.state = r1;
    }

    public static final /* synthetic */ void access$setTrailers$p(Http1ExchangeCodec r0, Headers r1) {
        r0.trailers = r1;
    }

    private final void detachTimeout(ForwardingTimeout r2) {
        Timeout r1 = r2.delegate();
        r2.setDelegate(Timeout.NONE);
        r1.clearDeadline();
        r1.clearTimeout();
    }

    private final boolean isChunked(Response r3) {
        return HTTP.CHUNK_CODING.equalsIgnoreCase(Response.header$default(r3, HTTP.TRANSFER_ENCODING, null, 2, null));
    }

    private final Sink newChunkedSink() {
        boolean r1 = true;
        if (this.state == 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L10;
        this.state = 2;
        return new ChunkedSink(this);
    L10:
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final Source newChunkedSource(HttpUrl r3) {
        if (this.state != 4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.state = 5;
        return new ChunkedSource(this, r3);
    L10:
        throw new IllegalStateException(("state: " + this.state).toString());
    L5:
        r0 = false;
        goto L6
    }

    private final Source newFixedLengthSource(long r3) {
        if (this.state != 4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.state = 5;
        return new FixedLengthSource(this, r3);
    L10:
        throw new IllegalStateException(("state: " + this.state).toString());
    L5:
        r0 = false;
        goto L6
    }

    private final Sink newKnownLengthSink() {
        boolean r1 = true;
        if (this.state == 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L10;
        this.state = 2;
        return new KnownLengthSink(this);
    L10:
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final Source newUnknownLengthSource() {
        if (this.state != 4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.state = 5;
        getConnection().noNewExchanges$okhttp();
        return new UnknownLengthSource(this);
    L10:
        throw new IllegalStateException(("state: " + this.state).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        getConnection().cancel();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Sink createRequestBody(@NotNull Request r3, long r4) {
        Intrinsics.f(r3, "request");
        if (r3.body() == null) goto L10;
        if (r3.body().isDuplex() == false) goto L10;
        throw new ProtocolException("Duplex connections are not supported for HTTP/1");
    L10:
        if (isChunked(r3) == false) goto L13;
        return newChunkedSink();
    L13:
        if (r4 == (-1)) goto L17;
        return newKnownLengthSink();
    L17:
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public RealConnection getConnection() {
        return this.connection;
    }

    public final boolean isClosed() {
        if (this.state != 6) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Source openResponseBodySource(@NotNull Response r5) {
        Intrinsics.f(r5, ApmTrafficStats.TTNET_RESPONSE);
        if (HttpHeaders.promisesBody(r5) == true) goto L6;
        return newFixedLengthSource(0);
    L6:
        if (isChunked(r5) == true) goto L14;
        long r0 = Util.headersContentLength(r5);
        if (r0 == (-1)) goto L12;
        return newFixedLengthSource(r0);
    L12:
        return newUnknownLengthSource();
    L14:
        return newChunkedSource(r5.request().url());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @Nullable
    public Response.Builder readResponseHeaders(boolean r5) {
        int r0 = this.state;
        boolean r2 = true;
        if (r0 == 1) goto L7;
        if (r0 == 3) goto L7;
        r2 = false;
    L7:
        if (r2 == false) goto L23;
        StatusLine r1 = StatusLine.Companion.parse(this.headersReader.readLine());     // Catch: EOFException -> L13
        Response.Builder r3 = new Response.Builder().protocol(r1.protocol).code(r1.code).message(r1.message).headers(this.headersReader.readHeaders());     // Catch: EOFException -> L13
        if (r5 == false) goto L16;
        if (r1.code != 100) goto L16;
        return null;
    L16:
        if (r1.code != 100) goto L18;
        this.state = 3;     // Catch: EOFException -> L13
        return r3;
    L18:
        this.state = 4;     // Catch: EOFException -> L13
        return r3;
    L13:
        e = move-exception;
        throw new IOException(a.A("unexpected end of stream on ", getConnection().route().address().url().redact()), e);
    L23:
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(@NotNull Response r2) {
        Intrinsics.f(r2, ApmTrafficStats.TTNET_RESPONSE);
        if (HttpHeaders.promisesBody(r2) == true) goto L6;
        return 0;
    L6:
        if (isChunked(r2) == false) goto L9;
        return -1;
    L9:
        return Util.headersContentLength(r2);
    }

    public final void skipConnectBody(@NotNull Response r5) {
        Intrinsics.f(r5, ApmTrafficStats.TTNET_RESPONSE);
        long r0 = Util.headersContentLength(r5);
        if (r0 != (-1)) goto L5;
        return;
    L5:
        Source r4 = newFixedLengthSource(r0);
        Util.skipAll(r4, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.MILLISECONDS);
        r4.close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Headers trailers() {
        if (this.state != 6) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        Headers r2 = this.trailers;
        if (r2 == null) goto L11;
        return r2;
    L11:
        return Util.EMPTY_HEADERS;
    L13:
        throw new IllegalStateException("too early; can't read the trailers yet".toString());
    L5:
        r0 = false;
        goto L6
    }

    public final void writeRequest(@NotNull Headers r6, @NotNull String r7) {
        Intrinsics.f(r6, "headers");
        Intrinsics.f(r7, "requestLine");
        int r1 = 0;
        if (this.state != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        this.sink.writeUtf8(r7).writeUtf8("\r\n");
        int r8 = r6.size();
    L8:
        if (r1 >= r8) goto L10;
        this.sink.writeUtf8(r6.name(r1)).writeUtf8(": ").writeUtf8(r6.value(r1)).writeUtf8("\r\n");
        r1 = r1 + 1;
        goto L8
    L10:
        this.sink.writeUtf8("\r\n");
        this.state = 1;
        return;
    L13:
        throw new IllegalStateException(("state: " + this.state).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(@NotNull Request r4) {
        Intrinsics.f(r4, "request");
        RequestLine r0 = RequestLine.INSTANCE;
        Proxy.Type r1 = getConnection().route().proxy().type();
        Intrinsics.e(r1, "connection.route().proxy.type()");
        String r2 = r0.get(r4, r1);
        writeRequest(r4.headers(), r2);
    }

    private final boolean isChunked(Request r1) {
        return HTTP.CHUNK_CODING.equalsIgnoreCase(r1.header(HTTP.TRANSFER_ENCODING));
    }
}
