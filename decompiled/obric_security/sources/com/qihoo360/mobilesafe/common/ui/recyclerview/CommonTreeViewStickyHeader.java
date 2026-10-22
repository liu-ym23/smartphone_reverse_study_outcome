package com.qihoo360.mobilesafe.common.ui.recyclerview;

import android.graphics.Canvas;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes4.dex */
class CommonTreeViewStickyHeader extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    private Comparator<RecyclerView.ViewHolder> comparator;
    private int currentStickyViewType;
    private boolean hasActionDown;
    private SparseArray<View> headerCache;
    private int headerTopOffset;
    private View touchTarget;

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean r1) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView r1, MotionEvent r2) {
    }

    CommonTreeViewStickyHeader(RecyclerView r2) {
        this.comparator = new AnonymousClass1(this);
        r2.addOnItemTouchListener(this);
        this.headerCache = new SparseArray();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        int r13 = -1;
        this.currentStickyViewType = -1;
        RecyclerView.Adapter r0 = r11.getAdapter();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getItemCount() > 0) goto L7;
        return;
    L7:
        if (r11.getChildCount() > 0) goto L10;
        return;
    L10:
        if ((r0 instanceof CommonTreeProxyAdapter) == true) goto L12;
        return;
    L12:
        CommonTreeProxyAdapter r1 = (CommonTreeProxyAdapter) r0;
        ArrayList r2 = new ArrayList();
        int r3 = 0;
    L14:
        if (r3 >= r11.getChildCount()) goto L22;
        RecyclerView.ViewHolder r4 = r11.getChildViewHolder(r11.getChildAt(r3));
        if (r4 == null) goto L20;
        if (r4.getAdapterPosition() == (-1)) goto L20;
        r2.add(r4);
    L20:
        r3 = r3 + 1;
        goto L14
    L22:
        if (r2.isEmpty() == false) goto L24;
        return;
    L24:
        Collections.sort(r2, this.comparator);
        CommonTreeNode r5 = getStickyNode(r1.getNodeAtPosition(((RecyclerView.ViewHolder) r2.get(0)).getAdapterPosition()));
        if (r5 != null) goto L27;
        return;
    L27:
        int r6 = r1.getItemViewType(r5);
        this.currentStickyViewType = r6;
        View r7 = this.headerCache.get(r6);
        if (r7 != null) goto L30;
        r7 = r1.createView(r11, this.currentStickyViewType);
        this.headerCache.put(this.currentStickyViewType, r7);
    L30:
        r1.bindView(r7, r5, this.currentStickyViewType);
        this.headerTopOffset = 0;
        int r8 = View.MeasureSpec.makeMeasureSpec(r11.getWidth(), 1073741824);
        int r9 = View.MeasureSpec.makeMeasureSpec(r11.getHeight(), 0);
        ViewGroup.LayoutParams r14 = r7.getLayoutParams();
        int r15 = r11.getPaddingLeft() + r11.getPaddingRight();
        if (r14 == null) goto L34;
        r13 = r14.width;
    L34:
        int r16 = ViewGroup.getChildMeasureSpec(r8, r15, r13);
        int r17 = r11.getPaddingLeft() + r11.getPaddingRight();
        if (r14 != null) goto L37;
        int r18 = -2;
    L38:
        r7.measure(r16, ViewGroup.getChildMeasureSpec(r9, r17, r18));
        r7.layout(0, 0, r7.getMeasuredWidth(), r7.getMeasuredHeight());
        if (r2.size() <= 1) goto L50;
        int r19 = 1;
    L42:
        if (r19 >= r2.size()) goto L50;
        RecyclerView.ViewHolder r20 = (RecyclerView.ViewHolder) r2.get(r19);
        CommonTreeNode r21 = r1.getNodeAtPosition(r20.getAdapterPosition());
        int r22 = r20.itemView.getTop() - r7.getMeasuredHeight();
        if (r22 >= 0) goto L50;
        if (r21.getDepth() == 1) goto L48;
        r19 = r19 + 1;
        goto L42
    L48:
        this.headerTopOffset = r22;
    L50:
        drawHeader(r10, r7, this.headerTopOffset);
        return;
    L37:
        r18 = r14.height;
        goto L38
    }

    private CommonTreeNode getStickyNode(CommonTreeNode r3) {
        if (r3.getDepth() != 1) goto L6;
        return r3;
    L6:
        return getStickyNode(r3.getParent());
    }

    private void drawHeader(Canvas r1, View r2, int r3) {
        r1.save();
        r1.translate(0.0f, r3);
        r2.draw(r1);
        r1.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView r5, MotionEvent r6) {
        int r7 = r6.getAction();
        if (r7 == 0) goto L6;
        if (r7 == 1) goto L13;
    L23:
        return false;
    L13:
        if (this.headerCache.get(this.currentStickyViewType) != null) goto L15;
    L22:
        this.hasActionDown = false;
        goto L23
    L15:
        if (this.hasActionDown == false) goto L22;
        View r8 = this.touchTarget;
        if (r8 == null) goto L22;
        if (isPointInView(r8, (int) r6.getX(), (int) r6.getY()) == false) goto L22;
        this.hasActionDown = false;
        this.touchTarget.performClick();
        return true;
    L6:
        View r9 = this.headerCache.get(this.currentStickyViewType);
        if (r9 == null) goto L13;
        View r10 = getTouchTarget(r9, (int) r6.getX(), (int) r6.getY());
        this.touchTarget = r10;
        if (r10 == null) goto L13;
        this.hasActionDown = true;
        return true;
    }

    private boolean isPointInView(View r2, int r3, int r4) {
        if (r3 >= r2.getLeft()) goto L5;
    L11:
        return false;
    L5:
        if (r3 > r2.getRight()) goto L11;
        if (r4 < (r2.getTop() + this.headerTopOffset)) goto L11;
        if (r4 > (r2.getBottom() + this.headerTopOffset)) goto L11;
        return true;
    }

    private View getTouchTarget(View r5, int r6, int r7) {
        if (isPointInView(r5, r6, r7) == true) goto L6;
        return null;
    L6:
        if ((r5 instanceof ViewGroup) == false) goto L14;
        ViewGroup r0 = (ViewGroup) r5;
        int r2 = r0.getChildCount() - 1;
    L8:
        if (r2 < 0) goto L14;
        View r3 = getTouchTarget(r0.getChildAt(r2), r6, r7);
        if (r3 != null) goto L11;
        r2 = r2 - 1;
        goto L8
    L11:
        return r3;
    L14:
        if (r5.isClickable() == false) goto L16;
        return r5;
    L16:
        return null;
    }
}
