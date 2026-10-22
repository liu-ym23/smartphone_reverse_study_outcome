package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.coroutines.Continuation;
import okhttp3.i;
import okhttp3.s0;
import okhttp3.w0;

/* JADX INFO: loaded from: classes3.dex */
abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {
    private final i callFactory;
    private final RequestFactory requestFactory;
    private final Converter<w0, ResponseT> responseConverter;

    public static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {
        private final CallAdapter<ResponseT, ReturnT> callAdapter;

        public CallAdapted(RequestFactory r5, i r10, Converter<w0, ResponseT> r11, CallAdapter<ResponseT, ReturnT> r12) {
            super(r5, r10, r11);
            this.callAdapter = r12;
        }

        @Override // retrofit2.HttpServiceMethod
        public ReturnT adapt(Call<ResponseT> r5, Object[] r10) {
            return this.callAdapter.adapt(r5);
        }
    }

    public static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;
        private final boolean isNullable;

        public SuspendForBody(RequestFactory r5, i r10, Converter<w0, ResponseT> r11, CallAdapter<ResponseT, Call<ResponseT>> r12, boolean r13) {
            super(r5, r10, r11);
            this.callAdapter = r12;
            this.isNullable = r13;
        }

        @Override // retrofit2.HttpServiceMethod
        public Object adapt(Call<ResponseT> r5, Object[] r10) {
            Call<ResponseT> r11 = this.callAdapter.adapt(r5);
            Continuation r12 = (Continuation) r10[r10.length - 1];
        L6:
            e = move-exception;
            return KotlinExtensions.suspendAndThrow(e, r12);
        L4:
            if (this.isNullable == false) goto L9;
            return KotlinExtensions.awaitNullable(r11, r12);
        L9:
            return KotlinExtensions.await(r11, r12);
        }
    }

    public static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;

        public SuspendForResponse(RequestFactory r5, i r10, Converter<w0, ResponseT> r11, CallAdapter<ResponseT, Call<ResponseT>> r12) {
            super(r5, r10, r11);
            this.callAdapter = r12;
        }

        @Override // retrofit2.HttpServiceMethod
        public Object adapt(Call<ResponseT> r5, Object[] r10) {
            Call<ResponseT> r11 = this.callAdapter.adapt(r5);
            Continuation r12 = (Continuation) r10[r10.length - 1];
            return KotlinExtensions.awaitResponse(r11, r12);
        L5:
            e = move-exception;
            return KotlinExtensions.suspendAndThrow(e, r12);
        }
    }

    public HttpServiceMethod(RequestFactory r5, i r10, Converter<w0, ResponseT> r11) {
        this.requestFactory = r5;
        this.callFactory = r10;
        this.responseConverter = r11;
    }

    private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(Retrofit r5, Method r10, Type r11, Annotation[] r12) {
        return (CallAdapter<ResponseT, ReturnT>) r5.callAdapter(r11, r12);
    L4:
        e = move-exception;
        throw Utils.methodError(r10, e, "Unable to create call adapter for %s", new Object[]{r11});
    }

    private static <ResponseT> Converter<w0, ResponseT> createResponseConverter(Retrofit r5, Method r10, Type r11) {
        return r5.responseBodyConverter(r11, r10.getAnnotations());
    L5:
        e = move-exception;
        throw Utils.methodError(r10, e, "Unable to create converter for %s", new Object[]{r11});
    }

    public static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(Retrofit r12, Method r13, RequestFactory r14) {
        boolean r5 = r14.isKotlinSuspendFunction;
        Annotation[] r10 = r13.getAnnotations();
        if (r5 == false) goto L11;
        Type[] r11 = r13.getGenericParameterTypes();
        Type r15 = Utils.getParameterLowerBound(0, (ParameterizedType) r11[r11.length - 1]);
        if (Utils.getRawType(r15) == Response.class) goto L7;
    L9:
        boolean r16 = false;
    L10:
        Type r17 = new Utils.ParameterizedTypeImpl(null, Call.class, new Type[]{r15});
        r10 = SkipCallbackExecutorImpl.ensurePresent(r10);
    L12:
        CallAdapter r18 = createCallAdapter(r12, r13, r17, r10);
        Type r19 = r18.responseType();
        if (r19 == s0.class) goto L34;
        if (r19 == Response.class) goto L32;
        if (r14.httpMethod.equals("HEAD") == true) goto L18;
    L22:
        Converter r20 = createResponseConverter(r12, r13, r19);
        i r21 = r12.callFactory;
        if (r5 == false) goto L25;
        if (r16 == false) goto L30;
        return new SuspendForResponse(r14, r21, r20, r18);
    L30:
        return new SuspendForBody(r14, r21, r20, r18, false);
    L25:
        return new CallAdapted(r14, r21, r20, r18);
    L18:
        if (Void.class.equals(r19) == true) goto L22;
        throw Utils.methodError(r13, "HEAD method must use Void as response type.", new Object[0]);
    L32:
        throw Utils.methodError(r13, "Response must include generic type (e.g., Response<String>)", new Object[0]);
    L34:
        throw Utils.methodError(r13, "'" + Utils.getRawType(r19).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
    L7:
        if ((r15 instanceof ParameterizedType) == false) goto L9;
        r15 = Utils.getParameterUpperBound(0, (ParameterizedType) r15);
        r16 = true;
        goto L10
    L11:
        r17 = r13.getGenericReturnType();
        r16 = false;
        goto L12
    }

    public abstract ReturnT adapt(Call<ResponseT> r5, Object[] r10);

    @Override // retrofit2.ServiceMethod
    public final ReturnT invoke(Object[] r5) {
        return adapt(new OkHttpCall(this.requestFactory, r5, this.callFactory, this.responseConverter), r5);
    }
}
