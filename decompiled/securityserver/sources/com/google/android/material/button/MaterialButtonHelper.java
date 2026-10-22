package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class MaterialButtonHelper {
    private static final boolean IS_LOLLIPOP = false;
    private boolean backgroundOverwritten;

    @Nullable
    private ColorStateList backgroundTint;

    @Nullable
    private PorterDuff.Mode backgroundTintMode;
    private boolean checkable;
    private int cornerRadius;
    private boolean cornerRadiusSet;
    private int insetBottom;
    private int insetLeft;
    private int insetRight;
    private int insetTop;

    @Nullable
    private Drawable maskDrawable;
    private final MaterialButton materialButton;

    @Nullable
    private ColorStateList rippleColor;
    private LayerDrawable rippleDrawable;

    @NonNull
    private ShapeAppearanceModel shapeAppearanceModel;
    private boolean shouldDrawSurfaceColorStroke;

    @Nullable
    private ColorStateList strokeColor;
    private int strokeWidth;

    static {
        IS_LOLLIPOP = true;
    }

    public MaterialButtonHelper(MaterialButton r2, @NonNull ShapeAppearanceModel r3) {
        this.shouldDrawSurfaceColorStroke = false;
        this.backgroundOverwritten = false;
        this.cornerRadiusSet = false;
        this.materialButton = r2;
        this.shapeAppearanceModel = r3;
    }

    private Drawable createBackground() {
        MaterialShapeDrawable r3 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        r3.initializeElevationOverlay(this.materialButton.getContext());
        DrawableCompat.setTintList(r3, this.backgroundTint);
        PorterDuff.Mode r4 = this.backgroundTintMode;
        if (r4 == null) goto L5;
        DrawableCompat.setTintMode(r3, r4);
    L5:
        r3.setStroke(this.strokeWidth, this.strokeColor);
        MaterialShapeDrawable r5 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        r5.setTint(0);
        float r6 = this.strokeWidth;
        if (this.shouldDrawSurfaceColorStroke == false) goto L8;
        int r7 = MaterialColors.getColor(this.materialButton, R.attr.colorSurface);
    L9:
        r5.setStroke(r6, r7);
        if (IS_LOLLIPOP == false) goto L13;
        MaterialShapeDrawable r8 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        this.maskDrawable = r8;
        DrawableCompat.setTint(r8, -1);
        RippleDrawable r9 = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.rippleColor), wrapDrawableWithInset(new LayerDrawable(new Drawable[]{r5, r3})), this.maskDrawable);
        this.rippleDrawable = r9;
        return r9;
    L13:
        RippleDrawableCompat r10 = new RippleDrawableCompat(this.shapeAppearanceModel);
        this.maskDrawable = r10;
        DrawableCompat.setTintList(r10, RippleUtils.sanitizeRippleDrawableColor(this.rippleColor));
        LayerDrawable r11 = new LayerDrawable(new Drawable[]{r5, r3, this.maskDrawable});
        this.rippleDrawable = r11;
        return wrapDrawableWithInset(r11);
    L8:
        r7 = 0;
        goto L9
    }

    @Nullable
    private MaterialShapeDrawable getMaterialShapeDrawable(boolean r2) {
        LayerDrawable r0 = this.rippleDrawable;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.getNumberOfLayers() > 0) goto L7;
        return null;
    L7:
        if (IS_LOLLIPOP == false) goto L11;
        return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.rippleDrawable.getDrawable(0)).getDrawable()).getDrawable(!r2 ? 1 : 0);
    L11:
        return (MaterialShapeDrawable) this.rippleDrawable.getDrawable(!r2 ? 1 : 0);
    }

    @Nullable
    private MaterialShapeDrawable getSurfaceColorStrokeDrawable() {
        return getMaterialShapeDrawable(true);
    }

    private void updateButtonShape(@NonNull ShapeAppearanceModel r2) {
        if (getMaterialShapeDrawable() == null) goto L6;
        getMaterialShapeDrawable().setShapeAppearanceModel(r2);
    L6:
        if (getSurfaceColorStrokeDrawable() == null) goto L9;
        getSurfaceColorStrokeDrawable().setShapeAppearanceModel(r2);
    L9:
        if (getMaskDrawable() == null) goto L12;
        getMaskDrawable().setShapeAppearanceModel(r2);
        return;
    }

    private void updateStroke() {
        MaterialShapeDrawable r0 = getMaterialShapeDrawable();
        MaterialShapeDrawable r1 = getSurfaceColorStrokeDrawable();
        if (r0 == null) goto L12;
        r0.setStroke(this.strokeWidth, this.strokeColor);
        if (r1 == null) goto L13;
        float r2 = this.strokeWidth;
        if (this.shouldDrawSurfaceColorStroke == false) goto L9;
        int r4 = MaterialColors.getColor(this.materialButton, R.attr.colorSurface);
    L10:
        r1.setStroke(r2, r4);
        return;
    L9:
        r4 = 0;
        goto L10
    L13:
        return;
    }

    @NonNull
    private InsetDrawable wrapDrawableWithInset(Drawable r8) {
        return new InsetDrawable(r8, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
    }

    public int getCornerRadius() {
        return this.cornerRadius;
    }

    @Nullable
    public Shapeable getMaskDrawable() {
        LayerDrawable r0 = this.rippleDrawable;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.getNumberOfLayers() > 1) goto L7;
        return null;
    L7:
        if (this.rippleDrawable.getNumberOfLayers() <= 2) goto L11;
        return (Shapeable) this.rippleDrawable.getDrawable(2);
    L11:
        return (Shapeable) this.rippleDrawable.getDrawable(1);
    }

    @Nullable
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.backgroundTint;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    public boolean isBackgroundOverwritten() {
        return this.backgroundOverwritten;
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    public void loadFromAttributes(@NonNull TypedArray r7) {
        this.insetLeft = r7.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.insetRight = r7.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.insetTop = r7.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.insetBottom = r7.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        if (r7.hasValue(R.styleable.MaterialButton_cornerRadius) == false) goto L5;
        int r0 = r7.getDimensionPixelSize(R.styleable.MaterialButton_cornerRadius, -1);
        this.cornerRadius = r0;
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(r0));
        this.cornerRadiusSet = true;
    L5:
        this.strokeWidth = r7.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.backgroundTintMode = ViewUtils.parseTintMode(r7.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.backgroundTint = MaterialResources.getColorStateList(this.materialButton.getContext(), r7, R.styleable.MaterialButton_backgroundTint);
        this.strokeColor = MaterialResources.getColorStateList(this.materialButton.getContext(), r7, R.styleable.MaterialButton_strokeColor);
        this.rippleColor = MaterialResources.getColorStateList(this.materialButton.getContext(), r7, R.styleable.MaterialButton_rippleColor);
        this.checkable = r7.getBoolean(R.styleable.MaterialButton_android_checkable, false);
        int r1 = r7.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
        int r2 = ViewCompat.getPaddingStart(this.materialButton);
        int r3 = this.materialButton.getPaddingTop();
        int r4 = ViewCompat.getPaddingEnd(this.materialButton);
        int r5 = this.materialButton.getPaddingBottom();
        if (r7.hasValue(R.styleable.MaterialButton_android_background) == false) goto L8;
        setBackgroundOverwritten();
    L11:
        ViewCompat.setPaddingRelative(this.materialButton, r2 + this.insetLeft, r3 + this.insetTop, r4 + this.insetRight, r5 + this.insetBottom);
        return;
    L8:
        this.materialButton.setInternalBackground(createBackground());
        MaterialShapeDrawable r8 = getMaterialShapeDrawable();
        if (r8 == null) goto L11;
        r8.setElevation(r1);
        goto L11
    }

    public void setBackgroundColor(int r2) {
        if (getMaterialShapeDrawable() == null) goto L6;
        getMaterialShapeDrawable().setTint(r2);
        return;
    }

    public void setBackgroundOverwritten() {
        this.backgroundOverwritten = true;
        this.materialButton.setSupportBackgroundTintList(this.backgroundTint);
        this.materialButton.setSupportBackgroundTintMode(this.backgroundTintMode);
    }

    public void setCheckable(boolean r1) {
        this.checkable = r1;
    }

    public void setCornerRadius(int r2) {
        if (this.cornerRadiusSet == true) goto L5;
    L6:
        this.cornerRadius = r2;
        this.cornerRadiusSet = true;
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(r2));
        return;
    L5:
        if (this.cornerRadius != r2) goto L6;
    }

    public void setRippleColor(@Nullable ColorStateList r3) {
        if (this.rippleColor == r3) goto L14;
        this.rippleColor = r3;
        boolean r0 = IS_LOLLIPOP;
        if (r0 == true) goto L7;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        if ((this.materialButton.getBackground() instanceof RippleDrawableCompat) == false) goto L17;
        ((RippleDrawableCompat) this.materialButton.getBackground()).setTintList(RippleUtils.sanitizeRippleDrawableColor(r3));
        return;
    L17:
        return;
    L7:
        if ((this.materialButton.getBackground() instanceof RippleDrawable) == false) goto L9;
        ((RippleDrawable) this.materialButton.getBackground()).setColor(RippleUtils.sanitizeRippleDrawableColor(r3));
        return;
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r1) {
        this.shapeAppearanceModel = r1;
        updateButtonShape(r1);
    }

    public void setShouldDrawSurfaceColorStroke(boolean r1) {
        this.shouldDrawSurfaceColorStroke = r1;
        updateStroke();
    }

    public void setStrokeColor(@Nullable ColorStateList r2) {
        if (this.strokeColor == r2) goto L6;
        this.strokeColor = r2;
        updateStroke();
        return;
    }

    public void setStrokeWidth(int r2) {
        if (this.strokeWidth == r2) goto L6;
        this.strokeWidth = r2;
        updateStroke();
        return;
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList r2) {
        if (this.backgroundTint == r2) goto L8;
        this.backgroundTint = r2;
        if (getMaterialShapeDrawable() == null) goto L9;
        DrawableCompat.setTintList(getMaterialShapeDrawable(), this.backgroundTint);
        return;
    L9:
        return;
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r2) {
        if (this.backgroundTintMode == r2) goto L10;
        this.backgroundTintMode = r2;
        if (getMaterialShapeDrawable() != null) goto L7;
        return;
    L7:
        if (this.backgroundTintMode == null) goto L12;
        DrawableCompat.setTintMode(getMaterialShapeDrawable(), this.backgroundTintMode);
        return;
    L12:
        return;
    }

    public void updateMaskBounds(int r5, int r6) {
        Drawable r0 = this.maskDrawable;
        if (r0 == null) goto L6;
        r0.setBounds(this.insetLeft, this.insetTop, r6 - this.insetRight, r5 - this.insetBottom);
        return;
    }

    @Nullable
    public MaterialShapeDrawable getMaterialShapeDrawable() {
        return getMaterialShapeDrawable(false);
    }
}
