package com.android.settings.specialaccess;

import android.view.ViewGroup;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HeaderBaseAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H&J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H&J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/settings/specialaccess/HeaderBaseAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "()V", "VIEW_TYPE_HEADER", "", "VIEW_TYPE_ITEM", "getContentItemId", "", "position", "getContentItemViewType", "getItemContentCount", "getItemCount", "getItemId", "getItemViewType", "onBindContentViewHolder", "", "viewHolder", "onBindHeaderViewHolder", "onBindViewHolder", "holder", "onCreateContentViewHolder", "parent", "Landroid/view/ViewGroup;", "onCreateHeaderViewHolder", "onCreateViewHolder", "viewType", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class HeaderBaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int VIEW_TYPE_HEADER;
    private final int VIEW_TYPE_ITEM;

    public long getContentItemId(int r1) {
        return r1;
    }

    public abstract int getItemContentCount();

    public abstract void onBindContentViewHolder(RecyclerView.ViewHolder r1, int r2);

    public abstract void onBindHeaderViewHolder(RecyclerView.ViewHolder r1, int r2);

    public abstract RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup r1, int r2);

    public abstract RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup r1);

    public HeaderBaseAdapter() {
        this.VIEW_TYPE_HEADER = -100000;
        this.VIEW_TYPE_ITEM = -200000;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        if (r3 != this.VIEW_TYPE_HEADER) goto L7;
        return onCreateHeaderViewHolder(r2);
    L7:
        return onCreateContentViewHolder(r2, r3);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        if (r3 != 0) goto L5;
        onBindHeaderViewHolder(r2, 0);
        return;
    L5:
        int r4 = r3 - 1;
        if (r4 < 0) goto L10;
        onBindContentViewHolder(r2, r4);
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (getItemContentCount() != 0) goto L7;
        return 0;
    L7:
        return getItemContentCount() + 1;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r1) {
        return getContentItemId(r1 - 1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r1) {
        if (r1 != 0) goto L6;
        return this.VIEW_TYPE_HEADER;
    L6:
        return getContentItemViewType(r1 - 1);
    }

    public int getContentItemViewType(int r1) {
        return this.VIEW_TYPE_ITEM;
    }
}
