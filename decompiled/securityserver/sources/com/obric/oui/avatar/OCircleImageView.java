package com.obric.oui.avatar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.obric.common.oui.R;

/* JADX INFO: loaded from: classes2.dex */
public class OCircleImageView extends AppCompatImageView {
    public static final Bitmap.Config A = null;
    public static final ImageView.ScaleType z = null;
    public final RectF b;
    public final RectF c;
    public final Matrix e;
    public final Paint f;
    public final Paint i;
    public final Paint j;
    public int k;
    public int l;
    public int m;
    public int n;
    public Bitmap o;
    public Canvas p;
    public float q;
    public float r;
    public ColorFilter s;
    public final boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public int y;

    /* JADX INFO: renamed from: com.obric.oui.avatar.OCircleImageView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    @RequiresApi(api = 21)
    public class OutlineProvider extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OCircleImageView f172a;

        public OutlineProvider(OCircleImageView r1) {
            this.f172a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r2, Outline r3) {
            OCircleImageView r1 = this.f172a;
            if (r1.x == false) goto L5;
            ViewOutlineProvider.BACKGROUND.getOutline(r2, r3);
            return;
        L5:
            Rect r4 = new Rect();
            r1.c.roundOut(r4);
            r3.setRoundRect(r4, r4.width() / 2.0f);
        }
    }

    static {
        z = ImageView.ScaleType.CENTER_CROP;
        A = Bitmap.Config.ARGB_8888;
    }

    public OCircleImageView(Context r7, AttributeSet r8) {
        super(r7, r8, 0);
        this.b = new RectF();
        this.c = new RectF();
        this.e = new Matrix();
        Paint r1 = new Paint();
        this.f = r1;
        Paint r2 = new Paint();
        this.i = r2;
        Paint r3 = new Paint();
        this.j = r3;
        this.k = ViewCompat.MEASURED_STATE_MASK;
        this.l = 0;
        this.m = 0;
        this.n = 255;
        TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.i, 0, 0);
        this.l = r9.getDimensionPixelSize(2, 0);
        this.k = r9.getColor(0, ViewCompat.MEASURED_STATE_MASK);
        this.w = r9.getBoolean(1, false);
        this.m = r9.getColor(3, 0);
        r9.recycle();
        this.t = true;
        super.setScaleType(z);
        r1.setAntiAlias(true);
        r1.setDither(true);
        r1.setFilterBitmap(true);
        r1.setAlpha(this.n);
        r1.setColorFilter(this.s);
        r2.setStyle(Paint.Style.STROKE);
        r2.setAntiAlias(true);
        r2.setColor(this.k);
        r2.setStrokeWidth(this.l);
        r3.setStyle(Paint.Style.FILL);
        r3.setAntiAlias(true);
        r3.setColor(this.m);
        setOutlineProvider(new OutlineProvider(this));
    }

    public final void g() {
        Drawable r0 = getDrawable();
        if (r0 != null) goto L6;
    L4:
        Bitmap r1 = null;
    L19:
        this.o = r1;
        if (r1 != null) goto L22;
    L24:
        this.p = null;
    L26:
        if (this.t == true) goto L29;
        return;
    L29:
        if (this.o == null) goto L31;
        i();
        return;
    L31:
        this.f.setShader(null);
        return;
    L22:
        if (r1.isMutable() == false) goto L24;
        this.p = new Canvas(this.o);
        goto L26
    L6:
        if ((r0 instanceof BitmapDrawable) == false) goto L33;
        r1 = ((BitmapDrawable) r0).getBitmap();
        goto L19
    L33:
        boolean r2 = r0 instanceof ColorDrawable;     // Catch: Exception -> L13
        Bitmap.Config r3 = A;
        if (r2 == true) goto L12;
        Bitmap r4 = Bitmap.createBitmap(r0.getIntrinsicWidth(), r0.getIntrinsicHeight(), r3);     // Catch: Exception -> L13
    L16:
        Canvas r5 = new Canvas(r4);     // Catch: Exception -> L13
        r0.setBounds(0, 0, r5.getWidth(), r5.getHeight());     // Catch: Exception -> L13
        r0.draw(r5);     // Catch: Exception -> L13
        r1 = r4;
        goto L19
    L12:
        r4 = Bitmap.createBitmap(2, 2, r3);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L4
    }

    public int getBorderColor() {
        return this.k;
    }

    public int getBorderWidth() {
        return this.l;
    }

    public int getCircleBackgroundColor() {
        return this.m;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.s;
    }

    @Override // android.widget.ImageView
    public int getImageAlpha() {
        return this.n;
    }

    public final void h() {
        RectF r0 = this.c;
        int r1 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r3 = Math.min(r1, r2);
        float r4 = ((r1 - r3) / 2.0f) + getPaddingLeft();
        float r5 = ((r2 - r3) / 2.0f) + getPaddingTop();
        float r6 = r3;
        r0.set(new RectF(r4, r5, r4 + r6, r6 + r5));
        this.r = Math.min((r0.height() - this.l) / 2.0f, (r0.width() - this.l) / 2.0f);
        RectF r7 = this.b;
        int r8 = getWidth() - (this.y * 2);
        int r9 = getHeight() - (this.y * 2);
        int r10 = Math.min(r9, r8);
        float r11 = this.y;
        float r12 = ((r8 - r10) / 2.0f) + r11;
        float r13 = ((r9 - r10) / 2.0f) + r11;
        float r14 = r10;
        r7.set(new RectF(r12, r13, r12 + r14, r14 + r13));
        if (this.w == true) goto L7;
        int r15 = this.l;
        if (r15 <= 0) goto L7;
        r7.inset(r15 - 1.0f, r15 - 1.0f);
    L7:
        this.q = Math.min(r7.height() / 2.0f, r7.width() / 2.0f);
        i();
    }

    public final void i() {
        if (this.o != null) goto L5;
        return;
    L5:
        Matrix r0 = this.e;
        r0.set(null);
        int r1 = this.o.getHeight();
        float r2 = this.o.getWidth();
        RectF r3 = this.b;
        float r4 = r1;
        float r5 = 0.0f;
        if ((r3.height() * r2) <= (r3.width() * r4)) goto L8;
        float r6 = r3.height() / r4;
        float r7 = (r3.width() - (r2 * r6)) * 0.5f;
        float r8 = 0.0f;
        r5 = r7;
    L9:
        r0.setScale(r6, r6);
        r0.postTranslate(((int) (r5 + 0.5f)) + r3.left, ((int) (r8 + 0.5f)) + r3.top);
        this.u = true;
        return;
    L8:
        r6 = r3.width() / r2;
        r8 = (r3.height() - (r4 * r6)) * 0.5f;
        goto L9
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r1) {
        this.v = true;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r6) {
        if (this.x == false) goto L6;
        super.onDraw(r6);
        return;
    L6:
        int r0 = this.m;
        RectF r1 = this.c;
        if (r0 == 0) goto L10;
        r6.drawCircle(r1.centerX(), r1.centerY(), this.r, this.j);
    L10:
        if (this.o == null) goto L21;
        if (this.v == true) goto L14;
    L16:
        boolean r2 = this.u;
        Paint r3 = this.f;
        if (r2 == false) goto L19;
        this.u = false;
        Bitmap r4 = this.o;
        Shader.TileMode r5 = Shader.TileMode.CLAMP;
        BitmapShader r7 = new BitmapShader(r4, r5, r5);
        r7.setLocalMatrix(this.e);
        r3.setShader(r7);
    L19:
        RectF r8 = this.b;
        r6.drawCircle(r8.centerX(), r8.centerY(), this.q, r3);
        goto L21
    L14:
        if (this.p == null) goto L16;
        this.v = false;
        Drawable r9 = getDrawable();
        r9.setBounds(0, 0, this.p.getWidth(), this.p.getHeight());
        r9.draw(this.p);
    L21:
        if (this.l <= 0) goto L24;
        r6.drawCircle(r1.centerX(), r1.centerY(), this.r, this.i);
        return;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        h();
        invalidate();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        if (this.x == true) goto L5;
        float r0 = r8.getX();
        float r1 = r8.getY();
        RectF r2 = this.c;
        if (r2.isEmpty() == true) goto L12;
        if ((Math.pow(r1 - r2.centerY(), 2.0d) + Math.pow(r0 - r2.centerX(), 2.0d)) <= Math.pow(this.r, 2.0d)) goto L12;
    L14:
        return false;
    L12:
        if (super.onTouchEvent(r8) == false) goto L14;
        return true;
    L5:
        return super.onTouchEvent(r8);
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean r1) {
        if (r1 == true) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("adjustViewBounds not supported.");
    }

    public void setBorderColor(@ColorInt int r2) {
        if (r2 != this.k) goto L5;
        return;
    L5:
        this.k = r2;
        this.i.setColor(r2);
        invalidate();
    }

    public void setBorderOverlay(boolean r2) {
        if (r2 != this.w) goto L5;
        return;
    L5:
        this.w = r2;
        h();
        invalidate();
    }

    public void setBorderWidth(int r2) {
        if (r2 != this.l) goto L5;
        return;
    L5:
        this.l = r2;
        this.i.setStrokeWidth(r2);
        h();
        invalidate();
    }

    public void setCircleBackgroundColor(@ColorInt int r2) {
        if (r2 != this.m) goto L5;
        return;
    L5:
        this.m = r2;
        this.j.setColor(r2);
        invalidate();
    }

    @Deprecated
    public void setCircleBackgroundColorResource(@ColorRes int r2) {
        setCircleBackgroundColor(getContext().getResources().getColor(r2));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter r2) {
        if (r2 != this.s) goto L5;
        return;
    L5:
        this.s = r2;
        if (this.t == false) goto L9;
        this.f.setColorFilter(r2);
        invalidate();
        return;
    }

    public void setContentPadding(int r1) {
        this.y = r1;
        h();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean r2) {
        if (r2 != this.x) goto L5;
        return;
    L5:
        this.x = r2;
        if (r2 == false) goto L8;
        this.o = null;
        this.p = null;
        this.f.setShader(null);
    L9:
        invalidate();
        return;
    L8:
        g();
        goto L9
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int r2) {
        int r3 = r2 & 255;
        if (r3 != this.n) goto L5;
        return;
    L5:
        this.n = r3;
        if (this.t == false) goto L9;
        this.f.setAlpha(r3);
        invalidate();
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r1) {
        super.setImageBitmap(r1);
        g();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r1) {
        super.setImageDrawable(r1);
        g();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int r1) {
        super.setImageResource(r1);
        g();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri r1) {
        super.setImageURI(r1);
        g();
        invalidate();
    }

    @Override // android.view.View
    public final void setPadding(int r1, int r2, int r3, int r4) {
        super.setPadding(r1, r2, r3, r4);
        h();
        invalidate();
    }

    @Override // android.view.View
    public final void setPaddingRelative(int r1, int r2, int r3, int r4) {
        super.setPaddingRelative(r1, r2, r3, r4);
        h();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r3) {
        if (r3 != z) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("ScaleType " + r3 + " not supported.");
    }
}
