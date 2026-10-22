package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.a0.c;
import com.google.gson.x;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x f6924c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<E> f6925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypeAdapter<E> f6926b;

    static {
        f6924c = new AnonymousClass1();
    }

    public ArrayTypeAdapter(Gson r2, TypeAdapter<E> r3, Class<E> r4) {
        this.f6926b = new TypeAdapterRuntimeTypeWrapper(r2, r3, r4);
        this.f6925a = r4;
    }

    @Override // com.google.gson.TypeAdapter
    public Object b(com.google.gson.a0.a r4) {
        if (r4.k0() != com.google.gson.a0.b.n) goto L6;
        r4.g0();
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        r4.a();
    L8:
        if (r4.L() == false) goto L10;
        r0.add(this.f6926b.b(r4));
        goto L8
    L10:
        r4.x();
        int r5 = r0.size();
        boolean r1 = this.f6925a.isPrimitive();
        Object r3 = Array.newInstance(this.f6925a, r5);
        if (r1 == false) goto L17;
        int r2 = 0;
    L13:
        if (r2 >= r5) goto L15;
        Array.set(r3, r2, r0.get(r2));
        r2 = r2 + 1;
        goto L13
    L15:
        return r3;
    L17:
        return r0.toArray((Object[]) r3);
    }

    @Override // com.google.gson.TypeAdapter
    public void d(c r5, Object r6) {
        if (r6 != null) goto L5;
        r5.O();
        return;
    L5:
        r5.g();
        int r0 = 0;
        int r1 = Array.getLength(r6);
    L6:
        if (r0 >= r1) goto L8;
        Object r2 = Array.get(r6, r0);
        this.f6926b.d(r5, (E) r2);
        r0 = r0 + 1;
        goto L6
    L8:
        r5.x();
    }
}
