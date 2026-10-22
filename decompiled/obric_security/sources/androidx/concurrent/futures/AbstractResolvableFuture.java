package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
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
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractResolvableFuture<V> implements ListenableFuture<V> {
    static final AtomicHelper ATOMIC_HELPER = null;
    static final boolean GENERATE_CANCELLATION_CAUSES = false;
    private static final Object NULL = null;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log = null;
    volatile Listener listeners;
    volatile Object value;
    volatile Waiter waiters;

    /* JADX INFO: renamed from: androidx.concurrent.futures.AbstractResolvableFuture$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static abstract class AtomicHelper {
        abstract boolean casListeners(AbstractResolvableFuture<?> r1, Listener r2, Listener r3);

        abstract boolean casValue(AbstractResolvableFuture<?> r1, Object r2, Object r3);

        abstract boolean casWaiters(AbstractResolvableFuture<?> r1, Waiter r2, Waiter r3);

        abstract void putNext(Waiter r1, Waiter r2);

        abstract void putThread(Waiter r1, Thread r2);

        private AtomicHelper() {
        }

        /* synthetic */ AtomicHelper(AnonymousClass1 r1) {
            this();
        }
    }

    private static final class Cancellation {
        static final Cancellation CAUSELESS_CANCELLED = null;
        static final Cancellation CAUSELESS_INTERRUPTED = null;
        final Throwable cause;
        final boolean wasInterrupted;

        static {
            if (AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES == false) goto L5;
            CAUSELESS_CANCELLED = null;
            CAUSELESS_INTERRUPTED = null;
            return;
        L5:
            CAUSELESS_CANCELLED = new Cancellation(false, null);
            CAUSELESS_INTERRUPTED = new Cancellation(true, null);
        }

        Cancellation(boolean r1, Throwable r2) {
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
            this.exception = (Throwable) AbstractResolvableFuture.checkNotNull(r1);
        }
    }

    private static final class Listener {
        static final Listener TOMBSTONE = null;
        final Executor executor;
        Listener next;
        final Runnable task;

        static {
            TOMBSTONE = new Listener(null, null);
        }

        Listener(Runnable r1, Executor r2) {
            this.task = r1;
            this.executor = r2;
        }
    }

    private static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> listenersUpdater;
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> valueUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> waitersUpdater;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> r2, AtomicReferenceFieldUpdater<Waiter, Waiter> r3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> r4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> r5, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> r6) {
            super(null);
            this.waiterThreadUpdater = r2;
            this.waiterNextUpdater = r3;
            this.waitersUpdater = r4;
            this.listenersUpdater = r5;
            this.valueUpdater = r6;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void putThread(Waiter r1, Thread r2) {
            this.waiterThreadUpdater.lazySet(r1, r2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void putNext(Waiter r1, Waiter r2) {
            this.waiterNextUpdater.lazySet(r1, r2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean casWaiters(AbstractResolvableFuture<?> r1, Waiter r2, Waiter r3) {
            return b0$$ExternalSyntheticBackport0.m(this.waitersUpdater, r1, r2, r3);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean casListeners(AbstractResolvableFuture<?> r1, Listener r2, Listener r3) {
            return b0$$ExternalSyntheticBackport0.m(this.listenersUpdater, r1, r2, r3);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean casValue(AbstractResolvableFuture<?> r1, Object r2, Object r3) {
            return b0$$ExternalSyntheticBackport0.m(this.valueUpdater, r1, r2, r3);
        }
    }

    private static final class SetFuture<V> implements Runnable {
        final ListenableFuture<? extends V> future;
        final AbstractResolvableFuture<V> owner;

        SetFuture(AbstractResolvableFuture<V> r1, ListenableFuture<? extends V> r2) {
            this.owner = r1;
            this.future = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.owner.value == this) goto L5;
            return;
        L5:
            Object r0 = AbstractResolvableFuture.getFutureValue(this.future);
            if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(this.owner, this, r0) == false) goto L9;
            AbstractResolvableFuture.complete(this.owner);
            return;
        }
    }

    private static final class SynchronizedHelper extends AtomicHelper {
        SynchronizedHelper() {
            super(null);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void putThread(Waiter r1, Thread r2) {
            r1.thread = r2;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void putNext(Waiter r1, Waiter r2) {
            r1.next = r2;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean casWaiters(AbstractResolvableFuture<?> r1, Waiter r2, Waiter r3) {
            monitor-enter(r1);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (r1.waiters != r2) goto L9;
            r1.waiters = r3;     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            return true;
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L12
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean casListeners(AbstractResolvableFuture<?> r1, Listener r2, Listener r3) {
            monitor-enter(r1);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (r1.listeners != r2) goto L9;
            r1.listeners = r3;     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            return true;
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L12
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean casValue(AbstractResolvableFuture<?> r1, Object r2, Object r3) {
            monitor-enter(r1);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (r1.value != r2) goto L9;
            r1.value = r3;     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            return true;
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L12
            return false;
        }
    }

    private static final class Waiter {
        static final Waiter TOMBSTONE = null;
        volatile Waiter next;
        volatile Thread thread;

        static {
            TOMBSTONE = new Waiter(false);
        }

        Waiter(boolean r1) {
        }

        Waiter() {
            AbstractResolvableFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }

        void setNext(Waiter r2) {
            AbstractResolvableFuture.ATOMIC_HELPER.putNext(this, r2);
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

    static {
        GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        log = Logger.getLogger(AbstractResolvableFuture.class.getName());
        AtomicHelper r1 = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "value"));     // Catch: Throwable -> L5
        th = null;
    L7:
        ATOMIC_HELPER = r1;
        if (th == null) goto L10;
        log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
    L10:
        NULL = new Object();
        return;
    L5:
        th = th;
        r1 = new SynchronizedHelper();
        goto L7
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

    protected AbstractResolvableFuture() {
    }

    @Override // java.util.concurrent.Future
    public final V get(long r20, TimeUnit r22) throws InterruptedException, TimeoutException, ExecutionException {
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
        LockSupport.parkNanos(this, r4);
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
        return getDoneValue(this.value);
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
        String r1 = "Waited " + r20 + " " + r22.toString().toLowerCase(Locale.ROOT);
        if ((r4 + 1000) >= 0) goto L75;
        String r2 = r1 + " (plus ";
        long r16 = -r4;
        long r17 = r22.convert(r16, TimeUnit.NANOSECONDS);
        long r18 = r16 - r22.toNanos(r17);
        if (r17 != 0) goto L62;
    L65:
        boolean r19 = true;
    L66:
        if (r17 <= 0) goto L71;
        String r3 = r2 + r17 + " " + r14;
        if (r19 == false) goto L70;
        r3 = r3 + ",";
    L70:
        r2 = r3 + " ";
    L71:
        if (r19 == false) goto L73;
        r2 = r2 + r18 + " nanoseconds ";
    L73:
        r1 = r2 + "delay)";
        goto L75
    L62:
        if (r18 > 1000) goto L65;
        r19 = false;
    L75:
        if (isDone() == false) goto L79;
        throw new TimeoutException(r1 + " but future completed as timeout expired");
    L79:
        throw new TimeoutException(r1 + " for " + r13);
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
    public final V get() throws InterruptedException, ExecutionException {
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
        return getDoneValue(this.value);
    L11:
        return getDoneValue(r0);
    L7:
        r3 = false;
        goto L9
    L34:
        throw new InterruptedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V getDoneValue(Object r1) throws ExecutionException {
        if ((r1 instanceof Cancellation) == true) goto L14;
        if ((r1 instanceof Failure) == true) goto L12;
        if (r1 != NULL) goto L10;
        return null;
    L10:
        return r1;
    L12:
        throw new ExecutionException(((Failure) r1).exception);
    L14:
        throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation) r1).cause);
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
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
    public final boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean r7) {
        Object r0 = this.value;
        if (r0 != null) goto L5;
        boolean r3 = true;
    L7:
        if ((r3 | (r0 instanceof SetFuture)) == false) goto L35;
        if (GENERATE_CANCELLATION_CAUSES == false) goto L11;
        Cancellation r4 = new Cancellation(r7, new CancellationException("Future.cancel() was called."));
    L14:
        boolean r5 = false;
    L16:
        if (ATOMIC_HELPER.casValue(this, r0, r4) == true) goto L17;
        r0 = this.value;
        if ((r0 instanceof SetFuture) == true) goto L16;
        return r5;
    L17:
        if (r7 == false) goto L19;
        this.interruptTask();
    L19:
        complete(this);
        if ((r0 instanceof SetFuture) == false) goto L47;
        ListenableFuture<? extends V> r6 = ((SetFuture) r0).future;
        if ((r6 instanceof AbstractResolvableFuture) == false) goto L30;
        AbstractResolvableFuture<V> this = (AbstractResolvableFuture) r6;
        r0 = this.value;
        if (r0 != null) goto L26;
        boolean r8 = true;
    L28:
        if ((r8 | (r0 instanceof SetFuture)) == false) goto L48;
        r5 = true;
        goto L16
    L48:
        return true;
    L26:
        r8 = false;
        goto L28
    L30:
        r6.cancel(r7);
        return true;
    L47:
        return true;
    L11:
        if (r7 == false) goto L13;
        r4 = Cancellation.CAUSELESS_INTERRUPTED;
        goto L14
    L13:
        r4 = Cancellation.CAUSELESS_CANCELLED;
        goto L14
    L35:
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
    public final void addListener(Runnable r4, Executor r5) {
        checkNotNull(r4);
        checkNotNull(r5);
        Listener r0 = this.listeners;
        if (r0 == Listener.TOMBSTONE) goto L10;
        Listener r1 = new Listener(r4, r5);
    L5:
        r1.next = r0;
        if (ATOMIC_HELPER.casListeners(this, r0, r1) == true) goto L7;
        r0 = this.listeners;
        if (r0 != Listener.TOMBSTONE) goto L5;
    L7:
        return;
    L10:
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
    protected boolean set(V r3) {
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
        Failure r0 = new Failure((Throwable) checkNotNull(r3));
        if (ATOMIC_HELPER.casValue(this, null, r0) == false) goto L6;
        complete(this);
        return true;
    L6:
        return false;
    }

    protected boolean setFuture(ListenableFuture<? extends V> r6) {
        checkNotNull(r6);
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

    static Object getFutureValue(ListenableFuture<?> r5) {
        if ((r5 instanceof AbstractResolvableFuture) == false) goto L13;
        Object r6 = ((AbstractResolvableFuture) r5).value;
        if ((r6 instanceof Cancellation) == false) goto L35;
        Cancellation r0 = (Cancellation) r6;
        if (r0.wasInterrupted == true) goto L9;
        return r6;
    L9:
        if (r0.cause == null) goto L12;
        return new Cancellation(false, r0.cause);
    L12:
        return Cancellation.CAUSELESS_CANCELLED;
    L35:
        return r6;
    L13:
        boolean r1 = r5.isCancelled();
        if (((!GENERATE_CANCELLATION_CAUSES) & r1) == true) goto L16;
        Object r2 = getUninterruptibly(r5);     // Catch: Throwable -> L21 CancellationException -> L24 ExecutionException -> L30
        if (r2 != null) goto L38;
        return NULL;
    L38:
        return r2;
    L24:
        e = move-exception;
        if (r1 == true) goto L29;
        return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + r5, e));
    L29:
        return new Cancellation(false, e);
    L30:
        e = move-exception;
        return new Failure(e.getCause());
    L21:
        th = move-exception;
        return new Failure(th);
    L16:
        return Cancellation.CAUSELESS_CANCELLED;
    }

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
    static void complete(AbstractResolvableFuture<V> r4) {
        Listener r0 = null;
    L3:
        r4.releaseWaiters();
        r4.afterDone();
        Listener r5 = r4.clearListeners(r0);
    L4:
        if (r5 == null) goto L14;
        r0 = r5.next;
        Runnable r1 = r5.task;
        if ((r1 instanceof SetFuture) == false) goto L12;
        SetFuture r2 = (SetFuture) r1;
        r4 = r2.owner;
        if (r4.value != r2) goto L13;
        Object r3 = getFutureValue(r2.future);
        if (ATOMIC_HELPER.casValue(r4, r2, r3) == true) goto L3;
    L13:
        r5 = r0;
        goto L4
    L12:
        executeListener(r1, r5.executor);
        goto L13
    }

    final void maybePropagateCancellationTo(Future<?> r3) {
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

    private Listener clearListeners(Listener r4) {
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
        StringBuilder r0 = new StringBuilder().append(super.toString()).append("[status=");
        if (isCancelled() == false) goto L6;
        r0.append("CANCELLED");
    L21:
        return r0.append("]").toString();
    L6:
        if (isDone() == false) goto L22;
        addDoneString(r0);
        goto L21
    L22:
        String r1 = pendingToString();     // Catch: RuntimeException -> L10
    L12:
        if (r1 == null) goto L17;
        if (r1.isEmpty() == true) goto L17;
        r0.append("PENDING, info=[").append(r1).append("]");
    L17:
        if (isDone() == false) goto L19;
        addDoneString(r0);
        goto L21
    L19:
        r0.append("PENDING");
    L10:
        e = move-exception;
        r1 = "Exception thrown from implementation: " + e.getClass();
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String pendingToString() {
        Object r0 = this.value;
        if ((r0 instanceof SetFuture) == false) goto L7;
        return "setFuture=[" + userObjectToString(((SetFuture) r0).future) + "]";
    L7:
        if ((this instanceof ScheduledFuture) == true) goto L9;
        return null;
    L9:
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    private void addDoneString(StringBuilder r4) {
        Object r1 = getUninterruptibly(this);     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
        r4.append("SUCCESS, result=[").append(userObjectToString(r1)).append("]");     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
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

    private String userObjectToString(Object r1) {
        if (r1 != this) goto L6;
        return "this future";
    L6:
        return String.valueOf(r1);
    }

    private static void executeListener(Runnable r5, Executor r6) {
        r6.execute(r5);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        log.log(Level.SEVERE, "RuntimeException while executing runnable " + r5 + " with executor " + r6, e);
    }

    private static CancellationException cancellationExceptionWithCause(String r1, Throwable r2) {
        CancellationException r0 = new CancellationException(r1);
        r0.initCause(r2);
        return r0;
    }

    static <T> T checkNotNull(T r0) {
        r0.getClass();
        return r0;
    }
}
