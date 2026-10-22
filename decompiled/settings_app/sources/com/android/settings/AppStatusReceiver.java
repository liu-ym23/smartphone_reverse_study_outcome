package com.android.settings;

import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.CustomTheme;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import bytedanceos.api.ActivityManagerSmt;
import bytedanceos.api.ConfigurationSmt;
import com.android.settings.applock.event.AppStateChangeEvent;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
public class AppStatusReceiver extends BroadcastReceiver {
    private static final String TAG = "AppStatusReceiver";

    public static final class Processor {
        private Context mContext;

        public Processor(Context r1) {
            this.mContext = r1;
        }

        public void process(Intent r5) {
            if (r5.getData() != null) goto L5;
            return;
        L5:
            String r0 = r5.getAction();
            String r1 = r5.getData().getSchemeSpecificPart();
            boolean r6 = r5.getBooleanExtra("android.intent.extra.REPLACING", false);
            OLog.d(AppStatusReceiver.TAG, "action = " + r0 + " , packageName = " + r1 + " , isReplacing " + r6);
            if (r1 != null) goto L8;
            return;
        L8:
            if (r6 == false) goto L13;
            if ("android.intent.action.PACKAGE_REPLACED".equals(r0) == false) goto L20;
            onAppUpdated(r1);
            return;
        L20:
            return;
        L13:
            if ("android.intent.action.PACKAGE_ADDED".equals(r0) == false) goto L16;
            onAppInstalled(r1);
        L18:
            EventBus.getDefault().post(new AppStateChangeEvent());
            return;
        L16:
            if ("android.intent.action.PACKAGE_REMOVED".equals(r0) == false) goto L18;
            onAppRemoved(r1);
            goto L18
        }

        private void onAppInstalled(String r3) {
            OLog.d(AppStatusReceiver.TAG, "onAppInstalled " + r3);
            handleInstallWpsApp(r3);
        }

        private void onAppUpdated(String r2) {
            OLog.d(AppStatusReceiver.TAG, "onAppUpdated " + r2);
        }

        private void onAppRemoved(String r3) {
            OLog.d(AppStatusReceiver.TAG, "onAppRemoved " + r3);
            handleQuickFingerprintSettings(r3);
            resetSideKeyOptionsToScreenShot(r3);
            handleRemoveTheme(r3);
            handleCmelRemove(r3);
        }

        private void handleCmelRemove(String r2) {
            if (Constants.PKG_CMEL_ESPORT_COMMUNITY.equals(r2) == true) goto L6;
            return;
        L6:
            if ("feature_cmel".equals(android.provider.Settings.Global.getString(this.mContext.getContentResolver(), "smart_key_click_function")) == false) goto L9;
            FunctionSmartKeyOptionsFragment.disableSmartKey(this.mContext);
            return;
        }

        private void handleRemoveTheme(String r4) {
            ActivityManager r3 = (ActivityManager) this.mContext.getSystemService("activity");
            Configuration r0 = ActivityManagerSmt.getInstance().getConfiguration(r3);     // Catch: Exception -> L14
            String r1 = ((CustomTheme) NullSafe.nonNull(ConfigurationSmt.getInstance().get_customTheme(r0))).getThemePackageName();
            if (r1 != null) goto L7;
            return;
        L7:
            if (r1.equals(r4) == false) goto L22;
            CustomTheme r5 = new CustomTheme("BytedanceOSDefault", "com.bytedanceos.theme.default");
            ConfigurationSmt.getInstance().set_customTheme(r0, r5);
            ActivityManagerSmt.getInstance().updateConfiguration(r3, r0);     // Catch: Exception -> L11
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L22:
            return;
        L14:
            e = move-exception;
            e.printStackTrace();
        }

        private void handleInstallWpsApp(String r3) {
            if (Constants.PKG_WPS.equals(r3) == false) goto L6;
            Bundle r4 = new Bundle();
            r4.putString(SetupDefaultAppService.EXTRA_EVENT_TYPE, SetupDefaultAppService.EVENT_FOR_INSTALL_WPS);
            SetupDefaultAppService.start(this.mContext, r4);
            return;
        }

        private void resetSideKeyOptionsToScreenShot(String r5) {
            String r0 = android.provider.Settings.Global.getString(this.mContext.getContentResolver(), "squeeze_side_buttons");
            if (r0 == null) goto L7;
            String[] r1 = r0.split("\\/");
            if (r1.length <= 1) goto L7;
            String r2 = r1[0];
        L9:
            if (r5.equals(r2) == false) goto L12;
            android.provider.Settings.Global.putString(this.mContext.getContentResolver(), "squeeze_side_buttons", "screenshot");
            return;
        L12:
            return;
        L7:
            r2 = null;
            goto L9
        }

        private void handleQuickFingerprintSettings(String r5) {
            FingerprintManager r0 = (FingerprintManager) this.mContext.getSystemService("fingerprint");
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isHardwareDetected() == false) goto L26;
            List r1 = r0.getEnrolledFingerprints();
            if (r1 == null) goto L25;
            ContentResolver r4 = this.mContext.getContentResolver();
            Iterator r2 = r1.iterator();
        L11:
            if (r2.hasNext() == false) goto L27;
            String r3 = "quick_app_via_fingerprint_id_" + InvisibleApi.getFingerId((Fingerprint) r2.next());
            String r6 = android.provider.Settings.Global.getString(r4, r3);
            if (r6 == null) goto L11;
            if (r6.contains(r5) == false) goto L11;
            OLog.d(AppStatusReceiver.TAG, "remove key " + r3);
            android.provider.Settings.Global.putString(r4, r3, null);
            goto L11
        L27:
            return;
        L25:
            return;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_AppStatusReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public AppStatusReceiver() {
    }

    public void com_android_settings_AppStatusReceiver__onReceive$___twin___(Context r3, Intent r4) {
        OLog.d(TAG, "onReceive app status action = " + r4.getAction());     // Catch: Exception -> L5
        r4.setClass(r3, HandleEventService.class);     // Catch: Exception -> L5
        r4.putExtra("type", 8);     // Catch: Exception -> L5
        r3.startService(r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Insert("onReceive")
    public static void com_android_settings_AppStatusReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(AppStatusReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        AppStatusReceiver r1 = r7;
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
        r7.com_android_settings_AppStatusReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_AppStatusReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_AppStatusReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_AppStatusReceiver__onReceive$___twin___(r8, r9);
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
