package com.google.android.material.card;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class MaterialCardViewHelper {
    private static final float CARD_VIEW_SHADOW_MULTIPLIER = 1.5f;
    private static final int CHECKED_ICON_LAYER_INDEX = 2;
    private static final double COS_45 = 0.0d;
    private static final int DEFAULT_STROKE_VALUE = -1;

    @NonNull
    private final MaterialShapeDrawable bgDrawable;
    private boolean checkable;

    @Nullable
    private Drawable checkedIcon;

    @Dimension
    private int checkedIconMargin;

    @Dimension
    private int checkedIconSize;

    @Nullable
    private ColorStateList checkedIconTint;

    @Nullable
    private LayerDrawable clickableForegroundDrawable;

    @Nullable
    private MaterialShapeDrawable compatRippleDrawable;

    @Nullable
    private Drawable fgDrawable;

    @NonNull
    private final MaterialShapeDrawable foregroundContentDrawable;

    @Nullable
    private MaterialShapeDrawable foregroundShapeDrawable;
    private boolean isBackgroundOverwritten;

    @NonNull
    private final MaterialCardView materialCardView;

    @Nullable
    private ColorStateList rippleColor;

    @Nullable
    private Drawable rippleDrawable;

    @Nullable
    private ShapeAppearanceModel shapeAppearanceModel;

    @Nullable
    private ColorStateList strokeColor;

    @Dimension
    private int strokeWidth;

    @NonNull
    private final Rect userContentPadding;

    static {
        COS_45 = Math.cos(Math.toRadians(45.0d));
    }

    public MaterialCardViewHelper(@NonNull MaterialCardView r3, AttributeSet r4, int r5, @StyleRes int r6) {
        this.userContentPadding = new Rect();
        this.isBackgroundOverwritten = false;
        this.materialCardView = r3;
        MaterialShapeDrawable r0 = new MaterialShapeDrawable(r3.getContext(), r4, r5, r6);
        this.bgDrawable = r0;
        r0.initializeElevationOverlay(r3.getContext());
        r0.setShadowColor(-12303292);
        ShapeAppearanceModel.Builder r7 = r0.getShapeAppearanceModel().toBuilder();
        TypedArray r8 = r3.getContext().obtainStyledAttributes(r4, R.styleable.CardView, r5, R.style.CardView);
        int r9 = R.styleable.CardView_cardCornerRadius;
        if (r8.hasValue(r9) == false) goto L5;
        r7.setAllCornerSizes(r8.getDimension(r9, 0.0f));
    L5:
        this.foregroundContentDrawable = new MaterialShapeDrawable();
        setShapeAppearanceModel(r7.build());
        r8.recycle();
    }

    private float calculateActualCornerPadding() {
        return Math.max(Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopLeftCorner(), this.bgDrawable.getTopLeftCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopRightCorner(), this.bgDrawable.getTopRightCornerResolvedSize())), Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomRightCorner(), this.bgDrawable.getBottomRightCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomLeftCorner(), this.bgDrawable.getBottomLeftCornerResolvedSize())));
    }

    private float calculateCornerPaddingForCornerTreatment(CornerTreatment r3, float r4) {
        if ((r3 instanceof RoundedCornerTreatment) == false) goto L7;
        return (float) ((1.0d - COS_45) * ((double) r4));
    L7:
        if ((r3 instanceof CutCornerTreatment) == true) goto L9;
        return 0.0f;
    L9:
        return r4 / 2.0f;
    }

    private float calculateHorizontalBackgroundPadding() {
        float r0 = this.materialCardView.getMaxCardElevation();
        if (shouldAddCornerPaddingOutsideCardBackground() == false) goto L5;
        float r2 = calculateActualCornerPadding();
    L7:
        return r0 + r2;
    L5:
        r2 = 0.0f;
        goto L7
    }

    private float calculateVerticalBackgroundPadding() {
        float r0 = this.materialCardView.getMaxCardElevation() * CARD_VIEW_SHADOW_MULTIPLIER;
        if (shouldAddCornerPaddingOutsideCardBackground() == false) goto L5;
        float r2 = calculateActualCornerPadding();
    L7:
        return r0 + r2;
    L5:
        r2 = 0.0f;
        goto L7
    }

    private boolean canClipToOutline() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L7:
        return false;
    L5:
        if (this.bgDrawable.isRoundRect() == false) goto L7;
        return true;
    }

    @NonNull
    private Drawable createCompatRippleDrawable() {
        StateListDrawable r0 = new StateListDrawable();
        MaterialShapeDrawable r1 = createForegroundShapeDrawable();
        this.compatRippleDrawable = r1;
        r1.setFillColor(this.rippleColor);
        r0.addState(new int[]{android.R.attr.state_pressed}, this.compatRippleDrawable);
        return r0;
    }

    @NonNull
    private Drawable createForegroundRippleDrawable() {
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == false) goto L7;
        this.foregroundShapeDrawable = createForegroundShapeDrawable();
        return new RippleDrawable(this.rippleColor, null, this.foregroundShapeDrawable);
    L7:
        return createCompatRippleDrawable();
    }

    @NonNull
    private MaterialShapeDrawable createForegroundShapeDrawable() {
        return new MaterialShapeDrawable(this.shapeAppearanceModel);
    }

    @NonNull
    private Drawable getClickableForeground() {
        if (this.rippleDrawable != null) goto L6;
        this.rippleDrawable = createForegroundRippleDrawable();
    L6:
        if (this.clickableForegroundDrawable != null) goto L9;
        LayerDrawable r0 = new LayerDrawable(new Drawable[]{this.rippleDrawable, this.foregroundContentDrawable, this.checkedIcon});
        this.clickableForegroundDrawable = r0;
        r0.setId(2, R.id.mtrl_card_checked_layer_id);
    L9:
        return this.clickableForegroundDrawable;
    }

    private float getParentCardViewCalculatedCornerPadding() {
        if (this.materialCardView.getPreventCornerOverlap() == true) goto L5;
        return 0.0f;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L9;
        if (this.materialCardView.getUseCompatPadding() == true) goto L9;
        return 0.0f;
    L9:
        return (float) ((1.0d - COS_45) * ((double) this.materialCardView.getCardViewRadius()));
    }

    @NonNull
    private Drawable insetDrawable(final Drawable r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L11:
        int r1 = (int) Math.ceil(calculateVerticalBackgroundPadding());
        final int r7 = (int) Math.ceil(calculateHorizontalBackgroundPadding());
        final int r8 = r1;
    L12:
        final int r5 = r7;
        final int r6 = r8;
        return new AnonymousClass1(this, r10, r5, r6, r7, r8);
    L8:
        if (this.materialCardView.getUseCompatPadding() == true) goto L11;
        r7 = 0;
        r8 = 0;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    private boolean shouldAddCornerPaddingInsideCardBackground() {
        if (this.materialCardView.getPreventCornerOverlap() == true) goto L5;
    L7:
        return false;
    L5:
        if (canClipToOutline() == true) goto L7;
        return true;
    }

    private boolean shouldAddCornerPaddingOutsideCardBackground() {
        if (this.materialCardView.getPreventCornerOverlap() == true) goto L5;
    L9:
        return false;
    L5:
        if (canClipToOutline() == false) goto L9;
        if (this.materialCardView.getUseCompatPadding() == false) goto L9;
        return true;
    }

    private void updateInsetForeground(Drawable r3) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
    L7:
        this.materialCardView.setForeground(insetDrawable(r3));
        return;
    L5:
        if ((this.materialCardView.getForeground() instanceof InsetDrawable) == false) goto L7;
        ((InsetDrawable) this.materialCardView.getForeground()).setDrawable(r3);
    }

    private void updateRippleColor() {
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == false) goto L7;
        Drawable r0 = this.rippleDrawable;
        if (r0 == null) goto L7;
        ((RippleDrawable) r0).setColor(this.rippleColor);
        return;
    L7:
        MaterialShapeDrawable r1 = this.compatRippleDrawable;
        if (r1 == null) goto L12;
        r1.setFillColor(this.rippleColor);
        return;
    }

    @RequiresApi(api = 23)
    void forceRippleRedraw() {
        Drawable r0 = this.rippleDrawable;
        if (r0 == null) goto L6;
        Rect r1 = r0.getBounds();
        int r2 = r1.bottom;
        this.rippleDrawable.setBounds(r1.left, r1.top, r1.right, r2 - 1);
        this.rippleDrawable.setBounds(r1.left, r1.top, r1.right, r2);
        return;
    }

    @NonNull
    MaterialShapeDrawable getBackground() {
        return this.bgDrawable;
    }

    ColorStateList getCardBackgroundColor() {
        return this.bgDrawable.getFillColor();
    }

    ColorStateList getCardForegroundColor() {
        return this.foregroundContentDrawable.getFillColor();
    }

    @Nullable
    Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    @Dimension
    int getCheckedIconMargin() {
        return this.checkedIconMargin;
    }

    @Dimension
    int getCheckedIconSize() {
        return this.checkedIconSize;
    }

    @Nullable
    ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    float getCornerRadius() {
        return this.bgDrawable.getTopLeftCornerResolvedSize();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    float getProgress() {
        return this.bgDrawable.getInterpolation();
    }

    @Nullable
    ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @ColorInt
    int getStrokeColor() {
        ColorStateList r0 = this.strokeColor;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.getDefaultColor();
    }

    @Nullable
    ColorStateList getStrokeColorStateList() {
        return this.strokeColor;
    }

    @Dimension
    int getStrokeWidth() {
        return this.strokeWidth;
    }

    @NonNull
    Rect getUserContentPadding() {
        return this.userContentPadding;
    }

    boolean isBackgroundOverwritten() {
        return this.isBackgroundOverwritten;
    }

    boolean isCheckable() {
        return this.checkable;
    }

    void loadFromAttributes(@NonNull TypedArray r4) {
        ColorStateList r0 = MaterialResources.getColorStateList(this.materialCardView.getContext(), r4, R.styleable.MaterialCardView_strokeColor);
        this.strokeColor = r0;
        if (r0 != null) goto L5;
        this.strokeColor = ColorStateList.valueOf(-1);
    L5:
        this.strokeWidth = r4.getDimensionPixelSize(R.styleable.MaterialCardView_strokeWidth, 0);
        boolean r1 = r4.getBoolean(R.styleable.MaterialCardView_android_checkable, false);
        this.checkable = r1;
        this.materialCardView.setLongClickable(r1);
        this.checkedIconTint = MaterialResources.getColorStateList(this.materialCardView.getContext(), r4, R.styleable.MaterialCardView_checkedIconTint);
        setCheckedIcon(MaterialResources.getDrawable(this.materialCardView.getContext(), r4, R.styleable.MaterialCardView_checkedIcon));
        setCheckedIconSize(r4.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconSize, 0));
        setCheckedIconMargin(r4.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconMargin, 0));
        ColorStateList r2 = MaterialResources.getColorStateList(this.materialCardView.getContext(), r4, R.styleable.MaterialCardView_rippleColor);
        this.rippleColor = r2;
        if (r2 != null) goto L8;
        this.rippleColor = ColorStateList.valueOf(MaterialColors.getColor(this.materialCardView, R.attr.colorControlHighlight));
    L8:
        setCardForegroundColor(MaterialResources.getColorStateList(this.materialCardView.getContext(), r4, R.styleable.MaterialCardView_cardForegroundColor));
        updateRippleColor();
        updateElevation();
        updateStroke();
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        if (this.materialCardView.isClickable() == false) goto L11;
        Drawable r5 = getClickableForeground();
    L12:
        this.fgDrawable = r5;
        this.materialCardView.setForeground(insetDrawable(r5));
        return;
    L11:
        r5 = this.foregroundContentDrawable;
        goto L12
    }

    void onMeasure(int r10, int r11) {
        if (this.clickableForegroundDrawable == null) goto L18;
        int r0 = this.checkedIconMargin;
        int r1 = this.checkedIconSize;
        int r12 = (r10 - r0) - r1;
        int r13 = (r11 - r0) - r1;
        if (Build.VERSION.SDK_INT >= 21) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
    L11:
        r13 = r13 - ((int) Math.ceil(calculateVerticalBackgroundPadding() * 2.0f));
        r12 = r12 - ((int) Math.ceil(calculateHorizontalBackgroundPadding() * 2.0f));
    L12:
        int r8 = r13;
        int r14 = this.checkedIconMargin;
        if (ViewCompat.getLayoutDirection(this.materialCardView) != 1) goto L15;
        int r7 = r12;
        int r5 = r14;
    L16:
        this.clickableForegroundDrawable.setLayerInset(2, r5, this.checkedIconMargin, r7, r8);
        return;
    L15:
        r5 = r12;
        r7 = r14;
        goto L16
    L10:
        if (this.materialCardView.getUseCompatPadding() == false) goto L12;
    L7:
        r2 = false;
        goto L8
    }

    void setBackgroundOverwritten(boolean r1) {
        this.isBackgroundOverwritten = r1;
    }

    void setCardBackgroundColor(ColorStateList r1) {
        this.bgDrawable.setFillColor(r1);
    }

    void setCardForegroundColor(@Nullable ColorStateList r1) {
        MaterialShapeDrawable r0 = this.foregroundContentDrawable;
        if (r1 != null) goto L5;
        r1 = ColorStateList.valueOf(0);
    L5:
        r0.setFillColor(r1);
    }

    void setCheckable(boolean r1) {
        this.checkable = r1;
    }

    public void setChecked(boolean r1) {
        Drawable r0 = this.checkedIcon;
        if (r0 == null) goto L9;
        if (r1 == false) goto L6;
        int r2 = 255;
    L7:
        r0.setAlpha(r2);
        return;
    L6:
        r2 = 0;
        goto L7
    }

    void setCheckedIcon(@Nullable Drawable r2) {
        this.checkedIcon = r2;
        if (r2 == null) goto L5;
        Drawable r3 = DrawableCompat.wrap(r2).mutate();
        this.checkedIcon = r3;
        DrawableCompat.setTintList(r3, this.checkedIconTint);
        setChecked(this.materialCardView.isChecked());
    L5:
        LayerDrawable r4 = this.clickableForegroundDrawable;
        if (r4 == null) goto L9;
        r4.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, this.checkedIcon);
        return;
    }

    void setCheckedIconMargin(@Dimension int r1) {
        this.checkedIconMargin = r1;
    }

    void setCheckedIconSize(@Dimension int r1) {
        this.checkedIconSize = r1;
    }

    void setCheckedIconTint(@Nullable ColorStateList r1) {
        this.checkedIconTint = r1;
        Drawable r0 = this.checkedIcon;
        if (r0 == null) goto L6;
        DrawableCompat.setTintList(r0, r1);
        return;
    }

    void setCornerRadius(float r2) {
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(r2));
        this.fgDrawable.invalidateSelf();
        if (shouldAddCornerPaddingOutsideCardBackground() == false) goto L5;
    L6:
        updateContentPadding();
    L8:
        if (shouldAddCornerPaddingOutsideCardBackground() == false) goto L11;
        updateInsets();
        return;
    L11:
        return;
    L5:
        if (shouldAddCornerPaddingInsideCardBackground() == false) goto L8;
        goto L6
    }

    void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float r2) {
        this.bgDrawable.setInterpolation(r2);
        MaterialShapeDrawable r0 = this.foregroundContentDrawable;
        if (r0 == null) goto L5;
        r0.setInterpolation(r2);
    L5:
        MaterialShapeDrawable r1 = this.foregroundShapeDrawable;
        if (r1 == null) goto L9;
        r1.setInterpolation(r2);
        return;
    }

    void setRippleColor(@Nullable ColorStateList r1) {
        this.rippleColor = r1;
        updateRippleColor();
    }

    void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r3) {
        this.shapeAppearanceModel = r3;
        this.bgDrawable.setShapeAppearanceModel(r3);
        MaterialShapeDrawable r0 = this.bgDrawable;
        r0.setShadowBitmapDrawingEnable(!r0.isRoundRect());
        MaterialShapeDrawable r1 = this.foregroundContentDrawable;
        if (r1 == null) goto L5;
        r1.setShapeAppearanceModel(r3);
    L5:
        MaterialShapeDrawable r2 = this.foregroundShapeDrawable;
        if (r2 == null) goto L8;
        r2.setShapeAppearanceModel(r3);
    L8:
        MaterialShapeDrawable r4 = this.compatRippleDrawable;
        if (r4 == null) goto L12;
        r4.setShapeAppearanceModel(r3);
        return;
    }

    void setStrokeColor(ColorStateList r2) {
        if (this.strokeColor != r2) goto L5;
        return;
    L5:
        this.strokeColor = r2;
        updateStroke();
    }

    void setStrokeWidth(@Dimension int r2) {
        if (r2 != this.strokeWidth) goto L5;
        return;
    L5:
        this.strokeWidth = r2;
        updateStroke();
    }

    void setUserContentPadding(int r2, int r3, int r4, int r5) {
        this.userContentPadding.set(r2, r3, r4, r5);
        updateContentPadding();
    }

    void updateClickable() {
        Drawable r0 = this.fgDrawable;
        if (this.materialCardView.isClickable() == false) goto L5;
        Drawable r1 = getClickableForeground();
    L6:
        this.fgDrawable = r1;
        if (r0 == r1) goto L10;
        updateInsetForeground(r1);
        return;
    L10:
        return;
    L5:
        r1 = this.foregroundContentDrawable;
        goto L6
    }

    void updateContentPadding() {
        if (shouldAddCornerPaddingInsideCardBackground() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        float r1 = calculateActualCornerPadding();
    L12:
        int r2 = (int) (r1 - getParentCardViewCalculatedCornerPadding());
        MaterialCardView r3 = this.materialCardView;
        Rect r5 = this.userContentPadding;
        r3.setAncestorContentPadding(r5.left + r2, r5.top + r2, r5.right + r2, r5.bottom + r2);
        return;
    L11:
        r1 = 0.0f;
        goto L12
    L5:
        if (shouldAddCornerPaddingOutsideCardBackground() == true) goto L8;
        r0 = false;
        goto L9
    }

    void updateElevation() {
        this.bgDrawable.setElevation(this.materialCardView.getCardElevation());
    }

    void updateInsets() {
        if (isBackgroundOverwritten() == true) goto L5;
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
    L5:
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }

    void updateStroke() {
        this.foregroundContentDrawable.setStroke(this.strokeWidth, this.strokeColor);
    }
}
