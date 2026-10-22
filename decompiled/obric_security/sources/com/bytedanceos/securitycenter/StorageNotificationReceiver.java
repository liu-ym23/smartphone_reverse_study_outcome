package com.bytedanceos.securitycenter;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.bytedanceos.storage.StorageActivity;
import com.obric.olog.OLog;
import com.obric.security.R;
import com.obric.security.battertpower.powerHigh.clearApp.ClearPowerHighAppsActivity;
import com.obric.securitycenter.api.TrackUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class StorageNotificationReceiver extends BroadcastReceiver {
    private static final String ACTION = "com.bytedanceos.securitycenter.StorageNotificationReceiver";
    public static final String ACTION_IGNORE = "com.bytedanceos.securitycenter.StorageNotificationReceiver.ACTION_IGNORE";
    private static final String CHANNEL_ID = "com.bytedanceos.securitycenter.StorageNotificationReceiver2";
    private static final int NOTIFICATION_ID = 1;
    public static final String TAG = "StorageNotificationReceiver";

    public StorageNotificationReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String r6 = intent.getAction();
        if (r6 == null) goto L17;
        OLog.i(TAG, "onReceive action: " + r6);
        if (r6.equals(ACTION) == false) goto L8;
        sendNotification(context, context.getString(R.string.storage_notification_title), context.getString(R.string.storage_notification_detail));
        return;
    L8:
        if (r6.equals(ACTION_IGNORE) == false) goto L11;
        OLog.i(TAG, "onReceive ACTION_IGNORE");
        cancelNotification(context);
        return;
    L11:
        if ("android.intent.action.DEVICE_STORAGE_LOW".equals(r6) == false) goto L14;
        OLog.i(TAG, "onReceive ACTION_DEVICE_STORAGE_LOW");
        sendNotification(context, context.getString(R.string.storage_notification_title), context.getString(R.string.storage_notification_detail));
        return;
    L14:
        if ("android.intent.action.DEVICE_STORAGE_OK".equals(r6) == false) goto L21;
        OLog.i(TAG, "onReceive ACTION_DEVICE_STORAGE_OK");
        cancelNotification(context);
        return;
    L21:
        return;
    }

    private void sendNotification(Context context, String title, String message) {
        NotificationManager r8 = (NotificationManager) context.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
        if (r8.getNotificationChannel(CHANNEL_ID) != null) goto L5;
        r8.createNotificationChannel(new NotificationChannel(CHANNEL_ID, context.getString(R.string.storage_notification_channel), 4));
    L5:
        PendingIntent r1 = PendingIntent.getActivity(context, 0, new Intent(context, StorageActivity.class), 201326592);
        Intent r4 = new Intent(context, StorageNotificationReceiver.class);
        r4.setAction(ACTION_IGNORE);
        PendingIntent r5 = PendingIntent.getBroadcast(context, 1, r4, 201326592);
        Intent r6 = new Intent(context, StorageActivity.class);
        r6.putExtra(TAG, true);
        PendingIntent r3 = PendingIntent.getActivity(context, 2, r6, 201326592);
        r8.notify(1, new NotificationCompat.Builder(context, CHANNEL_ID).setSmallIcon(R.mipmap.app_secure).setContentIntent(r1).setDeleteIntent(r5).setContentTitle(title).setContentText(message).setPriority(2).setAutoCancel(true).setOngoing(true).addAction(0, context.getString(R.string.ignore), r5).addAction(0, context.getString(R.string.clean_now), r3).build());
        TrackUtils.INSTANCE.trackEvent("low_storage_alert_notification_show", new HashMap());
    }

    public static void cancelNotification(Context context) {
        ((NotificationManager) context.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION)).cancel(1);
    }
}
