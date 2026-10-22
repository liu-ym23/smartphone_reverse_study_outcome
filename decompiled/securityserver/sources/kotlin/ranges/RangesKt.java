package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RangesKt extends RangesKt___RangesKt {
    public static float a(float r2, float r3, float r4) {
        if (r3 > r4) goto L12;
        if (r2 >= r3) goto L8;
        return r3;
    L8:
        if (r2 > r4) goto L10;
        return r2;
    L10:
        return r4;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r4 + " is less than minimum " + r3 + '.');
    }

    public static int b(int r2, int r3, int r4) {
        if (r3 > r4) goto L9;
        if (r2 < r3) goto L10;
        if (r2 > r4) goto L7;
        return r2;
    L7:
        return r4;
    L10:
        return r3;
    L9:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r4 + " is less than minimum " + r3 + '.');
    }

    public static long c(long r3, long r5) {
        if (0 > r5) goto L12;
        if (r3 >= 0) goto L8;
        return 0;
    L8:
        if (r3 > r5) goto L10;
        return r3;
    L10:
        return r5;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r5 + " is less than minimum 0.");
    }

    public static IntProgression d(IntProgression r2, int r3) {
        Intrinsics.f(r2, "<this>");
        if (r3 <= 0) goto L5;
        boolean r0 = true;
    L6:
        Integer r1 = Integer.valueOf(r3);
        if (r0 == false) goto L15;
        if (r2.e > 0) goto L13;
        r3 = -r3;
    L13:
        return new IntProgression(r2.b, r2.c, r3);
    L15:
        throw new IllegalArgumentException("Step must be positive, was: " + r1 + '.');
    L5:
        r0 = false;
        goto L6
    }

    public static IntRange e(int r2, int r3) {
        if (r3 > Integer.MIN_VALUE) goto L6;
        return IntRange.f;
    L6:
        return new IntRange(r2, r3 - 1, 1);
    }
}
