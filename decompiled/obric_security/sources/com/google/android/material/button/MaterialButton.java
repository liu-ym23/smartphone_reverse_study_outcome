package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
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

/* JADX INFO: loaded from: classes2.dex */
public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    private static final int[] CHECKABLE_STATE_SET = null;
    private static final int[] CHECKED_STATE_SET = null;
    private static final int DEF_STYLE_RES = 0;
    public static final int ICON_GRAVITY_END = 3;
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_END = 4;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    public static final int ICON_GRAVITY_TEXT_TOP = 32;
    public static final int ICON_GRAVITY_TOP = 16;
    private static final String LOG_TAG = "MaterialButton";
    private boolean broadcasting;
    private boolean checked;
    private Drawable icon;
    private int iconGravity;
    private int iconLeft;
    private int iconPadding;
    private int iconSize;
    private ColorStateList iconTint;
    private PorterDuff.Mode iconTintMode;
    private int iconTop;
    private final MaterialButtonHelper materialButtonHelper;
    private final LinkedHashSet<OnCheckedChangeListener> onCheckedChangeListeners;
    private OnPressedChangeListener onPressedChangeListenerInternal;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialButton r1, boolean r2);
    }

    interface OnPressedChangeListener {
        void onPressedChanged(MaterialButton r1, boolean r2);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean checked;

        public SavedState(Parcelable r1) {
            super(r1);
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            if (r2 != null) goto L5;
            getClass().getClassLoader();
        L5:
            readFromParcel(r1);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.checked ? 1 : 0);
        }

        private void readFromParcel(Parcel r2) {
            boolean r0 = true;
            if (r2.readInt() == 1) goto L6;
            r0 = false;
        L6:
            this.checked = r0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static {
        CHECKABLE_STATE_SET = new int[]{R.attr.state_checkable};
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_Button;
    }

    public MaterialButton(Context r2) {
        this(r2, null);
    }

    public MaterialButton(Context r2, AttributeSet r3) {
        this(r2, r3, com.google.android.material.R.attr.materialButtonStyle);
    }

    public MaterialButton(Context r9, AttributeSet r10, int r11) {
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

    private String getA11yClassName() {
        if (isCheckable() == false) goto L5;
        Class r0 = CompoundButton.class;
    L7:
        return r0.getName();
    L5:
        r0 = Button.class;
        goto L7
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r2) {
        super.onInitializeAccessibilityNodeInfo(r2);
        r2.setClassName(getA11yClassName());
        r2.setCheckable(isCheckable());
        r2.setChecked(isChecked());
        r2.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r2) {
        super.onInitializeAccessibilityEvent(r2);
        r2.setClassName(getA11yClassName());
        r2.setChecked(isChecked());
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.checked = this.checked;
        return r1;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        setChecked(r3.checked);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList r2) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.setSupportBackgroundTintList(r2);
        return;
    L5:
        super.setSupportBackgroundTintList(r2);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.getSupportBackgroundTintList();
    L7:
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode r2) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.setSupportBackgroundTintMode(r2);
        return;
    L5:
        super.setSupportBackgroundTintMode(r2);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.getSupportBackgroundTintMode();
    L7:
        return super.getSupportBackgroundTintMode();
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList r1) {
        setSupportBackgroundTintList(r1);
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode r1) {
        setSupportBackgroundTintMode(r1);
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Override // android.view.View
    public void setBackgroundColor(int r2) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.setBackgroundColor(r2);
        return;
    L5:
        super.setBackgroundColor(r2);
    }

    @Override // android.view.View
    public void setBackground(Drawable r1) {
        setBackgroundDrawable(r1);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), r2);
    L5:
        setBackgroundDrawable(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable r3) {
        if (isUsingOriginalBackground() == true) goto L5;
        super.setBackgroundDrawable(r3);
        return;
    L5:
        if (r3 == getBackground()) goto L7;
        Log.w(LOG_TAG, "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        this.materialButtonHelper.setBackgroundOverwritten();
        super.setBackgroundDrawable(r3);
        return;
    L7:
        getBackground().setState(r3.getState());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        updateIconPosition(r1, r2);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    protected void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        super.onTextChanged(r1, r2, r3, r4);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isUsingOriginalBackground() == false) goto L6;
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialButtonHelper.getMaterialShapeDrawable());
        return;
    }

    @Override // android.view.View
    public void setElevation(float r2) {
        super.setElevation(r2);
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.getMaterialShapeDrawable().setElevation(r2);
        return;
    }

    private void updateIconPosition(int r5, int r6) {
        if (this.icon != null) goto L5;
        return;
    L5:
        if (getLayout() != null) goto L8;
        return;
    L8:
        if (isIconStart() == false) goto L10;
    L24:
        this.iconTop = 0;
        int r7 = this.iconGravity;
        boolean r0 = true;
        if (r7 != 1) goto L27;
    L42:
        this.iconLeft = 0;
        updateIcon(false);
        return;
    L27:
        if (r7 == 3) goto L42;
        int r8 = this.iconSize;
        if (r8 != 0) goto L32;
        r8 = this.icon.getIntrinsicWidth();
    L32:
        int r9 = (((((r5 - getTextWidth()) - ViewCompat.getPaddingEnd(this)) - r8) - this.iconPadding) - ViewCompat.getPaddingStart(this)) / 2;
        boolean r10 = isLayoutRTL();
        if (this.iconGravity == 4) goto L36;
        r0 = false;
    L36:
        if (r10 == r0) goto L39;
        r9 = -r9;
    L39:
        if (this.iconLeft == r9) goto L47;
        this.iconLeft = r9;
        updateIcon(false);
        return;
    L47:
        return;
    L10:
        if (isIconEnd() == true) goto L24;
        if (isIconTop() == false) goto L44;
        this.iconLeft = 0;
        if (this.iconGravity != 16) goto L18;
        this.iconTop = 0;
        updateIcon(false);
        return;
    L18:
        int r11 = this.iconSize;
        if (r11 != 0) goto L21;
        r11 = this.icon.getIntrinsicHeight();
    L21:
        int r12 = (((((r6 - getTextHeight()) - getPaddingTop()) - r11) - this.iconPadding) - getPaddingBottom()) / 2;
        if (this.iconTop == r12) goto L45;
        this.iconTop = r12;
        updateIcon(false);
        return;
    L45:
        return;
    }

    private int getTextWidth() {
        TextPaint r0 = getPaint();
        String r1 = getText().toString();
        if (getTransformationMethod() == null) goto L6;
        r1 = getTransformationMethod().getTransformation(r1, this).toString();
    L6:
        return Math.min((int) r0.measureText(r1), getLayout().getEllipsizedWidth());
    }

    private int getTextHeight() {
        TextPaint r0 = getPaint();
        String r1 = getText().toString();
        if (getTransformationMethod() == null) goto L5;
        r1 = getTransformationMethod().getTransformation(r1, this).toString();
    L5:
        Rect r2 = new Rect();
        r0.getTextBounds(r1, 0, r1.length(), r2);
        return Math.min(r2.height(), getLayout().getHeight());
    }

    private boolean isLayoutRTL() {
        if (ViewCompat.getLayoutDirection(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    void setInternalBackground(Drawable r1) {
        super.setBackgroundDrawable(r1);
    }

    public void setIconPadding(int r2) {
        if (this.iconPadding == r2) goto L6;
        this.iconPadding = r2;
        setCompoundDrawablePadding(r2);
        return;
    }

    public int getIconPadding() {
        return this.iconPadding;
    }

    public void setIconSize(int r2) {
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

    public int getIconSize() {
        return this.iconSize;
    }

    public void setIcon(Drawable r2) {
        if (this.icon == r2) goto L6;
        this.icon = r2;
        updateIcon(true);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        return;
    }

    public void setIconResource(int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), r2);
    L5:
        setIcon(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public void setIconTint(ColorStateList r2) {
        if (this.iconTint == r2) goto L6;
        this.iconTint = r2;
        updateIcon(false);
        return;
    }

    public void setIconTintResource(int r2) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), r2));
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public void setIconTintMode(PorterDuff.Mode r2) {
        if (this.iconTintMode == r2) goto L6;
        this.iconTintMode = r2;
        updateIcon(false);
        return;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
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
        int r8 = this.iconTop;
        r5.setBounds(r7, r8, r3 + r7, r4 + r8);
    L16:
        if (r6 == false) goto L19;
        resetIconDrawable();
        return;
    L19:
        Drawable[] r9 = TextViewCompat.getCompoundDrawablesRelative(this);
        boolean r10 = false;
        Drawable r11 = r9[0];
        Drawable r12 = r9[1];
        Drawable r13 = r9[2];
        if (isIconStart() == false) goto L24;
        if (r11 == this.icon) goto L24;
    L31:
        r10 = true;
    L32:
        if (r10 == false) goto L35;
        resetIconDrawable();
        return;
    L35:
        return;
    L24:
        if (isIconEnd() == false) goto L28;
        if (r13 != this.icon) goto L31;
    L28:
        if (isIconTop() == false) goto L32;
        if (r12 == this.icon) goto L32;
        goto L31
    }

    private void resetIconDrawable() {
        if (isIconStart() == false) goto L6;
        TextViewCompat.setCompoundDrawablesRelative(this, this.icon, null, null, null);
        return;
    L6:
        if (isIconEnd() == false) goto L9;
        TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.icon, null);
        return;
    L9:
        if (isIconTop() == false) goto L14;
        TextViewCompat.setCompoundDrawablesRelative(this, null, this.icon, null, null);
        return;
    }

    private boolean isIconStart() {
        int r2 = this.iconGravity;
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean isIconEnd() {
        int r1 = this.iconGravity;
        if (r1 != 3) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 4) goto L8;
        return false;
    }

    private boolean isIconTop() {
        int r1 = this.iconGravity;
        if (r1 != 16) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 32) goto L8;
        return false;
    }

    public void setRippleColor(ColorStateList r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setRippleColor(r2);
        return;
    }

    public void setRippleColorResource(int r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        setRippleColor(AppCompatResources.getColorStateList(getContext(), r2));
        return;
    }

    public ColorStateList getRippleColor() {
        if (isUsingOriginalBackground() == true) goto L7;
        return null;
    L7:
        return this.materialButtonHelper.getRippleColor();
    }

    public void setStrokeColor(ColorStateList r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setStrokeColor(r2);
        return;
    }

    public void setStrokeColorResource(int r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        setStrokeColor(AppCompatResources.getColorStateList(getContext(), r2));
        return;
    }

    public ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground() == true) goto L7;
        return null;
    L7:
        return this.materialButtonHelper.getStrokeColor();
    }

    public void setStrokeWidth(int r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setStrokeWidth(r2);
        return;
    }

    public void setStrokeWidthResource(int r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        setStrokeWidth(getResources().getDimensionPixelSize(r2));
        return;
    }

    public int getStrokeWidth() {
        if (isUsingOriginalBackground() == true) goto L7;
        return 0;
    L7:
        return this.materialButtonHelper.getStrokeWidth();
    }

    public void setCornerRadius(int r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setCornerRadius(r2);
        return;
    }

    public void setCornerRadiusResource(int r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        setCornerRadius(getResources().getDimensionPixelSize(r2));
        return;
    }

    public int getCornerRadius() {
        if (isUsingOriginalBackground() == true) goto L7;
        return 0;
    L7:
        return this.materialButtonHelper.getCornerRadius();
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    public void setIconGravity(int r2) {
        if (this.iconGravity == r2) goto L6;
        this.iconGravity = r2;
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        return;
    }

    public void setInsetBottom(int r1) {
        this.materialButtonHelper.setInsetBottom(r1);
    }

    public int getInsetBottom() {
        return this.materialButtonHelper.getInsetBottom();
    }

    public void setInsetTop(int r1) {
        this.materialButtonHelper.setInsetTop(r1);
    }

    public int getInsetTop() {
        return this.materialButtonHelper.getInsetTop();
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int r2) {
        int[] r3 = super.onCreateDrawableState(r2 + 2);
        if (isCheckable() == false) goto L6;
        mergeDrawableStates(r3, CHECKABLE_STATE_SET);
    L6:
        if (isChecked() == false) goto L8;
        mergeDrawableStates(r3, CHECKED_STATE_SET);
    L8:
        return r3;
    }

    public void addOnCheckedChangeListener(OnCheckedChangeListener r1) {
        this.onCheckedChangeListeners.add(r1);
    }

    public void removeOnCheckedChangeListener(OnCheckedChangeListener r1) {
        this.onCheckedChangeListeners.remove(r1);
    }

    public void clearOnCheckedChangeListeners() {
        this.onCheckedChangeListeners.clear();
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

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
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

    public void setCheckable(boolean r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setCheckable(r2);
        return;
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel r2) {
        if (isUsingOriginalBackground() == false) goto L7;
        this.materialButtonHelper.setShapeAppearanceModel(r2);
        return;
    L7:
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    @Override // com.google.android.material.shape.Shapeable
    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.getShapeAppearanceModel();
    L7:
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    void setOnPressedChangeListenerInternal(OnPressedChangeListener r1) {
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

    private boolean isUsingOriginalBackground() {
        MaterialButtonHelper r0 = this.materialButtonHelper;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isBackgroundOverwritten() == true) goto L7;
        return true;
    }

    void setShouldDrawSurfaceColorStroke(boolean r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setShouldDrawSurfaceColorStroke(r2);
        return;
    }
}
