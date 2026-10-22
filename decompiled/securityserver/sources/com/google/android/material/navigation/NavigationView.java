package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int DEF_STYLE_RES = 0;
    private static final int[] DISABLED_STATE_SET = null;
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;

    @NonNull
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private final NavigationMenuPresenter presenter;
    private final int[] tmpLocation;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem r1);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        @Nullable
        public Bundle menuState;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(@NonNull Parcel r1, @Nullable ClassLoader r2) {
            super(r1, r2);
            this.menuState = r1.readBundle(r2);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeBundle(this.menuState);
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }
    }

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DISABLED_STATE_SET = new int[]{-16842910};
        DEF_STYLE_RES = com.google.android.material.R.style.Widget_Design_NavigationView;
    }

    public NavigationView(@NonNull Context r2) {
        this(r2, null);
    }

    public static /* synthetic */ int[] access$000(NavigationView r0) {
        return r0.tmpLocation;
    }

    public static /* synthetic */ NavigationMenuPresenter access$100(NavigationView r0) {
        return r0.presenter;
    }

    @Nullable
    private ColorStateList createDefaultColorStateList(int r6) {
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
        return new ColorStateList(new int[][]{r2, CHECKED_STATE_SET, FrameLayout.EMPTY_STATE_SET}, new int[]{r7.getColorForState(r2, r1), r5, r1});
    }

    @NonNull
    private final Drawable createDefaultItemBackground(@NonNull TintTypedArray r10) {
        int r0 = r10.getResourceId(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance, 0);
        int r2 = r10.getResourceId(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay, 0);
        MaterialShapeDrawable r4 = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), r0, r2).build());
        r4.setFillColor(MaterialResources.getColorStateList(getContext(), r10, com.google.android.material.R.styleable.NavigationView_itemShapeFillColor));
        return new InsetDrawable(r4, r10.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetStart, 0), r10.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetTop, 0), r10.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetEnd, 0), r10.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater != null) goto L6;
        this.menuInflater = new SupportMenuInflater(getContext());
    L6:
        return this.menuInflater;
    }

    private boolean hasShapeAppearance(@NonNull TintTypedArray r1) {
        if (r1.hasValue(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance) == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.hasValue(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay) == true) goto L8;
        return false;
    }

    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new AnonymousClass2(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public void addHeaderView(@NonNull View r1) {
        this.presenter.addHeaderView(r1);
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public View getHeaderView(int r1) {
        return this.presenter.getHeaderView(r1);
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    @Dimension
    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    @Dimension
    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public int getItemMaxLines() {
        return this.presenter.getItemMaxLines();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    @NonNull
    public Menu getMenu() {
        return this.menu;
    }

    public View inflateHeaderView(@LayoutRes int r1) {
        return this.presenter.inflateHeaderView(r1);
    }

    public void inflateMenu(int r3) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(r3, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onInsetsChanged(@NonNull WindowInsetsCompat r1) {
        this.presenter.dispatchApplyWindowInsets(r1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getMode(r4);
        if (r0 == Integer.MIN_VALUE) goto L7;
        if (r0 != 0) goto L8;
        r4 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, BasicMeasure.EXACTLY);
    L8:
        super.onMeasure(r4, r5);
        return;
    L7:
        r4 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(r4), this.maxWidth), BasicMeasure.EXACTLY);
        goto L8
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        this.menu.restorePresenterStates(r3.menuState);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        Bundle r0 = new Bundle();
        r1.menuState = r0;
        this.menu.savePresenterStates(r0);
        return r1;
    }

    public void removeHeaderView(@NonNull View r1) {
        this.presenter.removeHeaderView(r1);
    }

    public void setCheckedItem(@IdRes int r2) {
        MenuItem r3 = this.menu.findItem(r2);
        if (r3 == null) goto L6;
        this.presenter.setCheckedItem((MenuItemImpl) r3);
        return;
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        MaterialShapeUtils.setElevation(this, r1);
    }

    public void setItemBackground(@Nullable Drawable r1) {
        this.presenter.setItemBackground(r1);
    }

    public void setItemBackgroundResource(@DrawableRes int r2) {
        setItemBackground(ContextCompat.getDrawable(getContext(), r2));
    }

    public void setItemHorizontalPadding(@Dimension int r1) {
        this.presenter.setItemHorizontalPadding(r1);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int r2) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(r2));
    }

    public void setItemIconPadding(@Dimension int r1) {
        this.presenter.setItemIconPadding(r1);
    }

    public void setItemIconPaddingResource(int r2) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(r2));
    }

    public void setItemIconSize(@Dimension int r1) {
        this.presenter.setItemIconSize(r1);
    }

    public void setItemIconTintList(@Nullable ColorStateList r1) {
        this.presenter.setItemIconTintList(r1);
    }

    public void setItemMaxLines(int r1) {
        this.presenter.setItemMaxLines(r1);
    }

    public void setItemTextAppearance(@StyleRes int r1) {
        this.presenter.setItemTextAppearance(r1);
    }

    public void setItemTextColor(@Nullable ColorStateList r1) {
        this.presenter.setItemTextColor(r1);
    }

    public void setNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener r1) {
        this.listener = r1;
    }

    @Override // android.view.View
    public void setOverScrollMode(int r1) {
        super.setOverScrollMode(r1);
        NavigationMenuPresenter r0 = this.presenter;
        if (r0 == null) goto L6;
        r0.setOverScrollMode(r1);
        return;
    }

    public NavigationView(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, com.google.android.material.R.attr.navigationViewStyle);
    }

    public NavigationView(@NonNull Context r11, @Nullable AttributeSet r12, int r13) {
        int r4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r11, r12, r13, r4), r12, r13);
        NavigationMenuPresenter r14 = new NavigationMenuPresenter();
        this.presenter = r14;
        this.tmpLocation = new int[2];
        Context r6 = getContext();
        NavigationMenu r7 = new NavigationMenu(r6);
        this.menu = r7;
        TintTypedArray r15 = ThemeEnforcement.obtainTintedStyledAttributes(r6, r12, com.google.android.material.R.styleable.NavigationView, r13, r4, new int[0]);
        if (r15.hasValue(com.google.android.material.R.styleable.NavigationView_android_background) == false) goto L6;
        ViewCompat.setBackground(this, r15.getDrawable(com.google.android.material.R.styleable.NavigationView_android_background));
    L6:
        if (getBackground() != null) goto L8;
    L9:
        Drawable r16 = getBackground();
        MaterialShapeDrawable r0 = new MaterialShapeDrawable();
        if ((r16 instanceof ColorDrawable) == false) goto L12;
        r0.setFillColor(ColorStateList.valueOf(((ColorDrawable) r16).getColor()));
    L12:
        r0.initializeElevationOverlay(r6);
        ViewCompat.setBackground(this, r0);
    L14:
        if (r15.hasValue(com.google.android.material.R.styleable.NavigationView_elevation) == false) goto L16;
        setElevation(r15.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_elevation, 0));
    L16:
        setFitsSystemWindows(r15.getBoolean(com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.maxWidth = r15.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_android_maxWidth, 0);
        if (r15.hasValue(com.google.android.material.R.styleable.NavigationView_itemIconTint) == false) goto L19;
        ColorStateList r17 = r15.getColorStateList(com.google.android.material.R.styleable.NavigationView_itemIconTint);
    L21:
        if (r15.hasValue(com.google.android.material.R.styleable.NavigationView_itemTextAppearance) == false) goto L23;
        int r1 = r15.getResourceId(com.google.android.material.R.styleable.NavigationView_itemTextAppearance, 0);
        boolean r2 = true;
    L25:
        if (r15.hasValue(com.google.android.material.R.styleable.NavigationView_itemIconSize) == false) goto L28;
        setItemIconSize(r15.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemIconSize, 0));
    L28:
        if (r15.hasValue(com.google.android.material.R.styleable.NavigationView_itemTextColor) == false) goto L30;
        ColorStateList r3 = r15.getColorStateList(com.google.android.material.R.styleable.NavigationView_itemTextColor);
    L31:
        if (r2 == true) goto L34;
        if (r3 != null) goto L34;
        r3 = createDefaultColorStateList(R.attr.textColorPrimary);
    L34:
        Drawable r5 = r15.getDrawable(com.google.android.material.R.styleable.NavigationView_itemBackground);
        if (r5 != null) goto L40;
        if (hasShapeAppearance(r15) == false) goto L40;
        r5 = createDefaultItemBackground(r15);
    L40:
        if (r15.hasValue(com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding) == false) goto L42;
        r14.setItemHorizontalPadding(r15.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding, 0));
    L42:
        int r8 = r15.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(r15.getInt(com.google.android.material.R.styleable.NavigationView_itemMaxLines, 1));
        r7.setCallback(new AnonymousClass1(this));
        r14.setId(1);
        r14.initForMenu(r6, r7);
        r14.setItemIconTintList(r17);
        r14.setOverScrollMode(getOverScrollMode());
        if (r2 == false) goto L45;
        r14.setItemTextAppearance(r1);
    L45:
        r14.setItemTextColor(r3);
        r14.setItemBackground(r5);
        r14.setItemIconPadding(r8);
        r7.addMenuPresenter(r14);
        addView((View) r14.getMenuView(this));
        if (r15.hasValue(com.google.android.material.R.styleable.NavigationView_menu) == false) goto L49;
        inflateMenu(r15.getResourceId(com.google.android.material.R.styleable.NavigationView_menu, 0));
    L49:
        if (r15.hasValue(com.google.android.material.R.styleable.NavigationView_headerLayout) == false) goto L51;
        inflateHeaderView(r15.getResourceId(com.google.android.material.R.styleable.NavigationView_headerLayout, 0));
    L51:
        r15.recycle();
        setupInsetScrimsListener();
        return;
    L30:
        r3 = null;
        goto L31
    L23:
        r1 = 0;
        r2 = false;
        goto L25
    L19:
        r17 = createDefaultColorStateList(R.attr.textColorSecondary);
        goto L21
    L8:
        if ((getBackground() instanceof ColorDrawable) == false) goto L14;
        goto L9
    }

    public void setCheckedItem(@NonNull MenuItem r2) {
        MenuItem r3 = this.menu.findItem(r2.getItemId());
        if (r3 == null) goto L7;
        this.presenter.setCheckedItem((MenuItemImpl) r3);
        return;
    L7:
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
