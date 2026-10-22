package com.bytedance.apm6.util;

import android.util.Pair;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class ListUtils {

    public interface ComparableDiffType<A, B> {
        boolean equals(A r1, B r2);
    }

    public ListUtils() {
    }

    public static boolean isEmpty(List<?> r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.size() == 0) goto L7;
        return false;
    }

    public static String[] toArray(Set<String> r4) {
        String[] r0 = new String[r4.size()];
        Iterator<String> r5 = r4.iterator();
        int r1 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0[r1] = r5.next();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static String listToString(Collection r3, String r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        StringBuilder r0 = new StringBuilder();
        Iterator r5 = r3.iterator();
        boolean r1 = true;
    L7:
        if (r5.hasNext() == false) goto L14;
        Object r2 = r5.next();
        if (r1 == false) goto L11;
        r1 = false;
    L12:
        r0.append(r2.toString());
        goto L7
    L11:
        r0.append(r4);
        goto L12
    L14:
        return r0.toString();
    }

    public static String arrayToString(Object[] r6, String r7) {
        if (r6 != null) goto L5;
        return "";
    L5:
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        boolean r3 = true;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L13;
        Object r5 = r6[r4];
        if (r3 == false) goto L10;
        r3 = false;
    L11:
        r0.append(r5.toString());
        r4 = r4 + 1;
        goto L6
    L10:
        r0.append(r7);
        goto L11
    L13:
        return r0.toString();
    }

    public static Map<String, String> listToMap(List<Pair<String, String>> r3) {
        if (isEmpty(r3) == true) goto L5;
        HashMap r0 = new HashMap();
        Iterator<Pair<String, String>> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L15;
        Pair<String, String> r1 = r4.next();
        if (r1 == null) goto L8;
        if (r1.first == null) goto L8;
        r0.put(r1.first, r1.second);
        goto L8
    L15:
        return r0;
    L5:
        return Collections.emptyMap();
    }

    public static <L, O> boolean removeAll(Collection<L> r2, O r3, ComparableDiffType<? super L, O> r4) {
        Iterator<L> r5 = r2.iterator();
        boolean r0 = false;
    L4:
        if (r5.hasNext() == false) goto L8;
        if (r4.equals(r5.next(), r3) == false) goto L4;
        r5.remove();
        r0 = true;
        goto L4
    L8:
        return r0;
    }
}
