package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.x;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Excluder implements x, Cloneable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Excluder f6904l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f6905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f6906g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f6907h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f6908i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<com.google.gson.a> f6909j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<com.google.gson.a> f6910k;

    static {
        f6904l = new Excluder();
    }

    public Excluder() {
        this.f6905f = -1.0d;
        this.f6906g = 136;
        this.f6907h = true;
        this.f6909j = Collections.emptyList();
        this.f6910k = Collections.emptyList();
    }

    private boolean e(Class<?> r5) {
        if (this.f6905f == (-1.0d)) goto L8;
        if (o((com.google.gson.y.d) r5.getAnnotation(com.google.gson.y.d.class), (com.google.gson.y.e) r5.getAnnotation(com.google.gson.y.e.class)) == true) goto L8;
        return true;
    L8:
        if (this.f6907h == true) goto L13;
        if (j(r5) == false) goto L13;
        return true;
    L13:
        return i(r5);
    }

    private boolean f(Class<?> r1, boolean r2) {
        if (r2 == false) goto L4;
        List<com.google.gson.a> r0 = this.f6909j;
    L5:
        Iterator<com.google.gson.a> r3 = r0.iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        if (r3.next().shouldSkipClass(r1) == false) goto L7;
        return true;
    L12:
        return false;
    L4:
        r0 = this.f6910k;
        goto L5
    }

    private boolean i(Class<?> r2) {
        if (Enum.class.isAssignableFrom(r2) == false) goto L5;
    L11:
        return false;
    L5:
        if (k(r2) == true) goto L11;
        if (r2.isAnonymousClass() == false) goto L9;
    L10:
        return true;
    L9:
        if (r2.isLocalClass() == false) goto L11;
        goto L10
    }

    private boolean j(Class<?> r2) {
        if (r2.isMemberClass() == true) goto L5;
    L7:
        return false;
    L5:
        if (k(r2) == true) goto L7;
        return true;
    }

    private boolean k(Class<?> r1) {
        if ((r1.getModifiers() & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean m(com.google.gson.y.d r4) {
        if (r4 == null) goto L9;
        double r1 = r4.value();
        if (this.f6905f >= r1) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true;
    }

    private boolean n(com.google.gson.y.e r4) {
        if (r4 == null) goto L9;
        double r1 = r4.value();
        if (this.f6905f < r1) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true;
    }

    private boolean o(com.google.gson.y.d r1, com.google.gson.y.e r2) {
        if (m(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (n(r2) == false) goto L7;
        return true;
    }

    @Override // com.google.gson.x
    public <T> TypeAdapter<T> a(final Gson r12, final com.google.gson.z.a<T> r13) {
        Class<? super T> r0 = r13.getRawType();
        boolean r1 = e(r0);
        if (r1 == false) goto L5;
    L8:
        final boolean r8 = true;
    L9:
        if (r1 == false) goto L11;
    L14:
        final boolean r7 = true;
    L15:
        if (r8 == true) goto L20;
        if (r7 == true) goto L20;
        return null;
    L20:
        return new AnonymousClass1(this, r7, r8, r12, r13);
    L11:
        if (f(r0, false) == true) goto L14;
        r7 = false;
        goto L15
    L5:
        if (f(r0, true) == true) goto L8;
        r8 = false;
        goto L9
    }

    protected Excluder c() {
        return (Excluder) super.clone();
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    protected /* bridge */ /* synthetic */ Object clone() {
        return c();
    }

    public boolean d(Class<?> r2, boolean r3) {
        if (e(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (f(r2, r3) == true) goto L8;
        return false;
    }

    public boolean h(Field r7, boolean r8) {
        if ((this.f6906g & r7.getModifiers()) == 0) goto L6;
        return true;
    L6:
        if (this.f6905f == (-1.0d)) goto L11;
        if (o((com.google.gson.y.d) r7.getAnnotation(com.google.gson.y.d.class), (com.google.gson.y.e) r7.getAnnotation(com.google.gson.y.e.class)) == true) goto L11;
        return true;
    L11:
        if (r7.isSynthetic() == false) goto L14;
        return true;
    L14:
        if (this.f6908i == false) goto L25;
        com.google.gson.y.a r0 = (com.google.gson.y.a) r7.getAnnotation(com.google.gson.y.a.class);
        if (r0 == null) goto L23;
        if (r8 == false) goto L22;
        if (r0.serialize() == true) goto L25;
    L22:
        if (r0.deserialize() == true) goto L25;
    L23:
        return true;
    L25:
        if (this.f6907h == true) goto L30;
        if (j(r7.getType()) == false) goto L30;
        return true;
    L30:
        if (i(r7.getType()) == false) goto L32;
        return true;
    L32:
        if (r8 == false) goto L34;
        List<com.google.gson.a> r6 = this.f6909j;
    L36:
        if (r6.isEmpty() == true) goto L43;
        com.google.gson.b r9 = new com.google.gson.b(r7);
        Iterator<com.google.gson.a> r10 = r6.iterator();
    L39:
        if (r10.hasNext() == false) goto L48;
        if (r10.next().shouldSkipField(r9) == false) goto L39;
        return true;
    L48:
        return false;
    L43:
        return false;
    L34:
        r6 = this.f6910k;
        goto L36
    }

    public Excluder p(com.google.gson.a r3, boolean r4, boolean r5) {
        Excluder r0 = c();
        if (r4 == false) goto L5;
        ArrayList r6 = new ArrayList(this.f6909j);
        r0.f6909j = r6;
        r6.add(r3);
    L5:
        if (r5 == false) goto L7;
        ArrayList r7 = new ArrayList(this.f6910k);
        r0.f6910k = r7;
        r7.add(r3);
    L7:
        return r0;
    }
}
