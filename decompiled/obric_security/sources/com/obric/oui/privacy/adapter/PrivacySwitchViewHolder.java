package com.obric.oui.privacy.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.privacy.PrivacyItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrivacySwitchViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/privacy/adapter/PrivacySwitchViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "cardListItem", "Lcom/obric/oui/lisitem/OCardListItem;", "(Lcom/obric/oui/lisitem/OCardListItem;)V", "bind", "", "item", "Lcom/obric/oui/privacy/PrivacyItem$SwitchItem;", "position", "", "totalSwitchCount", "switchStartIndex", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrivacySwitchViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = null;
    private final OCardListItem cardListItem;

    /* JADX INFO: compiled from: PrivacySwitchViewHolder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/privacy/adapter/PrivacySwitchViewHolder$Companion;", "", "()V", "create", "Lcom/obric/oui/privacy/adapter/PrivacySwitchViewHolder;", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final PrivacySwitchViewHolder create(Context r7) {
            Intrinsics.checkNotNullParameter(r7, "context");
            OCardListItem r6 = new OCardListItem(r7, null, 0, 6, null);
            r6.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            r6.setDefaultCustomEndView(1);
            r6.showCustomEnd(true);
            r6.showIcon(false);
            r6.showDivider(false);
            return new PrivacySwitchViewHolder(r6);
        }
    }

    public static /* synthetic */ void $r8$lambda$3EuxCFOXZEGlE22vA4bJZCNmIMU(PrivacyItem.SwitchItem r0, CompoundButton r1, boolean r2) {
        m460bind$lambda0(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
    }

    public PrivacySwitchViewHolder(OCardListItem r2) {
        Intrinsics.checkNotNullParameter(r2, "cardListItem");
        super(r2);
        this.cardListItem = r2;
    }

    public final void bind(final PrivacyItem.SwitchItem r5, int r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r5, "item");
        this.cardListItem.setTitle(r5.getTitle());
        int r2 = 1;
        if (r5.getSubtitle() == null) goto L5;
        this.cardListItem.setSubTitle(r5.getSubtitle());
        this.cardListItem.showSubTitle(true);
    L6:
        int r9 = r6 - r8;
        if (r7 != 1) goto L9;
        r2 = 0;
    L15:
        OCardListItem.setCardPosition$default(this.cardListItem, r2, false, 2, null);
        OSwitch r4 = this.cardListItem.getEndSwitch();
        if (r4 == null) goto L19;
        r4.setOnCheckedChangeListener(null);
    L19:
        if (r4 == null) goto L22;
        r4.setChecked(r5.isChecked());
    L22:
        if (r4 == null) goto L26;
        r4.setOnCheckedChangeListener(new PrivacySwitchViewHolder$$ExternalSyntheticLambda0(r5));
        return;
    L26:
        return;
    L9:
        if (r9 == 0) goto L15;
        if (r9 != (r7 - 1)) goto L14;
        r2 = 3;
        goto L15
    L14:
        r2 = 2;
        goto L15
    L5:
        this.cardListItem.showSubTitle(false);
        goto L6
    }

    /* JADX INFO: renamed from: bind$lambda-0, reason: not valid java name */
    private static final void m460bind$lambda0(PrivacyItem.SwitchItem r0, CompoundButton r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r0, "$item");
        Function1<Boolean, Unit> r3 = r0.getOnCheckedChange();
        if (r3 == null) goto L7;
        r3.invoke(Boolean.valueOf(r2));
        return;
    }
}
