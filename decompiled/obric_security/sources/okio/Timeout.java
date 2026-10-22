package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class Timeout {
    public static final Timeout NONE = null;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    static {
        NONE = new AnonymousClass1();
    }

    public Timeout() {
    }

    public Timeout timeout(long r3, TimeUnit r5) {
        if (r3 < 0) goto L10;
        if (r5 == null) goto L8;
        this.timeoutNanos = r5.toNanos(r3);
        return this;
    L8:
        throw new IllegalArgumentException("unit == null");
    L10:
        throw new IllegalArgumentException("timeout < 0: " + r3);
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline == false) goto L7;
        return this.deadlineNanoTime;
    L7:
        throw new IllegalStateException("No deadline");
    }

    public Timeout deadlineNanoTime(long r2) {
        this.hasDeadline = true;
        this.deadlineNanoTime = r2;
        return this;
    }

    public final Timeout deadline(long r3, TimeUnit r5) {
        if (r3 <= 0) goto L10;
        if (r5 == null) goto L8;
        return deadlineNanoTime(System.nanoTime() + r5.toNanos(r3));
    L8:
        throw new IllegalArgumentException("unit == null");
    L10:
        throw new IllegalArgumentException("duration <= 0: " + r3);
    }

    public Timeout clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted() == false) goto L5;
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    L5:
        if (this.hasDeadline == true) goto L7;
        return;
    L7:
        if ((this.deadlineNanoTime - System.nanoTime()) <= 0) goto L10;
        return;
    L10:
        throw new InterruptedIOException("deadline reached");
    }

    public final void waitUntilNotified(Object r10) throws InterruptedIOException {
        boolean r0 = hasDeadline();     // Catch: InterruptedException -> L23
        long r1 = timeoutNanos();     // Catch: InterruptedException -> L23
        long r3 = 0;
        if (r0 == false) goto L5;
    L8:
        long r5 = System.nanoTime();     // Catch: InterruptedException -> L23
        if (r0 == true) goto L11;
    L13:
        if (r0 == false) goto L16;
        r1 = deadlineNanoTime() - r5;     // Catch: InterruptedException -> L23
    L16:
        if (r1 <= 0) goto L19;
        long r7 = r1 / 1000000;     // Catch: InterruptedException -> L23
        r10.wait(r7, (int) (r1 - (1000000 * r7)));     // Catch: InterruptedException -> L23
        r3 = System.nanoTime() - r5;     // Catch: InterruptedException -> L23
    L19:
        if (r3 >= r1) goto L22;
        return;
    L22:
        throw new InterruptedIOException("timeout");     // Catch: InterruptedException -> L23
    L11:
        if (r1 == 0) goto L13;
        r1 = Math.min(r1, deadlineNanoTime() - r5);     // Catch: InterruptedException -> L23
        goto L16
    L5:
        if (r1 != 0) goto L8;
        r10.wait();     // Catch: InterruptedException -> L23
        return;
    L23:
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }
}
