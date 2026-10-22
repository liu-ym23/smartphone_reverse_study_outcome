package com.bytedance.applog.u;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f2398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f2399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, List<Set<String>>> f2400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, List<Map<String, Object>>> f2401d;

    a(int r1, Set<String> r2, Map<String, List<Set<String>>> r3, Map<String, List<Map<String, Object>>> r4) {
        this.f2398a = r1;
        this.f2399b = r2;
        this.f2400c = r3;
        this.f2401d = r4;
    }

    final int a() {
        int r1 = this.f2398a;
        if (r1 > 0) goto L7;
        return -1;
    L7:
        if (r1 < 10000) goto L10;
        return 1;
    L10:
        return 0;
    }

    final boolean b(String r7, JSONObject r8) {
        if (TextUtils.isEmpty(r7) == false) goto L5;
        return false;
    L5:
        Set<String> r0 = this.f2399b;
        if (r0 != null) goto L8;
    L10:
        if (r8 != null) goto L12;
        return false;
    L12:
        HashSet r1 = new HashSet();
        Iterator<String> r3 = r8.keys();
    L14:
        if (r3.hasNext() == false) goto L16;
        r1.add(r3.next());
        goto L14
    L16:
        Map<String, List<Set<String>>> r4 = this.f2400c;
        if (r4 != null) goto L19;
    L34:
        Map<String, List<Map<String, Object>>> r5 = this.f2401d;
        if (r5 != null) goto L37;
    L63:
        return false;
    L37:
        if (r5.containsKey(r7) == false) goto L63;
        List<Map<String, Object>> r6 = this.f2401d.get(r7);
        if (r6 == null) goto L63;
        if (r6.isEmpty() == true) goto L63;
        Iterator<Map<String, Object>> r9 = r6.iterator();
    L44:
        if (r9.hasNext() == false) goto L63;
        Map<String, Object> r10 = r9.next();
        if (r10 == null) goto L44;
        if (r10.isEmpty() == true) goto L44;
        if (r1.containsAll(r10.keySet()) == false) goto L44;
        Iterator<Map.Entry<String, Object>> r11 = r10.entrySet().iterator();
    L53:
        if (r11.hasNext() == false) goto L60;
        Map.Entry<String, Object> r12 = r11.next();
        String r13 = r12.getKey();
        Object r14 = r12.getValue();
        if (TextUtils.isEmpty(r13) == true) goto L59;
        if (r14 == null) goto L59;
        if (r14.equals(r8.opt(r13)) == true) goto L53;
    L59:
        boolean r15 = false;
    L61:
        if (r15 == false) goto L44;
        return true;
    L60:
        r15 = true;
        goto L61
    L19:
        if (r4.containsKey(r7) == false) goto L34;
        List<Set<String>> r16 = this.f2400c.get(r7);
        if (r16 == null) goto L34;
        if (r16.isEmpty() == true) goto L34;
        Iterator<Set<String>> r17 = r16.iterator();
    L26:
        if (r17.hasNext() == false) goto L34;
        Set<String> r18 = r17.next();
        if (r18 == null) goto L26;
        if (r18.isEmpty() == true) goto L26;
        if (r1.containsAll(r18) == false) goto L26;
        return true;
    L8:
        if (r0.contains(r7) == false) goto L10;
        return true;
    }

    abstract boolean c(i r1);
}
