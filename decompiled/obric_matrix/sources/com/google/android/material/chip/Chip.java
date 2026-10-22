package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.bytedance.bdlocation.trace.TraceCons;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Chip extends AppCompatCheckBox implements ChipDrawable.Delegate, Shapeable {
    private static final String BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.Button";
    private static final int[] CHECKABLE_STATE_SET = null;
    private static final int CHIP_BODY_VIRTUAL_ID = 0;
    private static final int CLOSE_ICON_VIRTUAL_ID = 1;
    private static final String COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.CompoundButton";
    private static final int DEF_STYLE_RES = 0;
    private static final Rect EMPTY_BOUNDS = null;
    private static final String GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME = "android.view.View";
    private static final int MIN_TOUCH_TARGET_DP = 48;
    private static final String NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    private static final String RADIO_BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.RadioButton";
    private static final int[] SELECTED_STATE = null;
    private static final String TAG = "Chip";

    @Nullable
    private ChipDrawable chipDrawable;
    private boolean closeIconFocused;
    private boolean closeIconHovered;
    private boolean closeIconPressed;
    private boolean deferredCheckedValue;
    private boolean ensureMinTouchTargetSize;
    private final TextAppearanceFontCallback fontCallback;

    @Nullable
    private InsetDrawable insetBackgroundDrawable;
    private int lastLayoutDirection;

    @Dimension(unit = 1)
    private int minTouchTargetSize;

    @Nullable
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListenerInternal;

    @Nullable
    private View.OnClickListener onCloseIconClickListener;
    private final Rect rect;
    private final RectF rectF;

    @Nullable
    private RippleDrawable ripple;

    @NonNull
    private final ChipTouchHelper touchHelper;
    private boolean touchHelperEnabled;

    private class ChipTouchHelper extends ExploreByTouchHelper {
        final /* synthetic */ Chip this$0;

        ChipTouchHelper(Chip r1, Chip r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float r2, float r3) {
            if (Chip.access$100(this.this$0) == true) goto L5;
        L7:
            return 0;
        L5:
            if (Chip.access$200(this.this$0).contains(r2, r3) == false) goto L7;
            return 1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(@NonNull List<Integer> r2) {
            r2.add(0);
            if (Chip.access$100(this.this$0) == true) goto L5;
            return;
        L5:
            if (this.this$0.isCloseIconVisible() == true) goto L7;
            return;
        L7:
            if (Chip.access$300(this.this$0) == null) goto L12;
            r2.add(1);
            return;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int r1, int r2, Bundle r3) {
            if (r2 != 16) goto L11;
            if (r1 != 0) goto L8;
            return this.this$0.performClick();
        L8:
            if (r1 == 1) goto L10;
            return false;
        L10:
            return this.this$0.performCloseIconClick();
        L11:
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat r3) {
            r3.setCheckable(this.this$0.isCheckable());
            r3.setClickable(this.this$0.isClickable());
            r3.setClassName(this.this$0.getAccessibilityClassName());
            CharSequence r2 = this.this$0.getText();
            if (Build.VERSION.SDK_INT < 23) goto L5;
            r3.setText(r2);
            return;
        L5:
            r3.setContentDescription(r2);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int r7, @NonNull AccessibilityNodeInfoCompat r8) {
            CharSequence r0 = "";
            if (r7 != 1) goto L12;
            CharSequence r9 = this.this$0.getCloseIconContentDescription();
            if (r9 == null) goto L7;
        L6:
            r8.setContentDescription(r9);
            r8.setBoundsInParent(Chip.access$500(this.this$0));
            r8.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            r8.setEnabled(this.this$0.isEnabled());
            return;
        L7:
            CharSequence r10 = this.this$0.getText();
            Context r2 = this.this$0.getContext();
            int r3 = R.string.mtrl_chip_close_icon_content_description;
            Object[] r1 = new Object[1];
            if (TextUtils.isEmpty(r10) == true) goto L10;
            r0 = r10;
        L10:
            r1[0] = r0;
            r9 = r2.getString(r3, r1).trim();
            goto L6
        L12:
            r8.setContentDescription("");
            r8.setBoundsInParent(Chip.access$600());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onVirtualViewKeyboardFocusChanged(int r2, boolean r3) {
            if (r2 != 1) goto L6;
            Chip.access$402(this.this$0, r3);
            this.this$0.refreshDrawableState();
            return;
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_Chip_Action;
        EMPTY_BOUNDS = new Rect();
        SELECTED_STATE = new int[]{android.R.attr.state_selected};
        CHECKABLE_STATE_SET = new int[]{android.R.attr.state_checkable};
    }

    public Chip(Context r2) {
        this(r2, null);
    }

    public Chip(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.chipStyle);
    }

    public Chip(Context r8, AttributeSet r9, int r10) {
        int r4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r8, r9, r10, r4), r9, r10);
        this.rect = new Rect();
        this.rectF = new RectF();
        this.fontCallback = new AnonymousClass1(this);
        Context r11 = getContext();
        validateAttributes(r9);
        ChipDrawable r6 = ChipDrawable.createFromAttributes(r11, r9, r10, r4);
        initMinTouchTarget(r11, r9, r10);
        setChipDrawable(r6);
        r6.setElevation(ViewCompat.getElevation(this));
        TypedArray r12 = ThemeEnforcement.obtainStyledAttributes(r11, r9, R.styleable.Chip, r10, r4, new int[0]);
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        setTextColor(MaterialResources.getColorStateList(r11, r12, R.styleable.Chip_android_textColor));
    L5:
        boolean r13 = r12.hasValue(R.styleable.Chip_shapeAppearance);
        r12.recycle();
        this.touchHelper = new ChipTouchHelper(this, this);
        updateAccessibilityDelegate();
        if (r13 == true) goto L8;
        initOutlineProvider();
    L8:
        setChecked(this.deferredCheckedValue);
        setText(r6.getText());
        setEllipsize(r6.getEllipsize());
        updateTextPaintDrawState();
        if (this.chipDrawable.shouldDrawText() == true) goto L11;
        setLines(1);
        setHorizontallyScrolling(true);
    L11:
        setGravity(8388627);
        updatePaddingInternal();
        if (shouldEnsureMinTouchTargetSize() == false) goto L14;
        setMinHeight(this.minTouchTargetSize);
    L14:
        this.lastLayoutDirection = ViewCompat.getLayoutDirection(this);
    }

    static /* synthetic */ ChipDrawable access$000(Chip r0) {
        return r0.chipDrawable;
    }

    static /* synthetic */ boolean access$100(Chip r0) {
        return r0.hasCloseIcon();
    }

    static /* synthetic */ RectF access$200(Chip r0) {
        return r0.getCloseIconTouchBounds();
    }

    static /* synthetic */ View.OnClickListener access$300(Chip r0) {
        return r0.onCloseIconClickListener;
    }

    static /* synthetic */ boolean access$402(Chip r0, boolean r1) {
        r0.closeIconFocused = r1;
        return r1;
    }

    static /* synthetic */ Rect access$500(Chip r0) {
        return r0.getCloseIconTouchBoundsInt();
    }

    static /* synthetic */ Rect access$600() {
        return EMPTY_BOUNDS;
    }

    private void applyChipDrawable(@NonNull ChipDrawable r1) {
        r1.setDelegate(this);
    }

    @NonNull
    private int[] createCloseIconDrawableState() {
        int r1 = 0;
        if (isEnabled() == false) goto L5;
        int r0 = 1;
    L7:
        if (this.closeIconFocused == false) goto L10;
        r0 = r0 + 1;
    L10:
        if (this.closeIconHovered == false) goto L13;
        r0 = r0 + 1;
    L13:
        if (this.closeIconPressed == false) goto L16;
        r0 = r0 + 1;
    L16:
        if (isChecked() == false) goto L18;
        r0 = r0 + 1;
    L18:
        int[] r2 = new int[r0];
        if (isEnabled() == false) goto L22;
        r2[0] = 16842910;
        r1 = 1;
    L22:
        if (this.closeIconFocused == false) goto L25;
        r2[r1] = 16842908;
        r1 = r1 + 1;
    L25:
        if (this.closeIconHovered == false) goto L28;
        r2[r1] = 16843623;
        r1 = r1 + 1;
    L28:
        if (this.closeIconPressed == false) goto L31;
        r2[r1] = 16842919;
        r1 = r1 + 1;
    L31:
        if (isChecked() == false) goto L33;
        r2[r1] = 16842913;
    L33:
        return r2;
    L5:
        r0 = 0;
        goto L7
    }

    private void ensureChipDrawableHasCallback() {
        if (getBackgroundDrawable() == this.insetBackgroundDrawable) goto L5;
        return;
    L5:
        if (this.chipDrawable.getCallback() != null) goto L9;
        this.chipDrawable.setCallback(this.insetBackgroundDrawable);
        return;
    }

    @NonNull
    private RectF getCloseIconTouchBounds() {
        this.rectF.setEmpty();
        if (hasCloseIcon() == false) goto L8;
        if (this.onCloseIconClickListener == null) goto L8;
        this.chipDrawable.getCloseIconTouchBounds(this.rectF);
    L8:
        return this.rectF;
    }

    @NonNull
    private Rect getCloseIconTouchBoundsInt() {
        RectF r0 = getCloseIconTouchBounds();
        this.rect.set((int) r0.left, (int) r0.top, (int) r0.right, (int) r0.bottom);
        return this.rect;
    }

    @Nullable
    private TextAppearance getTextAppearance() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTextAppearance();
    }

    private boolean hasCloseIcon() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getCloseIcon() == null) goto L7;
        return true;
    }

    private void initMinTouchTarget(Context r8, @Nullable AttributeSet r9, int r10) {
        TypedArray r11 = ThemeEnforcement.obtainStyledAttributes(r8, r9, R.styleable.Chip, r10, DEF_STYLE_RES, new int[0]);
        this.ensureMinTouchTargetSize = r11.getBoolean(R.styleable.Chip_ensureMinTouchTargetSize, false);
        this.minTouchTargetSize = (int) Math.ceil(r11.getDimension(R.styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(ViewUtils.dpToPx(getContext(), 48))));
        r11.recycle();
    }

    private void initOutlineProvider() {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        setOutlineProvider(new AnonymousClass2(this));
        return;
    }

    private void insetChipBackgroundDrawable(int r8, int r9, int r10, int r11) {
        this.insetBackgroundDrawable = new InsetDrawable(this.chipDrawable, r8, r9, r10, r11);
    }

    private void removeBackgroundInset() {
        if (this.insetBackgroundDrawable == null) goto L6;
        this.insetBackgroundDrawable = null;
        setMinWidth(0);
        setMinHeight((int) getChipMinHeight());
        updateBackgroundDrawable();
        return;
    }

    private void setCloseIconHovered(boolean r2) {
        if (this.closeIconHovered == r2) goto L6;
        this.closeIconHovered = r2;
        refreshDrawableState();
        return;
    }

    private void setCloseIconPressed(boolean r2) {
        if (this.closeIconPressed == r2) goto L6;
        this.closeIconPressed = r2;
        refreshDrawableState();
        return;
    }

    private void unapplyChipDrawable(@Nullable ChipDrawable r1) {
        if (r1 == null) goto L5;
        r1.setDelegate(null);
        return;
    }

    private void updateAccessibilityDelegate() {
        if (hasCloseIcon() == true) goto L5;
    L9:
        ViewCompat.setAccessibilityDelegate(this, null);
        boolean r0 = false;
    L10:
        this.touchHelperEnabled = r0;
        return;
    L5:
        if (isCloseIconVisible() == false) goto L9;
        if (this.onCloseIconClickListener == null) goto L9;
        ViewCompat.setAccessibilityDelegate(this, this.touchHelper);
        r0 = true;
        goto L10
    }

    private void updateBackgroundDrawable() {
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == false) goto L5;
        updateFrameworkRippleBackground();
        return;
    L5:
        this.chipDrawable.setUseCompatRipple(true);
        ViewCompat.setBackground(this, getBackgroundDrawable());
        updatePaddingInternal();
        ensureChipDrawableHasCallback();
    }

    private void updateFrameworkRippleBackground() {
        this.ripple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.chipDrawable.getRippleColor()), getBackgroundDrawable(), null);
        this.chipDrawable.setUseCompatRipple(false);
        ViewCompat.setBackground(this, this.ripple);
        updatePaddingInternal();
    }

    private void updatePaddingInternal() {
        if (TextUtils.isEmpty(getText()) == true) goto L12;
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L13;
        int r1 = (int) ((r0.getChipEndPadding() + this.chipDrawable.getTextEndPadding()) + this.chipDrawable.calculateCloseIconWidth());
        int r2 = (int) ((this.chipDrawable.getChipStartPadding() + this.chipDrawable.getTextStartPadding()) + this.chipDrawable.calculateChipIconWidth());
        if (this.insetBackgroundDrawable == null) goto L10;
        Rect r3 = new Rect();
        this.insetBackgroundDrawable.getPadding(r3);
        r2 = r2 + r3.left;
        r1 = r1 + r3.right;
    L10:
        ViewCompat.setPaddingRelative(this, r2, getPaddingTop(), r1, getPaddingBottom());
        return;
    L13:
        return;
    }

    private void updateTextPaintDrawState() {
        TextPaint r0 = getPaint();
        ChipDrawable r1 = this.chipDrawable;
        if (r1 == null) goto L5;
        r0.drawableState = r1.getState();
    L5:
        TextAppearance r2 = getTextAppearance();
        if (r2 == null) goto L9;
        r2.updateDrawState(getContext(), r0, this.fontCallback);
        return;
    }

    private void validateAttributes(@Nullable AttributeSet r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.getAttributeValue(NAMESPACE_ANDROID, TraceCons.METRIC_BACKGROUND) == null) goto L8;
        Log.w(TAG, "Do not set the background; Chip manages its own background drawable.");
    L8:
        if (r4.getAttributeValue(NAMESPACE_ANDROID, "drawableLeft") != null) goto L36;
        if (r4.getAttributeValue(NAMESPACE_ANDROID, "drawableStart") != null) goto L34;
        if (r4.getAttributeValue(NAMESPACE_ANDROID, "drawableEnd") != null) goto L32;
        if (r4.getAttributeValue(NAMESPACE_ANDROID, "drawableRight") != null) goto L30;
        if (r4.getAttributeBooleanValue(NAMESPACE_ANDROID, "singleLine", true) == false) goto L28;
        if (r4.getAttributeIntValue(NAMESPACE_ANDROID, "lines", 1) != 1) goto L28;
        if (r4.getAttributeIntValue(NAMESPACE_ANDROID, "minLines", 1) != 1) goto L28;
        if (r4.getAttributeIntValue(NAMESPACE_ANDROID, "maxLines", 1) != 1) goto L28;
        if (r4.getAttributeIntValue(NAMESPACE_ANDROID, "gravity", 8388627) == 8388627) goto L37;
        Log.w(TAG, "Chip text must be vertically center and start aligned");
        return;
    L37:
        return;
    L28:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    L30:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L32:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L34:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    L36:
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(@NonNull MotionEvent r2) {
        if (this.touchHelperEnabled == true) goto L7;
        return super.dispatchHoverEvent(r2);
    L7:
        if (this.touchHelper.dispatchHoverEvent(r2) == false) goto L9;
    L12:
        return true;
    L9:
        if (super.dispatchHoverEvent(r2) == true) goto L12;
        return false;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent r3) {
        if (this.touchHelperEnabled == true) goto L7;
        return super.dispatchKeyEvent(r3);
    L7:
        if (this.touchHelper.dispatchKeyEvent(r3) == false) goto L13;
        if (this.touchHelper.getKeyboardFocusedVirtualViewId() == Integer.MIN_VALUE) goto L13;
        return true;
    L13:
        return super.dispatchKeyEvent(r3);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        invalidate();
        return;
    L11:
        return;
    L5:
        if (r0.isCloseIconStateful() == false) goto L7;
        r1 = this.chipDrawable.setCloseIconState(createCloseIconDrawableState());
        goto L8
    }

    public boolean ensureAccessibleTouchTarget(@Dimension int r6) {
        this.minTouchTargetSize = r6;
        int r1 = 0;
        if (shouldEnsureMinTouchTargetSize() == false) goto L5;
        int r0 = Math.max(0, r6 - this.chipDrawable.getIntrinsicHeight());
        int r2 = Math.max(0, r6 - this.chipDrawable.getIntrinsicWidth());
        if (r2 > 0) goto L17;
        if (r0 > 0) goto L17;
        if (this.insetBackgroundDrawable == null) goto L15;
        removeBackgroundInset();
    L16:
        return false;
    L15:
        updateBackgroundDrawable();
    L17:
        if (r2 <= 0) goto L19;
        int r3 = r2 / 2;
    L20:
        if (r0 <= 0) goto L23;
        r1 = r0 / 2;
    L23:
        if (this.insetBackgroundDrawable == null) goto L35;
        Rect r4 = new Rect();
        this.insetBackgroundDrawable.getPadding(r4);
        if (r4.top != r1) goto L35;
        if (r4.bottom != r1) goto L35;
        if (r4.left != r3) goto L35;
        if (r4.right != r3) goto L35;
        updateBackgroundDrawable();
        return true;
    L35:
        if (Build.VERSION.SDK_INT >= 16) goto L37;
        setMinHeight(r6);
    L43:
        setMinWidth(r6);
    L44:
        insetChipBackgroundDrawable(r3, r1, r3, r1);
        updateBackgroundDrawable();
        return true;
    L37:
        if (getMinHeight() == r6) goto L40;
        setMinHeight(r6);
    L40:
        if (getMinWidth() == r6) goto L44;
    L19:
        r3 = 0;
        goto L20
    L5:
        if (this.insetBackgroundDrawable == null) goto L7;
        removeBackgroundInset();
    L8:
        return false;
    L7:
        updateBackgroundDrawable();
        goto L8
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        if (isCheckable() == false) goto L13;
        ViewParent r1 = getParent();
        if ((r1 instanceof ChipGroup) == true) goto L7;
        return COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME;
    L7:
        if (((ChipGroup) r1).isSingleSelection() == false) goto L18;
        return RADIO_BUTTON_ACCESSIBILITY_CLASS_NAME;
    L18:
        return COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME;
    L13:
        if (isClickable() == false) goto L16;
        return BUTTON_ACCESSIBILITY_CLASS_NAME;
    L16:
        return GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME;
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable r0 = this.insetBackgroundDrawable;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.chipDrawable;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCheckedIcon();
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCheckedIconTint();
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getChipBackgroundColor();
    }

    public float getChipCornerRadius() {
        ChipDrawable r1 = this.chipDrawable;
        if (r1 != null) goto L5;
        return 0.0f;
    L5:
        return Math.max(0.0f, r1.getChipCornerRadius());
    }

    public Drawable getChipDrawable() {
        return this.chipDrawable;
    }

    public float getChipEndPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getChipEndPadding();
    }

    @Nullable
    public Drawable getChipIcon() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getChipIcon();
    }

    public float getChipIconSize() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getChipIconSize();
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getChipIconTint();
    }

    public float getChipMinHeight() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getChipMinHeight();
    }

    public float getChipStartPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getChipStartPadding();
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getChipStrokeColor();
    }

    public float getChipStrokeWidth() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getChipStrokeWidth();
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Nullable
    public Drawable getCloseIcon() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCloseIcon();
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCloseIconContentDescription();
    }

    public float getCloseIconEndPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getCloseIconEndPadding();
    }

    public float getCloseIconSize() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getCloseIconSize();
    }

    public float getCloseIconStartPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getCloseIconStartPadding();
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCloseIconTint();
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getEllipsize();
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@NonNull Rect r3) {
        if (this.touchHelperEnabled == true) goto L5;
    L9:
        super.getFocusedRect(r3);
        return;
    L5:
        if (this.touchHelper.getKeyboardFocusedVirtualViewId() != 1) goto L7;
    L8:
        r3.set(getCloseIconTouchBoundsInt());
        return;
    L7:
        if (this.touchHelper.getAccessibilityFocusedVirtualViewId() != 1) goto L9;
        goto L8
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHideMotionSpec();
    }

    public float getIconEndPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getIconEndPadding();
    }

    public float getIconStartPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getIconStartPadding();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRippleColor();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.chipDrawable.getShapeAppearanceModel();
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getShowMotionSpec();
    }

    public float getTextEndPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getTextEndPadding();
    }

    public float getTextStartPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getTextStartPadding();
    }

    public boolean isCheckable() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isCheckable() == false) goto L7;
        return true;
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isCheckedIconVisible() == false) goto L7;
        return true;
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isChipIconVisible() == false) goto L7;
        return true;
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public boolean isCloseIconVisible() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isCloseIconVisible() == false) goto L7;
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.chipDrawable);
    }

    @Override // com.google.android.material.chip.ChipDrawable.Delegate
    public void onChipDrawableSizeChange() {
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
        requestLayout();
        if (Build.VERSION.SDK_INT < 21) goto L6;
        invalidateOutline();
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int r2) {
        int[] r3 = super.onCreateDrawableState(r2 + 2);
        if (isChecked() == false) goto L6;
        CheckBox.mergeDrawableStates(r3, SELECTED_STATE);
    L6:
        if (isCheckable() == false) goto L8;
        CheckBox.mergeDrawableStates(r3, CHECKABLE_STATE_SET);
    L8:
        return r3;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean r2, int r3, Rect r4) {
        super.onFocusChanged(r2, r3, r4);
        if (this.touchHelperEnabled == false) goto L6;
        this.touchHelper.onFocusChanged(r2, r3, r4);
        return;
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent r4) {
        int r0 = r4.getActionMasked();
        if (r0 != 7) goto L5;
        boolean r1 = getCloseIconTouchBounds().contains(r4.getX(), r4.getY());
    L9:
        setCloseIconHovered(r1);
    L11:
        return super.onHoverEvent(r4);
    L5:
        if (r0 != 10) goto L11;
        r1 = false;
        goto L9
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r9) {
        super.onInitializeAccessibilityNodeInfo(r9);
        r9.setClassName(getAccessibilityClassName());
        r9.setCheckable(isCheckable());
        r9.setClickable(isClickable());
        if ((getParent() instanceof ChipGroup) == false) goto L10;
        ChipGroup r0 = (ChipGroup) getParent();
        AccessibilityNodeInfoCompat r10 = AccessibilityNodeInfoCompat.wrap(r9);
        if (r0.isSingleLine() == false) goto L7;
        int r1 = r0.getIndexOfChip(this);
    L8:
        int r2 = r0.getRowIndex(this);
        r10.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r2, 1, r1, 1, false, isChecked()));
        return;
    L7:
        r1 = -1;
        goto L8
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @Nullable
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@NonNull MotionEvent r2, int r3) {
        if (getCloseIconTouchBounds().contains(r2.getX(), r2.getY()) == true) goto L5;
        return null;
    L5:
        if (isEnabled() == true) goto L7;
        return null;
    L7:
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int r2) {
        super.onRtlPropertiesChanged(r2);
        if (this.lastLayoutDirection == r2) goto L6;
        this.lastLayoutDirection = r2;
        updatePaddingInternal();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NonNull MotionEvent r6) {
        int r0 = r6.getActionMasked();
        boolean r1 = getCloseIconTouchBounds().contains(r6.getX(), r6.getY());
        if (r0 == 0) goto L19;
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L11;
        if (r0 != 3) goto L22;
    L17:
        boolean r2 = false;
    L18:
        setCloseIconPressed(false);
    L23:
        if (r2 == true) goto L27;
        if (super.onTouchEvent(r6) == true) goto L27;
        return false;
    L27:
        return true;
    L22:
        r2 = false;
        goto L23
    L11:
        if (this.closeIconPressed == false) goto L22;
        if (r1 == true) goto L21;
        setCloseIconPressed(false);
    L21:
        r2 = true;
        goto L23
    L15:
        if (this.closeIconPressed == false) goto L17;
        performCloseIconClick();
        r2 = true;
        goto L18
    L19:
        if (r1 == false) goto L22;
        setCloseIconPressed(true);
        goto L21
    }

    @CallSuper
    public boolean performCloseIconClick() {
        boolean r0 = false;
        playSoundEffect(0);
        View.OnClickListener r1 = this.onCloseIconClickListener;
        if (r1 == null) goto L6;
        r1.onClick(this);
        r0 = true;
    L6:
        if (this.touchHelperEnabled == false) goto L8;
        this.touchHelper.sendEventForVirtualView(1, 1);
    L8:
        return r0;
    }

    @Override // android.view.View
    public void setBackground(Drawable r2) {
        if (r2 != getBackgroundDrawable()) goto L5;
    L7:
        super.setBackground(r2);
        return;
    L5:
        if (r2 == this.ripple) goto L7;
        Log.w(TAG, "Do not set the background; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        Log.w(TAG, "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable r2) {
        if (r2 != getBackgroundDrawable()) goto L5;
    L7:
        super.setBackgroundDrawable(r2);
        return;
    L5:
        if (r2 == this.ripple) goto L7;
        Log.w(TAG, "Do not set the background drawable; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int r1) {
        Log.w(TAG, "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList r1) {
        Log.w(TAG, "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode r1) {
        Log.w(TAG, "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckable(r1);
        return;
    }

    public void setCheckableResource(@BoolRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckableResource(r1);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L6;
        this.deferredCheckedValue = r2;
        return;
    L6:
        if (r0.isCheckable() == false) goto L14;
        boolean r1 = isChecked();
        super.setChecked(r2);
        if (r1 == r2) goto L15;
        CompoundButton.OnCheckedChangeListener r3 = this.onCheckedChangeListenerInternal;
        if (r3 == null) goto L16;
        r3.onCheckedChanged(this, r2);
        return;
    L16:
        return;
    L15:
        return;
    }

    public void setCheckedIcon(@Nullable Drawable r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckedIcon(r1);
        return;
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean r1) {
        setCheckedIconVisible(r1);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int r1) {
        setCheckedIconVisible(r1);
    }

    public void setCheckedIconResource(@DrawableRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckedIconResource(r1);
        return;
    }

    public void setCheckedIconTint(@Nullable ColorStateList r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckedIconTint(r1);
        return;
    }

    public void setCheckedIconTintResource(@ColorRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckedIconTintResource(r1);
        return;
    }

    public void setCheckedIconVisible(@BoolRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckedIconVisible(r1);
        return;
    }

    public void setCheckedIconVisible(boolean r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckedIconVisible(r1);
        return;
    }

    public void setChipBackgroundColor(@Nullable ColorStateList r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipBackgroundColor(r1);
        return;
    }

    public void setChipBackgroundColorResource(@ColorRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipBackgroundColorResource(r1);
        return;
    }

    @Deprecated
    public void setChipCornerRadius(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipCornerRadius(r1);
        return;
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipCornerRadiusResource(r1);
        return;
    }

    public void setChipDrawable(@NonNull ChipDrawable r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == r2) goto L6;
        unapplyChipDrawable(r0);
        this.chipDrawable = r2;
        r2.setShouldDrawText(false);
        applyChipDrawable(this.chipDrawable);
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
        return;
    }

    public void setChipEndPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipEndPadding(r1);
        return;
    }

    public void setChipEndPaddingResource(@DimenRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipEndPaddingResource(r1);
        return;
    }

    public void setChipIcon(@Nullable Drawable r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIcon(r1);
        return;
    }

    @Deprecated
    public void setChipIconEnabled(boolean r1) {
        setChipIconVisible(r1);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int r1) {
        setChipIconVisible(r1);
    }

    public void setChipIconResource(@DrawableRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconResource(r1);
        return;
    }

    public void setChipIconSize(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconSize(r1);
        return;
    }

    public void setChipIconSizeResource(@DimenRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconSizeResource(r1);
        return;
    }

    public void setChipIconTint(@Nullable ColorStateList r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconTint(r1);
        return;
    }

    public void setChipIconTintResource(@ColorRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconTintResource(r1);
        return;
    }

    public void setChipIconVisible(@BoolRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconVisible(r1);
        return;
    }

    public void setChipIconVisible(boolean r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconVisible(r1);
        return;
    }

    public void setChipMinHeight(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipMinHeight(r1);
        return;
    }

    public void setChipMinHeightResource(@DimenRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipMinHeightResource(r1);
        return;
    }

    public void setChipStartPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipStartPadding(r1);
        return;
    }

    public void setChipStartPaddingResource(@DimenRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipStartPaddingResource(r1);
        return;
    }

    public void setChipStrokeColor(@Nullable ColorStateList r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipStrokeColor(r1);
        return;
    }

    public void setChipStrokeColorResource(@ColorRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipStrokeColorResource(r1);
        return;
    }

    public void setChipStrokeWidth(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipStrokeWidth(r1);
        return;
    }

    public void setChipStrokeWidthResource(@DimenRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipStrokeWidthResource(r1);
        return;
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence r1) {
        setText(r1);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int r2) {
        setText(getResources().getString(r2));
    }

    public void setCloseIcon(@Nullable Drawable r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L5;
        r0.setCloseIcon(r2);
    L5:
        updateAccessibilityDelegate();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconContentDescription(r1);
        return;
    }

    @Deprecated
    public void setCloseIconEnabled(boolean r1) {
        setCloseIconVisible(r1);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int r1) {
        setCloseIconVisible(r1);
    }

    public void setCloseIconEndPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconEndPadding(r1);
        return;
    }

    public void setCloseIconEndPaddingResource(@DimenRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconEndPaddingResource(r1);
        return;
    }

    public void setCloseIconResource(@DrawableRes int r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L5;
        r0.setCloseIconResource(r2);
    L5:
        updateAccessibilityDelegate();
    }

    public void setCloseIconSize(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconSize(r1);
        return;
    }

    public void setCloseIconSizeResource(@DimenRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconSizeResource(r1);
        return;
    }

    public void setCloseIconStartPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconStartPadding(r1);
        return;
    }

    public void setCloseIconStartPaddingResource(@DimenRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconStartPaddingResource(r1);
        return;
    }

    public void setCloseIconTint(@Nullable ColorStateList r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconTint(r1);
        return;
    }

    public void setCloseIconTintResource(@ColorRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconTintResource(r1);
        return;
    }

    public void setCloseIconVisible(@BoolRes int r2) {
        setCloseIconVisible(getResources().getBoolean(r2));
    }

    public void setCloseIconVisible(boolean r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L5;
        r0.setCloseIconVisible(r2);
    L5:
        updateAccessibilityDelegate();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable r1, @Nullable Drawable r2, @Nullable Drawable r3, @Nullable Drawable r4) {
        if (r1 != null) goto L9;
        if (r3 != null) goto L7;
        super.setCompoundDrawables(r1, r2, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawablesRelative(@Nullable Drawable r1, @Nullable Drawable r2, @Nullable Drawable r3, @Nullable Drawable r4) {
        if (r1 != null) goto L9;
        if (r3 != null) goto L7;
        super.setCompoundDrawablesRelative(r1, r2, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int r1, int r2, int r3, int r4) {
        if (r1 != 0) goto L9;
        if (r3 != 0) goto L7;
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable r1, @Nullable Drawable r2, @Nullable Drawable r3, @Nullable Drawable r4) {
        if (r1 != null) goto L9;
        if (r3 != null) goto L7;
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int r1, int r2, int r3, int r4) {
        if (r1 != 0) goto L9;
        if (r3 != 0) goto L7;
        super.setCompoundDrawablesWithIntrinsicBounds(r1, r2, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable r1, @Nullable Drawable r2, @Nullable Drawable r3, @Nullable Drawable r4) {
        if (r1 != null) goto L9;
        if (r3 != null) goto L7;
        super.setCompoundDrawablesWithIntrinsicBounds(r1, r2, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r1) {
        super.setElevation(r1);
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setElevation(r1);
        return;
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt r2) {
        if (this.chipDrawable != null) goto L6;
        return;
    L6:
        if (r2 == TextUtils.TruncateAt.MARQUEE) goto L12;
        super.setEllipsize(r2);
        ChipDrawable r1 = this.chipDrawable;
        if (r1 == null) goto L13;
        r1.setEllipsize(r2);
        return;
    L13:
        return;
    L12:
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }

    public void setEnsureMinTouchTargetSize(boolean r1) {
        this.ensureMinTouchTargetSize = r1;
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
    }

    @Override // android.widget.TextView
    public void setGravity(int r2) {
        if (r2 == 8388627) goto L5;
        Log.w(TAG, "Chip text must be vertically center and start aligned");
        return;
    L5:
        super.setGravity(r2);
    }

    public void setHideMotionSpec(@Nullable MotionSpec r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setHideMotionSpec(r1);
        return;
    }

    public void setHideMotionSpecResource(@AnimatorRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setHideMotionSpecResource(r1);
        return;
    }

    public void setIconEndPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setIconEndPadding(r1);
        return;
    }

    public void setIconEndPaddingResource(@DimenRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setIconEndPaddingResource(r1);
        return;
    }

    public void setIconStartPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setIconStartPadding(r1);
        return;
    }

    public void setIconStartPaddingResource(@DimenRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setIconStartPaddingResource(r1);
        return;
    }

    @Override // android.view.View
    public void setLayoutDirection(int r3) {
        if (this.chipDrawable != null) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 17) goto L9;
        super.setLayoutDirection(r3);
        return;
    }

    @Override // android.widget.TextView
    public void setLines(int r2) {
        if (r2 > 1) goto L7;
        super.setLines(r2);
        return;
    L7:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int r2) {
        if (r2 > 1) goto L7;
        super.setMaxLines(r2);
        return;
    L7:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@Px int r1) {
        super.setMaxWidth(r1);
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setMaxWidth(r1);
        return;
    }

    @Override // android.widget.TextView
    public void setMinLines(int r2) {
        if (r2 > 1) goto L7;
        super.setMinLines(r2);
        return;
    L7:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener r1) {
        this.onCheckedChangeListenerInternal = r1;
    }

    public void setOnCloseIconClickListener(View.OnClickListener r1) {
        this.onCloseIconClickListener = r1;
        updateAccessibilityDelegate();
    }

    public void setRippleColor(@Nullable ColorStateList r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setRippleColor(r2);
    L6:
        if (this.chipDrawable.getUseCompatRipple() == true) goto L9;
        updateFrameworkRippleBackground();
        return;
    }

    public void setRippleColorResource(@ColorRes int r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L8;
        r0.setRippleColorResource(r2);
        if (this.chipDrawable.getUseCompatRipple() == true) goto L9;
        updateFrameworkRippleBackground();
        return;
    L9:
        return;
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r1) {
        this.chipDrawable.setShapeAppearanceModel(r1);
    }

    public void setShowMotionSpec(@Nullable MotionSpec r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setShowMotionSpec(r1);
        return;
    }

    public void setShowMotionSpecResource(@AnimatorRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setShowMotionSpecResource(r1);
        return;
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean r1) {
        if (r1 == false) goto L6;
        super.setSingleLine(r1);
        return;
    L6:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r2, TextView.BufferType r3) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        if (r0.shouldDrawText() == false) goto L10;
        CharSequence r1 = null;
    L11:
        super.setText(r1, r3);
        ChipDrawable r4 = this.chipDrawable;
        if (r4 == null) goto L15;
        r4.setText(r2);
        return;
    L15:
        return;
    L10:
        r1 = r2;
        goto L11
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int r2) {
        super.setTextAppearance(r2);
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L5;
        r0.setTextAppearanceResource(r2);
    L5:
        updateTextPaintDrawState();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context r1, int r2) {
        super.setTextAppearance(r1, r2);
        ChipDrawable r3 = this.chipDrawable;
        if (r3 == null) goto L5;
        r3.setTextAppearanceResource(r2);
    L5:
        updateTextPaintDrawState();
    }

    public void setTextAppearance(@Nullable TextAppearance r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L5;
        r0.setTextAppearance(r2);
    L5:
        updateTextPaintDrawState();
    }

    public void setTextAppearanceResource(@StyleRes int r2) {
        setTextAppearance(getContext(), r2);
    }

    public void setTextEndPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setTextEndPadding(r1);
        return;
    }

    public void setTextEndPaddingResource(@DimenRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setTextEndPaddingResource(r1);
        return;
    }

    public void setTextStartPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setTextStartPadding(r1);
        return;
    }

    public void setTextStartPaddingResource(@DimenRes int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setTextStartPaddingResource(r1);
        return;
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }
}
