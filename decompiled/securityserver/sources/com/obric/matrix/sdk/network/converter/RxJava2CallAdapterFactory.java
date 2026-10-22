package com.obric.matrix.sdk.network.converter;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class RxJava2CallAdapterFactory extends CallAdapter.Factory {

    public static final class TTCallDisposable implements Disposable {
        private final Call<?> call;

        public TTCallDisposable(Call<?> r1) {
            this.call = r1;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.call.cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.call.isCanceled();
        }
    }

    public static class TTCallExecuteObservable<R> extends Observable<R> {
        private Call<R> originalCall;

        public TTCallExecuteObservable(Call<R> r1) {
            this.originalCall = r1;
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(Observer<? super R> r4) {
            Call<R> r3 = this.originalCall.clone();
            r4.onSubscribe(new TTCallDisposable(r3));
            boolean r0 = false;
            SsResponse<R> r1 = r3.execute();     // Catch: Throwable -> L6
            if (r3.isCanceled() == true) goto L8;
            r4.onNext(r1.body());     // Catch: Throwable -> L6
        L8:
            if (r3.isCanceled() == true) goto L30;
            r4.onComplete();     // Catch: Throwable -> L12
            return;
        L12:
            th = th;
            r0 = true;
        L14:
            Exceptions.throwIfFatal(th);
            if (r0 == false) goto L18;
            RxJavaPlugins.onError(th);
            return;
        L18:
            if (r3.isCanceled() == true) goto L32;
            r4.onError(th);     // Catch: Throwable -> L21
            return;
        L21:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(new CompositeException(new Throwable[]{th, th}));
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

    public static class TTRxJava2CallAdapter<R> implements CallAdapter<R, Observable<R>> {
        private Type responseType;

        public TTRxJava2CallAdapter(Type r1) {
            this.responseType = r1;
        }

        @Override // com.bytedance.retrofit2.CallAdapter
        public /* bridge */ /* synthetic */ Object adapt(Call r1) {
            return adapt(r1);
        }

        @Override // com.bytedance.retrofit2.CallAdapter
        public Type responseType() {
            return this.responseType;
        }

        @Override // com.bytedance.retrofit2.CallAdapter
        public Observable<R> adapt(Call<R> r1) {
            return new TTCallExecuteObservable(r1);
        }
    }

    private RxJava2CallAdapterFactory() {
    }

    public static RxJava2CallAdapterFactory create() {
        return new RxJava2CallAdapterFactory();
    }

    @Override // com.bytedance.retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type r1, Annotation[] r2, Retrofit r3) {
        if (CallAdapter.Factory.getRawType(r1) == Observable.class) goto L6;
        return null;
    L6:
        if ((r1 instanceof ParameterizedType) == true) goto L9;
        return null;
    L9:
        return new TTRxJava2CallAdapter(CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) r1));
    }
}
