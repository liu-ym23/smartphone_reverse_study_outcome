package com.bumptech.glide;

import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

/* JADX INFO: loaded from: classes.dex */
public final class GenericTransitionOptions<TranscodeType> extends TransitionOptions<GenericTransitionOptions<TranscodeType>, TranscodeType> {
    public GenericTransitionOptions() {
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> withNoTransition() {
        return new GenericTransitionOptions().dontTransition();
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(int r1) {
        return new GenericTransitionOptions().transition(r1);
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(ViewPropertyTransition.Animator r1) {
        return new GenericTransitionOptions().transition(r1);
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(TransitionFactory<? super TranscodeType> r1) {
        return new GenericTransitionOptions().transition(r1);
    }

    @Override // com.bumptech.glide.TransitionOptions
    public boolean equals(Object r2) {
        if ((r2 instanceof GenericTransitionOptions) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.equals(r2) == false) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.TransitionOptions
    public int hashCode() {
        return super.hashCode();
    }
}
