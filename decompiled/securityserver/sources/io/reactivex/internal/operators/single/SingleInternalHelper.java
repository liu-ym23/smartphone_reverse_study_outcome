package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleInternalHelper {

    public static final enum NoSuchElementCallable extends Enum<NoSuchElementCallable> implements Callable<NoSuchElementException> {
        private static final /* synthetic */ NoSuchElementCallable[] $VALUES = null;
        public static final NoSuchElementCallable INSTANCE = null;

        static {
            NoSuchElementCallable r0 = new NoSuchElementCallable("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new NoSuchElementCallable[]{r0};
        }

        private NoSuchElementCallable(String r1, int r2) {
            super(r1, r2);
        }

        public static NoSuchElementCallable valueOf(String r1) {
            return (NoSuchElementCallable) Enum.valueOf(NoSuchElementCallable.class, r1);
        }

        public static NoSuchElementCallable[] values() {
            return (NoSuchElementCallable[]) $VALUES.clone();
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ NoSuchElementException call() {
            return call2();
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public NoSuchElementException call2() {
            return new NoSuchElementException();
        }
    }

    public static final enum ToFlowable extends Enum<ToFlowable> implements Function<SingleSource, Publisher> {
        private static final /* synthetic */ ToFlowable[] $VALUES = null;
        public static final ToFlowable INSTANCE = null;

        static {
            ToFlowable r0 = new ToFlowable("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new ToFlowable[]{r0};
        }

        private ToFlowable(String r1, int r2) {
            super(r1, r2);
        }

        public static ToFlowable valueOf(String r1) {
            return (ToFlowable) Enum.valueOf(ToFlowable.class, r1);
        }

        public static ToFlowable[] values() {
            return (ToFlowable[]) $VALUES.clone();
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Publisher apply(SingleSource r1) {
            return apply2(r1);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public Publisher apply2(SingleSource r1) {
            return new SingleToFlowable(r1);
        }
    }

    public static final class ToFlowableIterable<T> implements Iterable<Flowable<T>> {
        private final Iterable<? extends SingleSource<? extends T>> sources;

        public ToFlowableIterable(Iterable<? extends SingleSource<? extends T>> r1) {
            this.sources = r1;
        }

        @Override // java.lang.Iterable
        public Iterator<Flowable<T>> iterator() {
            return new ToFlowableIterator(this.sources.iterator());
        }
    }

    public static final class ToFlowableIterator<T> implements Iterator<Flowable<T>> {
        private final Iterator<? extends SingleSource<? extends T>> sit;

        public ToFlowableIterator(Iterator<? extends SingleSource<? extends T>> r1) {
            this.sit = r1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.sit.hasNext();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public Flowable<T> next() {
            return new SingleToFlowable(this.sit.next());
        }
    }

    public static final enum ToObservable extends Enum<ToObservable> implements Function<SingleSource, Observable> {
        private static final /* synthetic */ ToObservable[] $VALUES = null;
        public static final ToObservable INSTANCE = null;

        static {
            ToObservable r0 = new ToObservable("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new ToObservable[]{r0};
        }

        private ToObservable(String r1, int r2) {
            super(r1, r2);
        }

        public static ToObservable valueOf(String r1) {
            return (ToObservable) Enum.valueOf(ToObservable.class, r1);
        }

        public static ToObservable[] values() {
            return (ToObservable[]) $VALUES.clone();
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Observable apply(SingleSource r1) {
            return apply2(r1);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public Observable apply2(SingleSource r1) {
            return new SingleToObservable(r1);
        }
    }

    private SingleInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Callable<NoSuchElementException> emptyThrower() {
        return NoSuchElementCallable.INSTANCE;
    }

    public static <T> Iterable<? extends Flowable<T>> iterableToFlowable(Iterable<? extends SingleSource<? extends T>> r1) {
        return new ToFlowableIterable(r1);
    }

    public static <T> Function<SingleSource<? extends T>, Publisher<? extends T>> toFlowable() {
        return ToFlowable.INSTANCE;
    }

    public static <T> Function<SingleSource<? extends T>, Observable<? extends T>> toObservable() {
        return ToObservable.INSTANCE;
    }
}
