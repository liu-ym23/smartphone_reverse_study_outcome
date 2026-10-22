package com.google.common.util.concurrent;

import com.android.settings.utils.HanziToPinyin;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractFuture<V> extends InternalFutureFailureAccess implements ListenableFuture<V> {
    private static final AtomicHelper ATOMIC_HELPER = null;
    private static final boolean GENERATE_CANCELLATION_CAUSES = false;
    private static final Object NULL = null;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log = null;

    @CheckForNull
    private volatile Listener listeners;

    @CheckForNull
    private volatile Object value;

    @CheckForNull
    private volatile Waiter waiters;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractFuture$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static abstract class AtomicHelper {
        abstract boolean casListeners(AbstractFuture<?> r1, @CheckForNull Listener r2, Listener r3);

        abstract boolean casValue(AbstractFuture<?> r1, @CheckForNull Object r2, Object r3);

        abstract boolean casWaiters(AbstractFuture<?> r1, @CheckForNull Waiter r2, @CheckForNull Waiter r3);

        abstract void putNext(Waiter r1, @CheckForNull Waiter r2);

        abstract void putThread(Waiter r1, Thread r2);

        private AtomicHelper() {
        }

        /* synthetic */ AtomicHelper(AnonymousClass1 r1) {
            this();
        }
    }

    private static final class Cancellation {

        @CheckForNull
        static final Cancellation CAUSELESS_CANCELLED = null;

        @CheckForNull
        static final Cancellation CAUSELESS_INTERRUPTED = null;

        @CheckForNull
        final Throwable cause;
        final boolean wasInterrupted;

        static {
            if (AbstractFuture.access$300() == false) goto L5;
            CAUSELESS_CANCELLED = null;
            CAUSELESS_INTERRUPTED = null;
            return;
        L5:
            CAUSELESS_CANCELLED = new Cancellation(false, null);
            CAUSELESS_INTERRUPTED = new Cancellation(true, null);
        }

        Cancellation(boolean r1, @CheckForNull Throwable r2) {
            this.wasInterrupted = r1;
            this.cause = r2;
        }
    }

    private static final class Failure {
        static final Failure FALLBACK_INSTANCE = null;
        final Throwable exception;

        static {
            final String r2 = "Failure occurred while trying to finish a future.";
            FALLBACK_INSTANCE = new Failure(new AnonymousClass1(r2));
        }

        Failure(Throwable r1) {
            this.exception = (Throwable) Preconditions.checkNotNull(r1);
        }
    }

    private static final class Listener {
        static final Listener TOMBSTONE = null;

        @CheckForNull
        final Executor executor;

        @CheckForNull
        Listener next;

        @CheckForNull
        final Runnable task;

        static {
            TOMBSTONE = new Listener();
        }

        Listener(Runnable r1, Executor r2) {
            this.task = r1;
            this.executor = r2;
        }

        Listener() {
            this.task = null;
            this.executor = null;
        }
    }

    private static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicReferenceFieldUpdater<AbstractFuture, Listener> listenersUpdater;
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> waitersUpdater;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> r2, AtomicReferenceFieldUpdater<Waiter, Waiter> r3, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> r4, AtomicReferenceFieldUpdater<AbstractFuture, Listener> r5, AtomicReferenceFieldUpdater<AbstractFuture, Object> r6) {
            super(null);
            this.waiterThreadUpdater = r2;
            this.waiterNextUpdater = r3;
            this.waitersUpdater = r4;
            this.listenersUpdater = r5;
            this.valueUpdater = r6;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void putThread(Waiter r1, Thread r2) {
            this.waiterThreadUpdater.lazySet(r1, r2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void putNext(Waiter r1, @CheckForNull Waiter r2) {
            this.waiterNextUpdater.lazySet(r1, r2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean casWaiters(AbstractFuture<?> r1, @CheckForNull Waiter r2, @CheckForNull Waiter r3) {
            return this.waitersUpdater.compareAndSet(r1, r2, r3);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean casListeners(AbstractFuture<?> r1, @CheckForNull Listener r2, Listener r3) {
            return this.listenersUpdater.compareAndSet(r1, r2, r3);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean casValue(AbstractFuture<?> r1, @CheckForNull Object r2, Object r3) {
            return this.valueUpdater.compareAndSet(r1, r2, r3);
        }
    }

    private static final class SetFuture<V> implements Runnable {
        final ListenableFuture<? extends V> future;
        final AbstractFuture<V> owner;

        SetFuture(AbstractFuture<V> r1, ListenableFuture<? extends V> r2) {
            this.owner = r1;
            this.future = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AbstractFuture.access$400(this.owner) == this) goto L5;
            return;
        L5:
            Object r0 = AbstractFuture.access$500(this.future);
            if (AbstractFuture.access$200().casValue(this.owner, this, r0) == false) goto L9;
            AbstractFuture.access$600(this.owner);
            return;
        }
    }

    private static final class SynchronizedHelper extends AtomicHelper {
        private SynchronizedHelper() {
            super(null);
        }

        /* synthetic */ SynchronizedHelper(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void putThread(Waiter r1, Thread r2) {
            r1.thread = r2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void putNext(Waiter r1, @CheckForNull Waiter r2) {
            r1.next = r2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean casWaiters(AbstractFuture<?> r1, @CheckForNull Waiter r2, @CheckForNull Waiter r3) {
            monitor-enter(r1);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (AbstractFuture.access$800(r1) != r2) goto L9;
            AbstractFuture.access$802(r1, r3);     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            return true;
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L12
            return false;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean casListeners(AbstractFuture<?> r1, @CheckForNull Listener r2, Listener r3) {
            monitor-enter(r1);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (AbstractFuture.access$900(r1) != r2) goto L9;
            AbstractFuture.access$902(r1, r3);     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            return true;
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L12
            return false;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean casValue(AbstractFuture<?> r1, @CheckForNull Object r2, Object r3) {
            monitor-enter(r1);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (AbstractFuture.access$400(r1) != r2) goto L9;
            AbstractFuture.access$402(r1, r3);     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            return true;
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L12
            return false;
        }
    }

    interface Trusted<V> extends ListenableFuture<V> {
    }

    static abstract class TrustedFuture<V> extends AbstractFuture<V> implements Trusted<V> {
        TrustedFuture() {
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @ParametricNullness
        public final V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @ParametricNullness
        public final V get(long r1, TimeUnit r3) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(r1, r3);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public final void addListener(Runnable r1, Executor r2) {
            super.addListener(r1, r2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean cancel(boolean r1) {
            return super.cancel(r1);
        }
    }

    private static final class UnsafeAtomicHelper extends AtomicHelper {
        static final long LISTENERS_OFFSET = 0;
        static final Unsafe UNSAFE = null;
        static final long VALUE_OFFSET = 0;
        static final long WAITERS_OFFSET = 0;
        static final long WAITER_NEXT_OFFSET = 0;
        static final long WAITER_THREAD_OFFSET = 0;

        private UnsafeAtomicHelper() {
            super(null);
        }

        /* synthetic */ UnsafeAtomicHelper(AnonymousClass1 r1) {
            this();
        }

        static {
            Unsafe r0 = Unsafe.getUnsafe();     // Catch: SecurityException -> L4
        L15:
            WAITERS_OFFSET = r0.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));     // Catch: Exception -> L7
            LISTENERS_OFFSET = r0.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));     // Catch: Exception -> L7
            VALUE_OFFSET = r0.objectFieldOffset(AbstractFuture.class.getDeclaredField("value"));     // Catch: Exception -> L7
            WAITER_THREAD_OFFSET = r0.objectFieldOffset(Waiter.class.getDeclaredField("thread"));     // Catch: Exception -> L7
            WAITER_NEXT_OFFSET = r0.objectFieldOffset(Waiter.class.getDeclaredField("next"));     // Catch: Exception -> L7
            UNSAFE = r0;     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            Throwables.throwIfUnchecked(e);
            throw new RuntimeException(e);
        L4:
            r0 = (Unsafe) AccessController.doPrivileged(new AnonymousClass1());     // Catch: PrivilegedActionException -> L10
        L10:
            e = move-exception;
            throw new RuntimeException("Could not initialize intrinsics", e.getCause());
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void putThread(Waiter r3, Thread r4) {
            UNSAFE.putObject(r3, WAITER_THREAD_OFFSET, r4);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        void putNext(Waiter r3, @CheckForNull Waiter r4) {
            UNSAFE.putObject(r3, WAITER_NEXT_OFFSET, r4);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean casWaiters(AbstractFuture<?> r7, @CheckForNull Waiter r8, @CheckForNull Waiter r9) {
            return UNSAFE.compareAndSwapObject(r7, WAITERS_OFFSET, r8, r9);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean casListeners(AbstractFuture<?> r7, @CheckForNull Listener r8, Listener r9) {
            return UNSAFE.compareAndSwapObject(r7, LISTENERS_OFFSET, r8, r9);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        boolean casValue(AbstractFuture<?> r7, @CheckForNull Object r8, Object r9) {
            return UNSAFE.compareAndSwapObject(r7, VALUE_OFFSET, r8, r9);
        }
    }

    private static final class Waiter {
        static final Waiter TOMBSTONE = null;

        @CheckForNull
        volatile Waiter next;

        @CheckForNull
        volatile Thread thread;

        static {
            TOMBSTONE = new Waiter(false);
        }

        Waiter(boolean r1) {
        }

        Waiter() {
            AbstractFuture.access$200().putThread(this, Thread.currentThread());
        }

        void setNext(@CheckForNull Waiter r2) {
            AbstractFuture.access$200().putNext(this, r2);
        }

        void unpark() {
            Thread r0 = this.thread;
            if (r0 == null) goto L6;
            this.thread = null;
            LockSupport.unpark(r0);
            return;
        }
    }

    protected void afterDone() {
    }

    protected void interruptTask() {
    }

    static /* synthetic */ AtomicHelper access$200() {
        return ATOMIC_HELPER;
    }

    static /* synthetic */ boolean access$300() {
        return GENERATE_CANCELLATION_CAUSES;
    }

    static /* synthetic */ Object access$400(AbstractFuture r0) {
        return r0.value;
    }

    static /* synthetic */ Object access$402(AbstractFuture r0, Object r1) {
        r0.value = r1;
        return r1;
    }

    static /* synthetic */ Object access$500(ListenableFuture r0) {
        return getFutureValue(r0);
    }

    static /* synthetic */ void access$600(AbstractFuture r0) {
        complete(r0);
    }

    static /* synthetic */ Waiter access$800(AbstractFuture r0) {
        return r0.waiters;
    }

    static /* synthetic */ Waiter access$802(AbstractFuture r0, Waiter r1) {
        r0.waiters = r1;
        return r1;
    }

    static /* synthetic */ Listener access$900(AbstractFuture r0) {
        return r0.listeners;
    }

    static /* synthetic */ Listener access$902(AbstractFuture r0, Listener r1) {
        r0.listeners = r1;
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.common.util.concurrent.AbstractFuture$1] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v5 */
    static {
        boolean r0 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));     // Catch: SecurityException -> L4
    L5:
        GENERATE_CANCELLATION_CAUSES = r0;
        log = Logger.getLogger(AbstractFuture.class.getName());
        ?? r1 = 0;
        r1 = 0;
        AtomicHelper r3 = new UnsafeAtomicHelper(r1);     // Catch: Throwable -> L8
        th = null;
    L13:
        ATOMIC_HELPER = r3;
        if (r1 == 0) goto L16;
        ?? r2 = log;
        r2.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", th);
        r2.log(Level.SEVERE, "SafeAtomicHelper is broken!", r1);
    L16:
        NULL = new Object();
        return;
    L8:
        th = th;
        r3 = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value"));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r3 = new SynchronizedHelper(r1);
        r1 = th;
    L4:
        r0 = false;
        goto L5
    }

    private void removeWaiter(Waiter r5) {
        r5.thread = null;
    L3:
        Waiter r6 = this.waiters;
        if (r6 == Waiter.TOMBSTONE) goto L5;
        Waiter r1 = null;
    L7:
        if (r6 == null) goto L19;
        Waiter r2 = r6.next;
        if (r6.thread == null) goto L11;
        r1 = r6;
    L18:
        r6 = r2;
        goto L7
    L11:
        if (r1 == null) goto L16;
        r1.next = r2;
        if (r1.thread != null) goto L18;
    L16:
        if (ATOMIC_HELPER.casWaiters(this, r6, r2) == true) goto L18;
    L19:
        return;
    }

    protected AbstractFuture() {
    }

    @Override // java.util.concurrent.Future
    @ParametricNullness
    public V get(long r20, TimeUnit r22) throws InterruptedException, TimeoutException, ExecutionException {
        long r4 = r22.toNanos(r20);
        if (Thread.interrupted() == true) goto L81;
        Object r6 = this.value;
        if (r6 == null) goto L7;
        boolean r9 = true;
    L9:
        if ((r9 & (!(r6 instanceof SetFuture))) == false) goto L13;
        return getDoneValue(r6);
    L13:
        if (r4 <= 0) goto L15;
        long r11 = System.nanoTime() + r4;
    L17:
        if (r4 < 1000) goto L43;
        Waiter r7 = this.waiters;
        if (r7 == Waiter.TOMBSTONE) goto L41;
        Waiter r15 = new Waiter();
    L21:
        r15.setNext(r7);
        if (ATOMIC_HELPER.casWaiters(this, r7, r15) == true) goto L23;
        r7 = this.waiters;
        if (r7 != Waiter.TOMBSTONE) goto L21;
    L23:
        OverflowAvoidingLockSupport.parkNanos(this, r4);
        if (Thread.interrupted() == true) goto L36;
        Object r5 = this.value;
        if (r5 == null) goto L28;
        boolean r8 = true;
    L30:
        if ((r8 & (!(r5 instanceof SetFuture))) == true) goto L32;
        r4 = r11 - System.nanoTime();
        if (r4 >= 1000) goto L23;
        removeWaiter(r15);
        goto L43
    L32:
        return getDoneValue(r5);
    L28:
        r8 = false;
        goto L30
    L36:
        removeWaiter(r15);
        throw new InterruptedException();
    L41:
        return getDoneValue(Objects.requireNonNull(this.value));
    L43:
        if (r4 <= 0) goto L57;
        Object r10 = this.value;
        if (r10 == null) goto L47;
        boolean r12 = true;
    L49:
        if ((r12 & (!(r10 instanceof SetFuture))) == true) goto L51;
        if (Thread.interrupted() == true) goto L56;
        r4 = r11 - System.nanoTime();
        goto L43
    L56:
        throw new InterruptedException();
    L51:
        return getDoneValue(r10);
    L47:
        r12 = false;
        goto L49
    L57:
        String r13 = toString();
        String r14 = r22.toString().toLowerCase(Locale.ROOT);
        String r16 = r22.toString().toLowerCase(Locale.ROOT);
        String r1 = new StringBuilder(String.valueOf(r16).length() + 28).append("Waited ").append(r20).append(HanziToPinyin.Token.SEPARATOR).append(r16).toString();
        if ((r4 + 1000) >= 0) goto L75;
        String r2 = String.valueOf(r1).concat(" (plus ");
        long r17 = -r4;
        long r18 = r22.convert(r17, TimeUnit.NANOSECONDS);
        long r19 = r17 - r22.toNanos(r18);
        if (r18 != 0) goto L62;
    L65:
        boolean r110 = true;
    L66:
        if (r18 <= 0) goto L71;
        String r3 = String.valueOf(r2);
        String r21 = new StringBuilder((String.valueOf(r3).length() + 21) + String.valueOf(r14).length()).append(r3).append(r18).append(HanziToPinyin.Token.SEPARATOR).append(r14).toString();
        if (r110 == false) goto L70;
        r21 = String.valueOf(r21).concat(",");
    L70:
        r2 = String.valueOf(r21).concat(HanziToPinyin.Token.SEPARATOR);
    L71:
        if (r110 == false) goto L73;
        String r23 = String.valueOf(r2);
        r2 = new StringBuilder(String.valueOf(r23).length() + 33).append(r23).append(r19).append(" nanoseconds ").toString();
    L73:
        r1 = String.valueOf(r2).concat("delay)");
        goto L75
    L62:
        if (r19 > 1000) goto L65;
        r110 = false;
    L75:
        if (isDone() == false) goto L79;
        throw new TimeoutException(String.valueOf(r1).concat(" but future completed as timeout expired"));
    L79:
        throw new TimeoutException(new StringBuilder((String.valueOf(r1).length() + 5) + String.valueOf(r13).length()).append(r1).append(" for ").append(r13).toString());
    L15:
        r11 = 0;
        goto L17
    L7:
        r9 = false;
        goto L9
    L81:
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    @ParametricNullness
    public V get() throws InterruptedException, ExecutionException {
        if (Thread.interrupted() == true) goto L34;
        Object r0 = this.value;
        if (r0 == null) goto L7;
        boolean r3 = true;
    L9:
        if ((r3 & (!(r0 instanceof SetFuture))) == true) goto L11;
        Waiter r1 = this.waiters;
        if (r1 == Waiter.TOMBSTONE) goto L32;
        Waiter r4 = new Waiter();
    L15:
        r4.setNext(r1);
        if (ATOMIC_HELPER.casWaiters(this, r1, r4) == true) goto L17;
        r1 = this.waiters;
        if (r1 != Waiter.TOMBSTONE) goto L15;
    L17:
        LockSupport.park(this);
        if (Thread.interrupted() == true) goto L27;
        Object r2 = this.value;
        if (r2 == null) goto L22;
        boolean r5 = true;
    L24:
        if ((r5 & (!(r2 instanceof SetFuture))) == false) goto L17;
        return getDoneValue(r2);
    L22:
        r5 = false;
        goto L24
    L27:
        removeWaiter(r4);
        throw new InterruptedException();
    L32:
        return getDoneValue(Objects.requireNonNull(this.value));
    L11:
        return getDoneValue(r0);
    L7:
        r3 = false;
        goto L9
    L34:
        throw new InterruptedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ParametricNullness
    private V getDoneValue(Object r1) throws ExecutionException {
        if ((r1 instanceof Cancellation) == true) goto L14;
        if ((r1 instanceof Failure) == true) goto L12;
        if (r1 == NULL) goto L9;
        return r1;
    L9:
        return (V) NullnessCasts.uncheckedNull();
    L12:
        throw new ExecutionException(((Failure) r1).exception);
    L14:
        throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation) r1).cause);
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object r2 = this.value;
        if (r2 == null) goto L5;
        boolean r1 = true;
    L7:
        return (!(r2 instanceof SetFuture)) & r1;
    L5:
        r1 = false;
        goto L7
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r7) {
        Object r0 = this.value;
        if (r0 != null) goto L5;
        boolean r3 = true;
    L7:
        if ((r3 | (r0 instanceof SetFuture)) == false) goto L36;
        if (GENERATE_CANCELLATION_CAUSES == false) goto L11;
        Object r4 = new Cancellation(r7, new CancellationException("Future.cancel() was called."));
    L15:
        boolean r5 = false;
    L17:
        if (ATOMIC_HELPER.casValue(this, r0, r4) == true) goto L18;
        r0 = this.value;
        if ((r0 instanceof SetFuture) == true) goto L17;
        return r5;
    L18:
        if (r7 == false) goto L20;
        this.interruptTask();
    L20:
        complete(this);
        if ((r0 instanceof SetFuture) == false) goto L48;
        ListenableFuture<? extends V> r6 = ((SetFuture) r0).future;
        if ((r6 instanceof Trusted) == false) goto L31;
        AbstractFuture<V> this = (AbstractFuture) r6;
        r0 = this.value;
        if (r0 != null) goto L27;
        boolean r8 = true;
    L29:
        if ((r8 | (r0 instanceof SetFuture)) == false) goto L49;
        r5 = true;
        goto L17
    L49:
        return true;
    L27:
        r8 = false;
        goto L29
    L31:
        r6.cancel(r7);
        return true;
    L48:
        return true;
    L11:
        if (r7 == false) goto L13;
        Cancellation r9 = Cancellation.CAUSELESS_INTERRUPTED;
    L14:
        r4 = Objects.requireNonNull(r9);
        goto L15
    L13:
        r9 = Cancellation.CAUSELESS_CANCELLED;
        goto L14
    L36:
        return false;
    L5:
        r3 = false;
        goto L7
    }

    protected final boolean wasInterrupted() {
        Object r1 = this.value;
        if ((r1 instanceof Cancellation) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Cancellation) r1).wasInterrupted == false) goto L7;
        return true;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable r4, Executor r5) {
        Preconditions.checkNotNull(r4, "Runnable was null.");
        Preconditions.checkNotNull(r5, "Executor was null.");
        if (isDone() == true) goto L12;
        Listener r0 = this.listeners;
        if (r0 == Listener.TOMBSTONE) goto L12;
        Listener r1 = new Listener(r4, r5);
    L7:
        r1.next = r0;
        if (ATOMIC_HELPER.casListeners(this, r0, r1) == true) goto L9;
        r0 = this.listeners;
        if (r0 != Listener.TOMBSTONE) goto L7;
    L9:
        return;
    L12:
        executeListener(r4, r5);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    protected boolean set(@ParametricNullness V r3) {
        if (r3 != null) goto L5;
        r3 = (V) NULL;
    L5:
        if (ATOMIC_HELPER.casValue(this, null, r3) == false) goto L8;
        complete(this);
        return true;
    L8:
        return false;
    }

    protected boolean setException(Throwable r3) {
        Failure r0 = new Failure((Throwable) Preconditions.checkNotNull(r3));
        if (ATOMIC_HELPER.casValue(this, null, r0) == false) goto L6;
        complete(this);
        return true;
    L6:
        return false;
    }

    protected boolean setFuture(ListenableFuture<? extends V> r6) {
        Preconditions.checkNotNull(r6);
        Object r0 = this.value;
        if (r0 != null) goto L23;
        if (r6.isDone() == false) goto L11;
        Object r7 = getFutureValue(r6);
        if (ATOMIC_HELPER.casValue(this, null, r7) == false) goto L10;
        complete(this);
        return true;
    L10:
        return false;
    L11:
        SetFuture r1 = new SetFuture(this, r6);
        if (ATOMIC_HELPER.casValue(this, null, r1) == true) goto L26;
        r0 = this.value;
        goto L23
    L26:
        r6.addListener(r1, DirectExecutor.INSTANCE);     // Catch: Throwable -> L15
    L20:
        return true;
    L15:
        th = move-exception;
        Failure r2 = new Failure(th);     // Catch: Throwable -> L18
    L19:
        ATOMIC_HELPER.casValue(this, r1, r2);
    L18:
        r2 = Failure.FALLBACK_INSTANCE;
    L23:
        if ((r0 instanceof Cancellation) == false) goto L25;
        r6.cancel(((Cancellation) r0).wasInterrupted);
    L25:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Object getFutureValue(ListenableFuture<?> r8) {
        if ((r8 instanceof Trusted) == false) goto L15;
        Object r9 = ((AbstractFuture) r8).value;
        if ((r9 instanceof Cancellation) == false) goto L13;
        Cancellation r0 = (Cancellation) r9;
        if (r0.wasInterrupted == false) goto L13;
        if (r0.cause == null) goto L11;
        r9 = new Cancellation(false, r0.cause);
        goto L13
    L11:
        r9 = Cancellation.CAUSELESS_CANCELLED;
    L13:
        return Objects.requireNonNull(r9);
    L15:
        if ((r8 instanceof InternalFutureFailureAccess) == false) goto L20;
        Throwable r1 = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) r8);
        if (r1 == null) goto L20;
        return new Failure(r1);
    L20:
        boolean r2 = r8.isCancelled();
        if (((!GENERATE_CANCELLATION_CAUSES) & r2) == true) goto L23;
        Object r3 = getUninterruptibly(r8);     // Catch: Throwable -> L31 CancellationException -> L34 ExecutionException -> L40
        if (r2 == false) goto L28;
        String r5 = String.valueOf(r8);     // Catch: Throwable -> L31 CancellationException -> L34 ExecutionException -> L40
        return new Cancellation(false, new IllegalArgumentException(new StringBuilder(String.valueOf(r5).length() + 84).append("get() did not throw CancellationException, despite reporting isCancelled() == true: ").append(r5).toString()));
    L28:
        if (r3 == null) goto L30;
        return r3;
    L30:
        return NULL;
    L34:
        e = move-exception;
        if (r2 == true) goto L39;
        String r10 = String.valueOf(r8);
        return new Failure(new IllegalArgumentException(new StringBuilder(String.valueOf(r10).length() + 77).append("get() threw CancellationException, despite reporting isCancelled() == false: ").append(r10).toString(), e));
    L39:
        return new Cancellation(false, e);
    L40:
        e = move-exception;
        if (r2 == false) goto L45;
        String r11 = String.valueOf(r8);
        return new Cancellation(false, new IllegalArgumentException(new StringBuilder(String.valueOf(r11).length() + 84).append("get() did not throw CancellationException, despite reporting isCancelled() == true: ").append(r11).toString(), e));
    L45:
        return new Failure(e.getCause());
    L31:
        th = move-exception;
        return new Failure(th);
    L23:
        return Objects.requireNonNull(Cancellation.CAUSELESS_CANCELLED);
    }

    @ParametricNullness
    private static <V> V getUninterruptibly(Future<V> r1) throws ExecutionException {
        boolean r0 = false;
    L12:
        V r2 = r1.get();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r0 == false) goto L6;
        Thread.currentThread().interrupt();
    L6:
        return r2;
    L11:
        r0 = true;
    L7:
        th = move-exception;
        if (r0 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private static void complete(AbstractFuture<V> r4) {
        Listener r0 = null;
    L3:
        r4.releaseWaiters();
        r4.afterDone();
        Listener r5 = r4.clearListeners(r0);
    L4:
        if (r5 == null) goto L14;
        r0 = r5.next;
        Runnable r1 = (Runnable) Objects.requireNonNull(r5.task);
        if ((r1 instanceof SetFuture) == false) goto L12;
        SetFuture r2 = (SetFuture) r1;
        r4 = r2.owner;
        if (((AbstractFuture) r4).value != r2) goto L13;
        Object r3 = getFutureValue(r2.future);
        if (ATOMIC_HELPER.casValue(r4, r2, r3) == true) goto L3;
    L13:
        r5 = r0;
        goto L4
    L12:
        executeListener(r1, (Executor) Objects.requireNonNull(r5.executor));
        goto L13
    }

    @Override // com.google.common.util.concurrent.internal.InternalFutureFailureAccess
    @CheckForNull
    protected final Throwable tryInternalFastPathGetFailure() {
        if ((this instanceof Trusted) == false) goto L8;
        Object r1 = this.value;
        if ((r1 instanceof Failure) == true) goto L7;
        return null;
    L7:
        return ((Failure) r1).exception;
    L8:
        return null;
    }

    final void maybePropagateCancellationTo(@CheckForNull Future<?> r3) {
        if (r3 == null) goto L4;
        boolean r0 = true;
    L6:
        if ((r0 & isCancelled()) == false) goto L9;
        r3.cancel(wasInterrupted());
        return;
    L9:
        return;
    L4:
        r0 = false;
        goto L6
    }

    private void releaseWaiters() {
    L2:
        Waiter r0 = this.waiters;
        if (ATOMIC_HELPER.casWaiters(this, r0, Waiter.TOMBSTONE) == false) goto L2;
    L4:
        if (r0 == null) goto L6;
        r0.unpark();
        r0 = r0.next;
        goto L4
    }

    @CheckForNull
    private Listener clearListeners(@CheckForNull Listener r4) {
    L2:
        Listener r0 = this.listeners;
        if (ATOMIC_HELPER.casListeners(this, r0, Listener.TOMBSTONE) == false) goto L2;
    L4:
        Listener r3 = r4;
        r4 = r0;
        if (r4 == null) goto L7;
        r0 = r4.next;
        r4.next = r3;
        goto L4
    L7:
        return r3;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.") == false) goto L5;
        r0.append(getClass().getSimpleName());
    L6:
        r0.append('@').append(Integer.toHexString(System.identityHashCode(this))).append("[status=");
        if (isCancelled() == false) goto L10;
        r0.append("CANCELLED");
    L14:
        return r0.append("]").toString();
    L10:
        if (isDone() == false) goto L12;
        addDoneString(r0);
        goto L14
    L12:
        addPendingString(r0);
        goto L14
    L5:
        r0.append(getClass().getName());
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    protected String pendingToString() {
        if ((this instanceof ScheduledFuture) == false) goto L6;
        long r0 = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        return new StringBuilder(41).append("remaining delay=[").append(r0).append(" ms]").toString();
    L6:
        return null;
    }

    private void addPendingString(StringBuilder r6) {
        int r0 = r6.length();
        r6.append("PENDING");
        Object r1 = this.value;
        if ((r1 instanceof SetFuture) == false) goto L15;
        r6.append(", setFuture=[");
        appendUserObject(r6, ((SetFuture) r1).future);
        r6.append("]");
    L12:
        if (isDone() == false) goto L17;
        r6.delete(r0, r6.length());
        addDoneString(r6);
        return;
    L17:
        return;
    L15:
        String r2 = Strings.emptyToNull(pendingToString());     // Catch: Throwable -> L7
    L9:
        if (r2 == null) goto L12;
        r6.append(", info=[").append(r2).append("]");
    L7:
        e = move-exception;
        String r3 = String.valueOf(e.getClass());
        r2 = new StringBuilder(String.valueOf(r3).length() + 38).append("Exception thrown from implementation: ").append(r3).toString();
        goto L9
    }

    private void addDoneString(StringBuilder r4) {
        Object r1 = getUninterruptibly(this);     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
        r4.append("SUCCESS, result=[");     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
        appendResultObject(r4, r1);     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
        r4.append("]");     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
    L15:
        return;
    L7:
        r4.append("CANCELLED");
        return;
    L5:
        e = move-exception;
        r4.append("UNKNOWN, cause=[").append(e.getClass()).append(" thrown from get()]");
        return;
    L8:
        e = move-exception;
        r4.append("FAILURE, cause=[").append(e.getCause()).append("]");
    }

    private void appendResultObject(StringBuilder r1, @CheckForNull Object r2) {
        if (r2 != null) goto L4;
        r1.append("null");
        return;
    L4:
        if (r2 != this) goto L6;
        r1.append("this future");
        return;
    L6:
        r1.append(r2.getClass().getName()).append("@").append(Integer.toHexString(System.identityHashCode(r2)));
    }

    private void appendUserObject(StringBuilder r1, @CheckForNull Object r2) {
        if (r2 != this) goto L4;
        r1.append("this future");     // Catch: Throwable -> L6
    L9:
        return;
    L4:
        r1.append(r2);     // Catch: Throwable -> L6
    L6:
        e = move-exception;
        r1.append("Exception thrown from implementation: ").append(e.getClass());
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

    private static CancellationException cancellationExceptionWithCause(String r1, @CheckForNull Throwable r2) {
        CancellationException r0 = new CancellationException(r1);
        r0.initCause(r2);
        return r0;
    }
}
