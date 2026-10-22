package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {
    private static final int[] CHECKED_STATE_SET = null;
    private final AccessibilityDelegateCompat accessibilityDelegate;
    private FrameLayout actionArea;
    boolean checkable;
    private Drawable emptyDrawable;
    private boolean hasIconTintList;
    private int iconSize;
    private ColorStateList iconTintList;
    private MenuItemImpl itemData;
    private boolean needsEmptyIcon;
    private final CheckedTextView textView;

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

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
    }

    public NavigationMenuItemView(Context r2) {
        this(r2, null);
    }

    public NavigationMenuItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public NavigationMenuItemView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        AccessibilityDelegateCompat r6 = new AnonymousClass1(this);
        this.accessibilityDelegate = r6;
        setOrientation(0);
        LayoutInflater.from(r3).inflate(com.google.android.material.R.layout.design_navigation_menu_item, this, true);
        setIconSize(r3.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.design_navigation_icon_size));
        CheckedTextView r7 = (CheckedTextView) findViewById(com.google.android.material.R.id.design_menu_item_text);
        this.textView = r7;
        r7.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(r7, r6);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl r1, int r2) {
        this.itemData = r1;
        if (r1.getItemId() <= 0) goto L6;
        setId(r1.getItemId());
    L6:
        if (r1.isVisible() == false) goto L8;
        int r3 = 0;
    L9:
        setVisibility(r3);
        if (getBackground() != null) goto L12;
        ViewCompat.setBackground(this, createDefaultBackground());
    L12:
        setCheckable(r1.isCheckable());
        setChecked(r1.isChecked());
        setEnabled(r1.isEnabled());
        setTitle(r1.getTitle());
        setIcon(r1.getIcon());
        setActionView(r1.getActionView());
        setContentDescription(r1.getContentDescription());
        TooltipCompat.setTooltipText(this, r1.getTooltipText());
        adjustAppearance();
        return;
    L8:
        r3 = 8;
        goto L9
    }

    private boolean shouldExpandActionArea() {
        if (this.itemData.getTitle() == null) goto L5;
    L9:
        return false;
    L5:
        if (this.itemData.getIcon() != null) goto L9;
        if (this.itemData.getActionView() == null) goto L9;
        return true;
    }

    private void adjustAppearance() {
        if (shouldExpandActionArea() == false) goto L7;
        this.textView.setVisibility(8);
        FrameLayout r0 = this.actionArea;
        if (r0 == null) goto L11;
        LinearLayoutCompat.LayoutParams r1 = (LinearLayoutCompat.LayoutParams) r0.getLayoutParams();
        r1.width = -1;
        this.actionArea.setLayoutParams(r1);
        return;
    L11:
        return;
    L7:
        this.textView.setVisibility(0);
        FrameLayout r2 = this.actionArea;
        if (r2 == null) goto L13;
        LinearLayoutCompat.LayoutParams r3 = (LinearLayoutCompat.LayoutParams) r2.getLayoutParams();
        r3.width = -2;
        this.actionArea.setLayoutParams(r3);
        return;
    }

    public void recycle() {
        FrameLayout r0 = this.actionArea;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        this.textView.setCompoundDrawables(null, null, null, null);
    }

    private void setActionView(View r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.actionArea != null) goto L6;
        this.actionArea = (FrameLayout) ((ViewStub) findViewById(com.google.android.material.R.id.design_menu_item_action_area_stub)).inflate();
    L6:
        this.actionArea.removeAllViews();
        this.actionArea.addView(r2);
    }

    private StateListDrawable createDefaultBackground() {
        TypedValue r0 = new TypedValue();
        if (getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlHighlight, r0, true) == false) goto L6;
        StateListDrawable r3 = new StateListDrawable();
        r3.addState(CHECKED_STATE_SET, new ColorDrawable(r0.data));
        r3.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return r3;
    L6:
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence r1) {
        this.textView.setText(r1);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r2) {
        refreshDrawableState();
        if (this.checkable == r2) goto L6;
        this.checkable = r2;
        this.accessibilityDelegate.sendAccessibilityEvent(this.textView, 2048);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r1) {
        refreshDrawableState();
        this.textView.setChecked(r1);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable r4) {
        if (r4 == null) goto L13;
        if (this.hasIconTintList == false) goto L11;
        Drawable.ConstantState r1 = r4.getConstantState();
        if (r1 == null) goto L10;
        r4 = r1.newDrawable();
    L10:
        r4 = DrawableCompat.wrap(r4).mutate();
        DrawableCompat.setTintList(r4, this.iconTintList);
    L11:
        int r2 = this.iconSize;
        r4.setBounds(0, 0, r2, r2);
    L20:
        TextViewCompat.setCompoundDrawablesRelative(this.textView, r4, null, null, null);
        return;
    L13:
        if (this.needsEmptyIcon == false) goto L20;
        if (this.emptyDrawable != null) goto L19;
        Drawable r5 = ResourcesCompat.getDrawable(getResources(), com.google.android.material.R.drawable.navigation_empty_icon, getContext().getTheme());
        this.emptyDrawable = r5;
        if (r5 == null) goto L19;
        int r3 = this.iconSize;
        r5.setBounds(0, 0, r3, r3);
    L19:
        r4 = this.emptyDrawable;
        goto L20
    }

    public void setIconSize(int r1) {
        this.iconSize = r1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int r2) {
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

    void setIconTintList(ColorStateList r1) {
        this.iconTintList = r1;
        if (r1 == null) goto L5;
        boolean r2 = true;
    L6:
        this.hasIconTintList = r2;
        MenuItemImpl r3 = this.itemData;
        if (r3 == null) goto L10;
        setIcon(r3.getIcon());
        return;
    L10:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public void setTextAppearance(int r1) {
        TextViewCompat.setTextAppearance(this.textView, r1);
    }

    public void setTextColor(ColorStateList r1) {
        this.textView.setTextColor(r1);
    }

    public void setNeedsEmptyIcon(boolean r1) {
        this.needsEmptyIcon = r1;
    }

    public void setHorizontalPadding(int r2) {
        setPadding(r2, 0, r2, 0);
    }

    public void setIconPadding(int r1) {
        this.textView.setCompoundDrawablePadding(r1);
    }

    public void setMaxLines(int r1) {
        this.textView.setMaxLines(r1);
    }
}
