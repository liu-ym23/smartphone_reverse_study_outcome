package com.bytedance.retrofit2;

import android.os.SystemClock;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
abstract class ServiceMethod<T> {
    public ServiceMethod() {
    }

    public static <T> ServiceMethod<T> parseAnnotations(Retrofit r3, Method r4, RetrofitMetrics r5) {
        r5.retrofitMethodInvokeTime = SystemClock.uptimeMillis();
        RequestFactory r0 = RequestFactory.parseAnnotations(r3, r4, r5);
        Type r1 = r4.getGenericReturnType();
        if (Utils.hasUnresolvableType(r1) == true) goto L11;
        if (r1 == Void.TYPE) goto L9;
        r5.createSsHttpCallTime = SystemClock.uptimeMillis();
        return HttpServiceMethod.parseAnnotations(r3, r4, r0);
    L9:
        throw Utils.methodError(r4, "Service methods cannot return void.", new Object[0]);
    L11:
        throw Utils.methodError(r4, "Method return type must not include a type variable or wildcard: %s", new Object[]{r1});
    }

    @Nullable
    public abstract T invoke(Object[] r1);
}
