package com.bytedance.applog.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i {
    private static boolean a(Object r0, Object r1, String r2) {
        if (r0 != null) goto L4;
        if (r1 == null) goto L4;
    L7:
        return false;
    L4:
        if (r0 == null) goto L8;
        if (r1 == null) goto L7;
    L8:
        return true;
    }

    private static boolean b(Object r3, Object r4, String r5) {
        if (a(r3, r4, r5) == true) goto L6;
        return false;
    L6:
        if ((r3 instanceof JSONObject) == false) goto L10;
        return e((JSONObject) r3, (JSONObject) r4, r5);
    L10:
        if ((r3 instanceof JSONArray) == false) goto L14;
        return d((JSONArray) r3, (JSONArray) r4, r5);
    L14:
        if (r3.getClass() == r4.getClass()) goto L17;
        return false;
    L17:
        return c(r3.toString(), r4.toString(), r5);
    }

    private static boolean c(String r0, String r1, String r2) {
        if (a(r0, r1, r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
        return true;
    }

    private static boolean d(JSONArray r5, JSONArray r6, String r7) {
        if (a(r5, r6, r7) == true) goto L5;
        return false;
    L5:
        HashMap r8 = new HashMap();
        int r1 = 0;
    L7:
        if (r1 >= r5.length()) goto L15;
        Object r2 = r5.get(r1);
        if (r8.containsKey(r2) == true) goto L11;
    L13:
        int r3 = 1;
    L14:
        r8.put(r2, r3);
        r1 = r1 + 1;
        goto L7
    L11:
        if (r8.get(r2) == null) goto L13;
        r3 = Integer.valueOf(((Integer) r8.get(r2)).intValue() + 1);
        goto L14
    L15:
        HashMap r9 = new HashMap();
        int r4 = 0;
    L17:
        if (r4 >= r6.length()) goto L26;
        Object r10 = r6.get(r4);
        if (r9.containsKey(r10) == true) goto L21;
    L23:
        int r11 = 1;
    L24:
        r9.put(r10, r11);
        r4 = r4 + 1;
        goto L17
    L21:
        if (r9.get(r10) == null) goto L23;
        r11 = Integer.valueOf(((Integer) r9.get(r10)).intValue() + 1);
        goto L24
    L26:
        if (r8.size() == r9.size()) goto L28;
        return false;
    L28:
        Iterator r12 = r8.entrySet().iterator();
    L30:
        if (r12.hasNext() == false) goto L34;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (((Integer) r13.getValue()).equals((Integer) r9.get(r13.getKey())) == true) goto L30;
        return false;
    L34:
        return true;
    }

    public static boolean e(JSONObject r3, JSONObject r4, String r5) {
        if (a(r3, r4, r5) == true) goto L5;
        return false;
    L5:
        if (r3 != null) goto L7;
    L9:
        Iterator<String> r6 = r3.keys();
        boolean r0 = true;
    L11:
        if (r6.hasNext() == false) goto L14;
        String r1 = r6.next();
        r0 = b(r3.get(r1), r4.get(r1), r1);
        if (r0 == true) goto L11;
    L14:
        return r0;
    L7:
        if (r3.length() == r4.length()) goto L9;
        return false;
    }
}
