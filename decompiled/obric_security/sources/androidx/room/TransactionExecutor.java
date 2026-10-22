package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransactionExecutor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0006\u0010\r\u001a\u00020\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/room/TransactionExecutor;", "Ljava/util/concurrent/Executor;", "executor", "(Ljava/util/concurrent/Executor;)V", "active", "Ljava/lang/Runnable;", "syncLock", "", "tasks", "Ljava/util/ArrayDeque;", "execute", "", "command", "scheduleNext", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TransactionExecutor implements Executor {
    private Runnable active;
    private final Executor executor;
    private final Object syncLock;
    private final ArrayDeque<Runnable> tasks;

    public static /* synthetic */ void $r8$lambda$AympDHYBb78s7_N_9gRsXF0sHiw(Runnable r0, TransactionExecutor r1) {
        execute$lambda$1$lambda$0(r0, r1);
    }

    public TransactionExecutor(Executor r2) {
        Intrinsics.checkNotNullParameter(r2, "executor");
        this.executor = r2;
        this.tasks = new ArrayDeque();
        this.syncLock = new Object();
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable r4) {
        Intrinsics.checkNotNullParameter(r4, "command");
        Object r0 = this.syncLock;
        monitor-enter(r0);
        this.tasks.offer(new TransactionExecutor$$ExternalSyntheticLambda0(r4, this));     // Catch: Throwable -> L10
        if (this.active != null) goto L7;
        scheduleNext();     // Catch: Throwable -> L10
    L7:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static final void execute$lambda$1$lambda$0(Runnable r1, TransactionExecutor r2) {
        Intrinsics.checkNotNullParameter(r1, "$command");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r1.run();     // Catch: Throwable -> L6
        r2.scheduleNext();
        return;
    L6:
        th = move-exception;
        r2.scheduleNext();
        throw th;
    }

    public final void scheduleNext() {
        Object r0 = this.syncLock;
        monitor-enter(r0);
        Runnable r1 = this.tasks.poll();     // Catch: Throwable -> L10
        Runnable r2 = r1;     // Catch: Throwable -> L10
        this.active = r2;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        this.executor.execute(r2);     // Catch: Throwable -> L10
    L7:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
