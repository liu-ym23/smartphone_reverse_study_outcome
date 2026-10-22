package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public final class ScaleProvider implements VisibilityAnimatorProvider {
    private boolean growing;
    private float incomingEndScale;
    private float incomingStartScale;
    private float outgoingEndScale;
    private float outgoingStartScale;
    private boolean scaleOnDisappear;

    public ScaleProvider() {
        this(true);
    }

    public ScaleProvider(boolean r3) {
        this.outgoingStartScale = 1.0f;
        this.outgoingEndScale = 1.1f;
        this.incomingStartScale = 0.8f;
        this.incomingEndScale = 1.0f;
        this.scaleOnDisappear = true;
        this.growing = r3;
    }

    public boolean isGrowing() {
        return this.growing;
    }

    public void setGrowing(boolean r1) {
        this.growing = r1;
    }

    public boolean isScaleOnDisappear() {
        return this.scaleOnDisappear;
    }

    public void setScaleOnDisappear(boolean r1) {
        this.scaleOnDisappear = r1;
    }

    public float getOutgoingStartScale() {
        return this.outgoingStartScale;
    }

    public void setOutgoingStartScale(float r1) {
        this.outgoingStartScale = r1;
    }

    public float getOutgoingEndScale() {
        return this.outgoingEndScale;
    }

    public void setOutgoingEndScale(float r1) {
        this.outgoingEndScale = r1;
    }

    public float getIncomingStartScale() {
        return this.incomingStartScale;
    }

    public void setIncomingStartScale(float r1) {
        this.incomingStartScale = r1;
    }

    public float getIncomingEndScale() {
        return this.incomingEndScale;
    }

    public void setIncomingEndScale(float r1) {
        this.incomingEndScale = r1;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    public Animator createAppear(ViewGroup r1, View r2) {
        if (this.growing == false) goto L7;
        return createScaleAnimator(r2, this.incomingStartScale, this.incomingEndScale);
    L7:
        return createScaleAnimator(r2, this.outgoingEndScale, this.outgoingStartScale);
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    public Animator createDisappear(ViewGroup r1, View r2) {
        if (this.scaleOnDisappear == true) goto L7;
        return null;
    L7:
        if (this.growing == false) goto L11;
        return createScaleAnimator(r2, this.outgoingStartScale, this.outgoingEndScale);
    L11:
        return createScaleAnimator(r2, this.incomingEndScale, this.incomingStartScale);
    }

    private static Animator createScaleAnimator(final View r9, float r10, float r11) {
        final float r0 = r9.getScaleX();
        final float r1 = r9.getScaleY();
        ObjectAnimator r12 = ObjectAnimator.ofPropertyValuesHolder(r9, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{r0 * r10, r0 * r11}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{r10 * r1, r11 * r1})});
        r12.addListener(new AnonymousClass1(r9, r0, r1));
        return r12;
    }
}
