package com.bytedance.applog.r;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class e {
    static List<c> a(Map<String, Map<String, b.c>> r3) {
        List<JSONObject> r4 = c(r3);
        ArrayList r0 = new ArrayList();
        Iterator<JSONObject> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(new c(r5.next()));
        goto L4
    L6:
        return r0;
    }

    static Map<String, Map<String, b.c>> b(List<JSONObject> r12) {
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        if (r12 != null) goto L5;
    L19:
        return r0;
    L5:
        if (r12.size() == 0) goto L19;
        Iterator<JSONObject> r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L19;
        JSONObject r1 = r13.next();
        String r2 = r1.optString("key", b.a.f2330f.name());     // Catch: Throwable -> L20
        String r3 = r1.optString(WsConstants.KEY_CONNECTION_STATE, b.d.f2345f.name());     // Catch: Throwable -> L20
        int r4 = r1.optInt("total", 0);
        long r5 = r1.optLong(TypedValues.TransitionType.S_DURATION, -1);
        long r10 = r1.optLong("date", 0);
        if (r10 == 0) goto L9;
        b.c r6 = new b.c(r10);
        r6.f2341a = r4;
        r6.f2342b = r5;
        Map r7 = (Map) r0.get(r2);
        if (r7 != null) goto L18;
        r7 = new ConcurrentHashMap();
        r0.put(r2, r7);
    L18:
        r7.put(r3, r6);
        goto L9
    }

    static List<JSONObject> c(Map<String, Map<String, b.c>> r8) {
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, Map<String, b.c>>> r9 = r8.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L22;
        Map.Entry<String, Map<String, b.c>> r1 = r9.next();
        Map<String, b.c> r2 = r1.getValue();
        if (r2 == null) goto L4;
        if (r2.size() == 0) goto L4;
        Iterator<Map.Entry<String, b.c>> r3 = r2.entrySet().iterator();
    L12:
        if (r3.hasNext() == false) goto L4;
        Map.Entry<String, b.c> r4 = r3.next();
        String r5 = r4.getKey();
        b.c r6 = r4.getValue();
        if (r6 == null) goto L12;
        JSONObject r7 = new JSONObject();
        r7.put("key", r1.getKey());     // Catch: Throwable -> L23
        r7.put(WsConstants.KEY_CONNECTION_STATE, r5);     // Catch: Throwable -> L23
        r7.put("total", r6.f2341a);     // Catch: Throwable -> L23
        r7.put("date", r6.f2343c);     // Catch: Throwable -> L23
        long r10 = r6.f2342b;     // Catch: Throwable -> L23
        if (r10 == (-1)) goto L20;
        r7.put(TypedValues.TransitionType.S_DURATION, r10);     // Catch: Throwable -> L23
    L20:
        r7.put("params_for_special", "applog_trace");     // Catch: Throwable -> L23
        r0.add(r7);     // Catch: Throwable -> L23
        goto L12
    L22:
        return r0;
    }

    static Map<String, Map<String, b.c>> d(Map<String, Map<String, b.c>>... r17) {
        ConcurrentHashMap r1 = new ConcurrentHashMap();
        int r2 = r17.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L33;
        Iterator<Map.Entry<String, Map<String, b.c>>> r4 = r17[r3].entrySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L32;
        Map.Entry<String, Map<String, b.c>> r5 = r4.next();
        String r6 = r5.getKey();
        Map<String, b.c> r7 = r5.getValue();
        if (r7 == null) goto L6;
        if (r7.size() == 0) goto L6;
        Iterator<Map.Entry<String, b.c>> r8 = r7.entrySet().iterator();
    L14:
        if (r8.hasNext() == false) goto L6;
        Map.Entry<String, b.c> r9 = r8.next();
        String r10 = r9.getKey();
        b.c r11 = r9.getValue();
        Map r12 = (Map) r1.get(r6);
        if (r12 != null) goto L18;
        r12 = new ConcurrentHashMap(4);
        r1.put(r6, r12);
    L18:
        b.c r13 = (b.c) r12.get(r10);
        if (r13 != null) goto L21;
        r13 = new b.c();
        r13.f2342b = -1;
    L21:
        if (r11 == null) goto L14;
        r13.f2341a += r11.f2341a;
        long r14 = r13.f2342b;
        if (r14 != (-1)) goto L26;
        r13.f2342b = r11.f2342b;
    L31:
        r12.put(r10, r13);
        r4 = r4;
        r8 = r8;
        goto L14
    L26:
        long r15 = r11.f2342b;
        if (r15 == (-1)) goto L30;
        r14 = r14 + r15;
    L30:
        r13.f2342b = r14;
        goto L31
    L32:
        r3 = r3 + 1;
        goto L3
    L33:
        return r1;
    }
}
