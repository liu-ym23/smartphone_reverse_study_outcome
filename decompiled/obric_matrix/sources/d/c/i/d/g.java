package d.c.i.d;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public class g implements d.c.c.h.c<Bitmap> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static g f15915f;

    private g() {
    }

    public static g a() {
        if (f15915f != null) goto L6;
        f15915f = new g();
    L6:
        return f15915f;
    }

    public void b(Bitmap r1) {
        r1.recycle();
    }

    @Override // d.c.c.h.c
    public /* bridge */ /* synthetic */ void release(Bitmap r1) {
        b(r1);
    }
}
