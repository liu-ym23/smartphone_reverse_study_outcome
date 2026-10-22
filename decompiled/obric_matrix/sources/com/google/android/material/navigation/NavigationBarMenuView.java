package com.google.android.material.navigation;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int[] DISABLED_STATE_SET = null;
    private static final int ITEM_POOL_SIZE = 5;
    private static final int NO_PADDING = -1;

    @NonNull
    private SparseArray<BadgeDrawable> badgeDrawables;

    @Nullable
    private NavigationBarItemView[] buttons;
    private ColorStateList itemActiveIndicatorColor;
    private boolean itemActiveIndicatorEnabled;
    private int itemActiveIndicatorHeight;
    private int itemActiveIndicatorMarginHorizontal;
    private boolean itemActiveIndicatorResizeable;
    private ShapeAppearanceModel itemActiveIndicatorShapeAppearance;
    private int itemActiveIndicatorWidth;
    private Drawable itemBackground;
    private int itemBackgroundRes;

    @Dimension
    private int itemIconSize;

    @Nullable
    private ColorStateList itemIconTint;
    private int itemPaddingBottom;
    private int itemPaddingTop;
    private final Pools.Pool<NavigationBarItemView> itemPool;

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

    @NonNull
    private final SparseArray<View.OnTouchListener> onTouchListeners;
    private NavigationBarPresenter presenter;
    private int selectedItemId;
    private int selectedItemPosition;

    @NonNull
    private final TransitionSet set;

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DISABLED_STATE_SET = new int[]{-16842910};
    }

    public NavigationBarMenuView(@NonNull Context r5) {
        super(r5);
        this.itemPool = new Pools.SynchronizedPool(5);
        this.onTouchListeners = new SparseArray(5);
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.badgeDrawables = new SparseArray(5);
        this.itemPaddingTop = -1;
        this.itemPaddingBottom = -1;
        this.itemActiveIndicatorResizeable = false;
        this.itemTextColorDefault = createDefaultColorStateList(R.attr.textColorSecondary);
        AutoTransition r0 = new AutoTransition();
        this.set = r0;
        r0.setOrdering(0);
        r0.setDuration(MotionUtils.resolveThemeDuration(getContext(), com.google.android.material.R.attr.motionDurationLong1, getResources().getInteger(com.google.android.material.R.integer.material_motion_duration_long_1)));
        r0.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), com.google.android.material.R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        r0.addTransition(new TextScale());
        this.onClickListener = new AnonymousClass1(this);
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    static /* synthetic */ NavigationBarPresenter access$000(NavigationBarMenuView r0) {
        return r0.presenter;
    }

    static /* synthetic */ MenuBuilder access$100(NavigationBarMenuView r0) {
        return r0.menu;
    }

    @Nullable
    private Drawable createItemActiveIndicatorDrawable() {
        if (this.itemActiveIndicatorShapeAppearance != null) goto L5;
        return null;
    L5:
        if (this.itemActiveIndicatorColor == null) goto L10;
        MaterialShapeDrawable r0 = new MaterialShapeDrawable(this.itemActiveIndicatorShapeAppearance);
        r0.setFillColor(this.itemActiveIndicatorColor);
        return r0;
    L10:
        return null;
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView r0 = this.itemPool.acquire();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return createNavigationBarItemView(getContext());
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

    private void setBadgeIfNeeded(@NonNull NavigationBarItemView r3) {
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

    @SuppressLint({"ClickableViewAccessibility"})
    public void buildMenuView() {
        removeAllViews();
        NavigationBarItemView[] r0 = this.buttons;
        if (r0 == null) goto L11;
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        NavigationBarItemView r4 = r0[r3];
        if (r4 == null) goto L9;
        this.itemPool.release(r4);
        r4.clear();
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
        this.buttons = new NavigationBarItemView[this.menu.size()];
        boolean r1 = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        int r5 = 0;
    L16:
        if (r5 >= this.menu.size()) goto L32;
        this.presenter.setUpdateSuspended(true);
        this.menu.getItem(r5).setCheckable(true);
        this.presenter.setUpdateSuspended(false);
        NavigationBarItemView r6 = getNewItem();
        this.buttons[r5] = r6;
        r6.setIconTintList(this.itemIconTint);
        r6.setIconSize(this.itemIconSize);
        r6.setTextColor(this.itemTextColorDefault);
        r6.setTextAppearanceInactive(this.itemTextAppearanceInactive);
        r6.setTextAppearanceActive(this.itemTextAppearanceActive);
        r6.setTextColor(this.itemTextColorFromUser);
        int r7 = this.itemPaddingTop;
        if (r7 == (-1)) goto L20;
        r6.setItemPaddingTop(r7);
    L20:
        int r8 = this.itemPaddingBottom;
        if (r8 == (-1)) goto L23;
        r6.setItemPaddingBottom(r8);
    L23:
        r6.setActiveIndicatorWidth(this.itemActiveIndicatorWidth);
        r6.setActiveIndicatorHeight(this.itemActiveIndicatorHeight);
        r6.setActiveIndicatorMarginHorizontal(this.itemActiveIndicatorMarginHorizontal);
        r6.setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
        r6.setActiveIndicatorResizeable(this.itemActiveIndicatorResizeable);
        r6.setActiveIndicatorEnabled(this.itemActiveIndicatorEnabled);
        Drawable r9 = this.itemBackground;
        if (r9 == null) goto L26;
        r6.setItemBackground(r9);
    L27:
        r6.setShifting(r1);
        r6.setLabelVisibilityMode(this.labelVisibilityMode);
        MenuItemImpl r10 = (MenuItemImpl) this.menu.getItem(r5);
        r6.initialize(r10, 0);
        r6.setItemPosition(r5);
        int r11 = r10.getItemId();
        r6.setOnTouchListener(this.onTouchListeners.get(r11));
        r6.setOnClickListener(this.onClickListener);
        int r12 = this.selectedItemId;
        if (r12 == 0) goto L31;
        if (r11 != r12) goto L31;
        this.selectedItemPosition = r5;
    L31:
        setBadgeIfNeeded(r6);
        addView(r6);
        r5 = r5 + 1;
        goto L16
    L26:
        r6.setItemBackground(this.itemBackgroundRes);
        goto L27
    L32:
        int r13 = Math.min(this.menu.size() - 1, this.selectedItemPosition);
        this.selectedItemPosition = r13;
        this.menu.getItem(r13).setChecked(true);
    }

    @Nullable
    public ColorStateList createDefaultColorStateList(int r10) {
        TypedValue r0 = new TypedValue();
        if (getContext().getTheme().resolveAttribute(r10, r0, true) == true) goto L5;
        return null;
    L5:
        ColorStateList r11 = AppCompatResources.getColorStateList(getContext(), r0.resourceId);
        if (getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, r0, true) == true) goto L8;
        return null;
    L8:
        int r9 = r0.data;
        int r1 = r11.getDefaultColor();
        int[] r5 = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{r5, CHECKED_STATE_SET, ViewGroup.EMPTY_STATE_SET}, new int[]{r11.getColorForState(r5, r1), r9, r1});
    }

    @NonNull
    protected abstract NavigationBarItemView createNavigationBarItemView(@NonNull Context r1);

    @Nullable
    public NavigationBarItemView findItemView(int r5) {
        validateMenuItemId(r5);
        NavigationBarItemView[] r4 = this.buttons;
        if (r4 == null) goto L10;
        int r0 = r4.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L14;
        NavigationBarItemView r2 = r4[r1];
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

    SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.badgeDrawables;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.itemActiveIndicatorColor;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.itemActiveIndicatorEnabled;
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.itemActiveIndicatorHeight;
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.itemActiveIndicatorMarginHorizontal;
    }

    @Nullable
    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.itemActiveIndicatorShapeAppearance;
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.itemActiveIndicatorWidth;
    }

    @Nullable
    public Drawable getItemBackground() {
        NavigationBarItemView[] r0 = this.buttons;
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

    @Px
    public int getItemPaddingBottom() {
        return this.itemPaddingBottom;
    }

    @Px
    public int getItemPaddingTop() {
        return this.itemPaddingTop;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    @Nullable
    protected MenuBuilder getMenu() {
        return this.menu;
    }

    BadgeDrawable getOrCreateBadge(int r3) {
        validateMenuItemId(r3);
        BadgeDrawable r0 = this.badgeDrawables.get(r3);
        if (r0 != null) goto L5;
        r0 = BadgeDrawable.create(getContext());
        this.badgeDrawables.put(r3, r0);
    L5:
        NavigationBarItemView r2 = findItemView(r3);
        if (r2 == null) goto L8;
        r2.setBadge(r0);
    L8:
        return r0;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    protected int getSelectedItemPosition() {
        return this.selectedItemPosition;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(@NonNull MenuBuilder r1) {
        this.menu = r1;
    }

    protected boolean isItemActiveIndicatorResizeable() {
        return this.itemActiveIndicatorResizeable;
    }

    protected boolean isShifting(int r3, int r4) {
        if (r3 == (-1)) goto L5;
        if (r3 != 0) goto L10;
        return true;
    L10:
        return false;
    L5:
        if (r4 <= 3) goto L10;
        return true;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r3) {
        super.onInitializeAccessibilityNodeInfo(r3);
        AccessibilityNodeInfoCompat.wrap(r3).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.menu.getVisibleItems().size(), false, 1));
    }

    void removeBadge(int r3) {
        validateMenuItemId(r3);
        BadgeDrawable r0 = this.badgeDrawables.get(r3);
        NavigationBarItemView r1 = findItemView(r3);
        if (r1 == null) goto L5;
        r1.removeBadge();
    L5:
        if (r0 == null) goto L8;
        this.badgeDrawables.remove(r3);
        return;
    }

    void setBadgeDrawables(SparseArray<BadgeDrawable> r5) {
        this.badgeDrawables = r5;
        NavigationBarItemView[] r4 = this.buttons;
        if (r4 == null) goto L7;
        int r0 = r4.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        NavigationBarItemView r2 = r4[r1];
        r2.setBadge(r5.get(r2.getId()));
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setIconTintList(@Nullable ColorStateList r4) {
        this.itemIconTint = r4;
        NavigationBarItemView[] r3 = this.buttons;
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

    public void setItemActiveIndicatorColor(@Nullable ColorStateList r5) {
        this.itemActiveIndicatorColor = r5;
        NavigationBarItemView[] r6 = this.buttons;
        if (r6 == null) goto L7;
        int r0 = r6.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r6[r1].setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorEnabled(boolean r4) {
        this.itemActiveIndicatorEnabled = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setActiveIndicatorEnabled(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorHeight(@Px int r4) {
        this.itemActiveIndicatorHeight = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setActiveIndicatorHeight(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int r4) {
        this.itemActiveIndicatorMarginHorizontal = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setActiveIndicatorMarginHorizontal(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    protected void setItemActiveIndicatorResizeable(boolean r4) {
        this.itemActiveIndicatorResizeable = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setActiveIndicatorResizeable(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable ShapeAppearanceModel r5) {
        this.itemActiveIndicatorShapeAppearance = r5;
        NavigationBarItemView[] r6 = this.buttons;
        if (r6 == null) goto L7;
        int r0 = r6.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r6[r1].setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorWidth(@Px int r4) {
        this.itemActiveIndicatorWidth = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setActiveIndicatorWidth(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemBackground(@Nullable Drawable r4) {
        this.itemBackground = r4;
        NavigationBarItemView[] r3 = this.buttons;
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
        NavigationBarItemView[] r3 = this.buttons;
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

    public void setItemIconSize(@Dimension int r4) {
        this.itemIconSize = r4;
        NavigationBarItemView[] r3 = this.buttons;
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

    @SuppressLint({"ClickableViewAccessibility"})
    public void setItemOnTouchListener(int r5, @Nullable View.OnTouchListener r6) {
        SparseArray<View.OnTouchListener> r0 = this.onTouchListeners;
        if (r6 != null) goto L5;
        r0.remove(r5);
    L6:
        NavigationBarItemView[] r4 = this.buttons;
        if (r4 == null) goto L14;
        int r1 = r4.length;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L18;
        NavigationBarItemView r3 = r4[r2];
        if (r3.getItemData().getItemId() != r5) goto L13;
        r3.setOnTouchListener(r6);
    L13:
        r2 = r2 + 1;
        goto L9
    L18:
        return;
    L14:
        return;
    L5:
        r0.put(r5, r6);
        goto L6
    }

    public void setItemPaddingBottom(@Px int r4) {
        this.itemPaddingBottom = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setItemPaddingBottom(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemPaddingTop(@Px int r4) {
        this.itemPaddingTop = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setItemPaddingTop(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemTextAppearanceActive(@StyleRes int r6) {
        this.itemTextAppearanceActive = r6;
        NavigationBarItemView[] r0 = this.buttons;
        if (r0 == null) goto L10;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L14;
        NavigationBarItemView r3 = r0[r2];
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
        NavigationBarItemView[] r0 = this.buttons;
        if (r0 == null) goto L10;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L14;
        NavigationBarItemView r3 = r0[r2];
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

    public void setItemTextColor(@Nullable ColorStateList r4) {
        this.itemTextColorFromUser = r4;
        NavigationBarItemView[] r3 = this.buttons;
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

    public void setPresenter(@NonNull NavigationBarPresenter r1) {
        this.presenter = r1;
    }

    void tryRestoreSelectedItemId(int r5) {
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
}
