package kotlin.internal;

import com.bytedance.apm.constant.TraceStatsConsts;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;

/* JADX INFO: compiled from: UProgressionUtil.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0006\u001a*\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", TraceStatsConsts.STATS_KEY_END, "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class UProgressionUtilKt {
    /* JADX INFO: renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m1992differenceModuloWZ9TVnA(int r1, int r2, int r3) {
        int r4 = Integer.remainderUnsigned(r1, r3);
        int r5 = Integer.remainderUnsigned(r2, r3);
        int r0 = Integer.compareUnsigned(r4, r5);
        int r6 = UInt.m869constructorimpl(r4 - r5);
        if (r0 < 0) goto L6;
        return r6;
    L6:
        return UInt.m869constructorimpl(r6 + r3);
    }

    /* JADX INFO: renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m1993differenceModulosambcqE(long r1, long r3, long r5) {
        long r2 = Long.remainderUnsigned(r1, r5);
        long r4 = Long.remainderUnsigned(r3, r5);
        int r0 = Long.compareUnsigned(r2, r4);
        long r6 = ULong.m948constructorimpl(r2 - r4);
        if (r0 < 0) goto L6;
        return r6;
    L6:
        return ULong.m948constructorimpl(r6 + r5);
    }

    /* JADX INFO: renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m1995getProgressionLastElementNkh28Cs(int r1, int r2, int r3) {
        if (r3 > 0) goto L4;
        if (r3 >= 0) goto L14;
        if (Integer.compareUnsigned(r1, r2) > 0) goto L12;
        return r2;
    L12:
        return UInt.m869constructorimpl(r2 + m1992differenceModuloWZ9TVnA(r1, r2, UInt.m869constructorimpl(-r3)));
    L14:
        throw new IllegalArgumentException("Step is zero.");
    L4:
        if (Integer.compareUnsigned(r1, r2) < 0) goto L15;
        return r2;
    L15:
        return UInt.m869constructorimpl(r2 - m1992differenceModuloWZ9TVnA(r2, r1, UInt.m869constructorimpl(r3)));
    }

    /* JADX INFO: renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m1994getProgressionLastElement7ftBX0g(long r7, long r9, long r11) {
        if (r11 > 0) goto L5;
        if (r11 >= 0) goto L15;
        if (Long.compareUnsigned(r7, r9) > 0) goto L13;
        return r9;
    L13:
        return ULong.m948constructorimpl(r9 + m1993differenceModulosambcqE(r7, r9, ULong.m948constructorimpl(-r11)));
    L15:
        throw new IllegalArgumentException("Step is zero.");
    L5:
        if (Long.compareUnsigned(r7, r9) < 0) goto L16;
        return r9;
    L16:
        return ULong.m948constructorimpl(r9 - m1993differenceModulosambcqE(r9, r7, ULong.m948constructorimpl(r11)));
    }
}
