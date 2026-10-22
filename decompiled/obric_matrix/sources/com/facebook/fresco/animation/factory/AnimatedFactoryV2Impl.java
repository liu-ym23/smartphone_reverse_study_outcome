package com.facebook.fresco.animation.factory;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.time.RealtimeSinceBootClock;
import d.c.c.d.l;
import d.c.i.e.h;
import d.c.i.l.i;

/* JADX INFO: loaded from: classes.dex */
@d.c.c.d.d
public class AnimatedFactoryV2Impl implements d.c.i.c.b.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f6634h = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.i.d.f f6635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.i.g.e f6636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h<d.c.b.a.d, d.c.i.l.c> f6637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.c.i.c.b.d f6638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.c.i.c.c.b f6639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d.c.i.c.d.a f6640f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d.c.i.j.a f6641g;

    class a implements d.c.i.i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap.Config f6642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AnimatedFactoryV2Impl f6643b;

        a(AnimatedFactoryV2Impl r1, Bitmap.Config r2) {
            this.f6643b = r1;
            this.f6642a = r2;
        }

        @Override // d.c.i.i.c
        public d.c.i.l.c a(d.c.i.l.e r1, int r2, i r3, d.c.i.f.c r4) {
            return AnimatedFactoryV2Impl.e(this.f6643b).a(r1, r4, this.f6642a);
        }
    }

    class b implements d.c.i.i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap.Config f6644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AnimatedFactoryV2Impl f6645b;

        b(AnimatedFactoryV2Impl r1, Bitmap.Config r2) {
            this.f6645b = r1;
            this.f6644a = r2;
        }

        @Override // d.c.i.i.c
        public d.c.i.l.c a(d.c.i.l.e r1, int r2, i r3, d.c.i.f.c r4) {
            return AnimatedFactoryV2Impl.e(this.f6645b).b(r1, r4, this.f6644a);
        }
    }

    class c implements d.c.i.i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap.Config f6646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AnimatedFactoryV2Impl f6647b;

        c(AnimatedFactoryV2Impl r1, Bitmap.Config r2) {
            this.f6647b = r1;
            this.f6646a = r2;
        }

        @Override // d.c.i.i.c
        public d.c.i.l.c a(d.c.i.l.e r1, int r2, i r3, d.c.i.f.c r4) {
            return AnimatedFactoryV2Impl.e(this.f6647b).c(r1, r4, this.f6646a);
        }
    }

    class d implements l<Integer> {
        d(AnimatedFactoryV2Impl r1) {
        }

        public Integer a() {
            return Integer.valueOf(AnimatedFactoryV2Impl.f());
        }

        @Override // d.c.c.d.l
        public /* bridge */ /* synthetic */ Integer get() {
            return a();
        }
    }

    class e implements l<Integer> {
        e(AnimatedFactoryV2Impl r1) {
        }

        public Integer a() {
            return 3;
        }

        @Override // d.c.c.d.l
        public /* bridge */ /* synthetic */ Integer get() {
            return a();
        }
    }

    class f implements d.c.i.c.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AnimatedFactoryV2Impl f6648a;

        f(AnimatedFactoryV2Impl r1) {
            this.f6648a = r1;
        }

        @Override // d.c.i.c.c.b
        public d.c.i.c.a.a a(d.c.i.c.a.e r2, Rect r3) {
            return new d.c.i.c.c.a(AnimatedFactoryV2Impl.g(this.f6648a), r2, r3);
        }
    }

    class g implements d.c.i.c.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AnimatedFactoryV2Impl f6649a;

        g(AnimatedFactoryV2Impl r1) {
            this.f6649a = r1;
        }

        @Override // d.c.i.c.c.b
        public d.c.i.c.a.a a(d.c.i.c.a.e r2, Rect r3) {
            return new d.c.i.c.c.a(AnimatedFactoryV2Impl.g(this.f6649a), r2, r3);
        }
    }

    static {
    }

    @d.c.c.d.d
    public AnimatedFactoryV2Impl(d.c.i.d.f r1, d.c.i.g.e r2, h<d.c.b.a.d, d.c.i.l.c> r3) {
        this.f6635a = r1;
        this.f6636b = r2;
        this.f6637c = r3;
    }

    static /* synthetic */ d.c.i.c.b.d e(AnimatedFactoryV2Impl r0) {
        return r0.l();
    }

    static /* synthetic */ int f() {
        return f6634h;
    }

    static /* synthetic */ d.c.i.c.d.a g(AnimatedFactoryV2Impl r0) {
        return r0.k();
    }

    private d.c.i.c.b.d h() {
        return new d.c.i.c.b.e(new g(this), this.f6635a);
    }

    private com.facebook.fresco.animation.factory.a i() {
        d r7 = new d(this);
        d.c.c.b.d r3 = new d.c.c.b.d(this.f6636b.a());
        e r8 = new e(this);
        return new com.facebook.fresco.animation.factory.a(j(), d.c.c.b.h.g(), r3, RealtimeSinceBootClock.get(), this.f6635a, this.f6637c, r7, r8);
    }

    private d.c.i.c.c.b j() {
        if (this.f6639e != null) goto L6;
        this.f6639e = new f(this);
    L6:
        return this.f6639e;
    }

    private d.c.i.c.d.a k() {
        if (this.f6640f != null) goto L6;
        this.f6640f = new d.c.i.c.d.a();
    L6:
        return this.f6640f;
    }

    private d.c.i.c.b.d l() {
        if (this.f6638d != null) goto L6;
        this.f6638d = h();
    L6:
        return this.f6638d;
    }

    @Override // d.c.i.c.b.a
    public d.c.i.j.a a(Context r1) {
        if (this.f6641g != null) goto L6;
        this.f6641g = i();
    L6:
        return this.f6641g;
    }

    @Override // d.c.i.c.b.a
    public d.c.i.i.c b(Bitmap.Config r2) {
        return new a(this, r2);
    }

    @Override // d.c.i.c.b.a
    public d.c.i.i.c c(Bitmap.Config r2) {
        return new b(this, r2);
    }

    @Override // d.c.i.c.b.a
    public d.c.i.i.c d(Bitmap.Config r2) {
        return new c(this, r2);
    }
}
