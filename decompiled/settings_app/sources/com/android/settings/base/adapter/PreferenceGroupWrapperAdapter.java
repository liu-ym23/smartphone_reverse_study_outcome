package com.android.settings.base.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreferenceGroupWrapperAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0018\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/android/settings/base/adapter/PreferenceGroupWrapperAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "innerAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "TYPE_FOOTER", "", "TYPE_HEADER", "TYPE_NORMAL", "footerView", "Landroid/view/View;", "headerView", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setFooterView", "view", "setHeaderView", "SimpleViewHolder", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PreferenceGroupWrapperAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int TYPE_FOOTER;
    private final int TYPE_HEADER;
    private final int TYPE_NORMAL;
    private View footerView;
    private View headerView;
    private final RecyclerView.Adapter<RecyclerView.ViewHolder> innerAdapter;

    /* JADX INFO: compiled from: PreferenceGroupWrapperAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/settings/base/adapter/PreferenceGroupWrapperAdapter$SimpleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SimpleViewHolder extends RecyclerView.ViewHolder {
        public SimpleViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public PreferenceGroupWrapperAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> r2) {
        Intrinsics.checkNotNullParameter(r2, "innerAdapter");
        this.innerAdapter = r2;
        this.TYPE_HEADER = 1;
        this.TYPE_FOOTER = 2;
    }

    public final void setHeaderView(View r1) {
        this.headerView = r1;
        notifyDataSetChanged();
    }

    public final void setFooterView(View r1) {
        this.footerView = r1;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r2) {
        if (this.headerView == null) goto L8;
        if (r2 != 0) goto L8;
        return this.TYPE_HEADER;
    L8:
        if (this.footerView == null) goto L14;
        if (r2 != (getItemCount() - 1)) goto L14;
        return this.TYPE_FOOTER;
    L14:
        return this.TYPE_NORMAL;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        if (r3 != this.TYPE_HEADER) goto L6;
        View r1 = this.headerView;
        Intrinsics.checkNotNull(r1);
        return new SimpleViewHolder(r1);
    L6:
        if (r3 != this.TYPE_FOOTER) goto L8;
        View r4 = this.footerView;
        Intrinsics.checkNotNull(r4);
        return new SimpleViewHolder(r4);
    L8:
        RecyclerView.ViewHolder r5 = this.innerAdapter.onCreateViewHolder(r2, r3);
        Intrinsics.checkNotNullExpressionValue(r5, "onCreateViewHolder(...)");
        return r5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        int r0 = getItemViewType(r4);
        if (r0 != this.TYPE_HEADER) goto L5;
        return;
    L5:
        if (r0 != this.TYPE_FOOTER) goto L8;
        return;
    L8:
        if (this.headerView == null) goto L10;
        r4 = r4 - 1;
    L10:
        this.innerAdapter.onBindViewHolder(r3, r4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int r0 = this.innerAdapter.getItemCount();
        if (this.headerView == null) goto L6;
        r0 = r0 + 1;
    L6:
        if (this.footerView != null) goto L8;
        return r0;
    L8:
        return r0 + 1;
    }
}
