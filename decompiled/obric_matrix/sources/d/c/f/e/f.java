package d.c.f.e;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class f extends Drawable implements Drawable.Callback, r, q, b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Drawable f15624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c f15625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected r f15626h;

    static {
        new Matrix();
    }

    public f(@Nullable Drawable r2) {
        this.f15625g = new c();
        this.f15624f = r2;
        d.d(r2, this, this);
    }

    @Override // d.c.f.e.q
    public void b(r r1) {
        this.f15626h = r1;
    }

    @Override // d.c.f.e.r
    public void d(Matrix r1) {
        m(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r1) {
        Drawable r0 = this.f15624f;
        if (r0 == null) goto L6;
        r0.draw(r1);
        return;
    }

    @Override // d.c.f.e.b
    public Drawable f(@Nullable Drawable r1) {
        return n(r1);
    }

    @Override // d.c.f.e.r
    public void g(RectF r2) {
        r r0 = this.f15626h;
        if (r0 == null) goto L5;
        r0.g(r2);
        return;
    L5:
        r2.set(getBounds());
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        Drawable r0 = this.f15624f;
        if (r0 != null) goto L7;
        return super.getConstantState();
    L7:
        return r0.getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable getCurrent() {
        return this.f15624f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable r0 = this.f15624f;
        if (r0 != null) goto L7;
        return super.getIntrinsicHeight();
    L7:
        return r0.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable r0 = this.f15624f;
        if (r0 != null) goto L7;
        return super.getIntrinsicWidth();
    L7:
        return r0.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable r0 = this.f15624f;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r2) {
        Drawable r0 = this.f15624f;
        if (r0 != null) goto L7;
        return super.getPadding(r2);
    L7:
        return r0.getPadding(r2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r1) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable r0 = this.f15624f;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isStateful();
    }

    @Override // d.c.f.e.b
    @Nullable
    public Drawable k() {
        return getCurrent();
    }

    protected void m(Matrix r1) {
        r r0 = this.f15626h;
        if (r0 == null) goto L5;
        r0.d(r1);
        return;
    L5:
        r1.reset();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable r0 = this.f15624f;
        if (r0 == null) goto L5;
        r0.mutate();
    L5:
        return this;
    }

    @Nullable
    public Drawable n(@Nullable Drawable r1) {
        Drawable r2 = o(r1);
        invalidateSelf();
        return r2;
    }

    @Nullable
    protected Drawable o(@Nullable Drawable r3) {
        Drawable r0 = this.f15624f;
        d.d(r0, null, null);
        d.d(r3, null, null);
        d.e(r3, this.f15625g);
        d.a(r3, this);
        d.d(r3, this, this);
        this.f15624f = r3;
        return r0;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r1) {
        Drawable r0 = this.f15624f;
        if (r0 == null) goto L6;
        r0.setBounds(r1);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int r2) {
        Drawable r0 = this.f15624f;
        if (r0 != null) goto L7;
        return super.onLevelChange(r2);
    L7:
        return r0.setLevel(r2);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] r2) {
        Drawable r0 = this.f15624f;
        if (r0 != null) goto L7;
        return super.onStateChange(r2);
    L7:
        return r0.setState(r2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
        scheduleSelf(r2, r3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.f15625g.b(r2);
        Drawable r1 = this.f15624f;
        if (r1 == null) goto L6;
        r1.setAlpha(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.f15625g.c(r2);
        Drawable r1 = this.f15624f;
        if (r1 == null) goto L6;
        r1.setColorFilter(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r2) {
        this.f15625g.d(r2);
        Drawable r1 = this.f15624f;
        if (r1 == null) goto L6;
        r1.setDither(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r2) {
        this.f15625g.e(r2);
        Drawable r1 = this.f15624f;
        if (r1 == null) goto L6;
        r1.setFilterBitmap(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float r1, float r2) {
        Drawable r0 = this.f15624f;
        if (r0 == null) goto L6;
        r0.setHotspot(r1, r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r2, boolean r3) {
        boolean r0 = super.setVisible(r2, r3);
        Drawable r1 = this.f15624f;
        if (r1 != null) goto L6;
        return r0;
    L6:
        return r1.setVisible(r2, r3);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r1, Runnable r2) {
        unscheduleSelf(r2);
    }
}
