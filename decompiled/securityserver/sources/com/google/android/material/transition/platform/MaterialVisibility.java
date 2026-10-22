package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.platform.VisibilityAnimatorProvider;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {
    private final P primaryAnimatorProvider;

    @Nullable
    private VisibilityAnimatorProvider secondaryAnimatorProvider;

    public MaterialVisibility(P r1, @Nullable VisibilityAnimatorProvider r2) {
        this.primaryAnimatorProvider = r1;
        this.secondaryAnimatorProvider = r2;
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    private Animator createAnimator(ViewGroup r4, View r5, boolean r6) {
        AnimatorSet r0 = new AnimatorSet();
        ArrayList r1 = new ArrayList();
        if (r6 == false) goto L5;
        Animator r2 = this.primaryAnimatorProvider.createAppear(r4, r5);
    L6:
        if (r2 == null) goto L8;
        r1.add(r2);
    L8:
        VisibilityAnimatorProvider r3 = this.secondaryAnimatorProvider;
        if (r3 == null) goto L15;
        if (r6 == false) goto L12;
        Animator r7 = r3.createAppear(r4, r5);
    L13:
        if (r7 == null) goto L15;
        r1.add(r7);
        goto L15
    L12:
        r7 = r3.createDisappear(r4, r5);
    L15:
        AnimatorSetCompat.playTogether(r0, r1);
        return r0;
    L5:
        r2 = this.primaryAnimatorProvider.createDisappear(r4, r5);
        goto L6
    }

    @NonNull
    public P getPrimaryAnimatorProvider() {
        return this.primaryAnimatorProvider;
    }

    @Nullable
    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return this.secondaryAnimatorProvider;
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup r1, View r2, TransitionValues r3, TransitionValues r4) {
        return createAnimator(r1, r2, true);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup r1, View r2, TransitionValues r3, TransitionValues r4) {
        return createAnimator(r1, r2, false);
    }

    public void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider r1) {
        this.secondaryAnimatorProvider = r1;
    }
}
