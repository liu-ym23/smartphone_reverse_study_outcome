package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseProgressIndicator<S extends BaseProgressIndicatorSpec> extends ProgressBar {
    static final float DEFAULT_OPACITY = 0.2f;
    static final int DEF_STYLE_RES = 0;
    public static final int HIDE_INWARD = 2;
    public static final int HIDE_NONE = 0;
    public static final int HIDE_OUTWARD = 1;
    static final int MAX_ALPHA = 255;
    static final int MAX_HIDE_DELAY = 1000;
    public static final int SHOW_INWARD = 2;
    public static final int SHOW_NONE = 0;
    public static final int SHOW_OUTWARD = 1;
    AnimatorDurationScaleProvider animatorDurationScaleProvider;
    private final Runnable delayedHide;
    private final Runnable delayedShow;
    private final Animatable2Compat.AnimationCallback hideAnimationCallback;
    private boolean isIndeterminateModeChangeRequested;
    private boolean isParentDoneInitializing;
    private long lastShowStartTime;
    private final int minHideDelay;
    private final int showDelay;
    S spec;
    private int storedProgress;
    private boolean storedProgressAnimated;
    private final Animatable2Compat.AnimationCallback switchIndeterminateModeCallback;
    private int visibilityAfterHide;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface HideAnimationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ShowAnimationBehavior {
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_ProgressIndicator;
    }

    protected BaseProgressIndicator(@NonNull Context r8, @Nullable AttributeSet r9, @AttrRes int r10, @StyleRes int r11) {
        super(MaterialThemeOverlay.wrap(r8, r9, r10, DEF_STYLE_RES), r9, r10);
        this.lastShowStartTime = -1;
        this.isIndeterminateModeChangeRequested = false;
        this.visibilityAfterHide = 4;
        this.delayedShow = new AnonymousClass1(this);
        this.delayedHide = new AnonymousClass2(this);
        this.switchIndeterminateModeCallback = new AnonymousClass3(this);
        this.hideAnimationCallback = new AnonymousClass4(this);
        Context r1 = getContext();
        this.spec = (S) createSpec(r1, r9);
        TypedArray r12 = ThemeEnforcement.obtainStyledAttributes(r1, r9, R.styleable.BaseProgressIndicator, r10, r11, new int[0]);
        this.showDelay = r12.getInt(R.styleable.BaseProgressIndicator_showDelay, -1);
        this.minHideDelay = Math.min(r12.getInt(R.styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        r12.recycle();
        this.animatorDurationScaleProvider = new AnimatorDurationScaleProvider();
        this.isParentDoneInitializing = true;
    }

    static /* synthetic */ void access$000(BaseProgressIndicator r0) {
        r0.internalShow();
    }

    static /* synthetic */ void access$100(BaseProgressIndicator r0) {
        r0.internalHide();
    }

    static /* synthetic */ long access$202(BaseProgressIndicator r0, long r1) {
        r0.lastShowStartTime = r1;
        return r1;
    }

    static /* synthetic */ int access$300(BaseProgressIndicator r0) {
        return r0.storedProgress;
    }

    static /* synthetic */ boolean access$400(BaseProgressIndicator r0) {
        return r0.storedProgressAnimated;
    }

    static /* synthetic */ boolean access$500(BaseProgressIndicator r0) {
        return r0.isIndeterminateModeChangeRequested;
    }

    static /* synthetic */ int access$600(BaseProgressIndicator r0) {
        return r0.visibilityAfterHide;
    }

    @Nullable
    private DrawingDelegate<S> getCurrentDrawingDelegate() {
        if (isIndeterminate() == false) goto L10;
        if (getIndeterminateDrawable() != null) goto L8;
        return null;
    L8:
        return getIndeterminateDrawable().getDrawingDelegate();
    L10:
        if (getProgressDrawable() != null) goto L13;
        return null;
    L13:
        return getProgressDrawable().getDrawingDelegate();
    }

    private void internalHide() {
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(false, false, true);
        if (isNoLongerNeedToBeVisible() == false) goto L6;
        setVisibility(4);
        return;
    }

    private void internalShow() {
        if (this.minHideDelay <= 0) goto L5;
        this.lastShowStartTime = SystemClock.uptimeMillis();
    L5:
        setVisibility(0);
    }

    private boolean isNoLongerNeedToBeVisible() {
        if (getProgressDrawable() == null) goto L7;
        if (getProgressDrawable().isVisible() == false) goto L7;
    L11:
        return false;
    L7:
        if (getIndeterminateDrawable() != null) goto L9;
    L12:
        return true;
    L9:
        if (getIndeterminateDrawable().isVisible() == true) goto L11;
        goto L11
    }

    private void registerAnimationCallbacks() {
        if (getProgressDrawable() == null) goto L8;
        if (getIndeterminateDrawable() == null) goto L8;
        getIndeterminateDrawable().getAnimatorDelegate().registerAnimatorsCompleteCallback(this.switchIndeterminateModeCallback);
    L8:
        if (getProgressDrawable() == null) goto L11;
        getProgressDrawable().registerAnimationCallback(this.hideAnimationCallback);
    L11:
        if (getIndeterminateDrawable() == null) goto L14;
        getIndeterminateDrawable().registerAnimationCallback(this.hideAnimationCallback);
        return;
    }

    private void unregisterAnimationCallbacks() {
        if (getIndeterminateDrawable() == null) goto L6;
        getIndeterminateDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
        getIndeterminateDrawable().getAnimatorDelegate().unregisterAnimatorsCompleteCallback();
    L6:
        if (getProgressDrawable() == null) goto L9;
        getProgressDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
        return;
    }

    protected void applyNewVisibility(boolean r3) {
        if (this.isParentDoneInitializing == true) goto L5;
        return;
    L5:
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(visibleToUser(), false, r3);
    }

    abstract S createSpec(@NonNull Context r1, @NonNull AttributeSet r2);

    @Override // android.widget.ProgressBar
    @Nullable
    public Drawable getCurrentDrawable() {
        if (isIndeterminate() == false) goto L6;
        return getIndeterminateDrawable();
    L6:
        return getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.spec.hideAnimationBehavior;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public /* bridge */ /* synthetic */ Drawable getIndeterminateDrawable() {
        return getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public IndeterminateDrawable<S> getIndeterminateDrawable() {
        return (IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.spec.indicatorColors;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public /* bridge */ /* synthetic */ Drawable getProgressDrawable() {
        return getProgressDrawable();
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public DeterminateDrawable<S> getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }

    public int getShowAnimationBehavior() {
        return this.spec.showAnimationBehavior;
    }

    @ColorInt
    public int getTrackColor() {
        return this.spec.trackColor;
    }

    @Px
    public int getTrackCornerRadius() {
        return this.spec.trackCornerRadius;
    }

    @Px
    public int getTrackThickness() {
        return this.spec.trackThickness;
    }

    public void hide() {
        if (getVisibility() == 0) goto L6;
        removeCallbacks(this.delayedShow);
        return;
    L6:
        removeCallbacks(this.delayedHide);
        long r0 = SystemClock.uptimeMillis() - this.lastShowStartTime;
        int r2 = this.minHideDelay;
        if (r0 < r2) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L13;
        this.delayedHide.run();
        return;
    L13:
        postDelayed(this.delayedHide, ((long) r2) - r0);
        return;
    L9:
        r3 = false;
        goto L10
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() == null) goto L6;
        getCurrentDrawable().invalidateSelf();
        return;
    }

    boolean isEffectivelyVisible() {
        View r0 = this;
    L4:
        if (r0.getVisibility() != 0) goto L5;
        Object r1 = r0.getParent();
        if (r1 == null) goto L9;
        if ((r1 instanceof View) == false) goto L14;
        r0 = (View) r1;
        goto L4
    L14:
        return true;
    L9:
        if (getWindowVisibility() == 0) goto L11;
        return false;
    L11:
        return true;
    L5:
        return false;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerAnimationCallbacks();
        if (visibleToUser() == false) goto L6;
        internalShow();
        return;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.delayedHide);
        removeCallbacks(this.delayedShow);
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).hideNow();
        unregisterAnimationCallbacks();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(@NonNull Canvas r6) {
        monitor-enter(this);
        int r0 = r6.save();     // Catch: Throwable -> L16
        if (getPaddingLeft() == 0) goto L6;
    L7:
        r6.translate(getPaddingLeft(), getPaddingTop());     // Catch: Throwable -> L16
    L9:
        if (getPaddingRight() == 0) goto L11;
    L12:
        r6.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));     // Catch: Throwable -> L16
    L13:
        getCurrentDrawable().draw(r6);     // Catch: Throwable -> L16
        r6.restoreToCount(r0);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L11:
        if (getPaddingBottom() == 0) goto L13;
    L6:
        if (getPaddingTop() == 0) goto L9;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int r2, int r3) {
        monitor-enter(this);
        super.onMeasure(r2, r3);     // Catch: Throwable -> L17
        DrawingDelegate<S> r4 = getCurrentDrawingDelegate();     // Catch: Throwable -> L17
        if (r4 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        int r5 = r4.getPreferredWidth();     // Catch: Throwable -> L17
        int r6 = r4.getPreferredHeight();     // Catch: Throwable -> L17
        if (r5 >= 0) goto L10;
        int r7 = getMeasuredWidth();     // Catch: Throwable -> L17
    L11:
        if (r6 >= 0) goto L13;
        int r8 = getMeasuredHeight();     // Catch: Throwable -> L17
    L14:
        setMeasuredDimension(r7, r8);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L13:
        r8 = (r6 + getPaddingTop()) + getPaddingBottom();     // Catch: Throwable -> L17
        goto L14
    L10:
        r7 = (r5 + getPaddingLeft()) + getPaddingRight();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View r1, int r2) {
        super.onVisibilityChanged(r1, r2);
        if (r2 != 0) goto L5;
        boolean r3 = true;
    L6:
        applyNewVisibility(r3);
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        applyNewVisibility(false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setAnimatorDurationScaleProvider(@NonNull AnimatorDurationScaleProvider r2) {
        this.animatorDurationScaleProvider = r2;
        if (getProgressDrawable() == null) goto L6;
        getProgressDrawable().animatorDurationScaleProvider = r2;
    L6:
        if (getIndeterminateDrawable() == null) goto L9;
        getIndeterminateDrawable().animatorDurationScaleProvider = r2;
        return;
    }

    public void setHideAnimationBehavior(int r2) {
        this.spec.hideAnimationBehavior = r2;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean r3) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (r3 != isIndeterminate()) goto L7;
        monitor-exit(this);
        return;
    L7:
        DrawableWithAnimatedVisibilityChange r0 = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();     // Catch: Throwable -> L21
        if (r0 == null) goto L10;
        r0.hideNow();     // Catch: Throwable -> L21
    L10:
        super.setIndeterminate(r3);     // Catch: Throwable -> L21
        DrawableWithAnimatedVisibilityChange r4 = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();     // Catch: Throwable -> L21
        if (r4 == null) goto L14;
        r4.setVisible(visibleToUser(), false, false);     // Catch: Throwable -> L21
    L14:
        if ((r4 instanceof IndeterminateDrawable) == true) goto L16;
    L18:
        this.isIndeterminateModeChangeRequested = false;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L16:
        if (visibleToUser() == false) goto L18;
        ((IndeterminateDrawable) r4).getAnimatorDelegate().startAnimator();     // Catch: Throwable -> L21
        goto L18
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@Nullable Drawable r2) {
        if (r2 != null) goto L6;
        super.setIndeterminateDrawable(null);
        return;
    L6:
        if ((r2 instanceof IndeterminateDrawable) == false) goto L10;
        ((DrawableWithAnimatedVisibilityChange) r2).hideNow();
        super.setIndeterminateDrawable(r2);
        return;
    L10:
        throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
    }

    public void setIndicatorColor(@ColorInt int... r5) {
        if (r5.length != 0) goto L6;
        r5 = new int[]{MaterialColors.getColor(getContext(), R.attr.colorPrimary, -1)};
    L6:
        if (Arrays.equals(getIndicatorColor(), r5) == true) goto L9;
        this.spec.indicatorColors = r5;
        getIndeterminateDrawable().getAnimatorDelegate().invalidateSpecValues();
        invalidate();
        return;
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isIndeterminate() == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        setProgressCompat(r2, false);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void setProgressCompat(int r2, boolean r3) {
        if (isIndeterminate() == true) goto L5;
        super.setProgress(r2);
        if (getProgressDrawable() == null) goto L21;
        if (r3 == true) goto L22;
        getProgressDrawable().jumpToCurrentState();
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (getProgressDrawable() == null) goto L18;
        this.storedProgress = r2;
        this.storedProgressAnimated = r3;
        this.isIndeterminateModeChangeRequested = true;
        if (getIndeterminateDrawable().isVisible() == true) goto L9;
    L12:
        this.switchIndeterminateModeCallback.onAnimationEnd(getIndeterminateDrawable());
        return;
    L9:
        if (this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(getContext().getContentResolver()) == 0.0f) goto L12;
        getIndeterminateDrawable().getAnimatorDelegate().requestCancelAnimatorAfterCurrentCycle();
        return;
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@Nullable Drawable r2) {
        if (r2 != null) goto L6;
        super.setProgressDrawable(null);
        return;
    L6:
        if ((r2 instanceof DeterminateDrawable) == false) goto L10;
        DeterminateDrawable r3 = (DeterminateDrawable) r2;
        r3.hideNow();
        super.setProgressDrawable(r3);
        r3.setLevelByFraction(getProgress() / getMax());
        return;
    L10:
        throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
    }

    public void setShowAnimationBehavior(int r2) {
        this.spec.showAnimationBehavior = r2;
        invalidate();
    }

    public void setTrackColor(@ColorInt int r3) {
        S r0 = this.spec;
        if (r0.trackColor == r3) goto L6;
        r0.trackColor = r3;
        invalidate();
        return;
    }

    public void setTrackCornerRadius(@Px int r2) {
        S r1 = this.spec;
        if (r1.trackCornerRadius == r2) goto L6;
        r1.trackCornerRadius = Math.min(r2, r1.trackThickness / 2);
        return;
    }

    public void setTrackThickness(@Px int r3) {
        S r0 = this.spec;
        if (r0.trackThickness == r3) goto L6;
        r0.trackThickness = r3;
        requestLayout();
        return;
    }

    public void setVisibilityAfterHide(int r2) {
        if (r2 != 0) goto L4;
    L10:
        this.visibilityAfterHide = r2;
        return;
    L4:
        if (r2 == 4) goto L10;
        if (r2 == 8) goto L10;
        throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }

    public void show() {
        if (this.showDelay <= 0) goto L5;
        removeCallbacks(this.delayedShow);
        postDelayed(this.delayedShow, this.showDelay);
        return;
    L5:
        this.delayedShow.run();
    }

    boolean visibleToUser() {
        if (ViewCompat.isAttachedToWindow(this) == true) goto L5;
    L9:
        return false;
    L5:
        if (getWindowVisibility() != 0) goto L9;
        if (isEffectivelyVisible() == false) goto L9;
        return true;
    }
}
