package com.android.settings;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.os.UserHandle;
import android.os.UserManager;
import com.android.settings.applications.PickApplicationActivity;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsInitialize extends BroadcastReceiver {
    private static final String PRIMARY_PROFILE_SETTING = "com.android.settings.PRIMARY_PROFILE_CONTROLLED";
    private static final String TAG = "Settings";

    private void webviewSettingSetup(Context r1, PackageManager r2, UserInfo r3) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_SettingsInitialize_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public SettingsInitialize() {
    }

    public void com_android_settings_SettingsInitialize__onReceive$___twin___(Context r3, Intent r4) {
        UserInfo r0 = ((UserManager) r3.getSystemService(PickApplicationActivity.EXTRA_USER)).getUserInfo(UserHandle.myUserId());
        PackageManager r1 = r3.getPackageManager();
        managedProfileSetup(r3, r1, r4, r0);
        webviewSettingSetup(r3, r1, r0);
    }

    private void managedProfileSetup(Context r5, PackageManager r6, Intent r7, UserInfo r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isManagedProfile() == false) goto L29;
        OLog.e(TAG, "Received broadcast: " + r7.getAction() + ". Setting up intent forwarding for managed profile.");
        r6.clearCrossProfileIntentFilters(r8.id);
        Intent r4 = new Intent();
        r4.addCategory("android.intent.category.DEFAULT");
        r4.setPackage(r5.getPackageName());
        List<ResolveInfo> r9 = r6.queryIntentActivities(r4, 705);
        int r10 = 0;
        if (r9 == null) goto L9;
        int r11 = r9.size();
    L10:
        if (r10 >= r11) goto L30;
        ResolveInfo r0 = r9.get(r10);
        if (r0.filter == null) goto L20;
        if (r0.activityInfo == null) goto L20;
        if (r0.activityInfo.metaData == null) goto L20;
        if (r0.activityInfo.metaData.getBoolean(PRIMARY_PROFILE_SETTING) == false) goto L20;
        r6.addCrossProfileIntentFilter(r0.filter, r8.id, r8.profileGroupId, 2);
    L20:
        r10 = r10 + 1;
        goto L10
    L30:
        return;
    L9:
        r11 = 0;
        goto L10
    }

    @Insert("onReceive")
    public static void com_android_settings_SettingsInitialize_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(SettingsInitialize r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        SettingsInitialize r1 = r7;
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
        r7.com_android_settings_SettingsInitialize__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_SettingsInitialize__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_SettingsInitialize__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_SettingsInitialize__onReceive$___twin___(r8, r9);
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
