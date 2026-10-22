package com.google.common.util.concurrent;

import com.google.common.collect.Sets;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class AggregateFutureState<OutputT> extends AbstractFuture.TrustedFuture<OutputT> {
    private static final AtomicHelper ATOMIC_HELPER = null;
    private static final Logger log = null;
    private volatile int remaining;

    @CheckForNull
    private volatile Set<Throwable> seenExceptions;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.AggregateFutureState$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static abstract class AtomicHelper {
        abstract void compareAndSetSeenExceptions(AggregateFutureState<?> r1, @CheckForNull Set<Throwable> r2, Set<Throwable> r3);

        abstract int decrementAndGetRemainingCount(AggregateFutureState<?> r1);

        private AtomicHelper() {
        }

        /* synthetic */ AtomicHelper(AnonymousClass1 r1) {
            this();
        }
    }

    private static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicIntegerFieldUpdater<AggregateFutureState<?>> remainingCountUpdater;
        final AtomicReferenceFieldUpdater<AggregateFutureState<?>, Set<Throwable>> seenExceptionsUpdater;

        SafeAtomicHelper(AtomicReferenceFieldUpdater r2, AtomicIntegerFieldUpdater r3) {
            super(null);
            this.seenExceptionsUpdater = r2;
            this.remainingCountUpdater = r3;
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        void compareAndSetSeenExceptions(AggregateFutureState<?> r1, @CheckForNull Set<Throwable> r2, Set<Throwable> r3) {
            this.seenExceptionsUpdater.compareAndSet(r1, r2, r3);
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        int decrementAndGetRemainingCount(AggregateFutureState<?> r1) {
            return this.remainingCountUpdater.decrementAndGet(r1);
        }
    }

    private static final class SynchronizedAtomicHelper extends AtomicHelper {
        private SynchronizedAtomicHelper() {
            super(null);
        }

        /* synthetic */ SynchronizedAtomicHelper(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        void compareAndSetSeenExceptions(AggregateFutureState<?> r1, @CheckForNull Set<Throwable> r2, Set<Throwable> r3) {
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (AggregateFutureState.access$200(r1) != r2) goto L6;
            AggregateFutureState.access$202(r1, r3);     // Catch: Throwable -> L8
        L6:
            monitor-exit(r1);     // Catch: Throwable -> L8
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        int decrementAndGetRemainingCount(AggregateFutureState<?> r1) {
            monitor-enter(r1);
            int r0 = AggregateFutureState.access$306(r1);     // Catch: Throwable -> L6
            monitor-exit(r1);     // Catch: Throwable -> L6
            return r0;
        L6:
            th = move-exception;
            throw th;
        }
    }

    abstract void addInitialException(Set<Throwable> r1);

    static /* synthetic */ Set access$200(AggregateFutureState r0) {
        return r0.seenExceptions;
    }

    static /* synthetic */ Set access$202(AggregateFutureState r0, Set r1) {
        r0.seenExceptions = r1;
        return r1;
    }

    static /* synthetic */ int access$306(AggregateFutureState r1) {
        int r0 = r1.remaining - 1;
        r1.remaining = r0;
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        log = Logger.getLogger(AggregateFutureState.class.getName());
        Throwable r1 = null;
        Object[] r2 = 0;
        AtomicHelper r3 = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "remaining"));     // Catch: Throwable -> L5
    L7:
        ATOMIC_HELPER = r3;
        if (r1 == null) goto L13;
        log.log(Level.SEVERE, "SafeAtomicHelper is broken!", r1);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        r3 = new SynchronizedAtomicHelper(r2 == true ? 1 : 0);
        r1 = th;
        goto L7
    }

    AggregateFutureState(int r2) {
        this.seenExceptions = null;
        this.remaining = r2;
    }

    final Set<Throwable> getOrInitSeenExceptions() {
        Set<Throwable> r0 = this.seenExceptions;
        if (r0 != null) goto L6;
        Set<Throwable> r1 = Sets.newConcurrentHashSet();
        addInitialException(r1);
        ATOMIC_HELPER.compareAndSetSeenExceptions(this, null, r1);
        return (Set) Objects.requireNonNull(this.seenExceptions);
    L6:
        return r0;
    }

    final int decrementRemainingAndGet() {
        return ATOMIC_HELPER.decrementAndGetRemainingCount(this);
    }

    final void clearSeenExceptions() {
        this.seenExceptions = null;
    }
}
