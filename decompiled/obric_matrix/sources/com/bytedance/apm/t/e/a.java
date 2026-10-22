package com.bytedance.apm.t.e;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f2005b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.apm.e0.a<JSONObject> f2006a;

    private a() {
        this.f2006a = new com.bytedance.apm.e0.a(20);
    }

    public static a b() {
        if (f2005b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2005b != null) goto L9;
        f2005b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f2005b;
    }

    public void a(JSONObject r1) {
        this.f2006a.a(r1);
    }

    public List<JSONObject> c() {
        return this.f2006a.b();
    }
}
