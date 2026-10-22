package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class e extends s<Bitmap> {
    public e() {
    }

    @Override // com.facebook.imagepipeline.memory.c0
    public /* bridge */ /* synthetic */ int a(Object r1) {
        return d((Bitmap) r1);
    }

    @Nullable
    public Bitmap c(int r1) {
        Bitmap r2 = (Bitmap) super.get(r1);
        if (r2 != null) goto L5;
        return null;
    L5:
        if (e(r2) == false) goto L10;
        r2.eraseColor(0);
        return r2;
    L10:
        return null;
    }

    public int d(Bitmap r1) {
        return com.facebook.imageutils.b.e(r1);
    }

    protected boolean e(@Nullable Bitmap r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.isRecycled() == false) goto L10;
        d.c.c.e.a.G("BitmapPoolBackend", "Cannot reuse a recycled bitmap: %s", new Object[]{r4});
        return false;
    L10:
        if (r4.isMutable() == true) goto L13;
        d.c.c.e.a.G("BitmapPoolBackend", "Cannot reuse an immutable bitmap: %s", new Object[]{r4});
        return false;
    L13:
        return true;
    }

    public void f(Bitmap r2) {
        if (e(r2) == false) goto L6;
        super.put(r2);
        return;
    }

    @Override // com.facebook.imagepipeline.memory.s, com.facebook.imagepipeline.memory.c0
    @Nullable
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return c(r1);
    }

    @Override // com.facebook.imagepipeline.memory.s, com.facebook.imagepipeline.memory.c0
    public /* bridge */ /* synthetic */ void put(Object r1) {
        f((Bitmap) r1);
    }
}
