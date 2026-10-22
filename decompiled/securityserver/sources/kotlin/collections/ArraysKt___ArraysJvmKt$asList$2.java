package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ArraysKt___ArraysJvmKt$asList$2 extends AbstractList<Short> implements RandomAccess {
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean contains(Object r1) {
        if ((r1 instanceof Short) == true) goto L6;
        return false;
    L6:
        ArraysKt.f(((Number) r1).shortValue());
        throw null;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int r1) {
        throw null;
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        throw null;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object r1) {
        if ((r1 instanceof Short) == true) goto L6;
        return -1;
    L6:
        ArraysKt.r(((Number) r1).shortValue());
        throw null;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        throw null;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object r1) {
        if ((r1 instanceof Short) == true) goto L6;
        return -1;
    L6:
        ((Number) r1).shortValue();
        Intrinsics.f(null, "<this>");
        throw null;
    }
}
