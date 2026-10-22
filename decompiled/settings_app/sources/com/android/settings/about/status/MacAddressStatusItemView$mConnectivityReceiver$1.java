package com.android.settings.about.status;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.utils.ThreadUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: compiled from: MacAddressStatusItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/android/settings/about/status/MacAddressStatusItemView$mConnectivityReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MacAddressStatusItemView$mConnectivityReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ MacAddressStatusItemView this$0;

    public static /* synthetic */ void $r8$lambda$tY3MSyOYws6_LzseHDuXZy0LIIo(MacAddressStatusItemView r0) {
        onReceive$lambda$0(r0);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_about_status_MacAddressStatusItemView$mConnectivityReceiver$1_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    MacAddressStatusItemView$mConnectivityReceiver$1(MacAddressStatusItemView r1) {
        this.this$0 = r1;
    }

    public void com_android_settings_about_status_MacAddressStatusItemView$mConnectivityReceiver$1__onReceive$___twin___(Context r1, Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        final MacAddressStatusItemView r0 = this.this$0;
        ThreadUtils.postOnMainThread(new MacAddressStatusItemView$mConnectivityReceiver$1$$ExternalSyntheticLambda0(r0));
    }

    private static final void onReceive$lambda$0(MacAddressStatusItemView r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        MacAddressStatusItemView.access$updateMacAddress(r1);
    }

    @Insert("onReceive")
    public static void com_android_settings_about_status_MacAddressStatusItemView$mConnectivityReceiver$1_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(MacAddressStatusItemView$mConnectivityReceiver$1 r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        MacAddressStatusItemView$mConnectivityReceiver$1 r1 = r7;
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
        r7.com_android_settings_about_status_MacAddressStatusItemView$mConnectivityReceiver$1__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_about_status_MacAddressStatusItemView$mConnectivityReceiver$1__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_about_status_MacAddressStatusItemView$mConnectivityReceiver$1__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_about_status_MacAddressStatusItemView$mConnectivityReceiver$1__onReceive$___twin___(r8, r9);
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
