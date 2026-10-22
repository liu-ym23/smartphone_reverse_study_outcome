package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g5 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static j4 f7337g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static z f7338h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static long f7339i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f7341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    j4 f7342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    j4 f7343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f7344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f7345f;

    static {
    }

    public g5(Context r3) {
        this.f7341b = null;
        this.f7342c = null;
        this.f7343d = null;
        this.f7344e = 0;
        this.f7345f = false;
        this.f7340a = r3.getApplicationContext();
    }

    private void g() {
        if (f7337g != null) goto L5;
    L6:
        j4 r4 = h();
        f7339i = a5.A();
        if (r4 != null) goto L9;
        return;
    L9:
        if (a5.p(r4.a()) == false) goto L14;
        f7337g = r4;
        return;
    L14:
        return;
    L5:
        if ((a5.A() - f7339i) > 180000) goto L6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private j4 h() {
        String r1 = null;
        if (this.f7340a != null) goto L5;
        return null;
    L5:
        b();
        z r0 = f7338h;     // Catch: Throwable -> L44
        if (r0 != null) goto L9;
        return null;
    L9:
        List r2 = r0.f("_id=1", j4.class);     // Catch: Throwable -> L44
        if (r2 != null) goto L12;
    L35:
        j4 r3 = null;
    L37:
        if (TextUtils.isEmpty(r1) == true) goto L51;
        AMapLocation r6 = new AMapLocation("");     // Catch: Throwable -> L42
        s4.f(r6, new JSONObject(r1));     // Catch: Throwable -> L42
        if (a5.F(r6) == false) goto L52;
        r3.c(r6);     // Catch: Throwable -> L42
        return r3;
    L42:
        th = th;
        r1 = r3;
    L45:
        s4.h(th, "LastLocationManager", "readLastFix");
        return r1;
    L52:
        return r3;
    L51:
        return r3;
    L12:
        if (r2.size() <= 0) goto L35;
        r3 = (j4) r2.get(0);     // Catch: Throwable -> L44
        byte[] r4 = m5.g(r3.g());     // Catch: Throwable -> L42
        if (r4 != null) goto L18;
    L24:
        String r5 = null;
    L25:
        byte[] r7 = m5.g(r3.e());     // Catch: Throwable -> L42
        if (r7 != null) goto L28;
    L34:
        r3.d(r1);     // Catch: Throwable -> L42
        r1 = r5;
        goto L37
    L28:
        if (r7.length <= 0) goto L34;
        byte[] r8 = h4.h(r7, this.f7341b);     // Catch: Throwable -> L42
        if (r8 == null) goto L34;
        if (r8.length <= 0) goto L34;
        r1 = new String(r8, "UTF-8");     // Catch: Throwable -> L42
        goto L34
    L18:
        if (r4.length <= 0) goto L24;
        byte[] r9 = h4.h(r4, this.f7341b);     // Catch: Throwable -> L42
        if (r9 == null) goto L24;
        if (r9.length <= 0) goto L24;
        r5 = new String(r9, "UTF-8");     // Catch: Throwable -> L42
    L44:
        th = th;
        goto L45
    }

    public final AMapLocation a(AMapLocation r8, String r9, long r10) {
        if (r8 != null) goto L5;
        return r8;
    L5:
        if (r8.U() != 0) goto L7;
        return r8;
    L7:
        if (r8.Y() != 1) goto L9;
        return r8;
    L9:
        if (r8.U() == 7) goto L44;
        g();     // Catch: Throwable -> L33
        j4 r7 = f7337g;     // Catch: Throwable -> L33
        if (r7 != null) goto L14;
    L32:
        return r8;
    L14:
        if (r7.a() == null) goto L32;
        boolean r11 = false;
        if (TextUtils.isEmpty(r9) == false) goto L24;
        long r2 = a5.A() - f7337g.h();     // Catch: Throwable -> L33
        if (r2 >= 0) goto L21;
    L23:
        r8.T0(3);     // Catch: Throwable -> L33
    L25:
        if (r11 == false) goto L42;
        AMapLocation r12 = f7337g.a();     // Catch: Throwable -> L33
        r12.L0(9);     // Catch: Throwable -> L30
        r12.G0(true);     // Catch: Throwable -> L30
        r12.J0(r8.X());     // Catch: Throwable -> L30
        return r12;
    L30:
        th = move-exception;
        r8 = r12;
        th = th;
    L34:
        s4.h(th, "LastLocationManager", "fixLastLocation");
        return r8;
    L42:
        return r8;
    L21:
        if (r2 > r10) goto L23;
        r11 = true;
        goto L23
    L24:
        r11 = a5.s(f7337g.e(), r9);     // Catch: Throwable -> L33
        r8.T0(2);     // Catch: Throwable -> L33
    L33:
        th = th;
        goto L34
    L44:
        return r8;
    }

    public final void b() {
        if (this.f7345f == false) goto L16;
        return;
    L16:
    L12:
        th = move-exception;
        s4.h(th, "LastLocationManager", "<init>:DBOperation");
    L14:
        this.f7345f = true;
        return;
    L6:
        if (this.f7341b != null) goto L9;
        this.f7341b = h4.b("MD5", l5.P());     // Catch: Throwable -> L12
    L9:
        if (f7338h != null) goto L14;
        y r0 = z.c(k4.class);     // Catch: Throwable -> L12
        f7338h = new z(this.f7340a, r0);     // Catch: Throwable -> L12
        goto L14
    }

    public final boolean c(AMapLocation r6, String r7) {
        if (this.f7340a == null) goto L30;
        if (r6 == null) goto L30;
        if (a5.p(r6) == false) goto L30;
        if (r6.Y() == 2) goto L30;
        if (r6.isMock() == true) goto L30;
        if (r6.k0() == true) goto L30;
        j4 r0 = new j4();
        r0.c(r6);
        if (r6.Y() != 1) goto L18;
        r0.d(null);
    L31:
        f7337g = r0;     // Catch: Throwable -> L28
        f7339i = a5.A();     // Catch: Throwable -> L28
        this.f7342c = r0;     // Catch: Throwable -> L28
        j4 r8 = this.f7343d;     // Catch: Throwable -> L28
        if (r8 != null) goto L22;
    L24:
        if ((a5.A() - this.f7344e) <= 30000) goto L30;
        return true;
    L22:
        if (a5.c(r8.a(), r0.a()) > 500.0f) goto L24;
        return false;
    L28:
        th = move-exception;
        s4.h(th, "LastLocationManager", "setLastFix");
        goto L30
    L18:
        r0.d(r7);
    L30:
        return false;
    }

    public final AMapLocation d() {
        g();
        j4 r1 = f7337g;
        if (r1 != null) goto L6;
        return null;
    L6:
        if (a5.p(r1.a()) == true) goto L9;
        return null;
    L9:
        return f7337g.a();
    }

    public final void e() {
        f();     // Catch: Throwable -> L4
        this.f7344e = 0;     // Catch: Throwable -> L4
        this.f7345f = false;     // Catch: Throwable -> L4
        this.f7342c = null;     // Catch: Throwable -> L4
        this.f7343d = null;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "LastLocationManager", "destroy");
    }

    public final void f() {
        b();     // Catch: Throwable -> L27
        j4 r1 = this.f7342c;     // Catch: Throwable -> L27
        if (r1 != null) goto L6;
        return;
    L6:
        if (a5.p(r1.a()) == true) goto L8;
        return;
    L8:
        if (f7338h == null) goto L34;
        j4 r2 = this.f7342c;     // Catch: Throwable -> L27
        if (r2 != this.f7343d) goto L12;
        return;
    L12:
        if (r2.h() != 0) goto L36;
        String r3 = this.f7342c.a().V0();     // Catch: Throwable -> L27
        String r4 = this.f7342c.e();     // Catch: Throwable -> L27
        this.f7343d = this.f7342c;     // Catch: Throwable -> L27
        String r5 = null;
        if (TextUtils.isEmpty(r3) == true) goto L20;
        String r6 = m5.f(h4.e(r3.getBytes("UTF-8"), this.f7341b));     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r4) == true) goto L19;
        r5 = m5.f(h4.e(r4.getBytes("UTF-8"), this.f7341b));     // Catch: Throwable -> L27
    L19:
        String r0 = r5;
        r5 = r6;
    L22:
        if (TextUtils.isEmpty(r5) == true) goto L37;
        j4 r7 = new j4();     // Catch: Throwable -> L27
        r7.f(r5);     // Catch: Throwable -> L27
        r7.b(a5.A());     // Catch: Throwable -> L27
        r7.d(r0);     // Catch: Throwable -> L27
        f7338h.i(r7, "_id=1");     // Catch: Throwable -> L27
        this.f7344e = a5.A();     // Catch: Throwable -> L27
        j4 r8 = f7337g;     // Catch: Throwable -> L27
        if (r8 == null) goto L38;
        r8.b(a5.A());     // Catch: Throwable -> L27
        return;
    L38:
        return;
    L37:
        return;
    L20:
        r0 = null;
        goto L22
    L36:
        return;
    L34:
        return;
    L27:
        th = move-exception;
        s4.h(th, "LastLocationManager", "saveLastFix");
    }
}
