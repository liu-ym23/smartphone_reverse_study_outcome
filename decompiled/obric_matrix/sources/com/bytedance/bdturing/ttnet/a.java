package com.bytedance.bdturing.ttnet;

import android.text.TextUtils;
import d.b.r.d0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a implements d.b.r.j0.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile a f3143g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, String> f3144f;

    private a() {
    }

    private Map<String, String> b() {
        if (this.f3144f != null) goto L6;
        this.f3144f = new HashMap();
    L6:
        if (TextUtils.isEmpty(this.f3144f.get("x-vc-bdturing-sdk-version")) == false) goto L9;
        this.f3144f.put("x-vc-bdturing-sdk-version", "3.2.0.cn");
    L9:
        return this.f3144f;
    }

    public static a c() {
        if (f3143g != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3143g != null) goto L9;
        f3143g = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f3143g;
    }

    @Override // d.b.r.j0.a
    public d0 a(d.b.r.j0.a.InterfaceC0391a r6) {
        d.b.r.h0.c r0 = r6.b();
        LinkedList r1 = new LinkedList();
        r1.addAll(r0.v());
        Map<String, String> r5 = b();
        if (r5 == null) goto L8;
        Iterator<Map.Entry<String, String>> r7 = r5.entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        Map.Entry<String, String> r2 = r7.next();
        r1.add(new d.b.r.h0.b(r2.getKey(), r2.getValue()));
    L8:
        d.b.r.h0.c.a r8 = r0.O();
        r8.b(r1);
        return r6.c(r8.a());
    }
}
