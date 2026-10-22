package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class ObjectArrays {
    private ObjectArrays() {
    }

    public static <T> T[] newArray(Class<T> r0, int r1) {
        return (T[]) ((Object[]) Array.newInstance(r0, r1));
    }

    public static <T> T[] newArray(T[] r0, int r1) {
        return (T[]) Platform.newArray(r0, r1);
    }

    public static <T> T[] concat(T[] r2, T[] r3, Class<T> r4) {
        T[] r5 = (T[]) newArray(r4, r2.length + r3.length);
        System.arraycopy(r2, 0, r5, 0, r2.length);
        System.arraycopy(r3, 0, r5, r2.length, r3.length);
        return r5;
    }

    public static <T> T[] concat(@ParametricNullness T r3, T[] r4) {
        T[] r0 = (T[]) newArray(r4, r4.length + 1);
        r0[0] = r3;
        System.arraycopy(r4, 0, r0, 1, r4.length);
        return r0;
    }

    public static <T> T[] concat(T[] r1, @ParametricNullness T r2) {
        T[] r0 = (T[]) Arrays.copyOf(r1, r1.length + 1);
        r0[r1.length] = r2;
        return r0;
    }

    static <T> T[] toArrayImpl(Collection<?> r2, T[] r3) {
        int r0 = r2.size();
        if (r3.length >= r0) goto L5;
        r3 = (T[]) newArray(r3, r0);
    L5:
        fillArray(r2, r3);
        if (r3.length <= r0) goto L8;
        r3[r0] = null;
    L8:
        return r3;
    }

    static <T> T[] toArrayImpl(Object[] r2, int r3, int r4, T[] r5) {
        Preconditions.checkPositionIndexes(r3, r3 + r4, r2.length);
        if (r5.length >= r4) goto L6;
        r5 = (T[]) newArray(r5, r4);
    L8:
        System.arraycopy(r2, r3, r5, 0, r4);
        return r5;
    L6:
        if (r5.length <= r4) goto L8;
        r5[r4] = null;
        goto L8
    }

    static Object[] toArrayImpl(Collection<?> r1) {
        return fillArray(r1, new Object[r1.size()]);
    }

    static Object[] copyAsObjectArray(Object[] r2, int r3, int r4) {
        Preconditions.checkPositionIndexes(r3, r3 + r4, r2.length);
        if (r4 == 0) goto L5;
        Object[] r1 = new Object[r4];
        System.arraycopy(r2, r3, r1, 0, r4);
        return r1;
    L5:
        return new Object[0];
    }

    private static Object[] fillArray(Iterable<?> r3, Object[] r4) {
        Iterator<?> r5 = r3.iterator();
        int r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        r4[r0] = r5.next();
        r0 = r0 + 1;
        goto L4
    L6:
        return r4;
    }

    static void swap(Object[] r2, int r3, int r4) {
        Object r0 = r2[r3];
        r2[r3] = r2[r4];
        r2[r4] = r0;
    }

    static Object[] checkElementsNotNull(Object... r1) {
        return checkElementsNotNull(r1, r1.length);
    }

    static Object[] checkElementsNotNull(Object[] r2, int r3) {
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L5;
        checkElementNotNull(r2[r0], r0);
        r0 = r0 + 1;
        goto L3
    L5:
        return r2;
    }

    static Object checkElementNotNull(Object r2, int r3) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException(new StringBuilder(20).append("at index ").append(r3).toString());
    }
}
