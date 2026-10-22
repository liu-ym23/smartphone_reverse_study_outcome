package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes3.dex */
@IgnoreJRERequirement
final class CompletableFutureCallAdapterFactory extends CallAdapter.Factory {
    static final CallAdapter.Factory INSTANCE = null;

    @IgnoreJRERequirement
    public static final class BodyCallAdapter<R> implements CallAdapter<R, CompletableFuture<R>> {
        private final Type responseType;

        public BodyCallAdapter(Type r5) {
            this.responseType = r5;
        }

        @Override // retrofit2.CallAdapter
        public /* bridge */ /* synthetic */ Object adapt(Call r5) {
            return adapt(r5);
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return this.responseType;
        }

        @Override // retrofit2.CallAdapter
        public CompletableFuture<R> adapt(Call<R> r5) {
            final CallCancelCompletableFuture r10 = new CallCancelCompletableFuture(r5);
            r5.enqueue(new AnonymousClass1(this, r10));
            return r10;
        }
    }

    public static final class CallCancelCompletableFuture<T> extends CompletableFuture<T> {
        private final Call<?> call;

        public CallCancelCompletableFuture(Call<?> r5) {
            this.call = r5;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean r5) {
            if (r5 == false) goto L5;
            this.call.cancel();
        L5:
            return super.cancel(r5);
        }
    }

    @IgnoreJRERequirement
    public static final class ResponseCallAdapter<R> implements CallAdapter<R, CompletableFuture<Response<R>>> {
        private final Type responseType;

        public ResponseCallAdapter(Type r5) {
            this.responseType = r5;
        }

        @Override // retrofit2.CallAdapter
        public /* bridge */ /* synthetic */ Object adapt(Call r5) {
            return adapt(r5);
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return this.responseType;
        }

        @Override // retrofit2.CallAdapter
        public CompletableFuture<Response<R>> adapt(Call<R> r5) {
            final CallCancelCompletableFuture r10 = new CallCancelCompletableFuture(r5);
            r5.enqueue(new AnonymousClass1(this, r10));
            return r10;
        }
    }

    static {
        INSTANCE = new CompletableFutureCallAdapterFactory();
    }

    public CompletableFutureCallAdapterFactory() {
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type r5, Annotation[] r10, Retrofit r11) {
        if (CallAdapter.Factory.getRawType(r5) == CompletableFuture.class) goto L7;
        return null;
    L7:
        if ((r5 instanceof ParameterizedType) == false) goto L19;
        Type r12 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) r5);
        if (CallAdapter.Factory.getRawType(r12) == Response.class) goto L13;
        return new BodyCallAdapter(r12);
    L13:
        if ((r12 instanceof ParameterizedType) == false) goto L17;
        return new ResponseCallAdapter(CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) r12));
    L17:
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    L19:
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }
}
