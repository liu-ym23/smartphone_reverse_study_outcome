package com.obric.security.trafficHigh;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedanceos.datausage.DataUsageActivity;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.olog.OLog;
import com.obric.security.R;
import com.obric.security.battertpower.powerHigh.clearApp.ClearPowerHighAppsActivity;
import com.obric.security.util.NoticeEventRecorder;
import com.obric.securitycenter.api.TrackUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class TrafficHighWarningReceiver extends BroadcastReceiver {
    private static final String ACTION = "com.obric.security.battertpower.trafficHigh.TrafficHighWarningReceiver";
    public static final String ACTION_IGNORE = "com.bytedanceos.securitycenter.TrafficHighWarningReceiver.ACTION_IGNORE";
    public static final String ACTION_NO_REMIND = "com.bytedanceos.securitycenter.TrafficHighWarningReceiver.NO_REMIND";
    public static final String ACTION_TRAFFIC_HIGH_WARNING = "com.obric.security.action.TRAFFIC_HIGH_CONSUMPTION_WARNING";
    public static final String CHANNEL_ID = "com.obric.security.action.TRAFFIC_HIGH_CONSUMPTION_WARNING2";
    public static final String EXTRA_NOTIFICATION_TIMEOUT_AFTER_MS = "notification_timeout_after_ms";
    public static final String EXTRA_SUB_ID = "subId";
    public static final String FROM_TRAFFIC_HIGH_WARNING = "traffic_high_warning";
    public static final int NOTIFICATION_ID = 100003;
    public static final long NOTIFICATION_TIMEOUT = 1800000;
    public static final String PREF_TRAFFIC_WARNING_DAY_TIME = "traffic_warning_day_";
    public static final String PREF_TRAFFIC_WARNING_MONTH_TIME = "traffic_warning_month_";
    public static final String TAG = "TrafficHighWarningReceiver";
    NoticeEventRecorder dailyEventRecorder;
    int subId;

    public TrafficHighWarningReceiver() {
        this.dailyEventRecorder = null;
        this.subId = 0;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        new Handler(Looper.getMainLooper());
        String r0 = intent.getAction();
        Object r1 = intent.getExtras().get(EXTRA_SUB_ID);     // Catch: Exception -> L34
        if ((r1 instanceof Integer) == false) goto L7;
        this.subId = ((Integer) r1).intValue();     // Catch: Exception -> L34
    L35:
        goto L9
    L7:
        if ((r1 instanceof String) == false) goto L35;
        this.subId = Integer.valueOf((String) r1).intValue();     // Catch: Exception -> L34
    L9:
        OLog.d(TAG, "TrafficHighWarningReceiver-onReceive:" + r0 + ",subId:" + this.subId);
        if (TextUtils.isEmpty(r0) == false) goto L13;
        return;
    L13:
        if (this.dailyEventRecorder != null) goto L16;
        this.dailyEventRecorder = new NoticeEventRecorder(context);
    L16:
        if (r0.equals(ACTION_IGNORE) == false) goto L19;
        handleIgnoreAction(context, this.subId);
    L22:
        if (isIgnoredToday(context, this.subId) == false) goto L24;
        return;
    L24:
        if (isNoRemindMonthly(context, this.subId) == false) goto L27;
        return;
    L27:
        if (r0.equals(ACTION_TRAFFIC_HIGH_WARNING) == false) goto L30;
        handleTrafficHighWarning(context, intent);
    L32:
        this.dailyEventRecorder.recordCurrentTime(PREF_TRAFFIC_WARNING_DAY_TIME + this.subId, NoticeEventRecorder.CycleType.NOON_TO_NOON);
        return;
    L30:
        if (r0.equals(ACTION) == false) goto L32;
        handleTrafficHighWarning(context, intent);
        goto L32
    L19:
        if (r0.equals(ACTION_NO_REMIND) == false) goto L22;
        handleNoRemindAction(context);
        goto L22
    }

    private boolean isNoRemindMonthly(Context context, int subId) {
        boolean r1 = this.dailyEventRecorder.hasRecordInCurrentCycle(PREF_TRAFFIC_WARNING_MONTH_TIME + subId, NoticeEventRecorder.CycleType.MONTHLY);
        OLog.d(TAG, "isNoRemindMonthly:,isNoRemind:" + r1);
        return r1;
    }

    private void handleNoRemindAction(Context context) {
        this.dailyEventRecorder.recordCurrentTime(PREF_TRAFFIC_WARNING_MONTH_TIME + this.subId, NoticeEventRecorder.CycleType.MONTHLY);
        cancelNotification(context);
    }

    private void handleIgnoreAction(Context context, int subId) {
        this.dailyEventRecorder.recordCurrentTime(PREF_TRAFFIC_WARNING_DAY_TIME + subId, NoticeEventRecorder.CycleType.NOON_TO_NOON);
        cancelNotification(context);
    }

    public boolean isIgnoredToday(Context context, int subId) {
        boolean r1 = this.dailyEventRecorder.hasRecordInCurrentCycle(PREF_TRAFFIC_WARNING_DAY_TIME + subId, NoticeEventRecorder.CycleType.NOON_TO_NOON);
        OLog.d(TAG, "isIgnoredToday:,isIgnored:" + r1);
        return r1;
    }

    private void handleTrafficHighWarning(Context context, Intent intent) {
        sendNotification(context, intent, SecurityCenterApplication.getContext().getString(R.string.traffic_warning_title), SecurityCenterApplication.getContext().getString(R.string.traffic_warning_message));
        TrackUtils.INSTANCE.trackEvent("high_traffic_notification_show", new HashMap());
    }

    private void sendNotification(Context context, Intent sourceIntent, String title, String message) {
        NotificationManager r3 = (NotificationManager) context.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
        if (r3.getNotificationChannel(CHANNEL_ID) != null) goto L5;
        r3.createNotificationChannel(new NotificationChannel(CHANNEL_ID, context.getString(R.string.traffic_notification_channel), 4));
    L5:
        Intent r5 = new Intent(context, DataUsageActivity.class);
        r5.putExtra("from", FROM_TRAFFIC_HIGH_WARNING);
        r5.putExtra(EXTRA_SUB_ID, this.subId);
        PendingIntent r6 = PendingIntent.getActivity(context, 0, r5, 201326592);
        Intent r9 = new Intent(context, TrafficHighWarningReceiver.class);
        r9.setAction(ACTION_IGNORE);
        r9.putExtra(EXTRA_SUB_ID, this.subId);
        PendingIntent r12 = PendingIntent.getBroadcast(context, 1, r9, 201326592);
        new Intent(context, TrafficHighWarningReceiver.class);
        r9.setAction(ACTION_NO_REMIND);
        r9.putExtra(EXTRA_SUB_ID, this.subId);
        PendingIntent r0 = PendingIntent.getBroadcast(context, 1, r9, 201326592);
        long r7 = 1800000;
        if (sourceIntent != null) goto L8;
    L13:
        r3.notify(NOTIFICATION_ID, new NotificationCompat.Builder(context, CHANNEL_ID).setSmallIcon(R.mipmap.app_secure).setContentIntent(r6).setDeleteIntent(r12).setContentTitle(title).setContentText(message).setPriority(2).setAutoCancel(true).setOngoing(true).addAction(0, context.getString(R.string.traffic_notification_opt1), r0).addAction(0, context.getString(R.string.ignore), r12).setTimeoutAfter(r7).build());
        return;
    L8:
        if (sourceIntent.hasExtra(EXTRA_NOTIFICATION_TIMEOUT_AFTER_MS) == false) goto L13;
        long r10 = sourceIntent.getLongExtra(EXTRA_NOTIFICATION_TIMEOUT_AFTER_MS, 1800000);
        if (r10 <= 0) goto L13;
        r7 = r10;
        goto L13
    }

    public static void cancelNotification(Context context) {
        ((NotificationManager) context.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION)).cancel(NOTIFICATION_ID);
    }
}
