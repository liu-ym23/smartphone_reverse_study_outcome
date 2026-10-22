package okio;

import com.bytedance.apm.battery.dao.DBHelper;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class AsyncTimeout extends Timeout {
    public static final Companion Companion = null;
    private static final long IDLE_TIMEOUT_MILLIS = 0;
    private static final long IDLE_TIMEOUT_NANOS = 0;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ boolean access$cancelScheduledTimeout(Companion r0, AsyncTimeout r1) {
            return r0.cancelScheduledTimeout(r1);
        }

        public static final /* synthetic */ void access$scheduleTimeout(Companion r0, AsyncTimeout r1, long r2, boolean r4) {
            r0.scheduleTimeout(r1, r2, r4);
        }

        private final boolean cancelScheduledTimeout(AsyncTimeout r3) {
            monitor-enter(AsyncTimeout.class);
            AsyncTimeout r0 = AsyncTimeout.access$getHead$cp();     // Catch: Throwable -> L12
        L5:
            if (r0 == null) goto L16;
            if (AsyncTimeout.access$getNext$p(r0) == r3) goto L8;
            r0 = AsyncTimeout.access$getNext$p(r0);     // Catch: Throwable -> L12
            goto L5
        L8:
            AsyncTimeout.access$setNext$p(r0, AsyncTimeout.access$getNext$p(r3));     // Catch: Throwable -> L12
            AsyncTimeout.access$setNext$p(r3, null);     // Catch: Throwable -> L12
            monitor-exit(AsyncTimeout.class);
            return false;
        L16:
            monitor-exit(AsyncTimeout.class);
            return true;
        L12:
            th = move-exception;
            throw th;
        }

        private final void scheduleTimeout(AsyncTimeout r5, long r6, boolean r8) {
            monitor-enter(AsyncTimeout.class);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (AsyncTimeout.access$getHead$cp() != null) goto L9;
            AsyncTimeout.access$setHead$cp(new AsyncTimeout());     // Catch: Throwable -> L7
            new Watchdog().start();     // Catch: Throwable -> L7
        L9:
            long r0 = System.nanoTime();     // Catch: Throwable -> L7
            if (r6 == 0) goto L13;
            if (r8 == false) goto L13;
            AsyncTimeout.access$setTimeoutAt$p(r5, Math.min(r6, r5.deadlineNanoTime() - r0) + r0);     // Catch: Throwable -> L7
        L17:
            long r7 = AsyncTimeout.access$remainingNanos(r5, r0);     // Catch: Throwable -> L7
            AsyncTimeout r9 = AsyncTimeout.access$getHead$cp();     // Catch: Throwable -> L7
            Intrinsics.c(r9);     // Catch: Throwable -> L7
        L19:
            if (AsyncTimeout.access$getNext$p(r9) == null) goto L24;
            AsyncTimeout r2 = AsyncTimeout.access$getNext$p(r9);     // Catch: Throwable -> L7
            Intrinsics.c(r2);     // Catch: Throwable -> L7
            if (r7 < AsyncTimeout.access$remainingNanos(r2, r0)) goto L24;
            r9 = AsyncTimeout.access$getNext$p(r9);     // Catch: Throwable -> L7
            Intrinsics.c(r9);     // Catch: Throwable -> L7
        L24:
            AsyncTimeout.access$setNext$p(r5, AsyncTimeout.access$getNext$p(r9));     // Catch: Throwable -> L7
            AsyncTimeout.access$setNext$p(r9, r5);     // Catch: Throwable -> L7
            if (r9 != AsyncTimeout.access$getHead$cp()) goto L27;
            AsyncTimeout.class.notify();     // Catch: Throwable -> L7
        L27:
            monitor-exit(AsyncTimeout.class);
            return;
        L13:
            if (r6 == 0) goto L15;
            AsyncTimeout.access$setTimeoutAt$p(r5, r6 + r0);     // Catch: Throwable -> L7
            goto L17
        L15:
            if (r8 == false) goto L30;
            AsyncTimeout.access$setTimeoutAt$p(r5, r5.deadlineNanoTime());     // Catch: Throwable -> L7
            goto L17
        L30:
            throw new AssertionError();     // Catch: Throwable -> L7
        }

        @Nullable
        public final AsyncTimeout awaitTimeout$okio() {
            AsyncTimeout r8 = AsyncTimeout.access$getHead$cp();
            Intrinsics.c(r8);
            AsyncTimeout r9 = AsyncTimeout.access$getNext$p(r8);
            if (r9 != null) goto L10;
            long r2 = System.nanoTime();
            AsyncTimeout.class.wait(AsyncTimeout.access$getIDLE_TIMEOUT_MILLIS$cp());
            AsyncTimeout r10 = AsyncTimeout.access$getHead$cp();
            Intrinsics.c(r10);
            if (AsyncTimeout.access$getNext$p(r10) == null) goto L7;
            return null;
        L7:
            if ((System.nanoTime() - r2) >= AsyncTimeout.access$getIDLE_TIMEOUT_NANOS$cp()) goto L9;
            return null;
        L9:
            return AsyncTimeout.access$getHead$cp();
        L10:
            long r3 = AsyncTimeout.access$remainingNanos(r9, System.nanoTime());
            if (r3 <= 0) goto L14;
            long r6 = r3 / 1000000;
            AsyncTimeout.class.wait(r6, (int) (r3 - (1000000 * r6)));
            return null;
        L14:
            AsyncTimeout r0 = AsyncTimeout.access$getHead$cp();
            Intrinsics.c(r0);
            AsyncTimeout.access$setNext$p(r0, AsyncTimeout.access$getNext$p(r9));
            AsyncTimeout.access$setNext$p(r9, null);
            return r9;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L19:
            monitor-enter(AsyncTimeout.class);     // Catch: InterruptedException -> L16
            AsyncTimeout r0 = AsyncTimeout.Companion.awaitTimeout$okio();     // Catch: Throwable -> L9
            if (r0 != AsyncTimeout.access$getHead$cp()) goto L11;
            AsyncTimeout.access$setHead$cp(null);     // Catch: Throwable -> L9
            goto L19
        L7:
            monitor-exit(AsyncTimeout.class);     // Catch: InterruptedException -> L16
            return;
        L11:
            monitor-exit(AsyncTimeout.class);     // Catch: InterruptedException -> L16
            if (r0 == null) goto L19;
            r0.timedOut();     // Catch: InterruptedException -> L16
        L9:
            th = move-exception;
            throw th;     // Catch: InterruptedException -> L16
        }
    }

    static {
        Companion = new Companion(null);
        long r0 = TimeUnit.SECONDS.toMillis(60);
        IDLE_TIMEOUT_MILLIS = r0;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(r0);
    }

    public AsyncTimeout() {
    }

    public static final /* synthetic */ AsyncTimeout access$getHead$cp() {
        return head;
    }

    public static final /* synthetic */ long access$getIDLE_TIMEOUT_MILLIS$cp() {
        return IDLE_TIMEOUT_MILLIS;
    }

    public static final /* synthetic */ long access$getIDLE_TIMEOUT_NANOS$cp() {
        return IDLE_TIMEOUT_NANOS;
    }

    public static final /* synthetic */ AsyncTimeout access$getNext$p(AsyncTimeout r0) {
        return r0.next;
    }

    public static final /* synthetic */ long access$getTimeoutAt$p(AsyncTimeout r2) {
        return r2.timeoutAt;
    }

    public static final /* synthetic */ long access$remainingNanos(AsyncTimeout r0, long r1) {
        return r0.remainingNanos(r1);
    }

    public static final /* synthetic */ void access$setHead$cp(AsyncTimeout r0) {
        head = r0;
    }

    public static final /* synthetic */ void access$setNext$p(AsyncTimeout r0, AsyncTimeout r1) {
        r0.next = r1;
    }

    public static final /* synthetic */ void access$setTimeoutAt$p(AsyncTimeout r0, long r1) {
        r0.timeoutAt = r1;
    }

    private final long remainingNanos(long r3) {
        return this.timeoutAt - r3;
    }

    @PublishedApi
    @NotNull
    public final IOException access$newTimeoutException(@Nullable IOException r1) {
        return newTimeoutException(r1);
    }

    public final void enter() {
        if ((!this.inQueue) == false) goto L11;
        long r2 = timeoutNanos();
        boolean r0 = hasDeadline();
        if (r2 != 0) goto L8;
        if (r0 == true) goto L8;
        return;
    L8:
        this.inQueue = true;
        Companion.access$scheduleTimeout(Companion, this, r2, r0);
        return;
    L11:
        throw new IllegalStateException("Unbalanced enter/exit".toString());
    }

    public final boolean exit() {
        if (this.inQueue == true) goto L5;
        return false;
    L5:
        this.inQueue = false;
        return Companion.access$cancelScheduledTimeout(Companion, this);
    }

    @NotNull
    public IOException newTimeoutException(@Nullable IOException r2) {
        InterruptedIOException r1 = new InterruptedIOException("timeout");
        if (r2 == null) goto L5;
        r1.initCause(r2);
    L5:
        return r1;
    }

    @NotNull
    public final Sink sink(@NotNull final Sink r2) {
        Intrinsics.f(r2, "sink");
        return new AnonymousClass1(this, r2);
    }

    @NotNull
    public final Source source(@NotNull final Source r2) {
        Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
        return new C00461(this, r2);
    }

    public void timedOut() {
    }

    public final <T> T withTimeout(@NotNull Function0<? extends T> r2) {
        Intrinsics.f(r2, "block");
        enter();
        T r3 = (T) r2.invoke();
    L5:
        if (exit() == true) goto L8;
        return r3;
    L8:
        throw access$newTimeoutException(null);
    L9:
        th = move-exception;
        exit();
        throw th;
    L11:
        e = move-exception;
        if (exit() == true) goto L16;
        throw e;     // Catch: Throwable -> L9
    L16:
        throw access$newTimeoutException(e);     // Catch: Throwable -> L9
    }
}
