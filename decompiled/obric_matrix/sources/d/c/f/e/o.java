package d.c.f.e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class o extends f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    p.b f15658i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f15659j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    PointF f15660k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f15661l;
    int m;
    Matrix n;
    private Matrix o;

    public o(Drawable r1, p.b r2) {
        d.c.c.d.i.g(r1);
        super(r1);
        this.f15660k = null;
        this.f15661l = 0;
        this.m = 0;
        this.o = new Matrix();
        this.f15658i = r2;
    }

    private void q() {
        p.b r0 = this.f15658i;
        boolean r2 = true;
        if ((r0 instanceof p.l) == false) goto L12;
        Object r1 = ((p.l) r0).getState();
        if (r1 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        this.f15659j = r1;
    L14:
        if (this.f15661l == getCurrent().getIntrinsicWidth()) goto L16;
    L19:
        if (r2 == true) goto L21;
        if (r3 == true) goto L21;
        return;
    L21:
        p();
        return;
    L16:
        if (this.m != getCurrent().getIntrinsicHeight()) goto L19;
        r2 = false;
        goto L19
    L7:
        if (r1.equals(this.f15659j) == false) goto L10;
        r3 = false;
        goto L11
    L12:
        r3 = false;
        goto L14
    }

    @Override // d.c.f.e.f, d.c.f.e.r
    public void d(Matrix r1) {
        m(r1);
        q();
        Matrix r0 = this.n;
        if (r0 == null) goto L6;
        r1.preConcat(r0);
        return;
    }

    @Override // d.c.f.e.f, android.graphics.drawable.Drawable
    public void draw(Canvas r3) {
        q();
        if (this.n == null) goto L5;
        int r0 = r3.save();
        r3.clipRect(getBounds());
        r3.concat(this.n);
        super.draw(r3);
        r3.restoreToCount(r0);
        return;
    L5:
        super.draw(r3);
    }

    @Override // d.c.f.e.f
    public Drawable n(Drawable r1) {
        Drawable r2 = super.n(r1);
        p();
        return r2;
    }

    @Override // d.c.f.e.f, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r1) {
        p();
    }

    void p() {
        Drawable r0 = getCurrent();
        Rect r3 = getBounds();
        int r1 = r3.width();
        int r2 = r3.height();
        int r4 = r0.getIntrinsicWidth();
        this.f15661l = r4;
        int r5 = r0.getIntrinsicHeight();
        this.m = r5;
        if (r4 <= 0) goto L23;
        if (r5 <= 0) goto L23;
        if (r4 != r1) goto L11;
        if (r5 != r2) goto L11;
        r0.setBounds(r3);
        this.n = null;
        return;
    L11:
        if (this.f15658i != p.b.f15662a) goto L14;
        r0.setBounds(r3);
        this.n = null;
        return;
    L14:
        r0.setBounds(0, 0, r4, r5);
        p.b r6 = this.f15658i;
        Matrix r7 = this.o;
        PointF r8 = this.f15660k;
        if (r8 == null) goto L17;
        float r9 = r8.x;
    L18:
        if (r8 == null) goto L20;
        float r10 = r8.y;
    L21:
        r6.a(r7, r3, r4, r5, r9, r10);
        this.n = this.o;
        return;
    L20:
        r10 = 0.5f;
        goto L21
    L17:
        r9 = 0.5f;
    L23:
        r0.setBounds(r3);
        this.n = null;
    }

    public p.b r() {
        return this.f15658i;
    }

    public void s(PointF r2) {
        if (d.c.c.d.h.a(this.f15660k, r2) == false) goto L6;
        return;
    L6:
        if (this.f15660k != null) goto L8;
        this.f15660k = new PointF();
    L8:
        this.f15660k.set(r2);
        p();
        invalidateSelf();
    }

    public void t(p.b r2) {
        if (d.c.c.d.h.a(this.f15658i, r2) == false) goto L5;
        return;
    L5:
        this.f15658i = r2;
        this.f15659j = null;
        p();
        invalidateSelf();
    }
}
