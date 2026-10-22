package com.obric.oui.orecyclerview.widget;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SortedListAdapterCallback<T2> extends SortedList.Callback<T2> {
    final RecyclerView.Adapter<?> mAdapter;

    public SortedListAdapterCallback(RecyclerView.Adapter<?> r1) {
        this.mAdapter = r1;
    }

    @Override // com.obric.oui.orecyclerview.widget.ListUpdateCallback
    public void onInserted(int r1, int r2) {
        this.mAdapter.notifyItemRangeInserted(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.ListUpdateCallback
    public void onRemoved(int r1, int r2) {
        this.mAdapter.notifyItemRangeRemoved(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.ListUpdateCallback
    public void onMoved(int r1, int r2) {
        this.mAdapter.notifyItemMoved(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.SortedList.Callback
    public void onChanged(int r1, int r2) {
        this.mAdapter.notifyItemRangeChanged(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.SortedList.Callback, com.obric.oui.orecyclerview.widget.ListUpdateCallback
    public void onChanged(int r1, int r2, Object r3) {
        this.mAdapter.notifyItemRangeChanged(r1, r2, r3);
    }
}
