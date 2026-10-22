package com.android.settings.stickylistheaders;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.android.settings.widget.HorizontalScrollListView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class WrapperViewList extends HorizontalScrollListView {
    private boolean mBlockLayoutChildren;
    private boolean mClippingToPadding;
    private List<View> mFooterViews;
    private LifeCycleListener mLifeCycleListener;
    private Field mSelectorPositionField;
    private Rect mSelectorRect;
    private int mTopClippingLength;

    interface LifeCycleListener {
        void onDispatchDrawOccurred(Canvas r1);
    }

    static /* synthetic */ boolean access$002(WrapperViewList r0, boolean r1) {
        r0.mIsRunningDeleteAnim = r1;
        return r1;
    }

    static /* synthetic */ boolean access$102(WrapperViewList r0, boolean r1) {
        r0.mIsRunningDeleteAnim = r1;
        return r1;
    }

    static /* synthetic */ boolean access$202(WrapperViewList r0, boolean r1) {
        r0.mIsRunningDeleteAnim = r1;
        return r1;
    }

    public WrapperViewList(Context r3) {
        super(r3);
        this.mSelectorRect = new Rect();
        this.mClippingToPadding = true;
        this.mBlockLayoutChildren = false;
        Field r0 = AbsListView.class.getDeclaredField("mSelectorRect");     // Catch: IllegalAccessException -> L5 IllegalArgumentException -> L7 NoSuchFieldException -> L9
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L5 IllegalArgumentException -> L7 NoSuchFieldException -> L9
        this.mSelectorRect = (Rect) r0.get(this);     // Catch: IllegalAccessException -> L5 IllegalArgumentException -> L7 NoSuchFieldException -> L9
        Field r1 = AbsListView.class.getDeclaredField("mSelectorPosition");     // Catch: IllegalAccessException -> L5 IllegalArgumentException -> L7 NoSuchFieldException -> L9
        this.mSelectorPositionField = r1;     // Catch: IllegalAccessException -> L5 IllegalArgumentException -> L7 NoSuchFieldException -> L9
        r1.setAccessible(true);     // Catch: IllegalAccessException -> L5 IllegalArgumentException -> L7 NoSuchFieldException -> L9
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
    public boolean performItemClick(View r2, int r3, long r4) {
        if ((r2 instanceof WrapperView) == false) goto L6;
        r2 = ((WrapperView) r2).mItem;
    L6:
        return super.performItemClick(r2, r3, r4);
    }

    private void positionSelectorRect() {
        if (this.mSelectorRect.isEmpty() == true) goto L10;
        int r0 = getSelectorPosition();
        if (r0 < 0) goto L11;
        View r1 = getChildAt(r0 - getFixedFirstVisibleItem());
        if ((r1 instanceof WrapperView) == false) goto L12;
        WrapperView r2 = (WrapperView) r1;
        Rect r3 = this.mSelectorRect;
        r3.top = r2.getTop() + r2.mItemTop;
        return;
    L12:
        return;
    L11:
        return;
    }

    private int getSelectorPosition() {
        Field r0 = this.mSelectorPositionField;
        if (r0 != null) goto L20;
        int r1 = 0;
    L6:
        if (r1 >= getChildCount()) goto L25;
        if (getChildAt(r1).getBottom() == this.mSelectorRect.bottom) goto L10;
        r1 = r1 + 1;
        goto L6
    L10:
        return r1 + getFixedFirstVisibleItem();
    L25:
        return -1;
    L20:
        return r0.getInt(this);
    L14:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L16:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    @Override // com.obric.oui.bouncelayout.OListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r3) {
        positionSelectorRect();
        if (this.mTopClippingLength == 0) goto L5;
        r3.save();
        Rect r0 = r3.getClipBounds();
        r0.top = this.mTopClippingLength;
        r3.clipRect(r0);
        super.dispatchDraw(r3);
        r3.restore();
    L6:
        this.mLifeCycleListener.onDispatchDrawOccurred(r3);
        return;
    L5:
        super.dispatchDraw(r3);
        goto L6
    }

    void setLifeCycleListener(LifeCycleListener r1) {
        this.mLifeCycleListener = r1;
    }

    @Override // android.widget.ListView
    public void addFooterView(View r1) {
        super.addFooterView(r1);
        addInternalFooterView(r1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View r1, Object r2, boolean r3) {
        super.addFooterView(r1, r2, r3);
        addInternalFooterView(r1);
    }

    private void addInternalFooterView(View r2) {
        if (this.mFooterViews != null) goto L5;
        this.mFooterViews = new ArrayList();
    L5:
        this.mFooterViews.add(r2);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View r2) {
        if (super.removeFooterView(r2) == false) goto L6;
        this.mFooterViews.remove(r2);
        return true;
    L6:
        return false;
    }

    boolean containsFooterView(View r1) {
        List<View> r0 = this.mFooterViews;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.contains(r1);
    }

    void setTopClippingLength(int r1) {
        this.mTopClippingLength = r1;
    }

    int getFixedFirstVisibleItem() {
        return getFirstVisiblePosition();
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean r1) {
        this.mClippingToPadding = r1;
        super.setClipToPadding(r1);
    }

    public void setBlockLayoutChildren(boolean r1) {
        this.mBlockLayoutChildren = r1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        if (this.mBlockLayoutChildren == true) goto L6;
        super.layoutChildren();
        return;
    }

    @Override // com.android.settings.widget.HorizontalScrollListView
    public void playDeleteItemAnimation(final Animator.AnimatorListener r15) {
        View r0 = getHintView();
        int r1 = getHintViewPosition();
        if ((r0 instanceof WrapperView) == true) goto L5;
    L9:
        final View r7 = r0;
        if (r7 != null) goto L14;
        if (r15 == null) goto L37;
        r15.onAnimationStart(null);
        r15.onAnimationEnd(null);
        return;
    L37:
        return;
    L14:
        final View r2 = getBtnsView();
        final int r9 = r7.getScrollX();
        if (isStateLeft() == false) goto L17;
        int r3 = r7.getWidth();
    L18:
        int r10 = 0;
        ValueAnimator r4 = ValueAnimator.ofInt(new int[]{r9, r3});
        r4.setInterpolator(new DecelerateInterpolator(1.5f));
        r4.setDuration(200);
        r4.addUpdateListener(new AnonymousClass1(this, r7));
        r4.addListener(new AnonymousClass2(this, r15, r7, r2, r9));
        if (r2 == null) goto L31;
        AlphaAnimation r14 = new AlphaAnimation(1.0f, 0.0f);
        r14.setDuration(200);
        r14.setFillAfter(true);
        r14.setInterpolator(new DecelerateInterpolator(1.5f));
        if ((r2 instanceof ViewGroup) == false) goto L30;
        ViewGroup r5 = (ViewGroup) r2;
        int r16 = r5.getChildCount();
    L23:
        if (r10 >= r16) goto L31;
        View r6 = r5.getChildAt(r10);
        if (r6 == null) goto L29;
        if (r6.getVisibility() != 0) goto L29;
        r6.startAnimation(r14);
    L29:
        r10 = r10 + 1;
        goto L23
    L30:
        r2.startAnimation(r14);
    L31:
        r4.start();
        return;
    L17:
        r3 = -r7.getWidth();
        goto L18
    L5:
        if (r1 >= (getAdapter().getCount() - 1)) goto L9;
        if (nextPositionHasSameHeader(r1) == false) goto L9;
        r0 = ((WrapperView) r0).mItem;
        goto L9
    }

    private boolean nextPositionHasSameHeader(int r5) {
        ListAdapter r4 = getAdapter();
        if ((r4 instanceof StickyListHeadersAdapter) == false) goto L9;
        if (r5 == 0) goto L10;
        StickyListHeadersAdapter r6 = (StickyListHeadersAdapter) r4;
        if (r6.getHeaderId(r5) == r6.getHeaderId(r5 + 1)) goto L8;
        return false;
    L8:
        return true;
    L10:
        return false;
    L9:
        return false;
    }
}
