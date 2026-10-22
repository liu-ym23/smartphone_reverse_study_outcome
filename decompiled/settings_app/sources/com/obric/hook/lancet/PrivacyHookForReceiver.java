package com.obric.hook.lancet;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.This;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: PrivacyHookForReceiver.kt */
/* JADX INFO: loaded from: classes4.dex */
@TargetClass(scope = Scope.ALL, value = "android.content.BroadcastReceiver")
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t"}, d2 = {"Lcom/obric/hook/lancet/PrivacyHookForReceiver;", "", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PrivacyHookForReceiver {
    public static final PrivacyHookForReceiver INSTANCE = null;

    static {
        INSTANCE = new PrivacyHookForReceiver();
    }

    public PrivacyHookForReceiver() {
    }

    @Insert("onReceive")
    public final void onReceive(Context r5, Intent r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        String[] r4 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Object r7 = This.get();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        BroadcastReceiver r8 = (BroadcastReceiver) r7;
        String r0 = r8.getClass().getName();
        String r1 = r8.getClass().getSimpleName();
        boolean r9 = Intrinsics.areEqual(SettingsInitialize.class, r8.getClass());
        String r2 = null;
        if (r6 == null) goto L5;
        String r3 = r6.getAction();
    L7:
        if (ArraysKt.contains(r4, r3) == false) goto L13;
        StringBuilder r10 = new StringBuilder("onReceive allowList ");
        if (r6 == null) goto L11;
        r2 = r6.getAction();
    L11:
        OLog.i("PrivacyHookForReceiver", r10.append(r2).toString());
        Origin.callVoid();
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r1 + ", " + r0);
        Origin.callVoid();
        return;
    L16:
        String r13 = r1;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r1 + ", " + r0);
        Origin.callVoid();
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r9 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r1 + ", " + r0);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        Origin.callVoid();
        return;
    L19:
        if (r13.length() == 0) goto L22;
        r14 = false;
        goto L23
    L5:
        r3 = null;
        goto L7
    }
}
