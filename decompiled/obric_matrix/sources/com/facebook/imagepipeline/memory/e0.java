package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes2.dex */
public class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d0 f6704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f6705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private j f6706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private p f6707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private z f6708e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d.c.c.g.i f6709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d.c.c.g.l f6710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d.c.c.g.a f6711h;

    public e0(d0 r1) {
        d.c.c.d.i.g(r1);
        this.f6704a = r1;
    }

    private u e(int r2) {
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L8;
        return b();
    L8:
        throw new IllegalArgumentException("Invalid MemoryChunkType");
    L10:
        return f();
    }

    public d a() {
        if (this.f6705b != null) goto L29;
        String r0 = this.f6704a.e();
        byte r1 = -1;
        switch(r0.hashCode()) {
            case -1868884870: goto L17;
            case -1106578487: goto L14;
            case -404562712: goto L11;
            case 95945896: goto L8;
            default: goto L19;
        };
    L19:
        if (r1 == 0) goto L26;
        if (r1 != 1) goto L22;
        d r2 = new r(this.f6704a.b(), this.f6704a.a(), a0.h());
    L27:
        this.f6705b = r2;
        goto L29
    L22:
        if (r1 == 2) goto L24;
        r2 = r0;
        h r3 = new h(this.f6704a.i(), this.f6704a.c(), this.f6704a.d());
        goto L27
    L24:
        r2 = r3;
        r3 = new h(this.f6704a.i(), k.a(), this.f6704a.d());
        goto L27
    L26:
        r2 = new o();
        goto L27
    L8:
        if (r0.equals("dummy") == false) goto L19;
        r1 = 0;
        goto L19
    L11:
        if (r0.equals("experimental") == false) goto L19;
        r1 = 1;
        goto L19
    L14:
        if (r0.equals("legacy") == false) goto L19;
        r1 = 3;
        goto L19
    L17:
        if (r0.equals("legacy_default_params") == false) goto L19;
        r1 = 2;
    L29:
        return this.f6705b;
    }

    public j b() {
        if (this.f6706c != null) goto L6;
        this.f6706c = new j(this.f6704a.i(), this.f6704a.g(), this.f6704a.h());
    L6:
        return this.f6706c;
    }

    public p c() {
        if (this.f6707d != null) goto L6;
        this.f6707d = new p(this.f6704a.i(), this.f6704a.f());
    L6:
        return this.f6707d;
    }

    public int d() {
        return this.f6704a.f().f6721e;
    }

    public z f() {
        if (this.f6708e != null) goto L6;
        this.f6708e = new z(this.f6704a.i(), this.f6704a.g(), this.f6704a.h());
    L6:
        return this.f6708e;
    }

    public d.c.c.g.i g() {
        return h(0);
    }

    public d.c.c.g.i h(int r3) {
        if (this.f6709f != null) goto L6;
        this.f6709f = new x(e(r3), i());
    L6:
        return this.f6709f;
    }

    public d.c.c.g.l i() {
        if (this.f6710g != null) goto L6;
        this.f6710g = new d.c.c.g.l(j());
    L6:
        return this.f6710g;
    }

    public d.c.c.g.a j() {
        if (this.f6711h != null) goto L6;
        this.f6711h = new q(this.f6704a.i(), this.f6704a.j(), this.f6704a.k());
    L6:
        return this.f6711h;
    }
}
