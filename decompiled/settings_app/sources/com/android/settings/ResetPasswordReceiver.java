package com.android.settings;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.UserHandle;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.biometrics.FaceRecognitionHelper;
import com.android.vcard.VCardConfig;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.io.File;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;
import obric.api.ToastSmt;

/* JADX INFO: loaded from: classes2.dex */
public class ResetPasswordReceiver extends BroadcastReceiver {
    public static final String ACTION_CLEAN_PASSWORD_PUSH = "com.bytedance.push.MESSAGE_RECEIVE";
    public static final String ACTION_CLEAR_KEYGUARD_PASSWORD = "com.bytedanceos.CLEAR_KEYGUARD_PASSWORD";
    public static final String ACTION_RESET_KEYGUARD_PASSWORD = "com.bytedanceos.RESET_KEYGUARD_PASSWORD";
    private static final String TAG = "ResetPasswordReceiver";

    private static class PasswordCleaner {
        private static final String LOCK_SETTINGS_DB_PATH = "/data/system/locksettings.db";
        private static final int MSG_CLEAN_FAILED = 2;
        private static final int MSG_CLEAN_FINISHED = 3;
        private static final int MSG_START_CLEAR = 1;
        private static final long REBOOT_DELAY_MILLIS = 2000;
        private Context mContext;
        private final Handler mHandler;

        static /* synthetic */ void access$000(PasswordCleaner r0) {
            r0.start();
        }

        static /* synthetic */ void access$100(PasswordCleaner r0, int r1) {
            r0.toast(r1);
        }

        static /* synthetic */ void access$200(PasswordCleaner r0) {
            r0.reboot();
        }

        static /* synthetic */ Context access$300(PasswordCleaner r0) {
            return r0.mContext;
        }

        static /* synthetic */ void access$400(PasswordCleaner r0) {
            r0.onCleanFinished();
        }

        public PasswordCleaner(Context r3) {
            final Looper r1 = Looper.getMainLooper();
            this.mHandler = new AnonymousClass1(this, r1);
            this.mContext = r3;
        }

        private void start() {
            OLog.d(ResetPasswordReceiver.TAG, "start handle clear password");
            this.mHandler.sendEmptyMessage(1);
            if (MultiSDKAdapter.setLockSm(new LockPatternUtils(this.mContext)) == true) goto L6;
            this.mHandler.sendEmptyMessage(2);
            return;
        L6:
            deleteFingerprints();
            finallyStepDeleteFaceRecognitionData();
        }

        private boolean deleteLockSettingsDbFile() {
            File r3 = new File(LOCK_SETTINGS_DB_PATH);
            if (r3.exists() == false) goto L6;
            boolean r4 = r3.delete();
            OLog.d(ResetPasswordReceiver.TAG, "delete lock db file : " + r4);
            return r4;
        L6:
            OLog.e(ResetPasswordReceiver.TAG, "lock db file not exists");
            return true;
        }

        private void deleteFingerprints() {
            LockScreenModeActivity.removeAllFingerprintTemplates(this.mContext, new AnonymousClass2(this));
        }

        private void finallyStepDeleteFaceRecognitionData() {
            if (SettingsFeature.isFaceRecognitionEnable() == true) goto L6;
            onCleanFinished();
            return;
        L6:
            final FaceRecognitionHelper r0 = new FaceRecognitionHelper(this.mContext);
            r0.bind(new AnonymousClass3(this, r0));
        }

        private void onCleanFinished() {
            this.mHandler.sendEmptyMessageDelayed(3, REBOOT_DELAY_MILLIS);
        }

        private void reboot() {
            OLog.d(ResetPasswordReceiver.TAG, "settings reboot system after password cleared.");
            PowerManager r2 = (PowerManager) this.mContext.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
            if (r2 == null) goto L6;
            r2.reboot("settings reboot system after password cleared.");
            return;
        }

        private void toast(int r4) {
            ToastSmt r0 = ToastSmt.getInstance();
            Context r3 = this.mContext;
            r0.makeText(r3, r3.getString(r4), 1, 2010).show();
        }
    }

    public static final class Processor {
        public Processor() {
        }

