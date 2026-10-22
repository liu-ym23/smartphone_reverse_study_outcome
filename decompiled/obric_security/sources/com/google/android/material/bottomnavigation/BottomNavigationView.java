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

/* JADX INFO: loaded from: classes2.dex */
public class BottomNavigationView extends FrameLayout {
    private static final int DEF_STYLE_RES = 0;
    private static final int MENU_PRESENTER_ID = 1;
    private ColorStateList itemRippleColor;
    private final MenuBuilder menu;
    private MenuInflater menuInflater;
    final BottomNavigationMenuView menuView;
    private final BottomNavigationPresenter presenter;
    private OnNavigationItemReselectedListener reselectedListener;
    private OnNavigationItemSelectedListener selectedListener;

    public interface OnNavigationItemReselectedListener {
        void onNavigationItemReselected(MenuItem r1);
    }

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem r1);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Bundle menuPresenterState;

        public SavedState(Parcelable r1) {
            super(r1);
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            if (r2 != null) goto L5;
            r2 = getClass().getClassLoader();
        L5:
            readFromParcel(r1, r2);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeBundle(this.menuPresenterState);
        }

        private void readFromParcel(Parcel r1, ClassLoader r2) {
            this.menuPresenterState = r1.readBundle(r2);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    private boolean shouldDrawCompatibilityTopDivider() {
        return false;
    }

    public int getMaxItemCount() {
        return 5;
    }

    static /* synthetic */ OnNavigationItemReselectedListener access$000(BottomNavigationView r0) {
        return r0.reselectedListener;
    }

    static /* synthetic */ OnNavigationItemSelectedListener access$100(BottomNavigationView r0) {
        return r0.selectedListener;
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_BottomNavigationView;
    }

    public BottomNavigationView(Context r2) {
        this(r2, null);
    }

    public BottomNavigationView(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(Context r13, AttributeSet r14, int r15) {
        super(MaterialThemeOverlay.wrap(r13, r14, r15, DEF_STYLE_RES), r14, r15);
        BottomNavigationPresenter r16 = new BottomNavigationPresenter();
        this.presenter = r16;
        Context r6 = getContext();
        MenuBuilder r7 = new BottomNavigationMenu(r6);
        this.menu = r7;
        BottomNavigationMenuView r8 = new BottomNavigationMenuView(r6);
        this.menuView = r8;
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-2, -2);
        r9.gravity = 17;
        r8.setLayoutParams(r9);
        r16.setBottomNavigationMenuView(r8);
        r16.setId(1);
        r8.setPresenter(r16);
        r7.addMenuPresenter(r16);
        r16.initForMenu(getContext(), r7);
        TintTypedArray r17 = ThemeEnforcement.obtainTintedStyledAttributes(r6, r14, R.styleable.BottomNavigationView, r15, R.style.Widget_Design_BottomNavigationView, new int[]{R.styleable.BottomNavigationView_itemTextAppearanceInactive, R.styleable.BottomNavigationView_itemTextAppearanceActive});
        if (r17.hasValue(R.styleable.BottomNavigationView_itemIconTint) == false) goto L5;
        r8.setIconTintList(r17.getColorStateList(R.styleable.BottomNavigationView_itemIconTint));
    L6:
        setItemIconSize(r17.getDimensionPixelSize(R.styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_icon_size)));
        if (r17.hasValue(R.styleable.BottomNavigationView_itemTextAppearanceInactive) == false) goto L10;
        setItemTextAppearanceInactive(r17.getResourceId(R.styleable.BottomNavigationView_itemTextAppearanceInactive, 0));
    L10:
        if (r17.hasValue(R.styleable.BottomNavigationView_itemTextAppearanceActive) == false) goto L13;
        setItemTextAppearanceActive(r17.getResourceId(R.styleable.BottomNavigationView_itemTextAppearanceActive, 0));
    L13:
        if (r17.hasValue(R.styleable.BottomNavigationView_itemTextColor) == false) goto L16;
        setItemTextColor(r17.getColorStateList(R.styleable.BottomNavigationView_itemTextColor));
    L16:
        if (getBackground() != null) goto L18;
    L19:
        ViewCompat.setBackground(this, createMaterialShapeDrawableBackground(r6));
    L21:
        if (r17.hasValue(R.styleable.BottomNavigationView_elevation) == false) goto L23;
        setElevation(r17.getDimensionPixelSize(R.styleable.BottomNavigationView_elevation, 0));
    L23:
        DrawableCompat.setTintList(getBackground().mutate(), MaterialResources.getColorStateList(r6, r17, R.styleable.BottomNavigationView_backgroundTint));
        setLabelVisibilityMode(r17.getInteger(R.styleable.BottomNavigationView_labelVisibilityMode, -1));
        setItemHorizontalTranslationEnabled(r17.getBoolean(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        int r18 = r17.getResourceId(R.styleable.BottomNavigationView_itemBackground, 0);
        if (r18 == 0) goto L26;
        r8.setItemBackgroundRes(r18);
    L28:
        if (r17.hasValue(R.styleable.BottomNavigationView_menu) == false) goto L30;
        inflateMenu(r17.getResourceId(R.styleable.BottomNavigationView_menu, 0));
    L30:
        r17.recycle();
        addView(r8, r9);
        if (shouldDrawCompatibilityTopDivider() == false) goto L33;
        addCompatibilityTopDivider(r6);
    L33:
        r7.setCallback(new AnonymousClass1(this));
        applyWindowInsets();
        return;
    L26:
        setItemRippleColor(MaterialResources.getColorStateList(r6, r17, R.styleable.BottomNavigationView_itemRippleColor));
        goto L28
    L18:
        if ((getBackground() instanceof ColorDrawable) == false) goto L21;
    L5:
        r8.setIconTintList(r8.createDefaultColorStateList(android.R.attr.textColorSecondary));
        goto L6
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new AnonymousClass2(this));
    }

    private MaterialShapeDrawable createMaterialShapeDrawableBackground(Context r3) {
        MaterialShapeDrawable r0 = new MaterialShapeDrawable();
        Drawable r2 = getBackground();
        if ((r2 instanceof ColorDrawable) == false) goto L5;
        r0.setFillColor(ColorStateList.valueOf(((ColorDrawable) r2).getColor()));
    L5:
        r0.initializeElevationOverlay(r3);
        return r0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        MaterialShapeUtils.setElevation(this, r1);
    }

    public void setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener r1) {
        this.selectedListener = r1;
    }

    public void setOnNavigationItemReselectedListener(OnNavigationItemReselectedListener r1) {
        this.reselectedListener = r1;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public void inflateMenu(int r4) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(r4, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(true);
    }

    public ColorStateList getItemIconTintList() {
        return this.menuView.getIconTintList();
    }

    public void setItemIconTintList(ColorStateList r1) {
        this.menuView.setIconTintList(r1);
    }

    public void setItemIconSize(int r1) {
        this.menuView.setItemIconSize(r1);
    }

    public void setItemIconSizeRes(int r2) {
        setItemIconSize(getResources().getDimensionPixelSize(r2));
    }

    public int getItemIconSize() {
        return this.menuView.getItemIconSize();
    }

    public ColorStateList getItemTextColor() {
        return this.menuView.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList r1) {
        this.menuView.setItemTextColor(r1);
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.menuView.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int r2) {
        this.menuView.setItemBackgroundRes(r2);
        this.itemRippleColor = null;
    }

    public Drawable getItemBackground() {
        return this.menuView.getItemBackground();
    }

    public void setItemBackground(Drawable r2) {
        this.menuView.setItemBackground(r2);
        this.itemRippleColor = null;
    }

    public ColorStateList getItemRippleColor() {
        return this.itemRippleColor;
    }

    public void setItemRippleColor(ColorStateList r3) {
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

    public int getSelectedItemId() {
        return this.menuView.getSelectedItemId();
    }

    public void setSelectedItemId(int r3) {
        MenuItem r4 = this.menu.findItem(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.menu.performItemAction(r4, this.presenter, 0) == true) goto L9;
        r4.setChecked(true);
        return;
    }

    public void setLabelVisibilityMode(int r2) {
        if (this.menuView.getLabelVisibilityMode() == r2) goto L6;
        this.menuView.setLabelVisibilityMode(r2);
        this.presenter.updateMenuView(false);
        return;
    }

    public int getLabelVisibilityMode() {
        return this.menuView.getLabelVisibilityMode();
    }

    public void setItemTextAppearanceInactive(int r1) {
        this.menuView.setItemTextAppearanceInactive(r1);
    }

    public int getItemTextAppearanceInactive() {
        return this.menuView.getItemTextAppearanceInactive();
    }

    public void setItemTextAppearanceActive(int r1) {
        this.menuView.setItemTextAppearanceActive(r1);
    }

    public int getItemTextAppearanceActive() {
        return this.menuView.getItemTextAppearanceActive();
    }

    public void setItemHorizontalTranslationEnabled(boolean r2) {
        if (this.menuView.isItemHorizontalTranslationEnabled() == r2) goto L6;
        this.menuView.setItemHorizontalTranslationEnabled(r2);
        this.presenter.updateMenuView(false);
        return;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.menuView.isItemHorizontalTranslationEnabled();
    }

    public void setItemOnTouchListener(int r1, View.OnTouchListener r2) {
        this.menuView.setItemOnTouchListener(r1, r2);
    }

    public BadgeDrawable getBadge(int r1) {
        return this.menuView.getBadge(r1);
    }

    public BadgeDrawable getOrCreateBadge(int r1) {
        return this.menuView.getOrCreateBadge(r1);
    }

    public void removeBadge(int r1) {
        this.menuView.removeBadge(r1);
    }

    private void addCompatibilityTopDivider(Context r4) {
        View r0 = new View(r4);
        r0.setBackgroundColor(ContextCompat.getColor(r4, R.color.design_bottom_navigation_shadow_color));
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
        addView(r0);
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater != null) goto L6;
        this.menuInflater = new SupportMenuInflater(getContext());
    L6:
        return this.menuInflater;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.menuPresenterState = new Bundle();
        this.menu.savePresenterStates(r1.menuPresenterState);
        return r1;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        this.menu.restorePresenterStates(r3.menuPresenterState);
    }
}
