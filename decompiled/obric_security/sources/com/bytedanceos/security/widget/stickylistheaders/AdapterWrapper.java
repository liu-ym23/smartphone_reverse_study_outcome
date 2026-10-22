package com.bytedanceos.security.widget.stickylistheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class AdapterWrapper extends BaseAdapter implements StickyListHeadersAdapter {
    private final Context mContext;
    private DataSetObserver mDataSetObserver;
    final StickyListHeadersAdapter mDelegate;
    private Drawable mDivider;
    private int mDividerHeight;
    private final List<View> mHeaderCache;
    private OnHeaderClickListener mOnHeaderClickListener;

    interface OnHeaderClickListener {
        void onHeaderClick(View header, int itemPosition, long headerId);
    }

    static /* synthetic */ List access$000(AdapterWrapper r0) {
        return r0.mHeaderCache;
    }

    static /* synthetic */ void access$101(AdapterWrapper r0) {
        super.notifyDataSetInvalidated();
    }

    static /* synthetic */ void access$201(AdapterWrapper r0) {
        super.notifyDataSetChanged();
    }

    static /* synthetic */ OnHeaderClickListener access$300(AdapterWrapper r0) {
        return r0.mOnHeaderClickListener;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ View getView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    AdapterWrapper(Context context, StickyListHeadersAdapter delegate) {
        this.mHeaderCache = new LinkedList();
        DataSetObserver r0 = new AnonymousClass1(this);
        this.mDataSetObserver = r0;
        this.mContext = context;
        this.mDelegate = delegate;
        delegate.registerDataSetObserver(r0);
    }

    void setDivider(Drawable divider, int dividerHeight) {
        this.mDivider = divider;
        this.mDividerHeight = dividerHeight;
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.mDelegate.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int position) {
        return this.mDelegate.isEnabled(position);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDelegate.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.mDelegate.getItem(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return this.mDelegate.getItemId(position);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.mDelegate.hasStableIds();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        return this.mDelegate.getItemViewType(position);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.mDelegate.getViewTypeCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.mDelegate.isEmpty();
    }

    private void recycleHeaderIfExists(WrapperView wv) {
        View r2 = wv.mHeader;
        if (r2 == null) goto L6;
        r2.setVisibility(0);
        this.mHeaderCache.add(r2);
        return;
    }

    private View configureHeader(WrapperView wv, final int position) {
        if (wv.mHeader != null) goto L5;
        View r0 = popHeader();
    L6:
        View r3 = this.mDelegate.getHeaderView(position, r0, wv);
        if (r3 == null) goto L11;
        r3.setClickable(true);
        r3.setOnClickListener(new AnonymousClass2(this, position));
        return r3;
    L11:
        throw new NullPointerException("Header view must not be null.");
    L5:
        r0 = wv.mHeader;
        goto L6
    }

    private View popHeader() {
        if (this.mHeaderCache.size() > 0) goto L5;
        return null;
    L5:
        return this.mHeaderCache.remove(0);
    }

    private boolean previousPositionHasSameHeader(int position) {
        if (position != 0) goto L4;
    L6:
        return false;
    L4:
        if (this.mDelegate.getHeaderId(position) != this.mDelegate.getHeaderId(position - 1)) goto L6;
        return true;
    }

    @Override // android.widget.Adapter
    public WrapperView getView(int position, View convertView, ViewGroup parent) {
        if (convertView != null) goto L4;
        WrapperView r4 = new WrapperView(this.mContext);
    L5:
        View r5 = this.mDelegate.getView(position, r4.mItem, parent);
        if (previousPositionHasSameHeader(position) == false) goto L8;
        recycleHeaderIfExists(r4);
        View r3 = null;
    L9:
        boolean r0 = r5 instanceof Checkable;
        if (r0 == true) goto L12;
    L14:
        if (r0 == false) goto L16;
    L18:
        r4.update(r5, r3, this.mDivider, this.mDividerHeight);
        return r4;
    L16:
        if ((r4 instanceof CheckableWrapperView) == false) goto L18;
        r4 = new WrapperView(this.mContext);
        goto L18
    L12:
        if ((r4 instanceof CheckableWrapperView) == true) goto L14;
        r4 = new CheckableWrapperView(this.mContext);
        goto L18
    L8:
        r3 = configureHeader(r4, position);
        goto L9
    L4:
        r4 = (WrapperView) convertView;
        goto L5
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
        this.mOnHeaderClickListener = onHeaderClickListener;
    }

    public boolean equals(Object o) {
        return this.mDelegate.equals(o);
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return ((BaseAdapter) this.mDelegate).getDropDownView(position, convertView, parent);
    }

    public int hashCode() {
        return this.mDelegate.hashCode();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        ((BaseAdapter) this.mDelegate).notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        ((BaseAdapter) this.mDelegate).notifyDataSetInvalidated();
    }

    public String toString() {
        return this.mDelegate.toString();
    }

    @Override // com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersAdapter
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        return this.mDelegate.getHeaderView(position, convertView, parent);
    }

    @Override // com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersAdapter
    public long getHeaderId(int position) {
        return this.mDelegate.getHeaderId(position);
    }
}
