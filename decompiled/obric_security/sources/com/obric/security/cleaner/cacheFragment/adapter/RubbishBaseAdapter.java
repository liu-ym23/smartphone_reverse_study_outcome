package com.obric.security.cleaner.cacheFragment.adapter;

import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.security.cleaner.cacheFragment.viewholder.RubbishBaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.fg.module.cleanV2.RubbishEntity;

/* JADX INFO: compiled from: RubbishBaseAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001a\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/security/cleaner/cacheFragment/adapter/RubbishBaseAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/security/cleaner/cacheFragment/viewholder/RubbishBaseViewHolder;", "()V", "dataList", "", "Ltmsdk/fg/module/cleanV2/RubbishEntity;", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "setBackground", "oCardListItem", "Lcom/obric/oui/lisitem/OCardListItem;", "setData", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public abstract class RubbishBaseAdapter extends RecyclerView.Adapter<RubbishBaseViewHolder> {
    private List<? extends RubbishEntity> dataList;

    public RubbishBaseAdapter() {
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((RubbishBaseViewHolder) r1, r2);
    }

    public final List<RubbishEntity> getDataList() {
        return this.dataList;
    }

    public final void setDataList(List<? extends RubbishEntity> r1) {
        this.dataList = r1;
    }

    public void onBindViewHolder(RubbishBaseViewHolder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        List<? extends RubbishEntity> r0 = this.dataList;
        if (r0 == null) goto L5;
        RubbishEntity r1 = r0.get(r3);
    L6:
        if (r1 == null) goto L9;
        r2.onBind(r1);
        setBackground(r2.getOCardListItem(), r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<? extends RubbishEntity> r0 = this.dataList;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public void setData(List<? extends RubbishEntity> r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.dataList = r1;
        notifyDataSetChanged();
    }

    public void setBackground(OCardListItem r5, int r6) {
        int r4 = getItemCount();
        if (r4 == 1) goto L13;
        if (r6 != 0) goto L8;
        if (r5 == null) goto L16;
        OCardListItem.setCardPosition$default(r5, 1, false, 2, null);
        return;
    L16:
        return;
    L8:
        if (r6 != (r4 - 1)) goto L11;
        if (r5 == null) goto L18;
        OCardListItem.setCardPosition$default(r5, 3, false, 2, null);
        return;
    L18:
        return;
    L11:
        if (r5 == null) goto L20;
        OCardListItem.setCardPosition$default(r5, 2, false, 2, null);
        return;
    L20:
        return;
    L13:
        if (r5 == null) goto L22;
        OCardListItem.setCardPosition$default(r5, 0, false, 2, null);
        return;
    }
}
