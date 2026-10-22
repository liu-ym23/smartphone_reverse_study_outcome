package okhttp3;

import com.bytedance.librarian.LibrarianImpl;
import com.obric.oui.calendar.ODatePickerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: loaded from: classes5.dex */
public final class Cookie {
    private static final Pattern DAY_OF_MONTH_PATTERN = null;
    private static final Pattern MONTH_PATTERN = null;
    private static final Pattern TIME_PATTERN = null;
    private static final Pattern YEAR_PATTERN = null;
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;

    public static final class Builder {

        @Nullable
        String domain;
        long expiresAt;
        boolean hostOnly;
        boolean httpOnly;

        @Nullable
        String name;
        String path;
        boolean persistent;
        boolean secure;

        @Nullable
        String value;

        public Builder() {
            this.expiresAt = HttpDate.MAX_DATE;
            this.path = LibrarianImpl.Constants.SEPARATOR;
        }

        public Builder name(String r2) {
            if (r2 == null) goto L10;
            if (r2.trim().equals(r2) == false) goto L8;
            this.name = r2;
            return this;
        L8:
            throw new IllegalArgumentException("name is not trimmed");
        L10:
            throw new NullPointerException("name == null");
        }

        public Builder value(String r2) {
            if (r2 == null) goto L10;
            if (r2.trim().equals(r2) == false) goto L8;
            this.value = r2;
            return this;
        L8:
            throw new IllegalArgumentException("value is not trimmed");
        L10:
            throw new NullPointerException("value == null");
        }

        public Builder expiresAt(long r4) {
            if (r4 > 0) goto L6;
            r4 = Long.MIN_VALUE;
        L6:
            if (r4 <= HttpDate.MAX_DATE) goto L8;
            r4 = 253402300799999L;
        L8:
            this.expiresAt = r4;
            this.persistent = true;
            return this;
        }

        public Builder domain(String r2) {
            return domain(r2, false);
        }

        public Builder hostOnlyDomain(String r2) {
            return domain(r2, true);
        }

        private Builder domain(String r2, boolean r3) {
            if (r2 == null) goto L10;
            String r0 = Util.canonicalizeHost(r2);
            if (r0 == null) goto L8;
            this.domain = r0;
            this.hostOnly = r3;
            return this;
        L8:
            throw new IllegalArgumentException("unexpected domain: " + r2);
        L10:
            throw new NullPointerException("domain == null");
        }

        public Builder path(String r2) {
            if (r2.startsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L7;
            this.path = r2;
            return this;
        L7:
            throw new IllegalArgumentException("path must start with '/'");
        }

        public Builder secure() {
            this.secure = true;
            return this;
        }

        public Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public Cookie build() {
            return new Cookie(this);
        }
    }

    static {
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
        this.hostOnly = r9;
        this.persistent = r10;
    }

    Cookie(Builder r3) {
        if (r3.name == null) goto L15;
        if (r3.value == null) goto L13;
        if (r3.domain == null) goto L11;
        this.name = r3.name;
        this.value = r3.value;
        this.expiresAt = r3.expiresAt;
        this.domain = r3.domain;
        this.path = r3.path;
        this.secure = r3.secure;
        this.httpOnly = r3.httpOnly;
        this.persistent = r3.persistent;
        this.hostOnly = r3.hostOnly;
        return;
    L11:
        throw new NullPointerException("builder.domain == null");
    L13:
        throw new NullPointerException("builder.value == null");
    L15:
        throw new NullPointerException("builder.name == null");
    }

    public String name() {
        return this.name;
    }

    public String value() {
        return this.value;
    }

    public boolean persistent() {
        return this.persistent;
    }

    public long expiresAt() {
        return this.expiresAt;
    }

    public boolean hostOnly() {
        return this.hostOnly;
    }

    public String domain() {
        return this.domain;
    }

    public String path() {
        return this.path;
    }

    public boolean httpOnly() {
        return this.httpOnly;
    }

    public boolean secure() {
        return this.secure;
    }

    public boolean matches(HttpUrl r3) {
        if (this.hostOnly == false) goto L5;
        boolean r0 = r3.host().equals(this.domain);
    L7:
        if (r0 == true) goto L10;
        return false;
    L10:
        if (pathMatch(r3, this.path) == true) goto L13;
        return false;
    L13:
        if (this.secure == true) goto L15;
        return true;
    L15:
        if (r3.isHttps() == true) goto L19;
        return false;
    L19:
        return true;
    L5:
        r0 = domainMatch(r3.host(), this.domain);
        goto L7
    }

