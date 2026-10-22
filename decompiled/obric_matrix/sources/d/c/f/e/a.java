package d.c.f.e;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class a extends Drawable implements Drawable.Callback, r, q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private r f15610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c f15611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Drawable[] f15612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final b[] f15613i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Rect f15614j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f15615k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f15616l;
    private boolean m;

    /* JADX INFO: renamed from: d.c.f.e.a$a, reason: collision with other inner class name */
    class C0421a implements b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f15617f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f15618g;

        C0421a(a r1, int r2) {
            this.f15618g = r1;
            this.f15617f = r2;
        }

        @Override // d.c.f.e.b
        public Drawable f(Drawable r2) {
            return this.f15618g.h(this.f15617f, r2);
        }

        @Override // d.c.f.e.b
        public Drawable k() {
            return this.f15618g.c(this.f15617f);
        }
    }

    public a(Drawable[] r3) {
        this.f15611g = new c();
        this.f15614j = new Rect();
        int r0 = 0;
        this.f15615k = false;
        this.f15616l = false;
        this.m = false;
        d.c.c.d.i.g(r3);
        this.f15612h = r3;
    L3:
        Drawable[] r4 = this.f15612h;
        if (r0 >= r4.length) goto L6;
        d.d(r4[r0], this, this);
        r0 = r0 + 1;
        goto L3
    L6:
        this.f15613i = new b[r4.length];
    }

    private b a(int r2) {
        return new C0421a(this, r2);
    }

    @Override // d.c.f.e.q
    public void b(r r1) {
        this.f15610f = r1;
    }

    public Drawable c(int r4) {
        boolean r0 = true;
        if (r4 < 0) goto L5;
        boolean r2 = true;
    L6:
        d.c.c.d.i.b(r2);
        if (r4 < this.f15612h.length) goto L10;
        r0 = false;
    L10:
        d.c.c.d.i.b(r0);
        return this.f15612h[r4];
    L5:
        r2 = false;
        goto L6
    }

    @Override // d.c.f.e.r
    public void d(Matrix r1) {
        r r0 = this.f15610f;
        if (r0 == null) goto L5;
        r0.d(r1);
        return;
    L5:
        r1.reset();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r4) {
        int r0 = 0;
    L3:
        Drawable[] r1 = this.f15612h;
        if (r0 >= r1.length) goto L9;
        Drawable r2 = r1[r0];
        if (r2 == null) goto L8;
        r2.draw(r4);
    L8:
        r0 = r0 + 1;
        goto L3
    }

    public b e(int r4) {
        boolean r0 = true;
        if (r4 < 0) goto L5;
        boolean r2 = true;
    L6:
        d.c.c.d.i.b(r2);
        if (r4 < this.f15613i.length) goto L10;
        r0 = false;
    L10:
        d.c.c.d.i.b(r0);
        b[] r1 = this.f15613i;
        if (r1[r4] != null) goto L14;
        r1[r4] = a(r4);
    L14:
        return this.f15613i[r4];
    L5:
        r2 = false;
        goto L6
    }

    public int f() {
        return this.f15612h.length;
    }

    @Override // d.c.f.e.r
    public void g(RectF r2) {
        r r0 = this.f15610f;
        if (r0 == null) goto L5;
        r0.g(r2);
        return;
    L5:
        r2.set(getBounds());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int r1 = 0;
        int r2 = -1;
    L3:
        Drawable[] r3 = this.f15612h;
        if (r1 >= r3.length) goto L9;
        Drawable r4 = r3[r1];
        if (r4 == null) goto L8;
        r2 = Math.max(r2, r4.getIntrinsicHeight());
    L8:
        r1 = r1 + 1;
        goto L3
    L9:
        if (r2 > 0) goto L11;
        return -1;
    L11:
        return r2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int r1 = 0;
        int r2 = -1;
    L3:
        Drawable[] r3 = this.f15612h;
        if (r1 >= r3.length) goto L9;
        Drawable r4 = r3[r1];
        if (r4 == null) goto L8;
        r2 = Math.max(r2, r4.getIntrinsicWidth());
    L8:
        r1 = r1 + 1;
        goto L3
    L9:
        if (r2 > 0) goto L11;
        return -1;
    L11:
        return r2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f15612h.length != 0) goto L6;
        return -2;
    L6:
        int r0 = -1;
        int r1 = 1;
    L7:
        Drawable[] r2 = this.f15612h;
        if (r1 >= r2.length) goto L13;
        Drawable r3 = r2[r1];
        if (r3 == null) goto L12;
        r0 = Drawable.resolveOpacity(r0, r3.getOpacity());
    L12:
        r1 = r1 + 1;
        goto L7
    L13:
        return r0;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r5) {
        int r0 = 0;
        r5.left = 0;
        r5.top = 0;
        r5.right = 0;
        r5.bottom = 0;
        Rect r1 = this.f15614j;
    L3:
        Drawable[] r2 = this.f15612h;
        if (r0 >= r2.length) goto L9;
        Drawable r3 = r2[r0];
        if (r3 == null) goto L8;
        r3.getPadding(r1);
        r5.left = Math.max(r5.left, r1.left);
        r5.top = Math.max(r5.top, r1.top);
        r5.right = Math.max(r5.right, r1.right);
        r5.bottom = Math.max(r5.bottom, r1.bottom);
    L8:
        r0 = r0 + 1;
        goto L3
    L9:
        return true;
    }

    public Drawable h(int r5, Drawable r6) {
        boolean r0 = true;
        if (r5 < 0) goto L5;
        boolean r2 = true;
    L6:
        d.c.c.d.i.b(r2);
        if (r5 < this.f15612h.length) goto L10;
        r0 = false;
    L10:
        d.c.c.d.i.b(r0);
        Drawable r1 = this.f15612h[r5];
        if (r6 == r1) goto L17;
        if (r6 != null) goto L14;
    L16:
        d.d(this.f15612h[r5], null, null);
        d.d(r6, null, null);
        d.e(r6, this.f15611g);
        d.a(r6, this);
        d.d(r6, this, this);
        this.f15616l = false;
        this.f15612h[r5] = r6;
        invalidateSelf();
        goto L17
    L14:
        if (this.m == false) goto L16;
        r6.mutate();
    L17:
        return r1;
    L5:
        r2 = false;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r1) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.f15616l == true) goto L16;
        this.f15615k = false;
        int r1 = 0;
    L5:
        Drawable[] r2 = this.f15612h;
        boolean r4 = true;
        if (r1 >= r2.length) goto L14;
        Drawable r3 = r2[r1];
        boolean r5 = this.f15615k;
        if (r3 != null) goto L10;
    L12:
        r4 = false;
    L13:
        this.f15615k = r5 | r4;
        r1 = r1 + 1;
        goto L5
    L10:
        if (r3.isStateful() == false) goto L12;
    L14:
        this.f15616l = true;
    L16:
        return this.f15615k;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        int r0 = 0;
    L3:
        Drawable[] r1 = this.f15612h;
        if (r0 >= r1.length) goto L9;
        Drawable r2 = r1[r0];
        if (r2 == null) goto L8;
        r2.mutate();
    L8:
        r0 = r0 + 1;
        goto L3
    L9:
        this.m = true;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r4) {
        int r0 = 0;
    L3:
        Drawable[] r1 = this.f15612h;
        if (r0 >= r1.length) goto L9;
        Drawable r2 = r1[r0];
        if (r2 == null) goto L8;
        r2.setBounds(r4);
    L8:
        r0 = r0 + 1;
        goto L3
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int r5) {
        int r0 = 0;
        boolean r1 = false;
    L3:
        Drawable[] r2 = this.f15612h;
        if (r0 >= r2.length) goto L11;
        Drawable r3 = r2[r0];
        if (r3 == null) goto L10;
        if (r3.setLevel(r5) == false) goto L10;
        r1 = true;
    L10:
        r0 = r0 + 1;
        goto L3
    L11:
        return r1;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] r5) {
        int r0 = 0;
        boolean r1 = false;
    L3:
        Drawable[] r2 = this.f15612h;
        if (r0 >= r2.length) goto L11;
        Drawable r3 = r2[r0];
        if (r3 == null) goto L10;
        if (r3.setState(r5) == false) goto L10;
        r1 = true;
    L10:
        r0 = r0 + 1;
        goto L3
    L11:
        return r1;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
        scheduleSelf(r2, r3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r4) {
        this.f15611g.b(r4);
        int r0 = 0;
    L3:
        Drawable[] r1 = this.f15612h;
        if (r0 >= r1.length) goto L9;
        Drawable r2 = r1[r0];
        if (r2 == null) goto L8;
        r2.setAlpha(r4);
    L8:
        r0 = r0 + 1;
        goto L3
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r4) {
        this.f15611g.c(r4);
        int r0 = 0;
    L3:
        Drawable[] r1 = this.f15612h;
        if (r0 >= r1.length) goto L9;
        Drawable r2 = r1[r0];
        if (r2 == null) goto L8;
        r2.setColorFilter(r4);
    L8:
        r0 = r0 + 1;
        goto L3
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r4) {
        this.f15611g.d(r4);
        int r0 = 0;
    L3:
        Drawable[] r1 = this.f15612h;
        if (r0 >= r1.length) goto L9;
        Drawable r2 = r1[r0];
        if (r2 == null) goto L8;
        r2.setDither(r4);
    L8:
        r0 = r0 + 1;
        goto L3
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r4) {
        this.f15611g.e(r4);
        int r0 = 0;
    L3:
        Drawable[] r1 = this.f15612h;
        if (r0 >= r1.length) goto L9;
        Drawable r2 = r1[r0];
        if (r2 == null) goto L8;
        r2.setFilterBitmap(r4);
    L8:
        r0 = r0 + 1;
        goto L3
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float r4, float r5) {
        int r0 = 0;
    L3:
        Drawable[] r1 = this.f15612h;
        if (r0 >= r1.length) goto L9;
        Drawable r2 = r1[r0];
        if (r2 == null) goto L8;
        r2.setHotspot(r4, r5);
    L8:
        r0 = r0 + 1;
        goto L3
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r5, boolean r6) {
        boolean r0 = super.setVisible(r5, r6);
        int r1 = 0;
    L3:
        Drawable[] r2 = this.f15612h;
        if (r1 >= r2.length) goto L9;
        Drawable r3 = r2[r1];
        if (r3 == null) goto L8;
        r3.setVisible(r5, r6);
    L8:
        r1 = r1 + 1;
        goto L3
    L9:
        return r0;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r1, Runnable r2) {
        unscheduleSelf(r2);
    }
}
