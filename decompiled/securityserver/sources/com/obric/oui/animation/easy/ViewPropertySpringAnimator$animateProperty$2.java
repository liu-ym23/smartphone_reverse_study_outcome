package com.obric.oui.animation.easy;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ViewPropertySpringAnimator$animateProperty$2 extends Lambda implements Function1<SpringAnimationConfig, Unit> {
    public static final ViewPropertySpringAnimator$animateProperty$2 b = null;

    static {
        b = new ViewPropertySpringAnimator$animateProperty$2(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r1) {
        Intrinsics.f((SpringAnimationConfig) r1, "$receiver");
        return Unit.f330a;
    }
}
