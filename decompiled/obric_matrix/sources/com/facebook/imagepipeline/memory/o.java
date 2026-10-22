package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public class o implements d {
    public o() {
    }

    @Override // d.c.c.g.c
    public void a(d.c.c.g.b r1) {
    }

    public Bitmap b(int r3) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) r3) / 2.0d), Bitmap.Config.RGB_565);
    }

    public void c(Bitmap r1) {
        r1.recycle();
    }

    @Override // d.c.c.g.f
    public /* bridge */ /* synthetic */ Bitmap get(int r1) {
        return b(r1);
    }

    @Override // d.c.c.g.f, d.c.c.h.c
    public /* bridge */ /* synthetic */ void release(Object r1) {
        c((Bitmap) r1);
    }
}
