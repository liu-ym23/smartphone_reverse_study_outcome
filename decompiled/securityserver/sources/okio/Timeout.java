package okio;

import a.a;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class Timeout {
    public static final Companion Companion = null;

    @JvmField
    @NotNull
    public static final Timeout NONE = null;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final long minTimeout(long r3, long r5) {
            if (r3 == 0) goto L12;
            if (r5 != 0) goto L9;
            return r3;
        L9:
            if (r3 >= r5) goto L12;
            return r3;
        L12:
            return r5;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        NONE = new Timeout$Companion$NONE$1();
    }

    public Timeout() {
    }

    @NotNull
    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    @NotNull
    public Timeout clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    @NotNull
    public final Timeout deadline(long r3, @NotNull TimeUnit r5) {
        Intrinsics.f(r5, "unit");
        if (r3 <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        long r1 = System.nanoTime();
        return deadlineNanoTime(r5.toNanos(r3) + r1);
    L10:
        throw new IllegalArgumentException(a.h("duration <= 0: ", r3).toString());
    L5:
        r0 = false;
        goto L6
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline == false) goto L7;
        return this.deadlineNanoTime;
    L7:
        throw new IllegalStateException("No deadline".toString());
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final void intersectWith(@NotNull Timeout r10, @NotNull Function0<Unit> r11) {
        Intrinsics.f(r10, "other");
        Intrinsics.f(r11, "block");
        long r0 = timeoutNanos();
        long r2 = Companion.minTimeout(r10.timeoutNanos(), timeoutNanos());
        TimeUnit r4 = TimeUnit.NANOSECONDS;
        timeout(r2, r4);
        if (hasDeadline() == false) goto L17;
        long r3 = deadlineNanoTime();
        if (r10.hasDeadline() == false) goto L29;
        deadlineNanoTime(Math.min(deadlineNanoTime(), r10.deadlineNanoTime()));
    L29:
        r11.invoke();     // Catch: Throwable -> L11
        timeout(r0, r4);
        if (r10.hasDeadline() == false) goto L33;
        deadlineNanoTime(r3);
        return;
    L33:
        return;
    L11:
        th = move-exception;
        timeout(r0, TimeUnit.NANOSECONDS);
        if (r10.hasDeadline() == false) goto L15;
        deadlineNanoTime(r3);
    L15:
        throw th;
    L17:
        if (r10.hasDeadline() == false) goto L31;
        deadlineNanoTime(r10.deadlineNanoTime());
    L31:
        r11.invoke();     // Catch: Throwable -> L24
        timeout(r0, r4);
        if (r10.hasDeadline() == false) goto L35;
        clearDeadline();
        return;
    L35:
        return;
    L24:
        th = move-exception;
        timeout(r0, TimeUnit.NANOSECONDS);
        if (r10.hasDeadline() == false) goto L28;
        clearDeadline();
    L28:
        throw th;
    }

    public void throwIfReached() {
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

    @NotNull
    public Timeout timeout(long r3, @NotNull TimeUnit r5) {
        Intrinsics.f(r5, "unit");
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.timeoutNanos = r5.toNanos(r3);
        return this;
    L10:
        throw new IllegalArgumentException(a.h("timeout < 0: ", r3).toString());
    L5:
        r0 = false;
        goto L6
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(@NotNull Object r10) {
        Intrinsics.f(r10, "monitor");
        boolean r0 = hasDeadline();     // Catch: InterruptedException -> L24
        long r1 = timeoutNanos();     // Catch: InterruptedException -> L24
        long r3 = 0;
        if (r0 == false) goto L6;
    L9:
        long r5 = System.nanoTime();     // Catch: InterruptedException -> L24
        if (r0 == true) goto L12;
    L14:
        if (r0 == false) goto L17;
        r1 = deadlineNanoTime() - r5;     // Catch: InterruptedException -> L24
    L17:
        if (r1 <= 0) goto L20;
        long r7 = r1 / 1000000;     // Catch: InterruptedException -> L24
        r10.wait(r7, (int) (r1 - (1000000 * r7)));     // Catch: InterruptedException -> L24
        r3 = System.nanoTime() - r5;     // Catch: InterruptedException -> L24
    L20:
        if (r3 >= r1) goto L23;
        return;
    L23:
        throw new InterruptedIOException("timeout");     // Catch: InterruptedException -> L24
    L12:
        if (r1 == 0) goto L14;
        r1 = Math.min(r1, deadlineNanoTime() - r5);     // Catch: InterruptedException -> L24
        goto L17
    L6:
        if (r1 != 0) goto L9;
        r10.wait();     // Catch: InterruptedException -> L24
        return;
    L24:
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }

    @NotNull
    public Timeout deadlineNanoTime(long r2) {
        this.hasDeadline = true;
        this.deadlineNanoTime = r2;
        return this;
    }
}
