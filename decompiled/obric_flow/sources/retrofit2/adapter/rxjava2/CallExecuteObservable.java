package retrofit2.adapter.rxjava2;

import com.lynx.jsbridge.a;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import mt.n;
import mt.u;
import retrofit2.Call;
import retrofit2.Response;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class CallExecuteObservable<T> extends n<Response<T>> {
    private final Call<T> originalCall;

    public static final class CallDisposable implements Disposable {
        private final Call<?> call;
        private volatile boolean disposed;

        public CallDisposable(Call<?> r5) {
            this.call = r5;
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
    }

    public CallExecuteObservable(Call<T> r5) {
        this.originalCall = r5;
    }

    @Override // mt.n
    public void subscribeActual(u r5) {
        Call<T> r10 = this.originalCall.mo1704clone();
        CallDisposable r11 = new CallDisposable(r10);
        r5.onSubscribe(r11);
        boolean r12 = false;
        Response<T> r13 = r10.execute();     // Catch: Throwable -> L6
        if (r11.isDisposed() == true) goto L8;
        r5.onNext(r13);     // Catch: Throwable -> L6
    L8:
        if (r11.isDisposed() == true) goto L30;
        r5.onComplete();     // Catch: Throwable -> L12
        return;
    L12:
        th = th;
        r12 = true;
    L14:
        a.t(th);
        if (r12 == false) goto L18;
        f.k(th);
        return;
    L18:
        if (r11.isDisposed() == true) goto L32;
        r5.onError(th);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        a.t(th);
        f.k(new CompositeException(new Throwable[]{th, th}));
        return;
    L32:
        return;
    L30:
        return;
    L6:
        th = th;
        goto L14
    }
}
