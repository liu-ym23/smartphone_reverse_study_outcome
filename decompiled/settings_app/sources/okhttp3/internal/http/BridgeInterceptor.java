package okhttp3.internal.http;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okio.GzipSource;
import okio.Okio;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: BridgeInterceptor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/http/BridgeInterceptor;", "Lokhttp3/Interceptor;", "cookieJar", "Lokhttp3/CookieJar;", "(Lokhttp3/CookieJar;)V", "cookieHeader", "", "cookies", "", "Lokhttp3/Cookie;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar r2) {
        Intrinsics.checkNotNullParameter(r2, "cookieJar");
        this.cookieJar = r2;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r13) throws IOException {
        Intrinsics.checkNotNullParameter(r13, "chain");
        Request r0 = r13.request();
        Request.Builder r1 = r0.newBuilder();
        RequestBody r2 = r0.body();
        if (r2 == null) goto L11;
        MediaType r7 = r2.contentType();
        if (r7 == null) goto L7;
        r1.header("Content-Type", r7.toString());
    L7:
        long r8 = r2.contentLength();
        if (r8 == (-1)) goto L10;
        r1.header("Content-Length", String.valueOf(r8));
        r1.removeHeader("Transfer-Encoding");
        goto L11
    L10:
        r1.header("Transfer-Encoding", "chunked");
        r1.removeHeader("Content-Length");
    L11:
        boolean r9 = false;
        if (r0.header("Host") != null) goto L15;
        r1.header("Host", Util.toHostHeader$default(r0.url(), false, 1, null));
    L15:
        if (r0.header("Connection") != null) goto L18;
        r1.header("Connection", "Keep-Alive");
    L18:
        if (r0.header("Accept-Encoding") == null) goto L20;
    L22:
        List<Cookie> r3 = this.cookieJar.loadForRequest(r0.url());
        if ((!r3.isEmpty()) == false) goto L26;
        r1.header("Cookie", cookieHeader(r3));
    L26:
        if (r0.header("User-Agent") != null) goto L28;
        r1.header("User-Agent", Util.userAgent);
    L28:
        Response r14 = r13.proceed(r1.build());
        HttpHeaders.receiveHeaders(this.cookieJar, r0.url(), r14.headers());
        Response.Builder r12 = r14.newBuilder().request(r0);
        if (r9 == false) goto L38;
        if (StringsKt.equals("gzip", Response.header$default(r14, "Content-Encoding", null, 2, null), true) == false) goto L38;
        if (HttpHeaders.promisesBody(r14) == false) goto L38;
        ResponseBody r4 = r14.body();
        if (r4 == null) goto L38;
        GzipSource r10 = new GzipSource(r4.source());
        r12.headers(r14.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
        r12.body(new RealResponseBody(Response.header$default(r14, "Content-Type", null, 2, null), -1, Okio.buffer(r10)));
    L38:
        return r12.build();
    L20:
        if (r0.header("Range") != null) goto L22;
        r1.header("Accept-Encoding", "gzip");
        r9 = true;
        goto L22
    }

    private final String cookieHeader(List<Cookie> r5) {
        StringBuilder r4 = new StringBuilder();
        Iterator<T> r6 = r5.iterator();
        int r0 = 0;
    L4:
        if (r6.hasNext() == false) goto L12;
        Object r1 = r6.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Cookie r3 = (Cookie) r1;
        if (r0 <= 0) goto L11;
        r4.append(VectorFormat.DEFAULT_SEPARATOR);
    L11:
        r4.append(r3.name()).append('=').append(r3.value());
        r0 = r2;
        goto L4
    L12:
        String r7 = r4.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "StringBuilder().apply(builderAction).toString()");
        return r7;
    }
}
