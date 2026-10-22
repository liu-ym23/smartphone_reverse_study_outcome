package org.apache.commons.math3.primes;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
class PollardRho {
    private PollardRho() {
    }

    public static List<Integer> primeFactors(int r3) {
        ArrayList r0 = new ArrayList();
        int r4 = SmallPrimes.smallTrialDivision(r3, r0);
        if (1 != r4) goto L6;
        return r0;
    L6:
        if (SmallPrimes.millerRabinPrimeTest(r4) == false) goto L9;
        r0.add(Integer.valueOf(r4));
        return r0;
    L9:
        int r1 = rhoBrent(r4);
        r0.add(Integer.valueOf(r1));
        r0.add(Integer.valueOf(r4 / r1));
        return r0;
    }

    static int rhoBrent(int r18) {
        int r1 = SmallPrimes.PRIMES_LAST;
        int r4 = 2;
        int r5 = 1;
    L3:
        int r6 = 0;
        int r8 = r4;
        int r7 = 0;
    L4:
        if (r7 >= r5) goto L6;
        long r9 = r8;
        r8 = (int) (((r9 * r9) + ((long) r1)) % ((long) r18));
        r7 = r7 + 1;
    L6:
        int r10 = FastMath.min(25, r5 - r6);
        int r11 = -3;
        int r12 = 1;
    L7:
        if (r11 >= r10) goto L16;
        long r13 = r8;
        long r14 = r18;
        r8 = (int) (((r13 * r13) + ((long) r1)) % r14);
        long r15 = FastMath.abs(r4 - r8);
        if (0 == r15) goto L10;
        r12 = (int) ((((long) r12) * r15) % r14);
        if (r12 == 0) goto L14;
        r11 = r11 + 1;
        goto L7
    L14:
        return gcdPositive(FastMath.abs((int) r15), r18);
    L10:
        r1 = r1 + SmallPrimes.PRIMES_LAST;
        r6 = -25;
        r5 = 1;
        r8 = 2;
    L16:
        int r2 = gcdPositive(FastMath.abs(r12), r18);
        if (1 != r2) goto L18;
        r6 = r6 + 25;
        if (r6 < r5) goto L6;
        r5 = r5 * 2;
        r4 = r8;
        goto L3
    L18:
        return r2;
    }

    static int gcdPositive(int r2, int r3) {
        if (r2 != 0) goto L4;
        return r3;
    L4:
        if (r3 != 0) goto L6;
        return r2;
    L6:
        int r0 = Integer.numberOfTrailingZeros(r2);
        int r4 = r2 >> r0;
        int r1 = Integer.numberOfTrailingZeros(r3);
        int r5 = r3 >> r1;
        int r6 = FastMath.min(r0, r1);
    L7:
        if (r4 == r5) goto L10;
        int r7 = r4 - r5;
        r5 = FastMath.min(r4, r5);
        int r8 = FastMath.abs(r7);
        r4 = r8 >> Integer.numberOfTrailingZeros(r8);
        goto L7
    L10:
        return r4 << r6;
    }
}
