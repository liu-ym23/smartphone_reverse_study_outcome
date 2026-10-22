package com.obric.security.devenvcheck;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.obric.devenvcheck.R;
import com.obric.olog.OLog;
import com.obric.security.battertpower.powerHigh.clearApp.ClearPowerHighAppsActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WlanRiskNotifier.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/security/devenvcheck/WlanRiskNotifier;", "", "()V", "ACTION_DISCONNECT", "", "CHANNEL_ID", "NOTIFICATION_ID", "", "cancel", "", "context", "Landroid/content/Context;", "showRiskNotification", "ssid", "DisconnectReceiver", "devenvcheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class WlanRiskNotifier {
    public static final String ACTION_DISCONNECT = "com.obric.security.wlan.ACTION_NOTIFY_DISCONNECT";
    private static final String CHANNEL_ID = "wlan_security_risk";
    public static final WlanRiskNotifier INSTANCE = null;
    private static final int NOTIFICATION_ID = 5721153;

    /* JADX INFO: compiled from: WlanRiskNotifier.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/security/devenvcheck/WlanRiskNotifier$DisconnectReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "devenvcheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DisconnectReceiver extends BroadcastReceiver {
        public DisconnectReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "intent");
            if ((!Intrinsics.areEqual(r2.getAction(), WlanRiskNotifier.ACTION_DISCONNECT)) == false) goto L5;
            return;
        L5:
            OLog.d(WlanCheckResultProviderKt.WLAN_LOG_TAG, "WlanRiskNotifier: notification clicked, disconnect");
            WlanDisconnector.INSTANCE.disconnectCurrent(r1);
            WlanRiskNotifier.INSTANCE.cancel(r1);
        }
    }

    static {
        INSTANCE = new WlanRiskNotifier();
    }

    private WlanRiskNotifier() {
    }

    public final void showRiskNotification(Context r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "ssid");
        Context r9 = r7.getApplicationContext();
        Object r0 = r9.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
        if ((r0 instanceof NotificationManager) == true) goto L5;
        r0 = null;
    L5:
        NotificationManager r1 = (NotificationManager) r0;
        if (r1 != null) goto L10;
        OLog.w(WlanCheckResultProviderKt.WLAN_LOG_TAG, "WlanRiskNotifier: NotificationManager unavailable");
        return;
    L10:
        if (r1.getNotificationChannel(CHANNEL_ID) != null) goto L12;
        r1.createNotificationChannel(new NotificationChannel(CHANNEL_ID, r9.getString(R.string.wlan_security_notification_channel), 4));
    L12:
        Intent r2 = new Intent(r9, DisconnectReceiver.class);
        r2.setAction(ACTION_DISCONNECT);
        PendingIntent r3 = PendingIntent.getBroadcast(r9, 0, r2, 201326592);
        String r4 = r9.getString(R.string.wlan_security_notification_title);
        Intrinsics.checkNotNullExpressionValue(r4, "appContext.getString(R.s…urity_notification_title)");
        String r5 = r9.getString(R.string.wlan_security_notification_message);
        Intrinsics.checkNotNullExpressionValue(r5, "appContext.getString(R.s…ity_notification_message)");
        Notification r6 = new Notification.Builder(r9, CHANNEL_ID).setSmallIcon(android.R.drawable.stat_sys_warning).setContentTitle(r4).setContentText(r5).setContentIntent(r3).setAutoCancel(true).build();
        Intrinsics.checkNotNullExpressionValue(r6, "android.app.Notification…rue)\n            .build()");
        r1.notify(NOTIFICATION_ID, r6);
        OLog.d(WlanCheckResultProviderKt.WLAN_LOG_TAG, "WlanRiskNotifier: notification shown. ssid=" + r8);
    }

    public final void cancel(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Object r0 = r1.getApplicationContext().getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
        if ((r0 instanceof NotificationManager) == true) goto L5;
        r0 = null;
    L5:
        NotificationManager r2 = (NotificationManager) r0;
        if (r2 == null) goto L9;
        r2.cancel(NOTIFICATION_ID);
        return;
    }
}
