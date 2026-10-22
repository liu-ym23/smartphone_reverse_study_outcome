package com.android.settings.applications.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OPopoverHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/android/settings/applications/utils/InnerPopoverAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/android/settings/applications/utils/InnerPopoverAdapter$ViewHolder;", "data", "", "Lcom/android/settings/applications/utils/Item;", "listener", "Lcom/android/settings/applications/utils/OnPopoverItemClickListener;", "(Ljava/util/List;Lcom/android/settings/applications/utils/OnPopoverItemClickListener;)V", "getData", "()Ljava/util/List;", "getListener", "()Lcom/android/settings/applications/utils/OnPopoverItemClickListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InnerPopoverAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<Item> data;
    private final OnPopoverItemClickListener listener;

    /* JADX INFO: compiled from: OPopoverHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/settings/applications/utils/InnerPopoverAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$_2Uj-aSlHfmM9C4_h5QKZczS1OE, reason: not valid java name */
    public static /* synthetic */ void m315$r8$lambda$_2UjaSlHfmM9C4_h5QKZczS1OE(InnerPopoverAdapter r0, int r1, OCardListItem r2, View r3) {
        onBindViewHolder$lambda$0(r0, r1, r2, r3);
    }

    public InnerPopoverAdapter(List<Item> r2, OnPopoverItemClickListener r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.data = r2;
        this.listener = r3;
    }

    public final List<Item> getData() {
        return this.data;
    }

    public final OnPopoverItemClickListener getListener() {
        return this.listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((ViewHolder) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(R.layout.settings_oui_card_list_item, r3, false);
        Intrinsics.checkNotNullExpressionValue(r5, "inflate(...)");
        return new ViewHolder(r5);
    }

    public void onBindViewHolder(ViewHolder r5, final int r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        View r7 = r5.itemView;
        View r0 = null;
        if (r7 == null) goto L5;
        final OCardListItem r8 = (OCardListItem) r7.findViewById(R.id.card_list_item);
    L6:
        OCardListItemUtils.initCardItemInAdapter(r8, this.data.size(), r6);
        if (r8 == null) goto L9;
        r8.showTitle(true);
    L9:
        OCardListItemUtils.setTitle(r8, this.data.get(r6).getTitle());
        if (r8 == null) goto L12;
        r8.setCardType(0);
    L12:
        if (r8 == null) goto L14;
        r8.showTailIcon(false);
    L14:
        if (r8 == null) goto L16;
        r8.setCustomStartView(R.layout.o_card_list_item_custom_start_mark);
    L16:
        if (r8 == null) goto L19;
        r8.showCustomStart(true);
    L19:
        if (this.data.get(r6).isSelect() == false) goto L22;
        if (r8 == null) goto L28;
        r8.showCustomStart(true);
    L28:
        if (r8 == null) goto L30;
        View r1 = r8.findViewById(R.id.card_container);
    L31:
        if (r8 == null) goto L33;
        r0 = r8.findViewById(R.id.content_container);
    L33:
        if (r0 == null) goto L35;
        r0.setPadding(0, 0, 0, 0);
    L35:
        if (r1 == null) goto L37;
        r1.setPadding(0, 0, 0, 0);
    L37:
        if (r8 == null) goto L40;
        r8.setOnContentClickListener(new InnerPopoverAdapter$$ExternalSyntheticLambda0(this, r6, r8));
        return;
    L40:
        return;
    L30:
        r1 = null;
        goto L31
    L22:
        if (r8 == null) goto L24;
        View r2 = r8.getCustomStartView();
    L25:
        if (r2 == null) goto L28;
        r2.setVisibility(4);
        goto L28
    L24:
        r2 = null;
        goto L25
    L5:
        r8 = null;
        goto L6
    }

    private static final void onBindViewHolder$lambda$0(InnerPopoverAdapter r4, int r5, OCardListItem r6, View r7) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        int r8 = r4.data.size();
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L8;
        if (r1 != r5) goto L6;
        r4.data.get(r1).setSelect(true);
    L7:
        r1 = r1 + 1;
        goto L3
    L6:
        r4.data.get(r1).setSelect(false);
        goto L7
    L8:
        r4.notifyDataSetChanged();
        OnPopoverItemClickListener r9 = r4.listener;
        if (r9 == null) goto L15;
        r9.onPopoverItemClick(r6, r5);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }
}
