package okhttp3.internal.cache;

import com.ss.android.http.legacy.protocol.HTTP;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpHeaders;

/* JADX INFO: loaded from: classes5.dex */
public final class CacheStrategy {

    @Nullable
    public final Response cacheResponse;

    @Nullable
    public final Request networkRequest;

    public static class Factory {
        private int ageSeconds;
        final Response cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        final long nowMillis;
        private long receivedResponseMillis;
        final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(long r4, Request r6, Response r7) {
            this.ageSeconds = -1;
            this.nowMillis = r4;
            this.request = r6;
            this.cacheResponse = r7;
            if (r7 == null) goto L22;
            this.sentRequestMillis = r7.sentRequestAtMillis();
            this.receivedResponseMillis = r7.receivedResponseAtMillis();
            Headers r5 = r7.headers();
            int r8 = r5.size();
            int r9 = 0;
        L5:
            if (r9 >= r8) goto L30;
            String r10 = r5.name(r9);
            String r1 = r5.value(r9);
            if (HTTP.DATE_HEADER.equalsIgnoreCase(r10) == false) goto L10;
            this.servedDate = HttpDate.parse(r1);
            this.servedDateString = r1;
        L21:
            r9 = r9 + 1;
            goto L5
        L10:
            if ("Expires".equalsIgnoreCase(r10) == false) goto L13;
            this.expires = HttpDate.parse(r1);
            goto L21
        L13:
            if ("Last-Modified".equalsIgnoreCase(r10) == false) goto L16;
            this.lastModified = HttpDate.parse(r1);
            this.lastModifiedString = r1;
            goto L21
        L16:
            if ("ETag".equalsIgnoreCase(r10) == false) goto L19;
            this.etag = r1;
            goto L21
        L19:
            if ("Age".equalsIgnoreCase(r10) == false) goto L21;
            this.ageSeconds = HttpHeaders.parseSeconds(r1, -1);
            goto L21
        L30:
            return;
        }

        public CacheStrategy get() {
            CacheStrategy r0 = getCandidate();
            if (r0.networkRequest != null) goto L5;
        L8:
            return r0;
        L5:
            if (this.request.cacheControl().onlyIfCached() == false) goto L8;
            return new CacheStrategy(null, null);
        }

        private CacheStrategy getCandidate() {
            if (this.cacheResponse != null) goto L7;
            return new CacheStrategy(this.request, null);
        L7:
            if (this.request.isHttps() == false) goto L13;
            if (this.cacheResponse.handshake() != null) goto L13;
            return new CacheStrategy(this.request, null);
        L13:
            if (CacheStrategy.isCacheable(this.cacheResponse, this.request) == false) goto L15;
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
            Internal.instance.addLenient(r7, r6, r4);
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

        private long computeFreshnessLifetime() {
            CacheControl r0 = this.cacheResponse.cacheControl();
            if (r0.maxAgeSeconds() == (-1)) goto L7;
            return TimeUnit.SECONDS.toMillis(r0.maxAgeSeconds());
        L7:
            if (this.expires == null) goto L17;
            Date r1 = this.servedDate;
            if (r1 == null) goto L11;
            long r3 = r1.getTime();
        L12:
            long r5 = this.expires.getTime() - r3;
            if (r5 > 0) goto L15;
            return 0;
        L15:
            return r5;
        L11:
            r3 = this.receivedResponseMillis;
            goto L12
        L17:
            if (this.lastModified != null) goto L19;
            return 0;
        L19:
            if (this.cacheResponse.request().url().query() != null) goto L30;
            Date r2 = this.servedDate;
            if (r2 == null) goto L23;
            long r4 = r2.getTime();
        L24:
            long r6 = r4 - this.lastModified.getTime();
            if (r6 > 0) goto L27;
            return 0;
        L27:
            return r6 / 10;
        L23:
            r4 = this.sentRequestMillis;
            goto L24
        L30:
            return 0;
        }

        private long cacheResponseAge() {
            Date r0 = this.servedDate;
            long r1 = 0;
            if (r0 == null) goto L6;
            r1 = Math.max(0, this.receivedResponseMillis - r0.getTime());
        L6:
            if (this.ageSeconds == (-1)) goto L8;
            r1 = Math.max(r1, TimeUnit.SECONDS.toMillis(this.ageSeconds));
        L8:
            long r3 = this.receivedResponseMillis;
            return (r1 + (r3 - this.sentRequestMillis)) + (this.nowMillis - r3);
        }

        private boolean isFreshnessLifetimeHeuristic() {
            if (this.cacheResponse.cacheControl().maxAgeSeconds() == (-1)) goto L5;
        L7:
            return false;
        L5:
            if (this.expires != null) goto L7;
            return true;
        }

        private static boolean hasConditions(Request r1) {
            if (r1.header("If-Modified-Since") == null) goto L5;
        L8:
            return true;
        L5:
            if (r1.header("If-None-Match") != null) goto L8;
            return false;
        }
    }

    CacheStrategy(Request r1, Response r2) {
        this.networkRequest = r1;
        this.cacheResponse = r2;
    }

    public static boolean isCacheable(Response r3, Request r4) {
        int r0 = r3.code();
        if (r0 == 200) goto L35;
        if (r0 == 410) goto L35;
        if (r0 == 414) goto L35;
        if (r0 == 501) goto L35;
        if (r0 == 203) goto L35;
        if (r0 == 204) goto L35;
        if (r0 == 307) goto L25;
        if (r0 == 308) goto L35;
        if (r0 == 404) goto L35;
        if (r0 == 405) goto L35;
        switch(r0) {
            case 300: goto L35;
            case 301: goto L35;
            case 302: goto L25;
            default: goto L33;
        };
    L33:
        return false;
    L25:
        if (r3.header("Expires") != null) goto L35;
        if (r3.cacheControl().maxAgeSeconds() != (-1)) goto L35;
        if (r3.cacheControl().isPublic() == true) goto L35;
        if (r3.cacheControl().isPrivate() == false) goto L33;
    L35:
        if (r3.cacheControl().noStore() == false) goto L37;
        return false;
    L37:
        if (r4.cacheControl().noStore() == true) goto L41;
        return true;
    L41:
        return false;
    }
}
