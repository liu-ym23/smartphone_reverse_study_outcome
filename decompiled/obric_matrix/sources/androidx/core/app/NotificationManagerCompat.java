package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
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

    @GuardedBy("sEnabledNotificationListenersLock")
    private static Set<String> sEnabledNotificationListenerPackages;

    @GuardedBy("sEnabledNotificationListenersLock")
    private static String sEnabledNotificationListeners;
    private static final Object sEnabledNotificationListenersLock = null;
    private static final Object sLock = null;

    @GuardedBy("sLock")
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
        public void send(android.support.v4.app.a r3) {
            if (this.all == false) goto L5;
            r3.cancelAll(this.packageName);
            return;
        L5:
            r3.cancel(this.packageName, this.id, this.tag);
        }

        @NonNull
        public String toString() {
            return "CancelTask[packageName:" + this.packageName + ", id:" + this.id + ", tag:" + this.tag + ", all:" + this.all + "]";
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
        public void send(android.support.v4.app.a r4) {
            r4.notify(this.packageName, this.id, this.tag, this.notif);
        }

        @NonNull
        public String toString() {
            return "NotifyTask[packageName:" + this.packageName + ", id:" + this.id + ", tag:" + this.tag + "]";
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
            android.support.v4.app.a service;
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

        private boolean ensureServiceBound(ListenerRecord r4) {
            if (r4.bound == false) goto L6;
            return true;
        L6:
            boolean r0 = this.mContext.bindService(new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(r4.componentName), this, 33);
            r4.bound = r0;
            if (r0 == false) goto L9;
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

        private void handleRetryListenerQueue(ComponentName r2) {
            ListenerRecord r3 = this.mRecordMap.get(r2);
            if (r3 == null) goto L6;
            processListenerQueue(r3);
            return;
        }

        private void handleServiceConnected(ComponentName r2, IBinder r3) {
            ListenerRecord r4 = this.mRecordMap.get(r2);
            if (r4 == null) goto L6;
            r4.service = android.support.v4.app.a.AbstractBinderC0004a.asInterface(r3);
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

        private void scheduleListenerRetry(ListenerRecord r6) {
            if (this.mHandler.hasMessages(3, r6.componentName) == false) goto L5;
            return;
        L5:
            int r0 = r6.retryCount + 1;
            r6.retryCount = r0;
            if (r0 <= 6) goto L9;
            Log.w(NotificationManagerCompat.TAG, "Giving up on delivering " + r6.taskQueue.size() + " tasks to " + r6.componentName + " after " + r6.retryCount + " retries");
            r6.taskQueue.clear();
            return;
        L9:
            int r1 = (1 << (r0 - 1)) * 1000;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L12;
            Log.d(NotificationManagerCompat.TAG, "Scheduling retry for " + r1 + " ms");
        L12:
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, r6.componentName), r1);
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
            ServiceInfo r6 = r4.serviceInfo;
            ComponentName r5 = new ComponentName(r6.packageName, r6.name);
            if (r4.serviceInfo.permission != null) goto L13;
            r2.add(r5);
            goto L7
        L13:
            Log.w(NotificationManagerCompat.TAG, "Permission present on component " + r5 + ", not adding listener record.");
            goto L7
        L15:
            Iterator r7 = r2.iterator();
        L17:
            if (r7.hasNext() == false) goto L24;
            ComponentName r8 = (ComponentName) r7.next();
            if (this.mRecordMap.containsKey(r8) == true) goto L17;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L23;
            Log.d(NotificationManagerCompat.TAG, "Adding listener record for " + r8);
        L23:
            this.mRecordMap.put(r8, new ListenerRecord(r8));
            goto L17
        L24:
            Iterator<Map.Entry<ComponentName, ListenerRecord>> r9 = this.mRecordMap.entrySet().iterator();
        L26:
            if (r9.hasNext() == false) goto L33;
            Map.Entry<ComponentName, ListenerRecord> r10 = r9.next();
            if (r2.contains(r10.getKey()) == true) goto L26;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L32;
            Log.d(NotificationManagerCompat.TAG, "Removing listener record for " + r10.getKey());
        L32:
            ensureServiceUnbound(r10.getValue());
            r9.remove();
            goto L26
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

        public void queueTask(Task r2) {
            this.mHandler.obtainMessage(0, r2).sendToTarget();
        }
    }

    private interface Task {
        void send(android.support.v4.app.a r1);
    }

    static {
        sEnabledNotificationListenersLock = new Object();
        sEnabledNotificationListenerPackages = new HashSet();
        sLock = new Object();
    }

    private NotificationManagerCompat(Context r2) {
        this.mContext = r2;
        this.mNotificationManager = (NotificationManager) r2.getSystemService("notification");
    }

    @NonNull
    public static NotificationManagerCompat from(@NonNull Context r1) {
        return new NotificationManagerCompat(r1);
    }

    @NonNull
    public static Set<String> getEnabledListenerPackages(@NonNull Context r6) {
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

    private static boolean useSideChannelForNotification(Notification r1) {
        Bundle r2 = NotificationCompat.getExtras(r1);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.getBoolean(EXTRA_USE_SIDE_CHANNEL) == false) goto L7;
        return true;
    }

    public boolean areNotificationsEnabled() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 24) goto L7;
        return this.mNotificationManager.areNotificationsEnabled();
    L7:
        if (r0 < 19) goto L17;
        AppOpsManager r1 = (AppOpsManager) this.mContext.getSystemService("appops");
        ApplicationInfo r2 = this.mContext.getApplicationInfo();
        String r10 = this.mContext.getApplicationContext().getPackageName();
        int r3 = r2.uid;
        Class<?> r4 = Class.forName(AppOpsManager.class.getName());     // Catch: Throwable -> L14
        Class<?> r7 = Integer.TYPE;     // Catch: Throwable -> L14
        if (((Integer) r4.getMethod(CHECK_OP_NO_THROW, new Class[]{r7, r7, String.class}).invoke(r1, new Object[]{Integer.valueOf(((Integer) r4.getDeclaredField(OP_POST_NOTIFICATION).get(Integer.class)).intValue()), Integer.valueOf(r3), r10})).intValue() != 0) goto L13;
        return true;
    L13:
        return false;
    L19:
        return true;
    L17:
        return true;
    }

    public void cancel(int r2) {
        cancel(null, r2);
    }

    public void cancel(@Nullable String r3, int r4) {
        this.mNotificationManager.cancel(r3, r4);
        if (Build.VERSION.SDK_INT > 19) goto L6;
        pushSideChannelQueue(new CancelTask(this.mContext.getPackageName(), r4, r3));
        return;
    }

    public void cancelAll() {
        this.mNotificationManager.cancelAll();
        if (Build.VERSION.SDK_INT > 19) goto L6;
        pushSideChannelQueue(new CancelTask(this.mContext.getPackageName()));
        return;
    }

    public void createNotificationChannel(@NonNull NotificationChannel r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        this.mNotificationManager.createNotificationChannel(r3);
        return;
    }

    public void createNotificationChannel(@NonNull NotificationChannelCompat r1) {
        createNotificationChannel(r1.getNotificationChannel());
    }

    public void createNotificationChannelGroup(@NonNull NotificationChannelGroup r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        this.mNotificationManager.createNotificationChannelGroup(r3);
        return;
    }

    public void createNotificationChannelGroup(@NonNull NotificationChannelGroupCompat r1) {
        createNotificationChannelGroup(r1.getNotificationChannelGroup());
    }

    public void createNotificationChannelGroups(@NonNull List<NotificationChannelGroup> r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        this.mNotificationManager.createNotificationChannelGroups(r3);
        return;
    }

    public void createNotificationChannelGroupsCompat(@NonNull List<NotificationChannelGroupCompat> r3) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L14;
        ArrayList r0 = new ArrayList(r3.size());
        Iterator<NotificationChannelGroupCompat> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r0.add(r4.next().getNotificationChannelGroup());
        goto L8
    L10:
        this.mNotificationManager.createNotificationChannelGroups(r0);
        return;
    }

    public void createNotificationChannels(@NonNull List<NotificationChannel> r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        this.mNotificationManager.createNotificationChannels(r3);
        return;
    }

    public void createNotificationChannelsCompat(@NonNull List<NotificationChannelCompat> r3) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L14;
        ArrayList r0 = new ArrayList(r3.size());
        Iterator<NotificationChannelCompat> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r0.add(r4.next().getNotificationChannel());
        goto L8
    L10:
        this.mNotificationManager.createNotificationChannels(r0);
        return;
    }

    public void deleteNotificationChannel(@NonNull String r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        this.mNotificationManager.deleteNotificationChannel(r3);
        return;
    }

    public void deleteNotificationChannelGroup(@NonNull String r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        this.mNotificationManager.deleteNotificationChannelGroup(r3);
        return;
    }

    public void deleteUnlistedNotificationChannels(@NonNull Collection<String> r5) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 26) goto L16;
        Iterator<NotificationChannel> r1 = this.mNotificationManager.getNotificationChannels().iterator();
    L6:
        if (r1.hasNext() == false) goto L25;
        NotificationChannel r2 = r1.next();
        if (r5.contains(r2.getId()) == true) goto L6;
        if (r0 < 30) goto L15;
        if (r5.contains(r2.getParentChannelId()) == true) goto L6;
    L15:
        this.mNotificationManager.deleteNotificationChannel(r2.getId());
        goto L6
    L25:
        return;
    }

    public int getImportance() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return -1000;
    L5:
        return this.mNotificationManager.getImportance();
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String r3) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return this.mNotificationManager.getNotificationChannel(r3);
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String r3, @NonNull String r4) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return this.mNotificationManager.getNotificationChannel(r3, r4);
    L7:
        return getNotificationChannel(r3);
    }

    @Nullable
    public NotificationChannelCompat getNotificationChannelCompat(@NonNull String r3) {
        if (Build.VERSION.SDK_INT < 26) goto L8;
        NotificationChannel r2 = getNotificationChannel(r3);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new NotificationChannelCompat(r2);
    L8:
        return null;
    }

    @Nullable
    public NotificationChannelCompat getNotificationChannelCompat(@NonNull String r3, @NonNull String r4) {
        if (Build.VERSION.SDK_INT < 26) goto L8;
        NotificationChannel r2 = getNotificationChannel(r3, r4);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new NotificationChannelCompat(r2);
    L8:
        return null;
    }

    @Nullable
    public NotificationChannelGroup getNotificationChannelGroup(@NonNull String r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L7;
        return this.mNotificationManager.getNotificationChannelGroup(r4);
    L7:
        if (r0 < 26) goto L14;
        Iterator<NotificationChannelGroup> r3 = getNotificationChannelGroups().iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        NotificationChannelGroup r1 = r3.next();
        if (r1.getId().equals(r4) == false) goto L10;
        return r1;
    L14:
        return null;
    }

    @Nullable
    public NotificationChannelGroupCompat getNotificationChannelGroupCompat(@NonNull String r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L9;
        NotificationChannelGroup r2 = getNotificationChannelGroup(r3);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new NotificationChannelGroupCompat(r2);
    L9:
        if (r0 < 26) goto L16;
        NotificationChannelGroup r4 = getNotificationChannelGroup(r3);
        if (r4 != null) goto L13;
        return null;
    L13:
        return new NotificationChannelGroupCompat(r4, getNotificationChannels());
    L16:
        return null;
    }

    @NonNull
    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return this.mNotificationManager.getNotificationChannelGroups();
    L7:
        return Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannelGroupCompat> getNotificationChannelGroupsCompat() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 26) goto L20;
        List<NotificationChannelGroup> r1 = getNotificationChannelGroups();
        if (r1.isEmpty() == true) goto L20;
        if (r0 < 28) goto L9;
        List<NotificationChannel> r6 = Collections.emptyList();
    L10:
        ArrayList r3 = new ArrayList(r1.size());
        Iterator<NotificationChannelGroup> r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L18;
        NotificationChannelGroup r4 = r2.next();
        if (r0 < 28) goto L16;
        NotificationChannelGroupCompat r5 = new NotificationChannelGroupCompat(r4);
    L17:
        r3.add(r5);
        goto L12
    L16:
        r5 = new NotificationChannelGroupCompat(r4, r6);
        goto L17
    L18:
        return r3;
    L9:
        r6 = getNotificationChannels();
    L20:
        return Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannel> getNotificationChannels() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return this.mNotificationManager.getNotificationChannels();
    L7:
        return Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannelCompat> getNotificationChannelsCompat() {
        if (Build.VERSION.SDK_INT < 26) goto L12;
        List<NotificationChannel> r3 = getNotificationChannels();
        if (r3.isEmpty() == true) goto L12;
        ArrayList r0 = new ArrayList(r3.size());
        Iterator<NotificationChannel> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r0.add(new NotificationChannelCompat(r4.next()));
        goto L8
    L10:
        return r0;
    L12:
        return Collections.emptyList();
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void notify(int r2, @NonNull Notification r3) {
        notify(null, r2, r3);
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void notify(@Nullable String r3, int r4, @NonNull Notification r5) {
        if (useSideChannelForNotification(r5) == false) goto L5;
        pushSideChannelQueue(new NotifyTask(this.mContext.getPackageName(), r4, r3, r5));
        this.mNotificationManager.cancel(r3, r4);
        return;
    L5:
        this.mNotificationManager.notify(r3, r4, r5);
    }
}
