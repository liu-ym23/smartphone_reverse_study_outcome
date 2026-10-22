package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes.dex */
public class ViewAnimationFactory<R> implements TransitionFactory<R> {
    private Transition<R> transition;
    private final ViewTransition.ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    private static class ConcreteViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {
        private final Animation animation;

        ConcreteViewTransitionAnimationFactory(Animation r1) {
            this.animation = r1;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public Animation build(Context r1) {
            return this.animation;
        }
    }

    private static class ResourceViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {
        private final int animationId;

        ResourceViewTransitionAnimationFactory(int r1) {
            this.animationId = r1;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public Animation build(Context r1) {
            return AnimationUtils.loadAnimation(r1, this.animationId);
        }
    }

    public ViewAnimationFactory(Animation r2) {
        this(new ConcreteViewTransitionAnimationFactory(r2));
    }

    public ViewAnimationFactory(int r2) {
        this(new ResourceViewTransitionAnimationFactory(r2));
    }

    ViewAnimationFactory(ViewTransition.ViewTransitionAnimationFactory r1) {
        this.viewTransitionAnimationFactory = r1;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource r2, boolean r3) {
        if (r2 == DataSource.MEMORY_CACHE) goto L12;
        if (r3 == false) goto L12;
        if (this.transition != null) goto L10;
        this.transition = new ViewTransition(this.viewTransitionAnimationFactory);
    L10:
        return this.transition;
    L12:
        return NoTransition.get();
    }
}
