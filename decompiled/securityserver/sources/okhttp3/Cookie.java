package okhttp3;

import a.a;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.librarian.LibrarianImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Cookie {
    public static final Companion Companion = null;
    private static final Pattern DAY_OF_MONTH_PATTERN = null;
    private static final Pattern MONTH_PATTERN = null;
    private static final Pattern TIME_PATTERN = null;
    private static final Pattern YEAR_PATTERN = null;

    @NotNull
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;

    @NotNull
    private final String name;

    @NotNull
    private final String path;
    private final boolean persistent;
    private final boolean secure;

    @NotNull
    private final String value;

    @Metadata
    public static final class Builder {
        private String domain;
        private long expiresAt;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private String path;
        private boolean persistent;
        private boolean secure;
        private String value;

        public Builder() {
            this.expiresAt = DatesKt.MAX_DATE;
            this.path = LibrarianImpl.Constants.SEPARATOR;
        }

        @NotNull
        public final Cookie build() {
            String r1 = this.name;
            if (r1 == null) goto L15;
            String r2 = this.value;
            if (r2 == null) goto L13;
            long r3 = this.expiresAt;
            String r5 = this.domain;
            if (r5 == null) goto L11;
            return new Cookie(r1, r2, r3, r5, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
        L11:
            throw new NullPointerException("builder.domain == null");
        L13:
            throw new NullPointerException("builder.value == null");
        L15:
            throw new NullPointerException("builder.name == null");
        }

        @NotNull
        public final Builder domain(@NotNull String r2) {
            Intrinsics.f(r2, "domain");
            return domain(r2, false);
        }

        @NotNull
        public final Builder expiresAt(long r4) {
            if (r4 > 0) goto L6;
            r4 = Long.MIN_VALUE;
        L6:
            if (r4 <= DatesKt.MAX_DATE) goto L8;
            r4 = 253402300799999L;
        L8:
            this.expiresAt = r4;
            this.persistent = true;
            return this;
        }

        @NotNull
        public final Builder hostOnlyDomain(@NotNull String r2) {
            Intrinsics.f(r2, "domain");
            return domain(r2, true);
        }

        @NotNull
        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        @NotNull
        public final Builder name(@NotNull String r2) {
            Intrinsics.f(r2, "name");
            if (Intrinsics.a(StringsKt.J(r2).toString(), r2) == false) goto L7;
            this.name = r2;
            return this;
        L7:
            throw new IllegalArgumentException("name is not trimmed".toString());
        }

        @NotNull
        public final Builder path(@NotNull String r3) {
            Intrinsics.f(r3, ApmTrafficStats.KEY_PATH);
            if (StringsKt.F(r3, LibrarianImpl.Constants.SEPARATOR, false) == false) goto L7;
            this.path = r3;
            return this;
        L7:
            throw new IllegalArgumentException("path must start with '/'".toString());
        }

        @NotNull
        public final Builder secure() {
            this.secure = true;
            return this;
        }

        @NotNull
        public final Builder value(@NotNull String r2) {
            Intrinsics.f(r2, "value");
            if (Intrinsics.a(StringsKt.J(r2).toString(), r2) == false) goto L7;
            this.value = r2;
            return this;
        L7:
            throw new IllegalArgumentException("value is not trimmed".toString());
        }

        private final Builder domain(String r2, boolean r3) {
            String r0 = HostnamesKt.toCanonicalHost(r2);
            if (r0 == null) goto L7;
            this.domain = r0;
            this.hostOnly = r3;
            return this;
        L7:
            throw new IllegalArgumentException(a.A("unexpected domain: ", r2));
        }
    }

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ boolean access$domainMatch(Companion r0, String r1, String r2) {
            return r0.domainMatch(r1, r2);
        }

        public static final /* synthetic */ boolean access$pathMatch(Companion r0, HttpUrl r1, String r2) {
            return r0.pathMatch(r1, r2);
        }

        private final int dateCharacterOffset(String r3, int r4, int r5, boolean r6) {
        L2:
            if (r4 >= r5) goto L30;
            char r2 = r3.charAt(r4);
            if (r2 >= ' ') goto L8;
            if (r2 == '\t') goto L8;
        L25:
            boolean r7 = true;
        L27:
            if (r7 == (!r6)) goto L28;
            r4 = r4 + 1;
            goto L2
        L28:
            return r4;
        L8:
            if (r2 >= 127) goto L25;
            if ('0' > r2) goto L14;
            if ('9' >= r2) goto L25;
        L14:
            if ('a' > r2) goto L18;
            if ('z' >= r2) goto L25;
        L18:
            if ('A' > r2) goto L22;
            if ('Z' >= r2) goto L25;
        L22:
            if (r2 == ':') goto L25;
            r7 = false;
            goto L27
        L30:
            return r5;
        }

        private final boolean domainMatch(String r2, String r3) {
            if (Intrinsics.a(r2, r3) == false) goto L6;
            return true;
        L6:
            if (StringsKt.o(r2, r3) == true) goto L8;
        L12:
            return false;
        L8:
            if (r2.charAt((r2.length() - r3.length()) - 1) != '.') goto L12;
            if (Util.canParseAsIpAddress(r2) == true) goto L12;
            return true;
        }

        private final String parseDomain(String r2) {
            if ((!StringsKt.o(r2, LibrarianImpl.Constants.DOT)) == false) goto L10;
            String r1 = HostnamesKt.toCanonicalHost(StringsKt.x(r2, LibrarianImpl.Constants.DOT));
            if (r1 == null) goto L8;
            return r1;
        L8:
            throw new IllegalArgumentException();
        L10:
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseExpires(String r17, int r18, int r19) {
            int r4 = dateCharacterOffset(r17, r18, r19, false);
            Matcher r5 = Cookie.access$getTIME_PATTERN$cp().matcher(r17);
            int r7 = -1;
            int r8 = -1;
            int r9 = -1;
            int r10 = -1;
            int r11 = -1;
            int r12 = -1;
        L4:
            if (r4 >= r19) goto L24;
            int r15 = dateCharacterOffset(r17, r4 + 1, r19, true);
            r5.region(r4, r15);
            if (r8 == (-1)) goto L8;
        L10:
            if (r9 == (-1)) goto L12;
        L14:
            if (r10 == (-1)) goto L16;
        L18:
            if (r7 != (-1)) goto L22;
            if (r5.usePattern(Cookie.access$getYEAR_PATTERN$cp()).matches() == false) goto L22;
            String r3 = r5.group(1);
            Intrinsics.e(r3, "matcher.group(1)");
            r7 = Integer.parseInt(r3);
        L22:
            r4 = dateCharacterOffset(r17, r15 + 1, r19, false);
            goto L4
        L16:
            if (r5.usePattern(Cookie.access$getMONTH_PATTERN$cp()).matches() == false) goto L18;
            String r6 = r5.group(1);
            Intrinsics.e(r6, "matcher.group(1)");
            Locale r13 = Locale.US;
            Intrinsics.e(r13, "Locale.US");
            String r14 = r6.toLowerCase(r13);
            Intrinsics.e(r14, "(this as java.lang.String).toLowerCase(locale)");
            String r16 = Cookie.access$getMONTH_PATTERN$cp().pattern();
            Intrinsics.e(r16, "MONTH_PATTERN.pattern()");
            r10 = StringsKt.s(r16, r14, 0, false, 6) / 4;
            goto L22
        L12:
            if (r5.usePattern(Cookie.access$getDAY_OF_MONTH_PATTERN$cp()).matches() == false) goto L14;
            String r20 = r5.group(1);
            Intrinsics.e(r20, "matcher.group(1)");
            r9 = Integer.parseInt(r20);
            goto L22
        L8:
            if (r5.usePattern(Cookie.access$getTIME_PATTERN$cp()).matches() == false) goto L10;
            String r21 = r5.group(1);
            Intrinsics.e(r21, "matcher.group(1)");
            r8 = Integer.parseInt(r21);
            String r22 = r5.group(2);
            Intrinsics.e(r22, "matcher.group(2)");
            r11 = Integer.parseInt(r22);
            String r23 = r5.group(3);
            Intrinsics.e(r23, "matcher.group(3)");
            r12 = Integer.parseInt(r23);
            goto L22
        L24:
            if (70 <= r7) goto L27;
        L29:
            if (r7 < 0) goto L35;
            if (69 < r7) goto L35;
            r7 = r7 + 2000;
        L35:
            if (r7 < 1601) goto L37;
            boolean r0 = true;
        L39:
            if (r0 == false) goto L65;
            if (r10 == (-1)) goto L63;
            if (1 > r9) goto L61;
            if (31 < r9) goto L61;
            if (r8 < 0) goto L59;
            if (23 < r8) goto L59;
            if (r11 < 0) goto L57;
            if (59 < r11) goto L57;
            if (r12 < 0) goto L55;
            if (59 < r12) goto L55;
            GregorianCalendar r1 = new GregorianCalendar(Util.UTC);
            r1.setLenient(false);
            r1.set(1, r7);
            r1.set(2, r10 - 1);
            r1.set(5, r9);
            r1.set(11, r8);
            r1.set(12, r11);
            r1.set(13, r12);
            r1.set(14, 0);
            return r1.getTimeInMillis();
        L55:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L57:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L59:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L61:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L63:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L65:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L37:
            r0 = false;
            goto L39
        L27:
            if (99 < r7) goto L29;
            r7 = r7 + 1900;
            goto L29
        }

        private final long parseMaxAge(String r5) {
            long r4 = Long.parseLong(r5);     // Catch: NumberFormatException -> L9
            if (r4 > 0) goto L8;
            return Long.MIN_VALUE;
        L8:
            return r4;
        L9:
            e = move-exception;
            if (new Regex("-?\\d+").b(r5) == true) goto L13;
            throw e;
        L13:
            if (StringsKt.F(r5, "-", false) == true) goto L21;
            return Long.MAX_VALUE;
        L21:
            return Long.MIN_VALUE;
        }

        private final boolean pathMatch(HttpUrl r3, String r4) {
            String r2 = r3.encodedPath();
            if (Intrinsics.a(r2, r4) == false) goto L6;
            return true;
        L6:
            if (StringsKt.F(r2, r4, false) == true) goto L8;
        L13:
            return false;
        L8:
            if (StringsKt.o(r4, LibrarianImpl.Constants.SEPARATOR) == false) goto L11;
            return true;
        L11:
            if (r2.charAt(r4.length()) != '/') goto L13;
            return true;
        }

        @JvmStatic
        @Nullable
        public final Cookie parse(@NotNull HttpUrl r3, @NotNull String r4) {
            Intrinsics.f(r3, "url");
            Intrinsics.f(r4, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), r3, r4);
        }

        @Nullable
        public final Cookie parse$okhttp(long r26, @NotNull HttpUrl r28, @NotNull String r29) {
            Intrinsics.f(r28, "url");
            Intrinsics.f(r29, "setCookie");
            int r9 = Util.delimiterOffset$default(r29, ';', 0, 0, 6, null);
            int r1 = Util.delimiterOffset$default(r29, '=', 0, r9, 2, null);
            if (r1 != r9) goto L5;
            return null;
        L5:
            String r11 = Util.trimSubstring$default(r29, 0, r1, 1, null);
            if (r11.length() != 0) goto L9;
        L10:
            return null;
        L9:
            if (Util.indexOfControlOrNonAscii(r11) != (-1)) goto L10;
            String r12 = Util.trimSubstring(r29, r1 + 1, r9);
            if (Util.indexOfControlOrNonAscii(r12) == (-1)) goto L14;
            return null;
        L14:
            int r10 = r9 + 1;
            int r2 = r29.length();
            String r13 = null;
            String r22 = null;
            boolean r17 = false;
            boolean r18 = false;
            boolean r19 = false;
            boolean r20 = true;
            long r15 = -1;
            long r23 = DatesKt.MAX_DATE;
        L15:
            if (r10 >= r2) goto L41;
            int r3 = Util.delimiterOffset(r29, ';', r10, r2);
            int r14 = Util.delimiterOffset(r29, '=', r10, r3);
            String r16 = Util.trimSubstring(r29, r10, r14);
            if (r14 >= r3) goto L19;
            String r110 = Util.trimSubstring(r29, r14 + 1, r3);
        L21:
            if (StringsKt.p(r16, "expires", true) == false) goto L25;
            r23 = parseExpires(r110, 0, r110.length());     // Catch: Throwable -> L83
        L23:
            r19 = true;
        L40:
            r10 = r3 + 1;
            goto L15
        L25:
            if (StringsKt.p(r16, "max-age", true) == false) goto L28;
            r15 = parseMaxAge(r110);
            goto L23
        L28:
            if (StringsKt.p(r16, "domain", true) == false) goto L32;
            r13 = parseDomain(r110);     // Catch: Throwable -> L83
            r20 = false;
            goto L40
        L32:
            if (StringsKt.p(r16, ApmTrafficStats.KEY_PATH, true) == false) goto L35;
            r22 = r110;
            goto L40
        L35:
            if (StringsKt.p(r16, "secure", true) == false) goto L38;
            r17 = true;
            goto L40
        L38:
            if (StringsKt.p(r16, "httponly", true) == false) goto L40;
            r18 = true;
            goto L40
        L19:
            r110 = "";
            goto L21
        L41:
            long r4 = Long.MIN_VALUE;
            if (r15 != Long.MIN_VALUE) goto L45;
        L43:
            long r111 = r4;
        L58:
            String r5 = r28.host();
            if (r13 != null) goto L62;
            String r112 = r5;
            Cookie r0 = null;
        L67:
            if (r5.length() != r112.length()) goto L69;
        L71:
            String r6 = LibrarianImpl.Constants.SEPARATOR;
            String r7 = r22;
            if (r7 != null) goto L74;
        L77:
            String r8 = r28.encodedPath();
            int r21 = StringsKt.v(r8, '/', 0, 6);
            if (r21 == 0) goto L80;
            r6 = r8.substring(0, r21);
            Intrinsics.e(r6, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        L80:
            String r113 = r6;
        L82:
            return new Cookie(r11, r12, r111, r112, r113, r17, r18, r19, r20, null);
        L74:
            if (StringsKt.F(r7, LibrarianImpl.Constants.SEPARATOR, false) == false) goto L77;
            r113 = r7;
            goto L82
        L69:
            if (PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(r112) != null) goto L71;
            return r0;
        L62:
            if (domainMatch(r5, r13) == true) goto L65;
            return null;
        L65:
            r0 = null;
            r112 = r13;
            goto L67
        L45:
            if (r15 != (-1)) goto L47;
            r111 = r23;
            goto L58
        L47:
            if (r15 > 9223372036854775L) goto L49;
            long r114 = r15 * ((long) 1000);
        L50:
            r4 = r26 + r114;
            if (r4 < r26) goto L55;
            long r24 = DatesKt.MAX_DATE;
            if (r4 <= DatesKt.MAX_DATE) goto L43;
        L56:
            r111 = r24;
            goto L58
        L55:
            r24 = DatesKt.MAX_DATE;
            goto L56
        L49:
            r114 = Long.MAX_VALUE;
            goto L50
        }

        @JvmStatic
        @NotNull
        public final List<Cookie> parseAll(@NotNull HttpUrl r5, @NotNull Headers r6) {
            Intrinsics.f(r5, "url");
            Intrinsics.f(r6, "headers");
            List<String> r7 = r6.values("Set-Cookie");
            int r0 = r7.size();
            ArrayList r1 = null;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L10;
            Cookie r3 = parse(r5, r7.get(r2));
            if (r3 == null) goto L9;
            if (r1 != null) goto L8;
            r1 = new ArrayList();
        L8:
            r1.add(r3);
        L9:
            r2 = r2 + 1;
            goto L3
        L10:
            if (r1 == null) goto L13;
            List<Cookie> r4 = Collections.unmodifiableList(r1);
            Intrinsics.e(r4, "Collections.unmodifiableList(cookies)");
            return r4;
        L13:
            return EmptyList.b;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
        MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
        TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    private Cookie(String r1, String r2, long r3, String r5, String r6, boolean r7, boolean r8, boolean r9, boolean r10) {
        this.name = r1;
        this.value = r2;
        this.expiresAt = r3;
        this.domain = r5;
        this.path = r6;
        this.secure = r7;
        this.httpOnly = r8;
        this.persistent = r9;
        this.hostOnly = r10;
    }

    public static final /* synthetic */ Pattern access$getDAY_OF_MONTH_PATTERN$cp() {
        return DAY_OF_MONTH_PATTERN;
    }

    public static final /* synthetic */ Pattern access$getMONTH_PATTERN$cp() {
        return MONTH_PATTERN;
    }

    public static final /* synthetic */ Pattern access$getTIME_PATTERN$cp() {
        return TIME_PATTERN;
    }

    public static final /* synthetic */ Pattern access$getYEAR_PATTERN$cp() {
        return YEAR_PATTERN;
    }

    @JvmStatic
    @Nullable
    public static final Cookie parse(@NotNull HttpUrl r1, @NotNull String r2) {
        return Companion.parse(r1, r2);
    }

    @JvmStatic
    @NotNull
    public static final List<Cookie> parseAll(@NotNull HttpUrl r1, @NotNull Headers r2) {
        return Companion.parseAll(r1, r2);
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_domain, reason: not valid java name */
    public final String m75deprecated_domain() {
        return this.domain;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_expiresAt, reason: not valid java name */
    public final long m76deprecated_expiresAt() {
        return this.expiresAt;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_hostOnly, reason: not valid java name */
    public final boolean m77deprecated_hostOnly() {
        return this.hostOnly;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_httpOnly, reason: not valid java name */
    public final boolean m78deprecated_httpOnly() {
        return this.httpOnly;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_name, reason: not valid java name */
    public final String m79deprecated_name() {
        return this.name;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_path, reason: not valid java name */
    public final String m80deprecated_path() {
        return this.path;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_persistent, reason: not valid java name */
    public final boolean m81deprecated_persistent() {
        return this.persistent;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_secure, reason: not valid java name */
    public final boolean m82deprecated_secure() {
        return this.secure;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_value, reason: not valid java name */
    public final String m83deprecated_value() {
        return this.value;
    }

    @JvmName
    @NotNull
    public final String domain() {
        return this.domain;
    }

    public boolean equals(@Nullable Object r5) {
        if ((r5 instanceof Cookie) == false) goto L23;
        Cookie r6 = (Cookie) r5;
        if (Intrinsics.a(r6.name, this.name) == false) goto L23;
        if (Intrinsics.a(r6.value, this.value) == false) goto L23;
        if (r6.expiresAt != this.expiresAt) goto L23;
        if (Intrinsics.a(r6.domain, this.domain) == false) goto L23;
        if (Intrinsics.a(r6.path, this.path) == false) goto L23;
        if (r6.secure != this.secure) goto L23;
        if (r6.httpOnly != this.httpOnly) goto L23;
        if (r6.persistent != this.persistent) goto L23;
        if (r6.hostOnly != this.hostOnly) goto L23;
        return true;
    L23:
        return false;
    }

    @JvmName
    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        int r0 = (this.name.hashCode() + 527) * 31;
        int r1 = (this.value.hashCode() + r0) * 31;
        int r2 = (Long.hashCode(this.expiresAt) + r1) * 31;
        int r3 = (this.domain.hashCode() + r2) * 31;
        int r4 = (this.path.hashCode() + r3) * 31;
        int r5 = (Boolean.hashCode(this.secure) + r4) * 31;
        int r6 = (Boolean.hashCode(this.httpOnly) + r5) * 31;
        int r7 = (Boolean.hashCode(this.persistent) + r6) * 31;
        return Boolean.hashCode(this.hostOnly) + r7;
    }

    @JvmName
    public final boolean hostOnly() {
        return this.hostOnly;
    }

    @JvmName
    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(@NotNull HttpUrl r4) {
        Intrinsics.f(r4, "url");
        if (this.hostOnly == false) goto L5;
        boolean r0 = Intrinsics.a(r4.host(), this.domain);
    L7:
        if (r0 == true) goto L10;
        return false;
    L10:
        if (Companion.access$pathMatch(Companion, r4, this.path) == true) goto L13;
        return false;
    L13:
        if (this.secure == true) goto L15;
    L16:
        return true;
    L15:
        if (r4.isHttps() == true) goto L16;
        return false;
    L5:
        r0 = Companion.access$domainMatch(Companion, r4.host(), this.domain);
        goto L7
    }

    @JvmName
    @NotNull
    public final String name() {
        return this.name;
    }

    @JvmName
    @NotNull
    public final String path() {
        return this.path;
    }

    @JvmName
    public final boolean persistent() {
        return this.persistent;
    }

    @JvmName
    public final boolean secure() {
        return this.secure;
    }

    @NotNull
    public String toString() {
        return toString$okhttp(false);
    }

    @NotNull
    public final String toString$okhttp(boolean r6) {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.name);
        r0.append('=');
        r0.append(this.value);
        if (this.persistent == false) goto L9;
        if (this.expiresAt != Long.MIN_VALUE) goto L7;
        r0.append("; max-age=0");
        goto L9
    L7:
        r0.append("; expires=");
        r0.append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
    L9:
        if (this.hostOnly == true) goto L14;
        r0.append("; domain=");
        if (r6 == false) goto L13;
        r0.append(LibrarianImpl.Constants.DOT);
    L13:
        r0.append(this.domain);
    L14:
        r0.append("; path=");
        r0.append(this.path);
        if (this.secure == false) goto L18;
        r0.append("; secure");
    L18:
        if (this.httpOnly == false) goto L20;
        r0.append("; httponly");
    L20:
        String r5 = r0.toString();
        Intrinsics.e(r5, "toString()");
        return r5;
    }

    @JvmName
    @NotNull
    public final String value() {
        return this.value;
    }

    public /* synthetic */ Cookie(String r1, String r2, long r3, String r5, String r6, boolean r7, boolean r8, boolean r9, boolean r10, DefaultConstructorMarker r11) {
        this(r1, r2, r3, r5, r6, r7, r8, r9, r10);
    }
}
