package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: _USequences.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"sum", "Lkotlin/UInt;", "Lkotlin/sequences/Sequence;", "Lkotlin/UByte;", "sumOfUByte", "(Lkotlin/sequences/Sequence;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UShort;", "sumOfUShort", "kotlin-stdlib"}, k = 5, mv = {1, 8, 0}, xi = 49, xs = "kotlin/sequences/USequencesKt")
class USequencesKt___USequencesKt {
    public USequencesKt___USequencesKt() {
    }

    public static final int sumOfUInt(Sequence<UInt> r2) {
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

    public static final long sumOfULong(Sequence<ULong> r4) {
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

    public static final int sumOfUByte(Sequence<UByte> r2) {
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

    public static final int sumOfUShort(Sequence<UShort> r3) {
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
