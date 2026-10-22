package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.c;
import com.google.gson.internal.e;
import com.google.gson.internal.h;
import com.google.gson.internal.l;
import com.google.gson.j;
import com.google.gson.p;
import com.google.gson.s;
import com.google.gson.x;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class MapTypeAdapterFactory implements x {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f6937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f6938g;

    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TypeAdapter<K> f6939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TypeAdapter<V> f6940b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final h<? extends Map<K, V>> f6941c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ MapTypeAdapterFactory f6942d;

        public Adapter(MapTypeAdapterFactory r1, Gson r2, Type r3, TypeAdapter<K> r4, Type r5, TypeAdapter<V> r6, h<? extends Map<K, V>> r7) {
            this.f6942d = r1;
            this.f6939a = new TypeAdapterRuntimeTypeWrapper(r2, r4, r3);
            this.f6940b = new TypeAdapterRuntimeTypeWrapper(r2, r6, r5);
            this.f6941c = r7;
        }

        private String e(j r1) {
            if (r1.p() == false) goto L19;
            p r0 = r1.d();
            if (r0.w() == false) goto L9;
            return String.valueOf(r0.t());
        L9:
            if (r0.u() == false) goto L13;
            return Boolean.toString(r0.q());
        L13:
            if (r0.x() == false) goto L17;
            return r0.l();
        L17:
            throw new AssertionError();
        L19:
            if (r1.n() == false) goto L23;
            return "null";
        L23:
            throw new AssertionError();
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ Object b(com.google.gson.a0.a r1) {
            return f(r1);
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void d(com.google.gson.a0.c r1, Object r2) {
            g(r1, (Map) r2);
        }

        public Map<K, V> f(com.google.gson.a0.a r5) {
            com.google.gson.a0.b r0 = r5.k0();
            if (r0 != com.google.gson.a0.b.n) goto L6;
            r5.g0();
            return null;
        L6:
            Map<K, V> r1 = this.f6941c.a();
            if (r0 != com.google.gson.a0.b.f6869f) goto L17;
            r5.a();
        L10:
            if (r5.L() == false) goto L16;
            r5.a();
            K r2 = this.f6939a.b(r5);
            if (r1.put(r2, this.f6940b.b(r5)) != null) goto L15;
            r5.x();
            goto L10
        L15:
            throw new s("duplicate key: " + r2);
        L16:
            r5.x();
        L26:
            return r1;
        L17:
            r5.b();
        L19:
            if (r5.L() == false) goto L25;
            e.f7042a.a(r5);
            K r3 = this.f6939a.b(r5);
            if (r1.put(r3, this.f6940b.b(r5)) == null) goto L19;
            throw new s("duplicate key: " + r3);
        L25:
            r5.A();
            goto L26
        }

        public void g(com.google.gson.a0.c r8, Map<K, V> r9) {
            if (r9 != null) goto L6;
            r8.O();
            return;
        L6:
            if (this.f6942d.f6938g == true) goto L13;
            r8.l();
            Iterator<Map.Entry<K, V>> r10 = r9.entrySet().iterator();
        L9:
            if (r10.hasNext() == false) goto L11;
            Map.Entry<K, V> r0 = r10.next();
            r8.M(String.valueOf(r0.getKey()));
            this.f6940b.d(r8, r0.getValue());
            goto L9
        L11:
            r8.A();
            return;
        L13:
            ArrayList r1 = new ArrayList(r9.size());
            ArrayList r2 = new ArrayList(r9.size());
            Iterator<Map.Entry<K, V>> r11 = r9.entrySet().iterator();
            int r3 = 0;
            boolean r4 = false;
        L15:
            if (r11.hasNext() == false) goto L24;
            Map.Entry<K, V> r5 = r11.next();
            j r6 = this.f6939a.c(r5.getKey());
            r1.add(r6);
            r2.add(r5.getValue());
            if (r6.m() == false) goto L19;
        L22:
            boolean r7 = true;
        L23:
            r4 = r4 | r7;
            goto L15
        L19:
            if (r6.o() == true) goto L22;
            r7 = false;
            goto L23
        L24:
            if (r4 == false) goto L29;
            r8.g();
            int r12 = r1.size();
        L26:
            if (r3 >= r12) goto L28;
            r8.g();
            l.b((j) r1.get(r3), r8);
            this.f6940b.d(r8, (V) r2.get(r3));
            r8.x();
            r3 = r3 + 1;
            goto L26
        L28:
            r8.x();
            return;
        L29:
            r8.l();
            int r13 = r1.size();
        L30:
            if (r3 >= r13) goto L32;
            r8.M(e((j) r1.get(r3)));
            this.f6940b.d(r8, (V) r2.get(r3));
            r3 = r3 + 1;
            goto L30
        L32:
            r8.A();
        }
    }

    public MapTypeAdapterFactory(c r1, boolean r2) {
        this.f6937f = r1;
        this.f6938g = r2;
    }

    private TypeAdapter<?> b(Gson r1, Type r2) {
        if (r2 == Boolean.TYPE) goto L9;
        if (r2 == Boolean.class) goto L9;
        return r1.o(com.google.gson.z.a.get(r2));
    L9:
        return TypeAdapters.f6997f;
    }

    @Override // com.google.gson.x
    public <T> TypeAdapter<T> a(Gson r12, com.google.gson.z.a<T> r13) {
        Type r0 = r13.getType();
        Class<? super T> r1 = r13.getRawType();
        if (Map.class.isAssignableFrom(r1) == true) goto L6;
        return null;
    L6:
        Type[] r2 = com.google.gson.internal.b.j(r0, r1);
        TypeAdapter<?> r7 = b(r12, r2[0]);
        TypeAdapter<T> r9 = r12.o(com.google.gson.z.a.get(r2[1]));
        h<T> r10 = this.f6937f.b(r13);
        return new Adapter(this, r12, r2[0], r7, r2[1], r9, r10);
    }
}
