package com.ttnet.org.chromium.base;

import android.util.Pair;
import com.loopj.android.http.RequestParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class CollectionUtil {
    private CollectionUtil() {
    }

    @SafeVarargs
    public static <E> HashSet<E> newHashSet(E... r2) {
        HashSet<E> r0 = new HashSet(r2.length);
        Collections.addAll(r0, r2);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> HashMap<K, V> newHashMap(Pair<? extends K, ? extends V>... r5) {
        RequestParams.AnonymousClass1 r0 = (HashMap<K, V>) new HashMap();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Pair<? extends K, ? extends V> r3 = r5[r2];
        r0.put(r3.first, r3.second);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static boolean[] booleanListToBooleanArray(List<Boolean> r3) {
        boolean[] r0 = new boolean[r3.size()];
        int r1 = 0;
    L4:
        if (r1 >= r3.size()) goto L6;
        r0[r1] = r3.get(r1).booleanValue();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static int[] integerListToIntArray(List<Integer> r3) {
        int[] r0 = new int[r3.size()];
        int r1 = 0;
    L4:
        if (r1 >= r3.size()) goto L6;
        r0[r1] = r3.get(r1).intValue();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static long[] longListToLongArray(List<Long> r4) {
        long[] r0 = new long[r4.size()];
        int r1 = 0;
    L4:
        if (r1 >= r4.size()) goto L6;
        r0[r1] = r4.get(r1).longValue();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static <T> void forEach(Collection<? extends T> r1, Callback<T> r2) {
        Iterator<? extends T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.onResult(r3.next());
        goto L4
    }

    public static <K, V> void forEach(Map<? extends K, ? extends V> r1, Callback<Map.Entry<K, V>> r2) {
        Iterator<Map.Entry<? extends K, ? extends V>> r3 = r1.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.onResult(r3.next());
        goto L4
    }

    public static <T> List<T> strengthen(Collection<WeakReference<T>> r2) {
        ArrayList r0 = new ArrayList(r2.size());
        Iterator<WeakReference<T>> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        T r1 = r3.next().get();
        if (r1 == null) goto L7;
        r0.add(r1);
        goto L4
    L7:
        r3.remove();
        goto L4
    L9:
        return r0;
    }
}
