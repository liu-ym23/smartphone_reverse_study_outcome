package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

/* JADX INFO: loaded from: classes3.dex */
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private boolean itemHorizontalTranslationEnabled;
    private int[] tempChildWidths;

    public BottomNavigationMenuView(Context r2) {
        super(r2);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-2, -2);
        r3.gravity = 17;
        setLayoutParams(r3);
        Resources r4 = getResources();
        this.inactiveItemMaxWidth = r4.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = r4.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = r4.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = r4.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
        this.tempChildWidths = new int[5];
    }

    @Override // android.view.View
    protected void onMeasure(int r13, int r14) {
        MenuBuilder r0 = getMenu();
        int r15 = View.MeasureSpec.getSize(r13);
        int r1 = r0.getVisibleItems().size();
        int r2 = getChildCount();
        int r3 = View.MeasureSpec.getSize(r14);
        int r4 = View.MeasureSpec.makeMeasureSpec(r3, 1073741824);
        int r7 = 1;
        if (isShifting(getLabelVisibilityMode(), r1) == true) goto L5;
    L30:
        if (r1 == 0) goto L33;
        r7 = r1;
    L33:
        int r5 = Math.min(r15 / r7, this.activeItemMaxWidth);
        int r16 = r15 - (r1 * r5);
        int r6 = 0;
    L34:
        if (r6 >= r2) goto L42;
        if (getChildAt(r6).getVisibility() == 8) goto L40;
        int[] r8 = this.tempChildWidths;
        r8[r6] = r5;
        if (r16 <= 0) goto L41;
        r8[r6] = r5 + 1;
        r16 = r16 - 1;
    L41:
        r6 = r6 + 1;
        goto L34
    L40:
        this.tempChildWidths[r6] = 0;
    L42:
        int r17 = 0;
        int r9 = 0;
    L43:
        if (r17 >= r2) goto L49;
        View r10 = getChildAt(r17);
        if (r10.getVisibility() == 8) goto L48;
        r10.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths[r17], 1073741824), r4);
        r10.getLayoutParams().width = r10.getMeasuredWidth();
        r9 = r9 + r10.getMeasuredWidth();
    L48:
        r17 = r17 + 1;
        goto L43
    L49:
        setMeasuredDimension(View.resolveSizeAndState(r9, View.MeasureSpec.makeMeasureSpec(r9, 1073741824), 0), View.resolveSizeAndState(r3, r14, 0));
        return;
    L5:
        if (isItemHorizontalTranslationEnabled() == false) goto L30;
        View r11 = getChildAt(getSelectedItemPosition());
        int r12 = this.activeItemMinWidth;
        if (r11.getVisibility() == 8) goto L10;
        r11.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), r4);
        r12 = Math.max(r12, r11.getMeasuredWidth());
    L10:
        if (r11.getVisibility() == 8) goto L12;
        int r18 = 1;
    L13:
        int r19 = r1 - r18;
        int r20 = Math.min(r15 - (this.inactiveItemMinWidth * r19), Math.min(r12, this.activeItemMaxWidth));
        int r110 = r15 - r20;
        if (r19 != 0) goto L16;
        int r21 = 1;
    L17:
        int r22 = Math.min(r110 / r21, this.inactiveItemMaxWidth);
        int r111 = r110 - (r19 * r22);
        int r23 = 0;
    L18:
        if (r23 >= r2) goto L42;
        if (getChildAt(r23).getVisibility() == 8) goto L28;
        int[] r112 = this.tempChildWidths;
        if (r23 != getSelectedItemPosition()) goto L24;
        int r113 = r20;
    L25:
        r112[r23] = r113;
        if (r111 <= 0) goto L29;
        int[] r114 = this.tempChildWidths;
        r114[r23] = r114[r23] + 1;
        r111 = r111 - 1;
    L29:
        r23 = r23 + 1;
        goto L18
    L24:
        r113 = r22;
        goto L25
    L28:
        this.tempChildWidths[r23] = 0;
        goto L29
    L16:
        r21 = r19;
        goto L17
    L12:
        r18 = 0;
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
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

    public void setItemHorizontalTranslationEnabled(boolean r1) {
        this.itemHorizontalTranslationEnabled = r1;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    protected NavigationBarItemView createNavigationBarItemView(Context r1) {
        return new BottomNavigationItemView(r1);
    }
}