    private static boolean domainMatch(String r2, String r3) {
        if (r2.equals(r3) == false) goto L6;
        return true;
    L6:
        if (r2.endsWith(r3) == true) goto L8;
        return false;
    L8:
        if (r2.charAt((r2.length() - r3.length()) - 1) == '.') goto L10;
        return false;
    L10:
        if (Util.verifyAsIpAddress(r2) == true) goto L15;
        return true;
    L15:
        return false;
    }

    private static boolean pathMatch(HttpUrl r2, String r3) {
        String r4 = r2.encodedPath();
        if (r4.equals(r3) == false) goto L6;
        return true;
    L6:
        if (r4.startsWith(r3) == true) goto L8;
        return false;
    L8:
        if (r3.endsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L11;
        return true;
    L11:
        if (r4.charAt(r3.length()) != '/') goto L15;
        return true;
    L15:
        return false;
    }

    @Nullable
    public static Cookie parse(HttpUrl r2, String r3) {
        return parse(System.currentTimeMillis(), r2, r3);
    }

    @Nullable
    static Cookie parse(long r23, HttpUrl r25, String r26) {
        int r1 = r26.length();
        char r3 = ';';
        int r4 = Util.delimiterOffset(r26, 0, r1, ';');
        char r5 = '=';
        int r6 = Util.delimiterOffset(r26, 0, r4, '=');
        if (r6 != r4) goto L5;
        return null;
    L5:
        String r9 = Util.trimSubstring(r26, 0, r6);
        if (r9.isEmpty() == true) goto L82;
        if (Util.indexOfControlOrNonAscii(r9) != (-1)) goto L82;
        String r7 = Util.trimSubstring(r26, r6 + 1, r4);
        if (Util.indexOfControlOrNonAscii(r7) == (-1)) goto L13;
        return null;
    L13:
        int r8 = r4 + 1;
        boolean r15 = false;
        boolean r16 = false;
        boolean r18 = false;
        String r14 = null;
        boolean r17 = true;
        long r19 = -1;
        long r21 = 253402300799999L;
        String r10 = null;
    L14:
        if (r8 >= r1) goto L41;
        int r11 = Util.delimiterOffset(r26, r8, r1, r3);
        int r12 = Util.delimiterOffset(r26, r8, r11, r5);
        String r13 = Util.trimSubstring(r26, r8, r12);
        if (r12 >= r11) goto L18;
        String r20 = Util.trimSubstring(r26, r12 + 1, r11);
    L20:
        if (r13.equalsIgnoreCase("expires") == false) goto L24;
        r21 = parseExpires(r20, 0, r20.length());     // Catch: Throwable -> L83
    L26:
        r18 = true;
    L40:
        r8 = r11 + 1;
        r3 = ';';
        r5 = '=';
        goto L14
    L24:
        if (r13.equalsIgnoreCase("max-age") == false) goto L28;
        r19 = parseMaxAge(r20);
        goto L26
    L28:
        if (r13.equalsIgnoreCase("domain") == false) goto L32;
        r14 = parseDomain(r20);     // Catch: Throwable -> L83
        r17 = false;
        goto L40
    L32:
        if (r13.equalsIgnoreCase("path") == false) goto L35;
        r10 = r20;
        goto L40
    L35:
        if (r13.equalsIgnoreCase("secure") == false) goto L38;
        r15 = true;
        goto L40
    L38:
        if (r13.equalsIgnoreCase("httponly") == false) goto L40;
        r16 = true;
        goto L40
    L18:
        r20 = "";
        goto L20
    L41:
        long r0 = Long.MIN_VALUE;
        if (r19 != Long.MIN_VALUE) goto L45;
    L43:
        long r110 = r0;
    L56:
        String r2 = r25.host();
        if (r14 != null) goto L60;
        String r111 = r2;
        Cookie r22 = null;
    L65:
        if (r2.length() != r111.length()) goto L67;
    L69:
        String r24 = LibrarianImpl.Constants.SEPARATOR;
        if (r10 != null) goto L72;
    L75:
        String r27 = r25.encodedPath();
        int r28 = r27.lastIndexOf(47);
        if (r28 == 0) goto L78;
        r24 = r27.substring(0, r28);
    L78:
        String r112 = r24;
    L80:
        return new Cookie(r9, r7, r110, r111, r112, r15, r16, r17, r18);
    L72:
        if (r10.startsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L75;
        r112 = r10;
        goto L80
    L67:
        if (PublicSuffixDatabase.get().getEffectiveTldPlusOne(r111) != null) goto L69;
        return r22;
    L60:
        if (domainMatch(r2, r14) == true) goto L63;
        return null;
    L63:
        r22 = null;
        r111 = r14;
        goto L65
    L45:
        if (r19 != (-1)) goto L47;
        r110 = r21;
        goto L56
    L47:
        if (r19 > 9223372036854775L) goto L49;
        long r113 = r19 * 1000;
    L50:
        r0 = r23 + r113;
        if (r0 >= r23) goto L53;
    L54:
        r110 = 253402300799999L;
        goto L56
    L53:
        if (r0 <= HttpDate.MAX_DATE) goto L43;
    L49:
        r113 = Long.MAX_VALUE;
    L82:
        return null;
    }

    private static long parseExpires(String r12, int r13, int r14) {
        int r15 = dateCharacterOffset(r12, r13, r14, false);
        Matcher r1 = TIME_PATTERN.matcher(r12);
        int r3 = -1;
        int r4 = -1;
        int r5 = -1;
        int r6 = -1;
        int r7 = -1;
        int r8 = -1;
    L4:
        if (r15 >= r14) goto L24;
        int r11 = dateCharacterOffset(r12, r15 + 1, r14, true);
        r1.region(r15, r11);
        if (r4 == (-1)) goto L8;
    L10:
        if (r5 == (-1)) goto L12;
    L14:
        if (r6 != (-1)) goto L18;
        Pattern r16 = MONTH_PATTERN;
        if (r1.usePattern(r16).matches() == false) goto L18;
        r6 = r16.pattern().indexOf(r1.group(1).toLowerCase(Locale.US)) / 4;
    L22:
        r15 = dateCharacterOffset(r12, r11 + 1, r14, false);
    L18:
        if (r3 != (-1)) goto L22;
        if (r1.usePattern(YEAR_PATTERN).matches() == false) goto L22;
        r3 = Integer.parseInt(r1.group(1));
        goto L22
    L12:
        if (r1.usePattern(DAY_OF_MONTH_PATTERN).matches() == false) goto L14;
        r5 = Integer.parseInt(r1.group(1));
        goto L22
    L8:
        if (r1.usePattern(TIME_PATTERN).matches() == false) goto L10;
        r4 = Integer.parseInt(r1.group(1));
        r7 = Integer.parseInt(r1.group(2));
        r8 = Integer.parseInt(r1.group(3));
        goto L22
    L24:
        if (r3 >= 70) goto L26;
    L28:
        if (r3 < 0) goto L33;
        if (r3 > 69) goto L33;
        r3 = r3 + 2000;
    L33:
        if (r3 < 1601) goto L59;
        if (r6 == (-1)) goto L57;
        if (r5 < 1) goto L55;
        if (r5 > 31) goto L55;
        if (r4 < 0) goto L53;
        if (r4 > 23) goto L53;
        if (r7 < 0) goto L51;
        if (r7 > 59) goto L51;
        if (r8 < 0) goto L49;
        if (r8 > 59) goto L49;
        GregorianCalendar r17 = new GregorianCalendar(Util.UTC);
        r17.setLenient(false);
        r17.set(1, r3);
        r17.set(2, r6 - 1);
        r17.set(5, r5);
        r17.set(11, r4);
        r17.set(12, r7);
        r17.set(13, r8);
        r17.set(14, 0);
        return r17.getTimeInMillis();
    L49:
        throw new IllegalArgumentException();
    L51:
        throw new IllegalArgumentException();
    L53:
        throw new IllegalArgumentException();
    L55:
        throw new IllegalArgumentException();
    L57:
        throw new IllegalArgumentException();
    L59:
        throw new IllegalArgumentException();
    L26:
        if (r3 > 99) goto L28;
        r3 = r3 + ODatePickerView.YEAR_FROM;
        goto L28
    }

    private static int dateCharacterOffset(String r3, int r4, int r5, boolean r6) {
    L2:
        if (r4 >= r5) goto L30;
        char r0 = r3.charAt(r4);
        if (r0 >= ' ') goto L8;
        if (r0 == '\t') goto L8;
    L25:
        boolean r1 = true;
    L27:
        if (r1 == (!r6)) goto L28;
        r4 = r4 + 1;
        goto L2
    L28:
        return r4;
    L8:
        if (r0 >= 127) goto L25;
        if (r0 < '0') goto L14;
        if (r0 <= '9') goto L25;
    L14:
        if (r0 < 'a') goto L18;
        if (r0 <= 'z') goto L25;
    L18:
        if (r0 < 'A') goto L22;
        if (r0 <= 'Z') goto L25;
    L22:
        if (r0 == ':') goto L25;
        r1 = false;
        goto L27
    L30:
        return r5;
    }

    private static long parseMaxAge(String r6) {
        long r2 = Long.parseLong(r6);     // Catch: NumberFormatException -> L9
        if (r2 > 0) goto L8;
        return Long.MIN_VALUE;
    L8:
        return r2;
    L9:
        e = move-exception;
        if (r6.matches("-?\\d+") == true) goto L13;
        throw e;
    L13:
        if (r6.startsWith("-") == true) goto L21;
        return Long.MAX_VALUE;
    L21:
        return Long.MIN_VALUE;
    }

    private static String parseDomain(String r2) {
        if (r2.endsWith(LibrarianImpl.Constants.DOT) == true) goto L13;
        if (r2.startsWith(LibrarianImpl.Constants.DOT) == false) goto L7;
        r2 = r2.substring(1);
    L7:
        String r3 = Util.canonicalizeHost(r2);
        if (r3 == null) goto L11;
        return r3;
    L11:
        throw new IllegalArgumentException();
    L13:
        throw new IllegalArgumentException();
    }

    public static List<Cookie> parseAll(HttpUrl r4, Headers r5) {
        List<String> r6 = r5.values("Set-Cookie");
        int r0 = r6.size();
        ArrayList r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        Cookie r3 = parse(r4, r6.get(r2));
        if (r3 == null) goto L10;
        if (r1 != null) goto L9;
        r1 = new ArrayList();
    L9:
        r1.add(r3);
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        if (r1 == null) goto L14;
        return Collections.unmodifiableList(r1);
    L14:
        return Collections.emptyList();
    }

    public String toString() {
        return toString(false);
    }

    String toString(boolean r6) {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.name);
        r0.append('=');
        r0.append(this.value);
        if (this.persistent == false) goto L9;
        if (this.expiresAt != Long.MIN_VALUE) goto L7;
        r0.append("; max-age=0");
        goto L9
    L7:
        r0.append("; expires=").append(HttpDate.format(new Date(this.expiresAt)));
    L9:
        if (this.hostOnly == true) goto L14;
        r0.append("; domain=");
        if (r6 == false) goto L13;
        r0.append(LibrarianImpl.Constants.DOT);
    L13:
        r0.append(this.domain);
    L14:
        r0.append("; path=").append(this.path);
        if (this.secure == false) goto L18;
        r0.append("; secure");
    L18:
        if (this.httpOnly == false) goto L21;
        r0.append("; httponly");
    L21:
        return r0.toString();
    }

    public boolean equals(@Nullable Object r7) {
        if ((r7 instanceof Cookie) == true) goto L5;
        return false;
    L5:
        Cookie r8 = (Cookie) r7;
        if (r8.name.equals(this.name) == true) goto L8;
        return false;
    L8:
        if (r8.value.equals(this.value) == true) goto L10;
        return false;
    L10:
        if (r8.domain.equals(this.domain) == true) goto L12;
        return false;
    L12:
        if (r8.path.equals(this.path) == true) goto L14;
        return false;
    L14:
        if (r8.expiresAt == this.expiresAt) goto L16;
        return false;
    L16:
        if (r8.secure == this.secure) goto L18;
        return false;
    L18:
        if (r8.httpOnly == this.httpOnly) goto L20;
        return false;
    L20:
        if (r8.persistent == this.persistent) goto L22;
        return false;
    L22:
        if (r8.hostOnly != this.hostOnly) goto L33;
        return true;
    L33:
        return false;
    }

    public int hashCode() {
        int r1 = (((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31;
        long r2 = this.expiresAt;
        return ((((((((r1 + ((int) (r2 ^ (r2 >>> 32)))) * 31) + (!this.secure ? 1 : 0)) * 31) + (!this.httpOnly ? 1 : 0)) * 31) + (!this.persistent ? 1 : 0)) * 31) + (!this.hostOnly ? 1 : 0);
    }
}
