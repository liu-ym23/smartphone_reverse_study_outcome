package androidx.recyclerview.widget;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
class NestedAdapterWrapper {
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> adapter;
    private RecyclerView.AdapterDataObserver mAdapterObserver;
    int mCachedItemCount;
    final Callback mCallback;
    private final StableIdStorage.StableIdLookup mStableIdLookup;
    private final ViewTypeStorage.ViewTypeLookup mViewTypeLookup;

    interface Callback {
        void onChanged(NestedAdapterWrapper r1);

        void onItemRangeChanged(NestedAdapterWrapper r1, int r2, int r3);

        void onItemRangeChanged(NestedAdapterWrapper r1, int r2, int r3, Object r4);

        void onItemRangeInserted(NestedAdapterWrapper r1, int r2, int r3);

        void onItemRangeMoved(NestedAdapterWrapper r1, int r2, int r3);

        void onItemRangeRemoved(NestedAdapterWrapper r1, int r2, int r3);

        void onStateRestorationPolicyChanged(NestedAdapterWrapper r1);
    }

    NestedAdapterWrapper(RecyclerView.Adapter<RecyclerView.ViewHolder> r2, Callback r3, ViewTypeStorage r4, StableIdStorage.StableIdLookup r5) {
        this.mAdapterObserver = new AnonymousClass1(this);
        this.adapter = r2;
        this.mCallback = r3;
        this.mViewTypeLookup = r4.createViewTypeWrapper(this);
        this.mStableIdLookup = r5;
        this.mCachedItemCount = r2.getItemCount();
        r2.registerAdapterDataObserver(this.mAdapterObserver);
    }

    void dispose() {
        this.adapter.unregisterAdapterDataObserver(this.mAdapterObserver);
        this.mViewTypeLookup.dispose();
    }

    int getCachedItemCount() {
        return this.mCachedItemCount;
    }

    int getItemViewType(int r2) {
        return this.mViewTypeLookup.localToGlobal(this.adapter.getItemViewType(r2));
    }

    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        int r4 = this.mViewTypeLookup.globalToLocal(r3);
        return this.adapter.onCreateViewHolder(r2, r4);
    }

    void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        this.adapter.bindViewHolder(r1, r2);
    }

    public long getItemId(int r3) {
        long r0 = this.adapter.getItemId(r3);
        return this.mStableIdLookup.localToGlobal(r0);
    }
}
