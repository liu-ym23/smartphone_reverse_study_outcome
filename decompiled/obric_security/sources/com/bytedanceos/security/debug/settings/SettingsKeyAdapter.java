package com.bytedanceos.security.debug.settings;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: SettingsKeyAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u001c\u0010\u0015\u001a\u00020\n2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u0014\u0010\u0017\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedanceos/security/debug/settings/SettingsKeyAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedanceos/security/debug/settings/SettingKeyViewHolder;", "()V", "items", "Ljava/util/ArrayList;", "Lcom/bytedanceos/security/debug/settings/SettingsKeyEntry;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function1;", "", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnClickListener", "listener", "submitList", "newItems", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SettingsKeyAdapter extends RecyclerView.Adapter<SettingKeyViewHolder> {
    private final ArrayList<SettingsKeyEntry> items;
    private Function1<? super SettingsKeyEntry, Unit> onItemClickListener;

    public SettingsKeyAdapter() {
        this.items = new ArrayList();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((SettingKeyViewHolder) r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    public final void submitList(List<? extends SettingsKeyEntry> r2) {
        Intrinsics.checkNotNullParameter(r2, "newItems");
        this.items.clear();
        this.items.addAll(r2);
        notifyDataSetChanged();
    }

    public final void setOnClickListener(Function1<? super SettingsKeyEntry, Unit> r1) {
        this.onItemClickListener = r1;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r1) {
        SettingsKeyEntry r0 = this.items.get(r1);
        if ((r0 instanceof SettingsKeyEntry.ScopeEntry) == false) goto L6;
        return 0;
    L6:
        if ((r0 instanceof SettingsKeyEntry.ChildEntry) == false) goto L10;
        return 1;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public SettingKeyViewHolder onCreateViewHolder(ViewGroup r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        if (r8 == 0) goto L5;
        OSectionTitleBar r6 = LayoutInflater.from(r7.getContext()).inflate(R.layout.pm_item_settings_key, r7, false);
        Intrinsics.checkNotNullExpressionValue(r6, "LayoutInflater.from(pare…tings_key, parent, false)");
    L6:
        RecyclerView.LayoutParams r9 = new RecyclerView.LayoutParams(-1, -2);
        Resources r1 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r1, "Resources.getSystem()");
        r9.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 6, r1.getDisplayMetrics()));
        if (r8 != 0) goto L9;
        float r10 = 16;
        Resources r0 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r0, "Resources.getSystem()");
        r9.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, r10, r0.getDisplayMetrics())));
        Resources r2 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r2, "Resources.getSystem()");
        r9.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, r10, r2.getDisplayMetrics())));
    L9:
        r6.setLayoutParams(r9);
        return new SettingKeyViewHolder(r6);
    L5:
        Context r3 = r7.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "parent.context");
        r6 = new OSectionTitleBar(r3, null, 0, 6, null);
        goto L6
    }

    public void onBindViewHolder(SettingKeyViewHolder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        SettingsKeyEntry r4 = this.items.get(r3);
        Intrinsics.checkNotNullExpressionValue(r4, "items[position]");
        r2.bind(r4, this.onItemClickListener);
    }
}
