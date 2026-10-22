package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class TypeCapture<T> {
    TypeCapture() {
    }

    final Type capture() {
        Type r2 = getClass().getGenericSuperclass();
        Preconditions.checkArgument(r2 instanceof ParameterizedType, "%s isn't parameterized", r2);
        return ((ParameterizedType) r2).getActualTypeArguments()[0];
    }
}
