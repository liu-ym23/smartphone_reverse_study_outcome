package com.android.settings.notification.zen;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.oui.dialog.v2.selection.OSelectionItemView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SelectionDialogAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000bH\u0016J\u001c\u0010\u000e\u001a\u00020\f2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000bJ\u0014\u0010\u0016\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0017J \u0010\u0018\u001a\u00020\f2\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/settings/notification/zen/SelectionDialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/android/settings/notification/zen/SelectionDialogAdapter$DialogItemViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "items", "", "Lcom/android/settings/notification/zen/ZenRuleInfo;", "onItemClickListener", "Lkotlin/Function2;", "", "", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectItem", "setItems", "", "setOnItemClickListener", "listener", "DialogItemViewHolder", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SelectionDialogAdapter extends RecyclerView.Adapter<DialogItemViewHolder> {
    private final Context context;
    private final List<ZenRuleInfo> items;
    private Function2<? super ZenRuleInfo, ? super Integer, Unit> onItemClickListener;

    /* JADX INFO: compiled from: SelectionDialogAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Lcom/android/settings/notification/zen/SelectionDialogAdapter$DialogItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/android/settings/notification/zen/SelectionDialogAdapter;Landroid/view/View;)V", "bind", "", "item", "Lcom/android/settings/notification/zen/ZenRuleInfo;", "showDivider", "show", "", "toggleCheckState", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class DialogItemViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ SelectionDialogAdapter this$0;

        public DialogItemViewHolder(SelectionDialogAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.this$0 = r2;
            super(r3);
        }

        public final void bind(ZenRuleInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            View r1 = this.itemView;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.oui.dialog.v2.selection.OSelectionItemView");
            OSelectionItemView r3 = (OSelectionItemView) r1;
            r3.setTitle(r2.title);
            r3.setChecked(r2.isChecked);
        }

        public final void showDivider(boolean r2) {
            View r1 = this.itemView;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.oui.dialog.v2.selection.OSelectionItemView");
            ((OSelectionItemView) r1).showDivider(r2);
        }

        public final boolean toggleCheckState() {
            View r1 = this.itemView;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.oui.dialog.v2.selection.OSelectionItemView");
            OSelectionItemView r2 = (OSelectionItemView) r1;
            r2.toggleCheckState();
            return r2.isChecked();
        }
    }

    public static /* synthetic */ void $r8$lambda$Ac5_og8sZh7fIfCiEDQ9x6wjE9Q(ZenRuleInfo r0, DialogItemViewHolder r1, SelectionDialogAdapter r2, int r3, View r4) {
        onBindViewHolder$lambda$1(r0, r1, r2, r3, r4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((DialogItemViewHolder) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    public SelectionDialogAdapter(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.items = new ArrayList();
    }

    public final void setItems(List<? extends ZenRuleInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this.items.clear();
        this.items.addAll(r2);
        notifyDataSetChanged();
    }

    public final void selectItem(int r3) {
        ZenRuleInfo r0 = (ZenRuleInfo) CollectionsKt.getOrNull(this.items, r3);
        if (r0 == null) goto L5;
        r0.isChecked = true;
    L5:
        notifyItemChanged(r3);
    }

    public final void setOnItemClickListener(Function2<? super ZenRuleInfo, ? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.onItemClickListener = r2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DialogItemViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        OSelectionItemView r5 = new OSelectionItemView(this.context, null, 2, null);
        r5.setCheckStyle(OSelectionItemView.Companion.CheckStyle.ICON);
        return new DialogItemViewHolder(this, r5);
    }

    public void onBindViewHolder(final DialogItemViewHolder r4, final int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        final ZenRuleInfo r0 = this.items.get(r5);
        r4.bind(r0);
        if (r5 != (this.items.size() - 1)) goto L5;
        r4.showDivider(false);
    L5:
        r4.itemView.setOnClickListener(new SelectionDialogAdapter$$ExternalSyntheticLambda0(r0, r4, this, r5));
    }

    private static final void onBindViewHolder$lambda$1(ZenRuleInfo r0, DialogItemViewHolder r1, SelectionDialogAdapter r2, int r3, View r4) {
        Intrinsics.checkNotNullParameter(r0, "$item");
        Intrinsics.checkNotNullParameter(r1, "$holder");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r0.isChecked = r1.toggleCheckState();
        Function2<? super ZenRuleInfo, ? super Integer, Unit> r5 = r2.onItemClickListener;
        if (r5 == null) goto L6;
        r5.invoke(r0, Integer.valueOf(r3));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }
}
