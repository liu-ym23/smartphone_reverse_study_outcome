package com.obric.security.battertpower.powerHigh.notice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.bytedanceos.security.appbehaviorrecord.PermissionUtils;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.olog.OLog;
import com.obric.security.R;
import com.obric.security.battertpower.powerHigh.clearApp.ClearPowerHighAppsActivity;
import com.obric.securitycenter.api.TrackUtils;
import com.obric.taskmanager.TaskManager;
import com.obric.taskmanager.TaskWithCallback;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PowerHightNoticeService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/notice/PowerHightNoticeService;", "Landroid/app/Service;", "()V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onDestroy", "", "onStartCommand", "", "flags", "startId", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PowerHightNoticeService extends Service {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: PowerHightNoticeService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¨\u0006\u000f"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/notice/PowerHightNoticeService$Companion;", "", "()V", "getNotificationMessage", "", "context", "Landroid/content/Context;", "list", "Ljava/util/ArrayList;", "Lcom/obric/security/battertpower/powerHigh/notice/PowerHighApp;", "Lkotlin/collections/ArrayList;", "sendNotification", "", "title", "message", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final String getNotificationMessage(Context r4, ArrayList<PowerHighApp> r5) {
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "list");
            if (PowerHighWarningReceiver.powerHighApps.size() != 1) goto L5;
            PermissionUtils r3 = PermissionUtils.INSTANCE;
            String r1 = PowerHighWarningReceiver.powerHighApps.get(0).getPackageName();
            Intrinsics.checkNotNull(r1);
            String r6 = r4.getString(R.string.power_high_notification_message1, new Object[]{r3.getAppName(r4, r1)});
            Intrinsics.checkNotNullExpressionValue(r6, "context.getString(R.stri…cation_message1, appName)");
            return r6;
        L5:
            PermissionUtils r7 = PermissionUtils.INSTANCE;
            String r2 = PowerHighWarningReceiver.powerHighApps.get(0).getPackageName();
            Intrinsics.checkNotNull(r2);
            String r8 = r7.getAppName(r4, r2);
            PermissionUtils r9 = PermissionUtils.INSTANCE;
            String r10 = PowerHighWarningReceiver.powerHighApps.get(1).getPackageName();
            Intrinsics.checkNotNull(r10);
            String r11 = r4.getString(R.string.power_high_notification_message2, new Object[]{r8, r9.getAppName(r4, r10)});
            Intrinsics.checkNotNullExpressionValue(r11, "context.getString(R.stri…age2, appName1, appName2)");
            return r11;
        }

        public final void sendNotification(Context r9, String r10, String r11) {
            Intrinsics.checkNotNullParameter(r9, "context");
            Intrinsics.checkNotNullParameter(r10, "title");
            Intrinsics.checkNotNullParameter(r11, "message");
            Object r0 = r9.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
            if (r0 == null) goto L10;
            NotificationManager r1 = (NotificationManager) r0;
            if (r1.getNotificationChannel(PowerHighWarningReceiver.CHANNEL_ID) != null) goto L7;
            r1.createNotificationChannel(new NotificationChannel(PowerHighWarningReceiver.CHANNEL_ID, r9.getString(R.string.power_high_channel), 4));
        L7:
            Intent r2 = new Intent(r9, ClearPowerHighAppsActivity.class);
            r2.putExtra(ClearPowerHighAppsActivity.COME_FROM, ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
            PendingIntent r3 = PendingIntent.getActivity(r9, 0, r2, 201326592);
            Intent r4 = new Intent(r9, PowerHighWarningReceiver.class);
            r4.setAction(PowerHighWarningReceiver.ACTION_IGNORE);
            PendingIntent r5 = PendingIntent.getBroadcast(r9, 1, r4, 201326592);
            Intent r6 = new Intent(r9, PowerHighWarningReceiver.class);
            r6.setAction(PowerHighWarningReceiver.ACTION_CLEAR);
            PendingIntent r7 = PendingIntent.getBroadcast(r9, 2, r6, 201326592);
            Notification r8 = new NotificationCompat.Builder(r9, PowerHighWarningReceiver.CHANNEL_ID).setSmallIcon(R.mipmap.app_secure).setContentIntent(r3).setDeleteIntent(r5).setContentTitle(r10).setContentText(r11).setPriority(2).setAutoCancel(true).setOnlyAlertOnce(true).setOngoing(true).addAction(0, r9.getString(R.string.ignore), r5).addAction(1, r9.getString(R.string.clean_now), r7).build();
            Intrinsics.checkNotNullExpressionValue(r8, "NotificationCompat.Build…\n                .build()");
            r1.notify(PowerHighWarningReceiver.NOTIFICATION_ID, r8);
            PowerHighWarningReceiver.noticeShowing = true;
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }
    }

    /* JADX INFO: renamed from: com.obric.security.battertpower.powerHigh.notice.PowerHightNoticeService$onStartCommand$1, reason: invalid class name */
    /* JADX INFO: compiled from: PowerHightNoticeService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/obric/security/battertpower/powerHigh/notice/PowerHightNoticeService$onStartCommand$1", "Lcom/obric/taskmanager/TaskWithCallback;", "", NotificationCompat.CATEGORY_CALL, "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends TaskWithCallback<String> {
        final /* synthetic */ int $startId;
        final /* synthetic */ PowerHightNoticeService this$0;

        AnonymousClass1(PowerHightNoticeService r1, int r2) {
            this.this$0 = r1;
            this.$startId = r2;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            PowerHighWarningReceiver.powerHighApps.addAll(PowerHighAppsManager.INSTANCE.getLocalPowerHighApps(this.this$0));
            PowerHighAppsManager r0 = PowerHighAppsManager.INSTANCE;
            ArrayList<PowerHighApp> r1 = PowerHighWarningReceiver.powerHighApps;
            Intrinsics.checkNotNullExpressionValue(r1, "PowerHighWarningReceiver.powerHighApps");
            ArrayList<PowerHighApp> r3 = PowerHighWarningReceiver.tempPowerHighApps;
            Intrinsics.checkNotNullExpressionValue(r3, "PowerHighWarningReceiver.tempPowerHighApps");
            PowerHighWarningReceiver.powerHighApps = r0.mergeAndRemoveDuplicates(r1, r3);
            PowerHighAppsManager r2 = PowerHighAppsManager.INSTANCE;
            PowerHightNoticeService r4 = this.this$0;
            ArrayList<PowerHighApp> r5 = PowerHighWarningReceiver.powerHighApps;
            Intrinsics.checkNotNullExpressionValue(r5, "PowerHighWarningReceiver.powerHighApps");
            PowerHighWarningReceiver.powerHighApps = r2.filterDeadProcesses(r4, r5);
            OLog.d("PowerHightNoticeService", "PowerHighAppsManager-the final power high apps is:" + PowerHighWarningReceiver.powerHighApps);
            PowerHighAppsManager r6 = PowerHighAppsManager.INSTANCE;
            PowerHightNoticeService r7 = this.this$0;
            ArrayList<PowerHighApp> r8 = PowerHighWarningReceiver.powerHighApps;
            Intrinsics.checkNotNullExpressionValue(r8, "PowerHighWarningReceiver.powerHighApps");
            r6.savePowerHighApps(r7, r8);
            if (PowerHighWarningReceiver.powerHighApps.size() != 0) goto L6;
            OLog.i("PowerHightNoticeService", "no apps, stopSelf");
            this.this$0.stopSelf(this.$startId);
            return "";
        L6:
            ArrayList<PowerHighApp> r9 = PowerHighWarningReceiver.powerHighApps;
            Intrinsics.checkNotNullExpressionValue(r9, "PowerHighWarningReceiver.powerHighApps");
            TrackUtils.trackEvent$default(TrackUtils.INSTANCE, "high_power_notification_show", MapsKt.mapOf(TuplesKt.to("app_package_list", CollectionsKt.joinToString$default(r9, ", ", null, null, 0, null, PowerHightNoticeService$onStartCommand$1$call$appList$1.INSTANCE, 30, null))), false, 4, null);
            Companion r10 = PowerHightNoticeService.Companion;
            Context r11 = SecurityCenterApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(r11, "SecurityCenterApplication.getContext()");
            ArrayList<PowerHighApp> r12 = PowerHighWarningReceiver.powerHighApps;
            Intrinsics.checkNotNullExpressionValue(r12, "PowerHighWarningReceiver.powerHighApps");
            String r13 = r10.getNotificationMessage(r11, r12);
            Companion r14 = PowerHightNoticeService.Companion;
            Context r15 = SecurityCenterApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(r15, "SecurityCenterApplication.getContext()");
            String r16 = SecurityCenterApplication.getContext().getString(R.string.power_high_notification_title);
            Intrinsics.checkNotNullExpressionValue(r16, "SecurityCenterApplicatio…_high_notification_title)");
            r14.sendNotification(r15, r16, r13);
            new Handler(Looper.getMainLooper()).postDelayed(PowerHightNoticeService$onStartCommand$1$call$1.INSTANCE, 0);
            new Handler(Looper.getMainLooper()).postDelayed(new PowerHightNoticeService$onStartCommand$1$call$2(this), 2000);
            return "";
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return null;
    }

    public PowerHightNoticeService() {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r1, int r2, int r3) {
        OLog.i("PowerHightNoticeService", "onStartCommand: startId=" + r3);
        TaskManager.Companion.getInstance().execute("PowerHighAppsManager", new AnonymousClass1(this, r3));
        return 2;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        OLog.d("PowerHightNoticeService", "onDestroy");
    }
}
