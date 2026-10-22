package okhttp3.internal.http2;

import android.security.bytedance.guard.BDSecurityGuardStub;
import com.android.settings.deviceinfo.DeviceInfoProvider;
import com.android.vcard.VCardConstants;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.capabilitykit.common.Ext;
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

/* JADX INFO: compiled from: Http2ExchangeCodec.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\fH\u0016J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lokhttp3/internal/http2/Http2ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", DeviceInfoProvider.CLIENT, "Lokhttp3/OkHttpClient;", "connection", "Lokhttp3/internal/connection/RealConnection;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "http2Connection", "Lokhttp3/internal/http2/Http2Connection;", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lokhttp3/internal/http/RealInterceptorChain;Lokhttp3/internal/http2/Http2Connection;)V", "canceled", "", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "protocol", "Lokhttp3/Protocol;", CozeCloudExt.API_KEY_HTTP_STREAM_METHOD, "Lokhttp3/internal/http2/Http2Stream;", BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "createRequestBody", "Lokio/Sink;", Ext.KEY_REQUEST, "Lokhttp3/Request;", "contentLength", "", "finishRequest", "flushRequest", "openResponseBodySource", "Lokio/Source;", ApmTrafficStats.TTNET_RESPONSE, "Lokhttp3/Response;", "readResponseHeaders", "Lokhttp3/Response$Builder;", "expectContinue", "reportedContentLength", "trailers", "Lokhttp3/Headers;", "writeRequestHeaders", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
    private final RealConnection connection;
    private final Http2Connection http2Connection;
    private final Protocol protocol;
    private volatile Http2Stream stream;

    /* JADX INFO: compiled from: Http2ExchangeCodec.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/http2/Http2ExchangeCodec$Companion;", "", "()V", "CONNECTION", "", VCardConstants.PARAM_ENCODING, "HOST", "HTTP_2_SKIPPED_REQUEST_HEADERS", "", "HTTP_2_SKIPPED_RESPONSE_HEADERS", "KEEP_ALIVE", "PROXY_CONNECTION", "TE", "TRANSFER_ENCODING", "UPGRADE", "http2HeadersList", "Lokhttp3/internal/http2/Header;", Ext.KEY_REQUEST, "Lokhttp3/Request;", "readHttp2HeadersList", "Lokhttp3/Response$Builder;", "headerBlock", "Lokhttp3/Headers;", "protocol", "Lokhttp3/Protocol;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final List<Header> http2HeadersList(Request r7) {
            Intrinsics.checkNotNullParameter(r7, Ext.KEY_REQUEST);
            Headers r6 = r7.headers();
            ArrayList r0 = new ArrayList(r6.size() + 4);
            r0.add(new Header(Header.TARGET_METHOD, r7.method()));
            r0.add(new Header(Header.TARGET_PATH, RequestLine.INSTANCE.requestPath(r7.url())));
            String r1 = r7.header("Host");
            if (r1 == null) goto L5;
            r0.add(new Header(Header.TARGET_AUTHORITY, r1));
        L5:
            r0.add(new Header(Header.TARGET_SCHEME, r7.url().scheme()));
            int r8 = r6.size();
            int r2 = 0;
        L6:
            if (r2 >= r8) goto L16;
            int r3 = r2 + 1;
            String r4 = r6.name(r2);
            Locale r5 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(r5, "US");
            String r9 = r4.toLowerCase(r5);
            Intrinsics.checkNotNullExpressionValue(r9, "this as java.lang.String).toLowerCase(locale)");
            if (Http2ExchangeCodec.access$getHTTP_2_SKIPPED_REQUEST_HEADERS$cp().contains(r9) == true) goto L10;
        L13:
            r0.add(new Header(r9, r6.value(r2)));
        L14:
            r2 = r3;
            goto L6
        L10:
            if (Intrinsics.areEqual(r9, Http2ExchangeCodec.TE) == false) goto L14;
            if (Intrinsics.areEqual(r6.value(r2), "trailers") == false) goto L14;
        L16:
            return r0;
        }

        public final Response.Builder readHttp2HeadersList(Headers r7, Protocol r8) {
            Intrinsics.checkNotNullParameter(r7, "headerBlock");
            Intrinsics.checkNotNullParameter(r8, "protocol");
            Headers.Builder r6 = new Headers.Builder();
            int r0 = r7.size();
            StatusLine r1 = null;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            int r3 = r2 + 1;
            String r4 = r7.name(r2);
            String r5 = r7.value(r2);
            if (Intrinsics.areEqual(r4, Header.RESPONSE_STATUS_UTF8) == false) goto L8;
            r1 = StatusLine.Companion.parse(Intrinsics.stringPlus("HTTP/1.1 ", r5));
        L10:
            r2 = r3;
            goto L3
        L8:
            if (Http2ExchangeCodec.access$getHTTP_2_SKIPPED_RESPONSE_HEADERS$cp().contains(r4) == true) goto L10;
            r6.addLenient$okhttp(r4, r5);
            goto L10
        L11:
            if (r1 == null) goto L15;
            return new Response.Builder().protocol(r8).code(r1.code).message(r1.message).headers(r6.build());
        L15:
            throw new ProtocolException("Expected ':status' header not present");
        }
    }

    public Http2ExchangeCodec(OkHttpClient r2, RealConnection r3, RealInterceptorChain r4, Http2Connection r5) {
        Intrinsics.checkNotNullParameter(r2, DeviceInfoProvider.CLIENT);
        Intrinsics.checkNotNullParameter(r3, "connection");
        Intrinsics.checkNotNullParameter(r4, "chain");
        Intrinsics.checkNotNullParameter(r5, "http2Connection");
        this.connection = r3;
        this.chain = r4;
        this.http2Connection = r5;
        if (r2.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE) == false) goto L5;
        Protocol r6 = Protocol.H2_PRIOR_KNOWLEDGE;
    L6:
        this.protocol = r6;
        return;
    L5:
        r6 = Protocol.HTTP_2;
        goto L6
    }

    public static final /* synthetic */ List access$getHTTP_2_SKIPPED_REQUEST_HEADERS$cp() {
        return HTTP_2_SKIPPED_REQUEST_HEADERS;
    }

    public static final /* synthetic */ List access$getHTTP_2_SKIPPED_RESPONSE_HEADERS$cp() {
        return HTTP_2_SKIPPED_RESPONSE_HEADERS;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection getConnection() {
        return this.connection;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Sink createRequestBody(Request r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, Ext.KEY_REQUEST);
        Http2Stream r0 = this.stream;
        Intrinsics.checkNotNull(r0);
        return r0.getSink();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(Request r4) {
        Intrinsics.checkNotNullParameter(r4, Ext.KEY_REQUEST);
        if (this.stream == null) goto L6;
        return;
    L6:
        if (r4.body() == null) goto L8;
        boolean r0 = true;
    L9:
        this.stream = this.http2Connection.newStream(Companion.http2HeadersList(r4), r0);
        if (this.canceled == true) goto L13;
        Http2Stream r5 = this.stream;
        Intrinsics.checkNotNull(r5);
        r5.readTimeout().timeout(this.chain.getReadTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
        Http2Stream r6 = this.stream;
        Intrinsics.checkNotNull(r6);
        r6.writeTimeout().timeout(this.chain.getWriteTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
        return;
    L13:
        Http2Stream r3 = this.stream;
        Intrinsics.checkNotNull(r3);
        r3.closeLater(ErrorCode.CANCEL);
        throw new IOException("Canceled");
    L8:
        r0 = false;
        goto L9
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.http2Connection.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        Http2Stream r0 = this.stream;
        Intrinsics.checkNotNull(r0);
        r0.getSink().close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Response.Builder readResponseHeaders(boolean r3) {
        Http2Stream r0 = this.stream;
        if (r0 == null) goto L11;
        Headers r1 = r0.takeHeaders();
        Response.Builder r2 = Companion.readHttp2HeadersList(r1, this.protocol);
        if (r3 == true) goto L7;
        return r2;
    L7:
        if (r2.getCode$okhttp() != 100) goto L13;
        Response.Builder r4 = (Response.Builder) null;
        return null;
    L13:
        return r2;
    L11:
        throw new IOException("stream wasn't created");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(Response r1) {
        Intrinsics.checkNotNullParameter(r1, ApmTrafficStats.TTNET_RESPONSE);
        if (HttpHeaders.promisesBody(r1) == true) goto L6;
        return 0;
    L6:
        return Util.headersContentLength(r1);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Source openResponseBodySource(Response r2) {
        Intrinsics.checkNotNullParameter(r2, ApmTrafficStats.TTNET_RESPONSE);
        Http2Stream r1 = this.stream;
        Intrinsics.checkNotNull(r1);
        return r1.getSource$okhttp();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Headers trailers() {
        Http2Stream r0 = this.stream;
        Intrinsics.checkNotNull(r0);
        return r0.trailers();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        this.canceled = true;
        Http2Stream r1 = this.stream;
        if (r1 == null) goto L7;
        r1.closeLater(ErrorCode.CANCEL);
        return;
    }

    static {
        Companion = new Companion(null);
        HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableListOf(new String[]{"connection", "host", KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8});
        HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableListOf(new String[]{"connection", "host", KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE});
    }
}
