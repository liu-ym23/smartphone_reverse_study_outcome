package com.bumptech.glide.request.transition;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ViewPropertyTransition<R> implements Transition<R> {
    private final Animator animator;

    public interface Animator {
        void animate(View r1);
    }

    public ViewPropertyTransition(Animator r1) {
        this.animator = r1;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(R r1, Transition.ViewAdapter r2) {
        if (r2.getView() == null) goto L7;
        this.animator.animate(r2.getView());
        return false;
    L7:
        return false;
    }
}
