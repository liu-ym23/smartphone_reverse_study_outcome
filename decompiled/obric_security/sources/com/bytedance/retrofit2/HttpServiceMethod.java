package com.bytedance.retrofit2;

import com.bytedance.retrofit2.mime.TypedInput;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.coroutines.Continuation;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {
    final RequestFactory<ReturnT> requestFactory;

    static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {
        private final CallAdapter<ResponseT, ReturnT> callAdapter;

        CallAdapted(RequestFactory r1, CallAdapter<ResponseT, ReturnT> r2) {
            super(r1);
            this.callAdapter = r2;
        }

        @Override // com.bytedance.retrofit2.HttpServiceMethod
        protected ReturnT adapt(Call<ResponseT> r1, Object[] r2) {
            return this.callAdapter.adapt(r1);
        }
    }

    static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;
        private final boolean isNullable;

        SuspendForBody(RequestFactory r1, CallAdapter<ResponseT, Call<ResponseT>> r2, boolean r3) {
            super(r1);
            this.callAdapter = r2;
            this.isNullable = r3;
        }

        @Override // com.bytedance.retrofit2.HttpServiceMethod
        protected Object adapt(Call<ResponseT> r2, Object[] r3) {
            Call<ResponseT> r4 = this.callAdapter.adapt(r2);
            Continuation r5 = (Continuation) r3[r3.length - 1];
        L8:
            e = move-exception;
            return KotlinExtensions.suspendAndThrow(e, r5);
        L4:
            if (this.isNullable == false) goto L7;
            return KotlinExtensions.awaitNullable(r4, r5);
        L7:
            return KotlinExtensions.await(r4, r5);
        }
    }

    static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;

        SuspendForResponse(RequestFactory r1, CallAdapter<ResponseT, Call<ResponseT>> r2) {
            super(r1);
            this.callAdapter = r2;
        }

        @Override // com.bytedance.retrofit2.HttpServiceMethod
        protected Object adapt(Call<ResponseT> r1, Object[] r2) {
            Call<ResponseT> r0 = this.callAdapter.adapt(r1);
            Continuation r3 = (Continuation) r2[r2.length - 1];
            return KotlinExtensions.awaitResponse(r0, r3);
        L5:
            e = move-exception;
            return KotlinExtensions.suspendAndThrow(e, r3);
        }
    }

    @Nullable
    protected abstract ReturnT adapt(Call<ResponseT> r1, Object[] r2);

    static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(Retrofit r8, Method r9, RequestFactory r10) {
        boolean r0 = r10.isKotlinSuspendFunction;
        Annotation[] r1 = r9.getAnnotations();
        if (r0 == false) goto L11;
        Type[] r3 = r9.getGenericParameterTypes();
        Type r4 = Utils.getParameterLowerBound(0, (ParameterizedType) r3[r3.length - 1]);
        if (Utils.getRawType(r4) == SsResponse.class) goto L7;
    L9:
        boolean r5 = false;
    L10:
        Type r6 = new Utils.ParameterizedTypeImpl(null, Call.class, new Type[]{r4});
        r1 = SkipCallbackExecutorImpl.ensurePresent(r1);
    L12:
        CallAdapter r2 = createCallAdapter(r8, r9, r6, r1);
        Type r7 = r2.responseType();
        if (r7 == Response.class) goto L39;
        if (r7 == SsResponse.class) goto L37;
        if (r7 == com.bytedance.retrofit2.client.Response.class) goto L35;
        if (r10.httpMethod.equals(HttpMethodContrants.HEAD) == true) goto L21;
    L25:
        r10.responseConverter = createResponseConverter(r8, r9, r7);
        if (r0 == false) goto L28;
        if (r5 == false) goto L33;
        return new SuspendForResponse(r10, r2);
    L33:
        return new SuspendForBody(r10, r2, false);
    L28:
        return new CallAdapted(r10, r2);
    L21:
        if (Void.class.equals(r7) == true) goto L25;
        throw Utils.methodError(r9, "HEAD method must use Void as response type.", new Object[0]);
    L35:
        throw Utils.methodError(r9, "'" + Utils.getRawType(r7).getName() + "' is not a valid response body type.", new Object[0]);
    L37:
        throw Utils.methodError(r9, "Response must include generic type (e.g., SsResponse<String>)", new Object[0]);
    L39:
        throw Utils.methodError(r9, "'" + Utils.getRawType(r7).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
    L7:
        if ((r4 instanceof ParameterizedType) == false) goto L9;
        r4 = Utils.getParameterUpperBound(0, (ParameterizedType) r4);
        r5 = true;
        goto L10
    L11:
        r6 = r9.getGenericReturnType();
        r5 = false;
        goto L12
    }

    private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(Retrofit r1, Method r2, Type r3, Annotation[] r4) {
        return (CallAdapter<ResponseT, ReturnT>) r1.callAdapter(r3, r4);
    L4:
        e = move-exception;
        throw Utils.methodError(r2, e, "Unable to create call adapter for %s", new Object[]{r3});
    }

    private static <ResponseT> Converter<TypedInput, ResponseT> createResponseConverter(Retrofit r2, Method r3, Type r4) {
        return r2.responseBodyConverter(r4, r3.getAnnotations());
    L5:
        e = move-exception;
        throw Utils.methodError(r3, e, "Unable to create converter for %s", new Object[]{r4});
    }

    HttpServiceMethod(RequestFactory<ReturnT> r1) {
        this.requestFactory = r1;
    }

    @Override // com.bytedance.retrofit2.ServiceMethod
    @Nullable
    final ReturnT invoke(Object[] r3) {
        return adapt(new SsHttpCall(this.requestFactory, r3), r3);
    }
}
