package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CommandHandler implements ExecutionListener {
    static final String ACTION_CONSTRAINTS_CHANGED = "ACTION_CONSTRAINTS_CHANGED";
    static final String ACTION_DELAY_MET = "ACTION_DELAY_MET";
    static final String ACTION_EXECUTION_COMPLETED = "ACTION_EXECUTION_COMPLETED";
    static final String ACTION_RESCHEDULE = "ACTION_RESCHEDULE";
    static final String ACTION_SCHEDULE_WORK = "ACTION_SCHEDULE_WORK";
    static final String ACTION_STOP_WORK = "ACTION_STOP_WORK";
    private static final String KEY_NEEDS_RESCHEDULE = "KEY_NEEDS_RESCHEDULE";
    private static final String KEY_WORKSPEC_GENERATION = "KEY_WORKSPEC_GENERATION";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";
    private static final String TAG = null;
    static final long WORK_PROCESSING_TIME_IN_MS = 600000;
    private final Context mContext;
    private final Object mLock;
    private final Map<WorkGenerationalId, DelayMetCommandHandler> mPendingDelayMet;
    private final StartStopTokens mStartStopTokens;

    static {
        TAG = Logger.tagWithPrefix("CommandHandler");
    }

    static Intent createScheduleWorkIntent(Context context, WorkGenerationalId id) {
        Intent r0 = new Intent(context, SystemAlarmService.class);
        r0.setAction(ACTION_SCHEDULE_WORK);
        return writeWorkGenerationalId(r0, id);
    }

    private static Intent writeWorkGenerationalId(Intent intent, WorkGenerationalId id) {
        intent.putExtra(KEY_WORKSPEC_ID, id.getWorkSpecId());
        intent.putExtra(KEY_WORKSPEC_GENERATION, id.getGeneration());
        return intent;
    }

    static WorkGenerationalId readWorkGenerationalId(Intent intent) {
        return new WorkGenerationalId(intent.getStringExtra(KEY_WORKSPEC_ID), intent.getIntExtra(KEY_WORKSPEC_GENERATION, 0));
    }

    static Intent createDelayMetIntent(Context context, WorkGenerationalId id) {
        Intent r0 = new Intent(context, SystemAlarmService.class);
        r0.setAction(ACTION_DELAY_MET);
        return writeWorkGenerationalId(r0, id);
    }

    static Intent createStopWorkIntent(Context context, String workSpecId) {
        Intent r0 = new Intent(context, SystemAlarmService.class);
        r0.setAction(ACTION_STOP_WORK);
        r0.putExtra(KEY_WORKSPEC_ID, workSpecId);
        return r0;
    }

    static Intent createStopWorkIntent(Context context, WorkGenerationalId id) {
        Intent r0 = new Intent(context, SystemAlarmService.class);
        r0.setAction(ACTION_STOP_WORK);
        return writeWorkGenerationalId(r0, id);
    }

    static Intent createConstraintsChangedIntent(Context context) {
        Intent r0 = new Intent(context, SystemAlarmService.class);
        r0.setAction(ACTION_CONSTRAINTS_CHANGED);
        return r0;
    }

    static Intent createRescheduleIntent(Context context) {
        Intent r0 = new Intent(context, SystemAlarmService.class);
        r0.setAction(ACTION_RESCHEDULE);
        return r0;
    }

    static Intent createExecutionCompletedIntent(Context context, WorkGenerationalId id, boolean needsReschedule) {
        Intent r0 = new Intent(context, SystemAlarmService.class);
        r0.setAction(ACTION_EXECUTION_COMPLETED);
        r0.putExtra(KEY_NEEDS_RESCHEDULE, needsReschedule);
        return writeWorkGenerationalId(r0, id);
    }

    CommandHandler(Context context, StartStopTokens startStopTokens) {
        this.mContext = context;
        this.mStartStopTokens = startStopTokens;
        this.mPendingDelayMet = new HashMap();
        this.mLock = new Object();
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(WorkGenerationalId id, boolean needsReschedule) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DelayMetCommandHandler r1 = this.mPendingDelayMet.remove(id);     // Catch: Throwable -> L9
        this.mStartStopTokens.remove(id);     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.onExecuted(needsReschedule);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    boolean hasPendingCommands() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingDelayMet.isEmpty() == true) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    void onHandleIntent(Intent intent, int startId, SystemAlarmDispatcher dispatcher) {
        String r0 = intent.getAction();
        if (ACTION_CONSTRAINTS_CHANGED.equals(r0) == false) goto L6;
        handleConstraintsChanged(intent, startId, dispatcher);
        return;
    L6:
        if (ACTION_RESCHEDULE.equals(r0) == false) goto L9;
        handleReschedule(intent, startId, dispatcher);
        return;
    L9:
        if (hasKeys(intent.getExtras(), new String[]{KEY_WORKSPEC_ID}) == true) goto L12;
        Logger.get().error(TAG, "Invalid request for " + r0 + " , requires KEY_WORKSPEC_ID .");
        return;
    L12:
        if (ACTION_SCHEDULE_WORK.equals(r0) == false) goto L15;
        handleScheduleWorkIntent(intent, startId, dispatcher);
        return;
    L15:
        if (ACTION_DELAY_MET.equals(r0) == false) goto L18;
        handleDelayMet(intent, startId, dispatcher);
        return;
    L18:
        if (ACTION_STOP_WORK.equals(r0) == false) goto L21;
        handleStopWork(intent, dispatcher);
        return;
    L21:
        if (ACTION_EXECUTION_COMPLETED.equals(r0) == false) goto L23;
        handleExecutionCompleted(intent, startId);
        return;
    L23:
        Logger.get().warning(TAG, "Ignoring intent " + intent);
    }

    private void handleScheduleWorkIntent(Intent intent, int startId, SystemAlarmDispatcher dispatcher) {
        WorkGenerationalId r9 = readWorkGenerationalId(intent);
        Logger r2 = Logger.get();
        String r3 = TAG;
        r2.debug(r3, "Handling schedule work for " + r9);
        WorkDatabase r4 = dispatcher.getWorkManager().getWorkDatabase();
        r4.beginTransaction();
        WorkSpec r5 = r4.workSpecDao().getWorkSpec(r9.getWorkSpecId());     // Catch: Throwable -> L22
        if (r5 != null) goto L10;
        Logger.get().warning(r3, "Skipping scheduling " + r9 + " because it's no longer in the DB");     // Catch: Throwable -> L22
        r4.endTransaction();
        return;
    L10:
        if (r5.state.isFinished() == false) goto L14;
        Logger.get().warning(r3, "Skipping scheduling " + r9 + "because it is finished.");     // Catch: Throwable -> L22
        r4.endTransaction();
        return;
    L14:
        long r6 = r5.calculateNextRunTime();     // Catch: Throwable -> L22
        if (r5.hasConstraints() == true) goto L18;
        Logger.get().debug(r3, "Setting up Alarms for " + r9 + "at " + r6);     // Catch: Throwable -> L22
        Alarms.setAlarm(this.mContext, r4, r9, r6);     // Catch: Throwable -> L22
    L19:
        r4.setTransactionSuccessful();     // Catch: Throwable -> L22
        r4.endTransaction();
        return;
    L18:
        Logger.get().debug(r3, "Opportunistically setting an alarm for " + r9 + "at " + r6);     // Catch: Throwable -> L22
        Alarms.setAlarm(this.mContext, r4, r9, r6);     // Catch: Throwable -> L22
        dispatcher.getTaskExecutor().getMainThreadExecutor().execute(new SystemAlarmDispatcher.AddRunnable(dispatcher, createConstraintsChangedIntent(this.mContext), startId));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r4.endTransaction();
        throw th;
    }

    private void handleDelayMet(Intent intent, int startId, SystemAlarmDispatcher dispatcher) {
        Object r2 = this.mLock;
        monitor-enter(r2);
        WorkGenerationalId r7 = readWorkGenerationalId(intent);     // Catch: Throwable -> L10
        Logger r3 = Logger.get();     // Catch: Throwable -> L10
        String r4 = TAG;     // Catch: Throwable -> L10
        r3.debug(r4, "Handing delay met for " + r7);     // Catch: Throwable -> L10
        if (this.mPendingDelayMet.containsKey(r7) == true) goto L7;
        DelayMetCommandHandler r0 = new DelayMetCommandHandler(this.mContext, startId, dispatcher, this.mStartStopTokens.tokenFor(r7));     // Catch: Throwable -> L10
        this.mPendingDelayMet.put(r7, r0);     // Catch: Throwable -> L10
        r0.handleProcessWork();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r2);     // Catch: Throwable -> L10
        return;
    L7:
        Logger.get().debug(r4, "WorkSpec " + r7 + " is is already being handled for ACTION_DELAY_MET");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private void handleStopWork(Intent intent, SystemAlarmDispatcher dispatcher) {
        Bundle r7 = intent.getExtras();
        String r0 = r7.getString(KEY_WORKSPEC_ID);
        if (r7.containsKey(KEY_WORKSPEC_GENERATION) == false) goto L7;
        int r8 = r7.getInt(KEY_WORKSPEC_GENERATION);
        List<StartStopToken> r1 = new ArrayList(1);
        StartStopToken r9 = this.mStartStopTokens.remove(new WorkGenerationalId(r0, r8));
        if (r9 == null) goto L8;
        r1.add(r9);
    L8:
        Iterator<StartStopToken> r10 = r1.iterator();
    L10:
        if (r10.hasNext() == false) goto L12;
        StartStopToken r2 = r10.next();
        Logger.get().debug(TAG, "Handing stopWork work for " + r0);
        dispatcher.getWorkManager().stopWork(r2);
        Alarms.cancelAlarm(this.mContext, dispatcher.getWorkManager().getWorkDatabase(), r2.getId());
        dispatcher.onExecuted(r2.getId(), false);
        goto L10
    L12:
        return;
    L7:
        r1 = this.mStartStopTokens.remove(r0);
        goto L8
    }

    private void handleConstraintsChanged(Intent intent, int startId, SystemAlarmDispatcher dispatcher) {
        Logger.get().debug(TAG, "Handling constraints changed " + intent);
        new ConstraintsCommandHandler(this.mContext, startId, dispatcher).handleConstraintsChanged();
    }

    private void handleReschedule(Intent intent, int startId, SystemAlarmDispatcher dispatcher) {
        Logger.get().debug(TAG, "Handling reschedule " + intent + ", " + startId);
        dispatcher.getWorkManager().rescheduleEligibleWork();
    }

    private void handleExecutionCompleted(Intent intent, int startId) {
        WorkGenerationalId r0 = readWorkGenerationalId(intent);
        boolean r1 = intent.getExtras().getBoolean(KEY_NEEDS_RESCHEDULE);
        Logger.get().debug(TAG, "Handling onExecutionCompleted " + intent + ", " + startId);
        onExecuted(r0, r1);
    }

    private static boolean hasKeys(Bundle bundle, String... keys) {
        if (bundle != null) goto L5;
    L15:
        return false;
    L5:
        if (bundle.isEmpty() == true) goto L15;
        int r1 = keys.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L13;
        if (bundle.get(keys[r2]) == null) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    }
}
