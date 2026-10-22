package l.b.g.b.h;

import java.io.Serializable;
import java.util.Objects;
import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
class c implements Serializable, Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private u f22095f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f22096g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f22097h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f22098i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f22099j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f22100k;

    c(int r1) {
        this.f22096g = r1;
        this.f22099j = false;
        this.f22100k = false;
    }

    protected c a() {
        c r0 = new c(this.f22096g);
        r0.f22095f = this.f22095f;
        r0.f22097h = this.f22097h;
        r0.f22098i = this.f22098i;
        r0.f22099j = this.f22099j;
        r0.f22100k = this.f22100k;
        return r0;
    }

    int c() {
        if (this.f22099j == true) goto L5;
        return Integer.MAX_VALUE;
    L5:
        if (this.f22100k == false) goto L8;
        return Integer.MAX_VALUE;
    L8:
        return this.f22097h;
    }

    protected /* bridge */ /* synthetic */ Object clone() {
        return a();
    }

    int d() {
        return this.f22098i;
    }

    public u e() {
        return this.f22095f;
    }

    void f(int r2) {
        this.f22095f = null;
        this.f22097h = this.f22096g;
        this.f22098i = r2;
        this.f22099j = true;
        this.f22100k = false;
    }

    boolean h() {
        return this.f22100k;
    }

    boolean i() {
        return this.f22099j;
    }

    void j(u r2) {
        this.f22095f = r2;
        int r3 = r2.a();
        this.f22097h = r3;
        if (r3 != this.f22096g) goto L6;
        this.f22100k = true;
        return;
    }

    void k(Stack<u> r5, k r6, byte[] r7, byte[] r8, j r9) {
        Objects.requireNonNull(r9, "otsHashAddress == null");
        if (this.f22100k == true) goto L27;
        if (this.f22099j == false) goto L27;
        j.b r0 = new j.b().g(r9.b()).h(r9.c());
        r0.p(this.f22098i);
        r0.n(r9.e());
        r0.o(r9.f());
        j r10 = (j) r0.f(r9.a()).l();
        i.b r1 = new i.b().g(r10.b()).h(r10.c());
        r1.n(this.f22098i);
        i r2 = (i) r1.l();
        g.b r3 = new g.b().g(r10.b()).h(r10.c());
        r3.n(this.f22098i);
        g r4 = (g) r3.k();
        r6.h(r6.g(r8, r10), r7);
        u r11 = v.a(r6, r6.e(r10), r2);
    L8:
        if (r5.isEmpty() == true) goto L14;
        if (r5.peek().a() != r11.a()) goto L14;
        if (r5.peek().a() == this.f22096g) goto L14;
        g.b r12 = new g.b().g(r4.b()).h(r4.c());
        r12.m(r4.e());
        r12.n((r4.f() - 1) / 2);
        g r13 = (g) r12.f(r4.a()).k();
        u r14 = v.b(r6, r5.pop(), r11, r13);
        u r15 = new u(r14.a() + 1, r14.b());
        g.b r16 = new g.b().g(r13.b()).h(r13.c());
        r16.m(r13.e() + 1);
        r16.n(r13.f());
        r4 = (g) r16.f(r13.a()).k();
        r11 = r15;
    L14:
        u r17 = this.f22095f;
        if (r17 != null) goto L18;
        this.f22095f = r11;
    L22:
        if (this.f22095f.a() != this.f22096g) goto L24;
        this.f22100k = true;
        return;
    L24:
        this.f22097h = r11.a();
        this.f22098i++;
        return;
    L18:
        if (r17.a() != r11.a()) goto L20;
        g.b r18 = new g.b().g(r4.b()).h(r4.c());
        r18.m(r4.e());
        r18.n((r4.f() - 1) / 2);
        g r19 = (g) r18.f(r4.a()).k();
        r11 = new u(this.f22095f.a() + 1, v.b(r6, this.f22095f, r11, r19).b());
        this.f22095f = r11;
        g.b r20 = new g.b().g(r19.b()).h(r19.c());
        r20.m(r19.e() + 1);
        r20.n(r19.f());
        g r21 = (g) r20.f(r19.a()).k();
        goto L22
    L20:
        r5.push(r11);
    L27:
        throw new IllegalStateException("finished or not initialized");
    }
}
