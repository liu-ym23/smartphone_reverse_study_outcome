package okhttp3.internal.cache;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.ss.android.http.legacy.protocol.HTTP;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CacheStrategy {
    public static final Companion Companion = null;

    @Nullable
    private final Response cacheResponse;

    @Nullable
    private final Request networkRequest;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final boolean isCacheable(@NotNull Response r4, @NotNull Request r5) {
            Intrinsics.f(r4, ApmTrafficStats.TTNET_RESPONSE);
            Intrinsics.f(r5, "request");
            int r3 = r4.code();
            if (r3 == 200) goto L34;
            if (r3 == 410) goto L34;
            if (r3 == 414) goto L34;
            if (r3 == 501) goto L34;
            if (r3 == 203) goto L34;
            if (r3 == 204) goto L34;
            if (r3 == 307) goto L25;
            if (r3 == 308) goto L34;
            if (r3 == 404) goto L34;
            if (r3 == 405) goto L34;
            switch(r3) {
                case 300: goto L34;
                case 301: goto L34;
                case 302: goto L25;
                default: goto L23;
            };
        L23:
            return false;
        L25:
            if (Response.header$default(r4, "Expires", null, 2, null) != null) goto L34;
            if (r4.cacheControl().maxAgeSeconds() != (-1)) goto L34;
            if (r4.cacheControl().isPublic() == true) goto L34;
            if (r4.cacheControl().isPrivate() == true) goto L34;
            return false;
        L34:
            if (r4.cacheControl().noStore() == false) goto L36;
            return false;
        L36:
            if (r5.cacheControl().noStore() == true) goto L40;
            return true;
        L40:
            return false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public static final class Factory {
        private int ageSeconds;
        private final Response cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        private final long nowMillis;
        private long receivedResponseMillis;

        @NotNull
        private final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(long r5, @NotNull Request r7, @Nullable Response r8) {
            Intrinsics.f(r7, "request");
            this.nowMillis = r5;
            this.request = r7;
            this.cacheResponse = r8;
            this.ageSeconds = -1;
            if (r8 == null) goto L22;
            this.sentRequestMillis = r8.sentRequestAtMillis();
            this.receivedResponseMillis = r8.receivedResponseAtMillis();
            Headers r6 = r8.headers();
            int r9 = r6.size();
            int r10 = 0;
        L5:
            if (r10 >= r9) goto L30;
            String r0 = r6.name(r10);
            String r1 = r6.value(r10);
            if (StringsKt.p(r0, HTTP.DATE_HEADER, true) == false) goto L10;
            this.servedDate = DatesKt.toHttpDateOrNull(r1);
            this.servedDateString = r1;
        L21:
            r10 = r10 + 1;
            goto L5
        L10:
            if (StringsKt.p(r0, "Expires", true) == false) goto L13;
            this.expires = DatesKt.toHttpDateOrNull(r1);
            goto L21
        L13:
            if (StringsKt.p(r0, "Last-Modified", true) == false) goto L16;
            this.lastModified = DatesKt.toHttpDateOrNull(r1);
            this.lastModifiedString = r1;
            goto L21
        L16:
            if (StringsKt.p(r0, "ETag", true) == false) goto L19;
            this.etag = r1;
            goto L21
        L19:
            if (StringsKt.p(r0, "Age", true) == false) goto L21;
            this.ageSeconds = Util.toNonNegativeInt(r1, -1);
            goto L21
        L30:
            return;
        }

        private final long cacheResponseAge() {
            Date r0 = this.servedDate;
            long r1 = 0;
            if (r0 == null) goto L5;
            r1 = Math.max(0, this.receivedResponseMillis - r0.getTime());
        L5:
            int r2 = this.ageSeconds;
            if (r2 == (-1)) goto L8;
            r1 = Math.max(r1, TimeUnit.SECONDS.toMillis(r2));
        L8:
            long r3 = this.receivedResponseMillis;
            return (r1 + (r3 - this.sentRequestMillis)) + (this.nowMillis - r3);
        }

        private final CacheStrategy computeCandidate() {
            if (this.cacheResponse != null) goto L7;
            return new CacheStrategy(this.request, null);
        L7:
            if (this.request.isHttps() == false) goto L13;
            if (this.cacheResponse.handshake() != null) goto L13;
            return new CacheStrategy(this.request, null);
        L13:
            if (CacheStrategy.Companion.isCacheable(this.cacheResponse, this.request) == false) goto L15;
            CacheControl r0 = this.request.cacheControl();
            if (r0.noCache() == true) goto L62;
            if (hasConditions(this.request) == true) goto L62;
            CacheControl r2 = this.cacheResponse.cacheControl();
            long r3 = cacheResponseAge();
            long r5 = computeFreshnessLifetime();
            if (r0.maxAgeSeconds() == (-1)) goto L24;
            r5 = Math.min(r5, TimeUnit.SECONDS.toMillis(r0.maxAgeSeconds()));
        L24:
            long r9 = 0;
            if (r0.minFreshSeconds() == (-1)) goto L27;
            long r11 = TimeUnit.SECONDS.toMillis(r0.minFreshSeconds());
        L29:
            if (r2.mustRevalidate() == true) goto L34;
            if (r0.maxStaleSeconds() == (-1)) goto L34;
            r9 = TimeUnit.SECONDS.toMillis(r0.maxStaleSeconds());
        L34:
            if (r2.noCache() == true) goto L47;
            long r12 = r11 + r3;
            if (r12 >= (r9 + r5)) goto L47;
            Response.Builder r1 = this.cacheResponse.newBuilder();
            if (r12 < r5) goto L41;
            r1.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
        L41:
            if (r3 <= 86400000) goto L46;
            if (isFreshnessLifetimeHeuristic() == false) goto L46;
            r1.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
        L46:
            return new CacheStrategy(null, r1.build());
        L47:
            String r4 = this.etag;
            if (r4 == null) goto L51;
            String r6 = "If-None-Match";
        L57:
            Headers.Builder r7 = this.request.headers().newBuilder();
            Intrinsics.c(r4);
            r7.addLenient$okhttp(r6, r4);
            return new CacheStrategy(this.request.newBuilder().headers(r7.build()).build(), this.cacheResponse);
        L51:
            if (this.lastModified == null) goto L55;
            r4 = this.lastModifiedString;
        L53:
            r6 = "If-Modified-Since";
            goto L57
        L55:
            if (this.servedDate == null) goto L60;
            r4 = this.servedDateString;
            goto L53
        L60:
            return new CacheStrategy(this.request, null);
        L27:
            r11 = 0;
        L62:
            return new CacheStrategy(this.request, null);
        L15:
            return new CacheStrategy(this.request, null);
        }

        private final long computeFreshnessLifetime() {
            Response r0 = this.cacheResponse;
            Intrinsics.c(r0);
            CacheControl r1 = r0.cacheControl();
            if (r1.maxAgeSeconds() != (-1)) goto L5;
            Date r2 = this.expires;
            if (r2 == null) goto L17;
            Date r3 = this.servedDate;
            if (r3 == null) goto L11;
            long r4 = r3.getTime();
        L12:
            long r5 = r2.getTime() - r4;
            if (r5 > 0) goto L15;
            return 0;
        L15:
            return r5;
        L11:
            r4 = this.receivedResponseMillis;
            goto L12
        L17:
            if (this.lastModified != null) goto L19;
            return 0;
        L19:
            if (this.cacheResponse.request().url().query() != null) goto L30;
            Date r6 = this.servedDate;
            if (r6 == null) goto L23;
            long r7 = r6.getTime();
        L24:
            Date r8 = this.lastModified;
            Intrinsics.c(r8);
            long r9 = r7 - r8.getTime();
            if (r9 > 0) goto L27;
            return 0;
        L27:
            return r9 / ((long) 10);
        L23:
            r7 = this.sentRequestMillis;
            goto L24
        L30:
            return 0;
        L5:
            return TimeUnit.SECONDS.toMillis(r1.maxAgeSeconds());
        }

        private final boolean hasConditions(Request r1) {
            if (r1.header("If-Modified-Since") == null) goto L5;
        L8:
            return true;
        L5:
            if (r1.header("If-None-Match") != null) goto L8;
            return false;
        }

        private final boolean isFreshnessLifetimeHeuristic() {
            Response r0 = this.cacheResponse;
            Intrinsics.c(r0);
            if (r0.cacheControl().maxAgeSeconds() == (-1)) goto L5;
        L7:
            return false;
        L5:
            if (this.expires != null) goto L7;
            return true;
        }

        @NotNull
        public final CacheStrategy compute() {
            CacheStrategy r0 = computeCandidate();
            if (r0.getNetworkRequest() != null) goto L5;
        L8:
            return r0;
        L5:
            if (this.request.cacheControl().onlyIfCached() == false) goto L8;
            return new CacheStrategy(null, null);
        }

        @NotNull
        public final Request getRequest$okhttp() {
            return this.request;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CacheStrategy(@Nullable Request r1, @Nullable Response r2) {
        this.networkRequest = r1;
        this.cacheResponse = r2;
    }

    @Nullable
    public final Response getCacheResponse() {
        return this.cacheResponse;
    }

    @Nullable
    public final Request getNetworkRequest() {
        return this.networkRequest;
    }
}
