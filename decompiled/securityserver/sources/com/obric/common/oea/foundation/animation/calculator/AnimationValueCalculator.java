package com.obric.common.oea.foundation.animation.calculator;

import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface AnimationValueCalculator<T> {
    Object a(long r1, Object r3, Object r4, float r5, AnimationSpec r6);

    float b(long r1, Object r3, Object r4, float r5, AnimationSpec r6);

    boolean c(long r1, long r3, AnimationSpec r5);
}
