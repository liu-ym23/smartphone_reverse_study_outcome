package com.obric.security.cleaner.cacheFragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.security.R;
import com.obric.security.cleaner.RubbishEntityWrapper;
import com.obric.security.cleaner.cacheFragment.viewholder.RubbishBaseViewHolder;
import com.obric.security.cleaner.cacheFragment.viewholder.SoftCacheViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.fg.module.cleanV2.RubbishEntity;

/* JADX INFO: compiled from: SoftCacheListAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0018\u0010\u0017\u001a\u00020\u000e2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0016R.\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/obric/security/cleaner/cacheFragment/adapter/SoftCacheListAdapter;", "Lcom/obric/security/cleaner/cacheFragment/adapter/RubbishBaseAdapter;", "()V", "wrappers", "Ljava/util/ArrayList;", "Lcom/obric/security/cleaner/RubbishEntityWrapper;", "Lkotlin/collections/ArrayList;", "getWrappers", "()Ljava/util/ArrayList;", "setWrappers", "(Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "Lcom/obric/security/cleaner/cacheFragment/viewholder/RubbishBaseViewHolder;", "position", "onCreateViewHolder", "Lcom/obric/security/cleaner/cacheFragment/viewholder/SoftCacheViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "dataList", "", "Ltmsdk/fg/module/cleanV2/RubbishEntity;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SoftCacheListAdapter extends RubbishBaseAdapter {
    private ArrayList<RubbishEntityWrapper> wrappers;

    public SoftCacheListAdapter() {
    }

    @Override // com.obric.security.cleaner.cacheFragment.adapter.RubbishBaseAdapter, com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((RubbishBaseViewHolder) r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    public final ArrayList<RubbishEntityWrapper> getWrappers() {
        return this.wrappers;
    }

    public final void setWrappers(ArrayList<RubbishEntityWrapper> r1) {
        this.wrappers = r1;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public SoftCacheViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        View r1 = LayoutInflater.from(r2.getContext()).inflate(R.layout.soft_cache_item, r2, false);
        Intrinsics.checkNotNullExpressionValue(r1, "view");
        return new SoftCacheViewHolder(r1);
    }

    @Override // com.obric.security.cleaner.cacheFragment.adapter.RubbishBaseAdapter
    public void onBindViewHolder(RubbishBaseViewHolder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        ArrayList<RubbishEntityWrapper> r1 = this.wrappers;
        if (r1 == null) goto L5;
        RubbishEntityWrapper r4 = r1.get(r3);
    L6:
        if (r4 == null) goto L9;
        ((SoftCacheViewHolder) r2).onBind(r4);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.obric.security.cleaner.cacheFragment.adapter.RubbishBaseAdapter, com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<RubbishEntityWrapper> r0 = this.wrappers;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    @Override // com.obric.security.cleaner.cacheFragment.adapter.RubbishBaseAdapter
    public void setData(List<? extends RubbishEntity> r6) {
        this.wrappers = new ArrayList();
        if (r6 == null) goto L10;
        Iterator<T> r0 = r6.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        RubbishEntity r1 = (RubbishEntity) r0.next();
        ArrayList<RubbishEntityWrapper> r2 = this.wrappers;
        if (r2 == null) goto L6;
        r2.add(new RubbishEntityWrapper(r1, 0));
    L10:
        if (r6 != null) goto L12;
        return;
    L12:
        this.wrappers = this.wrappers;
        notifyDataSetChanged();
    }
}
