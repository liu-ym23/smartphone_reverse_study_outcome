package com.obric.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.oui.selection.OActionSheet;
import com.obric.oui.selection.OActionSheetButton;
import com.obric.oui.selection.OActionSheetItemView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionSheetAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00020\f2\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0014\u0010\u0016\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0017J \u0010\u0018\u001a\u00020\f2\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/widget/ActionSheetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/widget/ActionSheetAdapter$SheetItemViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "items", "", "Lcom/obric/widget/ActionSheetItemData;", "onItemClickListener", "Lkotlin/Function2;", "", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItems", "", "setOnItemClickListener", "listener", "SheetItemViewHolder", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ActionSheetAdapter extends RecyclerView.Adapter<SheetItemViewHolder> {
    private final Context context;
    private final List<ActionSheetItemData> items;
    private Function2<? super ActionSheetItemData, ? super Integer, Unit> onItemClickListener;

    /* JADX INFO: compiled from: ActionSheetAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/obric/widget/ActionSheetAdapter$SheetItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/obric/widget/ActionSheetAdapter;Landroid/view/View;)V", "bind", "", "item", "Lcom/obric/widget/ActionSheetItemData;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class SheetItemViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ ActionSheetAdapter this$0;

        public SheetItemViewHolder(ActionSheetAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.this$0 = r2;
            super(r3);
        }

        public final void bind(ActionSheetItemData r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            View r1 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(r1, "itemView");
            if ((r1 instanceof OActionSheetButton) == false) goto L6;
            OActionSheetButton r3 = (OActionSheetButton) r1;
            r3.setText(r2.getTitle());
            r3.setTextColor(r2.getTitleTextColor());
            return;
        L6:
            if ((r1 instanceof OActionSheetItemView) == false) goto L10;
            OActionSheetItemView r4 = (OActionSheetItemView) r1;
            r4.setTitle(r2.getTitle());
            r4.setIcon(r2.getIcon());
            return;
        }
    }

    public static /* synthetic */ void $r8$lambda$c1pvg_Mj_5nd5Oe9kIL71Zd08mc(ActionSheetAdapter r0, ActionSheetItemData r1, int r2, View r3) {
        onBindViewHolder$lambda$0(r0, r1, r2, r3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((SheetItemViewHolder) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    public ActionSheetAdapter(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.items = new ArrayList();
    }

    public final void setItems(List<ActionSheetItemData> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this.items.clear();
        this.items.addAll(r2);
        notifyDataSetChanged();
    }

    public final void setOnItemClickListener(Function2<? super ActionSheetItemData, ? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.onItemClickListener = r2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SheetItemViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        boolean r0 = true;
        if (r4 == OActionSheet.Companion.ItemStyle.LIST_TEXT_ONLY.ordinal()) goto L10;
        if (r4 == OActionSheet.Companion.ItemStyle.LIST_ICON_AND_TEXT.ordinal()) goto L10;
        r0 = false;
    L10:
        if (r0 == false) goto L13;
        OActionSheetButton r5 = new OActionSheetItemView(this.context, null, 2, null);
    L16:
        return new SheetItemViewHolder(this, r5);
    L13:
        if (r4 != OActionSheet.Companion.ItemStyle.LIST_BUTTON.ordinal()) goto L18;
        r5 = new OActionSheetButton(this.context, null, 2, null);
        goto L16
    L18:
        throw new IllegalArgumentException("Unsupported viewType: " + r4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r1) {
        return this.items.get(r1).getStyle().ordinal();
    }

    public void onBindViewHolder(SheetItemViewHolder r3, final int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        final ActionSheetItemData r0 = this.items.get(r4);
        r3.bind(r0);
        r3.itemView.setOnClickListener(new ActionSheetAdapter$$ExternalSyntheticLambda0(this, r0, r4));
    }

    private static final void onBindViewHolder$lambda$0(ActionSheetAdapter r0, ActionSheetItemData r1, int r2, View r3) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$item");
        Function2<? super ActionSheetItemData, ? super Integer, Unit> r4 = r0.onItemClickListener;
        if (r4 == null) goto L6;
        r4.invoke(r1, Integer.valueOf(r2));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }
}
