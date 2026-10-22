package com.bytedance.bdinstall;

import android.accounts.Account;
import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k {
    String A;
    String B;
    String C;
    String D;
    JSONObject E;
    Map<String, Object> F;
    Account G;
    boolean H;
    c0 I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    y f2825J;
    boolean K;
    f0 L;
    boolean M;
    com.bytedance.bdinstall.y0.b N;
    com.bytedance.bdinstall.y0.c O;
    com.bytedance.bdinstall.y0.a P;
    a0 Q;
    boolean R;
    boolean S;
    boolean T;
    boolean U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f2826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f2827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    q0 f2828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f2829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    z f2830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f2831f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f2832g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f2833h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f2834i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    w f2835j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f2836k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f2837l;
    d0 m;
    Context n;
    String o;
    String p;
    String q;
    String r;
    long s;
    long t;
    long u;
    String v;
    String w;
    String x;
    String y;
    v z;

    public k() {
        this.f2826a = true;
        this.f2827b = false;
        this.f2831f = true;
        this.H = false;
        this.K = true;
        this.P = new com.bytedance.bdinstall.y0.a.C0082a();
        this.R = true;
        this.S = false;
        this.T = false;
    }

    public k A(String r1) {
        this.y = r1;
        return this;
    }

    public k B(f0 r1) {
        this.L = r1;
        return this;
    }

    public k C(boolean r1) {
        this.f2832g = r1;
        return this;
    }

    public k D(String r1) {
        this.o = r1;
        return this;
    }

    public k E(boolean r1) {
        this.M = r1;
        return this;
    }

    @Deprecated
    public k F(String r1) {
        this.x = r1;
        return this;
    }

    public k G(long r1) {
        this.t = r1;
        return this;
    }

    public k H(String r1) {
        this.r = r1;
        return this;
    }

    public k I(long r1) {
        this.s = r1;
        return this;
    }

    public k J(String r1) {
        this.q = r1;
        return this;
    }

    public k K(String r1) {
        this.p = r1;
        return this;
    }

    public i0 a() {
        if (this.n != null) goto L5;
    L29:
        StringBuilder r1 = new StringBuilder();
        r1.append("parameters error:");
        if (this.n != null) goto L32;
        boolean r2 = true;
    L33:
        r1.append(r2);
        r1.append(", ");
        r1.append(this.f2837l);
        r1.append(", ");
        r1.append(this.w);
        throw new IllegalArgumentException(r1.toString());
    L32:
        r2 = false;
        goto L33
    L5:
        if (this.f2837l <= 0) goto L29;
        if (TextUtils.isEmpty(this.w) == true) goto L29;
        if (TextUtils.isEmpty(this.v) == true) goto L28;
        if (q.b() == true) goto L23;
        if (this.m == null) goto L21;
        if (this.f2830e != null) goto L23;
        throw new IllegalArgumentException("please set event depend");
    L21:
        throw new IllegalArgumentException("please set network client");
    L23:
        if (TextUtils.isEmpty(this.x) == false) goto L26;
        this.x = this.w;
    L26:
        return new i0(this);
    L28:
        throw new IllegalArgumentException("appName is empty");
    }

    public k b(boolean r1) {
        this.S = r1;
        return this;
    }

    public k c(boolean r1) {
        v0.n(r1);
        return this;
    }

    public k d(v r1) {
        this.z = r1;
        return this;
    }

    public k e(Account r1) {
        this.G = r1;
        return this;
    }

    public k f(int r1) {
        this.f2837l = r1;
        return this;
    }

    public k g(boolean r1) {
        this.f2829d = r1;
        return this;
    }

    @Deprecated
    public k h(boolean r1) {
        return this;
    }

    public k i(String r1) {
        this.C = r1;
        return this;
    }

    public k j(String r1) {
        this.v = r1;
        return this;
    }

    public k k(String r1) {
        this.D = r1;
        return this;
    }

    public k l(com.bytedance.bdinstall.y0.b r1) {
        this.N = r1;
        return this;
    }

    public k m(boolean r1) {
        this.f2833h = r1;
        return this;
    }

    public k n(z r1) {
        this.f2830e = r1;
        return this;
    }

    public k o(String r1) {
        this.w = r1;
        return this;
    }

    public k p(Context r1) {
        this.n = r1;
        return this;
    }

    public k q(w r1) {
        this.f2835j = r1;
        return this;
    }

    public k r(Map<String, Object> r1) {
        this.F = r1;
        return this;
    }

    public k s(boolean r1) {
        this.H = r1;
        return this;
    }

    public k t(boolean r1) {
        this.U = r1;
        return this;
    }

    public k u(boolean r1) {
        this.f2836k = r1;
        return this;
    }

    public k v(y r1) {
        this.f2825J = r1;
        return this;
    }

    public k w(boolean r1) {
        this.f2834i = r1;
        return this;
    }

    public k x(long r1) {
        this.u = r1;
        return this;
    }

    public k y(d0 r1) {
        this.m = r1;
        return this;
    }

    public k z(q0 r1) {
        this.f2828c = r1;
        return this;
    }
}
