package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.a0.c;
import com.google.gson.internal.g;
import com.google.gson.v;
import com.google.gson.w;
import com.google.gson.x;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final x f6947c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f6948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w f6949b;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6951a = null;

        static {
            int[] r0 = new int[com.google.gson.a0.b.values().length];
            f6951a = r0;
            r0[com.google.gson.a0.b.f6869f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f6951a[com.google.gson.a0.b.f6871h.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f6951a[com.google.gson.a0.b.f6874k.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f6951a[com.google.gson.a0.b.f6875l.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f6951a[com.google.gson.a0.b.m.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f6951a[com.google.gson.a0.b.n.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        f6947c = f(v.f7104f);
    }

    private ObjectTypeAdapter(Gson r1, w r2) {
        this.f6948a = r1;
        this.f6949b = r2;
    }

    /* synthetic */ ObjectTypeAdapter(Gson r1, w r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static x e(w r1) {
        if (r1 != v.f7104f) goto L7;
        return f6947c;
    L7:
        return f(r1);
    }

    private static x f(final w r1) {
        return new AnonymousClass1(r1);
    }

    private Object g(com.google.gson.a0.a r3, com.google.gson.a0.b r4) {
        int r0 = a.f6951a[r4.ordinal()];
        if (r0 == 3) goto L19;
        if (r0 == 4) goto L17;
        if (r0 == 5) goto L15;
        if (r0 != 6) goto L13;
        r3.g0();
        return null;
    L13:
        throw new IllegalStateException("Unexpected token: " + r4);
    L15:
        return Boolean.valueOf(r3.Q());
    L17:
        return this.f6949b.a(r3);
    L19:
        return r3.i0();
    }

    private Object h(com.google.gson.a0.a r1, com.google.gson.a0.b r2) {
        int r0 = a.f6951a[r2.ordinal()];
        if (r0 != 1) goto L5;
        r1.a();
        return new ArrayList();
    L5:
        if (r0 == 2) goto L8;
        return null;
    L8:
        r1.b();
        return new g();
    }

    @Override // com.google.gson.TypeAdapter
    public Object b(com.google.gson.a0.a r7) {
        com.google.gson.a0.b r0 = r7.k0();
        Object r1 = h(r7, r0);
        if (r1 == null) goto L5;
        ArrayDeque r2 = new ArrayDeque();
    L8:
        if (r7.L() == true) goto L9;
        if ((r1 instanceof List) == false) goto L27;
        r7.x();
    L29:
        if (r2.isEmpty() == true) goto L30;
        r1 = r2.removeLast();
        goto L8
    L30:
        return r1;
    L27:
        r7.A();
        goto L29
    L9:
        String r3 = null;
        if ((r1 instanceof Map) == false) goto L12;
        r3 = r7.Y();
    L12:
        com.google.gson.a0.b r4 = r7.k0();
        Object r5 = h(r7, r4);
        if (r5 == null) goto L15;
        boolean r6 = true;
    L16:
        if (r5 != null) goto L19;
        r5 = g(r7, r4);
    L19:
        if ((r1 instanceof List) == false) goto L21;
        ((List) r1).add(r5);
    L22:
        if (r6 == false) goto L8;
        r2.addLast(r1);
        r1 = r5;
        goto L8
    L21:
        ((Map) r1).put(r3, r5);
        goto L22
    L15:
        r6 = false;
        goto L16
    L5:
        return g(r7, r0);
    }

    @Override // com.google.gson.TypeAdapter
    public void d(c r2, Object r3) {
        if (r3 != null) goto L5;
        r2.O();
        return;
    L5:
        TypeAdapter r1 = this.f6948a.p(r3.getClass());
        if ((r1 instanceof ObjectTypeAdapter) == false) goto L9;
        r2.l();
        r2.A();
        return;
    L9:
        r1.d(r2, r3);
    }
}
