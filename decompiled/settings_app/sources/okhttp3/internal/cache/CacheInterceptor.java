package okhttp3.internal.cache;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: compiled from: CacheInterceptor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor;", "Lokhttp3/Interceptor;", "cache", "Lokhttp3/Cache;", "(Lokhttp3/Cache;)V", "getCache$okhttp", "()Lokhttp3/Cache;", "cacheWritingResponse", "Lokhttp3/Response;", "cacheRequest", "Lokhttp3/internal/cache/CacheRequest;", ApmTrafficStats.TTNET_RESPONSE, "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CacheInterceptor implements Interceptor {
    public static final Companion Companion = null;
    private final Cache cache;

    /* JADX INFO: compiled from: CacheInterceptor.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor$Companion;", "", "()V", "combine", "Lokhttp3/Headers;", "cachedHeaders", "networkHeaders", "isContentSpecificHeader", "", "fieldName", "", "isEndToEnd", "stripBody", "Lokhttp3/Response;", ApmTrafficStats.TTNET_RESPONSE, "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ Headers access$combine(Companion r0, Headers r1, Headers r2) {
            return r0.combine(r1, r2);
        }

        public static final /* synthetic */ Response access$stripBody(Companion r0, Response r1) {
            return r0.stripBody(r1);
        }

        private final Response stripBody(Response r2) {
            if (r2 != null) goto L5;
            ResponseBody r0 = null;
        L6:
            if (r0 != null) goto L8;
            return r2;
        L8:
            return r2.newBuilder().body(null).build();
        L5:
            r0 = r2.body();
            goto L6
        }

        private final Headers combine(Headers r10, Headers r11) {
            Headers.Builder r0 = new Headers.Builder();
            int r1 = r10.size();
            int r2 = 0;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L17;
            int r4 = r3 + 1;
            String r5 = r10.name(r3);
            String r6 = r10.value(r3);
            if (StringsKt.equals("Warning", r5, true) == false) goto L10;
            if (StringsKt.startsWith$default(r6, "1", false, 2, null) == false) goto L10;
        L16:
            r3 = r4;
        L10:
            if (isContentSpecificHeader(r5) == false) goto L12;
        L15:
            r0.addLenient$okhttp(r5, r6);
            goto L16
        L12:
            if (isEndToEnd(r5) == false) goto L15;
            if (r11.get(r5) != null) goto L16;
        L17:
            int r12 = r11.size();
        L18:
            if (r2 >= r12) goto L26;
            int r7 = r2 + 1;
            String r8 = r11.name(r2);
            if (isContentSpecificHeader(r8) == true) goto L24;
            if (isEndToEnd(r8) == false) goto L24;
            r0.addLenient$okhttp(r8, r11.value(r2));
        L24:
            r2 = r7;
            goto L18
        L26:
            return r0.build();
        }

        private final boolean isEndToEnd(String r2) {
            if (StringsKt.equals("Connection", r2, true) == false) goto L5;
        L19:
            return false;
        L5:
            if (StringsKt.equals("Keep-Alive", r2, true) == true) goto L19;
            if (StringsKt.equals("Proxy-Authenticate", r2, true) == true) goto L19;
            if (StringsKt.equals("Proxy-Authorization", r2, true) == true) goto L19;
            if (StringsKt.equals("TE", r2, true) == true) goto L19;
            if (StringsKt.equals("Trailers", r2, true) == true) goto L19;
            if (StringsKt.equals("Transfer-Encoding", r2, true) == true) goto L19;
            if (StringsKt.equals("Upgrade", r2, true) == true) goto L19;
            return true;
        }

        private final boolean isContentSpecificHeader(String r2) {
            if (StringsKt.equals("Content-Length", r2, true) == false) goto L5;
            return true;
        L5:
            if (StringsKt.equals("Content-Encoding", r2, true) == false) goto L7;
            return true;
        L7:
            if (StringsKt.equals("Content-Type", r2, true) == true) goto L13;
            return false;
        L13:
            return true;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CacheInterceptor(Cache r1) {
        this.cache = r1;
    }

    public final Cache getCache$okhttp() {
        return this.cache;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r9) throws IOException {
        Intrinsics.checkNotNullParameter(r9, "chain");
        Call r0 = r9.call();
        Cache r1 = this.cache;
        EventListener r2 = null;
        if (r1 != null) goto L5;
        Response r3 = null;
    L6:
        CacheStrategy r4 = new CacheStrategy.Factory(System.currentTimeMillis(), r9.request(), r3).compute();
        Request r5 = r4.getNetworkRequest();
        Response r6 = r4.getCacheResponse();
        Cache r7 = this.cache;
        if (r7 == null) goto L11;
        r7.trackResponse$okhttp(r4);
    L11:
        if ((r0 instanceof RealCall) == false) goto L13;
        RealCall r8 = (RealCall) r0;
    L14:
        if (r8 == null) goto L17;
        r2 = r8.getEventListener$okhttp();
    L17:
        if (r2 != null) goto L19;
        r2 = EventListener.NONE;
    L19:
        if (r3 == null) goto L25;
        if (r6 != null) goto L25;
        ResponseBody r10 = r3.body();
        if (r10 == null) goto L25;
        Util.closeQuietly(r10);
    L25:
        if (r5 != null) goto L29;
        if (r6 != null) goto L29;
        Response r11 = new Response.Builder().request(r9.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(System.currentTimeMillis()).build();
        r2.satisfactionFailure(r0, r11);
        return r11;
    L29:
        if (r5 != null) goto L32;
        Intrinsics.checkNotNull(r6);
        Response r12 = r6.newBuilder().cacheResponse(Companion.access$stripBody(Companion, r6)).build();
        r2.cacheHit(r0, r12);
        return r12;
    L32:
        if (r6 == null) goto L35;
        r2.cacheConditionalHit(r0, r6);
    L82:
        Response r13 = r9.proceed(r5);     // Catch: Throwable -> L72
        if (r13 != null) goto L44;
        if (r3 == null) goto L44;
        ResponseBody r14 = r3.body();
        if (r14 == null) goto L44;
        Util.closeQuietly(r14);
    L44:
        if (r6 == null) goto L58;
        boolean r15 = false;
        if (r13 != null) goto L49;
    L51:
        if (r15 == false) goto L54;
        Response.Builder r16 = r6.newBuilder();
        Companion r17 = Companion;
        Response r18 = r16.headers(Companion.access$combine(r17, r6.headers(), r13.headers())).sentRequestAtMillis(r13.sentRequestAtMillis()).receivedResponseAtMillis(r13.receivedResponseAtMillis()).cacheResponse(Companion.access$stripBody(r17, r6)).networkResponse(Companion.access$stripBody(r17, r13)).build();
        ResponseBody r19 = r13.body();
        Intrinsics.checkNotNull(r19);
        r19.close();
        Cache r20 = this.cache;
        Intrinsics.checkNotNull(r20);
        r20.trackConditionalCacheHit$okhttp();
        this.cache.update$okhttp(r6, r18);
        r2.cacheHit(r0, r18);
        return r18;
    L54:
        ResponseBody r21 = r6.body();
        if (r21 == null) goto L58;
        Util.closeQuietly(r21);
        goto L58
    L49:
        if (r13.code() != 304) goto L51;
        r15 = true;
    L58:
        Intrinsics.checkNotNull(r13);
        Response.Builder r22 = r13.newBuilder();
        Companion r23 = Companion;
        Response r24 = r22.cacheResponse(Companion.access$stripBody(r23, r6)).networkResponse(Companion.access$stripBody(r23, r13)).build();
        if (this.cache != null) goto L61;
    L71:
        return r24;
    L61:
        if (HttpHeaders.promisesBody(r24) == false) goto L69;
        if (CacheStrategy.Companion.isCacheable(r24, r5) == false) goto L69;
        Response r25 = cacheWritingResponse(this.cache.put$okhttp(r24), r24);
        if (r6 == null) goto L67;
        r2.cacheMiss(r0);
    L67:
        return r25;
    L69:
        if (HttpMethod.INSTANCE.invalidatesCache(r5.method()) == false) goto L71;
        this.cache.remove$okhttp(r5);     // Catch: IOException -> L79
    L72:
        th = move-exception;
        if (r3 == null) goto L78;
        ResponseBody r26 = r3.body();
        if (r26 == null) goto L78;
        Util.closeQuietly(r26);
    L78:
        throw th;
    L35:
        if (this.cache == null) goto L82;
        r2.cacheMiss(r0);
        goto L82
    L13:
        r8 = null;
        goto L14
    L5:
        r3 = r1.get$okhttp(r9.request());
        goto L6
    }

    private final Response cacheWritingResponse(final CacheRequest r5, Response r6) throws IOException {
        if (r5 != null) goto L4;
        return r6;
    L4:
        Sink r4 = r5.body();
        ResponseBody r0 = r6.body();
        Intrinsics.checkNotNull(r0);
        final BufferedSource r1 = r0.source();
        final BufferedSink r7 = Okio.buffer(r4);
        Source r2 = new CacheInterceptor$cacheWritingResponse$cacheWritingSource$1(r1, r5, r7);
        String r8 = Response.header$default(r6, "Content-Type", null, 2, null);
        long r3 = r6.body().contentLength();
        return r6.newBuilder().body(new RealResponseBody(r8, r3, Okio.buffer(r2))).build();
    }
}
