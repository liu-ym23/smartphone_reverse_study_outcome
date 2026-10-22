package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import nu.f0;
import okhttp3.Request;

/* JADX INFO: loaded from: classes3.dex */
final class DefaultCallAdapterFactory extends CallAdapter.Factory {
    private final Executor callbackExecutor;

    public static final class ExecutorCallbackCall<T> implements Call<T> {
        final Executor callbackExecutor;
        final Call<T> delegate;

        /* JADX INFO: renamed from: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1, reason: invalid class name */
        public class AnonymousClass1 implements Callback<T> {
            final /* synthetic */ ExecutorCallbackCall this$0;
            final /* synthetic */ Callback val$callback;

            public AnonymousClass1(ExecutorCallbackCall r5, Callback r10) {
                this.this$0 = r5;
                this.val$callback = r10;
            }

            public static /* synthetic */ void a(AnonymousClass1 r5, Callback r10, Throwable r11) {
                r5.lambda$onFailure$1(r10, r11);
            }

            public static /* synthetic */ void b(AnonymousClass1 r5, Callback r10, Response r11) {
                r5.lambda$onResponse$0(r10, r11);
            }

            private /* synthetic */ void lambda$onFailure$1(Callback r5, Throwable r10) {
                r5.onFailure(this.this$0, r10);
            }

            private /* synthetic */ void lambda$onResponse$0(Callback r5, Response r10) {
                if (this.this$0.delegate.isCanceled() == false) goto L5;
                r5.onFailure(this.this$0, new IOException("Canceled"));
                return;
            L5:
                r5.onResponse(this.this$0, r10);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<T> r5, Throwable r10) {
                this.this$0.callbackExecutor.execute(new a(this, this.val$callback, r10, 1));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> r5, Response<T> r10) {
                this.this$0.callbackExecutor.execute(new a(this, this.val$callback, r10, 0));
            }
        }

        public ExecutorCallbackCall(Executor r5, Call<T> r10) {
            this.callbackExecutor = r5;
            this.delegate = r10;
        }

        @Override // retrofit2.Call
        public void cancel() {
            this.delegate.cancel();
        }

        public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return mo1704clone();
        }

        @Override // retrofit2.Call
        public void enqueue(Callback<T> r5) {
            Objects.requireNonNull(r5, "callback == null");
            this.delegate.enqueue(new AnonymousClass1(this, r5));
        }

        @Override // retrofit2.Call
        public Response<T> execute() throws IOException {
            return this.delegate.execute();
        }

        @Override // retrofit2.Call
        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        @Override // retrofit2.Call
        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        @Override // retrofit2.Call
        public Request request() {
            return this.delegate.request();
        }

        @Override // retrofit2.Call
        public f0 timeout() {
            return this.delegate.timeout();
        }

        @Override // retrofit2.Call
        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public Call<T> mo1704clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.mo1704clone());
        }
    }

    public DefaultCallAdapterFactory(Executor r5) {
        this.callbackExecutor = r5;
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type r5, Annotation[] r10, Retrofit r11) {
        final Executor r12 = null;
        if (CallAdapter.Factory.getRawType(r5) == Call.class) goto L6;
        return null;
    L6:
        if ((r5 instanceof ParameterizedType) == false) goto L14;
        final Type r13 = Utils.getParameterUpperBound(0, (ParameterizedType) r5);
        if (Utils.isAnnotationPresent(r10, SkipCallbackExecutor.class) == true) goto L12;
        r12 = this.callbackExecutor;
    L12:
        return new AnonymousClass1(this, r13, r12);
    L14:
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
