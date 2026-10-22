package retrofit2.adapter.rxjava2;

import com.lynx.jsbridge.a;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import mt.n;
import mt.u;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class CallEnqueueObservable<T> extends n<Response<T>> {
    private final Call<T> originalCall;

    public static final class CallCallback<T> implements Disposable, Callback<T> {
        private final Call<?> call;
        private volatile boolean disposed;
        private final u observer;
        boolean terminated;

        public CallCallback(Call<?> r5, u r10) {
            this.terminated = false;
            this.call = r5;
            this.observer = r10;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.call.cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<T> r5, Throwable r10) {
            if (r5.isCanceled() == false) goto L10;
            return;
        L10:
            this.observer.onError(r10);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            a.t(th);
            f.k(new CompositeException(new Throwable[]{r10, th}));
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<T> r5, Response<T> r10) {
            if (this.disposed == false) goto L20;
            return;
        L20:
            this.observer.onNext(r10);     // Catch: Throwable -> L9
            if (this.disposed == true) goto L24;
            this.terminated = true;     // Catch: Throwable -> L9
            this.observer.onComplete();     // Catch: Throwable -> L9
            return;
        L24:
            return;
        L9:
            th = move-exception;
            if (this.terminated == false) goto L14;
            f.k(th);
            return;
        L14:
            if (this.disposed == true) goto L26;
            this.observer.onError(th);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            a.t(th);
            f.k(new CompositeException(new Throwable[]{th, th}));
            return;
        }
    }

    public CallEnqueueObservable(Call<T> r5) {
        this.originalCall = r5;
    }

    @Override // mt.n
    public void subscribeActual(u r5) {
        Call<T> r10 = this.originalCall.mo1704clone();
        CallCallback r11 = new CallCallback(r10, r5);
        r5.onSubscribe(r11);
        r10.enqueue(r11);
    }
}
