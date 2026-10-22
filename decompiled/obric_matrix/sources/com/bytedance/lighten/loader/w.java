package com.bytedance.lighten.loader;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class w extends d.c.f.i.f implements d.b.k.a.k, d.b.k.a.j {
    private WeakReference<d.b.k.a.y.a> r;
    private c s;
    private d.b.k.a.s t;
    private String u;
    private d.c.c.h.a<Bitmap> v;
    private boolean w;
    private boolean x;

    private void r() {
        getHierarchy().r(null);
        d.c.c.h.a<Bitmap> r0 = a.f().g(this.u);
        this.v = r0;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.Q() == false) goto L12;
        Bitmap r1 = this.v.N();
        if (r1.isRecycled() == true) goto L9;
        BitmapDrawable r2 = new BitmapDrawable(r1);
        getHierarchy().r(new d.c.f.e.o(r2, d.c.f.e.p.b.f15668g));
        return;
    L9:
        getHierarchy().r(null);
        return;
    }

    private void setController(d.c.i.q.b r3) {
        d.c.f.a.a.e r0 = d.c.f.a.a.c.g();
        r0.E(getController());
        d.c.f.a.a.e r1 = r0;
        r1.x(this.t.G());
        d.c.f.a.a.e r2 = r1;
        if (this.t.y() <= 0) goto L5;
        boolean r4 = true;
    L6:
        r2.G(r4);
        d.c.f.a.a.e r5 = r2;
        r5.D(r3);
        d.c.f.a.a.e r6 = r5;
        if (TextUtils.isEmpty(this.t.i()) == true) goto L9;
        r6.y(this.t.i());
    L9:
        c r7 = this.s;
        if (r7 != null) goto L13;
        r7 = new c();
        this.s = r7;
    L13:
        r7.k(this.t);
        r6.z(this.s);
        setController(r6.c());
        return;
    L5:
        r4 = false;
        goto L6
    }

    private void setController(d.c.i.q.b[] r3) {
        if (r3.length != 0) goto L5;
        return;
    L5:
        d.c.f.a.a.e r0 = d.c.f.a.a.c.g();
        r0.E(getController());
        d.c.f.a.a.e r1 = r0;
        r1.x(this.t.G());
        d.c.f.a.a.e r2 = r1;
        if (this.t.y() <= 0) goto L8;
        boolean r4 = true;
    L9:
        r2.G(r4);
        d.c.f.a.a.e r5 = r2;
        r5.y(this.t.i());
        d.c.f.a.a.e r6 = r5;
        r6.A(r3);
        d.c.f.a.a.e r7 = r6;
        if (TextUtils.isEmpty(this.t.i()) == true) goto L12;
        r7.y(this.t.i());
    L12:
        c r8 = this.s;
        if (r8 != null) goto L16;
        r8 = new c();
        this.s = r8;
    L16:
        r8.k(this.t);
        r7.z(this.s);
        setController(r7.c());
        return;
    L8:
        r4 = false;
        goto L9
    }

    String getAnimPreviewFrameCacheKey() {
        return this.u;
    }

    public d.b.k.a.j getSmartHierarchy() {
        return this;
    }

    public void q(d.b.k.a.s r3) {
        this.t = r3;
        if (r3.F() == false) goto L12;
        if (r3.C() != null) goto L7;
    L9:
        String r0 = r3.B().toString();
    L10:
        this.u = r0;
        r();
        goto L12
    L7:
        if (r3.C().b() == true) goto L9;
        r0 = r3.C().a().get(0);
    L12:
        if (r3.C() != null) goto L14;
    L16:
        setController(o.g(r3, r3.B()));
        return;
    L14:
        if (r3.C().b() == true) goto L16;
        setController(o.h(r3));
    }

    public void s() {
        if (getController() == null) goto L23;
        c r0 = this.s;
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.w == true) goto L10;
        return;
    L10:
        if (r0.l() == true) goto L12;
        return;
    L12:
        if (this.x == false) goto L26;
        Animatable r1 = getController().e();
        if (r1 != null) goto L16;
        return;
    L16:
        if (r1.isRunning() == true) goto L28;
        r1.start();
        WeakReference<d.b.k.a.y.a> r2 = this.r;
        if (r2 != null) goto L20;
        return;
    L20:
        if (r2.get() == null) goto L30;
        this.r.get().a();
        return;
    L30:
        return;
    L28:
        return;
    L26:
        return;
    }

    public void setActualImageScaleType(d.b.k.a.u r1) {
        if (r1 == null) goto L5;
        getHierarchy().q(u.a(r1));
        return;
    }

    public void setAnimationListener(d.b.k.a.y.a r2) {
        this.r = new WeakReference(r2);
    }

    public void setAttached(boolean r1) {
        this.w = r1;
    }

    public void setCircleOptions(d.b.k.a.e r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (getHierarchy().m() == null) goto L7;
        d.c.f.f.d r0 = getHierarchy().m();
    L9:
        if (r3.c() != null) goto L12;
        r0.o(r3.h());
        r0.l(r3.d());
        r0.k(r3.b());
        r0.j(r3.a());
        r0.m(r3.e());
        r0.n(r3.f());
        r0.p(x.d(r3.g()));
        getHierarchy().H(r0);
        return;
    L12:
        r3.c().a();
        throw null;
    L7:
        r0 = new d.c.f.f.d();
        goto L9
    }

    public void setImageDisplayListener(d.b.k.a.y.f r1) {
        c r0 = this.s;
        if (r0 == null) goto L6;
        r0.o(r1);
        return;
    }

    public void setPlaceholderImage(int r1) {
        if (r1 <= 0) goto L5;
        getHierarchy().y(r1);
        return;
    }

    public void setPlaceholderImage(@Nullable Drawable r1) {
        getHierarchy().A(r1);
    }

    public void setUserVisibleHint(boolean r1) {
        this.x = r1;
    }
}
