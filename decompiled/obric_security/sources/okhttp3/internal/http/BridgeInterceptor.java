package okhttp3.internal.http;

import com.ss.android.http.legacy.protocol.HTTP;
import java.io.IOException;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okio.GzipSource;
import okio.Okio;

/* JADX INFO: loaded from: classes5.dex */
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar r1) {
        this.cookieJar = r1;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r11) throws IOException {
        Request r0 = r11.request();
        Request.Builder r1 = r0.newBuilder();
        RequestBody r2 = r0.body();
        if (r2 == null) goto L11;
        MediaType r7 = r2.contentType();
        if (r7 == null) goto L7;
        r1.header("Content-Type", r7.toString());
    L7:
        long r8 = r2.contentLength();
        if (r8 == (-1)) goto L10;
        r1.header(HTTP.CONTENT_LEN, Long.toString(r8));
        r1.removeHeader(HTTP.TRANSFER_ENCODING);
        goto L11
    L10:
        r1.header(HTTP.TRANSFER_ENCODING, HTTP.CHUNK_CODING);
        r1.removeHeader(HTTP.CONTENT_LEN);
    L11:
        boolean r9 = false;
        if (r0.header(HTTP.TARGET_HOST) != null) goto L15;
        r1.header(HTTP.TARGET_HOST, Util.hostHeader(r0.url(), false));
    L15:
        if (r0.header(HTTP.CONN_DIRECTIVE) != null) goto L18;
        r1.header(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
    L18:
        if (r0.header("Accept-Encoding") == null) goto L20;
    L22:
        List<Cookie> r3 = this.cookieJar.loadForRequest(r0.url());
        if (r3.isEmpty() == true) goto L26;
        r1.header("Cookie", cookieHeader(r3));
    L26:
        if (r0.header("User-Agent") != null) goto L28;
        r1.header("User-Agent", Version.userAgent());
    L28:
        Response r12 = r11.proceed(r1.build());
        HttpHeaders.receiveHeaders(this.cookieJar, r0.url(), r12.headers());
        Response.Builder r10 = r12.newBuilder().request(r0);
        if (r9 == false) goto L36;
        if ("gzip".equalsIgnoreCase(r12.header("Content-Encoding")) == false) goto L36;
        if (HttpHeaders.hasBody(r12) == false) goto L36;
        GzipSource r4 = new GzipSource(r12.body().source());
        r10.headers(r12.headers().newBuilder().removeAll("Content-Encoding").removeAll(HTTP.CONTENT_LEN).build());
        r10.body(new RealResponseBody(r12.header("Content-Type"), -1, Okio.buffer(r4)));
    L36:
        return r10.build();
    L20:
        if (r0.header("Range") != null) goto L22;
        r1.header("Accept-Encoding", "gzip");
        r9 = true;
        goto L22
    }

    private String cookieHeader(List<Cookie> r6) {
        StringBuilder r5 = new StringBuilder();
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r1 <= 0) goto L6;
        r5.append("; ");
    L6:
        Cookie r2 = r6.get(r1);
        r5.append(r2.name()).append('=').append(r2.value());
        r1 = r1 + 1;
        goto L3
    L8:
        return r5.toString();
    }
}
