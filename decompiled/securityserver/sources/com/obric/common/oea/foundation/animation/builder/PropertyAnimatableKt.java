package com.obric.common.oea.foundation.animation.builder;

import android.view.View;
import com.obric.common.oea.foundation.animation.token.OEasingKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PropertyAnimatableKt {
    public static PropertyAnimatable.Builder a(View r2) {
        Intrinsics.f(r2, "$this$animator");
        PropertyAnimatable.Builder r0 = new PropertyAnimatable.Builder(r2);
        if (1.0f <= 0) goto L6;
        r0.f104a = 1.0f;
        r0.b = 90.0f;
        return r0;
    L6:
        int r3 = OEasingKt.f129a;
        throw new IllegalArgumentException("animationSpeed必须大于 0");
    }
}
