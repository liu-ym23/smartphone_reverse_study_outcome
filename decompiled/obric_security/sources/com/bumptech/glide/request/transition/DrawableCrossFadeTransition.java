package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

/* JADX INFO: loaded from: classes.dex */
public class DrawableCrossFadeTransition implements Transition<Drawable> {
    private final int duration;
    private final boolean isCrossFadeEnabled;

    @Override // com.bumptech.glide.request.transition.Transition
    public /* bridge */ /* synthetic */ boolean transition(Drawable r1, Transition.ViewAdapter r2) {
        return transition2(r1, r2);
    }

    public DrawableCrossFadeTransition(int r1, boolean r2) {
        this.duration = r1;
        this.isCrossFadeEnabled = r2;
    }

    /* JADX INFO: renamed from: transition, reason: avoid collision after fix types in other method */
    public boolean transition2(Drawable r5, Transition.ViewAdapter r6) {
        Drawable r0 = r6.getCurrentDrawable();
        if (r0 != null) goto L5;
        r0 = new ColorDrawable(0);
    L5:
        TransitionDrawable r2 = new TransitionDrawable(new Drawable[]{r0, r5});
        r2.setCrossFadeEnabled(this.isCrossFadeEnabled);
        r2.startTransition(this.duration);
        r6.setDrawable(r2);
        return true;
    }
}
