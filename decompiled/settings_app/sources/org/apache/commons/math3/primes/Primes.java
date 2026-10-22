package org.apache.commons.math3.primes;

import java.util.List;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class Primes {
    private Primes() {
    }

    public static boolean isPrime(int r6) {
        if (r6 >= 2) goto L5;
        return false;
    L5:
        int[] r0 = SmallPrimes.PRIMES;
        int r2 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L14;
        int r4 = r0[r3];
        if ((r6 % r4) == 0) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        if (r6 != r4) goto L17;
        return true;
    L17:
        return false;
    L14:
        return SmallPrimes.millerRabinPrimeTest(r6);
    }

    public static int nextPrime(int r5) {
        if (r5 < 0) goto L24;
        if (r5 != 2) goto L6;
        return 2;
    L6:
        int r6 = r5 | 1;
        if (r6 != 1) goto L10;
        return 2;
    L10:
        if (isPrime(r6) == false) goto L12;
        return r6;
    L12:
        int r1 = r6 % 3;
        if (r1 != 0) goto L15;
        int r7 = r6 + 2;
    L18:
        if (isPrime(r7) == true) goto L19;
        int r8 = r7 + 2;
        if (isPrime(r8) == true) goto L22;
    L16:
        r7 = r8 + 4;
        goto L18
    L22:
        return r8;
    L19:
        return r7;
    L15:
        if (1 == r1) goto L16;
        r7 = r6 + 4;
        goto L18
    L24:
        throw new MathIllegalArgumentException(LocalizedFormats.NUMBER_TOO_SMALL, new Object[]{Integer.valueOf(r5), 0});
    }

    public static List<Integer> primeFactors(int r5) {
        if (r5 < 2) goto L7;
        return SmallPrimes.trialDivision(r5);
    L7:
        throw new MathIllegalArgumentException(LocalizedFormats.NUMBER_TOO_SMALL, new Object[]{Integer.valueOf(r5), 2});
    }
}
