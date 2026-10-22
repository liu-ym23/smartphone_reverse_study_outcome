package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableInternalHelper {

    public static final class BufferedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        private final int bufferSize;
        private final Observable<T> parent;

        public BufferedReplayCallable(Observable<T> r1, int r2) {
            this.parent = r1;
            this.bufferSize = r2;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            return this.parent.replay(this.bufferSize);
        }
    }

    public static final class BufferedTimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        private final int bufferSize;
        private final Observable<T> parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        public BufferedTimedReplayCallable(Observable<T> r1, int r2, long r3, TimeUnit r5, Scheduler r6) {
            this.parent = r1;
            this.bufferSize = r2;
            this.time = r3;
            this.unit = r5;
            this.scheduler = r6;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            return this.parent.replay(this.bufferSize, this.time, this.unit, this.scheduler);
        }
    }

    public static final class FlatMapIntoIterable<T, U> implements Function<T, ObservableSource<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> mapper;

        public FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> r1) {
            this.mapper = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply(r1);
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<U> apply(T r2) {
            return new ObservableFromIterable((Iterable) ObjectHelper.requireNonNull(this.mapper.apply(r2), "The mapper returned a null Iterable"));
        }
    }

    public static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;
        private final T t;

        public FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> r1, T r2) {
            this.combiner = r1;
            this.t = r2;
        }

        @Override // io.reactivex.functions.Function
        public R apply(U r2) {
            return this.combiner.apply(this.t, r2);
        }
    }

    public static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, ObservableSource<R>> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;
        private final Function<? super T, ? extends ObservableSource<? extends U>> mapper;

        public FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> r1, Function<? super T, ? extends ObservableSource<? extends U>> r2) {
            this.combiner = r1;
            this.mapper = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply(r1);
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<R> apply(T r4) {
            return new ObservableMap((ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(r4), "The mapper returned a null ObservableSource"), new FlatMapWithCombinerInner(this.combiner, r4));
        }
    }

    public static final class ItemDelayFunction<T, U> implements Function<T, ObservableSource<T>> {
        final Function<? super T, ? extends ObservableSource<U>> itemDelay;

        public ItemDelayFunction(Function<? super T, ? extends ObservableSource<U>> r1) {
            this.itemDelay = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply(r1);
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<T> apply(T r4) {
            return new ObservableTake((ObservableSource) ObjectHelper.requireNonNull(this.itemDelay.apply(r4), "The itemDelay returned a null ObservableSource"), 1).map(Functions.justFunction(r4)).defaultIfEmpty(r4);
        }
    }

    public static final enum MapToInt extends Enum<MapToInt> implements Function<Object, Object> {
        private static final /* synthetic */ MapToInt[] $VALUES = null;
        public static final MapToInt INSTANCE = null;

        static {
            MapToInt r0 = new MapToInt("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new MapToInt[]{r0};
        }

        private MapToInt(String r1, int r2) {
            super(r1, r2);
        }

        public static MapToInt valueOf(String r1) {
            return (MapToInt) Enum.valueOf(MapToInt.class, r1);
        }

        public static MapToInt[] values() {
            return (MapToInt[]) $VALUES.clone();
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object r1) {
            return 0;
        }
    }

    public static final class ObserverOnComplete<T> implements Action {
        final Observer<T> observer;

        public ObserverOnComplete(Observer<T> r1) {
            this.observer = r1;
        }

        @Override // io.reactivex.functions.Action
        public void run() {
            this.observer.onComplete();
        }
    }

    public static final class ObserverOnError<T> implements Consumer<Throwable> {
        final Observer<T> observer;

        public ObserverOnError(Observer<T> r1) {
            this.observer = r1;
        }

        @Override // io.reactivex.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Throwable r1) {
            accept2(r1);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Throwable r1) {
            this.observer.onError(r1);
        }
    }

    public static final class ObserverOnNext<T> implements Consumer<T> {
        final Observer<T> observer;

        public ObserverOnNext(Observer<T> r1) {
            this.observer = r1;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T r1) {
            this.observer.onNext(r1);
        }
    }

    public static final class ReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        private final Observable<T> parent;

        public ReplayCallable(Observable<T> r1) {
            this.parent = r1;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            return this.parent.replay();
        }
    }

    public static final class ReplayFunction<T, R> implements Function<Observable<T>, ObservableSource<R>> {
        private final Scheduler scheduler;
        private final Function<? super Observable<T>, ? extends ObservableSource<R>> selector;

        public ReplayFunction(Function<? super Observable<T>, ? extends ObservableSource<R>> r1, Scheduler r2) {
            this.selector = r1;
            this.scheduler = r2;
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply((Observable) r1);
        }

        public ObservableSource<R> apply(Observable<T> r2) {
            return Observable.wrap((ObservableSource) ObjectHelper.requireNonNull(this.selector.apply(r2), "The selector returned a null ObservableSource")).observeOn(this.scheduler);
        }
    }

    public static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final BiConsumer<S, Emitter<T>> consumer;

        public SimpleBiGenerator(BiConsumer<S, Emitter<T>> r1) {
            this.consumer = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiFunction
        public /* bridge */ /* synthetic */ Object apply(Object r1, Object r2) {
            return apply(r1, (Emitter) r2);
        }

        public S apply(S r1, Emitter<T> r2) {
            this.consumer.accept(r1, r2);
            return r1;
        }
    }

    public static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final Consumer<Emitter<T>> consumer;

        public SimpleGenerator(Consumer<Emitter<T>> r1) {
            this.consumer = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiFunction
        public /* bridge */ /* synthetic */ Object apply(Object r1, Object r2) {
            return apply(r1, (Emitter) r2);
        }

        public S apply(S r1, Emitter<T> r2) {
            this.consumer.accept(r2);
            return r1;
        }
    }

    public static final class TimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        private final Observable<T> parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        public TimedReplayCallable(Observable<T> r1, long r2, TimeUnit r4, Scheduler r5) {
            this.parent = r1;
            this.time = r2;
            this.unit = r4;
            this.scheduler = r5;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            return this.parent.replay(this.time, this.unit, this.scheduler);
        }
    }

    public static final class ZipIterableFunction<T, R> implements Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> {
        private final Function<? super Object[], ? extends R> zipper;

        public ZipIterableFunction(Function<? super Object[], ? extends R> r1) {
            this.zipper = r1;
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply((List) r1);
        }

        public ObservableSource<? extends R> apply(List<ObservableSource<? extends T>> r3) {
            return Observable.zipIterable(r3, this.zipper, false, Observable.bufferSize());
        }
    }

    private ObservableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Function<T, ObservableSource<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> r1) {
        return new FlatMapIntoIterable(r1);
    }

    public static <T, U, R> Function<T, ObservableSource<R>> flatMapWithCombiner(Function<? super T, ? extends ObservableSource<? extends U>> r1, BiFunction<? super T, ? super U, ? extends R> r2) {
        return new FlatMapWithCombinerOuter(r2, r1);
    }

    public static <T, U> Function<T, ObservableSource<T>> itemDelay(Function<? super T, ? extends ObservableSource<U>> r1) {
        return new ItemDelayFunction(r1);
    }

    public static <T> Action observerOnComplete(Observer<T> r1) {
        return new ObserverOnComplete(r1);
    }

    public static <T> Consumer<Throwable> observerOnError(Observer<T> r1) {
        return new ObserverOnError(r1);
    }

    public static <T> Consumer<T> observerOnNext(Observer<T> r1) {
        return new ObserverOnNext(r1);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> r1) {
        return new ReplayCallable(r1);
    }

    public static <T, R> Function<Observable<T>, ObservableSource<R>> replayFunction(Function<? super Observable<T>, ? extends ObservableSource<R>> r1, Scheduler r2) {
        return new ReplayFunction(r1, r2);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> r1) {
        return new SimpleBiGenerator(r1);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> r1) {
        return new SimpleGenerator(r1);
    }

    public static <T, R> Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> zipIterable(Function<? super Object[], ? extends R> r1) {
        return new ZipIterableFunction(r1);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> r1, int r2) {
        return new BufferedReplayCallable(r1, r2);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> r8, int r9, long r10, TimeUnit r12, Scheduler r13) {
        return new BufferedTimedReplayCallable(r8, r9, r10, r12, r13);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> r7, long r8, TimeUnit r10, Scheduler r11) {
        return new TimedReplayCallable(r7, r8, r10, r11);
    }
}
