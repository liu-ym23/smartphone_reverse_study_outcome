package com.bytedance.applog.u;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private static void b(b r17, JSONArray r18) {
        JSONArray r0 = r18;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r18.length() <= 0) goto L123;
        int r2 = 0;
    L89:
        if (r2 >= r18.length()) goto L125;
        JSONObject r3 = r0.optJSONObject(r2);     // Catch: Throwable -> L88
        if (r3 == null) goto L86;
        int r6 = r3.optInt("sampling_rate");     // Catch: Throwable -> L88
        int r7 = r3.optInt("sampling_method");     // Catch: Throwable -> L88
        HashSet r8 = new HashSet();     // Catch: Throwable -> L88
        JSONArray r4 = r3.optJSONArray("events");     // Catch: Throwable -> L88
        if (r4 != null) goto L14;
    L22:
        HashMap r9 = new HashMap();     // Catch: Throwable -> L88
        JSONObject r5 = r3.optJSONObject("param_keys");     // Catch: Throwable -> L88
        if (r5 == null) goto L52;
        Iterator<String> r10 = r5.keys();     // Catch: Throwable -> L88
    L26:
        if (r10.hasNext() == false) goto L52;
        String r11 = r10.next();     // Catch: Throwable -> L88
        if (TextUtils.isEmpty(r11) == true) goto L26;
        JSONArray r12 = r5.optJSONArray(r11);     // Catch: Throwable -> L88
        if (r12 == null) goto L26;
        if (r12.length() <= 0) goto L26;
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L88
        int r14 = 0;
    L36:
        if (r14 >= r12.length()) goto L50;
        JSONArray r15 = r12.optJSONArray(r14);     // Catch: Throwable -> L88
        if (r15 == null) goto L49;
        if (r15.length() <= 0) goto L49;
        HashSet r16 = new HashSet();     // Catch: Throwable -> L88
        int r1 = 0;
    L43:
        if (r1 >= r15.length()) goto L48;
        String r19 = r15.optString(r1);     // Catch: Throwable -> L88
        if (TextUtils.isEmpty(r19) == true) goto L47;
        r16.add(r19);     // Catch: Throwable -> L88
    L47:
        r1 = r1 + 1;     // Catch: Throwable -> L88
        goto L43
    L48:
        r13.add(r16);     // Catch: Throwable -> L88
    L49:
        r14 = r14 + 1;     // Catch: Throwable -> L88
        goto L36
    L50:
        r9.put(r11, r13);     // Catch: Throwable -> L88
    L52:
        HashMap r110 = new HashMap();     // Catch: Throwable -> L88
        JSONObject r20 = r3.optJSONObject("param_key_values");     // Catch: Throwable -> L88
        if (r20 == null) goto L85;
        Iterator<String> r21 = r20.keys();     // Catch: Throwable -> L88
    L56:
        if (r21.hasNext() == false) goto L85;
        String r22 = r21.next();     // Catch: Throwable -> L88
        if (TextUtils.isEmpty(r22) == true) goto L56;
        JSONArray r23 = r20.optJSONArray(r22);     // Catch: Throwable -> L88
        if (r23 != null) goto L63;
    L83:
        JSONObject r111 = r20;
    L84:
        r20 = r111;
        goto L56
    L63:
        if (r23.length() <= 0) goto L83;
        ArrayList r24 = new ArrayList();     // Catch: Throwable -> L88
        int r112 = 0;
    L66:
        if (r112 >= r23.length()) goto L82;
        JSONObject r113 = r23.optJSONObject(r112);     // Catch: Throwable -> L88
        if (r113 == null) goto L80;
        HashMap r114 = new HashMap();     // Catch: Throwable -> L88
        Iterator<String> r115 = r113.keys();     // Catch: Throwable -> L88
    L71:
        if (r115.hasNext() == false) goto L79;
        String r116 = r115.next();     // Catch: Throwable -> L88
        if (TextUtils.isEmpty(r116) == true) goto L77;
        JSONObject r117 = r20;
        Object r25 = r113.opt(r116);     // Catch: Throwable -> L88
        if (r25 == null) goto L78;
        r114.put(r116, r25);     // Catch: Throwable -> L88
    L78:
        r20 = r117;
        goto L71
    L77:
        r117 = r20;
        goto L78
    L79:
        JSONObject r118 = r20;
        r24.add(r114);     // Catch: Throwable -> L88
    L81:
        r112 = r112 + 1;     // Catch: Throwable -> L88
        r20 = r118;
        goto L66
    L80:
        r118 = r20;
        goto L81
    L82:
        r111 = r20;
        r110.put(r22, r24);     // Catch: Throwable -> L88
    L85:
        r17.a(r6, r7, r8, r9, r110);     // Catch: Throwable -> L88
        goto L86
    L14:
        if (r4.length() <= 0) goto L22;
        int r26 = 0;
    L17:
        if (r26 >= r4.length()) goto L22;
        String r27 = r4.optString(r26);     // Catch: Throwable -> L88
        if (TextUtils.isEmpty(r27) == true) goto L21;
        r8.add(r27);     // Catch: Throwable -> L88
    L21:
        r26 = r26 + 1;     // Catch: Throwable -> L88
    L86:
        r2 = r2 + 1;
        r0 = r18;
        goto L89
    L125:
        return;
    L124:
        return;
    }

    public static b c(Context r6, String r7, JSONObject r8, b r9) {
        if (r8 != null) goto L19;
        return r9;
    L19:
        b r2 = new b();     // Catch: Throwable -> L18
        r2.e(r8.optInt("event_sampling_version", 0));     // Catch: Throwable -> L18
        JSONArray r10 = r8.optJSONArray("samplings");     // Catch: Throwable -> L18
        b(r2, r10);     // Catch: Throwable -> L18
        if (r9 == null) goto L10;
        if (r2.b() <= r9.b()) goto L17;
    L10:
        if (TextUtils.isEmpty(r7) == false) goto L12;
        r7 = "sampling_list";
    L12:
        SharedPreferences.Editor r11 = a(r6, r7, 0).edit();     // Catch: Throwable -> L18
        r11.putInt("event_sampling_version", r2.b());     // Catch: Throwable -> L18
        if (r10 == null) goto L15;
        r11.putString("samplings", r10.toString());     // Catch: Throwable -> L18
    L15:
        r11.apply();     // Catch: Throwable -> L18
        return r2;
    L17:
        return r9;
    }

    public static b d(Context r2, String r3) {
        b r0 = new b();
        if (TextUtils.isEmpty(r3) == false) goto L5;
        r3 = "sampling_list";
    L5:
        SharedPreferences r4 = a(r2, r3, 0);
        r0.e(r4.getInt("event_sampling_version", 0));
        String r5 = r4.getString("samplings", null);
        if (TextUtils.isEmpty(r5) == false) goto L10;
    L8:
        return r0;
    L10:
        b(r0, new JSONArray(r5));     // Catch: Throwable -> L9
        goto L8
    }
}
