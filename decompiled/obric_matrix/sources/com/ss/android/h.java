package com.ss.android;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<f> f11868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f11869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private g f11870e;

    public h(String r1, int r2, List<f> r3, String r4) {
        this.f11866a = r1;
        this.f11867b = r2;
        this.f11868c = Collections.unmodifiableList(new ArrayList(r3));
        this.f11869d = r4;
    }

    public String a() {
        return this.f11869d;
    }

    public List<f> b() {
        return this.f11868c;
    }

    public int c() {
        return this.f11867b;
    }

    public g d() {
        return this.f11870e;
    }

    public String e() {
        return this.f11866a;
    }

    public boolean f() {
        int r1 = this.f11867b;
        if (r1 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= 300) goto L7;
        return true;
    }

    public void g(g r1) {
        this.f11870e = r1;
    }
}
