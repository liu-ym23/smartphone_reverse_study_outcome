package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
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
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    private static final int DEF_STYLE_RES = 0;
    public static final int TITLE_COLLAPSE_MODE_FADE = 1;
    public static final int TITLE_COLLAPSE_MODE_SCALE = 0;

    @NonNull
    final CollapsingTextHelper collapsingTextHelper;
    private boolean collapsingTitleEnabled;

    @Nullable
    private Drawable contentScrim;
    int currentOffset;
    private boolean drawCollapsingTitle;
    private View dummyView;

    @NonNull
    final ElevationOverlayProvider elevationOverlayProvider;
    private int expandedMarginBottom;
    private int expandedMarginEnd;
    private int expandedMarginStart;
    private int expandedMarginTop;
    private int extraMultilineHeight;
    private boolean extraMultilineHeightEnabled;
    private boolean forceApplySystemWindowInsetTop;

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
    private int titleCollapseMode;
    private final Rect tmpRect;

    @Nullable
    private ViewGroup toolbar;

    @Nullable
    private View toolbarDirectChild;
    private int toolbarId;
    private int topInsetApplied;

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        int collapseMode;
        float parallaxMult;

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(int r1, int r2, int r3) {
            super(r1, r2, r3);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(Context r4, AttributeSet r5) {
            super(r4, r5);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
            TypedArray r6 = r4.obtainStyledAttributes(r5, R.styleable.CollapsingToolbarLayout_Layout);
            this.collapseMode = r6.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            setParallaxMultiplier(r6.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            r6.recycle();
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams r1) {
            super(r1);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull FrameLayout.LayoutParams r1) {
            super(r1);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
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
    }

    private class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        final /* synthetic */ CollapsingToolbarLayout this$0;

        OffsetUpdateListener(CollapsingToolbarLayout r1) {
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
            if (r2 >= r1) goto L17;
            View r3 = this.this$0.getChildAt(r2);
            LayoutParams r4 = (LayoutParams) r3.getLayoutParams();
            ViewOffsetHelper r5 = CollapsingToolbarLayout.getViewOffsetHelper(r3);
            int r6 = r4.collapseMode;
            if (r6 != 1) goto L11;
            int r7 = MathUtils.clamp(-r10, 0, this.this$0.getMaxOffsetForPinChild(r3));
        L15:
            r5.setTopAndBottomOffset(r7);
        L16:
            r2 = r2 + 1;
            goto L7
        L11:
            if (r6 != 2) goto L16;
            r7 = Math.round((-r10) * r4.parallaxMult);
            goto L15
        L17:
            this.this$0.updateScrimVisibility();
            CollapsingToolbarLayout r0 = this.this$0;
            if (r0.statusBarScrim == null) goto L21;
            if (r13 <= 0) goto L21;
            ViewCompat.postInvalidateOnAnimation(r0);
        L21:
            int r8 = this.this$0.getHeight();
            int r14 = (r8 - ViewCompat.getMinimumHeight(this.this$0)) - r13;
            float r15 = r14;
            this.this$0.collapsingTextHelper.setFadeModeStartFraction(Math.min(1.0f, (r8 - this.this$0.getScrimVisibleHeightTrigger()) / r15));
            CollapsingToolbarLayout r16 = this.this$0;
            r16.collapsingTextHelper.setCurrentOffsetY(r16.currentOffset + r14);
            this.this$0.collapsingTextHelper.setExpansionFraction(Math.abs(r10) / r15);
            return;
        L5:
            r13 = 0;
            goto L6
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TitleCollapseMode {
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_CollapsingToolbar;
    }

    public CollapsingToolbarLayout(@NonNull Context r2) {
        this(r2, null);
    }

    public CollapsingToolbarLayout(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.collapsingToolbarLayoutStyle);
    }

    public CollapsingToolbarLayout(@NonNull Context r11, @Nullable AttributeSet r12, int r13) {
        int r4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r11, r12, r13, r4), r12, r13);
        this.refreshToolbar = true;
        this.tmpRect = new Rect();
        this.scrimVisibleHeightTrigger = -1;
        this.topInsetApplied = 0;
        this.extraMultilineHeight = 0;
        Context r8 = getContext();
        CollapsingTextHelper r9 = new CollapsingTextHelper(this);
        this.collapsingTextHelper = r9;
        r9.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
        r9.setRtlTextDirectionHeuristicsEnabled(false);
        this.elevationOverlayProvider = new ElevationOverlayProvider(r8);
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(r8, r12, R.styleable.CollapsingToolbarLayout, r13, r4, new int[0]);
        r9.setExpandedTextGravity(r14.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, BadgeDrawable.BOTTOM_START));
        r9.setCollapsedTextGravity(r14.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int r15 = r14.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.expandedMarginBottom = r15;
        this.expandedMarginEnd = r15;
        this.expandedMarginTop = r15;
        this.expandedMarginStart = r15;
        int r16 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart;
        if (r14.hasValue(r16) == false) goto L5;
        this.expandedMarginStart = r14.getDimensionPixelSize(r16, 0);
    L5:
        int r17 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd;
        if (r14.hasValue(r17) == false) goto L8;
        this.expandedMarginEnd = r14.getDimensionPixelSize(r17, 0);
    L8:
        int r18 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop;
        if (r14.hasValue(r18) == false) goto L11;
        this.expandedMarginTop = r14.getDimensionPixelSize(r18, 0);
    L11:
        int r19 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom;
        if (r14.hasValue(r19) == false) goto L14;
        this.expandedMarginBottom = r14.getDimensionPixelSize(r19, 0);
    L14:
        this.collapsingTitleEnabled = r14.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(r14.getText(R.styleable.CollapsingToolbarLayout_title));
        r9.setExpandedTextAppearance(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        r9.setCollapsedTextAppearance(androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        int r110 = R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance;
        if (r14.hasValue(r110) == false) goto L17;
        r9.setExpandedTextAppearance(r14.getResourceId(r110, 0));
    L17:
        int r111 = R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance;
        if (r14.hasValue(r111) == false) goto L20;
        r9.setCollapsedTextAppearance(r14.getResourceId(r111, 0));
    L20:
        int r112 = R.styleable.CollapsingToolbarLayout_expandedTitleTextColor;
        if (r14.hasValue(r112) == false) goto L23;
        r9.setExpandedTextColor(MaterialResources.getColorStateList(r8, r14, r112));
    L23:
        int r113 = R.styleable.CollapsingToolbarLayout_collapsedTitleTextColor;
        if (r14.hasValue(r113) == false) goto L26;
        r9.setCollapsedTextColor(MaterialResources.getColorStateList(r8, r14, r113));
    L26:
        this.scrimVisibleHeightTrigger = r14.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        int r114 = R.styleable.CollapsingToolbarLayout_maxLines;
        if (r14.hasValue(r114) == false) goto L29;
        r9.setMaxLines(r14.getInt(r114, 1));
    L29:
        int r115 = R.styleable.CollapsingToolbarLayout_titlePositionInterpolator;
        if (r14.hasValue(r115) == false) goto L32;
        r9.setPositionInterpolator(android.view.animation.AnimationUtils.loadInterpolator(r8, r14.getResourceId(r115, 0)));
    L32:
        this.scrimAnimationDuration = r14.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(r14.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(r14.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        setTitleCollapseMode(r14.getInt(R.styleable.CollapsingToolbarLayout_titleCollapseMode, 0));
        this.toolbarId = r14.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        this.forceApplySystemWindowInsetTop = r14.getBoolean(R.styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, false);
        this.extraMultilineHeightEnabled = r14.getBoolean(R.styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, false);
        r14.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1(this));
    }

    private void animateScrim(int r5) {
        ensureToolbar();
        ValueAnimator r0 = this.scrimAnimator;
        if (r0 != null) goto L10;
        ValueAnimator r1 = new ValueAnimator();
        this.scrimAnimator = r1;
        if (r5 <= this.scrimAlpha) goto L7;
        TimeInterpolator r2 = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    L8:
        r1.setInterpolator(r2);
        this.scrimAnimator.addUpdateListener(new AnonymousClass2(this));
    L12:
        this.scrimAnimator.setDuration(this.scrimAnimationDuration);
        this.scrimAnimator.setIntValues(new int[]{this.scrimAlpha, r5});
        this.scrimAnimator.start();
        return;
    L7:
        r2 = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
        goto L8
    L10:
        if (r0.isRunning() == false) goto L12;
        this.scrimAnimator.cancel();
        goto L12
    }

    private void disableLiftOnScrollIfNeeded(AppBarLayout r1) {
        if (isTitleCollapseFadeMode() == false) goto L6;
        r1.setLiftOnScroll(false);
        return;
    }

    private void ensureToolbar() {
        if (this.refreshToolbar == true) goto L5;
        return;
    L5:
        ViewGroup r0 = null;
        this.toolbar = null;
        this.toolbarDirectChild = null;
        int r1 = this.toolbarId;
        if (r1 == (-1)) goto L11;
        ViewGroup r2 = (ViewGroup) findViewById(r1);
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
        if (isToolbar(r5) == true) goto L16;
        r4 = r4 + 1;
        goto L13
    L16:
        r0 = (ViewGroup) r5;
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
        return (r2.getMeasuredHeight() + r1.topMargin) + r1.bottomMargin;
    L7:
        return r2.getMeasuredHeight();
    }

    private static CharSequence getToolbarTitle(View r2) {
        if ((r2 instanceof Toolbar) == false) goto L7;
        return ((Toolbar) r2).getTitle();
    L7:
        if (Build.VERSION.SDK_INT >= 21) goto L9;
        return null;
    L9:
        if ((r2 instanceof android.widget.Toolbar) == true) goto L11;
        return null;
    L11:
        return ((android.widget.Toolbar) r2).getTitle();
    }

    @NonNull
    static ViewOffsetHelper getViewOffsetHelper(@NonNull View r2) {
        int r0 = R.id.view_offset_helper;
        ViewOffsetHelper r1 = (ViewOffsetHelper) r2.getTag(r0);
        if (r1 != null) goto L6;
        ViewOffsetHelper r3 = new ViewOffsetHelper(r2);
        r2.setTag(r0, r3);
        return r3;
    L6:
        return r1;
    }

    private boolean isTitleCollapseFadeMode() {
        if (this.titleCollapseMode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static boolean isToolbar(View r2) {
        if ((r2 instanceof Toolbar) == false) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 21) goto L7;
    L9:
        return false;
    L7:
        if ((r2 instanceof android.widget.Toolbar) == false) goto L9;
        goto L9
    }

    private boolean isToolbarChild(View r4) {
        View r0 = this.toolbarDirectChild;
        if (r0 == null) goto L9;
        if (r0 == this) goto L9;
        if (r4 != r0) goto L12;
        return true;
    L12:
        return false;
    L9:
        if (r4 != this.toolbar) goto L12;
        return true;
    }

    private void updateCollapsedBounds(boolean r9) {
        View r0 = this.toolbarDirectChild;
        if (r0 != null) goto L6;
        r0 = this.toolbar;
    L6:
        int r1 = getMaxOffsetForPinChild(r0);
        DescendantOffsetUtils.getDescendantRect(this, this.dummyView, this.tmpRect);
        ViewGroup r2 = this.toolbar;
        int r3 = 0;
        if ((r2 instanceof Toolbar) == false) goto L10;
        Toolbar r4 = (Toolbar) r2;
        r3 = r4.getTitleMarginStart();
        int r5 = r4.getTitleMarginEnd();
        int r6 = r4.getTitleMarginTop();
        int r7 = r4.getTitleMarginBottom();
    L15:
        CollapsingTextHelper r8 = this.collapsingTextHelper;
        Rect r10 = this.tmpRect;
        int r11 = r10.left;
        if (r9 == false) goto L18;
        int r12 = r5;
    L19:
        int r13 = r11 + r12;
        int r14 = (r10.top + r1) + r6;
        int r15 = r10.right;
        if (r9 == true) goto L23;
        r3 = r5;
    L23:
        r8.setCollapsedBounds(r13, r14, r15 - r3, (r10.bottom + r1) - r7);
        return;
    L18:
        r12 = r3;
        goto L19
    L10:
        if (Build.VERSION.SDK_INT >= 24) goto L12;
    L14:
        r7 = 0;
        r5 = 0;
        r6 = 0;
        goto L15
    L12:
        if ((r2 instanceof android.widget.Toolbar) == false) goto L14;
        android.widget.Toolbar r16 = (android.widget.Toolbar) r2;
        r3 = r16.getTitleMarginStart();
        r5 = r16.getTitleMarginEnd();
        r6 = r16.getTitleMarginTop();
        r7 = r16.getTitleMarginBottom();
        goto L15
    }

    private void updateContentDescriptionFromTitle() {
        setContentDescription(getTitle());
    }

    private void updateContentScrimBounds(@NonNull Drawable r2, int r3, int r4) {
        updateContentScrimBounds(r2, this.toolbar, r3, r4);
    }

    private void updateContentScrimBounds(@NonNull Drawable r2, @Nullable View r3, int r4, int r5) {
        if (isTitleCollapseFadeMode() == false) goto L8;
        if (r3 == null) goto L8;
        if (this.collapsingTitleEnabled == false) goto L8;
        r5 = r3.getBottom();
    L8:
        r2.setBounds(0, 0, r4, r5);
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

    private void updateTextBounds(int r6, int r7, int r8, int r9, boolean r10) {
        if (this.collapsingTitleEnabled == false) goto L28;
        View r0 = this.dummyView;
        if (r0 == null) goto L29;
        boolean r1 = false;
        if (ViewCompat.isAttachedToWindow(r0) == true) goto L9;
    L11:
        boolean r2 = false;
    L12:
        this.drawCollapsingTitle = r2;
        if (r2 == true) goto L16;
        if (r10 == true) goto L16;
        return;
    L16:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L18;
        r1 = true;
    L18:
        updateCollapsedBounds(r1);
        CollapsingTextHelper r3 = this.collapsingTextHelper;
        if (r1 == false) goto L21;
        int r4 = this.expandedMarginEnd;
    L22:
        int r5 = this.tmpRect.top + this.expandedMarginTop;
        int r11 = r8 - r6;
        if (r1 == false) goto L25;
        int r12 = this.expandedMarginStart;
    L26:
        r3.setExpandedBounds(r4, r5, r11 - r12, (r9 - r7) - this.expandedMarginBottom);
        this.collapsingTextHelper.recalculate(r10);
        return;
    L25:
        r12 = this.expandedMarginEnd;
        goto L26
    L21:
        r4 = this.expandedMarginStart;
        goto L22
    L9:
        if (this.dummyView.getVisibility() != 0) goto L11;
        r2 = true;
        goto L12
    L29:
        return;
    }

    private void updateTitleFromToolbarIfNeeded() {
        if (this.toolbar != null) goto L5;
        return;
    L5:
        if (this.collapsingTitleEnabled == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.collapsingTextHelper.getText()) == false) goto L12;
        setTitle(getToolbarTitle(this.toolbar));
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
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
        if (this.collapsingTitleEnabled == false) goto L26;
        if (this.drawCollapsingTitle == false) goto L26;
        if (this.toolbar != null) goto L16;
    L24:
        this.collapsingTextHelper.draw(r7);
        goto L26
    L16:
        if (this.contentScrim == null) goto L24;
        if (this.scrimAlpha <= 0) goto L24;
        if (isTitleCollapseFadeMode() == false) goto L24;
        if (this.collapsingTextHelper.getExpansionFraction() >= this.collapsingTextHelper.getFadeModeThresholdFraction()) goto L24;
        int r1 = r7.save();
        r7.clipRect(this.contentScrim.getBounds(), Region.Op.DIFFERENCE);
        this.collapsingTextHelper.draw(r7);
        r7.restoreToCount(r1);
    L26:
        if (this.statusBarScrim != null) goto L28;
        return;
    L28:
        if (this.scrimAlpha <= 0) goto L37;
        WindowInsetsCompat r2 = this.lastInsets;
        if (r2 == null) goto L32;
        int r3 = r2.getSystemWindowInsetTop();
    L33:
        if (r3 <= 0) goto L38;
        this.statusBarScrim.setBounds(0, -this.currentOffset, getWidth(), r3 - this.currentOffset);
        this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
        this.statusBarScrim.draw(r7);
        return;
    L38:
        return;
    L32:
        r3 = 0;
        goto L33
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas r6, View r7, long r8) {
        if (this.contentScrim != null) goto L5;
    L9:
        boolean r0 = false;
    L11:
        if (super.drawChild(r6, r7, r8) == true) goto L16;
        if (r0 == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return true;
    L5:
        if (this.scrimAlpha <= 0) goto L9;
        if (isToolbarChild(r7) == false) goto L9;
        updateContentScrimBounds(this.contentScrim, r7, getWidth(), getHeight());
        this.contentScrim.mutate().setAlpha(this.scrimAlpha);
        this.contentScrim.draw(r6);
        r0 = true;
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r0 = getDrawableState();
        Drawable r1 = this.statusBarScrim;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        Drawable r3 = this.contentScrim;
        if (r3 != null) goto L10;
    L12:
        CollapsingTextHelper r4 = this.collapsingTextHelper;
        if (r4 == null) goto L15;
        r2 = r2 | r4.setState(r0);
    L15:
        if (r2 == false) goto L18;
        invalidate();
        return;
    L18:
        return;
    L10:
        if (r3.isStateful() == false) goto L12;
        r2 = r2 | r3.setState(r0);
        goto L12
    L5:
        if (r1.isStateful() == false) goto L7;
        r2 = false | r1.setState(r0);
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
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

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getHyphenationFrequency() {
        return this.collapsingTextHelper.getHyphenationFrequency();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLineCount() {
        return this.collapsingTextHelper.getLineCount();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingAdd() {
        return this.collapsingTextHelper.getLineSpacingAdd();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingMultiplier() {
        return this.collapsingTextHelper.getLineSpacingMultiplier();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.collapsingTextHelper.getMaxLines();
    }

    final int getMaxOffsetForPinChild(@NonNull View r3) {
        ViewOffsetHelper r0 = getViewOffsetHelper(r3);
        LayoutParams r1 = (LayoutParams) r3.getLayoutParams();
        return ((getHeight() - r0.getLayoutTop()) - r3.getHeight()) - ((FrameLayout.LayoutParams) r1).bottomMargin;
    }

    int getScrimAlpha() {
        return this.scrimAlpha;
    }

    public long getScrimAnimationDuration() {
        return this.scrimAnimationDuration;
    }

    public int getScrimVisibleHeightTrigger() {
        int r0 = this.scrimVisibleHeightTrigger;
        if (r0 >= 0) goto L5;
        WindowInsetsCompat r1 = this.lastInsets;
        if (r1 == null) goto L9;
        int r2 = r1.getSystemWindowInsetTop();
    L10:
        int r3 = ViewCompat.getMinimumHeight(this);
        if (r3 <= 0) goto L15;
        return Math.min((r3 * 2) + r2, getHeight());
    L15:
        return getHeight() / 3;
    L9:
        r2 = 0;
        goto L10
    L5:
        return (r0 + this.topInsetApplied) + this.extraMultilineHeight;
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

    public int getTitleCollapseMode() {
        return this.titleCollapseMode;
    }

    @Nullable
    public TimeInterpolator getTitlePositionInterpolator() {
        return this.collapsingTextHelper.getPositionInterpolator();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isExtraMultilineHeightEnabled() {
        return this.extraMultilineHeightEnabled;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isForceApplySystemWindowInsetTop() {
        return this.forceApplySystemWindowInsetTop;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.collapsingTextHelper.isRtlTextDirectionHeuristicsEnabled();
    }

    public boolean isTitleEnabled() {
        return this.collapsingTitleEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r0 = getParent();
        if ((r0 instanceof AppBarLayout) == false) goto L9;
        AppBarLayout r1 = (AppBarLayout) r0;
        disableLiftOnScrollIfNeeded(r1);
        ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows(r1));
        if (this.onOffsetChangedListener != null) goto L7;
        this.onOffsetChangedListener = new OffsetUpdateListener(this);
    L7:
        r1.addOnOffsetChangedListener(this.onOffsetChangedListener);
        ViewCompat.requestApplyInsets(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
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
    protected void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
        super.onLayout(r9, r10, r11, r12, r13);
        WindowInsetsCompat r14 = this.lastInsets;
        int r0 = 0;
        if (r14 == null) goto L12;
        int r15 = r14.getSystemWindowInsetTop();
        int r1 = getChildCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L12;
        View r3 = getChildAt(r2);
        if (ViewCompat.getFitsSystemWindows(r3) == true) goto L11;
        if (r3.getTop() >= r15) goto L11;
        ViewCompat.offsetTopAndBottom(r3, r15);
    L11:
        r2 = r2 + 1;
    L12:
        int r16 = getChildCount();
        int r4 = 0;
    L13:
        if (r4 >= r16) goto L15;
        getViewOffsetHelper(getChildAt(r4)).onViewLayout();
        r4 = r4 + 1;
        goto L13
    L15:
        updateTextBounds(r10, r11, r12, r13, false);
        updateTitleFromToolbarIfNeeded();
        updateScrimVisibility();
        int r17 = getChildCount();
    L16:
        if (r0 >= r17) goto L18;
        getViewOffsetHelper(getChildAt(r0)).applyOffsets();
        r0 = r0 + 1;
        goto L16
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r9, int r10) {
        ensureToolbar();
        super.onMeasure(r9, r10);
        int r11 = View.MeasureSpec.getMode(r10);
        WindowInsetsCompat r0 = this.lastInsets;
        if (r0 == null) goto L5;
        int r1 = r0.getSystemWindowInsetTop();
    L7:
        if (r11 != 0) goto L9;
    L10:
        if (r1 <= 0) goto L13;
        this.topInsetApplied = r1;
        super.onMeasure(r9, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + r1, BasicMeasure.EXACTLY));
    L13:
        if (this.extraMultilineHeightEnabled == true) goto L15;
    L19:
        ViewGroup r12 = this.toolbar;
        if (r12 == null) goto L29;
        View r13 = this.toolbarDirectChild;
        if (r13 == null) goto L26;
        if (r13 == this) goto L26;
        int r14 = getHeightWithMargins(r13);
    L27:
        setMinimumHeight(r14);
        return;
    L26:
        r14 = getHeightWithMargins(r12);
        goto L27
    L29:
        return;
    L15:
        if (this.collapsingTextHelper.getMaxLines() <= 1) goto L19;
        updateTitleFromToolbarIfNeeded();
        updateTextBounds(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
        int r15 = this.collapsingTextHelper.getExpandedLineCount();
        if (r15 <= 1) goto L19;
        this.extraMultilineHeight = Math.round(this.collapsingTextHelper.getExpandedTextFullHeight()) * (r15 - 1);
        super.onMeasure(r9, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.extraMultilineHeight, BasicMeasure.EXACTLY));
        goto L19
    L9:
        if (this.forceApplySystemWindowInsetTop == false) goto L13;
    L5:
        r1 = 0;
        goto L7
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        Drawable r5 = this.contentScrim;
        if (r5 == null) goto L6;
        updateContentScrimBounds(r5, r1, r2);
        return;
    }

    WindowInsetsCompat onWindowInsetChanged(@NonNull WindowInsetsCompat r3) {
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

    public void setCollapsedTitleTextColor(@NonNull ColorStateList r1) {
        this.collapsingTextHelper.setCollapsedTextColor(r1);
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface r1) {
        this.collapsingTextHelper.setCollapsedTypeface(r1);
    }

    public void setContentScrim(@Nullable Drawable r3) {
        Drawable r0 = this.contentScrim;
        if (r0 == r3) goto L14;
        Drawable r1 = null;
        if (r0 == null) goto L7;
        r0.setCallback(null);
    L7:
        if (r3 == null) goto L9;
        r1 = r3.mutate();
    L9:
        this.contentScrim = r1;
        if (r1 == null) goto L12;
        updateContentScrimBounds(r1, getWidth(), getHeight());
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
    public void setExtraMultilineHeightEnabled(boolean r1) {
        this.extraMultilineHeightEnabled = r1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceApplySystemWindowInsetTop(boolean r1) {
        this.forceApplySystemWindowInsetTop = r1;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHyphenationFrequency(int r1) {
        this.collapsingTextHelper.setHyphenationFrequency(r1);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingAdd(float r1) {
        this.collapsingTextHelper.setLineSpacingAdd(r1);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float r1) {
        this.collapsingTextHelper.setLineSpacingMultiplier(r1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int r1) {
        this.collapsingTextHelper.setMaxLines(r1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRtlTextDirectionHeuristicsEnabled(boolean r1) {
        this.collapsingTextHelper.setRtlTextDirectionHeuristicsEnabled(r1);
    }

    void setScrimAlpha(int r2) {
        if (r2 != this.scrimAlpha) goto L5;
        return;
    L5:
        if (this.contentScrim == null) goto L9;
        ViewGroup r0 = this.toolbar;
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

    public void setScrimsShown(boolean r3, boolean r4) {
        if (this.scrimsAreShown == r3) goto L16;
        int r0 = 255;
        if (r4 == false) goto L10;
        if (r3 == true) goto L9;
        r0 = 0;
    L9:
        animateScrim(r0);
    L14:
        this.scrimsAreShown = r3;
        return;
    L10:
        if (r3 == true) goto L13;
        r0 = 0;
    L13:
        setScrimAlpha(r0);
        goto L14
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

    public void setTitleCollapseMode(int r3) {
        this.titleCollapseMode = r3;
        boolean r4 = isTitleCollapseFadeMode();
        this.collapsingTextHelper.setFadeModeEnabled(r4);
        ViewParent r0 = getParent();
        if ((r0 instanceof AppBarLayout) == false) goto L5;
        disableLiftOnScrollIfNeeded((AppBarLayout) r0);
    L5:
        if (r4 == true) goto L7;
        return;
    L7:
        if (this.contentScrim != null) goto L11;
        float r5 = getResources().getDimension(R.dimen.design_appbar_elevation);
        setContentScrimColor(this.elevationOverlayProvider.compositeOverlayWithThemeSurfaceColorIfNeeded(r5));
        return;
    }

    public void setTitleEnabled(boolean r2) {
        if (r2 == this.collapsingTitleEnabled) goto L6;
        this.collapsingTitleEnabled = r2;
        updateContentDescriptionFromTitle();
        updateDummyView();
        requestLayout();
        return;
    }

    public void setTitlePositionInterpolator(@Nullable TimeInterpolator r1) {
        this.collapsingTextHelper.setPositionInterpolator(r1);
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

    final void updateScrimVisibility() {
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
    protected boolean verifyDrawable(@NonNull Drawable r2) {
        if (super.verifyDrawable(r2) == false) goto L5;
    L10:
        return true;
    L5:
        if (r2 == this.contentScrim) goto L10;
        if (r2 == this.statusBarScrim) goto L10;
        return false;
    }
}
