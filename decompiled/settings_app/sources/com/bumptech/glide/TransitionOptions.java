package com.bumptech.glide;

import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

/* JADX INFO: loaded from: classes.dex */
public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    private TransitionFactory<? super TranscodeType> transitionFactory;

    private CHILD self() {
        return this;
    }

    public TransitionOptions() {
        this.transitionFactory = NoTransition.getFactory();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m885clone() throws CloneNotSupportedException {
        return clone();
    }

    public final CHILD dontTransition() {
        return (CHILD) transition(NoTransition.getFactory());
    }

    public final CHILD transition(int r2) {
        return (CHILD) transition(new ViewAnimationFactory(r2));
    }

    public final CHILD transition(ViewPropertyTransition.Animator r2) {
        return (CHILD) transition(new ViewPropertyAnimationFactory(r2));
    }

    public final CHILD transition(TransitionFactory<? super TranscodeType> r1) {
        this.transitionFactory = (TransitionFactory) Preconditions.checkNotNull(r1);
        return (CHILD) self();
    }

    public final CHILD clone() {
        return (CHILD) super.clone();
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    final TransitionFactory<? super TranscodeType> getTransitionFactory() {
        return this.transitionFactory;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof TransitionOptions) == true) goto L5;
        return false;
    L5:
        return Util.bothNullOrEqual(this.transitionFactory, ((TransitionOptions) r2).transitionFactory);
    }

    public int hashCode() {
        TransitionFactory<? super TranscodeType> r0 = this.transitionFactory;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }
}
