package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    private static final int[] CHECKABLE_STATE_SET = null;
    private static final int[] CHECKED_STATE_SET = null;
    private static final int DEF_STYLE_RES = 0;
    public static final int ICON_GRAVITY_END = 3;
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_END = 4;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    private static final String LOG_TAG = "MaterialButton";
    private boolean broadcasting;
    private boolean checked;

    @Nullable
    private Drawable icon;
    private int iconGravity;

    @Px
    private int iconLeft;

    @Px
    private int iconPadding;

    @Px
    private int iconSize;

    @Nullable
    private ColorStateList iconTint;

    @Nullable
    private PorterDuff.Mode iconTintMode;

    @NonNull
    private final MaterialButtonHelper materialButtonHelper;

    @NonNull
    private final LinkedHashSet<OnCheckedChangeListener> onCheckedChangeListeners;

    @Nullable
    private OnPressedChangeListener onPressedChangeListenerInternal;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialButton r1, boolean r2);
    }

    public interface OnPressedChangeListener {
        void onPressedChanged(MaterialButton r1, boolean r2);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean checked;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        private void readFromParcel(@NonNull Parcel r2) {
            boolean r0 = true;
            if (r2.readInt() == 1) goto L6;
            r0 = false;
        L6:
            this.checked = r0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.checked ? 1 : 0);
        }

        public SavedState(@NonNull Parcel r1, ClassLoader r2) {
            super(r1, r2);
            if (r2 != null) goto L5;
            getClass().getClassLoader();
        L5:
            readFromParcel(r1);
        }
    }

    static {
        CHECKABLE_STATE_SET = new int[]{R.attr.state_checkable};
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_Button;
    }

    public MaterialButton(@NonNull Context r2) {
        this(r2, null);
    }

    @NonNull
    private String getA11yClassName() {
        if (isCheckable() == false) goto L5;
        Class r0 = CompoundButton.class;
    L7:
        return r0.getName();
    L5:
        r0 = Button.class;
        goto L7
    }

    private boolean isLayoutRTL() {
        if (ViewCompat.getLayoutDirection(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isUsingOriginalBackground() {
        MaterialButtonHelper r0 = this.materialButtonHelper;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isBackgroundOverwritten() == true) goto L7;
        return true;
    }

    private void resetIconDrawable(boolean r2) {
        if (r2 == false) goto L5;
        TextViewCompat.setCompoundDrawablesRelative(this, this.icon, null, null, null);
        return;
    L5:
        TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.icon, null);
    }

    private void updateIcon(boolean r6) {
        Drawable r0 = this.icon;
        if (r0 == null) goto L16;
        Drawable r1 = DrawableCompat.wrap(r0).mutate();
        this.icon = r1;
        DrawableCompat.setTintList(r1, this.iconTint);
        PorterDuff.Mode r2 = this.iconTintMode;
        if (r2 == null) goto L7;
        DrawableCompat.setTintMode(this.icon, r2);
    L7:
        int r3 = this.iconSize;
        if (r3 != 0) goto L11;
        r3 = this.icon.getIntrinsicWidth();
    L11:
        int r4 = this.iconSize;
        if (r4 != 0) goto L15;
        r4 = this.icon.getIntrinsicHeight();
    L15:
        Drawable r5 = this.icon;
        int r7 = this.iconLeft;
        r5.setBounds(r7, 0, r3 + r7, r4);
    L16:
        int r8 = this.iconGravity;
        boolean r9 = true;
        if (r8 == 1) goto L21;
        if (r8 == 2) goto L21;
        r9 = false;
    L21:
        if (r6 == false) goto L24;
        resetIconDrawable(r9);
        return;
    L24:
        Drawable[] r10 = TextViewCompat.getCompoundDrawablesRelative(this);
        Drawable r11 = r10[0];
        Drawable r12 = r10[2];
        if (r9 == true) goto L27;
    L28:
        if (r9 == false) goto L30;
        return;
    L30:
        if (r12 == this.icon) goto L34;
    L31:
        resetIconDrawable(r9);
        return;
    L34:
        return;
    L27:
        if (r11 != this.icon) goto L31;
        goto L28
    }

    private void updateIconPosition() {
        if (this.icon != null) goto L5;
        return;
    L5:
        if (getLayout() == null) goto L32;
        int r0 = this.iconGravity;
        boolean r1 = true;
        if (r0 != 1) goto L10;
    L28:
        this.iconLeft = 0;
        updateIcon(false);
        return;
    L10:
        if (r0 == 3) goto L28;
        TextPaint r2 = getPaint();
        String r3 = getText().toString();
        if (getTransformationMethod() == null) goto L15;
        r3 = getTransformationMethod().getTransformation(r3, this).toString();
    L15:
        int r4 = Math.min((int) r2.measureText(r3), getLayout().getEllipsizedWidth());
        int r5 = this.iconSize;
        if (r5 != 0) goto L18;
        r5 = this.icon.getIntrinsicWidth();
    L18:
        int r6 = (((((getMeasuredWidth() - r4) - ViewCompat.getPaddingEnd(this)) - r5) - this.iconPadding) - ViewCompat.getPaddingStart(this)) / 2;
        boolean r7 = isLayoutRTL();
        if (this.iconGravity == 4) goto L22;
        r1 = false;
    L22:
        if (r7 == r1) goto L25;
        r6 = -r6;
    L25:
        if (this.iconLeft == r6) goto L30;
        this.iconLeft = r6;
        updateIcon(false);
        return;
    L30:
        return;
    }

    public void addOnCheckedChangeListener(@NonNull OnCheckedChangeListener r1) {
        this.onCheckedChangeListeners.add(r1);
    }

    public void clearOnCheckedChangeListeners() {
        this.onCheckedChangeListeners.clear();
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (isUsingOriginalBackground() == true) goto L7;
        return 0;
    L7:
        return this.materialButtonHelper.getCornerRadius();
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    @Px
    public int getIconPadding() {
        return this.iconPadding;
    }

    @Px
    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (isUsingOriginalBackground() == true) goto L7;
        return null;
    L7:
        return this.materialButtonHelper.getRippleColor();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.getShapeAppearanceModel();
    L7:
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground() == true) goto L7;
        return null;
    L7:
        return this.materialButtonHelper.getStrokeColor();
    }

    @Px
    public int getStrokeWidth() {
        if (isUsingOriginalBackground() == true) goto L7;
        return 0;
    L7:
        return this.materialButtonHelper.getStrokeWidth();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.getSupportBackgroundTintList();
    L7:
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.getSupportBackgroundTintMode();
    L7:
        return super.getSupportBackgroundTintMode();
    }

    public boolean isCheckable() {
        MaterialButtonHelper r0 = this.materialButtonHelper;
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

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isUsingOriginalBackground() == false) goto L6;
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialButtonHelper.getMaterialShapeDrawable());
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r2) {
        int[] r3 = super.onCreateDrawableState(r2 + 2);
        if (isCheckable() == false) goto L6;
        View.mergeDrawableStates(r3, CHECKABLE_STATE_SET);
    L6:
        if (isChecked() == false) goto L8;
        View.mergeDrawableStates(r3, CHECKED_STATE_SET);
    L8:
        return r3;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r2) {
        super.onInitializeAccessibilityEvent(r2);
        r2.setClassName(getA11yClassName());
        r2.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r2) {
        super.onInitializeAccessibilityNodeInfo(r2);
        r2.setClassName(getA11yClassName());
        r2.setCheckable(isCheckable());
        r2.setChecked(isChecked());
        r2.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        updateIconPosition();
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        setChecked(r3.checked);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.checked = this.checked;
        return r1;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        super.onTextChanged(r1, r2, r3, r4);
        updateIconPosition();
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void removeOnCheckedChangeListener(@NonNull OnCheckedChangeListener r1) {
        this.onCheckedChangeListeners.remove(r1);
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable r1) {
        setBackgroundDrawable(r1);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int r2) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.setBackgroundColor(r2);
        return;
    L5:
        super.setBackgroundColor(r2);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable r3) {
        if (isUsingOriginalBackground() == true) goto L5;
        super.setBackgroundDrawable(r3);
        return;
    L5:
        if (r3 == getBackground()) goto L7;
        Log.w(LOG_TAG, "Do not set the background; MaterialButton manages its own background drawable.");
        this.materialButtonHelper.setBackgroundOverwritten();
        super.setBackgroundDrawable(r3);
        return;
    L7:
        getBackground().setState(r3.getState());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), r2);
    L5:
        setBackgroundDrawable(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList r1) {
        setSupportBackgroundTintList(r1);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode r1) {
        setSupportBackgroundTintMode(r1);
    }

    public void setCheckable(boolean r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setCheckable(r2);
        return;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r3) {
        if (isCheckable() == true) goto L5;
        return;
    L5:
        if (isEnabled() == true) goto L7;
        return;
    L7:
        if (this.checked == r3) goto L20;
        this.checked = r3;
        refreshDrawableState();
        if (this.broadcasting == false) goto L11;
        return;
    L11:
        this.broadcasting = true;
        Iterator<OnCheckedChangeListener> r4 = this.onCheckedChangeListeners.iterator();
    L13:
        if (r4.hasNext() == false) goto L15;
        r4.next().onCheckedChanged(this, this.checked);
        goto L13
    L15:
        this.broadcasting = false;
        return;
    }

    public void setCornerRadius(@Px int r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setCornerRadius(r2);
        return;
    }

    public void setCornerRadiusResource(@DimenRes int r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        setCornerRadius(getResources().getDimensionPixelSize(r2));
        return;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r2) {
        super.setElevation(r2);
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.getMaterialShapeDrawable().setElevation(r2);
        return;
    }

    public void setIcon(@Nullable Drawable r2) {
        if (this.icon == r2) goto L6;
        this.icon = r2;
        updateIcon(true);
        return;
    }

    public void setIconGravity(int r2) {
        if (this.iconGravity == r2) goto L6;
        this.iconGravity = r2;
        updateIconPosition();
        return;
    }

    public void setIconPadding(@Px int r2) {
        if (this.iconPadding == r2) goto L6;
        this.iconPadding = r2;
        setCompoundDrawablePadding(r2);
        return;
    }

    public void setIconResource(@DrawableRes int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), r2);
    L5:
        setIcon(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setIconSize(@Px int r2) {
        if (r2 < 0) goto L8;
        if (this.iconSize == r2) goto L9;
        this.iconSize = r2;
        updateIcon(true);
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(@Nullable ColorStateList r2) {
        if (this.iconTint == r2) goto L6;
        this.iconTint = r2;
        updateIcon(false);
        return;
    }

    public void setIconTintMode(PorterDuff.Mode r2) {
        if (this.iconTintMode == r2) goto L6;
        this.iconTintMode = r2;
        updateIcon(false);
        return;
    }

    public void setIconTintResource(@ColorRes int r2) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), r2));
    }

    public void setInternalBackground(Drawable r1) {
        super.setBackgroundDrawable(r1);
    }

    public void setOnPressedChangeListenerInternal(@Nullable OnPressedChangeListener r1) {
        this.onPressedChangeListenerInternal = r1;
    }

    @Override // android.view.View
    public void setPressed(boolean r2) {
        OnPressedChangeListener r0 = this.onPressedChangeListenerInternal;
        if (r0 == null) goto L5;
        r0.onPressedChanged(this, r2);
    L5:
        super.setPressed(r2);
    }

    public void setRippleColor(@Nullable ColorStateList r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setRippleColor(r2);
        return;
    }

    public void setRippleColorResource(@ColorRes int r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        setRippleColor(AppCompatResources.getColorStateList(getContext(), r2));
        return;
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r2) {
        if (isUsingOriginalBackground() == false) goto L7;
        this.materialButtonHelper.setShapeAppearanceModel(r2);
        return;
    L7:
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setShouldDrawSurfaceColorStroke(r2);
        return;
    }

    public void setStrokeColor(@Nullable ColorStateList r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setStrokeColor(r2);
        return;
    }

    public void setStrokeColorResource(@ColorRes int r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        setStrokeColor(AppCompatResources.getColorStateList(getContext(), r2));
        return;
    }

    public void setStrokeWidth(@Px int r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setStrokeWidth(r2);
        return;
    }

    public void setStrokeWidthResource(@DimenRes int r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        setStrokeWidth(getResources().getDimensionPixelSize(r2));
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList r2) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.setSupportBackgroundTintList(r2);
        return;
    L5:
        super.setSupportBackgroundTintList(r2);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r2) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.setSupportBackgroundTintMode(r2);
        return;
    L5:
        super.setSupportBackgroundTintMode(r2);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }

    public MaterialButton(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, com.google.android.material.R.attr.materialButtonStyle);
    }

    public MaterialButton(@NonNull Context r9, @Nullable AttributeSet r10, int r11) {
        int r6 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r9, r10, r11, r6), r10, r11);
        this.onCheckedChangeListeners = new LinkedHashSet();
        boolean r12 = false;
        this.checked = false;
        this.broadcasting = false;
        Context r7 = getContext();
        TypedArray r0 = ThemeEnforcement.obtainStyledAttributes(r7, r10, com.google.android.material.R.styleable.MaterialButton, r11, r6, new int[0]);
        this.iconPadding = r0.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_iconPadding, 0);
        this.iconTintMode = ViewUtils.parseTintMode(r0.getInt(com.google.android.material.R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.iconTint = MaterialResources.getColorStateList(getContext(), r0, com.google.android.material.R.styleable.MaterialButton_iconTint);
        this.icon = MaterialResources.getDrawable(getContext(), r0, com.google.android.material.R.styleable.MaterialButton_icon);
        this.iconGravity = r0.getInteger(com.google.android.material.R.styleable.MaterialButton_iconGravity, 1);
        this.iconSize = r0.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_iconSize, 0);
        MaterialButtonHelper r13 = new MaterialButtonHelper(this, ShapeAppearanceModel.builder(r7, r10, r11, r6).build());
        this.materialButtonHelper = r13;
        r13.loadFromAttributes(r0);
        r0.recycle();
        setCompoundDrawablePadding(this.iconPadding);
        if (this.icon == null) goto L5;
        r12 = true;
    L5:
        updateIcon(r12);
    }
}