        private void handleResetPassword(Context r6, String r7) {
            if (r7 != null) goto L5;
        L7:
            WifiManager r8 = (WifiManager) r6.getApplicationContext().getSystemService("wifi");
            List<WifiConfiguration> r0 = r8.getConfiguredNetworks();     // Catch: RuntimeException -> L10
        L13:
            if (r0 == null) goto L21;
            int r2 = 0;
        L16:
            if (r2 >= r0.size()) goto L21;
            WifiConfiguration r3 = r0.get(r2);
            if (WifiConfigurationSmtOnly.get_isTrustedAp(r3) == false) goto L20;
            WifiConfigurationSmtOnly.set_isTrustedAp(r3, false);
            r8.save(r3, null);
        L20:
            r2 = r2 + 1;
        L21:
            android.provider.Settings.Secure.putInt(r6.getContentResolver(), "lock_screen_lock_after_timeout", 0);
            return;
        L10:
            e = move-exception;
            e.printStackTrace();
            r0 = null;
            goto L13
        L5:
            if (r7.length() < 4) goto L7;
            LockPatternUtils r1 = new LockPatternUtils(r6);
            InvisibleApi.clearLock(r1, null);
            LockPatternUtilsOnly.saveLockPassword(r1, r7, null, 262144, UserHandle.myUserId());
            goto L7
        }

        public void process(Context r4, Intent r5) {
            String r0 = r5.getAction();
            if (r0 != null) goto L5;
            return;
        L5:
            r0.hashCode();
            byte r2 = -1;
            switch(r0.hashCode()) {
                case -1106071545: goto L17;
                case 344206328: goto L13;
                case 2131411318: goto L9;
                default: goto L20;
            };
        L20:
            switch(r2) {
                case 0: goto L24;
                case 1: goto L23;
                case 2: goto L22;
                default: goto L28;
            };
        L22:
            PasswordCleaner.access$000(new PasswordCleaner(r4));
            return;
        L23:
            handleResetPassword(r4, r5.getStringExtra("pwd"));
            return;
        L24:
            handleCleanPwdPushMsg(r4, r5.getType(), r5.getStringExtra("data"));
            return;
        L28:
            return;
        L9:
            if (r0.equals(ResetPasswordReceiver.ACTION_CLEAR_KEYGUARD_PASSWORD) == false) goto L20;
            r2 = 2;
            goto L20
        L13:
            if (r0.equals(ResetPasswordReceiver.ACTION_RESET_KEYGUARD_PASSWORD) == false) goto L20;
            r2 = 1;
            goto L20
        L17:
            if (r0.equals(ResetPasswordReceiver.ACTION_CLEAN_PASSWORD_PUSH) == false) goto L20;
            r2 = 0;
            goto L20
        }

        private void handleCleanPwdPushMsg(Context r2, String r3, String r4) {
            OLog.d(ResetPasswordReceiver.TAG, "handle clean pwd push opcode : " + r3 + " , data : " + r4);
            Notification.Builder r1 = new Notification.Builder(r2).setAutoCancel(true).setContentIntent(PendingIntent.getBroadcast(r2, 0, new Intent(ResetPasswordReceiver.ACTION_CLEAR_KEYGUARD_PASSWORD).setPackage("com.android.settings"), VCardConfig.FLAG_CONVERT_PHONETIC_NAME_STRINGS)).setSmallIcon(R.drawable.ic_launcher_settings).setContentTitle(r2.getString(R.string.clean_pwd_notification_title)).setContentText(r2.getString(R.string.clean_pwd_notification_context));
            MultiSDKAdapter.setNotificationChannelId(r1, Constants.NOTIFICATION_CHANEL_ID);
            NotificationManager r5 = (NotificationManager) r2.getApplicationContext().getSystemService("notification");
            MultiSDKAdapter.createNotificationChannel(r5, Constants.NOTIFICATION_CHANEL_ID, Constants.NOTIFICATION_CHANEL_NAME);
            r5.notify(0, r1.build());
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_ResetPasswordReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public ResetPasswordReceiver() {
    }

    public void com_android_settings_ResetPasswordReceiver__onReceive$___twin___(Context r2, Intent r3) {
        OLog.d(TAG, "receive action : " + r3.getAction());
        r3.setClass(r2, HandleEventService.class);
        r3.putExtra("type", -1000);
        r2.startService(r3);
    }

    @Insert("onReceive")
    public static void com_android_settings_ResetPasswordReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(ResetPasswordReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        ResetPasswordReceiver r1 = r7;
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
        r7.com_android_settings_ResetPasswordReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_ResetPasswordReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_ResetPasswordReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_ResetPasswordReceiver__onReceive$___twin___(r8, r9);
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
