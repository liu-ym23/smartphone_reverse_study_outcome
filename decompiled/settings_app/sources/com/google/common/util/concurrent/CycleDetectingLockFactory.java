package com.google.common.util.concurrent;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public class CycleDetectingLockFactory {
    private static final ThreadLocal<ArrayList<LockGraphNode>> acquiredLocks = null;
    private static final ConcurrentMap<Class<? extends Enum<?>>, Map<? extends Enum<?>, LockGraphNode>> lockGraphNodesPerType = null;
    private static final Logger logger = null;
    final Policy policy;

    private interface CycleDetectingLock {
        LockGraphNode getLockGraphNode();

        boolean isAcquiredByCurrentThread();
    }

    final class CycleDetectingReentrantLock extends ReentrantLock implements CycleDetectingLock {
        private final LockGraphNode lockGraphNode;
        final /* synthetic */ CycleDetectingLockFactory this$0;

        /* synthetic */ CycleDetectingReentrantLock(CycleDetectingLockFactory r1, LockGraphNode r2, boolean r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        private CycleDetectingReentrantLock(CycleDetectingLockFactory r1, LockGraphNode r2, boolean r3) {
            this.this$0 = r1;
            super(r3);
            this.lockGraphNode = (LockGraphNode) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public LockGraphNode getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public boolean isAcquiredByCurrentThread() {
            return isHeldByCurrentThread();
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.access$600(this.this$0, this);
            super.lock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.access$600(this.this$0, this);
            super.lockInterruptibly();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.access$600(this.this$0, this);
            boolean r0 = super.tryLock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this);
            return r0;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long r2, TimeUnit r4) throws InterruptedException {
            CycleDetectingLockFactory.access$600(this.this$0, this);
            boolean r3 = super.tryLock(r2, r4);     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this);
            return r3;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void unlock() {
            super.unlock();     // Catch: Throwable -> L5
            CycleDetectingLockFactory.access$700(this);
            return;
        L5:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this);
            throw th;
        }
    }

    private class CycleDetectingReentrantReadLock extends ReentrantReadWriteLock.ReadLock {
        final CycleDetectingReentrantReadWriteLock readWriteLock;
        final /* synthetic */ CycleDetectingLockFactory this$0;

        CycleDetectingReentrantReadLock(CycleDetectingLockFactory r1, CycleDetectingReentrantReadWriteLock r2) {
            this.this$0 = r1;
            super(r2);
            this.readWriteLock = r2;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            super.lock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            super.lockInterruptibly();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            boolean r0 = super.tryLock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return r0;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long r3, TimeUnit r5) throws InterruptedException {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            boolean r4 = super.tryLock(r3, r5);     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return r4;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void unlock() {
            super.unlock();     // Catch: Throwable -> L5
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return;
        L5:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }
    }

    final class CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements CycleDetectingLock {
        private final LockGraphNode lockGraphNode;
        private final CycleDetectingReentrantReadLock readLock;
        private final CycleDetectingReentrantWriteLock writeLock;

        /* synthetic */ CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory r1, LockGraphNode r2, boolean r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public /* bridge */ /* synthetic */ Lock readLock() {
            return readLock();
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public /* bridge */ /* synthetic */ Lock writeLock() {
            return writeLock();
        }

        private CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory r1, LockGraphNode r2, boolean r3) {
            super(r3);
            this.readLock = new CycleDetectingReentrantReadLock(r1, this);
            this.writeLock = new CycleDetectingReentrantWriteLock(r1, this);
            this.lockGraphNode = (LockGraphNode) Preconditions.checkNotNull(r2);
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.ReadLock readLock() {
            return this.readLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.WriteLock writeLock() {
            return this.writeLock;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public LockGraphNode getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public boolean isAcquiredByCurrentThread() {
            if (isWriteLockedByCurrentThread() == false) goto L5;
        L8:
            return true;
        L5:
            if (getReadHoldCount() > 0) goto L8;
            return false;
        }
    }

    private class CycleDetectingReentrantWriteLock extends ReentrantReadWriteLock.WriteLock {
        final CycleDetectingReentrantReadWriteLock readWriteLock;
        final /* synthetic */ CycleDetectingLockFactory this$0;

        CycleDetectingReentrantWriteLock(CycleDetectingLockFactory r1, CycleDetectingReentrantReadWriteLock r2) {
            this.this$0 = r1;
            super(r2);
            this.readWriteLock = r2;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            super.lock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            super.lockInterruptibly();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            boolean r0 = super.tryLock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return r0;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long r3, TimeUnit r5) throws InterruptedException {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            boolean r4 = super.tryLock(r3, r5);     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return r4;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void unlock() {
            super.unlock();     // Catch: Throwable -> L5
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return;
        L5:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }
    }

    private static class ExampleStackTrace extends IllegalStateException {
        static final StackTraceElement[] EMPTY_STACK_TRACE = null;
        static final ImmutableSet<String> EXCLUDED_CLASS_NAMES = null;

        static {
            EMPTY_STACK_TRACE = new StackTraceElement[0];
            EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), LockGraphNode.class.getName());
        }

        ExampleStackTrace(LockGraphNode r4, LockGraphNode r5) {
            String r6 = r4.getLockName();
            String r7 = r5.getLockName();
            super(new StringBuilder((String.valueOf(r6).length() + 4) + String.valueOf(r7).length()).append(r6).append(" -> ").append(r7).toString());
            StackTraceElement[] r8 = getStackTrace();
            int r9 = r8.length;
            int r0 = 0;
        L3:
            if (r0 >= r9) goto L16;
            if (WithExplicitOrdering.class.getName().equals(r8[r0].getClassName()) == true) goto L6;
            if (EXCLUDED_CLASS_NAMES.contains(r8[r0].getClassName()) == false) goto L9;
            r0 = r0 + 1;
            goto L3
        L9:
            setStackTrace((StackTraceElement[]) Arrays.copyOfRange(r8, r0, r9));
            return;
        L6:
            setStackTrace(EMPTY_STACK_TRACE);
            return;
        }
    }

    private static class LockGraphNode {
        final Map<LockGraphNode, ExampleStackTrace> allowedPriorLocks;
        final Map<LockGraphNode, PotentialDeadlockException> disallowedPriorLocks;
        final String lockName;

        LockGraphNode(String r2) {
            this.allowedPriorLocks = new MapMaker().weakKeys().makeMap();
            this.disallowedPriorLocks = new MapMaker().weakKeys().makeMap();
            this.lockName = (String) Preconditions.checkNotNull(r2);
        }

        String getLockName() {
            return this.lockName;
        }

        void checkAcquiredLocks(Policy r2, List<LockGraphNode> r3) {
            Iterator<LockGraphNode> r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            checkAcquiredLock(r2, r4.next());
            goto L4
        }

        void checkAcquiredLock(Policy r4, LockGraphNode r5) {
            if (this == r5) goto L4;
            boolean r0 = true;
        L5:
            Preconditions.checkState(r0, "Attempted to acquire multiple locks with the same rank %s", r5.getLockName());
            if (this.allowedPriorLocks.containsKey(r5) == false) goto L8;
            return;
        L8:
            PotentialDeadlockException r1 = this.disallowedPriorLocks.get(r5);
            AnonymousClass1 r2 = null;
            if (r1 == null) goto L12;
            r4.handlePotentialDeadlock(new PotentialDeadlockException(r5, this, r1.getConflictingStackTrace(), r2));
            return;
        L12:
            ExampleStackTrace r3 = r5.findPathTo(this, Sets.newIdentityHashSet());
            if (r3 != null) goto L15;
            this.allowedPriorLocks.put(r5, new ExampleStackTrace(r5, this));
            return;
        L15:
            PotentialDeadlockException r6 = new PotentialDeadlockException(r5, this, r3, r2);
            this.disallowedPriorLocks.put(r5, r6);
            r4.handlePotentialDeadlock(r6);
            return;
        L4:
            r0 = false;
            goto L5
        }

        @CheckForNull
        private ExampleStackTrace findPathTo(LockGraphNode r6, Set<LockGraphNode> r7) {
            if (r7.add(this) == true) goto L5;
            return null;
        L5:
            ExampleStackTrace r0 = this.allowedPriorLocks.get(r6);
            if (r0 == null) goto L8;
            return r0;
        L8:
            Iterator<Map.Entry<LockGraphNode, ExampleStackTrace>> r1 = this.allowedPriorLocks.entrySet().iterator();
        L10:
            if (r1.hasNext() == false) goto L15;
            Map.Entry<LockGraphNode, ExampleStackTrace> r2 = r1.next();
            LockGraphNode r3 = r2.getKey();
            ExampleStackTrace r4 = r3.findPathTo(r6, r7);
            if (r4 == null) goto L10;
            ExampleStackTrace r8 = new ExampleStackTrace(r3, this);
            r8.setStackTrace(r2.getValue().getStackTrace());
            r8.initCause(r4);
            return r8;
        L15:
            return null;
        }
    }

    public static abstract enum Policies extends Enum<Policies> implements Policy {
        private static final /* synthetic */ Policies[] $VALUES = null;
        public static final Policies DISABLED = null;
        public static final Policies THROW = null;
        public static final Policies WARN = null;

        private static /* synthetic */ Policies[] $values() {
            return new Policies[]{THROW, WARN, DISABLED};
        }

        public static Policies valueOf(String r1) {
            return (Policies) Enum.valueOf(Policies.class, r1);
        }

        public static Policies[] values() {
            return (Policies[]) $VALUES.clone();
        }

        private Policies(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ Policies(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static {
            final String r1 = "THROW";
            final int r2 = 0;
            THROW = new AnonymousClass1(r1, r2);
            final String r3 = "WARN";
            final int r4 = 1;
            WARN = new AnonymousClass2(r3, r4);
            final String r5 = "DISABLED";
            final int r6 = 2;
            DISABLED = new AnonymousClass3(r5, r6);
            $VALUES = $values();
        }
    }

    public interface Policy {
        void handlePotentialDeadlock(PotentialDeadlockException r1);
    }

    public static final class PotentialDeadlockException extends ExampleStackTrace {
        private final ExampleStackTrace conflictingStackTrace;

        /* synthetic */ PotentialDeadlockException(LockGraphNode r1, LockGraphNode r2, ExampleStackTrace r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        private PotentialDeadlockException(LockGraphNode r1, LockGraphNode r2, ExampleStackTrace r3) {
            super(r1, r2);
            this.conflictingStackTrace = r3;
            initCause(r3);
        }

        public ExampleStackTrace getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuilder r0 = new StringBuilder((String) Objects.requireNonNull(super.getMessage()));
            Throwable r3 = this.conflictingStackTrace;
        L3:
            if (r3 == null) goto L6;
            r0.append(", ").append(r3.getMessage());
            r3 = r3.getCause();
            goto L3
        L6:
            return r0.toString();
        }
    }

    public static final class WithExplicitOrdering<E extends Enum<E>> extends CycleDetectingLockFactory {
        private final Map<E, LockGraphNode> lockGraphNodes;

        WithExplicitOrdering(Policy r2, Map<E, LockGraphNode> r3) {
            super(r2, null);
            this.lockGraphNodes = r3;
        }

        public ReentrantLock newReentrantLock(E r2) {
            return newReentrantLock(r2, false);
        }

        public ReentrantLock newReentrantLock(E r3, boolean r4) {
            if (this.policy != Policies.DISABLED) goto L6;
            return new ReentrantLock(r4);
        L6:
            return new CycleDetectingReentrantLock(this, (LockGraphNode) Objects.requireNonNull(this.lockGraphNodes.get(r3)), r4, null);
        }

        public ReentrantReadWriteLock newReentrantReadWriteLock(E r2) {
            return newReentrantReadWriteLock(r2, false);
        }

        public ReentrantReadWriteLock newReentrantReadWriteLock(E r3, boolean r4) {
            if (this.policy != Policies.DISABLED) goto L6;
            return new ReentrantReadWriteLock(r4);
        L6:
            return new CycleDetectingReentrantReadWriteLock(this, (LockGraphNode) Objects.requireNonNull(this.lockGraphNodes.get(r3)), r4, null);
        }
    }

    /* synthetic */ CycleDetectingLockFactory(Policy r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ Logger access$100() {
        return logger;
    }

    static /* synthetic */ void access$600(CycleDetectingLockFactory r0, CycleDetectingLock r1) {
        r0.aboutToAcquire(r1);
    }

    static /* synthetic */ void access$700(CycleDetectingLock r0) {
        lockStateChanged(r0);
    }

    public static CycleDetectingLockFactory newInstance(Policy r1) {
        return new CycleDetectingLockFactory(r1);
    }

    public ReentrantLock newReentrantLock(String r2) {
        return newReentrantLock(r2, false);
    }

    public ReentrantLock newReentrantLock(String r3, boolean r4) {
        if (this.policy != Policies.DISABLED) goto L6;
        return new ReentrantLock(r4);
    L6:
        return new CycleDetectingReentrantLock(this, new LockGraphNode(r3), r4, null);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String r2) {
        return newReentrantReadWriteLock(r2, false);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String r3, boolean r4) {
        if (this.policy != Policies.DISABLED) goto L6;
        return new ReentrantReadWriteLock(r4);
    L6:
        return new CycleDetectingReentrantReadWriteLock(this, new LockGraphNode(r3), r4, null);
    }

    static {
        lockGraphNodesPerType = new MapMaker().weakKeys().makeMap();
        logger = Logger.getLogger(CycleDetectingLockFactory.class.getName());
        acquiredLocks = new AnonymousClass1();
    }

    public static <E extends Enum<E>> WithExplicitOrdering<E> newInstanceWithExplicitOrdering(Class<E> r1, Policy r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new WithExplicitOrdering(r2, getOrCreateNodes(r1));
    }

    private static <E extends Enum<E>> Map<? extends E, LockGraphNode> getOrCreateNodes(Class<E> r2) {
        ConcurrentMap<Class<? extends Enum<?>>, Map<? extends Enum<?>, LockGraphNode>> r0 = lockGraphNodesPerType;
        Map<? extends E, LockGraphNode> r1 = (Map) r0.get(r2);
        if (r1 == null) goto L5;
        return r1;
    L5:
        Map<? extends Enum<?>, LockGraphNode> r3 = createNodes(r2);
        return (Map) MoreObjects.firstNonNull(r0.putIfAbsent(r2, r3), r3);
    }

    static <E extends Enum<E>> Map<E, LockGraphNode> createNodes(Class<E> r9) {
        EnumMap r0 = Maps.newEnumMap(r9);
        E[] r10 = r9.getEnumConstants();
        int r1 = r10.length;
        ArrayList r2 = Lists.newArrayListWithCapacity(r1);
        int r3 = r10.length;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        E r6 = r10[r5];
        LockGraphNode r7 = new LockGraphNode(getLockName(r6));
        r2.add(r7);
        r0.put(r6, r7);
        r5 = r5 + 1;
        goto L3
    L5:
        int r11 = 1;
    L6:
        if (r11 >= r1) goto L9;
        ((LockGraphNode) r2.get(r11)).checkAcquiredLocks(Policies.THROW, r2.subList(0, r11));
        r11 = r11 + 1;
    L9:
        if (r4 >= (r1 - 1)) goto L12;
        r4 = r4 + 1;
        ((LockGraphNode) r2.get(r4)).checkAcquiredLocks(Policies.DISABLED, r2.subList(r4, r1));
        goto L9
    L12:
        return Collections.unmodifiableMap(r0);
    }

    private static String getLockName(Enum<?> r3) {
        String r0 = r3.getDeclaringClass().getSimpleName();
        String r4 = r3.name();
        return new StringBuilder((String.valueOf(r0).length() + 1) + String.valueOf(r4).length()).append(r0).append(".").append(r4).toString();
    }

    private CycleDetectingLockFactory(Policy r1) {
        this.policy = (Policy) Preconditions.checkNotNull(r1);
    }

    private void aboutToAcquire(CycleDetectingLock r2) {
        if (r2.isAcquiredByCurrentThread() == true) goto L6;
        ArrayList<LockGraphNode> r0 = acquiredLocks.get();
        LockGraphNode r3 = r2.getLockGraphNode();
        r3.checkAcquiredLocks(this.policy, r0);
        r0.add(r3);
        return;
    }

    private static void lockStateChanged(CycleDetectingLock r3) {
        if (r3.isAcquiredByCurrentThread() == true) goto L10;
        ArrayList<LockGraphNode> r0 = acquiredLocks.get();
        LockGraphNode r4 = r3.getLockGraphNode();
        int r1 = r0.size() - 1;
    L5:
        if (r1 < 0) goto L14;
        if (r0.get(r1) == r4) goto L8;
        r1 = r1 - 1;
        goto L5
    L8:
        r0.remove(r1);
        return;
    L14:
        return;
    }
}
