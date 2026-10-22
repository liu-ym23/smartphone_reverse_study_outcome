package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.a0.c;
import com.google.gson.s;
import com.google.gson.v;
import com.google.gson.w;
import com.google.gson.x;

/* JADX INFO: loaded from: classes2.dex */
public final class NumberTypeAdapter extends TypeAdapter<Number> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final x f6943b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f6944a;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6946a = null;

        static {
            int[] r0 = new int[com.google.gson.a0.b.values().length];
            f6946a = r0;
            r0[com.google.gson.a0.b.n.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f6946a[com.google.gson.a0.b.f6875l.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f6946a[com.google.gson.a0.b.f6874k.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f6943b = f(v.f7105g);
    }

    private NumberTypeAdapter(w r1) {
        this.f6944a = r1;
    }

    public static x e(w r1) {
        if (r1 != v.f7105g) goto L7;
        return f6943b;
    L7:
        return f(r1);
    }

    private static x f(w r1) {
        final NumberTypeAdapter r0 = new NumberTypeAdapter(r1);
        return new AnonymousClass1(r0);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Number b(com.google.gson.a0.a r1) {
        return g(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void d(c r1, Number r2) {
        h(r1, r2);
    }

    public Number g(com.google.gson.a0.a r4) {
        com.google.gson.a0.b r0 = r4.k0();
        int r1 = a.f6946a[r0.ordinal()];
        if (r1 != 1) goto L5;
        r4.g0();
        return null;
    L5:
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L12;
        throw new s("Expecting number, got: " + r0 + "; at path " + r4.getPath());
    L12:
        return this.f6944a.a(r4);
    }

    public void h(c r1, Number r2) {
        r1.m0(r2);
    }
}
