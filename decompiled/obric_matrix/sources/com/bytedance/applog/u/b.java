package com.bytedance.applog.u;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f2403b;

    public b() {
        this.f2403b = new ArrayList();
    }

    public void a(int r2, int r3, Set<String> r4, Map<String, List<Set<String>>> r5, Map<String, List<Map<String, Object>>> r6) {
        if (r3 != 1) goto L5;
        a r7 = new f(r2, r4, r5, r6);
    L18:
        a r8 = r7;
    L19:
        if (r8 == null) goto L22;
        this.f2403b.add(r8);
        return;
    L22:
        return;
    L5:
        if (r3 != 2) goto L7;
        r7 = new d(r2, r4, r5, r6);
        goto L18
    L7:
        if (r3 != 3) goto L9;
        r7 = new e(r2, r4, r5, r6);
        goto L18
    L9:
        if (r3 != 4) goto L11;
        r7 = new g(r2, r4, r5, r6);
        goto L18
    L11:
        if (r3 == 5) goto L13;
        r8 = null;
        goto L19
    L13:
        r7 = new h(r2, r4, r5, r6);
        goto L18
    }

    public int b() {
        return this.f2402a;
    }

    public boolean c(i r3, String r4, String r5) {
        JSONObject r0 = null;
        if (TextUtils.isEmpty(r5) == true) goto L8;
        r0 = new JSONObject(r5);     // Catch: Throwable -> L9
    L8:
        return d(r3, r4, r0);
    }

    public boolean d(i r3, String r4, JSONObject r5) {
        Iterator<a> r2 = this.f2403b.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        a r0 = r2.next();
        if (r0.b(r4, r5) == false) goto L4;
        return r0.c(r3);
    L9:
        return false;
    }

    public void e(int r1) {
        this.f2402a = r1;
    }
}
