package retrofit2.adapter.rxjava2;

import com.lynx.jsbridge.a;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import mt.n;
import mt.u;
import retrofit2.Response;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class ResultObservable<T> extends n<Result<T>> {
    private final n<Response<T>> upstream;

    public static class ResultObserver<R> implements u {
        private final u observer;

        public ResultObserver(u r5) {
            this.observer = r5;
        }

        @Override // mt.u
        public void onComplete() {
            this.observer.onComplete();
        }

        @Override // mt.u
        public void onError(Throwable r5) {
            this.observer.onNext(Result.error(r5));     // Catch: Throwable -> L5
            this.observer.onComplete();
            return;
        L5:
            th = move-exception;
            this.observer.onError(th);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            a.t(th);
            f.k(new CompositeException(new Throwable[]{th, th}));
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
            this.observer.onNext(Result.response(r5));
        }
    }

    public ResultObservable(n<Response<T>> r5) {
        this.upstream = r5;
    }

    @Override // mt.n
    public void subscribeActual(u r5) {
        this.upstream.subscribe(new ResultObserver(r5));
    }
}
