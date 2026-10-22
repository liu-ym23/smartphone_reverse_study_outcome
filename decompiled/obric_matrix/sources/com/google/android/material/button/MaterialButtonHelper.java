package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.Dimension;
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

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class MaterialButtonHelper {
    private static final boolean IS_LOLLIPOP = false;

    @ChecksSdkIntAtLeast(api = 21)
    private static final boolean IS_MIN_LOLLIPOP = false;
    private boolean backgroundOverwritten;

    @Nullable
    private ColorStateList backgroundTint;

    @Nullable
    private PorterDuff.Mode backgroundTintMode;
    private boolean checkable;
    private int cornerRadius;
    private boolean cornerRadiusSet;
    private int elevation;
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
        int r0 = Build.VERSION.SDK_INT;
        boolean r1 = true;
        if (r0 < 21) goto L5;
        boolean r4 = true;
    L6:
        IS_MIN_LOLLIPOP = r4;
        if (r0 >= 21) goto L9;
    L11:
        r1 = false;
    L12:
        IS_LOLLIPOP = r1;
        return;
    L9:
        if (r0 > 22) goto L11;
    L5:
        r4 = false;
        goto L6
    }

    MaterialButtonHelper(MaterialButton r2, @NonNull ShapeAppearanceModel r3) {
        this.shouldDrawSurfaceColorStroke = false;
        this.backgroundOverwritten = false;
        this.cornerRadiusSet = false;
        this.materialButton = r2;
        this.shapeAppearanceModel = r3;
    }

    private Drawable createBackground() {
        MaterialShapeDrawable r0 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        r0.initializeElevationOverlay(this.materialButton.getContext());
        DrawableCompat.setTintList(r0, this.backgroundTint);
        PorterDuff.Mode r1 = this.backgroundTintMode;
        if (r1 == null) goto L5;
        DrawableCompat.setTintMode(r0, r1);
    L5:
        r0.setStroke(this.strokeWidth, this.strokeColor);
        MaterialShapeDrawable r2 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        r2.setTint(0);
        float r3 = this.strokeWidth;
        if (this.shouldDrawSurfaceColorStroke == false) goto L8;
        int r4 = MaterialColors.getColor(this.materialButton, R.attr.colorSurface);
    L9:
        r2.setStroke(r3, r4);
        if (IS_MIN_LOLLIPOP == false) goto L13;
        MaterialShapeDrawable r5 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        this.maskDrawable = r5;
        DrawableCompat.setTint(r5, -1);
        RippleDrawable r6 = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.rippleColor), wrapDrawableWithInset(new LayerDrawable(new Drawable[]{r2, r0})), this.maskDrawable);
        this.rippleDrawable = r6;
        return r6;
    L13:
        RippleDrawableCompat r7 = new RippleDrawableCompat(this.shapeAppearanceModel);
        this.maskDrawable = r7;
        DrawableCompat.setTintList(r7, RippleUtils.sanitizeRippleDrawableColor(this.rippleColor));
        LayerDrawable r8 = new LayerDrawable(new Drawable[]{r2, r0, this.maskDrawable});
        this.rippleDrawable = r8;
        return wrapDrawableWithInset(r8);
    L8:
        r4 = 0;
        goto L9
    }

    @Nullable
    private MaterialShapeDrawable getMaterialShapeDrawable(boolean r2) {
        LayerDrawable r0 = this.rippleDrawable;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.getNumberOfLayers() <= 0) goto L13;
        boolean r1 = IS_MIN_LOLLIPOP;
        LayerDrawable r3 = this.rippleDrawable;
        if (r1 == false) goto L10;
        r3 = (LayerDrawable) ((InsetDrawable) r3.getDrawable(0)).getDrawable();
    L10:
        return (MaterialShapeDrawable) r3.getDrawable(!r2 ? 1 : 0);
    L13:
        return null;
    }

    @Nullable
    private MaterialShapeDrawable getSurfaceColorStrokeDrawable() {
        return getMaterialShapeDrawable(true);
    }

    private void setVerticalInsets(@Dimension int r8, @Dimension int r9) {
        int r0 = ViewCompat.getPaddingStart(this.materialButton);
        int r1 = this.materialButton.getPaddingTop();
        int r2 = ViewCompat.getPaddingEnd(this.materialButton);
        int r3 = this.materialButton.getPaddingBottom();
        int r4 = this.insetTop;
        int r5 = this.insetBottom;
        this.insetBottom = r9;
        this.insetTop = r8;
        if (this.backgroundOverwritten == true) goto L5;
        updateBackground();
    L5:
        ViewCompat.setPaddingRelative(this.materialButton, r0, (r1 + r8) - r4, r2, (r3 + r9) - r5);
    }

    private void updateBackground() {
        this.materialButton.setInternalBackground(createBackground());
        MaterialShapeDrawable r0 = getMaterialShapeDrawable();
        if (r0 == null) goto L6;
        r0.setElevation(this.elevation);
        return;
    }

    private void updateButtonShape(@NonNull ShapeAppearanceModel r4) {
        if (IS_LOLLIPOP == false) goto L8;
        if (this.backgroundOverwritten == true) goto L8;
        int r5 = ViewCompat.getPaddingStart(this.materialButton);
        int r0 = this.materialButton.getPaddingTop();
        int r1 = ViewCompat.getPaddingEnd(this.materialButton);
        int r2 = this.materialButton.getPaddingBottom();
        updateBackground();
        ViewCompat.setPaddingRelative(this.materialButton, r5, r0, r1, r2);
        return;
    L8:
        if (getMaterialShapeDrawable() == null) goto L11;
        getMaterialShapeDrawable().setShapeAppearanceModel(r4);
    L11:
        if (getSurfaceColorStrokeDrawable() == null) goto L14;
        getSurfaceColorStrokeDrawable().setShapeAppearanceModel(r4);
    L14:
        if (getMaskDrawable() == null) goto L18;
        getMaskDrawable().setShapeAppearanceModel(r4);
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

    int getCornerRadius() {
        return this.cornerRadius;
    }

    public int getInsetBottom() {
        return this.insetBottom;
    }

    public int getInsetTop() {
        return this.insetTop;
    }

    @Nullable
    public Shapeable getMaskDrawable() {
        LayerDrawable r0 = this.rippleDrawable;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.getNumberOfLayers() <= 1) goto L14;
        int r1 = this.rippleDrawable.getNumberOfLayers();
        LayerDrawable r3 = this.rippleDrawable;
        if (r1 <= 2) goto L11;
        Object r4 = r3.getDrawable(2);
    L10:
        return (Shapeable) r4;
    L11:
        r4 = r3.getDrawable(1);
        goto L10
    L14:
        return null;
    }

    @Nullable
    MaterialShapeDrawable getMaterialShapeDrawable() {
        return getMaterialShapeDrawable(false);
    }

    @Nullable
    ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    @NonNull
    ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Nullable
    ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    int getStrokeWidth() {
        return this.strokeWidth;
    }

    ColorStateList getSupportBackgroundTintList() {
        return this.backgroundTint;
    }

    PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    boolean isBackgroundOverwritten() {
        return this.backgroundOverwritten;
    }

    boolean isCheckable() {
        return this.checkable;
    }

    void loadFromAttributes(@NonNull TypedArray r6) {
        this.insetLeft = r6.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.insetRight = r6.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.insetTop = r6.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.insetBottom = r6.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        int r0 = R.styleable.MaterialButton_cornerRadius;
        if (r6.hasValue(r0) == false) goto L5;
        int r1 = r6.getDimensionPixelSize(r0, -1);
        this.cornerRadius = r1;
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(r1));
        this.cornerRadiusSet = true;
    L5:
        this.strokeWidth = r6.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.backgroundTintMode = ViewUtils.parseTintMode(r6.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.backgroundTint = MaterialResources.getColorStateList(this.materialButton.getContext(), r6, R.styleable.MaterialButton_backgroundTint);
        this.strokeColor = MaterialResources.getColorStateList(this.materialButton.getContext(), r6, R.styleable.MaterialButton_strokeColor);
        this.rippleColor = MaterialResources.getColorStateList(this.materialButton.getContext(), r6, R.styleable.MaterialButton_rippleColor);
        this.checkable = r6.getBoolean(R.styleable.MaterialButton_android_checkable, false);
        this.elevation = r6.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
        int r2 = ViewCompat.getPaddingStart(this.materialButton);
        int r3 = this.materialButton.getPaddingTop();
        int r4 = ViewCompat.getPaddingEnd(this.materialButton);
        int r5 = this.materialButton.getPaddingBottom();
        if (r6.hasValue(R.styleable.MaterialButton_android_background) == false) goto L8;
        setBackgroundOverwritten();
    L9:
        ViewCompat.setPaddingRelative(this.materialButton, r2 + this.insetLeft, r3 + this.insetTop, r4 + this.insetRight, r5 + this.insetBottom);
        return;
    L8:
        updateBackground();
        goto L9
    }

    void setBackgroundColor(int r2) {
        if (getMaterialShapeDrawable() == null) goto L6;
        getMaterialShapeDrawable().setTint(r2);
        return;
    }

    void setBackgroundOverwritten() {
        this.backgroundOverwritten = true;
        this.materialButton.setSupportBackgroundTintList(this.backgroundTint);
        this.materialButton.setSupportBackgroundTintMode(this.backgroundTintMode);
    }

    void setCheckable(boolean r1) {
        this.checkable = r1;
    }

    void setCornerRadius(int r2) {
        if (this.cornerRadiusSet == true) goto L5;
    L6:
        this.cornerRadius = r2;
        this.cornerRadiusSet = true;
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(r2));
        return;
    L5:
        if (this.cornerRadius != r2) goto L6;
    }

    public void setInsetBottom(@Dimension int r2) {
        setVerticalInsets(this.insetTop, r2);
    }

    public void setInsetTop(@Dimension int r2) {
        setVerticalInsets(r2, this.insetBottom);
    }

    void setRippleColor(@Nullable ColorStateList r3) {
        if (this.rippleColor == r3) goto L14;
        this.rippleColor = r3;
        boolean r0 = IS_MIN_LOLLIPOP;
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

    void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r1) {
        this.shapeAppearanceModel = r1;
        updateButtonShape(r1);
    }

    void setShouldDrawSurfaceColorStroke(boolean r1) {
        this.shouldDrawSurfaceColorStroke = r1;
        updateStroke();
    }

    void setStrokeColor(@Nullable ColorStateList r2) {
        if (this.strokeColor == r2) goto L6;
        this.strokeColor = r2;
        updateStroke();
        return;
    }

    void setStrokeWidth(int r2) {
        if (this.strokeWidth == r2) goto L6;
        this.strokeWidth = r2;
        updateStroke();
        return;
    }

    void setSupportBackgroundTintList(@Nullable ColorStateList r2) {
        if (this.backgroundTint == r2) goto L8;
        this.backgroundTint = r2;
        if (getMaterialShapeDrawable() == null) goto L9;
        DrawableCompat.setTintList(getMaterialShapeDrawable(), this.backgroundTint);
        return;
    L9:
        return;
    }

    void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r2) {
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

    void updateMaskBounds(int r5, int r6) {
        Drawable r0 = this.maskDrawable;
        if (r0 == null) goto L6;
        r0.setBounds(this.insetLeft, this.insetTop, r6 - this.insetRight, r5 - this.insetBottom);
        return;
    }
}
