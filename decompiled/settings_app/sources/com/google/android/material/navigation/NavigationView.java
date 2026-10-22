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
import android.graphics.drawable.RippleDrawable;
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
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int DEF_STYLE_RES = 0;
    private static final int[] DISABLED_STATE_SET = null;
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    private boolean bottomInsetScrimEnabled;
    private int drawerLayoutCornerSize;
    private int layoutGravity;
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private final NavigationMenuPresenter presenter;
    private final RectF shapeClipBounds;
    private Path shapeClipPath;
    private final int[] tmpLocation;
    private boolean topInsetScrimEnabled;

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

    public NavigationView(Context r17, AttributeSet r18, int r19) {
        int r9 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r17, r18, r19, r9), r18, r19);
        NavigationMenuPresenter r10 = new NavigationMenuPresenter();
        this.presenter = r10;
        this.tmpLocation = new int[2];
        this.topInsetScrimEnabled = true;
        this.bottomInsetScrimEnabled = true;
        this.layoutGravity = 0;
        this.drawerLayoutCornerSize = 0;
        this.shapeClipBounds = new RectF();
        Context r13 = getContext();
        NavigationMenu r14 = new NavigationMenu(r13);
        this.menu = r14;
        TintTypedArray r1 = ThemeEnforcement.obtainTintedStyledAttributes(r13, r18, com.google.android.material.R.styleable.NavigationView, r19, r9, new int[0]);
        if (r1.hasValue(com.google.android.material.R.styleable.NavigationView_android_background) == false) goto L5;
        ViewCompat.setBackground(this, r1.getDrawable(com.google.android.material.R.styleable.NavigationView_android_background));
    L5:
        this.drawerLayoutCornerSize = r1.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_drawerLayoutCornerSize, 0);
        this.layoutGravity = r1.getInt(com.google.android.material.R.styleable.NavigationView_android_layout_gravity, 0);
        if (getBackground() != null) goto L8;
    L9:
        ShapeAppearanceModel r2 = ShapeAppearanceModel.builder(r13, r18, r19, r9).build();
        Drawable r3 = getBackground();
        MaterialShapeDrawable r4 = new MaterialShapeDrawable(r2);
        if ((r3 instanceof ColorDrawable) == false) goto L12;
        r4.setFillColor(ColorStateList.valueOf(((ColorDrawable) r3).getColor()));
    L12:
        r4.initializeElevationOverlay(r13);
        ViewCompat.setBackground(this, r4);
    L14:
        if (r1.hasValue(com.google.android.material.R.styleable.NavigationView_elevation) == false) goto L16;
        setElevation(r1.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_elevation, 0));
    L16:
        setFitsSystemWindows(r1.getBoolean(com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.maxWidth = r1.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_android_maxWidth, 0);
        if (r1.hasValue(com.google.android.material.R.styleable.NavigationView_subheaderColor) == false) goto L19;
        ColorStateList r5 = r1.getColorStateList(com.google.android.material.R.styleable.NavigationView_subheaderColor);
    L21:
        if (r1.hasValue(com.google.android.material.R.styleable.NavigationView_subheaderTextAppearance) == false) goto L23;
        int r6 = r1.getResourceId(com.google.android.material.R.styleable.NavigationView_subheaderTextAppearance, 0);
    L25:
        if (r6 != 0) goto L29;
        if (r5 != null) goto L29;
        r5 = createDefaultColorStateList(R.attr.textColorSecondary);
    L29:
        if (r1.hasValue(com.google.android.material.R.styleable.NavigationView_itemIconTint) == false) goto L31;
        ColorStateList r7 = r1.getColorStateList(com.google.android.material.R.styleable.NavigationView_itemIconTint);
    L33:
        if (r1.hasValue(com.google.android.material.R.styleable.NavigationView_itemTextAppearance) == false) goto L35;
        int r8 = r1.getResourceId(com.google.android.material.R.styleable.NavigationView_itemTextAppearance, 0);
    L37:
        if (r1.hasValue(com.google.android.material.R.styleable.NavigationView_itemIconSize) == false) goto L40;
        setItemIconSize(r1.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemIconSize, 0));
    L40:
        if (r1.hasValue(com.google.android.material.R.styleable.NavigationView_itemTextColor) == false) goto L42;
        ColorStateList r11 = r1.getColorStateList(com.google.android.material.R.styleable.NavigationView_itemTextColor);
    L43:
        if (r8 != 0) goto L46;
        if (r11 != null) goto L46;
        r11 = createDefaultColorStateList(R.attr.textColorPrimary);
    L46:
        Drawable r12 = r1.getDrawable(com.google.android.material.R.styleable.NavigationView_itemBackground);
        if (r12 != null) goto L54;
        if (hasShapeAppearance(r1) == false) goto L54;
        r12 = createDefaultItemBackground(r1);
        ColorStateList r15 = MaterialResources.getColorStateList(r13, r1, com.google.android.material.R.styleable.NavigationView_itemRippleColor);
        if (r15 == null) goto L54;
        r10.setItemForeground(new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(r15), null, createDefaultItemDrawable(r1, null)));
    L54:
        if (r1.hasValue(com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding) == false) goto L57;
        setItemHorizontalPadding(r1.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding, 0));
    L57:
        if (r1.hasValue(com.google.android.material.R.styleable.NavigationView_itemVerticalPadding) == false) goto L59;
        setItemVerticalPadding(r1.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemVerticalPadding, 0));
    L59:
        setDividerInsetStart(r1.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_dividerInsetStart, 0));
        setDividerInsetEnd(r1.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_dividerInsetEnd, 0));
        setSubheaderInsetStart(r1.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_subheaderInsetStart, 0));
        setSubheaderInsetEnd(r1.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_subheaderInsetEnd, 0));
        setTopInsetScrimEnabled(r1.getBoolean(com.google.android.material.R.styleable.NavigationView_topInsetScrimEnabled, this.topInsetScrimEnabled));
        setBottomInsetScrimEnabled(r1.getBoolean(com.google.android.material.R.styleable.NavigationView_bottomInsetScrimEnabled, this.bottomInsetScrimEnabled));
        int r16 = r1.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(r1.getInt(com.google.android.material.R.styleable.NavigationView_itemMaxLines, 1));
        r14.setCallback(new AnonymousClass1(this));
        r10.setId(1);
        r10.initForMenu(r13, r14);
        if (r6 == 0) goto L62;
        r10.setSubheaderTextAppearance(r6);
    L62:
        r10.setSubheaderColor(r5);
        r10.setItemIconTintList(r7);
        r10.setOverScrollMode(getOverScrollMode());
        if (r8 == 0) goto L65;
        r10.setItemTextAppearance(r8);
    L65:
        r10.setItemTextColor(r11);
        r10.setItemBackground(r12);
        r10.setItemIconPadding(r16);
        r14.addMenuPresenter(r10);
        addView((View) r10.getMenuView(this));
        if (r1.hasValue(com.google.android.material.R.styleable.NavigationView_menu) == false) goto L69;
        inflateMenu(r1.getResourceId(com.google.android.material.R.styleable.NavigationView_menu, 0));
    L69:
        if (r1.hasValue(com.google.android.material.R.styleable.NavigationView_headerLayout) == false) goto L71;
        inflateHeaderView(r1.getResourceId(com.google.android.material.R.styleable.NavigationView_headerLayout, 0));
    L71:
        r1.recycle();
        setupInsetScrimsListener();
        return;
    L42:
        r11 = null;
        goto L43
    L35:
        r8 = 0;
        goto L37
    L31:
        r7 = createDefaultColorStateList(R.attr.textColorSecondary);
        goto L33
    L23:
        r6 = 0;
        goto L25
    L19:
        r5 = null;
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

    private void maybeUpdateCornerSizeForDrawerLayout(int r5, int r6) {
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
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        maybeUpdateCornerSizeForDrawerLayout(r1, r2);
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        MaterialShapeUtils.setElevation(this, r1);
    }

    private Drawable createDefaultItemBackground(TintTypedArray r3) {
        return createDefaultItemDrawable(r3, MaterialResources.getColorStateList(getContext(), r3, com.google.android.material.R.styleable.NavigationView_itemShapeFillColor));
    }

    private Drawable createDefaultItemDrawable(TintTypedArray r10, ColorStateList r11) {
        int r0 = r10.getResourceId(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance, 0);
        int r2 = r10.getResourceId(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay, 0);
        MaterialShapeDrawable r4 = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), r0, r2).build());
        r4.setFillColor(r11);
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

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r3) {
        if (this.shapeClipPath != null) goto L6;
        super.dispatchDraw(r3);
        return;
    L6:
        int r0 = r3.save();
        r3.clipPath(this.shapeClipPath);
        super.dispatchDraw(r3);
        r3.restoreToCount(r0);
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

    public int getItemVerticalPadding() {
        return this.presenter.getItemVerticalPadding();
    }

    public void setItemVerticalPadding(int r1) {
        this.presenter.setItemVerticalPadding(r1);
    }

    public void setItemVerticalPaddingResource(int r2) {
        this.presenter.setItemVerticalPadding(getResources().getDimensionPixelSize(r2));
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

    public boolean isTopInsetScrimEnabled() {
        return this.topInsetScrimEnabled;
    }

    public void setTopInsetScrimEnabled(boolean r1) {
        this.topInsetScrimEnabled = r1;
    }

    public boolean isBottomInsetScrimEnabled() {
        return this.bottomInsetScrimEnabled;
    }

    public void setBottomInsetScrimEnabled(boolean r1) {
        this.bottomInsetScrimEnabled = r1;
    }

    public int getDividerInsetStart() {
        return this.presenter.getDividerInsetStart();
    }

    public void setDividerInsetStart(int r1) {
        this.presenter.setDividerInsetStart(r1);
    }

    public int getDividerInsetEnd() {
        return this.presenter.getDividerInsetEnd();
    }

    public void setDividerInsetEnd(int r1) {
        this.presenter.setDividerInsetEnd(r1);
    }

    public int getSubheaderInsetStart() {
        return this.presenter.getSubheaderInsetStart();
    }

    public void setSubheaderInsetStart(int r1) {
        this.presenter.setSubheaderInsetStart(r1);
    }

    public int getSubheaderInsetEnd() {
        return this.presenter.getSubheaderInsetEnd();
    }

    public void setSubheaderInsetEnd(int r1) {
        this.presenter.setSubheaderInsetStart(r1);
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
