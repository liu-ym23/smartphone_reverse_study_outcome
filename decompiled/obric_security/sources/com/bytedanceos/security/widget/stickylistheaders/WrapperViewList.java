package com.bytedanceos.security.widget.stickylistheaders;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import com.bytedanceos.security.widget.SlideListView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class WrapperViewList extends SlideListView {
    private boolean mBlockLayoutChildren;
    private boolean mClippingToPadding;
    private List<View> mFooterViews;
    private LifeCycleListener mLifeCycleListener;
    private Field mSelectorPositionField;
    private Rect mSelectorRect;
    private int mTopClippingLength;

    interface LifeCycleListener {
        void onDispatchDrawOccurred(Canvas canvas);
    }

    public WrapperViewList(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSelectorRect = new Rect();
        this.mClippingToPadding = true;
        this.mBlockLayoutChildren = false;
        Field r3 = AbsListView.class.getDeclaredField("mSelectorRect");     // Catch: IllegalAccessException -> L5 IllegalArgumentException -> L7 NoSuchFieldException -> L9
        r3.setAccessible(true);     // Catch: IllegalAccessException -> L5 IllegalArgumentException -> L7 NoSuchFieldException -> L9
        this.mSelectorRect = (Rect) r3.get(this);     // Catch: IllegalAccessException -> L5 IllegalArgumentException -> L7 NoSuchFieldException -> L9
        Field r4 = AbsListView.class.getDeclaredField("mSelectorPosition");     // Catch: IllegalAccessException -> L5 IllegalArgumentException -> L7 NoSuchFieldException -> L9
        this.mSelectorPositionField = r4;     // Catch: IllegalAccessException -> L5 IllegalArgumentException -> L7 NoSuchFieldException -> L9
        r4.setAccessible(true);     // Catch: IllegalAccessException -> L5 IllegalArgumentException -> L7 NoSuchFieldException -> L9
    L16:
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView
    public boolean performItemClick(View view, int position, long id) {
        if ((view instanceof WrapperView) == false) goto L6;
        view = ((WrapperView) view).mItem;
    L6:
        return super.performItemClick(view, position, id);
    }

    private void positionSelectorRect() {
        if (this.mSelectorRect.isEmpty() == true) goto L13;
        int r0 = getSelectorPosition();
        if (r0 < 0) goto L14;
        View r1 = getChildAt(r0 - getFixedFirstVisibleItem());
        if (r1 != null) goto L10;
        return;
    L10:
        if ((r1 instanceof WrapperView) == false) goto L15;
        WrapperView r2 = (WrapperView) r1;
        Rect r3 = this.mSelectorRect;
        r3.top = r2.getTop() + r2.mItemTop;
        return;
    L15:
        return;
    L14:
        return;
    }

    private int getSelectorPosition() {
        Field r0 = this.mSelectorPositionField;
        if (r0 != null) goto L23;
        int r1 = 0;
    L6:
        if (r1 >= getChildCount()) goto L30;
        View r2 = getChildAt(r1);
        if (r2 == null) goto L14;
        if (r2.getBottom() != this.mSelectorRect.bottom) goto L14;
        return r1 + getFixedFirstVisibleItem();
    L14:
        r1 = r1 + 1;
        goto L6
    L30:
        return -1;
    L23:
        return r0.getInt(this);
    L17:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L19:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    @Override // com.obric.oui.bouncelayout.OListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        positionSelectorRect();
        if (this.mTopClippingLength == 0) goto L5;
        canvas.save();
        Rect r0 = canvas.getClipBounds();
        r0.top = this.mTopClippingLength;
        canvas.clipRect(r0);
        super.dispatchDraw(canvas);
        canvas.restore();
    L6:
        this.mLifeCycleListener.onDispatchDrawOccurred(canvas);
        return;
    L5:
        super.dispatchDraw(canvas);
        goto L6
    }

    void setLifeCycleListener(LifeCycleListener lifeCycleListener) {
        this.mLifeCycleListener = lifeCycleListener;
    }

    @Override // android.widget.ListView
    public void addFooterView(View v) {
        super.addFooterView(v);
        addInternalFooterView(v);
    }

    @Override // android.widget.ListView
    public void addFooterView(View v, Object data, boolean isSelectable) {
        super.addFooterView(v, data, isSelectable);
        addInternalFooterView(v);
    }

    private void addInternalFooterView(View v) {
        if (this.mFooterViews != null) goto L5;
        this.mFooterViews = new ArrayList();
    L5:
        this.mFooterViews.add(v);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View v) {
        if (super.removeFooterView(v) == false) goto L6;
        this.mFooterViews.remove(v);
        return true;
    L6:
        return false;
    }

    boolean containsFooterView(View v) {
        List<View> r0 = this.mFooterViews;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.contains(v);
    }

    void setTopClippingLength(int topClipping) {
        this.mTopClippingLength = topClipping;
    }

    int getFixedFirstVisibleItem() {
        return getFirstVisiblePosition();
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean clipToPadding) {
        this.mClippingToPadding = clipToPadding;
        super.setClipToPadding(clipToPadding);
    }

    public void setBlockLayoutChildren(boolean block) {
        this.mBlockLayoutChildren = block;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        if (this.mBlockLayoutChildren == true) goto L6;
        super.layoutChildren();
        return;
    }
}
