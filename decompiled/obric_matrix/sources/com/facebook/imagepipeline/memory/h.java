package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class h extends a<Bitmap> implements d {
    public h(d.c.c.g.d r1, f0 r2, g0 r3) {
        super(r1, r2, r3);
        n();
    }

    protected int A(Bitmap r1) {
        d.c.c.d.i.g(r1);
        return r1.getAllocationByteCount();
    }

    protected Bitmap B(f<Bitmap> r1) {
        Bitmap r0 = (Bitmap) super.l(r1);
        if (r0 == null) goto L5;
        r0.eraseColor(0);
    L5:
        return r0;
    }

    protected boolean C(Bitmap r1) {
        d.c.c.d.i.g(r1);
        if (r1.isRecycled() == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.isMutable() == false) goto L7;
        return true;
    }

    @Override // com.facebook.imagepipeline.memory.a
    protected /* bridge */ /* synthetic */ Bitmap b(int r1) {
        return y(r1);
    }

    @Override // com.facebook.imagepipeline.memory.a
    protected /* bridge */ /* synthetic */ void f(Bitmap r1) {
        z(r1);
    }

    @Override // com.facebook.imagepipeline.memory.a
    protected int i(int r1) {
        return r1;
    }

    @Override // com.facebook.imagepipeline.memory.a
    protected /* bridge */ /* synthetic */ int j(Bitmap r1) {
        return A(r1);
    }

    @Override // com.facebook.imagepipeline.memory.a
    protected int k(int r1) {
        return r1;
    }

    @Override // com.facebook.imagepipeline.memory.a
    protected /* bridge */ /* synthetic */ Bitmap l(f<Bitmap> r1) {
        return B(r1);
    }

    @Override // com.facebook.imagepipeline.memory.a
    protected /* bridge */ /* synthetic */ boolean p(Bitmap r1) {
        return C(r1);
    }

    protected Bitmap y(int r3) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) r3) / 2.0d), Bitmap.Config.RGB_565);
    }

    protected void z(Bitmap r1) {
        d.c.c.d.i.g(r1);
        r1.recycle();
    }
}
