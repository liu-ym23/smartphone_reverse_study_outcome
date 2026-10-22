package com.obric.oui.animation.easy;

import com.obric.oui.animation.engine.DynamicAnimation;
import com.obric.oui.animation.engine.SpringAnimation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SpringAnimationConfig$onEnd$1 implements DynamicAnimation.OnAnimationEndListener {
    @Override // com.obric.oui.animation.engine.DynamicAnimation.OnAnimationEndListener
    public final void a(DynamicAnimation r1, boolean r2) {
        if (r1 == null) goto L4;
        SpringAnimation r3 = (SpringAnimation) r1;
        throw null;
    L4:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.animation.engine.SpringAnimation");
    }
}
