package com.obric.matrix.r.e;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static String a(Map<String, Object> r3, @NonNull String r4, @NonNull String r5) {
        if (r3 != null) goto L5;
        return "";
    L5:
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<String, Object>> r6 = r3.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L10;
        Map.Entry<String, Object> r1 = r6.next();
        r0.append(r1.getKey());
        r0.append(r4);
        r0.append(r1.getValue());
        r0.append(r5);
        goto L7
    L10:
        return r0.toString();
    }
}
