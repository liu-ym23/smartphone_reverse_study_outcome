package com.bytedance.apm.a0;

import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.util.i;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile e f1133c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CopyOnWriteArraySet<String> f1134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f1135b;

    private e() {
        this.f1134a = new CopyOnWriteArraySet();
        this.f1135b = new ConcurrentHashMap();
    }

    public static e a() {
        if (f1133c != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1133c != null) goto L9;
        f1133c = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f1133c;
    }

    public JSONObject b(boolean r4) {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, String>> r3 = this.f1135b.entrySet().iterator();     // Catch: JSONException -> L10
    L5:
        if (r3.hasNext() == false) goto L7;
        Map.Entry<String, String> r1 = r3.next();     // Catch: JSONException -> L10
        r0.put(r1.getKey(), r1.getValue());     // Catch: JSONException -> L10
        goto L5
    L7:
        if (r4 == false) goto L9;
        com.bytedance.apm.util.c.k().e(r0);     // Catch: JSONException -> L10
        com.bytedance.apm.util.c.k().a(r0);     // Catch: JSONException -> L10
    L9:
        return r0;
    }

    public String c() {
        String r1 = i.a(this.f1134a.toArray(), "#");
        if (TextUtils.isEmpty(r1) == true) goto L5;
        return r1;
    L5:
        return ActivityLifeObserver.getInstance().getTopActivityClassName();
    }
}
