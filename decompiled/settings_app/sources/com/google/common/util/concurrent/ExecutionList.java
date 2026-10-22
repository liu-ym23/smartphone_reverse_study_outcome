package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class ExecutionList {
    private static final Logger log = null;
    private boolean executed;

    @CheckForNull
    private RunnableExecutorPair runnables;

    private static final class RunnableExecutorPair {
        final Executor executor;

        @CheckForNull
        RunnableExecutorPair next;
        final Runnable runnable;

        RunnableExecutorPair(Runnable r1, Executor r2, @CheckForNull RunnableExecutorPair r3) {
            this.runnable = r1;
            this.executor = r2;
            this.next = r3;
        }
    }

    static {
        log = Logger.getLogger(ExecutionList.class.getName());
    }

    public ExecutionList() {
    }

    public void add(Runnable r3, Executor r4) {
        Preconditions.checkNotNull(r3, "Runnable was null.");
        Preconditions.checkNotNull(r4, "Executor was null.");
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.executed == true) goto L9;
        this.runnables = new RunnableExecutorPair(r3, r4, this.runnables);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L12
        executeListener(r3, r4);
    }

    public void execute() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.executed == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L7:
        this.executed = true;     // Catch: Throwable -> L14
        RunnableExecutorPair r0 = this.runnables;     // Catch: Throwable -> L14
        RunnableExecutorPair r1 = null;
        this.runnables = null;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
    L9:
        if (r0 == null) goto L11;
        RunnableExecutorPair r2 = r0.next;
        r0.next = r1;
        r1 = r0;
        r0 = r2;
    L11:
        if (r1 == null) goto L13;
        executeListener(r1.runnable, r1.executor);
        r1 = r1.next;
        goto L11
    }

    private static void executeListener(Runnable r5, Executor r6) {
        r6.execute(r5);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        Logger r1 = log;
        Level r2 = Level.SEVERE;
        String r7 = String.valueOf(r5);
        String r8 = String.valueOf(r6);
        r1.log(r2, new StringBuilder((String.valueOf(r7).length() + 57) + String.valueOf(r8).length()).append("RuntimeException while executing runnable ").append(r7).append(" with executor ").append(r8).toString(), e);
    }
}
