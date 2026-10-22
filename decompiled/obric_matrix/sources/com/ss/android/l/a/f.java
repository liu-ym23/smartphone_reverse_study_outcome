package com.ss.android.l.a;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    static {
    }

    public static String a(Map<String, Float> r4) {
        if (r4 != null) goto L4;
    L16:
        return BDLocationException.ERROR_TIMEOUT;
    L4:
        if (r4.isEmpty() == true) goto L16;
        Map.Entry<String, Float> r0 = null;
        Iterator<Map.Entry<String, Float>> r5 = r4.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L14;
        Map.Entry<String, Float> r1 = r5.next();
        if (r1 == null) goto L7;
        if (r0 == null) goto L13;
        if (r0.getValue().floatValue() >= r1.getValue().floatValue()) goto L7;
    L13:
        r0 = r1;
        goto L7
    L14:
        if (r0 == null) goto L16;
        return r0.getKey();
    }

    public static int b(String r6) {
        r6.hashCode();
        switch(r6.hashCode()) {
            case 49: goto L22;
            case 50: goto L18;
            case 51: goto L14;
            case 1444: goto L10;
            case 1445: goto L6;
            default: goto L4;
        };
    L4:
        byte r7 = -1;
    L25:
        switch(r7) {
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L27;
            default: goto L26;
        };
    L26:
        return 0;
    L27:
        return -2;
    L29:
        return -1;
    L30:
        return 3;
    L31:
        return 2;
    L32:
        return 1;
    L6:
        if (r6.equals("-2") == false) goto L33;
        r7 = 4;
        goto L25
    L33:
        r7 = -1;
        goto L25
    L10:
        if (r6.equals("-1") == false) goto L34;
        r7 = 3;
        goto L25
    L34:
        r7 = -1;
        goto L25
    L14:
        if (r6.equals("3") == false) goto L35;
        r7 = 2;
        goto L25
    L35:
        r7 = -1;
        goto L25
    L18:
        if (r6.equals("2") == false) goto L36;
        r7 = 1;
        goto L25
    L36:
        r7 = -1;
        goto L25
    L22:
        if (r6.equals(LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L37;
        r7 = 0;
        goto L25
    L37:
        r7 = -1;
        goto L25
    }
}
