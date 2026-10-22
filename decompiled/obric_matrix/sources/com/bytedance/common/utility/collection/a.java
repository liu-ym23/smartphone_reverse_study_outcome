package com.bytedance.common.utility.collection;

import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static <T> boolean a(Collection<T> r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }
}
