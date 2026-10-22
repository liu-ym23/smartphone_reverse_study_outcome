package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class DrawableWithAnimatedVisibilityChange extends Drawable implements Animatable2Compat {
    private static final boolean DEFAULT_DRAWABLE_RESTART = false;
    private static final int GROW_DURATION = 500;
    private static final Property<DrawableWithAnimatedVisibilityChange, Float> GROW_FRACTION = null;
    private List<Animatable2Compat.AnimationCallback> animationCallbacks;
    AnimatorDurationScaleProvider animatorDurationScaleProvider;
    final BaseProgressIndicatorSpec baseSpec;
    final Context context;
    private float growFraction;
    private ValueAnimator hideAnimator;
    private boolean ignoreCallbacks;
    private Animatable2Compat.AnimationCallback internalAnimationCallback;
    private float mockGrowFraction;
    private boolean mockHideAnimationRunning;
    private boolean mockShowAnimationRunning;
    final Paint paint;
    private ValueAnimator showAnimator;
    private int totalAlpha;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    static /* synthetic */ void access$000(DrawableWithAnimatedVisibilityChange r0) {
        r0.dispatchAnimationStart();
    }

    static /* synthetic */ boolean access$101(DrawableWithAnimatedVisibilityChange r0, boolean r1, boolean r2) {
        return super.setVisible(r1, r2);
    }

    static /* synthetic */ void access$200(DrawableWithAnimatedVisibilityChange r0) {
        r0.dispatchAnimationEnd();
    }

    DrawableWithAnimatedVisibilityChange(Context r2, BaseProgressIndicatorSpec r3) {
        this.paint = new Paint();
        this.context = r2;
        this.baseSpec = r3;
        this.animatorDurationScaleProvider = new AnimatorDurationScaleProvider();
        setAlpha(255);
    }

    private void maybeInitializeAnimators() {
        if (this.showAnimator != null) goto L6;
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this, GROW_FRACTION, new float[]{0.0f, 1.0f});
        this.showAnimator = r0;
        r0.setDuration(500);
        this.showAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        setShowAnimator(this.showAnimator);
    L6:
        if (this.hideAnimator != null) goto L9;
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this, GROW_FRACTION, new float[]{1.0f, 0.0f});
        this.hideAnimator = r1;
        r1.setDuration(500);
        this.hideAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        setHideAnimator(this.hideAnimator);
        return;
    }

    public void registerAnimationCallback(Animatable2Compat.AnimationCallback r2) {
        if (this.animationCallbacks != null) goto L6;
        this.animationCallbacks = new ArrayList();
    L6:
        if (this.animationCallbacks.contains(r2) == true) goto L9;
        this.animationCallbacks.add(r2);
        return;
    }

    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback r2) {
        List<Animatable2Compat.AnimationCallback> r0 = this.animationCallbacks;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.contains(r2) == false) goto L14;
        this.animationCallbacks.remove(r2);
        if (this.animationCallbacks.isEmpty() == false) goto L13;
        this.animationCallbacks = null;
        return true;
    L13:
        return true;
    L14:
        return false;
    }

    public void clearAnimationCallbacks() {
        this.animationCallbacks.clear();
        this.animationCallbacks = null;
    }

    void setInternalAnimationCallback(Animatable2Compat.AnimationCallback r1) {
        this.internalAnimationCallback = r1;
    }

    private void dispatchAnimationStart() {
        Animatable2Compat.AnimationCallback r0 = this.internalAnimationCallback;
        if (r0 == null) goto L5;
        r0.onAnimationStart(this);
    L5:
        List<Animatable2Compat.AnimationCallback> r1 = this.animationCallbacks;
        if (r1 != null) goto L8;
        return;
    L8:
        if (this.ignoreCallbacks == true) goto L15;
        Iterator<Animatable2Compat.AnimationCallback> r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L16;
        r2.next().onAnimationStart(this);
        goto L11
    L16:
        return;
    }

    private void dispatchAnimationEnd() {
        Animatable2Compat.AnimationCallback r0 = this.internalAnimationCallback;
        if (r0 == null) goto L5;
        r0.onAnimationEnd(this);
    L5:
        List<Animatable2Compat.AnimationCallback> r1 = this.animationCallbacks;
        if (r1 != null) goto L8;
        return;
    L8:
        if (this.ignoreCallbacks == true) goto L15;
        Iterator<Animatable2Compat.AnimationCallback> r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L16;
        r2.next().onAnimationEnd(this);
        goto L11
    L16:
        return;
    }

    public void start() {
        setVisibleInternal(true, true, false);
    }

    public void stop() {
        setVisibleInternal(false, true, false);
    }

    public boolean isRunning() {
        if (isShowing() == false) goto L5;
    L8:
        return true;
    L5:
        if (isHiding() == true) goto L8;
        return false;
    }

    public boolean isShowing() {
        ValueAnimator r0 = this.showAnimator;
        if (r0 == null) goto L7;
        if (r0.isRunning() == false) goto L7;
    L8:
        return true;
    L7:
        if (this.mockShowAnimationRunning == true) goto L8;
        return false;
    }

    public boolean isHiding() {
        ValueAnimator r0 = this.hideAnimator;
        if (r0 == null) goto L7;
        if (r0.isRunning() == false) goto L7;
    L8:
        return true;
    L7:
        if (this.mockHideAnimationRunning == true) goto L8;
        return false;
    }

    public boolean hideNow() {
        return setVisible(false, false, false);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r2, boolean r3) {
        return setVisible(r2, r3, true);
    }

    public boolean setVisible(boolean r3, boolean r4, boolean r5) {
        float r0 = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (r5 == true) goto L5;
    L7:
        boolean r6 = false;
    L9:
        return setVisibleInternal(r3, r4, r6);
    L5:
        if (r0 <= 0.0f) goto L7;
        r6 = true;
        goto L9
    }

    boolean setVisibleInternal(boolean r4, boolean r5, boolean r6) {
        maybeInitializeAnimators();
        if (isVisible() == true) goto L6;
        if (r4 == true) goto L6;
        return false;
    L6:
        if (r4 == false) goto L8;
        ValueAnimator r0 = this.showAnimator;
    L10:
        if (r6 == false) goto L12;
        if (r6 == true) goto L19;
    L21:
        if (r4 == true) goto L23;
    L26:
        boolean r7 = true;
    L27:
        if (r4 == false) goto L29;
        boolean r8 = this.baseSpec.isShowAnimationEnabled();
    L30:
        if (r8 == true) goto L33;
        endAnimatorWithoutCallbacks(new ValueAnimator[]{r0});
        return r7;
    L33:
        if (r5 == false) goto L35;
    L38:
        r0.start();
    L39:
        return r7;
    L35:
        if (r0.isPaused() == false) goto L38;
        r0.resume();
        goto L39
    L29:
        r8 = this.baseSpec.isHideAnimationEnabled();
        goto L30
    L23:
        if (super.setVisible(r4, false) == true) goto L26;
        r7 = false;
        goto L27
    L19:
        if (r0.isRunning() == false) goto L21;
        return false;
    L12:
        if (r0.isRunning() == false) goto L14;
        r0.end();
    L16:
        return super.setVisible(r4, false);
    L14:
        endAnimatorWithoutCallbacks(new ValueAnimator[]{r0});
        goto L16
    L8:
        r0 = this.hideAnimator;
        goto L10
    }

    private void endAnimatorWithoutCallbacks(ValueAnimator... r5) {
        boolean r0 = this.ignoreCallbacks;
        this.ignoreCallbacks = true;
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r5[r2].end();
        r2 = r2 + 1;
        goto L3
    L5:
        this.ignoreCallbacks = r0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
        this.totalAlpha = r1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.totalAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.paint.setColorFilter(r2);
        invalidateSelf();
    }

    private void setShowAnimator(ValueAnimator r2) {
        ValueAnimator r0 = this.showAnimator;
        if (r0 != null) goto L5;
    L9:
        this.showAnimator = r2;
        r2.addListener(new AnonymousClass1(this));
        return;
    L5:
        if (r0.isRunning() == false) goto L9;
        throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
    }

    ValueAnimator getHideAnimator() {
        return this.hideAnimator;
    }

    private void setHideAnimator(ValueAnimator r2) {
        ValueAnimator r0 = this.hideAnimator;
        if (r0 != null) goto L5;
    L9:
        this.hideAnimator = r2;
        r2.addListener(new AnonymousClass2(this));
        return;
    L5:
        if (r0.isRunning() == false) goto L9;
        throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
    }

    float getGrowFraction() {
        if (this.baseSpec.isShowAnimationEnabled() == true) goto L9;
        if (this.baseSpec.isHideAnimationEnabled() == true) goto L9;
        return 1.0f;
    L9:
        if (this.mockHideAnimationRunning == true) goto L16;
        if (this.mockShowAnimationRunning == true) goto L16;
        return this.growFraction;
    L16:
        return this.mockGrowFraction;
    }

    void setGrowFraction(float r2) {
        if (this.growFraction == r2) goto L6;
        this.growFraction = r2;
        invalidateSelf();
        return;
    }

    void setMockShowAnimationRunning(boolean r1, float r2) {
        this.mockShowAnimationRunning = r1;
        this.mockGrowFraction = r2;
    }

    void setMockHideAnimationRunning(boolean r1, float r2) {
        this.mockHideAnimationRunning = r1;
        this.mockGrowFraction = r2;
    }

    static {
        final Class<Float> r1 = Float.class;
        final String r2 = "growFraction";
        GROW_FRACTION = new AnonymousClass3(r1, r2);
    }
}
