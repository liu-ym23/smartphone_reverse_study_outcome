package com.bytedance.common.utility.collection;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ArrayUtils {
    private ArrayUtils() {
    }

    public static long[] toLongArray(List<Long> r0) {
        return com.bytedance.android.standard.tools.collection.ArrayUtils.toLongArray(r0);
    }

    public static List<Long> toList(long[] r0) {
        return com.bytedance.android.standard.tools.collection.ArrayUtils.toList(r0);
    }

    public static <T> T[] combineArray(T[] r0, T[] r1) {
        return (T[]) com.bytedance.android.standard.tools.collection.ArrayUtils.combineArray(r0, r1);
    }

    public static <T> T[] insert(T[] r0, int r1, T r2) {
        return (T[]) com.bytedance.android.standard.tools.collection.ArrayUtils.insert(r0, r1, r2);
    }

    public static <T> T[] copyOfRange(T[] r0, int r1, int r2) {
        return (T[]) com.bytedance.android.standard.tools.collection.ArrayUtils.copyOfRange(r0, r1, r2);
    }
}
