package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;

/* JADX INFO: loaded from: classes5.dex */
public interface SchedulerMultiWorkerSupport {

    public interface WorkerCallback {
        void onWorker(int r1, Scheduler.Worker r2);
    }

    void createWorkers(int r1, WorkerCallback r2);
}
