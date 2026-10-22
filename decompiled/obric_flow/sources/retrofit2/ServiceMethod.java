package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
abstract class ServiceMethod<T> {
    public ServiceMethod() {
    }

    public static <T> ServiceMethod<T> parseAnnotations(Retrofit r5, Method r10) {
        RequestFactory r11 = RequestFactory.parseAnnotations(r5, r10);
        Type r12 = r10.getGenericReturnType();
        if (Utils.hasUnresolvableType(r12) == true) goto L11;
        if (r12 == Void.TYPE) goto L9;
        return HttpServiceMethod.parseAnnotations(r5, r10, r11);
    L9:
        throw Utils.methodError(r10, "Service methods cannot return void.", new Object[0]);
    L11:
        throw Utils.methodError(r10, "Method return type must not include a type variable or wildcard: %s", new Object[]{r12});
    }

    public abstract T invoke(Object[] r5);
}
