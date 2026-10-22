package kotlin.s0;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\tJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016¢\u0006\u0002\u0010\u0011J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0019"}, d2 = {"Lkotlin/reflect/ParameterizedTypeImpl;", "Ljava/lang/reflect/ParameterizedType;", "Lkotlin/reflect/TypeImpl;", "rawType", "Ljava/lang/Class;", "ownerType", "Ljava/lang/reflect/Type;", "typeArguments", "", "(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V", "", "[Ljava/lang/reflect/Type;", "equals", "", "other", "", "getActualTypeArguments", "()[Ljava/lang/reflect/Type;", "getOwnerType", "getRawType", "getTypeName", "", "hashCode", "", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class r implements ParameterizedType, Type {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Class<?> f18488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Type f18489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Type[] f18490h;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* synthetic */ class a extends kotlin.n0.d.m implements kotlin.n0.c.l<Type, String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f18491f = null;

        static {
            f18491f = new a();
        }

        a() {
            super(1, t.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ String invoke(Type r1) {
            return m(r1);
        }

        public final String m(Type r1) {
            kotlin.n0.d.o.f(r1, "p0");
            return t.b(r1);
        }
    }

    public r(Class<?> r2, Type r3, List<? extends Type> r4) {
        kotlin.n0.d.o.f(r2, "rawType");
        kotlin.n0.d.o.f(r4, "typeArguments");
        this.f18488f = r2;
        this.f18489g = r3;
        Object[] r5 = r4.toArray(new Type[0]);
        kotlin.n0.d.o.d(r5, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.f18490h = (Type[]) r5;
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof ParameterizedType) == false) goto L11;
        ParameterizedType r4 = (ParameterizedType) r3;
        if (kotlin.n0.d.o.a(this.f18488f, r4.getRawType()) == false) goto L11;
        if (kotlin.n0.d.o.a(this.f18489g, r4.getOwnerType()) == false) goto L11;
        if (Arrays.equals(getActualTypeArguments(), r4.getActualTypeArguments()) == false) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.f18490h;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.f18489g;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.f18488f;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        StringBuilder r10 = new StringBuilder();
        Type r0 = this.f18489g;
        if (r0 == null) goto L5;
        r10.append(t.b(r0));
        r10.append("$");
        String r1 = this.f18488f.getSimpleName();
    L6:
        r10.append(r1);
        Type[] r2 = this.f18490h;
        if (r2.length != 0) goto L9;
        boolean r11 = true;
    L11:
        if ((!r11) == false) goto L13;
        kotlin.i0.i.H(r2, r10, null, "<", ">", 0, null, a.f18491f, 50, null);
    L13:
        String r12 = r10.toString();
        kotlin.n0.d.o.e(r12, "StringBuilder().apply(builderAction).toString()");
        return r12;
    L9:
        r11 = false;
        goto L11
    L5:
        r1 = t.b(this.f18488f);
        goto L6
    }

    public int hashCode() {
        int r0 = this.f18488f.hashCode();
        Type r1 = this.f18489g;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        int r3 = Arrays.hashCode(getActualTypeArguments());
        return r3 ^ (r0 ^ r2);
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return getTypeName();
    }
}
