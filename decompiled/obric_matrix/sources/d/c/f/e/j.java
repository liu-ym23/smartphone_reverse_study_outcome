package d.c.f.e;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class j extends m {
    private final Paint H;
    private final Paint I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final Bitmap f15635J;
    private WeakReference<Bitmap> K;

    public j(Resources r5, Bitmap r6, Paint r7) {
        super(new BitmapDrawable(r5, r6));
        Paint r8 = new Paint();
        this.H = r8;
        Paint r0 = new Paint(1);
        this.I = r0;
        this.f15635J = r6;
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L10:
        if (r7 == null) goto L12;
        r8.set(r7);
    L12:
        r8.setFlags(1);
        r0.setStyle(Paint.Style.STROKE);
        return;
    L5:
        if ((this.f15651f instanceof BitmapDrawable) == false) goto L10;
        if (r6 == null) goto L10;
        int r9 = r6.getDensity();
        int r2 = DisplayMetrics.DENSITY_DEVICE_STABLE;
        if (r9 != r2) goto L10;
        ((BitmapDrawable) this.f15651f).setTargetDensity(r2);
        goto L10
    }

    private void j() {
        WeakReference<Bitmap> r0 = this.K;
        if (r0 != null) goto L5;
    L6:
        this.K = new WeakReference(this.f15635J);
        this.H.setFilterBitmap(true);
        Paint r1 = this.H;
        Bitmap r3 = this.f15635J;
        Shader.TileMode r4 = Shader.TileMode.CLAMP;
        r1.setShader(new BitmapShader(r3, r4, r4));
        this.f15656k = true;
    L8:
        if (this.f15656k == false) goto L11;
        this.H.getShader().setLocalMatrix(this.C);
        this.f15656k = false;
        return;
    L11:
        return;
    L5:
        if (r0.get() == this.f15635J) goto L8;
        goto L6
    }

    @Override // d.c.f.e.m
    boolean d() {
        if (super.d() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f15635J == null) goto L7;
        return true;
    }

    @Override // d.c.f.e.m, android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        if (d.c.i.r.b.d() == false) goto L6;
        d.c.i.r.b.a("RoundedBitmapDrawable#draw");
    L6:
        if (d() == true) goto L11;
        super.draw(r5);
        if (d.c.i.r.b.d() == false) goto L18;
        d.c.i.r.b.b();
        return;
    L18:
        return;
    L11:
        g();
        f();
        j();
        int r0 = r5.save();
        r5.concat(this.z);
        r5.drawPath(this.f15655j, this.H);
        float r1 = this.f15654i;
        if (r1 <= 0.0f) goto L14;
        this.I.setStrokeWidth(r1);
        this.I.setColor(d.c(this.f15657l, this.H.getAlpha()));
        r5.drawPath(this.m, this.I);
    L14:
        r5.restoreToCount(r0);
        if (d.c.i.r.b.d() == false) goto L19;
        d.c.i.r.b.b();
        return;
    }

    @Override // d.c.f.e.m, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Bitmap r0 = this.f15635J;
        if (r0 == null) goto L7;
        return r0.getHeight();
    L7:
        return super.getIntrinsicHeight();
    }

    @Override // d.c.f.e.m, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Bitmap r0 = this.f15635J;
        if (r0 == null) goto L7;
        return r0.getWidth();
    L7:
        return super.getIntrinsicWidth();
    }

    @Override // d.c.f.e.m, android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        super.setAlpha(r2);
        if (r2 == this.H.getAlpha()) goto L6;
        this.H.setAlpha(r2);
        super.setAlpha(r2);
        invalidateSelf();
        return;
    }

    @Override // d.c.f.e.m, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
        super.setColorFilter(r1);
        this.H.setColorFilter(r1);
    }
}
