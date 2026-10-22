package com.obric.securitycenter.nodisturb.setting.slot;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.security.Utils;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.securitycenter.nodisturb.R;
import com.obric.slot.Slot;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockedCallSlot.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/securitycenter/nodisturb/setting/slot/BlockedCallSlot;", "Lcom/obric/slot/Slot;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cardItem", "Lcom/obric/oui/lisitem/OCardListItem;", "createView", "Landroid/view/View;", "onPositioned", "", "view", Utils.INTENT_KEY_INDEX, "", PerfConsts.PERF_DISK_TOTAL, "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlockedCallSlot extends Slot {
    private OCardListItem cardItem;

    /* JADX INFO: renamed from: $r8$lambda$XYsyLJ9-JytYbH41oZY_2B0q4so, reason: not valid java name */
    public static /* synthetic */ void m614$r8$lambda$XYsyLJ9JytYbH41oZY_2B0q4so(OCardListItem r0, View r1) {
        createView$lambda$2$lambda$1(r0, r1);
    }

    public BlockedCallSlot(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // com.obric.slot.Slot
    public View createView() {
        final OCardListItem r6 = new OCardListItem(getContext(), null, 0, 6, null);
        this.cardItem = r6;
        r6.setTitle(r6.getContext().getString(R.string.blocked_call_title));
        r6.showSubTitle(false);
        r6.setDefaultTailIcon(0);
        r6.showTailIcon(true);
        r6.setOnContentClickListener(new BlockedCallSlot$$ExternalSyntheticLambda0(r6));
        return r6;
    }

    private static final void createView$lambda$2$lambda$1(OCardListItem r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "$this_apply");
        Intent r5 = new Intent();     // Catch: Exception -> L5
        r5.setComponent(new ComponentName("com.android.contacts", "com.android.contacts.calllog.blocked.settings.BlockedCallSettingsActivity"));     // Catch: Exception -> L5
        r5.putExtra("enter_from", r3.getContext().getPackageName());     // Catch: Exception -> L5
        r3.getContext().startActivity(r5);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.obric.slot.Slot
    public void onPositioned(View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        OCardListItem r1 = this.cardItem;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cardItem");
        r1 = null;
    L5:
        OCardListItem.setCardPosition$default(r1, SlotExtKt.cardPositionOf(r3, r4), false, 2, null);
    }
}
