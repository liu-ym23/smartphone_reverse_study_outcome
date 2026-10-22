package tmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class mf extends k3 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f352a;
        public String b;
        public int c;
        public long d;
        public int e;
        public String f;
        public String g;
        public int h;
        public String i;
        public int j;
        public Map k;
        public boolean l;
        public String m;
        public String n;
        public boolean o;
        public boolean p;
        public boolean q;
        public boolean r;
        public m7 s;
        public i7 t;
        public boolean u;
        public boolean v;
        public boolean w;
        public boolean x;
        public Set y;
        public n7 z;

        public a(Context r4, m7 r5) {
            this.b = "";
            this.c = 5000;
            this.d = 60000;
            this.e = 3;
            this.f = "";
            this.g = "";
            this.h = 0;
            this.i = "";
            this.j = 0;
            this.k = new HashMap();
            this.l = true;
            this.m = "";
            this.n = "";
            this.o = true;
            this.p = true;
            this.q = false;
            this.r = true;
            this.u = false;
            this.v = false;
            this.w = false;
            this.x = false;
            this.z = null;
            this.f352a = r4.getApplicationContext();
            this.s = r5;
        }

        public static /* synthetic */ int A(a r0) {
            return r0.e;
        }

        public static /* synthetic */ String B(a r0) {
            return r0.g;
        }

        public static /* synthetic */ String C(a r0) {
            return r0.f;
        }

        public static /* synthetic */ int a(a r0) {
            return r0.h;
        }

        public static /* synthetic */ String b(a r0) {
            return r0.i;
        }

        public static /* synthetic */ Map c(a r0) {
            return r0.k;
        }

        public static /* synthetic */ Context d(a r0) {
            return r0.f352a;
        }

        public static /* synthetic */ String e(a r0) {
            return r0.b;
        }

        public static /* synthetic */ int f(a r0) {
            return r0.j;
        }

        public static /* synthetic */ boolean g(a r0) {
            return r0.l;
        }

        public static /* synthetic */ String h(a r0) {
            return r0.m;
        }

        public static /* synthetic */ String i(a r0) {
            return r0.n;
        }

        public static /* synthetic */ boolean j(a r0) {
            return r0.o;
        }

        public static /* synthetic */ boolean k(a r0) {
            return r0.p;
        }

        public static /* synthetic */ boolean l(a r0) {
            return r0.q;
        }

        public static /* synthetic */ boolean m(a r0) {
            return r0.r;
        }

        public static /* synthetic */ m7 n(a r0) {
            return r0.s;
        }

        public static /* synthetic */ i7 o(a r0) {
            return r0.t;
        }

        public static /* synthetic */ int p(a r0) {
            return r0.c;
        }

        public static /* synthetic */ l7 q(a r0) {
            r0.getClass();
            return null;
        }

        public static /* synthetic */ j7 r(a r0) {
            r0.getClass();
            return null;
        }

        public static /* synthetic */ boolean s(a r0) {
            return r0.u;
        }

        public static /* synthetic */ boolean t(a r0) {
            return r0.v;
        }

        public static /* synthetic */ boolean u(a r0) {
            return r0.w;
        }

        public static /* synthetic */ boolean v(a r0) {
            return r0.x;
        }

        public static /* synthetic */ k7 w(a r0) {
            r0.getClass();
            return null;
        }

        public static /* synthetic */ Set x(a r0) {
            return r0.y;
        }

        public static /* synthetic */ n7 y(a r0) {
            return r0.z;
        }

        public static /* synthetic */ long z(a r2) {
            return r2.d;
        }

        public final a a(boolean r1) {
            this.p = r1;
            return this;
        }

        public final mf a() {
            return new mf(this);
        }

        public final a a(Set r1) {
            this.y = r1;
            return this;
        }

        public final a a(i7 r1) {
            this.t = r1;
            return this;
        }

        public final a a(n7 r1) {
            this.z = r1;
            return this;
        }
    }

    public mf(a r3) {
        a(a.d(r3));
        this.f = a.e(r3);
        this.v = a.p(r3);
        this.w = a.z(r3);
        this.x = a.A(r3);
        this.l = a.B(r3);
        this.k = a.C(r3);
        this.m = a.a(r3);
        this.n = a.b(r3);
        this.o = a.c(r3);
        this.e = a.f(r3);
        this.g = a.g(r3);
        this.p = a.h(r3);
        this.j = a.i(r3);
        this.s = a.j(r3);
        this.q = a.k(r3);
        this.r = a.l(r3);
        this.t = a.m(r3);
        this.c = a.n(r3);
        this.d = a.o(r3);
        a.q(r3);
        a.r(r3);
        this.u = a.s(r3);
        this.z = a.t(r3);
        this.B = a.u(r3);
        this.C = a.v(r3);
        a.w(r3);
        this.f300a = null;
        this.A = a.x(r3);
        this.b = a.y(r3);
        a();
    }

    public static a a(Context r1, m7 r2) {
        return new a(r1, r2);
    }

    public static String d() {
        AtomicBoolean r0 = d8.b;
        StringBuilder r1 = new StringBuilder();
        Locale r2 = Locale.SIMPLIFIED_CHINESE;
        r1.append(String.format(r2, "TuringFD v%d", new Object[]{90}));
        r1.append(" (A43184BF099FF466, vd, 30eeafe");
        StringBuilder r3 = new StringBuilder();
        if ("".isEmpty() == true) goto L5;
        r3.append(";");
    L5:
        r3.append("rfr");
        if (r3.toString().isEmpty() == true) goto L8;
        r3.append(";");
    L8:
        r3.append("rs");
        String r4 = r3.toString();
        if (TextUtils.isEmpty(r4) == true) goto L11;
        r1.append(", ");
        r1.append(r4);
    L11:
        r1.append(", ");
        StringBuilder r5 = new StringBuilder();
        if ("".isEmpty() == true) goto L14;
        r5.append(";");
    L14:
        r5.append("tmfshark");
        if (r5.toString().isEmpty() == true) goto L17;
        r5.append(";");
    L17:
        r5.append("105478");
        r1.append(r5.toString());
        r1.append(String.format(r2, ", compiled %s)", new Object[]{"2025_04_23_11_10_29"}));
        monitor-enter(k3.class);
        k3 r6 = k3.D;     // Catch: Throwable -> L37
        monitor-exit(k3.class);
        if (r6 == null) goto L36;
        r1.append(" [");
        StringBuilder r7 = new StringBuilder();
        String r8 = p.a("url(").append(TextUtils.join(",", r6.h)).append(")").toString();
        if ("".isEmpty() == true) goto L25;
        r7.append(";");
    L25:
        r7.append(r8);
        String r9 = "c(" + r6.e + ")";
        if (r7.toString().isEmpty() == true) goto L28;
        r7.append(";");
    L28:
        r7.append(r9);
        if (r6.y == true) goto L31;
    L34:
        r1.append(r7.toString());
        r1.append("]");
        goto L36
    L31:
        if (r7.toString().isEmpty() == true) goto L33;
        r7.append(";");
    L33:
        r7.append("ext");
    L36:
        return r1.toString();
    L37:
        th = move-exception;
        throw th;
    }

    public int e() {
        AtomicBoolean r0 = d8.c;
        monitor-enter(r0);
    L44:
        th = move-exception;
        throw th;
    L5:
        if (r0.get() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L44
        return 0;
    L8:
        int r1 = this.e;     // Catch: Throwable -> L44
        if (r1 <= 0) goto L12;
        n0.f360a = r1;     // Catch: Throwable -> L44
    L12:
        if (n0.f360a != 0) goto L16;
        Log.e("TuringFdJava", "please input valid channel!");     // Catch: Throwable -> L44
        monitor-exit(r0);     // Catch: Throwable -> L44
        return -10018;
    L16:
        n0.b = this.z;     // Catch: Throwable -> L44
        monitor-enter(k3.class);     // Catch: Throwable -> L44
        k3.D = this;     // Catch: Throwable -> L41
        monitor-exit(k3.class);     // Catch: Throwable -> L44
        AtomicReference r2 = qk.f459a;     // Catch: Throwable -> L44
        if (TextUtils.isEmpty(null) == true) goto L27;
        AtomicReference r3 = qk.f459a;     // Catch: Throwable -> L44
        monitor-enter(r3);     // Catch: Throwable -> L44
        r3.set(null);     // Catch: Throwable -> L38
        monitor-exit(r3);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L27:
        int r4 = d8.b(this);     // Catch: Throwable -> L44
        if (r4 == 0) goto L31;
        monitor-exit(r0);     // Catch: Throwable -> L44
    L54:
        return r4;
    L31:
        r4 = d8.c(this);     // Catch: Throwable -> L44
        if (r4 == 0) goto L35;
        monitor-exit(r0);     // Catch: Throwable -> L44
        goto L54
    L35:
        s5.b.f499a = this;     // Catch: Throwable -> L44
        d8.a(this);     // Catch: Throwable -> L44
        r0.set(true);     // Catch: Throwable -> L44
        monitor-exit(r0);     // Catch: Throwable -> L44
        return 0;
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    }
}
