package okhttp3.internal.http;

import a.a;
import com.ss.android.http.legacy.protocol.HTTP;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okio.BufferedSink;
import okio.Okio;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean r1) {
        this.forWebSocket = r1;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain r11) {
        Intrinsics.f(r11, "chain");
        RealInterceptorChain r12 = (RealInterceptorChain) r11;
        Exchange r0 = r12.getExchange$okhttp();
        Intrinsics.c(r0);
        Request r13 = r12.getRequest$okhttp();
        RequestBody r1 = r13.body();
        long r2 = System.currentTimeMillis();
        r0.writeRequestHeaders(r13);
        boolean r6 = true;
        Long r7 = null;
        if (HttpMethod.permitsRequestBody(r13.method()) == false) goto L18;
        if (r1 == null) goto L18;
        if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(r13.header(HTTP.EXPECT_DIRECTIVE)) == false) goto L8;
        r0.flushRequest();
        Response.Builder r4 = r0.readResponseHeaders(true);
        r0.responseHeadersStart();
        boolean r8 = false;
    L9:
        if (r4 == null) goto L11;
        r0.noRequestBody();
        if (r0.getConnection$okhttp().isMultiplexed$okhttp() == true) goto L17;
        r0.noNewExchangesOnConnection();
    L17:
        r6 = r8;
    L19:
        if (r1 != null) goto L21;
    L22:
        r0.finishRequest();
    L23:
        if (r4 != null) goto L27;
        r4 = r0.readResponseHeaders(false);
        Intrinsics.c(r4);
        if (r6 == false) goto L27;
        r0.responseHeadersStart();
        r6 = false;
    L27:
        Response r3 = r4.request(r13).handshake(r0.getConnection$okhttp().handshake()).sentRequestAtMillis(r2).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int r5 = r3.code();
        if (r5 != 100) goto L33;
        Response.Builder r9 = r0.readResponseHeaders(false);
        Intrinsics.c(r9);
        if (r6 == false) goto L32;
        r0.responseHeadersStart();
    L32:
        r3 = r9.request(r13).handshake(r0.getConnection$okhttp().handshake()).sentRequestAtMillis(r2).receivedResponseAtMillis(System.currentTimeMillis()).build();
        r5 = r3.code();
    L33:
        r0.responseHeadersEnd(r3);
        if (this.forWebSocket == true) goto L36;
    L38:
        Response r10 = r3.newBuilder().body(r0.openResponseBody(r3)).build();
    L40:
        if ("close".equalsIgnoreCase(r10.request().header(HTTP.CONN_DIRECTIVE)) == false) goto L42;
    L43:
        r0.noNewExchangesOnConnection();
    L45:
        if (r5 != 204) goto L47;
    L48:
        ResponseBody r14 = r10.body();
        if (r14 == null) goto L51;
        long r15 = r14.contentLength();
    L53:
        if (r15 <= 0) goto L59;
        StringBuilder r16 = a.p(r5, "HTTP ", " had non-zero Content-Length: ");
        ResponseBody r17 = r10.body();
        if (r17 == null) goto L57;
        r7 = Long.valueOf(r17.contentLength());
    L57:
        r16.append(r7);
        throw new ProtocolException(r16.toString());
    L59:
        return r10;
    L51:
        r15 = -1;
        goto L53
    L47:
        if (r5 != 205) goto L59;
    L42:
        if ("close".equalsIgnoreCase(Response.header$default(r10, HTTP.CONN_DIRECTIVE, null, 2, null)) == false) goto L45;
    L36:
        if (r5 != 101) goto L38;
        r10 = r3.newBuilder().body(Util.EMPTY_RESPONSE).build();
        goto L40
    L21:
        if (r1.isDuplex() == true) goto L23;
    L11:
        if (r1.isDuplex() == false) goto L13;
        r0.flushRequest();
        r1.writeTo(Okio.buffer(r0.createRequestBody(r13, true)));
        goto L17
    L13:
        BufferedSink r18 = Okio.buffer(r0.createRequestBody(r13, false));
        r1.writeTo(r18);
        r18.close();
        goto L17
    L8:
        r8 = true;
        r4 = null;
    L18:
        r0.noRequestBody();
        r4 = null;
        goto L19
    }
}
