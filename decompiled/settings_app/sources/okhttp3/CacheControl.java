package okhttp3;

import com.android.settings.search.IndexDatabaseHelper;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: CacheControl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 !2\u00020\u0001:\u0002 !Bq\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\r\u0010\u000f\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0015J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0016J\r\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0017J\r\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0018J\r\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0019J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001aJ\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001bJ\r\u0010\u000e\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001cJ\r\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001dJ\r\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001eJ\b\u0010\u001f\u001a\u00020\u0011H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0014R\u0013\u0010\f\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0014R\u0013\u0010\n\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0013\u0010\u000e\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0013R\u0013\u0010\r\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0013R\u0013\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014¨\u0006\""}, d2 = {"Lokhttp3/CacheControl;", "", "noCache", "", "noStore", "maxAgeSeconds", "", "sMaxAgeSeconds", "isPrivate", "isPublic", "mustRevalidate", "maxStaleSeconds", "minFreshSeconds", "onlyIfCached", "noTransform", "immutable", "headerValue", "", "(ZZIIZZZIIZZZLjava/lang/String;)V", "()Z", "()I", "-deprecated_immutable", "-deprecated_maxAgeSeconds", "-deprecated_maxStaleSeconds", "-deprecated_minFreshSeconds", "-deprecated_mustRevalidate", "-deprecated_noCache", "-deprecated_noStore", "-deprecated_noTransform", "-deprecated_onlyIfCached", "-deprecated_sMaxAgeSeconds", "toString", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CacheControl {
    public static final Companion Companion = null;
    public static final CacheControl FORCE_CACHE = null;
    public static final CacheControl FORCE_NETWORK = null;
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    /* JADX INFO: compiled from: CacheControl.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0003\u001a\u00020\u0000J\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\t\u001a\u00020\u0000J\u0006\u0010\n\u001a\u00020\u0000J\u0006\u0010\u000b\u001a\u00020\u0000J\u0006\u0010\f\u001a\u00020\u0000J\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/CacheControl$Builder;", "", "()V", "immutable", "", "maxAgeSeconds", "", "maxStaleSeconds", "minFreshSeconds", "noCache", "noStore", "noTransform", "onlyIfCached", IndexDatabaseHelper.MetaColumns.BUILD, "Lokhttp3/CacheControl;", "maxAge", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "maxStale", "minFresh", "clampToInt", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds;
        private int maxStaleSeconds;
        private int minFreshSeconds;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        private final int clampToInt(long r3) {
            if (r3 <= 2147483647L) goto L6;
            return Integer.MAX_VALUE;
        L6:
            return (int) r3;
        }

        public Builder() {
            this.maxAgeSeconds = -1;
            this.maxStaleSeconds = -1;
            this.minFreshSeconds = -1;
        }

        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        public final Builder maxAge(int r3, TimeUnit r4) {
            Intrinsics.checkNotNullParameter(r4, "timeUnit");
            if (r3 < 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.maxAgeSeconds = clampToInt(r4.toSeconds(r3));
            return this;
        L10:
            throw new IllegalArgumentException(Intrinsics.stringPlus("maxAge < 0: ", Integer.valueOf(r3)).toString());
        L5:
            r0 = false;
            goto L6
        }

        public final Builder maxStale(int r3, TimeUnit r4) {
            Intrinsics.checkNotNullParameter(r4, "timeUnit");
            if (r3 < 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.maxStaleSeconds = clampToInt(r4.toSeconds(r3));
            return this;
        L10:
            throw new IllegalArgumentException(Intrinsics.stringPlus("maxStale < 0: ", Integer.valueOf(r3)).toString());
        L5:
            r0 = false;
            goto L6
        }

        public final Builder minFresh(int r3, TimeUnit r4) {
            Intrinsics.checkNotNullParameter(r4, "timeUnit");
            if (r3 < 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.minFreshSeconds = clampToInt(r4.toSeconds(r3));
            return this;
        L10:
            throw new IllegalArgumentException(Intrinsics.stringPlus("minFresh < 0: ", Integer.valueOf(r3)).toString());
        L5:
            r0 = false;
            goto L6
        }

        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }

        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }
    }

    /* JADX INFO: compiled from: CacheControl.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001e\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/CacheControl$Companion;", "", "()V", "FORCE_CACHE", "Lokhttp3/CacheControl;", "FORCE_NETWORK", "parse", "headers", "Lokhttp3/Headers;", "indexOfElement", "", "", "characters", "startIndex", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CacheControl parse(Headers r31) {
            Headers r1 = r31;
            Intrinsics.checkNotNullParameter(r1, "headers");
            int r2 = r31.size();
            boolean r5 = true;
            boolean r8 = true;
            int r7 = 0;
            String r9 = null;
            boolean r10 = false;
            boolean r11 = false;
            int r12 = -1;
            int r13 = -1;
            boolean r14 = false;
            boolean r15 = false;
            boolean r16 = false;
            int r17 = -1;
            int r18 = -1;
            boolean r19 = false;
            boolean r20 = false;
            boolean r21 = false;
        L3:
            if (r7 >= r2) goto L67;
            int r22 = r7 + 1;
            String r3 = r1.name(r7);
            String r23 = r1.value(r7);
            if (StringsKt.equals(r3, "Cache-Control", r5) == false) goto L10;
            if (r9 != null) goto L11;
            r9 = r23;
        L12:
            int r4 = 0;
        L14:
            if (r4 >= r23.length()) goto L66;
            int r6 = indexOfElement(r23, "=,;", r4);
            String r24 = r23.substring(r4, r6);
            Intrinsics.checkNotNullExpressionValue(r24, "this as java.lang.String…ing(startIndex, endIndex)");
            String r25 = StringsKt.trim(r24).toString();
            if (r6 != r23.length()) goto L18;
        L28:
            r4 = r6 + 1;
            String r26 = null;
        L30:
            if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_NO_CACHE, r25, true) == true) goto L31;
            if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_NO_STORE, r25, true) == true) goto L34;
            if (StringsKt.equals("max-age", r25, true) == true) goto L37;
            if (StringsKt.equals("s-maxage", r25, true) == true) goto L41;
            if (StringsKt.equals(HeaderConstants.PRIVATE, r25, true) == false) goto L46;
            r5 = true;
            r14 = true;
            goto L14
        L46:
            if (StringsKt.equals(HeaderConstants.PUBLIC, r25, true) == false) goto L49;
            r5 = true;
            r15 = true;
            goto L14
        L49:
            if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE, r25, true) == false) goto L52;
            r5 = true;
            r16 = true;
            goto L14
        L52:
            if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_MAX_STALE, r25, true) == true) goto L53;
            if (StringsKt.equals(HeaderConstants.CACHE_CONTROL_MIN_FRESH, r25, true) == true) goto L56;
            if (StringsKt.equals("only-if-cached", r25, true) == false) goto L61;
            r5 = true;
            r19 = true;
            goto L14
        L61:
            if (StringsKt.equals("no-transform", r25, true) == false) goto L64;
            r5 = true;
            r20 = true;
            goto L14
        L64:
            if (StringsKt.equals("immutable", r25, true) == false) goto L38;
            r5 = true;
            r21 = true;
        L38:
            r5 = true;
            goto L14
        L56:
            r18 = Util.toNonNegativeInt(r26, -1);
            goto L38
        L53:
            r17 = Util.toNonNegativeInt(r26, Integer.MAX_VALUE);
            goto L38
        L41:
            r13 = Util.toNonNegativeInt(r26, -1);
            goto L38
        L37:
            r12 = Util.toNonNegativeInt(r26, -1);
            goto L38
        L34:
            r5 = true;
            r11 = true;
            goto L14
        L31:
            r5 = true;
            r10 = true;
            goto L14
        L18:
            if (r23.charAt(r6) == ',') goto L28;
            if (r23.charAt(r6) == ';') goto L28;
            int r27 = Util.indexOfNonWhitespace(r23, r6 + 1);
            if (r27 < r23.length()) goto L25;
        L27:
            r4 = indexOfElement(r23, ",;", r27);
            String r28 = r23.substring(r27, r4);
            Intrinsics.checkNotNullExpressionValue(r28, "this as java.lang.String…ing(startIndex, endIndex)");
            r26 = StringsKt.trim(r28).toString();
            goto L30
        L25:
            if (r23.charAt(r27) != '\"') goto L27;
            int r29 = r27 + 1;
            int r30 = StringsKt.indexOf$default(r23, '\"', r29, false, 4, null);
            r26 = r23.substring(r29, r30);
            Intrinsics.checkNotNullExpressionValue(r26, "this as java.lang.String…ing(startIndex, endIndex)");
            r4 = r30 + 1;
        L66:
            r1 = r31;
            r7 = r22;
        L11:
            r8 = false;
            goto L12
        L10:
            if (StringsKt.equals(r3, "Pragma", r5) == false) goto L66;
        L67:
            if (r8 == true) goto L69;
            String r210 = null;
        L71:
            return new CacheControl(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r210, null);
        L69:
            r210 = r9;
            goto L71
        }

        static /* synthetic */ int indexOfElement$default(Companion r0, String r1, String r2, int r3, int r4, Object r5) {
            if ((r4 & 2) == 0) goto L6;
            r3 = 0;
        L6:
            return r0.indexOfElement(r1, r2, r3);
        }

        private final int indexOfElement(String r7, String r8, int r9) {
            int r6 = r7.length();
        L3:
            if (r9 >= r6) goto L9;
            int r0 = r9 + 1;
            if (StringsKt.contains$default(r8, r7.charAt(r9), false, 2, null) == true) goto L6;
            r9 = r0;
            goto L3
        L6:
            return r9;
        L9:
            return r7.length();
        }
    }

    public /* synthetic */ CacheControl(boolean r1, boolean r2, int r3, int r4, boolean r5, boolean r6, boolean r7, int r8, int r9, boolean r10, boolean r11, boolean r12, String r13, DefaultConstructorMarker r14) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    @JvmStatic
    public static final CacheControl parse(Headers r1) {
        return Companion.parse(r1);
    }

    private CacheControl(boolean r1, boolean r2, int r3, int r4, boolean r5, boolean r6, boolean r7, int r8, int r9, boolean r10, boolean r11, boolean r12, String r13) {
        this.noCache = r1;
        this.noStore = r2;
        this.maxAgeSeconds = r3;
        this.sMaxAgeSeconds = r4;
        this.isPrivate = r5;
        this.isPublic = r6;
        this.mustRevalidate = r7;
        this.maxStaleSeconds = r8;
        this.minFreshSeconds = r9;
        this.onlyIfCached = r10;
        this.noTransform = r11;
        this.immutable = r12;
        this.headerValue = r13;
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noCache", imports = {}))
    /* JADX INFO: renamed from: -deprecated_noCache, reason: not valid java name */
    public final boolean m3104deprecated_noCache() {
        return this.noCache;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noStore", imports = {}))
    /* JADX INFO: renamed from: -deprecated_noStore, reason: not valid java name */
    public final boolean m3105deprecated_noStore() {
        return this.noStore;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxAgeSeconds", imports = {}))
    /* JADX INFO: renamed from: -deprecated_maxAgeSeconds, reason: not valid java name */
    public final int m3100deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sMaxAgeSeconds", imports = {}))
    /* JADX INFO: renamed from: -deprecated_sMaxAgeSeconds, reason: not valid java name */
    public final int m3108deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "mustRevalidate", imports = {}))
    /* JADX INFO: renamed from: -deprecated_mustRevalidate, reason: not valid java name */
    public final boolean m3103deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxStaleSeconds", imports = {}))
    /* JADX INFO: renamed from: -deprecated_maxStaleSeconds, reason: not valid java name */
    public final int m3101deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "minFreshSeconds", imports = {}))
    /* JADX INFO: renamed from: -deprecated_minFreshSeconds, reason: not valid java name */
    public final int m3102deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "onlyIfCached", imports = {}))
    /* JADX INFO: renamed from: -deprecated_onlyIfCached, reason: not valid java name */
    public final boolean m3107deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noTransform", imports = {}))
    /* JADX INFO: renamed from: -deprecated_noTransform, reason: not valid java name */
    public final boolean m3106deprecated_noTransform() {
        return this.noTransform;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "immutable", imports = {}))
    /* JADX INFO: renamed from: -deprecated_immutable, reason: not valid java name */
    public final boolean m3099deprecated_immutable() {
        return this.immutable;
    }

    public String toString() {
        String r0 = this.headerValue;
        if (r0 != null) goto L49;
        StringBuilder r1 = new StringBuilder();
        if (noCache() == false) goto L8;
        r1.append("no-cache, ");
    L8:
        if (noStore() == false) goto L11;
        r1.append("no-store, ");
    L11:
        if (maxAgeSeconds() == (-1)) goto L14;
        r1.append("max-age=").append(maxAgeSeconds()).append(", ");
    L14:
        if (sMaxAgeSeconds() == (-1)) goto L17;
        r1.append("s-maxage=").append(sMaxAgeSeconds()).append(", ");
    L17:
        if (isPrivate() == false) goto L20;
        r1.append("private, ");
    L20:
        if (isPublic() == false) goto L23;
        r1.append("public, ");
    L23:
        if (mustRevalidate() == false) goto L26;
        r1.append("must-revalidate, ");
    L26:
        if (maxStaleSeconds() == (-1)) goto L29;
        r1.append("max-stale=").append(maxStaleSeconds()).append(", ");
    L29:
        if (minFreshSeconds() == (-1)) goto L32;
        r1.append("min-fresh=").append(minFreshSeconds()).append(", ");
    L32:
        if (onlyIfCached() == false) goto L35;
        r1.append("only-if-cached, ");
    L35:
        if (noTransform() == false) goto L38;
        r1.append("no-transform, ");
    L38:
        if (immutable() == false) goto L41;
        r1.append("immutable, ");
    L41:
        if (r1.length() != 0) goto L43;
        boolean r2 = true;
    L44:
        if (r2 == false) goto L47;
        return "";
    L47:
        r1.delete(r1.length() - 2, r1.length());
        String r3 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r3, "StringBuilder().apply(builderAction).toString()");
        this.headerValue = r3;
        return r3;
    L43:
        r2 = false;
        goto L44
    L49:
        return r0;
    }

    static {
        Companion = new Companion(null);
        FORCE_NETWORK = new Builder().noCache().build();
        FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    }
}
