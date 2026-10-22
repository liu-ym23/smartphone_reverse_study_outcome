package com.obric.security.cleaner.cacheFragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.security.R;
import com.obric.security.cleaner.cacheFragment.viewholder.SystemCacheViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemCacheListAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/security/cleaner/cacheFragment/adapter/SystemCacheListAdapter;", "Lcom/obric/security/cleaner/cacheFragment/adapter/RubbishBaseAdapter;", "()V", "onCreateViewHolder", "Lcom/obric/security/cleaner/cacheFragment/viewholder/SystemCacheViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SystemCacheListAdapter extends RubbishBaseAdapter {
    public SystemCacheListAdapter() {
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public SystemCacheViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        View r1 = LayoutInflater.from(r2.getContext()).inflate(R.layout.soft_cache_item, r2, false);
        Intrinsics.checkNotNullExpressionValue(r1, "view");
        return new SystemCacheViewHolder(r1);
    }
}
