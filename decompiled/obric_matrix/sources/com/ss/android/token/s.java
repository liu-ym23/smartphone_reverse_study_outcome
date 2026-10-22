package com.ss.android.token;

import android.os.Build;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class s {
    public static final /* synthetic */ Set a() {
        return c();
    }

    public static final /* synthetic */ JSONObject b(kotlin.u... r0) {
        return d(r0);
    }

    private static final Set<String> c() {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Set<String> r0 = ConcurrentHashMap.newKeySet();
        String r1 = "ConcurrentHashMap.newKeySet()";
    L6:
        kotlin.n0.d.o.b(r0, r1);
        return r0;
    L5:
        r0 = Collections.synchronizedSet(new HashSet());
        r1 = "Collections.synchronizedSet(HashSet<String>())";
        goto L6
    }

    private static final JSONObject d(kotlin.u<String, ? extends Object>... r5) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L6
        int r1 = r5.length;     // Catch: JSONException -> L6
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        kotlin.u<String, ? extends Object> r3 = r5[r2];     // Catch: JSONException -> L6
        r0.put(r3.c(), r3.d());     // Catch: JSONException -> L6
        r2 = r2 + 1;
        goto L3
    L11:
        return r0;
    L7:
        return new JSONObject();
    }
}
