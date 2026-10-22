package com.android.settings.stickylistheaders;

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
    private boolean wrapClipChildren;

    interface OnHeaderClickListener {
        void onHeaderClick(View r1, int r2, long r3);
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
    public /* bridge */ /* synthetic */ View getView(int r1, View r2, ViewGroup r3) {
        return getView(r1, r2, r3);
    }

    AdapterWrapper(Context r2, StickyListHeadersAdapter r3) {
        this.mHeaderCache = new LinkedList();
        this.wrapClipChildren = true;
        DataSetObserver r0 = new AnonymousClass1(this);
        this.mDataSetObserver = r0;
        this.mContext = r2;
        this.mDelegate = r3;
        r3.registerDataSetObserver(r0);
    }

    void setDivider(Drawable r1, int r2) {
        this.mDivider = r1;
        this.mDividerHeight = r2;
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.mDelegate.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int r1) {
        return this.mDelegate.isEnabled(r1);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDelegate.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int r1) {
        return this.mDelegate.getItem(r1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return this.mDelegate.getItemId(r1);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.mDelegate.hasStableIds();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r1) {
        return this.mDelegate.getItemViewType(r1);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.mDelegate.getViewTypeCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.mDelegate.isEmpty();
    }

    private void recycleHeaderIfExists(WrapperView r2) {
        View r3 = r2.mHeader;
        if (r3 == null) goto L6;
        r3.setVisibility(0);
        this.mHeaderCache.add(r3);
        return;
    }

    private View configureHeader(WrapperView r3, final int r4) {
        if (r3.mHeader != null) goto L5;
        View r0 = popHeader();
    L6:
        View r5 = this.mDelegate.getHeaderView(r4, r0, r3);
        if (r5 == null) goto L11;
        r5.setClickable(true);
        r5.setOnClickListener(new AnonymousClass2(this, r4));
        return r5;
    L11:
        throw new NullPointerException("Header view must not be null.");
    L5:
        r0 = r3.mHeader;
        goto L6
    }

    private View popHeader() {
        if (this.mHeaderCache.size() > 0) goto L5;
        return null;
    L5:
        return this.mHeaderCache.remove(0);
    }

    private boolean previousPositionHasSameHeader(int r4) {
        if (r4 != 0) goto L4;
    L6:
        return false;
    L4:
        if (this.mDelegate.getHeaderId(r4) != this.mDelegate.getHeaderId(r4 - 1)) goto L6;
        return true;
    }

    @Override // android.widget.Adapter
    public WrapperView getView(int r4, View r5, ViewGroup r6) {
        if (r5 != null) goto L4;
    L7:
        WrapperView r7 = new WrapperView(this.mContext);
    L8:
        View r8 = this.mDelegate.getView(r4, r7.mItem, r6);
        if (previousPositionHasSameHeader(r4) == false) goto L11;
        recycleHeaderIfExists(r7);
        View r0 = null;
    L12:
        boolean r1 = r8 instanceof Checkable;
        if (r1 == true) goto L15;
    L17:
        if (r1 == false) goto L19;
    L21:
        this.mDelegate.onBindHeaderAndItem(r4, r0, r8);
        r7.update(r8, r0, this.mDivider, this.mDividerHeight);
        r7.setClipChildren(this.wrapClipChildren);
        r8.setImportantForAccessibility(1);
        r7.setImportantForAccessibility(2);
        return r7;
    L19:
        if ((r7 instanceof CheckableWrapperView) == false) goto L21;
        r7 = new WrapperView(this.mContext);
        goto L21
    L15:
        if ((r7 instanceof CheckableWrapperView) == true) goto L17;
        r7 = new CheckableWrapperView(this.mContext);
        goto L21
    L11:
        r0 = configureHeader(r7, r4);
        goto L12
    L4:
        if ((r5 instanceof WrapperView) == false) goto L7;
        r7 = (WrapperView) r5;
        goto L8
    }

    public void setOnHeaderClickListener(OnHeaderClickListener r1) {
        this.mOnHeaderClickListener = r1;
    }

    public void setWrapClipChildren(boolean r1) {
        this.wrapClipChildren = r1;
    }

    public boolean equals(Object r1) {
        return this.mDelegate.equals(r1);
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int r1, View r2, ViewGroup r3) {
        return ((BaseAdapter) this.mDelegate).getDropDownView(r1, r2, r3);
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

    @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
    public View getHeaderView(int r1, View r2, ViewGroup r3) {
        return this.mDelegate.getHeaderView(r1, r2, r3);
    }

    @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
    public long getHeaderId(int r1) {
        return this.mDelegate.getHeaderId(r1);
    }
}
