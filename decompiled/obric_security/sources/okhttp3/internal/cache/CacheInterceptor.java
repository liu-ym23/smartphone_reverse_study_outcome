package okhttp3.internal.cache;

import com.ss.android.http.legacy.protocol.HTTP;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes5.dex */
public final class CacheInterceptor implements Interceptor {
    final InternalCache cache;

    public CacheInterceptor(InternalCache r1) {
        this.cache = r1;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r6) throws IOException {
        InternalCache r0 = this.cache;
        if (r0 == null) goto L5;
        Response r1 = r0.get(r6.request());
    L6:
        CacheStrategy r2 = new CacheStrategy.Factory(System.currentTimeMillis(), r6.request(), r1).get();
        Request r3 = r2.networkRequest;
        Response r4 = r2.cacheResponse;
        InternalCache r5 = this.cache;
        if (r5 == null) goto L9;
        r5.trackResponse(r2);
    L9:
        if (r1 == null) goto L12;
        if (r4 != null) goto L12;
        Util.closeQuietly(r1.body());
    L12:
        if (r3 != null) goto L16;
        if (r4 != null) goto L16;
        return new Response.Builder().request(r6.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(System.currentTimeMillis()).build();
    L16:
        if (r3 == null) goto L18;
        Response r7 = r6.proceed(r3);     // Catch: Throwable -> L41
        if (r7 != null) goto L23;
        if (r1 == null) goto L23;
        Util.closeQuietly(r1.body());
    L23:
        if (r4 != null) goto L25;
    L29:
        Response r8 = r7.newBuilder().cacheResponse(stripBody(r4)).networkResponse(stripBody(r7)).build();
        if (this.cache != null) goto L32;
    L40:
        return r8;
    L32:
        if (HttpHeaders.hasBody(r8) == false) goto L38;
        if (CacheStrategy.isCacheable(r8, r3) == false) goto L38;
        return cacheWritingResponse(this.cache.put(r8), r8);
    L38:
        if (HttpMethod.invalidatesCache(r3.method()) == false) goto L40;
        this.cache.remove(r3);     // Catch: IOException -> L45
        goto L40
    L25:
        if (r7.code() != 304) goto L28;
        Response r9 = r4.newBuilder().headers(combine(r4.headers(), r7.headers())).sentRequestAtMillis(r7.sentRequestAtMillis()).receivedResponseAtMillis(r7.receivedResponseAtMillis()).cacheResponse(stripBody(r4)).networkResponse(stripBody(r7)).build();
        r7.body().close();
        this.cache.trackConditionalCacheHit();
        this.cache.update(r4, r9);
        return r9;
    L28:
        Util.closeQuietly(r4.body());
    L41:
        th = move-exception;
        if (r1 == null) goto L44;
        Util.closeQuietly(r1.body());
    L44:
        throw th;
    L18:
        return r4.newBuilder().cacheResponse(stripBody(r4)).build();
    L5:
        r1 = null;
        goto L6
    }

    private static Response stripBody(Response r1) {
        if (r1 != null) goto L4;
        return r1;
    L4:
        if (r1.body() != null) goto L6;
        return r1;
    L6:
        return r1.newBuilder().body(null).build();
    }

    private Response cacheWritingResponse(final CacheRequest r4, Response r5) throws IOException {
        if (r4 != null) goto L4;
        return r5;
    L4:
        Sink r0 = r4.body();
        if (r0 != null) goto L7;
        return r5;
    L7:
        final BufferedSource r1 = r5.body().source();
        final BufferedSink r2 = Okio.buffer(r0);
        Source r3 = new AnonymousClass1(this, r1, r4, r2);
        String r6 = r5.header("Content-Type");
        long r7 = r5.body().contentLength();
        return r5.newBuilder().body(new RealResponseBody(r6, r7, Okio.buffer(r3))).build();
    }

    private static Headers combine(Headers r7, Headers r8) {
        Headers.Builder r0 = new Headers.Builder();
        int r1 = r7.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L17;
        String r4 = r7.name(r3);
        String r5 = r7.value(r3);
        if ("Warning".equalsIgnoreCase(r4) == false) goto L10;
        if (r5.startsWith("1") == false) goto L10;
    L16:
        r3 = r3 + 1;
    L10:
        if (isContentSpecificHeader(r4) == false) goto L12;
    L15:
        Internal.instance.addLenient(r0, r4, r5);
        goto L16
    L12:
        if (isEndToEnd(r4) == false) goto L15;
        if (r8.get(r4) != null) goto L16;
    L17:
        int r9 = r8.size();
    L18:
        if (r2 >= r9) goto L26;
        String r6 = r8.name(r2);
        if (isContentSpecificHeader(r6) == true) goto L24;
        if (isEndToEnd(r6) == false) goto L24;
        Internal.instance.addLenient(r0, r6, r8.value(r2));
    L24:
        r2 = r2 + 1;
        goto L18
    L26:
        return r0.build();
    }

    static boolean isEndToEnd(String r1) {
        if (HTTP.CONN_DIRECTIVE.equalsIgnoreCase(r1) == false) goto L5;
    L19:
        return false;
    L5:
        if (HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(r1) == true) goto L19;
        if ("Proxy-Authenticate".equalsIgnoreCase(r1) == true) goto L19;
        if ("Proxy-Authorization".equalsIgnoreCase(r1) == true) goto L19;
        if ("TE".equalsIgnoreCase(r1) == true) goto L19;
        if ("Trailers".equalsIgnoreCase(r1) == true) goto L19;
        if (HTTP.TRANSFER_ENCODING.equalsIgnoreCase(r1) == true) goto L19;
        if ("Upgrade".equalsIgnoreCase(r1) == true) goto L19;
        return true;
    }

    static boolean isContentSpecificHeader(String r1) {
        if (HTTP.CONTENT_LEN.equalsIgnoreCase(r1) == false) goto L5;
    L10:
        return true;
    L5:
        if ("Content-Encoding".equalsIgnoreCase(r1) == true) goto L10;
        if ("Content-Type".equalsIgnoreCase(r1) == true) goto L10;
        return false;
    }
}
