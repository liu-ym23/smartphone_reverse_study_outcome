package androidx.work;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class WorkerFactory {
    private static final String TAG = null;

    public abstract ListenableWorker createWorker(Context appContext, String workerClassName, WorkerParameters workerParameters);

    public WorkerFactory() {
    }

    static {
        TAG = Logger.tagWithPrefix("WorkerFactory");
    }

    public final ListenableWorker createWorkerWithDefaultFallback(Context appContext, String workerClassName, WorkerParameters workerParameters) {
        ListenableWorker r0 = createWorker(appContext, workerClassName, workerParameters);
        if (r0 == null) goto L21;
    L14:
        if (r0 != null) goto L16;
    L20:
        return r0;
    L16:
        if (r0.isUsed() == false) goto L20;
        throw new IllegalStateException("WorkerFactory (" + getClass().getName() + ") returned an instance of a ListenableWorker (" + workerClassName + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    L21:
        Class r1 = Class.forName(workerClassName).asSubclass(ListenableWorker.class);     // Catch: Throwable -> L6
    L8:
        if (r1 == null) goto L14;
        r0 = (ListenableWorker) r1.getDeclaredConstructor(new Class[]{Context.class, WorkerParameters.class}).newInstance(new Object[]{appContext, workerParameters});     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Logger.get().error(TAG, "Could not instantiate " + workerClassName, th);
    L6:
        th = move-exception;
        Logger.get().error(TAG, "Invalid class: " + workerClassName, th);
        r1 = null;
        goto L8
    }

    public static WorkerFactory getDefaultWorkerFactory() {
        return new AnonymousClass1();
    }
}
