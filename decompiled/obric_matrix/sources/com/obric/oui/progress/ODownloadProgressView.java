package com.obric.oui.progress;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt;
import com.obric.common.oui.e;
import com.obric.common.oui.k;
import kotlin.f0;
import kotlin.n0.c.l;

/* JADX INFO: loaded from: classes2.dex */
public class ODownloadProgressView extends View {
    private final Path A;
    private final PorterDuffXfermode B;
    private final ValueAnimator C;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Paint f11298h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11299i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ValueAnimator f11300j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f11301k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f11302l;
    private int m;
    private int n;
    private final ValueAnimator o;
    private final int p;
    private int q;
    private int r;
    private int s;
    private Drawable t;
    private Drawable u;
    private Drawable v;
    private Drawable w;
    private Drawable x;
    private Drawable y;
    private Drawable z;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f11303f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f11304g;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            public SavedState a(Parcel r2) {
                return new SavedState(r2, null);
            }

            public SavedState[] b(int r1) {
                return new SavedState[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ SavedState createFromParcel(Parcel r1) {
                return a(r1);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ SavedState[] newArray(int r1) {
                return b(r1);
            }
        }

        static {
            CREATOR = new a();
        }

        private SavedState(Parcel r2) {
            super(r2);
            this.f11303f = r2.readInt();
            this.f11304g = r2.readInt();
        }

        /* synthetic */ SavedState(Parcel r1, a r2) {
            this(r1);
        }

        SavedState(Parcelable r1) {
            super(r1);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.f11303f);
            r1.writeInt(this.f11304g);
        }
    }

    class a implements l<View, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ODownloadProgressView f11305f;

        /* JADX INFO: renamed from: com.obric.oui.progress.ODownloadProgressView$a$a, reason: collision with other inner class name */
        class C0297a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f11306a;

