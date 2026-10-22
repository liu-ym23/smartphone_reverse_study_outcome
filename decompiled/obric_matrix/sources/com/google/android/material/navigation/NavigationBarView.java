package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NavigationBarView extends FrameLayout {
    public static final int LABEL_VISIBILITY_AUTO = -1;
    public static final int LABEL_VISIBILITY_LABELED = 1;
    public static final int LABEL_VISIBILITY_SELECTED = 0;
    public static final int LABEL_VISIBILITY_UNLABELED = 2;
    private static final int MENU_PRESENTER_ID = 1;

    @Nullable
    private ColorStateList itemRippleColor;

    @NonNull
    private final NavigationBarMenu menu;
    private MenuInflater menuInflater;

    @NonNull
    private final NavigationBarMenuView menuView;

    @NonNull
    private final NavigationBarPresenter presenter;
    private OnItemReselectedListener reselectedListener;
    private OnItemSelectedListener selectedListener;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface LabelVisibility {
    }

    public interface OnItemReselectedListener {
        void onNavigationItemReselected(@NonNull MenuItem r1);
    }

    public interface OnItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem r1);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        @Nullable
        Bundle menuPresenterState;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(@NonNull Parcel r1, ClassLoader r2) {
            super(r1, r2);
            if (r2 != null) goto L5;
            r2 = getClass().getClassLoader();
        L5:
            readFromParcel(r1, r2);
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
    }

    public NavigationBarView(@NonNull Context r12, @Nullable AttributeSet r13, @AttrRes int r14, @StyleRes int r15) {
        super(MaterialThemeOverlay.wrap(r12, r13, r14, r15), r13, r14);
        NavigationBarPresenter r16 = new NavigationBarPresenter();
        this.presenter = r16;
        Context r6 = getContext();
        int[] r2 = R.styleable.NavigationBarView;
        int r7 = R.styleable.NavigationBarView_itemTextAppearanceInactive;
        int r9 = R.styleable.NavigationBarView_itemTextAppearanceActive;
        TintTypedArray r17 = ThemeEnforcement.obtainTintedStyledAttributes(r6, r13, r2, r14, r15, new int[]{r7, r9});
        NavigationBarMenu r18 = new NavigationBarMenu(r6, getClass(), getMaxItemCount());
        this.menu = r18;
        NavigationBarMenuView r19 = createNavigationBarMenuView(r6);
        this.menuView = r19;
        r16.setMenuView(r19);
        r16.setId(1);
        r19.setPresenter(r16);
        r18.addMenuPresenter(r16);
        r16.initForMenu(getContext(), r18);
        int r110 = R.styleable.NavigationBarView_itemIconTint;
        if (r17.hasValue(r110) == false) goto L5;
        ColorStateList r111 = r17.getColorStateList(r110);
    L6:
        r19.setIconTintList(r111);
        setItemIconSize(r17.getDimensionPixelSize(R.styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (r17.hasValue(r7) == false) goto L10;
        setItemTextAppearanceInactive(r17.getResourceId(r7, 0));
    L10:
        if (r17.hasValue(r9) == false) goto L12;
        setItemTextAppearanceActive(r17.getResourceId(r9, 0));
    L12:
        int r112 = R.styleable.NavigationBarView_itemTextColor;
        if (r17.hasValue(r112) == false) goto L16;
        setItemTextColor(r17.getColorStateList(r112));
    L16:
        if (getBackground() != null) goto L18;
    L19:
        ViewCompat.setBackground(this, createMaterialShapeDrawableBackground(r6));
    L20:
        int r113 = R.styleable.NavigationBarView_itemPaddingTop;
        if (r17.hasValue(r113) == false) goto L23;
        setItemPaddingTop(r17.getDimensionPixelSize(r113, 0));
    L23:
        int r114 = R.styleable.NavigationBarView_itemPaddingBottom;
        if (r17.hasValue(r114) == false) goto L26;
        setItemPaddingBottom(r17.getDimensionPixelSize(r114, 0));
    L26:
        int r115 = R.styleable.NavigationBarView_elevation;
        if (r17.hasValue(r115) == false) goto L29;
        setElevation(r17.getDimensionPixelSize(r115, 0));
    L29:
        DrawableCompat.setTintList(getBackground().mutate(), MaterialResources.getColorStateList(r6, r17, R.styleable.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(r17.getInteger(R.styleable.NavigationBarView_labelVisibilityMode, -1));
        int r116 = r17.getResourceId(R.styleable.NavigationBarView_itemBackground, 0);
        if (r116 == 0) goto L32;
        r19.setItemBackgroundRes(r116);
    L33:
        int r117 = r17.getResourceId(R.styleable.NavigationBarView_itemActiveIndicatorStyle, 0);
        if (r117 == 0) goto L36;
        setItemActiveIndicatorEnabled(true);
        TypedArray r118 = r6.obtainStyledAttributes(r117, R.styleable.NavigationBarActiveIndicator);
        setItemActiveIndicatorWidth(r118.getDimensionPixelSize(R.styleable.NavigationBarActiveIndicator_android_width, 0));
        setItemActiveIndicatorHeight(r118.getDimensionPixelSize(R.styleable.NavigationBarActiveIndicator_android_height, 0));
        setItemActiveIndicatorMarginHorizontal(r118.getDimensionPixelOffset(R.styleable.NavigationBarActiveIndicator_marginHorizontal, 0));
        setItemActiveIndicatorColor(MaterialResources.getColorStateList(r6, r118, R.styleable.NavigationBarActiveIndicator_android_color));
        setItemActiveIndicatorShapeAppearance(ShapeAppearanceModel.builder(r6, r118.getResourceId(R.styleable.NavigationBarActiveIndicator_shapeAppearance, 0), 0).build());
        r118.recycle();
    L36:
        int r119 = R.styleable.NavigationBarView_menu;
        if (r17.hasValue(r119) == false) goto L39;
        inflateMenu(r17.getResourceId(r119, 0));
    L39:
        r17.recycle();
        addView(r19);
        r18.setCallback(new AnonymousClass1(this));
        return;
    L32:
        setItemRippleColor(MaterialResources.getColorStateList(r6, r17, R.styleable.NavigationBarView_itemRippleColor));
        goto L33
    L18:
        if ((getBackground() instanceof ColorDrawable) == false) goto L20;
    L5:
        r111 = r19.createDefaultColorStateList(android.R.attr.textColorSecondary);
        goto L6
    }

    static /* synthetic */ OnItemReselectedListener access$000(NavigationBarView r0) {
        return r0.reselectedListener;
    }

    static /* synthetic */ OnItemSelectedListener access$100(NavigationBarView r0) {
        return r0.selectedListener;
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

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected abstract NavigationBarMenuView createNavigationBarMenuView(@NonNull Context r1);

    @Nullable
    public BadgeDrawable getBadge(int r1) {
        return this.menuView.getBadge(r1);
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.menuView.getItemActiveIndicatorColor();
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.menuView.getItemActiveIndicatorHeight();
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.menuView.getItemActiveIndicatorMarginHorizontal();
    }

    @Nullable
    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.menuView.getItemActiveIndicatorShapeAppearance();
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.menuView.getItemActiveIndicatorWidth();
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

    @Px
    public int getItemPaddingBottom() {
        return this.menuView.getItemPaddingBottom();
    }

    @Px
    public int getItemPaddingTop() {
        return this.menuView.getItemPaddingTop();
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

    public abstract int getMaxItemCount();

    @NonNull
    public Menu getMenu() {
        return this.menu;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MenuView getMenuView() {
        return this.menuView;
    }

    @NonNull
    public BadgeDrawable getOrCreateBadge(int r1) {
        return this.menuView.getOrCreateBadge(r1);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationBarPresenter getPresenter() {
        return this.presenter;
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

    public boolean isItemActiveIndicatorEnabled() {
        return this.menuView.getItemActiveIndicatorEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@Nullable Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        this.menu.restorePresenterStates(r3.menuPresenterState);
    }

    @Override // android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
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
    public void setElevation(float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        super.setElevation(r3);
    L5:
        MaterialShapeUtils.setElevation(this, r3);
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList r1) {
        this.menuView.setItemActiveIndicatorColor(r1);
    }

    public void setItemActiveIndicatorEnabled(boolean r1) {
        this.menuView.setItemActiveIndicatorEnabled(r1);
    }

    public void setItemActiveIndicatorHeight(@Px int r1) {
        this.menuView.setItemActiveIndicatorHeight(r1);
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int r1) {
        this.menuView.setItemActiveIndicatorMarginHorizontal(r1);
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable ShapeAppearanceModel r1) {
        this.menuView.setItemActiveIndicatorShapeAppearance(r1);
    }

    public void setItemActiveIndicatorWidth(@Px int r1) {
        this.menuView.setItemActiveIndicatorWidth(r1);
    }

    public void setItemBackground(@Nullable Drawable r2) {
        this.menuView.setItemBackground(r2);
        this.itemRippleColor = null;
    }

    public void setItemBackgroundResource(@DrawableRes int r2) {
        this.menuView.setItemBackgroundRes(r2);
        this.itemRippleColor = null;
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

    public void setItemOnTouchListener(int r1, @Nullable View.OnTouchListener r2) {
        this.menuView.setItemOnTouchListener(r1, r2);
    }

    public void setItemPaddingBottom(@Px int r1) {
        this.menuView.setItemPaddingBottom(r1);
    }

    public void setItemPaddingTop(@Px int r1) {
        this.menuView.setItemPaddingTop(r1);
    }

    public void setItemRippleColor(@Nullable ColorStateList r4) {
        if (this.itemRippleColor != r4) goto L9;
        if (r4 == null) goto L6;
        return;
    L6:
        if (this.menuView.getItemBackground() == null) goto L19;
        this.menuView.setItemBackground(null);
        return;
    L19:
        return;
    L9:
        this.itemRippleColor = r4;
        if (r4 != null) goto L12;
        this.menuView.setItemBackground(null);
        return;
    L12:
        ColorStateList r5 = RippleUtils.convertToRippleDrawableColor(r4);
        if (Build.VERSION.SDK_INT < 21) goto L15;
        NavigationBarMenuView r3 = this.menuView;
        Drawable r0 = new RippleDrawable(r5, null, null);
    L16:
        r3.setItemBackground(r0);
        return;
    L15:
        GradientDrawable r1 = new GradientDrawable();
        r1.setCornerRadius(1.0E-5f);
        r0 = DrawableCompat.wrap(r1);
        DrawableCompat.setTintList(r0, r5);
        r3 = this.menuView;
        goto L16
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

    public void setOnItemReselectedListener(@Nullable OnItemReselectedListener r1) {
        this.reselectedListener = r1;
    }

    public void setOnItemSelectedListener(@Nullable OnItemSelectedListener r1) {
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
}
