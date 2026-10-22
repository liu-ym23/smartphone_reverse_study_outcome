package com.bytedanceos.rotateview;

import android.os.SystemClock;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class RandomUtils {
    public static final Random RAND = null;

    public RandomUtils() {
    }

    static {
        RAND = new Random(SystemClock.elapsedRealtime());
    }

    public static int getRandomRange(int range) {
        if (range != 0) goto L5;
        return 0;
    L5:
        if (range >= 0) goto L8;
        range = -range;
    L8:
        return RAND.nextInt(range * 2) - range;
    }

    public static float getRandomRange(float range) {
        return ((RAND.nextFloat() * 2.0f) - 1.0f) * range;
    }

    public static int getRandomValue(int base, int range) {
        return base + getRandomRange(range);
    }

    public static float getRandomValue(float base, float range) {
        return base + getRandomRange(range);
    }

    public static int getRandomRange(int start, int end) {
        return (int) ((Math.random() * ((double) (end - start))) + ((double) start));
    }
}
