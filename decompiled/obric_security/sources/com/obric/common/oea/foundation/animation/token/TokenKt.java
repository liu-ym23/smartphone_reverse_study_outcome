package com.obric.common.oea.foundation.animation.token;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Token.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002¨\u0006\u0005"}, d2 = {"toCubicBezierEasing", "Lcom/obric/common/oea/foundation/animation/token/CubicBezierEasing;", "Lcom/obric/common/oea/foundation/animation/token/Token$Easing;", "toLinearEasing", "Lcom/obric/common/oea/foundation/animation/token/Easing;", "foundation_standardRelease"}, k = 2, mv = {1, 4, 3})
public final class TokenKt {
    public static final CubicBezierEasing toCubicBezierEasing(Token.Easing r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toCubicBezierEasing");
        if (r5.getValues().length != 4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return new CubicBezierEasing(r5.getValues()[0], r5.getValues()[1], r5.getValues()[2], r5.getValues()[3]);
    L10:
        throw new IllegalArgumentException("Easing values must contain exactly 4 floats for cubic bezier.".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final Easing toLinearEasing(Token.Easing r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toLinearEasing");
        return AnonymousClass1.INSTANCE;
    }
}
