package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes.dex */
public class MaterialCardView extends CardView implements Checkable, Shapeable {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.cardview.widget.CardView";
    private static final int[] CHECKABLE_STATE_SET = null;
    private static final int[] CHECKED_STATE_SET = null;
    private static final int DEF_STYLE_RES = 0;
    private static final int[] DRAGGED_STATE_SET = null;
    private static final String LOG_TAG = "MaterialCardView";

    @NonNull
    private final MaterialCardViewHelper cardViewHelper;
    private boolean checked;
    private boolean dragged;
    private boolean isParentCardViewDoneInitializing;
    private OnCheckedChangeListener onCheckedChangeListener;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialCardView r1, boolean r2);
    }

    static {
        CHECKABLE_STATE_SET = new int[]{R.attr.state_checkable};
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DRAGGED_STATE_SET = new int[]{com.google.android.material.R.attr.state_dragged};
        DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_CardView;
    }

    public MaterialCardView(Context r2) {
        this(r2, null);
    }

    public static /* synthetic */ float access$001(MaterialCardView r0) {
        return super.getRadius();
    }

    private void forceRippleRedrawIfNeeded() {
        this.cardViewHelper.forceRippleRedraw();
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF r0 = new RectF();
        r0.set(this.cardViewHelper.getBackground().getBounds());
        return r0;
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.cardViewHelper.getCardBackgroundColor();
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.cardViewHelper.getCardForegroundColor();
    }

    public float getCardViewRadius() {
        return access$001(this);
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.cardViewHelper.getCheckedIcon();
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.cardViewHelper.getCheckedIconTint();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.cardViewHelper.getUserContentPadding().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.cardViewHelper.getUserContentPadding().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.cardViewHelper.getUserContentPadding().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.cardViewHelper.getUserContentPadding().top;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.cardViewHelper.getProgress();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.cardViewHelper.getCornerRadius();
    }

    public ColorStateList getRippleColor() {
        return this.cardViewHelper.getRippleColor();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.cardViewHelper.getShapeAppearanceModel();
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        return this.cardViewHelper.getStrokeColor();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.cardViewHelper.getStrokeColorStateList();
    }

    @Dimension
    public int getStrokeWidth() {
        return this.cardViewHelper.getStrokeWidth();
    }

    public boolean isCheckable() {
        MaterialCardViewHelper r0 = this.cardViewHelper;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isCheckable() == false) goto L7;
        return true;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    public boolean isDragged() {
        return this.dragged;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.cardViewHelper.getBackground());
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int r2) {
        int[] r3 = super.onCreateDrawableState(r2 + 3);
        if (isCheckable() == false) goto L6;
        View.mergeDrawableStates(r3, CHECKABLE_STATE_SET);
    L6:
        if (isChecked() == false) goto L9;
        View.mergeDrawableStates(r3, CHECKED_STATE_SET);
    L9:
        if (isDragged() == false) goto L11;
        View.mergeDrawableStates(r3, DRAGGED_STATE_SET);
    L11:
        return r3;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r2) {
        super.onInitializeAccessibilityEvent(r2);
        r2.setClassName(ACCESSIBILITY_CLASS_NAME);
        r2.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r2) {
        super.onInitializeAccessibilityNodeInfo(r2);
        r2.setClassName(ACCESSIBILITY_CLASS_NAME);
        r2.setCheckable(isCheckable());
        r2.setClickable(isClickable());
        r2.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.cardViewHelper.onMeasure(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setAncestorContentPadding(int r1, int r2, int r3, int r4) {
        super.setContentPadding(r1, r2, r3, r4);
    }

    @Override // android.view.View
    public void setBackground(Drawable r1) {
        setBackgroundDrawable(r1);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r3) {
        if (this.isParentCardViewDoneInitializing == true) goto L5;
        return;
    L5:
        if (this.cardViewHelper.isBackgroundOverwritten() == true) goto L7;
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
        this.cardViewHelper.setBackgroundOverwritten(true);
    L7:
        super.setBackgroundDrawable(r3);
    }

    public void setBackgroundInternal(Drawable r1) {
        super.setBackgroundDrawable(r1);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int r1) {
        this.cardViewHelper.setCardBackgroundColor(ColorStateList.valueOf(r1));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float r1) {
        super.setCardElevation(r1);
        this.cardViewHelper.updateElevation();
    }

    public void setCardForegroundColor(@Nullable ColorStateList r1) {
        this.cardViewHelper.setCardForegroundColor(r1);
    }

    public void setCheckable(boolean r1) {
        this.cardViewHelper.setCheckable(r1);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r2) {
        if (this.checked == r2) goto L6;
        toggle();
        return;
    }

    public void setCheckedIcon(@Nullable Drawable r1) {
        this.cardViewHelper.setCheckedIcon(r1);
    }

    public void setCheckedIconResource(@DrawableRes int r2) {
        this.cardViewHelper.setCheckedIcon(AppCompatResources.getDrawable(getContext(), r2));
    }

    public void setCheckedIconTint(@Nullable ColorStateList r1) {
        this.cardViewHelper.setCheckedIconTint(r1);
    }

    @Override // android.view.View
    public void setClickable(boolean r1) {
        super.setClickable(r1);
        this.cardViewHelper.updateClickable();
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int r1, int r2, int r3, int r4) {
        this.cardViewHelper.setUserContentPadding(r1, r2, r3, r4);
    }

    public void setDragged(boolean r2) {
        if (this.dragged == r2) goto L6;
        this.dragged = r2;
        refreshDrawableState();
        forceRippleRedrawIfNeeded();
        invalidate();
        return;
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float r1) {
        super.setMaxCardElevation(r1);
        this.cardViewHelper.updateInsets();
    }

    public void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener r1) {
        this.onCheckedChangeListener = r1;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean r1) {
        super.setPreventCornerOverlap(r1);
        this.cardViewHelper.updateInsets();
        this.cardViewHelper.updateContentPadding();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float r1) {
        this.cardViewHelper.setProgress(r1);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float r1) {
        super.setRadius(r1);
        this.cardViewHelper.setCornerRadius(r1);
    }

    public void setRippleColor(@Nullable ColorStateList r1) {
        this.cardViewHelper.setRippleColor(r1);
    }

    public void setRippleColorResource(@ColorRes int r2) {
        this.cardViewHelper.setRippleColor(AppCompatResources.getColorStateList(getContext(), r2));
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r2) {
        setClipToOutline(r2.isRoundRect(getBoundsAsRectF()));
        this.cardViewHelper.setShapeAppearanceModel(r2);
    }

    public void setStrokeColor(@ColorInt int r1) {
        this.cardViewHelper.setStrokeColor(ColorStateList.valueOf(r1));
    }

    public void setStrokeWidth(@Dimension int r1) {
        this.cardViewHelper.setStrokeWidth(r1);
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean r1) {
        super.setUseCompatPadding(r1);
        this.cardViewHelper.updateInsets();
        this.cardViewHelper.updateContentPadding();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (isCheckable() == true) goto L5;
        return;
    L5:
        if (isEnabled() == false) goto L11;
        this.checked = !this.checked;
        refreshDrawableState();
        forceRippleRedrawIfNeeded();
        OnCheckedChangeListener r0 = this.onCheckedChangeListener;
        if (r0 == null) goto L12;
        r0.onCheckedChanged(this, this.checked);
        return;
    L12:
        return;
    }

    public MaterialCardView(Context r2, AttributeSet r3) {
        this(r2, r3, com.google.android.material.R.attr.materialCardViewStyle);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList r1) {
        this.cardViewHelper.setCardBackgroundColor(r1);
    }

    public void setStrokeColor(ColorStateList r1) {
        this.cardViewHelper.setStrokeColor(r1);
    }

    public MaterialCardView(Context r8, AttributeSet r9, int r10) {
        int r6 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r8, r9, r10, r6), r9, r10);
        this.checked = false;
        this.dragged = false;
        this.isParentCardViewDoneInitializing = true;
        TypedArray r11 = ThemeEnforcement.obtainStyledAttributes(getContext(), r9, com.google.android.material.R.styleable.MaterialCardView, r10, r6, new int[0]);
        MaterialCardViewHelper r0 = new MaterialCardViewHelper(this, r9, r10, r6);
        this.cardViewHelper = r0;
        r0.setCardBackgroundColor(super.getCardBackgroundColor());
        r0.setUserContentPadding(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        r0.loadFromAttributes(r11);
        r11.recycle();
    }
}
