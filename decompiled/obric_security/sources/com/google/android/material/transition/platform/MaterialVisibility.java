package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.platform.VisibilityAnimatorProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {
    private final List<VisibilityAnimatorProvider> additionalAnimatorProviders;
    private final P primaryAnimatorProvider;
    private VisibilityAnimatorProvider secondaryAnimatorProvider;

    protected MaterialVisibility(P r2, VisibilityAnimatorProvider r3) {
        this.additionalAnimatorProviders = new ArrayList();
        this.primaryAnimatorProvider = r2;
        this.secondaryAnimatorProvider = r3;
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    public P getPrimaryAnimatorProvider() {
        return this.primaryAnimatorProvider;
    }

    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return this.secondaryAnimatorProvider;
    }

    public void setSecondaryAnimatorProvider(VisibilityAnimatorProvider r1) {
        this.secondaryAnimatorProvider = r1;
    }

    public void addAdditionalAnimatorProvider(VisibilityAnimatorProvider r1) {
        this.additionalAnimatorProviders.add(r1);
    }

    public boolean removeAdditionalAnimatorProvider(VisibilityAnimatorProvider r1) {
        return this.additionalAnimatorProviders.remove(r1);
    }

    public void clearAdditionalAnimatorProvider() {
        this.additionalAnimatorProviders.clear();
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup r1, View r2, TransitionValues r3, TransitionValues r4) {
        return createAnimator(r1, r2, true);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup r1, View r2, TransitionValues r3, TransitionValues r4) {
        return createAnimator(r1, r2, false);
    }

    private Animator createAnimator(ViewGroup r4, View r5, boolean r6) {
        AnimatorSet r0 = new AnimatorSet();
        ArrayList r1 = new ArrayList();
        addAnimatorIfNeeded(r1, this.primaryAnimatorProvider, r4, r5, r6);
        addAnimatorIfNeeded(r1, this.secondaryAnimatorProvider, r4, r5, r6);
        Iterator<VisibilityAnimatorProvider> r3 = this.additionalAnimatorProviders.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        addAnimatorIfNeeded(r1, r3.next(), r4, r5, r6);
        goto L4
    L6:
        AnimatorSetCompat.playTogether(r0, r1);
        return r0;
    }

    private static void addAnimatorIfNeeded(List<Animator> r0, VisibilityAnimatorProvider r1, ViewGroup r2, View r3, boolean r4) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r4 == false) goto L6;
        Animator r5 = r1.createAppear(r2, r3);
    L7:
        if (r5 == null) goto L10;
        r0.add(r5);
        return;
    L10:
        return;
    L6:
        r5 = r1.createDisappear(r2, r3);
        goto L7
    }
}
