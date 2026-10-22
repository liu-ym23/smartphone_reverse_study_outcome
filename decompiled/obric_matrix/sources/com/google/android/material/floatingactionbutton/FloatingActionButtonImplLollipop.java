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
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {

    static class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
        AlwaysStatefulMaterialShapeDrawable(ShapeAppearanceModel r1) {
            super(r1);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    FloatingActionButtonImplLollipop(FloatingActionButton r1, ShadowViewDelegate r2) {
        super(r1, r2);
    }

    @NonNull
    private Animator createElevationAnimator(float r8, float r9) {
        AnimatorSet r0 = new AnimatorSet();
        r0.play(ObjectAnimator.ofFloat(this.view, "elevation", new float[]{r8}).setDuration(0)).with(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[]{r9}).setDuration(100));
        r0.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
        return r0;
    }

    @NonNull
    BorderDrawable createBorderDrawable(int r6, ColorStateList r7) {
        Context r0 = this.view.getContext();
        BorderDrawable r1 = new BorderDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
        r1.setGradientColors(ContextCompat.getColor(r0, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(r0, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(r0, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(r0, R.color.design_fab_stroke_end_outer_color));
        r1.setBorderWidth(r6);
        r1.setBorderTint(r7);
        return r1;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    @NonNull
    MaterialShapeDrawable createShapeDrawable() {
        return new AlwaysStatefulMaterialShapeDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public float getElevation() {
        return this.view.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void getPadding(@NonNull Rect r2) {
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

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void initializeBackgroundDrawable(ColorStateList r3, @Nullable PorterDuff.Mode r4, ColorStateList r5, int r6) {
        MaterialShapeDrawable r0 = createShapeDrawable();
        this.shapeDrawable = r0;
        r0.setTintList(r3);
        if (r4 == null) goto L5;
        this.shapeDrawable.setTintMode(r4);
    L5:
        this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
        if (r6 <= 0) goto L8;
        this.borderDrawable = createBorderDrawable(r6, r3);
        Drawable r7 = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.borderDrawable), (Drawable) Preconditions.checkNotNull(this.shapeDrawable)});
    L9:
        RippleDrawable r8 = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(r5), r7, null);
        this.rippleDrawable = r8;
        this.contentBackground = r8;
        return;
    L8:
        this.borderDrawable = null;
        r7 = this.shapeDrawable;
        goto L9
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void jumpDrawableToCurrentState() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void onCompatShadowChanged() {
        updatePadding();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void onDrawableStateChanged(int[] r3) {
        if (Build.VERSION.SDK_INT == 21) goto L5;
        return;
    L5:
        if (this.view.isEnabled() == false) goto L15;
        this.view.setElevation(this.elevation);
        if (this.view.isPressed() == false) goto L11;
        FloatingActionButton r4 = this.view;
        float r2 = this.pressedTranslationZ;
    L9:
        r4.setTranslationZ(r2);
        return;
    L11:
        if (this.view.isFocused() == false) goto L13;
    L14:
        r4 = this.view;
        r2 = this.hoveredFocusedTranslationZ;
        goto L9
    L13:
        if (this.view.isHovered() == true) goto L14;
    L16:
        this.view.setTranslationZ(0.0f);
        return;
    L15:
        this.view.setElevation(0.0f);
        goto L16
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void onElevationsChanged(float r9, float r10, float r11) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 != 21) goto L5;
        this.view.refreshDrawableState();
    L12:
        if (shouldAddPadding() == false) goto L15;
        updatePadding();
        return;
    L15:
        return;
    L5:
        StateListAnimator r1 = new StateListAnimator();
        r1.addState(FloatingActionButtonImpl.PRESSED_ENABLED_STATE_SET, createElevationAnimator(r9, r11));
        r1.addState(FloatingActionButtonImpl.HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(r9, r10));
        r1.addState(FloatingActionButtonImpl.FOCUSED_ENABLED_STATE_SET, createElevationAnimator(r9, r10));
        r1.addState(FloatingActionButtonImpl.HOVERED_ENABLED_STATE_SET, createElevationAnimator(r9, r10));
        AnimatorSet r12 = new AnimatorSet();
        ArrayList r13 = new ArrayList();
        r13.add(ObjectAnimator.ofFloat(this.view, "elevation", new float[]{r9}).setDuration(0));
        if (r0 >= 22) goto L8;
    L10:
        r13.add(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
        r12.playSequentially((Animator[]) r13.toArray(new Animator[0]));
        r12.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
        r1.addState(FloatingActionButtonImpl.ENABLED_STATE_SET, r12);
        r1.addState(FloatingActionButtonImpl.EMPTY_STATE_SET, createElevationAnimator(0.0f, 0.0f));
        this.view.setStateListAnimator(r1);
        goto L12
    L8:
        if (r0 > 24) goto L10;
        FloatingActionButton r14 = this.view;
        r13.add(ObjectAnimator.ofFloat(r14, View.TRANSLATION_Z, new float[]{r14.getTranslationZ()}).setDuration(100));
        goto L10
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean requirePreDrawListener() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void setRippleColor(@Nullable ColorStateList r3) {
        Drawable r0 = this.rippleDrawable;
        if ((r0 instanceof RippleDrawable) == false) goto L5;
        ((RippleDrawable) r0).setColor(RippleUtils.sanitizeRippleDrawableColor(r3));
        return;
    L5:
        super.setRippleColor(r3);
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

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void updateFromViewRotation() {
    }
}
