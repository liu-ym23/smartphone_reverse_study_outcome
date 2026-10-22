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

    public static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {
        private final CallAdapter<ResponseT, ReturnT> callAdapter;

        public CallAdapted(RequestFactory r1, CallAdapter<ResponseT, ReturnT> r2) {
            super(r1);
            this.callAdapter = r2;
        }

        @Override // com.bytedance.retrofit2.HttpServiceMethod
        public ReturnT adapt(Call<ResponseT> r1, Object[] r2) {
            return this.callAdapter.adapt(r1);
        }
    }

    public static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;
        private final boolean isNullable;

        public SuspendForBody(RequestFactory r1, CallAdapter<ResponseT, Call<ResponseT>> r2, boolean r3) {
            super(r1);
            this.callAdapter = r2;
            this.isNullable = r3;
        }

        @Override // com.bytedance.retrofit2.HttpServiceMethod
        public Object adapt(Call<ResponseT> r2, Object[] r3) {
            Call<ResponseT> r4 = this.callAdapter.adapt(r2);
            Continuation r5 = (Continuation) r3[r3.length - 1];
        L6:
            e = move-exception;
            return KotlinExtensions.suspendAndThrow(e, r5);
        L4:
            if (this.isNullable == false) goto L9;
            return KotlinExtensions.awaitNullable(r4, r5);
        L9:
            return KotlinExtensions.await(r4, r5);
        }
    }

    public static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;

        public SuspendForResponse(RequestFactory r1, CallAdapter<ResponseT, Call<ResponseT>> r2) {
            super(r1);
            this.callAdapter = r2;
        }

        @Override // com.bytedance.retrofit2.HttpServiceMethod
        public Object adapt(Call<ResponseT> r1, Object[] r2) {
            Call<ResponseT> r0 = this.callAdapter.adapt(r1);
            Continuation r3 = (Continuation) r2[r2.length - 1];
            return KotlinExtensions.awaitResponse(r0, r3);
        L5:
            e = move-exception;
            return KotlinExtensions.suspendAndThrow(e, r3);
        }
    }

    public HttpServiceMethod(RequestFactory<ReturnT> r1) {
        this.requestFactory = r1;
    }

    private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(Retrofit r0, Method r1, Type r2, Annotation[] r3) {
        return (CallAdapter<ResponseT, ReturnT>) r0.callAdapter(r2, r3);
    L4:
        e = move-exception;
        throw Utils.methodError(r1, e, "Unable to create call adapter for %s", new Object[]{r2});
    }

    private static <ResponseT> Converter<TypedInput, ResponseT> createResponseConverter(Retrofit r1, Method r2, Type r3) {
        return r1.responseBodyConverter(r3, r2.getAnnotations());
    L5:
        e = move-exception;
        throw Utils.methodError(r2, e, "Unable to create converter for %s", new Object[]{r3});
    }

    public static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(Retrofit r9, Method r10, RequestFactory r11) {
        boolean r1 = r11.isKotlinSuspendFunction;
        Annotation[] r2 = r10.getAnnotations();
        if (r1 == false) goto L11;
        Type[] r5 = r10.getGenericParameterTypes();
        Type r6 = Utils.getParameterLowerBound(0, (ParameterizedType) r5[r5.length - 1]);
        if (Utils.getRawType(r6) == SsResponse.class) goto L7;
    L9:
        boolean r7 = false;
    L10:
        Type r8 = new Utils.ParameterizedTypeImpl(null, Call.class, new Type[]{r6});
        r2 = SkipCallbackExecutorImpl.ensurePresent(r2);
    L12:
        CallAdapter r0 = createCallAdapter(r9, r10, r8, r2);
        Type r3 = r0.responseType();
        if (r3 == Response.class) goto L38;
        if (r3 == SsResponse.class) goto L36;
        if (r3 == com.bytedance.retrofit2.client.Response.class) goto L34;
        if (r11.httpMethod.equals(HttpMethodContrants.HEAD) == true) goto L20;
    L24:
        r11.responseConverter = createResponseConverter(r9, r10, r3);
        if (r1 == false) goto L27;
        if (r7 == false) goto L32;
        return new SuspendForResponse(r11, r0);
    L32:
        return new SuspendForBody(r11, r0, false);
    L27:
        return new CallAdapted(r11, r0);
    L20:
        if (Void.class.equals(r3) == true) goto L24;
        throw Utils.methodError(r10, "HEAD method must use Void as response type.", new Object[0]);
    L34:
        throw Utils.methodError(r10, "'" + Utils.getRawType(r3).getName() + "' is not a valid response body type.", new Object[0]);
    L36:
        throw Utils.methodError(r10, "Response must include generic type (e.g., SsResponse<String>)", new Object[0]);
    L38:
        throw Utils.methodError(r10, "'" + Utils.getRawType(r3).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
    L7:
        if ((r6 instanceof ParameterizedType) == false) goto L9;
        r6 = Utils.getParameterUpperBound(0, (ParameterizedType) r6);
        r7 = true;
        goto L10
    L11:
        r8 = r10.getGenericReturnType();
        r7 = false;
        goto L12
    }

    @Nullable
    public abstract ReturnT adapt(Call<ResponseT> r1, Object[] r2);

    @Override // com.bytedance.retrofit2.ServiceMethod
    @Nullable
    public final ReturnT invoke(Object[] r3) {
        return adapt(new SsHttpCall(this.requestFactory, r3), r3);
    }
}
