package tmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedanceos.security.Utils;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class qj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private qg f455a;
    private volatile boolean b;
    private volatile String c;
    private volatile long d;
    private int e;

    class a implements qg.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f456a;
        final /* synthetic */ int b;
        final /* synthetic */ d1 c;
        final /* synthetic */ qj d;

        a(qj r1, d r2, int r3, d1 r4) {
            this.d = r1;
            this.f456a = r2;
            this.b = r3;
            this.c = r4;
        }

        @Override // tmsdkobf.qg.j
        public void a(boolean r3, int r4, int r5, ArrayList r6) {
            if (r4 == 0) goto L7;
            this.f456a.a(this.b, 1, r4, null);
            return;
        L7:
            if (r6 != null) goto L11;
            this.f456a.a(this.b, 1, -21002600, null);
            return;
        L11:
            if (r6.size() > 0) goto L14;
            this.f456a.a(this.b, 1, -21002600, null);
            return;
        L14:
            ij r7 = (ij) r6.get(0);
            if (r7 != null) goto L18;
            this.f456a.a(this.b, 1, -21002600, null);
            return;
        L18:
            int r8 = r7.d;
            if (r8 == 0) goto L23;
            this.f456a.a(this.b, 1, r8, null);
            return;
        L23:
            if (r7.e == 0) goto L26;
            this.f456a.a(this.b, 1, -21300000, null);
            return;
        L26:
            byte[] r9 = r7.f;
            if (r9 != null) goto L39;
            this.f456a.a(this.b, 1, -21000005, null);
            return;
        L39:
            JceStruct r10 = z7.b(r9, new th(), false);     // Catch: Exception -> L37
            if (r10 != null) goto L35;
            this.f456a.a(this.b, 1, -21000700, null);
            return;
        L35:
            th r11 = (th) r10;
            qj.a(this.d, r11.f531a, this.c, true);
            this.f456a.a(this.b, 1, 0, r11.f531a);
            return;
        L37:
            this.f456a.a(this.b, 1, -21000700, null);
        }
    }

    class b implements a7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ qj f457a;

        b(qj r1) {
            this.f457a = r1;
        }

        @Override // tmsdkobf.a7
        public Cif a(int r1, long r2, int r4, JceStruct r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            this.f457a.a(true, ((bh) r5).f120a);
            return null;
        }
    }

    class c implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d1 f458a;
        final /* synthetic */ qj b;

        c(qj r1, d1 r2) {
            this.b = r1;
            this.f458a = r2;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r1, int r2, int r3, int r4, JceStruct r5) {
            if (r3 != 0) goto L7;
            if (r4 != 0) goto L8;
            qj r6 = this.b;
            qj.a(r6, qj.a(r6), this.f458a, false);
            return;
        L8:
            return;
        }
    }

    public interface d {
        void a(int r1, int r2, int r3, String r4);
    }

    public qj(Context r3, qg r4, int r5) {
        this.b = false;
        this.c = "";
        this.d = 0;
        this.f455a = r4;
        this.e = r5;
        b();
        c();
    }

    private static boolean a(int r0, int r1) {
        if (r0 == r1) goto L4;
        return true;
    L4:
        return false;
    }

    private static boolean a(long r0, long r2) {
        if (r0 == r2) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean a(boolean r0, boolean r1) {
        if (r0 == r1) goto L4;
        return true;
    L4:
        return false;
    }

    private void c() {
        ql r1 = this.f455a.f444a;
        if (r1.f460a.l == true) goto L5;
        return;
    L5:
        b r7 = new b(this);
        r1.a(0, 15081, new bh(), 0, r7);
    }

    public void b() {
        this.c = this.f455a.c().f();
        if (TextUtils.isEmpty(this.c) == false) goto L7;
        this.b = false;
        this.c = this.f455a.c().g();
        if (this.c != null) goto L9;
        this.c = "";
        return;
    L9:
        return;
    L7:
        this.b = true;
    }

    public boolean d() {
        if (this.f455a.f444a.f460a.l == true) goto L7;
        return false;
    L7:
        return e();
    }

    public boolean e() {
        if (TextUtils.isEmpty(a()) == false) goto L5;
        return true;
    L5:
        if (this.b == false) goto L10;
        return false;
    L10:
        return true;
    }

    static /* synthetic */ void a(qj r0, String r1, d1 r2, boolean r3) {
        r0.a(r1, r2, r3);
    }

    static /* synthetic */ String a(qj r0) {
        return r0.c;
    }

    public static void a(Context r4, String r5) {
        Intent r1 = new Intent(String.format("action.reg.guid:%s", new Object[]{r4.getPackageName()}));     // Catch: Throwable -> L5
        r1.setPackage(r4.getPackageName());     // Catch: Throwable -> L5
        r1.putExtra("k.s.p", r5);     // Catch: Throwable -> L5
        r4.sendBroadcast(r1, rd.f());     // Catch: Throwable -> L5
        return;
    }

    private d1 b(boolean r3, String r4) {
        if (d() == false) goto L6;
        return null;
    L6:
        if (a(r3) == true) goto L8;
        return null;
    L8:
        d1 r5 = a(this.f455a.c());
        if (r5 != null) goto L12;
        return null;
    L12:
        if (TextUtils.isEmpty(r4) == true) goto L14;
        return r5;
    L14:
        d1 r6 = this.f455a.c().i();
        if (r6 != null) goto L17;
        return r5;
    L17:
        boolean r7 = a(r5, r6);
        if (r7 == true) goto L26;
        String r8 = this.f455a.c().g();
        String r2 = a();
        if (TextUtils.isEmpty(r8) == false) goto L22;
    L27:
        return null;
    L22:
        if (TextUtils.isEmpty(r2) == true) goto L27;
        if (r8.equals(r2) == true) goto L27;
    L28:
        return r5;
    L26:
        if (r7 == true) goto L28;
        goto L27
    }

    public static void a(Context r4, String r5, int r6, String r7) {
        Intent r1 = new Intent(String.format("action.guid.got:%s", new Object[]{r4.getPackageName()}));     // Catch: Throwable -> L5
        r1.putExtra("k.s.p", r5);     // Catch: Throwable -> L5
        r1.putExtra("k.rc", r6);     // Catch: Throwable -> L5
        r1.putExtra("k.g", r7);     // Catch: Throwable -> L5
        r4.sendBroadcast(r1, rd.f());     // Catch: Throwable -> L5
        return;
    }

    public void a(d r12) {
        if (d() == true) goto L6;
        r12.a(0, 1, 0, this.c);
        return;
    L6:
        d1 r0 = a(this.f455a.c());
        pi r2 = new pi();
        int r3 = jl.b().a();
        r2.b = r3;
        r2.f422a = 1;
        byte[] r4 = z7.a(r0);
        r2.d = r4;
        if (r4 != null) goto L10;
        r12.a(r3, 1, -20001500, null);
        return;
    L10:
        ArrayList r1 = new ArrayList();
        r1.add(r2);
        this.f455a.f444a.k().a(r2.b, 1, -1, null);
        this.f455a.a(r1, new a(this, r12, r3, r0));
    }

    private void a(String r3, d1 r4, boolean r5) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        this.c = r3;
        this.b = true;
        this.f455a.c().e(this.e);
        this.f455a.c().a(r3, r5);
        this.f455a.c().b(r3, r5);
        this.f455a.c().a(r4);
    }

    private static boolean b(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return true;
    L10:
        return !r2.equals(r3);
    }

    private void b(d1 r9, String r10) {
        tg r2 = a(r9, r10);
        this.f455a.f444a.a(2, r2, null, 0, new c(this, r9), 60000);
    }

    public void a(boolean r1, String r2) {
        d1 r3 = b(r1, r2);
        if (r3 != null) goto L5;
        return;
    L5:
        b(r3, r2);
    }

    private boolean a(boolean r8) {
        long r0 = System.currentTimeMillis();
        if (r8 == false) goto L7;
        this.d = r0;
        this.f455a.c().a(r0);
        return true;
    L7:
        if (this.d > 0) goto L10;
        this.d = r0;
    L13:
        long r3 = this.f455a.c().h();
        if (r3 > 0) goto L17;
        this.f455a.c().a(r0);
    L19:
        return false;
    L17:
        if (bk.a(r0, r3, Utils.WIDTH_THRESHOLD_H) == false) goto L19;
        this.f455a.c().a(r0);
        return true;
    L10:
        if (bk.a(r0, this.d, 60) == false) goto L19;
        this.d = r0;
        goto L13
    }

    public static boolean a(d1 r4, d1 r5) {
        if (b(r4.f141a, r5.f141a) == false) goto L5;
    L140:
        return true;
    L5:
        if (b(r4.b, r5.b) == true) goto L140;
        if (b(r4.L, r5.L) == true) goto L140;
        if (b(r4.K, r5.K) == true) goto L140;
        if (b(r4.c, r5.c) == true) goto L140;
        if (b(r4.d, r5.d) == true) goto L140;
        if (b(r4.e, r5.e) == true) goto L140;
        if (a(r4.f, r5.f) == true) goto L140;
        if (b(r4.g, r5.g) == true) goto L140;
        if (a(r4.h, r5.h) == true) goto L140;
        if (b(r4.i, r5.i) == true) goto L140;
        if (a(r4.j, r5.j) == true) goto L140;
        if (a(r4.k, r5.k) == true) goto L140;
        if (a(r4.l, r5.l) == true) goto L140;
        if (b(r4.m, r5.m) == true) goto L140;
        if (b(r4.n, r5.n) == true) goto L140;
        if (a(r4.o, r5.o) == true) goto L140;
        if (b(r4.p, r5.p) == true) goto L140;
        if (a(r4.q, r5.q) == true) goto L140;
        if (a(r4.r, r5.r) == true) goto L140;
        if (TextUtils.isEmpty(r4.s) == true) goto L47;
        if (TextUtils.isEmpty(r5.s) == true) goto L140;
    L47:
        if (b(r4.V, r5.V) == true) goto L140;
        if (b(r4.t, r5.t) == true) goto L140;
        if (a(r4.u, r5.u) == true) goto L140;
        if (b(r4.v, r5.v) == true) goto L140;
        if (a(r4.w, r5.w) == true) goto L140;
        if (a(r4.x, r5.x) == true) goto L140;
        if (a(r4.y, r5.y) == true) goto L140;
        if (a(r4.a0, r5.a0) == true) goto L140;
        if (b(r4.z, r5.z) == true) goto L140;
        if (b(r4.A, r5.A) == true) goto L140;
        if (b(r4.B, r5.B) == true) goto L140;
        if (b(r4.P, r5.P) == true) goto L140;
        if (a(r4.Q, r5.Q) == true) goto L140;
        if (b(r4.R, r5.R) == true) goto L140;
        if (b(r4.E, r5.E) == true) goto L140;
        if (a(r4.H, r5.H) == true) goto L140;
        if (a(r4.I, r5.I) == true) goto L140;
        if (b(r4.S, r5.S) == true) goto L140;
        if (b(r4.T, r5.T) == true) goto L140;
        if (b(r4.U, r5.U) == true) goto L140;
        if (b(r4.W, r5.W) == true) goto L140;
        if (b(r4.X, r5.X) == true) goto L140;
        if (b(r4.Y, r5.Y) == true) goto L140;
        if (b(r4.Z, r5.Z) == true) goto L140;
        if (b(r4.F, r5.F) == true) goto L140;
        if (b(r4.b0, r5.b0) == true) goto L140;
        if (b(r4.G, r5.G) == true) goto L140;
        if (b(r4.C, r5.C) == true) goto L140;
        if (b(r4.D, r5.D) == true) goto L140;
        if (b(r4.c0, r5.c0) == true) goto L140;
        if (a(r4.f140J, r5.f140J) == true) goto L140;
        if (a(r4.d0, r5.d0) == true) goto L140;
        if (b(r4.e0, r5.e0) == true) goto L140;
        if (b(r4.f0, r5.f0) == true) goto L140;
        if (b(r4.g0, r5.g0) == true) goto L140;
        if (b(r4.i0, r5.i0) == true) goto L140;
        if (b(r4.j0, r5.j0) == true) goto L140;
        if (b(r4.k0, r5.k0) == true) goto L140;
        if (b(r4.l0, r5.l0) == true) goto L140;
        if (b(r4.m0, r5.m0) == true) goto L140;
        if (b(r4.n0, r5.n0) == true) goto L140;
        if (b(r4.o0, r5.o0) == true) goto L140;
        if (b(r4.p0, r5.p0) == true) goto L140;
        if (a(r4.q0, r5.q0) == true) goto L140;
        if (a(r4.r0, r5.r0) == true) goto L140;
        if (a(r4.s0, r5.s0) == true) goto L140;
        return false;
    }

    private static boolean a(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == false) goto L8;
        boolean r3 = TextUtils.isEmpty(r2);
    L6:
        return !r3;
    L8:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        r3 = TextUtils.isEmpty(r1);
        goto L6
    L10:
        r3 = r1.equals(r2);
        goto L6
    }

    public String a() {
        if (this.c == null) goto L5;
        String r0 = this.c;
    L7:
        if (TextUtils.isEmpty(r0) == false) goto L9;
        return r0;
    L9:
        return r0 + this.f455a.f444a.f460a.w;
    L5:
        r0 = "";
        goto L7
    }

    static d1 a(z6 r1) {
        d1 r2 = r1.l();
        if (r2 == null) goto L9;
        if (r2.f141a != null) goto L7;
        r2.f141a = "";
    L7:
        return r2;
    L9:
        throw new RuntimeException("onGetRealInfoOfGuid() return null");
    }

    private tg a(d1 r2, String r3) {
        tg r0 = new tg();
        r0.f530a = r2;
        r0.b = a();
        r0.c = this.f455a.c().g();
        r0.d = r3;
        return r0;
    }
}
