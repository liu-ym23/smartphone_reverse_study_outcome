package d.c.f.e;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class m extends Drawable implements i, q {

    @Nullable
    Matrix A;

    @Nullable
    Matrix B;
    final Matrix C;
    private float D;
    private boolean E;
    private boolean F;

    @Nullable
    private r G;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final Drawable f15651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected boolean f15652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected boolean f15653h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected float f15654i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final Path f15655j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected boolean f15656k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f15657l;
    protected final Path m;
    private final float[] n;
    final float[] o;

    @Nullable
    float[] p;
    final RectF q;
    final RectF r;
    final RectF s;
    final RectF t;

    @Nullable
    RectF u;
    final Matrix v;
    final Matrix w;
    final Matrix x;
    final Matrix y;
    final Matrix z;

    m(Drawable r6) {
        this.f15652g = false;
        this.f15653h = false;
        this.f15654i = 0.0f;
        this.f15655j = new Path();
        this.f15656k = true;
        this.f15657l = 0;
        this.m = new Path();
        this.n = new float[8];
        this.o = new float[8];
        this.q = new RectF();
        this.r = new RectF();
        this.s = new RectF();
        this.t = new RectF();
        this.v = new Matrix();
        this.w = new Matrix();
        this.x = new Matrix();
        this.y = new Matrix();
        this.z = new Matrix();
        this.C = new Matrix();
        this.D = 0.0f;
        this.E = false;
        this.F = true;
        this.f15651f = r6;
    }

    @Override // d.c.f.e.i
    public void a(int r2, float r3) {
        if (this.f15657l == r2) goto L5;
    L6:
        this.f15657l = r2;
        this.f15654i = r3;
        this.F = true;
        invalidateSelf();
        return;
    L5:
        if (this.f15654i != r3) goto L6;
    }

    @Override // d.c.f.e.q
    public void b(@Nullable r r1) {
        this.G = r1;
    }

    @Override // d.c.f.e.i
    public void c(boolean r1) {
        this.f15652g = r1;
        this.F = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.f15651f.clearColorFilter();
    }

    boolean d() {
        if (this.f15652g == false) goto L5;
    L10:
        return true;
    L5:
        if (this.f15653h == true) goto L10;
        if (this.f15654i > 0.0f) goto L10;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r2) {
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("RoundedDrawable#draw");
    L5:
        this.f15651f.draw(r2);
        if (d.c.i.r.b.d() == false) goto L9;
        d.c.i.r.b.b();
        return;
    }

    @Override // d.c.f.e.i
    public void e(boolean r2) {
        if (this.E == r2) goto L6;
        this.E = r2;
        this.F = true;
        invalidateSelf();
        return;
    }

    protected void f() {
        if (this.F == false) goto L34;
        this.m.reset();
        RectF r0 = this.q;
        float r1 = this.f15654i;
        r0.inset(r1 / 2.0f, r1 / 2.0f);
        if (this.f15652g == false) goto L7;
        this.m.addCircle(this.q.centerX(), this.q.centerY(), Math.min(this.q.width(), this.q.height()) / 2.0f, Path.Direction.CW);
    L12:
        RectF r2 = this.q;
        float r3 = this.f15654i;
        r2.inset((-r3) / 2.0f, (-r3) / 2.0f);
        this.f15655j.reset();
        float r4 = this.D;
        if (this.E == false) goto L15;
        float r5 = this.f15654i;
    L16:
        float r6 = r4 + r5;
        this.q.inset(r6, r6);
        if (this.f15652g == false) goto L20;
        this.f15655j.addCircle(this.q.centerX(), this.q.centerY(), Math.min(this.q.width(), this.q.height()) / 2.0f, Path.Direction.CW);
    L30:
        float r7 = -r6;
        this.q.inset(r7, r7);
        this.f15655j.setFillType(Path.FillType.WINDING);
        this.F = false;
        return;
    L20:
        if (this.E == true) goto L22;
        this.f15655j.addRoundRect(this.q, this.n, Path.Direction.CW);
        goto L30
    L22:
        if (this.p != null) goto L24;
        this.p = new float[8];
    L24:
        int r8 = 0;
    L26:
        if (r8 >= this.o.length) goto L28;
        this.p[r8] = this.n[r8] - this.f15654i;
        r8 = r8 + 1;
        goto L26
    L28:
        this.f15655j.addRoundRect(this.q, this.p, Path.Direction.CW);
        goto L30
    L15:
        r5 = 0.0f;
        goto L16
    L7:
        int r9 = 0;
    L8:
        float[] r10 = this.o;
        if (r9 >= r10.length) goto L11;
        r10[r9] = (this.n[r9] + this.D) - (this.f15654i / 2.0f);
        r9 = r9 + 1;
        goto L8
    L11:
        this.m.addRoundRect(this.q, r10, Path.Direction.CW);
        goto L12
    }

    protected void g() {
        r r0 = this.G;
        if (r0 == null) goto L5;
        r0.d(this.x);
        this.G.g(this.q);
    L6:
        Drawable r1 = this.f15651f;
        if ((r1 instanceof BitmapDrawable) == false) goto L9;
        BitmapDrawable r2 = (BitmapDrawable) r1;
        this.s.set(0.0f, 0.0f, r2.getBitmap().getWidth(), r2.getBitmap().getHeight());
        this.t.set(r2.getBounds());
    L10:
        this.v.setRectToRect(this.s, this.t, Matrix.ScaleToFit.FILL);
        if (this.E == false) goto L20;
        RectF r3 = this.u;
        if (r3 != null) goto L15;
        this.u = new RectF(this.q);
    L16:
        RectF r4 = this.u;
        float r5 = this.f15654i;
        r4.inset(r5, r5);
        if (this.A != null) goto L19;
        this.A = new Matrix();
    L19:
        this.A.setRectToRect(this.q, this.u, Matrix.ScaleToFit.FILL);
    L24:
        if (this.x.equals(this.y) == true) goto L26;
    L31:
        this.f15656k = true;
        this.x.invert(this.z);
        this.C.set(this.x);
        if (this.E == false) goto L34;
        this.C.postConcat(this.A);
    L34:
        this.C.preConcat(this.v);
        this.y.set(this.x);
        this.w.set(this.v);
        if (this.E == false) goto L40;
        Matrix r6 = this.B;
        if (r6 != null) goto L39;
        this.B = new Matrix(this.A);
    L44:
        if (this.q.equals(this.r) == true) goto L47;
        this.F = true;
        this.r.set(this.q);
        return;
    L47:
        return;
    L39:
        r6.set(this.A);
        goto L44
    L40:
        Matrix r7 = this.B;
        if (r7 == null) goto L44;
        r7.reset();
        goto L44
    L26:
        if (this.v.equals(this.w) == false) goto L31;
        Matrix r8 = this.A;
        if (r8 == null) goto L44;
        if (r8.equals(this.B) == true) goto L44;
    L15:
        r3.set(this.q);
        goto L16
    L20:
        Matrix r9 = this.A;
        if (r9 == null) goto L24;
        r9.reset();
        goto L24
    L9:
        this.s.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.t.set(this.f15651f.getBounds());
        goto L10
    L5:
        this.x.reset();
        this.q.set(getBounds());
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.f15651f.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    @RequiresApi(api = 21)
    public ColorFilter getColorFilter() {
        return this.f15651f.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f15651f.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f15651f.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f15651f.getOpacity();
    }

    @Override // d.c.f.e.i
    public void h(float r2) {
        if (this.D == r2) goto L6;
        this.D = r2;
        this.F = true;
        invalidateSelf();
        return;
    }

    @Override // d.c.f.e.i
    public void i(float r5) {
        boolean r1 = false;
        if (r5 < 0.0f) goto L5;
        boolean r3 = true;
    L6:
        d.c.c.d.i.i(r3);
        Arrays.fill(this.n, r5);
        if (r5 == 0.0f) goto L9;
        r1 = true;
    L9:
        this.f15653h = r1;
        this.F = true;
        invalidateSelf();
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // d.c.f.e.i
    public void l(float[] r8) {
        if (r8 != null) goto L6;
        Arrays.fill(this.n, 0.0f);
        this.f15653h = false;
    L16:
        this.F = true;
        invalidateSelf();
        return;
    L6:
        if (r8.length != 8) goto L8;
        boolean r3 = true;
    L9:
        d.c.c.d.i.c(r3, "radii should have exactly 8 values");
        System.arraycopy(r8, 0, this.n, 0, 8);
        this.f15653h = false;
        int r4 = 0;
    L10:
        if (r4 >= 8) goto L16;
        boolean r5 = this.f15653h;
        if (r8[r4] <= 0.0f) goto L14;
        boolean r6 = true;
    L15:
        this.f15653h = r5 | r6;
        r4 = r4 + 1;
        goto L10
    L14:
        r6 = false;
        goto L15
    L8:
        r3 = false;
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r1) {
        this.f15651f.setBounds(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
        this.f15651f.setAlpha(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int r1, @NonNull PorterDuff.Mode r2) {
        this.f15651f.setColorFilter(r1, r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r1) {
        this.f15651f.setColorFilter(r1);
    }
}
