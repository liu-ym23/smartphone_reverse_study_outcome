package com.android.settings;

import android.app.AlarmManager;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class ProvisionImportDataReceiver extends BroadcastReceiver {
    private static final String ACTION_CHANGE_PHONE_NEW_BD = "com.ume.weshare.CHANGEPHONE.NEW.BD";
    private static final String ACTION_PROVISION_IMPORT_DATA = "intent.provision.import_data";
    private static final String ACTION_SHOW_IMPORT_DATA_NOTIFICATION = "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION";
    private static final long DELAY_SHOW_NOTIFICATION_MILLIS = 180000;
    private static final int NOTIFICATION_ID_IMPORT_OLD_DEVICE_DATA = 10086;
    private static final int REQUEST_CODE_SHOW_NOTIFICATION = 10087;
    private static final String TAG = "ProvisionImportDataReceiver";
    private static final String ZTE_BACKUP_APP_PACKAGE_NAME = "cuuca.sendfiles.Activity";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_ProvisionImportDataReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public ProvisionImportDataReceiver() {
    }

    public void com_android_settings_ProvisionImportDataReceiver__onReceive$___twin___(Context r3, Intent r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        String r5 = r4.getAction();
        if (ACTION_PROVISION_IMPORT_DATA.equals(r5) == false) goto L8;
        OLog.d(TAG, "onReceive: ACTION_PROVISION_IMPORT_DATA, schedule in 3 min");
        scheduleShowImportDataNotification(r3);
        return;
    L8:
        if (ACTION_SHOW_IMPORT_DATA_NOTIFICATION.equals(r5) == false) goto L12;
        OLog.d(TAG, "onReceive: ACTION_SHOW_IMPORT_DATA_NOTIFICATION, show now");
        showImportDataNotification(r3);
        return;
    }

    private void scheduleShowImportDataNotification(Context r8) {
        Context r9 = r8.getApplicationContext();
        AlarmManager r0 = (AlarmManager) r9.getSystemService("alarm");
        if (r0 != null) goto L6;
        OLog.w(TAG, "scheduleShowImportDataNotification: AlarmManager is null");
        return;
    L6:
        Intent r2 = new Intent(r9, ProvisionImportDataReceiver.class);
        r2.setAction(ACTION_SHOW_IMPORT_DATA_NOTIFICATION);
        r2.setPackage(r9.getPackageName());
        PendingIntent r10 = PendingIntent.getBroadcast(r9, REQUEST_CODE_SHOW_NOTIFICATION, r2, 201326592);
        long r3 = SystemClock.elapsedRealtime() + DELAY_SHOW_NOTIFICATION_MILLIS;
    L13:
        e = move-exception;
        OLog.w(TAG, "scheduleShowImportDataNotification: SecurityException, fallback. " + e.getMessage());
        r0.setAndAllowWhileIdle(2, r3, r10);
        return;
    L8:
        if (r0.canScheduleExactAlarms() == false) goto L10;
        r0.setExactAndAllowWhileIdle(2, r3, r10);     // Catch: SecurityException -> L13
    L11:
        OLog.d(TAG, "scheduleShowImportDataNotification: scheduled, triggerAtMillis=" + r3);     // Catch: SecurityException -> L13
        return;
    L10:
        r0.setAndAllowWhileIdle(2, r3, r10);     // Catch: SecurityException -> L13
        goto L11
    }

    private void showImportDataNotification(Context r4) {
        PackageManager r3 = r4.getPackageManager();
        if (r3 != null) goto L6;
        OLog.w(TAG, "showImportDataNotification: PackageManager is null");
        return;
    L6:
        Intent r5 = r3.getLaunchIntentForPackage(ZTE_BACKUP_APP_PACKAGE_NAME);
        if (r5 != null) goto L10;
        OLog.w(TAG, "showImportDataNotification: getLaunchIntentForPackage is null");
        return;
    L10:
        PendingIntent r6 = PendingIntent.getActivity(r4, 0, r5, 201326592);
        Notification.Builder r7 = new Notification.Builder(r4).setAutoCancel(true).setSmallIcon(R.drawable.ic_launcher_settings).setContentTitle(r4.getString(R.string.provision_import_data_title)).setContentText(r4.getString(R.string.provision_import_data_desc)).setContentIntent(r6);
        MultiSDKAdapter.setNotificationChannelId(r7, Constants.NOTIFICATION_CHANEL_ID);
        NotificationManager r8 = (NotificationManager) r4.getApplicationContext().getSystemService("notification");
        if (r8 != null) goto L14;
        OLog.w(TAG, "showImportDataNotification: NotificationManager is null");
        return;
    L14:
        MultiSDKAdapter.createNotificationChannel(r8, Constants.NOTIFICATION_CHANEL_ID, Constants.NOTIFICATION_CHANEL_NAME);
        r8.notify(NOTIFICATION_ID_IMPORT_OLD_DEVICE_DATA, r7.build());
    }

    @Insert("onReceive")
    public static void com_android_settings_ProvisionImportDataReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(ProvisionImportDataReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", ACTION_PROVISION_IMPORT_DATA, ACTION_SHOW_IMPORT_DATA_NOTIFICATION};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        ProvisionImportDataReceiver r1 = r7;
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
        r7.com_android_settings_ProvisionImportDataReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_ProvisionImportDataReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_ProvisionImportDataReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_ProvisionImportDataReceiver__onReceive$___twin___(r8, r9);
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
