package com.bytedance.bdlocation.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CollectionUtil {
    public CollectionUtil() {
    }

    public static boolean containsIgnoreCase(List<String> r3, String r4) {
        if (r3 != null) goto L5;
    L13:
        return false;
    L5:
        if (r3.size() < 1) goto L13;
        Iterator<String> r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        if (r5.next().equalsIgnoreCase(r4) == false) goto L9;
        return true;
    }

    public static boolean isEmpty(Collection r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }
}
