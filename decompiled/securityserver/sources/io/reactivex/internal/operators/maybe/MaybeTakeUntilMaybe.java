package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeTakeUntilMaybe<T, U> extends AbstractMaybeWithUpstream<T, T> {
    final MaybeSource<U> other;

    public static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -2187421758664251153L;
        final MaybeObserver<? super T> downstream;
        final TakeUntilOtherMaybeObserver<U> other;

        public static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<Disposable> implements MaybeObserver<U> {
            private static final long serialVersionUID = -1266041316834525931L;
            final TakeUntilMainMaybeObserver<?, U> parent;

            public TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver<?, U> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.parent.otherComplete();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable r1) {
                this.parent.otherError(r1);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(Object r1) {
                this.parent.otherComplete();
            }
        }

        public TakeUntilMainMaybeObserver(MaybeObserver<? super T> r1) {
            this.downstream = r1;
            this.other = new TakeUntilOtherMaybeObserver(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.other);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            DisposableHelper r0 = DisposableHelper.DISPOSED;
            if (getAndSet(r0) == r0) goto L6;
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r3) {
            DisposableHelper.dispose(this.other);
            DisposableHelper r0 = DisposableHelper.DISPOSED;
            if (getAndSet(r0) == r0) goto L5;
            this.downstream.onError(r3);
            return;
        L5:
            RxJavaPlugins.onError(r3);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r3) {
            DisposableHelper.dispose(this.other);
            DisposableHelper r0 = DisposableHelper.DISPOSED;
            if (getAndSet(r0) == r0) goto L6;
            this.downstream.onSuccess(r3);
            return;
        }

        public void otherComplete() {
            if (DisposableHelper.dispose(this) == false) goto L6;
            this.downstream.onComplete();
            return;
        }

        public void otherError(Throwable r2) {
            if (DisposableHelper.dispose(this) == false) goto L5;
            this.downstream.onError(r2);
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }
    }

    public MaybeTakeUntilMaybe(MaybeSource<T> r1, MaybeSource<U> r2) {
        super(r1);
        this.other = r2;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> r3) {
        TakeUntilMainMaybeObserver r0 = new TakeUntilMainMaybeObserver(r3);
        r3.onSubscribe(r0);
        this.other.subscribe(r0.other);
        this.source.subscribe(r0);
    }
}
