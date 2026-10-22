package com.android.settings.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class RoundCornerListView extends ListView {
    private static final float DEFAULT_RADIUS = 16.0f;
    Path mClip;
    private Drawable mContentBottomShadow;
    private int mContentBottomShadowHeight;
    private Drawable mContentTopShadow;
    private int mContentTopShadowHeight;
    private int mMaxHeight;
    private boolean mParentBgStateChangeable;
    private int mParentPressedResourceId;
    private int mParentResourceId;
    private float mRadius;
    private boolean mUseShadow;

    public RoundCornerListView(Context r2) {
        super(r2);
        this.mRadius = 16.0f;
        this.mMaxHeight = -1;
        this.mParentResourceId = -1;
        this.mParentPressedResourceId = -1;
        this.mParentBgStateChangeable = true;
        this.mUseShadow = true;
        init(r2);
    }

    public RoundCornerListView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mRadius = 16.0f;
        this.mMaxHeight = -1;
        this.mParentResourceId = -1;
        this.mParentPressedResourceId = -1;
        this.mParentBgStateChangeable = true;
        this.mUseShadow = true;
        init(r1);
    }

    public RoundCornerListView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mRadius = 16.0f;
        this.mMaxHeight = -1;
        this.mParentResourceId = -1;
        this.mParentPressedResourceId = -1;
        this.mParentBgStateChangeable = true;
        this.mUseShadow = true;
        init(r1);
    }

    private void init(Context r3) {
        this.mContentTopShadow = r3.getResources().getDrawable(R.drawable.menu_cover_top);
        this.mContentBottomShadow = r3.getResources().getDrawable(R.drawable.menu_cover_bottom);
        this.mContentTopShadowHeight = this.mContentTopShadow.getIntrinsicHeight();
        this.mContentBottomShadowHeight = this.mContentBottomShadow.getIntrinsicHeight();
        setRecyclerListener(new AnonymousClass1(this));
    }

    public void setRadius(float r1) {
        this.mRadius = r1;
    }

    public void setMaxHeight(int r1) {
        this.mMaxHeight = r1;
    }

    public void setUseShadow(boolean r1) {
        this.mUseShadow = r1;
    }

    public void setParentBackgroundResource(int r1, int r2) {
        this.mParentResourceId = r1;
        this.mParentPressedResourceId = r2;
    }

    public void setParentBackgroundStateChangeable(boolean r1) {
        this.mParentBgStateChangeable = r1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.mClip = new Path();
        RectF r5 = new RectF(0.0f, 0.0f, r1, r2);
        Path r6 = this.mClip;
        float r0 = this.mRadius;
        r6.addRoundRect(r5, r0, r0, Path.Direction.CW);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r14) {
        int r0 = r14.save();
        r14.clipPath(this.mClip);
        super.dispatchDraw(r14);
        int r1 = getFirstVisiblePosition();
        int r2 = getWidth();
        int r3 = getHeight();
        int r4 = getScrollX();
        int r5 = getScrollY();
        Drawable r6 = this.mContentTopShadow;
        Drawable r7 = this.mContentBottomShadow;
        int r8 = this.mContentTopShadowHeight;
        int r9 = this.mContentBottomShadowHeight;
        View r11 = getChildAt(pointToPosition(0, r8) - r1);
        if (this.mUseShadow == false) goto L8;
        if (r11 == null) goto L8;
        if (r11.isPressed() == true) goto L8;
        r6.setBounds(new Rect(r4, r5, r4 + r2, r8 + r5));
        r6.draw(r14);
    L8:
        int r10 = r3 - r9;
        View r12 = getChildAt(pointToPosition(0, r10) - r1);
        if (this.mUseShadow == false) goto L14;
        if (r12 == null) goto L14;
        if (r12.isPressed() == true) goto L14;
        int r13 = r10 + r5;
        r7.setBounds(new Rect(r4, r13, r2 + r4, r9 + r13));
        r7.draw(r14);
    L14:
        r14.restoreToCount(r0);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int r3, int r4) {
        if (this.mMaxHeight <= 0) goto L8;
        int r0 = View.MeasureSpec.getSize(r4);
        int r5 = View.MeasureSpec.getMode(r4);
        int r1 = this.mMaxHeight;
        if (r0 <= r1) goto L7;
        r0 = r1;
    L7:
        r4 = View.MeasureSpec.makeMeasureSpec(r0, r5);
    L8:
        super.onMeasure(r3, r4);
    }

    @Override // android.view.View
    public void setPressed(boolean r3) {
        super.setPressed(r3);
        if (this.mParentBgStateChangeable == false) goto L27;
        int r0 = this.mParentResourceId;
        if (r0 >= 0) goto L7;
        return;
    L7:
        if (this.mParentPressedResourceId < 0) goto L30;
        boolean r1 = false;
        if (r3 == true) goto L12;
    L20:
        ViewGroup r4 = (ViewGroup) getParent();
        if (r4 == null) goto L29;
        if (r1 == false) goto L24;
        int r2 = this.mParentPressedResourceId;
    L25:
        r4.setBackgroundResource(r2);
        return;
    L24:
        r2 = this.mParentResourceId;
        goto L25
    L29:
        return;
    L12:
        if (r0 != R.drawable.menu_item_point_down) goto L14;
        int r5 = getLastVisiblePosition() - getFirstVisiblePosition();
    L15:
        View r6 = getChildAt(r5);
        if (r6 == null) goto L20;
        if (r6.isPressed() == false) goto L20;
        r1 = true;
        goto L20
    L14:
        r5 = 0;
        goto L15
    L30:
        return;
    }
}
