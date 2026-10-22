package com.google.android.material.card;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
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
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class MaterialCardViewHelper {
    private static final float CARD_VIEW_SHADOW_MULTIPLIER = 1.5f;
    private static final int CHECKED_ICON_LAYER_INDEX = 2;
    private static final int[] CHECKED_STATE_SET = null;
    private static final double COS_45 = 0.0d;
    private static final int DEFAULT_STROKE_VALUE = -1;

    @NonNull
    private final MaterialShapeDrawable bgDrawable;
    private boolean checkable;

    @Nullable
    private Drawable checkedIcon;

    @Dimension
    private final int checkedIconMargin;

    @Dimension
    private final int checkedIconSize;

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
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        COS_45 = Math.cos(Math.toRadians(45.0d));
    }

    public MaterialCardViewHelper(@NonNull MaterialCardView r4, AttributeSet r5, int r6, @StyleRes int r7) {
        this.userContentPadding = new Rect();
        this.isBackgroundOverwritten = false;
        this.materialCardView = r4;
        MaterialShapeDrawable r0 = new MaterialShapeDrawable(r4.getContext(), r5, r6, r7);
        this.bgDrawable = r0;
        r0.initializeElevationOverlay(r4.getContext());
        r0.setShadowColor(-12303292);
        ShapeAppearanceModel.Builder r8 = r0.getShapeAppearanceModel().toBuilder();
        TypedArray r9 = r4.getContext().obtainStyledAttributes(r5, com.google.android.material.R.styleable.CardView, r6, com.google.android.material.R.style.CardView);
        if (r9.hasValue(com.google.android.material.R.styleable.CardView_cardCornerRadius) == false) goto L5;
        r8.setAllCornerSizes(r9.getDimension(com.google.android.material.R.styleable.CardView_cardCornerRadius, 0.0f));
    L5:
        this.foregroundContentDrawable = new MaterialShapeDrawable();
        setShapeAppearanceModel(r8.build());
        Resources r10 = r4.getResources();
        this.checkedIconMargin = r10.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_card_checked_icon_margin);
        this.checkedIconSize = r10.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_card_checked_icon_size);
        r9.recycle();
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
        return this.bgDrawable.isRoundRect();
    }

    @NonNull
    private Drawable createCheckedIconLayer() {
        StateListDrawable r0 = new StateListDrawable();
        Drawable r2 = this.checkedIcon;
        if (r2 == null) goto L5;
        r0.addState(CHECKED_STATE_SET, r2);
    L5:
        return r0;
    }

    @NonNull
    private Drawable createCompatRippleDrawable() {
        StateListDrawable r0 = new StateListDrawable();
        MaterialShapeDrawable r1 = createForegroundShapeDrawable();
        this.compatRippleDrawable = r1;
        r1.setFillColor(this.rippleColor);
        r0.addState(new int[]{R.attr.state_pressed}, this.compatRippleDrawable);
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
        Drawable r1 = createCheckedIconLayer();
        LayerDrawable r2 = new LayerDrawable(new Drawable[]{this.rippleDrawable, this.foregroundContentDrawable, r1});
        this.clickableForegroundDrawable = r2;
        r2.setId(2, com.google.android.material.R.id.mtrl_card_checked_layer_id);
    L9:
        return this.clickableForegroundDrawable;
    }

    private float getParentCardViewCalculatedCornerPadding() {
        if (this.materialCardView.getPreventCornerOverlap() == true) goto L5;
        return 0.0f;
    L5:
        if (this.materialCardView.getUseCompatPadding() == true) goto L7;
        return 0.0f;
    L7:
        return (float) ((1.0d - COS_45) * ((double) this.materialCardView.getCardViewRadius()));
    }

    @NonNull
    private Drawable insetDrawable(final Drawable r9) {
        if (this.materialCardView.getUseCompatPadding() == false) goto L5;
        final int r7 = (int) Math.ceil(calculateVerticalBackgroundPadding());
        final int r6 = (int) Math.ceil(calculateHorizontalBackgroundPadding());
    L6:
        final int r4 = r6;
        final int r5 = r7;
        return new AnonymousClass1(this, r9, r4, r5, r6, r7);
    L5:
        r6 = 0;
        r7 = 0;
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

    private void updateInsetForeground(Drawable r2) {
        if ((this.materialCardView.getForeground() instanceof InsetDrawable) == false) goto L5;
        ((InsetDrawable) this.materialCardView.getForeground()).setDrawable(r2);
        return;
    L5:
        this.materialCardView.setForeground(insetDrawable(r2));
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
    public void forceRippleRedraw() {
        Drawable r0 = this.rippleDrawable;
        if (r0 == null) goto L6;
        Rect r1 = r0.getBounds();
        int r2 = r1.bottom;
        this.rippleDrawable.setBounds(r1.left, r1.top, r1.right, r2 - 1);
        this.rippleDrawable.setBounds(r1.left, r1.top, r1.right, r2);
        return;
    }

    @NonNull
    public MaterialShapeDrawable getBackground() {
        return this.bgDrawable;
    }

    public ColorStateList getCardBackgroundColor() {
        return this.bgDrawable.getFillColor();
    }

    public ColorStateList getCardForegroundColor() {
        return this.foregroundContentDrawable.getFillColor();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    public float getCornerRadius() {
        return this.bgDrawable.getTopLeftCornerResolvedSize();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.bgDrawable.getInterpolation();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @ColorInt
    public int getStrokeColor() {
        ColorStateList r0 = this.strokeColor;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.getDefaultColor();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.strokeColor;
    }

    @Dimension
    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    @NonNull
    public Rect getUserContentPadding() {
        return this.userContentPadding;
    }

    public boolean isBackgroundOverwritten() {
        return this.isBackgroundOverwritten;
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    public void loadFromAttributes(@NonNull TypedArray r3) {
        ColorStateList r0 = MaterialResources.getColorStateList(this.materialCardView.getContext(), r3, com.google.android.material.R.styleable.MaterialCardView_strokeColor);
        this.strokeColor = r0;
        if (r0 != null) goto L5;
        this.strokeColor = ColorStateList.valueOf(-1);
    L5:
        this.strokeWidth = r3.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_strokeWidth, 0);
        boolean r1 = r3.getBoolean(com.google.android.material.R.styleable.MaterialCardView_android_checkable, false);
        this.checkable = r1;
        this.materialCardView.setLongClickable(r1);
        this.checkedIconTint = MaterialResources.getColorStateList(this.materialCardView.getContext(), r3, com.google.android.material.R.styleable.MaterialCardView_checkedIconTint);
        setCheckedIcon(MaterialResources.getDrawable(this.materialCardView.getContext(), r3, com.google.android.material.R.styleable.MaterialCardView_checkedIcon));
        ColorStateList r2 = MaterialResources.getColorStateList(this.materialCardView.getContext(), r3, com.google.android.material.R.styleable.MaterialCardView_rippleColor);
        this.rippleColor = r2;
        if (r2 != null) goto L8;
        this.rippleColor = ColorStateList.valueOf(MaterialColors.getColor(this.materialCardView, com.google.android.material.R.attr.colorControlHighlight));
    L8:
        setCardForegroundColor(MaterialResources.getColorStateList(this.materialCardView.getContext(), r3, com.google.android.material.R.styleable.MaterialCardView_cardForegroundColor));
        updateRippleColor();
        updateElevation();
        updateStroke();
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        if (this.materialCardView.isClickable() == false) goto L11;
        Drawable r4 = getClickableForeground();
    L12:
        this.fgDrawable = r4;
        this.materialCardView.setForeground(insetDrawable(r4));
        return;
    L11:
        r4 = this.foregroundContentDrawable;
        goto L12
    }

    public void onMeasure(int r7, int r8) {
        if (this.clickableForegroundDrawable == null) goto L13;
        int r0 = this.checkedIconMargin;
        int r1 = this.checkedIconSize;
        int r9 = (r7 - r0) - r1;
        int r10 = (r8 - r0) - r1;
        if (this.materialCardView.getUseCompatPadding() == false) goto L7;
        r10 = r10 - ((int) Math.ceil(calculateVerticalBackgroundPadding() * 2.0f));
        r9 = r9 - ((int) Math.ceil(calculateHorizontalBackgroundPadding() * 2.0f));
    L7:
        int r5 = r10;
        int r11 = this.checkedIconMargin;
        if (ViewCompat.getLayoutDirection(this.materialCardView) != 1) goto L10;
        int r4 = r9;
        int r2 = r11;
    L11:
        this.clickableForegroundDrawable.setLayerInset(2, r2, this.checkedIconMargin, r4, r5);
        return;
    L10:
        r2 = r9;
        r4 = r11;
        goto L11
    }

    public void setBackgroundOverwritten(boolean r1) {
        this.isBackgroundOverwritten = r1;
    }

    public void setCardBackgroundColor(ColorStateList r1) {
        this.bgDrawable.setFillColor(r1);
    }

    public void setCardForegroundColor(@Nullable ColorStateList r1) {
        MaterialShapeDrawable r0 = this.foregroundContentDrawable;
        if (r1 != null) goto L5;
        r1 = ColorStateList.valueOf(0);
    L5:
        r0.setFillColor(r1);
    }

    public void setCheckable(boolean r1) {
        this.checkable = r1;
    }

    public void setCheckedIcon(@Nullable Drawable r2) {
        this.checkedIcon = r2;
        if (r2 == null) goto L6;
        Drawable r3 = DrawableCompat.wrap(r2.mutate());
        this.checkedIcon = r3;
        DrawableCompat.setTintList(r3, this.checkedIconTint);
    L6:
        if (this.clickableForegroundDrawable == null) goto L9;
        Drawable r4 = createCheckedIconLayer();
        this.clickableForegroundDrawable.setDrawableByLayerId(com.google.android.material.R.id.mtrl_card_checked_layer_id, r4);
        return;
    }

    public void setCheckedIconTint(@Nullable ColorStateList r1) {
        this.checkedIconTint = r1;
        Drawable r0 = this.checkedIcon;
        if (r0 == null) goto L6;
        DrawableCompat.setTintList(r0, r1);
        return;
    }

    public void setCornerRadius(float r2) {
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

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float r2) {
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

    public void setRippleColor(@Nullable ColorStateList r1) {
        this.rippleColor = r1;
        updateRippleColor();
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r3) {
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

    public void setStrokeColor(ColorStateList r2) {
        if (this.strokeColor != r2) goto L5;
        return;
    L5:
        this.strokeColor = r2;
        updateStroke();
    }

    public void setStrokeWidth(@Dimension int r2) {
        if (r2 != this.strokeWidth) goto L5;
        return;
    L5:
        this.strokeWidth = r2;
        updateStroke();
    }

    public void setUserContentPadding(int r2, int r3, int r4, int r5) {
        this.userContentPadding.set(r2, r3, r4, r5);
        updateContentPadding();
    }

    public void updateClickable() {
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

    public void updateContentPadding() {
        if (shouldAddCornerPaddingInsideCardBackground() == false) goto L5;
    L8:
        float r0 = calculateActualCornerPadding();
    L9:
        int r1 = (int) (r0 - getParentCardViewCalculatedCornerPadding());
        MaterialCardView r2 = this.materialCardView;
        Rect r5 = this.userContentPadding;
        r2.setAncestorContentPadding(r5.left + r1, r5.top + r1, r5.right + r1, r5.bottom + r1);
        return;
    L5:
        if (shouldAddCornerPaddingOutsideCardBackground() == true) goto L8;
        r0 = 0.0f;
        goto L9
    }

    public void updateElevation() {
        this.bgDrawable.setElevation(this.materialCardView.getCardElevation());
    }

    public void updateInsets() {
        if (isBackgroundOverwritten() == true) goto L5;
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
    L5:
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }

    public void updateStroke() {
        this.foregroundContentDrawable.setStroke(this.strokeWidth, this.strokeColor);
    }
}
