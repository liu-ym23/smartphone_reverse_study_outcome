package com.obric.oui.progress;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
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
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewKt;
import com.obric.common.oui.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class ODownloadProgressView extends View {
    public int b;
    public int c;
    public Paint e;
    public int f;
    public int i;
    public int j;
    public int k;
    public int l;
    public final ValueAnimator m;
    public int n;
    public int o;
    public int p;
    public Drawable q;
    public Drawable r;
    public Drawable s;
    public Drawable t;
    public Drawable u;
    public Drawable v;
    public Drawable w;
    public final Path x;
    public final ValueAnimator y;

    /* JADX INFO: renamed from: com.obric.oui.progress.ODownloadProgressView$2, reason: invalid class name */
    class AnonymousClass2 implements ValueAnimator.AnimatorUpdateListener {
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r1) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.progress.ODownloadProgressView$3, reason: invalid class name */
    class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r1) {
            ((Integer) r1.getAnimatedValue()).intValue();
            throw null;
        }
    }

    public static class GapBitmap {
        static {
            new SparseArray(3);
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int b;
        public int c;

        /* JADX INFO: renamed from: com.obric.oui.progress.ODownloadProgressView$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r2) {
                SavedState r1 = new SavedState(r2);
                r1.b = r2.readInt();
                r1.c = r2.readInt();
                return r1;
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r1) {
                return new SavedState[r1];
            }
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.b);
            r1.writeInt(this.c);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Size {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public ODownloadProgressView(Context r6, AttributeSet r7) {
        super(r6, r7, 0, 0);
        this.b = 0;
        this.c = 0;
        this.f = 255;
        this.m = new ValueAnimator();
        this.p = 1200;
        this.x = new Path();
        new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.y = new ValueAnimator();
        TypedArray r8 = r6.obtainStyledAttributes(r7, R.styleable.k, 0, 0);
        int r1 = r8.getInt(4, 1);
        this.l = r8.getInt(1, 0);
        this.n = r8.getColor(3, ContextCompat.getColor(r6, com.bytedance.securityserver.R.color.oui_accent_6_bg));
        this.o = r8.getColor(2, ContextCompat.getColor(r6, com.bytedance.securityserver.R.color.oui_basic_line_2));
        int r3 = r8.getColor(5, ContextCompat.getColor(r6, com.bytedance.securityserver.R.color.oui_accent_6_bg));
        int r9 = r8.getColor(0, ContextCompat.getColor(r6, com.bytedance.securityserver.R.color.oui_accent_6_bg));
        r8.recycle();
        this.q = ResourcesCompat.getDrawable(getResources(), com.bytedance.securityserver.R.drawable.o_ic_progress_processing, null);
        this.r = ResourcesCompat.getDrawable(getResources(), com.bytedance.securityserver.R.drawable.o_ic_download_progress_bg, null);
        this.s = ResourcesCompat.getDrawable(getResources(), com.bytedance.securityserver.R.drawable.o_ic_arrow_down_download, null);
        this.t = ResourcesCompat.getDrawable(getResources(), com.bytedance.securityserver.R.drawable.o_ic_pause_download, null);
        this.u = ResourcesCompat.getDrawable(getResources(), com.bytedance.securityserver.R.drawable.o_ic_download_retry, null);
        if (r3 == 0) goto L5;
        setProcessingColor(r3);
    L5:
        if (r9 == 0) goto L7;
        setActionColor(r9);
    L7:
        this.v = ResourcesCompat.getDrawable(getResources(), com.bytedance.securityserver.R.drawable.o_ic_download_succeed, null);
        this.w = ResourcesCompat.getDrawable(getResources(), com.bytedance.securityserver.R.drawable.o_ic_download_failed, null);
        setSize(r1);
        d();
    }

    public static int b(float r1) {
        return (int) (r1 * Resources.getSystem().getDisplayMetrics().density);
    }

    private Drawable getCurrentStateDrawable() {
        return c(this.b);
    }

    private Drawable getLastStateDrawable() {
        return c(this.c);
    }

    public final void a() {
        ValueAnimator r0 = this.y;
        r0.removeAllUpdateListeners();
        r0.cancel();
    }

    public final Drawable c(int r2) {
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L26;
        if (r2 == 2) goto L25;
        if (r2 == 3) goto L24;
        if (r2 == 4) goto L23;
        if (r2 == 5) goto L22;
        return null;
    L22:
        return this.w;
    L23:
        return this.v;
    L24:
        return this.u;
    L25:
        return this.t;
    L26:
        return this.s;
    L20:
        return this.q;
    }

    public final void d() {
        if (this.b == 0) goto L6;
        a();
        return;
    L6:
        ViewKt.doOnPreDraw(this, new AnonymousClass1(this));
    }

    public int getCurrentState() {
        return this.b;
    }

    public Drawable getDownloadDrawable() {
        return this.s;
    }

    public Drawable getFailedDrawable() {
        return this.w;
    }

    public int getLastState() {
        return this.c;
    }

    public Drawable getPauseDrawable() {
        return this.t;
    }

    public Drawable getProcessingDrawable() {
        return this.q;
    }

    public int getProgress() {
        return this.l;
    }

    public Drawable getProgressBgDrawable() {
        return this.r;
    }

    public Drawable getRetryDrawable() {
        return this.u;
    }

    public Drawable getSucceedDrawable() {
        return this.v;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        this.f = 255;
        ValueAnimator r0 = this.m;
        r0.removeAllUpdateListeners();
        r0.cancel();
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r13) {
        super.onDraw(r13);
        if (this.e != null) goto L5;
        this.e = new Paint();
    L5:
        this.e.reset();
        this.e.setAntiAlias(true);
        int r0 = this.i / 2;
        r13.save();
        Drawable r1 = getLastStateDrawable();
        if (r1 != null) goto L8;
    L17:
        Drawable r2 = getCurrentStateDrawable();
        if (r2 == null) goto L39;
        int r5 = this.b;
        if (r5 == 0) goto L25;
        if (r5 == 4) goto L25;
        if (r5 == 5) goto L25;
        int r4 = this.i;
        int r6 = this.k;
        int r7 = (r4 - r6) / 2;
        int r8 = (r4 + r6) / 2;
        r2.setBounds(r7, r7, r8, r8);
    L27:
        if (this.b != 0) goto L33;
        ValueAnimator r9 = this.y;
        if (r9.isRunning() == false) goto L33;
        if (r9.getAnimatedValue() == null) goto L33;
        r13.save();
        Drawable r10 = this.r;
        r10.setBounds(r2.getBounds());
        r10.setColorFilter(this.o, PorterDuff.Mode.SRC_IN);
        r10.draw(r13);
        r13.restore();
        float r3 = r0;
        r13.rotate(((Float) r9.getAnimatedValue()).floatValue(), r3, r3);
    L33:
        r2.setAlpha(this.f);
        r2.draw(r13);
        int r11 = this.b;
        if (r11 == 0) goto L37;
        if (r11 == 4) goto L37;
        if (r11 != 5) goto L39;
    L37:
        invalidate();
        return;
    L25:
        int r12 = this.i;
        r2.setBounds(0, 0, r12, r12);
    L39:
        r13.restore();
        ValueAnimator r14 = this.m;
        if (r14.isRunning() == true) goto L42;
    L45:
        float r15 = this.l;
    L44:
        float r16 = (r15 * 360.0f) / 100.0f;
        r13.save();
        if (r16 < 360.0f) goto L49;
        this.r.setColorFilter(this.n, PorterDuff.Mode.SRC_IN);
        this.r.draw(r13);
    L50:
        r13.restore();
        return;
    L49:
        Drawable r17 = this.r;
        int r18 = this.o;
        PorterDuff.Mode r19 = PorterDuff.Mode.SRC_IN;
        r17.setColorFilter(r18, r19);
        this.r.draw(r13);
        Path r20 = this.x;
        r20.reset();
        r20.moveTo(getWidth() / 2.0f, getHeight() / 2.0f);
        r20.arcTo(0.0f, 0.0f, getWidth(), getHeight(), -90.0f, r16, false);
        r13.save();
        r13.clipPath(r20);
        this.r.setColorFilter(this.n, r19);
        this.r.draw(r13);
        r13.restore();
        goto L50
    L42:
        if (r14.getAnimatedValue() == null) goto L45;
        r15 = ((Float) r14.getAnimatedValue()).floatValue();
        goto L44
    L8:
        if (this.f == 255) goto L17;
        int r21 = this.c;
        if (r21 == 0) goto L15;
        if (r21 == 4) goto L15;
        if (r21 == 5) goto L15;
        int r22 = Math.min(r1.getIntrinsicWidth(), this.k);
        int r23 = Math.min(r1.getIntrinsicHeight(), this.k);
        int r24 = this.i;
        r1.setBounds((r24 - r22) / 2, (r24 - r23) / 2, (r22 + r24) / 2, (r24 + r23) / 2);
    L16:
        r1.setAlpha(255 - this.f);
        r1.draw(r13);
    L15:
        int r25 = this.i;
        r1.setBounds(0, 0, r25, r25);
        goto L16
    }

    @Override // android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.view.View
    public final void onMeasure(int r2, int r3) {
        int r4 = View.MeasureSpec.getMode(r2);
        int r5 = View.MeasureSpec.getSize(r2);
        if (r4 == Integer.MIN_VALUE) goto L7;
        if (r5 <= 0) goto L7;
        this.i = r5;
    L8:
        int r6 = this.i;
        setMeasuredDimension(r6, r6);
        return;
    L7:
        this.i = this.j;
        goto L8
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r2) {
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        setCurrentState(r3.c);
        setProgress(r3.b);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.b = this.l;
        r1.c = this.b;
        return r1;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r1, int r2) {
        super.onVisibilityChanged(r1, r2);
        if (r2 != 0) goto L5;
        d();
        return;
    L5:
        a();
    }

    public void setActionColor(int r2) {
        this.s = this.s.mutate();
        this.t = this.t.mutate();
        this.u = this.u.mutate();
        DrawableCompat.setTint(this.s, r2);
        DrawableCompat.setTint(this.t, r2);
        DrawableCompat.setTint(this.u, r2);
    }

    public void setAlphaAnimationDuration(long r1) {
    }

    public void setCurrentState(int r2) {
        int r0 = this.b;
        if (r0 != r2) goto L5;
        return;
    L5:
        this.c = r0;
        this.b = r2;
        invalidate();
        d();
    }

    public void setDownloadDrawable(Drawable r1) {
        this.s = r1;
    }

    public void setFailedDrawable(Drawable r1) {
        this.w = r1;
    }

    public void setPauseDrawable(Drawable r1) {
        this.t = r1;
    }

    @Override // android.view.View
    public void setPressed(boolean r1) {
        super.setPressed(r1);
        invalidate();
    }

    public void setProcessingColor(int r2) {
        Drawable r0 = this.q.mutate();
        this.q = r0;
        DrawableCompat.setTint(r0, r2);
    }

    public void setProcessingDrawable(Drawable r1) {
        this.q = r1;
    }

    public void setProcessingDuration(int r1) {
        this.p = r1;
    }

    public void setProgress(int r2) {
        if (this.l == r2) goto L7;
        this.m.cancel();
        this.l = Math.max(Math.min(r2, 100), 0);
        invalidate();
        return;
    }

    public void setProgressBackgroundColor(int r1) {
        this.o = r1;
    }

    public void setProgressBgDrawable(Drawable r1) {
        this.r = r1;
    }

    public void setProgressColor(int r1) {
        this.n = r1;
    }

    public void setProgressDuration(int r1) {
    }

    public void setRetryDrawable(Drawable r1) {
        this.u = r1;
    }

    public void setSize(int r3) {
        if (r3 != 0) goto L5;
        this.j = b(48.0f);
        this.k = b(24.0f);
    L9:
        Drawable r4 = this.r;
        int r0 = this.j;
        r4.setBounds(0, 0, r0, r0);
        invalidate();
        return;
    L5:
        if (r3 == 2) goto L7;
        this.j = b(36.0f);
        this.k = b(16.0f);
        goto L9
    L7:
        this.j = b(24.0f);
        this.k = b(12.0f);
        goto L9
    }

    public void setSucceedDrawable(Drawable r1) {
        this.v = r1;
    }
}
