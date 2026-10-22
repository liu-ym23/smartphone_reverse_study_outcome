package androidx.work.impl.background.greedy;

import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DelayedWorkTracker {
    static final String TAG = null;
    final GreedyScheduler mGreedyScheduler;
    private final RunnableScheduler mRunnableScheduler;
    private final Map<String, Runnable> mRunnables;

    static {
        TAG = Logger.tagWithPrefix("DelayedWorkTracker");
    }

    public DelayedWorkTracker(GreedyScheduler scheduler, RunnableScheduler runnableScheduler) {
        this.mGreedyScheduler = scheduler;
        this.mRunnableScheduler = runnableScheduler;
        this.mRunnables = new HashMap();
    }

    public void schedule(final WorkSpec workSpec) {
        Runnable r0 = this.mRunnables.remove(workSpec.id);
        if (r0 == null) goto L5;
        this.mRunnableScheduler.cancel(r0);
    L5:
        Runnable r1 = new AnonymousClass1(this, workSpec);
        this.mRunnables.put(workSpec.id, r1);
        long r2 = System.currentTimeMillis();
        long r3 = workSpec.calculateNextRunTime() - r2;
        this.mRunnableScheduler.scheduleWithDelay(r3, r1);
    }

    public void unschedule(String workSpecId) {
        Runnable r2 = this.mRunnables.remove(workSpecId);
        if (r2 == null) goto L6;
        this.mRunnableScheduler.cancel(r2);
        return;
    }
}
