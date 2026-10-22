package p000j;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000j.k0.c;
import p000j.k0.g.d;
import p000j.k0.l.a;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f18164j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Pattern f18165k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Pattern f18166l = null;
    private static final Pattern m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f18169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f18170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f18171e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f18172f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f18173g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f18174h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f18175i;

    static {
        f18164j = Pattern.compile("(\\d{2,4})[^\\d]*");
        f18165k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        f18166l = Pattern.compile("(\\d{1,2})[^\\d]*");
        m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    private m(String r1, String r2, long r3, String r5, String r6, boolean r7, boolean r8, boolean r9, boolean r10) {
        this.f18167a = r1;
        this.f18168b = r2;
        this.f18169c = r3;
        this.f18170d = r5;
        this.f18171e = r6;
        this.f18172f = r7;
        this.f18173g = r8;
        this.f18175i = r9;
        this.f18174h = r10;
    }

    private static int a(String r3, int r4, int r5, boolean r6) {
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

    private static boolean b(String r2, String r3) {
        if (r2.equals(r3) == false) goto L6;
        return true;
    L6:
        if (r2.endsWith(r3) == true) goto L8;
        return false;
    L8:
        if (r2.charAt((r2.length() - r3.length()) - 1) == '.') goto L10;
        return false;
    L10:
        if (c.J(r2) == true) goto L15;
        return true;
    L15:
        return false;
    }

    static m d(long r23, w r25, String r26) {
        int r1 = r26.length();
        char r3 = ';';
        int r4 = c.n(r26, 0, r1, ';');
        char r5 = '=';
        int r6 = c.n(r26, 0, r4, '=');
        if (r6 != r4) goto L5;
        return null;
    L5:
        String r9 = c.I(r26, 0, r6);
        if (r9.isEmpty() == true) goto L82;
        if (c.x(r9) != (-1)) goto L82;
        String r7 = c.I(r26, r6 + 1, r4);
        if (c.x(r7) == (-1)) goto L13;
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
        int r11 = c.n(r26, r8, r1, r3);
        int r12 = c.n(r26, r8, r11, r5);
        String r13 = c.I(r26, r8, r12);
        if (r12 >= r11) goto L18;
        String r20 = c.I(r26, r12 + 1, r11);
    L20:
        if (r13.equalsIgnoreCase("expires") == false) goto L24;
        r21 = h(r20, 0, r20.length());     // Catch: Throwable -> L83
    L26:
        r18 = true;
    L40:
        r8 = r11 + 1;
        r3 = ';';
        r5 = '=';
        goto L14
    L24:
        if (r13.equalsIgnoreCase("max-age") == false) goto L28;
        r19 = i(r20);
        goto L26
    L28:
        if (r13.equalsIgnoreCase("domain") == false) goto L32;
        r14 = g(r20);     // Catch: Throwable -> L83
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
        String r2 = r25.m();
        if (r14 != null) goto L60;
        String r111 = r2;
        m r22 = null;
    L65:
        if (r2.length() != r111.length()) goto L67;
    L69:
        String r24 = "/";
        if (r10 != null) goto L72;
    L75:
        String r27 = r25.h();
        int r28 = r27.lastIndexOf(47);
        if (r28 == 0) goto L78;
        r24 = r27.substring(0, r28);
    L78:
        String r112 = r24;
    L80:
        return new m(r9, r7, r110, r111, r112, r15, r16, r17, r18);
    L72:
        if (r10.startsWith("/") == false) goto L75;
        r112 = r10;
        goto L80
    L67:
        if (a.c().d(r111) != null) goto L69;
        return r22;
    L60:
        if (b(r2, r14) == true) goto L63;
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
        if (r0 <= 253402300799999L) goto L43;
    L49:
        r113 = LocationRequestCompat.PASSIVE_INTERVAL;
    L82:
        return null;
    }

    public static m e(w r2, String r3) {
        return d(System.currentTimeMillis(), r2, r3);
    }

    public static List<m> f(w r4, v r5) {
        List<String> r6 = r5.n("Set-Cookie");
        int r0 = r6.size();
        ArrayList r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        m r3 = e(r4, r6.get(r2));
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

    private static String g(String r2) {
        if (r2.endsWith(".") == true) goto L13;
        if (r2.startsWith(".") == false) goto L7;
        r2 = r2.substring(1);
    L7:
        String r3 = c.d(r2);
        if (r3 == null) goto L11;
        return r3;
    L11:
        throw new IllegalArgumentException();
    L13:
        throw new IllegalArgumentException();
    }

    private static long h(String r12, int r13, int r14) {
        int r15 = a(r12, r13, r14, false);
        Matcher r1 = m.matcher(r12);
        int r3 = -1;
        int r4 = -1;
        int r5 = -1;
        int r6 = -1;
        int r7 = -1;
        int r8 = -1;
    L4:
        if (r15 >= r14) goto L24;
        int r11 = a(r12, r15 + 1, r14, true);
        r1.region(r15, r11);
        if (r4 == (-1)) goto L8;
    L10:
        if (r5 == (-1)) goto L12;
    L14:
        if (r6 != (-1)) goto L18;
        Pattern r16 = f18165k;
        if (r1.usePattern(r16).matches() == false) goto L18;
        r6 = r16.pattern().indexOf(r1.group(1).toLowerCase(Locale.US)) / 4;
    L22:
        r15 = a(r12, r11 + 1, r14, false);
    L18:
        if (r3 != (-1)) goto L22;
        if (r1.usePattern(f18164j).matches() == false) goto L22;
        r3 = Integer.parseInt(r1.group(1));
        goto L22
    L12:
        if (r1.usePattern(f18166l).matches() == false) goto L14;
        r5 = Integer.parseInt(r1.group(1));
        goto L22
    L8:
        if (r1.usePattern(m).matches() == false) goto L10;
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
        GregorianCalendar r17 = new GregorianCalendar(c.o);
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
        r3 = r3 + 1900;
        goto L28
    }

    private static long i(String r6) {
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
        return LocationRequestCompat.PASSIVE_INTERVAL;
    L21:
        return Long.MIN_VALUE;
    }

    public String c() {
        return this.f18167a;
    }

    public boolean equals(Object r7) {
        if ((r7 instanceof m) == true) goto L5;
        return false;
    L5:
        m r8 = (m) r7;
        if (r8.f18167a.equals(this.f18167a) == true) goto L8;
        return false;
    L8:
        if (r8.f18168b.equals(this.f18168b) == true) goto L10;
        return false;
    L10:
        if (r8.f18170d.equals(this.f18170d) == true) goto L12;
        return false;
    L12:
        if (r8.f18171e.equals(this.f18171e) == true) goto L14;
        return false;
    L14:
        if (r8.f18169c == this.f18169c) goto L16;
        return false;
    L16:
        if (r8.f18172f == this.f18172f) goto L18;
        return false;
    L18:
        if (r8.f18173g == this.f18173g) goto L20;
        return false;
    L20:
        if (r8.f18174h == this.f18174h) goto L22;
        return false;
    L22:
        if (r8.f18175i != this.f18175i) goto L33;
        return true;
    L33:
        return false;
    }

    public int hashCode() {
        int r1 = (((((((527 + this.f18167a.hashCode()) * 31) + this.f18168b.hashCode()) * 31) + this.f18170d.hashCode()) * 31) + this.f18171e.hashCode()) * 31;
        long r2 = this.f18169c;
        return ((((((((r1 + ((int) (r2 ^ (r2 >>> 32)))) * 31) + (!this.f18172f ? 1 : 0)) * 31) + (!this.f18173g ? 1 : 0)) * 31) + (!this.f18174h ? 1 : 0)) * 31) + (!this.f18175i ? 1 : 0);
    }

    String j(boolean r6) {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.f18167a);
        r0.append('=');
        r0.append(this.f18168b);
        if (this.f18174h == false) goto L10;
        if (this.f18169c != Long.MIN_VALUE) goto L7;
        String r1 = "; max-age=0";
    L8:
        r0.append(r1);
        goto L10
    L7:
        r0.append("; expires=");
        r1 = d.a(new Date(this.f18169c));
    L10:
        if (this.f18175i == true) goto L15;
        r0.append("; domain=");
        if (r6 == false) goto L14;
        r0.append(".");
    L14:
        r0.append(this.f18170d);
    L15:
        r0.append("; path=");
        r0.append(this.f18171e);
        if (this.f18172f == false) goto L19;
        r0.append("; secure");
    L19:
        if (this.f18173g == false) goto L22;
        r0.append("; httponly");
    L22:
        return r0.toString();
    }

    public String k() {
        return this.f18168b;
    }

    public String toString() {
        return j(false);
    }
}
