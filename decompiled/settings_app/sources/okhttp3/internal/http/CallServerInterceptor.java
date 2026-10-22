package okhttp3.internal.http;

import com.bytedance.apm.alog.AlogMonitor;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http2.ConnectionShutdownException;
import okio.BufferedSink;
import okio.Okio;

/* JADX INFO: compiled from: CallServerInterceptor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "forWebSocket", "", "(Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "shouldIgnoreAndWaitForRealResponse", AlogMonitor.ALOG_RESULT_CODE, "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    private final boolean shouldIgnoreAndWaitForRealResponse(int r3) {
        if (r3 != 100) goto L6;
        return true;
    L6:
        if (102 <= r3) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L14;
        return true;
    L14:
        return false;
    L8:
        if (r3 >= 200) goto L10;
        r2 = true;
        goto L11
    }

    public CallServerInterceptor(boolean r1) {
        this.forWebSocket = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21, types: [okhttp3.Response$Builder] */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Object, okhttp3.Response$Builder] */
    /* JADX WARN: Type inference failed for: r10v4, types: [okhttp3.Response$Builder] */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r15) throws IOException {
        Intrinsics.checkNotNullParameter(r15, "chain");
        RealInterceptorChain r16 = (RealInterceptorChain) r15;
        Exchange r3 = r16.getExchange$okhttp();
        Intrinsics.checkNotNull(r3);
        Request r17 = r16.getRequest$okhttp();
        RequestBody r4 = r17.body();
        long r5 = System.currentTimeMillis();
        Long r9 = null;
        r3.writeRequestHeaders(r17);     // Catch: IOException -> L32
        ?? r10 = HttpMethod.permitsRequestBody(r17.method());     // Catch: IOException -> L32
        if (r10 == 0) goto L23;
        if (r4 == null) goto L23;
        if (StringsKt.equals("100-continue", r17.header("Expect"), true) == false) goto L13;
        r3.flushRequest();     // Catch: IOException -> L32
        r10 = r3.readResponseHeaders(true);     // Catch: IOException -> L32
        r3.responseHeadersStart();     // Catch: IOException -> L11
        boolean r11 = false;
        ?? r12 = r10;
    L14:
        if (r12 == 0) goto L16;
        r3.noRequestBody();     // Catch: IOException -> L30
        r10 = r12;
        if (r3.getConnection$okhttp().isMultiplexed$okhttp() == true) goto L25;
        r3.noNewExchangesOnConnection();     // Catch: IOException -> L30
        r10 = r12;
    L25:
        if (r4 != null) goto L27;
    L28:
        r3.finishRequest();     // Catch: IOException -> L30
    L29:
        e = null;
        ?? r13 = r10;
    L38:
        if (r13 == 0) goto L85;
    L42:
        Response r14 = r13.request(r17).handshake(r3.getConnection$okhttp().handshake()).sentRequestAtMillis(r5).receivedResponseAtMillis(System.currentTimeMillis()).build();     // Catch: IOException -> L76
        int r18 = r14.code();     // Catch: IOException -> L76
        if (shouldIgnoreAndWaitForRealResponse(r18) == false) goto L48;
        Response.Builder r7 = r3.readResponseHeaders(false);     // Catch: IOException -> L76
        Intrinsics.checkNotNull(r7);     // Catch: IOException -> L76
        if (r11 == false) goto L47;
        r3.responseHeadersStart();     // Catch: IOException -> L76
    L47:
        r14 = r7.request(r17).handshake(r3.getConnection$okhttp().handshake()).sentRequestAtMillis(r5).receivedResponseAtMillis(System.currentTimeMillis()).build();     // Catch: IOException -> L76
        r18 = r14.code();     // Catch: IOException -> L76
    L48:
        r3.responseHeadersEnd(r14);     // Catch: IOException -> L76
        if (this.forWebSocket == true) goto L51;
    L53:
        Response r19 = r14.newBuilder().body(r3.openResponseBody(r14)).build();     // Catch: IOException -> L76
    L55:
        if (StringsKt.equals("close", r19.request().header("Connection"), true) == false) goto L57;
    L58:
        r3.noNewExchangesOnConnection();     // Catch: IOException -> L76
    L60:
        if (r18 != 204) goto L62;
    L63:
        ResponseBody r110 = r19.body();     // Catch: IOException -> L76
        if (r110 != null) goto L66;
        long r0 = -1;
    L68:
        if (r0 <= 0) goto L75;
        StringBuilder r1 = new StringBuilder("HTTP ").append(r18).append(" had non-zero Content-Length: ");     // Catch: IOException -> L76
        ResponseBody r111 = r19.body();     // Catch: IOException -> L76
        if (r111 == null) goto L74;
        r9 = Long.valueOf(r111.contentLength());     // Catch: IOException -> L76
    L74:
        throw new ProtocolException(r1.append(r9).toString());     // Catch: IOException -> L76
    L76:
        e = move-exception;
        if (e == null) goto L80;
        ExceptionsKt.addSuppressed(e, e);
        throw e;
    L80:
        throw e;
    L75:
        return r19;
    L66:
        r0 = r110.contentLength();     // Catch: IOException -> L76
        goto L68
    L62:
        if (r18 != 205) goto L75;
    L57:
        if (StringsKt.equals("close", Response.header$default(r19, "Connection", null, 2, null), true) == false) goto L60;
    L51:
        if (r18 != 101) goto L53;
        r19 = r14.newBuilder().body(Util.EMPTY_RESPONSE).build();     // Catch: IOException -> L76
        goto L55
    L85:
        r13 = r3.readResponseHeaders(false);     // Catch: IOException -> L76
        Intrinsics.checkNotNull(r13);     // Catch: IOException -> L76
        if (r11 == false) goto L42;
        r3.responseHeadersStart();     // Catch: IOException -> L76
        r11 = false;
        goto L42
    L27:
        if (r4.isDuplex() == true) goto L29;
    L16:
        if (r4.isDuplex() == false) goto L18;
        r3.flushRequest();     // Catch: IOException -> L30
        r4.writeTo(Okio.buffer(r3.createRequestBody(r17, true)));     // Catch: IOException -> L30
        r10 = r12;
        goto L25
    L18:
        BufferedSink r112 = Okio.buffer(r3.createRequestBody(r17, false));     // Catch: IOException -> L30
        r4.writeTo(r112);     // Catch: IOException -> L30
        r112.close();     // Catch: IOException -> L30
        r10 = r12;
    L11:
        e = e;
        r11 = true;
    L35:
        if ((e instanceof ConnectionShutdownException) == true) goto L82;
        r13 = r10;
        if (r3.getHasFailure$okhttp() == true) goto L38;
        throw e;
    L82:
        throw e;
    L13:
        r11 = true;
        r12 = 0;
    L23:
        r3.noRequestBody();     // Catch: IOException -> L32
        r11 = true;
        r10 = 0;
    L30:
        e = e;
    L32:
        e = e;
        r11 = true;
        r10 = 0;
        goto L35
    }
}
