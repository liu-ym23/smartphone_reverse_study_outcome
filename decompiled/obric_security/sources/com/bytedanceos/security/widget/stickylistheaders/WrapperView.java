package com.bytedanceos.security.widget.stickylistheaders;

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

    WrapperView(Context c) {
        super(c);
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

    void update(View item, View header, Drawable divider, int dividerHeight) {
        if (item == null) goto L24;
        View r0 = this.mItem;
        if (r0 == item) goto L12;
        removeView(r0);
        this.mItem = item;
        ViewParent r1 = item.getParent();
        if (r1 == null) goto L11;
        if (r1 == this) goto L11;
        if ((r1 instanceof ViewGroup) == false) goto L11;
        ((ViewGroup) r1).removeView(item);
    L11:
        addView(item);
    L12:
        View r3 = this.mHeader;
        if (r3 == header) goto L20;
        if (r3 == null) goto L16;
        removeView(r3);
    L16:
        this.mHeader = header;
        if (header == null) goto L20;
        addView(header);
    L20:
        if (this.mDivider == divider) goto L25;
        this.mDivider = divider;
        this.mDividerHeight = dividerHeight;
        invalidate();
        return;
    L25:
        return;
    L24:
        throw new NullPointerException("List view item must not be null.");
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int r7 = View.MeasureSpec.getSize(widthMeasureSpec);
        int r0 = View.MeasureSpec.makeMeasureSpec(r7, 1073741824);
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
        if (r3 == null) goto L20;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 != null) goto L15;
    L17:
        this.mHeader.measure(r0, View.MeasureSpec.makeMeasureSpec(0, 0));
    L18:
        int r5 = this.mHeader.getMeasuredHeight() + 0;
    L26:
        if (this.mItem.getVisibility() != 8) goto L28;
        this.mItem.measure(r0, View.MeasureSpec.makeMeasureSpec(0, 1073741824));
    L35:
        if (getTag() != null) goto L37;
    L39:
        setMeasuredDimension(r7, r5);
        return;
    L37:
        if (getLayoutParams().height <= 0) goto L39;
        setMeasuredDimension(r7, getLayoutParams().height);
        return;
    L28:
        if (r1 != null) goto L30;
    L32:
        this.mItem.measure(r0, View.MeasureSpec.makeMeasureSpec(0, 0));
        int r8 = this.mItem.getMeasuredHeight();
    L33:
        r5 = r5 + r8;
        goto L35
    L30:
        if (r1.height < 0) goto L32;
        this.mItem.measure(r0, View.MeasureSpec.makeMeasureSpec(r1.height, 1073741824));
        r8 = this.mItem.getMeasuredHeight();
        goto L33
    L15:
        if (r4.height <= 0) goto L17;
        this.mHeader.measure(r0, View.MeasureSpec.makeMeasureSpec(r4.height, 1073741824));
        goto L18
    L20:
        if (this.mDivider != null) goto L22;
    L24:
        r5 = 0;
        goto L26
    L22:
        if (this.mItem.getVisibility() == 8) goto L24;
        r5 = this.mDividerHeight + 0;
        goto L26
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int r1 = getWidth();
        int r2 = getHeight();
        View r3 = this.mHeader;
        if (r3 == null) goto L5;
        int r4 = r3.getMeasuredHeight();
        this.mHeader.layout(0, 0, r1, r4);
        this.mItemTop = r4;
        this.mItem.layout(0, r4, r1, r2);
        return;
    L5:
        Drawable r5 = this.mDivider;
        if (r5 == null) goto L8;
        r5.setBounds(0, 0, r1, this.mDividerHeight);
        int r6 = this.mDividerHeight;
        this.mItemTop = r6;
        this.mItem.layout(0, r6, r1, r2);
        return;
    L8:
        this.mItemTop = 0;
        this.mItem.layout(0, 0, r1, r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mHeader == null) goto L5;
        return;
    L5:
        if (this.mDivider != null) goto L7;
        return;
    L7:
        if (this.mItem.getVisibility() == 8) goto L12;
        this.mDivider.draw(canvas);
        return;
    }
}
