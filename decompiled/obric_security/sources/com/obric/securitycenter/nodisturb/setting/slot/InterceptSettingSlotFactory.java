package com.obric.securitycenter.nodisturb.setting.slot;

import android.content.Context;
import com.obric.slot.SlotGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InterceptSettingSlotFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/obric/securitycenter/nodisturb/setting/slot/InterceptSettingSlotFactory;", "", "()V", "createInterceptRuleGroup", "Lcom/obric/slot/SlotGroup;", "context", "Landroid/content/Context;", "createNumberManagementGroup", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InterceptSettingSlotFactory {
    public static final InterceptSettingSlotFactory INSTANCE = null;

    static {
        INSTANCE = new InterceptSettingSlotFactory();
    }

    private InterceptSettingSlotFactory() {
    }

    public final SlotGroup createInterceptRuleGroup(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        SlotGroup r3 = new SlotGroup();
        SlotGroup.add$default(r3, new BlockedCallSlot(r4), null, 2, null);
        SlotGroup.add$default(r3, new BlockedSmsSlot(r4), null, 2, null);
        return r3;
    }

    public final SlotGroup createNumberManagementGroup(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        SlotGroup r3 = new SlotGroup();
        SlotGroup.add$default(r3, new BlackListSlot(r4), null, 2, null);
        SlotGroup.add$default(r3, new WhiteListSlot(r4), null, 2, null);
        SlotGroup.add$default(r3, new SmsKeywordSlot(r4), null, 2, null);
        return r3;
    }
}
