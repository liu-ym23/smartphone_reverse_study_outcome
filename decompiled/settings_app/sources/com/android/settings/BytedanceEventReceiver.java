package com.android.settings;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
public class BytedanceEventReceiver extends BroadcastReceiver {
    private static final String ACTION_BOSTON_UPDATE = "com.bytedanceos.boston.NEW_BOSTON_OTA_ROM";
    private static final String ACTION_BYTEDANCE_UPDATER_BADGE = "com.bytedanceos.launcher.new_message";
    private static final String ACTION_PACKAGE_LOCKED = "android.content.pm.action.sm_PACKAGE_LOCKED";
    private static final String ACTION_PREFERRED_ACTIVITY_CLEAR = "com.android.settings.action.ACTION_PREFERRED_ACTIVITY_CLEAR";
    private static final String APPLICATION_PACKAGE = "com.android.settings";
    private static final String EXTRA_BOSTON_UPDATE_KEY = "extra_ota_count";
    private static final String EXTRA_MESSAGE_COUNT = "extra_message_count";
    private static final String EXTRA_PACKAGENAME = "extra_packagename";
    public static final String KEY_SHOW_OTA_UPDATABLE_BADGE = "show_ota_updatable_badge";
    public static final String PREF_KEY_SHOW_BOSTON_OTA = "show_boston_ota";
    private static final String TAG = "BytedanceEventReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_BytedanceEventReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public BytedanceEventReceiver() {
    }

    public void com_android_settings_BytedanceEventReceiver__onReceive$___twin___(Context r5, Intent r6) {
        String r0 = r6.getAction();
        OLog.d(TAG, "action " + r0);
        boolean r2 = true;
        int r3 = 1;
        if (ACTION_BYTEDANCE_UPDATER_BADGE.equals(r0) == false) goto L16;
        if ("com.android.settings".equals(r6.getStringExtra(EXTRA_PACKAGENAME)) == false) goto L32;
        int r7 = r6.getIntExtra(EXTRA_MESSAGE_COUNT, 0);
        if (r7 == 0) goto L9;
        boolean r1 = true;
    L10:
        setShowBytedanceUpdateBadge(r5, r1);
        if (r7 > 0) goto L14;
        r3 = 0;
    L14:
        SettingsApplication.notifyLauncher(r5, r3);
        return;
    L9:
        r1 = false;
        goto L10
    L32:
        return;
    L16:
        if ("android.intent.action.LOCALE_CHANGED".equals(r0) == false) goto L19;
        reApplyOCRLanguage(r5);
        return;
    L19:
        if (ACTION_BOSTON_UPDATE.equals(r0) == false) goto L26;
        if (r6.getIntExtra(EXTRA_BOSTON_UPDATE_KEY, 0) > 0) goto L24;
        r2 = false;
    L24:
        setShowBostonOtaItem(r5, r2);
        return;
    L26:
        if (ACTION_PACKAGE_LOCKED.equals(r0) == false) goto L29;
        lockedAppFilter(r5);
        return;
    L29:
        if (ACTION_PREFERRED_ACTIVITY_CLEAR.equals(r0) == false) goto L37;
        handleResetDefaultAppSetter(r5, r6);
        return;
    }

    private void lockedAppFilter(Context r11) {
        String r10 = Utils.getSideBarEnabledApp(r11);
        OLog.i(TAG, "lockedAppFilter:" + r10);
        if (TextUtils.isEmpty(r10) == true) goto L5;
        String[] r0 = r10.split(";");
    L6:
        boolean r3 = false;
        if (r0 != null) goto L28;
    L25:
        if (r3 == false) goto L36;
        Utils.updateSideBarEnabledApp(r11, r10);
        return;
    L36:
        return;
    L28:
        if (r0.length <= 0) goto L25;
        int r4 = 0;
        boolean r5 = false;
    L30:
    L21:
        e = e;
        r3 = r5;
    L24:
        e.printStackTrace();
        goto L25
    L12:
        if (r4 >= r0.length) goto L20;
        String[] r6 = r0[r4].split(":");     // Catch: Exception -> L21
        if (r6.length != 2) goto L19;
        OLog.i(TAG, "lockedAppFilter:" + r6[0] + ",uid:" + Integer.parseInt(r6[1]));     // Catch: Exception -> L21
        if (Utils.isPackageAlreadyLockedByUserId(r11.getPackageManager(), r6[0], Integer.parseInt(r6[1])) == false) goto L19;
        OLog.i(TAG, "addApps:" + r0[r4]);     // Catch: Exception -> L21
        r10 = Utils.removePackageNameAndUserId(r10, r0[r4]);     // Catch: Exception -> L21
        r5 = true;
    L19:
        r4 = r4 + 1;
        goto L30
    L20:
        r3 = r5;
    L23:
        e = e;
        goto L24
    L5:
        r0 = null;
        goto L6
    }

    private void setShowBytedanceUpdateBadge(Context r2, boolean r3) {
        OLog.d(TAG, "setShowBytedanceUpdateBadge as " + r3);
        PreferenceMgr.getInstance(r2).putBoolean(KEY_SHOW_OTA_UPDATABLE_BADGE, r3);
        EventBus.getDefault().post(new EventType.OTABadgeUpdateEvent(r3));
    }

    private void setShowBostonOtaItem(Context r2, boolean r3) {
        OLog.d(TAG, "Received boston ota status changed, has updates: " + r3);
        PreferenceMgr.getInstance(r2).putBoolean(PREF_KEY_SHOW_BOSTON_OTA, r3);
    }

    private void reApplyOCRLanguage(Context r3) {
        boolean r2 = PreferenceMgr.getInstance(r3).getBoolean(PreferenceMgr.KEY_OCR_LANGUAGE_SET_BY_USER, false);
        if (r2 == false) goto L6;
        OLog.d(TAG, "reApplyOCRLanguage isUserSet " + r2);
        return;
    L6:
        int r4 = locale2OCRLanguageType(Locale.getDefault());
        if (r4 != 1) goto L9;
        int r5 = r4 | 2;
    L10:
        android.provider.Settings.Global.putInt(r3.getContentResolver(), "big_bang_ocr_language", r5);
        return;
    L9:
        r5 = r4 | 1;
        goto L10
    }

    private static int locale2OCRLanguageType(Locale r2) {
        if (Locale.US.equals(r2) == false) goto L6;
        int r3 = 1;
    L18:
        OLog.d("OCR", "languageType " + r3);
        return r3;
    L6:
        if (Locale.SIMPLIFIED_CHINESE.equals(r2) == false) goto L9;
        r3 = 2;
        goto L18
    L9:
        if (Locale.TRADITIONAL_CHINESE.equals(r2) == false) goto L12;
        r3 = 4;
        goto L18
    L12:
        if (Locale.KOREA.equals(r2) == false) goto L15;
        r3 = 16;
        goto L18
    L15:
        if (Locale.JAPAN.equals(r2) == false) goto L17;
        r3 = 8;
        goto L18
    L17:
        r3 = 0;
        goto L18
    }

    private void handleResetDefaultAppSetter(Context r3, Intent r4) {
        String r2 = r4.getStringExtra("package");
        ArrayList<String> r5 = r4.getStringArrayListExtra("preferred_mimetype_list");
        if (TextUtils.isEmpty(r2) == true) goto L9;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.isEmpty() == true) goto L11;
        Bundle r0 = new Bundle();
        r0.putStringArrayList("mime_list", r5);
        r0.putString("uninstalled_pkg", r2);
        r0.putString(SetupDefaultAppService.EXTRA_EVENT_TYPE, SetupDefaultAppService.EVENT_FOR_UNINSTALL_APP);
        SetupDefaultAppService.start(r3, r0);
        return;
    L11:
        return;
    }

    @Insert("onReceive")
    public static void com_android_settings_BytedanceEventReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(BytedanceEventReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", ACTION_BYTEDANCE_UPDATER_BADGE, "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        BytedanceEventReceiver r1 = r7;
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
        r7.com_android_settings_BytedanceEventReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_BytedanceEventReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_BytedanceEventReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_BytedanceEventReceiver__onReceive$___twin___(r8, r9);
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
