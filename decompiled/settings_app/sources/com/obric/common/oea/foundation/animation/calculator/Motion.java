package com.obric.common.oea.foundation.animation.calculator;

import com.bytedance.apm.trace.fps.RealFpsTracer;
import kotlin.Metadata;

/* JADX INFO: compiled from: SpringSimulation.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/obric/common/oea/foundation/animation/calculator/Motion;", "", "packedValue", "", "(J)V", "getPackedValue", "()J", "value", "", "getValue", "()F", RealFpsTracer.SCROLL_VELOCITY, "getVelocity", "copy", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class Motion {
    private final long packedValue;

    public Motion(long r1) {
        this.packedValue = r1;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public final float getValue() {
        return Float.intBitsToFloat((int) (this.packedValue >> 32));
    }

    public final float getVelocity() {
        return Float.intBitsToFloat((int) (this.packedValue & 4294967295L));
    }

    public static /* synthetic */ Motion copy$default(Motion r0, float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.getValue();
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.getVelocity();
    L9:
        return r0.copy(r1, r2);
    }

    public final Motion copy(float r1, float r2) {
        return SpringSimulationKt.Motion(r1, r2);
    }
}
