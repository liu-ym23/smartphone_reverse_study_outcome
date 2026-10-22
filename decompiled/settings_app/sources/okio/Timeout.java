package okio;

import android.icu.text.PluralRules;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u0000H\u0016J\b\u0010\r\u001a\u00020\u0000H\u0016J\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J-\u0010\u0012\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u0014\u001a\u00020\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0016H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\tH\u0016J\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"Lokio/Timeout;", "", "()V", "deadlineNanoTime", "", "hasDeadline", "", "timeoutNanos", "awaitSignal", "", "condition", "Ljava/util/concurrent/locks/Condition;", "clearDeadline", "clearTimeout", "deadline", "duration", "unit", "Ljava/util/concurrent/TimeUnit;", "intersectWith", ExifInterface.GPS_DIRECTION_TRUE, PluralRules.KEYWORD_OTHER, "block", "Lkotlin/Function0;", "(Lokio/Timeout;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "throwIfReached", "timeout", "waitUntilNotified", "monitor", "Companion", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class Timeout {
    public static final Companion Companion = null;
    public static final Timeout NONE = null;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    /* JADX INFO: compiled from: Timeout.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lokio/Timeout$Companion;", "", "()V", "NONE", "Lokio/Timeout;", "minTimeout", "", "aNanos", "bNanos", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
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

        private Companion() {
        }
    }

    public Timeout() {
    }

    public Timeout timeout(long r3, TimeUnit r5) {
        Intrinsics.checkNotNullParameter(r5, "unit");
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.timeoutNanos = r5.toNanos(r3);
        return this;
    L10:
        throw new IllegalArgumentException(("timeout < 0: " + r3).toString());
    L5:
        r0 = false;
        goto L6
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
        throw new IllegalStateException("No deadline".toString());
    }

    public Timeout deadlineNanoTime(long r2) {
        this.hasDeadline = true;
        this.deadlineNanoTime = r2;
        return this;
    }

    public final Timeout deadline(long r3, TimeUnit r5) {
        Intrinsics.checkNotNullParameter(r5, "unit");
        if (r3 <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return deadlineNanoTime(System.nanoTime() + r5.toNanos(r3));
    L10:
        throw new IllegalArgumentException(("duration <= 0: " + r3).toString());
    L5:
        r0 = false;
        goto L6
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
        if (Thread.currentThread().isInterrupted() == true) goto L13;
        if (this.hasDeadline == true) goto L7;
        return;
    L7:
        if ((this.deadlineNanoTime - System.nanoTime()) <= 0) goto L10;
        return;
    L10:
        throw new InterruptedIOException("deadline reached");
    L13:
        throw new InterruptedIOException("interrupted");
    }

    public final void awaitSignal(Condition r10) throws InterruptedIOException {
        Intrinsics.checkNotNullParameter(r10, "condition");
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
        r10.await(r1, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L24
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
        r10.await();     // Catch: InterruptedException -> L24
        return;
    L24:
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }

    public final void waitUntilNotified(Object r10) throws InterruptedIOException {
        Intrinsics.checkNotNullParameter(r10, "monitor");
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

    public final <T> T intersectWith(Timeout r11, Function0<? extends T> r12) {
        Intrinsics.checkNotNullParameter(r11, PluralRules.KEYWORD_OTHER);
        Intrinsics.checkNotNullParameter(r12, "block");
        long r0 = timeoutNanos();
        timeout(Companion.minTimeout(r11.timeoutNanos(), timeoutNanos()), TimeUnit.NANOSECONDS);
        if (hasDeadline() == false) goto L20;
        long r4 = deadlineNanoTime();
        if (r11.hasDeadline() == false) goto L36;
        deadlineNanoTime(Math.min(deadlineNanoTime(), r11.deadlineNanoTime()));
    L36:
        T r13 = r12.invoke();     // Catch: Throwable -> L13
        InlineMarker.finallyStart(1);
        timeout(r0, TimeUnit.NANOSECONDS);
        if (r11.hasDeadline() == false) goto L11;
        deadlineNanoTime(r4);
    L11:
        InlineMarker.finallyEnd(1);
        return r13;
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        timeout(r0, TimeUnit.NANOSECONDS);
        if (r11.hasDeadline() == false) goto L17;
        deadlineNanoTime(r4);
    L17:
        InlineMarker.finallyEnd(1);
        throw th;
    L20:
        if (r11.hasDeadline() == false) goto L34;
        deadlineNanoTime(r11.deadlineNanoTime());
    L34:
        T r14 = r12.invoke();     // Catch: Throwable -> L28
        InlineMarker.finallyStart(1);
        timeout(r0, TimeUnit.NANOSECONDS);
        if (r11.hasDeadline() == false) goto L26;
        clearDeadline();
    L26:
        InlineMarker.finallyEnd(1);
        return r14;
    L28:
        th = move-exception;
        InlineMarker.finallyStart(1);
        timeout(r0, TimeUnit.NANOSECONDS);
        if (r11.hasDeadline() == false) goto L32;
        clearDeadline();
    L32:
        InlineMarker.finallyEnd(1);
        throw th;
    }

    static {
        Companion = new Companion(null);
        NONE = new Timeout$Companion$NONE$1();
    }
}
