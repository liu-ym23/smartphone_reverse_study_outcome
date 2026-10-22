package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SystemAlarmDispatcher implements ExecutionListener {
    private static final int DEFAULT_START_ID = 0;
    private static final String KEY_START_ID = "KEY_START_ID";
    private static final String PROCESS_COMMAND_TAG = "ProcessCommand";
    static final String TAG = null;
    final CommandHandler mCommandHandler;
    private CommandsCompletedListener mCompletedListener;
    final Context mContext;
    Intent mCurrentIntent;
    final List<Intent> mIntents;
    private final Processor mProcessor;
    private StartStopTokens mStartStopTokens;
    final TaskExecutor mTaskExecutor;
    private final WorkManagerImpl mWorkManager;
    private final WorkTimer mWorkTimer;

    static class AddRunnable implements Runnable {
        private final SystemAlarmDispatcher mDispatcher;
        private final Intent mIntent;
        private final int mStartId;

        AddRunnable(SystemAlarmDispatcher dispatcher, Intent intent, int startId) {
            this.mDispatcher = dispatcher;
            this.mIntent = intent;
            this.mStartId = startId;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mDispatcher.add(this.mIntent, this.mStartId);
        }
    }

    interface CommandsCompletedListener {
        void onAllCommandsCompleted();
    }

    static class DequeueAndCheckForCompletion implements Runnable {
        private final SystemAlarmDispatcher mDispatcher;

        DequeueAndCheckForCompletion(SystemAlarmDispatcher dispatcher) {
            this.mDispatcher = dispatcher;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mDispatcher.dequeueAndCheckForCompletion();
        }
    }

    static {
        TAG = Logger.tagWithPrefix("SystemAlarmDispatcher");
    }

    SystemAlarmDispatcher(Context context) {
        this(context, null, null);
    }

    SystemAlarmDispatcher(Context context, Processor processor, WorkManagerImpl workManager) {
        Context r0 = context.getApplicationContext();
        this.mContext = r0;
        this.mStartStopTokens = new StartStopTokens();
        this.mCommandHandler = new CommandHandler(r0, this.mStartStopTokens);
        if (workManager != null) goto L6;
        workManager = WorkManagerImpl.getInstance(context);
    L6:
        this.mWorkManager = workManager;
        this.mWorkTimer = new WorkTimer(workManager.getConfiguration().getRunnableScheduler());
        if (processor != null) goto L10;
        processor = workManager.getProcessor();
    L10:
        this.mProcessor = processor;
        this.mTaskExecutor = workManager.getWorkTaskExecutor();
        processor.addExecutionListener(this);
        this.mIntents = new ArrayList();
        this.mCurrentIntent = null;
    }

    void onDestroy() {
        Logger.get().debug(TAG, "Destroying SystemAlarmDispatcher");
        this.mProcessor.removeExecutionListener(this);
        this.mCompletedListener = null;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(WorkGenerationalId id, boolean needsReschedule) {
        this.mTaskExecutor.getMainThreadExecutor().execute(new AddRunnable(this, CommandHandler.createExecutionCompletedIntent(this.mContext, id, needsReschedule), 0));
    }

    public boolean add(final Intent intent, final int startId) {
        Logger r0 = Logger.get();
        String r1 = TAG;
        r0.debug(r1, "Adding command " + intent + " (" + startId + ")");
        assertMainThread();
        String r2 = intent.getAction();
        boolean r3 = false;
        if (TextUtils.isEmpty(r2) == false) goto L7;
        Logger.get().warning(r1, "Unknown command. Ignoring");
        return false;
    L7:
        if ("ACTION_CONSTRAINTS_CHANGED".equals(r2) == true) goto L9;
    L11:
        intent.putExtra(KEY_START_ID, startId);
        List<Intent> r6 = this.mIntents;
        monitor-enter(r6);
    L21:
        th = move-exception;
        throw th;
    L14:
        if (this.mIntents.isEmpty() == true) goto L16;
        r3 = true;
    L16:
        this.mIntents.add(intent);     // Catch: Throwable -> L21
        if (r3 == true) goto L19;
        processCommand();     // Catch: Throwable -> L21
    L19:
        monitor-exit(r6);     // Catch: Throwable -> L21
        return true;
    L9:
        if (hasIntentWithAction("ACTION_CONSTRAINTS_CHANGED") == false) goto L11;
        return false;
    }

    void setCompletedListener(CommandsCompletedListener listener) {
        if (this.mCompletedListener == null) goto L6;
        Logger.get().error(TAG, "A completion listener for SystemAlarmDispatcher already exists.");
        return;
    L6:
        this.mCompletedListener = listener;
    }

    Processor getProcessor() {
        return this.mProcessor;
    }

    WorkTimer getWorkTimer() {
        return this.mWorkTimer;
    }

    WorkManagerImpl getWorkManager() {
        return this.mWorkManager;
    }

    TaskExecutor getTaskExecutor() {
        return this.mTaskExecutor;
    }

    void dequeueAndCheckForCompletion() {
        Logger r1 = Logger.get();
        String r2 = TAG;
        r1.debug(r2, "Checking if commands are complete.");
        assertMainThread();
        List<Intent> r3 = this.mIntents;
        monitor-enter(r3);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentIntent == null) goto L11;
        Logger.get().debug(r2, "Removing command " + this.mCurrentIntent);     // Catch: Throwable -> L25
        if (this.mIntents.remove(0).equals(this.mCurrentIntent) == false) goto L10;
        this.mCurrentIntent = null;     // Catch: Throwable -> L25
        goto L11
    L10:
        throw new IllegalStateException("Dequeue-d command is not the first.");     // Catch: Throwable -> L25
    L11:
        SerialExecutor r0 = this.mTaskExecutor.getSerialTaskExecutor();     // Catch: Throwable -> L25
        if (this.mCommandHandler.hasPendingCommands() == true) goto L21;
        if (this.mIntents.isEmpty() == false) goto L21;
        if (r0.hasPendingTasks() == true) goto L21;
        Logger.get().debug(r2, "No more commands & intents.");     // Catch: Throwable -> L25
        CommandsCompletedListener r5 = this.mCompletedListener;     // Catch: Throwable -> L25
        if (r5 == null) goto L23;
        r5.onAllCommandsCompleted();     // Catch: Throwable -> L25
    L23:
        monitor-exit(r3);     // Catch: Throwable -> L25
        return;
    L21:
        if (this.mIntents.isEmpty() == true) goto L23;
        processCommand();     // Catch: Throwable -> L25
        goto L23
    }

    private void processCommand() {
        assertMainThread();
        PowerManager.WakeLock r0 = WakeLocks.newWakeLock(this.mContext, PROCESS_COMMAND_TAG);
        r0.acquire();     // Catch: Throwable -> L6
        this.mWorkManager.getWorkTaskExecutor().executeOnTaskThread(new AnonymousClass1(this));     // Catch: Throwable -> L6
        r0.release();
        return;
    L6:
        th = move-exception;
        r0.release();
        throw th;
    }

    private boolean hasIntentWithAction(String action) {
        assertMainThread();
        List<Intent> r0 = this.mIntents;
        monitor-enter(r0);
        Iterator<Intent> r2 = this.mIntents.iterator();     // Catch: Throwable -> L15
    L6:
        if (r2.hasNext() == false) goto L12;
        if (action.equals(r2.next().getAction()) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return true;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    private void assertMainThread() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L6;
        return;
    L6:
        throw new IllegalStateException("Needs to be invoked on the main thread.");
    }
}
