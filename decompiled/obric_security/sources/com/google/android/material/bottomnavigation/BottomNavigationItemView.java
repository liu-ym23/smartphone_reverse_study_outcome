package com.google.android.material.bottomnavigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
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
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;

/* JADX INFO: loaded from: classes2.dex */
public class BottomNavigationItemView extends FrameLayout implements MenuView.ItemView {
    private static final int[] CHECKED_STATE_SET = null;
    public static final int INVALID_ITEM_POSITION = -1;
    private BadgeDrawable badgeDrawable;
    private final int defaultMargin;
    private ImageView icon;
    private ColorStateList iconTint;
    private boolean isShifting;
    private MenuItemImpl itemData;
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

    static /* synthetic */ ImageView access$000(BottomNavigationItemView r0) {
        return r0.icon;
    }

    static /* synthetic */ void access$100(BottomNavigationItemView r0, View r1) {
        r0.tryUpdateBadgeBounds(r1);
    }

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
    }

    public BottomNavigationItemView(Context r2) {
        this(r2, null);
    }

    public BottomNavigationItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public BottomNavigationItemView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        this.itemPosition = -1;
        Resources r7 = getResources();
        LayoutInflater.from(r4).inflate(com.google.android.material.R.layout.design_bottom_navigation_item, this, true);
        setBackgroundResource(com.google.android.material.R.drawable.design_bottom_navigation_item_background);
        this.defaultMargin = r7.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_margin);
        this.icon = (ImageView) findViewById(com.google.android.material.R.id.icon);
        ViewGroup r8 = (ViewGroup) findViewById(com.google.android.material.R.id.labelGroup);
        this.labelGroup = r8;
        TextView r9 = (TextView) findViewById(com.google.android.material.R.id.smallLabel);
        this.smallLabel = r9;
        TextView r10 = (TextView) findViewById(com.google.android.material.R.id.largeLabel);
        this.largeLabel = r10;
        r8.setTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding, Integer.valueOf(r8.getPaddingBottom()));
        ViewCompat.setImportantForAccessibility(r9, 2);
        ViewCompat.setImportantForAccessibility(r10, 2);
        setFocusable(true);
        calculateTextScaleFactors(r9.getTextSize(), r10.getTextSize());
        ImageView r11 = this.icon;
        if (r11 == null) goto L6;
        r11.addOnLayoutChangeListener(new AnonymousClass1(this));
        return;
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
        return;
    L12:
        r4 = 8;
        goto L13
    L8:
        r3 = r1.getTitle();
        goto L9
    }

    public void setItemPosition(int r1) {
        this.itemPosition = r1;
    }

    public int getItemPosition() {
        return this.itemPosition;
    }

    public void setShifting(boolean r2) {
        if (this.isShifting == r2) goto L11;
        this.isShifting = r2;
        MenuItemImpl r3 = this.itemData;
        if (r3 == null) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        setChecked(r3.isChecked());
        return;
    L12:
        return;
    L7:
        r0 = false;
        goto L8
    }

    public void setLabelVisibilityMode(int r2) {
        if (this.labelVisibilityMode == r2) goto L11;
        this.labelVisibilityMode = r2;
        MenuItemImpl r3 = this.itemData;
        if (r3 == null) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        setChecked(r3.isChecked());
        return;
    L12:
        return;
    L7:
        r0 = false;
        goto L8
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
        int r4 = this.labelVisibilityMode;
        if (r4 == (-1)) goto L19;
        if (r4 != 0) goto L6;
        if (r9 == false) goto L16;
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        ViewGroup r5 = this.labelGroup;
        updateViewPaddingBottom(r5, ((Integer) r5.getTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding)).intValue());
        this.largeLabel.setVisibility(0);
    L17:
        this.smallLabel.setVisibility(4);
    L28:
        refreshDrawableState();
        setSelected(r9);
        return;
    L16:
        setViewLayoutParams(this.icon, this.defaultMargin, 17);
        updateViewPaddingBottom(this.labelGroup, 0);
        this.largeLabel.setVisibility(4);
        goto L17
    L6:
        if (r4 == 1) goto L10;
        if (r4 != 2) goto L28;
        setViewLayoutParams(this.icon, this.defaultMargin, 17);
        this.largeLabel.setVisibility(8);
        this.smallLabel.setVisibility(8);
        goto L28
    L10:
        ViewGroup r6 = this.labelGroup;
        updateViewPaddingBottom(r6, ((Integer) r6.getTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding)).intValue());
        if (r9 == false) goto L13;
        setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
        setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
        TextView r7 = this.smallLabel;
        float r8 = this.scaleUpFactor;
        setViewScaleValues(r7, r8, r8, 4);
        goto L28
    L13:
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        TextView r10 = this.largeLabel;
        float r11 = this.scaleDownFactor;
        setViewScaleValues(r10, r11, r11, 4);
        setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
        goto L28
    L19:
        if (this.isShifting == false) goto L24;
        if (r9 == false) goto L22;
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        ViewGroup r12 = this.labelGroup;
        updateViewPaddingBottom(r12, ((Integer) r12.getTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding)).intValue());
        this.largeLabel.setVisibility(0);
    L23:
        this.smallLabel.setVisibility(4);
        goto L28
    L22:
        setViewLayoutParams(this.icon, this.defaultMargin, 17);
        updateViewPaddingBottom(this.labelGroup, 0);
        this.largeLabel.setVisibility(4);
        goto L23
    L24:
        ViewGroup r13 = this.labelGroup;
        updateViewPaddingBottom(r13, ((Integer) r13.getTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding)).intValue());
        if (r9 == false) goto L27;
        setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
        setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
        TextView r14 = this.smallLabel;
        float r15 = this.scaleUpFactor;
        setViewScaleValues(r14, r15, r15, 4);
        goto L28
    L27:
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        TextView r16 = this.largeLabel;
        float r17 = this.scaleDownFactor;
        setViewScaleValues(r16, r17, r17, 4);
        setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
        goto L28
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
        if ((r3 instanceof BottomNavigationItemView) == false) goto L9;
        if (r3.getVisibility() != 0) goto L9;
        r2 = r2 + 1;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return r2;
    }

    private static void setViewLayoutParams(View r1, int r2, int r3) {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) r1.getLayoutParams();
        r0.topMargin = r2;
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
        TextViewCompat.setTextAppearance(this.smallLabel, r2);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceActive(int r2) {
        TextViewCompat.setTextAppearance(this.largeLabel, r2);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
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

    void setBadge(BadgeDrawable r1) {
        this.badgeDrawable = r1;
        ImageView r2 = this.icon;
        if (r2 == null) goto L6;
        tryAttachBadgeToAnchor(r2);
        return;
    }

    BadgeDrawable getBadge() {
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
}
