package okhttp3.internal.http1;

import android.security.bytedance.guard.BDSecurityGuardStub;
import com.android.settings.deviceinfo.DeviceInfoProvider;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.common.Ext;
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

/* JADX INFO: compiled from: Http1ExchangeCodec.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 ?2\u00020\u0001:\u0007<=>?@ABB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\u001cH\u0016J\b\u0010'\u001a\u00020\u001eH\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020!H\u0002J\b\u0010.\u001a\u00020\u001eH\u0002J\b\u0010/\u001a\u00020)H\u0002J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u0019H\u0016J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u0010H\u0016J\u0010\u00105\u001a\u00020!2\u0006\u00101\u001a\u00020\u0019H\u0016J\u000e\u00106\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u0019J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u00152\u0006\u00109\u001a\u00020:J\u0010\u0010;\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0017H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\u00020\u0010*\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0018\u0010\u0016\u001a\u00020\u0010*\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u001a¨\u0006C"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", DeviceInfoProvider.CLIENT, "Lokhttp3/OkHttpClient;", WsConstants.KEY_CONNECTION, "Lokhttp3/internal/connection/RealConnection;", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lokio/BufferedSource;Lokio/BufferedSink;)V", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "headersReader", "Lokhttp3/internal/http1/HeadersReader;", "isClosed", "", "()Z", "state", "", "trailers", "Lokhttp3/Headers;", "isChunked", "Lokhttp3/Request;", "(Lokhttp3/Request;)Z", "Lokhttp3/Response;", "(Lokhttp3/Response;)Z", BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "createRequestBody", "Lokio/Sink;", Ext.KEY_REQUEST, "contentLength", "", "detachTimeout", "timeout", "Lokio/ForwardingTimeout;", "finishRequest", "flushRequest", "newChunkedSink", "newChunkedSource", "Lokio/Source;", "url", "Lokhttp3/HttpUrl;", "newFixedLengthSource", "length", "newKnownLengthSink", "newUnknownLengthSource", "openResponseBodySource", ApmTrafficStats.TTNET_RESPONSE, "readResponseHeaders", "Lokhttp3/Response$Builder;", "expectContinue", "reportedContentLength", "skipConnectBody", "writeRequest", "headers", "requestLine", "", "writeRequestHeaders", "AbstractSource", "ChunkedSink", "ChunkedSource", "Companion", "FixedLengthSource", "KnownLengthSink", "UnknownLengthSource", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
    private final RealConnection connection;
    private final HeadersReader headersReader;
    private final BufferedSink sink;
    private final BufferedSource source;
    private int state;
    private Headers trailers;

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b¢\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\t\u001a\u00020\u0014H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokio/Source;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "timeout", "Lokio/ForwardingTimeout;", "getTimeout", "()Lokio/ForwardingTimeout;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "responseBodyComplete", "", "Lokio/Timeout;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private abstract class AbstractSource implements Source {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final ForwardingTimeout timeout;

        public AbstractSource(Http1ExchangeCodec r2) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.this$0 = r2;
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.access$getSource$p(r2).timeout());
        }

        protected final ForwardingTimeout getTimeout() {
            return this.timeout;
        }

        protected final boolean getClosed() {
            return this.closed;
        }

        protected final void setClosed(boolean r1) {
            this.closed = r1;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Source
        public long read(Buffer r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "sink");
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
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(Http1ExchangeCodec.access$getState$p(this.this$0))));
        }
    }

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0005\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSink;", "Lokio/Sink;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "closed", "", "timeout", "Lokio/ForwardingTimeout;", "close", "", "flush", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class ChunkedSink implements Sink {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final ForwardingTimeout timeout;

        public ChunkedSink(Http1ExchangeCodec r2) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.this$0 = r2;
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.access$getSink$p(r2).timeout());
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(Buffer r3, long r4) {
            Intrinsics.checkNotNullParameter(r3, "source");
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
    }

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "url", "Lokhttp3/HttpUrl;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;Lokhttp3/HttpUrl;)V", "bytesRemainingInChunk", "", "hasMoreChunks", "", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "readChunkSize", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class ChunkedSource extends AbstractSource {
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final HttpUrl url;

        public ChunkedSource(Http1ExchangeCodec r2, HttpUrl r3) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            Intrinsics.checkNotNullParameter(r3, "url");
            this.this$0 = r2;
            super(r2);
            this.url = r3;
            this.bytesRemainingInChunk = -1;
            this.hasMoreChunks = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(Buffer r8, long r9) {
            Intrinsics.checkNotNullParameter(r8, "sink");
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
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(r9)).toString());
        L5:
            r2 = false;
            goto L6
        }

        private final void readChunkSize() {
            if (this.bytesRemainingInChunk == (-1)) goto L23;
            Http1ExchangeCodec.access$getSource$p(this.this$0).readUtf8LineStrict();
        L23:
            this.bytesRemainingInChunk = Http1ExchangeCodec.access$getSource$p(this.this$0).readHexadecimalUnsignedLong();     // Catch: NumberFormatException -> L20
            String r1 = StringsKt.trim(Http1ExchangeCodec.access$getSource$p(this.this$0).readUtf8LineStrict()).toString();     // Catch: NumberFormatException -> L20
            if (this.bytesRemainingInChunk < 0) goto L19;
            if (r1.length() <= 0) goto L10;
            boolean r2 = true;
        L11:
            if (r2 == false) goto L15;
            if (StringsKt.startsWith$default(r1, ";", false, 2, null) == false) goto L19;
        L15:
            if (this.bytesRemainingInChunk != 0) goto L25;
            this.hasMoreChunks = false;
            Http1ExchangeCodec r0 = this.this$0;
            Http1ExchangeCodec.access$setTrailers$p(r0, Http1ExchangeCodec.access$getHeadersReader$p(r0).readHeaders());
            OkHttpClient r3 = Http1ExchangeCodec.access$getClient$p(this.this$0);
            Intrinsics.checkNotNull(r3);
            CookieJar r4 = r3.cookieJar();
            HttpUrl r5 = this.url;
            Headers r6 = Http1ExchangeCodec.access$getTrailers$p(this.this$0);
            Intrinsics.checkNotNull(r6);
            HttpHeaders.receiveHeaders(r4, r5, r6);
            responseBodyComplete();
            return;
        L25:
            return;
        L10:
            r2 = false;
        L19:
            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + r1 + '\"');     // Catch: NumberFormatException -> L20
        L20:
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
    }

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$Companion;", "", "()V", "NO_CHUNK_YET", "", "STATE_CLOSED", "", "STATE_IDLE", "STATE_OPEN_REQUEST_BODY", "STATE_OPEN_RESPONSE_BODY", "STATE_READING_RESPONSE_BODY", "STATE_READ_RESPONSE_HEADERS", "STATE_WRITING_REQUEST_BODY", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$FixedLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "bytesRemaining", "", "(Lokhttp3/internal/http1/Http1ExchangeCodec;J)V", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;
        final /* synthetic */ Http1ExchangeCodec this$0;

        public FixedLengthSource(Http1ExchangeCodec r3, long r4) {
            Intrinsics.checkNotNullParameter(r3, "this$0");
            this.this$0 = r3;
            super(r3);
            this.bytesRemaining = r4;
            if (r4 != 0) goto L6;
            responseBodyComplete();
            return;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(Buffer r8, long r9) {
            Intrinsics.checkNotNullParameter(r8, "sink");
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
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(r9)).toString());
        L5:
            r2 = false;
            goto L6
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
    }

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0005\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$KnownLengthSink;", "Lokio/Sink;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "closed", "", "timeout", "Lokio/ForwardingTimeout;", "close", "", "flush", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class KnownLengthSink implements Sink {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final ForwardingTimeout timeout;

        public KnownLengthSink(Http1ExchangeCodec r2) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.this$0 = r2;
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.access$getSink$p(r2).timeout());
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(Buffer r8, long r9) {
            Intrinsics.checkNotNullParameter(r8, "source");
            if ((!this.closed) == false) goto L7;
            Util.checkOffsetAndCount(r8.size(), 0, r9);
            Http1ExchangeCodec.access$getSink$p(this.this$0).write(r8, r9);
            return;
        L7:
            throw new IllegalStateException("closed".toString());
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (this.closed == false) goto L5;
            return;
        L5:
            Http1ExchangeCodec.access$getSink$p(this.this$0).flush();
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
    }

    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$UnknownLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "inputExhausted", "", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;
        final /* synthetic */ Http1ExchangeCodec this$0;

        public UnknownLengthSource(Http1ExchangeCodec r2) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.this$0 = r2;
            super(r2);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(Buffer r5, long r6) {
            Intrinsics.checkNotNullParameter(r5, "sink");
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
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(r6)).toString());
        L5:
            r0 = false;
            goto L6
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
    }

    static {
        Companion = new Companion(null);
    }

    public Http1ExchangeCodec(OkHttpClient r2, RealConnection r3, BufferedSource r4, BufferedSink r5) {
        Intrinsics.checkNotNullParameter(r3, WsConstants.KEY_CONNECTION);
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter(r5, "sink");
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

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection getConnection() {
        return this.connection;
    }

    private final boolean isChunked(Response r3) {
        return StringsKt.equals("chunked", Response.header$default(r3, "Transfer-Encoding", null, 2, null), true);
    }

    private final boolean isChunked(Request r2) {
        return StringsKt.equals("chunked", r2.header("Transfer-Encoding"), true);
    }

    public final boolean isClosed() {
        if (this.state != 6) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Sink createRequestBody(Request r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, Ext.KEY_REQUEST);
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
    public void cancel() {
        getConnection().cancel();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(Request r4) {
        Intrinsics.checkNotNullParameter(r4, Ext.KEY_REQUEST);
        RequestLine r0 = RequestLine.INSTANCE;
        Proxy.Type r1 = getConnection().route().proxy().type();
        Intrinsics.checkNotNullExpressionValue(r1, "connection.route().proxy.type()");
        String r2 = r0.get(r4, r1);
        writeRequest(r4.headers(), r2);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(Response r2) {
        Intrinsics.checkNotNullParameter(r2, ApmTrafficStats.TTNET_RESPONSE);
        if (HttpHeaders.promisesBody(r2) == true) goto L6;
        return 0;
    L6:
        if (isChunked(r2) == false) goto L9;
        return -1;
    L9:
        return Util.headersContentLength(r2);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Source openResponseBodySource(Response r5) {
        Intrinsics.checkNotNullParameter(r5, ApmTrafficStats.TTNET_RESPONSE);
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
    public Headers trailers() {
        if (this.state != 6) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
        Headers r2 = this.trailers;
        if (r2 == null) goto L10;
        return r2;
    L10:
        return Util.EMPTY_HEADERS;
    L12:
        throw new IllegalStateException("too early; can't read the trailers yet".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        this.sink.flush();
    }

    public final void writeRequest(Headers r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "headers");
        Intrinsics.checkNotNullParameter(r8, "requestLine");
        int r0 = this.state;
        int r1 = 0;
        if (r0 != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L13;
        this.sink.writeUtf8(r8).writeUtf8("\r\n");
        int r9 = r7.size();
    L8:
        if (r1 >= r9) goto L10;
        this.sink.writeUtf8(r7.name(r1)).writeUtf8(": ").writeUtf8(r7.value(r1)).writeUtf8("\r\n");
        r1 = r1 + 1;
        goto L8
    L10:
        this.sink.writeUtf8("\r\n");
        this.state = 1;
        return;
    L13:
        throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(r0)).toString());
    L5:
        r3 = false;
        goto L6
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Response.Builder readResponseHeaders(boolean r7) {
        int r0 = this.state;
        boolean r1 = false;
        if (r0 != 1) goto L5;
    L9:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L32;
        StatusLine r2 = StatusLine.Companion.parse(this.headersReader.readLine());     // Catch: EOFException -> L28
        Response.Builder r5 = new Response.Builder().protocol(r2.protocol).code(r2.code).message(r2.message).headers(this.headersReader.readHeaders());     // Catch: EOFException -> L28
        if (r7 == false) goto L17;
        if (r2.code != 100) goto L17;
        Response.Builder r8 = (Response.Builder) null;     // Catch: EOFException -> L28
        return null;
    L17:
        if (r2.code != 100) goto L19;
        this.state = 3;     // Catch: EOFException -> L28
        return r5;
    L19:
        int r9 = r2.code;     // Catch: EOFException -> L28
        if (102 <= r9) goto L22;
    L24:
        if (r1 == false) goto L26;
        this.state = 3;     // Catch: EOFException -> L28
        return r5;
    L26:
        this.state = 4;     // Catch: EOFException -> L28
        return r5;
    L22:
        if (r9 >= 200) goto L24;
        r1 = true;
    L28:
        e = move-exception;
        throw new IOException(Intrinsics.stringPlus("unexpected end of stream on ", getConnection().route().address().url().redact()), e);
    L32:
        throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(r0)).toString());
    L5:
        if (r0 == 2) goto L9;
        if (r0 == 3) goto L9;
        r4 = false;
        goto L10
    }

    private final Sink newChunkedSink() {
        int r0 = this.state;
        boolean r1 = true;
        if (r0 == 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L10;
        this.state = 2;
        return new ChunkedSink(this);
    L10:
        throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(r0)).toString());
    }

    private final Sink newKnownLengthSink() {
        int r0 = this.state;
        boolean r1 = true;
        if (r0 == 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L10;
        this.state = 2;
        return new KnownLengthSink(this);
    L10:
        throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(r0)).toString());
    }

    private final Source newFixedLengthSource(long r3) {
        int r0 = this.state;
        if (r0 != 4) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        this.state = 5;
        return new FixedLengthSource(this, r3);
    L10:
        throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(r0)).toString());
    L5:
        r1 = false;
        goto L6
    }

    private final Source newChunkedSource(HttpUrl r3) {
        int r0 = this.state;
        if (r0 != 4) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        this.state = 5;
        return new ChunkedSource(this, r3);
    L10:
        throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(r0)).toString());
    L5:
        r1 = false;
        goto L6
    }

    private final Source newUnknownLengthSource() {
        int r0 = this.state;
        if (r0 != 4) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        this.state = 5;
        getConnection().noNewExchanges$okhttp();
        return new UnknownLengthSource(this);
    L10:
        throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(r0)).toString());
    L5:
        r1 = false;
        goto L6
    }

    private final void detachTimeout(ForwardingTimeout r2) {
        Timeout r1 = r2.delegate();
        r2.setDelegate(Timeout.NONE);
        r1.clearDeadline();
        r1.clearTimeout();
    }

    public final void skipConnectBody(Response r5) {
        Intrinsics.checkNotNullParameter(r5, ApmTrafficStats.TTNET_RESPONSE);
        long r0 = Util.headersContentLength(r5);
        if (r0 != (-1)) goto L5;
        return;
    L5:
        Source r4 = newFixedLengthSource(r0);
        Util.skipAll(r4, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        r4.close();
    }
}
