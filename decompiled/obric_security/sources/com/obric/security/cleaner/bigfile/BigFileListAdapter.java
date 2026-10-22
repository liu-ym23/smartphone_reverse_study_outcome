package com.obric.security.cleaner.bigfile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.DiffUtil;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.security.R;
import com.obric.vault.feat.main.diffutil.BigfileDiffCallback;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BigFileListAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\"\u0010\u0016\u001a\u00020\u000f2\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/security/cleaner/bigfile/BigFileListAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/security/cleaner/bigfile/BigFileItemViewHolder;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/obric/security/cleaner/bigfile/BigFileScanResultItem;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class BigFileListAdapter extends RecyclerView.Adapter<BigFileItemViewHolder> {
    private ArrayList<BigFileScanResultItem> dataList;

    public BigFileListAdapter() {
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((BigFileItemViewHolder) r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    public final ArrayList<BigFileScanResultItem> getDataList() {
        return this.dataList;
    }

    public final void setDataList(ArrayList<BigFileScanResultItem> r1) {
        this.dataList = r1;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public BigFileItemViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        View r1 = LayoutInflater.from(r2.getContext()).inflate(R.layout.bigfile_item, r2, false);
        Intrinsics.checkNotNullExpressionValue(r1, "view");
        return new BigFileItemViewHolder(r1);
    }

    public void onBindViewHolder(BigFileItemViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        ArrayList<BigFileScanResultItem> r0 = this.dataList;
        if (r0 == null) goto L5;
        BigFileScanResultItem r1 = r0.get(r7);
    L6:
        if (r1 == null) goto L8;
        r6.onBind(r1, r7, this);
    L8:
        OCardListItem r2 = r6.getListItem();
        if (r2 == null) goto L12;
        r2.setCardType(1);
    L12:
        if (getItemCount() != 1) goto L17;
        OCardListItem r5 = r6.getListItem();
        if (r5 == null) goto L32;
        OCardListItem.setCardPosition$default(r5, 0, false, 2, null);
        return;
    L32:
        return;
    L17:
        if (r7 != 0) goto L21;
        OCardListItem r8 = r6.getListItem();
        if (r8 == null) goto L33;
        OCardListItem.setCardPosition$default(r8, 1, false, 2, null);
        return;
    L33:
        return;
    L21:
        ArrayList<BigFileScanResultItem> r9 = this.dataList;
        if (r9 != null) goto L24;
    L28:
        OCardListItem r10 = r6.getListItem();
        if (r10 == null) goto L37;
        OCardListItem.setCardPosition$default(r10, 2, false, 2, null);
        return;
    L37:
        return;
    L24:
        if (r7 != (r9.size() - 1)) goto L28;
        OCardListItem r11 = r6.getListItem();
        if (r11 == null) goto L35;
        OCardListItem.setCardPosition$default(r11, 3, false, 2, null);
        return;
    L35:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<BigFileScanResultItem> r0 = this.dataList;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final void setData(ArrayList<BigFileScanResultItem> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        DiffUtil.DiffResult r0 = DiffUtil.calculateDiff(new BigfileDiffCallback(this.dataList, r4));
        Intrinsics.checkNotNullExpressionValue(r0, "com.obric.oui.orecyclerv…this.dataList, dataList))");
        this.dataList = r4;
        r0.dispatchUpdatesTo(this);
        ArrayList<BigFileScanResultItem> r5 = this.dataList;
        if (r5 == null) goto L7;
        int r6 = r5.size();
    L8:
        if (r6 <= 0) goto L13;
        notifyItemChanged(0);
        if (r6 <= 1) goto L14;
        notifyItemChanged(r6 - 1);
        return;
    L14:
        return;
    L13:
        return;
    L7:
        r6 = 0;
        goto L8
    }
}
