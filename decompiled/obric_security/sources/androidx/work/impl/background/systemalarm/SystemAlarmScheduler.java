package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;

/* JADX INFO: loaded from: classes.dex */
public class SystemAlarmScheduler implements Scheduler {
    private static final String TAG = null;
    private final Context mContext;

    @Override // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    static {
        TAG = Logger.tagWithPrefix("SystemAlarmScheduler");
    }

    public SystemAlarmScheduler(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // androidx.work.impl.Scheduler
    public void schedule(WorkSpec... workSpecs) {
        int r0 = workSpecs.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        scheduleWorkSpec(workSpecs[r1]);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(String workSpecId) {
        Intent r2 = CommandHandler.createStopWorkIntent(this.mContext, workSpecId);
        this.mContext.startService(r2);
    }

    private void scheduleWorkSpec(WorkSpec workSpec) {
        Logger.get().debug(TAG, "Scheduling work with workSpecId " + workSpec.id);
        this.mContext.startService(CommandHandler.createScheduleWorkIntent(this.mContext, WorkSpecKt.generationalId(workSpec)));
    }
}
