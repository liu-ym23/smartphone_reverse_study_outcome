package com.android.settings.widget;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class GridViewWithHeaderAndFooter extends GridView {
    public static boolean DEBUG = false;
    private static final String LOG_TAG = "GridViewHeaderAndFooter";
    private ArrayList<FixedViewInfo> mFooterViewInfos;
    private ArrayList<FixedViewInfo> mHeaderViewInfos;
    private ItemClickHandler mItemClickHandler;
    private int mNumColumns;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private AdapterView.OnItemLongClickListener mOnItemLongClickListener;
    private ListAdapter mOriginalAdapter;
    private int mRowHeight;
    private View mViewForMeasureRowHeight;

    /* JADX INFO: renamed from: com.android.settings.widget.GridViewWithHeaderAndFooter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class FixedViewInfo {
        public Object data;
        public boolean isSelectable;
        public View view;
        public ViewGroup viewContainer;

        private FixedViewInfo() {
        }

        /* synthetic */ FixedViewInfo(AnonymousClass1 r1) {
            this();
        }
    }

    private class FullWidthFixedViewLayout extends FrameLayout {
        final /* synthetic */ GridViewWithHeaderAndFooter this$0;

        public FullWidthFixedViewLayout(GridViewWithHeaderAndFooter r1, Context r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
            int r0 = this.this$0.getPaddingLeft() + getPaddingLeft();
            if (r0 == r4) goto L5;
            offsetLeftAndRight(r0 - r4);
        L5:
            super.onLayout(r3, r4, r5, r6, r7);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int r3, int r4) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((this.this$0.getMeasuredWidth() - this.this$0.getPaddingLeft()) - this.this$0.getPaddingRight(), View.MeasureSpec.getMode(r3)), r4);
        }
    }

    private static class HeaderViewGridAdapter implements WrapperListAdapter, Filterable {
        static final ArrayList<FixedViewInfo> EMPTY_INFO_LIST = null;
        private final ListAdapter mAdapter;
        boolean mAreAllFixedViewsSelectable;
        private boolean mCacheFirstHeaderView;
        private boolean mCachePlaceHoldView;
        private final DataSetObservable mDataSetObservable;
        ArrayList<FixedViewInfo> mFooterViewInfos;
        ArrayList<FixedViewInfo> mHeaderViewInfos;
        private final boolean mIsFilterable;
        private int mNumColumns;
        private int mRowHeight;

        static {
            EMPTY_INFO_LIST = new ArrayList();
        }

        public HeaderViewGridAdapter(ArrayList<FixedViewInfo> r3, ArrayList<FixedViewInfo> r4, ListAdapter r5) {
            this.mDataSetObservable = new DataSetObservable();
            boolean r0 = true;
            this.mNumColumns = 1;
            this.mRowHeight = -1;
            this.mCachePlaceHoldView = true;
            this.mCacheFirstHeaderView = false;
            this.mAdapter = r5;
            this.mIsFilterable = r5 instanceof Filterable;
            if (r3 != null) goto L5;
            this.mHeaderViewInfos = EMPTY_INFO_LIST;
        L6:
            if (r4 != null) goto L8;
            this.mFooterViewInfos = EMPTY_INFO_LIST;
        L10:
            if (areAllListInfosSelectable(this.mHeaderViewInfos) == true) goto L12;
        L14:
            r0 = false;
        L15:
            this.mAreAllFixedViewsSelectable = r0;
            return;
        L12:
            if (areAllListInfosSelectable(this.mFooterViewInfos) == false) goto L14;
        L8:
            this.mFooterViewInfos = r4;
            goto L10
        L5:
            this.mHeaderViewInfos = r3;
            goto L6
        }

        public void setNumColumns(int r2) {
            if (r2 >= 1) goto L6;
            return;
        L6:
            if (this.mNumColumns == r2) goto L9;
            this.mNumColumns = r2;
            notifyDataSetChanged();
            return;
        }

        public void setRowHeight(int r1) {
            this.mRowHeight = r1;
        }

        public int getHeadersCount() {
            return this.mHeaderViewInfos.size();
        }

        public int getFootersCount() {
            return this.mFooterViewInfos.size();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            ListAdapter r0 = this.mAdapter;
            if (r0 != null) goto L5;
        L8:
            return true;
        L5:
            if (r0.isEmpty() == true) goto L8;
            return false;
        }

        private boolean areAllListInfosSelectable(ArrayList<FixedViewInfo> r1) {
            if (r1 == null) goto L10;
            Iterator<FixedViewInfo> r0 = r1.iterator();
        L5:
            if (r0.hasNext() == false) goto L15;
            if (r0.next().isSelectable == true) goto L5;
            return false;
        L15:
            return true;
        L10:
            return true;
        }

        public boolean removeHeader(View r4) {
            boolean r0 = false;
            int r1 = 0;
        L4:
            if (r1 >= this.mHeaderViewInfos.size()) goto L15;
            if (this.mHeaderViewInfos.get(r1).view == r4) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            this.mHeaderViewInfos.remove(r1);
            if (areAllListInfosSelectable(this.mHeaderViewInfos) == true) goto L10;
        L12:
            this.mAreAllFixedViewsSelectable = r0;
            this.mDataSetObservable.notifyChanged();
            return true;
        L10:
            if (areAllListInfosSelectable(this.mFooterViewInfos) == false) goto L12;
            r0 = true;
            goto L12
        L15:
            return false;
        }

        public boolean removeFooter(View r4) {
            boolean r0 = false;
            int r1 = 0;
        L4:
            if (r1 >= this.mFooterViewInfos.size()) goto L15;
            if (this.mFooterViewInfos.get(r1).view == r4) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            this.mFooterViewInfos.remove(r1);
            if (areAllListInfosSelectable(this.mHeaderViewInfos) == true) goto L10;
        L12:
            this.mAreAllFixedViewsSelectable = r0;
            this.mDataSetObservable.notifyChanged();
            return true;
        L10:
            if (areAllListInfosSelectable(this.mFooterViewInfos) == false) goto L12;
            r0 = true;
            goto L12
        L15:
            return false;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.mAdapter == null) goto L7;
            return ((getFootersCount() + getHeadersCount()) * this.mNumColumns) + getAdapterAndPlaceHolderCount();
        L7:
            return (getFootersCount() + getHeadersCount()) * this.mNumColumns;
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter r0 = this.mAdapter;
            if (r0 != null) goto L5;
        L10:
            return true;
        L5:
            if (this.mAreAllFixedViewsSelectable == true) goto L7;
        L9:
            return false;
        L7:
            if (r0.areAllItemsEnabled() == false) goto L9;
            goto L9
        }

        private int getAdapterAndPlaceHolderCount() {
            return (int) (Math.ceil((this.mAdapter.getCount() * 1.0f) / this.mNumColumns) * ((double) this.mNumColumns));
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int r5) {
            int r0 = getHeadersCount();
            int r1 = this.mNumColumns;
            int r2 = r0 * r1;
            if (r5 < r2) goto L5;
            int r6 = r5 - r2;
            if (this.mAdapter == null) goto L22;
            int r3 = getAdapterAndPlaceHolderCount();
            if (r6 < r3) goto L16;
        L23:
            int r7 = r6 - r3;
            int r4 = this.mNumColumns;
            if ((r7 % r4) != 0) goto L29;
            if (this.mFooterViewInfos.get(r7 / r4).isSelectable == false) goto L29;
            return true;
        L29:
            return false;
        L16:
            if (r6 >= this.mAdapter.getCount()) goto L21;
            if (this.mAdapter.isEnabled(r6) == false) goto L21;
            return true;
        L21:
            return false;
        L22:
            r3 = 0;
            goto L23
        L5:
            if ((r5 % r1) != 0) goto L10;
            if (this.mHeaderViewInfos.get(r5 / r1).isSelectable == false) goto L10;
            return true;
        L10:
            return false;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r4) {
            int r0 = getHeadersCount();
            int r1 = this.mNumColumns;
            int r2 = r0 * r1;
            if (r4 < r2) goto L5;
            int r5 = r4 - r2;
            if (this.mAdapter == null) goto L18;
            int r3 = getAdapterAndPlaceHolderCount();
            if (r5 < r3) goto L14;
        L19:
            int r6 = r5 - r3;
            if ((r6 % this.mNumColumns) == 0) goto L22;
            return null;
        L22:
            return this.mFooterViewInfos.get(r6).data;
        L14:
            if (r5 < this.mAdapter.getCount()) goto L16;
            return null;
        L16:
            return this.mAdapter.getItem(r5);
        L18:
            r3 = 0;
            goto L19
        L5:
            if ((r4 % r1) == 0) goto L7;
            return null;
        L7:
            return this.mHeaderViewInfos.get(r4 / r1).data;
        }

        @Override // android.widget.Adapter
        public long getItemId(int r3) {
            int r0 = getHeadersCount() * this.mNumColumns;
            ListAdapter r1 = this.mAdapter;
            if (r1 == null) goto L9;
            if (r3 < r0) goto L11;
            int r4 = r3 - r0;
            if (r4 < r1.getCount()) goto L8;
            return -1;
        L8:
            return this.mAdapter.getItemId(r4);
        L11:
            return -1;
        L9:
            return -1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            ListAdapter r0 = this.mAdapter;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.hasStableIds() == false) goto L7;
            return true;
        }

        @Override // android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            int r1 = 0;
            if (GridViewWithHeaderAndFooter.DEBUG == false) goto L9;
            Object[] r0 = new Object[2];
            r0[0] = Integer.valueOf(r5);
            if (r6 != null) goto L7;
            boolean r3 = true;
        L8:
            r0[1] = Boolean.valueOf(r3);
            OLog.d(GridViewWithHeaderAndFooter.LOG_TAG, String.format("getView: %s, reused: %s", r0));
            goto L9
        L7:
            r3 = false;
        L9:
            int r2 = getHeadersCount();
            int r4 = this.mNumColumns;
            int r8 = r2 * r4;
            if (r5 >= r8) goto L18;
            ViewGroup r9 = this.mHeaderViewInfos.get(r5 / r4).viewContainer;
            if ((r5 % this.mNumColumns) != 0) goto L14;
            return r9;
        L14:
            if (r6 != null) goto L16;
            r6 = new View(r7.getContext());
        L16:
            r6.setVisibility(4);
            r6.setMinimumHeight(r9.getHeight());
            return r6;
        L18:
            int r10 = r5 - r8;
            if (this.mAdapter == null) goto L30;
            r1 = getAdapterAndPlaceHolderCount();
            if (r10 >= r1) goto L30;
            if (r10 < this.mAdapter.getCount()) goto L25;
            if (r6 != null) goto L28;
            r6 = new View(r7.getContext());
        L28:
            r6.setVisibility(4);
            r6.setMinimumHeight(this.mRowHeight);
            return r6;
        L25:
            return this.mAdapter.getView(r10, r6, r7);
        L30:
            int r11 = r10 - r1;
            if (r11 >= getCount()) goto L40;
            ViewGroup r12 = this.mFooterViewInfos.get(r11 / this.mNumColumns).viewContainer;
            if ((r5 % this.mNumColumns) != 0) goto L35;
            return r12;
        L35:
            if (r6 != null) goto L37;
            r6 = new View(r7.getContext());
        L37:
            r6.setVisibility(4);
            r6.setMinimumHeight(r12.getHeight());
            return r6;
        L40:
            throw new ArrayIndexOutOfBoundsException(r5);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int r8) {
            int r0 = getHeadersCount() * this.mNumColumns;
            ListAdapter r1 = this.mAdapter;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r5 = -2;
            if (this.mCachePlaceHoldView == false) goto L16;
            if (r8 >= r0) goto L16;
            if (r8 == 0) goto L11;
        L13:
            int r4 = this.mNumColumns;
            if ((r8 % r4) == 0) goto L16;
            r5 = r2 + ((r8 / r4) + 1);
            goto L16
        L11:
            if (this.mCacheFirstHeaderView == false) goto L13;
            r5 = (((this.mHeaderViewInfos.size() + r2) + this.mFooterViewInfos.size()) + 1) + 1;
        L16:
            int r3 = r8 - r0;
            if (this.mAdapter == null) goto L27;
            int r6 = getAdapterAndPlaceHolderCount();
            if (r3 < 0) goto L29;
            if (r3 >= r6) goto L29;
            if (r3 >= this.mAdapter.getCount()) goto L25;
            r5 = this.mAdapter.getItemViewType(r3);
            goto L29
        L25:
            if (this.mCachePlaceHoldView == false) goto L29;
            r5 = (this.mHeaderViewInfos.size() + r2) + 1;
        L29:
            if (this.mCachePlaceHoldView == false) goto L38;
            int r7 = r3 - r6;
            if (r7 < 0) goto L38;
            if (r7 >= getCount()) goto L38;
            if ((r7 % this.mNumColumns) == 0) goto L38;
            r5 = ((r2 + this.mHeaderViewInfos.size()) + 1) + ((r7 / this.mNumColumns) + 1);
        L38:
            if (GridViewWithHeaderAndFooter.DEBUG == false) goto L40;
            OLog.d(GridViewWithHeaderAndFooter.LOG_TAG, String.format("getItemViewType: pos: %s, result: %s", new Object[]{Integer.valueOf(r8), Integer.valueOf(r5), Boolean.valueOf(this.mCachePlaceHoldView), Boolean.valueOf(this.mCacheFirstHeaderView)}));
        L40:
            return r5;
        L27:
            r6 = 0;
            goto L29
        L5:
            r2 = r1.getViewTypeCount() - 1;
            goto L6
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            ListAdapter r0 = this.mAdapter;
            if (r0 != null) goto L5;
            int r1 = 1;
        L7:
            if (this.mCachePlaceHoldView == false) goto L13;
            int r2 = (this.mHeaderViewInfos.size() + 1) + this.mFooterViewInfos.size();
            if (this.mCacheFirstHeaderView == false) goto L11;
            r2 = r2 + 1;
        L11:
            r1 = r1 + r2;
        L13:
            if (GridViewWithHeaderAndFooter.DEBUG == false) goto L15;
            OLog.d(GridViewWithHeaderAndFooter.LOG_TAG, String.format("getViewTypeCount: %s", new Object[]{Integer.valueOf(r1)}));
        L15:
            return r1;
        L5:
            r1 = r0.getViewTypeCount();
            goto L7
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver r2) {
            this.mDataSetObservable.registerObserver(r2);
            ListAdapter r1 = this.mAdapter;
            if (r1 == null) goto L6;
            r1.registerDataSetObserver(r2);
            return;
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver r2) {
            this.mDataSetObservable.unregisterObserver(r2);
            ListAdapter r1 = this.mAdapter;
            if (r1 == null) goto L6;
            r1.unregisterDataSetObserver(r2);
            return;
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            if (this.mIsFilterable == true) goto L5;
            return null;
        L5:
            return ((Filterable) this.mAdapter).getFilter();
        }

        @Override // android.widget.WrapperListAdapter
        public ListAdapter getWrappedAdapter() {
            return this.mAdapter;
        }

        public void notifyDataSetChanged() {
            this.mDataSetObservable.notifyChanged();
        }
    }

    private class ItemClickHandler implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
        final /* synthetic */ GridViewWithHeaderAndFooter this$0;

        private ItemClickHandler(GridViewWithHeaderAndFooter r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ItemClickHandler(GridViewWithHeaderAndFooter r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> r8, View r9, int r10, long r11) {
            if (GridViewWithHeaderAndFooter.access$200(this.this$0) == null) goto L8;
            int r4 = r10 - (this.this$0.getHeaderViewCount() * GridViewWithHeaderAndFooter.access$300(this.this$0));
            if (r4 < 0) goto L9;
            GridViewWithHeaderAndFooter.access$200(this.this$0).onItemClick(r8, r9, r4, r11);
            return;
        L9:
            return;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> r8, View r9, int r10, long r11) {
            if (GridViewWithHeaderAndFooter.access$400(this.this$0) == null) goto L9;
            int r4 = r10 - (this.this$0.getHeaderViewCount() * GridViewWithHeaderAndFooter.access$300(this.this$0));
            if (r4 < 0) goto L10;
            GridViewWithHeaderAndFooter.access$400(this.this$0).onItemLongClick(r8, r9, r4, r11);
            return true;
        L10:
            return true;
        L9:
            return true;
        }
    }

    static {
    }

    private void initHeaderGridView() {
    }

    @Override // android.view.ViewGroup
    public void setClipChildren(boolean r1) {
    }

    static /* synthetic */ AdapterView.OnItemClickListener access$200(GridViewWithHeaderAndFooter r0) {
        return r0.mOnItemClickListener;
    }

    static /* synthetic */ int access$300(GridViewWithHeaderAndFooter r0) {
        return r0.getNumColumnsCompatible();
    }

    static /* synthetic */ AdapterView.OnItemLongClickListener access$400(GridViewWithHeaderAndFooter r0) {
        return r0.mOnItemLongClickListener;
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r1) {
        setAdapter((ListAdapter) r1);
    }

    public GridViewWithHeaderAndFooter(Context r2) {
        super(r2);
        this.mNumColumns = -1;
        this.mViewForMeasureRowHeight = null;
        this.mRowHeight = -1;
        this.mHeaderViewInfos = new ArrayList();
        this.mFooterViewInfos = new ArrayList();
        initHeaderGridView();
    }

    public GridViewWithHeaderAndFooter(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mNumColumns = -1;
        this.mViewForMeasureRowHeight = null;
        this.mRowHeight = -1;
        this.mHeaderViewInfos = new ArrayList();
        this.mFooterViewInfos = new ArrayList();
        initHeaderGridView();
    }

    public GridViewWithHeaderAndFooter(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mNumColumns = -1;
        this.mViewForMeasureRowHeight = null;
        this.mRowHeight = -1;
        this.mHeaderViewInfos = new ArrayList();
        this.mFooterViewInfos = new ArrayList();
        initHeaderGridView();
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        ListAdapter r3 = getAdapter();
        if (r3 != null) goto L5;
        return;
    L5:
        if ((r3 instanceof HeaderViewGridAdapter) == false) goto L9;
        HeaderViewGridAdapter r4 = (HeaderViewGridAdapter) r3;
        r4.setNumColumns(getNumColumnsCompatible());
        r4.setRowHeight(getRowHeight());
        return;
    }

    public void setClipChildrenSupper(boolean r1) {
        super.setClipChildren(false);
    }

    public void addHeaderView(View r3) {
        addHeaderView(r3, null, true);
    }

    public void addHeaderView(View r8, Object r9, boolean r10) {
        ListAdapter r0 = getAdapter();
        if (r0 != null) goto L5;
    L9:
        ViewGroup.LayoutParams r1 = r8.getLayoutParams();
        FixedViewInfo r2 = new FixedViewInfo(null);
        FullWidthFixedViewLayout r3 = new FullWidthFixedViewLayout(this, getContext());
        if (r1 == null) goto L12;
        r8.setLayoutParams(new FrameLayout.LayoutParams(r1.width, r1.height));
        r3.setLayoutParams(new AbsListView.LayoutParams(r1.width, r1.height));
    L12:
        r3.addView(r8);
        r2.view = r8;
        r2.viewContainer = r3;
        r2.data = r9;
        r2.isSelectable = r10;
        this.mHeaderViewInfos.add(r2);
        if (r0 == null) goto L16;
        ((HeaderViewGridAdapter) r0).notifyDataSetChanged();
        return;
    L16:
        return;
    L5:
        if ((r0 instanceof HeaderViewGridAdapter) == true) goto L9;
        throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
    }

    public void addFooterView(View r3) {
        addFooterView(r3, null, true);
    }

    public void addFooterView(View r8, Object r9, boolean r10) {
        ListAdapter r0 = getAdapter();
        if (r0 != null) goto L5;
    L9:
        ViewGroup.LayoutParams r1 = r8.getLayoutParams();
        FixedViewInfo r2 = new FixedViewInfo(null);
        FullWidthFixedViewLayout r3 = new FullWidthFixedViewLayout(this, getContext());
        if (r1 == null) goto L12;
        r8.setLayoutParams(new FrameLayout.LayoutParams(r1.width, r1.height));
        r3.setLayoutParams(new AbsListView.LayoutParams(r1.width, r1.height));
    L12:
        r3.addView(r8);
        r2.view = r8;
        r2.viewContainer = r3;
        r2.data = r9;
        r2.isSelectable = r10;
        this.mFooterViewInfos.add(r2);
        if (r0 == null) goto L16;
        ((HeaderViewGridAdapter) r0).notifyDataSetChanged();
        return;
    L16:
        return;
    L5:
        if ((r0 instanceof HeaderViewGridAdapter) == true) goto L9;
        throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
    }

    public int getHeaderViewCount() {
        return this.mHeaderViewInfos.size();
    }

    public int getFooterViewCount() {
        return this.mFooterViewInfos.size();
    }

    public boolean removeHeaderView(View r3) {
        boolean r1 = false;
        if (this.mHeaderViewInfos.size() <= 0) goto L10;
        ListAdapter r0 = getAdapter();
        if (r0 != null) goto L7;
    L9:
        removeFixedViewInfo(r3, this.mHeaderViewInfos);
        goto L10
    L7:
        if (((HeaderViewGridAdapter) r0).removeHeader(r3) == false) goto L9;
        r1 = true;
    L10:
        return r1;
    }

    public boolean removeFooterView(View r3) {
        boolean r1 = false;
        if (this.mFooterViewInfos.size() <= 0) goto L10;
        ListAdapter r0 = getAdapter();
        if (r0 != null) goto L7;
    L9:
        removeFixedViewInfo(r3, this.mFooterViewInfos);
        goto L10
    L7:
        if (((HeaderViewGridAdapter) r0).removeFooter(r3) == false) goto L9;
        r1 = true;
    L10:
        return r1;
    }

    private void removeFixedViewInfo(View r3, ArrayList<FixedViewInfo> r4) {
        int r2 = r4.size();
        int r0 = 0;
    L3:
        if (r0 >= r2) goto L11;
        if (r4.get(r0).view == r3) goto L6;
        r0 = r0 + 1;
        goto L3
    L6:
        r4.remove(r0);
        return;
    }

    private int getNumColumnsCompatible() {
        return super.getNumColumns();
    }

    private int getColumnWidthCompatible() {
        return super.getColumnWidth();
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mViewForMeasureRowHeight = null;
    }

    public void invalidateRowHeight() {
        this.mRowHeight = -1;
    }

    public int getHeaderHeight(int r1) {
        if (r1 >= 0) goto L4;
        return 0;
    L4:
        return this.mHeaderViewInfos.get(r1).view.getMeasuredHeight();
    }

    @Override // android.widget.GridView
    public int getVerticalSpacing() {
        return super.getVerticalSpacing();
    L4:
        return 0;
    }

    @Override // android.widget.GridView
    public int getHorizontalSpacing() {
        return super.getHorizontalSpacing();
    L4:
        return 0;
    }

    public int getRowHeight() {
        int r0 = this.mRowHeight;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        ListAdapter r1 = getAdapter();
        int r2 = getNumColumnsCompatible();
        if (r1 != null) goto L8;
    L19:
        return -1;
    L8:
        if (r1.getCount() <= ((this.mHeaderViewInfos.size() + this.mFooterViewInfos.size()) * r2)) goto L19;
        int r3 = getColumnWidthCompatible();
        View r4 = getAdapter().getView(r2 * this.mHeaderViewInfos.size(), this.mViewForMeasureRowHeight, this);
        if (r4 == null) goto L13;
        AbsListView.LayoutParams r5 = (AbsListView.LayoutParams) r4.getLayoutParams();
        if (r5 != null) goto L17;
        r5 = new AbsListView.LayoutParams(-1, -2, 0);
        r4.setLayoutParams(r5);
    L17:
        int r6 = getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, r5.height);
        r4.measure(getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(r3, 1073741824), 0, r5.width), r6);
        this.mViewForMeasureRowHeight = r4;
        int r7 = r4.getMeasuredHeight();
        this.mRowHeight = r7;
        return r7;
    L13:
        return this.mRowHeight;
    }

    public void tryToScrollToBottomSmoothly() {
        smoothScrollToPositionFromTop(getAdapter().getCount() - 1, 0);
    }

    public void tryToScrollToBottomSmoothly(int r3) {
        smoothScrollToPositionFromTop(getAdapter().getCount() - 1, 0, r3);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter r4) {
        this.mOriginalAdapter = r4;
        if (this.mHeaderViewInfos.size() <= 0) goto L5;
    L8:
        HeaderViewGridAdapter r0 = new HeaderViewGridAdapter(this.mHeaderViewInfos, this.mFooterViewInfos, r4);
        int r5 = getNumColumnsCompatible();
        if (r5 <= 1) goto L11;
        r0.setNumColumns(r5);
    L11:
        r0.setRowHeight(getRowHeight());
        super.setAdapter(r0);
        return;
    L5:
        if (this.mFooterViewInfos.size() > 0) goto L8;
        super.setAdapter(r4);
    }

    public ListAdapter getOriginalAdapter() {
        return this.mOriginalAdapter;
    }

    @Override // android.widget.GridView
    public void setNumColumns(int r2) {
        super.setNumColumns(r2);
        this.mNumColumns = r2;
        ListAdapter r1 = getAdapter();
        if (r1 != null) goto L5;
        return;
    L5:
        if ((r1 instanceof HeaderViewGridAdapter) == false) goto L9;
        ((HeaderViewGridAdapter) r1).setNumColumns(r2);
        return;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener r1) {
        this.mOnItemClickListener = r1;
        super.setOnItemClickListener(getItemClickHandler());
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener r1) {
        this.mOnItemLongClickListener = r1;
        super.setOnItemLongClickListener(getItemClickHandler());
    }

    private ItemClickHandler getItemClickHandler() {
        if (this.mItemClickHandler != null) goto L6;
        this.mItemClickHandler = new ItemClickHandler(this, null);
    L6:
        return this.mItemClickHandler;
    }
}
