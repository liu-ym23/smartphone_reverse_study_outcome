package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class AsyncTimeout extends Timeout {
    private static final long IDLE_TIMEOUT_MILLIS = 0;
    private static final long IDLE_TIMEOUT_NANOS = 0;
    private static final int TIMEOUT_WRITE_SIZE = 65536;

    @Nullable
    static AsyncTimeout head;
    private boolean inQueue;

    @Nullable
    private AsyncTimeout next;
    private long timeoutAt;

    private static final class Watchdog extends Thread {
        Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L20:
            monitor-enter(AsyncTimeout.class);     // Catch: InterruptedException -> L19
            AsyncTimeout r0 = AsyncTimeout.awaitTimeout();     // Catch: Throwable -> L16
            if (r0 == null) goto L6;
            if (r0 != AsyncTimeout.head) goto L13;
            AsyncTimeout.head = null;     // Catch: Throwable -> L16
            monitor-exit(AsyncTimeout.class);     // Catch: Throwable -> L16
            goto L20
        L12:
            return;
        L13:
            monitor-exit(AsyncTimeout.class);     // Catch: Throwable -> L16
            r0.timedOut();     // Catch: InterruptedException -> L19
            goto L20
        L6:
            monitor-exit(AsyncTimeout.class);     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;     // Catch: InterruptedException -> L19
        }
    }

    protected void timedOut() {
    }

    public AsyncTimeout() {
    }

    static {
        long r0 = TimeUnit.SECONDS.toMillis(60);
        IDLE_TIMEOUT_MILLIS = r0;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(r0);
    }

    public final void enter() {
        if (this.inQueue == true) goto L11;
        long r0 = timeoutNanos();
        boolean r2 = hasDeadline();
        if (r0 != 0) goto L8;
        if (r2 == true) goto L8;
        return;
    L8:
        this.inQueue = true;
        scheduleTimeout(this, r0, r2);
        return;
    L11:
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    private static synchronized void scheduleTimeout(AsyncTimeout r5, long r6, boolean r8) {
        monitor-enter(AsyncTimeout.class);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (head != null) goto L7;
        head = new AsyncTimeout();     // Catch: Throwable -> L29
        new Watchdog().start();     // Catch: Throwable -> L29
    L7:
        long r1 = System.nanoTime();     // Catch: Throwable -> L29
        if (r6 == 0) goto L11;
        if (r8 == false) goto L11;
        r5.timeoutAt = Math.min(r6, r5.deadlineNanoTime() - r1) + r1;     // Catch: Throwable -> L29
    L15:
        long r7 = r5.remainingNanos(r1);     // Catch: Throwable -> L29
        AsyncTimeout r9 = head;     // Catch: Throwable -> L29
    L16:
        AsyncTimeout r3 = r9.next;     // Catch: Throwable -> L29
        if (r3 == null) goto L22;
        if (r7 < r3.remainingNanos(r1)) goto L22;
        r9 = r9.next;     // Catch: Throwable -> L29
    L22:
        r5.next = r9.next;     // Catch: Throwable -> L29
        r9.next = r5;     // Catch: Throwable -> L29
        if (r9 != head) goto L25;
        AsyncTimeout.class.notify();     // Catch: Throwable -> L29
    L25:
        monitor-exit(AsyncTimeout.class);
        return;
    L11:
        if (r6 == 0) goto L13;
        r5.timeoutAt = r6 + r1;     // Catch: Throwable -> L29
        goto L15
    L13:
        if (r8 == false) goto L28;
        r5.timeoutAt = r5.deadlineNanoTime();     // Catch: Throwable -> L29
        goto L15
    L28:
        throw new AssertionError();     // Catch: Throwable -> L29
    }

    public final boolean exit() {
        if (this.inQueue == true) goto L5;
        return false;
    L5:
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    private static synchronized boolean cancelScheduledTimeout(AsyncTimeout r3) {
        monitor-enter(AsyncTimeout.class);
        AsyncTimeout r1 = head;     // Catch: Throwable -> L16
    L5:
        if (r1 == null) goto L13;
        AsyncTimeout r2 = r1.next;     // Catch: Throwable -> L16
        if (r2 == r3) goto L8;
        r1 = r2;
        goto L5
    L8:
        r1.next = r3.next;     // Catch: Throwable -> L16
        r3.next = null;     // Catch: Throwable -> L16
        monitor-exit(AsyncTimeout.class);
        return false;
    L13:
        monitor-exit(AsyncTimeout.class);
        return true;
    L16:
        th = move-exception;
        throw th;
    }

    private long remainingNanos(long r3) {
        return this.timeoutAt - r3;
    }

    public final Sink sink(final Sink r2) {
        return new AnonymousClass1(this, r2);
    }

    public final Source source(final Source r2) {
        return new AnonymousClass2(this, r2);
    }

    final void exit(boolean r2) throws IOException {
        if (exit() == false) goto L8;
        if (r2 == true) goto L7;
        return;
    L7:
        throw newTimeoutException(null);
    }

    final IOException exit(IOException r2) throws IOException {
        if (exit() == true) goto L6;
        return r2;
    L6:
        return newTimeoutException(r2);
    }

    protected IOException newTimeoutException(@Nullable IOException r2) {
        InterruptedIOException r1 = new InterruptedIOException("timeout");
        if (r2 == null) goto L5;
        r1.initCause(r2);
    L5:
        return r1;
    }

    @Nullable
    static AsyncTimeout awaitTimeout() throws InterruptedException {
        AsyncTimeout r0 = head.next;
        if (r0 != null) goto L10;
        long r3 = System.nanoTime();
        AsyncTimeout.class.wait(IDLE_TIMEOUT_MILLIS);
        if (head.next == null) goto L7;
        return null;
    L7:
        if ((System.nanoTime() - r3) >= IDLE_TIMEOUT_NANOS) goto L9;
        return null;
    L9:
        return head;
    L10:
        long r4 = r0.remainingNanos(System.nanoTime());
        if (r4 <= 0) goto L14;
        long r7 = r4 / 1000000;
        AsyncTimeout.class.wait(r7, (int) (r4 - (1000000 * r7)));
        return null;
    L14:
        AsyncTimeout r1 = head;
        r1.next = r0.next;
        r0.next = null;
        return r0;
    }
}
