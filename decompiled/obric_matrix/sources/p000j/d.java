package p000j;

import java.util.concurrent.TimeUnit;
import p000j.k0.g.e;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f17690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f17691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f17692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f17693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f17694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f17695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f17696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f17697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f17698i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f17699j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f17700k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f17701l;
    String m;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f17702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f17703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f17704c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f17705d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f17706e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f17707f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f17708g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f17709h;

        public a() {
            this.f17704c = -1;
            this.f17705d = -1;
            this.f17706e = -1;
        }

        public d a() {
            return new d(this);
        }

        public a b(int r3, TimeUnit r4) {
            if (r3 < 0) goto L10;
            long r5 = r4.toSeconds(r3);
            if (r5 <= 2147483647L) goto L6;
            int r6 = Integer.MAX_VALUE;
        L7:
            this.f17705d = r6;
            return this;
        L6:
            r6 = (int) r5;
            goto L7
        L10:
            throw new IllegalArgumentException("maxStale < 0: " + r3);
        }

        public a c() {
            this.f17702a = true;
            return this;
        }

        public a d() {
            this.f17707f = true;
            return this;
        }
    }

    static {
        a r0 = new a();
        r0.c();
        r0.a();
        a r1 = new a();
        r1.d();
        r1.b(Integer.MAX_VALUE, TimeUnit.SECONDS);
        r1.a();
    }

    d(a r2) {
        this.f17690a = r2.f17702a;
        this.f17691b = r2.f17703b;
        this.f17692c = r2.f17704c;
        this.f17693d = -1;
        this.f17694e = false;
        this.f17695f = false;
        this.f17696g = false;
        this.f17697h = r2.f17705d;
        this.f17698i = r2.f17706e;
        this.f17699j = r2.f17707f;
        this.f17700k = r2.f17708g;
        this.f17701l = r2.f17709h;
    }

    private d(boolean r1, boolean r2, int r3, int r4, boolean r5, boolean r6, boolean r7, int r8, int r9, boolean r10, boolean r11, boolean r12, String r13) {
        this.f17690a = r1;
        this.f17691b = r2;
        this.f17692c = r3;
        this.f17693d = r4;
        this.f17694e = r5;
        this.f17695f = r6;
        this.f17696g = r7;
        this.f17697h = r8;
        this.f17698i = r9;
        this.f17699j = r10;
        this.f17700k = r11;
        this.f17701l = r12;
        this.m = r13;
    }

    private String a() {
        StringBuilder r0 = new StringBuilder();
        if (this.f17690a == false) goto L6;
        r0.append("no-cache, ");
    L6:
        if (this.f17691b == false) goto L9;
        r0.append("no-store, ");
    L9:
        if (this.f17692c == (-1)) goto L12;
        r0.append("max-age=");
        r0.append(this.f17692c);
        r0.append(", ");
    L12:
        if (this.f17693d == (-1)) goto L15;
        r0.append("s-maxage=");
        r0.append(this.f17693d);
        r0.append(", ");
    L15:
        if (this.f17694e == false) goto L18;
        r0.append("private, ");
    L18:
        if (this.f17695f == false) goto L21;
        r0.append("public, ");
    L21:
        if (this.f17696g == false) goto L24;
        r0.append("must-revalidate, ");
    L24:
        if (this.f17697h == (-1)) goto L27;
        r0.append("max-stale=");
        r0.append(this.f17697h);
        r0.append(", ");
    L27:
        if (this.f17698i == (-1)) goto L30;
        r0.append("min-fresh=");
        r0.append(this.f17698i);
        r0.append(", ");
    L30:
        if (this.f17699j == false) goto L33;
        r0.append("only-if-cached, ");
    L33:
        if (this.f17700k == false) goto L36;
        r0.append("no-transform, ");
    L36:
        if (this.f17701l == false) goto L39;
        r0.append("immutable, ");
    L39:
        if (r0.length() != 0) goto L42;
        return "";
    L42:
        r0.delete(r0.length() - 2, r0.length());
        return r0.toString();
    }

    public static d k(v r22) {
        int r1 = r22.k();
        int r6 = 0;
        boolean r7 = true;
        String r8 = null;
        boolean r9 = false;
        boolean r10 = false;
        int r11 = -1;
        int r12 = -1;
        boolean r13 = false;
        boolean r14 = false;
        boolean r15 = false;
        int r16 = -1;
        int r17 = -1;
        boolean r18 = false;
        boolean r19 = false;
        boolean r20 = false;
    L3:
        if (r6 >= r1) goto L67;
        String r2 = r22.f(r6);
        String r4 = r22.m(r6);
        if (r2.equalsIgnoreCase("Cache-Control") == false) goto L10;
        if (r8 != null) goto L11;
        r8 = r4;
    L12:
        int r3 = 0;
    L14:
        if (r3 >= r4.length()) goto L66;
        int r5 = e.l(r4, r3, "=,;");
        String r21 = r4.substring(r3, r5).trim();
        if (r5 != r4.length()) goto L18;
    L28:
        int r23 = r5 + 1;
        String r0 = null;
    L30:
        if ("no-cache".equalsIgnoreCase(r21) == false) goto L33;
        r9 = true;
    L65:
        r3 = r23;
        goto L14
    L33:
        if ("no-store".equalsIgnoreCase(r21) == false) goto L36;
        r10 = true;
        goto L65
    L36:
        if ("max-age".equalsIgnoreCase(r21) == false) goto L39;
        r11 = e.f(r0, -1);
        goto L65
    L39:
        if ("s-maxage".equalsIgnoreCase(r21) == false) goto L42;
        r12 = e.f(r0, -1);
        goto L65
    L42:
        if ("private".equalsIgnoreCase(r21) == false) goto L45;
        r13 = true;
        goto L65
    L45:
        if ("public".equalsIgnoreCase(r21) == false) goto L48;
        r14 = true;
        goto L65
    L48:
        if ("must-revalidate".equalsIgnoreCase(r21) == false) goto L51;
        r15 = true;
        goto L65
    L51:
        if ("max-stale".equalsIgnoreCase(r21) == false) goto L54;
        r16 = e.f(r0, Integer.MAX_VALUE);
        goto L65
    L54:
        if ("min-fresh".equalsIgnoreCase(r21) == false) goto L57;
        r17 = e.f(r0, -1);
        goto L65
    L57:
        if ("only-if-cached".equalsIgnoreCase(r21) == false) goto L60;
        r18 = true;
        goto L65
    L60:
        if ("no-transform".equalsIgnoreCase(r21) == false) goto L63;
        r19 = true;
        goto L65
    L63:
        if ("immutable".equalsIgnoreCase(r21) == false) goto L65;
        r20 = true;
        goto L65
    L18:
        if (r4.charAt(r5) == ',') goto L28;
        if (r4.charAt(r5) == ';') goto L28;
        int r24 = e.m(r4, r5 + 1);
        if (r24 < r4.length()) goto L25;
    L27:
        r23 = e.l(r4, r24, ",;");
        r0 = r4.substring(r24, r23).trim();
        goto L30
    L25:
        if (r4.charAt(r24) != '\"') goto L27;
        int r25 = r24 + 1;
        int r26 = e.l(r4, r25, "\"");
        r0 = r4.substring(r25, r26);
        r23 = r26 + 1;
    L66:
        r6 = r6 + 1;
    L11:
        r7 = false;
        goto L12
    L10:
        if (r2.equalsIgnoreCase("Pragma") == false) goto L66;
    L67:
        if (r7 == true) goto L69;
        String r27 = null;
    L71:
        return new d(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r27);
    L69:
        r27 = r8;
        goto L71
    }

    public boolean b() {
        return this.f17694e;
    }

    public boolean c() {
        return this.f17695f;
    }

    public int d() {
        return this.f17692c;
    }

    public int e() {
        return this.f17697h;
    }

    public int f() {
        return this.f17698i;
    }

    public boolean g() {
        return this.f17696g;
    }

    public boolean h() {
        return this.f17690a;
    }

    public boolean i() {
        return this.f17691b;
    }

    public boolean j() {
        return this.f17699j;
    }

    public String toString() {
        String r0 = this.m;
        if (r0 != null) goto L7;
        String r1 = a();
        this.m = r1;
        return r1;
    L7:
        return r0;
    }
}
