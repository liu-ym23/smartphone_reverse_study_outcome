package com.loc;

import android.text.TextUtils;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f7790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Proxy f7791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    o0.a f7792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f7796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f7797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f7798i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f7799j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private b f7800k;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f7801f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f7802g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f7803h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f7804i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f7805j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ a[] f7806k = null;

        static {
            a r0 = new a("NORMAL", 0, 0);
            f7801f = r0;
            a r1 = new a("INTERRUPT_IO", 1, 1);
            f7802g = r1;
            a r3 = new a("NEVER", 2, 2);
            f7803h = r3;
            a r5 = new a("FIX", 3, 3);
            f7804i = r5;
            a r7 = new a("SINGLE", 4, 4);
            f7805j = r7;
            f7806k = new a[]{r0, r1, r3, r5, r7};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f7806k.clone();
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f7807g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f7808h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f7809i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final b f7810j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final b f7811k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final b f7812l = null;
        public static final b m = null;
        private static final /* synthetic */ b[] n = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f7813f;

        static {
            b r0 = new b("FIRST_NONDEGRADE", 0, 0);
            f7807g = r0;
            b r1 = new b("NEVER_GRADE", 1, 1);
            f7808h = r1;
            b r3 = new b("DEGRADE_BYERROR", 2, 2);
            f7809i = r3;
            b r5 = new b("DEGRADE_ONLY", 3, 3);
            f7810j = r5;
            b r7 = new b("FIX_NONDEGRADE", 4, 4);
            f7811k = r7;
            b r9 = new b("FIX_DEGRADE_BYERROR", 5, 5);
            f7812l = r9;
            b r11 = new b("FIX_DEGRADE_ONLY", 6, 6);
            m = r11;
            n = new b[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.f7813f = r3;
        }

        public static b valueOf(String r1) {
            return (b) Enum.valueOf(b.class, r1);
        }

        public static b[] values() {
            return (b[]) n.clone();
        }

        public final int a() {
            return this.f7813f;
        }

        public final boolean b() {
            int r1 = this.f7813f;
            if (r1 != f7807g.f7813f) goto L5;
            return true;
        L5:
            if (r1 != f7808h.f7813f) goto L7;
            return true;
        L7:
            if (r1 == f7811k.f7813f) goto L14;
            return false;
        L14:
            return true;
        }

        public final boolean c() {
            int r1 = this.f7813f;
            if (r1 != f7809i.f7813f) goto L5;
            return true;
        L5:
            if (r1 != f7810j.f7813f) goto L7;
            return true;
        L7:
            if (r1 != f7812l.f7813f) goto L9;
            return true;
        L9:
            if (r1 == m.f7813f) goto L17;
            return false;
        L17:
            return true;
        }

        public final boolean g() {
            int r1 = this.f7813f;
            if (r1 != f7809i.f7813f) goto L5;
            return true;
        L5:
            if (r1 == f7812l.f7813f) goto L11;
            return false;
        L11:
            return true;
        }

        public final boolean j() {
            if (this.f7813f != f7808h.f7813f) goto L6;
            return true;
        L6:
            return false;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f7814f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f7815g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ c[] f7816h = null;

        static {
            c r0 = new c("HTTP", 0, 0);
            f7814f = r0;
            c r1 = new c("HTTPS", 1, 1);
            f7815g = r1;
            f7816h = new c[]{r0, r1};
        }

        private c(String r1, int r2, int r3) {
            super(r1, r2);
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f7816h.clone();
        }
    }

    public t0() {
        this.f7790a = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
        this.f7791b = null;
        this.f7793d = false;
        this.f7794e = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
        this.f7795f = true;
        this.f7799j = a.f7801f;
        this.f7800k = b.f7807g;
    }

    private static String a(Map<String, String> r3) {
        if (r3 != null) goto L12;
        return null;
    L12:
    L9:
        th = move-exception;
        s.e(th, "ht", "pnfh");
        return null;
    L6:
        if (r3.containsKey("platinfo") == false) goto L14;
        return n(r3.get("platinfo"));
    L14:
        return null;
    }

    private String k(String r2) {
        byte[] r0 = q();
        if (r0 != null) goto L5;
    L16:
        return r2;
    L5:
        if (r0.length == 0) goto L16;
        Map<String, String> r1 = r();
        HashMap<String, String> r3 = o0.f7585e;
        if (r3 == null) goto L12;
        if (r1 == null) goto L11;
        r1.putAll(r3);
        goto L12
    L11:
        r1 = r3;
    L12:
        if (r1 != null) goto L14;
        return r2;
    L14:
        String r4 = r0.f(r1);
        StringBuffer r5 = new StringBuffer();
        r5.append(r2);
        r5.append("?");
        r5.append(r4);
        return r5.toString();
    }

    private static String n(String r8) {
        String r1 = "";
    L29:
        th = move-exception;
        s.e(th, "ht", "pnfp");
    L31:
        return r1;
    L4:
        if (TextUtils.isEmpty(r8) == true) goto L31;
        String[] r9 = r8.split("&");     // Catch: Throwable -> L29
        if (r9.length <= 1) goto L31;
        int r2 = r9.length;     // Catch: Throwable -> L29
        int r4 = 0;
        String r5 = "";
    L8:
        if (r4 >= r2) goto L16;
        String r6 = r9[r4];     // Catch: Throwable -> L29
        if (r6.contains("sdkversion") == false) goto L13;
        r5 = r6;
    L13:
        if (r6.contains("product") == true) goto L18;
        r4 = r4 + 1;     // Catch: Throwable -> L29
    L18:
        if (TextUtils.isEmpty(r6) == true) goto L31;
        String[] r10 = r6.split("=");     // Catch: Throwable -> L29
        if (r10.length <= 1) goto L31;
        r1 = r10[1].trim();     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r5) == true) goto L31;
        if (TextUtils.isEmpty(g.a(r1)) == false) goto L31;
        String[] r11 = r5.split("=");     // Catch: Throwable -> L29
        if (r11.length <= 1) goto L31;
        g.b(r1, r11[1].trim());     // Catch: Throwable -> L29
        goto L31
    L16:
        r6 = "";
        goto L18
    }

    public final void A() {
        this.f7793d = true;
    }

    protected final boolean B() {
        return this.f7798i;
    }

    public final o0.a C() {
        return this.f7792c;
    }

    protected final b D() {
        return this.f7800k;
    }

    protected final int E() {
        return this.f7794e;
    }

    public final void F() {
        this.f7795f = false;
    }

    protected final String G() {
        return this.f7796g;
    }

    protected final boolean H() {
        return this.f7797h;
    }

    protected final String I() {
        String r0 = p();     // Catch: Throwable -> L12
    L10:
        th = th;
    L14:
        s.e(th, "ht", "pnfr");
    L16:
        return r0;
    L4:
        if (TextUtils.isEmpty(r0) == false) goto L16;
        if (this.f7793d == true) goto L20;
        r0 = a(b());     // Catch: Throwable -> L10
        goto L16
    L20:
        return n(((p0) this).S());
    L12:
        th = th;
        r0 = "";
        goto L14
    }

    public abstract Map<String, String> b();

    public final void c(int r1) {
        this.f7790a = r1;
    }

    public final void d(a r1) {
        this.f7799j = r1;
    }

    public final void e(b r1) {
        this.f7800k = r1;
    }

    public final void f(c r2) {
        if (r2 != c.f7815g) goto L5;
        boolean r3 = true;
    L6:
        this.f7798i = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final void g(String r1) {
        this.f7796g = r1;
    }

    public final void h(Proxy r1) {
        this.f7791b = r1;
    }

    public final void i(boolean r1) {
        this.f7797h = r1;
    }

    public abstract String j();

    public final void l(int r1) {
    }

    public String m() {
        return j();
    }

    public final void o(int r1) {
        this.f7794e = r1;
    }

    public String p() {
        return "";
    }

    public abstract byte[] q();

    public abstract Map<String, String> r();

    protected String s() {
        return "";
    }

    protected boolean t() {
        return this.f7795f;
    }

    final String u() {
        return k(j());
    }

    final String v() {
        return k(m());
    }

    public final int w() {
        return this.f7790a;
    }

    public final Proxy x() {
        return this.f7791b;
    }

    protected final a y() {
        return this.f7799j;
    }

    protected final boolean z() {
        return this.f7793d;
    }
}
