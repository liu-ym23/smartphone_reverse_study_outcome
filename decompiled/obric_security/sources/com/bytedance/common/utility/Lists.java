package com.bytedance.common.utility;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Lists {
    public Lists() {
    }

    public static <T> boolean isEmpty(List<T> r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.size() == 0) goto L7;
        return false;
    }

    public static <T> boolean notEmpty(List<T> r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.size() <= 0) goto L6;
        return true;
    }

    public static <T> boolean deepEquals(List<T> r5, List<T> r6) {
        if (r5 != r6) goto L6;
        return true;
    L6:
        if (r5 == null) goto L19;
        if (r6 == null) goto L19;
        if (r5.size() != r6.size()) goto L19;
        int r2 = 0;
    L13:
        if (r2 >= r5.size()) goto L18;
        if (r5.get(r2).equals(r6.get(r2)) == false) goto L16;
        r2 = r2 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    L19:
        return false;
    }
}
