package com.bytedance.applog;

import android.accounts.Account;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.bdinstall.c0;
import com.bytedance.bdinstall.d0;
import com.bytedance.bdinstall.f0;
import com.bytedance.bdinstall.q0;
import com.bytedance.bdinstall.v;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class l {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private String f2220J;
    private q0 K;
    private f0 L;
    private boolean M;
    private a N;
    private v O;
    private boolean P;
    private volatile com.bytedance.bdinstall.y0.b Q;
    private b R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.b.m.a f2224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c0 f2226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f2227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private j f2228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f2229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f2230j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2231k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f2232l;
    private String m;
    private String n;
    private m o;
    private String p;
    private String q;
    private long r;
    private long s;
    private long t;
    private String u;
    private String v;
    private Map<String, Object> w;
    private Account x;
    private final d0 y;
    private d0 z;

    public interface a {
        boolean a(String[] r1);
    }

    public l(@NonNull String r4, @NonNull String r5) {
        this.f2222b = true;
        this.f2230j = false;
        this.f2232l = 0;
        this.y = new com.bytedance.applog.util.c();
        this.B = true;
        this.D = false;
        this.E = true;
        this.F = false;
        this.G = false;
        this.H = true;
        this.I = "bd_tea_agent.db";
        this.f2220J = "applog_stats";
        this.N = null;
        this.O = null;
        this.f2221a = r4;
        this.f2223c = r5;
        TextUtils.isEmpty(r5);
    }

    public long A() {
        return this.s;
    }

    public m B() {
        return this.o;
    }

    public String C() {
        return this.p;
    }

    public long D() {
        return this.r;
    }

    public String E() {
        return this.u;
    }

    public String F() {
        return this.v;
    }

    public boolean G() {
        return this.D;
    }

    public boolean H() {
        return this.F;
    }

    public boolean I() {
        return this.B;
    }

    public boolean J() {
        return this.E;
    }

    public boolean K() {
        return this.H;
    }

    public boolean L() {
        return this.A;
    }

    public boolean M() {
        return this.M;
    }

    boolean N() {
        return this.G;
    }

    public boolean O() {
        return this.f2231k;
    }

    public boolean P() {
        return this.C;
    }

    public boolean Q() {
        return this.P;
    }

    public l R(String r1) {
        this.n = r1;
        return this;
    }

    public l S(boolean r1) {
        this.f2222b = r1;
        return this;
    }

    public l T(d0 r1) {
        this.z = r1;
        return this;
    }

    @NonNull
    public l U(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 1;
    L5:
        this.f2232l = r2;
        return this;
    L4:
        r2 = 2;
        goto L5
    }

    public l V(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        this.f2220J = r2;
    L5:
        return this;
    }

    public l W(long r1) {
        this.s = r1;
        return this;
    }

    public l X(m r1) {
        this.o = r1;
        return this;
    }

    public boolean a() {
        return this.f2222b;
    }

    public v b() {
        return this.O;
    }

    public Account c() {
        return this.x;
    }

    public String d() {
        return this.f2221a;
    }

    public boolean e() {
        return this.f2229i;
    }

    public String f() {
        return this.n;
    }

    public com.bytedance.bdinstall.y0.b g() {
        return this.Q;
    }

    public b h() {
        return this.R;
    }

    public String i() {
        return this.f2223c;
    }

    public Map<String, Object> j() {
        return this.w;
    }

    public String k() {
        return this.I;
    }

    public d.b.m.a l() {
        return this.f2224d;
    }

    public a m() {
        return this.N;
    }

    public String n() {
        return this.f2225e;
    }

    public boolean o() {
        return this.f2230j;
    }

    public c0 p() {
        return this.f2226f;
    }

    public long q() {
        return this.t;
    }

    public d0 r() {
        d0 r0 = this.z;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.y;
    }

    public j s() {
        return this.f2228h;
    }

    public q0 t() {
        return this.K;
    }

    public int u() {
        return this.f2232l;
    }

    public String v() {
        return this.f2227g;
    }

    public String w() {
        return this.m;
    }

    public f0 x() {
        return this.L;
    }

    public String y() {
        return this.f2220J;
    }

    public String z() {
        return this.q;
    }
}
