package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.c;
import com.google.gson.internal.h;
import com.google.gson.x;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class CollectionTypeAdapterFactory implements x {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f6927f;

    private static final class Adapter<E> extends TypeAdapter<Collection<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TypeAdapter<E> f6928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h<? extends Collection<E>> f6929b;

        public Adapter(Gson r2, Type r3, TypeAdapter<E> r4, h<? extends Collection<E>> r5) {
            this.f6928a = new TypeAdapterRuntimeTypeWrapper(r2, r4, r3);
            this.f6929b = r5;
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ Object b(com.google.gson.a0.a r1) {
            return e(r1);
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void d(com.google.gson.a0.c r1, Object r2) {
            f(r1, (Collection) r2);
        }

        public Collection<E> e(com.google.gson.a0.a r3) {
            if (r3.k0() != com.google.gson.a0.b.n) goto L6;
            r3.g0();
            return null;
        L6:
            Collection<E> r0 = this.f6929b.a();
            r3.a();
        L8:
            if (r3.L() == false) goto L10;
            r0.add(this.f6928a.b(r3));
            goto L8
        L10:
            r3.x();
            return r0;
        }

        public void f(com.google.gson.a0.c r3, Collection<E> r4) {
            if (r4 != null) goto L5;
            r3.O();
            return;
        L5:
            r3.g();
            Iterator<E> r5 = r4.iterator();
        L7:
            if (r5.hasNext() == false) goto L9;
            E r0 = r5.next();
            this.f6928a.d(r3, r0);
            goto L7
        L9:
            r3.x();
        }
    }

    public CollectionTypeAdapterFactory(c r1) {
        this.f6927f = r1;
    }

    @Override // com.google.gson.x
    public <T> TypeAdapter<T> a(Gson r4, com.google.gson.z.a<T> r5) {
        Type r0 = r5.getType();
        Class<? super T> r1 = r5.getRawType();
        if (Collection.class.isAssignableFrom(r1) == true) goto L6;
        return null;
    L6:
        Type r2 = com.google.gson.internal.b.h(r0, r1);
        return new Adapter(r4, r2, r4.o(com.google.gson.z.a.get(r2)), this.f6927f.b(r5));
    }
}
