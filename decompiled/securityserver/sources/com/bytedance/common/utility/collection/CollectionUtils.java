package com.bytedance.common.utility.collection;

import com.bytedance.common.utility.reflect.JavaCalls;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class CollectionUtils {
    public CollectionUtils() {
    }

    public static void clear(Object r2) {
        JavaCalls.callMethod(r2, "clear", new Object[0]);
    }

    public static <T> boolean isEmpty(Collection<T> r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }
}
