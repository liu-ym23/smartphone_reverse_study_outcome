package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MathUtils {

    @NotNull
    public static final MathUtils INSTANCE = null;

    static {
        INSTANCE = new MathUtils();
    }

    private MathUtils() {
    }

    public final double keepDecimal(double r5, int r7) {
        double r0 = Math.pow(10.0d, r7);
        return Math.floor(r5 * r0) / r0;
    }

    public final double keepTwoDecimal(double r3) {
        double r0 = 100;
        return Math.floor(r3 * r0) / r0;
    }

    public final float limit(float r1, float r2, float r3) {
        return Math.min(r3, Math.max(r1, r2));
    }

    public final int limit(int r1, int r2, int r3) {
        return Math.min(r3, Math.max(r1, r2));
    }

    public final long limit(long r1, long r3, long r5) {
        return Math.min(r5, Math.max(r1, r3));
    }

    public final double limit(double r1, double r3, double r5) {
        return Math.min(r5, Math.max(r1, r3));
    }
}
