package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* JADX INFO: loaded from: classes2.dex */
public final class IndeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    private IndeterminateAnimatorDelegate<ObjectAnimator> animatorDelegate;
    private DrawingDelegate<S> drawingDelegate;

    IndeterminateDrawable(@NonNull Context r1, @NonNull BaseProgressIndicatorSpec r2, @NonNull DrawingDelegate<S> r3, @NonNull IndeterminateAnimatorDelegate<ObjectAnimator> r4) {
        super(r1, r2);
        setDrawingDelegate(r3);
        setAnimatorDelegate(r4);
    }

    @NonNull
    public static IndeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(@NonNull Context r3, @NonNull CircularProgressIndicatorSpec r4) {
        return new IndeterminateDrawable(r3, r4, new CircularDrawingDelegate(r4), new CircularIndeterminateAnimatorDelegate(r4));
    }

    @NonNull
    public static IndeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(@NonNull Context r3, @NonNull LinearProgressIndicatorSpec r4) {
        LinearDrawingDelegate r1 = new LinearDrawingDelegate(r4);
        if (r4.indeterminateAnimationType != 0) goto L5;
        IndeterminateAnimatorDelegate r2 = new LinearIndeterminateContiguousAnimatorDelegate(r4);
    L7:
        return new IndeterminateDrawable(r3, r4, r1, r2);
    L5:
        r2 = new LinearIndeterminateDisjointAnimatorDelegate(r3, r4);
        goto L7
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r11) {
        Rect r0 = new Rect();
        if (getBounds().isEmpty() == false) goto L5;
        return;
    L5:
        if (isVisible() == true) goto L7;
        return;
    L7:
        if (r11.getClipBounds(r0) == false) goto L18;
        r11.save();
        this.drawingDelegate.validateSpecAndAdjustCanvas(r11, getGrowFraction());
        this.drawingDelegate.fillTrack(r11, this.paint);
        int r1 = 0;
    L10:
        IndeterminateAnimatorDelegate<ObjectAnimator> r2 = this.animatorDelegate;
        int[] r3 = r2.segmentColors;
        if (r1 >= r3.length) goto L13;
        DrawingDelegate<S> r4 = this.drawingDelegate;
        Paint r6 = this.paint;
        float[] r5 = r2.segmentPositions;
        int r7 = r1 * 2;
        r4.fillIndicator(r11, r6, r5[r7], r5[r7 + 1], r3[r1]);
        r1 = r1 + 1;
        goto L10
    L13:
        r11.restore();
        return;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @NonNull
    IndeterminateAnimatorDelegate<ObjectAnimator> getAnimatorDelegate() {
        return this.animatorDelegate;
    }

    @NonNull
    DrawingDelegate<S> getDrawingDelegate() {
        return this.drawingDelegate;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.drawingDelegate.getPreferredHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.drawingDelegate.getPreferredWidth();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean hideNow() {
        return super.hideNow();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean isHiding() {
        return super.isHiding();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean isShowing() {
        return super.isShowing();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r1) {
        super.registerAnimationCallback(r1);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int r1) {
        super.setAlpha(r1);
    }

    void setAnimatorDelegate(@NonNull IndeterminateAnimatorDelegate<ObjectAnimator> r1) {
        this.animatorDelegate = r1;
        r1.registerDrawable(this);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(@Nullable ColorFilter r1) {
        super.setColorFilter(r1);
    }

    void setDrawingDelegate(@NonNull DrawingDelegate<S> r1) {
        this.drawingDelegate = r1;
        r1.registerDrawable(this);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean r1, boolean r2) {
        return super.setVisible(r1, r2);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean setVisible(boolean r1, boolean r2, boolean r3) {
        return super.setVisible(r1, r2, r3);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    boolean setVisibleInternal(boolean r3, boolean r4, boolean r5) {
        boolean r6 = super.setVisibleInternal(r3, r4, r5);
        if (isRunning() == true) goto L5;
        this.animatorDelegate.cancelAnimatorImmediately();
    L5:
        float r0 = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (r3 == false) goto L13;
        if (r5 == false) goto L9;
    L12:
        this.animatorDelegate.startAnimator();
        goto L13
    L9:
        if (Build.VERSION.SDK_INT > 21) goto L13;
        if (r0 > 0.0f) goto L12;
    L13:
        return r6;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r1) {
        return super.unregisterAnimationCallback(r1);
    }
}
