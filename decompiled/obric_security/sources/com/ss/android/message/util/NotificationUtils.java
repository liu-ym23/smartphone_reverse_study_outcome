package com.ss.android.message.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import com.obric.security.battertpower.powerHigh.clearApp.ClearPowerHighAppsActivity;

/* JADX INFO: loaded from: classes4.dex */
public class NotificationUtils {
    public static final String CHANNEL_ID = "other";
    public static final String CHANNEL_NAME = "other";

    public NotificationUtils() {
    }

    public static void tryCreatePushAliveNotificationChannel(Context r3) {
        NotificationManager r4 = (NotificationManager) r3.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.getNotificationChannel("other") != null) goto L9;
        r4.createNotificationChannel(new NotificationChannel("other", "other", 1));
        return;
    }
}
