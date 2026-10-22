package androidx.work.impl.utils;

import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class StatusRunnable<T> implements Runnable {
    private final SettableFuture<T> mFuture;

    abstract T runInternal();

    public StatusRunnable() {
        this.mFuture = SettableFuture.create();
    }

    @Override // java.lang.Runnable
    public void run() {
        T r0 = runInternal();     // Catch: Throwable -> L4
        this.mFuture.set(r0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        this.mFuture.setException(th);
    }

    public ListenableFuture<T> getFuture() {
        return this.mFuture;
    }

    public static StatusRunnable<List<WorkInfo>> forStringIds(final WorkManagerImpl workManager, final List<String> ids) {
        return new AnonymousClass1(workManager, ids);
    }

    public static StatusRunnable<WorkInfo> forUUID(final WorkManagerImpl workManager, final UUID id) {
        return new AnonymousClass2(workManager, id);
    }

    public static StatusRunnable<List<WorkInfo>> forTag(final WorkManagerImpl workManager, final String tag) {
        return new AnonymousClass3(workManager, tag);
    }

    public static StatusRunnable<List<WorkInfo>> forUniqueWork(final WorkManagerImpl workManager, final String name) {
        return new AnonymousClass4(workManager, name);
    }

    public static StatusRunnable<List<WorkInfo>> forWorkQuerySpec(final WorkManagerImpl workManager, final WorkQuery querySpec) {
        return new AnonymousClass5(workManager, querySpec);
    }
}
