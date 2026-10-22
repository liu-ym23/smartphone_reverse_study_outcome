package com.obric.security.battertpower.powerHigh.clearApp;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedanceos.oui.OCardListItemExtKt;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.DiffUtil;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.security.R;
import com.obric.security.battertpower.powerHigh.notice.PowerHighApp;
import com.obric.vault.feat.main.diffutil.PowerHighAppsDiffCallback;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: PowerHighAppsAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u001e\u0010\u0012\u001a\u00020\u000b2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/clearApp/PowerHighAppsAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/security/battertpower/powerHigh/clearApp/PowerHighAppsViewHolder;", "()V", "powerHighApps", "Ljava/util/ArrayList;", "Lcom/obric/security/battertpower/powerHigh/notice/PowerHighApp;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "dataList", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PowerHighAppsAdapter extends RecyclerView.Adapter<PowerHighAppsViewHolder> {
    private ArrayList<PowerHighApp> powerHighApps;

    public PowerHighAppsAdapter() {
        this.powerHighApps = new ArrayList();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((PowerHighAppsViewHolder) r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    public final void setData(ArrayList<PowerHighApp> r4) {
        Intrinsics.checkNotNullParameter(r4, "dataList");
        DiffUtil.DiffResult r0 = DiffUtil.calculateDiff(new PowerHighAppsDiffCallback(this.powerHighApps, r4));
        Intrinsics.checkNotNullExpressionValue(r0, "DiffUtil.calculateDiff(P…powerHighApps, dataList))");
        this.powerHighApps = r4;
        r0.dispatchUpdatesTo(this);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public PowerHighAppsViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        View r4 = LayoutInflater.from(r5.getContext()).inflate(R.layout.power_high_apps_item, r5, false);
        if (r4 == null) goto L7;
        OCardListItem r7 = (OCardListItem) r4;
        View r8 = LayoutInflater.from(r5.getContext()).inflate(R.layout.check_box_item_tail, null, false);
        float r0 = 32;
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics())));
        r9.leftMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
        Intrinsics.checkNotNullExpressionValue(r8, "checkBox");
        r8.setLayoutParams(r9);
        OCardListItemExtKt.setStartView(r7, r8);
        return new PowerHighAppsViewHolder(r7);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.lisitem.OCardListItem");
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.powerHighApps.size();
    }

    public void onBindViewHolder(PowerHighAppsViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        PowerHighApp r0 = this.powerHighApps.get(r7);
        Intrinsics.checkNotNullExpressionValue(r0, "powerHighApps.get(position)");
        r6.onBind(r0, r7);
        if (this.powerHighApps.size() != 1) goto L7;
        OCardListItem r5 = r6.getItem();
        if (r5 == null) goto L20;
        OCardListItem.setCardPosition$default(r5, 0, false, 2, null);
        return;
    L20:
        return;
    L7:
        if (r7 != 0) goto L12;
        OCardListItem r8 = r6.getItem();
        if (r8 == null) goto L22;
        OCardListItem.setCardPosition$default(r8, 1, false, 2, null);
        return;
    L22:
        return;
    L12:
        if (r7 != (this.powerHighApps.size() - 1)) goto L16;
        OCardListItem r9 = r6.getItem();
        if (r9 == null) goto L24;
        OCardListItem.setCardPosition$default(r9, 3, false, 2, null);
        return;
    L24:
        return;
    L16:
        OCardListItem r10 = r6.getItem();
        if (r10 == null) goto L26;
        OCardListItem.setCardPosition$default(r10, 2, false, 2, null);
        return;
    }
}
