package okhttp3;

import a.a;
import androidx.appcompat.widget.ActivityChooserView;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CacheControl {
    public static final Companion Companion = null;

    @JvmField
    @NotNull
    public static final CacheControl FORCE_CACHE = null;

    @JvmField
    @NotNull
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

    @Metadata
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds;
        private int maxStaleSeconds;
        private int minFreshSeconds;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        public Builder() {
            this.maxAgeSeconds = -1;
            this.maxStaleSeconds = -1;
            this.minFreshSeconds = -1;
        }

        private final int clampToInt(long r3) {
            if (r3 <= ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) goto L6;
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        L6:
            return (int) r3;
        }

        @NotNull
        public final CacheControl build() {
            int r4 = -1;
            boolean r5 = false;
            boolean r6 = false;
            boolean r7 = false;
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, r4, r5, r6, r7, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }

        @NotNull
        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        @NotNull
        public final Builder maxAge(int r3, @NotNull TimeUnit r4) {
            Intrinsics.f(r4, "timeUnit");
            if (r3 < 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.maxAgeSeconds = clampToInt(r4.toSeconds(r3));
            return this;
        L10:
            throw new IllegalArgumentException(a.e(r3, "maxAge < 0: ").toString());
        L5:
            r0 = false;
            goto L6
        }

        @NotNull
        public final Builder maxStale(int r3, @NotNull TimeUnit r4) {
            Intrinsics.f(r4, "timeUnit");
            if (r3 < 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.maxStaleSeconds = clampToInt(r4.toSeconds(r3));
            return this;
        L10:
            throw new IllegalArgumentException(a.e(r3, "maxStale < 0: ").toString());
        L5:
            r0 = false;
            goto L6
        }

        @NotNull
        public final Builder minFresh(int r3, @NotNull TimeUnit r4) {
            Intrinsics.f(r4, "timeUnit");
            if (r3 < 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.minFreshSeconds = clampToInt(r4.toSeconds(r3));
            return this;
        L10:
            throw new IllegalArgumentException(a.e(r3, "minFresh < 0: ").toString());
        L5:
            r0 = false;
            goto L6
        }

        @NotNull
        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        @NotNull
        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        @NotNull
        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        @NotNull
        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final int indexOfElement(String r2, String r3, int r4) {
            int r1 = r2.length();
        L3:
            if (r4 >= r1) goto L9;
            if (StringsKt.n(r3, r2.charAt(r4)) == true) goto L6;
            r4 = r4 + 1;
            goto L3
        L6:
            return r4;
        L9:
            return r2.length();
        }

        public static /* synthetic */ int indexOfElement$default(Companion r0, String r1, String r2, int r3, int r4, Object r5) {
            if ((r4 & 2) == 0) goto L6;
            r3 = 0;
        L6:
            return r0.indexOfElement(r1, r2, r3);
        }

        @JvmStatic
        @NotNull
        public final CacheControl parse(@NotNull Headers r28) {
            Headers r1 = r28;
            Intrinsics.f(r1, "headers");
            int r2 = r28.size();
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
            if (r7 >= r2) goto L71;
            String r6 = r1.name(r7);
            String r4 = r1.value(r7);
            if (StringsKt.p(r6, "Cache-Control", r5) == false) goto L10;
            if (r9 == null) goto L8;
        L7:
            r8 = false;
        L12:
            int r3 = 0;
        L14:
            if (r3 >= r4.length()) goto L68;
            int r22 = indexOfElement(r4, "=,;", r3);
            String r23 = r4.substring(r3, r22);
            Intrinsics.e(r23, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String r24 = StringsKt.J(r23).toString();
            if (r22 == r4.length()) goto L28;
            int r25 = r2;
            if (r4.charAt(r22) != ',') goto L20;
        L21:
            boolean r26 = true;
            int r27 = r22 + 1;
            String r29 = null;
        L31:
            if ("no-cache".equalsIgnoreCase(r24) == false) goto L35;
            r10 = r26;
        L67:
            r3 = r27;
            r5 = r26;
            r2 = r25;
            r9 = r9;
            goto L14
        L35:
            if ("no-store".equalsIgnoreCase(r24) == false) goto L38;
            r11 = r26;
            goto L67
        L38:
            if ("max-age".equalsIgnoreCase(r24) == false) goto L41;
            r12 = Util.toNonNegativeInt(r29, -1);
            goto L67
        L41:
            if ("s-maxage".equalsIgnoreCase(r24) == false) goto L44;
            r13 = Util.toNonNegativeInt(r29, -1);
            goto L67
        L44:
            if ("private".equalsIgnoreCase(r24) == false) goto L47;
            r14 = r26;
            goto L67
        L47:
            if ("public".equalsIgnoreCase(r24) == false) goto L50;
            r15 = r26;
            goto L67
        L50:
            if ("must-revalidate".equalsIgnoreCase(r24) == false) goto L53;
            r16 = r26;
            goto L67
        L53:
            if ("max-stale".equalsIgnoreCase(r24) == false) goto L56;
            r17 = Util.toNonNegativeInt(r29, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            goto L67
        L56:
            if ("min-fresh".equalsIgnoreCase(r24) == false) goto L59;
            r18 = Util.toNonNegativeInt(r29, -1);
            goto L67
        L59:
            if ("only-if-cached".equalsIgnoreCase(r24) == false) goto L62;
            r19 = r26;
            goto L67
        L62:
            if ("no-transform".equalsIgnoreCase(r24) == false) goto L65;
            r20 = r26;
            goto L67
        L65:
            if ("immutable".equalsIgnoreCase(r24) == false) goto L67;
            r21 = r26;
            goto L67
        L20:
            if (r4.charAt(r22) == ';') goto L21;
            int r30 = Util.indexOfNonWhitespace(r4, r22 + 1);
            if (r30 < r4.length()) goto L25;
        L27:
            r26 = true;
            r27 = indexOfElement(r4, ",;", r30);
            String r31 = r4.substring(r30, r27);
            Intrinsics.e(r31, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            r29 = StringsKt.J(r31).toString();
            goto L31
        L25:
            if (r4.charAt(r30) != '\"') goto L27;
            int r32 = r30 + 1;
            int r33 = StringsKt.r(r4, '\"', r32, false, 4);
            r29 = r4.substring(r32, r33);
            Intrinsics.e(r29, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            r26 = true;
            r27 = r33 + 1;
            goto L31
        L28:
            r25 = r2;
            goto L21
        L68:
            int r210 = r2;
            boolean r211 = r5;
            String r34 = r9;
        L70:
            r7 = r7 + 1;
            r1 = r28;
            r9 = r34;
            r5 = r211;
            r2 = r210;
            goto L3
        L8:
            r9 = r4;
            goto L12
        L10:
            if (StringsKt.p(r6, "Pragma", r5) == true) goto L7;
            r210 = r2;
            r211 = r5;
            r34 = r9;
            goto L70
        L71:
            String r35 = r9;
            if (r8 == true) goto L74;
            String r212 = null;
        L76:
            return new CacheControl(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r212, null);
        L74:
            r212 = r35;
            goto L76
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        FORCE_NETWORK = new Builder().noCache().build();
        FORCE_CACHE = new Builder().onlyIfCached().maxStale(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.SECONDS).build();
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

    @JvmStatic
    @NotNull
    public static final CacheControl parse(@NotNull Headers r1) {
        return Companion.parse(r1);
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_immutable, reason: not valid java name */
    public final boolean m57deprecated_immutable() {
        return this.immutable;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_maxAgeSeconds, reason: not valid java name */
    public final int m58deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_maxStaleSeconds, reason: not valid java name */
    public final int m59deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_minFreshSeconds, reason: not valid java name */
    public final int m60deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_mustRevalidate, reason: not valid java name */
    public final boolean m61deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_noCache, reason: not valid java name */
    public final boolean m62deprecated_noCache() {
        return this.noCache;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_noStore, reason: not valid java name */
    public final boolean m63deprecated_noStore() {
        return this.noStore;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_noTransform, reason: not valid java name */
    public final boolean m64deprecated_noTransform() {
        return this.noTransform;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_onlyIfCached, reason: not valid java name */
    public final boolean m65deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_sMaxAgeSeconds, reason: not valid java name */
    public final int m66deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @JvmName
    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    @JvmName
    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @JvmName
    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @JvmName
    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @JvmName
    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    @JvmName
    public final boolean noCache() {
        return this.noCache;
    }

    @JvmName
    public final boolean noStore() {
        return this.noStore;
    }

    @JvmName
    public final boolean noTransform() {
        return this.noTransform;
    }

    @JvmName
    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    @JvmName
    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @NotNull
    public String toString() {
        String r0 = this.headerValue;
        if (r0 != null) goto L46;
        StringBuilder r1 = new StringBuilder();
        if (this.noCache == false) goto L8;
        r1.append("no-cache, ");
    L8:
        if (this.noStore == false) goto L11;
        r1.append("no-store, ");
    L11:
        if (this.maxAgeSeconds == (-1)) goto L14;
        r1.append("max-age=");
        r1.append(this.maxAgeSeconds);
        r1.append(", ");
    L14:
        if (this.sMaxAgeSeconds == (-1)) goto L17;
        r1.append("s-maxage=");
        r1.append(this.sMaxAgeSeconds);
        r1.append(", ");
    L17:
        if (this.isPrivate == false) goto L20;
        r1.append("private, ");
    L20:
        if (this.isPublic == false) goto L23;
        r1.append("public, ");
    L23:
        if (this.mustRevalidate == false) goto L26;
        r1.append("must-revalidate, ");
    L26:
        if (this.maxStaleSeconds == (-1)) goto L29;
        r1.append("max-stale=");
        r1.append(this.maxStaleSeconds);
        r1.append(", ");
    L29:
        if (this.minFreshSeconds == (-1)) goto L32;
        r1.append("min-fresh=");
        r1.append(this.minFreshSeconds);
        r1.append(", ");
    L32:
        if (this.onlyIfCached == false) goto L35;
        r1.append("only-if-cached, ");
    L35:
        if (this.noTransform == false) goto L38;
        r1.append("no-transform, ");
    L38:
        if (this.immutable == false) goto L41;
        r1.append("immutable, ");
    L41:
        if (r1.length() != 0) goto L44;
        return "";
    L44:
        r1.delete(r1.length() - 2, r1.length());
        String r2 = r1.toString();
        Intrinsics.e(r2, "StringBuilder().apply(builderAction).toString()");
        this.headerValue = r2;
        return r2;
    L46:
        return r0;
    }

    public /* synthetic */ CacheControl(boolean r1, boolean r2, int r3, int r4, boolean r5, boolean r6, boolean r7, int r8, int r9, boolean r10, boolean r11, boolean r12, String r13, DefaultConstructorMarker r14) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }
}
