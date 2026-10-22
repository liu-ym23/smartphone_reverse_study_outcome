package com.google.android.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RippleDrawableCompat extends Drawable implements Shapeable, TintAwareDrawable {
    private RippleDrawableCompatState drawableState;

    /* JADX INFO: renamed from: com.google.android.material.ripple.RippleDrawableCompat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class RippleDrawableCompatState extends Drawable.ConstantState {

        @NonNull
        MaterialShapeDrawable delegate;
        boolean shouldDrawDelegate;

        public RippleDrawableCompatState(MaterialShapeDrawable r1) {
            this.delegate = r1;
            this.shouldDrawDelegate = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public /* bridge */ /* synthetic */ Drawable newDrawable() {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public RippleDrawableCompat newDrawable() {
            return new RippleDrawableCompat(new RippleDrawableCompatState(this), null);
        }

        public RippleDrawableCompatState(@NonNull RippleDrawableCompatState r2) {
            this.delegate = (MaterialShapeDrawable) r2.delegate.getConstantState().newDrawable();
            this.shouldDrawDelegate = r2.shouldDrawDelegate;
        }
    }

    public /* synthetic */ RippleDrawableCompat(RippleDrawableCompatState r1, AnonymousClass1 r2) {
        this(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        RippleDrawableCompatState r1 = this.drawableState;
        if (r1.shouldDrawDelegate == false) goto L6;
        r1.delegate.draw(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.drawableState.delegate.getOpacity();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.delegate.getShapeAppearanceModel();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public /* bridge */ /* synthetic */ Drawable mutate() {
        return mutate();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect r1) {
        super.onBoundsChange(r1);
        this.drawableState.delegate.setBounds(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(@NonNull int[] r4) {
        boolean r0 = super.onStateChange(r4);
        if (this.drawableState.delegate.setState(r4) == false) goto L5;
        r0 = true;
    L5:
        boolean r5 = RippleUtils.shouldDrawRippleCompat(r4);
        RippleDrawableCompatState r3 = this.drawableState;
        if (r3.shouldDrawDelegate == r5) goto L9;
        r3.shouldDrawDelegate = r5;
        return true;
    L9:
        return r0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
        this.drawableState.delegate.setAlpha(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r1) {
        this.drawableState.delegate.setColorFilter(r1);
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r1) {
        this.drawableState.delegate.setShapeAppearanceModel(r1);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int r1) {
        this.drawableState.delegate.setTint(r1);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList r1) {
        this.drawableState.delegate.setTintList(r1);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode r1) {
        this.drawableState.delegate.setTintMode(r1);
    }

    public RippleDrawableCompat(ShapeAppearanceModel r3) {
        this(new RippleDrawableCompatState(new MaterialShapeDrawable(r3)));
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public RippleDrawableCompat mutate() {
        this.drawableState = new RippleDrawableCompatState(this.drawableState);
        return this;
    }

    private RippleDrawableCompat(RippleDrawableCompatState r1) {
        this.drawableState = r1;
    }
}
