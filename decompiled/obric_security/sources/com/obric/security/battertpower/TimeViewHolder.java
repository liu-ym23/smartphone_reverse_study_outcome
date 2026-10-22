package com.obric.security.battertpower;

import android.view.View;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import com.obric.security.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/obric/security/battertpower/TimeViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "oCardListItem", "Lcom/obric/oui/lisitem/OCardListItem;", "getOCardListItem", "()Lcom/obric/oui/lisitem/OCardListItem;", "setOCardListItem", "(Lcom/obric/oui/lisitem/OCardListItem;)V", "onBind", "", "data", "Lcom/obric/security/battertpower/AppPowerProfileData;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class TimeViewHolder extends RecyclerView.ViewHolder {
    private OCardListItem oCardListItem;

    public TimeViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.oCardListItem = (OCardListItem) r2.findViewById(R.id.oCard_list_item);
    }

    public final OCardListItem getOCardListItem() {
        return this.oCardListItem;
    }

    public final void setOCardListItem(OCardListItem r1) {
        this.oCardListItem = r1;
    }

    public final void onBind(AppPowerProfileData r7) {
        Intrinsics.checkNotNullParameter(r7, "data");
        OCardListItem r0 = this.oCardListItem;
        if (r0 == null) goto L5;
        r0.setTitle(r7.getAppName());
    L5:
        OCardListItem r1 = this.oCardListItem;
        if (r1 == null) goto L10;
        OTextView r2 = r1.getTitleView();
        if (r2 == null) goto L10;
        r2.setMaxLines(1);
    L10:
        OCardListItem r3 = this.oCardListItem;
        if (r3 == null) goto L13;
        OCardListItem.setEndDetailText$default(r3, r7.getDurationDesc(), 0, 2, null);
    L13:
        OCardListItem r4 = this.oCardListItem;
        if (r4 == null) goto L16;
        r4.showCustomEnd(true);
    L16:
        OCardListItem r5 = this.oCardListItem;
        if (r5 == null) goto L21;
        OTextView r6 = r5.getEndDetail();
        if (r6 == null) goto L21;
        r6.setMaxLines(1);
    L21:
        OCardListItem r8 = this.oCardListItem;
        if (r8 == null) goto L24;
        r8.setAppIcon(r7.getAppIcon());
    L24:
        OCardListItem r9 = this.oCardListItem;
        if (r9 == null) goto L27;
        r9.showIcon(true);
    L27:
        OCardListItem r10 = this.oCardListItem;
        if (r10 == null) goto L30;
        r10.setOnContentClickListener(AnonymousClass1.INSTANCE);
    L30:
        OCardListItem r11 = this.oCardListItem;
        if (r11 == null) goto L34;
        r11.setCardType(0);
        return;
    }
}
