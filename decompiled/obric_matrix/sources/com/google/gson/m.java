package com.google.gson;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.internal.g<String, j> f7094a;

    public m() {
        this.f7094a = new com.google.gson.internal.g(false);
    }

    public Set<String> A() {
        return this.f7094a.keySet();
    }

    public boolean equals(Object r2) {
        if (r2 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r2 instanceof m) == true) goto L6;
    L8:
        return false;
    L6:
        if (((m) r2).f7094a.equals(this.f7094a) == false) goto L8;
        goto L8
    }

    public int hashCode() {
        return this.f7094a.hashCode();
    }

    public void q(String r1, j r2) {
        com.google.gson.internal.g<String, j> r0 = this.f7094a;
        if (r2 != null) goto L5;
        r2 = l.f7093a;
    L5:
        r0.put(r1, r2);
    }

    public void r(String r2, Boolean r3) {
        if (r3 != null) goto L4;
        j r4 = l.f7093a;
    L5:
        q(r2, r4);
        return;
    L4:
        r4 = new p(r3);
        goto L5
    }

    public void s(String r2, Number r3) {
        if (r3 != null) goto L4;
        j r4 = l.f7093a;
    L5:
        q(r2, r4);
        return;
    L4:
        r4 = new p(r3);
        goto L5
    }

    public void t(String r2, String r3) {
        if (r3 != null) goto L4;
        j r4 = l.f7093a;
    L5:
        q(r2, r4);
        return;
    L4:
        r4 = new p(r3);
        goto L5
    }

    public Set<Map.Entry<String, j>> u() {
        return this.f7094a.entrySet();
    }

    public j v(String r1) {
        return this.f7094a.get(r1);
    }

    public g w(String r1) {
        return (g) this.f7094a.get(r1);
    }

    public m x(String r1) {
        return (m) this.f7094a.get(r1);
    }

    public p y(String r1) {
        return (p) this.f7094a.get(r1);
    }

    public boolean z(String r1) {
        return this.f7094a.containsKey(r1);
    }
}
