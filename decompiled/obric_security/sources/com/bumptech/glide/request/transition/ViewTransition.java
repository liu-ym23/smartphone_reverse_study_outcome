package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes.dex */
public class ViewTransition<R> implements Transition<R> {
    private final ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    interface ViewTransitionAnimationFactory {
        Animation build(Context r1);
    }

    ViewTransition(ViewTransitionAnimationFactory r1) {
        this.viewTransitionAnimationFactory = r1;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(R r1, Transition.ViewAdapter r2) {
        View r3 = r2.getView();
        if (r3 == null) goto L7;
        r3.clearAnimation();
        r3.startAnimation(this.viewTransitionAnimationFactory.build(r3.getContext()));
        return false;
    L7:
        return false;
    }
}
