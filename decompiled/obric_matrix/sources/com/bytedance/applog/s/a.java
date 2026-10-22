package com.bytedance.applog.s;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f2358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Map<Integer, b> f2360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Map<String, Integer> f2362e;

    a() {
        this.f2358a = 0;
        this.f2359b = 5;
        this.f2361d = -1;
    }

    public b a(int r1) {
        Map<Integer, b> r0 = this.f2360c;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.get(Integer.valueOf(r1));
    }

    public Map<Integer, b> b() {
        return this.f2360c;
    }

    public int c(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return -1;
    L5:
        Map<String, Integer> r0 = this.f2362e;
        if (r0 != null) goto L8;
    L11:
        JSONObject r1 = null;
        if (TextUtils.isEmpty(r11) == true) goto L16;
        r1 = new JSONObject(r11);     // Catch: JSONException -> L86
    L16:
        if (r1 == null) goto L85;
        Map<Integer, b> r12 = this.f2360c;
        if (r12 == null) goto L85;
        if (r12.isEmpty() == true) goto L85;
        HashSet r13 = new HashSet();
        Iterator<String> r2 = r1.keys();
    L24:
        if (r2.hasNext() == false) goto L26;
        r13.add(r2.next());
        goto L24
    L26:
        Iterator<Map.Entry<Integer, b>> r9 = this.f2360c.entrySet().iterator();
    L28:
        if (r9.hasNext() == false) goto L85;
        Map.Entry<Integer, b> r3 = r9.next();
        int r4 = r3.getKey().intValue();
        if ((-1) == r4) goto L28;
        b r5 = r3.getValue();
        if (r5 == null) goto L28;
        Map<String, List<Set<String>>> r6 = r5.f2368f;
        if (r6 != null) goto L38;
    L55:
        Map<String, List<Map<String, Object>>> r7 = r5.f2369g;
        if (r7 == null) goto L28;
        if (r7.isEmpty() == true) goto L28;
        if (r5.f2369g.containsKey(r10) == false) goto L28;
        List<Map<String, Object>> r8 = r5.f2369g.get(r10);
        if (r8 == null) goto L28;
        if (r8.isEmpty() == true) goto L28;
        Iterator<Map<String, Object>> r14 = r8.iterator();
    L67:
        if (r14.hasNext() == false) goto L28;
        Map<String, Object> r15 = r14.next();
        if (r15 == null) goto L67;
        if (r15.isEmpty() == true) goto L67;
        if (r13.containsAll(r15.keySet()) == false) goto L67;
        boolean r16 = true;
        Iterator<Map.Entry<String, Object>> r17 = r15.entrySet().iterator();
    L76:
        if (r17.hasNext() == false) goto L83;
        Map.Entry<String, Object> r18 = r17.next();
        String r19 = r18.getKey();
        Object r20 = r18.getValue();
        if (TextUtils.isEmpty(r19) == true) goto L82;
        if (r20 == null) goto L82;
        if (r20.equals(r1.opt(r19)) == true) goto L76;
    L82:
        r16 = false;
    L83:
        if (r16 == false) goto L67;
        return r4;
    L38:
        if (r6.isEmpty() == true) goto L55;
        if (r5.f2368f.containsKey(r10) == false) goto L55;
        List<Set<String>> r21 = r5.f2368f.get(r10);
        if (r21 == null) goto L55;
        if (r21.isEmpty() == true) goto L55;
        Iterator<Set<String>> r22 = r21.iterator();
    L47:
        if (r22.hasNext() == false) goto L55;
        Set<String> r23 = r22.next();
        if (r23 == null) goto L47;
        if (r23.isEmpty() == true) goto L47;
        if (r13.containsAll(r23) == false) goto L47;
        return r4;
    L85:
        return -1;
    L8:
        if (r0.containsKey(r10) == false) goto L11;
        return this.f2362e.get(r10).intValue();
    }

    public boolean d() {
        if (this.f2358a >= 0) goto L5;
    L22:
        return false;
    L5:
        if (this.f2359b <= 0) goto L22;
        Map<Integer, b> r3 = this.f2360c;
        if (r3 == null) goto L22;
        if (r3.isEmpty() == true) goto L22;
        if (r3.containsKey(-1) == true) goto L15;
        return false;
    L15:
        b r4 = r3.get(-1);
        if (r4 == null) goto L22;
        if (r4.f2366d <= 0) goto L22;
        return true;
    }
}
