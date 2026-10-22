package androidx.arch.core.executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class TaskExecutor {
    public abstract void executeOnDiskIO(Runnable r1);

    public abstract boolean isMainThread();

    public abstract void postToMainThread(Runnable r1);

    public TaskExecutor() {
    }

    public void executeOnMainThread(Runnable r2) {
        if (isMainThread() == false) goto L5;
        r2.run();
        return;
    L5:
        postToMainThread(r2);
    }
}
