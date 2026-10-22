package d.c.f.e;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class k extends Drawable implements i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float[] f15636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final float[] f15637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float[] f15638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Paint f15639i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f15640j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f15641k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f15642l;
    private int m;
    private boolean n;
    final Path o;
    final Path p;
    private int q;
    private final RectF r;
    private int s;

    public k(int r3) {
        this.f15636f = new float[8];
        this.f15637g = new float[8];
        this.f15639i = new Paint(1);
        this.f15640j = false;
        this.f15641k = 0.0f;
        this.f15642l = 0.0f;
        this.m = 0;
        this.n = false;
        this.o = new Path();
        this.p = new Path();
        this.q = 0;
        this.r = new RectF();
        this.s = 255;
        d(r3);
    }

    @TargetApi(11)
    public static k b(ColorDrawable r1) {
        return new k(r1.getColor());
    }

    private void f() {
        this.o.reset();
        this.p.reset();
        this.r.set(getBounds());
        RectF r0 = this.r;
        float r1 = this.f15641k;
        r0.inset(r1 / 2.0f, r1 / 2.0f);
        int r2 = 0;
        if (this.f15640j == false) goto L5;
        this.p.addCircle(this.r.centerX(), this.r.centerY(), Math.min(this.r.width(), this.r.height()) / 2.0f, Path.Direction.CW);
    L10:
        RectF r3 = this.r;
        float r4 = this.f15641k;
        r3.inset((-r4) / 2.0f, (-r4) / 2.0f);
        float r5 = this.f15642l;
        if (this.n == false) goto L13;
        float r6 = this.f15641k;
    L14:
        float r7 = r5 + r6;
        this.r.inset(r7, r7);
        if (this.f15640j == false) goto L18;
        this.o.addCircle(this.r.centerX(), this.r.centerY(), Math.min(this.r.width(), this.r.height()) / 2.0f, Path.Direction.CW);
    L27:
        float r8 = -r7;
        this.r.inset(r8, r8);
        return;
    L18:
        if (this.n == true) goto L20;
        this.o.addRoundRect(this.r, this.f15636f, Path.Direction.CW);
        goto L27
    L20:
        if (this.f15638h != null) goto L22;
        this.f15638h = new float[8];
    L22:
        float[] r9 = this.f15638h;
        if (r2 >= r9.length) goto L25;
        r9[r2] = this.f15636f[r2] - this.f15641k;
        r2 = r2 + 1;
        goto L22
    L25:
        this.o.addRoundRect(this.r, r9, Path.Direction.CW);
        goto L27
    L13:
        r6 = 0.0f;
        goto L14
    L5:
        int r10 = 0;
    L6:
        float[] r11 = this.f15637g;
        if (r10 >= r11.length) goto L9;
        r11[r10] = (this.f15636f[r10] + this.f15642l) - (this.f15641k / 2.0f);
        r10 = r10 + 1;
        goto L6
    L9:
        this.p.addRoundRect(this.r, r11, Path.Direction.CW);
        goto L10
    }

    @Override // d.c.f.e.i
    public void a(int r2, float r3) {
        if (this.m == r2) goto L6;
        this.m = r2;
        invalidateSelf();
    L6:
        if (this.f15641k == r3) goto L9;
        this.f15641k = r3;
        f();
        invalidateSelf();
        return;
    }

    @Override // d.c.f.e.i
    public void c(boolean r1) {
        this.f15640j = r1;
        f();
        invalidateSelf();
    }

    public void d(int r2) {
        if (this.q == r2) goto L6;
        this.q = r2;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r4) {
        this.f15639i.setColor(d.c(this.q, this.s));
        this.f15639i.setStyle(Paint.Style.FILL);
        r4.drawPath(this.o, this.f15639i);
        if (this.f15641k == 0.0f) goto L6;
        this.f15639i.setColor(d.c(this.m, this.s));
        this.f15639i.setStyle(Paint.Style.STROKE);
        this.f15639i.setStrokeWidth(this.f15641k);
        r4.drawPath(this.p, this.f15639i);
        return;
    }

    @Override // d.c.f.e.i
    public void e(boolean r2) {
        if (this.n == r2) goto L6;
        this.n = r2;
        f();
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.s;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return d.b(d.c(this.q, this.s));
    }

    @Override // d.c.f.e.i
    public void h(float r2) {
        if (this.f15642l == r2) goto L6;
        this.f15642l = r2;
        f();
        invalidateSelf();
        return;
    }

    @Override // d.c.f.e.i
    public void i(float r3) {
        if (r3 < 0.0f) goto L5;
        boolean r0 = true;
    L6:
        d.c.c.d.i.c(r0, "radius should be non negative");
        Arrays.fill(this.f15636f, r3);
        f();
        invalidateSelf();
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // d.c.f.e.i
    public void l(float[] r5) {
        if (r5 != null) goto L5;
        Arrays.fill(this.f15636f, 0.0f);
    L9:
        f();
        invalidateSelf();
        return;
    L5:
        if (r5.length != 8) goto L7;
        boolean r0 = true;
    L8:
        d.c.c.d.i.c(r0, "radii should have exactly 8 values");
        System.arraycopy(r5, 0, this.f15636f, 0, 8);
        goto L9
    L7:
        r0 = false;
        goto L8
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r1) {
        super.onBoundsChange(r1);
        f();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        if (r2 == this.s) goto L6;
        this.s = r2;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }
}
