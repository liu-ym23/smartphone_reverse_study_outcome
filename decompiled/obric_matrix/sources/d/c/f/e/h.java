package d.c.f.e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class h extends f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Matrix f15631i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f15632j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f15633k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Matrix f15634l;
    private final RectF m;

    public h(Drawable r3, int r4, int r5) {
        super(r3);
        this.f15634l = new Matrix();
        this.m = new RectF();
        boolean r0 = true;
        if ((r4 % 90) != 0) goto L5;
        boolean r6 = true;
    L6:
        d.c.c.d.i.b(r6);
        if (r5 >= 0) goto L9;
    L11:
        r0 = false;
    L12:
        d.c.c.d.i.b(r0);
        this.f15631i = new Matrix();
        this.f15632j = r4;
        this.f15633k = r5;
        return;
    L9:
        if (r5 > 8) goto L11;
    L5:
        r6 = false;
        goto L6
    }

    @Override // d.c.f.e.f, d.c.f.e.r
    public void d(Matrix r2) {
        m(r2);
        if (this.f15631i.isIdentity() == true) goto L6;
        r2.preConcat(this.f15631i);
        return;
    }

    @Override // d.c.f.e.f, android.graphics.drawable.Drawable
    public void draw(Canvas r3) {
        if (this.f15632j > 0) goto L10;
        int r0 = this.f15633k;
        if (r0 != 0) goto L7;
    L8:
        super.draw(r3);
        return;
    L7:
        if (r0 == 1) goto L8;
    L10:
        int r1 = r3.save();
        r3.concat(this.f15631i);
        super.draw(r3);
        r3.restoreToCount(r1);
    }

    @Override // d.c.f.e.f, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int r0 = this.f15633k;
        if (r0 == 5) goto L12;
        if (r0 == 7) goto L12;
        if ((this.f15632j % 180) != 0) goto L12;
        return super.getIntrinsicHeight();
    L12:
        return super.getIntrinsicWidth();
    }

    @Override // d.c.f.e.f, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int r0 = this.f15633k;
        if (r0 == 5) goto L12;
        if (r0 == 7) goto L12;
        if ((this.f15632j % 180) != 0) goto L12;
        return super.getIntrinsicWidth();
    L12:
        return super.getIntrinsicHeight();
    }

    @Override // d.c.f.e.f, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r8) {
        Drawable r0 = getCurrent();
        int r1 = this.f15632j;
        if (r1 > 0) goto L10;
        int r2 = this.f15633k;
        if (r2 != 0) goto L7;
    L9:
        r0.setBounds(r8);
        return;
    L7:
        if (r2 == 1) goto L9;
    L10:
        int r3 = this.f15633k;
        if (r3 != 2) goto L13;
        this.f15631i.setScale(-1.0f, 1.0f);
    L23:
        this.f15634l.reset();
        this.f15631i.invert(this.f15634l);
        this.m.set(r8);
        this.f15634l.mapRect(this.m);
        RectF r7 = this.m;
        r0.setBounds((int) r7.left, (int) r7.top, (int) r7.right, (int) r7.bottom);
        return;
    L13:
        if (r3 != 7) goto L15;
        this.f15631i.setRotate(270.0f, r8.centerX(), r8.centerY());
        this.f15631i.postScale(-1.0f, 1.0f);
        goto L23
    L15:
        if (r3 != 4) goto L17;
        this.f15631i.setScale(1.0f, -1.0f);
        goto L23
    L17:
        if (r3 == 5) goto L19;
        this.f15631i.setRotate(r1, r8.centerX(), r8.centerY());
        goto L23
    L19:
        this.f15631i.setRotate(270.0f, r8.centerX(), r8.centerY());
        this.f15631i.postScale(1.0f, -1.0f);
        goto L23
    }
}
