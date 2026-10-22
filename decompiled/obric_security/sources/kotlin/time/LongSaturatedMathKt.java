package kotlin.time;

import kotlin.Metadata;

/* JADX INFO: compiled from: longSaturatedMath.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\"\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\n\u001a \u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a \u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\r\u0010\u0016\u001a\u00020\u0017*\u00020\u0001H\u0082\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"checkInfiniteSumDefined", "", "longNs", "duration", "Lkotlin/time/Duration;", "durationNs", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "saturatingAdd", "saturatingAdd-pTJri5U", "(JJ)J", "saturatingAddInHalves", "saturatingAddInHalves-pTJri5U", "saturatingDiff", "valueNs", "originNs", "saturatingFiniteDiff", "value1Ns", "value2Ns", "saturatingOriginsDiff", "origin1Ns", "origin2Ns", "isSaturated", "", "kotlin-stdlib"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LongSaturatedMathKt {
    private static final boolean isSaturated(long r2) {
        if (((r2 - 1) | 1) != Long.MAX_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: saturatingAdd-pTJri5U, reason: not valid java name */
    public static final long m2228saturatingAddpTJri5U(long r11, long r13) {
        long r4 = Duration.m2120getInWholeNanosecondsimpl(r13);
        boolean r3 = true;
        if (((r11 - 1) | 1) != Long.MAX_VALUE) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L10;
        return m2227checkInfiniteSumDefinedPjuGub4(r11, r13, r4);
    L10:
        if ((1 | (r4 - 1)) == Long.MAX_VALUE) goto L13;
        r3 = false;
    L13:
        if (r3 == true) goto L15;
        long r14 = r11 + r4;
        if (((r11 ^ r14) & (r4 ^ r14)) < 0) goto L19;
        return r14;
    L19:
        if (r11 >= 0) goto L23;
        return Long.MIN_VALUE;
    L23:
        return Long.MAX_VALUE;
    L15:
        return m2229saturatingAddInHalvespTJri5U(r11, r13);
    L5:
        r2 = false;
        goto L6
    }

    /* JADX INFO: renamed from: checkInfiniteSumDefined-PjuGub4, reason: not valid java name */
    private static final long m2227checkInfiniteSumDefinedPjuGub4(long r0, long r2, long r4) {
        if (Duration.m2132isInfiniteimpl(r2) == true) goto L5;
    L9:
        return r0;
    L5:
        if ((r0 ^ r4) >= 0) goto L9;
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    /* JADX INFO: renamed from: saturatingAddInHalves-pTJri5U, reason: not valid java name */
    private static final long m2229saturatingAddInHalvespTJri5U(long r6, long r8) {
        long r0 = Duration.m2103divUwyO8pc(r8, 2);
        if (((Duration.m2120getInWholeNanosecondsimpl(r0) - 1) | 1) != Long.MAX_VALUE) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L10;
        return (long) (r6 + Duration.m2143toDoubleimpl(r8, DurationUnit.NANOSECONDS));
    L10:
        return m2228saturatingAddpTJri5U(m2228saturatingAddpTJri5U(r6, r0), Duration.m2135minusLRDsOJo(r8, r0));
    L5:
        r2 = false;
        goto L6
    }

    public static final long saturatingDiff(long r4, long r6) {
        if ((1 | (r6 - 1)) != Long.MAX_VALUE) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return Duration.m2152unaryMinusUwyO8pc(DurationKt.toDuration(r6, DurationUnit.DAYS));
    L10:
        return saturatingFiniteDiff(r4, r6);
    L5:
        r0 = false;
        goto L6
    }

    public static final long saturatingOriginsDiff(long r9, long r11) {
        boolean r3 = true;
        if (((r11 - 1) | 1) != Long.MAX_VALUE) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L14;
        if (r9 != r11) goto L12;
        return Duration.Companion.m2202getZEROUwyO8pc();
    L12:
        return Duration.m2152unaryMinusUwyO8pc(DurationKt.toDuration(r11, DurationUnit.DAYS));
    L14:
        if ((1 | (r9 - 1)) == Long.MAX_VALUE) goto L17;
        r3 = false;
    L17:
        if (r3 == false) goto L21;
        return DurationKt.toDuration(r9, DurationUnit.DAYS);
    L21:
        return saturatingFiniteDiff(r9, r11);
    L5:
        r2 = false;
        goto L6
    }

    private static final long saturatingFiniteDiff(long r6, long r8) {
        long r0 = r6 - r8;
        if (((r0 ^ r6) & (~(r0 ^ r8))) >= 0) goto L6;
        long r1 = 1000000;
        long r2 = (r6 / r1) - (r8 / r1);
        long r7 = (r6 % r1) - (r8 % r1);
        Duration.Companion r9 = Duration.Companion;
        long r10 = DurationKt.toDuration(r2, DurationUnit.MILLISECONDS);
        Duration.Companion r3 = Duration.Companion;
        return Duration.m2136plusLRDsOJo(r10, DurationKt.toDuration(r7, DurationUnit.NANOSECONDS));
    L6:
        Duration.Companion r11 = Duration.Companion;
        return DurationKt.toDuration(r0, DurationUnit.NANOSECONDS);
    }
}
