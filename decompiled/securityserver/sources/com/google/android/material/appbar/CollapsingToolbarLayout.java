package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    private static final int DEF_STYLE_RES = 0;

    @NonNull
    final CollapsingTextHelper collapsingTextHelper;
    private boolean collapsingTitleEnabled;

    @Nullable
    private Drawable contentScrim;
    int currentOffset;
    private boolean drawCollapsingTitle;
    private View dummyView;
    private int expandedMarginBottom;
    private int expandedMarginEnd;
    private int expandedMarginStart;
    private int expandedMarginTop;

    @Nullable
    WindowInsetsCompat lastInsets;
    private AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
    private boolean refreshToolbar;
    private int scrimAlpha;
    private long scrimAnimationDuration;
    private ValueAnimator scrimAnimator;
    private int scrimVisibleHeightTrigger;
    private boolean scrimsAreShown;

    @Nullable
    Drawable statusBarScrim;
    private final Rect tmpRect;

    @Nullable
    private Toolbar toolbar;

    @Nullable
    private View toolbarDirectChild;
    private int toolbarId;

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        int collapseMode;
        float parallaxMult;

        public LayoutParams(Context r4, AttributeSet r5) {
            super(r4, r5);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
            TypedArray r6 = r4.obtainStyledAttributes(r5, R.styleable.CollapsingToolbarLayout_Layout);
            this.collapseMode = r6.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            setParallaxMultiplier(r6.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, DEFAULT_PARALLAX_MULTIPLIER));
            r6.recycle();
        }

        public int getCollapseMode() {
            return this.collapseMode;
        }

        public float getParallaxMultiplier() {
            return this.parallaxMult;
        }

        public void setCollapseMode(int r1) {
            this.collapseMode = r1;
        }

        public void setParallaxMultiplier(float r1) {
            this.parallaxMult = r1;
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public LayoutParams(int r1, int r2, int r3) {
            super(r1, r2, r3);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams r1) {
            super(r1);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull FrameLayout.LayoutParams r1) {
            super(r1);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }
    }

    public class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        final /* synthetic */ CollapsingToolbarLayout this$0;

        public OffsetUpdateListener(CollapsingToolbarLayout r1) {
            this.this$0 = r1;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout r9, int r10) {
            CollapsingToolbarLayout r11 = this.this$0;
            r11.currentOffset = r10;
            WindowInsetsCompat r12 = r11.lastInsets;
            if (r12 == null) goto L5;
            int r13 = r12.getSystemWindowInsetTop();
        L6:
            int r1 = this.this$0.getChildCount();
            int r2 = 0;
        L7:
            if (r2 >= r1) goto L16;
            View r3 = this.this$0.getChildAt(r2);
            LayoutParams r4 = (LayoutParams) r3.getLayoutParams();
            ViewOffsetHelper r5 = CollapsingToolbarLayout.getViewOffsetHelper(r3);
            int r6 = r4.collapseMode;
            if (r6 != 1) goto L11;
            r5.setTopAndBottomOffset(MathUtils.clamp(-r10, 0, this.this$0.getMaxOffsetForPinChild(r3)));
        L15:
            r2 = r2 + 1;
            goto L7
        L11:
            if (r6 != 2) goto L15;
            r5.setTopAndBottomOffset(Math.round((-r10) * r4.parallaxMult));
            goto L15
        L16:
            this.this$0.updateScrimVisibility();
            CollapsingToolbarLayout r0 = this.this$0;
            if (r0.statusBarScrim == null) goto L20;
            if (r13 <= 0) goto L20;
            ViewCompat.postInvalidateOnAnimation(r0);
        L20:
            this.this$0.collapsingTextHelper.setExpansionFraction(Math.abs(r10) / ((this.this$0.getHeight() - ViewCompat.getMinimumHeight(this.this$0)) - r13));
            return;
        L5:
            r13 = 0;
            goto L6
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_CollapsingToolbar;
    }

    public CollapsingToolbarLayout(@NonNull Context r2) {
        this(r2, null);
    }

    private void animateScrim(int r4) {
        ensureToolbar();
        ValueAnimator r0 = this.scrimAnimator;
        if (r0 != null) goto L10;
        ValueAnimator r1 = new ValueAnimator();
        this.scrimAnimator = r1;
        r1.setDuration(this.scrimAnimationDuration);
        ValueAnimator r2 = this.scrimAnimator;
        if (r4 <= this.scrimAlpha) goto L7;
        TimeInterpolator r3 = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    L8:
        r2.setInterpolator(r3);
        this.scrimAnimator.addUpdateListener(new AnonymousClass2(this));
    L12:
        this.scrimAnimator.setIntValues(new int[]{this.scrimAlpha, r4});
        this.scrimAnimator.start();
        return;
    L7:
        r3 = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
        goto L8
    L10:
        if (r0.isRunning() == false) goto L12;
        this.scrimAnimator.cancel();
        goto L12
    }

    private void ensureToolbar() {
        if (this.refreshToolbar == true) goto L5;
        return;
    L5:
        Toolbar r0 = null;
        this.toolbar = null;
        this.toolbarDirectChild = null;
        int r1 = this.toolbarId;
        if (r1 == (-1)) goto L11;
        Toolbar r2 = (Toolbar) findViewById(r1);
        this.toolbar = r2;
        if (r2 == null) goto L11;
        this.toolbarDirectChild = findDirectChild(r2);
    L11:
        if (this.toolbar != null) goto L19;
        int r3 = getChildCount();
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L18;
        View r5 = getChildAt(r4);
        if ((r5 instanceof Toolbar) == true) goto L16;
        r4 = r4 + 1;
        goto L13
    L16:
        r0 = (Toolbar) r5;
    L18:
        this.toolbar = r0;
    L19:
        updateDummyView();
        this.refreshToolbar = false;
    }

    @NonNull
    private View findDirectChild(@NonNull View r3) {
        ViewParent r0 = r3.getParent();
    L3:
        if (r0 == this) goto L9;
        if (r0 == null) goto L9;
        if ((r0 instanceof View) == false) goto L8;
        r3 = r0;
    L8:
        r0 = r0.getParent();
    L9:
        return r3;
    }

    private static int getHeightWithMargins(@NonNull View r2) {
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        return (r2.getHeight() + r1.topMargin) + r1.bottomMargin;
    L7:
        return r2.getHeight();
    }

    @NonNull
    public static ViewOffsetHelper getViewOffsetHelper(@NonNull View r2) {
        ViewOffsetHelper r0 = (ViewOffsetHelper) r2.getTag(R.id.view_offset_helper);
        if (r0 != null) goto L6;
        ViewOffsetHelper r1 = new ViewOffsetHelper(r2);
        r2.setTag(R.id.view_offset_helper, r1);
        return r1;
    L6:
        return r0;
    }

    private boolean isToolbarChild(View r4) {
        View r0 = this.toolbarDirectChild;
        if (r0 == null) goto L9;
        if (r0 == this) goto L9;
        if (r4 == r0) goto L12;
        return false;
    L12:
        return true;
    L9:
        if (r4 == this.toolbar) goto L12;
        return false;
    }

    private void updateContentDescriptionFromTitle() {
        setContentDescription(getTitle());
    }

    private void updateDummyView() {
        if (this.collapsingTitleEnabled == true) goto L10;
        View r0 = this.dummyView;
        if (r0 == null) goto L10;
        ViewParent r1 = r0.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L10;
        ((ViewGroup) r1).removeView(this.dummyView);
    L10:
        if (this.collapsingTitleEnabled == true) goto L12;
        return;
    L12:
        if (this.toolbar != null) goto L14;
        return;
    L14:
        if (this.dummyView != null) goto L17;
        this.dummyView = new View(getContext());
    L17:
        if (this.dummyView.getParent() != null) goto L22;
        this.toolbar.addView(this.dummyView, -1, -1);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r7) {
        super.draw(r7);
        ensureToolbar();
        if (this.toolbar != null) goto L10;
        Drawable r0 = this.contentScrim;
        if (r0 == null) goto L10;
        if (this.scrimAlpha <= 0) goto L10;
        r0.mutate().setAlpha(this.scrimAlpha);
        this.contentScrim.draw(r7);
    L10:
        if (this.collapsingTitleEnabled == false) goto L15;
        if (this.drawCollapsingTitle == false) goto L15;
        this.collapsingTextHelper.draw(r7);
    L15:
        if (this.statusBarScrim != null) goto L17;
        return;
    L17:
        if (this.scrimAlpha <= 0) goto L26;
        WindowInsetsCompat r1 = this.lastInsets;
        if (r1 == null) goto L21;
        int r2 = r1.getSystemWindowInsetTop();
    L22:
        if (r2 <= 0) goto L27;
        this.statusBarScrim.setBounds(0, -this.currentOffset, getWidth(), r2 - this.currentOffset);
        this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
        this.statusBarScrim.draw(r7);
        return;
    L27:
        return;
    L21:
        r2 = 0;
        goto L22
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r5, View r6, long r7) {
        if (this.contentScrim != null) goto L5;
    L9:
        boolean r0 = false;
    L11:
        if (super.drawChild(r5, r6, r7) == true) goto L16;
        if (r0 == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return true;
    L5:
        if (this.scrimAlpha <= 0) goto L9;
        if (isToolbarChild(r6) == false) goto L9;
        this.contentScrim.mutate().setAlpha(this.scrimAlpha);
        this.contentScrim.draw(r5);
        r0 = true;
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r0 = getDrawableState();
        Drawable r1 = this.statusBarScrim;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        Drawable r3 = this.contentScrim;
        if (r3 != null) goto L11;
    L13:
        CollapsingTextHelper r4 = this.collapsingTextHelper;
        if (r4 == null) goto L16;
        r2 = r2 | r4.setState(r0);
    L16:
        if (r2 == false) goto L19;
        invalidate();
        return;
    L19:
        return;
    L11:
        if (r3.isStateful() == false) goto L13;
        r2 = r2 | r3.setState(r0);
        goto L13
    L5:
        if (r1.isStateful() == false) goto L7;
        r2 = r1.setState(r0);
        goto L8
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    public int getCollapsedTitleGravity() {
        return this.collapsingTextHelper.getCollapsedTextGravity();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.collapsingTextHelper.getCollapsedTypeface();
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.contentScrim;
    }

    public int getExpandedTitleGravity() {
        return this.collapsingTextHelper.getExpandedTextGravity();
    }

    public int getExpandedTitleMarginBottom() {
        return this.expandedMarginBottom;
    }

    public int getExpandedTitleMarginEnd() {
        return this.expandedMarginEnd;
    }

    public int getExpandedTitleMarginStart() {
        return this.expandedMarginStart;
    }

    public int getExpandedTitleMarginTop() {
        return this.expandedMarginTop;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.collapsingTextHelper.getExpandedTypeface();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.collapsingTextHelper.getMaxLines();
    }

    public final int getMaxOffsetForPinChild(@NonNull View r3) {
        ViewOffsetHelper r0 = getViewOffsetHelper(r3);
        LayoutParams r1 = (LayoutParams) r3.getLayoutParams();
        return ((getHeight() - r0.getLayoutTop()) - r3.getHeight()) - ((FrameLayout.LayoutParams) r1).bottomMargin;
    }

    public int getScrimAlpha() {
        return this.scrimAlpha;
    }

    public long getScrimAnimationDuration() {
        return this.scrimAnimationDuration;
    }

    public int getScrimVisibleHeightTrigger() {
        int r0 = this.scrimVisibleHeightTrigger;
        if (r0 < 0) goto L5;
        return r0;
    L5:
        WindowInsetsCompat r1 = this.lastInsets;
        if (r1 == null) goto L8;
        int r2 = r1.getSystemWindowInsetTop();
    L9:
        int r3 = ViewCompat.getMinimumHeight(this);
        if (r3 <= 0) goto L14;
        return Math.min((r3 * 2) + r2, getHeight());
    L14:
        return getHeight() / 3;
    L8:
        r2 = 0;
        goto L9
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.statusBarScrim;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.collapsingTitleEnabled == true) goto L7;
        return null;
    L7:
        return this.collapsingTextHelper.getText();
    }

    public boolean isTitleEnabled() {
        return this.collapsingTitleEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object r0 = getParent();
        if ((r0 instanceof AppBarLayout) == false) goto L9;
        ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View) r0));
        if (this.onOffsetChangedListener != null) goto L7;
        this.onOffsetChangedListener = new OffsetUpdateListener(this);
    L7:
        ((AppBarLayout) r0).addOnOffsetChangedListener(this.onOffsetChangedListener);
        ViewCompat.requestApplyInsets(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewParent r0 = getParent();
        AppBarLayout.OnOffsetChangedListener r1 = this.onOffsetChangedListener;
        if (r1 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if ((r0 instanceof AppBarLayout) == false) goto L7;
        ((AppBarLayout) r0).removeOnOffsetChangedListener(r1);
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        super.onLayout(r8, r9, r10, r11, r12);
        WindowInsetsCompat r13 = this.lastInsets;
        int r0 = 0;
        if (r13 == null) goto L12;
        int r14 = r13.getSystemWindowInsetTop();
        int r1 = getChildCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L12;
        View r3 = getChildAt(r2);
        if (ViewCompat.getFitsSystemWindows(r3) == true) goto L11;
        if (r3.getTop() >= r14) goto L11;
        ViewCompat.offsetTopAndBottom(r3, r14);
    L11:
        r2 = r2 + 1;
    L12:
        int r15 = getChildCount();
        int r4 = 0;
    L13:
        if (r4 >= r15) goto L16;
        getViewOffsetHelper(getChildAt(r4)).onViewLayout();
        r4 = r4 + 1;
        goto L13
    L16:
        if (this.collapsingTitleEnabled == false) goto L53;
        View r16 = this.dummyView;
        if (r16 == null) goto L53;
        boolean r5 = true;
        if (ViewCompat.isAttachedToWindow(r16) == true) goto L22;
    L24:
        boolean r17 = false;
    L25:
        this.drawCollapsingTitle = r17;
        if (r17 == false) goto L53;
        if (ViewCompat.getLayoutDirection(this) == 1) goto L31;
        r5 = false;
    L31:
        View r18 = this.toolbarDirectChild;
        if (r18 != null) goto L35;
        r18 = this.toolbar;
    L35:
        int r19 = getMaxOffsetForPinChild(r18);
        DescendantOffsetUtils.getDescendantRect(this, this.dummyView, this.tmpRect);
        CollapsingTextHelper r6 = this.collapsingTextHelper;
        int r7 = this.tmpRect.left;
        if (r5 == false) goto L38;
        int r20 = this.toolbar.getTitleMarginEnd();
    L39:
        int r21 = r7 + r20;
        int r22 = this.toolbar.getTitleMarginTop() + (this.tmpRect.top + r19);
        int r23 = this.tmpRect.right;
        if (r5 == false) goto L42;
        int r24 = this.toolbar.getTitleMarginStart();
    L43:
        r6.setCollapsedBounds(r21, r22, r23 - r24, (this.tmpRect.bottom + r19) - this.toolbar.getTitleMarginBottom());
        CollapsingTextHelper r25 = this.collapsingTextHelper;
        if (r5 == false) goto L46;
        int r26 = this.expandedMarginEnd;
    L47:
        int r27 = this.tmpRect.top + this.expandedMarginTop;
        int r110 = r11 - r9;
        if (r5 == false) goto L50;
        int r28 = this.expandedMarginStart;
    L51:
        r25.setExpandedBounds(r26, r27, r110 - r28, (r12 - r10) - this.expandedMarginBottom);
        this.collapsingTextHelper.recalculate();
        goto L53
    L50:
        r28 = this.expandedMarginEnd;
        goto L51
    L46:
        r26 = this.expandedMarginStart;
        goto L47
    L42:
        r24 = this.toolbar.getTitleMarginEnd();
        goto L43
    L38:
        r20 = this.toolbar.getTitleMarginStart();
        goto L39
    L22:
        if (this.dummyView.getVisibility() != 0) goto L24;
        r17 = true;
    L53:
        if (this.toolbar != null) goto L55;
    L65:
        updateScrimVisibility();
        int r29 = getChildCount();
    L66:
        if (r0 >= r29) goto L68;
        getViewOffsetHelper(getChildAt(r0)).applyOffsets();
        r0 = r0 + 1;
        goto L66
    L68:
        return;
    L55:
        if (this.collapsingTitleEnabled == true) goto L57;
    L59:
        View r30 = this.toolbarDirectChild;
        if (r30 == null) goto L64;
        if (r30 == this) goto L64;
        setMinimumHeight(getHeightWithMargins(r30));
    L64:
        setMinimumHeight(getHeightWithMargins(this.toolbar));
        goto L65
    L57:
        if (TextUtils.isEmpty(this.collapsingTextHelper.getText()) == false) goto L59;
        setTitle(this.toolbar.getTitle());
        goto L59
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r2, int r3) {
        ensureToolbar();
        super.onMeasure(r2, r3);
        int r4 = View.MeasureSpec.getMode(r3);
        WindowInsetsCompat r0 = this.lastInsets;
        if (r0 == null) goto L5;
        int r1 = r0.getSystemWindowInsetTop();
    L6:
        if (r4 != 0) goto L10;
        if (r1 <= 0) goto L11;
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + r1, BasicMeasure.EXACTLY));
        return;
    L11:
        return;
    L10:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        Drawable r0 = this.contentScrim;
        if (r0 == null) goto L6;
        r0.setBounds(0, 0, r1, r2);
        return;
    }

    public WindowInsetsCompat onWindowInsetChanged(@NonNull WindowInsetsCompat r3) {
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L5;
        WindowInsetsCompat r0 = r3;
    L7:
        if (ObjectsCompat.equals(this.lastInsets, r0) == true) goto L10;
        this.lastInsets = r0;
        requestLayout();
    L10:
        return r3.consumeSystemWindowInsets();
    L5:
        r0 = null;
        goto L7
    }

    public void setCollapsedTitleGravity(int r1) {
        this.collapsingTextHelper.setCollapsedTextGravity(r1);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int r1) {
        this.collapsingTextHelper.setCollapsedTextAppearance(r1);
    }

    public void setCollapsedTitleTextColor(@ColorInt int r1) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(r1));
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface r1) {
        this.collapsingTextHelper.setCollapsedTypeface(r1);
    }

    public void setContentScrim(@Nullable Drawable r4) {
        Drawable r0 = this.contentScrim;
        if (r0 == r4) goto L14;
        Drawable r1 = null;
        if (r0 == null) goto L7;
        r0.setCallback(null);
    L7:
        if (r4 == null) goto L9;
        r1 = r4.mutate();
    L9:
        this.contentScrim = r1;
        if (r1 == null) goto L12;
        r1.setBounds(0, 0, getWidth(), getHeight());
        this.contentScrim.setCallback(this);
        this.contentScrim.setAlpha(this.scrimAlpha);
    L12:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public void setContentScrimColor(@ColorInt int r2) {
        setContentScrim(new ColorDrawable(r2));
    }

    public void setContentScrimResource(@DrawableRes int r2) {
        setContentScrim(ContextCompat.getDrawable(getContext(), r2));
    }

    public void setExpandedTitleColor(@ColorInt int r1) {
        setExpandedTitleTextColor(ColorStateList.valueOf(r1));
    }

    public void setExpandedTitleGravity(int r1) {
        this.collapsingTextHelper.setExpandedTextGravity(r1);
    }

    public void setExpandedTitleMargin(int r1, int r2, int r3, int r4) {
        this.expandedMarginStart = r1;
        this.expandedMarginTop = r2;
        this.expandedMarginEnd = r3;
        this.expandedMarginBottom = r4;
        requestLayout();
    }

    public void setExpandedTitleMarginBottom(int r1) {
        this.expandedMarginBottom = r1;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int r1) {
        this.expandedMarginEnd = r1;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int r1) {
        this.expandedMarginStart = r1;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int r1) {
        this.expandedMarginTop = r1;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int r1) {
        this.collapsingTextHelper.setExpandedTextAppearance(r1);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList r1) {
        this.collapsingTextHelper.setExpandedTextColor(r1);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface r1) {
        this.collapsingTextHelper.setExpandedTypeface(r1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int r1) {
        this.collapsingTextHelper.setMaxLines(r1);
    }

    public void setScrimAlpha(int r2) {
        if (r2 != this.scrimAlpha) goto L5;
        return;
    L5:
        if (this.contentScrim == null) goto L9;
        Toolbar r0 = this.toolbar;
        if (r0 == null) goto L9;
        ViewCompat.postInvalidateOnAnimation(r0);
    L9:
        this.scrimAlpha = r2;
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long r1) {
        this.scrimAnimationDuration = r1;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int r2) {
        if (this.scrimVisibleHeightTrigger == r2) goto L6;
        this.scrimVisibleHeightTrigger = r2;
        updateScrimVisibility();
        return;
    }

    public void setScrimsShown(boolean r2) {
        if (ViewCompat.isLaidOut(this) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        setScrimsShown(r2, r0);
        return;
    L5:
        if (isInEditMode() == true) goto L7;
        r0 = true;
        goto L8
    }

    public void setStatusBarScrim(@Nullable Drawable r3) {
        Drawable r0 = this.statusBarScrim;
        if (r0 == r3) goto L21;
        Drawable r1 = null;
        if (r0 == null) goto L7;
        r0.setCallback(null);
    L7:
        if (r3 == null) goto L9;
        r1 = r3.mutate();
    L9:
        this.statusBarScrim = r1;
        if (r1 != null) goto L12;
    L19:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L12:
        if (r1.isStateful() == false) goto L14;
        this.statusBarScrim.setState(getDrawableState());
    L14:
        DrawableCompat.setLayoutDirection(this.statusBarScrim, ViewCompat.getLayoutDirection(this));
        Drawable r4 = this.statusBarScrim;
        if (getVisibility() != 0) goto L17;
        boolean r2 = true;
    L18:
        r4.setVisible(r2, false);
        this.statusBarScrim.setCallback(this);
        this.statusBarScrim.setAlpha(this.scrimAlpha);
        goto L19
    L17:
        r2 = false;
        goto L18
    }

    public void setStatusBarScrimColor(@ColorInt int r2) {
        setStatusBarScrim(new ColorDrawable(r2));
    }

    public void setStatusBarScrimResource(@DrawableRes int r2) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), r2));
    }

    public void setTitle(@Nullable CharSequence r2) {
        this.collapsingTextHelper.setText(r2);
        updateContentDescriptionFromTitle();
    }

    public void setTitleEnabled(boolean r2) {
        if (r2 == this.collapsingTitleEnabled) goto L6;
        this.collapsingTitleEnabled = r2;
        updateContentDescriptionFromTitle();
        updateDummyView();
        requestLayout();
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        super.setVisibility(r3);
        if (r3 != 0) goto L5;
        boolean r4 = true;
    L6:
        Drawable r1 = this.statusBarScrim;
        if (r1 != null) goto L9;
    L11:
        Drawable r2 = this.contentScrim;
        if (r2 != null) goto L14;
        return;
    L14:
        if (r2.isVisible() == r4) goto L18;
        this.contentScrim.setVisible(r4, false);
        return;
    L18:
        return;
    L9:
        if (r1.isVisible() == r4) goto L11;
        this.statusBarScrim.setVisible(r4, false);
        goto L11
    L5:
        r4 = false;
        goto L6
    }

    public final void updateScrimVisibility() {
        if (this.contentScrim != null) goto L7;
        if (this.statusBarScrim != null) goto L7;
        return;
    L7:
        if ((getHeight() + this.currentOffset) >= getScrimVisibleHeightTrigger()) goto L9;
        boolean r0 = true;
    L10:
        setScrimsShown(r0);
        return;
    L9:
        r0 = false;
        goto L10
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable r2) {
        if (super.verifyDrawable(r2) == false) goto L5;
    L10:
        return true;
    L5:
        if (r2 == this.contentScrim) goto L10;
        if (r2 == this.statusBarScrim) goto L10;
        return false;
    }

    public CollapsingToolbarLayout(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList r1) {
        this.collapsingTextHelper.setCollapsedTextColor(r1);
    }

    public void setScrimsShown(boolean r3, boolean r4) {
        if (this.scrimsAreShown == r3) goto L14;
        int r0 = 0;
        if (r4 == false) goto L9;
        if (r3 == false) goto L8;
        r0 = 255;
    L8:
        animateScrim(r0);
    L12:
        this.scrimsAreShown = r3;
        return;
    L9:
        if (r3 == false) goto L11;
        r0 = 255;
    L11:
        setScrimAlpha(r0);
        goto L12
    }

    public CollapsingToolbarLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r4), r11, r12);
        this.refreshToolbar = true;
        this.tmpRect = new Rect();
        this.scrimVisibleHeightTrigger = -1;
        Context r0 = getContext();
        CollapsingTextHelper r7 = new CollapsingTextHelper(this);
        this.collapsingTextHelper = r7;
        r7.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(r0, r11, R.styleable.CollapsingToolbarLayout, r12, r4, new int[0]);
        r7.setExpandedTextGravity(r13.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, BadgeDrawable.BOTTOM_START));
        r7.setCollapsedTextGravity(r13.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int r14 = r13.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.expandedMarginBottom = r14;
        this.expandedMarginEnd = r14;
        this.expandedMarginTop = r14;
        this.expandedMarginStart = r14;
        if (r13.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart) == false) goto L6;
        this.expandedMarginStart = r13.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
    L6:
        if (r13.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd) == false) goto L9;
        this.expandedMarginEnd = r13.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
    L9:
        if (r13.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop) == false) goto L12;
        this.expandedMarginTop = r13.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
    L12:
        if (r13.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom) == false) goto L14;
        this.expandedMarginBottom = r13.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
    L14:
        this.collapsingTitleEnabled = r13.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(r13.getText(R.styleable.CollapsingToolbarLayout_title));
        r7.setExpandedTextAppearance(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        r7.setCollapsedTextAppearance(androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (r13.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance) == false) goto L18;
        r7.setExpandedTextAppearance(r13.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
    L18:
        if (r13.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance) == false) goto L20;
        r7.setCollapsedTextAppearance(r13.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
    L20:
        this.scrimVisibleHeightTrigger = r13.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        if (r13.hasValue(R.styleable.CollapsingToolbarLayout_maxLines) == false) goto L23;
        r7.setMaxLines(r13.getInt(R.styleable.CollapsingToolbarLayout_maxLines, 1));
    L23:
        this.scrimAnimationDuration = r13.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(r13.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(r13.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        this.toolbarId = r13.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        r13.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1(this));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
    }
}
