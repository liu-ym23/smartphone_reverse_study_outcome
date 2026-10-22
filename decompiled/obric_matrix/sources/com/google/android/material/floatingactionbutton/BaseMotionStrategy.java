package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class BaseMotionStrategy implements MotionStrategy {
    private final Context context;

    @Nullable
    private MotionSpec defaultMotionSpec;

    @NonNull
    private final ExtendedFloatingActionButton fab;
    private final ArrayList<Animator.AnimatorListener> listeners;

    @Nullable
    private MotionSpec motionSpec;
    private final AnimatorTracker tracker;

    BaseMotionStrategy(@NonNull ExtendedFloatingActionButton r2, AnimatorTracker r3) {
        this.listeners = new ArrayList();
        this.fab = r2;
        this.context = r2.getContext();
        this.tracker = r3;
    }

    static /* synthetic */ ExtendedFloatingActionButton access$000(BaseMotionStrategy r0) {
        return r0.fab;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void addAnimationListener(@NonNull Animator.AnimatorListener r1) {
        this.listeners.add(r1);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public AnimatorSet createAnimator() {
        return createAnimator(getCurrentMotionSpec());
    }

    @NonNull
    AnimatorSet createAnimator(@NonNull MotionSpec r7) {
        ArrayList r0 = new ArrayList();
        if (r7.hasPropertyValues("opacity") == false) goto L6;
        r0.add(r7.getAnimator("opacity", this.fab, View.ALPHA));
    L6:
        if (r7.hasPropertyValues("scale") == false) goto L9;
        r0.add(r7.getAnimator("scale", this.fab, View.SCALE_Y));
        r0.add(r7.getAnimator("scale", this.fab, View.SCALE_X));
    L9:
        if (r7.hasPropertyValues("width") == false) goto L12;
        r0.add(r7.getAnimator("width", this.fab, ExtendedFloatingActionButton.WIDTH));
    L12:
        if (r7.hasPropertyValues("height") == false) goto L15;
        r0.add(r7.getAnimator("height", this.fab, ExtendedFloatingActionButton.HEIGHT));
    L15:
        if (r7.hasPropertyValues("paddingStart") == false) goto L18;
        r0.add(r7.getAnimator("paddingStart", this.fab, ExtendedFloatingActionButton.PADDING_START));
    L18:
        if (r7.hasPropertyValues("paddingEnd") == false) goto L21;
        r0.add(r7.getAnimator("paddingEnd", this.fab, ExtendedFloatingActionButton.PADDING_END));
    L21:
        if (r7.hasPropertyValues("labelOpacity") == false) goto L23;
        final Class<Float> r4 = Float.class;
        final String r5 = "LABEL_OPACITY_PROPERTY";
        r0.add(r7.getAnimator("labelOpacity", this.fab, new AnonymousClass1(this, r4, r5)));
    L23:
        AnimatorSet r6 = new AnimatorSet();
        AnimatorSetCompat.playTogether(r6, r0);
        return r6;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final MotionSpec getCurrentMotionSpec() {
        MotionSpec r0 = this.motionSpec;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.defaultMotionSpec != null) goto L9;
        this.defaultMotionSpec = MotionSpec.createFromResource(this.context, getDefaultMotionSpecResource());
    L9:
        return (MotionSpec) Preconditions.checkNotNull(this.defaultMotionSpec);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @NonNull
    public final List<Animator.AnimatorListener> getListeners() {
        return this.listeners;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @Nullable
    public MotionSpec getMotionSpec() {
        return this.motionSpec;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @CallSuper
    public void onAnimationCancel() {
        this.tracker.clear();
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @CallSuper
    public void onAnimationEnd() {
        this.tracker.clear();
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @CallSuper
    public void onAnimationStart(Animator r1) {
        this.tracker.onNextAnimationStart(r1);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void removeAnimationListener(@NonNull Animator.AnimatorListener r1) {
        this.listeners.remove(r1);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void setMotionSpec(@Nullable MotionSpec r1) {
        this.motionSpec = r1;
    }
}
