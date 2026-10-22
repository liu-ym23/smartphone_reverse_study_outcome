package org.apache.commons.math3.random;

import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public class RandomGeneratorFactory {
    private RandomGeneratorFactory() {
    }

    public static RandomGenerator createRandomGenerator(final Random r1) {
        return new AnonymousClass1(r1);
    }

    public static long convertToLong(int[] r7) {
        int r0 = r7.length;
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1 = (r1 * 4294967291L) + ((long) r7[r3]);
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }
}
