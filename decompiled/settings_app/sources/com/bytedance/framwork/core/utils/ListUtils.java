package com.bytedance.framwork.core.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class ListUtils {
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
}
