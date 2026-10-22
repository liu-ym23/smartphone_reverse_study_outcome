package d.c.i.p;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public class i implements k0<d.c.c.h.a<d.c.i.l.c>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k0<d.c.c.h.a<d.c.i.l.c>> f16294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f16297d;

    private static class a extends n<d.c.c.h.a<d.c.i.l.c>, d.c.c.h.a<d.c.i.l.c>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f16298c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f16299d;

        a(k<d.c.c.h.a<d.c.i.l.c>> r1, int r2, int r3) {
            super(r1);
            this.f16298c = r2;
            this.f16299d = r3;
        }

        private void q(d.c.c.h.a<d.c.i.l.c> r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            if (r3.Q() == false) goto L27;
            d.c.i.l.c r4 = r3.N();
            if (r4 != null) goto L9;
            return;
        L9:
            if (r4.isClosed() == false) goto L12;
            return;
        L12:
            if ((r4 instanceof d.c.i.l.d) == false) goto L26;
            Bitmap r5 = ((d.c.i.l.d) r4).E();
            if (r5 != null) goto L16;
            return;
        L16:
            int r0 = r5.getRowBytes() * r5.getHeight();
            if (r0 >= this.f16298c) goto L20;
            return;
        L20:
            if (r0 <= this.f16299d) goto L22;
            return;
        L22:
            r5.prepareToDraw();
            return;
        L26:
            return;
        }

        @Override // d.c.i.p.b
        protected /* bridge */ /* synthetic */ void i(Object r1, int r2) {
            r((d.c.c.h.a) r1, r2);
        }

        protected void r(d.c.c.h.a<d.c.i.l.c> r1, int r2) {
            q(r1);
            p().d(r1, r2);
        }
    }

    public i(k0<d.c.c.h.a<d.c.i.l.c>> r2, int r3, int r4, boolean r5) {
        if (r3 > r4) goto L5;
        boolean r0 = true;
    L6:
        d.c.c.d.i.b(r0);
        d.c.c.d.i.g(r2);
        this.f16294a = r2;
        this.f16295b = r3;
        this.f16296c = r4;
        this.f16297d = r5;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // d.c.i.p.k0
    public void b(k<d.c.c.h.a<d.c.i.l.c>> r4, l0 r5) {
        if (r5.e() == true) goto L5;
    L7:
        this.f16294a.b(new a(r4, this.f16295b, this.f16296c), r5);
        return;
    L5:
        if (this.f16297d == true) goto L7;
        this.f16294a.b(r4, r5);
    }
}
