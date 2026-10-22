package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DefaultObserver;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class BlockingObservableMostRecent<T> implements Iterable<T> {
    final T initialValue;
    final ObservableSource<T> source;

    public static final class MostRecentObserver<T> extends DefaultObserver<T> {
        volatile Object value;

        public final class Iterator implements java.util.Iterator<T> {
            private Object buf;
            final /* synthetic */ MostRecentObserver this$0;

            public Iterator(MostRecentObserver r1) {
                this.this$0 = r1;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                Object r0 = this.this$0.value;
                this.buf = r0;
                return !NotificationLite.isComplete(r0);
            }

            @Override // java.util.Iterator
            public T next() {
            L6:
                th = move-exception;
                this.buf = null;
                throw th;
            L4:
                if (this.buf != null) goto L9;
                this.buf = this.this$0.value;     // Catch: Throwable -> L6
            L9:
                if (NotificationLite.isComplete(this.buf) == true) goto L18;
                if (NotificationLite.isError(this.buf) == true) goto L16;
                T r1 = (T) NotificationLite.getValue(this.buf);
                this.buf = null;
                return r1;
            L16:
                throw ExceptionHelper.wrapOrThrow(NotificationLite.getError(this.buf));     // Catch: Throwable -> L6
            L18:
                throw new NoSuchElementException();     // Catch: Throwable -> L6
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        public MostRecentObserver(T r1) {
            this.value = NotificationLite.next(r1);
        }

        public MostRecentObserver<T>.Iterator getIterable() {
            return new Iterator(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.value = NotificationLite.complete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.value = NotificationLite.error(r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r1) {
            this.value = NotificationLite.next(r1);
        }
    }

    public BlockingObservableMostRecent(ObservableSource<T> r1, T r2) {
        this.source = r1;
        this.initialValue = r2;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        MostRecentObserver r0 = new MostRecentObserver(this.initialValue);
        this.source.subscribe(r0);
        return r0.getIterable();
    }
}
