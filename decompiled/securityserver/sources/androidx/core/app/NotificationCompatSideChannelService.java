package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.INotificationSideChannel;

/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationCompatSideChannelService extends Service {

    public class NotificationSideChannelStub extends INotificationSideChannel.Stub {
        final /* synthetic */ NotificationCompatSideChannelService this$0;

        public NotificationSideChannelStub(NotificationCompatSideChannelService r1) {
            this.this$0 = r1;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancel(String r3, int r4, String r5) {
            this.this$0.checkPermission(Binder.getCallingUid(), r3);
            long r0 = Binder.clearCallingIdentity();
            this.this$0.cancel(r3, r4, r5);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(r0);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(r0);
            throw th;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancelAll(String r3) {
            this.this$0.checkPermission(Binder.getCallingUid(), r3);
            long r0 = Binder.clearCallingIdentity();
            this.this$0.cancelAll(r3);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(r0);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(r0);
            throw th;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void notify(String r3, int r4, String r5, Notification r6) {
            this.this$0.checkPermission(Binder.getCallingUid(), r3);
            long r0 = Binder.clearCallingIdentity();
            this.this$0.notify(r3, r4, r5, r6);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(r0);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(r0);
            throw th;
        }
    }

    public NotificationCompatSideChannelService() {
    }

    public abstract void cancel(String r1, int r2, String r3);

    public abstract void cancelAll(String r1);

    public void checkPermission(int r4, String r5) {
        String[] r3 = getPackageManager().getPackagesForUid(r4);
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (r3[r1].equals(r5) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return;
    L9:
        throw new SecurityException("NotificationSideChannelService: Uid " + r4 + " is not authorized for package " + r5);
    }

    public abstract void notify(String r1, int r2, String r3, Notification r4);

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        r1.getAction().equals(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL);
        return null;
    }
}
