package com.obric.common.oea.foundation.animation.spec.tween;

import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import com.obric.common.oea.foundation.animation.token.TokenKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class IntTweenSpec implements AnimationSpec<Integer> {
    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public final float a(long r5, Number r7, Number r8, float r9) {
        r7.intValue();
        r8.intValue();
        long r10 = ((long) 0) * 1000000;
        long r4 = RangesKt.c(r5 - r10, r10);
        if (r4 >= 0) goto L5;
        return 0.0f;
    L5:
        if (r4 == 0) goto L9;
        RangesKt.c((r4 - 1000000) - r10, r10);
        TokenKt.a();
        throw null;
    L9:
        return r9;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public final long b(float r1, Object r2, Object r3) {
        ((Number) r2).intValue();
        ((Number) r3).intValue();
        return ((long) 0) * 1000000;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public final String c() {
        return "IntTweenSpec(durationMillis: 0, delay: 0, easing: null, isColor: false)";
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public final Object d(long r3, Number r5, Number r6, float r7) {
        r5.intValue();
        r6.intValue();
        long r8 = ((long) 0) * 1000000;
        RangesKt.c(r3 - r8, r8);
        TokenKt.a();
        throw null;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public final boolean e(long r5, long r7) {
        if (r5 < ((((long) 0) * 1000000) + r7)) goto L6;
        return true;
    L6:
        return false;
    }
}
