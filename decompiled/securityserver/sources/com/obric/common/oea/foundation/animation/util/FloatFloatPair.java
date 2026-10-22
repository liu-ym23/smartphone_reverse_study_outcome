package com.obric.common.oea.foundation.animation.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FloatFloatPair {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f130a;

    public FloatFloatPair(float r5, float r6) {
        long r0 = Float.floatToRawIntBits(r5);
        this.f130a = (((long) Float.floatToRawIntBits(r6)) & 4294967295L) | (r0 << 32);
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("(");
        long r2 = this.f130a;
        r0.append(Float.intBitsToFloat((int) (r2 >> 32)));
        r0.append(", ");
        r0.append(Float.intBitsToFloat((int) (r2 & 4294967295L)));
        r0.append(')');
        return r0.toString();
    }
}
