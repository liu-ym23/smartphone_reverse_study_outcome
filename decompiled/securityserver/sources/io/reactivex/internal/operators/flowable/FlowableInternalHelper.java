package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableInternalHelper {

    public static final class BufferedReplayCallable<T> implements Callable<ConnectableFlowable<T>> {
        private final int bufferSize;
        private final Flowable<T> parent;

        public BufferedReplayCallable(Flowable<T> r1, int r2) {
            this.parent = r1;
            this.bufferSize = r2;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // java.util.concurrent.Callable
        public ConnectableFlowable<T> call() {
            return this.parent.replay(this.bufferSize);
        }
    }

    public static final class BufferedTimedReplay<T> implements Callable<ConnectableFlowable<T>> {
        private final int bufferSize;
        private final Flowable<T> parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        public BufferedTimedReplay(Flowable<T> r1, int r2, long r3, TimeUnit r5, Scheduler r6) {
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
        public ConnectableFlowable<T> call() {
            return this.parent.replay(this.bufferSize, this.time, this.unit, this.scheduler);
        }
    }

    public static final class FlatMapIntoIterable<T, U> implements Function<T, Publisher<U>> {
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
        public Publisher<U> apply(T r2) {
            return new FlowableFromIterable((Iterable) ObjectHelper.requireNonNull(this.mapper.apply(r2), "The mapper returned a null Iterable"));
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

    public static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, Publisher<R>> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;
        private final Function<? super T, ? extends Publisher<? extends U>> mapper;

        public FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> r1, Function<? super T, ? extends Publisher<? extends U>> r2) {
            this.combiner = r1;
            this.mapper = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply(r1);
        }

        @Override // io.reactivex.functions.Function
        public Publisher<R> apply(T r4) {
            return new FlowableMapPublisher((Publisher) ObjectHelper.requireNonNull(this.mapper.apply(r4), "The mapper returned a null Publisher"), new FlatMapWithCombinerInner(this.combiner, r4));
        }
    }

    public static final class ItemDelayFunction<T, U> implements Function<T, Publisher<T>> {
        final Function<? super T, ? extends Publisher<U>> itemDelay;

        public ItemDelayFunction(Function<? super T, ? extends Publisher<U>> r1) {
            this.itemDelay = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply(r1);
        }

        @Override // io.reactivex.functions.Function
        public Publisher<T> apply(T r4) {
            return new FlowableTakePublisher((Publisher) ObjectHelper.requireNonNull(this.itemDelay.apply(r4), "The itemDelay returned a null Publisher"), 1).map(Functions.justFunction(r4)).defaultIfEmpty(r4);
        }
    }

    public static final class ReplayCallable<T> implements Callable<ConnectableFlowable<T>> {
        private final Flowable<T> parent;

        public ReplayCallable(Flowable<T> r1) {
            this.parent = r1;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // java.util.concurrent.Callable
        public ConnectableFlowable<T> call() {
            return this.parent.replay();
        }
    }

    public static final class ReplayFunction<T, R> implements Function<Flowable<T>, Publisher<R>> {
        private final Scheduler scheduler;
        private final Function<? super Flowable<T>, ? extends Publisher<R>> selector;

        public ReplayFunction(Function<? super Flowable<T>, ? extends Publisher<R>> r1, Scheduler r2) {
            this.selector = r1;
            this.scheduler = r2;
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply((Flowable) r1);
        }

        public Publisher<R> apply(Flowable<T> r2) {
            return Flowable.fromPublisher((Publisher) ObjectHelper.requireNonNull(this.selector.apply(r2), "The selector returned a null Publisher")).observeOn(this.scheduler);
        }
    }

    public static final enum RequestMax extends Enum<RequestMax> implements Consumer<Subscription> {
        private static final /* synthetic */ RequestMax[] $VALUES = null;
        public static final RequestMax INSTANCE = null;

        static {
            RequestMax r0 = new RequestMax("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new RequestMax[]{r0};
        }

        private RequestMax(String r1, int r2) {
            super(r1, r2);
        }

        public static RequestMax valueOf(String r1) {
            return (RequestMax) Enum.valueOf(RequestMax.class, r1);
        }

        public static RequestMax[] values() {
            return (RequestMax[]) $VALUES.clone();
        }

        @Override // io.reactivex.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Subscription r1) {
            accept2(r1);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Subscription r3) {
            r3.request(Long.MAX_VALUE);
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

    public static final class SubscriberOnComplete<T> implements Action {
        final Subscriber<T> subscriber;

        public SubscriberOnComplete(Subscriber<T> r1) {
            this.subscriber = r1;
        }

        @Override // io.reactivex.functions.Action
        public void run() {
            this.subscriber.onComplete();
        }
    }

    public static final class SubscriberOnError<T> implements Consumer<Throwable> {
        final Subscriber<T> subscriber;

        public SubscriberOnError(Subscriber<T> r1) {
            this.subscriber = r1;
        }

        @Override // io.reactivex.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Throwable r1) {
            accept2(r1);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Throwable r1) {
            this.subscriber.onError(r1);
        }
    }

    public static final class SubscriberOnNext<T> implements Consumer<T> {
        final Subscriber<T> subscriber;

        public SubscriberOnNext(Subscriber<T> r1) {
            this.subscriber = r1;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T r1) {
            this.subscriber.onNext(r1);
        }
    }

    public static final class TimedReplay<T> implements Callable<ConnectableFlowable<T>> {
        private final Flowable<T> parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        public TimedReplay(Flowable<T> r1, long r2, TimeUnit r4, Scheduler r5) {
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
        public ConnectableFlowable<T> call() {
            return this.parent.replay(this.time, this.unit, this.scheduler);
        }
    }

    public static final class ZipIterableFunction<T, R> implements Function<List<Publisher<? extends T>>, Publisher<? extends R>> {
        private final Function<? super Object[], ? extends R> zipper;

        public ZipIterableFunction(Function<? super Object[], ? extends R> r1) {
            this.zipper = r1;
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply((List) r1);
        }

        public Publisher<? extends R> apply(List<Publisher<? extends T>> r3) {
            return Flowable.zipIterable(r3, this.zipper, false, Flowable.bufferSize());
        }
    }

    private FlowableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Function<T, Publisher<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> r1) {
        return new FlatMapIntoIterable(r1);
    }

    public static <T, U, R> Function<T, Publisher<R>> flatMapWithCombiner(Function<? super T, ? extends Publisher<? extends U>> r1, BiFunction<? super T, ? super U, ? extends R> r2) {
        return new FlatMapWithCombinerOuter(r2, r1);
    }

    public static <T, U> Function<T, Publisher<T>> itemDelay(Function<? super T, ? extends Publisher<U>> r1) {
        return new ItemDelayFunction(r1);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> r1) {
        return new ReplayCallable(r1);
    }

    public static <T, R> Function<Flowable<T>, Publisher<R>> replayFunction(Function<? super Flowable<T>, ? extends Publisher<R>> r1, Scheduler r2) {
        return new ReplayFunction(r1, r2);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> r1) {
        return new SimpleBiGenerator(r1);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> r1) {
        return new SimpleGenerator(r1);
    }

    public static <T> Action subscriberOnComplete(Subscriber<T> r1) {
        return new SubscriberOnComplete(r1);
    }

    public static <T> Consumer<Throwable> subscriberOnError(Subscriber<T> r1) {
        return new SubscriberOnError(r1);
    }

    public static <T> Consumer<T> subscriberOnNext(Subscriber<T> r1) {
        return new SubscriberOnNext(r1);
    }

    public static <T, R> Function<List<Publisher<? extends T>>, Publisher<? extends R>> zipIterable(Function<? super Object[], ? extends R> r1) {
        return new ZipIterableFunction(r1);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> r1, int r2) {
        return new BufferedReplayCallable(r1, r2);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> r8, int r9, long r10, TimeUnit r12, Scheduler r13) {
        return new BufferedTimedReplay(r8, r9, r10, r12, r13);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> r7, long r8, TimeUnit r10, Scheduler r11) {
        return new TimedReplay(r7, r8, r10, r11);
    }
}
