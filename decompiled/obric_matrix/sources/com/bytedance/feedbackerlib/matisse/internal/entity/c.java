package com.bytedance.feedbackerlib.matisse.internal.entity;

import androidx.annotation.StyleRes;
import com.bytedance.feedbackerlib.h;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set<com.bytedance.feedbackerlib.k.b> f4345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @StyleRes
    public int f4348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4351g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4352h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4353i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<com.bytedance.feedbackerlib.k.e.a> f4354j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4355k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.feedbackerlib.matisse.internal.entity.a f4356l;
    public int m;
    public int n;
    public float o;
    public com.bytedance.feedbackerlib.k.d.a p;
    public boolean q;
    public com.bytedance.feedbackerlib.k.g.c r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public com.bytedance.feedbackerlib.k.g.a w;
    public boolean x;
    public List<Item> y;

    static /* synthetic */ class a {
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f4357a = null;

        static {
            f4357a = new c(null);
        }

        static /* synthetic */ c a() {
            return f4357a;
        }
    }

    private c() {
    }

    /* synthetic */ c(a r1) {
        this();
    }

    public static c a() {
        c r0 = b();
        r0.g();
        return r0;
    }

    public static c b() {
        return b.a();
    }

    private void g() {
        this.f4345a = null;
        this.f4346b = true;
        this.f4347c = false;
        this.f4348d = h.f4047b;
        this.f4349e = 0;
        this.f4350f = false;
        this.f4351g = 1;
        this.f4352h = 0;
        this.f4353i = 0;
        this.f4354j = null;
        this.f4355k = false;
        this.m = 3;
        this.n = 0;
        this.o = 0.5f;
        this.p = new com.bytedance.feedbackerlib.k.d.b.a();
        this.q = true;
        this.s = false;
        this.u = false;
        this.v = Integer.MAX_VALUE;
        this.x = true;
    }

    public boolean c() {
        if (this.f4349e == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        if (this.f4347c == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.feedbackerlib.k.b.l().equals(this.f4345a) == false) goto L7;
        return true;
    }

    public boolean e() {
        if (this.f4347c == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.feedbackerlib.k.b.m().containsAll(this.f4345a) == false) goto L7;
        return true;
    }

    public boolean f() {
        if (this.f4347c == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.feedbackerlib.k.b.o().containsAll(this.f4345a) == false) goto L7;
        return true;
    }

    public boolean h() {
        if (this.f4350f == false) goto L5;
    L11:
        return false;
    L5:
        if (this.f4351g != 1) goto L7;
        return true;
    L7:
        if (this.f4352h != 1) goto L11;
        if (this.f4353i != 1) goto L11;
        return true;
    }
}
