package okhttp3.internal.http;

import com.ss.android.http.legacy.protocol.HTTP;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
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
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(@NotNull CookieJar r2) {
        Intrinsics.f(r2, "cookieJar");
        this.cookieJar = r2;
    }

    private final String cookieHeader(List<Cookie> r4) {
        StringBuilder r3 = new StringBuilder();
        Iterator<T> r5 = r4.iterator();
        int r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L13;
        Object r1 = r5.next();
        int r2 = r0 + 1;
        if (r0 < 0) goto L11;
        Cookie r6 = (Cookie) r1;
        if (r0 <= 0) goto L10;
        r3.append("; ");
    L10:
        r3.append(r6.name());
        r3.append('=');
        r3.append(r6.value());
        r0 = r2;
        goto L4
    L11:
        CollectionsKt.p();
        throw null;
    L13:
        String r7 = r3.toString();
        Intrinsics.e(r7, "StringBuilder().apply(builderAction).toString()");
        return r7;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain r13) {
        Intrinsics.f(r13, "chain");
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
        r1.header(HTTP.CONTENT_LEN, String.valueOf(r8));
        r1.removeHeader(HTTP.TRANSFER_ENCODING);
        goto L11
    L10:
        r1.header(HTTP.TRANSFER_ENCODING, HTTP.CHUNK_CODING);
        r1.removeHeader(HTTP.CONTENT_LEN);
    L11:
        boolean r9 = false;
        if (r0.header(HTTP.TARGET_HOST) != null) goto L15;
        r1.header(HTTP.TARGET_HOST, Util.toHostHeader$default(r0.url(), false, 1, null));
    L15:
        if (r0.header(HTTP.CONN_DIRECTIVE) != null) goto L18;
        r1.header(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
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
        if ("gzip".equalsIgnoreCase(Response.header$default(r14, "Content-Encoding", null, 2, null)) == false) goto L38;
        if (HttpHeaders.promisesBody(r14) == false) goto L38;
        ResponseBody r4 = r14.body();
        if (r4 == null) goto L38;
        GzipSource r10 = new GzipSource(r4.source());
        r12.headers(r14.headers().newBuilder().removeAll("Content-Encoding").removeAll(HTTP.CONTENT_LEN).build());
        r12.body(new RealResponseBody(Response.header$default(r14, "Content-Type", null, 2, null), -1, Okio.buffer(r10)));
    L38:
        return r12.build();
    L20:
        if (r0.header("Range") != null) goto L22;
        r1.header("Accept-Encoding", "gzip");
        r9 = true;
        goto L22
    }
}
