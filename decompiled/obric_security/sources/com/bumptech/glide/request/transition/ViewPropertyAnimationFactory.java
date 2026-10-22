package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes.dex */
public class ViewPropertyAnimationFactory<R> implements TransitionFactory<R> {
    private ViewPropertyTransition<R> animation;
    private final ViewPropertyTransition.Animator animator;

    public ViewPropertyAnimationFactory(ViewPropertyTransition.Animator r1) {
        this.animator = r1;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource r2, boolean r3) {
        if (r2 == DataSource.MEMORY_CACHE) goto L12;
        if (r3 == false) goto L12;
        if (this.animation != null) goto L10;
        this.animation = new ViewPropertyTransition(this.animator);
    L10:
        return this.animation;
    L12:
        return NoTransition.get();
    }
}
