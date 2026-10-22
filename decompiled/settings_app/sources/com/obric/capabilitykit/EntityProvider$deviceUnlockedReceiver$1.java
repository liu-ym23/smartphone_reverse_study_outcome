package com.obric.capabilitykit;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.obric.capabilitykit.logger.Logger;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/capabilitykit/EntityProvider$deviceUnlockedReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityProvider$deviceUnlockedReceiver$1 extends BroadcastReceiver {
    public static /* synthetic */ void $r8$lambda$75vsgR4EUL26kiuKKjvBeu9OGxs() {
        a();
    }

    public EntityProvider$deviceUnlockedReceiver$1() {
    }

    private static final void a() {
        EntityProvider.access$checkIfFirstRunOrDataClean(EntityProvider.INSTANCE);
    }

    public void com_obric_capabilitykit_EntityProvider$deviceUnlockedReceiver$1__onReceive$___twin___(Context r1, Intent r2) {
        Logger.INSTANCE.d(EntityProvider.TAG, "user unlocked");
        IndexTaskManager.INSTANCE.postTask("checkIfFirstRunOrDataClean", new EntityProvider$deviceUnlockedReceiver$1$$ExternalSyntheticLambda0());
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_obric_capabilitykit_EntityProvider$deviceUnlockedReceiver$1_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    @Insert("onReceive")
    public static void com_obric_capabilitykit_EntityProvider$deviceUnlockedReceiver$1_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(EntityProvider$deviceUnlockedReceiver$1 r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        EntityProvider$deviceUnlockedReceiver$1 r1 = r7;
        String r2 = r1.getClass().getName();
        String r3 = r1.getClass().getSimpleName();
        boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
        String r5 = null;
        if (r9 == null) goto L5;
        String r6 = r9.getAction();
    L7:
        if (ArraysKt.contains(r0, r6) == false) goto L13;
        StringBuilder r10 = new StringBuilder("onReceive allowList ");
        if (r9 == null) goto L11;
        r5 = r9.getAction();
    L11:
        OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
        r7.com_obric_capabilitykit_EntityProvider$deviceUnlockedReceiver$1__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_obric_capabilitykit_EntityProvider$deviceUnlockedReceiver$1__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_obric_capabilitykit_EntityProvider$deviceUnlockedReceiver$1__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_obric_capabilitykit_EntityProvider$deviceUnlockedReceiver$1__onReceive$___twin___(r8, r9);
        return;
    L19:
        if (r13.length() == 0) goto L22;
        r14 = false;
        goto L23
    L5:
        r6 = null;
        goto L7
    }
}
