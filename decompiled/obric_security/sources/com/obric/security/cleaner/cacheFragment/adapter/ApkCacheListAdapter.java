package com.obric.security.cleaner.cacheFragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.security.R;
import com.obric.security.cleaner.cacheFragment.viewholder.ApkCacheViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApkCacheListAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/security/cleaner/cacheFragment/adapter/ApkCacheListAdapter;", "Lcom/obric/security/cleaner/cacheFragment/adapter/RubbishBaseAdapter;", "()V", "onCreateViewHolder", "Lcom/obric/security/cleaner/cacheFragment/viewholder/ApkCacheViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ApkCacheListAdapter extends RubbishBaseAdapter {
    public ApkCacheListAdapter() {
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public ApkCacheViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(R.layout.soft_cache_item, r3, false);
        Intrinsics.checkNotNullExpressionValue(r5, "view");
        ApkCacheViewHolder r6 = new ApkCacheViewHolder(r5);
        r6.setAdapter(this);
        return r6;
    }
}
