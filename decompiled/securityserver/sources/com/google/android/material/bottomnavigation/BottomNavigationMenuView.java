package com.google.android.material.bottomnavigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView extends ViewGroup implements MenuView {
    private static final long ACTIVE_ANIMATION_DURATION_MS = 115;
    private static final int[] CHECKED_STATE_SET = null;
    private static final int[] DISABLED_STATE_SET = null;
    private static final int ITEM_POOL_SIZE = 5;
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;

    @NonNull
    private SparseArray<BadgeDrawable> badgeDrawables;

    @Nullable
    private BottomNavigationItemView[] buttons;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private Drawable itemBackground;
    private int itemBackgroundRes;
    private final int itemHeight;
    private boolean itemHorizontalTranslationEnabled;

    @Dimension
    private int itemIconSize;
    private ColorStateList itemIconTint;
    private final Pools.Pool<BottomNavigationItemView> itemPool;

    @StyleRes
    private int itemTextAppearanceActive;

    @StyleRes
    private int itemTextAppearanceInactive;

    @Nullable
    private final ColorStateList itemTextColorDefault;
    private ColorStateList itemTextColorFromUser;
    private int labelVisibilityMode;
    private MenuBuilder menu;

    @NonNull
    private final View.OnClickListener onClickListener;
    private BottomNavigationPresenter presenter;
    private int selectedItemId;
    private int selectedItemPosition;

    @NonNull
    private final TransitionSet set;
    private int[] tempChildWidths;

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DISABLED_STATE_SET = new int[]{-16842910};
    }

    public BottomNavigationMenuView(Context r2) {
        this(r2, null);
    }

    public static /* synthetic */ BottomNavigationPresenter access$000(BottomNavigationMenuView r0) {
        return r0.presenter;
    }

    public static /* synthetic */ MenuBuilder access$100(BottomNavigationMenuView r0) {
        return r0.menu;
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView r0 = this.itemPool.acquire();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new BottomNavigationItemView(getContext());
    }

    private boolean isShifting(int r3, int r4) {
        if (r3 == (-1)) goto L5;
        if (r3 == 0) goto L10;
        return false;
    L10:
        return true;
    L5:
        if (r4 > 3) goto L10;
        return false;
    }

    private boolean isValidId(int r1) {
        if (r1 == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private void removeUnusedBadges() {
        HashSet r0 = new HashSet();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= this.menu.size()) goto L7;
        r0.add(Integer.valueOf(this.menu.getItem(r2).getItemId()));
        r2 = r2 + 1;
    L7:
        if (r1 >= this.badgeDrawables.size()) goto L12;
        int r3 = this.badgeDrawables.keyAt(r1);
        if (r0.contains(Integer.valueOf(r3)) == true) goto L11;
        this.badgeDrawables.delete(r3);
    L11:
        r1 = r1 + 1;
        goto L7
    }

    private void setBadgeIfNeeded(@NonNull BottomNavigationItemView r3) {
        int r0 = r3.getId();
        if (isValidId(r0) == true) goto L5;
        return;
    L5:
        BadgeDrawable r2 = this.badgeDrawables.get(r0);
        if (r2 == null) goto L9;
        r3.setBadge(r2);
        return;
    }

    private void validateMenuItemId(int r2) {
        if (isValidId(r2) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(r2 + " is not a valid view id");
    }

    public void buildMenuView() {
        removeAllViews();
        BottomNavigationItemView[] r0 = this.buttons;
        if (r0 == null) goto L11;
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        BottomNavigationItemView r4 = r0[r3];
        if (r4 == null) goto L9;
        this.itemPool.release(r4);
        r4.removeBadge();
    L9:
        r3 = r3 + 1;
    L11:
        if (this.menu.size() != 0) goto L14;
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.buttons = null;
        return;
    L14:
        removeUnusedBadges();
        this.buttons = new BottomNavigationItemView[this.menu.size()];
        boolean r1 = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        int r5 = 0;
    L16:
        if (r5 >= this.menu.size()) goto L27;
        this.presenter.setUpdateSuspended(true);
        this.menu.getItem(r5).setCheckable(true);
        this.presenter.setUpdateSuspended(false);
        BottomNavigationItemView r6 = getNewItem();
        this.buttons[r5] = r6;
        r6.setIconTintList(this.itemIconTint);
        r6.setIconSize(this.itemIconSize);
        r6.setTextColor(this.itemTextColorDefault);
        r6.setTextAppearanceInactive(this.itemTextAppearanceInactive);
        r6.setTextAppearanceActive(this.itemTextAppearanceActive);
        r6.setTextColor(this.itemTextColorFromUser);
        Drawable r7 = this.itemBackground;
        if (r7 == null) goto L20;
        r6.setItemBackground(r7);
    L21:
        r6.setShifting(r1);
        r6.setLabelVisibilityMode(this.labelVisibilityMode);
        r6.initialize((MenuItemImpl) this.menu.getItem(r5), 0);
        r6.setItemPosition(r5);
        r6.setOnClickListener(this.onClickListener);
        if (this.selectedItemId == 0) goto L26;
        if (this.menu.getItem(r5).getItemId() != this.selectedItemId) goto L26;
        this.selectedItemPosition = r5;
    L26:
        setBadgeIfNeeded(r6);
        addView(r6);
        r5 = r5 + 1;
        goto L16
    L20:
        r6.setItemBackground(this.itemBackgroundRes);
        goto L21
    L27:
        int r8 = Math.min(this.menu.size() - 1, this.selectedItemPosition);
        this.selectedItemPosition = r8;
        this.menu.getItem(r8).setChecked(true);
    }

    @Nullable
    public ColorStateList createDefaultColorStateList(int r6) {
        TypedValue r0 = new TypedValue();
        if (getContext().getTheme().resolveAttribute(r6, r0, true) == true) goto L5;
        return null;
    L5:
        ColorStateList r7 = AppCompatResources.getColorStateList(getContext(), r0.resourceId);
        if (getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, r0, true) == true) goto L8;
        return null;
    L8:
        int r5 = r0.data;
        int r1 = r7.getDefaultColor();
        int[] r2 = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{r2, CHECKED_STATE_SET, ViewGroup.EMPTY_STATE_SET}, new int[]{r7.getColorForState(r2, r1), r5, r1});
    }

    @Nullable
    @VisibleForTesting
    public BottomNavigationItemView findItemView(int r5) {
        validateMenuItemId(r5);
        BottomNavigationItemView[] r4 = this.buttons;
        if (r4 == null) goto L10;
        int r0 = r4.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L14;
        BottomNavigationItemView r2 = r4[r1];
        if (r2.getId() == r5) goto L8;
        r1 = r1 + 1;
        goto L5
    L8:
        return r2;
    L14:
        return null;
    L10:
        return null;
    }

    @Nullable
    public BadgeDrawable getBadge(int r1) {
        return this.badgeDrawables.get(r1);
    }

    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.badgeDrawables;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    @Nullable
    public Drawable getItemBackground() {
        BottomNavigationItemView[] r0 = this.buttons;
        if (r0 == null) goto L9;
        if (r0.length <= 0) goto L9;
        return r0[0].getBackground();
    L9:
        return this.itemBackground;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    @Dimension
    public int getItemIconSize() {
        return this.itemIconSize;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    public ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    public BadgeDrawable getOrCreateBadge(int r3) {
        validateMenuItemId(r3);
        BadgeDrawable r0 = this.badgeDrawables.get(r3);
        if (r0 != null) goto L5;
        r0 = BadgeDrawable.create(getContext());
        this.badgeDrawables.put(r3, r0);
    L5:
        BottomNavigationItemView r2 = findItemView(r3);
        if (r2 == null) goto L8;
        r2.setBadge(r0);
    L8:
        return r0;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder r1) {
        this.menu = r1;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r3) {
        super.onInitializeAccessibilityNodeInfo(r3);
        AccessibilityNodeInfoCompat.wrap(r3).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.menu.getVisibleItems().size(), false, 1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        int r10 = getChildCount();
        int r11 = r8 - r6;
        int r12 = r9 - r7;
        int r13 = 0;
        int r0 = 0;
    L3:
        if (r13 >= r10) goto L13;
        View r1 = getChildAt(r13);
        if (r1.getVisibility() == 8) goto L12;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L10;
        int r2 = r11 - r0;
        r1.layout(r2 - r1.getMeasuredWidth(), 0, r2, r12);
    L11:
        r0 = r0 + r1.getMeasuredWidth();
        goto L12
    L10:
        r1.layout(r0, 0, r1.getMeasuredWidth() + r0, r12);
    L12:
        r13 = r13 + 1;
        goto L3
    }

    @Override // android.view.View
    public void onMeasure(int r11, int r12) {
        int r13 = View.MeasureSpec.getSize(r11);
        int r14 = this.menu.getVisibleItems().size();
        int r0 = getChildCount();
        int r1 = View.MeasureSpec.makeMeasureSpec(this.itemHeight, BasicMeasure.EXACTLY);
        int r5 = 1;
        if (isShifting(this.labelVisibilityMode, r14) == true) goto L5;
    L30:
        if (r14 == 0) goto L33;
        r5 = r14;
    L33:
        int r3 = Math.min(r13 / r5, this.activeItemMaxWidth);
        int r15 = r13 - (r14 * r3);
        int r16 = 0;
    L34:
        if (r16 >= r0) goto L42;
        if (getChildAt(r16).getVisibility() == 8) goto L40;
        int[] r6 = this.tempChildWidths;
        r6[r16] = r3;
        if (r15 <= 0) goto L41;
        r6[r16] = r3 + 1;
        r15 = r15 - 1;
    L41:
        r16 = r16 + 1;
        goto L34
    L40:
        this.tempChildWidths[r16] = 0;
    L42:
        int r17 = 0;
        int r18 = 0;
    L43:
        if (r17 >= r0) goto L49;
        View r4 = getChildAt(r17);
        if (r4.getVisibility() == 8) goto L48;
        r4.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths[r17], BasicMeasure.EXACTLY), r1);
        r4.getLayoutParams().width = r4.getMeasuredWidth();
        r18 = r18 + r4.getMeasuredWidth();
    L48:
        r17 = r17 + 1;
        goto L43
    L49:
        setMeasuredDimension(View.resolveSizeAndState(r18, View.MeasureSpec.makeMeasureSpec(r18, BasicMeasure.EXACTLY), 0), View.resolveSizeAndState(this.itemHeight, r1, 0));
        return;
    L5:
        if (this.itemHorizontalTranslationEnabled == false) goto L30;
        View r7 = getChildAt(this.selectedItemPosition);
        int r8 = this.activeItemMinWidth;
        if (r7.getVisibility() == 8) goto L10;
        r7.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), r1);
        r8 = Math.max(r8, r7.getMeasuredWidth());
    L10:
        if (r7.getVisibility() == 8) goto L12;
        int r9 = 1;
    L13:
        int r19 = r14 - r9;
        int r10 = Math.min(r13 - (this.inactiveItemMinWidth * r19), Math.min(r8, this.activeItemMaxWidth));
        int r110 = r13 - r10;
        if (r19 == 0) goto L17;
        r5 = r19;
    L17:
        int r20 = Math.min(r110 / r5, this.inactiveItemMaxWidth);
        int r111 = r110 - (r19 * r20);
        int r112 = 0;
    L18:
        if (r112 >= r0) goto L42;
        if (getChildAt(r112).getVisibility() == 8) goto L28;
        int[] r21 = this.tempChildWidths;
        if (r112 != this.selectedItemPosition) goto L24;
        int r22 = r10;
    L25:
        r21[r112] = r22;
        if (r111 <= 0) goto L29;
        r21[r112] = r22 + 1;
        r111 = r111 - 1;
    L29:
        r112 = r112 + 1;
        goto L18
    L24:
        r22 = r20;
        goto L25
    L28:
        this.tempChildWidths[r112] = 0;
        goto L29
    L12:
        r9 = 0;
        goto L13
    }

    public void removeBadge(int r3) {
        validateMenuItemId(r3);
        BadgeDrawable r0 = this.badgeDrawables.get(r3);
        BottomNavigationItemView r1 = findItemView(r3);
        if (r1 == null) goto L5;
        r1.removeBadge();
    L5:
        if (r0 == null) goto L8;
        this.badgeDrawables.remove(r3);
        return;
    }

    public void setBadgeDrawables(SparseArray<BadgeDrawable> r5) {
        this.badgeDrawables = r5;
        BottomNavigationItemView[] r4 = this.buttons;
        if (r4 == null) goto L7;
        int r0 = r4.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        BottomNavigationItemView r2 = r4[r1];
        r2.setBadge(r5.get(r2.getId()));
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setIconTintList(ColorStateList r4) {
        this.itemIconTint = r4;
        BottomNavigationItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setIconTintList(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemBackground(@Nullable Drawable r4) {
        this.itemBackground = r4;
        BottomNavigationItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setItemBackground(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemBackgroundRes(int r4) {
        this.itemBackgroundRes = r4;
        BottomNavigationItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setItemBackground(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemHorizontalTranslationEnabled(boolean r1) {
        this.itemHorizontalTranslationEnabled = r1;
    }

    public void setItemIconSize(@Dimension int r4) {
        this.itemIconSize = r4;
        BottomNavigationItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setIconSize(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemTextAppearanceActive(@StyleRes int r6) {
        this.itemTextAppearanceActive = r6;
        BottomNavigationItemView[] r0 = this.buttons;
        if (r0 == null) goto L10;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L14;
        BottomNavigationItemView r3 = r0[r2];
        r3.setTextAppearanceActive(r6);
        ColorStateList r4 = this.itemTextColorFromUser;
        if (r4 == null) goto L9;
        r3.setTextColor(r4);
    L9:
        r2 = r2 + 1;
        goto L5
    L14:
        return;
    }

    public void setItemTextAppearanceInactive(@StyleRes int r6) {
        this.itemTextAppearanceInactive = r6;
        BottomNavigationItemView[] r0 = this.buttons;
        if (r0 == null) goto L10;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L14;
        BottomNavigationItemView r3 = r0[r2];
        r3.setTextAppearanceInactive(r6);
        ColorStateList r4 = this.itemTextColorFromUser;
        if (r4 == null) goto L9;
        r3.setTextColor(r4);
    L9:
        r2 = r2 + 1;
        goto L5
    L14:
        return;
    }

    public void setItemTextColor(ColorStateList r4) {
        this.itemTextColorFromUser = r4;
        BottomNavigationItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setTextColor(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setLabelVisibilityMode(int r1) {
        this.labelVisibilityMode = r1;
    }

    public void setPresenter(BottomNavigationPresenter r1) {
        this.presenter = r1;
    }

    public void tryRestoreSelectedItemId(int r5) {
        int r0 = this.menu.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        MenuItem r2 = this.menu.getItem(r1);
        if (r5 == r2.getItemId()) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        this.selectedItemId = r5;
        this.selectedItemPosition = r1;
        r2.setChecked(true);
        return;
    }

    public void updateMenuView() {
        MenuBuilder r0 = this.menu;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.buttons == null) goto L28;
        int r1 = r0.size();
        if (r1 == this.buttons.length) goto L11;
        buildMenuView();
        return;
    L11:
        int r2 = this.selectedItemId;
        int r3 = 0;
    L12:
        if (r3 >= r1) goto L18;
        MenuItem r4 = this.menu.getItem(r3);
        if (r4.isChecked() == false) goto L16;
        this.selectedItemId = r4.getItemId();
        this.selectedItemPosition = r3;
    L16:
        r3 = r3 + 1;
        goto L12
    L18:
        if (r2 == this.selectedItemId) goto L20;
        TransitionManager.beginDelayedTransition(this, this.set);
    L20:
        boolean r5 = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        int r6 = 0;
    L21:
        if (r6 >= r1) goto L29;
        this.presenter.setUpdateSuspended(true);
        this.buttons[r6].setLabelVisibilityMode(this.labelVisibilityMode);
        this.buttons[r6].setShifting(r5);
        this.buttons[r6].initialize((MenuItemImpl) this.menu.getItem(r6), 0);
        this.presenter.setUpdateSuspended(false);
        r6 = r6 + 1;
        goto L21
    L29:
        return;
    }

    public BottomNavigationMenuView(Context r4, AttributeSet r5) {
        super(r4, r5);
        this.itemPool = new Pools.SynchronizedPool(5);
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.badgeDrawables = new SparseArray(5);
        Resources r0 = getResources();
        this.inactiveItemMaxWidth = r0.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = r0.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = r0.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = r0.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_active_item_min_width);
        this.itemHeight = r0.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_height);
        this.itemTextColorDefault = createDefaultColorStateList(R.attr.textColorSecondary);
        AutoTransition r1 = new AutoTransition();
        this.set = r1;
        r1.setOrdering(0);
        r1.setDuration(ACTIVE_ANIMATION_DURATION_MS);
        r1.setInterpolator(new FastOutSlowInInterpolator());
        r1.addTransition(new TextScale());
        this.onClickListener = new AnonymousClass1(this);
        this.tempChildWidths = new int[5];
        ViewCompat.setImportantForAccessibility(this, 1);
    }
}
