package d.c.i.d;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import d.c.c.d.i;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.facebook.imagepipeline.memory.d f15904a;

    public a(com.facebook.imagepipeline.memory.d r1) {
        this.f15904a = r1;
    }

    @Override // d.c.i.d.f
    public d.c.c.h.a<Bitmap> l(int r5, int r6, Bitmap.Config r7) {
        int r0 = com.facebook.imageutils.b.d(r5, r6, r7);
        Bitmap r1 = this.f15904a.get(r0);
        if (r1.getAllocationByteCount() < ((r5 * r6) * com.facebook.imageutils.b.c(r7))) goto L5;
        boolean r2 = true;
    L6:
        i.b(r2);
        r1.reconfigure(r5, r6, r7);
        return d.c.c.h.a.X(r1, this.f15904a);
    L5:
        r2 = false;
        goto L6
    }
}
