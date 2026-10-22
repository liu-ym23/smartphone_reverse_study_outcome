package androidx.work;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class DelegatingWorkerFactory extends WorkerFactory {
    private static final String TAG = null;
    private final List<WorkerFactory> mFactories;

    static {
        TAG = Logger.tagWithPrefix("DelegatingWkrFctry");
    }

    public DelegatingWorkerFactory() {
        this.mFactories = new CopyOnWriteArrayList();
    }

    List<WorkerFactory> getFactories() {
        return this.mFactories;
    }

    public final void addFactory(WorkerFactory workerFactory) {
        this.mFactories.add(workerFactory);
    }

    @Override // androidx.work.WorkerFactory
    public final ListenableWorker createWorker(Context appContext, String workerClassName, WorkerParameters workerParameters) {
        Iterator<WorkerFactory> r1 = this.mFactories.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        ListenableWorker r0 = r1.next().createWorker(appContext, workerClassName, workerParameters);     // Catch: Throwable -> L9
        if (r0 == null) goto L4;
        return r0;
    L9:
        th = move-exception;
        Logger.get().error(TAG, "Unable to instantiate a ListenableWorker (" + workerClassName + ")", th);
        throw th;
    L12:
        return null;
    }
}
