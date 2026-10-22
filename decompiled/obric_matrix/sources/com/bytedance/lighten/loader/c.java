package com.bytedance.lighten.loader;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
class c extends d.c.f.c.c<d.c.i.l.f> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private w f4926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.b.k.a.y.f f4927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f4928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.c.i.l.a f4929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d.b.k.a.s f4931g;

    c() {
        this.f4930f = false;
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public /* bridge */ /* synthetic */ void a(String r1, Object r2) {
        n(r1, (d.c.i.l.f) r2);
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public /* bridge */ /* synthetic */ void b(String r1, @Nullable Object r2, @Nullable Animatable r3) {
        m(r1, (d.c.i.l.f) r2, r3);
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public void c(String r3, Throwable r4) {
        Log.d("Lighten:", "onFailure: id=" + r3 + ", ex=" + r4);
        d.b.k.a.y.f r5 = this.f4927c;
        if (r5 == null) goto L5;
        r5.d(this.f4928d, this.f4926b, r4);
    L5:
        this.f4930f = false;
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public void d(String r3) {
        super.d(r3);
        Log.d("Lighten:", "onRelease: id=" + r3);
        d.b.k.a.y.f r4 = this.f4927c;
        if (r4 == null) goto L5;
        r4.c(this.f4928d);
    L5:
        this.f4930f = false;
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public void e(String r2, Object r3) {
        Log.d("Lighten:", "onSubmit: id=" + r2);
        d.b.k.a.y.f r4 = this.f4927c;
        if (r4 == null) goto L6;
        r4.b(this.f4928d, this.f4926b);
        return;
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public void f(String r3, Throwable r4) {
        super.f(r3, r4);
        Log.d("Lighten:", "onIntermediateImageFailed: id=" + r3);
        d.b.k.a.y.f r5 = this.f4927c;
        if (r5 == null) goto L5;
        r5.e(this.f4928d, r4);
    L5:
        this.f4930f = false;
    }

    void k(d.b.k.a.s r2) {
        this.f4931g = r2;
        this.f4926b = (w) r2.D();
        this.f4927c = r2.q();
        if (r2.C() != null) goto L5;
    L7:
        Uri r3 = r2.B();
    L8:
        this.f4928d = r3;
        return;
    L5:
        if (r2.C().b() == true) goto L7;
        r3 = Uri.parse(r2.C().a().get(0));
        goto L8
    }

    boolean l() {
        return this.f4930f;
    }

    public void m(String r4, @Nullable d.c.i.l.f r5, @Nullable Animatable r6) {
        boolean r0 = r5 instanceof d.c.i.l.a;
        if (r0 == false) goto L5;
        this.f4929e = (d.c.i.l.a) r5;
    L5:
        Log.d("Lighten:", "onFinalImageSet: id=" + r4);
        if (r6 == null) goto L8;
        boolean r7 = true;
    L9:
        this.f4930f = r7;
        d.b.k.a.y.f r8 = this.f4927c;
        if (r8 == null) goto L15;
        if (r5 == null) goto L13;
        this.f4927c.f(this.f4928d, this.f4926b, new d.b.k.a.n(r5.getWidth(), r5.getHeight()), r6);
        goto L15
    L13:
        r8.f(this.f4928d, this.f4926b, null, r6);
    L15:
        if (this.f4929e == null) goto L25;
        if (this.f4931g.F() == false) goto L25;
        if (TextUtils.isEmpty(this.f4926b.getAnimPreviewFrameCacheKey()) == true) goto L25;
        if (a.f().g(this.f4926b.getAnimPreviewFrameCacheKey()) != null) goto L25;
        if (r0 == false) goto L25;
        a.f().c(this.f4926b.getAnimPreviewFrameCacheKey(), this.f4929e);
    L25:
        if (this.f4930f == true) goto L27;
        return;
    L27:
        if (this.f4931g.G() == false) goto L31;
        this.f4926b.s();
        return;
    L31:
        return;
    L8:
        r7 = false;
        goto L9
    }

    public void n(String r3, d.c.i.l.f r4) {
        super.a(r3, r4);
        Log.d("Lighten:", "onIntermediateImageSet: id=" + r3);
        d.b.k.a.y.f r5 = this.f4927c;
        if (r5 == null) goto L8;
        if (r4 == null) goto L6;
        d.b.k.a.n r0 = new d.b.k.a.n(r4.getWidth(), r4.getHeight());
        r5 = this.f4927c;
        Uri r6 = this.f4928d;
    L7:
        r5.a(r6, r0);
        goto L8
    L6:
        r6 = this.f4928d;
        r0 = null;
    L8:
        this.f4930f = false;
    }

    void o(d.b.k.a.y.f r1) {
        this.f4927c = r1;
    }
}