            C0297a(a r1) {
                this.f11306a = r1;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator r1) {
                this.f11306a.f11305f.invalidate();
            }
        }

        a(ODownloadProgressView r1) {
            this.f11305f = r1;
        }

        public f0 a(View r3) {
            if (ODownloadProgressView.a(this.f11305f) == 0) goto L5;
        L14:
            ODownloadProgressView.b(this.f11305f);
        L13:
            return f0.f18324a;
        L5:
            if (this.f11305f.isShown() == false) goto L14;
            if (ODownloadProgressView.c(this.f11305f).isRunning() == true) goto L10;
            ODownloadProgressView.b(this.f11305f);
            ODownloadProgressView.c(this.f11305f).setInterpolator(new LinearInterpolator());
            ODownloadProgressView.c(this.f11305f).setDuration(ODownloadProgressView.d(this.f11305f));
            ODownloadProgressView.c(this.f11305f).setFloatValues(new float[]{0.0f, 360.0f});
            ODownloadProgressView.c(this.f11305f).addUpdateListener(new C0297a(this));
            ODownloadProgressView.c(this.f11305f).setRepeatCount(-1);
            ODownloadProgressView.c(this.f11305f).start();
            goto L13
        L10:
            return f0.f18324a;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(View r1) {
            return a(r1);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ODownloadProgressView f11307a;

        b(ODownloadProgressView r1) {
            this.f11307a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r1) {
            this.f11307a.invalidate();
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final SparseArray<Bitmap> f11308a = null;

        static {
            f11308a = new SparseArray(3);
        }

        public static Bitmap a(Context r3, int r4) {
            SparseArray<Bitmap> r0 = f11308a;
            Bitmap r1 = r0.get(r4);
            if (r1 == null) goto L5;
            return r1;
        L5:
            Drawable r5 = ResourcesCompat.getDrawable(r3.getResources(), e.q, null);
            if (r5 != null) goto L8;
            return null;
        L8:
            r5.setBounds(0, 0, r4, r4);
            Bitmap r2 = Bitmap.createBitmap(r4, r4, Bitmap.Config.ARGB_8888);
            r5.draw(new Canvas(r2));
            r0.put(r4, r2);
            return r2;
        }
    }

    public ODownloadProgressView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ODownloadProgressView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public ODownloadProgressView(Context r4, AttributeSet r5, int r6, int r7) {
        super(r4, r5, r6, r7);
        this.f11296f = 0;
        this.f11297g = 0;
        this.f11299i = 255;
        this.o = new ValueAnimator();
        this.r = 1200;
        this.s = 2000;
        this.A = new Path();
        this.B = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.C = new ValueAnimator();
        TypedArray r8 = r4.obtainStyledAttributes(r5, k.R, r6, r7);
        int r9 = r8.getInt(k.X, 1);
        this.n = r8.getInt(k.V, 0);
        this.p = r8.getColor(k.W, ContextCompat.getColor(r4, com.obric.common.oui.c.y));
        r8.getColor(k.U, ContextCompat.getColor(r4, com.obric.common.oui.c.P));
        this.q = r8.getColor(k.S, ContextCompat.getColor(r4, com.obric.common.oui.c.K));
        int r10 = r8.getColor(k.T, 0);
        r8.recycle();
        this.t = ResourcesCompat.getDrawable(getResources(), e.u, null);
        this.u = ResourcesCompat.getDrawable(getResources(), e.p, null);
        this.v = ResourcesCompat.getDrawable(getResources(), e.n, null);
        this.w = ResourcesCompat.getDrawable(getResources(), e.t, null);
        this.x = ResourcesCompat.getDrawable(getResources(), e.r, null);
        if (r10 == 0) goto L5;
        this.v = this.v.mutate();
        this.w = this.w.mutate();
        this.x = this.x.mutate();
        DrawableCompat.setTint(this.v, r10);
        DrawableCompat.setTint(this.w, r10);
        DrawableCompat.setTint(this.x, r10);
    L5:
        this.y = ResourcesCompat.getDrawable(getResources(), e.s, null);
        this.z = ResourcesCompat.getDrawable(getResources(), e.o, null);
        setSize(r9);
        m();
    }

    static /* synthetic */ int a(ODownloadProgressView r0) {
        return r0.f11296f;
    }

    static /* synthetic */ void b(ODownloadProgressView r0) {
        r0.f();
    }

    static /* synthetic */ ValueAnimator c(ODownloadProgressView r0) {
        return r0.C;
    }

    static /* synthetic */ int d(ODownloadProgressView r0) {
        return r0.r;
    }

    private void e() {
        if (j() == false) goto L5;
        this.f11300j.cancel();
    L5:
        this.f11299i = 255;
    }

    private void f() {
        this.C.removeAllUpdateListeners();
        this.C.cancel();
    }

    private void g() {
        this.o.removeAllUpdateListeners();
        this.o.cancel();
    }

    private Drawable getCurrentStateDrawable() {
        return i(this.f11296f);
    }

    private Drawable getLastStateDrawable() {
        return i(this.f11297g);
    }

    private int h(float r1) {
        return (int) (r1 * Resources.getSystem().getDisplayMetrics().density);
    }

    private Drawable i(int r2) {
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L26;
        if (r2 == 2) goto L25;
        if (r2 == 3) goto L24;
        if (r2 == 4) goto L23;
        if (r2 == 5) goto L22;
        return null;
    L22:
        return this.z;
    L23:
        return this.y;
    L24:
        return this.x;
    L25:
        return this.w;
    L26:
        return this.v;
    L20:
        return this.t;
    }

    private boolean j() {
        ValueAnimator r0 = this.f11300j;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isRunning() == false) goto L7;
        return true;
    }

    private boolean k(int r1) {
        if (r1 != 0) goto L4;
    L9:
        return true;
    L4:
        if (r1 == 4) goto L9;
        if (r1 == 5) goto L9;
        return false;
    }

    private void m() {
        if (this.f11296f == 0) goto L6;
        f();
        return;
    L6:
        ViewKt.doOnPreDraw(this, new a(this));
    }

    public int getCurrentState() {
        return this.f11296f;
    }

    public Drawable getDownloadDrawable() {
        return this.v;
    }

    public Drawable getFailedDrawable() {
        return this.z;
    }

    public int getLastState() {
        return this.f11297g;
    }

    public Drawable getPauseDrawable() {
        return this.w;
    }

    public Drawable getProcessingDrawable() {
        return this.t;
    }

    public int getProgress() {
        return this.n;
    }

    public Drawable getProgressBgDrawable() {
        return this.u;
    }

    public Drawable getRetryDrawable() {
        return this.x;
    }

    public Drawable getSucceedDrawable() {
        return this.y;
    }

    public void l(int r7, boolean r8) {
        if (this.n != r7) goto L5;
        return;
    L5:
        this.o.cancel();
        int r0 = this.n;
        int r9 = Math.max(Math.min(r7, 100), 0);
        this.n = r9;
        if (r0 > r9) goto L11;
        if (r8 == false) goto L11;
        this.o.setInterpolator(new LinearInterpolator());
        this.o.setDuration((((long) Math.abs(this.n - r0)) * ((long) this.s)) / 100);
        this.o.setFloatValues(new float[]{r0, this.n});
        this.o.addUpdateListener(new b(this));
        this.o.start();
        return;
    L11:
        invalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        e();
        g();
        f();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas r12) {
        super.onDraw(r12);
        if (this.f11298h != null) goto L5;
        this.f11298h = new Paint();
    L5:
        this.f11298h.reset();
        this.f11298h.setAntiAlias(true);
        int r0 = this.f11301k;
        int r1 = r0 / 2;
        int r2 = r0 / 2;
        Drawable r3 = getLastStateDrawable();
        if (r3 != null) goto L8;
    L14:
        Drawable r4 = getCurrentStateDrawable();
        if (r4 == null) goto L32;
        if (k(this.f11296f) == false) goto L19;
        int r5 = this.f11301k;
        r4.setBounds(0, 0, r5, r5);
    L21:
        if (this.f11296f == 0) goto L23;
    L27:
        r4.setAlpha(this.f11299i);
        r4.draw(r12);
        if (k(this.f11296f) == false) goto L32;
        invalidate();
        return;
    L23:
        if (this.C.isRunning() == false) goto L27;
        if (this.C.getAnimatedValue() == null) goto L27;
        r12.rotate(((Float) this.C.getAnimatedValue()).floatValue(), r1, r2);
        goto L27
    L19:
        int r6 = this.f11301k;
        int r7 = this.m;
        r4.setBounds((r6 - r7) / 2, (r6 - r7) / 2, (r6 + r7) / 2, (r6 + r7) / 2);
    L32:
        if (this.o.isRunning() == true) goto L34;
    L36:
        float r8 = this.n;
    L37:
        float r9 = (r8 * 360.0f) / 100.0f;
        r12.saveLayer(null, null, 31);
        if (r9 < 360.0f) goto L40;
        this.u.setColorFilter(this.p, PorterDuff.Mode.SRC_IN);
        this.u.draw(r12);
    L41:
        Bitmap r10 = c.a(getContext(), this.f11302l);
        if (r10 == null) goto L46;
        this.f11298h.setXfermode(this.B);
        this.f11298h.setColor(ViewCompat.MEASURED_STATE_MASK);
        r12.drawBitmap(r10, 0.0f, 0.0f, this.f11298h);
        if (r9 >= 360.0f) goto L46;
        r12.rotate(r9, getWidth() / 2.0f, getHeight() / 2.0f);
        r12.drawBitmap(r10, 0.0f, 0.0f, this.f11298h);
    L46:
        r12.restore();
        return;
    L40:
        this.u.setColorFilter(this.q, PorterDuff.Mode.SRC_IN);
        this.u.draw(r12);
        this.A.reset();
        this.A.moveTo(getWidth() / 2.0f, getHeight() / 2.0f);
        this.A.arcTo(0.0f, 0.0f, getWidth(), getHeight(), -90.0f, r9, false);
        r12.save();
        r12.clipPath(this.A);
        this.u.setColorFilter(this.p, PorterDuff.Mode.SRC_IN);
        this.u.draw(r12);
        r12.restore();
        goto L41
    L34:
        if (this.o.getAnimatedValue() == null) goto L36;
        r8 = ((Float) this.o.getAnimatedValue()).floatValue();
        goto L37
    L8:
        if (this.f11299i == 255) goto L14;
        if (k(this.f11297g) == false) goto L12;
        int r11 = this.f11301k;
        r3.setBounds(0, 0, r11, r11);
    L13:
        r3.setAlpha(255 - this.f11299i);
        r3.draw(r12);
        goto L14
    L12:
        int r13 = Math.min(r3.getIntrinsicWidth(), this.m);
        int r14 = Math.min(r3.getIntrinsicHeight(), this.m);
        int r15 = this.f11301k;
        r3.setBounds((r15 - r13) / 2, (r15 - r14) / 2, (r13 + r15) / 2, (r15 + r14) / 2);
        goto L13
    }

    @Override // android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.view.View
    protected void onMeasure(int r2, int r3) {
        int r4 = View.MeasureSpec.getMode(r2);
        int r5 = View.MeasureSpec.getSize(r2);
        if (r4 == Integer.MIN_VALUE) goto L5;
        if (r5 <= 0) goto L5;
    L6:
        this.f11301k = r5;
        int r6 = this.f11301k;
        setMeasuredDimension(r6, r6);
        return;
    L5:
        r5 = this.f11302l;
        goto L6
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r2) {
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        setCurrentState(r3.f11304g);
        setProgress(r3.f11303f);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.f11303f = this.n;
        r1.f11304g = this.f11296f;
        return r1;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View r1, int r2) {
        super.onVisibilityChanged(r1, r2);
        if (r2 != 0) goto L5;
        m();
        return;
    L5:
        f();
    }

    public void setAlphaAnimationDuration(long r1) {
    }

    public void setCurrentState(int r2) {
        int r0 = this.f11296f;
        if (r0 != r2) goto L5;
        return;
    L5:
        this.f11297g = r0;
        this.f11296f = r2;
        invalidate();
        m();
    }

    public void setDownloadDrawable(Drawable r1) {
        this.v = r1;
    }

    public void setFailedDrawable(Drawable r1) {
        this.z = r1;
    }

    public void setPauseDrawable(Drawable r1) {
        this.w = r1;
    }

    @Override // android.view.View
    public void setPressed(boolean r1) {
        super.setPressed(r1);
        invalidate();
    }

    public void setProcessingDrawable(Drawable r1) {
        this.t = r1;
    }

    public void setProcessingDuration(int r1) {
        this.r = r1;
    }

    public void setProgress(int r2) {
        l(r2, false);
    }

    public void setProgressBgDrawable(Drawable r1) {
        this.u = r1;
    }

    public void setProgressDuration(int r1) {
        this.s = r1;
    }

    public void setRetryDrawable(Drawable r1) {
        this.x = r1;
    }

    public void setSize(int r4) {
        if (r4 != 0) goto L5;
        this.f11302l = h(48.0f);
        h(20.0f);
        h(16.0f);
        int r5 = h(24.0f);
    L9:
        this.m = r5;
        Drawable r6 = this.u;
        int r0 = this.f11302l;
        r6.setBounds(0, 0, r0, r0);
        invalidate();
        return;
    L5:
        if (r4 == 2) goto L7;
        this.f11302l = h(36.0f);
        h(15.0f);
        h(12.0f);
        r5 = h(18.0f);
        goto L9
    L7:
        this.f11302l = h(24.0f);
        h(10.0f);
        h(8.0f);
        r5 = h(12.0f);
        goto L9
    }

    public void setSucceedDrawable(Drawable r1) {
        this.y = r1;
    }
}
