package com.bytedance.android.sdk.bdticketguard;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class t<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<R> f1066a;

    private static final class a<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a<R>[] f1067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<Character, a<R>> f1068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private kotlin.n0.c.p<? super String, ? super String, ? extends R> f1069c;

        public a() {
            this.f1067a = new a[128];
        }

        public final a<R> a(char r2) {
            if (r2 < 128) goto L10;
            Map<Character, a<R>> r1 = this.f1068b;
            if (r1 != null) goto L11;
            return null;
        L11:
            return r1.get(Character.valueOf(r2));
        L10:
            return this.f1067a[r2];
        }

        public final kotlin.n0.c.p<String, String, R> b() {
            return this.f1069c;
        }

        public final void c(char r2, a<R> r3) {
            kotlin.n0.d.o.g(r3, "node");
            if (r2 >= 128) goto L6;
            this.f1067a[r2] = r3;
            return;
        L6:
            if (this.f1068b != null) goto L8;
            this.f1068b = new LinkedHashMap();
        L8:
            Map<Character, a<R>> r1 = this.f1068b;
            if (r1 == null) goto L12;
            r1.put(Character.valueOf(r2), r3);
            return;
        L12:
            kotlin.n0.d.o.p();
            throw null;
        }

        public final void d(kotlin.n0.c.p<? super String, ? super String, ? extends R> r1) {
            this.f1069c = r1;
        }
    }

    public t(kotlin.u<String, ? extends kotlin.n0.c.p<? super String, ? super String, ? extends R>>... r5) {
        kotlin.n0.d.o.g(r5, "matchCases");
        this.f1066a = new a();
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        kotlin.u<String, ? extends kotlin.n0.c.p<? super String, ? super String, ? extends R>> r2 = r5[r1];
        b(r2.a(), r2.b());
        r1 = r1 + 1;
        goto L3
    }

    private final kotlin.n0.c.p<String, String, R> a(String r3) {
        a<R> r2 = this.f1066a;
        int r0 = 0;
    L4:
        if (r0 >= r3.length()) goto L11;
        r2 = r2.a(Character.toLowerCase(r3.charAt(r0)));
        if (r2 == null) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return null;
    L11:
        return r2.b();
    }

    private final void b(String r4, kotlin.n0.c.p<? super String, ? super String, ? extends R> r5) {
        a<R> r3 = this.f1066a;
        int r0 = 0;
    L4:
        if (r0 >= r4.length()) goto L9;
        char r1 = Character.toLowerCase(r4.charAt(r0));
        a<R> r2 = r3.a(r1);
        if (r2 != null) goto L8;
        r2 = new a();
        r3.c(r1, r2);
    L8:
        r3 = r2;
        r0 = r0 + 1;
        goto L4
    L9:
        r3.d(r5);
    }

    public final R c(String r2, String r3) {
        kotlin.n0.d.o.g(r2, "headerName");
        kotlin.n0.d.o.g(r3, "value");
        kotlin.n0.c.p<String, String, R> r1 = a(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.invoke(r2, r3);
    }
}
