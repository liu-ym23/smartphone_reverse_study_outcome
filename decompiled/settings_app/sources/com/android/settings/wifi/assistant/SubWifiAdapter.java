package com.android.settings.wifi.assistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.R;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubWifiAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0016\u0010\u0017\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019H\u0007R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/android/settings/wifi/assistant/SubWifiAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/android/settings/wifi/assistant/WifiViewHolder;", "onItemClick", "Lkotlin/Function2;", "Landroid/content/Context;", "Lcom/android/settings/wifi/assistant/SubAccessPoint;", "", "(Lkotlin/jvm/functions/Function2;)V", "mWifiList", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function2;", "getCardPosition", "", "position", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "wifiList", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SubWifiAdapter extends RecyclerView.Adapter<WifiViewHolder> {
    private final List<SubAccessPoint> mWifiList;
    private final Function2<Context, SubAccessPoint, Unit> onItemClick;

    /* JADX INFO: renamed from: $r8$lambda$bL4_aDnH9RzjjF62VaEDh-4tRsE, reason: not valid java name */
    public static /* synthetic */ void m722$r8$lambda$bL4_aDnH9RzjjF62VaEDh4tRsE(int r0, SubWifiAdapter r1, WifiViewHolder r2, View r3) {
        onBindViewHolder$lambda$0(r0, r1, r2, r3);
    }

    public static final /* synthetic */ List access$getMWifiList$p(SubWifiAdapter r0) {
        return r0.mWifiList;
    }

    public final Function2<Context, SubAccessPoint, Unit> getOnItemClick() {
        return this.onItemClick;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((WifiViewHolder) r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubWifiAdapter(Function2<? super Context, ? super SubAccessPoint, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onItemClick");
        this.onItemClick = r2;
        this.mWifiList = new ArrayList();
    }

    public final void setData(List<SubAccessPoint> r2) {
        Intrinsics.checkNotNullParameter(r2, "wifiList");
        this.mWifiList.clear();
        this.mWifiList.addAll(r2);
        notifyDataSetChanged();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public WifiViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        View r4 = LayoutInflater.from(r2.getContext()).inflate(R.layout.card_list_item_layout, null);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.obric.oui.lisitem.OCardListItem");
        return new WifiViewHolder((OCardListItem) r4, new AnonymousClass1(this));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mWifiList.size();
    }

    public void onBindViewHolder(final WifiViewHolder r3, final int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.bindData(this.mWifiList.get(r4), getCardPosition(r4));
        View r0 = r3.itemView;
        if ((r0 instanceof OCardListItem) == false) goto L5;
        OCardListItem r1 = (OCardListItem) r0;
    L6:
        if (r1 == null) goto L9;
        r1.setOnContentClickListener(new SubWifiAdapter$$ExternalSyntheticLambda0(r4, this, r3));
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final void onBindViewHolder$lambda$0(int r1, SubWifiAdapter r2, WifiViewHolder r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$holder");
        OLog.i("SubWifiAdapter", "onBindViewHolder " + r1);
        SubAccessPoint r5 = (SubAccessPoint) CollectionsKt.getOrNull(r2.mWifiList, r1);
        if (r5 != null) goto L5;
        return;
    L5:
        Function2<Context, SubAccessPoint, Unit> r6 = r2.onItemClick;
        Context r7 = r3.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(r7, "getContext(...)");
        r6.invoke(r7, r5);
    }

    private final int getCardPosition(int r2) {
        int r1 = getItemCount();
        if (r1 != 1) goto L5;
        return 0;
    L5:
        if (r2 != 0) goto L8;
        return 1;
    L8:
        if (r2 != (r1 - 1)) goto L10;
        return 3;
    L10:
        return 2;
    }
}
