package com.squareup.wire;

import com.squareup.wire.WireEnum;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
final class RuntimeEnumAdapter<E extends WireEnum> extends EnumAdapter<E> {
    private Method fromValueMethod;
    private final Class<E> type;

    public RuntimeEnumAdapter(Class<E> r1) {
        super(r1);
        this.type = r1;
    }

    private Method getFromValueMethod() {
        Method r0 = this.fromValueMethod;
        if (r0 == null) goto L10;
        return r0;
    L10:
        Method r1 = this.type.getMethod("fromValue", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L7
        this.fromValueMethod = r1;     // Catch: NoSuchMethodException -> L7
        return r1;
    L7:
        e = move-exception;
        throw new AssertionError(e);
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof RuntimeEnumAdapter) == true) goto L5;
    L7:
        return false;
    L5:
        if (((RuntimeEnumAdapter) r2).type != this.type) goto L7;
        return true;
    }

    @Override // com.squareup.wire.EnumAdapter
    public E fromValue(int r2) {
        return (E) getFromValueMethod().invoke(null, new Object[]{Integer.valueOf(r2)});
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public int hashCode() {
        return this.type.hashCode();
    }
}
