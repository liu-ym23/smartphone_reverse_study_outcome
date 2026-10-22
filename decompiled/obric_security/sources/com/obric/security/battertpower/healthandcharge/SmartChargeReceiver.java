package com.obric.security.battertpower.healthandcharge;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedanceos.powerusage.PowerUsageActivity;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.olog.OLog;
import com.obric.security.R;
import com.obric.security.battertpower.powerHigh.clearApp.ClearPowerHighAppsActivity;
import com.obric.security.devenvcheck.WlanRiskBroadcaster;
import com.obric.securitycenter.api.TrackUtils;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class SmartChargeReceiver extends BroadcastReceiver {
    private static final String ACTION = "com.obric.security.battertpower.healthandcharge.SmartChargeReceiver";
    public static final String ACTION_EXIT = "com.obric.security.action.SMART_CHARGE_EXIT";
    public static final String ACTION_SMART_CHARGE_STATE_CHANGE = "com.obric.security.action.SMART_CHARGE_STATE_CHANGE";
    private static final String ACTION_SMART_NAVIGATION_END_EXPIRE_CANCEL = "com.obric.security.action.SMART_NAVIGATION_END_EXPIRE_CANCEL";
    public static final String ACTION_SMART_NAVIGATION_MANUAL_EXIT = "com.obric.security.action.SMART_NAVIGATION_MANUAL_EXIT";
    private static final String ACTION_SMART_NAVIGATION_MANUAL_EXIT_CLICK = "com.obric.security.action.SMART_NAVIGATION_MANUAL_EXIT_CLICK";
    public static final String ACTION_SMART_NAVIGATION_STATE_CHANGE = "com.obric.security.action.SMART_NAVIGATION_STATE_CHANGE";
    public static final String CHANNEL_ID = "com.obric.security.action.SMART_CHARGE_STATE_CHANGE2";
    private static final String CHANNEL_NAVIGATION_NORMAL_ID = "com.obric.security.action.SMART_NAVIGATION_STATE_CHANGE.normal";
    private static final String CHANNEL_NAVIGATION_SILENT_ID = "com.obric.security.action.SMART_NAVIGATION_STATE_CHANGE.silent";
    private static final String EXTRA_NAVIGATION_AUTO_CANCEL_DELAY_MS = "extra_navigation_auto_cancel_delay_ms";
    private static final String EXTRA_NAVIGATION_EXIT_REASON = "extra_navigation_exit_reason";
    private static final long NAVIGATION_END_AUTO_CANCEL_DELAY_MS = 86400000;
    private static final long NAVIGATION_END_AUTO_CANCEL_DELAY_UNPLUGGED_MS = 2000;
    private static final int NAVIGATION_EXIT_REASON_UNPLUGGED = 1;
    public static final int NOTIFICATION_ID = 100004;
    private static final int NOTIFICATION_NAVIGATION_ID = 100005;
    private static final int REQUEST_CODE_NAVIGATION_ACTION_CONTINUE = 2;
    private static final int REQUEST_CODE_NAVIGATION_CONTENT = 0;
    private static final int REQUEST_CODE_NAVIGATION_END_EXPIRE_CANCEL = 100006;
    public static final String TAG = "SmartChargeReceiver";

    public SmartChargeReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String r0 = intent.getAction();
        OLog.d(TAG, "onReceive:" + r0);
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return;
    L5:
        r0.hashCode();
        switch(r0.hashCode()) {
            case -1679272563: goto L25;
            case -560152153: goto L21;
            case 834007447: goto L17;
            case 898432103: goto L13;
            case 1616117447: goto L9;
            default: goto L7;
        };
    L7:
        byte r1 = -1;
    L29:
        switch(r1) {
            case 0: goto L35;
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            default: goto L46;
        };
    L31:
        handleSmartChargeStateChange(context, intent);
        return;
    L32:
        handleSmartNavigationStateChange(context, intent);
        return;
    L33:
        context.sendBroadcast(new Intent(ACTION_SMART_NAVIGATION_MANUAL_EXIT), WlanRiskBroadcaster.PERMISSION_RECEIVE);
        cancelNavigationNotification(context);
        return;
    L34:
        Intent r5 = new Intent("com.obric.security.action.EXIT_SINGLE_SMART_CHANGE");
        r5.putExtra("isExit", true);
        context.sendBroadcast(r5, WlanRiskBroadcaster.PERMISSION_RECEIVE);
        cancelNotification(context);
        TrackUtils.INSTANCE.trackEvent("smart_charge_remove_limit_click", Collections.emptyMap());
        return;
    L35:
        int r6 = intent.getIntExtra(EXTRA_NAVIGATION_EXIT_REASON, -1);
        long r2 = intent.getLongExtra(EXTRA_NAVIGATION_AUTO_CANCEL_DELAY_MS, -1);
        HashMap r7 = new HashMap(2);
        r7.put("exitReason", Integer.valueOf(r6));
        r7.put("delayMs", Long.valueOf(r2));
        TrackUtils.INSTANCE.trackEvent("smart_navigation_end_notification_auto_cancel", r7);
        cancelNavigationNotification(context);
        return;
    L46:
        return;
    L9:
        if (r0.equals(ACTION_SMART_CHARGE_STATE_CHANGE) == false) goto L37;
        r1 = 4;
        goto L29
    L37:
        r1 = -1;
        goto L29
    L13:
        if (r0.equals(ACTION_SMART_NAVIGATION_STATE_CHANGE) == false) goto L38;
        r1 = 3;
        goto L29
    L38:
        r1 = -1;
        goto L29
    L17:
        if (r0.equals(ACTION_SMART_NAVIGATION_MANUAL_EXIT_CLICK) == false) goto L39;
        r1 = 2;
        goto L29
    L39:
        r1 = -1;
        goto L29
    L21:
        if (r0.equals(ACTION_EXIT) == false) goto L40;
        r1 = 1;
        goto L29
    L40:
        r1 = -1;
        goto L29
    L25:
        if (r0.equals(ACTION_SMART_NAVIGATION_END_EXPIRE_CANCEL) == false) goto L41;
        r1 = 0;
        goto L29
    L41:
        r1 = -1;
        goto L29
    }

    private void handleSmartChargeStateChange(Context context, Intent intent) {
        boolean r0 = intent.getBooleanExtra("isEnterSmartCharge", false);
        int r8 = intent.getIntExtra(DBHelper.COL_TIME, 0);
        OLog.d(TAG, "isEnterSmartCharge:" + r0 + ",time:" + r8);
        if (r0 == true) goto L5;
        cancelNotification(context);
        return;
    L5:
        if (getBatteryInfo(context) != 100) goto L8;
        OLog.d(TAG, "batteryPct is 100, no need to protect");
        cancelNotification(context);
        return;
    L8:
        Calendar r1 = Calendar.getInstance();
        r1.add(13, r8);
        String r9 = String.format(Locale.getDefault(), "%02d:%02d", new Object[]{Integer.valueOf(r1.get(11)), Integer.valueOf(r1.get(12))});
        OLog.d(TAG, "targetTime:" + r9);
        sendNotification(context, SecurityCenterApplication.getContext().getString(R.string.smart_charge_protecting), SecurityCenterApplication.getContext().getString(R.string.smart_charge_protecting_tip, new Object[]{r9}));
        HashMap r6 = new HashMap(1);
        r6.put(DBHelper.COL_TIME, r9);
        TrackUtils.INSTANCE.trackEvent("smart_charge_notification_show", r6);
    }

    private int getBatteryInfo(Context context) {
        Intent r1 = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r1 == null) goto L6;
        int r2 = PowerUsageActivity.getBatteryLevel(r1);
        OLog.d(TAG, "batteryPct:" + r2);
        return r2;
    L6:
        return 0;
    }

    private void handleSmartNavigationStateChange(Context context, Intent intent) {
        boolean r0 = intent.getBooleanExtra("isEnterNavigationCharge", false);
        OLog.d(TAG, "handleSmartNavigationStateChange isEnterNavigationCharge=" + r0);
        if (r0 == false) goto L5;
        sendNavigationEnterNotification(context);
        return;
    L5:
        int r5 = intent.getIntExtra("exitReason", -1);
        OLog.d(TAG, "handleSmartNavigationStateChange exitReason=" + r5);
        sendNavigationEndSilentNotification(context, r5);
    }

    private void sendNotification(Context context, String title, String message) {
        NotificationManager r6 = (NotificationManager) context.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.getNotificationChannel(CHANNEL_ID) != null) goto L8;
        r6.createNotificationChannel(new NotificationChannel(CHANNEL_ID, context.getString(R.string.traffic_notification_channel), 4));
    L8:
        PendingIntent r1 = PendingIntent.getActivity(context, 0, new Intent(context, HealthAndChargeActivity.class), 201326592);
        Intent r4 = new Intent(context, SmartChargeReceiver.class);
        r4.setAction(ACTION_EXIT);
        PendingIntent r3 = PendingIntent.getBroadcast(context, 1, r4, 201326592);
        r6.notify(NOTIFICATION_ID, new NotificationCompat.Builder(context, CHANNEL_ID).setSmallIcon(R.mipmap.app_secure).setContentIntent(r1).setContentTitle(title).setContentText(message).setPriority(2).setOnlyAlertOnce(true).setAutoCancel(false).setOngoing(true).addAction(0, context.getString(R.string.exit_smart_charge), r3).build());
    }

    private void sendNavigationEnterNotification(Context context) {
        if (((NotificationManager) context.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION)) != null) goto L6;
        return;
    L6:
        if (isNotificationShowing(context, NOTIFICATION_NAVIGATION_ID) == false) goto L9;
        sendNavigationEnterNotification(context, true);
        return;
    L9:
        sendNavigationEnterNotification(context, false);
    }

    private void sendNavigationEnterNotification(Context context, boolean silent) {
        NotificationManager r7 = (NotificationManager) context.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
        if (r7 != null) goto L5;
        return;
    L5:
        cancelNavigationEndAutoCancel(context);
        if (silent == false) goto L10;
        String r2 = CHANNEL_NAVIGATION_SILENT_ID;
        if (r7.getNotificationChannel(CHANNEL_NAVIGATION_SILENT_ID) != null) goto L13;
        NotificationChannel r3 = new NotificationChannel(CHANNEL_NAVIGATION_SILENT_ID, context.getString(R.string.smart_navigation_charge_channel_silent_name), 2);
        r3.enableVibration(false);
        r3.setSound(null, null);
        r7.createNotificationChannel(r3);
    L13:
        PendingIntent r4 = PendingIntent.getActivity(context, 0, new Intent(context, HealthAndChargeActivity.class), 201326592);
        Intent r5 = new Intent(context, SmartChargeReceiver.class);
        r5.setAction(ACTION_SMART_NAVIGATION_MANUAL_EXIT_CLICK);
        PendingIntent r0 = PendingIntent.getBroadcast(context, 2, r5, 201326592);
        NotificationCompat.Builder r8 = new NotificationCompat.Builder(context, r2).setSmallIcon(R.mipmap.app_secure).setContentIntent(r4).setContentTitle(context.getString(R.string.smart_navigation_charge_enter_title)).setContentText(context.getString(R.string.smart_navigation_charge_enter_message)).setOnlyAlertOnce(true).setAutoCancel(true).setOngoing(false).addAction(0, context.getString(R.string.smart_navigation_charge_action_continue), r0);
        if (silent == false) goto L16;
        r8.setPriority(-1);
        r8.setSilent(true);
    L17:
        r7.notify(NOTIFICATION_NAVIGATION_ID, r8.build());
        return;
    L16:
        r8.setPriority(0);
        goto L17
    L10:
        r2 = CHANNEL_NAVIGATION_NORMAL_ID;
        if (r7.getNotificationChannel(CHANNEL_NAVIGATION_NORMAL_ID) != null) goto L13;
        r7.createNotificationChannel(new NotificationChannel(CHANNEL_NAVIGATION_NORMAL_ID, context.getString(R.string.smart_navigation_charge_channel_name), 3));
        goto L13
    }

    private void sendNavigationEndSilentNotification(Context context, int exitReason) {
        NotificationManager r5 = (NotificationManager) context.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.getNotificationChannel(CHANNEL_NAVIGATION_SILENT_ID) != null) goto L8;
        NotificationChannel r1 = new NotificationChannel(CHANNEL_NAVIGATION_SILENT_ID, context.getString(R.string.smart_navigation_charge_channel_silent_name), 2);
        r1.enableVibration(false);
        r1.setSound(null, null);
        r5.createNotificationChannel(r1);
    L8:
        PendingIntent r2 = PendingIntent.getActivity(context, 0, new Intent(context, HealthAndChargeActivity.class), 201326592);
        r5.notify(NOTIFICATION_NAVIGATION_ID, new NotificationCompat.Builder(context, CHANNEL_NAVIGATION_SILENT_ID).setSmallIcon(R.mipmap.app_secure).setContentIntent(r2).setContentTitle(context.getString(R.string.smart_navigation_charge_end_title)).setContentText(context.getString(R.string.smart_navigation_charge_end_message)).setPriority(-1).setSilent(true).setOnlyAlertOnce(true).setAutoCancel(true).setOngoing(false).build());
        HashMap r6 = new HashMap(1);
        r6.put("exitReason", Integer.valueOf(exitReason));
        TrackUtils.INSTANCE.trackEvent("smart_navigation_end_notification_show", r6);
        if (exitReason != 1) goto L11;
        scheduleNavigationEndAutoCancel(context, NAVIGATION_END_AUTO_CANCEL_DELAY_UNPLUGGED_MS, exitReason);
        return;
    L11:
        scheduleNavigationEndAutoCancel(context, 86400000, exitReason);
    }

    public static void cancelNotification(Context context) {
        NotificationManager r1 = (NotificationManager) context.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
        if (r1 == null) goto L6;
        r1.cancel(NOTIFICATION_ID);
        return;
    }

    public static void cancelNavigationNotification(Context context) {
        NotificationManager r0 = (NotificationManager) context.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
        if (r0 == null) goto L5;
        r0.cancel(NOTIFICATION_NAVIGATION_ID);
    L5:
        cancelNavigationEndAutoCancel(context);
    }

    private static void scheduleNavigationEndAutoCancel(Context context, long delayMs, int exitReason) {
        if (context != null) goto L4;
        return;
    L4:
        AlarmManager r0 = (AlarmManager) context.getSystemService("alarm");
        if (r0 != null) goto L7;
        return;
    L7:
        PendingIntent r3 = getNavigationEndExpireCancelPendingIntent(context, delayMs, exitReason, 268435456);
        r0.set(3, SystemClock.elapsedRealtime() + delayMs, r3);
    }

    private static void cancelNavigationEndAutoCancel(Context context) {
        if (context != null) goto L4;
        return;
    L4:
        AlarmManager r0 = (AlarmManager) context.getSystemService("alarm");
        if (r0 != null) goto L7;
        return;
    L7:
        PendingIntent r5 = getNavigationEndExpireCancelPendingIntent(context, -1, -1, 536870912);
        if (r5 == null) goto L11;
        r0.cancel(r5);
        r5.cancel();
        return;
    }

    private static PendingIntent getNavigationEndExpireCancelPendingIntent(Context context, long delayMs, int exitReason, int extraFlags) {
        Intent r0 = new Intent(context, SmartChargeReceiver.class);
        r0.setAction(ACTION_SMART_NAVIGATION_END_EXPIRE_CANCEL);
        if (delayMs < 0) goto L5;
        r0.putExtra(EXTRA_NAVIGATION_AUTO_CANCEL_DELAY_MS, delayMs);
    L5:
        if (exitReason < 0) goto L8;
        r0.putExtra(EXTRA_NAVIGATION_EXIT_REASON, exitReason);
    L8:
        return PendingIntent.getBroadcast(context, REQUEST_CODE_NAVIGATION_END_EXPIRE_CANCEL, r0, 67108864 | extraFlags);
    }

    private static boolean isNotificationShowing(Context context, int notificationId) {
        if (context != null) goto L5;
        return false;
    L5:
        NotificationManager r1 = (NotificationManager) context.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
        if (r1 != null) goto L8;
        return false;
    L8:
        StatusBarNotification[] r2 = r1.getActiveNotifications();
        if (r2 != null) goto L11;
    L25:
        return false;
    L11:
        if (r2.length == 0) goto L25;
        int r3 = r2.length;
        int r4 = 0;
    L14:
        if (r4 >= r3) goto L25;
        StatusBarNotification r5 = r2[r4];
        if (r5 == null) goto L24;
        if (TextUtils.equals(context.getPackageName(), r5.getPackageName()) == false) goto L24;
        if (r5.getId() != notificationId) goto L24;
        return true;
    L24:
        r4 = r4 + 1;
        goto L14
    }
}
