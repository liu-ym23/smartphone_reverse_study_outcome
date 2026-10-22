package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class SystemForegroundDispatcher implements WorkConstraintsCallback, ExecutionListener {
    private static final String ACTION_CANCEL_WORK = "ACTION_CANCEL_WORK";
    private static final String ACTION_NOTIFY = "ACTION_NOTIFY";
    private static final String ACTION_START_FOREGROUND = "ACTION_START_FOREGROUND";
    private static final String ACTION_STOP_FOREGROUND = "ACTION_STOP_FOREGROUND";
    private static final String KEY_FOREGROUND_SERVICE_TYPE = "KEY_FOREGROUND_SERVICE_TYPE";
    private static final String KEY_GENERATION = "KEY_GENERATION";
    private static final String KEY_NOTIFICATION = "KEY_NOTIFICATION";
    private static final String KEY_NOTIFICATION_ID = "KEY_NOTIFICATION_ID";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";
    static final String TAG = null;
    private Callback mCallback;
    final WorkConstraintsTracker mConstraintsTracker;
    private Context mContext;
    WorkGenerationalId mCurrentForegroundId;
    final Map<WorkGenerationalId, ForegroundInfo> mForegroundInfoById;
    final Object mLock;
    private final TaskExecutor mTaskExecutor;
    final Set<WorkSpec> mTrackedWorkSpecs;
    private WorkManagerImpl mWorkManagerImpl;
    final Map<WorkGenerationalId, WorkSpec> mWorkSpecById;

    interface Callback {
        void cancelNotification(int notificationId);

        void notify(int notificationId, Notification notification);

        void startForeground(int notificationId, int notificationType, Notification notification);

        void stop();
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(List<WorkSpec> workSpecs) {
    }

    static /* synthetic */ WorkManagerImpl access$000(SystemForegroundDispatcher r0) {
        return r0.mWorkManagerImpl;
    }

    static {
        TAG = Logger.tagWithPrefix("SystemFgDispatcher");
    }

    SystemForegroundDispatcher(Context context) {
        this.mContext = context;
        this.mLock = new Object();
        WorkManagerImpl r2 = WorkManagerImpl.getInstance(this.mContext);
        this.mWorkManagerImpl = r2;
        this.mTaskExecutor = r2.getWorkTaskExecutor();
        this.mCurrentForegroundId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashSet();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = new WorkConstraintsTrackerImpl(this.mWorkManagerImpl.getTrackers(), this);
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
    }

    SystemForegroundDispatcher(Context context, WorkManagerImpl workManagerImpl, WorkConstraintsTracker tracker) {
        this.mContext = context;
        this.mLock = new Object();
        this.mWorkManagerImpl = workManagerImpl;
        this.mTaskExecutor = workManagerImpl.getWorkTaskExecutor();
        this.mCurrentForegroundId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashSet();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = tracker;
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(WorkGenerationalId id, boolean needsReschedule) {
        Object r7 = this.mLock;
        monitor-enter(r7);
        WorkSpec r0 = this.mWorkSpecById.remove(id);     // Catch: Throwable -> L27
        if (r0 == null) goto L7;
        boolean r1 = this.mTrackedWorkSpecs.remove(r0);     // Catch: Throwable -> L27
    L8:
        if (r1 == false) goto L10;
        this.mConstraintsTracker.replace(this.mTrackedWorkSpecs);     // Catch: Throwable -> L27
    L10:
        monitor-exit(r7);     // Catch: Throwable -> L27
        ForegroundInfo r8 = this.mForegroundInfoById.remove(id);
        if (id.equals(this.mCurrentForegroundId) == true) goto L14;
    L22:
        Callback r5 = this.mCallback;
        if (r8 == null) goto L33;
        if (r5 == null) goto L34;
        Logger.get().debug(TAG, "Removing Notification (id: " + r8.getNotificationId() + ", workSpecId: " + id + ", notificationType: " + r8.getForegroundServiceType());
        r5.cancelNotification(r8.getNotificationId());
        return;
    L34:
        return;
    L33:
        return;
    L14:
        if (this.mForegroundInfoById.size() <= 0) goto L22;
        Iterator<Map.Entry<WorkGenerationalId, ForegroundInfo>> r2 = this.mForegroundInfoById.entrySet().iterator();
        Map.Entry<WorkGenerationalId, ForegroundInfo> r3 = r2.next();
    L16:
        Map.Entry<WorkGenerationalId, ForegroundInfo> r4 = r3;
        if (r2.hasNext() == false) goto L19;
        r3 = r2.next();
        goto L16
    L19:
        this.mCurrentForegroundId = r4.getKey();
        if (this.mCallback == null) goto L22;
        ForegroundInfo r6 = r4.getValue();
        this.mCallback.startForeground(r6.getNotificationId(), r6.getForegroundServiceType(), r6.getNotification());
        this.mCallback.cancelNotification(r6.getNotificationId());
        goto L22
    L7:
        r1 = false;
    L27:
        th = move-exception;
        throw th;
    }

    void setCallback(Callback callback) {
        if (this.mCallback == null) goto L6;
        Logger.get().error(TAG, "A callback already exists.");
        return;
    L6:
        this.mCallback = callback;
    }

    void onStartCommand(Intent intent) {
        String r0 = intent.getAction();
        if (ACTION_START_FOREGROUND.equals(r0) == false) goto L6;
        handleStartForeground(intent);
        handleNotify(intent);
        return;
    L6:
        if (ACTION_NOTIFY.equals(r0) == false) goto L9;
        handleNotify(intent);
        return;
    L9:
        if (ACTION_CANCEL_WORK.equals(r0) == false) goto L12;
        handleCancelWork(intent);
        return;
    L12:
        if (ACTION_STOP_FOREGROUND.equals(r0) == false) goto L18;
        handleStop(intent);
        return;
    }

    void onDestroy() {
        this.mCallback = null;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mConstraintsTracker.reset();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mWorkManagerImpl.getProcessor().removeExecutionListener(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void handleStartForeground(Intent intent) {
        Logger.get().info(TAG, "Started foreground service " + intent);
        final String r5 = intent.getStringExtra(KEY_WORKSPEC_ID);
        this.mTaskExecutor.executeOnTaskThread(new AnonymousClass1(this, r5));
    }

    private void handleNotify(Intent intent) {
        int r1 = 0;
        int r0 = intent.getIntExtra(KEY_NOTIFICATION_ID, 0);
        int r2 = intent.getIntExtra(KEY_FOREGROUND_SERVICE_TYPE, 0);
        String r3 = intent.getStringExtra(KEY_WORKSPEC_ID);
        WorkGenerationalId r5 = new WorkGenerationalId(r3, intent.getIntExtra(KEY_GENERATION, 0));
        Notification r10 = (Notification) intent.getParcelableExtra(KEY_NOTIFICATION);
        Logger.get().debug(TAG, "Notifying with (id:" + r0 + ", workSpecId: " + r3 + ", notificationType :" + r2 + ")");
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mCallback == null) goto L21;
        this.mForegroundInfoById.put(r5, new ForegroundInfo(r0, r10, r2));
        if (this.mCurrentForegroundId != null) goto L9;
        this.mCurrentForegroundId = r5;
        this.mCallback.startForeground(r0, r2, r10);
        return;
    L9:
        this.mCallback.notify(r0, r10);
        if (r2 == 0) goto L23;
        Iterator<Map.Entry<WorkGenerationalId, ForegroundInfo>> r11 = this.mForegroundInfoById.entrySet().iterator();
    L13:
        if (r11.hasNext() == false) goto L15;
        r1 = r1 | r11.next().getValue().getForegroundServiceType();
        goto L13
    L15:
        ForegroundInfo r12 = this.mForegroundInfoById.get(this.mCurrentForegroundId);
        if (r12 == null) goto L24;
        this.mCallback.startForeground(r12.getNotificationId(), r1, r12.getNotification());
        return;
    L24:
        return;
    L23:
        return;
    }

    void handleStop(Intent intent) {
        Logger.get().info(TAG, "Stopping foreground service");
        Callback r2 = this.mCallback;
        if (r2 == null) goto L6;
        r2.stop();
        return;
    }

    private void handleCancelWork(Intent intent) {
        Logger.get().info(TAG, "Stopping foreground work for " + intent);
        String r5 = intent.getStringExtra(KEY_WORKSPEC_ID);
        if (r5 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L9;
        this.mWorkManagerImpl.cancelWorkById(UUID.fromString(r5));
        return;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(List<WorkSpec> workSpecs) {
        if (workSpecs.isEmpty() == true) goto L8;
        Iterator<WorkSpec> r7 = workSpecs.iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        WorkSpec r0 = r7.next();
        Logger.get().debug(TAG, "Constraints unmet for WorkSpec " + r0.id);
        this.mWorkManagerImpl.stopForegroundWork(WorkSpecKt.generationalId(r0));
        goto L6
    L10:
        return;
    }

    public static Intent createStartForegroundIntent(Context context, WorkGenerationalId id, ForegroundInfo info) {
        Intent r0 = new Intent(context, SystemForegroundService.class);
        r0.setAction(ACTION_START_FOREGROUND);
        r0.putExtra(KEY_WORKSPEC_ID, id.getWorkSpecId());
        r0.putExtra(KEY_GENERATION, id.getGeneration());
        r0.putExtra(KEY_NOTIFICATION_ID, info.getNotificationId());
        r0.putExtra(KEY_FOREGROUND_SERVICE_TYPE, info.getForegroundServiceType());
        r0.putExtra(KEY_NOTIFICATION, info.getNotification());
        return r0;
    }

    public static Intent createCancelWorkIntent(Context context, String workSpecId) {
        Intent r0 = new Intent(context, SystemForegroundService.class);
        r0.setAction(ACTION_CANCEL_WORK);
        r0.setData(Uri.parse("workspec://" + workSpecId));
        r0.putExtra(KEY_WORKSPEC_ID, workSpecId);
        return r0;
    }

    public static Intent createNotifyIntent(Context context, WorkGenerationalId id, ForegroundInfo info) {
        Intent r0 = new Intent(context, SystemForegroundService.class);
        r0.setAction(ACTION_NOTIFY);
        r0.putExtra(KEY_NOTIFICATION_ID, info.getNotificationId());
        r0.putExtra(KEY_FOREGROUND_SERVICE_TYPE, info.getForegroundServiceType());
        r0.putExtra(KEY_NOTIFICATION, info.getNotification());
        r0.putExtra(KEY_WORKSPEC_ID, id.getWorkSpecId());
        r0.putExtra(KEY_GENERATION, id.getGeneration());
        return r0;
    }

    public static Intent createStopForegroundIntent(Context context) {
        Intent r0 = new Intent(context, SystemForegroundService.class);
        r0.setAction(ACTION_STOP_FOREGROUND);
        return r0;
    }
}
