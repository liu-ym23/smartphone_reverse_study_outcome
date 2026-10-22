package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {

    static class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }

        AlwaysStatefulMaterialShapeDrawable(ShapeAppearanceModel r1) {
            super(r1);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void jumpDrawableToCurrentState() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void onDrawableStateChanged(int[] r1) {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean requirePreDrawListener() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void updateFromViewRotation() {
    }

    FloatingActionButtonImplLollipop(FloatingActionButton r1, ShadowViewDelegate r2) {
        super(r1, r2);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void initializeBackgroundDrawable(ColorStateList r3, PorterDuff.Mode r4, ColorStateList r5, int r6) {
        this.shapeDrawable = createShapeDrawable();
        this.shapeDrawable.setTintList(r3);
        if (r4 == null) goto L5;
        this.shapeDrawable.setTintMode(r4);
    L5:
        this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
        if (r6 <= 0) goto L8;
        this.borderDrawable = createBorderDrawable(r6, r3);
        Drawable r7 = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.borderDrawable), (Drawable) Preconditions.checkNotNull(this.shapeDrawable)});
    L9:
        this.rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(r5), r7, null);
        this.contentBackground = this.rippleDrawable;
        return;
    L8:
        this.borderDrawable = null;
        r7 = this.shapeDrawable;
        goto L9
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void setRippleColor(ColorStateList r2) {
        if ((this.rippleDrawable instanceof RippleDrawable) == false) goto L5;
        ((RippleDrawable) this.rippleDrawable).setColor(RippleUtils.sanitizeRippleDrawableColor(r2));
        return;
    L5:
        super.setRippleColor(r2);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void onElevationsChanged(float r8, float r9, float r10) {
        StateListAnimator r0 = new StateListAnimator();
        r0.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(r8, r10));
        r0.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(r8, r9));
        r0.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(r8, r9));
        r0.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(r8, r9));
        AnimatorSet r11 = new AnimatorSet();
        ArrayList r12 = new ArrayList();
        r12.add(ObjectAnimator.ofFloat(this.view, "elevation", new float[]{r8}).setDuration(0));
        r12.add(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
        r11.playSequentially((Animator[]) r12.toArray(new Animator[0]));
        r11.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        r0.addState(ENABLED_STATE_SET, r11);
        r0.addState(EMPTY_STATE_SET, createElevationAnimator(0.0f, 0.0f));
        this.view.setStateListAnimator(r0);
        if (shouldAddPadding() == false) goto L6;
        updatePadding();
        return;
    }

    private Animator createElevationAnimator(float r8, float r9) {
        AnimatorSet r0 = new AnimatorSet();
        r0.play(ObjectAnimator.ofFloat(this.view, "elevation", new float[]{r8}).setDuration(0)).with(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[]{r9}).setDuration(100));
        r0.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        return r0;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public float getElevation() {
        return this.view.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void onCompatShadowChanged() {
        updatePadding();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean shouldAddPadding() {
        if (this.shadowViewDelegate.isCompatPaddingEnabled() == false) goto L5;
    L8:
        return true;
    L5:
        if (shouldExpandBoundsForA11y() == false) goto L8;
        return false;
    }

    BorderDrawable createBorderDrawable(int r6, ColorStateList r7) {
        Context r0 = this.view.getContext();
        BorderDrawable r1 = new BorderDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
        r1.setGradientColors(ContextCompat.getColor(r0, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(r0, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(r0, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(r0, R.color.design_fab_stroke_end_outer_color));
        r1.setBorderWidth(r6);
        r1.setBorderTint(r7);
        return r1;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    MaterialShapeDrawable createShapeDrawable() {
        return new AlwaysStatefulMaterialShapeDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void getPadding(Rect r2) {
        if (this.shadowViewDelegate.isCompatPaddingEnabled() == false) goto L6;
        super.getPadding(r2);
        return;
    L6:
        if (shouldExpandBoundsForA11y() == true) goto L8;
        int r0 = (this.minTouchTargetSize - this.view.getSizeDimension()) / 2;
        r2.set(r0, r0, r0, r0);
        return;
    L8:
        r2.set(0, 0, 0, 0);
    }
}
