package io.reactivex.internal.operators.observable;

import androidx.appcompat.widget.ActivityChooserView;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableReplay<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T>, ResettableConnectable {
    static final BufferSupplier DEFAULT_UNBOUNDED_FACTORY = null;
    final BufferSupplier<T> bufferFactory;
    final AtomicReference<ReplayObserver<T>> current;
    final ObservableSource<T> onSubscribe;
    final ObservableSource<T> source;

    public static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        int size;
        Node tail;

        public BoundedReplayBuffer() {
            Node r0 = new Node(null);
            this.tail = r0;
            set(r0);
        }

        public final void addLast(Node r2) {
            this.tail.set(r2);
            this.tail = r2;
            this.size++;
        }

        public final void collect(Collection<? super T> r4) {
            Node r0 = getHead();
        L3:
            r0 = r0.get();
            if (r0 == null) goto L11;
            Object r1 = leaveTransform(r0.value);
            if (NotificationLite.isComplete(r1) == true) goto L15;
            if (NotificationLite.isError(r1) == true) goto L16;
            r4.add((Object) NotificationLite.getValue(r1));
            goto L3
        L16:
            return;
        L15:
            return;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void complete() {
            addLast(new Node(enterTransform(NotificationLite.complete())));
            truncateFinal();
        }

        public Object enterTransform(Object r1) {
            return r1;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void error(Throwable r2) {
            addLast(new Node(enterTransform(NotificationLite.error(r2))));
            truncateFinal();
        }

        public Node getHead() {
            return get();
        }

        public boolean hasCompleted() {
            Object r0 = this.tail.value;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (NotificationLite.isComplete(leaveTransform(r0)) == false) goto L7;
            return true;
        }

        public boolean hasError() {
            Object r0 = this.tail.value;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (NotificationLite.isError(leaveTransform(r0)) == false) goto L7;
            return true;
        }

        public Object leaveTransform(Object r1) {
            return r1;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void next(T r2) {
            addLast(new Node(enterTransform(NotificationLite.next(r2))));
            truncate();
        }

        public final void removeFirst() {
            Node r0 = get().get();
            this.size--;
            setFirst(r0);
        }

        public final void removeSome(int r3) {
            Node r0 = get();
        L3:
            if (r3 <= 0) goto L5;
            r0 = r0.get();
            r3 = r3 - 1;
            this.size--;
            goto L3
        L5:
            setFirst(r0);
            Node r4 = get();
            if (r4.get() != null) goto L10;
            this.tail = r4;
            return;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void replay(InnerDisposable<T> r6) {
            if (r6.getAndIncrement() == 0) goto L5;
            return;
        L5:
            int r0 = 1;
        L6:
            Node r1 = (Node) r6.index();
            if (r1 != null) goto L10;
            r1 = getHead();
            r6.index = r1;
        L10:
            if (r6.isDisposed() == true) goto L11;
            Node r2 = r1.get();
            if (r2 == null) goto L20;
            if (NotificationLite.accept(leaveTransform(r2.value), r6.child) == true) goto L17;
            r1 = r2;
            goto L10
        L17:
            r6.index = null;
            return;
        L20:
            r6.index = r1;
            r0 = r6.addAndGet(-r0);
            if (r0 != 0) goto L6;
            return;
        L11:
            r6.index = null;
        }

        public final void setFirst(Node r1) {
            set(r1);
        }

        public final void trimHead() {
            Node r0 = get();
            if (r0.value == null) goto L6;
            Node r1 = new Node(null);
            r1.lazySet(r0.get());
            set(r1);
            return;
        }

        public abstract void truncate();

        public void truncateFinal() {
            trimHead();
        }
    }

    public interface BufferSupplier<T> {
        ReplayBuffer<T> call();
    }

    public static final class DisposeConsumer<R> implements Consumer<Disposable> {
        private final ObserverResourceWrapper<R> srw;

        public DisposeConsumer(ObserverResourceWrapper<R> r1) {
            this.srw = r1;
        }

        @Override // io.reactivex.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Disposable r1) {
            accept2(r1);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Disposable r1) {
            this.srw.setResource(r1);
        }
    }

    public static final class InnerDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 2728361546769921047L;
        volatile boolean cancelled;
        final Observer<? super T> child;
        Object index;
        final ReplayObserver<T> parent;

        public InnerDisposable(ReplayObserver<T> r1, Observer<? super T> r2) {
            this.parent = r1;
            this.child = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.parent.remove(this);
            this.index = null;
            return;
        }

        public <U> U index() {
            return (U) this.index;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    public static final class MulticastReplay<R, U> extends Observable<R> {
        private final Callable<? extends ConnectableObservable<U>> connectableFactory;
        private final Function<? super Observable<U>, ? extends ObservableSource<R>> selector;

        public MulticastReplay(Callable<? extends ConnectableObservable<U>> r1, Function<? super Observable<U>, ? extends ObservableSource<R>> r2) {
            this.connectableFactory = r1;
            this.selector = r2;
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(Observer<? super R> r3) {
            ConnectableObservable r0 = (ConnectableObservable) ObjectHelper.requireNonNull(this.connectableFactory.call(), "The connectableFactory returned a null ConnectableObservable");     // Catch: Throwable -> L5
            ObservableSource r2 = (ObservableSource) ObjectHelper.requireNonNull(this.selector.apply(r0), "The selector returned a null ObservableSource");     // Catch: Throwable -> L5
            ObserverResourceWrapper r1 = new ObserverResourceWrapper(r3);
            r2.subscribe(r1);
            r0.connect(new DisposeConsumer(r1));
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, r3);
        }
    }

    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final Object value;

        public Node(Object r1) {
            this.value = r1;
        }
    }

    public static final class Replay<T> extends ConnectableObservable<T> {
        private final ConnectableObservable<T> co;
        private final Observable<T> observable;

        public Replay(ConnectableObservable<T> r1, Observable<T> r2) {
            this.co = r1;
            this.observable = r2;
        }

        @Override // io.reactivex.observables.ConnectableObservable
        public void connect(Consumer<? super Disposable> r1) {
            this.co.connect(r1);
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(Observer<? super T> r1) {
            this.observable.subscribe(r1);
        }
    }

    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable r1);

        void next(T r1);

        void replay(InnerDisposable<T> r1);
    }

    public static final class ReplayBufferSupplier<T> implements BufferSupplier<T> {
        private final int bufferSize;

        public ReplayBufferSupplier(int r1) {
            this.bufferSize = r1;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public ReplayBuffer<T> call() {
            return new SizeBoundReplayBuffer(this.bufferSize);
        }
    }

    public static final class ReplayObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        static final InnerDisposable[] EMPTY = null;
        static final InnerDisposable[] TERMINATED = null;
        private static final long serialVersionUID = -533785617179540163L;
        final ReplayBuffer<T> buffer;
        boolean done;
        final AtomicReference<InnerDisposable[]> observers;
        final AtomicBoolean shouldConnect;

        static {
            EMPTY = new InnerDisposable[0];
            TERMINATED = new InnerDisposable[0];
        }

        public ReplayObserver(ReplayBuffer<T> r2) {
            this.buffer = r2;
            this.observers = new AtomicReference(EMPTY);
            this.shouldConnect = new AtomicBoolean();
        }

        public boolean add(InnerDisposable<T> r5) {
        L2:
            InnerDisposable[] r0 = this.observers.get();
            if (r0 == TERMINATED) goto L4;
            int r1 = r0.length;
            InnerDisposable[] r3 = new InnerDisposable[r1 + 1];
            System.arraycopy(r0, 0, r3, 0, r1);
            r3[r1] = r5;
            if (this.observers.compareAndSet(r0, r3) == false) goto L2;
            return true;
        L4:
            return false;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.observers.set(TERMINATED);
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.observers.get() != TERMINATED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            this.buffer.complete();
            replayFinal();
            return;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.done == true) goto L5;
            this.done = true;
            this.buffer.error(r2);
            replayFinal();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            if (this.done == true) goto L6;
            this.buffer.next(r2);
            replay();
            return;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            if (DisposableHelper.setOnce(this, r1) == false) goto L6;
            replay();
            return;
        }

        public void remove(InnerDisposable<T> r7) {
        L2:
            InnerDisposable[] r0 = this.observers.get();
            int r1 = r0.length;
            if (r1 == 0) goto L4;
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L11;
            if (r0[r3].equals(r7) == true) goto L12;
            r3 = r3 + 1;
        L12:
            if (r3 < 0) goto L13;
            if (r1 != 1) goto L17;
            InnerDisposable[] r2 = EMPTY;
        L19:
            if (this.observers.compareAndSet(r0, r2) == false) goto L2;
            return;
        L17:
            InnerDisposable[] r5 = new InnerDisposable[r1 - 1];
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

        public void replay() {
            InnerDisposable<T>[] r0 = this.observers.get();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            InnerDisposable<T> r3 = r0[r2];
            this.buffer.replay(r3);
            r2 = r2 + 1;
            goto L3
        }

        public void replayFinal() {
            InnerDisposable<T>[] r0 = this.observers.getAndSet(TERMINATED);
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            InnerDisposable<T> r3 = r0[r2];
            this.buffer.replay(r3);
            r2 = r2 + 1;
            goto L3
        }
    }

    public static final class ReplaySource<T> implements ObservableSource<T> {
        private final BufferSupplier<T> bufferFactory;
        private final AtomicReference<ReplayObserver<T>> curr;

        public ReplaySource(AtomicReference<ReplayObserver<T>> r1, BufferSupplier<T> r2) {
            this.curr = r1;
            this.bufferFactory = r2;
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer<? super T> r4) {
        L2:
            ReplayObserver<T> r0 = this.curr.get();
            if (r0 != null) goto L8;
            ReplayObserver<T> r1 = new ReplayObserver(this.bufferFactory.call());
            if (this.curr.compareAndSet(null, r1) == false) goto L2;
            r0 = r1;
        L8:
            InnerDisposable<T> r3 = new InnerDisposable(r0, r4);
            r4.onSubscribe(r3);
            r0.add(r3);
            if (r3.isDisposed() == false) goto L12;
            r0.remove(r3);
            return;
        L12:
            r0.buffer.replay(r3);
        }
    }

    public static final class ScheduledReplaySupplier<T> implements BufferSupplier<T> {
        private final int bufferSize;
        private final long maxAge;
        private final Scheduler scheduler;
        private final TimeUnit unit;

        public ScheduledReplaySupplier(int r1, long r2, TimeUnit r4, Scheduler r5) {
            this.bufferSize = r1;
            this.maxAge = r2;
            this.unit = r4;
            this.scheduler = r5;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public ReplayBuffer<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler);
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final Scheduler scheduler;
        final TimeUnit unit;

        public SizeAndTimeBoundReplayBuffer(int r1, long r2, TimeUnit r4, Scheduler r5) {
            this.scheduler = r5;
            this.limit = r1;
            this.maxAge = r2;
            this.unit = r4;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public Object enterTransform(Object r4) {
            return new Timed(r4, this.scheduler.now(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public Node getHead() {
            long r0 = this.scheduler.now(this.unit) - this.maxAge;
            Node r6 = get();
            Node r2 = r6.get();
        L3:
            Node r3 = r2;
            Node r4 = r6;
            r6 = r3;
            if (r6 == null) goto L14;
            Timed r5 = (Timed) r6.value;
            if (NotificationLite.isComplete(r5.value()) == true) goto L14;
            if (NotificationLite.isError(r5.value()) == true) goto L14;
            if (r5.time() > r0) goto L14;
            r2 = r6.get();
        L14:
            return r4;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public Object leaveTransform(Object r1) {
            return ((Timed) r1).value();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public void truncate() {
            long r0 = this.scheduler.now(this.unit) - this.maxAge;
            Node r2 = get();
            Node r3 = r2.get();
            int r4 = 0;
        L3:
            Node r8 = r3;
            Node r5 = r2;
            r2 = r8;
            if (r2 == null) goto L12;
            int r6 = this.size;
            if (r6 <= this.limit) goto L10;
            if (r6 <= 1) goto L10;
            r4 = r4 + 1;
            this.size = r6 - 1;
            r3 = r2.get();
        L10:
            if (((Timed) r2.value).time() > r0) goto L12;
            r4 = r4 + 1;
            this.size--;
            r3 = r2.get();
        L12:
            if (r4 == 0) goto L23;
            setFirst(r5);
            return;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public void truncateFinal() {
            long r0 = this.scheduler.now(this.unit) - this.maxAge;
            Node r2 = get();
            Node r3 = r2.get();
            int r4 = 0;
        L3:
            Node r9 = r3;
            Node r5 = r2;
            r2 = r9;
            if (r2 == null) goto L10;
            if (this.size <= 1) goto L10;
            if (((Timed) r2.value).time() > r0) goto L10;
            r4 = r4 + 1;
            this.size--;
            r3 = r2.get();
        L10:
            if (r4 == 0) goto L16;
            setFirst(r5);
            return;
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        public SizeBoundReplayBuffer(int r1) {
            this.limit = r1;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public void truncate() {
            if (this.size <= this.limit) goto L6;
            removeFirst();
            return;
        }
    }

    public static final class UnBoundedFactory implements BufferSupplier<Object> {
        public UnBoundedFactory() {
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public ReplayBuffer<Object> call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        public UnboundedReplayBuffer(int r1) {
            super(r1);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void error(Throwable r1) {
            add(NotificationLite.error(r1));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void next(T r1) {
            add(NotificationLite.next(r1));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void replay(InnerDisposable<T> r6) {
            if (r6.getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super T> r0 = r6.child;
            int r1 = 1;
        L7:
            if (r6.isDisposed() == true) goto L8;
            int r2 = this.size;
            Integer r3 = (Integer) r6.index();
            if (r3 == null) goto L12;
            int r4 = r3.intValue();
        L13:
            if (r4 >= r2) goto L21;
            if (NotificationLite.accept(get(r4), r0) == true) goto L16;
            if (r6.isDisposed() == true) goto L19;
            r4 = r4 + 1;
            goto L13
        L19:
            return;
        L16:
            return;
        L21:
            r6.index = Integer.valueOf(r4);
            r1 = r6.addAndGet(-r1);
            if (r1 != 0) goto L7;
            return;
        L12:
            r4 = 0;
            goto L13
        }
    }

    static {
        DEFAULT_UNBOUNDED_FACTORY = new UnBoundedFactory();
    }

    private ObservableReplay(ObservableSource<T> r1, ObservableSource<T> r2, AtomicReference<ReplayObserver<T>> r3, BufferSupplier<T> r4) {
        this.onSubscribe = r1;
        this.source = r2;
        this.current = r3;
        this.bufferFactory = r4;
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> r1, int r2) {
        if (r2 != Integer.MAX_VALUE) goto L7;
        return createFrom(r1);
    L7:
        return create(r1, new ReplayBufferSupplier(r2));
    }

    public static <T> ConnectableObservable<T> createFrom(ObservableSource<? extends T> r1) {
        return create(r1, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <U, R> Observable<R> multicastSelector(Callable<? extends ConnectableObservable<U>> r1, Function<? super Observable<U>, ? extends ObservableSource<R>> r2) {
        return RxJavaPlugins.onAssembly(new MulticastReplay(r1, r2));
    }

    public static <T> ConnectableObservable<T> observeOn(ConnectableObservable<T> r1, Scheduler r2) {
        return RxJavaPlugins.onAssembly(new Replay(r1, r1.observeOn(r2)));
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void connect(Consumer<? super Disposable> r5) {
    L2:
        ReplayObserver<T> r0 = this.current.get();
        if (r0 != null) goto L5;
    L6:
        ReplayObserver<T> r2 = new ReplayObserver(this.bufferFactory.call());
        if (this.current.compareAndSet(r0, r2) == false) goto L2;
        r0 = r2;
    L11:
        if (r0.shouldConnect.get() == false) goto L13;
    L15:
        boolean r1 = false;
    L25:
        r5.accept(r0);     // Catch: Throwable -> L20
        if (r1 == false) goto L30;
        this.source.subscribe(r0);
        return;
    L30:
        return;
    L20:
        th = move-exception;
        if (r1 == false) goto L23;
        r0.shouldConnect.compareAndSet(true, false);
    L23:
        Exceptions.throwIfFatal(th);
        throw ExceptionHelper.wrapOrThrow(th);
    L13:
        if (r0.shouldConnect.compareAndSet(false, true) == false) goto L15;
        r1 = true;
        goto L25
    L5:
        if (r0.isDisposed() == false) goto L11;
        goto L6
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public void resetIf(Disposable r2) {
        this.current.compareAndSet((ReplayObserver) r2, null);
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public ObservableSource<T> source() {
        return this.source;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r1) {
        this.onSubscribe.subscribe(r1);
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> r6, long r7, TimeUnit r9, Scheduler r10) {
        return create(r6, r7, r9, r10, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> r7, long r8, TimeUnit r10, Scheduler r11, int r12) {
        return create(r7, new ScheduledReplaySupplier(r12, r8, r10, r11));
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> r3, BufferSupplier<T> r4) {
        AtomicReference r0 = new AtomicReference();
        return RxJavaPlugins.onAssembly(new ObservableReplay(new ReplaySource(r0, r4), r3, r0, r4));
    }
}
