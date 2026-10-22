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
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
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

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationItemView extends FrameLayout implements MenuView.ItemView {
    private static final int[] CHECKED_STATE_SET = null;
    public static final int INVALID_ITEM_POSITION = -1;

    @Nullable
    private BadgeDrawable badgeDrawable;
    private final int defaultMargin;
    private ImageView icon;

    @Nullable
    private ColorStateList iconTint;
    private boolean isShifting;

    @Nullable
    private MenuItemImpl itemData;
    private int itemPosition;
    private int labelVisibilityMode;
    private final TextView largeLabel;

    @Nullable
    private Drawable originalIconDrawable;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final TextView smallLabel;

    @Nullable
    private Drawable wrappedIconDrawable;

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
    }

    public BottomNavigationItemView(@NonNull Context r2) {
        this(r2, null);
    }

    public static /* synthetic */ ImageView access$000(BottomNavigationItemView r0) {
        return r0.icon;
    }

    public static /* synthetic */ void access$100(BottomNavigationItemView r0, View r1) {
        r0.tryUpdateBadgeBounds(r1);
    }

    private void calculateTextScaleFactors(float r3, float r4) {
        this.shiftAmount = r3 - r4;
        this.scaleUpFactor = (r4 * 1.0f) / r3;
        this.scaleDownFactor = (r3 * 1.0f) / r4;
    }

    @Nullable
    private FrameLayout getCustomParentForBadge(View r2) {
        ImageView r1 = this.icon;
        if (r2 == r1) goto L5;
        return null;
    L5:
        if (BadgeUtils.USE_COMPAT_PARENT == true) goto L7;
        return null;
    L7:
        return (FrameLayout) r1.getParent();
    }

    private boolean hasBadge() {
        if (this.badgeDrawable == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void setViewLayoutParams(@NonNull View r1, int r2, int r3) {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) r1.getLayoutParams();
        r0.topMargin = r2;
        r0.gravity = r3;
        r1.setLayoutParams(r0);
    }

    private void setViewValues(@NonNull View r1, float r2, float r3, int r4) {
        r1.setScaleX(r2);
        r1.setScaleY(r3);
        r1.setVisibility(r4);
    }

    private void tryAttachBadgeToAnchor(@Nullable View r2) {
        if (hasBadge() == true) goto L5;
        return;
    L5:
        if (r2 == null) goto L8;
        setClipChildren(false);
        setClipToPadding(false);
        BadgeUtils.attachBadgeDrawable(this.badgeDrawable, r2, getCustomParentForBadge(r2));
        return;
    }

    private void tryRemoveBadgeFromAnchor(@Nullable View r3) {
        if (hasBadge() == true) goto L5;
        return;
    L5:
        if (r3 == null) goto L7;
        setClipChildren(true);
        setClipToPadding(true);
        BadgeUtils.detachBadgeDrawable(this.badgeDrawable, r3, getCustomParentForBadge(r3));
    L7:
        this.badgeDrawable = null;
    }

    private void tryUpdateBadgeBounds(View r2) {
        if (hasBadge() == true) goto L5;
        return;
    L5:
        BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, r2, getCustomParentForBadge(r2));
    }

    @Nullable
    public BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    public int getItemPosition() {
        return this.itemPosition;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl r1, int r2) {
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
        View.mergeDrawableStates(r3, CHECKED_STATE_SET);
        goto L9
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r7) {
        super.onInitializeAccessibilityNodeInfo(r7);
        BadgeDrawable r0 = this.badgeDrawable;
        if (r0 != null) goto L5;
    L10:
        AccessibilityNodeInfoCompat r8 = AccessibilityNodeInfoCompat.wrap(r7);
        r8.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemPosition(), 1, false, isSelected()));
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

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    public void setBadge(@NonNull BadgeDrawable r1) {
        this.badgeDrawable = r1;
        ImageView r2 = this.icon;
        if (r2 == null) goto L6;
        tryAttachBadgeToAnchor(r2);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r1) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r10) {
        TextView r0 = this.largeLabel;
        r0.setPivotX(r0.getWidth() / 2);
        TextView r1 = this.largeLabel;
        r1.setPivotY(r1.getBaseline());
        TextView r2 = this.smallLabel;
        r2.setPivotX(r2.getWidth() / 2);
        TextView r3 = this.smallLabel;
        r3.setPivotY(r3.getBaseline());
        int r4 = this.labelVisibilityMode;
        if (r4 == (-1)) goto L18;
        if (r4 != 0) goto L6;
        if (r10 == false) goto L15;
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
    L16:
        this.smallLabel.setVisibility(4);
    L26:
        refreshDrawableState();
        setSelected(r10);
        return;
    L15:
        setViewLayoutParams(this.icon, this.defaultMargin, 17);
        setViewValues(this.largeLabel, 0.5f, 0.5f, 4);
        goto L16
    L6:
        if (r4 == 1) goto L10;
        if (r4 != 2) goto L26;
        setViewLayoutParams(this.icon, this.defaultMargin, 17);
        this.largeLabel.setVisibility(8);
        this.smallLabel.setVisibility(8);
        goto L26
    L10:
        if (r10 == false) goto L12;
        setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
        setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
        TextView r5 = this.smallLabel;
        float r6 = this.scaleUpFactor;
        setViewValues(r5, r6, r6, 4);
        goto L26
    L12:
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        TextView r7 = this.largeLabel;
        float r8 = this.scaleDownFactor;
        setViewValues(r7, r8, r8, 4);
        setViewValues(this.smallLabel, 1.0f, 1.0f, 0);
        goto L26
    L18:
        if (this.isShifting == false) goto L23;
        if (r10 == false) goto L21;
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
    L22:
        this.smallLabel.setVisibility(4);
        goto L26
    L21:
        setViewLayoutParams(this.icon, this.defaultMargin, 17);
        setViewValues(this.largeLabel, 0.5f, 0.5f, 4);
        goto L22
    L23:
        if (r10 == false) goto L25;
        setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
        setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
        TextView r9 = this.smallLabel;
        float r11 = this.scaleUpFactor;
        setViewValues(r9, r11, r11, 4);
        goto L26
    L25:
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        TextView r12 = this.largeLabel;
        float r13 = this.scaleDownFactor;
        setViewValues(r12, r13, r13, 4);
        setViewValues(this.smallLabel, 1.0f, 1.0f, 0);
        goto L26
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

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable r2) {
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

    public void setIconSize(int r2) {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
        r0.width = r2;
        r0.height = r2;
        this.icon.setLayoutParams(r0);
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

    public void setItemPosition(int r1) {
        this.itemPosition = r1;
    }

    public void setLabelVisibilityMode(int r2) {
        if (this.labelVisibilityMode == r2) goto L8;
        this.labelVisibilityMode = r2;
        MenuItemImpl r3 = this.itemData;
        if (r3 == null) goto L9;
        setChecked(r3.isChecked());
        return;
    L9:
        return;
    }

    public void setShifting(boolean r2) {
        if (this.isShifting == r2) goto L8;
        this.isShifting = r2;
        MenuItemImpl r3 = this.itemData;
        if (r3 == null) goto L9;
        setChecked(r3.isChecked());
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean r1, char r2) {
    }

    public void setTextAppearanceActive(@StyleRes int r2) {
        TextViewCompat.setTextAppearance(this.largeLabel, r2);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceInactive(@StyleRes int r2) {
        TextViewCompat.setTextAppearance(this.smallLabel, r2);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList r2) {
        if (r2 == null) goto L5;
        this.smallLabel.setTextColor(r2);
        this.largeLabel.setTextColor(r2);
        return;
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
    public boolean showsIcon() {
        return true;
    }

    public BottomNavigationItemView(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, 0);
    }

    public BottomNavigationItemView(@NonNull Context r2, @Nullable AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.itemPosition = -1;
        Resources r5 = getResources();
        LayoutInflater.from(r2).inflate(com.google.android.material.R.layout.design_bottom_navigation_item, this, true);
        setBackgroundResource(com.google.android.material.R.drawable.design_bottom_navigation_item_background);
        this.defaultMargin = r5.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_margin);
        this.icon = (ImageView) findViewById(com.google.android.material.R.id.icon);
        TextView r6 = (TextView) findViewById(com.google.android.material.R.id.smallLabel);
        this.smallLabel = r6;
        TextView r7 = (TextView) findViewById(com.google.android.material.R.id.largeLabel);
        this.largeLabel = r7;
        ViewCompat.setImportantForAccessibility(r6, 2);
        ViewCompat.setImportantForAccessibility(r7, 2);
        setFocusable(true);
        calculateTextScaleFactors(r6.getTextSize(), r7.getTextSize());
        ImageView r8 = this.icon;
        if (r8 == null) goto L6;
        r8.addOnLayoutChangeListener(new AnonymousClass1(this));
        return;
    }

    public void setItemBackground(@Nullable Drawable r2) {
        if (r2 != null) goto L4;
    L6:
        ViewCompat.setBackground(this, r2);
        return;
    L4:
        if (r2.getConstantState() == null) goto L6;
        r2 = r2.getConstantState().newDrawable().mutate();
        goto L6
    }
}
