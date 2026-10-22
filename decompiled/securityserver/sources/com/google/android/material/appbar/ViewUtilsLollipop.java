package com.google.android.material.appbar;

import android.R;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.internal.ThemeEnforcement;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class ViewUtilsLollipop {
    private static final int[] STATE_LIST_ANIM_ATTRS = null;

    static {
        STATE_LIST_ANIM_ATTRS = new int[]{R.attr.stateListAnimator};
    }

    public ViewUtilsLollipop() {
    }

    public static void setBoundsViewOutlineProvider(@NonNull View r1) {
        r1.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    public static void setDefaultAppBarLayoutStateListAnimator(@NonNull View r11, float r12) {
        int r0 = r11.getResources().getInteger(com.google.android.material.R.integer.app_bar_elevation_anim_duration);
        StateListAnimator r1 = new StateListAnimator();
        long r9 = r0;
        r1.addState(new int[]{R.attr.enabled, com.google.android.material.R.attr.state_liftable, -com.google.android.material.R.attr.state_lifted}, ObjectAnimator.ofFloat(r11, "elevation", new float[]{0.0f}).setDuration(r9));
        r1.addState(new int[]{R.attr.enabled}, ObjectAnimator.ofFloat(r11, "elevation", new float[]{r12}).setDuration(r9));
        r1.addState(new int[0], ObjectAnimator.ofFloat(r11, "elevation", new float[]{0.0f}).setDuration(0));
        r11.setStateListAnimator(r1);
    }

    public static void setStateListAnimatorFromAttrs(@NonNull View r8, AttributeSet r9, int r10, int r11) {
        Context r6 = r8.getContext();
        TypedArray r12 = ThemeEnforcement.obtainStyledAttributes(r6, r9, STATE_LIST_ANIM_ATTRS, r10, r11, new int[0]);
    L7:
        th = move-exception;
        r12.recycle();
        throw th;
    L4:
        if (r12.hasValue(0) == false) goto L9;
        r8.setStateListAnimator(AnimatorInflater.loadStateListAnimator(r6, r12.getResourceId(0, 0)));     // Catch: Throwable -> L7
    L9:
        r12.recycle();
    }
}
