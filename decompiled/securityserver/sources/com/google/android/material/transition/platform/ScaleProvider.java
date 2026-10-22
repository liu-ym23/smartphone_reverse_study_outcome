package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
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

    private static Animator createScaleAnimator(View r5, float r6, float r7) {
        return ObjectAnimator.ofPropertyValuesHolder(r5, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{r6, r7}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{r6, r7})});
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup r1, @NonNull View r2) {
        if (this.growing == false) goto L7;
        return createScaleAnimator(r2, this.incomingStartScale, this.incomingEndScale);
    L7:
        return createScaleAnimator(r2, this.outgoingEndScale, this.outgoingStartScale);
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup r1, @NonNull View r2) {
        if (this.scaleOnDisappear == true) goto L7;
        return null;
    L7:
        if (this.growing == false) goto L11;
        return createScaleAnimator(r2, this.outgoingStartScale, this.outgoingEndScale);
    L11:
        return createScaleAnimator(r2, this.incomingEndScale, this.incomingStartScale);
    }

    public float getIncomingEndScale() {
        return this.incomingEndScale;
    }

    public float getIncomingStartScale() {
        return this.incomingStartScale;
    }

    public float getOutgoingEndScale() {
        return this.outgoingEndScale;
    }

    public float getOutgoingStartScale() {
        return this.outgoingStartScale;
    }

    public boolean isGrowing() {
        return this.growing;
    }

    public boolean isScaleOnDisappear() {
        return this.scaleOnDisappear;
    }

    public void setGrowing(boolean r1) {
        this.growing = r1;
    }

    public void setIncomingEndScale(float r1) {
        this.incomingEndScale = r1;
    }

    public void setIncomingStartScale(float r1) {
        this.incomingStartScale = r1;
    }

    public void setOutgoingEndScale(float r1) {
        this.outgoingEndScale = r1;
    }

    public void setOutgoingStartScale(float r1) {
        this.outgoingStartScale = r1;
    }

    public void setScaleOnDisappear(boolean r1) {
        this.scaleOnDisappear = r1;
    }

    public ScaleProvider(boolean r3) {
        this.outgoingStartScale = 1.0f;
        this.outgoingEndScale = 1.1f;
        this.incomingStartScale = 0.8f;
        this.incomingEndScale = 1.0f;
        this.scaleOnDisappear = true;
        this.growing = r3;
    }
}
