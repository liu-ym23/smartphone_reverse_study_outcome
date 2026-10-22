package com.android.settings.stickylistheaders;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes2.dex */
public class WrapperView extends ViewGroup {
    Drawable mDivider;
    int mDividerHeight;
    View mHeader;
    View mItem;
    int mItemTop;

    WrapperView(Context r1) {
        super(r1);
    }

    public boolean hasHeader() {
        if (this.mHeader == null) goto L5;
        return true;
    L5:
        return false;
    }

    public View getItem() {
        return this.mItem;
    }

    public View getHeader() {
        return this.mHeader;
    }

    void update(View r3, View r4, Drawable r5, int r6) {
        if (r3 == null) goto L24;
        View r0 = this.mItem;
        if (r0 == r3) goto L12;
        removeView(r0);
        this.mItem = r3;
        ViewParent r1 = r3.getParent();
        if (r1 == null) goto L11;
        if (r1 == this) goto L11;
        if ((r1 instanceof ViewGroup) == false) goto L11;
        ((ViewGroup) r1).removeView(r3);
    L11:
        addView(r3);
    L12:
        View r7 = this.mHeader;
        if (r7 == r4) goto L20;
        if (r7 == null) goto L16;
        removeView(r7);
    L16:
        this.mHeader = r4;
        if (r4 == null) goto L20;
        addView(r4);
    L20:
        if (this.mDivider == r5) goto L25;
        this.mDivider = r5;
        this.mDividerHeight = r6;
        invalidate();
        return;
    L25:
        return;
    L24:
        throw new NullPointerException("List view item must not be null.");
    }

    @Override // android.view.View
    protected void onMeasure(int r7, int r8) {
        int r9 = View.MeasureSpec.getSize(r7);
        int r0 = View.MeasureSpec.makeMeasureSpec(r9, 1073741824);
        ViewGroup.LayoutParams r1 = this.mItem.getLayoutParams();
        if (getTag() != null) goto L10;
        ViewGroup.LayoutParams r2 = getLayoutParams();
        if (r2.height == (-2)) goto L8;
        r2.height = -2;
        setLayoutParams(r2);
    L8:
        if (r1.height == (-1)) goto L10;
        r1.height = -2;
        this.mItem.setLayoutParams(r1);
    L10:
        View r3 = this.mHeader;
        if (r3 == null) goto L26;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 != null) goto L15;
    L17:
        this.mHeader.measure(r0, View.MeasureSpec.makeMeasureSpec(0, 0));
    L18:
        int r5 = this.mHeader.getMeasuredHeight() + 0;
        if (this.mHeader.getMeasuredHeight() > 0) goto L32;
        if (this.mDivider == null) goto L32;
        if (this.mItem.getVisibility() == 8) goto L32;
        r5 = r5 + this.mDividerHeight;
    L32:
        if (this.mItem.getVisibility() != 8) goto L34;
        this.mItem.measure(r0, View.MeasureSpec.makeMeasureSpec(0, 1073741824));
    L41:
        if (getTag() != null) goto L43;
    L45:
        setMeasuredDimension(r9, r5);
        return;
    L43:
        if (getLayoutParams().height <= 0) goto L45;
        setMeasuredDimension(r9, getLayoutParams().height);
        return;
    L34:
        if (r1 != null) goto L36;
    L38:
        this.mItem.measure(r0, View.MeasureSpec.makeMeasureSpec(0, 0));
        int r10 = this.mItem.getMeasuredHeight();
    L39:
        r5 = r5 + r10;
        goto L41
    L36:
        if (r1.height < 0) goto L38;
        this.mItem.measure(r0, View.MeasureSpec.makeMeasureSpec(r1.height, 1073741824));
        r10 = this.mItem.getMeasuredHeight();
        goto L39
    L15:
        if (r4.height <= 0) goto L17;
        this.mHeader.measure(r0, View.MeasureSpec.makeMeasureSpec(r4.height, 1073741824));
        goto L18
    L26:
        if (this.mDivider != null) goto L28;
    L30:
        r5 = 0;
        goto L32
    L28:
        if (this.mItem.getVisibility() == 8) goto L30;
        r5 = this.mDividerHeight + 0;
        goto L32
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        int r6 = getWidth();
        int r7 = getHeight();
        View r8 = this.mHeader;
        if (r8 != null) goto L5;
    L9:
        Drawable r9 = this.mDivider;
        if (r9 == null) goto L12;
        r9.setBounds(0, 0, r6, this.mDividerHeight);
        int r10 = this.mDividerHeight;
        this.mItemTop = r10;
        this.mItem.layout(0, r10, r6, r7);
        return;
    L12:
        this.mItemTop = 0;
        this.mItem.layout(0, 0, r6, r7);
        return;
    L5:
        if (r8.getVisibility() == 8) goto L9;
        if (this.mHeader.getMeasuredHeight() <= 0) goto L9;
        int r11 = this.mHeader.getMeasuredHeight();
        this.mHeader.layout(0, 0, r6, r11);
        this.mItemTop = r11;
        this.mItem.layout(0, r11, r6, r7);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r3) {
        super.dispatchDraw(r3);
        if (this.mHeader == null) goto L5;
    L9:
        View r0 = this.mHeader;
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.getMeasuredHeight() == 0) goto L14;
        return;
    L14:
        if (this.mDivider != null) goto L16;
        return;
    L16:
        if (this.mItem.getVisibility() == 8) goto L23;
        this.mDivider.draw(r3);
        return;
    L23:
        return;
    L5:
        if (this.mDivider == null) goto L9;
        if (this.mItem.getVisibility() == 8) goto L9;
        this.mDivider.draw(r3);
    }
}
