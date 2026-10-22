package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextScale extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    public TextScale() {
    }

    private void captureValues(@NonNull TransitionValues r2) {
        View r1 = r2.view;
        if ((r1 instanceof TextView) == false) goto L6;
        r2.values.put(PROPNAME_SCALE, Float.valueOf(((TextView) r1).getScaleX()));
        return;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(@NonNull ViewGroup r5, @Nullable TransitionValues r6, @Nullable TransitionValues r7) {
        if (r6 == null) goto L22;
        if (r7 != null) goto L6;
        return null;
    L6:
        if ((r6.view instanceof TextView) == false) goto L24;
        View r0 = r7.view;
        if ((r0 instanceof TextView) == false) goto L25;
        final TextView r1 = (TextView) r0;
        Map<String, Object> r8 = r6.values;
        Map<String, Object> r9 = r7.values;
        float r3 = 1.0f;
        if (r8.get(PROPNAME_SCALE) == null) goto L13;
        float r10 = ((Float) r8.get(PROPNAME_SCALE)).floatValue();
    L15:
        if (r9.get(PROPNAME_SCALE) == null) goto L18;
        r3 = ((Float) r9.get(PROPNAME_SCALE)).floatValue();
    L18:
        if (r10 != r3) goto L20;
        return null;
    L20:
        ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{r10, r3});
        r11.addUpdateListener(new AnonymousClass1(this, r1));
        return r11;
    L13:
        r10 = 1.0f;
        goto L15
    L25:
        return null;
    L24:
        return null;
    L22:
        return null;
    }
}
