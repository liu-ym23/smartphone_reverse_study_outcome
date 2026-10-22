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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
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

/* JADX INFO: loaded from: classes2.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int DEF_STYLE_RES = 0;
    private static final int[] DISABLED_STATE_SET = null;
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private final NavigationMenuPresenter presenter;
    private final int[] tmpLocation;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem r1);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public Bundle menuState;

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.menuState = r1.readBundle(r2);
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeBundle(this.menuState);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static /* synthetic */ int[] access$000(NavigationView r0) {
        return r0.tmpLocation;
    }

    static /* synthetic */ NavigationMenuPresenter access$100(NavigationView r0) {
        return r0.presenter;
    }

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DISABLED_STATE_SET = new int[]{-16842910};
        DEF_STYLE_RES = com.google.android.material.R.style.Widget_Design_NavigationView;
    }

    public NavigationView(Context r2) {
        this(r2, null);
    }

    public NavigationView(Context r2, AttributeSet r3) {
        this(r2, r3, com.google.android.material.R.attr.navigationViewStyle);
    }

    public NavigationView(Context r11, AttributeSet r12, int r13) {
        int r6 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r11, r12, r13, r6), r12, r13);
        NavigationMenuPresenter r14 = new NavigationMenuPresenter();
        this.presenter = r14;
        this.tmpLocation = new int[2];
        Context r7 = getContext();
        NavigationMenu r8 = new NavigationMenu(r7);
        this.menu = r8;
        TintTypedArray r0 = ThemeEnforcement.obtainTintedStyledAttributes(r7, r12, com.google.android.material.R.styleable.NavigationView, r13, r6, new int[0]);
        if (r0.hasValue(com.google.android.material.R.styleable.NavigationView_android_background) == false) goto L6;
        ViewCompat.setBackground(this, r0.getDrawable(com.google.android.material.R.styleable.NavigationView_android_background));
    L6:
        if (getBackground() != null) goto L8;
    L9:
        ShapeAppearanceModel r15 = ShapeAppearanceModel.builder(r7, r12, r13, r6).build();
        Drawable r16 = getBackground();
        MaterialShapeDrawable r1 = new MaterialShapeDrawable(r15);
        if ((r16 instanceof ColorDrawable) == false) goto L12;
        r1.setFillColor(ColorStateList.valueOf(((ColorDrawable) r16).getColor()));
    L12:
        r1.initializeElevationOverlay(r7);
        ViewCompat.setBackground(this, r1);
    L14:
        if (r0.hasValue(com.google.android.material.R.styleable.NavigationView_elevation) == false) goto L16;
        setElevation(r0.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_elevation, 0));
    L16:
        setFitsSystemWindows(r0.getBoolean(com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.maxWidth = r0.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_android_maxWidth, 0);
        if (r0.hasValue(com.google.android.material.R.styleable.NavigationView_itemIconTint) == false) goto L19;
        ColorStateList r17 = r0.getColorStateList(com.google.android.material.R.styleable.NavigationView_itemIconTint);
    L21:
        if (r0.hasValue(com.google.android.material.R.styleable.NavigationView_itemTextAppearance) == false) goto L23;
        int r18 = r0.getResourceId(com.google.android.material.R.styleable.NavigationView_itemTextAppearance, 0);
        boolean r2 = true;
    L25:
        if (r0.hasValue(com.google.android.material.R.styleable.NavigationView_itemIconSize) == false) goto L28;
        setItemIconSize(r0.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemIconSize, 0));
    L28:
        if (r0.hasValue(com.google.android.material.R.styleable.NavigationView_itemTextColor) == false) goto L30;
        ColorStateList r3 = r0.getColorStateList(com.google.android.material.R.styleable.NavigationView_itemTextColor);
    L31:
        if (r2 == true) goto L34;
        if (r3 != null) goto L34;
        r3 = createDefaultColorStateList(R.attr.textColorPrimary);
    L34:
        Drawable r4 = r0.getDrawable(com.google.android.material.R.styleable.NavigationView_itemBackground);
        if (r4 != null) goto L40;
        if (hasShapeAppearance(r0) == false) goto L40;
        r4 = createDefaultItemBackground(r0);
    L40:
        if (r0.hasValue(com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding) == false) goto L42;
        r14.setItemHorizontalPadding(r0.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding, 0));
    L42:
        int r5 = r0.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(r0.getInt(com.google.android.material.R.styleable.NavigationView_itemMaxLines, 1));
        r8.setCallback(new AnonymousClass1(this));
        r14.setId(1);
        r14.initForMenu(r7, r8);
        r14.setItemIconTintList(r17);
        r14.setOverScrollMode(getOverScrollMode());
        if (r2 == false) goto L45;
        r14.setItemTextAppearance(r18);
    L45:
        r14.setItemTextColor(r3);
        r14.setItemBackground(r4);
        r14.setItemIconPadding(r5);
        r8.addMenuPresenter(r14);
        addView((View) r14.getMenuView(this));
        if (r0.hasValue(com.google.android.material.R.styleable.NavigationView_menu) == false) goto L49;
        inflateMenu(r0.getResourceId(com.google.android.material.R.styleable.NavigationView_menu, 0));
    L49:
        if (r0.hasValue(com.google.android.material.R.styleable.NavigationView_headerLayout) == false) goto L51;
        inflateHeaderView(r0.getResourceId(com.google.android.material.R.styleable.NavigationView_headerLayout, 0));
    L51:
        r0.recycle();
        setupInsetScrimsListener();
        return;
    L30:
        r3 = null;
        goto L31
    L23:
        r18 = 0;
        r2 = false;
        goto L25
    L19:
        r17 = createDefaultColorStateList(R.attr.textColorSecondary);
        goto L21
    L8:
        if ((getBackground() instanceof ColorDrawable) == false) goto L14;
        goto L9
    }

    @Override // android.view.View
    public void setOverScrollMode(int r1) {
        super.setOverScrollMode(r1);
        NavigationMenuPresenter r0 = this.presenter;
        if (r0 == null) goto L6;
        r0.setOverScrollMode(r1);
        return;
    }

    private boolean hasShapeAppearance(TintTypedArray r1) {
        if (r1.hasValue(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance) == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.hasValue(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay) == true) goto L8;
        return false;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        MaterialShapeUtils.setElevation(this, r1);
    }

    private final Drawable createDefaultItemBackground(TintTypedArray r10) {
        int r0 = r10.getResourceId(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance, 0);
        int r2 = r10.getResourceId(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay, 0);
        MaterialShapeDrawable r4 = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), r0, r2).build());
        r4.setFillColor(MaterialResources.getColorStateList(getContext(), r10, com.google.android.material.R.styleable.NavigationView_itemShapeFillColor));
        return new InsetDrawable(r4, r10.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetStart, 0), r10.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetTop, 0), r10.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetEnd, 0), r10.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.menuState = new Bundle();
        this.menu.savePresenterStates(r1.menuState);
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
        this.menu.restorePresenterStates(r3.menuState);
    }

    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener r1) {
        this.listener = r1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getMode(r4);
        if (r0 == Integer.MIN_VALUE) goto L7;
        if (r0 != 0) goto L8;
        r4 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
    L8:
        super.onMeasure(r4, r5);
        return;
    L7:
        r4 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(r4), this.maxWidth), 1073741824);
        goto L8
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    protected void onInsetsChanged(WindowInsetsCompat r1) {
        this.presenter.dispatchApplyWindowInsets(r1);
    }

    public void inflateMenu(int r3) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(r3, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    public Menu getMenu() {
        return this.menu;
    }

    public View inflateHeaderView(int r1) {
        return this.presenter.inflateHeaderView(r1);
    }

    public void addHeaderView(View r1) {
        this.presenter.addHeaderView(r1);
    }

    public void removeHeaderView(View r1) {
        this.presenter.removeHeaderView(r1);
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public View getHeaderView(int r1) {
        return this.presenter.getHeaderView(r1);
    }

    public ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public void setItemIconTintList(ColorStateList r1) {
        this.presenter.setItemIconTintList(r1);
    }

    public ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList r1) {
        this.presenter.setItemTextColor(r1);
    }

    public Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    public void setItemBackgroundResource(int r2) {
        setItemBackground(ContextCompat.getDrawable(getContext(), r2));
    }

    public void setItemBackground(Drawable r1) {
        this.presenter.setItemBackground(r1);
    }

    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    public void setItemHorizontalPadding(int r1) {
        this.presenter.setItemHorizontalPadding(r1);
    }

    public void setItemHorizontalPaddingResource(int r2) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(r2));
    }

    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    public void setItemIconPadding(int r1) {
        this.presenter.setItemIconPadding(r1);
    }

    public void setItemIconPaddingResource(int r2) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(r2));
    }

    public void setCheckedItem(int r2) {
        MenuItem r3 = this.menu.findItem(r2);
        if (r3 == null) goto L6;
        this.presenter.setCheckedItem((MenuItemImpl) r3);
        return;
    }

    public void setCheckedItem(MenuItem r2) {
        MenuItem r3 = this.menu.findItem(r2.getItemId());
        if (r3 == null) goto L7;
        this.presenter.setCheckedItem((MenuItemImpl) r3);
        return;
    L7:
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    public void setItemTextAppearance(int r1) {
        this.presenter.setItemTextAppearance(r1);
    }

    public void setItemIconSize(int r1) {
        this.presenter.setItemIconSize(r1);
    }

    public void setItemMaxLines(int r1) {
        this.presenter.setItemMaxLines(r1);
    }

    public int getItemMaxLines() {
        return this.presenter.getItemMaxLines();
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater != null) goto L6;
        this.menuInflater = new SupportMenuInflater(getContext());
    L6:
        return this.menuInflater;
    }

    private ColorStateList createDefaultColorStateList(int r10) {
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
        return new ColorStateList(new int[][]{r5, CHECKED_STATE_SET, EMPTY_STATE_SET}, new int[]{r11.getColorForState(r5, r1), r9, r1});
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new AnonymousClass2(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }
}
