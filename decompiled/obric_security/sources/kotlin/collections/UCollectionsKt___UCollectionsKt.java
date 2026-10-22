package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: _UCollections.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0005\u001a\u001a\u0010\f\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001a\u0010\u0010\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u001a\u0010\u0013\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u001a\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"sum", "Lkotlin/UInt;", "", "Lkotlin/UByte;", "sumOfUByte", "(Ljava/lang/Iterable;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/Iterable;)J", "Lkotlin/UShort;", "sumOfUShort", "toUByteArray", "Lkotlin/UByteArray;", "", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "(Ljava/util/Collection;)[S", "kotlin-stdlib"}, k = 5, mv = {1, 8, 0}, xi = 49, xs = "kotlin/collections/UCollectionsKt")
class UCollectionsKt___UCollectionsKt {
    public UCollectionsKt___UCollectionsKt() {
    }

    public static final byte[] toUByteArray(Collection<UByte> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        byte[] r0 = UByteArray.m844constructorimpl(r4.size());
        Iterator<UByte> r5 = r4.iterator();
        int r1 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        UByteArray.m855setVurrAj0(r0, r1, r5.next().m842unboximpl());
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static final int[] toUIntArray(Collection<UInt> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        int[] r0 = UIntArray.m923constructorimpl(r4.size());
        Iterator<UInt> r5 = r4.iterator();
        int r1 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        UIntArray.m934setVXSXFK8(r0, r1, r5.next().m921unboximpl());
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static final long[] toULongArray(Collection<ULong> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        long[] r0 = ULongArray.m1002constructorimpl(r5.size());
        Iterator<ULong> r6 = r5.iterator();
        int r1 = 0;
    L4:
        if (r6.hasNext() == false) goto L6;
        ULongArray.m1013setk8EXiF4(r0, r1, r6.next().m1000unboximpl());
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static final short[] toUShortArray(Collection<UShort> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        short[] r0 = UShortArray.m1107constructorimpl(r4.size());
        Iterator<UShort> r5 = r4.iterator();
        int r1 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        UShortArray.m1118set01HTLdE(r0, r1, r5.next().m1105unboximpl());
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static final int sumOfUInt(Iterable<UInt> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Iterator<UInt> r3 = r2.iterator();
        int r0 = 0;
    L4:
        if (r3.hasNext() == false) goto L6;
        r0 = UInt.m869constructorimpl(r0 + r3.next().m921unboximpl());
        goto L4
    L6:
        return r0;
    }

    public static final long sumOfULong(Iterable<ULong> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Iterator<ULong> r5 = r4.iterator();
        long r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = ULong.m948constructorimpl(r0 + r5.next().m1000unboximpl());
        goto L4
    L6:
        return r0;
    }

    public static final int sumOfUByte(Iterable<UByte> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Iterator<UByte> r3 = r2.iterator();
        int r0 = 0;
    L4:
        if (r3.hasNext() == false) goto L6;
        r0 = UInt.m869constructorimpl(r0 + UInt.m869constructorimpl(r3.next().m842unboximpl() & UByte.MAX_VALUE));
        goto L4
    L6:
        return r0;
    }

    public static final int sumOfUShort(Iterable<UShort> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Iterator<UShort> r4 = r3.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = UInt.m869constructorimpl(r0 + UInt.m869constructorimpl(r4.next().m1105unboximpl() & UShort.MAX_VALUE));
        goto L4
    L6:
        return r0;
    }
}
