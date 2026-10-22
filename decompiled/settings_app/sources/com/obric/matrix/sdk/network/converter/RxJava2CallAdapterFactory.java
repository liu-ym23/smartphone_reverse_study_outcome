package com.obric.matrix.sdk.network.converter;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import com.obric.matrix.sdk.network.BaseResponseModel;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes4.dex */
public class RxJava2CallAdapterFactory extends CallAdapter.Factory {

    private static final class TTCallDisposable implements Disposable {
        private final Call<?> call;

        TTCallDisposable(Call<?> r1) {
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

    private static class TTCallExecuteObservable extends Observable<BaseResponseModel> {
        private Call<BaseResponseModel> originalCall;

        TTCallExecuteObservable(Call<BaseResponseModel> r1) {
            this.originalCall = r1;
        }

        @Override // io.reactivex.Observable
        protected void subscribeActual(Observer<? super BaseResponseModel> r5) {
            Call<BaseResponseModel> r4 = this.originalCall.clone();
            r5.onSubscribe(new TTCallDisposable(r4));
            SsResponse<BaseResponseModel> r2 = r4.execute();     // Catch: Throwable -> L12
            if (r4.isCanceled() == true) goto L6;
            r5.onNext(r2.body());     // Catch: Throwable -> L12
        L6:
            if (r4.isCanceled() == true) goto L30;
            r5.onComplete();     // Catch: Throwable -> L10
            return;
        L10:
            th = th;
            boolean r3 = true;
        L14:
            Exceptions.throwIfFatal(th);
            if (r3 == false) goto L18;
            RxJavaPlugins.onError(th);
            return;
        L18:
            if (r4.isCanceled() == true) goto L32;
            r5.onError(th);     // Catch: Throwable -> L21
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
        L12:
            th = th;
            r3 = false;
            goto L14
        }
    }

    private static class TTRxJava2CallAdapter implements CallAdapter<Observable> {
        private Type responseType;

        @Override // com.bytedance.retrofit2.CallAdapter
        public /* bridge */ /* synthetic */ Object adapt(Call r1) {
            return adapt(r1);
        }

        TTRxJava2CallAdapter(Type r1) {
            this.responseType = r1;
        }

        @Override // com.bytedance.retrofit2.CallAdapter
        public Type responseType() {
            return this.responseType;
        }

        @Override // com.bytedance.retrofit2.CallAdapter
        public <R> Observable adapt(Call<R> r1) {
            return new TTCallExecuteObservable(r1);
        }
    }

    public static RxJava2CallAdapterFactory create() {
        return new RxJava2CallAdapterFactory();
    }

    private RxJava2CallAdapterFactory() {
    }

    @Override // com.bytedance.retrofit2.CallAdapter.Factory
    public CallAdapter<?> get(Type r1, Annotation[] r2, Retrofit r3) {
        if (getRawType(r1) == Observable.class) goto L6;
        return null;
    L6:
        if ((r1 instanceof ParameterizedType) == true) goto L9;
        return null;
    L9:
        return new TTRxJava2CallAdapter(getParameterUpperBound(0, (ParameterizedType) r1));
    }
}
