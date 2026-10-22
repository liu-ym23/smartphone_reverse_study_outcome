package d.c.i.o;

import android.content.Context;
import android.graphics.Bitmap;
import d.c.b.a.d;
import d.c.b.a.j;
import d.c.i.d.f;
import d.c.i.k.b;

/* JADX INFO: loaded from: classes2.dex */
public class a extends d.c.i.q.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f16201f = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f16203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d f16205e;

    static {
        f16201f = b.b();
    }

    @Override // d.c.i.q.a, d.c.i.q.d
    public d.c.c.h.a<Bitmap> b(Bitmap r4, f r5) {
        if (r4.getConfig().equals(Bitmap.Config.ARGB_8888) == true) goto L5;
        Bitmap r0 = r4.copy(Bitmap.Config.ARGB_8888, true);
    L6:
        d.c.c.h.a<Bitmap> r6 = r5.l(r4.getWidth(), r4.getHeight(), Bitmap.Config.ARGB_8888);
        g(r6.N(), r0);     // Catch: Throwable -> L10
        d.c.c.h.a<Bitmap> r3 = d.c.c.h.a.E(r6);     // Catch: Throwable -> L10
        d.c.c.h.a.L(r6);
        return r3;
    L10:
        th = move-exception;
        d.c.c.h.a.L(r6);
        throw th;
    L5:
        r0 = r4;
        goto L6
    }

    @Override // d.c.i.q.a, d.c.i.q.d
    public d c() {
        if (this.f16205e != null) goto L10;
        if (f16201f == false) goto L7;
        String r0 = String.format(null, "IntrinsicBlur;%d", new Object[]{Integer.valueOf(this.f16204d)});
    L8:
        this.f16205e = new j(r0);
        goto L10
    L7:
        r0 = String.format(null, "IterativeBoxBlur;%d;%d", new Object[]{Integer.valueOf(this.f16202b), Integer.valueOf(this.f16204d)});
    L10:
        return this.f16205e;
    }

    @Override // d.c.i.q.a
    public void f(Bitmap r2) {
        d.c.i.k.a.b(r2, this.f16202b, this.f16204d);
    }

    @Override // d.c.i.q.a
    public void g(Bitmap r2, Bitmap r3) {
        if (f16201f == false) goto L5;
        b.a(r2, r3, this.f16203c, this.f16204d);
        return;
    L5:
        super.g(r2, r3);
    }
}
