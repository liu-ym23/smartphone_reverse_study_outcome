package com.android.setupwizardlib.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public class StickyHeaderListView extends ListView {
    private int statusBarInset;
    private View sticky;
    private View stickyContainer;
    private final RectF stickyRect;

    public StickyHeaderListView(Context r2) {
        super(r2);
        this.statusBarInset = 0;
        this.stickyRect = new RectF();
        init(null, R.attr.listViewStyle);
    }

    public StickyHeaderListView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.statusBarInset = 0;
        this.stickyRect = new RectF();
        init(r2, R.attr.listViewStyle);
    }

    public StickyHeaderListView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.statusBarInset = 0;
        this.stickyRect = new RectF();
        init(r2, r3);
    }

    private void init(AttributeSet r4, int r5) {
        TypedArray r6 = getContext().obtainStyledAttributes(r4, com.android.setupwizardlib.R.styleable.SuwStickyHeaderListView, r5, 0);
        int r7 = r6.getResourceId(com.android.setupwizardlib.R.styleable.SuwStickyHeaderListView_suwHeader, 0);
        if (r7 == 0) goto L5;
        addHeaderView(LayoutInflater.from(getContext()).inflate(r7, this, false), null, false);
    L5:
        r6.recycle();
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.sticky != null) goto L6;
        updateStickyView();
        return;
    }

    public void updateStickyView() {
        this.sticky = findViewWithTag("sticky");
        this.stickyContainer = findViewWithTag("stickyContainer");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r4) {
        if (this.stickyRect.contains(r4.getX(), r4.getY()) == false) goto L7;
        r4.offsetLocation(-this.stickyRect.left, -this.stickyRect.top);
        return this.stickyContainer.dispatchTouchEvent(r4);
    L7:
        return super.dispatchTouchEvent(r4);
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(Canvas r9) {
        super.draw(r9);
        if (this.sticky == null) goto L21;
        int r0 = r9.save();
        View r1 = this.stickyContainer;
        if (r1 == null) goto L7;
        View r2 = r1;
    L9:
        if (r1 == null) goto L11;
        int r3 = this.sticky.getTop();
    L13:
        if ((r2.getTop() + r3) >= this.statusBarInset) goto L15;
    L18:
        this.stickyRect.set(0.0f, (-r3) + this.statusBarInset, r2.getWidth(), (r2.getHeight() - r3) + this.statusBarInset);
        r9.translate(0.0f, this.stickyRect.top);
        r9.clipRect(0, 0, r2.getWidth(), r2.getHeight());
        r2.draw(r9);
    L19:
        r9.restoreToCount(r0);
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

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r3) {
        super.onInitializeAccessibilityEvent(r3);
        if (this.sticky == null) goto L5;
        int r2 = 1;
    L6:
        r3.setItemCount(r3.getItemCount() - r2);
        r3.setFromIndex(Math.max(r3.getFromIndex() - r2, 0));
        r3.setToIndex(Math.max(r3.getToIndex() - r2, 0));
        return;
    L5:
        r2 = 0;
        goto L6
    }
}
