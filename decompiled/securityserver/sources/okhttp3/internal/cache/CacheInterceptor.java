package okhttp3.internal.cache;

import com.ss.android.http.legacy.protocol.HTTP;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CacheInterceptor implements Interceptor {
    public static final Companion Companion = null;

    @Nullable
    private final Cache cache;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Headers access$combine(Companion r0, Headers r1, Headers r2) {
            return r0.combine(r1, r2);
        }

        public static final /* synthetic */ Response access$stripBody(Companion r0, Response r1) {
            return r0.stripBody(r1);
        }

        private final Headers combine(Headers r8, Headers r9) {
            Headers.Builder r0 = new Headers.Builder();
            int r1 = r8.size();
            int r2 = 0;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L17;
            String r4 = r8.name(r3);
            String r5 = r8.value(r3);
            if ("Warning".equalsIgnoreCase(r4) == false) goto L10;
            if (StringsKt.F(r5, "1", false) == false) goto L10;
        L16:
            r3 = r3 + 1;
        L10:
            if (isContentSpecificHeader(r4) == false) goto L12;
        L15:
            r0.addLenient$okhttp(r4, r5);
            goto L16
        L12:
            if (isEndToEnd(r4) == false) goto L15;
            if (r9.get(r4) != null) goto L16;
        L17:
            int r10 = r9.size();
        L18:
            if (r2 >= r10) goto L26;
            String r6 = r9.name(r2);
            if (isContentSpecificHeader(r6) == true) goto L24;
            if (isEndToEnd(r6) == false) goto L24;
            r0.addLenient$okhttp(r6, r9.value(r2));
        L24:
            r2 = r2 + 1;
            goto L18
        L26:
            return r0.build();
        }

        private final boolean isContentSpecificHeader(String r1) {
            if (HTTP.CONTENT_LEN.equalsIgnoreCase(r1) == false) goto L5;
        L10:
            return true;
        L5:
            if ("Content-Encoding".equalsIgnoreCase(r1) == true) goto L10;
            if ("Content-Type".equalsIgnoreCase(r1) == true) goto L10;
            return false;
        }

        private final boolean isEndToEnd(String r1) {
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

        private final Response stripBody(Response r2) {
            if (r2 == null) goto L5;
            ResponseBody r0 = r2.body();
        L6:
            if (r0 != null) goto L8;
            return r2;
        L8:
            return r2.newBuilder().body(null).build();
        L5:
            r0 = null;
            goto L6
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CacheInterceptor(@Nullable Cache r1) {
        this.cache = r1;
    }

    private final Response cacheWritingResponse(final CacheRequest r5, Response r6) {
        if (r5 != null) goto L4;
        return r6;
    L4:
        Sink r4 = r5.body();
        ResponseBody r0 = r6.body();
        Intrinsics.c(r0);
        final BufferedSource r1 = r0.source();
        final BufferedSink r7 = Okio.buffer(r4);
        Source r2 = new CacheInterceptor$cacheWritingResponse$cacheWritingSource$1(r1, r5, r7);
        String r8 = Response.header$default(r6, "Content-Type", null, 2, null);
        long r3 = r6.body().contentLength();
        return r6.newBuilder().body(new RealResponseBody(r8, r3, Okio.buffer(r2))).build();
    }

    @Nullable
    public final Cache getCache$okhttp() {
        return this.cache;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain r9) {
        Intrinsics.f(r9, "chain");
        Call r0 = r9.call();
        Cache r1 = this.cache;
        Call r2 = null;
        if (r1 == null) goto L5;
        Response r3 = r1.get$okhttp(r9.request());
    L6:
        CacheStrategy r4 = new CacheStrategy.Factory(System.currentTimeMillis(), r9.request(), r3).compute();
        Request r5 = r4.getNetworkRequest();
        Response r6 = r4.getCacheResponse();
        Cache r7 = this.cache;
        if (r7 == null) goto L10;
        r7.trackResponse$okhttp(r4);
    L10:
        if ((r0 instanceof RealCall) == false) goto L13;
        r2 = r0;
    L13:
        RealCall r8 = (RealCall) r2;
        if (r8 == null) goto L18;
        EventListener r10 = r8.getEventListener$okhttp();
        if (r10 == null) goto L18;
    L19:
        if (r3 == null) goto L24;
        if (r6 != null) goto L24;
        ResponseBody r11 = r3.body();
        if (r11 == null) goto L24;
        Util.closeQuietly(r11);
    L24:
        if (r5 != null) goto L28;
        if (r6 != null) goto L28;
        Response r12 = new Response.Builder().request(r9.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(System.currentTimeMillis()).build();
        r10.satisfactionFailure(r0, r12);
        return r12;
    L28:
        if (r5 != null) goto L31;
        Intrinsics.c(r6);
        Response r13 = r6.newBuilder().cacheResponse(Companion.access$stripBody(Companion, r6)).build();
        r10.cacheHit(r0, r13);
        return r13;
    L31:
        if (r6 == null) goto L34;
        r10.cacheConditionalHit(r0, r6);
    L74:
        Response r14 = r9.proceed(r5);     // Catch: Throwable -> L65
        if (r14 != null) goto L42;
        if (r3 == null) goto L42;
        ResponseBody r15 = r3.body();
        if (r15 == null) goto L42;
        Util.closeQuietly(r15);
    L42:
        if (r6 == null) goto L51;
        if (r14 != null) goto L45;
    L48:
        ResponseBody r16 = r6.body();
        if (r16 == null) goto L51;
        Util.closeQuietly(r16);
        goto L51
    L45:
        if (r14.code() != 304) goto L48;
        Response.Builder r17 = r6.newBuilder();
        Companion r18 = Companion;
        Response r19 = r17.headers(Companion.access$combine(r18, r6.headers(), r14.headers())).sentRequestAtMillis(r14.sentRequestAtMillis()).receivedResponseAtMillis(r14.receivedResponseAtMillis()).cacheResponse(Companion.access$stripBody(r18, r6)).networkResponse(Companion.access$stripBody(r18, r14)).build();
        ResponseBody r20 = r14.body();
        Intrinsics.c(r20);
        r20.close();
        Cache r21 = this.cache;
        Intrinsics.c(r21);
        r21.trackConditionalCacheHit$okhttp();
        this.cache.update$okhttp(r6, r19);
        r10.cacheHit(r0, r19);
        return r19;
    L51:
        Intrinsics.c(r14);
        Response.Builder r22 = r14.newBuilder();
        Companion r23 = Companion;
        Response r24 = r22.cacheResponse(Companion.access$stripBody(r23, r6)).networkResponse(Companion.access$stripBody(r23, r14)).build();
        if (this.cache != null) goto L54;
    L64:
        return r24;
    L54:
        if (HttpHeaders.promisesBody(r24) == false) goto L62;
        if (CacheStrategy.Companion.isCacheable(r24, r5) == false) goto L62;
        Response r25 = cacheWritingResponse(this.cache.put$okhttp(r24), r24);
        if (r6 == null) goto L60;
        r10.cacheMiss(r0);
    L60:
        return r25;
    L62:
        if (HttpMethod.INSTANCE.invalidatesCache(r5.method()) == false) goto L64;
        this.cache.remove$okhttp(r5);     // Catch: IOException -> L71
    L65:
        th = move-exception;
        if (r3 == null) goto L70;
        ResponseBody r26 = r3.body();
        if (r26 == null) goto L70;
        Util.closeQuietly(r26);
    L70:
        throw th;
    L34:
        if (this.cache == null) goto L74;
        r10.cacheMiss(r0);
    L18:
        r10 = EventListener.NONE;
        goto L19
    L5:
        r3 = null;
        goto L6
    }
}
