package org.apache.commons.math3.exception.util;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class ArgUtils {
    private ArgUtils() {
    }

    public static Object[] flatten(Object[] r8) {
        ArrayList r0 = new ArrayList();
        if (r8 == null) goto L14;
        int r1 = r8.length;
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L14;
        Object r4 = r8[r3];
        if ((r4 instanceof Object[]) == false) goto L11;
        Object[] r5 = flatten((Object[]) r4);
        int r6 = r5.length;
        int r7 = 0;
    L9:
        if (r7 >= r6) goto L12;
        r0.add(r5[r7]);
        r7 = r7 + 1;
    L12:
        r3 = r3 + 1;
        goto L5
    L11:
        r0.add(r4);
    L14:
        return r0.toArray();
    }
}
