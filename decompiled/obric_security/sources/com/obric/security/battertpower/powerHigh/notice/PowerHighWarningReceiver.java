package com.obric.security.battertpower.powerHigh.notice;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.text.TextUtils;
import com.bytedance.apm.alog.AlogMonitor;
import com.obric.olog.OLog;
import com.obric.security.battertpower.powerHigh.clearApp.ClearPowerHighAppsActivity;
import com.obric.security.util.NoticeEventRecorder;
import com.obric.securitycenter.api.TrackUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class PowerHighWarningReceiver extends BroadcastReceiver {
    private static final String ACTION = "com.bytedanceos.securitycenter.PowerHighWarningReceiver";
    public static final String ACTION_CLEAR = "com.bytedanceos.securitycenter.PowerHighWarningReceiver.CLEAR";
    public static final String ACTION_IGNORE = "com.bytedanceos.securitycenter.PowerHighWarningReceiver.ACTION_IGNORE";
    public static final String ACTION_POWER_HIGH_WARNING = "com.bytedanceos.action.POWER_HIGH_WARNING";
    public static final String CHANNEL_ID = "com.bytedanceos.action.POWER_HIGH_WARNING2";
    public static final String LOCAL_POWER_HIGH_APPS = "localPowerHighApps";
    public static final int NOTIFICATION_ID = 100002;
    public static final String PREF_FILE = "powerHighWarning";
    public static final String PREF_TIME = "power_warning_day";
    public static final String TAG = "PowerHighWarningReceiver";
    public static Boolean noticeShowing;
    public static ArrayList<PowerHighApp> powerHighApps;
    public static ArrayList<PowerHighApp> tempPowerHighApps;
    NoticeEventRecorder dailyEventRecorder;

    public PowerHighWarningReceiver() {
        this.dailyEventRecorder = null;
    }

    static {
        powerHighApps = new ArrayList();
        tempPowerHighApps = new ArrayList();
        noticeShowing = false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        new Handler(Looper.getMainLooper());
        String r0 = intent.getAction();
        OLog.d("PowerHighAppsManager", "PowerHighWarningReceiver-onReceive:" + r0);
        if (TextUtils.isEmpty(r0) == false) goto L6;
        return;
    L6:
        if (this.dailyEventRecorder != null) goto L9;
        this.dailyEventRecorder = new NoticeEventRecorder(context);
    L9:
        if (isIgnoredToday(context) == false) goto L12;
        return;
    L12:
        if (r0.equals(ACTION_POWER_HIGH_WARNING) == false) goto L15;
        handlePowerHighWarning(context, intent);
        return;
    L15:
        if (r0.equals(ACTION_IGNORE) == false) goto L18;
        handleIgnoreAction(context, intent);
        return;
    L18:
        if (r0.equals(ACTION_CLEAR) == false) goto L21;
        handleClearAction(context);
        return;
    L21:
        if (r0.equals(ACTION) == false) goto L31;
        Bundle r1 = new Bundle();
        int r2 = intent.getIntExtra("count", 4);
        OLog.d("PowerHighAppsManager", "count:" + r2);
        ArrayList r3 = new ArrayList();
        r3.add("uid:10212 pkgName:com.ss.android.ugc.aweme");
        ArrayList<CharSequence> r4 = new ArrayList();
        int r5 = Math.min(r2, r3.size());
        int r6 = 0;
    L23:
        if (r6 >= r5) goto L25;
        r4.add((CharSequence) r3.get(r6));
        r6 = r6 + 1;
        goto L23
    L25:
        r1.putCharSequenceArrayList("pkgList", r4);
        intent.putExtra(AlogMonitor.ALOG_RESULT_INFO, r1);
        handlePowerHighWarning(context, intent);
        return;
    }

    private void handleClearAction(Context context) {
        int r0 = 0;
    L4:
        if (r0 >= powerHighApps.size()) goto L6;
        String r1 = powerHighApps.get(r0).getPackageName();
        OLog.d(TAG, "forceStopPackageAsUser:packageName:i：" + r0 + ", pkg:" + r1);
        forceStopPackageAsUser(context, r1);
        r0 = r0 + 1;
        goto L4
    L6:
        showToast(context);
        cancelNotification(context);
        HashMap r4 = new HashMap();
        r4.put("trigger_type", ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
        TrackUtils.INSTANCE.trackEvent("high_power_clean_click", r4);
    }

    private void showToast(Context context) {
        new OToast(context, "已经清理", 48).show();
    }

    private void handleIgnoreAction(Context context, Intent intent) {
        this.dailyEventRecorder.recordCurrentTime(PREF_TIME, NoticeEventRecorder.CycleType.NOON_TO_NOON);
        cancelNotification(context);
    }

    private ArrayList<PowerHighApp> filterDeadProcesses(Context context, ArrayList<PowerHighApp> list) {
        return PowerHighAppsManager.INSTANCE.filterDeadProcesses(context, list);
    }

    public boolean isIgnoredToday(Context context) {
        return this.dailyEventRecorder.hasRecordInCurrentCycle(PREF_TIME, NoticeEventRecorder.CycleType.NOON_TO_NOON);
    }

    private void handlePowerHighWarning(Context context, Intent intent) {
        Bundle r3 = intent.getExtras();
        if (r3 != null) goto L5;
        return;
    L5:
        Bundle r4 = r3.getBundle(AlogMonitor.ALOG_RESULT_INFO);
        if (r4 != null) goto L8;
        return;
    L8:
        ArrayList<CharSequence> r5 = r4.getCharSequenceArrayList("pkgList");
        if (r5 != null) goto L11;
        return;
    L11:
        if (r5.isEmpty() == true) goto L29;
        tempPowerHighApps.clear();
        int r6 = 0;
    L15:
        if (r6 >= r5.size()) goto L21;
        PowerHighApp r0 = PowerHighAppKt.parseLogString(r5.get(r6).toString());
        if (TextUtils.isEmpty(r0.getPackageName()) == true) goto L19;
        tempPowerHighApps.add(r0);
        OLog.d("PowerHighAppsManager", "find new power high app-packageName:" + r0.getPackageName());
    L19:
        r6 = r6 + 1;
        goto L15
    L21:
        if (tempPowerHighApps.isEmpty() == false) goto L23;
        return;
    L23:
        context.startService(new Intent(context, PowerHightNoticeService.class));
        return;
    }

    public void forceStopPackageAsUser(Context context, String packageName) {
        ((ActivityManager) context.getSystemService("activity")).forceStopPackageAsUser(packageName, UserHandle.getUserId(context.getPackageManager().getApplicationInfo(packageName, 0).uid));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.e(TAG, "forceStopPackageAsUser:exception:" + e);
    }

    public static void cancelNotification(Context context) {
        ((NotificationManager) context.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION)).cancel(NOTIFICATION_ID);
        noticeShowing = false;
        powerHighApps.clear();
        PowerHighAppsManager.INSTANCE.clearLocalPowerHighApps(context);
        PowerHighAppsManager.INSTANCE.unregisterUidListener();
    }

    public static boolean isNotificationShowing(Context context, String channelId) {
        if (noticeShowing.booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (powerHighApps.isEmpty() == true) goto L7;
        return true;
    }
}
