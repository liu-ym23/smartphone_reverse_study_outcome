package okhttp3.internal.http2;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Http2ExchangeCodec implements ExchangeCodec {
    private static final String CONNECTION = "connection";
    public static final Companion Companion = null;
    private static final String ENCODING = "encoding";
    private static final String HOST = "host";
    private static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = null;
    private static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = null;
    private static final String KEEP_ALIVE = "keep-alive";
    private static final String PROXY_CONNECTION = "proxy-connection";
    private static final String TE = "te";
    private static final String TRANSFER_ENCODING = "transfer-encoding";
    private static final String UPGRADE = "upgrade";
    private volatile boolean canceled;
    private final RealInterceptorChain chain;

    @NotNull
    private final RealConnection connection;
    private final Http2Connection http2Connection;
    private final Protocol protocol;
    private volatile Http2Stream stream;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final List<Header> http2HeadersList(@NotNull Request r6) {
            Intrinsics.f(r6, "request");
            Headers r5 = r6.headers();
            ArrayList r0 = new ArrayList(r5.size() + 4);
            r0.add(new Header(Header.TARGET_METHOD, r6.method()));
            r0.add(new Header(Header.TARGET_PATH, RequestLine.INSTANCE.requestPath(r6.url())));
            String r1 = r6.header(HTTP.TARGET_HOST);
            if (r1 == null) goto L5;
            r0.add(new Header(Header.TARGET_AUTHORITY, r1));
        L5:
            r0.add(new Header(Header.TARGET_SCHEME, r6.url().scheme()));
            int r7 = r5.size();
            int r2 = 0;
        L6:
            if (r2 >= r7) goto L19;
            String r3 = r5.name(r2);
            Locale r4 = Locale.US;
            Intrinsics.e(r4, "Locale.US");
            if (r3 == null) goto L18;
            String r8 = r3.toLowerCase(r4);
            Intrinsics.e(r8, "(this as java.lang.String).toLowerCase(locale)");
            if (Http2ExchangeCodec.access$getHTTP_2_SKIPPED_REQUEST_HEADERS$cp().contains(r8) == true) goto L12;
        L15:
            r0.add(new Header(r8, r5.value(r2)));
        L16:
            r2 = r2 + 1;
            goto L6
        L12:
            if (r8.equals(Http2ExchangeCodec.TE) == false) goto L16;
            if (Intrinsics.a(r5.value(r2), "trailers") == false) goto L16;
        L18:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L19:
            return r0;
        }

        @NotNull
        public final Response.Builder readHttp2HeadersList(@NotNull Headers r7, @NotNull Protocol r8) {
            Intrinsics.f(r7, "headerBlock");
            Intrinsics.f(r8, "protocol");
            Headers.Builder r6 = new Headers.Builder();
            int r0 = r7.size();
            StatusLine r1 = null;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            String r3 = r7.name(r2);
            String r4 = r7.value(r2);
            if (Intrinsics.a(r3, Header.RESPONSE_STATUS_UTF8) == false) goto L8;
            r1 = StatusLine.Companion.parse("HTTP/1.1 " + r4);
        L10:
            r2 = r2 + 1;
            goto L3
        L8:
            if (Http2ExchangeCodec.access$getHTTP_2_SKIPPED_RESPONSE_HEADERS$cp().contains(r3) == true) goto L10;
            r6.addLenient$okhttp(r3, r4);
            goto L10
        L11:
            if (r1 == null) goto L15;
            return new Response.Builder().protocol(r8).code(r1.code).message(r1.message).headers(r6.build());
        L15:
            throw new ProtocolException("Expected ':status' header not present");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableListOf(new String[]{"connection", HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8});
        HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableListOf(new String[]{"connection", HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE});
    }

    public Http2ExchangeCodec(@NotNull OkHttpClient r2, @NotNull RealConnection r3, @NotNull RealInterceptorChain r4, @NotNull Http2Connection r5) {
        Intrinsics.f(r2, "client");
        Intrinsics.f(r3, "connection");
        Intrinsics.f(r4, "chain");
        Intrinsics.f(r5, "http2Connection");
        this.connection = r3;
        this.chain = r4;
        this.http2Connection = r5;
        List<Protocol> r6 = r2.protocols();
        Protocol r7 = Protocol.H2_PRIOR_KNOWLEDGE;
        if (r6.contains(r7) == true) goto L6;
        r7 = Protocol.HTTP_2;
    L6:
        this.protocol = r7;
    }

    public static final /* synthetic */ List access$getHTTP_2_SKIPPED_REQUEST_HEADERS$cp() {
        return HTTP_2_SKIPPED_REQUEST_HEADERS;
    }

    public static final /* synthetic */ List access$getHTTP_2_SKIPPED_RESPONSE_HEADERS$cp() {
        return HTTP_2_SKIPPED_RESPONSE_HEADERS;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        this.canceled = true;
        Http2Stream r1 = this.stream;
        if (r1 == null) goto L6;
        r1.closeLater(ErrorCode.CANCEL);
        return;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Sink createRequestBody(@NotNull Request r1, long r2) {
        Intrinsics.f(r1, "request");
        Http2Stream r0 = this.stream;
        Intrinsics.c(r0);
        return r0.getSink();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        Http2Stream r0 = this.stream;
        Intrinsics.c(r0);
        r0.getSink().close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.http2Connection.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public RealConnection getConnection() {
        return this.connection;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Source openResponseBodySource(@NotNull Response r2) {
        Intrinsics.f(r2, ApmTrafficStats.TTNET_RESPONSE);
        Http2Stream r1 = this.stream;
        Intrinsics.c(r1);
        return r1.getSource$okhttp();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @Nullable
    public Response.Builder readResponseHeaders(boolean r3) {
        Http2Stream r0 = this.stream;
        Intrinsics.c(r0);
        Headers r1 = r0.takeHeaders();
        Response.Builder r2 = Companion.readHttp2HeadersList(r1, this.protocol);
        if (r3 == true) goto L5;
        return r2;
    L5:
        if (r2.getCode$okhttp() != 100) goto L9;
        return null;
    L9:
        return r2;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(@NotNull Response r1) {
        Intrinsics.f(r1, ApmTrafficStats.TTNET_RESPONSE);
        if (HttpHeaders.promisesBody(r1) == true) goto L6;
        return 0;
    L6:
        return Util.headersContentLength(r1);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Headers trailers() {
        Http2Stream r0 = this.stream;
        Intrinsics.c(r0);
        return r0.trailers();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(@NotNull Request r4) {
        Intrinsics.f(r4, "request");
        if (this.stream == null) goto L6;
        return;
    L6:
        if (r4.body() == null) goto L8;
        boolean r0 = true;
    L9:
        this.stream = this.http2Connection.newStream(Companion.http2HeadersList(r4), r0);
        if (this.canceled == true) goto L13;
        Http2Stream r5 = this.stream;
        Intrinsics.c(r5);
        Timeout r6 = r5.readTimeout();
        long r1 = this.chain.getReadTimeoutMillis$okhttp();
        TimeUnit r2 = TimeUnit.MILLISECONDS;
        r6.timeout(r1, r2);
        Http2Stream r7 = this.stream;
        Intrinsics.c(r7);
        r7.writeTimeout().timeout(this.chain.getWriteTimeoutMillis$okhttp(), r2);
        return;
    L13:
        Http2Stream r3 = this.stream;
        Intrinsics.c(r3);
        r3.closeLater(ErrorCode.CANCEL);
        throw new IOException("Canceled");
    L8:
        r0 = false;
        goto L9
    }
}
