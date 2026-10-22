package com.android.setupwizardlib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public class StickyHeaderScrollView extends BottomScrollView {
    private int statusBarInset;
    private View sticky;
    private View stickyContainer;

    public StickyHeaderScrollView(Context r1) {
        super(r1);
        this.statusBarInset = 0;
    }

    public StickyHeaderScrollView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.statusBarInset = 0;
    }

    public StickyHeaderScrollView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.statusBarInset = 0;
    }

    @Override // com.android.setupwizardlib.view.BottomScrollView, android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.sticky != null) goto L5;
        updateStickyView();
    L5:
        updateStickyHeaderPosition();
    }

    public void updateStickyView() {
        this.sticky = findViewWithTag("sticky");
        this.stickyContainer = findViewWithTag("stickyContainer");
    }

    private void updateStickyHeaderPosition() {
        View r0 = this.sticky;
        if (r0 == null) goto L19;
        View r1 = this.stickyContainer;
        if (r1 == null) goto L7;
        View r2 = r1;
    L8:
        if (r1 == null) goto L10;
        int r3 = r0.getTop();
    L12:
        if (((r2.getTop() - getScrollY()) + r3) >= this.statusBarInset) goto L14;
    L17:
        r2.setTranslationY(getScrollY() - r3);
        return;
    L14:
        if (r2.isShown() == false) goto L17;
        r2.setTranslationY(0.0f);
        return;
    L10:
        r3 = 0;
        goto L12
    L7:
        r2 = r0;
        goto L8
    }

    @Override // com.android.setupwizardlib.view.BottomScrollView, android.view.View
    protected void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
        updateStickyHeaderPosition();
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets r4) {
        if (getFitsSystemWindows() == false) goto L6;
        this.statusBarInset = r4.getSystemWindowInsetTop();
        return r4.replaceSystemWindowInsets(r4.getSystemWindowInsetLeft(), 0, r4.getSystemWindowInsetRight(), r4.getSystemWindowInsetBottom());
    L6:
        return r4;
    }
}
