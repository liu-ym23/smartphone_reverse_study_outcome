package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Excluder f6891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private t f6892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f6893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Type, f<?>> f6894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<x> f6895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<x> f6896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f6897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f6898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f6899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f6900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f6901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f6902l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private w r;
    private w s;
    private final LinkedList<u> t;

    public e() {
        this.f6891a = Excluder.f6904l;
        this.f6892b = t.f7096f;
        this.f6893c = c.f6884f;
        this.f6894d = new HashMap();
        this.f6895e = new ArrayList();
        this.f6896f = new ArrayList();
        this.f6897g = false;
        this.f6898h = Gson.o;
        this.f6899i = 2;
        this.f6900j = 2;
        this.f6901k = false;
        this.f6902l = false;
        this.m = true;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = Gson.q;
        this.s = Gson.r;
        this.t = new LinkedList();
    }

    private void c(String r4, int r5, int r6, List<x> r7) {
        boolean r3 = com.google.gson.internal.sql.a.f7087a;
        x r0 = null;
        if (r4 == null) goto L11;
        if (r4.trim().isEmpty() == true) goto L11;
        x r8 = DefaultDateTypeAdapter.b.f6934b.b(r4);
        if (r3 == false) goto L9;
        r0 = com.google.gson.internal.sql.a.f7089c.b(r4);
        x r9 = com.google.gson.internal.sql.a.f7088b.b(r4);
    L17:
        r7.add(r8);
        if (r3 == false) goto L23;
        r7.add(r0);
        r7.add(r9);
        return;
    L23:
        return;
    L9:
        r9 = null;
    L11:
        if (r5 == 2) goto L21;
        if (r6 == 2) goto L22;
        x r10 = DefaultDateTypeAdapter.b.f6934b.a(r5, r6);
        if (r3 == false) goto L16;
        r0 = com.google.gson.internal.sql.a.f7089c.a(r5, r6);
        x r11 = com.google.gson.internal.sql.a.f7088b.a(r5, r6);
        r8 = r10;
        r9 = r11;
        goto L17
    L16:
        r8 = r10;
        goto L9
    L22:
        return;
    }

    public e a(a r4) {
        Objects.requireNonNull(r4);
        this.f6891a = this.f6891a.p(r4, false, true);
        return this;
    }

    public e b(a r4) {
        Objects.requireNonNull(r4);
        this.f6891a = this.f6891a.p(r4, true, false);
        return this;
    }

    public Gson d() {
        List<x> r1 = new ArrayList((this.f6895e.size() + this.f6896f.size()) + 3);
        r1.addAll(this.f6895e);
        Collections.reverse(r1);
        ArrayList r2 = new ArrayList(this.f6896f);
        Collections.reverse(r2);
        r1.addAll(r2);
        c(this.f6898h, this.f6899i, this.f6900j, r1);
        return new Gson(this.f6891a, this.f6893c, new HashMap(this.f6894d), this.f6897g, this.f6901k, this.o, this.m, this.n, this.p, this.f6902l, this.q, this.f6892b, this.f6898h, this.f6899i, this.f6900j, new ArrayList(this.f6895e), new ArrayList(this.f6896f), r1, this.r, this.s, new ArrayList(this.t));
    }

    public e e() {
        this.m = false;
        return this;
    }

    public e f() {
        this.f6901k = true;
        return this;
    }

    public e g(Class<?> r3, Object r4) {
        Objects.requireNonNull(r3);
        boolean r0 = r4 instanceof r;
        if (r0 == false) goto L5;
    L10:
        boolean r1 = true;
    L11:
        com.google.gson.internal.a.a(r1);
        if ((r4 instanceof i) == true) goto L14;
        if (r0 == true) goto L14;
    L16:
        if ((r4 instanceof TypeAdapter) == false) goto L18;
        x r5 = TypeAdapters.d(r3, (TypeAdapter) r4);
        this.f6895e.add(r5);
    L18:
        return this;
    L14:
        this.f6896f.add(TreeTypeAdapter.g(r3, r4));
        goto L16
    L5:
        if ((r4 instanceof i) == true) goto L10;
        if ((r4 instanceof TypeAdapter) == true) goto L10;
        r1 = false;
        goto L11
    }

    public e h() {
        this.n = true;
        return this;
    }
}
