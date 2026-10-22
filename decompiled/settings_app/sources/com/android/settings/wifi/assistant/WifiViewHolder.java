package com.android.settings.wifi.assistant;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WifiViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/android/settings/wifi/assistant/WifiViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "Lcom/android/settings/wifi/assistant/SubAccessPoint$OnUpdateListener;", "listItemView", "Lcom/obric/oui/lisitem/OCardListItem;", "resort", "Lkotlin/Function0;", "", "(Lcom/obric/oui/lisitem/OCardListItem;Lkotlin/jvm/functions/Function0;)V", "getResort", "()Lkotlin/jvm/functions/Function0;", "bindData", "info", "Lcom/android/settings/wifi/assistant/SubAccessPoint;", "cardPosition", "", "onUpdate", "subAccessPoint", "succeeded", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WifiViewHolder extends RecyclerView.ViewHolder implements SubAccessPoint.OnUpdateListener {
    private final OCardListItem listItemView;
    private final Function0<Unit> resort;

    /* JADX INFO: renamed from: $r8$lambda$hwBBGM6yjjvz3Uf8kfQoD3-oV5U, reason: not valid java name */
    public static /* synthetic */ void m723$r8$lambda$hwBBGM6yjjvz3Uf8kfQoD3oV5U(WifiViewHolder r0, SubAccessPoint r1, View r2) {
        bindData$lambda$1(r0, r1, r2);
    }

    public final Function0<Unit> getResort() {
        return this.resort;
    }

    public WifiViewHolder(OCardListItem r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "listItemView");
        Intrinsics.checkNotNullParameter(r3, "resort");
        super(r2);
        this.listItemView = r2;
        this.resort = r3;
        ImageView r1 = new ImageView(r2.getContext());
        r1.setImageResource(R.drawable.ic_info_button_bold);
        r2.setCustomEndView(r1);
        r2.showCustomEnd(false);
    }

    public final void bindData(final SubAccessPoint r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "info");
        AccessPointUIUtils.bindData$default(AccessPointUIUtils.INSTANCE, this.listItemView, r8, false, 2, null);
        OCardListItem.setCardPosition$default(this.listItemView, r9, false, 2, null);
        View r10 = this.listItemView.getCustomEndView();
        if (r10 == null) goto L5;
        r10.setOnClickListener(new WifiViewHolder$$ExternalSyntheticLambda0(this, r8));
    L5:
        r8.setOnUpdateListener(this);
    }

    private static final void bindData$lambda$1(WifiViewHolder r1, SubAccessPoint r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$info");
        WifiUtils r4 = WifiUtils.INSTANCE;
        Context r5 = r1.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "getContext(...)");
        r4.openAccessPointDetailPage(r5, r2.getInfo(), r2.isConnected());
    }

    @Override // com.android.settings.wifi.assistant.SubAccessPoint.OnUpdateListener
    public void onUpdate(SubAccessPoint r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "subAccessPoint");
        AccessPointUIUtils.bindData$default(AccessPointUIUtils.INSTANCE, this.listItemView, r8, false, 2, null);
        if (r9 == false) goto L6;
        this.resort.invoke();
        return;
    }
}
