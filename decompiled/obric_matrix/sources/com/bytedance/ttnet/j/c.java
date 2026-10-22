package com.bytedance.ttnet.j;

import android.os.Build;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.TTNetInit;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f6347a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f6348b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f6349c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f6350d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicBoolean f6351e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicBoolean f6352f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final List<String> f6353g = null;

    static {
        f6347a = new AtomicBoolean(false);
        f6348b = new AtomicBoolean(false);
        f6349c = new AtomicBoolean(false);
        f6350d = new AtomicBoolean(false);
        f6351e = new AtomicBoolean(false);
        f6352f = new AtomicBoolean(true);
        f6353g = new CopyOnWriteArrayList();
    }

    private static void a(JSONArray r2, List<String> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.clear();
        if (r2 != null) goto L7;
        return;
    L7:
        int r0 = 0;
    L9:
        if (r0 >= r2.length()) goto L15;
        r3.add(r2.getString(r0));     // Catch: JSONException -> L12
        r0 = r0 + 1;
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static boolean b() {
        return f6351e.get();
    }

    public static boolean c() {
        return f6352f.get();
    }

    public static boolean d() {
        return f6347a.get();
    }

    public static boolean e() {
        return f6348b.get();
    }

    public static boolean f() {
        return f6349c.get();
    }

    public static void g(Object r6) {
        JSONObject r0 = null;
    L61:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        if ((r6 instanceof e.b) == false) goto L10;
        JSONObject r7 = ((e.b) r6).b();     // Catch: JSONException -> L61
        if (r7 == null) goto L15;
    L8:
        r0 = r7.optJSONObject("data");     // Catch: JSONException -> L61
    L15:
        if (r0 != null) goto L17;
        return;
    L17:
        AtomicBoolean r8 = f6347a;     // Catch: JSONException -> L61
        boolean r2 = false;
        if (r0.optInt("enable_json_wrapper") <= 0) goto L20;
        boolean r1 = true;
    L21:
        r8.set(r1);     // Catch: JSONException -> L61
        AtomicBoolean r9 = f6348b;     // Catch: JSONException -> L61
        if (r0.optInt("enable_tnc_jsonopt") <= 0) goto L24;
        boolean r3 = true;
    L25:
        r9.set(r3);     // Catch: JSONException -> L61
        JSONObject r10 = r0.optJSONObject("cronet_fallback_config");     // Catch: JSONException -> L61
        if (r10 == null) goto L50;
        AtomicBoolean r4 = f6349c;     // Catch: JSONException -> L61
        if (r10.optInt("enable_with_contain_armabi") <= 0) goto L30;
        boolean r5 = true;
    L31:
        r4.set(r5);     // Catch: JSONException -> L61
        AtomicBoolean r11 = f6350d;     // Catch: JSONException -> L61
        if (r10.optInt("disable_reason_boot") <= 0) goto L34;
        boolean r12 = true;
    L35:
        r11.set(r12);     // Catch: JSONException -> L61
        AtomicBoolean r13 = f6351e;     // Catch: JSONException -> L61
        if (r10.optInt("disable_reason_cronet_exception") <= 0) goto L38;
        boolean r14 = true;
    L39:
        r13.set(r14);     // Catch: JSONException -> L61
        AtomicBoolean r15 = f6352f;     // Catch: JSONException -> L61
        if (r10.optInt("disable_reason_null_appconfig", 1) <= 0) goto L42;
        boolean r16 = true;
    L43:
        r15.set(r16);     // Catch: JSONException -> L61
        JSONArray r17 = r10.optJSONArray("merge_model_black_list");     // Catch: JSONException -> L61
        List<String> r18 = f6353g;     // Catch: JSONException -> L61
        a(r17, r18);     // Catch: JSONException -> L61
        if (r11.get() == false) goto L47;
        a.s(TTNetInit.getTTNetDepend().getContext()).D();     // Catch: JSONException -> L61
    L47:
        if (r18.contains(Build.MODEL) == false) goto L49;
        a.P = true;     // Catch: JSONException -> L61
    L49:
        Logger.debug();     // Catch: JSONException -> L61
        goto L50
    L42:
        r16 = false;
        goto L43
    L38:
        r14 = false;
        goto L39
    L34:
        r12 = false;
        goto L35
    L30:
        r5 = false;
    L50:
        JSONObject r19 = r0.optJSONObject("ttnet_okio");     // Catch: JSONException -> L61
        if (r19 != null) goto L53;
        return;
    L53:
        if (r19.optInt("okio_read_enabled", 1) <= 0) goto L55;
        boolean r20 = true;
    L56:
        d.b.h.a.a.h.m.b.O(r20);     // Catch: JSONException -> L61
        if (r19.optInt("zero_copy_enabled", 1) <= 0) goto L59;
        r2 = true;
    L59:
        com.bytedance.frameworks.baselib.network.http.cronet.e.c.j0(r2);     // Catch: JSONException -> L61
        return;
    L55:
        r20 = false;
        goto L56
    L24:
        r3 = false;
        goto L25
    L20:
        r1 = false;
        goto L21
    L10:
        if ((r6 instanceof JSONObject) == true) goto L12;
    L14:
        r0 = (JSONObject) r6;     // Catch: JSONException -> L61
        goto L15
    L12:
        if (((JSONObject) r6).isNull("data") == true) goto L14;
        r7 = (JSONObject) r6;     // Catch: JSONException -> L61
        goto L8
    }
}
