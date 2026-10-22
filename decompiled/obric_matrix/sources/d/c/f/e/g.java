package d.c.f.e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class g extends f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Matrix f15627i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Matrix f15628j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f15629k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f15630l;

    private void p() {
        Drawable r0 = getCurrent();
        Rect r1 = getBounds();
        int r2 = r0.getIntrinsicWidth();
        this.f15629k = r2;
        int r3 = r0.getIntrinsicHeight();
        this.f15630l = r3;
        if (r2 <= 0) goto L7;
        if (r3 <= 0) goto L7;
        r0.setBounds(0, 0, r2, r3);
        Matrix r4 = this.f15627i;
    L8:
        this.f15628j = r4;
        return;
    L7:
        r0.setBounds(r1);
        r4 = null;
        goto L8
    }

    private void q() {
        if (this.f15629k == getCurrent().getIntrinsicWidth()) goto L5;
    L6:
        p();
        return;
    L5:
        if (this.f15630l != getCurrent().getIntrinsicHeight()) goto L6;
    }

    @Override // d.c.f.e.f, d.c.f.e.r
    public void d(Matrix r1) {
        super.d(r1);
        Matrix r0 = this.f15628j;
        if (r0 == null) goto L6;
        r1.preConcat(r0);
        return;
    }

    @Override // d.c.f.e.f, android.graphics.drawable.Drawable
    public void draw(Canvas r3) {
        q();
        if (this.f15628j == null) goto L5;
        int r0 = r3.save();
        r3.clipRect(getBounds());
        r3.concat(this.f15628j);
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
        super.onBoundsChange(r1);
        p();
    }
}
