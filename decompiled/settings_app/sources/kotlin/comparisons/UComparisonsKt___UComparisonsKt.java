package kotlin.comparisons;

import android.icu.text.PluralRules;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: _UComparisons.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a(\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a(\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a#\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001f\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a(\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\b¢\u0006\u0004\b \u0010!\u001a#\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b&\u0010\u0005\u001a(\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b'\u0010\b\u001a#\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007¢\u0006\u0004\b(\u0010\f\u001a\u001f\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007¢\u0006\u0004\b)\u0010\u000f\u001a(\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b¢\u0006\u0004\b*\u0010\u0011\u001a#\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007¢\u0006\u0004\b+\u0010\u0014\u001a\u001f\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007¢\u0006\u0004\b,\u0010\u0017\u001a(\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\b-\u0010\u0019\u001a#\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007¢\u0006\u0004\b.\u0010\u001c\u001a\u001f\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007¢\u0006\u0004\b/\u0010\u001f\u001a(\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\b¢\u0006\u0004\b0\u0010!\u001a#\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007¢\u0006\u0004\b1\u0010$¨\u00062"}, d2 = {"maxOf", "Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", PluralRules.KEYWORD_OTHER, "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-Wr6uiD8", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-Md2H83M", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-R03FKyM", "minOf-5PvTz6A", "minOf-VKSA0NQ", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/comparisons/UComparisonsKt")
class UComparisonsKt___UComparisonsKt {
    public UComparisonsKt___UComparisonsKt() {
    }

    /* JADX INFO: renamed from: maxOf-J1ME1BU, reason: not valid java name */
    public static final int m2691maxOfJ1ME1BU(int r1, int r2) {
        if (Integer.compareUnsigned(r1, r2) < 0) goto L6;
        return r1;
    L6:
        return r2;
    }

    /* JADX INFO: renamed from: maxOf-eb3DHEI, reason: not valid java name */
    public static final long m2699maxOfeb3DHEI(long r1, long r3) {
        if (Long.compareUnsigned(r1, r3) < 0) goto L6;
        return r1;
    L6:
        return r3;
    }

    /* JADX INFO: renamed from: maxOf-Kr8caGY, reason: not valid java name */
    public static final byte m2692maxOfKr8caGY(byte r2, byte r3) {
        if (Intrinsics.compare(r2 & 255, r3 & 255) < 0) goto L6;
        return r2;
    L6:
        return r3;
    }

    /* JADX INFO: renamed from: maxOf-5PvTz6A, reason: not valid java name */
    public static final short m2690maxOf5PvTz6A(short r2, short r3) {
        if (Intrinsics.compare(r2 & 65535, 65535 & r3) < 0) goto L6;
        return r2;
    L6:
        return r3;
    }

    /* JADX INFO: renamed from: maxOf-WZ9TVnA, reason: not valid java name */
    private static final int m2696maxOfWZ9TVnA(int r0, int r1, int r2) {
        return UComparisonsKt.m2691maxOfJ1ME1BU(r0, UComparisonsKt.m2691maxOfJ1ME1BU(r1, r2));
    }

    /* JADX INFO: renamed from: maxOf-sambcqE, reason: not valid java name */
    private static final long m2700maxOfsambcqE(long r0, long r2, long r4) {
        return UComparisonsKt.m2699maxOfeb3DHEI(r0, UComparisonsKt.m2699maxOfeb3DHEI(r2, r4));
    }

    /* JADX INFO: renamed from: maxOf-b33U2AM, reason: not valid java name */
    private static final byte m2698maxOfb33U2AM(byte r0, byte r1, byte r2) {
        return UComparisonsKt.m2692maxOfKr8caGY(r0, UComparisonsKt.m2692maxOfKr8caGY(r1, r2));
    }

    /* JADX INFO: renamed from: maxOf-VKSA0NQ, reason: not valid java name */
    private static final short m2695maxOfVKSA0NQ(short r0, short r1, short r2) {
        return UComparisonsKt.m2690maxOf5PvTz6A(r0, UComparisonsKt.m2690maxOf5PvTz6A(r1, r2));
    }

    /* JADX INFO: renamed from: maxOf-Md2H83M, reason: not valid java name */
    public static final int m2693maxOfMd2H83M(int r3, int... r4) {
        Intrinsics.checkNotNullParameter(r4, PluralRules.KEYWORD_OTHER);
        int r0 = UIntArray.m1664getSizeimpl(r4);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3 = UComparisonsKt.m2691maxOfJ1ME1BU(r3, UIntArray.m1663getpVg5ArA(r4, r1));
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }

    /* JADX INFO: renamed from: maxOf-R03FKyM, reason: not valid java name */
    public static final long m2694maxOfR03FKyM(long r4, long... r6) {
        Intrinsics.checkNotNullParameter(r6, PluralRules.KEYWORD_OTHER);
        int r0 = ULongArray.m1743getSizeimpl(r6);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4 = UComparisonsKt.m2699maxOfeb3DHEI(r4, ULongArray.m1742getsVKNKU(r6, r1));
        r1 = r1 + 1;
        goto L3
    L5:
        return r4;
    }

    /* JADX INFO: renamed from: maxOf-Wr6uiD8, reason: not valid java name */
    public static final byte m2697maxOfWr6uiD8(byte r3, byte... r4) {
        Intrinsics.checkNotNullParameter(r4, PluralRules.KEYWORD_OTHER);
        int r0 = UByteArray.m1585getSizeimpl(r4);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3 = UComparisonsKt.m2692maxOfKr8caGY(r3, UByteArray.m1584getw2LRezQ(r4, r1));
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }

    /* JADX INFO: renamed from: maxOf-t1qELG4, reason: not valid java name */
    public static final short m2701maxOft1qELG4(short r3, short... r4) {
        Intrinsics.checkNotNullParameter(r4, PluralRules.KEYWORD_OTHER);
        int r0 = UShortArray.m1848getSizeimpl(r4);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3 = UComparisonsKt.m2690maxOf5PvTz6A(r3, UShortArray.m1847getMh2AYeg(r4, r1));
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }

    /* JADX INFO: renamed from: minOf-J1ME1BU, reason: not valid java name */
    public static final int m2703minOfJ1ME1BU(int r1, int r2) {
        if (Integer.compareUnsigned(r1, r2) > 0) goto L6;
        return r1;
    L6:
        return r2;
    }

    /* JADX INFO: renamed from: minOf-eb3DHEI, reason: not valid java name */
    public static final long m2711minOfeb3DHEI(long r1, long r3) {
        if (Long.compareUnsigned(r1, r3) > 0) goto L6;
        return r1;
    L6:
        return r3;
    }

    /* JADX INFO: renamed from: minOf-Kr8caGY, reason: not valid java name */
    public static final byte m2704minOfKr8caGY(byte r2, byte r3) {
        if (Intrinsics.compare(r2 & 255, r3 & 255) > 0) goto L6;
        return r2;
    L6:
        return r3;
    }

    /* JADX INFO: renamed from: minOf-5PvTz6A, reason: not valid java name */
    public static final short m2702minOf5PvTz6A(short r2, short r3) {
        if (Intrinsics.compare(r2 & 65535, 65535 & r3) > 0) goto L6;
        return r2;
    L6:
        return r3;
    }

    /* JADX INFO: renamed from: minOf-WZ9TVnA, reason: not valid java name */
    private static final int m2708minOfWZ9TVnA(int r0, int r1, int r2) {
        return UComparisonsKt.m2703minOfJ1ME1BU(r0, UComparisonsKt.m2703minOfJ1ME1BU(r1, r2));
    }

    /* JADX INFO: renamed from: minOf-sambcqE, reason: not valid java name */
    private static final long m2712minOfsambcqE(long r0, long r2, long r4) {
        return UComparisonsKt.m2711minOfeb3DHEI(r0, UComparisonsKt.m2711minOfeb3DHEI(r2, r4));
    }

    /* JADX INFO: renamed from: minOf-b33U2AM, reason: not valid java name */
    private static final byte m2710minOfb33U2AM(byte r0, byte r1, byte r2) {
        return UComparisonsKt.m2704minOfKr8caGY(r0, UComparisonsKt.m2704minOfKr8caGY(r1, r2));
    }

    /* JADX INFO: renamed from: minOf-VKSA0NQ, reason: not valid java name */
    private static final short m2707minOfVKSA0NQ(short r0, short r1, short r2) {
        return UComparisonsKt.m2702minOf5PvTz6A(r0, UComparisonsKt.m2702minOf5PvTz6A(r1, r2));
    }

    /* JADX INFO: renamed from: minOf-Md2H83M, reason: not valid java name */
    public static final int m2705minOfMd2H83M(int r3, int... r4) {
        Intrinsics.checkNotNullParameter(r4, PluralRules.KEYWORD_OTHER);
        int r0 = UIntArray.m1664getSizeimpl(r4);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3 = UComparisonsKt.m2703minOfJ1ME1BU(r3, UIntArray.m1663getpVg5ArA(r4, r1));
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }

    /* JADX INFO: renamed from: minOf-R03FKyM, reason: not valid java name */
    public static final long m2706minOfR03FKyM(long r4, long... r6) {
        Intrinsics.checkNotNullParameter(r6, PluralRules.KEYWORD_OTHER);
        int r0 = ULongArray.m1743getSizeimpl(r6);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4 = UComparisonsKt.m2711minOfeb3DHEI(r4, ULongArray.m1742getsVKNKU(r6, r1));
        r1 = r1 + 1;
        goto L3
    L5:
        return r4;
    }

    /* JADX INFO: renamed from: minOf-Wr6uiD8, reason: not valid java name */
    public static final byte m2709minOfWr6uiD8(byte r3, byte... r4) {
        Intrinsics.checkNotNullParameter(r4, PluralRules.KEYWORD_OTHER);
        int r0 = UByteArray.m1585getSizeimpl(r4);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3 = UComparisonsKt.m2704minOfKr8caGY(r3, UByteArray.m1584getw2LRezQ(r4, r1));
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }

    /* JADX INFO: renamed from: minOf-t1qELG4, reason: not valid java name */
    public static final short m2713minOft1qELG4(short r3, short... r4) {
        Intrinsics.checkNotNullParameter(r4, PluralRules.KEYWORD_OTHER);
        int r0 = UShortArray.m1848getSizeimpl(r4);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3 = UComparisonsKt.m2702minOf5PvTz6A(r3, UShortArray.m1847getMh2AYeg(r4, r1));
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }
}
