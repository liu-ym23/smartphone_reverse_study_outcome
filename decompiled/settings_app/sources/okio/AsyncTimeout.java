package okio;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AsyncTimeout.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0004J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J%\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0019H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"Lokio/AsyncTimeout;", "Lokio/Timeout;", "()V", "inQueue", "", "next", "timeoutAt", "", "access$newTimeoutException", "Ljava/io/IOException;", "cause", "enter", "", "exit", "newTimeoutException", "remainingNanos", "now", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "timedOut", "withTimeout", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "Watchdog", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class AsyncTimeout extends Timeout {
    public static final Companion Companion = null;
    private static final long IDLE_TIMEOUT_MILLIS = 0;
    private static final long IDLE_TIMEOUT_NANOS = 0;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static final Condition condition = null;
    private static AsyncTimeout head;
    private static final ReentrantLock lock = null;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    /* JADX INFO: compiled from: AsyncTimeout.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0002J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lokio/AsyncTimeout$Companion;", "", "()V", "IDLE_TIMEOUT_MILLIS", "", "IDLE_TIMEOUT_NANOS", "TIMEOUT_WRITE_SIZE", "", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "head", "Lokio/AsyncTimeout;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "awaitTimeout", "awaitTimeout$okio", "cancelScheduledTimeout", "", "node", "scheduleTimeout", "", "timeoutNanos", "hasDeadline", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ boolean access$cancelScheduledTimeout(Companion r0, AsyncTimeout r1) {
            return r0.cancelScheduledTimeout(r1);
        }

        public static final /* synthetic */ void access$scheduleTimeout(Companion r0, AsyncTimeout r1, long r2, boolean r4) {
            r0.scheduleTimeout(r1, r2, r4);
        }

        public final ReentrantLock getLock() {
            return AsyncTimeout.access$getLock$cp();
        }

        public final Condition getCondition() {
            return AsyncTimeout.access$getCondition$cp();
        }

        private final void scheduleTimeout(AsyncTimeout r5, long r6, boolean r8) {
            ReentrantLock r4 = AsyncTimeout.Companion.getLock();
            r4.lock();
        L33:
            th = move-exception;
            r4.unlock();
            throw th;
        L4:
            if ((!AsyncTimeout.access$getInQueue$p(r5)) == false) goto L32;
            AsyncTimeout.access$setInQueue$p(r5, true);     // Catch: Throwable -> L33
            if (AsyncTimeout.access$getHead$cp() != null) goto L8;
            Companion r0 = AsyncTimeout.Companion;     // Catch: Throwable -> L33
            AsyncTimeout.access$setHead$cp(new AsyncTimeout());     // Catch: Throwable -> L33
            new Watchdog().start();     // Catch: Throwable -> L33
        L8:
            long r1 = System.nanoTime();     // Catch: Throwable -> L33
            if (r6 == 0) goto L12;
            if (r8 == false) goto L12;
            AsyncTimeout.access$setTimeoutAt$p(r5, Math.min(r6, r5.deadlineNanoTime() - r1) + r1);     // Catch: Throwable -> L33
        L16:
            long r7 = AsyncTimeout.access$remainingNanos(r5, r1);     // Catch: Throwable -> L33
            AsyncTimeout r9 = AsyncTimeout.access$getHead$cp();     // Catch: Throwable -> L33
            Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L33
        L18:
            if (AsyncTimeout.access$getNext$p(r9) == null) goto L23;
            AsyncTimeout r2 = AsyncTimeout.access$getNext$p(r9);     // Catch: Throwable -> L33
            Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L33
            if (r7 < AsyncTimeout.access$remainingNanos(r2, r1)) goto L23;
            r9 = AsyncTimeout.access$getNext$p(r9);     // Catch: Throwable -> L33
            Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L33
        L23:
            AsyncTimeout.access$setNext$p(r5, AsyncTimeout.access$getNext$p(r9));     // Catch: Throwable -> L33
            AsyncTimeout.access$setNext$p(r9, r5);     // Catch: Throwable -> L33
            if (r9 != AsyncTimeout.access$getHead$cp()) goto L26;
            AsyncTimeout.Companion.getCondition().signal();     // Catch: Throwable -> L33
        L26:
            Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L33
            r4.unlock();
            return;
        L12:
            if (r6 == 0) goto L14;
            AsyncTimeout.access$setTimeoutAt$p(r5, r6 + r1);     // Catch: Throwable -> L33
            goto L16
        L14:
            if (r8 == false) goto L30;
            AsyncTimeout.access$setTimeoutAt$p(r5, r5.deadlineNanoTime());     // Catch: Throwable -> L33
            goto L16
        L30:
            throw new AssertionError();     // Catch: Throwable -> L33
        L32:
            throw new IllegalStateException("Unbalanced enter/exit".toString());     // Catch: Throwable -> L33
        }

        private final boolean cancelScheduledTimeout(AsyncTimeout r4) {
            ReentrantLock r3 = AsyncTimeout.Companion.getLock();
            r3.lock();
        L19:
            th = move-exception;
            r3.unlock();
            throw th;
        L5:
            if (AsyncTimeout.access$getInQueue$p(r4) == true) goto L8;
            r3.unlock();
            return false;
        L8:
            AsyncTimeout.access$setInQueue$p(r4, false);     // Catch: Throwable -> L19
            AsyncTimeout r0 = AsyncTimeout.access$getHead$cp();     // Catch: Throwable -> L19
        L9:
            if (r0 == null) goto L17;
            if (AsyncTimeout.access$getNext$p(r0) == r4) goto L12;
            r0 = AsyncTimeout.access$getNext$p(r0);     // Catch: Throwable -> L19
            goto L9
        L12:
            AsyncTimeout.access$setNext$p(r0, AsyncTimeout.access$getNext$p(r4));     // Catch: Throwable -> L19
            AsyncTimeout.access$setNext$p(r4, null);     // Catch: Throwable -> L19
            r3.unlock();
            return false;
        L17:
            r3.unlock();
            return true;
        }

        public final AsyncTimeout awaitTimeout$okio() throws InterruptedException {
            AsyncTimeout r0 = AsyncTimeout.access$getHead$cp();
            Intrinsics.checkNotNull(r0);
            AsyncTimeout r1 = AsyncTimeout.access$getNext$p(r0);
            if (r1 != null) goto L10;
            long r2 = System.nanoTime();
            getCondition().await(AsyncTimeout.access$getIDLE_TIMEOUT_MILLIS$cp(), TimeUnit.MILLISECONDS);
            AsyncTimeout r6 = AsyncTimeout.access$getHead$cp();
            Intrinsics.checkNotNull(r6);
            if (AsyncTimeout.access$getNext$p(r6) == null) goto L7;
            return null;
        L7:
            if ((System.nanoTime() - r2) >= AsyncTimeout.access$getIDLE_TIMEOUT_NANOS$cp()) goto L9;
            return null;
        L9:
            return AsyncTimeout.access$getHead$cp();
        L10:
            long r3 = AsyncTimeout.access$remainingNanos(r1, System.nanoTime());
            if (r3 <= 0) goto L14;
            getCondition().await(r3, TimeUnit.NANOSECONDS);
            return null;
        L14:
            AsyncTimeout r7 = AsyncTimeout.access$getHead$cp();
            Intrinsics.checkNotNull(r7);
            AsyncTimeout.access$setNext$p(r7, AsyncTimeout.access$getNext$p(r1));
            AsyncTimeout.access$setNext$p(r1, null);
            return r1;
        }
    }

    /* JADX INFO: compiled from: AsyncTimeout.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lokio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "()V", "run", "", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L16:
            ReentrantLock r2 = AsyncTimeout.Companion.getLock();     // Catch: InterruptedException -> L15
            r2.lock();     // Catch: InterruptedException -> L15
            AsyncTimeout r0 = AsyncTimeout.Companion.awaitTimeout$okio();     // Catch: Throwable -> L12
            if (r0 != AsyncTimeout.access$getHead$cp()) goto L8;
            Companion r1 = AsyncTimeout.Companion;     // Catch: Throwable -> L12
            AsyncTimeout.access$setHead$cp(null);     // Catch: Throwable -> L12
            goto L16
        L6:
            r2.unlock();     // Catch: InterruptedException -> L15
            return;
        L8:
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
            r2.unlock();     // Catch: InterruptedException -> L15
            if (r0 == null) goto L16;
            r0.timedOut();     // Catch: InterruptedException -> L15
        L12:
            th = move-exception;
            r2.unlock();     // Catch: InterruptedException -> L15
            throw th;     // Catch: InterruptedException -> L15
        }
    }

    protected void timedOut() {
    }

    public AsyncTimeout() {
    }

    public static final /* synthetic */ Condition access$getCondition$cp() {
        return condition;
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

    public static final /* synthetic */ boolean access$getInQueue$p(AsyncTimeout r0) {
        return r0.inQueue;
    }

    public static final /* synthetic */ ReentrantLock access$getLock$cp() {
        return lock;
    }

    public static final /* synthetic */ AsyncTimeout access$getNext$p(AsyncTimeout r0) {
        return r0.next;
    }

    public static final /* synthetic */ long access$remainingNanos(AsyncTimeout r0, long r1) {
        return r0.remainingNanos(r1);
    }

    public static final /* synthetic */ void access$setHead$cp(AsyncTimeout r0) {
        head = r0;
    }

    public static final /* synthetic */ void access$setInQueue$p(AsyncTimeout r0, boolean r1) {
        r0.inQueue = r1;
    }

    public static final /* synthetic */ void access$setNext$p(AsyncTimeout r0, AsyncTimeout r1) {
        r0.next = r1;
    }

    public static final /* synthetic */ void access$setTimeoutAt$p(AsyncTimeout r0, long r1) {
        r0.timeoutAt = r1;
    }

    public final void enter() {
        long r0 = timeoutNanos();
        boolean r2 = hasDeadline();
        if (r0 != 0) goto L6;
        if (r2 == true) goto L6;
        return;
    L6:
        Companion.access$scheduleTimeout(Companion, this, r0, r2);
    }

    public final boolean exit() {
        return Companion.access$cancelScheduledTimeout(Companion, this);
    }

    private final long remainingNanos(long r3) {
        return this.timeoutAt - r3;
    }

    public final Sink sink(final Sink r2) {
        Intrinsics.checkNotNullParameter(r2, "sink");
        return new AnonymousClass1(this, r2);
    }

    public final Source source(final Source r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        return new C04341(this, r2);
    }

    public final <T> T withTimeout(Function0<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r3, "block");
        enter();
        T r4 = r3.invoke();     // Catch: Throwable -> L10 IOException -> L12
        InlineMarker.finallyStart(1);
        if (exit() == true) goto L9;
        InlineMarker.finallyEnd(1);
        return r4;
    L9:
        throw access$newTimeoutException(null);
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        exit();
        InlineMarker.finallyEnd(1);
        throw th;
    L12:
        e = e;
        if (exit() == false) goto L17;
        e = access$newTimeoutException(e);     // Catch: Throwable -> L10
    L17:
        throw e;     // Catch: Throwable -> L10
    }

    public final IOException access$newTimeoutException(IOException r1) {
        return newTimeoutException(r1);
    }

    protected IOException newTimeoutException(IOException r2) {
        InterruptedIOException r1 = new InterruptedIOException("timeout");
        if (r2 == null) goto L6;
        r1.initCause(r2);
    L6:
        return r1;
    }

    static {
        Companion = new Companion(null);
        ReentrantLock r0 = new ReentrantLock();
        lock = r0;
        Condition r1 = r0.newCondition();
        Intrinsics.checkNotNullExpressionValue(r1, "lock.newCondition()");
        condition = r1;
        long r2 = TimeUnit.SECONDS.toMillis(60);
        IDLE_TIMEOUT_MILLIS = r2;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(r2);
    }
}
