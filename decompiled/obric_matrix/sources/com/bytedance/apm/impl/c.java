package com.bytedance.apm.impl;

import androidx.annotation.Nullable;
import d.b.r.k0.h;
import d.b.r.k0.j;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class c implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f1603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f1604b;

    public c(@Nullable Map<String, String> r1, h r2) {
        this.f1604b = r1;
        this.f1603a = r2;
    }

    private String d() {
        StringBuilder r0 = new StringBuilder(this.f1603a.c());
        r0.append("\"");
        Iterator<Map.Entry<String, String>> r5 = this.f1604b.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry<String, String> r2 = r5.next();
        String r3 = r2.getKey();
        String r4 = r2.getValue();
        r0.append("; ");
        r0.append(r3);
        r0.append("=\"");
        r0.append(r4);
        r0.append("\"");
        goto L4
    L6:
        r0.deleteCharAt(r0.length() - 1);
        return r0.toString();
    }

    @Override // d.b.r.k0.j
    public String a() {
        return this.f1603a.a();
    }

    @Override // d.b.r.k0.j
    public void b(OutputStream r1) {
        this.f1603a.b(r1);
    }

    @Override // d.b.r.k0.j
    public String c() {
        return d();
    }

    @Override // d.b.r.k0.j
    public String e() {
        return this.f1603a.e();
    }

    @Override // d.b.r.k0.j
    public long length() {
        return this.f1603a.length();
    }
}
