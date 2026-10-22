package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ArraysKt___ArraysJvmKt$asList$8 extends AbstractList<Character> implements RandomAccess {
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean contains(Object r1) {
        if ((r1 instanceof Character) == true) goto L6;
        return false;
    L6:
        ((Character) r1).charValue();
        Intrinsics.f(null, "<this>");
        Intrinsics.f(null, "<this>");
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
        if ((r1 instanceof Character) == true) goto L6;
        return -1;
    L6:
        ((Character) r1).charValue();
        Intrinsics.f(null, "<this>");
        throw null;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        throw null;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object r1) {
        if ((r1 instanceof Character) == true) goto L6;
        return -1;
    L6:
        ((Character) r1).charValue();
        Intrinsics.f(null, "<this>");
        throw null;
    }
}
