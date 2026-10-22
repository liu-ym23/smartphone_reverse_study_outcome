package com.obric.common.oea.foundation.animation.spec.spring;

import android.graphics.Color;
import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class IntSpringSpec implements AnimationSpec<Integer> {
    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public final float a(long r1, Number r3, Number r4, float r5) {
        f(r3.intValue(), r4.intValue());
        throw null;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public final /* bridge */ /* synthetic */ long b(float r1, Object r2, Object r3) {
        f(((Number) r2).intValue(), ((Number) r3).intValue());
        throw null;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public final String c() {
        return "IntSpringSpec(dampingRatio: 0.0, stiffness: 0.0, delay: 0, visibilityThreshold: 0.0, delta: 0.0)";
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public final Object d(long r1, Number r3, Number r4, float r5) {
        f(r3.intValue(), r4.intValue());
        throw null;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public final boolean e(long r5, long r7) {
        if (r5 < ((((long) 0) * 1000000) + r7)) goto L6;
        return true;
    L6:
        return false;
    }

    public final long f(int r1, int r2) {
        Color.alpha(r1);
        Color.alpha(r2);
        Color.red(r1);
        Color.red(r2);
        Color.green(r1);
        Color.green(r2);
        Color.blue(r1);
        Color.blue(r2);
        throw null;
    }
}
