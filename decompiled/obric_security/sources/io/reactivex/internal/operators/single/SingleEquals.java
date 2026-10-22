package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleEquals<T> extends Single<Boolean> {
    final SingleSource<? extends T> first;
    final SingleSource<? extends T> second;

    static class InnerObserver<T> implements SingleObserver<T> {
        final AtomicInteger count;
        final SingleObserver<? super Boolean> downstream;
        final int index;
        final CompositeDisposable set;
        final Object[] values;

        InnerObserver(int r1, CompositeDisposable r2, Object[] r3, SingleObserver<? super Boolean> r4, AtomicInteger r5) {
            this.index = r1;
            this.set = r2;
            this.values = r3;
            this.downstream = r4;
            this.count = r5;
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r1) {
            this.set.add(r1);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r3) {
            this.values[this.index] = r3;
            if (this.count.incrementAndGet() != 2) goto L6;
            SingleObserver<? super Boolean> r4 = this.downstream;
            Object[] r2 = this.values;
            r4.onSuccess(Boolean.valueOf(ObjectHelper.equals(r2[0], r2[1])));
            return;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r4) {
        L2:
            int r0 = this.count.get();
            if (r0 >= 2) goto L4;
            if (this.count.compareAndSet(r0, 2) == false) goto L2;
            this.set.dispose();
            this.downstream.onError(r4);
            return;
        L4:
            RxJavaPlugins.onError(r4);
        }
    }

    public SingleEquals(SingleSource<? extends T> r1, SingleSource<? extends T> r2) {
        this.first = r1;
        this.second = r2;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super Boolean> r12) {
        AtomicInteger r6 = new AtomicInteger();
        Object[] r7 = {null, null};
        CompositeDisposable r8 = new CompositeDisposable();
        r12.onSubscribe(r8);
        this.first.subscribe(new InnerObserver(0, r8, r7, r12, r6));
        this.second.subscribe(new InnerObserver(1, r8, r7, r12, r6));
    }
}
