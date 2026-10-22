package androidx.arch.core.executor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ArchTaskExecutor extends TaskExecutor {

    @NonNull
    private static final Executor sIOThreadExecutor = null;
    private static volatile ArchTaskExecutor sInstance;

    @NonNull
    private static final Executor sMainThreadExecutor = null;

    @NonNull
    private TaskExecutor mDefaultTaskExecutor;

    @NonNull
    private TaskExecutor mDelegate;

    static {
        sMainThreadExecutor = new AnonymousClass1();
        sIOThreadExecutor = new AnonymousClass2();
    }

    private ArchTaskExecutor() {
        DefaultTaskExecutor r0 = new DefaultTaskExecutor();
        this.mDefaultTaskExecutor = r0;
        this.mDelegate = r0;
    }

    @NonNull
    public static Executor getIOThreadExecutor() {
        return sIOThreadExecutor;
    }

    @NonNull
    public static ArchTaskExecutor getInstance() {
        if (sInstance == null) goto L7;
        return sInstance;
    L7:
        monitor-enter(ArchTaskExecutor.class);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (sInstance != null) goto L11;
        sInstance = new ArchTaskExecutor();     // Catch: Throwable -> L14
    L11:
        monitor-exit(ArchTaskExecutor.class);     // Catch: Throwable -> L14
        return sInstance;
    }

    @NonNull
    public static Executor getMainThreadExecutor() {
        return sMainThreadExecutor;
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(Runnable r1) {
        this.mDelegate.executeOnDiskIO(r1);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        return this.mDelegate.isMainThread();
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(Runnable r1) {
        this.mDelegate.postToMainThread(r1);
    }

    public void setDelegate(@Nullable TaskExecutor r1) {
        if (r1 != null) goto L4;
        r1 = this.mDefaultTaskExecutor;
    L4:
        this.mDelegate = r1;
    }
}
