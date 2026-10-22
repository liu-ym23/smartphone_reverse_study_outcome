package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public interface SchedulerMultiWorkerSupport {

    public interface WorkerCallback {
        void onWorker(int r1, @NonNull Scheduler.Worker r2);
    }

    void createWorkers(int r1, @NonNull WorkerCallback r2);
}
