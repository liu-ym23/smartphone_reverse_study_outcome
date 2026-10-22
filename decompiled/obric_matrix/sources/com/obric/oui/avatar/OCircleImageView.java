package com.obric.oui.avatar;

import android.annotation.SuppressLint;
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
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.obric.common.oui.k;

/* JADX INFO: loaded from: classes2.dex */
public class OCircleImageView extends AppCompatImageView {
    private static final ImageView.ScaleType A = null;
    private static final Bitmap.Config B = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RectF f10757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final RectF f10758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Matrix f10759h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Paint f10760i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Paint f10761j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Paint f10762k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f10763l;
    private int m;
    private int n;
    private int o;
    private Bitmap p;
    private Canvas q;
    private float r;
    private float s;
    private ColorFilter t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private int z;

    static /* synthetic */ class a {
    }

    @RequiresApi(api = 21)
    private class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OCircleImageView f10764a;

        private b(OCircleImageView r1) {
            this.f10764a = r1;
        }

        /* synthetic */ b(OCircleImageView r1, a r2) {
            this(r1);
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r2, Outline r3) {
            if (OCircleImageView.f(this.f10764a) == false) goto L5;
            ViewOutlineProvider.BACKGROUND.getOutline(r2, r3);
            return;
        L5:
            Rect r4 = new Rect();
            OCircleImageView.g(this.f10764a).roundOut(r4);
            r3.setRoundRect(r4, r4.width() / 2.0f);
        }
    }

    static {
        A = ImageView.ScaleType.CENTER_CROP;
        B = Bitmap.Config.ARGB_8888;
    }

    public OCircleImageView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public OCircleImageView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        this.f10757f = new RectF();
        this.f10758g = new RectF();
        this.f10759h = new Matrix();
        this.f10760i = new Paint();
        this.f10761j = new Paint();
        this.f10762k = new Paint();
        this.f10763l = ViewCompat.MEASURED_STATE_MASK;
        this.m = 0;
        this.n = 0;
        this.o = 255;
        TypedArray r7 = r4.obtainStyledAttributes(r5, k.K, r6, 0);
        this.m = r7.getDimensionPixelSize(k.N, 0);
        this.f10763l = r7.getColor(k.L, ViewCompat.MEASURED_STATE_MASK);
        this.x = r7.getBoolean(k.M, false);
        this.n = r7.getColor(k.O, 0);
        r7.recycle();
        l();
    }

    static /* synthetic */ boolean f(OCircleImageView r0) {
        return r0.y;
    }

    static /* synthetic */ RectF g(OCircleImageView r0) {
        return r0.f10758g;
    }

    private RectF h() {
        int r0 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r1 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r2 = Math.min(r0, r1);
        float r3 = getPaddingLeft() + ((r0 - r2) / 2.0f);
        float r5 = getPaddingTop() + ((r1 - r2) / 2.0f);
        float r4 = r2;
        return new RectF(r3, r5, r3 + r4, r4 + r5);
    }

    private RectF i() {
        int r0 = getWidth() - (this.z * 2);
        int r1 = getHeight() - (this.z * 2);
        int r2 = Math.min(r1, r0);
        int r5 = this.z;
        float r3 = r5 + ((r0 - r2) / 2.0f);
        float r6 = r5 + ((r1 - r2) / 2.0f);
        float r4 = r2;
        return new RectF(r3, r6, r3 + r4, r4 + r6);
    }

    private Bitmap j(Drawable r6) {
        if (r6 != null) goto L6;
        return null;
    L6:
        if ((r6 instanceof BitmapDrawable) == true) goto L8;
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        if ((r6 instanceof ColorDrawable) == false) goto L12;
        Bitmap r0 = Bitmap.createBitmap(2, 2, B);     // Catch: Exception -> L15
    L13:
        Canvas r1 = new Canvas(r0);     // Catch: Exception -> L15
        r6.setBounds(0, 0, r1.getWidth(), r1.getHeight());     // Catch: Exception -> L15
        r6.draw(r1);     // Catch: Exception -> L15
        return r0;
    L12:
        r0 = Bitmap.createBitmap(r6.getIntrinsicWidth(), r6.getIntrinsicHeight(), B);     // Catch: Exception -> L15
        goto L13
    L8:
        return ((BitmapDrawable) r6).getBitmap();
    }

    private boolean k(float r7, float r8) {
        if (this.f10758g.isEmpty() == false) goto L6;
        return true;
    L6:
        if ((Math.pow(r7 - this.f10758g.centerX(), 2.0d) + Math.pow(r8 - this.f10758g.centerY(), 2.0d)) <= Math.pow(this.s, 2.0d)) goto L10;
        return false;
    L10:
        return true;
    }

    private void l() {
        this.u = true;
        super.setScaleType(A);
        this.f10760i.setAntiAlias(true);
        this.f10760i.setDither(true);
        this.f10760i.setFilterBitmap(true);
        this.f10760i.setAlpha(this.o);
        this.f10760i.setColorFilter(this.t);
        this.f10761j.setStyle(Paint.Style.STROKE);
        this.f10761j.setAntiAlias(true);
        this.f10761j.setColor(this.f10763l);
        this.f10761j.setStrokeWidth(this.m);
        this.f10762k.setStyle(Paint.Style.FILL);
        this.f10762k.setAntiAlias(true);
        this.f10762k.setColor(this.n);
        if (Build.VERSION.SDK_INT < 21) goto L6;
        setOutlineProvider(new b(this, null));
        return;
    }

    private void m() {
        Bitmap r0 = j(getDrawable());
        this.p = r0;
        if (r0 != null) goto L5;
    L7:
        this.q = null;
    L9:
        if (this.u == true) goto L12;
        return;
    L12:
        if (this.p == null) goto L14;
        o();
        return;
    L14:
        this.f10760i.setShader(null);
        return;
    L5:
        if (r0.isMutable() == false) goto L7;
        this.q = new Canvas(this.p);
        goto L9
    }

    private void n() {
        this.f10758g.set(h());
        this.s = Math.min((this.f10758g.height() - this.m) / 2.0f, (this.f10758g.width() - this.m) / 2.0f);
        this.f10757f.set(i());
        if (this.x == true) goto L7;
        int r0 = this.m;
        if (r0 <= 0) goto L7;
        this.f10757f.inset(r0 - 1.0f, r0 - 1.0f);
    L7:
        this.r = Math.min(this.f10757f.height() / 2.0f, this.f10757f.width() / 2.0f);
        o();
    }

    private void o() {
        if (this.p != null) goto L5;
        return;
    L5:
        this.f10759h.set(null);
        int r0 = this.p.getHeight();
        float r1 = this.p.getWidth();
        float r2 = r0;
        float r3 = 0.0f;
        if ((this.f10757f.height() * r1) <= (this.f10757f.width() * r2)) goto L8;
        float r4 = this.f10757f.height() / r2;
        float r5 = (this.f10757f.width() - (r1 * r4)) * 0.5f;
        float r6 = 0.0f;
        r3 = r5;
    L9:
        this.f10759h.setScale(r4, r4);
        Matrix r7 = this.f10759h;
        float r8 = (int) (r3 + 0.5f);
        RectF r9 = this.f10757f;
        r7.postTranslate(r8 + r9.left, ((int) (r6 + 0.5f)) + r9.top);
        this.v = true;
        return;
    L8:
        r4 = this.f10757f.width() / r1;
        r6 = (this.f10757f.height() - (r2 * r4)) * 0.5f;
        goto L9
    }

    public int getBorderColor() {
        return this.f10763l;
    }

    public int getBorderWidth() {
        return this.m;
    }

    public int getCircleBackgroundColor() {
        return this.n;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.t;
    }

    @Override // android.widget.ImageView
    public int getImageAlpha() {
        return this.o;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable r1) {
        this.w = true;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"CanvasSize"})
    protected void onDraw(Canvas r5) {
        if (this.y == false) goto L7;
        super.onDraw(r5);
        return;
    L7:
        if (this.n == 0) goto L10;
        r5.drawCircle(this.f10758g.centerX(), this.f10758g.centerY(), this.s, this.f10762k);
    L10:
        if (this.p == null) goto L21;
        if (this.w == false) goto L17;
        if (this.q == null) goto L17;
        this.w = false;
        Drawable r0 = getDrawable();
        r0.setBounds(0, 0, this.q.getWidth(), this.q.getHeight());
        r0.draw(this.q);
    L17:
        if (this.v == false) goto L19;
        this.v = false;
        Bitmap r1 = this.p;
        Shader.TileMode r2 = Shader.TileMode.CLAMP;
        BitmapShader r3 = new BitmapShader(r1, r2, r2);
        r3.setLocalMatrix(this.f10759h);
        this.f10760i.setShader(r3);
    L19:
        r5.drawCircle(this.f10757f.centerX(), this.f10757f.centerY(), this.r, this.f10760i);
    L21:
        if (this.m <= 0) goto L24;
        r5.drawCircle(this.f10758g.centerX(), this.f10758g.centerY(), this.s, this.f10761j);
        return;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        n();
        invalidate();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent r3) {
        if (this.y == false) goto L7;
        return super.onTouchEvent(r3);
    L7:
        if (k(r3.getX(), r3.getY()) == true) goto L9;
    L11:
        return false;
    L9:
        if (super.onTouchEvent(r3) == false) goto L11;
        return true;
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean r1) {
        if (r1 == true) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("adjustViewBounds not supported.");
    }

    public void setBorderColor(@ColorInt int r2) {
        if (r2 != this.f10763l) goto L5;
        return;
    L5:
        this.f10763l = r2;
        this.f10761j.setColor(r2);
        invalidate();
    }

    public void setBorderOverlay(boolean r2) {
        if (r2 != this.x) goto L5;
        return;
    L5:
        this.x = r2;
        n();
        invalidate();
    }

    public void setBorderWidth(int r2) {
        if (r2 != this.m) goto L5;
        return;
    L5:
        this.m = r2;
        this.f10761j.setStrokeWidth(r2);
        n();
        invalidate();
    }

    public void setCircleBackgroundColor(@ColorInt int r2) {
        if (r2 != this.n) goto L5;
        return;
    L5:
        this.n = r2;
        this.f10762k.setColor(r2);
        invalidate();
    }

    @Deprecated
    public void setCircleBackgroundColorResource(@ColorRes int r2) {
        setCircleBackgroundColor(getContext().getResources().getColor(r2));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter r2) {
        if (r2 != this.t) goto L5;
        return;
    L5:
        this.t = r2;
        if (this.u == false) goto L9;
        this.f10760i.setColorFilter(r2);
        invalidate();
        return;
    }

    public void setContentPadding(int r1) {
        this.z = r1;
        n();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean r2) {
        if (r2 != this.y) goto L5;
        return;
    L5:
        this.y = r2;
        if (r2 == false) goto L8;
        this.p = null;
        this.q = null;
        this.f10760i.setShader(null);
    L9:
        invalidate();
        return;
    L8:
        m();
        goto L9
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int r2) {
        int r3 = r2 & 255;
        if (r3 != this.o) goto L5;
        return;
    L5:
        this.o = r3;
        if (this.u == false) goto L9;
        this.f10760i.setAlpha(r3);
        invalidate();
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r1) {
        super.setImageBitmap(r1);
        m();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r1) {
        super.setImageDrawable(r1);
        m();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int r1) {
        super.setImageResource(r1);
        m();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri r1) {
        super.setImageURI(r1);
        m();
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int r1, int r2, int r3, int r4) {
        super.setPadding(r1, r2, r3, r4);
        n();
        invalidate();
    }

    @Override // android.view.View
    public void setPaddingRelative(int r1, int r2, int r3, int r4) {
        super.setPaddingRelative(r1, r2, r3, r4);
        n();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r3) {
        if (r3 != A) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{r3}));
    }
}
