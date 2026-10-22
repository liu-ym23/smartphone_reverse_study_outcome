package com.bytedance.android.sdk.bdticketguard.o1.j;

import com.bytedance.android.sdk.bdticketguard.p1.k;
import com.bytedance.android.sdk.bdticketguard.s0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.e0;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ l[] f984a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.h f985b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlin.h f986c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f987d = null;

    static final class a extends q implements kotlin.n0.c.a<Map<String, ? extends g>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f988f = null;

        static {
            f988f = new a();
        }

        a() {
            super(0);
        }

        public final Map<String, g> a() {
            List r3 = d.a(d.f987d);
            LinkedHashMap r1 = new LinkedHashMap(kotlin.r0.e.c(m0.d(r.q(r3, 10)), 16));
            Iterator r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            Object r0 = r4.next();
            r1.put(((g) r0).f(), r0);
            goto L4
        L6:
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Map<String, ? extends g> invoke() {
            return a();
        }
    }

    static final class b extends q implements kotlin.n0.c.a<List<? extends g>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f989f = null;

        static {
            f989f = new b();
        }

        b() {
            super(0);
        }

        public final List<g> a() {
            return r.j(new g[]{com.bytedance.android.sdk.bdticketguard.o1.j.a.f969a, i.f1010b, h.f1003b});
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends g> invoke() {
            return a();
        }
    }

    static {
        f984a = new l[]{e0.g(new y(e0.b(d.class), "adapters", "getAdapters()Ljava/util/List;")), e0.g(new y(e0.b(d.class), "adapterNameMap", "getAdapterNameMap()Ljava/util/Map;"))};
        f987d = new d();
        f985b = kotlin.i.b(b.f989f);
        f986c = kotlin.i.b(a.f988f);
    }

    private d() {
    }

    public static final /* synthetic */ List a(d r0) {
        return r0.d();
    }

    private final Map<String, g> c() {
        kotlin.h r2 = f986c;
        l r0 = f984a[1];
        return (Map) r2.getValue();
    }

    private final List<g> d() {
        kotlin.h r2 = f985b;
        l r0 = f984a[0];
        return (List) r2.getValue();
    }

    private final g f() {
        k r0 = k.f1023J;
        String r1 = r0.l().b();
        if (r1.length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L10;
        return b(r1);
    L10:
        if (r0.w().b().booleanValue() == false) goto L15;
        i r3 = i.f1010b;
        if (r3.l() == false) goto L15;
        return r3;
    L15:
        if (r0.u().b().booleanValue() == false) goto L20;
        h r4 = h.f1003b;
        if (r4.l() == false) goto L20;
        return r4;
    L20:
        return com.bytedance.android.sdk.bdticketguard.o1.j.a.f969a;
    L5:
        r2 = false;
        goto L6
    }

    public final g b(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        g r1 = c().get(r2);
        if (r1 == null) goto L15;
        return r1;
    L15:
        return com.bytedance.android.sdk.bdticketguard.o1.j.a.f969a;
    L10:
        return com.bytedance.android.sdk.bdticketguard.o1.j.a.f969a;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final g e() {
        g r4 = f();
        boolean r0 = r4.g();
        s0.f1065a.e("AttestationBrandUtils", "init adapter, adapter: " + r4.f() + ", initResult: " + r0);
        if (r0 == false) goto L6;
        return r4;
    L6:
        return com.bytedance.android.sdk.bdticketguard.o1.j.a.f969a;
    }
}
