package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.DebugStringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TaskImpl extends Task {
    public final Runnable e;

    public TaskImpl(Runnable r1, long r2, TaskContext r4) {
        super(r2, r4);
        this.e = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.run();     // Catch: Throwable -> L5
        this.c.c();
        return;
    L5:
        th = move-exception;
        this.c.c();
        throw th;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("Task[");
        Runnable r1 = this.e;
        r0.append(r1.getClass().getSimpleName());
        r0.append('@');
        r0.append(DebugStringsKt.a(r1));
        r0.append(", ");
        r0.append(this.b);
        r0.append(", ");
        r0.append(this.c);
        r0.append(']');
        return r0.toString();
    }
}
