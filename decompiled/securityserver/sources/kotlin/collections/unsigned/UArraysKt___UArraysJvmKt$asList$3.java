package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class UArraysKt___UArraysJvmKt$asList$3 extends AbstractList<UByte> implements RandomAccess {
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean contains(Object r1) {
        if ((r1 instanceof UByte) == true) goto L6;
        return false;
    L6:
        ArraysKt.c(((UByte) r1).b);
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
        if ((r1 instanceof UByte) == true) goto L6;
        return -1;
    L6:
        ArraysKt.o(((UByte) r1).b);
        throw null;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        throw null;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object r1) {
        if ((r1 instanceof UByte) == true) goto L6;
        return -1;
    L6:
        byte r0 = ((UByte) r1).b;
        Intrinsics.f(null, "<this>");
        throw null;
    }
}
