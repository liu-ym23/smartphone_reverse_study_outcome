package com.obric.security.battertpower;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.View;
import com.bytedanceos.oui.OCardListItemExtKt;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import com.obric.security.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PercentViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/security/battertpower/PercentViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "oCardListItem", "Lcom/obric/oui/lisitem/OCardListItem;", "getOCardListItem", "()Lcom/obric/oui/lisitem/OCardListItem;", "setOCardListItem", "(Lcom/obric/oui/lisitem/OCardListItem;)V", "hasDesktopIcon", "", "context", "Landroid/content/Context;", "pkgName", "", "onBind", "", "data", "Lcom/obric/security/battertpower/AppPowerProfileData;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PercentViewHolder extends RecyclerView.ViewHolder {
    private OCardListItem oCardListItem;

    public PercentViewHolder(View r2) {
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

    public final void onBind(AppPowerProfileData r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        OCardListItem r0 = this.oCardListItem;
        if (r0 == null) goto L5;
        r0.setTitle(r5.getAppName());
    L5:
        OCardListItem r1 = this.oCardListItem;
        if (r1 == null) goto L10;
        OTextView r2 = r1.getTitleView();
        if (r2 == null) goto L10;
        r2.setMaxLines(1);
    L10:
        OCardListItem r3 = this.oCardListItem;
        if (r3 == null) goto L14;
        OCardListItemExtKt.setEndText(r3, new StringBuilder().append(r5.getPercent()).append('%').toString());
    L14:
        if ((!StringsKt.isBlank(r5.getDurationDesc())) == false) goto L18;
        OCardListItem r4 = this.oCardListItem;
        if (r4 == null) goto L24;
        OCardListItemExtKt.setSubTitleText(r4, r5.getDurationDesc());
    L24:
        OCardListItem r6 = this.oCardListItem;
        if (r6 == null) goto L27;
        r6.setCardType(1);
    L27:
        OCardListItem r7 = this.oCardListItem;
        if (r7 == null) goto L32;
        OTextView r8 = r7.getSubTitleView();
        if (r8 == null) goto L32;
        r8.setMaxLines(2);
    L32:
        OCardListItem r9 = this.oCardListItem;
        if (r9 == null) goto L37;
        OTextView r10 = r9.getTitleView();
        if (r10 == null) goto L37;
        r10.setMaxLines(1);
    L37:
        OCardListItem r11 = this.oCardListItem;
        if (r11 == null) goto L40;
        r11.setAppIcon(r5.getAppIcon());
    L40:
        OCardListItem r12 = this.oCardListItem;
        if (r12 == null) goto L43;
        r12.showIcon(true);
    L43:
        OCardListItem r13 = this.oCardListItem;
        if (r13 == null) goto L46;
        r13.setOnContentClickListener(AnonymousClass1.INSTANCE);
    L46:
        OCardListItem r14 = this.oCardListItem;
        if (r14 == null) goto L50;
        r14.setCardType(0);
        return;
    L50:
        return;
    L18:
        OCardListItem r15 = this.oCardListItem;
        if (r15 == null) goto L21;
        r15.setSubTitle("");
    L21:
        OCardListItem r16 = this.oCardListItem;
        if (r16 == null) goto L24;
        r16.showSubTitle(false);
        goto L24
    }

    public final boolean hasDesktopIcon(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        PackageManager r1 = r2.getPackageManager();
        Intent r4 = new Intent("android.intent.action.MAIN");
        r4.addCategory("android.intent.category.LAUNCHER");
        r4.setPackage(r3);
        List<ResolveInfo> r5 = r1.queryIntentActivities(r4, 0);
        Intrinsics.checkNotNullExpressionValue(r5, "pm.queryIntentActivities(intent, 0)");
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.isEmpty() == true) goto L9;
        return true;
    L9:
        return false;
    }
}
