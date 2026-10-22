package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class TimeoutFuture<V> extends FluentFuture.TrustedFuture<V> {

    @CheckForNull
    private ListenableFuture<V> delegateRef;

    @CheckForNull
    private ScheduledFuture<?> timer;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.TimeoutFuture$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class Fire<V> implements Runnable {

        @CheckForNull
        TimeoutFuture<V> timeoutFutureRef;

        Fire(TimeoutFuture<V> r1) {
            this.timeoutFutureRef = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            TimeoutFuture<V> r1 = this.timeoutFutureRef;
            if (r1 != null) goto L5;
            return;
        L5:
            ListenableFuture<? extends V> r2 = TimeoutFuture.access$000(r1);
            if (r2 != null) goto L8;
            return;
        L8:
            AnonymousClass1 r3 = null;
            this.timeoutFutureRef = null;
            if (r2.isDone() == false) goto L29;
            r1.setFuture(r2);
            return;
        L29:
            ScheduledFuture r4 = TimeoutFuture.access$100(r1);     // Catch: Throwable -> L24
            TimeoutFuture.access$102(r1, null);     // Catch: Throwable -> L24
            String r5 = "Timed out";
            if (r4 != null) goto L27;
        L17:
            String r0 = String.valueOf(r5);     // Catch: Throwable -> L21
            String r6 = String.valueOf(r2);     // Catch: Throwable -> L21
            r1.setException(new TimeoutFutureException(new StringBuilder((String.valueOf(r0).length() + 2) + String.valueOf(r6).length()).append(r0).append(": ").append(r6).toString(), r3));     // Catch: Throwable -> L24
            r2.cancel(true);
            return;
        L21:
            th = move-exception;
            r1.setException(new TimeoutFutureException(r5, r3));     // Catch: Throwable -> L24
            throw th;     // Catch: Throwable -> L24
        L27:
            long r7 = Math.abs(r4.getDelay(TimeUnit.MILLISECONDS));     // Catch: Throwable -> L21
            if (r7 <= 10) goto L17;
            r5 = new StringBuilder("Timed out".length() + 66).append("Timed out (timeout delayed by ").append(r7).append(" ms after scheduled time)").toString();     // Catch: Throwable -> L21
        L24:
            th = move-exception;
            r2.cancel(true);
            throw th;
        }
    }

    private static final class TimeoutFutureException extends TimeoutException {
        /* synthetic */ TimeoutFutureException(String r1, AnonymousClass1 r2) {
            this(r1);
        }

        private TimeoutFutureException(String r1) {
            super(r1);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            monitor-enter(this);
            setStackTrace(new StackTraceElement[0]);     // Catch: Throwable -> L7
            monitor-exit(this);
            return this;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static /* synthetic */ ListenableFuture access$000(TimeoutFuture r0) {
        return r0.delegateRef;
    }

    static /* synthetic */ ScheduledFuture access$100(TimeoutFuture r0) {
        return r0.timer;
    }

    static /* synthetic */ ScheduledFuture access$102(TimeoutFuture r0, ScheduledFuture r1) {
        r0.timer = r1;
        return r1;
    }

    static <V> ListenableFuture<V> create(ListenableFuture<V> r2, long r3, TimeUnit r5, ScheduledExecutorService r6) {
        TimeoutFuture r0 = new TimeoutFuture(r2);
        Fire r1 = new Fire(r0);
        r0.timer = r6.schedule(r1, r3, r5);
        r2.addListener(r1, MoreExecutors.directExecutor());
        return r0;
    }

    private TimeoutFuture(ListenableFuture<V> r1) {
        this.delegateRef = (ListenableFuture) Preconditions.checkNotNull(r1);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    protected String pendingToString() {
        ListenableFuture<V> r0 = this.delegateRef;
        ScheduledFuture<?> r5 = this.timer;
        if (r0 == null) goto L10;
        String r1 = String.valueOf(r0);
        String r2 = new StringBuilder(String.valueOf(r1).length() + 14).append("inputFuture=[").append(r1).append("]").toString();
        if (r5 == null) goto L12;
        long r3 = r5.getDelay(TimeUnit.MILLISECONDS);
        if (r3 <= 0) goto L13;
        String r6 = String.valueOf(r2);
        return new StringBuilder(String.valueOf(r6).length() + 43).append(r6).append(", remaining delay=[").append(r3).append(" ms]").toString();
    L13:
        return r2;
    L12:
        return r2;
    L10:
        return null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected void afterDone() {
        maybePropagateCancellationTo(this.delegateRef);
        ScheduledFuture<?> r0 = this.timer;
        if (r0 == null) goto L5;
        r0.cancel(false);
    L5:
        this.delegateRef = null;
        this.timer = null;
    }
}
