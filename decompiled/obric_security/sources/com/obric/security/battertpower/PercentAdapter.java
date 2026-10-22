package com.obric.security.battertpower;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.security.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PercentFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u0016\u0010\u001c\u001a\u00020\u00152\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u000e\u0010\u000f\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\fR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/obric/security/battertpower/PercentAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/security/battertpower/PercentViewHolder;", "()V", "dataList", "", "Lcom/obric/security/battertpower/AppPowerProfileData;", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "dropdown", "", "getDropdown", "()Ljava/lang/Boolean;", "setDropdown", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PercentAdapter extends RecyclerView.Adapter<PercentViewHolder> {
    private List<AppPowerProfileData> dataList;
    private Boolean dropdown;

    public PercentAdapter() {
        this.dropdown = true;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((PercentViewHolder) r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    public final List<AppPowerProfileData> getDataList() {
        return this.dataList;
    }

    public final void setDataList(List<AppPowerProfileData> r1) {
        this.dataList = r1;
    }

    public final Boolean getDropdown() {
        return this.dropdown;
    }

    public final void setDropdown(Boolean r1) {
        this.dropdown = r1;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public PercentViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        View r1 = LayoutInflater.from(r2.getContext()).inflate(R.layout.app_battery_profile_item, r2, false);
        Intrinsics.checkNotNullExpressionValue(r1, "view");
        return new PercentViewHolder(r1);
    }

    public void onBindViewHolder(PercentViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        List<AppPowerProfileData> r0 = this.dataList;
        if (r0 == null) goto L5;
        AppPowerProfileData r1 = r0.get(r7);
    L6:
        if (r1 == null) goto L9;
        r6.onBind(r1);
    L9:
        if (getItemCount() != 1) goto L13;
        OCardListItem r5 = r6.getOCardListItem();
        if (r5 == null) goto L28;
        OCardListItem.setCardPosition$default(r5, 0, false, 2, null);
        return;
    L28:
        return;
    L13:
        if (r7 != 0) goto L18;
        OCardListItem r8 = r6.getOCardListItem();
        if (r8 == null) goto L30;
        OCardListItem.setCardPosition$default(r8, 1, false, 2, null);
        return;
    L30:
        return;
    L18:
        if (r7 == (getItemCount() - 1)) goto L20;
    L24:
        OCardListItem r9 = r6.getOCardListItem();
        if (r9 == null) goto L34;
        OCardListItem.setCardPosition$default(r9, 2, false, 2, null);
        return;
    L34:
        return;
    L20:
        if (Intrinsics.areEqual(this.dropdown, false) == false) goto L24;
        OCardListItem r10 = r6.getOCardListItem();
        if (r10 == null) goto L32;
        OCardListItem.setCardPosition$default(r10, 3, false, 2, null);
        return;
    L32:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<AppPowerProfileData> r0 = this.dataList;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final void setData(List<AppPowerProfileData> r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.dataList = r1;
        notifyDataSetChanged();
    }

    public final void setDropdown(boolean r1) {
        this.dropdown = Boolean.valueOf(r1);
    }
}
