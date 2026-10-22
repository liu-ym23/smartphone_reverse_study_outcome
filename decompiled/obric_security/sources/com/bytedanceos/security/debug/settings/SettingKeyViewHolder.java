package com.bytedanceos.security.debug.settings;

import android.view.View;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.security.R;
import com.obric.securitycenter.api.settings.Owner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SettingsKeyAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedanceos/security/debug/settings/SettingKeyViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "item", "Lcom/bytedanceos/security/debug/settings/SettingsKeyEntry;", "onItemClickListener", "Lkotlin/Function1;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SettingKeyViewHolder extends RecyclerView.ViewHolder {
    public SettingKeyViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    public final void bind(final SettingsKeyEntry r7, final Function1<? super SettingsKeyEntry, Unit> r8) {
        Intrinsics.checkNotNullParameter(r7, "item");
        Object r1 = null;
        if ((r7 instanceof SettingsKeyEntry.ScopeEntry) == false) goto L12;
        Object r6 = this.itemView;
        if ((r6 instanceof OSectionTitleBar) == false) goto L8;
        r1 = r6;
    L8:
        OSectionTitleBar r2 = (OSectionTitleBar) r1;
        if (r2 == null) goto L37;
        r2.setTitleText(((SettingsKeyEntry.ScopeEntry) r7).getSettingsKeyValue());
        r2.setTitleTextSize(20.0f);
        return;
    L37:
        return;
    L12:
        if ((r7 instanceof SettingsKeyEntry.ChildEntry) == false) goto L39;
        View r0 = this.itemView;
        if ((r0 instanceof OCardListItem) == true) goto L16;
        r0 = null;
    L16:
        OCardListItem r3 = (OCardListItem) r0;
        if (r3 != null) goto L19;
        r3 = (OCardListItem) this.itemView.findViewById(R.id.card_item);
    L19:
        if (r3 != null) goto L21;
        return;
    L21:
        OTextView r9 = (OTextView) this.itemView.findViewById(R.id.tv_owner);
        SettingsKeyEntry.ChildEntry r4 = (SettingsKeyEntry.ChildEntry) r7;
        Owner r5 = (Owner) r4.getSettingsClass().getAnnotation(Owner.class);
        if (r5 == null) goto L24;
        r1 = r5.value();
    L24:
        if (r1 != null) goto L26;
        r1 = "";
    L26:
        String r10 = StringsKt.trim((CharSequence) r1).toString();
        if (r9 != null) goto L29;
    L35:
        r3.setTitle(r4.getSettingsKeyValue());
        r3.setSubTitle(r4.getTitleValue());
        r3.setTailIcon(R.drawable.btn_setting_selector_other);
        r3.setOnClickListener(new SettingKeyViewHolder$bind$$inlined$let$lambda$1(r7, r8));
        r3.getTailIconView().setOnClickListener(new SettingKeyViewHolder$bind$$inlined$let$lambda$2(r7, r8));
        r3.showTitle(true);
        r3.showSubTitle(true);
        r3.showTailIcon(true);
        return;
    L29:
        if (r10.length() != 0) goto L31;
        boolean r11 = true;
    L32:
        if (r11 == false) goto L34;
        r9.setVisibility(8);
        goto L35
    L34:
        r9.setVisibility(0);
        r9.setText("@" + r10);
        goto L35
    L31:
        r11 = false;
        goto L32
    }
}
