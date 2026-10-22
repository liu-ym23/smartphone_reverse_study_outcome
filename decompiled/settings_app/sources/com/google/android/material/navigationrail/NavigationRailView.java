package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationRailView extends NavigationBarView {
    private static final int DEFAULT_HEADER_GRAVITY = 49;
    static final int DEFAULT_MENU_GRAVITY = 49;
    static final int MAX_ITEM_COUNT = 7;
    static final int NO_ITEM_MINIMUM_HEIGHT = -1;
    private View headerView;
    private Boolean paddingBottomSystemWindowInsets;
    private Boolean paddingTopSystemWindowInsets;
    private final int topMargin;

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    static /* synthetic */ Boolean access$000(NavigationRailView r0) {
        return r0.paddingTopSystemWindowInsets;
    }

    static /* synthetic */ boolean access$100(NavigationRailView r0, Boolean r1) {
        return r0.shouldApplyWindowInsetPadding(r1);
    }

    static /* synthetic */ Boolean access$200(NavigationRailView r0) {
        return r0.paddingBottomSystemWindowInsets;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    protected /* bridge */ /* synthetic */ NavigationBarMenuView createNavigationBarMenuView(Context r1) {
        return createNavigationBarMenuView(r1);
    }

    public NavigationRailView(Context r2) {
        this(r2, null);
    }

    public NavigationRailView(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.navigationRailStyle);
    }

    public NavigationRailView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, R.style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(Context r7, AttributeSet r8, int r9, int r10) {
        super(r7, r8, r9, r10);
        this.paddingTopSystemWindowInsets = null;
        this.paddingBottomSystemWindowInsets = null;
        this.topMargin = getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin);
        TintTypedArray r11 = ThemeEnforcement.obtainTintedStyledAttributes(getContext(), r8, R.styleable.NavigationRailView, r9, r10, new int[0]);
        int r12 = r11.getResourceId(R.styleable.NavigationRailView_headerLayout, 0);
        if (r12 == 0) goto L5;
        addHeaderView(r12);
    L5:
        setMenuGravity(r11.getInt(R.styleable.NavigationRailView_menuGravity, 49));
        if (r11.hasValue(R.styleable.NavigationRailView_itemMinHeight) == false) goto L9;
        setItemMinimumHeight(r11.getDimensionPixelSize(R.styleable.NavigationRailView_itemMinHeight, -1));
    L9:
        if (r11.hasValue(R.styleable.NavigationRailView_paddingTopSystemWindowInsets) == false) goto L12;
        this.paddingTopSystemWindowInsets = Boolean.valueOf(r11.getBoolean(R.styleable.NavigationRailView_paddingTopSystemWindowInsets, false));
    L12:
        if (r11.hasValue(R.styleable.NavigationRailView_paddingBottomSystemWindowInsets) == false) goto L14;
        this.paddingBottomSystemWindowInsets = Boolean.valueOf(r11.getBoolean(R.styleable.NavigationRailView_paddingBottomSystemWindowInsets, false));
    L14:
        r11.recycle();
        applyWindowInsets();
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new AnonymousClass1(this));
    }

    private boolean shouldApplyWindowInsetPadding(Boolean r1) {
        if (r1 == null) goto L5;
        return r1.booleanValue();
    L5:
        return ViewCompat.getFitsSystemWindows(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r2, int r3) {
        int r4 = makeMinWidthSpec(r2);
        super.onMeasure(r4, r3);
        if (isHeaderViewVisible() == false) goto L6;
        int r5 = View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.headerView.getMeasuredHeight()) - this.topMargin, Integer.MIN_VALUE);
        measureChild(getNavigationRailMenuView(), r4, r5);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        NavigationRailMenuView r6 = getNavigationRailMenuView();
        int r7 = 0;
        if (isHeaderViewVisible() == false) goto L8;
        int r8 = this.headerView.getBottom() + this.topMargin;
        int r0 = r6.getTop();
        if (r0 >= r8) goto L10;
        r7 = r8 - r0;
    L10:
        if (r7 <= 0) goto L13;
        r6.layout(r6.getLeft(), r6.getTop() + r7, r6.getRight(), r6.getBottom() + r7);
        return;
    L13:
        return;
    L8:
        if (r6.isTopGravity() == false) goto L10;
        r7 = this.topMargin;
        goto L10
    }

    public void addHeaderView(int r3) {
        addHeaderView(LayoutInflater.from(getContext()).inflate(r3, this, false));
    }

    public void addHeaderView(View r3) {
        removeHeaderView();
        this.headerView = r3;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 49;
        r0.topMargin = this.topMargin;
        addView(r3, 0, r0);
    }

    public View getHeaderView() {
        return this.headerView;
    }

    public void removeHeaderView() {
        View r0 = this.headerView;
        if (r0 == null) goto L6;
        removeView(r0);
        this.headerView = null;
        return;
    }

    public void setMenuGravity(int r1) {
        getNavigationRailMenuView().setMenuGravity(r1);
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView) getMenuView()).getItemMinimumHeight();
    }

    public void setItemMinimumHeight(int r1) {
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(r1);
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    protected NavigationRailMenuView createNavigationBarMenuView(Context r1) {
        return new NavigationRailMenuView(r1);
    }

    private int makeMinWidthSpec(int r4) {
        int r0 = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(r4) == 1073741824) goto L7;
        if (r0 <= 0) goto L7;
        int r1 = r0 + (getPaddingLeft() + getPaddingRight());
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(r4), r1), 1073741824);
    L7:
        return r4;
    }

    private boolean isHeaderViewVisible() {
        View r1 = this.headerView;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.getVisibility() == 8) goto L7;
        return true;
    }
}
