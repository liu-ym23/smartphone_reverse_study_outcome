package retrofit2.adapter.rxjava2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import mt.a;
import mt.a0;
import mt.e;
import mt.h;
import mt.n;
import mt.z;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes3.dex */
public final class RxJava2CallAdapterFactory extends CallAdapter.Factory {
    private final boolean isAsync;
    private final z scheduler;

    private RxJava2CallAdapterFactory(z r5, boolean r10) {
        this.scheduler = r5;
        this.isAsync = r10;
    }

    public static RxJava2CallAdapterFactory create() {
        return new RxJava2CallAdapterFactory(null, false);
    }

    public static RxJava2CallAdapterFactory createAsync() {
        return new RxJava2CallAdapterFactory(null, true);
    }

    public static RxJava2CallAdapterFactory createWithScheduler(z r5) {
        if (r5 == null) goto L6;
        return new RxJava2CallAdapterFactory(r5, false);
    L6:
        throw new NullPointerException("scheduler == null");
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type r13, Annotation[] r14, Retrofit r15) {
        Class<?> r16 = CallAdapter.Factory.getRawType(r13);
        if (r16 != a.class) goto L7;
        return new RxJava2CallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, false, false, true);
    L7:
        if (r16 != e.class) goto L9;
        boolean r10 = true;
    L11:
        if (r16 != a0.class) goto L13;
        boolean r11 = true;
    L15:
        if (r16 != h.class) goto L17;
        boolean r12 = true;
    L19:
        if (r16 == n.class) goto L26;
        if (r10 == true) goto L26;
        if (r11 == true) goto L26;
        if (r12 == true) goto L26;
        return null;
    L26:
        if ((r13 instanceof ParameterizedType) == true) goto L36;
        if (r10 == true) goto L33;
        if (r11 == true) goto L32;
        if (r12 == false) goto L31;
        String r17 = "Maybe";
    L34:
        StringBuilder r18 = androidx.room.jarjarred.org.antlr.runtime.a.y(r17, " return type must be parameterized as ", r17, "<Foo> or ", r17);
        r18.append("<? extends Foo>");
        throw new IllegalStateException(r18.toString());
    L31:
        r17 = "Observable";
        goto L34
    L32:
        r17 = "Single";
        goto L34
    L33:
        r17 = "Flowable";
        goto L34
    L36:
        Type r19 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) r13);
        Class<?> r110 = CallAdapter.Factory.getRawType(r19);
        if (r110 != Response.class) goto L44;
        if ((r19 instanceof ParameterizedType) == false) goto L42;
        Type r5 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) r19);
        boolean r20 = false;
        boolean r21 = false;
    L52:
        return new RxJava2CallAdapter(r5, this.scheduler, this.isAsync, r20, r21, r10, r11, r12, false);
    L42:
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    L44:
        if (r110 == Result.class) goto L46;
        r5 = r19;
        r21 = true;
        r20 = false;
        goto L52
    L46:
        if ((r19 instanceof ParameterizedType) == false) goto L49;
        r5 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) r19);
        r20 = true;
        r21 = false;
        goto L52
    L49:
        throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
    L17:
        r12 = false;
        goto L19
    L13:
        r11 = false;
        goto L15
    L9:
        r10 = false;
        goto L11
    }
}
