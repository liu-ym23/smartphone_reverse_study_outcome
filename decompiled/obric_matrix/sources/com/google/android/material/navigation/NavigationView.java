package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
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
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int DEF_STYLE_RES = 0;
    private static final int[] DISABLED_STATE_SET = null;
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    private boolean bottomInsetScrimEnabled;

    @Px
    private int drawerLayoutCornerSize;
    private int layoutGravity;
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;

    @NonNull
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private final NavigationMenuPresenter presenter;
    private final RectF shapeClipBounds;

    @Nullable
    private Path shapeClipPath;
    private final int[] tmpLocation;
    private boolean topInsetScrimEnabled;

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

        public SavedState(Parcelable r1) {
            super(r1);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeBundle(this.menuState);
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

    public NavigationView(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, com.google.android.material.R.attr.navigationViewStyle);
    }

    public NavigationView(@NonNull Context r12, @Nullable AttributeSet r13, int r14) {
        int r6 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r12, r13, r14, r6), r13, r14);
        NavigationMenuPresenter r15 = new NavigationMenuPresenter();
        this.presenter = r15;
        this.tmpLocation = new int[2];
        this.topInsetScrimEnabled = true;
        this.bottomInsetScrimEnabled = true;
        this.layoutGravity = 0;
        this.drawerLayoutCornerSize = 0;
        this.shapeClipBounds = new RectF();
        Context r9 = getContext();
        NavigationMenu r10 = new NavigationMenu(r9);
        this.menu = r10;
        TintTypedArray r0 = ThemeEnforcement.obtainTintedStyledAttributes(r9, r13, com.google.android.material.R.styleable.NavigationView, r14, r6, new int[0]);
        int r1 = com.google.android.material.R.styleable.NavigationView_android_background;
        if (r0.hasValue(r1) == false) goto L5;
        ViewCompat.setBackground(this, r0.getDrawable(r1));
    L5:
        this.drawerLayoutCornerSize = r0.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_drawerLayoutCornerSize, 0);
        this.layoutGravity = r0.getInt(com.google.android.material.R.styleable.NavigationView_android_layout_gravity, 0);
        if (getBackground() != null) goto L8;
    L9:
        ShapeAppearanceModel r16 = ShapeAppearanceModel.builder(r9, r13, r14, r6).build();
        Drawable r17 = getBackground();
        MaterialShapeDrawable r2 = new MaterialShapeDrawable(r16);
        if ((r17 instanceof ColorDrawable) == false) goto L12;
        r2.setFillColor(ColorStateList.valueOf(((ColorDrawable) r17).getColor()));
    L12:
        r2.initializeElevationOverlay(r9);
        ViewCompat.setBackground(this, r2);
    L13:
        int r18 = com.google.android.material.R.styleable.NavigationView_elevation;
        if (r0.hasValue(r18) == false) goto L16;
        setElevation(r0.getDimensionPixelSize(r18, 0));
    L16:
        setFitsSystemWindows(r0.getBoolean(com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.maxWidth = r0.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_android_maxWidth, 0);
        int r19 = com.google.android.material.R.styleable.NavigationView_subheaderColor;
        ColorStateList r3 = null;
        if (r0.hasValue(r19) == false) goto L19;
        ColorStateList r110 = r0.getColorStateList(r19);
    L20:
        int r111 = com.google.android.material.R.styleable.NavigationView_subheaderTextAppearance;
        if (r0.hasValue(r111) == false) goto L23;
        int r112 = r0.getResourceId(r111, 0);
    L25:
        if (r112 != 0) goto L28;
        if (r110 != null) goto L28;
        r110 = createDefaultColorStateList(R.attr.textColorSecondary);
    L28:
        int r4 = com.google.android.material.R.styleable.NavigationView_itemIconTint;
        if (r0.hasValue(r4) == false) goto L31;
        ColorStateList r5 = r0.getColorStateList(r4);
    L32:
        int r7 = com.google.android.material.R.styleable.NavigationView_itemTextAppearance;
        if (r0.hasValue(r7) == false) goto L35;
        int r8 = r0.getResourceId(r7, 0);
    L36:
        int r11 = com.google.android.material.R.styleable.NavigationView_itemIconSize;
        if (r0.hasValue(r11) == false) goto L39;
        setItemIconSize(r0.getDimensionPixelSize(r11, 0));
    L39:
        int r20 = com.google.android.material.R.styleable.NavigationView_itemTextColor;
        if (r0.hasValue(r20) == false) goto L42;
        r3 = r0.getColorStateList(r20);
    L42:
        if (r8 != 0) goto L45;
        if (r3 != null) goto L45;
        r3 = createDefaultColorStateList(R.attr.textColorPrimary);
    L45:
        Drawable r21 = r0.getDrawable(com.google.android.material.R.styleable.NavigationView_itemBackground);
        if (r21 == null) goto L48;
    L50:
        int r22 = com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding;
        if (r0.hasValue(r22) == false) goto L53;
        setItemHorizontalPadding(r0.getDimensionPixelSize(r22, 0));
    L53:
        int r23 = com.google.android.material.R.styleable.NavigationView_itemVerticalPadding;
        if (r0.hasValue(r23) == false) goto L56;
        setItemVerticalPadding(r0.getDimensionPixelSize(r23, 0));
    L56:
        setDividerInsetStart(r0.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_dividerInsetStart, 0));
        setDividerInsetEnd(r0.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_dividerInsetEnd, 0));
        setSubheaderInsetStart(r0.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_subheaderInsetStart, 0));
        setSubheaderInsetEnd(r0.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_subheaderInsetEnd, 0));
        setTopInsetScrimEnabled(r0.getBoolean(com.google.android.material.R.styleable.NavigationView_topInsetScrimEnabled, this.topInsetScrimEnabled));
        setBottomInsetScrimEnabled(r0.getBoolean(com.google.android.material.R.styleable.NavigationView_bottomInsetScrimEnabled, this.bottomInsetScrimEnabled));
        int r24 = r0.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(r0.getInt(com.google.android.material.R.styleable.NavigationView_itemMaxLines, 1));
        r10.setCallback(new AnonymousClass1(this));
        r15.setId(1);
        r15.initForMenu(r9, r10);
        if (r112 == 0) goto L59;
        r15.setSubheaderTextAppearance(r112);
    L59:
        r15.setSubheaderColor(r110);
        r15.setItemIconTintList(r5);
        r15.setOverScrollMode(getOverScrollMode());
        if (r8 == 0) goto L62;
        r15.setItemTextAppearance(r8);
    L62:
        r15.setItemTextColor(r3);
        r15.setItemBackground(r21);
        r15.setItemIconPadding(r24);
        r10.addMenuPresenter(r15);
        addView((View) r15.getMenuView(this));
        int r113 = com.google.android.material.R.styleable.NavigationView_menu;
        if (r0.hasValue(r113) == false) goto L65;
        inflateMenu(r0.getResourceId(r113, 0));
    L65:
        int r114 = com.google.android.material.R.styleable.NavigationView_headerLayout;
        if (r0.hasValue(r114) == false) goto L68;
        inflateHeaderView(r0.getResourceId(r114, 0));
    L68:
        r0.recycle();
        setupInsetScrimsListener();
        return;
    L48:
        if (hasShapeAppearance(r0) == false) goto L50;
        r21 = createDefaultItemBackground(r0);
        goto L50
    L35:
        r8 = 0;
        goto L36
    L31:
        r5 = createDefaultColorStateList(R.attr.textColorSecondary);
        goto L32
    L23:
        r112 = 0;
        goto L25
    L19:
        r110 = null;
        goto L20
    L8:
        if ((getBackground() instanceof ColorDrawable) == false) goto L13;
        goto L9
    }

    static /* synthetic */ int[] access$000(NavigationView r0) {
        return r0.tmpLocation;
    }

    static /* synthetic */ NavigationMenuPresenter access$100(NavigationView r0) {
        return r0.presenter;
    }

    @Nullable
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
        return new ColorStateList(new int[][]{r5, CHECKED_STATE_SET, FrameLayout.EMPTY_STATE_SET}, new int[]{r11.getColorForState(r5, r1), r9, r1});
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

    private void maybeUpdateCornerSizeForDrawerLayout(@Px int r5, @Px int r6) {
        if ((getParent() instanceof DrawerLayout) == true) goto L5;
    L16:
        this.shapeClipPath = null;
        this.shapeClipBounds.setEmpty();
        return;
    L5:
        if (this.drawerLayoutCornerSize <= 0) goto L16;
        if ((getBackground() instanceof MaterialShapeDrawable) == false) goto L16;
        MaterialShapeDrawable r0 = (MaterialShapeDrawable) getBackground();
        ShapeAppearanceModel.Builder r1 = r0.getShapeAppearanceModel().toBuilder();
        if (GravityCompat.getAbsoluteGravity(this.layoutGravity, ViewCompat.getLayoutDirection(this)) != 3) goto L11;
        r1.setTopRightCornerSize(this.drawerLayoutCornerSize);
        r1.setBottomRightCornerSize(this.drawerLayoutCornerSize);
    L12:
        r0.setShapeAppearanceModel(r1.build());
        if (this.shapeClipPath != null) goto L15;
        this.shapeClipPath = new Path();
    L15:
        this.shapeClipPath.reset();
        this.shapeClipBounds.set(0.0f, 0.0f, r5, r6);
        ShapeAppearancePathProvider.getInstance().calculatePath(r0.getShapeAppearanceModel(), r0.getInterpolation(), this.shapeClipBounds, this.shapeClipPath);
        invalidate();
        return;
    L11:
        r1.setTopLeftCornerSize(this.drawerLayoutCornerSize);
        r1.setBottomLeftCornerSize(this.drawerLayoutCornerSize);
        goto L12
    }

    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new AnonymousClass2(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public void addHeaderView(@NonNull View r1) {
        this.presenter.addHeaderView(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NonNull Canvas r3) {
        if (this.shapeClipPath != null) goto L6;
        super.dispatchDraw(r3);
        return;
    L6:
        int r0 = r3.save();
        r3.clipPath(this.shapeClipPath);
        super.dispatchDraw(r3);
        r3.restoreToCount(r0);
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    @Px
    public int getDividerInsetEnd() {
        return this.presenter.getDividerInsetEnd();
    }

    @Px
    public int getDividerInsetStart() {
        return this.presenter.getDividerInsetStart();
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

    @Px
    public int getItemVerticalPadding() {
        return this.presenter.getItemVerticalPadding();
    }

    @NonNull
    public Menu getMenu() {
        return this.menu;
    }

    @Px
    public int getSubheaderInsetEnd() {
        return this.presenter.getSubheaderInsetEnd();
    }

    @Px
    public int getSubheaderInsetStart() {
        return this.presenter.getSubheaderInsetStart();
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

    public boolean isBottomInsetScrimEnabled() {
        return this.bottomInsetScrimEnabled;
    }

    public boolean isTopInsetScrimEnabled() {
        return this.topInsetScrimEnabled;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        getViewTreeObserver().removeGlobalOnLayoutListener(this.onGlobalLayoutListener);
        return;
    L5:
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void onInsetsChanged(@NonNull WindowInsetsCompat r1) {
        this.presenter.dispatchApplyWindowInsets(r1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getMode(r4);
        if (r0 == Integer.MIN_VALUE) goto L7;
        if (r0 != 0) goto L9;
        int r6 = this.maxWidth;
    L8:
        r4 = View.MeasureSpec.makeMeasureSpec(r6, BasicMeasure.EXACTLY);
    L9:
        super.onMeasure(r4, r5);
        return;
    L7:
        r6 = Math.min(View.MeasureSpec.getSize(r4), this.maxWidth);
        goto L8
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

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        Bundle r0 = new Bundle();
        r1.menuState = r0;
        this.menu.savePresenterStates(r0);
        return r1;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        maybeUpdateCornerSizeForDrawerLayout(r1, r2);
    }

    public void removeHeaderView(@NonNull View r1) {
        this.presenter.removeHeaderView(r1);
    }

    public void setBottomInsetScrimEnabled(boolean r1) {
        this.bottomInsetScrimEnabled = r1;
    }

    public void setCheckedItem(@IdRes int r2) {
        MenuItem r3 = this.menu.findItem(r2);
        if (r3 == null) goto L6;
        this.presenter.setCheckedItem((MenuItemImpl) r3);
        return;
    }

    public void setCheckedItem(@NonNull MenuItem r2) {
        MenuItem r3 = this.menu.findItem(r2.getItemId());
        if (r3 == null) goto L7;
        this.presenter.setCheckedItem((MenuItemImpl) r3);
        return;
    L7:
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public void setDividerInsetEnd(@Px int r1) {
        this.presenter.setDividerInsetEnd(r1);
    }

    public void setDividerInsetStart(@Px int r1) {
        this.presenter.setDividerInsetStart(r1);
    }

    @Override // android.view.View
    public void setElevation(float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        super.setElevation(r3);
    L5:
        MaterialShapeUtils.setElevation(this, r3);
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

    public void setItemVerticalPadding(@Px int r1) {
        this.presenter.setItemVerticalPadding(r1);
    }

    public void setItemVerticalPaddingResource(@DimenRes int r2) {
        this.presenter.setItemVerticalPadding(getResources().getDimensionPixelSize(r2));
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

    public void setSubheaderInsetEnd(@Px int r1) {
        this.presenter.setSubheaderInsetStart(r1);
    }

    public void setSubheaderInsetStart(@Px int r1) {
        this.presenter.setSubheaderInsetStart(r1);
    }

    public void setTopInsetScrimEnabled(boolean r1) {
        this.topInsetScrimEnabled = r1;
    }
}
