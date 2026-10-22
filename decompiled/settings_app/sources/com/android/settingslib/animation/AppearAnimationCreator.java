package com.android.settingslib.animation;

import android.animation.AnimatorListenerAdapter;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public interface AppearAnimationCreator<T> {
    void createAnimation(T r1, long r2, long r4, float r6, boolean r7, Interpolator r8, Runnable r9);

    default void createAnimation(T r1, long r2, long r4, float r6, boolean r7, Interpolator r8, Runnable r9, AnimatorListenerAdapter r10) {
    }
}
