package com.android.settings.stickylistheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class ExpandableStickyListHeadersAdapter extends BaseAdapter implements StickyListHeadersAdapter {
    List<Long> mCollapseHeaderIds;
    DistinctMultiHashMap<Integer, View> mHeaderIdToViewMap;
    private final StickyListHeadersAdapter mInnerAdapter;
    DualHashMap<View, Long> mViewToItemIdMap;

    ExpandableStickyListHeadersAdapter(StickyListHeadersAdapter r2) {
        this.mViewToItemIdMap = new DualHashMap();
        this.mHeaderIdToViewMap = new DistinctMultiHashMap();
        this.mCollapseHeaderIds = new ArrayList();
        this.mInnerAdapter = r2;
    }

    @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
    public View getHeaderView(int r1, View r2, ViewGroup r3) {
        return this.mInnerAdapter.getHeaderView(r1, r2, r3);
    }

    @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
    public long getHeaderId(int r1) {
        return this.mInnerAdapter.getHeaderId(r1);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.mInnerAdapter.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int r1) {
        return this.mInnerAdapter.isEnabled(r1);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver r1) {
        this.mInnerAdapter.registerDataSetObserver(r1);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver r1) {
        this.mInnerAdapter.unregisterDataSetObserver(r1);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mInnerAdapter.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int r1) {
        return this.mInnerAdapter.getItem(r1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return this.mInnerAdapter.getItemId(r1);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.mInnerAdapter.hasStableIds();
    }

    @Override // android.widget.Adapter
    public View getView(int r3, View r4, ViewGroup r5) {
        View r6 = this.mInnerAdapter.getView(r3, r4, r5);
        if (r6 != null) goto L6;
        return null;
    L6:
        this.mViewToItemIdMap.put(r6, Long.valueOf(getItemId(r3)));
        this.mHeaderIdToViewMap.add(Integer.valueOf((int) getHeaderId(r3)), r6);
        if (this.mCollapseHeaderIds.contains(Long.valueOf(getHeaderId(r3))) == false) goto L9;
        r6.setVisibility(8);
    L10:
        return r6;
    L9:
        r6.setVisibility(0);
        goto L10
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r1) {
        return this.mInnerAdapter.getItemViewType(r1);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.mInnerAdapter.getViewTypeCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.mInnerAdapter.isEmpty();
    }

    public List<View> getItemViewsByHeaderId(long r1) {
        return this.mHeaderIdToViewMap.get(Integer.valueOf((int) r1));
    }

    public boolean isHeaderCollapsed(long r1) {
        return this.mCollapseHeaderIds.contains(Long.valueOf(r1));
    }

    public void expand(long r2) {
        if (isHeaderCollapsed(r2) == false) goto L6;
        this.mCollapseHeaderIds.remove(Long.valueOf(r2));
        return;
    }

    public void collapse(long r2) {
        if (isHeaderCollapsed(r2) == true) goto L6;
        this.mCollapseHeaderIds.add(Long.valueOf(r2));
        return;
    }

    public View findViewByItemId(long r1) {
        return this.mViewToItemIdMap.getKey(Long.valueOf(r1));
    }

    public long findItemIdByView(View r1) {
        return this.mViewToItemIdMap.get(r1).longValue();
    }
}
