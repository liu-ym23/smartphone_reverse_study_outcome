package com.obric.oui.animation.style;

import com.obric.oui.animation.easy.SpringAnimationConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class CommonStyleKt$windowBottomHide$spring$1 extends Lambda implements Function1<SpringAnimationConfig, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r2) {
        SpringAnimationConfig r3 = (SpringAnimationConfig) r2;
        Intrinsics.f(r3, "$receiver");
        r3.f157d = true;
        r3.f = 1.0f;
        r3.g = true;
        r3.i = 480.0f;
        return Unit.f330a;
    }
}
