package androidx.arch.core.executor;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class TaskExecutor {
    public TaskExecutor() {
    }

    public abstract void executeOnDiskIO(@NonNull Runnable r1);

    public void executeOnMainThread(@NonNull Runnable r2) {
        if (isMainThread() == false) goto L5;
        r2.run();
        return;
    L5:
        postToMainThread(r2);
    }

    public abstract boolean isMainThread();

    public abstract void postToMainThread(@NonNull Runnable r1);
}
