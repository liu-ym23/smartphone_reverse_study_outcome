package com.obric.common.oea.foundation.animation.calculator;

import com.bytedance.apm.trace.fps.RealFpsTracer;
import kotlin.Metadata;

/* JADX INFO: compiled from: SpringSimulation.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\u0011\u0010\n\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u000bH\u0086\b\u001a\u0011\u0010\f\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u000bH\u0086\b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"UNSET", "", "getUNSET", "()F", "VelocityThresholdMultiplier", "", "Motion", "Lcom/obric/common/oea/foundation/animation/calculator/Motion;", "value", RealFpsTracer.SCROLL_VELOCITY, "unpackFloat1", "", "unpackFloat2", "foundation_standardRelease"}, k = 2, mv = {1, 4, 3})
public final class SpringSimulationKt {
    private static final float UNSET = Float.MAX_VALUE;
    private static final double VelocityThresholdMultiplier = 62.5d;

    static {
    }

    public static final Motion Motion(float r5, float r6) {
        long r1 = Float.floatToRawIntBits(r5);
        return new Motion((((long) Float.floatToRawIntBits(r6)) & 4294967295L) | (r1 << 32));
    }

    public static final float getUNSET() {
        return UNSET;
    }

    public static final float unpackFloat1(long r1) {
        return Float.intBitsToFloat((int) (r1 >> 32));
    }

    public static final float unpackFloat2(long r2) {
        return Float.intBitsToFloat((int) (r2 & 4294967295L));
    }
}
