package d.c.i.g;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import d.c.i.e.q;
import d.c.i.p.a1;
import d.c.i.p.b0;
import d.c.i.p.b1;
import d.c.i.p.c0;
import d.c.i.p.c1;
import d.c.i.p.d0;
import d.c.i.p.e1;
import d.c.i.p.f0;
import d.c.i.p.g0;
import d.c.i.p.h0;
import d.c.i.p.i0;
import d.c.i.p.j0;
import d.c.i.p.k0;
import d.c.i.p.o;
import d.c.i.p.o0;
import d.c.i.p.p;
import d.c.i.p.p0;
import d.c.i.p.q0;
import d.c.i.p.r;
import d.c.i.p.r0;
import d.c.i.p.s;
import d.c.i.p.s0;
import d.c.i.p.w;
import d.c.i.p.x;
import d.c.i.p.x0;
import d.c.i.p.y;
import d.c.i.p.y0;
import d.c.i.p.z;
import d.c.i.p.z0;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ContentResolver f16118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Resources f16119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AssetManager f16120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.c.c.g.a f16121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.c.i.i.c f16122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d.c.i.i.f f16123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f16124g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f16125h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f16126i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final e f16127j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final d.c.c.g.i f16128k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final d.c.i.e.e f16129l;
    private final d.c.i.e.e m;
    private final HashMap<String, d.c.i.e.e> n;
    private final q<d.c.b.a.d, d.c.c.g.h> o;
    private final q<d.c.b.a.d, d.c.i.l.c> p;
    private final d.c.i.e.f q;
    private final d.c.i.d.f r;
    private final int s;
    private final int t;
    private boolean u;
    private final int v;
    private final boolean w;

    public l(Context r3, d.c.c.g.a r4, d.c.i.i.c r5, d.c.i.i.f r6, boolean r7, boolean r8, boolean r9, e r10, d.c.c.g.i r11, q<d.c.b.a.d, d.c.i.l.c> r12, q<d.c.b.a.d, d.c.c.g.h> r13, d.c.i.e.e r14, d.c.i.e.e r15, HashMap<String, d.c.i.e.e> r16, d.c.i.e.f r17, d.c.i.d.f r18, int r19, int r20, boolean r21, int r22, boolean r23) {
        this.f16118a = r3.getApplicationContext().getContentResolver();
        this.f16119b = r3.getApplicationContext().getResources();
        this.f16120c = r3.getApplicationContext().getAssets();
        this.f16121d = r4;
        this.f16122e = r5;
        this.f16123f = r6;
        this.f16124g = r7;
        this.f16125h = r8;
        this.f16126i = r9;
        this.f16127j = r10;
        this.f16128k = r11;
        this.p = r12;
        this.o = r13;
        this.f16129l = r14;
        this.m = r15;
        this.n = r16;
        this.q = r17;
        this.r = r18;
        this.s = r19;
        this.t = r20;
        this.u = r21;
        this.v = r22;
        this.w = r23;
    }

    public static <T> x0<T> D(k0<T> r1) {
        return new x0(r1);
    }

    public static d.c.i.p.a a(k0<d.c.i.l.e> r1) {
        return new d.c.i.p.a(r1);
    }

    public static d.c.i.p.j g(k0<d.c.i.l.e> r1, k0<d.c.i.l.e> r2) {
        return new d.c.i.p.j(r1, r2);
    }

    public r A(k0<d.c.i.l.e> r2) {
        return new q0(this.q, r2);
    }

    public r0 B(k0<d.c.i.l.e> r9) {
        return new r0(this.f16129l, this.m, this.n, this.q, r9, this.f16128k);
    }

    public s0 C(k0<d.c.i.l.e> r12, boolean r13, d.c.i.s.c r14) {
        return new s0(this.f16127j.c(), this.f16128k, r12, r13, r14, this.f16129l, this.m, this.n, this.q);
    }

    public <T> a1<T> E(k0<T> r3) {
        return new a1(5, this.f16127j.b(), r3);
    }

    public b1 F(c1<d.c.i.l.e>[] r1) {
        return new b1(r1);
    }

    public e1 G(k0<d.c.i.l.e> r3) {
        return new e1(this.f16127j.c(), this.f16128k, r3);
    }

    public <T> y0<T> b(k0<T> r1, z0 r2) {
        return new y0(r1, r2);
    }

    public d.c.i.p.f c(k0<d.c.c.h.a<d.c.i.l.c>> r3) {
        return new d.c.i.p.f(this.p, this.q, r3);
    }

    public d.c.i.p.g d(k0<d.c.c.h.a<d.c.i.l.c>> r2) {
        return new d.c.i.p.g(this.q, r2);
    }

    public d.c.i.p.h e(k0<d.c.c.h.a<d.c.i.l.c>> r3) {
        return new d.c.i.p.h(this.p, this.q, r3);
    }

    public d.c.i.p.i f(k0<d.c.c.h.a<d.c.i.l.c>> r4) {
        return new d.c.i.p.i(r4, this.s, this.t, this.u);
    }

    public d.c.i.p.l h() {
        return new d.c.i.p.l(this.f16128k);
    }

    public d.c.i.p.m i(k0<d.c.i.l.e> r13) {
        return new d.c.i.p.m(this.f16121d, this.f16127j.a(), this.f16122e, this.f16123f, this.f16124g, this.f16125h, this.f16126i, r13, this.v, this.w);
    }

    public o j(k0<d.c.i.l.e> r9) {
        return new o(this.f16129l, this.m, this.n, this.q, r9, this.f16128k);
    }

    public p k(k0<d.c.i.l.e> r9) {
        return new p(this.f16129l, this.m, this.n, this.q, r9, this.f16128k);
    }

    public r l(k0<d.c.i.l.e> r2) {
        return new r(this.q, r2);
    }

    public s m(k0<d.c.i.l.e> r3) {
        return new s(this.o, this.q, r3);
    }

    public w n() {
        return new w(this.f16127j.e(), this.f16128k, this.f16120c);
    }

    public x o() {
        return new x(this.f16127j.e(), this.f16128k, this.f16118a);
    }

    public y p() {
        return new y(this.f16127j.e(), this.f16128k, this.f16118a);
    }

    public z q() {
        return new z(this.f16127j.e(), this.f16128k, this.f16118a);
    }

    public b0 r() {
        return new b0(this.f16127j.e(), this.f16128k);
    }

    public c0 s() {
        return new c0(this.f16127j.e(), this.f16128k, this.f16119b);
    }

    public d0 t() {
        return new d0(this.f16127j.e(), this.f16118a);
    }

    public f0 u(g0 r3) {
        return new f0(this.f16128k, this.f16121d, r3);
    }

    public h0 v(k0<d.c.i.l.e> r8) {
        return new h0(this.f16129l, this.q, this.f16128k, this.f16121d, r8);
    }

    public i0 w(k0<d.c.c.h.a<d.c.i.l.c>> r3) {
        return new i0(this.p, this.q, r3);
    }

    public j0 x(k0<d.c.c.h.a<d.c.i.l.c>> r3) {
        return new j0(r3, this.r, this.f16127j.c());
    }

    public o0 y() {
        return new o0(this.f16127j.e(), this.f16128k, this.f16118a);
    }

    public p0 z(k0<d.c.i.l.e> r8, boolean r9, d.c.i.s.c r10) {
        return new p0(this.f16127j.c(), this.f16128k, r8, r9, r10);
    }
}
