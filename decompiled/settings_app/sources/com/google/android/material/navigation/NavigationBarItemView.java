package com.google.android.material.navigation;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NavigationBarItemView extends FrameLayout implements MenuView.ItemView {
    private static final ActiveIndicatorTransform ACTIVE_INDICATOR_LABELED_TRANSFORM = null;
    private static final ActiveIndicatorTransform ACTIVE_INDICATOR_UNLABELED_TRANSFORM = null;
    private static final int[] CHECKED_STATE_SET = null;
    private static final int INVALID_ITEM_POSITION = -1;
    private ValueAnimator activeIndicatorAnimator;
    private int activeIndicatorDesiredHeight;
    private int activeIndicatorDesiredWidth;
    private boolean activeIndicatorEnabled;
    private int activeIndicatorMarginHorizontal;
    private float activeIndicatorProgress;
    private boolean activeIndicatorResizeable;
    private ActiveIndicatorTransform activeIndicatorTransform;
    private final View activeIndicatorView;
    private BadgeDrawable badgeDrawable;
    private final ImageView icon;
    private final FrameLayout iconContainer;
    private ColorStateList iconTint;
    private boolean initialized;
    private boolean isShifting;
    private MenuItemImpl itemData;
    private int itemPaddingBottom;
    private int itemPaddingTop;
    private int itemPosition;
    private final ViewGroup labelGroup;
    private int labelVisibilityMode;
    private final TextView largeLabel;
    private Drawable originalIconDrawable;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final TextView smallLabel;
    private Drawable wrappedIconDrawable;

    private static class ActiveIndicatorTransform {
        private static final float ALPHA_FRACTION = 0.2f;
        private static final float SCALE_X_HIDDEN = 0.4f;
        private static final float SCALE_X_SHOWN = 1.0f;

        protected float calculateScaleY(float r1, float r2) {
            return 1.0f;
        }

        private ActiveIndicatorTransform() {
        }

        /* synthetic */ ActiveIndicatorTransform(AnonymousClass1 r1) {
            this();
        }

        protected float calculateAlpha(float r3, float r4) {
            if (r4 != 0.0f) goto L5;
            float r0 = 0.8f;
        L7:
            if (r4 != 0.0f) goto L9;
            float r5 = 1.0f;
        L11:
            return AnimationUtils.lerp(0.0f, 1.0f, r0, r5, r3);
        L9:
            r5 = 0.2f;
            goto L11
        L5:
            r0 = 0.0f;
            goto L7
        }

        protected float calculateScaleX(float r1, float r2) {
            return AnimationUtils.lerp(0.4f, 1.0f, r1);
        }

        public void updateForProgress(float r2, float r3, View r4) {
            r4.setScaleX(calculateScaleX(r2, r3));
            r4.setScaleY(calculateScaleY(r2, r3));
            r4.setAlpha(calculateAlpha(r2, r3));
        }
    }

    private static class ActiveIndicatorUnlabeledTransform extends ActiveIndicatorTransform {
        private ActiveIndicatorUnlabeledTransform() {
            super(null);
        }

        /* synthetic */ ActiveIndicatorUnlabeledTransform(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.android.material.navigation.NavigationBarItemView.ActiveIndicatorTransform
        protected float calculateScaleY(float r1, float r2) {
            return calculateScaleX(r1, r2);
        }
    }

    protected abstract int getItemLayoutResId();

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean r1, char r2) {
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    static /* synthetic */ ImageView access$200(NavigationBarItemView r0) {
        return r0.icon;
    }

    static /* synthetic */ void access$300(NavigationBarItemView r0, View r1) {
        r0.tryUpdateBadgeBounds(r1);
    }

    static /* synthetic */ void access$400(NavigationBarItemView r0, int r1) {
        r0.updateActiveIndicatorLayoutParams(r1);
    }

    static /* synthetic */ void access$500(NavigationBarItemView r0, float r1, float r2) {
        r0.setActiveIndicatorProgress(r1, r2);
    }

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        AnonymousClass1 r1 = null;
        ACTIVE_INDICATOR_LABELED_TRANSFORM = new ActiveIndicatorTransform(r1);
        ACTIVE_INDICATOR_UNLABELED_TRANSFORM = new ActiveIndicatorUnlabeledTransform(r1);
    }

    public NavigationBarItemView(Context r7) {
        super(r7);
        this.initialized = false;
        this.itemPosition = -1;
        this.activeIndicatorTransform = ACTIVE_INDICATOR_LABELED_TRANSFORM;
        this.activeIndicatorProgress = 0.0f;
        this.activeIndicatorEnabled = false;
        this.activeIndicatorDesiredWidth = 0;
        this.activeIndicatorDesiredHeight = 0;
        this.activeIndicatorResizeable = false;
        this.activeIndicatorMarginHorizontal = 0;
        LayoutInflater.from(r7).inflate(getItemLayoutResId(), this, true);
        this.iconContainer = (FrameLayout) findViewById(com.google.android.material.R.id.navigation_bar_item_icon_container);
        this.activeIndicatorView = findViewById(com.google.android.material.R.id.navigation_bar_item_active_indicator_view);
        ImageView r8 = (ImageView) findViewById(com.google.android.material.R.id.navigation_bar_item_icon_view);
        this.icon = r8;
        ViewGroup r0 = (ViewGroup) findViewById(com.google.android.material.R.id.navigation_bar_item_labels_group);
        this.labelGroup = r0;
        TextView r2 = (TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_small_label_view);
        this.smallLabel = r2;
        TextView r3 = (TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_large_label_view);
        this.largeLabel = r3;
        setBackgroundResource(getItemBackgroundResId());
        this.itemPaddingTop = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.itemPaddingBottom = r0.getPaddingBottom();
        ViewCompat.setImportantForAccessibility(r2, 2);
        ViewCompat.setImportantForAccessibility(r3, 2);
        setFocusable(true);
        calculateTextScaleFactors(r2.getTextSize(), r3.getTextSize());
        if (r8 == null) goto L6;
        r8.addOnLayoutChangeListener(new AnonymousClass1(this));
        return;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) this.labelGroup.getLayoutParams();
        int r1 = (r0.leftMargin + this.labelGroup.getMeasuredWidth()) + r0.rightMargin;
        return Math.max(getSuggestedIconWidth(), r1);
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) this.labelGroup.getLayoutParams();
        return ((getSuggestedIconHeight() + r0.topMargin) + this.labelGroup.getMeasuredHeight()) + r0.bottomMargin;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl r1, int r2) {
        this.itemData = r1;
        setCheckable(r1.isCheckable());
        setChecked(r1.isChecked());
        setEnabled(r1.isEnabled());
        setIcon(r1.getIcon());
        setTitle(r1.getTitle());
        setId(r1.getItemId());
        if (TextUtils.isEmpty(r1.getContentDescription()) == true) goto L6;
        setContentDescription(r1.getContentDescription());
    L6:
        if (TextUtils.isEmpty(r1.getTooltipText()) == true) goto L8;
        CharSequence r3 = r1.getTooltipText();
    L9:
        TooltipCompat.setTooltipText(this, r3);
        if (r1.isVisible() == false) goto L12;
        int r4 = 0;
    L13:
        setVisibility(r4);
        this.initialized = true;
        return;
    L12:
        r4 = 8;
        goto L13
    L8:
        r3 = r1.getTitle();
        goto L9
    }

    void clear() {
        removeBadge();
        this.itemData = null;
        this.activeIndicatorProgress = 0.0f;
        this.initialized = false;
    }

    private View getIconOrContainer() {
        FrameLayout r0 = this.iconContainer;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.icon;
    }

    public void setItemPosition(int r1) {
        this.itemPosition = r1;
    }

    public int getItemPosition() {
        return this.itemPosition;
    }

    public void setShifting(boolean r2) {
        if (this.isShifting == r2) goto L6;
        this.isShifting = r2;
        refreshChecked();
        return;
    }

    public void setLabelVisibilityMode(int r2) {
        if (this.labelVisibilityMode == r2) goto L6;
        this.labelVisibilityMode = r2;
        updateActiveIndicatorTransform();
        updateActiveIndicatorLayoutParams(getWidth());
        refreshChecked();
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence r2) {
        this.smallLabel.setText(r2);
        this.largeLabel.setText(r2);
        MenuItemImpl r0 = this.itemData;
        if (r0 != null) goto L5;
    L6:
        setContentDescription(r2);
    L7:
        MenuItemImpl r1 = this.itemData;
        if (r1 != null) goto L10;
    L13:
        TooltipCompat.setTooltipText(this, r2);
        return;
    L10:
        if (TextUtils.isEmpty(r1.getTooltipText()) == true) goto L13;
        r2 = this.itemData.getTooltipText();
        goto L13
    L5:
        if (TextUtils.isEmpty(r0.getContentDescription()) == false) goto L7;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r1) {
        refreshDrawableState();
    }

    @Override // android.view.View
    protected void onSizeChanged(final int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        post(new AnonymousClass2(this, r1));
    }

    private void updateActiveIndicatorTransform() {
        if (isActiveIndicatorResizeableAndUnlabeled() == false) goto L5;
        this.activeIndicatorTransform = ACTIVE_INDICATOR_UNLABELED_TRANSFORM;
        return;
    L5:
        this.activeIndicatorTransform = ACTIVE_INDICATOR_LABELED_TRANSFORM;
    }

    private void setActiveIndicatorProgress(float r3, float r4) {
        View r0 = this.activeIndicatorView;
        if (r0 == null) goto L5;
        this.activeIndicatorTransform.updateForProgress(r3, r4, r0);
    L5:
        this.activeIndicatorProgress = r3;
    }

    private void maybeAnimateActiveIndicatorToProgress(final float r5) {
        if (this.activeIndicatorEnabled == true) goto L5;
    L14:
        setActiveIndicatorProgress(r5, r5);
        return;
    L5:
        if (this.initialized == false) goto L14;
        if (ViewCompat.isAttachedToWindow(this) == false) goto L14;
        ValueAnimator r0 = this.activeIndicatorAnimator;
        if (r0 == null) goto L12;
        r0.cancel();
        this.activeIndicatorAnimator = null;
    L12:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{this.activeIndicatorProgress, r5});
        this.activeIndicatorAnimator = r1;
        r1.addUpdateListener(new AnonymousClass3(this, r5));
        this.activeIndicatorAnimator.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), com.google.android.material.R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        this.activeIndicatorAnimator.setDuration(MotionUtils.resolveThemeDuration(getContext(), com.google.android.material.R.attr.motionDurationLong1, getResources().getInteger(com.google.android.material.R.integer.material_motion_duration_long_1)));
        this.activeIndicatorAnimator.start();
    }

    private void refreshChecked() {
        MenuItemImpl r0 = this.itemData;
        if (r0 == null) goto L6;
        setChecked(r0.isChecked());
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r9) {
        TextView r0 = this.largeLabel;
        r0.setPivotX(r0.getWidth() / 2);
        TextView r1 = this.largeLabel;
        r1.setPivotY(r1.getBaseline());
        TextView r2 = this.smallLabel;
        r2.setPivotX(r2.getWidth() / 2);
        TextView r3 = this.smallLabel;
        r3.setPivotY(r3.getBaseline());
        if (r9 == false) goto L5;
        float r4 = 1.0f;
    L6:
        maybeAnimateActiveIndicatorToProgress(r4);
        int r5 = this.labelVisibilityMode;
        if (r5 == (-1)) goto L23;
        if (r5 != 0) goto L10;
        if (r9 == false) goto L20;
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
        updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
        this.largeLabel.setVisibility(0);
    L21:
        this.smallLabel.setVisibility(4);
    L32:
        refreshDrawableState();
        setSelected(r9);
        return;
    L20:
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 17);
        updateViewPaddingBottom(this.labelGroup, 0);
        this.largeLabel.setVisibility(4);
        goto L21
    L10:
        if (r5 == 1) goto L14;
        if (r5 != 2) goto L32;
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 17);
        this.largeLabel.setVisibility(8);
        this.smallLabel.setVisibility(8);
        goto L32
    L14:
        updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
        if (r9 == false) goto L17;
        setViewTopMarginAndGravity(getIconOrContainer(), (int) (this.itemPaddingTop + this.shiftAmount), 49);
        setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
        TextView r6 = this.smallLabel;
        float r7 = this.scaleUpFactor;
        setViewScaleValues(r6, r7, r7, 4);
        goto L32
    L17:
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
        TextView r8 = this.largeLabel;
        float r10 = this.scaleDownFactor;
        setViewScaleValues(r8, r10, r10, 4);
        setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
        goto L32
    L23:
        if (this.isShifting == false) goto L28;
        if (r9 == false) goto L26;
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
        updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
        this.largeLabel.setVisibility(0);
    L27:
        this.smallLabel.setVisibility(4);
        goto L32
    L26:
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 17);
        updateViewPaddingBottom(this.labelGroup, 0);
        this.largeLabel.setVisibility(4);
        goto L27
    L28:
        updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
        if (r9 == false) goto L31;
        setViewTopMarginAndGravity(getIconOrContainer(), (int) (this.itemPaddingTop + this.shiftAmount), 49);
        setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
        TextView r11 = this.smallLabel;
        float r12 = this.scaleUpFactor;
        setViewScaleValues(r11, r12, r12, 4);
        goto L32
    L31:
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
        TextView r13 = this.largeLabel;
        float r14 = this.scaleDownFactor;
        setViewScaleValues(r13, r14, r14, 4);
        setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
        goto L32
    L5:
        r4 = 0.0f;
        goto L6
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r7) {
        super.onInitializeAccessibilityNodeInfo(r7);
        BadgeDrawable r0 = this.badgeDrawable;
        if (r0 != null) goto L5;
    L10:
        AccessibilityNodeInfoCompat r8 = AccessibilityNodeInfoCompat.wrap(r7);
        r8.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected() == false) goto L13;
        r8.setClickable(false);
        r8.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
    L13:
        r8.setRoleDescription(getResources().getString(com.google.android.material.R.string.item_view_role_description));
        return;
    L5:
        if (r0.isVisible() == false) goto L10;
        CharSequence r1 = this.itemData.getTitle();
        if (TextUtils.isEmpty(this.itemData.getContentDescription()) == true) goto L9;
        r1 = this.itemData.getContentDescription();
    L9:
        r7.setContentDescription(r1 + ", " + this.badgeDrawable.getContentDescription());
        goto L10
    }

    private int getItemVisiblePosition() {
        ViewGroup r0 = (ViewGroup) getParent();
        int r5 = r0.indexOfChild(this);
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r5) goto L10;
        View r3 = r0.getChildAt(r1);
        if ((r3 instanceof NavigationBarItemView) == false) goto L9;
        if (r3.getVisibility() != 0) goto L9;
        r2 = r2 + 1;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return r2;
    }

    private static void setViewTopMarginAndGravity(View r1, int r2, int r3) {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) r1.getLayoutParams();
        r0.topMargin = r2;
        r0.bottomMargin = r2;
        r0.gravity = r3;
        r1.setLayoutParams(r0);
    }

    private static void setViewScaleValues(View r0, float r1, float r2, int r3) {
        r0.setScaleX(r1);
        r0.setScaleY(r2);
        r0.setVisibility(r3);
    }

    private static void updateViewPaddingBottom(View r3, int r4) {
        r3.setPadding(r3.getPaddingLeft(), r3.getPaddingTop(), r3.getPaddingRight(), r4);
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        this.smallLabel.setEnabled(r2);
        this.largeLabel.setEnabled(r2);
        this.icon.setEnabled(r2);
        if (r2 == false) goto L5;
        ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        return;
    L5:
        ViewCompat.setPointerIcon(this, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int r2) {
        int[] r3 = super.onCreateDrawableState(r2 + 1);
        MenuItemImpl r0 = this.itemData;
        if (r0 != null) goto L5;
    L9:
        return r3;
    L5:
        if (r0.isCheckable() == false) goto L9;
        if (this.itemData.isChecked() == false) goto L9;
        mergeDrawableStates(r3, CHECKED_STATE_SET);
        goto L9
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable r2) {
        if (r2 != this.originalIconDrawable) goto L5;
        return;
    L5:
        this.originalIconDrawable = r2;
        if (r2 == null) goto L14;
        Drawable.ConstantState r0 = r2.getConstantState();
        if (r0 == null) goto L11;
        r2 = r0.newDrawable();
    L11:
        r2 = DrawableCompat.wrap(r2).mutate();
        this.wrappedIconDrawable = r2;
        ColorStateList r1 = this.iconTint;
        if (r1 == null) goto L14;
        DrawableCompat.setTintList(r2, r1);
    L14:
        this.icon.setImageDrawable(r2);
    }

    public void setIconTintList(ColorStateList r2) {
        this.iconTint = r2;
        if (this.itemData == null) goto L8;
        Drawable r0 = this.wrappedIconDrawable;
        if (r0 == null) goto L9;
        DrawableCompat.setTintList(r0, r2);
        this.wrappedIconDrawable.invalidateSelf();
        return;
    L9:
        return;
    }

    public void setIconSize(int r2) {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
        r0.width = r2;
        r0.height = r2;
        this.icon.setLayoutParams(r0);
    }

    public void setTextAppearanceInactive(int r2) {
        setTextAppearanceWithoutFontScaling(this.smallLabel, r2);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceActive(int r2) {
        setTextAppearanceWithoutFontScaling(this.largeLabel, r2);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    private static void setTextAppearanceWithoutFontScaling(TextView r2, int r3) {
        TextViewCompat.setTextAppearance(r2, r3);
        int r4 = MaterialResources.getUnscaledTextSize(r2.getContext(), r3, 0);
        if (r4 == 0) goto L6;
        r2.setTextSize(0, r4);
        return;
    }

    public void setTextColor(ColorStateList r2) {
        if (r2 == null) goto L5;
        this.smallLabel.setTextColor(r2);
        this.largeLabel.setTextColor(r2);
        return;
    }

    private void calculateTextScaleFactors(float r3, float r4) {
        this.shiftAmount = r3 - r4;
        this.scaleUpFactor = (r4 * 1.0f) / r3;
        this.scaleDownFactor = (r3 * 1.0f) / r4;
    }

    public void setItemBackground(int r2) {
        if (r2 != 0) goto L4;
        Drawable r3 = null;
    L5:
        setItemBackground(r3);
        return;
    L4:
        r3 = ContextCompat.getDrawable(getContext(), r2);
        goto L5
    }

    public void setItemBackground(Drawable r2) {
        if (r2 != null) goto L4;
    L6:
        ViewCompat.setBackground(this, r2);
        return;
    L4:
        if (r2.getConstantState() == null) goto L6;
        r2 = r2.getConstantState().newDrawable().mutate();
        goto L6
    }

    public void setItemPaddingTop(int r2) {
        if (this.itemPaddingTop == r2) goto L6;
        this.itemPaddingTop = r2;
        refreshChecked();
        return;
    }

    public void setItemPaddingBottom(int r2) {
        if (this.itemPaddingBottom == r2) goto L6;
        this.itemPaddingBottom = r2;
        refreshChecked();
        return;
    }

    public void setActiveIndicatorEnabled(boolean r2) {
        this.activeIndicatorEnabled = r2;
        View r0 = this.activeIndicatorView;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        requestLayout();
        return;
    L6:
        r3 = 8;
        goto L7
    }

    public void setActiveIndicatorWidth(int r1) {
        this.activeIndicatorDesiredWidth = r1;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    private void updateActiveIndicatorLayoutParams(int r3) {
        if (this.activeIndicatorView != null) goto L5;
        return;
    L5:
        int r4 = Math.min(this.activeIndicatorDesiredWidth, r3 - (this.activeIndicatorMarginHorizontal * 2));
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) this.activeIndicatorView.getLayoutParams();
        if (isActiveIndicatorResizeableAndUnlabeled() == false) goto L8;
        int r1 = r4;
    L9:
        r0.height = r1;
        r0.width = r4;
        this.activeIndicatorView.setLayoutParams(r0);
        return;
    L8:
        r1 = this.activeIndicatorDesiredHeight;
        goto L9
    }

    private boolean isActiveIndicatorResizeableAndUnlabeled() {
        if (this.activeIndicatorResizeable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.labelVisibilityMode != 2) goto L7;
        return true;
    }

    public void setActiveIndicatorHeight(int r1) {
        this.activeIndicatorDesiredHeight = r1;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorMarginHorizontal(int r1) {
        this.activeIndicatorMarginHorizontal = r1;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public Drawable getActiveIndicatorDrawable() {
        View r0 = this.activeIndicatorView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBackground();
    }

    public void setActiveIndicatorDrawable(Drawable r1) {
        View r0 = this.activeIndicatorView;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setBackgroundDrawable(r1);
    }

    public void setActiveIndicatorResizeable(boolean r1) {
        this.activeIndicatorResizeable = r1;
    }

    void setBadge(BadgeDrawable r3) {
        if (this.badgeDrawable != r3) goto L6;
        return;
    L6:
        if (hasBadge() == true) goto L8;
    L10:
        this.badgeDrawable = r3;
        ImageView r4 = this.icon;
        if (r4 == null) goto L14;
        tryAttachBadgeToAnchor(r4);
        return;
    L14:
        return;
    L8:
        if (this.icon == null) goto L10;
        Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
        tryRemoveBadgeFromAnchor(this.icon);
        goto L10
    }

    public BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    private boolean hasBadge() {
        if (this.badgeDrawable == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void tryUpdateBadgeBounds(View r2) {
        if (hasBadge() == true) goto L5;
        return;
    L5:
        BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, r2, getCustomParentForBadge(r2));
    }

    private void tryAttachBadgeToAnchor(View r2) {
        if (hasBadge() == true) goto L5;
        return;
    L5:
        if (r2 == null) goto L8;
        setClipChildren(false);
        setClipToPadding(false);
        BadgeUtils.attachBadgeDrawable(this.badgeDrawable, r2, getCustomParentForBadge(r2));
        return;
    }

    private void tryRemoveBadgeFromAnchor(View r2) {
        if (hasBadge() == true) goto L5;
        return;
    L5:
        if (r2 == null) goto L7;
        setClipChildren(true);
        setClipToPadding(true);
        BadgeUtils.detachBadgeDrawable(this.badgeDrawable, r2);
    L7:
        this.badgeDrawable = null;
    }

    private FrameLayout getCustomParentForBadge(View r3) {
        if (r3 == this.icon) goto L5;
        return null;
    L5:
        if (BadgeUtils.USE_COMPAT_PARENT == true) goto L7;
        return null;
    L7:
        return (FrameLayout) this.icon.getParent();
    }

    private int getSuggestedIconWidth() {
        BadgeDrawable r0 = this.badgeDrawable;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return (Math.max(r1, r2.leftMargin) + this.icon.getMeasuredWidth()) + Math.max(r1, r2.rightMargin);
    L5:
        r1 = r0.getMinimumWidth() - this.badgeDrawable.getHorizontalOffset();
        goto L6
    }

    private int getSuggestedIconHeight() {
        BadgeDrawable r0 = this.badgeDrawable;
        if (r0 == null) goto L5;
        int r1 = r0.getMinimumHeight() / 2;
    L7:
        return (Math.max(r1, ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin) + this.icon.getMeasuredWidth()) + r1;
    L5:
        r1 = 0;
        goto L7
    }

    protected int getItemBackgroundResId() {
        return com.google.android.material.R.drawable.mtrl_navigation_bar_item_background;
    }

    protected int getItemDefaultMarginResId() {
        return com.google.android.material.R.dimen.mtrl_navigation_bar_item_default_margin;
    }
}
