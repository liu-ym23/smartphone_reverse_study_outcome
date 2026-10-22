package com.bytedance.news.common.settings.h;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static boolean a(JSONObject r1, String r2) {
        return b(r1, r2, false);
    }

    public static boolean b(JSONObject r0, String r1, boolean r2) {
        Boolean r3 = c(r0.opt(r1));
        if (r3 != null) goto L5;
        return r2;
    L5:
        return r3.booleanValue();
    }

    private static Boolean c(Object r4) {
        Boolean r0 = Boolean.FALSE;
        Boolean r1 = Boolean.TRUE;
        if ((r4 instanceof Boolean) == false) goto L7;
        return (Boolean) r4;
    L7:
        if ((r4 instanceof Integer) == false) goto L15;
        Integer r5 = (Integer) r4;
        if (r5.intValue() != 1) goto L12;
        return r1;
    L12:
        if (r5.intValue() != 0) goto L27;
        return r0;
    L27:
        return null;
    L15:
        if ((r4 instanceof String) == false) goto L29;
        String r6 = (String) r4;
        if ("true".equalsIgnoreCase(r6) == false) goto L19;
    L26:
        return r1;
    L19:
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(r6) == true) goto L26;
        if ("false".equalsIgnoreCase(r6) == false) goto L24;
    L25:
        return r0;
    L24:
        if (BDLocationException.ERROR_TIMEOUT.equals(r6) == true) goto L25;
        return null;
    L29:
        return null;
    }
}
