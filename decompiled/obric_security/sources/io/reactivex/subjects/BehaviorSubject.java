package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public final class BehaviorSubject<T> extends Subject<T> {
    static final BehaviorDisposable[] EMPTY = null;
    private static final Object[] EMPTY_ARRAY = null;
    static final BehaviorDisposable[] TERMINATED = null;
    long index;
    final ReadWriteLock lock;
    final Lock readLock;
    final AtomicReference<BehaviorDisposable<T>[]> subscribers;
    final AtomicReference<Throwable> terminalEvent;
    final AtomicReference<Object> value;
    final Lock writeLock;

    static final class BehaviorDisposable<T> implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        volatile boolean cancelled;
        final Observer<? super T> downstream;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        AppendOnlyLinkedArrayList<Object> queue;
        final BehaviorSubject<T> state;

        BehaviorDisposable(Observer<? super T> r1, BehaviorSubject<T> r2) {
            this.downstream = r1;
            this.state = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.state.remove(this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void emitFirst() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            monitor-enter(this);
        L26:
            th = move-exception;
            throw th;
        L7:
            if (this.cancelled == false) goto L11;
            monitor-exit(this);     // Catch: Throwable -> L26
            return;
        L11:
            if (this.next == false) goto L14;
            monitor-exit(this);     // Catch: Throwable -> L26
            return;
        L14:
            BehaviorSubject<T> r0 = this.state;     // Catch: Throwable -> L26
            Lock r1 = r0.readLock;     // Catch: Throwable -> L26
            r1.lock();     // Catch: Throwable -> L26
            this.index = r0.index;     // Catch: Throwable -> L26
            Object r2 = r0.value.get();     // Catch: Throwable -> L26
            r1.unlock();     // Catch: Throwable -> L26
            if (r2 == null) goto L17;
            boolean r3 = true;
        L18:
            this.emitting = r3;     // Catch: Throwable -> L26
            this.next = true;     // Catch: Throwable -> L26
            monitor-exit(this);     // Catch: Throwable -> L26
            if (r2 != null) goto L22;
            return;
        L22:
            if (test(r2) == false) goto L24;
            return;
        L24:
            emitLoop();
            return;
        L17:
            r3 = false;
            goto L18
        }

        void emitNext(Object r3, long r4) {
            if (this.cancelled == false) goto L6;
            return;
        L6:
            if (this.fastPath == true) goto L30;
            monitor-enter(this);
        L27:
            th = move-exception;
            throw th;
        L9:
            if (this.cancelled == false) goto L13;
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L13:
            if (this.index != r4) goto L17;
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L17:
            if (this.emitting == false) goto L24;
            AppendOnlyLinkedArrayList<Object> r5 = this.queue;     // Catch: Throwable -> L27
            if (r5 != null) goto L21;
            r5 = new AppendOnlyLinkedArrayList(4);     // Catch: Throwable -> L27
            this.queue = r5;     // Catch: Throwable -> L27
        L21:
            r5.add(r3);     // Catch: Throwable -> L27
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L24:
            this.next = true;     // Catch: Throwable -> L27
            monitor-exit(this);     // Catch: Throwable -> L27
            this.fastPath = true;
        L30:
            test(r3);
        }

        @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
        public boolean test(Object r2) {
            if (this.cancelled == false) goto L5;
        L8:
            return true;
        L5:
            if (NotificationLite.accept(r2, this.downstream) == true) goto L8;
            return false;
        }

        void emitLoop() {
        L3:
            if (this.cancelled == true) goto L4;
            monitor-enter(this);
            AppendOnlyLinkedArrayList<Object> r0 = this.queue;     // Catch: Throwable -> L14
            if (r0 == null) goto L8;
            this.queue = null;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            r0.forEachWhile(this);
            goto L3
        L8:
            this.emitting = false;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    static {
        EMPTY_ARRAY = new Object[0];
        EMPTY = new BehaviorDisposable[0];
        TERMINATED = new BehaviorDisposable[0];
    }

    @CheckReturnValue
    public static <T> BehaviorSubject<T> create() {
        return new BehaviorSubject();
    }

    @CheckReturnValue
    public static <T> BehaviorSubject<T> createDefault(T r1) {
        return new BehaviorSubject(r1);
    }

    BehaviorSubject() {
        ReentrantReadWriteLock r0 = new ReentrantReadWriteLock();
        this.lock = r0;
        this.readLock = r0.readLock();
        this.writeLock = r0.writeLock();
        this.subscribers = new AtomicReference(EMPTY);
        this.value = new AtomicReference();
        this.terminalEvent = new AtomicReference();
    }

    BehaviorSubject(T r2) {
        this();
        this.value.lazySet(ObjectHelper.requireNonNull(r2, "defaultValue is null"));
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r3) {
        BehaviorDisposable<T> r0 = new BehaviorDisposable(r3, this);
        r3.onSubscribe(r0);
        if (add(r0) == true) goto L5;
        Throwable r2 = this.terminalEvent.get();
        if (r2 != ExceptionHelper.TERMINATED) goto L11;
        r3.onComplete();
        return;
    L11:
        r3.onError(r2);
        return;
    L5:
        if (r0.cancelled == false) goto L7;
        remove(r0);
        return;
    L7:
        r0.emitFirst();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r1) {
        if (this.terminalEvent.get() == null) goto L6;
        r1.dispose();
        return;
    }

    @Override // io.reactivex.Observer
    public void onNext(T r7) {
        ObjectHelper.requireNonNull(r7, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.terminalEvent.get() == null) goto L5;
        return;
    L5:
        Object r8 = NotificationLite.next(r7);
        setCurrent(r8);
        BehaviorDisposable<T>[] r0 = this.subscribers.get();
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        r0[r2].emitNext(r8, this.index);
        r2 = r2 + 1;
        goto L6
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r7) {
        ObjectHelper.requireNonNull(r7, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (b0$$ExternalSyntheticBackport0.m(this.terminalEvent, null, r7) == true) goto L6;
        RxJavaPlugins.onError(r7);
        return;
    L6:
        Object r8 = NotificationLite.error(r7);
        BehaviorDisposable<T>[] r0 = terminate(r8);
        int r1 = r0.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        r0[r2].emitNext(r8, this.index);
        r2 = r2 + 1;
        goto L7
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (b0$$ExternalSyntheticBackport0.m(this.terminalEvent, null, ExceptionHelper.TERMINATED) == true) goto L5;
        return;
    L5:
        Object r0 = NotificationLite.complete();
        BehaviorDisposable<T>[] r1 = terminate(r0);
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        r1[r3].emitNext(r0, this.index);
        r3 = r3 + 1;
        goto L6
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        if (this.subscribers.get().length == 0) goto L5;
        return true;
    L5:
        return false;
    }

    int subscriberCount() {
        return this.subscribers.get().length;
    }

    @Override // io.reactivex.subjects.Subject
    public Throwable getThrowable() {
        Object r1 = this.value.get();
        if (NotificationLite.isError(r1) == true) goto L5;
        return null;
    L5:
        return NotificationLite.getError(r1);
    }

    public T getValue() {
        Object r1 = this.value.get();
        if (NotificationLite.isComplete(r1) == false) goto L5;
        return null;
    L5:
        if (NotificationLite.isError(r1) == false) goto L8;
        return null;
    L8:
        return (T) NotificationLite.getValue(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public Object[] getValues() {
        Object[] r0 = EMPTY_ARRAY;
        Object[] r2 = getValues(r0);
        if (r2 == r0) goto L5;
        return r2;
    L5:
        return new Object[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public T[] getValues(T[] r5) {
        Object r4 = this.value.get();
        if (r4 == null) goto L17;
        if (NotificationLite.isComplete(r4) == true) goto L17;
        if (NotificationLite.isError(r4) == true) goto L17;
        Object r6 = NotificationLite.getValue(r4);
        if (r5.length == 0) goto L14;
        r5[0] = r6;
        if (r5.length == 1) goto L20;
        r5[1] = 0;
        return r5;
    L20:
        return r5;
    L14:
        T[] r7 = (T[]) ((Object[]) Array.newInstance(r5.getClass().getComponentType(), 1));
        r7[0] = r6;
        return r7;
    L17:
        if (r5.length == 0) goto L19;
        r5[0] = 0;
    L19:
        return r5;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return NotificationLite.isComplete(this.value.get());
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return NotificationLite.isError(this.value.get());
    }

    public boolean hasValue() {
        Object r1 = this.value.get();
        if (r1 != null) goto L5;
    L9:
        return false;
    L5:
        if (NotificationLite.isComplete(r1) == true) goto L9;
        if (NotificationLite.isError(r1) == true) goto L9;
        return true;
    }

    boolean add(BehaviorDisposable<T> r5) {
    L2:
        BehaviorDisposable<T>[] r0 = this.subscribers.get();
        if (r0 == TERMINATED) goto L4;
        int r1 = r0.length;
        BehaviorDisposable[] r3 = new BehaviorDisposable[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (b0$$ExternalSyntheticBackport0.m(this.subscribers, r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void remove(BehaviorDisposable<T> r7) {
    L2:
        BehaviorDisposable<T>[] r0 = this.subscribers.get();
        int r1 = r0.length;
        if (r1 == 0) goto L4;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L11;
        if (r0[r3] == r7) goto L12;
        r3 = r3 + 1;
    L12:
        if (r3 < 0) goto L13;
        if (r1 != 1) goto L17;
        BehaviorDisposable[] r2 = EMPTY;
    L19:
        if (b0$$ExternalSyntheticBackport0.m(this.subscribers, r0, r2) == false) goto L2;
        return;
    L17:
        BehaviorDisposable[] r5 = new BehaviorDisposable[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r3);
        System.arraycopy(r0, r3 + 1, r5, r3, (r1 - r3) - 1);
        r2 = r5;
        goto L19
    L13:
        return;
    L11:
        r3 = -1;
        goto L12
    }

    BehaviorDisposable<T>[] terminate(Object r3) {
        AtomicReference<BehaviorDisposable<T>[]> r0 = this.subscribers;
        BehaviorDisposable<T>[] r1 = TERMINATED;
        BehaviorDisposable<T>[] r2 = r0.getAndSet(r1);
        if (r2 == r1) goto L5;
        setCurrent(r3);
    L5:
        return r2;
    }

    void setCurrent(Object r5) {
        this.writeLock.lock();
        this.index++;
        this.value.lazySet(r5);
        this.writeLock.unlock();
    }
}
