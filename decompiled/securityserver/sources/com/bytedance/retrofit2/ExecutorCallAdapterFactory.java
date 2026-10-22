package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Request;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
final class ExecutorCallAdapterFactory extends CallAdapter.Factory {
    final Executor callbackExecutor;

    public static final class ExecutorCallbackCall<T> implements Call<T>, IMetricsCollect {
        final Executor callbackExecutor;
        final Call<T> delegate;

        public ExecutorCallbackCall(Executor r1, Call<T> r2) {
            this.callbackExecutor = r1;
            this.delegate = r2;
        }

        @Override // com.bytedance.retrofit2.Call
        public void cancel() {
            this.delegate.cancel();
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m9clone() {
            return clone();
        }

        @Override // com.bytedance.retrofit2.IMetricsCollect
        public void doCollect() {
            Call<T> r1 = this.delegate;
            if ((r1 instanceof IMetricsCollect) == false) goto L6;
            ((IMetricsCollect) r1).doCollect();
            return;
        }

        @Override // com.bytedance.retrofit2.Call
        public void enqueue(@Nullable final Callback<T> r3) {
            Utils.checkNotNull(r3, "callback == null");
            this.delegate.enqueue(new AnonymousClass1(this, r3));
        }

        @Override // com.bytedance.retrofit2.Call
        public SsResponse execute() {
            return this.delegate.execute();
        }

        @Override // com.bytedance.retrofit2.Call
        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        @Override // com.bytedance.retrofit2.Call
        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        @Override // com.bytedance.retrofit2.Call
        public Request request() {
            return this.delegate.request();
        }

        public boolean setThrottleNetSpeed(long r2) {
            Call<T> r1 = this.delegate;
            if ((r1 instanceof SsHttpCall) == true) goto L5;
            return false;
        L5:
            return ((SsHttpCall) r1).setThrottleNetSpeed(r2);
        }

        @Override // com.bytedance.retrofit2.Call
        public Call<T> clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }
    }

    public ExecutorCallAdapterFactory(Executor r1) {
        this.callbackExecutor = r1;
    }

    @Override // com.bytedance.retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type r3, Annotation[] r4, Retrofit r5) {
        final Executor r1 = null;
        if (CallAdapter.Factory.getRawType(r3) == Call.class) goto L6;
        return null;
    L6:
        if ((r3 instanceof ParameterizedType) == false) goto L14;
        final Type r6 = Utils.getCallResponseType(r3);
        if (Utils.isAnnotationPresent(r4, SkipCallbackExecutor.class) == true) goto L12;
        r1 = this.callbackExecutor;
    L12:
        return new AnonymousClass1(this, r6, r1);
    L14:
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
