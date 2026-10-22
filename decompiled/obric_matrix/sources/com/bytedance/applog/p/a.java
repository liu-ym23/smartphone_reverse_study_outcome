package com.bytedance.applog.p;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected HashSet<String> f2301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected HashMap<String, HashSet<String>> f2302b;

    protected a(HashSet<String> r1, HashMap<String, HashSet<String>> r2) {
        this.f2301a = r1;
        this.f2302b = r2;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences b(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private boolean c(String r4, String r5) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return false;
    L5:
        HashSet<String> r0 = this.f2301a;
        if (r0 != null) goto L8;
    L39:
        return true;
    L8:
        if (r0.size() <= 0) goto L39;
        if (d(r4) == false) goto L14;
        return false;
    L14:
        if (TextUtils.isEmpty(r5) == false) goto L16;
        return true;
    L16:
        JSONObject r1 = null;
        r1 = new JSONObject(r5);     // Catch: JSONException -> L40
    L19:
        if (r1 == null) goto L39;
        HashMap<String, HashSet<String>> r6 = this.f2302b;
        if (r6 == null) goto L39;
        if (r6.size() <= 0) goto L39;
        if (this.f2302b.containsKey(r4) == false) goto L39;
        HashSet<String> r7 = this.f2302b.get(r4);
        if (r7 == null) goto L39;
        if (r7.size() <= 0) goto L39;
        Iterator<String> r8 = r1.keys();
    L34:
        if (r8.hasNext() == false) goto L39;
        if (e(r7, r8.next()) == false) goto L34;
        r8.remove();     // Catch: Throwable -> L41
        goto L34
    }

    public static final a f(Context r11) {
        SharedPreferences r12 = b(r11, "sp_filter_name", 0);     // Catch: Throwable -> L47
        HashSet r2 = new HashSet();     // Catch: Throwable -> L47
        HashMap r4 = new HashMap();     // Catch: Throwable -> L47
        Map<String, ?> r5 = r12.getAll();     // Catch: Throwable -> L6
    L7:
        if (r5 != null) goto L9;
        return null;
    L9:
        if (r5.size() <= 0) goto L75;
        Iterator<Map.Entry<String, ?>> r6 = r5.entrySet().iterator();     // Catch: Throwable -> L47
        int r7 = 0;
    L13:
        if (r6.hasNext() == false) goto L42;
        Map.Entry<String, ?> r8 = r6.next();     // Catch: Throwable -> L47
        if (r8 == null) goto L13;
        String r9 = r8.getKey();     // Catch: Throwable -> L47
        if ("is_block".equals(r9) == true) goto L19;
        if ("events".equals(r9) == false) goto L30;
        Set r10 = (Set) r8.getValue();     // Catch: Throwable -> L24
    L25:
        if (r10 == null) goto L13;
        if (r10.size() <= 0) goto L13;
        r2.addAll(r10);     // Catch: Throwable -> L47
    L24:
        r10 = null;
        goto L25
    L30:
        if (TextUtils.isEmpty(r9) == true) goto L13;
        HashSet r13 = new HashSet();     // Catch: Throwable -> L47
        Set r14 = (Set) r8.getValue();     // Catch: Throwable -> L34
    L35:
        if (r14 == null) goto L40;
        if (r14.size() <= 0) goto L40;
        r13.addAll(r14);     // Catch: Throwable -> L47
    L40:
        if (r13.size() <= 0) goto L13;
        r4.put(r9, r13);     // Catch: Throwable -> L47
    L34:
        r14 = null;
        goto L35
    L19:
        r7 = r12.getInt("is_block", 0);     // Catch: Throwable -> L47
        goto L13
    L42:
        if (r7 <= 0) goto L44;
        a r15 = new c(r2, r4);     // Catch: Throwable -> L47
    L46:
        return r15;
    L44:
        r15 = new b(r2, r4);     // Catch: Throwable -> L47
        goto L46
    L75:
        return null;
    L6:
        r5 = null;
        goto L7
    L76:
        return null;
    }

    public static final a g(Context r12, JSONObject r13) {
        SharedPreferences.Editor r14 = b(r12, "sp_filter_name", 0).edit();     // Catch: Throwable -> L59
        r14.clear().commit();     // Catch: Throwable -> L59
        if (r13 != null) goto L6;
        return null;
    L6:
        if (r13.has("event_list") == false) goto L77;
        JSONObject r15 = r13.optJSONObject("event_list");     // Catch: Throwable -> L59
        if (r15 != null) goto L11;
        return null;
    L11:
        int r2 = r15.optInt("is_block", 0);     // Catch: Throwable -> L59
        r14.putInt("is_block", r2);     // Catch: Throwable -> L59
        HashSet r1 = new HashSet();     // Catch: Throwable -> L59
        JSONArray r4 = r15.optJSONArray("events");     // Catch: Throwable -> L59
        if (r4 == null) goto L23;
        if (r4.length() <= 0) goto L23;
        int r6 = 0;
    L17:
        if (r6 >= r4.length()) goto L23;
        String r7 = r4.optString(r6);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r7) == true) goto L21;
        r1.add(r7);     // Catch: Throwable -> L59
    L21:
        r6 = r6 + 1;     // Catch: Throwable -> L59
    L23:
        if (r1.size() <= 0) goto L25;
        r14.putStringSet("events", r1);     // Catch: Throwable -> L59
    L25:
        HashMap r0 = new HashMap();     // Catch: Throwable -> L59
        JSONObject r16 = r15.optJSONObject("params");     // Catch: Throwable -> L59
        if (r16 == null) goto L48;
        Iterator<String> r5 = r16.keys();     // Catch: Throwable -> L59
    L29:
        if (r5.hasNext() == false) goto L48;
        String r8 = r5.next();     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r8) == true) goto L29;
        HashSet r9 = new HashSet();     // Catch: Throwable -> L59
        JSONArray r10 = r16.optJSONArray(r8);     // Catch: Throwable -> L59
        if (r10 == null) goto L45;
        if (r10.length() <= 0) goto L45;
        int r11 = 0;
    L39:
        if (r11 >= r10.length()) goto L45;
        String r17 = r10.optString(r11);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r17) == true) goto L43;
        r9.add(r17);     // Catch: Throwable -> L59
    L43:
        r11 = r11 + 1;     // Catch: Throwable -> L59
    L45:
        if (r9.size() <= 0) goto L29;
        r0.put(r8, r9);     // Catch: Throwable -> L59
    L48:
        if (r0.size() <= 0) goto L53;
        Iterator r18 = r0.entrySet().iterator();     // Catch: Throwable -> L59
    L51:
        if (r18.hasNext() == false) goto L53;
        Map.Entry r19 = (Map.Entry) r18.next();     // Catch: Throwable -> L59
        r14.putStringSet((String) r19.getKey(), (Set) r19.getValue());     // Catch: Throwable -> L59
    L53:
        r14.commit();     // Catch: Throwable -> L59
        if (r2 <= 0) goto L56;
        a r110 = new c(r1, r0);     // Catch: Throwable -> L59
    L58:
        return r110;
    L56:
        r110 = new b(r1, r0);     // Catch: Throwable -> L59
        goto L58
    L77:
        return null;
    L78:
        return null;
    }

    @Override // com.bytedance.applog.p.d
    public boolean a(com.bytedance.applog.r.b.a r2, String r3, String r4) {
        if (com.bytedance.applog.r.b.a.f2332h.equals(r2) == true) goto L6;
        return false;
    L6:
        boolean r1 = !c(r3, r4);
        if (r1 == false) goto L9;
        com.bytedance.applog.o.b.d(r2, com.bytedance.applog.r.b.d.f2349j);
        com.bytedance.applog.o.b.i(com.bytedance.applog.r.b.a.v, r3);
    L9:
        return r1;
    }

    protected abstract boolean d(String r1);

    protected abstract boolean e(HashSet<String> r1, String r2);
}
