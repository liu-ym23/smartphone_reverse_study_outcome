package com.qihoo360.mobilesafe.common.ui.list;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class TreeView extends ListView implements AbsListView.OnScrollListener {
    private boolean mActionDownHappened;
    private boolean mClickItemEnableExpand;
    protected boolean mHeaderCanCollapse;
    private int mHeaderHeight;
    private TreeViewWrapper.OnHeaderUpdateListener mHeaderUpdateListener;
    private View mHeaderView;
    private int mHeaderWidth;
    protected boolean mIsHeaderGroupClickable;
    private boolean mIsScroll;
    private OnItemClickListenerImpl mItemClickListenerImpl;
    private int mMaxDepth;
    private View.OnClickListener mOnClickListener;
    private final TreeViewWrapper.TreeElement mRootElement;
    private AbsListView.OnScrollListener mScrollListener;
    private TViewAdapter mTViewAdapter;
    private View mTouchTarget;
    private final List<TreeViewWrapper.TreeElement> mTreeElements;
    private TreeViewWrapper.OnTreeItemClickListener mTreeItemClickListener;

    private class OnItemClickListenerImpl implements AdapterView.OnItemClickListener {
        private AdapterView.OnItemClickListener mListener;
        final /* synthetic */ TreeView this$0;

        private OnItemClickListenerImpl(TreeView r1) {
            this.this$0 = r1;
        }

        /* synthetic */ OnItemClickListenerImpl(TreeView r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ AdapterView.OnItemClickListener access$102(OnItemClickListenerImpl r0, AdapterView.OnItemClickListener r1) {
            r0.mListener = r1;
            return r1;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> r9, View r10, int r11, long r12) {
            int r0 = this.this$0.getTreeItemPosition(r11);
            if (r0 == (-1)) goto L14;
            TreeViewWrapper.TreeElement r1 = (TreeViewWrapper.TreeElement) TreeView.access$200(this.this$0).get(r0);
            if (r1.getDepth() < TreeView.access$300(this.this$0)) goto L7;
        L15:
            AdapterView.OnItemClickListener r2 = this.mListener;
            if (r2 == null) goto L19;
            r2.onItemClick(r9, r10, r11, r12);
        L19:
            if (TreeView.access$700(this.this$0) == null) goto L25;
            if (r1 != null) goto L22;
            return;
        L22:
            if (r1.isDivider() == true) goto L27;
            TreeView.access$700(this.this$0).onTreeElementClick(this.this$0, r1, r11);
            return;
        L27:
            return;
        L25:
            return;
        L7:
            if (r1.isLeaf() == true) goto L15;
            if (TreeView.access$400(this.this$0) == false) goto L15;
            if (r1.isExpand() == false) goto L13;
            TreeView.access$500(this.this$0, r1, r0, true);
            goto L15
        L13:
            TreeView.access$600(this.this$0, r1, r0, true);
            goto L15
        L14:
            r1 = null;
            goto L15
        }
    }

    private class TViewAdapter extends TreeViewWrapper.BaseAdapterExt {
        public TreeViewWrapper.TreeViewAdapter mAdapter;
        final /* synthetic */ TreeView this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private TViewAdapter(TreeView r1) {
            this.this$0 = r1;
            this.mAdapter = null;
        }

        /* synthetic */ TViewAdapter(TreeView r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return TreeView.access$200(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return TreeView.access$200(this.this$0).get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r2, View r3, ViewGroup r4) {
            TreeViewWrapper.TreeElement r0 = (TreeViewWrapper.TreeElement) getItem(r2);
            return this.mAdapter.getViewInternal(r2, r3, r4, r0);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r2) {
            TreeViewWrapper.TreeElement r3 = (TreeViewWrapper.TreeElement) TreeView.access$200(this.this$0).get(r2);
            TreeViewWrapper.TreeViewAdapter r1 = this.mAdapter;
            if (r1 == null) goto L5;
            int r4 = r1.getItemViewTypeInternal(r3);
        L6:
            if (r4 == (-1)) goto L8;
            return r4;
        L8:
            return r3.getDepth();
        L5:
            r4 = -1;
            goto L6
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            TreeViewWrapper.TreeViewAdapter r0 = this.mAdapter;
            if (r0 == null) goto L5;
            int r1 = r0.getViewTypeCountInternal();
        L6:
            if (r1 == (-1)) goto L8;
            return r1;
        L8:
            return TreeView.access$300(this.this$0);
        L5:
            r1 = -1;
            goto L6
        }

        @Override // com.qihoo360.mobilesafe.common.ui.list.TreeViewWrapper.BaseAdapterExt
        public boolean nextPositionIsDivider(int r3) {
            int r4 = r3 + 1;
            if (r4 < TreeView.access$200(this.this$0).size()) goto L5;
            return true;
        L5:
            return ((TreeViewWrapper.TreeElement) TreeView.access$200(this.this$0).get(r4)).isDivider();
        }
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return getAdapter();
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r1) {
        setAdapter((ListAdapter) r1);
    }

    static /* synthetic */ List access$200(TreeView r0) {
        return r0.mTreeElements;
    }

    static /* synthetic */ int access$300(TreeView r0) {
        return r0.mMaxDepth;
    }

    static /* synthetic */ boolean access$400(TreeView r0) {
        return r0.mClickItemEnableExpand;
    }

    static /* synthetic */ boolean access$500(TreeView r0, TreeViewWrapper.TreeElement r1, int r2, boolean r3) {
        return r0.collapseElement(r1, r2, r3);
    }

    static /* synthetic */ boolean access$600(TreeView r0, TreeViewWrapper.TreeElement r1, int r2, boolean r3) {
        return r0.expandElement(r1, r2, r3);
    }

    static /* synthetic */ TreeViewWrapper.OnTreeItemClickListener access$700(TreeView r0) {
        return r0.mTreeItemClickListener;
    }

    static /* synthetic */ int access$800(TreeView r0, int r1) {
        return r0.getFirstVisibleGroupPos(r1);
    }

    public TreeView(Context r2) {
        this(r2, null);
    }

    public TreeView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mItemClickListenerImpl = null;
        this.mTreeItemClickListener = null;
        this.mRootElement = new TreeViewWrapper.TreeElement(null, null);
        this.mTreeElements = new ArrayList();
        this.mTViewAdapter = null;
        this.mMaxDepth = 1;
        this.mClickItemEnableExpand = true;
        this.mScrollListener = null;
        this.mHeaderUpdateListener = null;
        this.mHeaderCanCollapse = true;
        this.mActionDownHappened = false;
        this.mIsHeaderGroupClickable = true;
        this.mIsScroll = true;
        this.mOnClickListener = new AnonymousClass1(this);
        initView();
    }

    public void setMaxDepth(int r2) {
        if (r2 < 1) goto L7;
        this.mMaxDepth = r2;
        return;
    L7:
        throw new RuntimeException("invalid depth!");
    }

    public void setAdapter(TreeViewWrapper.TreeViewAdapter r3) {
        if (r3 == null) goto L9;
        if (this.mTViewAdapter != null) goto L6;
        this.mTViewAdapter = new TViewAdapter(this, null);
    L6:
        this.mTViewAdapter.mAdapter = r3;
        r3.mBaseAdapter = this.mTViewAdapter;
        super.setAdapter(this.mTViewAdapter);
        return;
    L9:
        throw new RuntimeException("invalid adapter!");
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener r2) {
        OnItemClickListenerImpl r0 = this.mItemClickListenerImpl;
        if (r2 != r0) goto L5;
        super.setOnItemClickListener(r2);
        return;
    L5:
        OnItemClickListenerImpl.access$102(r0, r2);
    }

    public void setOnTreeItemClickListener(TreeViewWrapper.OnTreeItemClickListener r1) {
        this.mTreeItemClickListener = r1;
    }

    public TreeViewWrapper.TreeElement getRootElement(boolean r1) {
        if (r1 == false) goto L5;
        this.mRootElement.mChildList.clear();
    L5:
        return this.mRootElement;
    }

    public void refreshAllElements() {
        this.mTreeElements.clear();
        ArrayList r0 = new ArrayList(30);
        Iterator<TreeViewWrapper.TreeElement> r1 = this.mRootElement.mChildList.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        TreeViewWrapper.TreeElement r2 = r1.next();
        this.mTreeElements.add(r2);
        if (r2.isExpand() == false) goto L4;
        r0.clear();
        r2.getExpandList(r0);
        this.mTreeElements.addAll(r0);
        goto L4
    }

    public TreeViewWrapper.TreeElement insertElementByData(Object r2, TreeViewWrapper.TreeElement r3) {
        return insertElementByData(r2, r3, false);
    }

    public TreeViewWrapper.TreeElement insertElementByData(Object r2, TreeViewWrapper.TreeElement r3, boolean r4) {
        return insertElementByData(r2, r3, r4, false);
    }

    public TreeViewWrapper.TreeElement insertElementByData(Object r1, TreeViewWrapper.TreeElement r2, boolean r3, boolean r4) {
        TreeViewWrapper.TreeElement r0 = null;
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r3 == false) goto L7;
        r0 = new TreeViewWrapper.TreeElement(null, r2);
    L7:
        TreeViewWrapper.TreeElement r5 = new TreeViewWrapper.TreeElement(r1, r2);
        if (r0 == null) goto L11;
        r0.setDividerOwner(r5);
    L11:
        if (r5.isExpand() == r4) goto L13;
        r5.toggleExpand();
    L13:
        return r5;
    }

    public int deleteElement(TreeViewWrapper.TreeElement r4) {
        int r0 = this.mRootElement.deleteChildRecursion(r4);
        int r1 = this.mTreeElements.size() - 1;
    L3:
        if (r1 < 0) goto L8;
        if (this.mTreeElements.get(r1) == r4) goto L6;
        r1 = r1 - 1;
        goto L3
    L6:
        this.mTreeElements.remove(r1);
    L8:
        return r0;
    }

    public int deleteElementByData(Object r6) {
        int r0 = this.mRootElement.deleteChildRecursionByData(r6);
        int r1 = this.mTreeElements.size() - 1;
    L3:
        if (r1 < 0) goto L24;
        TreeViewWrapper.TreeElement r2 = this.mTreeElements.get(r1);
        Object r3 = r2.getData();
        if (r2.isDivider() == false) goto L14;
        Object r4 = r2.mDividerOwner.getData();
        if (r4 == r6) goto L12;
        if (r4 == null) goto L23;
        if (r4.equals(r6) == true) goto L12;
    L23:
        r1 = r1 - 1;
    L12:
        if (r2.getDepth() != r2.mDividerOwner.getDepth()) goto L23;
        this.mTreeElements.remove(r1);
        goto L23
    L14:
        if (r3 == r6) goto L22;
        if (r3 == null) goto L20;
        if (r3.equals(r6) == true) goto L22;
    L20:
        if (r2.isParentData(r6) == false) goto L23;
        this.mTreeElements.remove(r1);
    L22:
        this.mTreeElements.remove(r1);
        goto L23
    L24:
        return r0;
    }

    public int deleteElementByComparator(Comparator<TreeViewWrapper.TreeElement> r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r0 = this.mRootElement.deleteChildRecursionByComparator(r5);
        int r1 = this.mTreeElements.size() - 1;
    L6:
        if (r1 < 0) goto L21;
        TreeViewWrapper.TreeElement r2 = this.mTreeElements.get(r1);
        if (r2.isDivider() == false) goto L15;
        if (r5.equals(r2.mDividerOwner) == false) goto L20;
        if (r2.getDepth() != r2.mDividerOwner.getDepth()) goto L20;
        this.mTreeElements.remove(r1);
    L20:
        r1 = r1 - 1;
        goto L6
    L15:
        if (r5.equals(r2) == false) goto L18;
        this.mTreeElements.remove(r1);
        goto L20
    L18:
        if (r2.isParentEquals(r5) == false) goto L20;
        this.mTreeElements.remove(r1);
        goto L20
    L21:
        return r0;
    }

    public List<TreeViewWrapper.TreeElement> findElementByComparator(Comparator<TreeViewWrapper.TreeElement> r3, boolean r4) {
        ArrayList r0 = new ArrayList();
        if (r3 != null) goto L5;
        return r0;
    L5:
        if (r4 == false) goto L14;
        Iterator<TreeViewWrapper.TreeElement> r2 = this.mTreeElements.iterator();
    L8:
        if (r2.hasNext() == false) goto L15;
        TreeViewWrapper.TreeElement r5 = r2.next();
        if (r3.equals(r5) == false) goto L8;
        if (r5.isDivider() == true) goto L8;
        r0.add(r5);
    L15:
        return r0;
    L14:
        this.mRootElement.findChildRecursionByComparator(r3, r0);
        goto L15
    }

    public boolean expandElement(TreeViewWrapper.TreeElement r3) {
        return expandElement(r3, -1, false);
    }

    public boolean collapseElement(TreeViewWrapper.TreeElement r3) {
        return collapseElement(r3, -1, false);
    }

    public void setClickItemEnableExpand(boolean r1) {
        this.mClickItemEnableExpand = r1;
    }

    public boolean isClickItemEnableExpand() {
        return this.mClickItemEnableExpand;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter r1) {
        throw new RuntimeException("invalid adapter!");
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    private boolean expandElement(TreeViewWrapper.TreeElement r6, int r7, boolean r8) {
        if (r6 != null) goto L5;
    L26:
        return false;
    L5:
        if (r6.getDepth() >= this.mMaxDepth) goto L26;
        if (r6.isLeaf() == true) goto L26;
        if (r6.isExpand() == false) goto L13;
        return true;
    L13:
        if (r7 != (-1)) goto L21;
        int r3 = 0;
    L16:
        if (r3 >= this.mTreeElements.size()) goto L21;
        if (r6 == this.mTreeElements.get(r3)) goto L19;
        r3 = r3 + 1;
        goto L16
    L19:
        r7 = r3;
    L21:
        if (r7 == (-1)) goto L26;
        ArrayList r0 = new ArrayList(30);
        r6.getExpandList(r0);
        this.mTreeElements.addAll(r7 + 1, r0);
        r6.toggleExpand();
        if (r8 == false) goto L25;
        this.mTViewAdapter.mAdapter.notifyDataSetChanged();
    L25:
        return true;
    }

    private boolean collapseElement(TreeViewWrapper.TreeElement r7, int r8, boolean r9) {
        if (r7 != null) goto L5;
    L36:
        return false;
    L5:
        if (r7.getDepth() >= this.mMaxDepth) goto L36;
        if (r7.isLeaf() == true) goto L36;
        if (r7.isExpand() == true) goto L12;
        return true;
    L12:
        int r1 = r7.getDepth();
        if (r8 != (-1)) goto L21;
        int r4 = 0;
    L16:
        if (r4 >= this.mTreeElements.size()) goto L21;
        if (r7 == this.mTreeElements.get(r4)) goto L19;
        r4 = r4 + 1;
        goto L16
    L19:
        r8 = r4;
    L21:
        if (r8 == (-1)) goto L36;
        ArrayList r0 = new ArrayList(30);
        int r10 = r8 + 1;
    L24:
        if (r10 >= this.mTreeElements.size()) goto L29;
        if (this.mTreeElements.get(r10).getDepth() <= r1) goto L29;
        r0.add(Integer.valueOf(r10));
        r10 = r10 + 1;
    L29:
        int r11 = r0.size() - 1;
    L30:
        if (r11 < 0) goto L32;
        this.mTreeElements.remove(((Integer) r0.get(r11)).intValue());
        r11 = r11 - 1;
        goto L30
    L32:
        r7.toggleExpand();
        if (r9 == false) goto L35;
        this.mTViewAdapter.mAdapter.notifyDataSetChanged();
    L35:
        return true;
    }

    public boolean isHeaderOrFooterPosition(int r3) {
        int r0 = this.mTreeElements.size() + getHeaderViewsCount();
        if (r3 < getHeaderViewsCount()) goto L7;
        if (r3 >= r0) goto L7;
        return false;
    L7:
        return true;
    }

    public int getTreeItemPosition(int r3) {
        if (r3 < getHeaderViewsCount()) goto L9;
        int r4 = r3 - getHeaderViewsCount();
        if (r4 < this.mTreeElements.size()) goto L8;
        return -1;
    L8:
        return r4;
    L9:
        return -1;
    }

    public void setHeaderCanCollapse(boolean r1) {
        this.mHeaderCanCollapse = r1;
    }

    public void setOnHeaderUpdateListener(TreeViewWrapper.OnHeaderUpdateListener r3) {
        this.mHeaderUpdateListener = r3;
        if (r3 != null) goto L6;
        this.mHeaderView = null;
        this.mHeaderHeight = 0;
        this.mHeaderWidth = 0;
        return;
    L6:
        View r0 = r3.getPinnedHeader();
        this.mHeaderView = r0;
        r0.setOnClickListener(this.mOnClickListener);
        if ((getParent() instanceof ITreeViewListener) == false) goto L9;
        ((ITreeViewListener) getParent()).setHeaderView(this.mHeaderView);
    L9:
        int r1 = getFirstVisibleGroupPos(getFirstVisiblePosition());
        r3.updatePinnedHeader(this.mHeaderView, getTreeItemPosition(r1));
        requestLayout();
        postInvalidate();
    }

    public void setScroll(boolean r1) {
        this.mIsScroll = r1;
    }

    public void requestRefreshHeader() {
        if (this.mHeaderView != null) goto L5;
        return;
    L5:
        refreshHeader();
        invalidate(new Rect(0, 0, this.mHeaderWidth, this.mHeaderHeight));
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        View r0 = this.mHeaderView;
        if (r0 != null) goto L5;
        return;
    L5:
        measureChild(r0, r2, r3);
        this.mHeaderWidth = this.mHeaderView.getMeasuredWidth();
        this.mHeaderHeight = this.mHeaderView.getMeasuredHeight();
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);     // Catch: Throwable -> L11
    L3:
        View r6 = this.mHeaderView;
        if (r6 != null) goto L6;
        return;
    L6:
        int r7 = r6.getTop();
        int r8 = this.mHeaderHeight;
        if (r7 != ((-r8) - 1)) goto L9;
        hideHeader();
        return;
    L9:
        this.mHeaderView.layout(0, r7, this.mHeaderWidth, r8 + r7);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r4) {
        super.dispatchDraw(r4);     // Catch: Throwable -> L6
        View r0 = this.mHeaderView;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        drawChild(r4, r0, getDrawingTime());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    private View getTouchTarget(View r6, int r7, int r8) {
        if ((r6 instanceof ViewGroup) == true) goto L5;
        return r6;
    L5:
        ViewGroup r9 = (ViewGroup) r6;
        int r0 = r9.getChildCount();
        boolean r1 = isChildrenDrawingOrderEnabled();
        int r2 = r0 - 1;
    L6:
        if (r2 < 0) goto L14;
        if (r1 == false) goto L9;
        int r3 = getChildDrawingOrder(r0, r2);
    L10:
        View r4 = r9.getChildAt(r3);
        if (isTouchPointInView(r4, r7, r8) == true) goto L15;
        r2 = r2 - 1;
    L15:
        if (r4 != null) goto L18;
        return r9;
    L18:
        return r4;
    L9:
        r3 = r2;
        goto L10
    L14:
        r4 = null;
        goto L15
    }

    private boolean isTouchPointInView(View r1, int r2, int r3) {
        if (r1.isClickable() == true) goto L5;
        return false;
    L5:
        if (r3 >= r1.getTop()) goto L7;
        return false;
    L7:
        if (r3 <= r1.getBottom()) goto L9;
        return false;
    L9:
        if (r2 >= r1.getLeft()) goto L11;
        return false;
    L11:
        if (r2 > r1.getRight()) goto L19;
        return true;
    L19:
        return false;
    }

    protected void refreshHeader() {
        if (this.mHeaderView != null) goto L5;
        return;
    L5:
        int r0 = getHeaderViewsCount();
        int r1 = getFirstVisiblePosition();
        if (r1 >= 0) goto L8;
        r1 = 0;
    L8:
        int r3 = r1 + 1;
        int r4 = getTreeItemPosition(r3);
        if (r4 != (-1)) goto L11;
    L13:
        int r5 = getFirstVisibleGroupPos(r1);
        int r6 = getFirstVisibleGroupPos(r3);
        TreeViewWrapper.OnHeaderUpdateListener r7 = this.mHeaderUpdateListener;
        if (r7 == null) goto L16;
        r7.updatePinnedHeader(this.mHeaderView, getTreeItemPosition(r5));
        measureChild(this.mHeaderView, View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
    L16:
        if (r5 == (-1)) goto L37;
        if (r5 > r1) goto L37;
        if (r1 < r0) goto L35;
        this.mHeaderView.setVisibility(0);
        if (r6 == (-1)) goto L34;
        int r2 = r6 - r1;
        View r8 = getChildAt(r2);
        if (r8 != null) goto L29;
        if (r6 < r1) goto L26;
        return;
    L26:
        if (this.mHeaderView.getTop() == 0) goto L40;
        this.mHeaderView.layout(0, 0, this.mHeaderWidth, this.mHeaderHeight);
        return;
    L40:
        return;
    L29:
        int r9 = r8.getTop();
        int r10 = this.mHeaderHeight;
        if (r9 > r10) goto L33;
        if (r2 <= 0) goto L33;
        int r11 = r10 - r8.getTop();
        this.mHeaderView.layout(0, -r11, this.mHeaderWidth, this.mHeaderHeight - r11);
        return;
    L33:
        this.mHeaderView.layout(0, 0, this.mHeaderWidth, r10);
        return;
    L34:
        this.mHeaderView.layout(0, 0, this.mHeaderWidth, this.mHeaderHeight);
        return;
    L35:
        hideHeader();
        return;
    L37:
        hideHeader();
        return;
    L11:
        if (this.mTreeElements.get(r4).isDivider() == false) goto L13;
        r3 = r3 + 1;
        goto L13
    }

    protected void hideHeader() {
        View r0 = this.mHeaderView;
        if (r0 == null) goto L6;
        r0.layout((-this.mHeaderWidth) - 1, (-this.mHeaderHeight) - 1, -1, -1);
        this.mHeaderView.setVisibility(8);
        return;
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener r1) {
        if (r1 == this) goto L4;
        this.mScrollListener = r1;
    L5:
        super.setOnScrollListener(this);
        return;
    L4:
        this.mScrollListener = null;
        goto L5
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r1, int r2) {
        AbsListView.OnScrollListener r0 = this.mScrollListener;
        if (r0 == null) goto L6;
        r0.onScrollStateChanged(r1, r2);
        return;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
        if (r4 <= 0) goto L4;
        refreshHeader();
    L4:
        AbsListView.OnScrollListener r0 = this.mScrollListener;
        if (r0 == null) goto L8;
        r0.onScroll(r1, r2, r3, r4);
        return;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        if (this.mIsScroll == true) goto L10;
        r2.setAction(3);     // Catch: Exception -> L9
    L10:
        return super.onTouchEvent(r2);
    L7:
        return true;
    }

    private void initView() {
        setScrollingCacheEnabled(false);
        setFadingEdgeLength(0);
        setDividerHeight(0);
        setOverScrollMode(2);
        setOnScrollListener(this);
        OnItemClickListenerImpl r0 = new OnItemClickListenerImpl(this, null);
        this.mItemClickListenerImpl = r0;
        setOnItemClickListener(r0);
    }

    private int getFirstVisibleGroupPos(int r6) {
        int r0 = getLastVisiblePosition();
    L4:
        if (r6 > r0) goto L18;
        int r2 = getTreeItemPosition(r6);
        if (r2 == (-1)) goto L17;
    L7:
        if (r2 < 0) goto L17;
        TreeViewWrapper.TreeElement r1 = this.mTreeElements.get(r2);
        if (r1.getDepth() != 1) goto L16;
        if (r1.isDivider() == true) goto L16;
        if (r1.isLeaf() == true) goto L16;
        return r2 + getHeaderViewsCount();
    L16:
        r2 = r2 - 1;
    L17:
        r6 = r6 + 1;
        goto L4
    L18:
        return -1;
    }
}
