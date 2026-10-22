package com.android.settings.specialaccess;

import android.content.Context;
import android.view.ViewGroup;
import com.android.settings.R;
import com.android.settings.applications.manageapplications.ApplicationHeadViewHolder;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpecialAccessHeaderAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/android/settings/specialaccess/SpecialAccessHeaderAdapter;", "Lcom/android/settings/specialaccess/HeaderBaseAdapter;", "callback", "Lkotlin/Function1;", "Lcom/obric/oui/sectiontitlebar/OSectionSupportiveText;", "", "(Lkotlin/jvm/functions/Function1;)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", "onBindHeaderViewHolder", "holder", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "position", "", "onCreateHeaderViewHolder", "parent", "Landroid/view/ViewGroup;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class SpecialAccessHeaderAdapter extends HeaderBaseAdapter {
    private final Function1<OSectionSupportiveText, Unit> callback;

    /* JADX WARN: Multi-variable type inference failed */
    public SpecialAccessHeaderAdapter(Function1<? super OSectionSupportiveText, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.callback = r2;
    }

    public final Function1<OSectionSupportiveText, Unit> getCallback() {
        return this.callback;
    }

    @Override // com.android.settings.specialaccess.HeaderBaseAdapter
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        ApplicationHeadViewHolder.Companion r1 = ApplicationHeadViewHolder.Companion;
        Context r3 = r2.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "getContext(...)");
        return r1.create(r3);
    }

    @Override // com.android.settings.specialaccess.HeaderBaseAdapter
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        OSectionSupportiveText r3 = (OSectionSupportiveText) r1.itemView.findViewById(R.id.tv_permission_desc);
        if (r3 == null) goto L6;
        this.callback.invoke(r3);
        return;
    }
}
