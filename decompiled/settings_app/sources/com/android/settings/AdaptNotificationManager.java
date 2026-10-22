package com.android.settings;

import android.app.INotificationManager;
import android.app.NotificationChannel;
import android.os.RemoteException;
import android.service.notification.StatusBarNotification;

/* JADX INFO: loaded from: classes2.dex */
public class AdaptNotificationManager {
    public AdaptNotificationManager() {
    }

    public static NotificationChannel getNotificationChannelForPackage(INotificationManager r6, String r7, int r8, String r9, String r10) throws RemoteException {
        return r6.getNotificationChannelForPackage(r7, r8, r9, r10, true);
    }

    public static StatusBarNotification[] getHistoricalNotifications(INotificationManager r1, String r2, int r3) throws RemoteException {
        return r1.getHistoricalNotifications(r2, 50, false);
    }
}
