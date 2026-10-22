package com.obric.oui.slider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001J\u0013\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u001d\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0013J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0013J\u0015\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0018¢\u0006\u0004\b!\u0010\u001bJ\u0015\u0010\"\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0018¢\u0006\u0004\b\"\u0010\u001bJ\u0015\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0002¢\u0006\u0004\b&\u0010%J\r\u0010'\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0002¢\u0006\u0004\b)\u0010(J\u0015\u0010*\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0006¢\u0006\u0004\b*\u0010\u0013J\u0015\u0010,\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u0002¢\u0006\u0004\b,\u0010%J\u0017\u0010/\u001a\u00020\u000e2\b\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100J\u0015\u00102\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u001c¢\u0006\u0004\b2\u0010\u001fJ%\u0010\u000b\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u00105J\u0015\u00107\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u001c¢\u0006\u0004\b7\u0010\u001fJ\u0015\u00109\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u001c¢\u0006\u0004\b9\u0010\u001fJ\u0015\u0010;\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u0002¢\u0006\u0004\b;\u0010%J\u0017\u0010=\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u001cH\u0016¢\u0006\u0004\b=\u0010\u001fJ\u001f\u0010@\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u0006H\u0014¢\u0006\u0004\b@\u0010AJ7\u0010G\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u0006H\u0014¢\u0006\u0004\bG\u0010HJ\r\u0010J\u001a\u00020I¢\u0006\u0004\bJ\u0010KJ\u0015\u0010L\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u001c¢\u0006\u0004\bL\u0010\u001fJ\u0017\u0010N\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020\u001cH\u0016¢\u0006\u0004\bN\u0010\u001fJ\u0017\u0010Q\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Z\u001a\u00020S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010TR\"\u0010`\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010\u0013R\"\u0010d\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010\\\u001a\u0004\bb\u0010^\"\u0004\bc\u0010\u0013R$\u0010j\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010\u001bR\u0016\u0010m\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010p\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010lR\u0016\u0010s\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010oR\u0016\u0010v\u001a\u00020t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010uR$\u0010z\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010f\u001a\u0004\bx\u0010h\"\u0004\by\u0010\u001b¨\u0006{"}, d2 = {"Lcom/obric/oui/slider/OSlider;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "j", "(F)F", "i", "", "decimals", "f", "(FI)F", "w", "h", "oldw", "oldh", "Lkotlin/f0;", "onSizeChanged", "(IIII)V", "defaultWidth", "setThumbDefaultWidth", "(I)V", "thumbColorResId", "setThumbColor", "defaultMargin", "setDefaultMargin", "Landroid/graphics/drawable/Drawable;", "imageicon", "setProcessImageIcon", "(Landroid/graphics/drawable/Drawable;)V", "", "visibility", "setProcessImageIconVisibility", "(Z)V", "drawable", "setLeftIcon", "setRightIcon", "value", "setMinValue", "(F)V", "setMaxValue", "getMinValue", "()F", "getMaxValue", "setDefaultTickMarkCount", "process", "setProgress", "Lcom/obric/oui/slider/TickMarkSeekBar$a;", "listener", "setOnSeekBarChangeListenerExt", "(Lcom/obric/oui/slider/TickMarkSeekBar$a;)V", "istyleSegmented", "setIsSegmented", "tickMarkCount", "initTickPosition", "(ZII)V", "isAlwaysLight", "setIsAlwaysLight", "isAlwaysNight", "setIsAlwaysNight", "percent", "setAdsorptionPercent", "enabled", "setEnabled", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "setAutoAdjustSeekbarMargin", "hapticFeedbackEnabled", "setHapticFeedbackEnabled", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "tvRightIcon", "Landroid/widget/TextView;", "g", "Landroid/widget/TextView;", "progressDesc", "tvIcon", "o", "I", "getLeftImageMargin", "()I", "setLeftImageMargin", "leftImageMargin", "p", "getRightImageMargin", "setRightImageMargin", "rightImageMargin", "q", "Landroid/graphics/drawable/Drawable;", "getRightImage", "()Landroid/graphics/drawable/Drawable;", "setRightImage", "rightImage", "l", "Z", "optimizeEdgeTouchExperience", "k", "F", "maxValue", "m", "isSeeking", "minValue", "Lcom/obric/oui/slider/SeekBarFloatCompat;", "Lcom/obric/oui/slider/SeekBarFloatCompat;", "seekBar", "n", "getLeftImage", "setLeftImage", "leftImage", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
@SuppressLint({"ClickableViewAccessibility"})
public class OSlider extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SeekBarFloatCompat f11391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextView f11392g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ImageView f11393h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ImageView f11394i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f11395j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f11396k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f11397l;
    private boolean m;
    private Drawable n;
    private int o;
    private int p;
    private Drawable q;

    static {
    }

    private final float f(float r3, int r4) {
        String r2 = String.format("%." + r4 + 'f', Arrays.copyOf(new Object[]{Float.valueOf(r3)}, 1));
        o.e(r2, "format(this, *args)");
        return Float.parseFloat(r2);
    }

    static /* synthetic */ float g(OSlider r0, float r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r2 = 2;
    L7:
        return r0.f(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: round");
    }

    private final float i(float r2) {
        float r0 = this.f11395j;
        return (((r2 - r0) / (this.f11396k - r0)) * 100.0f) + 0.0f;
    }

    private final float j(float r4) {
        float r0 = this.f11395j;
        return g(this, r0 + (((r4 - 0.0f) / 100.0f) * (this.f11396k - r0)), 0, 1, null);
    }

    public final Drawable getLeftImage() {
        return this.n;
    }

    public final int getLeftImageMargin() {
        return this.o;
    }

    public final float getMaxValue() {
        return j(this.f11391f.getMaxValue());
    }

    public final float getMinValue() {
        return j(this.f11391f.getMinValue());
    }

    public final Drawable getRightImage() {
        return this.q;
    }

    public final int getRightImageMargin() {
        return this.p;
    }

    public final SeekBar getSeekBar() {
        return this.f11391f;
    }

    public final void h(boolean r2, int r3, int r4) {
        this.f11391f.p(r2, r3, r4);
        if (r2 == true) goto L6;
        this.f11391f.getProgressDrawable().setLevel((int) (this.f11391f.getFloatProgress() * 100));
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 <= 0) goto L6;
        Resources r5 = Resources.getSystem();
        o.e(r5, "Resources.getSystem()");
        TypedValue.applyDimension(1, 5, r5.getDisplayMetrics());
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r8) {
        o.f(r8, NotificationCompat.CATEGORY_EVENT);
        if (this.f11397l == false) goto L5;
        Rect r0 = new Rect();
        this.f11391f.getHitRect(r0);
        int r1 = r8.getActionMasked();
        if (r1 == 0) goto L27;
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L23;
    L30:
        d.g.d.f.f.b.a("OSlider", "onTouchEvent, " + r8.getAction() + ", super.onTouchEvent, isSeeking: " + this.m);
        return super.onTouchEvent(r8);
    L15:
        if (this.m == false) goto L19;
        MotionEvent r9 = MotionEvent.obtain(r8);
        r9.offsetLocation(-this.f11391f.getLeft(), -this.f11391f.getTop());
        this.f11391f.dispatchTouchEvent(r9);
        r9.recycle();
        return true;
    L19:
        if (r0.contains((int) r8.getX(), (int) r8.getY()) == false) goto L30;
        this.m = true;
        MotionEvent r2 = MotionEvent.obtain(r8);
        o.e(r2, "downEvent");
        r2.setAction(0);
        r2.offsetLocation(-this.f11391f.getLeft(), -this.f11391f.getTop());
        this.f11391f.dispatchTouchEvent(r2);
        r2.recycle();
        MotionEvent r10 = MotionEvent.obtain(r8);
        r10.offsetLocation(-this.f11391f.getLeft(), -this.f11391f.getTop());
        this.f11391f.dispatchTouchEvent(r10);
        r10.recycle();
        d.g.d.f.f.b.a("OSlider", "onTouchEvent, ACTION_MOVE, case 3, isSeeking: " + this.m);
        return true;
    L23:
        if (this.m == false) goto L30;
        MotionEvent r3 = MotionEvent.obtain(r8);
        r3.offsetLocation(-this.f11391f.getLeft(), -this.f11391f.getTop());
        this.f11391f.dispatchTouchEvent(r3);
        r3.recycle();
        this.m = false;
        requestDisallowInterceptTouchEvent(false);
        d.g.d.f.f.b.a("OSlider", "onTouchEvent, " + r8.getAction() + ", case 4, isSeeking: " + this.m);
        return true;
    L27:
        if (r0.contains((int) r8.getX(), (int) r8.getY()) == true) goto L30;
        this.m = false;
        requestDisallowInterceptTouchEvent(true);
        d.g.d.f.f.b.a("OSlider", "onTouchEvent, ACTION_DOWN, case 1, isSeeking: " + this.m);
        return true;
    L5:
        return super.onTouchEvent(r8);
    }

    public final void setAdsorptionPercent(float r1) {
    }

    public final void setAutoAdjustSeekbarMargin(boolean r1) {
    }

    public final void setDefaultMargin(int r1) {
        this.f11391f.setDefaultMargin(r1);
    }

    public final void setDefaultTickMarkCount(int r1) {
        this.f11391f.setDefaultTickMarkCount(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        this.f11391f.setEnabled(r2);
        this.f11392g.setEnabled(r2);
        this.f11393h.setEnabled(r2);
        if (r2 == false) goto L5;
        float r3 = 1.0f;
    L6:
        setAlpha(r3);
        return;
    L5:
        r3 = 0.5f;
        goto L6
    }

    @Override // android.view.View
    public void setHapticFeedbackEnabled(boolean r1) {
        super.setHapticFeedbackEnabled(r1);
        this.f11391f.setHapticFeedbackEnabled(r1);
    }

    public final void setIsAlwaysLight(boolean r4) {
        TextView r0 = this.f11392g;
        Context r1 = getContext();
        if (r4 == false) goto L5;
        int r2 = com.obric.common.oui.c.q;
    L6:
        r0.setTextColor(ContextCompat.getColor(r1, r2));
        this.f11391f.setIsAlwaysLight(r4);
        return;
    L5:
        r2 = com.obric.common.oui.c.p;
        goto L6
    }

    public final void setIsAlwaysNight(boolean r4) {
        TextView r0 = this.f11392g;
        Context r1 = getContext();
        if (r4 == false) goto L5;
        int r2 = com.obric.common.oui.c.f8211j;
    L6:
        r0.setTextColor(ContextCompat.getColor(r1, r2));
        this.f11391f.setIsAlwaysNight(r4);
        return;
    L5:
        r2 = com.obric.common.oui.c.p;
        goto L6
    }

    public final void setIsSegmented(boolean r2) {
        h(r2, 0, 0);
    }

    public final void setLeftIcon(Drawable r2) {
        o.f(r2, "drawable");
        this.f11393h.setImageDrawable(r2);
    }

    public final void setLeftImage(Drawable r1) {
        this.n = r1;
    }

    public final void setLeftImageMargin(int r1) {
        this.o = r1;
    }

    public final void setMaxValue(float r3) {
        Log.d("OSlider", "setMaxValue >>> " + r3);
        this.f11396k = r3;
        this.f11391f.setMinValue(0.0f);
        this.f11391f.setMaxValue(100.0f);
    }

    public final void setMinValue(float r3) {
        Log.d("OSlider", "setMinValue >>> " + r3);
        this.f11395j = r3;
        this.f11391f.setMinValue(0.0f);
        this.f11391f.setMaxValue(100.0f);
    }

    public final void setOnSeekBarChangeListenerExt(TickMarkSeekBar.a r1) {
    }

    public final void setProcessImageIcon(Drawable r2) {
        o.f(r2, "imageicon");
        this.f11391f.setImageIcon(r2);
    }

    public final void setProcessImageIconVisibility(boolean r1) {
        this.f11391f.setProcessImageIconVisibility(r1);
    }

    public final void setProgress(float r2) {
        this.f11391f.setProgress(i(r2));
    }

    public final void setRightIcon(Drawable r2) {
        o.f(r2, "drawable");
        this.f11394i.setImageDrawable(r2);
    }

    public final void setRightImage(Drawable r1) {
        this.q = r1;
    }

    public final void setRightImageMargin(int r1) {
        this.p = r1;
    }

    public final void setThumbColor(int r1) {
        this.f11391f.setThumbColor(r1);
    }

    public final void setThumbDefaultWidth(int r2) {
        Drawable r1 = this.f11391f.getThumb();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.oui.slider.ThumbDrawable");
        ((d) r1).a(r2);
    }
}
