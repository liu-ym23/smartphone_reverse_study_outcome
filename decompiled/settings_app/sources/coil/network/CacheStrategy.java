package coil.network;

import coil.util.Time;
import coil.util.Utils;
import com.android.settings.ApnEditor;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.obric.capabilitykit.common.Ext;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import cz.msebera.android.httpclient.cookie.ClientCookie;
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

/* JADX INFO: compiled from: CacheStrategy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcoil/network/CacheStrategy;", "", "networkRequest", "Lokhttp3/Request;", "cacheResponse", "Lcoil/network/CacheResponse;", "(Lokhttp3/Request;Lcoil/network/CacheResponse;)V", "getCacheResponse", "()Lcoil/network/CacheResponse;", "getNetworkRequest", "()Lokhttp3/Request;", "Companion", "Factory", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CacheStrategy {
    public static final Companion Companion = null;
    private final CacheResponse cacheResponse;
    private final Request networkRequest;

    /* JADX INFO: compiled from: CacheStrategy.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0012"}, d2 = {"Lcoil/network/CacheStrategy$Companion;", "", "()V", "combineHeaders", "Lokhttp3/Headers;", "cachedHeaders", "networkHeaders", "isCacheable", "", Ext.KEY_REQUEST, "Lokhttp3/Request;", ApmTrafficStats.TTNET_RESPONSE, "Lcoil/network/CacheResponse;", "Lokhttp3/Response;", "isContentSpecificHeader", "name", "", "isEndToEnd", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final boolean isCacheable(Request r1, Response r2) {
            if (r1.cacheControl().noStore() == false) goto L5;
        L9:
            return false;
        L5:
            if (r2.cacheControl().noStore() == true) goto L9;
            if (Intrinsics.areEqual(r2.headers().get("Vary"), ApnEditor.APN_TYPE_ALL) == true) goto L9;
            return true;
        }

        public final boolean isCacheable(Request r1, CacheResponse r2) {
            if (r1.cacheControl().noStore() == false) goto L5;
        L9:
            return false;
        L5:
            if (r2.getCacheControl().noStore() == true) goto L9;
            if (Intrinsics.areEqual(r2.getResponseHeaders().get("Vary"), ApnEditor.APN_TYPE_ALL) == true) goto L9;
            return true;
        }

        public final Headers combineHeaders(Headers r10, Headers r11) {
            Headers.Builder r0 = new Headers.Builder();
            int r1 = r10.size();
            int r2 = 0;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L17;
            String r4 = r10.name(r3);
            String r5 = r10.value(r3);
            if (StringsKt.equals("Warning", r4, true) == false) goto L10;
            if (StringsKt.startsWith$default(r5, "1", false, 2, null) == false) goto L10;
        L16:
            r3 = r3 + 1;
        L10:
            if (isContentSpecificHeader(r4) == false) goto L12;
        L15:
            r0.add(r4, r5);
            goto L16
        L12:
            if (isEndToEnd(r4) == false) goto L15;
            if (r11.get(r4) != null) goto L16;
        L17:
            int r12 = r11.size();
        L18:
            if (r2 >= r12) goto L26;
            String r6 = r11.name(r2);
            if (isContentSpecificHeader(r6) == true) goto L24;
            if (isEndToEnd(r6) == false) goto L24;
            r0.add(r6, r11.value(r2));
        L24:
            r2 = r2 + 1;
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

    /* JADX INFO: compiled from: CacheStrategy.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcoil/network/CacheStrategy$Factory;", "", Ext.KEY_REQUEST, "Lokhttp3/Request;", "cacheResponse", "Lcoil/network/CacheResponse;", "(Lokhttp3/Request;Lcoil/network/CacheResponse;)V", "ageSeconds", "", URLDispatch.KEY_ETAG, "", ClientCookie.EXPIRES_ATTR, "Ljava/util/Date;", "lastModified", "lastModifiedString", "receivedResponseMillis", "", "sentRequestMillis", "servedDate", "servedDateString", "cacheResponseAge", "compute", "Lcoil/network/CacheStrategy;", "computeFreshnessLifetime", "hasConditions", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Factory {
        private int ageSeconds;
        private final CacheResponse cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        private long receivedResponseMillis;
        private final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(Request r7, CacheResponse r8) {
            this.request = r7;
            this.cacheResponse = r8;
            this.ageSeconds = -1;
            if (r8 == null) goto L22;
            this.sentRequestMillis = r8.getSentRequestAtMillis();
            this.receivedResponseMillis = r8.getReceivedResponseAtMillis();
            Headers r9 = r8.getResponseHeaders();
            int r0 = r9.size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L30;
            String r2 = r9.name(r1);
            if (StringsKt.equals(r2, "Date", true) == false) goto L10;
            this.servedDate = r9.getDate("Date");
            this.servedDateString = r9.value(r1);
        L21:
            r1 = r1 + 1;
            goto L5
        L10:
            if (StringsKt.equals(r2, "Expires", true) == false) goto L13;
            this.expires = r9.getDate("Expires");
            goto L21
        L13:
            if (StringsKt.equals(r2, "Last-Modified", true) == false) goto L16;
            this.lastModified = r9.getDate("Last-Modified");
            this.lastModifiedString = r9.value(r1);
            goto L21
        L16:
            if (StringsKt.equals(r2, "ETag", true) == false) goto L19;
            this.etag = r9.value(r1);
            goto L21
        L19:
            if (StringsKt.equals(r2, "Age", true) == false) goto L21;
            this.ageSeconds = Utils.toNonNegativeInt(r9.value(r1), -1);
            goto L21
        L30:
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final CacheStrategy compute() {
            CacheResponse r1 = null;
            Object[] r2 = 0;
            Object[] r3 = 0;
            Object[] r4 = 0;
            Object[] r5 = 0;
            Object[] r6 = 0;
            Object[] r7 = 0;
            Object[] r8 = 0;
            Object[] r9 = 0;
            Object[] r10 = 0;
            Object[] r11 = 0;
            Object[] r12 = 0;
            Object[] r13 = 0;
            if (this.cacheResponse != null) goto L7;
            return new CacheStrategy(this.request, r1, r13 == true ? 1 : 0);
        L7:
            if (this.request.isHttps() == true) goto L9;
        L12:
            CacheControl r0 = this.cacheResponse.getCacheControl();
            if (CacheStrategy.Companion.isCacheable(this.request, this.cacheResponse) == false) goto L15;
            CacheControl r14 = this.request.cacheControl();
            if (r14.noCache() == true) goto L53;
            if (hasConditions(this.request) == true) goto L53;
            long r15 = cacheResponseAge();
            long r16 = computeFreshnessLifetime();
            if (r14.maxAgeSeconds() == (-1)) goto L24;
            r16 = Math.min(r16, TimeUnit.SECONDS.toMillis(r14.maxAgeSeconds()));
        L24:
            long r17 = 0;
            if (r14.minFreshSeconds() == (-1)) goto L27;
            long r18 = TimeUnit.SECONDS.toMillis(r14.minFreshSeconds());
        L29:
            if (r0.mustRevalidate() == true) goto L34;
            if (r14.maxStaleSeconds() == (-1)) goto L34;
            r17 = TimeUnit.SECONDS.toMillis(r14.maxStaleSeconds());
        L34:
            if (r0.noCache() == false) goto L36;
        L39:
            String r19 = this.etag;
            if (r19 == null) goto L42;
            Intrinsics.checkNotNull(r19);
            String r20 = "If-None-Match";
        L49:
            return new CacheStrategy(this.request.newBuilder().addHeader(r20, r19).build(), this.cacheResponse, r6 == true ? 1 : 0);
        L42:
            r20 = "If-Modified-Since";
            if (this.lastModified == null) goto L46;
            r19 = this.lastModifiedString;
            Intrinsics.checkNotNull(r19);
            goto L49
        L46:
            if (this.servedDate == null) goto L51;
            r19 = this.servedDateString;
            Intrinsics.checkNotNull(r19);
            goto L49
        L51:
            return new CacheStrategy(this.request, r5 == true ? 1 : 0, r4 == true ? 1 : 0);
        L36:
            if ((r15 + r18) >= (r16 + r17)) goto L39;
            return new CacheStrategy(r8 == true ? 1 : 0, this.cacheResponse, r7 == true ? 1 : 0);
        L27:
            r18 = 0;
        L53:
            return new CacheStrategy(this.request, r3 == true ? 1 : 0, r2 == true ? 1 : 0);
        L15:
            return new CacheStrategy(this.request, r10 == true ? 1 : 0, r9 == true ? 1 : 0);
        L9:
            if (this.cacheResponse.isTls() == true) goto L12;
            return new CacheStrategy(this.request, r12 == true ? 1 : 0, r11 == true ? 1 : 0);
        }

        private final long computeFreshnessLifetime() {
            CacheResponse r0 = this.cacheResponse;
            Intrinsics.checkNotNull(r0);
            CacheControl r1 = r0.getCacheControl();
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
            if (this.request.url().query() != null) goto L30;
            Date r6 = this.servedDate;
            if (r6 == null) goto L23;
            long r7 = r6.getTime();
        L24:
            Date r8 = this.lastModified;
            Intrinsics.checkNotNull(r8);
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

        private final long cacheResponseAge() {
            Date r0 = this.servedDate;
            long r1 = 0;
            if (r0 == null) goto L6;
            r1 = Math.max(0, this.receivedResponseMillis - r0.getTime());
        L6:
            if (this.ageSeconds == (-1)) goto L9;
            r1 = Math.max(r1, TimeUnit.SECONDS.toMillis(this.ageSeconds));
        L9:
            return (r1 + (this.receivedResponseMillis - this.sentRequestMillis)) + (Time.INSTANCE.currentMillis() - this.receivedResponseMillis);
        }

        private final boolean hasConditions(Request r1) {
            if (r1.header("If-Modified-Since") == null) goto L5;
        L8:
            return true;
        L5:
            if (r1.header("If-None-Match") != null) goto L8;
            return false;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ CacheStrategy(Request r1, CacheResponse r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    private CacheStrategy(Request r1, CacheResponse r2) {
        this.networkRequest = r1;
        this.cacheResponse = r2;
    }

    public final Request getNetworkRequest() {
        return this.networkRequest;
    }

    public final CacheResponse getCacheResponse() {
        return this.cacheResponse;
    }
}
