package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.constraints.WorkConstraintsTrackerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class ConstraintsCommandHandler {
    private static final String TAG = null;
    private final Context mContext;
    private final SystemAlarmDispatcher mDispatcher;
    private final int mStartId;
    private final WorkConstraintsTrackerImpl mWorkConstraintsTracker;

    static {
        TAG = Logger.tagWithPrefix("ConstraintsCmdHandler");
    }

    ConstraintsCommandHandler(Context context, int startId, SystemAlarmDispatcher dispatcher) {
        this.mContext = context;
        this.mStartId = startId;
        this.mDispatcher = dispatcher;
        this.mWorkConstraintsTracker = new WorkConstraintsTrackerImpl(dispatcher.getWorkManager().getTrackers(), null);
    }

    void handleConstraintsChanged() {
        List<WorkSpec> r0 = this.mDispatcher.getWorkManager().getWorkDatabase().workSpecDao().getScheduledWork();
        ConstraintProxy.updateAll(this.mContext, r0);
        this.mWorkConstraintsTracker.replace(r0);
        ArrayList r1 = new ArrayList(r0.size());
        long r2 = System.currentTimeMillis();
        Iterator<WorkSpec> r3 = r0.iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        WorkSpec r4 = r3.next();
        String r5 = r4.id;
        if (r2 < r4.calculateNextRunTime()) goto L4;
        if (r4.hasConstraints() == false) goto L11;
        if (this.mWorkConstraintsTracker.areAllConstraintsMet(r5) == false) goto L4;
    L11:
        r1.add(r4);
        goto L4
    L12:
        Iterator r6 = r1.iterator();
    L14:
        if (r6.hasNext() == false) goto L16;
        WorkSpec r7 = (WorkSpec) r6.next();
        String r8 = r7.id;
        Intent r9 = CommandHandler.createDelayMetIntent(this.mContext, WorkSpecKt.generationalId(r7));
        Logger.get().debug(TAG, "Creating a delay_met command for workSpec with id (" + r8 + ")");
        this.mDispatcher.getTaskExecutor().getMainThreadExecutor().execute(new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, r9, this.mStartId));
        goto L14
    L16:
        this.mWorkConstraintsTracker.reset();
    }
}
