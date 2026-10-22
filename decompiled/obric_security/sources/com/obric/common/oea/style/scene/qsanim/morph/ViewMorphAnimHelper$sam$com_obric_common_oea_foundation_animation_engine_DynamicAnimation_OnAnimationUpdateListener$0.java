package com.obric.common.oea.style.scene.qsanim.morph;

import com.obric.common.oea.foundation.animation.engine.DynamicAnimation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewMorphAnimHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final class ViewMorphAnimHelper$sam$com_obric_common_oea_foundation_animation_engine_DynamicAnimation_OnAnimationUpdateListener$0 implements DynamicAnimation.OnAnimationUpdateListener {
    private final /* synthetic */ Function3 function;

    ViewMorphAnimHelper$sam$com_obric_common_oea_foundation_animation_engine_DynamicAnimation_OnAnimationUpdateListener$0(Function3 r1) {
        this.function = r1;
    }

    @Override // com.obric.common.oea.foundation.animation.engine.DynamicAnimation.OnAnimationUpdateListener
    public final /* synthetic */ void onAnimationUpdate(DynamicAnimation r1, float r2, float r3) {
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(r1, Float.valueOf(r2), Float.valueOf(r3)), "invoke(...)");
    }
}
