package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class BottomNavigationView extends NavigationBarView {
    static final int MAX_ITEM_COUNT = 5;

    @Deprecated
    public interface OnNavigationItemReselectedListener extends NavigationBarView.OnItemReselectedListener {
    }

    @Deprecated
    public interface OnNavigationItemSelectedListener extends NavigationBarView.OnItemSelectedListener {
    }

    public BottomNavigationView(@NonNull Context r2) {
        this(r2, null);
    }

    public BottomNavigationView(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(@NonNull Context r2, @Nullable AttributeSet r3, int r4) {
        this(r2, r3, r4, R.style.Widget_Design_BottomNavigationView);
    }

    public BottomNavigationView(@NonNull Context r8, @Nullable AttributeSet r9, int r10, int r11) {
        super(r8, r9, r10, r11);
        Context r12 = getContext();
        TintTypedArray r13 = ThemeEnforcement.obtainTintedStyledAttributes(r12, r9, R.styleable.BottomNavigationView, r10, r11, new int[0]);
        setItemHorizontalTranslationEnabled(r13.getBoolean(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        int r14 = R.styleable.BottomNavigationView_android_minHeight;
        if (r13.hasValue(r14) == false) goto L5;
        setMinimumHeight(r13.getDimensionPixelSize(r14, 0));
    L5:
        r13.recycle();
        if (shouldDrawCompatibilityTopDivider() == false) goto L8;
        addCompatibilityTopDivider(r12);
    L8:
        applyWindowInsets();
    }

    private void addCompatibilityTopDivider(@NonNull Context r4) {
        View r0 = new View(r4);
        r0.setBackgroundColor(ContextCompat.getColor(r4, R.color.design_bottom_navigation_shadow_color));
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
        addView(r0);
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new AnonymousClass1(this));
    }

    private int makeMinHeightSpec(int r4) {
        int r0 = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(r4) == 1073741824) goto L7;
        if (r0 <= 0) goto L7;
        int r1 = r0 + (getPaddingTop() + getPaddingBottom());
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(r4), r1), BasicMeasure.EXACTLY);
    L7:
        return r4;
    }

    private boolean shouldDrawCompatibilityTopDivider() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
    L7:
        return false;
    L5:
        if ((getBackground() instanceof MaterialShapeDrawable) == true) goto L7;
        return true;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected NavigationBarMenuView createNavigationBarMenuView(@NonNull Context r1) {
        return new BottomNavigationMenuView(r1);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return ((BottomNavigationMenuView) getMenuView()).isItemHorizontalTranslationEnabled();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, makeMinHeightSpec(r2));
    }

    public void setItemHorizontalTranslationEnabled(boolean r3) {
        BottomNavigationMenuView r0 = (BottomNavigationMenuView) getMenuView();
        if (r0.isItemHorizontalTranslationEnabled() == r3) goto L6;
        r0.setItemHorizontalTranslationEnabled(r3);
        getPresenter().updateMenuView(false);
        return;
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(@Nullable OnNavigationItemReselectedListener r1) {
        setOnItemReselectedListener(r1);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener r1) {
        setOnItemSelectedListener(r1);
    }
}
