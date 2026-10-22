package retrofit2.adapter.rxjava2;

import com.lynx.jsbridge.a;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import mt.n;
import mt.u;
import retrofit2.Response;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class BodyObservable<T> extends n<T> {
    private final n<Response<T>> upstream;

    public static class BodyObserver<R> implements u {
        private final u observer;
        private boolean terminated;

        public BodyObserver(u r5) {
            this.observer = r5;
        }

        @Override // mt.u
        public void onComplete() {
            if (this.terminated == true) goto L6;
            this.observer.onComplete();
            return;
        }

        @Override // mt.u
        public void onError(Throwable r5) {
            if (this.terminated == true) goto L5;
            this.observer.onError(r5);
            return;
        L5:
            AssertionError r10 = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            r10.initCause(r5);
            f.k(r10);
        }

        @Override // mt.u
        public /* bridge */ /* synthetic */ void onNext(Object r5) {
            onNext((Response) r5);
        }

        @Override // mt.u
        public void onSubscribe(Disposable r5) {
            this.observer.onSubscribe(r5);
        }

        public void onNext(Response<R> r5) {
            if (r5.isSuccessful() == false) goto L5;
            this.observer.onNext(r5.body());
            return;
        L5:
            this.terminated = true;
            HttpException r10 = new HttpException(r5);
            this.observer.onError(r10);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            a.t(th);
            f.k(new CompositeException(new Throwable[]{r10, th}));
        }
    }

    public BodyObservable(n<Response<T>> r5) {
        this.upstream = r5;
    }

    @Override // mt.n
    public void subscribeActual(u r5) {
        this.upstream.subscribe(new BodyObserver(r5));
    }
}
