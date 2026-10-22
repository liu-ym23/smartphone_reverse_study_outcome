package com.android.setupwizardlib.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public class StickyHeaderRecyclerView extends HeaderRecyclerView {
    private int statusBarInset;
    private View sticky;
    private final RectF stickyRect;

    public StickyHeaderRecyclerView(Context r1) {
        super(r1);
        this.statusBarInset = 0;
        this.stickyRect = new RectF();
    }

    public StickyHeaderRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.statusBarInset = 0;
        this.stickyRect = new RectF();
    }

    public StickyHeaderRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.statusBarInset = 0;
        this.stickyRect = new RectF();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.sticky != null) goto L6;
        updateStickyView();
    L6:
        if (this.sticky == null) goto L13;
        View r0 = getHeader();
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.getHeight() != 0) goto L15;
        r0.layout(0, -r0.getMeasuredHeight(), r0.getMeasuredWidth(), 0);
        return;
    L15:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        if (this.sticky == null) goto L6;
        measureChild(getHeader(), r2, r3);
        return;
    }

    public void updateStickyView() {
        View r0 = getHeader();
        if (r0 == null) goto L6;
        this.sticky = r0.findViewWithTag("sticky");
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void draw(Canvas r9) {
        super.draw(r9);
        if (this.sticky == null) goto L21;
        View r0 = getHeader();
        int r1 = r9.save();
        if (r0 == null) goto L7;
        View r2 = r0;
    L9:
        if (r0 == null) goto L11;
        int r3 = this.sticky.getTop();
    L13:
        if ((r2.getTop() + r3) >= this.statusBarInset) goto L15;
    L18:
        this.stickyRect.set(0.0f, (-r3) + this.statusBarInset, r2.getWidth(), (r2.getHeight() - r3) + this.statusBarInset);
        r9.translate(0.0f, this.stickyRect.top);
        r9.clipRect(0, 0, r2.getWidth(), r2.getHeight());
        r2.draw(r9);
    L19:
        r9.restoreToCount(r1);
        return;
    L15:
        if (r2.isShown() == false) goto L18;
        this.stickyRect.setEmpty();
        goto L19
    L11:
        r3 = 0;
        goto L13
    L7:
        r2 = this.sticky;
        goto L9
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets r4) {
        if (getFitsSystemWindows() == false) goto L5;
        this.statusBarInset = r4.getSystemWindowInsetTop();
        r4.replaceSystemWindowInsets(r4.getSystemWindowInsetLeft(), 0, r4.getSystemWindowInsetRight(), r4.getSystemWindowInsetBottom());
    L5:
        return r4;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r4) {
        if (this.stickyRect.contains(r4.getX(), r4.getY()) == false) goto L7;
        r4.offsetLocation(-this.stickyRect.left, -this.stickyRect.top);
        return getHeader().dispatchTouchEvent(r4);
    L7:
        return super.dispatchTouchEvent(r4);
    }
}
