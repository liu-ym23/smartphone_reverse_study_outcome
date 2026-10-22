package com.google.android.material.snackbar;

import a.a;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    static final int ANIMATION_DURATION = 250;
    static final int ANIMATION_FADE_DURATION = 180;
    private static final int ANIMATION_FADE_IN_DURATION = 150;
    private static final int ANIMATION_FADE_OUT_DURATION = 75;
    public static final int ANIMATION_MODE_FADE = 1;
    public static final int ANIMATION_MODE_SLIDE = 0;
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    static final int MSG_DISMISS = 1;
    static final int MSG_SHOW = 0;
    private static final int[] SNACKBAR_STYLE_ATTR = null;
    private static final String TAG = null;
    private static final boolean USE_OFFSET_API = false;

    @NonNull
    static final Handler handler = null;

    @Nullable
    private final AccessibilityManager accessibilityManager;

    @Nullable
    private View anchorView;
    private Behavior behavior;

    @RequiresApi(29)
    private final Runnable bottomMarginGestureInsetRunnable;
    private List<BaseCallback<B>> callbacks;

    @NonNull
    private final com.google.android.material.snackbar.ContentViewCallback contentViewCallback;
    private final Context context;
    private int duration;
    private int extraBottomMarginAnchorView;
    private int extraBottomMarginGestureInset;
    private int extraBottomMarginWindowInset;
    private int extraLeftMarginWindowInset;
    private int extraRightMarginWindowInset;
    private boolean gestureInsetBottomIgnored;

    @NonNull
    SnackbarManager.Callback managerCallback;

    @Nullable
    private Rect originalMargins;

    @NonNull
    private final ViewGroup targetParent;

    @NonNull
    protected final SnackbarBaseLayout view;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AnimationMode {
    }

    public static abstract class BaseCallback<B> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface DismissEvent {
        }

        public BaseCallback() {
        }

        public void onDismissed(B r1, int r2) {
        }

        public void onShown(B r1) {
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {

        @NonNull
        private final BehaviorDelegate delegate;

        public Behavior() {
            this.delegate = new BehaviorDelegate(this);
        }

        public static /* synthetic */ void access$1000(Behavior r0, BaseTransientBottomBar r1) {
            r0.setBaseTransientBottomBar(r1);
        }

        private void setBaseTransientBottomBar(@NonNull BaseTransientBottomBar<?> r1) {
            this.delegate.setBaseTransientBottomBar(r1);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean canSwipeDismissView(View r1) {
            return this.delegate.canSwipeDismissView(r1);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r2, @NonNull View r3, @NonNull MotionEvent r4) {
            this.delegate.onInterceptTouchEvent(r2, r3, r4);
            return super.onInterceptTouchEvent(r2, r3, r4);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class BehaviorDelegate {
        private SnackbarManager.Callback managerCallback;

        public BehaviorDelegate(@NonNull SwipeDismissBehavior<?> r1) {
            r1.setStartAlphaSwipeDistance(0.1f);
            r1.setEndAlphaSwipeDistance(0.6f);
            r1.setSwipeDirection(0);
        }

        public boolean canSwipeDismissView(View r1) {
            return r1 instanceof SnackbarBaseLayout;
        }

        public void onInterceptTouchEvent(@NonNull CoordinatorLayout r2, @NonNull View r3, @NonNull MotionEvent r4) {
            int r0 = r4.getActionMasked();
            if (r0 == 0) goto L11;
            if (r0 != 1) goto L7;
        L9:
            SnackbarManager.getInstance().restoreTimeoutIfPaused(this.managerCallback);
            return;
        L7:
            if (r0 == 3) goto L9;
            return;
        L11:
            if (r2.isPointInChildBounds(r3, (int) r4.getX(), (int) r4.getY()) == false) goto L15;
            SnackbarManager.getInstance().pauseTimeout(this.managerCallback);
            return;
        }

        public void setBaseTransientBottomBar(@NonNull BaseTransientBottomBar<?> r1) {
            this.managerCallback = r1.managerCallback;
        }
    }

    @Deprecated
    public interface ContentViewCallback extends com.google.android.material.snackbar.ContentViewCallback {
    }

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Duration {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnAttachStateChangeListener {
        void onViewAttachedToWindow(View r1);

        void onViewDetachedFromWindow(View r1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnLayoutChangeListener {
        void onLayoutChange(View r1, int r2, int r3, int r4, int r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class SnackbarBaseLayout extends FrameLayout {
        private static final View.OnTouchListener consumeAllTouchListener = null;
        private final float actionTextColorAlpha;
        private int animationMode;
        private final float backgroundOverlayColorAlpha;
        private ColorStateList backgroundTint;
        private PorterDuff.Mode backgroundTintMode;
        private OnAttachStateChangeListener onAttachStateChangeListener;
        private OnLayoutChangeListener onLayoutChangeListener;

        static {
            consumeAllTouchListener = new AnonymousClass1();
        }

        public SnackbarBaseLayout(@NonNull Context r2) {
            this(r2, null);
        }

        @NonNull
        private Drawable createThemedBackground() {
            float r0 = getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
            GradientDrawable r1 = new GradientDrawable();
            r1.setShape(0);
            r1.setCornerRadius(r0);
            r1.setColor(MaterialColors.layer(this, R.attr.colorSurface, R.attr.colorOnSurface, getBackgroundOverlayColorAlpha()));
            if (this.backgroundTint == null) goto L7;
            Drawable r2 = DrawableCompat.wrap(r1);
            DrawableCompat.setTintList(r2, this.backgroundTint);
            return r2;
        L7:
            return DrawableCompat.wrap(r1);
        }

        public float getActionTextColorAlpha() {
            return this.actionTextColorAlpha;
        }

        public int getAnimationMode() {
            return this.animationMode;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.backgroundOverlayColorAlpha;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            OnAttachStateChangeListener r0 = this.onAttachStateChangeListener;
            if (r0 == null) goto L5;
            r0.onViewAttachedToWindow(this);
        L5:
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            OnAttachStateChangeListener r0 = this.onAttachStateChangeListener;
            if (r0 == null) goto L6;
            r0.onViewDetachedFromWindow(this);
            return;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
            super.onLayout(r7, r8, r9, r10, r11);
            OnLayoutChangeListener r0 = this.onLayoutChangeListener;
            if (r0 == null) goto L6;
            r0.onLayoutChange(this, r8, r9, r10, r11);
            return;
        }

        public void setAnimationMode(int r1) {
            this.animationMode = r1;
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable r1) {
            setBackgroundDrawable(r1);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable r2) {
            if (r2 != null) goto L4;
        L6:
            super.setBackgroundDrawable(r2);
            return;
        L4:
            if (this.backgroundTint == null) goto L6;
            r2 = DrawableCompat.wrap(r2.mutate());
            DrawableCompat.setTintList(r2, this.backgroundTint);
            DrawableCompat.setTintMode(r2, this.backgroundTintMode);
            goto L6
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList r2) {
            this.backgroundTint = r2;
            if (getBackground() == null) goto L8;
            Drawable r0 = DrawableCompat.wrap(getBackground().mutate());
            DrawableCompat.setTintList(r0, r2);
            DrawableCompat.setTintMode(r0, this.backgroundTintMode);
            if (r0 == getBackground()) goto L9;
            super.setBackgroundDrawable(r0);
            return;
        L9:
            return;
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode r2) {
            this.backgroundTintMode = r2;
            if (getBackground() == null) goto L8;
            Drawable r0 = DrawableCompat.wrap(getBackground().mutate());
            DrawableCompat.setTintMode(r0, r2);
            if (r0 == getBackground()) goto L9;
            super.setBackgroundDrawable(r0);
            return;
        L9:
            return;
        }

        public void setOnAttachStateChangeListener(OnAttachStateChangeListener r1) {
            this.onAttachStateChangeListener = r1;
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener r2) {
            if (r2 == null) goto L4;
            View.OnTouchListener r0 = null;
        L5:
            setOnTouchListener(r0);
            super.setOnClickListener(r2);
            return;
        L4:
            r0 = consumeAllTouchListener;
            goto L5
        }

        public void setOnLayoutChangeListener(OnLayoutChangeListener r1) {
            this.onLayoutChangeListener = r1;
        }

        public SnackbarBaseLayout(@NonNull Context r3, AttributeSet r4) {
            super(MaterialThemeOverlay.wrap(r3, r4, 0, 0), r4);
            Context r5 = getContext();
            TypedArray r6 = r5.obtainStyledAttributes(r4, R.styleable.SnackbarLayout);
            if (r6.hasValue(R.styleable.SnackbarLayout_elevation) == false) goto L5;
            ViewCompat.setElevation(this, r6.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
        L5:
            this.animationMode = r6.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            this.backgroundOverlayColorAlpha = r6.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(MaterialResources.getColorStateList(r5, r6, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(ViewUtils.parseTintMode(r6.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.actionTextColorAlpha = r6.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            r6.recycle();
            setOnTouchListener(consumeAllTouchListener);
            setFocusable(true);
            if (getBackground() != null) goto L9;
            ViewCompat.setBackground(this, createThemedBackground());
            return;
        }
    }

    static {
        USE_OFFSET_API = false;
        SNACKBAR_STYLE_ATTR = new int[]{R.attr.snackbarStyle};
        TAG = "BaseTransientBottomBar";
        handler = new Handler(Looper.getMainLooper(), new AnonymousClass1());
    }

    public BaseTransientBottomBar(@NonNull ViewGroup r5, @NonNull View r6, @NonNull com.google.android.material.snackbar.ContentViewCallback r7) {
        this.bottomMarginGestureInsetRunnable = new AnonymousClass2(this);
        this.managerCallback = new AnonymousClass5(this);
        if (r5 == null) goto L19;
        if (r6 == null) goto L17;
        if (r7 == null) goto L15;
        this.targetParent = r5;
        this.contentViewCallback = r7;
        Context r8 = r5.getContext();
        this.context = r8;
        ThemeEnforcement.checkAppCompatTheme(r8);
        SnackbarBaseLayout r9 = (SnackbarBaseLayout) LayoutInflater.from(r8).inflate(getSnackbarBaseLayoutResId(), r5, false);
        this.view = r9;
        if ((r6 instanceof SnackbarContentLayout) == false) goto L9;
        ((SnackbarContentLayout) r6).updateActionTextColorAlphaIfNeeded(r9.getActionTextColorAlpha());
    L9:
        r9.addView(r6);
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
        this.originalMargins = new Rect(r11.leftMargin, r11.topMargin, r11.rightMargin, r11.bottomMargin);
    L12:
        ViewCompat.setAccessibilityLiveRegion(r9, 1);
        ViewCompat.setImportantForAccessibility(r9, 1);
        ViewCompat.setFitsSystemWindows(r9, true);
        ViewCompat.setOnApplyWindowInsetsListener(r9, new AnonymousClass3(this));
        ViewCompat.setAccessibilityDelegate(r9, new AnonymousClass4(this));
        this.accessibilityManager = (AccessibilityManager) r8.getSystemService("accessibility");
        return;
    L15:
        throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
    L17:
        throw new IllegalArgumentException("Transient bottom bar must have non-null content");
    L19:
        throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
    }

    public static /* synthetic */ Context access$000(BaseTransientBottomBar r0) {
        return r0.context;
    }

    public static /* synthetic */ int access$100(BaseTransientBottomBar r0) {
        return r0.getScreenHeight();
    }

    public static /* synthetic */ void access$1100(BaseTransientBottomBar r0) {
        r0.startFadeInAnimation();
    }

    public static /* synthetic */ void access$1200(BaseTransientBottomBar r0) {
        r0.startSlideInAnimation();
    }

    public static /* synthetic */ com.google.android.material.snackbar.ContentViewCallback access$1300(BaseTransientBottomBar r0) {
        return r0.contentViewCallback;
    }

    public static /* synthetic */ boolean access$1400() {
        return USE_OFFSET_API;
    }

    public static /* synthetic */ int access$200(BaseTransientBottomBar r0) {
        return r0.getViewAbsoluteBottom();
    }

    public static /* synthetic */ int access$300(BaseTransientBottomBar r0) {
        return r0.extraBottomMarginGestureInset;
    }

    public static /* synthetic */ int access$302(BaseTransientBottomBar r0, int r1) {
        r0.extraBottomMarginGestureInset = r1;
        return r1;
    }

    public static /* synthetic */ String access$400() {
        return TAG;
    }

    public static /* synthetic */ int access$502(BaseTransientBottomBar r0, int r1) {
        r0.extraBottomMarginWindowInset = r1;
        return r1;
    }

    public static /* synthetic */ int access$602(BaseTransientBottomBar r0, int r1) {
        r0.extraLeftMarginWindowInset = r1;
        return r1;
    }

    public static /* synthetic */ int access$702(BaseTransientBottomBar r0, int r1) {
        r0.extraRightMarginWindowInset = r1;
        return r1;
    }

    public static /* synthetic */ void access$800(BaseTransientBottomBar r0) {
        r0.updateMargins();
    }

    public static /* synthetic */ void access$900(BaseTransientBottomBar r0) {
        r0.showViewImpl();
    }

    private void animateViewOut(int r3) {
        if (this.view.getAnimationMode() != 1) goto L5;
        startFadeOutAnimation(r3);
        return;
    L5:
        startSlideOutAnimation(r3);
    }

    private int calculateBottomMarginForAnchorView() {
        View r0 = this.anchorView;
        if (r0 != null) goto L6;
        return 0;
    L6:
        int[] r2 = new int[2];
        r0.getLocationOnScreen(r2);
        int r3 = r2[1];
        int[] r1 = new int[2];
        this.targetParent.getLocationOnScreen(r1);
        int r4 = r1[1];
        return (this.targetParent.getHeight() + r4) - r3;
    }

    private ValueAnimator getAlphaAnimator(float... r2) {
        ValueAnimator r3 = ValueAnimator.ofFloat(r2);
        r3.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r3.addUpdateListener(new AnonymousClass12(this));
        return r3;
    }

    private ValueAnimator getScaleAnimator(float... r2) {
        ValueAnimator r3 = ValueAnimator.ofFloat(r2);
        r3.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        r3.addUpdateListener(new AnonymousClass13(this));
        return r3;
    }

    @RequiresApi(17)
    private int getScreenHeight() {
        WindowManager r1 = (WindowManager) this.context.getSystemService("window");
        DisplayMetrics r0 = new DisplayMetrics();
        r1.getDefaultDisplay().getRealMetrics(r0);
        return r0.heightPixels;
    }

    private int getTranslationYBottom() {
        int r0 = this.view.getHeight();
        ViewGroup.LayoutParams r2 = this.view.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        return r0;
    L5:
        return r0 + ((ViewGroup.MarginLayoutParams) r2).bottomMargin;
    }

    private int getViewAbsoluteBottom() {
        int[] r0 = new int[2];
        this.view.getLocationOnScreen(r0);
        int r1 = r0[1];
        return this.view.getHeight() + r1;
    }

    private boolean isSwipeDismissable() {
        ViewGroup.LayoutParams r1 = this.view.getLayoutParams();
        if ((r1 instanceof CoordinatorLayout.LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if ((((CoordinatorLayout.LayoutParams) r1).getBehavior() instanceof SwipeDismissBehavior) == false) goto L7;
        return true;
    }

    private void setUpBehavior(CoordinatorLayout.LayoutParams r3) {
        SwipeDismissBehavior<? extends View> r0 = this.behavior;
        if (r0 != null) goto L6;
        r0 = getNewBehavior();
    L6:
        if ((r0 instanceof Behavior) == false) goto L8;
        Behavior.access$1000((Behavior) r0, this);
    L8:
        r0.setListener(new AnonymousClass8(this));
        r3.setBehavior(r0);
        if (this.anchorView != null) goto L12;
        r3.insetEdge = 80;
        return;
    }

    private boolean shouldUpdateGestureInset() {
        if (this.extraBottomMarginGestureInset > 0) goto L5;
    L9:
        return false;
    L5:
        if (this.gestureInsetBottomIgnored == true) goto L9;
        if (isSwipeDismissable() == false) goto L9;
        return true;
    }

    private void showViewImpl() {
        if (shouldAnimate() == false) goto L5;
        animateViewIn();
        return;
    L5:
        this.view.setVisibility(0);
        onViewShown();
    }

    private void startFadeInAnimation() {
        ValueAnimator r1 = getAlphaAnimator(new float[]{0.0f, 1.0f});
        ValueAnimator r2 = getScaleAnimator(new float[]{ANIMATION_SCALE_FROM_VALUE, 1.0f});
        AnimatorSet r3 = new AnimatorSet();
        r3.playTogether(new Animator[]{r1, r2});
        r3.setDuration(150);
        r3.addListener(new AnonymousClass10(this));
        r3.start();
    }

    private void startFadeOutAnimation(final int r4) {
        ValueAnimator r0 = getAlphaAnimator(new float[]{1.0f, 0.0f});
        r0.setDuration(75);
        r0.addListener(new AnonymousClass11(this, r4));
        r0.start();
    }

    private void startSlideInAnimation() {
        final int r0 = getTranslationYBottom();
        if (USE_OFFSET_API == false) goto L5;
        ViewCompat.offsetTopAndBottom(this.view, r0);
    L6:
        ValueAnimator r1 = new ValueAnimator();
        r1.setIntValues(new int[]{r0, 0});
        r1.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        r1.setDuration(250);
        r1.addListener(new AnonymousClass14(this));
        r1.addUpdateListener(new AnonymousClass15(this, r0));
        r1.start();
        return;
    L5:
        this.view.setTranslationY(r0);
        goto L6
    }

    private void startSlideOutAnimation(final int r4) {
        ValueAnimator r0 = new ValueAnimator();
        r0.setIntValues(new int[]{0, getTranslationYBottom()});
        r0.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        r0.setDuration(250);
        r0.addListener(new AnonymousClass16(this, r4));
        r0.addUpdateListener(new AnonymousClass17(this));
        r0.start();
    }

    private void updateMargins() {
        ViewGroup.LayoutParams r0 = this.view.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        Rect r1 = this.originalMargins;
        if (r1 == null) goto L15;
        if (this.anchorView == null) goto L10;
        int r2 = this.extraBottomMarginAnchorView;
    L11:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r0;
        r3.bottomMargin = r1.bottom + r2;
        r3.leftMargin = r1.left + this.extraLeftMarginWindowInset;
        r3.rightMargin = r1.right + this.extraRightMarginWindowInset;
        this.view.requestLayout();
        if (shouldUpdateGestureInset() == false) goto L17;
        this.view.removeCallbacks(this.bottomMarginGestureInsetRunnable);
        this.view.post(this.bottomMarginGestureInsetRunnable);
        return;
    L17:
        return;
    L10:
        r2 = this.extraBottomMarginWindowInset;
    L15:
        Log.w(TAG, "Unable to update margins because layout params are not MarginLayoutParams");
    }

    @NonNull
    public B addCallback(@Nullable BaseCallback<B> r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        if (this.callbacks != null) goto L7;
        this.callbacks = new ArrayList();
    L7:
        this.callbacks.add(r2);
        return this;
    }

    public void animateViewIn() {
        this.view.post(new AnonymousClass9(this));
    }

    public void dismiss() {
        dispatchDismiss(3);
    }

    public void dispatchDismiss(int r2) {
        SnackbarManager.getInstance().dismiss(this.managerCallback, r2);
    }

    @Nullable
    public View getAnchorView() {
        return this.anchorView;
    }

    public int getAnimationMode() {
        return this.view.getAnimationMode();
    }

    public Behavior getBehavior() {
        return this.behavior;
    }

    @NonNull
    public Context getContext() {
        return this.context;
    }

    public int getDuration() {
        return this.duration;
    }

    @NonNull
    public SwipeDismissBehavior<? extends View> getNewBehavior() {
        return new Behavior();
    }

    @LayoutRes
    public int getSnackbarBaseLayoutResId() {
        if (hasSnackbarStyleAttr() == false) goto L6;
        return R.layout.mtrl_layout_snackbar;
    L6:
        return R.layout.design_layout_snackbar;
    }

    @NonNull
    public View getView() {
        return this.view;
    }

    public boolean hasSnackbarStyleAttr() {
        TypedArray r3 = this.context.obtainStyledAttributes(SNACKBAR_STYLE_ATTR);
        int r2 = r3.getResourceId(0, -1);
        r3.recycle();
        if (r2 == (-1)) goto L6;
        return true;
    L6:
        return false;
    }

    public final void hideView(int r2) {
        if (shouldAnimate() == true) goto L5;
    L7:
        onViewHidden(r2);
        return;
    L5:
        if (this.view.getVisibility() != 0) goto L7;
        animateViewOut(r2);
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isShown() {
        return SnackbarManager.getInstance().isCurrent(this.managerCallback);
    }

    public boolean isShownOrQueued() {
        return SnackbarManager.getInstance().isCurrentOrNext(this.managerCallback);
    }

    public void onViewHidden(int r3) {
        SnackbarManager.getInstance().onDismissed(this.managerCallback);
        List<BaseCallback<B>> r0 = this.callbacks;
        if (r0 == null) goto L7;
        int r1 = r0.size() - 1;
    L5:
        if (r1 < 0) goto L7;
        this.callbacks.get(r1).onDismissed(this, r3);
        r1 = r1 - 1;
    L7:
        ViewParent r4 = this.view.getParent();
        if ((r4 instanceof ViewGroup) == false) goto L12;
        ((ViewGroup) r4).removeView(this.view);
        return;
    }

    public void onViewShown() {
        SnackbarManager.getInstance().onShown(this.managerCallback);
        List<BaseCallback<B>> r0 = this.callbacks;
        if (r0 == null) goto L7;
        int r1 = r0.size() - 1;
    L5:
        if (r1 < 0) goto L9;
        this.callbacks.get(r1).onShown(this);
        r1 = r1 - 1;
        goto L5
    L9:
        return;
    }

    @NonNull
    public B removeCallback(@Nullable BaseCallback<B> r2) {
        if (r2 != null) goto L4;
        return this;
    L4:
        List<BaseCallback<B>> r0 = this.callbacks;
        if (r0 != null) goto L7;
        return this;
    L7:
        r0.remove(r2);
        return this;
    }

    @NonNull
    public B setAnchorView(@Nullable View r1) {
        this.anchorView = r1;
        return this;
    }

    @NonNull
    public B setAnimationMode(int r2) {
        this.view.setAnimationMode(r2);
        return this;
    }

    @NonNull
    public B setBehavior(Behavior r1) {
        this.behavior = r1;
        return this;
    }

    @NonNull
    public B setDuration(int r1) {
        this.duration = r1;
        return this;
    }

    @NonNull
    public B setGestureInsetBottomIgnored(boolean r1) {
        this.gestureInsetBottomIgnored = r1;
        return this;
    }

    public boolean shouldAnimate() {
        List<AccessibilityServiceInfo> r1 = this.accessibilityManager.getEnabledAccessibilityServiceList(1);
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.isEmpty() == false) goto L7;
        return true;
    }

    public void show() {
        SnackbarManager.getInstance().show(getDuration(), this.managerCallback);
    }

    public final void showView() {
        this.view.setOnAttachStateChangeListener(new AnonymousClass6(this));
        if (this.view.getParent() != null) goto L9;
        ViewGroup.LayoutParams r0 = this.view.getLayoutParams();
        if ((r0 instanceof CoordinatorLayout.LayoutParams) == false) goto L7;
        setUpBehavior((CoordinatorLayout.LayoutParams) r0);
    L7:
        this.extraBottomMarginAnchorView = calculateBottomMarginForAnchorView();
        updateMargins();
        this.view.setVisibility(4);
        this.targetParent.addView(this.view);
    L9:
        if (ViewCompat.isLaidOut(this.view) == false) goto L12;
        showViewImpl();
        return;
    L12:
        this.view.setOnLayoutChangeListener(new AnonymousClass7(this));
    }

    @NonNull
    public B setAnchorView(@IdRes int r2) {
        View r0 = this.targetParent.findViewById(r2);
        this.anchorView = r0;
        if (r0 == null) goto L6;
        return this;
    L6:
        throw new IllegalArgumentException(a.e(r2, "Unable to find anchor view with id: "));
    }
}
