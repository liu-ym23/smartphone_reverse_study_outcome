package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import com.obric.security.battertpower.powerHigh.clearApp.ClearPowerHighAppsActivity;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;
    static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    private static final String TAG = "NotifManCompat";
    private static Set<String> sEnabledNotificationListenerPackages;
    private static String sEnabledNotificationListeners;
    private static final Object sEnabledNotificationListenersLock = null;
    private static final Object sLock = null;
    private static SideChannelManager sSideChannelManager;
    private final Context mContext;
    private final NotificationManager mNotificationManager;

    private static class CancelTask implements Task {
        final boolean all;
        final int id;
        final String packageName;
        final String tag;

        CancelTask(String r1) {
            this.packageName = r1;
            this.id = 0;
            this.tag = null;
            this.all = true;
        }

        CancelTask(String r1, int r2, String r3) {
            this.packageName = r1;
            this.id = r2;
            this.tag = r3;
            this.all = false;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(INotificationSideChannel r3) throws RemoteException {
            if (this.all == false) goto L5;
            r3.cancelAll(this.packageName);
            return;
        L5:
            r3.cancel(this.packageName, this.id, this.tag);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("CancelTask[packageName:");
            r0.append(this.packageName);
            r0.append(", id:").append(this.id);
            r0.append(", tag:").append(this.tag);
            r0.append(", all:").append(this.all);
            r0.append("]");
            return r0.toString();
        }
    }

    private static class NotifyTask implements Task {
        final int id;
        final Notification notif;
        final String packageName;
        final String tag;

        NotifyTask(String r1, int r2, String r3, Notification r4) {
            this.packageName = r1;
            this.id = r2;
            this.tag = r3;
            this.notif = r4;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(INotificationSideChannel r4) throws RemoteException {
            r4.notify(this.packageName, this.id, this.tag, this.notif);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("NotifyTask[packageName:");
            r0.append(this.packageName);
            r0.append(", id:").append(this.id);
            r0.append(", tag:").append(this.tag);
            r0.append("]");
            return r0.toString();
        }
    }

    private static class ServiceConnectedEvent {
        final ComponentName componentName;
        final IBinder iBinder;

        ServiceConnectedEvent(ComponentName r1, IBinder r2) {
            this.componentName = r1;
            this.iBinder = r2;
        }
    }

    private static class SideChannelManager implements Handler.Callback, ServiceConnection {
        private static final int MSG_QUEUE_TASK = 0;
        private static final int MSG_RETRY_LISTENER_QUEUE = 3;
        private static final int MSG_SERVICE_CONNECTED = 1;
        private static final int MSG_SERVICE_DISCONNECTED = 2;
        private Set<String> mCachedEnabledPackages;
        private final Context mContext;
        private final Handler mHandler;
        private final HandlerThread mHandlerThread;
        private final Map<ComponentName, ListenerRecord> mRecordMap;

        private static class ListenerRecord {
            boolean bound;
            final ComponentName componentName;
            int retryCount;
            INotificationSideChannel service;
            ArrayDeque<Task> taskQueue;

            ListenerRecord(ComponentName r3) {
                this.bound = false;
                this.taskQueue = new ArrayDeque();
                this.retryCount = 0;
                this.componentName = r3;
            }
        }

        SideChannelManager(Context r2) {
            this.mRecordMap = new HashMap();
            this.mCachedEnabledPackages = new HashSet();
            this.mContext = r2;
            HandlerThread r3 = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread = r3;
            r3.start();
            this.mHandler = new Handler(r3.getLooper(), this);
        }

        public void queueTask(Task r2) {
            this.mHandler.obtainMessage(0, r2).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r4) {
            int r0 = r4.what;
            if (r0 == 0) goto L17;
            if (r0 != 1) goto L6;
            ServiceConnectedEvent r5 = (ServiceConnectedEvent) r4.obj;
            handleServiceConnected(r5.componentName, r5.iBinder);
            return true;
        L6:
            if (r0 != 2) goto L8;
            handleServiceDisconnected((ComponentName) r4.obj);
            return true;
        L8:
            if (r0 == 3) goto L11;
            return false;
        L11:
            handleRetryListenerQueue((ComponentName) r4.obj);
            return true;
        L17:
            handleQueueTask((Task) r4.obj);
            return true;
        }

        private void handleQueueTask(Task r4) {
            updateListenerMap();
            Iterator<ListenerRecord> r0 = this.mRecordMap.values().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ListenerRecord r1 = r0.next();
            r1.taskQueue.add(r4);
            processListenerQueue(r1);
            goto L4
        }

        private void handleServiceConnected(ComponentName r2, IBinder r3) {
            ListenerRecord r4 = this.mRecordMap.get(r2);
            if (r4 == null) goto L6;
            r4.service = INotificationSideChannel.Stub.asInterface(r3);
            r4.retryCount = 0;
            processListenerQueue(r4);
            return;
        }

        private void handleServiceDisconnected(ComponentName r2) {
            ListenerRecord r3 = this.mRecordMap.get(r2);
            if (r3 == null) goto L6;
            ensureServiceUnbound(r3);
            return;
        }

        private void handleRetryListenerQueue(ComponentName r2) {
            ListenerRecord r3 = this.mRecordMap.get(r2);
            if (r3 == null) goto L6;
            processListenerQueue(r3);
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r4, IBinder r5) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L5;
            Log.d(NotificationManagerCompat.TAG, "Connected to service " + r4);
        L5:
            this.mHandler.obtainMessage(1, new ServiceConnectedEvent(r4, r5)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r4) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L5;
            Log.d(NotificationManagerCompat.TAG, "Disconnected from service " + r4);
        L5:
            this.mHandler.obtainMessage(2, r4).sendToTarget();
        }

        private void updateListenerMap() {
            Set<String> r0 = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
            if (r0.equals(this.mCachedEnabledPackages) == false) goto L5;
            return;
        L5:
            this.mCachedEnabledPackages = r0;
            List<ResolveInfo> r1 = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
            HashSet r2 = new HashSet();
            Iterator<ResolveInfo> r3 = r1.iterator();
        L7:
            if (r3.hasNext() == false) goto L15;
            ResolveInfo r4 = r3.next();
            if (r0.contains(r4.serviceInfo.packageName) == false) goto L7;
            ComponentName r5 = new ComponentName(r4.serviceInfo.packageName, r4.serviceInfo.name);
            if (r4.serviceInfo.permission != null) goto L13;
            r2.add(r5);
            goto L7
        L13:
            Log.w(NotificationManagerCompat.TAG, "Permission present on component " + r5 + ", not adding listener record.");
            goto L7
        L15:
            Iterator r6 = r2.iterator();
        L17:
            if (r6.hasNext() == false) goto L24;
            ComponentName r7 = (ComponentName) r6.next();
            if (this.mRecordMap.containsKey(r7) == true) goto L17;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L23;
            Log.d(NotificationManagerCompat.TAG, "Adding listener record for " + r7);
        L23:
            this.mRecordMap.put(r7, new ListenerRecord(r7));
            goto L17
        L24:
            Iterator<Map.Entry<ComponentName, ListenerRecord>> r8 = this.mRecordMap.entrySet().iterator();
        L26:
            if (r8.hasNext() == false) goto L33;
            Map.Entry<ComponentName, ListenerRecord> r9 = r8.next();
            if (r2.contains(r9.getKey()) == true) goto L26;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L32;
            Log.d(NotificationManagerCompat.TAG, "Removing listener record for " + r9.getKey());
        L32:
            ensureServiceUnbound(r9.getValue());
            r8.remove();
            goto L26
        }

        private boolean ensureServiceBound(ListenerRecord r4) {
            if (r4.bound == false) goto L6;
            return true;
        L6:
            r4.bound = this.mContext.bindService(new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(r4.componentName), this, 33);
            if (r4.bound == false) goto L9;
            r4.retryCount = 0;
        L11:
            return r4.bound;
        L9:
            Log.w(NotificationManagerCompat.TAG, "Unable to bind to listener " + r4.componentName);
            this.mContext.unbindService(this);
            goto L11
        }

        private void ensureServiceUnbound(ListenerRecord r2) {
            if (r2.bound == false) goto L5;
            this.mContext.unbindService(this);
            r2.bound = false;
        L5:
            r2.service = null;
        }

        private void scheduleListenerRetry(ListenerRecord r6) {
            if (this.mHandler.hasMessages(3, r6.componentName) == false) goto L5;
            return;
        L5:
            r6.retryCount++;
            if (r6.retryCount <= 6) goto L9;
            Log.w(NotificationManagerCompat.TAG, "Giving up on delivering " + r6.taskQueue.size() + " tasks to " + r6.componentName + " after " + r6.retryCount + " retries");
            r6.taskQueue.clear();
            return;
        L9:
            int r0 = (1 << (r6.retryCount - 1)) * 1000;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L12;
            Log.d(NotificationManagerCompat.TAG, "Scheduling retry for " + r0 + " ms");
        L12:
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, r6.componentName), r0);
        }

        private void processListenerQueue(ListenerRecord r6) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L6;
            Log.d(NotificationManagerCompat.TAG, "Processing component " + r6.componentName + ", " + r6.taskQueue.size() + " queued tasks");
        L6:
            if (r6.taskQueue.isEmpty() == false) goto L9;
            return;
        L9:
            if (ensureServiceBound(r6) == true) goto L11;
        L30:
            scheduleListenerRetry(r6);
            return;
        L11:
            if (r6.service == null) goto L30;
        L13:
            Task r2 = r6.taskQueue.peek();
            if (r2 == null) goto L27;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L19;
            Log.d(NotificationManagerCompat.TAG, "Sending task " + r2);     // Catch: RemoteException -> L21 DeadObjectException -> L23
        L19:
            r2.send(r6.service);     // Catch: RemoteException -> L21 DeadObjectException -> L23
            r6.taskQueue.remove();     // Catch: RemoteException -> L21 DeadObjectException -> L23
            goto L13
        L21:
            e = move-exception;
            Log.w(NotificationManagerCompat.TAG, "RemoteException communicating with " + r6.componentName, e);
        L24:
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L27;
            Log.d(NotificationManagerCompat.TAG, "Remote service has died: " + r6.componentName);
        L27:
            if (r6.taskQueue.isEmpty() == true) goto L37;
            scheduleListenerRetry(r6);
            return;
        }
    }

    private interface Task {
        void send(INotificationSideChannel r1) throws RemoteException;
    }

    static {
        sEnabledNotificationListenersLock = new Object();
        sEnabledNotificationListenerPackages = new HashSet();
        sLock = new Object();
    }

    public static NotificationManagerCompat from(Context r1) {
        return new NotificationManagerCompat(r1);
    }

    private NotificationManagerCompat(Context r2) {
        this.mContext = r2;
        this.mNotificationManager = (NotificationManager) r2.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
    }

    public void cancel(int r2) {
        cancel(null, r2);
    }

    public void cancel(String r1, int r2) {
        this.mNotificationManager.cancel(r1, r2);
    }

    public void cancelAll() {
        this.mNotificationManager.cancelAll();
    }

    public void notify(int r2, Notification r3) {
        notify(null, r2, r3);
    }

    public void notify(String r3, int r4, Notification r5) {
        if (useSideChannelForNotification(r5) == false) goto L5;
        pushSideChannelQueue(new NotifyTask(this.mContext.getPackageName(), r4, r3, r5));
        this.mNotificationManager.cancel(r3, r4);
        return;
    L5:
        this.mNotificationManager.notify(r3, r4, r5);
    }

    public boolean areNotificationsEnabled() {
        return this.mNotificationManager.areNotificationsEnabled();
    }

    public int getImportance() {
        return this.mNotificationManager.getImportance();
    }

    public void createNotificationChannel(NotificationChannel r1) {
        this.mNotificationManager.createNotificationChannel(r1);
    }

    public void createNotificationChannel(NotificationChannelCompat r1) {
        createNotificationChannel(r1.getNotificationChannel());
    }

    public void createNotificationChannelGroup(NotificationChannelGroup r1) {
        this.mNotificationManager.createNotificationChannelGroup(r1);
    }

    public void createNotificationChannelGroup(NotificationChannelGroupCompat r1) {
        createNotificationChannelGroup(r1.getNotificationChannelGroup());
    }

    public void createNotificationChannels(List<NotificationChannel> r1) {
        this.mNotificationManager.createNotificationChannels(r1);
    }

    public void createNotificationChannelsCompat(List<NotificationChannelCompat> r3) {
        if (r3.isEmpty() == true) goto L11;
        ArrayList r0 = new ArrayList(r3.size());
        Iterator<NotificationChannelCompat> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r0.add(r4.next().getNotificationChannel());
        goto L6
    L8:
        this.mNotificationManager.createNotificationChannels(r0);
        return;
    }

    public void createNotificationChannelGroups(List<NotificationChannelGroup> r1) {
        this.mNotificationManager.createNotificationChannelGroups(r1);
    }

    public void createNotificationChannelGroupsCompat(List<NotificationChannelGroupCompat> r3) {
        if (r3.isEmpty() == true) goto L11;
        ArrayList r0 = new ArrayList(r3.size());
        Iterator<NotificationChannelGroupCompat> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r0.add(r4.next().getNotificationChannelGroup());
        goto L6
    L8:
        this.mNotificationManager.createNotificationChannelGroups(r0);
        return;
    }

    public void deleteNotificationChannel(String r1) {
        this.mNotificationManager.deleteNotificationChannel(r1);
    }

    public void deleteNotificationChannelGroup(String r1) {
        this.mNotificationManager.deleteNotificationChannelGroup(r1);
    }

    public void deleteUnlistedNotificationChannels(Collection<String> r4) {
        Iterator<NotificationChannel> r0 = this.mNotificationManager.getNotificationChannels().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        NotificationChannel r1 = r0.next();
        if (r4.contains(r1.getId()) == true) goto L4;
        if (r4.contains(r1.getParentChannelId()) == true) goto L4;
        this.mNotificationManager.deleteNotificationChannel(r1.getId());
        goto L4
    }

    public NotificationChannel getNotificationChannel(String r1) {
        return this.mNotificationManager.getNotificationChannel(r1);
    }

    public NotificationChannelCompat getNotificationChannelCompat(String r1) {
        NotificationChannel r0 = getNotificationChannel(r1);
        if (r0 != null) goto L5;
        return null;
    L5:
        return new NotificationChannelCompat(r0);
    }

    public NotificationChannel getNotificationChannel(String r1, String r2) {
        return this.mNotificationManager.getNotificationChannel(r1, r2);
    }

    public NotificationChannelCompat getNotificationChannelCompat(String r1, String r2) {
        NotificationChannel r0 = getNotificationChannel(r1, r2);
        if (r0 != null) goto L5;
        return null;
    L5:
        return new NotificationChannelCompat(r0);
    }

    public NotificationChannelGroup getNotificationChannelGroup(String r1) {
        return this.mNotificationManager.getNotificationChannelGroup(r1);
    }

    public NotificationChannelGroupCompat getNotificationChannelGroupCompat(String r1) {
        NotificationChannelGroup r0 = getNotificationChannelGroup(r1);
        if (r0 != null) goto L5;
        return null;
    L5:
        return new NotificationChannelGroupCompat(r0);
    }

    public List<NotificationChannel> getNotificationChannels() {
        return this.mNotificationManager.getNotificationChannels();
    }

    public List<NotificationChannelCompat> getNotificationChannelsCompat() {
        List<NotificationChannel> r3 = getNotificationChannels();
        if (r3.isEmpty() == true) goto L10;
        ArrayList r0 = new ArrayList(r3.size());
        Iterator<NotificationChannel> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r0.add(new NotificationChannelCompat(r4.next()));
        goto L6
    L8:
        return r0;
    L10:
        return Collections.emptyList();
    }

    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        return this.mNotificationManager.getNotificationChannelGroups();
    }

    public List<NotificationChannelGroupCompat> getNotificationChannelGroupsCompat() {
        List<NotificationChannelGroup> r3 = getNotificationChannelGroups();
        if (r3.isEmpty() == true) goto L10;
        Collections.emptyList();
        ArrayList r0 = new ArrayList(r3.size());
        Iterator<NotificationChannelGroup> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r0.add(new NotificationChannelGroupCompat(r4.next()));
        goto L6
    L8:
        return r0;
    L10:
        return Collections.emptyList();
    }

    public static Set<String> getEnabledListenerPackages(Context r6) {
        String r7 = Settings.Secure.getString(r6.getContentResolver(), SETTING_ENABLED_NOTIFICATION_LISTENERS);
        Object r0 = sEnabledNotificationListenersLock;
        monitor-enter(r0);
        if (r7 != null) goto L20;
    L14:
        Set<String> r8 = sEnabledNotificationListenerPackages;     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return r8;
    L17:
        th = move-exception;
        throw th;
    L20:
        if (r7.equals(sEnabledNotificationListeners) == true) goto L14;
        String[] r1 = r7.split(":", -1);     // Catch: Throwable -> L17
        HashSet r2 = new HashSet(r1.length);     // Catch: Throwable -> L17
        int r3 = r1.length;     // Catch: Throwable -> L17
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L13;
        ComponentName r5 = ComponentName.unflattenFromString(r1[r4]);     // Catch: Throwable -> L17
        if (r5 == null) goto L12;
        r2.add(r5.getPackageName());     // Catch: Throwable -> L17
    L12:
        r4 = r4 + 1;     // Catch: Throwable -> L17
        goto L8
    L13:
        sEnabledNotificationListenerPackages = r2;     // Catch: Throwable -> L17
        sEnabledNotificationListeners = r7;     // Catch: Throwable -> L17
        goto L14
    }

    private static boolean useSideChannelForNotification(Notification r1) {
        Bundle r2 = NotificationCompat.getExtras(r1);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.getBoolean(EXTRA_USE_SIDE_CHANNEL) == false) goto L7;
        return true;
    }

    private void pushSideChannelQueue(Task r3) {
        Object r0 = sLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sSideChannelManager != null) goto L7;
        sSideChannelManager = new SideChannelManager(this.mContext.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        sSideChannelManager.queueTask(r3);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }
}
