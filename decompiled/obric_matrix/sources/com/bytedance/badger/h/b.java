package com.bytedance.badger.h;

import kotlin.n0.d.o;
import kotlin.s0.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f2583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ g f2584c;

    public b(g r2, String r3, Object r4) {
        o.g(r3, "key");
        this.f2584c = r2;
        this.f2582a = r3;
        this.f2583b = r4;
    }

    public final Object a(g r2, l r3) {
        o.g(r2, "thisRef");
        o.g(r3, "property");
        JSONObject r4 = this.f2584c.c();
        if (r4 == null) goto L8;
        Object r5 = b(r4, this.f2582a, this.f2583b);
        if (r5 == null) goto L8;
        return r5;
    L8:
        return this.f2583b;
    }

    public abstract Object b(JSONObject r1, String r2, Object r3);
}
