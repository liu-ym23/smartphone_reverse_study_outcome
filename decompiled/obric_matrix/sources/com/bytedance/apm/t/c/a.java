package com.bytedance.apm.t.c;

import com.bytedance.apm.x.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.apm.t.a<com.bytedance.apm.t.b> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile a f1965h;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f1966g;

    private a() {
    }

    public static a p() {
        if (f1965h != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1965h != null) goto L9;
        f1965h = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f1965h;
    }

    @Override // com.bytedance.apm.t.a
    protected void f(com.bytedance.apm.t.b r8) {
        JSONObject r6 = r8.c();
        boolean r4 = r8.b(r6);
        if (com.bytedance.apm.d.C() == true) goto L16;
    L8:
        if (r4 == false) goto L10;
    L12:
        l(r8.e(), r8.a(), r6, r4, false);
        b r7 = this.f1966g;
        if (r7 == null) goto L18;
        r7.a(r8.e(), r8.a(), r6);
        return;
    L18:
        return;
    L10:
        if (r8.d() == true) goto L12;
        return;
    L16:
        e.e(com.bytedance.apm.x.b.f2128d, new Object[]{"logType: " + r8.e() + ", subType: " + r8.a() + "data: " + r6, " ,sample: " + r4});     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public void q(b r1) {
        this.f1966g = r1;
    }
}
