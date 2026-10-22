package com.bytedance.retrofit2;

import android.os.SystemClock;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
abstract class ServiceMethod<T> {
    @Nullable
    abstract T invoke(Object[] r1);

    ServiceMethod() {
    }

    static <T> ServiceMethod<T> parseAnnotations(Retrofit r4, Method r5, RetrofitMetrics r6) {
        r6.retrofitMethodInvokeTime = SystemClock.uptimeMillis();
        RequestFactory r0 = RequestFactory.parseAnnotations(r4, r5, r6);
        Type r1 = r5.getGenericReturnType();
        if (Utils.hasUnresolvableType(r1) == true) goto L11;
        if (r1 == Void.TYPE) goto L9;
        r6.createSsHttpCallTime = SystemClock.uptimeMillis();
        return HttpServiceMethod.parseAnnotations(r4, r5, r0);
    L9:
        throw Utils.methodError(r5, "Service methods cannot return void.", new Object[0]);
    L11:
        throw Utils.methodError(r5, "Method return type must not include a type variable or wildcard: %s", new Object[]{r1});
    }
}
