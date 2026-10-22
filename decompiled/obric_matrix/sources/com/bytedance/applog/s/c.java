package com.bytedance.applog.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.applog.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static a b(com.bytedance.applog.q.b r4) {
        a r0 = new a();
        SharedPreferences r1 = a(r4.m(), "priority_list", 0);
        r0.f2358a = r1.getInt("priority_version", 0);
        r0.f2359b = r1.getInt("base_interval", 5);
        String r2 = r1.getString("priorities", null);
        if (TextUtils.isEmpty(r2) == false) goto L9;
    L8:
        return r0;
    L9:
        d(r4, r0, new JSONArray(r2));     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        n.c("parseEventPriorityFromLocal", e);
        goto L8
    }

    public static void c(com.bytedance.applog.q.b r8, @NonNull JSONObject r9) {
        JSONObject r10 = r9.optJSONObject("priority_list");
        if (r10 == null) goto L16;
        a r4 = new a();     // Catch: Throwable -> L11
        r4.f2358a = r10.optInt("priority_version", 0);     // Catch: Throwable -> L11
        r4.f2359b = r10.optInt("base_interval", 5);     // Catch: Throwable -> L11
        JSONArray r11 = r10.optJSONArray("priorities");     // Catch: Throwable -> L11
        d(r8, r4, r11);     // Catch: Throwable -> L11
        a r6 = r8.q();     // Catch: Throwable -> L11
        if (r4.d() == false) goto L17;
        if (r6 != null) goto L8;
    L9:
        r8.P(r4, true);     // Catch: Throwable -> L11
        SharedPreferences.Editor r12 = a(r8.m(), "priority_list", 0).edit();     // Catch: Throwable -> L11
        r12.putInt("priority_version", r4.f2358a);     // Catch: Throwable -> L11
        r12.putInt("base_interval", r4.f2359b);     // Catch: Throwable -> L11
        r12.putString("priorities", r11.toString());     // Catch: Throwable -> L11
        r12.apply();     // Catch: Throwable -> L11
        return;
    L8:
        if (r4.f2358a > r6.f2358a) goto L9;
        return;
    L17:
        return;
    L11:
        th = move-exception;
        n.c("parseEventPriorityFromServer", th);
        return;
    }

    private static void d(com.bytedance.applog.q.b r17, a r18, JSONArray r19) {
        r18.f2360c = new HashMap();
        r18.f2362e = new HashMap();
        if (r19 != null) goto L5;
        return;
    L5:
        if (r19.length() <= 0) goto L143;
        int r3 = 0;
    L96:
    L93:
        th = move-exception;
        n.c("parsePriorityMapFromJsonArray", th);
        return;
    L8:
        if (r3 >= r19.length()) goto L88;
        JSONObject r4 = r19.optJSONObject(r3);     // Catch: Throwable -> L93
        if (r4 == null) goto L87;
        b r5 = new b();     // Catch: Throwable -> L93
        int r6 = r4.optInt("priority");     // Catch: Throwable -> L93
        r5.f2363a = r6;     // Catch: Throwable -> L93
        if (r6 <= r18.f2361d) goto L14;
        r18.f2361d = r6;     // Catch: Throwable -> L93
    L14:
        r5.f2365c = r18.f2358a;     // Catch: Throwable -> L93
        int r7 = r4.optInt("interval_multiple");     // Catch: Throwable -> L93
        r5.f2366d = r7;     // Catch: Throwable -> L93
        if (r7 > 0) goto L17;
        r5.f2366d = 1;     // Catch: Throwable -> L93
    L17:
        long r8 = ((long) (r18.f2359b * r5.f2366d)) * 1000;     // Catch: Throwable -> L93
        r5.f2367e = r8;     // Catch: Throwable -> L93
        r5.f2374l = new com.bytedance.applog.y.a(r17, r8);     // Catch: Throwable -> L93
        r5.f2370h = r4.optString("report_host");     // Catch: Throwable -> L93
        r5.f2371i = r4.optString("report_path");     // Catch: Throwable -> L93
        r5.m = r4.optInt("forward_open");     // Catch: Throwable -> L93
        r5.n = r4.optString("forward_report_host");     // Catch: Throwable -> L93
        r5.o = r4.optString("forward_report_path");     // Catch: Throwable -> L93
        JSONArray r9 = r4.optJSONArray("events");     // Catch: Throwable -> L93
        if (r9 != null) goto L20;
    L28:
        JSONObject r10 = r4.optJSONObject("param_keys");     // Catch: Throwable -> L93
        if (r10 == null) goto L57;
        r5.f2368f = new HashMap();     // Catch: Throwable -> L93
        Iterator<String> r11 = r10.keys();     // Catch: Throwable -> L93
    L32:
        if (r11.hasNext() == false) goto L57;
        String r12 = r11.next();     // Catch: Throwable -> L93
        if (TextUtils.isEmpty(r12) == true) goto L32;
        JSONArray r13 = r10.optJSONArray(r12);     // Catch: Throwable -> L93
        if (r13 == null) goto L32;
        if (r13.length() <= 0) goto L32;
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L93
        int r15 = 0;
    L42:
        if (r15 >= r13.length()) goto L56;
        JSONArray r16 = r13.optJSONArray(r15);     // Catch: Throwable -> L93
        if (r16 == null) goto L55;
        if (r16.length() <= 0) goto L55;
        HashSet r110 = new HashSet();     // Catch: Throwable -> L93
        int r111 = 0;
    L49:
        if (r111 >= r16.length()) goto L54;
        String r2 = r16.optString(r111);     // Catch: Throwable -> L93
        if (TextUtils.isEmpty(r2) == true) goto L53;
        r110.add(r2);     // Catch: Throwable -> L93
    L53:
        r111 = r111 + 1;     // Catch: Throwable -> L93
        goto L49
    L54:
        r14.add(r110);     // Catch: Throwable -> L93
    L55:
        r15 = r15 + 1;     // Catch: Throwable -> L93
        goto L42
    L56:
        r5.f2368f.put(r12, r14);     // Catch: Throwable -> L93
    L57:
        JSONObject r20 = r4.optJSONObject("param_key_values");     // Catch: Throwable -> L93
        if (r20 == null) goto L85;
        r5.f2369g = new HashMap();     // Catch: Throwable -> L93
        Iterator<String> r21 = r20.keys();     // Catch: Throwable -> L93
    L61:
        if (r21.hasNext() == false) goto L85;
        String r22 = r21.next();     // Catch: Throwable -> L93
        if (TextUtils.isEmpty(r22) == true) goto L61;
        JSONArray r23 = r20.optJSONArray(r22);     // Catch: Throwable -> L93
        if (r23 == null) goto L61;
        if (r23.length() <= 0) goto L61;
        ArrayList r24 = new ArrayList();     // Catch: Throwable -> L93
        int r112 = 0;
    L71:
        if (r112 >= r23.length()) goto L84;
        JSONObject r113 = r23.optJSONObject(r112);     // Catch: Throwable -> L93
        if (r113 == null) goto L83;
        HashMap r114 = new HashMap();     // Catch: Throwable -> L93
        Iterator<String> r115 = r113.keys();     // Catch: Throwable -> L93
    L76:
        if (r115.hasNext() == false) goto L82;
        String r116 = r115.next();     // Catch: Throwable -> L93
        if (TextUtils.isEmpty(r116) == true) goto L76;
        Object r117 = r113.opt(r116);     // Catch: Throwable -> L93
        if (r117 == null) goto L76;
        r114.put(r116, r117);     // Catch: Throwable -> L93
        goto L76
    L82:
        r24.add(r114);     // Catch: Throwable -> L93
    L83:
        r112 = r112 + 1;     // Catch: Throwable -> L93
        goto L71
    L84:
        r5.f2369g.put(r22, r24);     // Catch: Throwable -> L93
    L85:
        r18.f2360c.put(Integer.valueOf(r5.f2363a), r5);     // Catch: Throwable -> L93
        goto L87
    L20:
        if (r9.length() <= 0) goto L28;
        int r25 = 0;
    L23:
        if (r25 >= r9.length()) goto L28;
        String r26 = r9.optString(r25);     // Catch: Throwable -> L93
        if (TextUtils.isEmpty(r26) == true) goto L27;
        r18.f2362e.put(r26, Integer.valueOf(r5.f2363a));     // Catch: Throwable -> L93
    L27:
        r25 = r25 + 1;     // Catch: Throwable -> L93
    L87:
        r3 = r3 + 1;     // Catch: Throwable -> L93
        goto L96
    L88:
        Iterator<b> r1 = r18.f2360c.values().iterator();     // Catch: Throwable -> L93
    L89:
        if (r1.hasNext() == false) goto L144;
        b r27 = r1.next();     // Catch: Throwable -> L93
        r27.f2364b = r18.f2361d;     // Catch: Throwable -> L93
        goto L89
    L144:
        return;
    }

    public static void e(@NonNull JSONObject r6, a r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        JSONArray r8 = r6.optJSONArray("priority_request_config");
        if (r8 != null) goto L7;
        return;
    L7:
        if (r8.length() <= 0) goto L22;
        int r0 = 0;
    L10:
        if (r0 >= r8.length()) goto L23;
        JSONObject r1 = r8.optJSONObject(r0);
        if (r1 == null) goto L16;
        b r2 = r7.a(r1.optInt("priority"));
        if (r2 == null) goto L16;
        r2.f2374l.c(r1, r2.c(), r2);
    L16:
        r0 = r0 + 1;
        goto L10
    L23:
        return;
    }
}
