package d.c.i.h;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends d.c.d.b<d.c.c.h.a<d.c.i.l.c>> {
    public b() {
    }

    @Override // d.c.d.b
    public void f(d.c.d.c<d.c.c.h.a<d.c.i.l.c>> r3) {
        if (r3.b() == true) goto L5;
        return;
    L5:
        d.c.c.h.a<d.c.i.l.c> r4 = r3.e();
        Bitmap r0 = null;
        if (r4 != null) goto L8;
    L16:
        g(r0);     // Catch: Throwable -> L13
        d.c.c.h.a.L(r4);
        return;
    L13:
        th = move-exception;
        d.c.c.h.a.L(r4);
        throw th;
    L8:
        if ((r4.N() instanceof d.c.i.l.b) == false) goto L16;
        r0 = ((d.c.i.l.b) r4.N()).E();
        goto L16
    }

    protected abstract void g(Bitmap r1);
}
