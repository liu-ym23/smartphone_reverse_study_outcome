package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationView extends FrameLayout {
    private static final int DEF_STYLE_RES = 0;
    private static final int MENU_PRESENTER_ID = 1;

    @Nullable
    private ColorStateList itemRippleColor;

    @NonNull
    private final MenuBuilder menu;
    private MenuInflater menuInflater;

    @NonNull
    @VisibleForTesting
    final BottomNavigationMenuView menuView;
    private final BottomNavigationPresenter presenter;
    private OnNavigationItemReselectedListener reselectedListener;
    private OnNavigationItemSelectedListener selectedListener;

    public interface OnNavigationItemReselectedListener {
        void onNavigationItemReselected(@NonNull MenuItem r1);
    }

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem r1);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        @Nullable
        Bundle menuPresenterState;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        private void readFromParcel(@NonNull Parcel r1, ClassLoader r2) {
            this.menuPresenterState = r1.readBundle(r2);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeBundle(this.menuPresenterState);
        }

        public SavedState(@NonNull Parcel r1, ClassLoader r2) {
            super(r1, r2);
            if (r2 != null) goto L5;
            r2 = getClass().getClassLoader();
        L5:
            readFromParcel(r1, r2);
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_BottomNavigationView;
    }

    public BottomNavigationView(@NonNull Context r2) {
        this(r2, null);
    }

    public static /* synthetic */ OnNavigationItemReselectedListener access$000(BottomNavigationView r0) {
        return r0.reselectedListener;
    }

    public static /* synthetic */ OnNavigationItemSelectedListener access$100(BottomNavigationView r0) {
        return r0.selectedListener;
    }

    private void addCompatibilityTopDivider(Context r4) {
        View r0 = new View(r4);
        r0.setBackgroundColor(ContextCompat.getColor(r4, R.color.design_bottom_navigation_shadow_color));
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
        addView(r0);
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new AnonymousClass2(this));
    }

    @NonNull
    private MaterialShapeDrawable createMaterialShapeDrawableBackground(Context r3) {
        MaterialShapeDrawable r0 = new MaterialShapeDrawable();
        Drawable r2 = getBackground();
        if ((r2 instanceof ColorDrawable) == false) goto L5;
        r0.setFillColor(ColorStateList.valueOf(((ColorDrawable) r2).getColor()));
    L5:
        r0.initializeElevationOverlay(r3);
        return r0;
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater != null) goto L6;
        this.menuInflater = new SupportMenuInflater(getContext());
    L6:
        return this.menuInflater;
    }

    @Nullable
    public BadgeDrawable getBadge(int r1) {
        return this.menuView.getBadge(r1);
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.menuView.getItemBackground();
    }

    @DrawableRes
    @Deprecated
    public int getItemBackgroundResource() {
        return this.menuView.getItemBackgroundRes();
    }

    @Dimension
    public int getItemIconSize() {
        return this.menuView.getItemIconSize();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.menuView.getIconTintList();
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.itemRippleColor;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.menuView.getItemTextAppearanceActive();
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.menuView.getItemTextAppearanceInactive();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.menuView.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.menuView.getLabelVisibilityMode();
    }

    public int getMaxItemCount() {
        return 5;
    }

    @NonNull
    public Menu getMenu() {
        return this.menu;
    }

    public BadgeDrawable getOrCreateBadge(int r1) {
        return this.menuView.getOrCreateBadge(r1);
    }

    @IdRes
    public int getSelectedItemId() {
        return this.menuView.getSelectedItemId();
    }

    public void inflateMenu(int r4) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(r4, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(true);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.menuView.isItemHorizontalTranslationEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        this.menu.restorePresenterStates(r3.menuPresenterState);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        Bundle r0 = new Bundle();
        r1.menuPresenterState = r0;
        this.menu.savePresenterStates(r0);
        return r1;
    }

    public void removeBadge(int r1) {
        this.menuView.removeBadge(r1);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r1) {
        super.setElevation(r1);
        MaterialShapeUtils.setElevation(this, r1);
    }

    public void setItemBackground(@Nullable Drawable r2) {
        this.menuView.setItemBackground(r2);
        this.itemRippleColor = null;
    }

    public void setItemBackgroundResource(@DrawableRes int r2) {
        this.menuView.setItemBackgroundRes(r2);
        this.itemRippleColor = null;
    }

    public void setItemHorizontalTranslationEnabled(boolean r2) {
        if (this.menuView.isItemHorizontalTranslationEnabled() == r2) goto L6;
        this.menuView.setItemHorizontalTranslationEnabled(r2);
        this.presenter.updateMenuView(false);
        return;
    }

    public void setItemIconSize(@Dimension int r1) {
        this.menuView.setItemIconSize(r1);
    }

    public void setItemIconSizeRes(@DimenRes int r2) {
        setItemIconSize(getResources().getDimensionPixelSize(r2));
    }

    public void setItemIconTintList(@Nullable ColorStateList r1) {
        this.menuView.setIconTintList(r1);
    }

    public void setItemRippleColor(@Nullable ColorStateList r3) {
        if (this.itemRippleColor != r3) goto L9;
        if (r3 == null) goto L6;
        return;
    L6:
        if (this.menuView.getItemBackground() == null) goto L15;
        this.menuView.setItemBackground(null);
        return;
    L15:
        return;
    L9:
        this.itemRippleColor = r3;
        if (r3 != null) goto L12;
        this.menuView.setItemBackground(null);
        return;
    L12:
        ColorStateList r4 = RippleUtils.convertToRippleDrawableColor(r3);
        this.menuView.setItemBackground(new RippleDrawable(r4, null, null));
    }

    public void setItemTextAppearanceActive(@StyleRes int r1) {
        this.menuView.setItemTextAppearanceActive(r1);
    }

    public void setItemTextAppearanceInactive(@StyleRes int r1) {
        this.menuView.setItemTextAppearanceInactive(r1);
    }

    public void setItemTextColor(@Nullable ColorStateList r1) {
        this.menuView.setItemTextColor(r1);
    }

    public void setLabelVisibilityMode(int r2) {
        if (this.menuView.getLabelVisibilityMode() == r2) goto L6;
        this.menuView.setLabelVisibilityMode(r2);
        this.presenter.updateMenuView(false);
        return;
    }

    public void setOnNavigationItemReselectedListener(@Nullable OnNavigationItemReselectedListener r1) {
        this.reselectedListener = r1;
    }

    public void setOnNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener r1) {
        this.selectedListener = r1;
    }

    public void setSelectedItemId(@IdRes int r3) {
        MenuItem r4 = this.menu.findItem(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.menu.performItemAction(r4, this.presenter, 0) == true) goto L9;
        r4.setChecked(true);
        return;
    }

    public BottomNavigationView(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(@NonNull Context r12, @Nullable AttributeSet r13, int r14) {
        super(MaterialThemeOverlay.wrap(r12, r13, r14, DEF_STYLE_RES), r13, r14);
        BottomNavigationPresenter r15 = new BottomNavigationPresenter();
        this.presenter = r15;
        Context r6 = getContext();
        MenuBuilder r7 = new BottomNavigationMenu(r6);
        this.menu = r7;
        BottomNavigationMenuView r8 = new BottomNavigationMenuView(r6);
        this.menuView = r8;
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-2, -2);
        r9.gravity = 17;
        r8.setLayoutParams(r9);
        r15.setBottomNavigationMenuView(r8);
        r15.setId(1);
        r8.setPresenter(r15);
        r7.addMenuPresenter(r15);
        r15.initForMenu(getContext(), r7);
        TintTypedArray r16 = ThemeEnforcement.obtainTintedStyledAttributes(r6, r13, R.styleable.BottomNavigationView, r14, R.style.Widget_Design_BottomNavigationView, new int[]{R.styleable.BottomNavigationView_itemTextAppearanceInactive, R.styleable.BottomNavigationView_itemTextAppearanceActive});
        if (r16.hasValue(R.styleable.BottomNavigationView_itemIconTint) == false) goto L5;
        r8.setIconTintList(r16.getColorStateList(R.styleable.BottomNavigationView_itemIconTint));
    L6:
        setItemIconSize(r16.getDimensionPixelSize(R.styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_icon_size)));
        if (r16.hasValue(R.styleable.BottomNavigationView_itemTextAppearanceInactive) == false) goto L10;
        setItemTextAppearanceInactive(r16.getResourceId(R.styleable.BottomNavigationView_itemTextAppearanceInactive, 0));
    L10:
        if (r16.hasValue(R.styleable.BottomNavigationView_itemTextAppearanceActive) == false) goto L13;
        setItemTextAppearanceActive(r16.getResourceId(R.styleable.BottomNavigationView_itemTextAppearanceActive, 0));
    L13:
        if (r16.hasValue(R.styleable.BottomNavigationView_itemTextColor) == false) goto L16;
        setItemTextColor(r16.getColorStateList(R.styleable.BottomNavigationView_itemTextColor));
    L16:
        if (getBackground() != null) goto L18;
    L19:
        ViewCompat.setBackground(this, createMaterialShapeDrawableBackground(r6));
    L21:
        if (r16.hasValue(R.styleable.BottomNavigationView_elevation) == false) goto L23;
        ViewCompat.setElevation(this, r16.getDimensionPixelSize(R.styleable.BottomNavigationView_elevation, 0));
    L23:
        DrawableCompat.setTintList(getBackground().mutate(), MaterialResources.getColorStateList(r6, r16, R.styleable.BottomNavigationView_backgroundTint));
        setLabelVisibilityMode(r16.getInteger(R.styleable.BottomNavigationView_labelVisibilityMode, -1));
        setItemHorizontalTranslationEnabled(r16.getBoolean(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        int r17 = r16.getResourceId(R.styleable.BottomNavigationView_itemBackground, 0);
        if (r17 == 0) goto L26;
        r8.setItemBackgroundRes(r17);
    L28:
        if (r16.hasValue(R.styleable.BottomNavigationView_menu) == false) goto L30;
        inflateMenu(r16.getResourceId(R.styleable.BottomNavigationView_menu, 0));
    L30:
        r16.recycle();
        addView(r8, r9);
        r7.setCallback(new AnonymousClass1(this));
        applyWindowInsets();
        return;
    L26:
        setItemRippleColor(MaterialResources.getColorStateList(r6, r16, R.styleable.BottomNavigationView_itemRippleColor));
        goto L28
    L18:
        if ((getBackground() instanceof ColorDrawable) == false) goto L21;
    L5:
        r8.setIconTintList(r8.createDefaultColorStateList(android.R.attr.textColorSecondary));
        goto L6
    }
}
