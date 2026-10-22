package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class TextScale extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    public TextScale() {
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r1) {
        captureValues(r1);
    }

    private void captureValues(TransitionValues r2) {
        if ((r2.view instanceof TextView) == false) goto L6;
        TextView r1 = (TextView) r2.view;
        r2.values.put(PROPNAME_SCALE, Float.valueOf(r1.getScaleX()));
        return;
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup r5, TransitionValues r6, TransitionValues r7) {
        if (r6 == null) goto L22;
        if (r7 != null) goto L6;
        return null;
    L6:
        if ((r6.view instanceof TextView) == true) goto L8;
        return null;
    L8:
        if ((r7.view instanceof TextView) == false) goto L25;
        final TextView r0 = (TextView) r7.view;
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
        r11.addUpdateListener(new AnonymousClass1(this, r0));
        return r11;
    L13:
        r10 = 1.0f;
        goto L15
    L25:
        return null;
    L22:
        return null;
    }
}
