package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.a0.c;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.internal.l;
import com.google.gson.j;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.x;

/* JADX INFO: loaded from: classes2.dex */
public final class TreeTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r<T> f6975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i<T> f6976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Gson f6977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.gson.z.a<T> f6978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final x f6979e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TreeTypeAdapter<T>.b f6980f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f6981g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile TypeAdapter<T> f6982h;

    private static final class SingleTypeFactory implements x {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final com.google.gson.z.a<?> f6983f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f6984g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Class<?> f6985h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final r<?> f6986i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final i<?> f6987j;

        SingleTypeFactory(Object r4, com.google.gson.z.a<?> r5, boolean r6, Class<?> r7) {
            i<?> r1 = null;
            if ((r4 instanceof r) == false) goto L5;
            r<?> r0 = (r) r4;
        L6:
            this.f6986i = r0;
            if ((r4 instanceof i) == false) goto L9;
            r1 = (i) r4;
        L9:
            this.f6987j = r1;
            if (r0 != null) goto L14;
            if (r1 != null) goto L14;
            boolean r8 = false;
        L15:
            com.google.gson.internal.a.a(r8);
            this.f6983f = r5;
            this.f6984g = r6;
            this.f6985h = r7;
            return;
        L14:
            r8 = true;
            goto L15
        L5:
            r0 = null;
            goto L6
        }

        @Override // com.google.gson.x
        public <T> TypeAdapter<T> a(Gson r8, com.google.gson.z.a<T> r9) {
            com.google.gson.z.a<?> r0 = this.f6983f;
            if (r0 != null) goto L5;
            boolean r1 = this.f6985h.isAssignableFrom(r9.getRawType());
        L14:
            if (r1 == true) goto L18;
            return null;
        L18:
            return new TreeTypeAdapter(this.f6986i, this.f6987j, r8, r9, this);
        L5:
            if (r0.equals(r9) == false) goto L7;
        L12:
            r1 = true;
            goto L14
        L7:
            if (this.f6984g == true) goto L9;
        L11:
            r1 = false;
            goto L14
        L9:
            if (this.f6983f.getType() != r9.getRawType()) goto L11;
            goto L11
        }
    }

    static /* synthetic */ class a {
    }

    private final class b implements q, h {
        private b(TreeTypeAdapter r1) {
        }

        /* synthetic */ b(TreeTypeAdapter r1, a r2) {
            this(r1);
        }
    }

    public TreeTypeAdapter(r<T> r8, i<T> r9, Gson r10, com.google.gson.z.a<T> r11, x r12) {
        this(r8, r9, r10, r11, r12, true);
    }

    public TreeTypeAdapter(r<T> r3, i<T> r4, Gson r5, com.google.gson.z.a<T> r6, x r7, boolean r8) {
        this.f6980f = new b(this, null);
        this.f6975a = r3;
        this.f6976b = r4;
        this.f6977c = r5;
        this.f6978d = r6;
        this.f6979e = r7;
        this.f6981g = r8;
    }

    private TypeAdapter<T> f() {
        TypeAdapter<T> r0 = this.f6982h;
        if (r0 != null) goto L7;
        TypeAdapter<T> r1 = this.f6977c.q(this.f6979e, this.f6978d);
        this.f6982h = r1;
        return r1;
    L7:
        return r0;
    }

    public static x g(Class<?> r3, Object r4) {
        return new SingleTypeFactory(r4, null, false, r3);
    }

    @Override // com.google.gson.TypeAdapter
    public T b(com.google.gson.a0.a r3) {
        if (this.f6976b == null) goto L5;
        j r4 = l.a(r3);
        if (this.f6981g == false) goto L13;
        if (r4.n() == false) goto L13;
        return null;
    L13:
        return this.f6976b.deserialize(r4, this.f6978d.getType(), this.f6980f);
    L5:
        return f().b(r3);
    }

    @Override // com.google.gson.TypeAdapter
    public void d(c r3, T r4) {
        r<T> r0 = this.f6975a;
        if (r0 != null) goto L7;
        f().d(r3, r4);
        return;
    L7:
        if (this.f6981g == false) goto L11;
        if (r4 != null) goto L11;
        r3.O();
        return;
    L11:
        l.b(r0.serialize(r4, this.f6978d.getType(), this.f6980f), r3);
    }

    @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
    public TypeAdapter<T> e() {
        if (this.f6975a == null) goto L6;
        return this;
    L6:
        return f();
    }
}
