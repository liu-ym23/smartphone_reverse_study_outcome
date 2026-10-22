package kotlin.reflect;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@ExperimentalStdlibApi
final class TypeVariableImpl implements TypeVariable<GenericDeclaration>, TypeImpl {
    public final KTypeParameter b;

    public TypeVariableImpl(KTypeParameter r2) {
        Intrinsics.f(r2, "typeParameter");
        this.b = r2;
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof TypeVariable) == false) goto L9;
        this.b.getClass();
        if (Intrinsics.a(null, ((TypeVariable) r2).getName()) == false) goto L11;
        getGenericDeclaration();
        throw null;
    L11:
        return false;
    L9:
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    public final Type[] getBounds() {
        List r7 = this.b.getUpperBounds();
        ArrayList r0 = new ArrayList(CollectionsKt.e(r7, 10));
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L31;
        KType r1 = (KType) r8.next();
        KClassifier r2 = r1.d();
        if ((r2 instanceof KTypeParameter) == false) goto L9;
        Object r3 = new TypeVariableImpl((KTypeParameter) r2);
    L28:
        r0.add(r3);
        goto L4
    L9:
        if ((r2 instanceof KClass) == false) goto L30;
        Class r4 = JvmClassMappingKt.a((KClass) r2);
        List r5 = r1.c();
        if (r5.isEmpty() == false) goto L14;
    L12:
        r3 = r4;
        goto L28
    L14:
        if (r4.isArray() == true) goto L16;
        r3 = TypesJVMKt.b(r4, r5);
        goto L28
    L16:
        if (r4.getComponentType().isPrimitive() == true) goto L12;
        if (r5.size() != 1) goto L21;
        Object r6 = r5.get(0);
    L22:
        KTypeProjection r9 = (KTypeProjection) r6;
        if (r9 == null) goto L26;
        r9.getClass();
        goto L12
    L26:
        throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + r1);
    L21:
        r6 = null;
        goto L22
    L30:
        throw new UnsupportedOperationException("Unsupported type classifier: " + r1);
    L31:
        Object[] r10 = r0.toArray(new Type[0]);
        Intrinsics.d(r10, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Type[]) r10;
    }

    @Override // java.lang.reflect.TypeVariable
    public final GenericDeclaration getGenericDeclaration() {
        String r3 = "An operation is not implemented: " + ("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.b);
        Intrinsics.f(r3, "message");
        throw new NotImplementedError(r3);
    }

    @Override // java.lang.reflect.TypeVariable
    public final String getName() {
        this.b.getClass();
        return null;
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        this.b.getClass();
        return null;
    }

    public final int hashCode() {
        this.b.getClass();
        throw null;
    }

    public final String toString() {
        this.b.getClass();
        return null;
    }
}
