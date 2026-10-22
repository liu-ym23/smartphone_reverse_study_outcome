package androidx.work.impl.foreground;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import com.obric.security.battertpower.powerHigh.clearApp.ClearPowerHighAppsActivity;

/* JADX INFO: loaded from: classes.dex */
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.Callback {
    private static final String TAG = null;
    private static SystemForegroundService sForegroundService;
    SystemForegroundDispatcher mDispatcher;
    private Handler mHandler;
    private boolean mIsShutdown;
    NotificationManager mNotificationManager;

    static class Api29Impl {
        private Api29Impl() {
        }

        static void startForeground(Service service, int id, Notification notification, int foregroundServiceType) {
            service.startForeground(id, notification, foregroundServiceType);
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static void startForeground(Service service, int id, Notification notification, int foregroundServiceType) {
            service.startForeground(id, notification, foregroundServiceType);     // Catch: ForegroundServiceStartNotAllowedException -> L4
            return;
        L4:
            e = move-exception;
            Logger.get().warning(SystemForegroundService.access$000(), "Unable to start foreground service", e);
        }
    }

    public SystemForegroundService() {
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    static {
        TAG = Logger.tagWithPrefix("SystemFgService");
        sForegroundService = null;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        sForegroundService = this;
        initializeDispatcher();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        if (this.mIsShutdown == false) goto L5;
        Logger.get().info(TAG, "Re-initializing SystemForegroundService after a request to shut-down.");
        this.mDispatcher.onDestroy();
        initializeDispatcher();
        this.mIsShutdown = false;
    L5:
        if (intent == null) goto L9;
        this.mDispatcher.onStartCommand(intent);
        return 3;
    L9:
        return 3;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mDispatcher.onDestroy();
    }

    private void initializeDispatcher() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mNotificationManager = (NotificationManager) getApplicationContext().getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
        SystemForegroundDispatcher r0 = new SystemForegroundDispatcher(getApplicationContext());
        this.mDispatcher = r0;
        r0.setCallback(this);
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void stop() {
        this.mIsShutdown = true;
        Logger.get().debug(TAG, "All commands completed.");
        stopForeground(true);
        sForegroundService = null;
        stopSelf();
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void startForeground(final int notificationId, final int notificationType, final Notification notification) {
        this.mHandler.post(new AnonymousClass1(this, notificationId, notification, notificationType));
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void notify(final int notificationId, final Notification notification) {
        this.mHandler.post(new AnonymousClass2(this, notificationId, notification));
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void cancelNotification(final int notificationId) {
        this.mHandler.post(new AnonymousClass3(this, notificationId));
    }

    public static SystemForegroundService getInstance() {
        return sForegroundService;
    }
}
