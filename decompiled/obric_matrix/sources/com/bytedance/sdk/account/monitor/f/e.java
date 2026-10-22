package com.bytedance.sdk.account.monitor.f;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.i0.j0;
import kotlin.i0.r;
import kotlin.n0.d.o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f5678a = null;

    static {
        f5678a = new e();
    }

    private e() {
    }

    private final g b(JSONArray r8) {
        if (r8.length() == 0) goto L5;
        Object r0 = r8.opt(0);
        if ((r0 instanceof String) == false) goto L19;
        kotlin.r0.d r7 = kotlin.r0.e.m(0, r8.length());
        ArrayList r1 = new ArrayList();
        Iterator<Integer> r9 = r7.iterator();
    L10:
        if (r9.hasNext() == false) goto L51;
        String r2 = r8.getString(((j0) r9).nextInt());     // Catch: JSONException -> L14
    L15:
        if (r2 == null) goto L10;
        r1.add(r2);
    L14:
        r2 = null;
        goto L15
    L51:
        return b.f5675b.a(r.z0(r1));
    L19:
        if ((r0 instanceof JSONArray) == false) goto L35;
        kotlin.r0.d r3 = kotlin.r0.e.m(0, r8.length());
        ArrayList r4 = new ArrayList(r.q(r3, 10));
        Iterator<Integer> r5 = r3.iterator();
    L22:
        if (r5.hasNext() == false) goto L52;
        JSONArray r6 = r8.getJSONArray(((j0) r5).nextInt());
        kotlin.r0.d r10 = kotlin.r0.e.m(0, r6.length());
        ArrayList r11 = new ArrayList();
        Iterator<Integer> r12 = r10.iterator();
    L25:
        if (r12.hasNext() == false) goto L32;
        String r13 = r6.getString(((j0) r12).nextInt());     // Catch: JSONException -> L29
    L30:
        if (r13 == null) goto L25;
        r11.add(r13);
    L29:
        r13 = null;
        goto L30
    L32:
        r4.add(r.z0(r11));
        goto L22
    L52:
        return j.f5684b.a(r.z0(r4));
    L35:
        return a.f5674a;
    L5:
        return a.f5674a;
    }

    public final g a(Object r2) {
        if (o.a(r2, JSONObject.NULL) == false) goto L6;
        return a.f5674a;
    L6:
        if ((r2 instanceof String) == false) goto L9;
        return k.f5686a.a((String) r2);
    L9:
        if ((r2 instanceof JSONArray) == false) goto L13;
        return b((JSONArray) r2);
    L13:
        throw new IllegalArgumentException("Unknown condition format");
    }
}
