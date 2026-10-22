package com.obric.oui.slider;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TickMarkSeekBar$anchorPoint$$inlined$apply$lambda$1 implements Animator.AnimatorListener {
    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
        Intrinsics.f(r1, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r1) {
        Intrinsics.f(r1, "animation");
        int r0 = TickMarkSeekBar.t;
        throw null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
        Intrinsics.f(r1, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
        Intrinsics.f(r1, "animation");
    }
}
