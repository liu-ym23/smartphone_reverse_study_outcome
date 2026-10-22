package com.bytedance.bdinstall;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i0 {
    private final boolean A;
    private final boolean B;
    private final boolean C;
    private Account D;
    private final w E;
    private final boolean F;
    private final boolean G;
    private final boolean H;
    private final boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final z f2795J;
    private final boolean K;
    private final q0 L;
    private final boolean M;
    private final boolean N;
    private final boolean O;
    private SharedPreferences P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d0 f2797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f2798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f2799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f2800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f2801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f2802g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f2803h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f2804i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final v f2805j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f2806k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f2807l;
    private final String m;
    private final JSONObject n;
    private final Map<String, Object> o;
    private final boolean p;
    private final h q;
    private final boolean r;
    private final c0 s;
    private final y t;
    private final f0 u;
    private final boolean v;
    private final com.bytedance.bdinstall.y0.b w;
    private final com.bytedance.bdinstall.y0.c x;
    private final com.bytedance.bdinstall.y0.a y;
    private final a0 z;

    i0(k r2) {
        this.P = null;
        this.f2798c = r2.n;
        this.f2796a = r2.f2837l;
        d0 r0 = r2.m;
        if (r0 != null) goto L6;
        r0 = new n();
    L6:
        this.f2797b = r0;
        if (TextUtils.isEmpty(r2.o) == false) goto L9;
        String r1 = "applog_stats";
    L10:
        this.f2799d = r1;
        this.f2800e = r2.p;
        this.f2801f = r2.v;
        this.f2802g = r2.w;
        this.f2803h = r2.x;
        this.f2804i = r2.y;
        this.f2805j = r2.z;
        this.f2806k = r2.A;
        String r3 = r2.B;
        this.f2807l = r2.C;
        this.m = r2.D;
        this.n = r2.E;
        this.o = r2.F;
        this.E = r2.f2835j;
        this.F = r2.f2836k;
        this.G = r2.f2834i;
        this.p = r2.f2833h;
        this.H = r2.f2832g;
        this.I = r2.f2831f;
        this.f2795J = r2.f2830e;
        this.K = r2.f2829d;
        this.L = r2.f2828c;
        this.q = new h(r2);
        this.D = r2.G;
        this.r = r2.H;
        this.s = r2.I;
        y r4 = r2.f2825J;
        if (r4 != null) goto L14;
        r4 = new y.a();
    L14:
        this.t = r4;
        boolean r5 = r2.K;
        this.u = r2.L;
        this.v = r2.M;
        this.w = r2.N;
        this.M = r2.f2827b;
        this.N = r2.f2826a;
        this.x = r2.O;
        this.y = r2.P;
        this.z = r2.Q;
        this.A = r2.R;
        this.B = r2.S;
        this.C = r2.T;
        this.O = r2.U;
        return;
    L9:
        r1 = r2.o;
        goto L10
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public com.bytedance.bdinstall.y0.c A() {
        return this.x;
    }

    public q0 B() {
        return this.L;
    }

    public String C() {
        return this.f2804i;
    }

    public SharedPreferences D() {
        if (this.P != null) goto L6;
        this.P = a(this.f2798c, this.f2799d, 0);
    L6:
        return this.P;
    }

    public f0 E() {
        return this.u;
    }

    public String F() {
        return this.f2803h;
    }

    public long G() {
        return this.q.c();
    }

    public String H() {
        if (TextUtils.isEmpty(this.f2806k) == true) goto L7;
        return this.f2806k;
    L7:
        return com.bytedance.bdinstall.d1.h.a(this.f2798c).getString("user_agent", null);
    }

    public String I() {
        return this.q.d();
    }

    public long J() {
        return this.q.e();
    }

    public String K() {
        return this.q.f();
    }

    public String L() {
        return this.f2800e;
    }

    public boolean M() {
        return this.K;
    }

    public boolean N() {
        return this.p;
    }

    public boolean O() {
        return this.C;
    }

    public boolean P() {
        return this.r;
    }

    public boolean Q() {
        return this.O;
    }

    public boolean R() {
        return this.B;
    }

    public boolean S() {
        return this.G;
    }

    public boolean T() {
        return this.M;
    }

    public boolean U() {
        return this.H;
    }

    public boolean V() {
        return this.v;
    }

    public boolean W() {
        return this.I;
    }

    public void X(SharedPreferences.Editor r3) {
        String r0 = k();
        String r2 = n();
        if (TextUtils.isEmpty(r0) == true) goto L6;
        r3.putString("app_language", r0);
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r3.putString("app_region", r2);
        return;
    }

    public boolean b() {
        return this.N;
    }

    public boolean c() {
        return this.A;
    }

    public boolean d() {
        if (P() == true) goto L5;
        return true;
    L5:
        return this.F;
    }

    public v e() {
        return this.f2805j;
    }

    public String f() {
        v r0 = this.f2805j;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getAbVersion();
    }

    public Account g() {
        return this.D;
    }

    public a0 h() {
        return this.z;
    }

    public com.bytedance.bdinstall.y0.a i() {
        return this.y;
    }

    public int j() {
        return this.f2796a;
    }

    public String k() {
        if (TextUtils.isEmpty(this.f2807l) == true) goto L7;
        return this.f2807l;
    L7:
        return com.bytedance.bdinstall.d1.h.a(this.f2798c).getString("app_language", null);
    }

    public String l() {
        return D().getString("app_language", null);
    }

    public String m() {
        return this.f2801f;
    }

    public String n() {
        if (TextUtils.isEmpty(this.m) == true) goto L7;
        return this.m;
    L7:
        return com.bytedance.bdinstall.d1.h.a(this.f2798c).getString("app_region", null);
    }

    public String o() {
        return D().getString("app_region", null);
    }

    public JSONObject p() {
        JSONObject r0 = this.n;
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r2 = com.bytedance.bdinstall.d1.h.a(this.f2798c).getString("app_track", null);
        if (r2 != null) goto L11;
    L9:
        return null;
    L11:
        return new JSONObject(r2);
    }

    public com.bytedance.bdinstall.y0.b q() {
        return this.w;
    }

    public String r() {
        return this.f2802g;
    }

    public Map<String, Object> s() {
        return this.o;
    }

    public Context t() {
        return this.f2798c;
    }

    public Map<String, Object> u() {
        w r0 = this.E;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a();
    }

    y v() {
        return this.t;
    }

    public z w() {
        return this.f2795J;
    }

    public c0 x() {
        return this.s;
    }

    public long y() {
        return this.q.b();
    }

    public d0 z() {
        return this.f2797b;
    }
}
