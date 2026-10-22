package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    private static final int[] SELECTED_STATE = null;
    private static final String TAG = "Chip";
    private ChipDrawable chipDrawable;
    private boolean closeIconFocused;
    private boolean closeIconHovered;
    private boolean closeIconPressed;
    private boolean deferredCheckedValue;
    private boolean ensureMinTouchTargetSize;
    private final TextAppearanceFontCallback fontCallback;
    private InsetDrawable insetBackgroundDrawable;
    private int lastLayoutDirection;
    private int minTouchTargetSize;
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListenerInternal;
    private View.OnClickListener onCloseIconClickListener;
    private final Rect rect;
    private final RectF rectF;
    private RippleDrawable ripple;
    private final ChipTouchHelper touchHelper;

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
        protected void getVisibleVirtualViews(List<Integer> r2) {
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
        protected void onVirtualViewKeyboardFocusChanged(int r2, boolean r3) {
            if (r2 != 1) goto L6;
            Chip.access$402(this.this$0, r3);
            this.this$0.refreshDrawableState();
            return;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int r6, AccessibilityNodeInfoCompat r7) {
            CharSequence r0 = "";
            if (r6 != 1) goto L12;
            CharSequence r8 = this.this$0.getCloseIconContentDescription();
            if (r8 == null) goto L7;
            r7.setContentDescription(r8);
        L11:
            r7.setBoundsInParent(Chip.access$500(this.this$0));
            r7.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            r7.setEnabled(this.this$0.isEnabled());
            return;
        L7:
            CharSequence r9 = this.this$0.getText();
            Context r2 = this.this$0.getContext();
            int r3 = R.string.mtrl_chip_close_icon_content_description;
            Object[] r1 = new Object[1];
            if (TextUtils.isEmpty(r9) == true) goto L10;
            r0 = r9;
        L10:
            r1[0] = r0;
            r7.setContentDescription(r2.getString(r3, r1).trim());
            goto L11
        L12:
            r7.setContentDescription("");
            r7.setBoundsInParent(Chip.access$600());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForHost(AccessibilityNodeInfoCompat r2) {
            r2.setCheckable(this.this$0.isCheckable());
            r2.setClickable(this.this$0.isClickable());
            if (this.this$0.isCheckable() == true) goto L9;
            if (this.this$0.isClickable() == true) goto L9;
            r2.setClassName(Chip.GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
        L13:
            r2.setText(this.this$0.getText());
            return;
        L9:
            if (this.this$0.isCheckable() == false) goto L11;
            String r0 = Chip.COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME;
        L12:
            r2.setClassName(r0);
            goto L13
        L11:
            r0 = Chip.BUTTON_ACCESSIBILITY_CLASS_NAME;
            goto L12
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

    public Chip(Context r7, AttributeSet r8, int r9) {
        int r4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r7, r8, r9, r4), r8, r9);
        this.rect = new Rect();
        this.rectF = new RectF();
        this.fontCallback = new AnonymousClass1(this);
        Context r0 = getContext();
        validateAttributes(r8);
        ChipDrawable r10 = ChipDrawable.createFromAttributes(r0, r8, r9, r4);
        initMinTouchTarget(r0, r8, r9);
        setChipDrawable(r10);
        r10.setElevation(ViewCompat.getElevation(this));
        TypedArray r11 = ThemeEnforcement.obtainStyledAttributes(r0, r8, R.styleable.Chip, r9, r4, new int[0]);
        boolean r12 = r11.hasValue(R.styleable.Chip_shapeAppearance);
        r11.recycle();
        this.touchHelper = new ChipTouchHelper(this, this);
        updateAccessibilityDelegate();
        if (r12 == true) goto L5;
        initOutlineProvider();
    L5:
        setChecked(this.deferredCheckedValue);
        setText(r10.getText());
        setEllipsize(r10.getEllipsize());
        updateTextPaintDrawState();
        if (this.chipDrawable.shouldDrawText() == true) goto L8;
        setLines(1);
        setHorizontallyScrolling(true);
    L8:
        setGravity(8388627);
        updatePaddingInternal();
        if (shouldEnsureMinTouchTargetSize() == false) goto L11;
        setMinHeight(this.minTouchTargetSize);
    L11:
        this.lastLayoutDirection = ViewCompat.getLayoutDirection(this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.chipDrawable);
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setElevation(r1);
        return;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r9) {
        super.onInitializeAccessibilityNodeInfo(r9);
        if (isCheckable() == true) goto L9;
        if (isClickable() == true) goto L9;
        r9.setClassName(GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
    L13:
        r9.setCheckable(isCheckable());
        r9.setClickable(isClickable());
        if ((getParent() instanceof ChipGroup) == false) goto L21;
        ChipGroup r0 = (ChipGroup) getParent();
        AccessibilityNodeInfoCompat r10 = AccessibilityNodeInfoCompat.wrap(r9);
        if (r0.isSingleLine() == false) goto L18;
        int r1 = r0.getIndexOfChip(this);
    L19:
        int r2 = r0.getRowIndex(this);
        r10.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r2, 1, r1, 1, false, isChecked()));
        return;
    L18:
        r1 = -1;
        goto L19
    L21:
        return;
    L9:
        if (isCheckable() == false) goto L11;
        String r3 = COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME;
    L12:
        r9.setClassName(r3);
        goto L13
    L11:
        r3 = BUTTON_ACCESSIBILITY_CLASS_NAME;
        goto L12
    }

    private void updateAccessibilityDelegate() {
        if (hasCloseIcon() == true) goto L5;
    L9:
        ViewCompat.setAccessibilityDelegate(this, null);
        return;
    L5:
        if (isCloseIconVisible() == false) goto L9;
        if (this.onCloseIconClickListener == null) goto L9;
        ViewCompat.setAccessibilityDelegate(this, this.touchHelper);
    }

    private void initMinTouchTarget(Context r8, AttributeSet r9, int r10) {
        TypedArray r11 = ThemeEnforcement.obtainStyledAttributes(r8, r9, R.styleable.Chip, r10, DEF_STYLE_RES, new int[0]);
        this.ensureMinTouchTargetSize = r11.getBoolean(R.styleable.Chip_ensureMinTouchTargetSize, false);
        this.minTouchTargetSize = (int) Math.ceil(r11.getDimension(R.styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(ViewUtils.dpToPx(getContext(), 48))));
        r11.recycle();
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

    @Override // android.widget.TextView, android.view.View
    public void onRtlPropertiesChanged(int r2) {
        super.onRtlPropertiesChanged(r2);
        if (this.lastLayoutDirection == r2) goto L6;
        this.lastLayoutDirection = r2;
        updatePaddingInternal();
        return;
    }

    private void validateAttributes(AttributeSet r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.getAttributeValue(NAMESPACE_ANDROID, "background") == null) goto L8;
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

    private void initOutlineProvider() {
        setOutlineProvider(new AnonymousClass2(this));
    }

    public Drawable getChipDrawable() {
        return this.chipDrawable;
    }

    public void setChipDrawable(ChipDrawable r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == r2) goto L6;
        unapplyChipDrawable(r0);
        this.chipDrawable = r2;
        r2.setShouldDrawText(false);
        applyChipDrawable(this.chipDrawable);
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
        return;
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

    private void ensureChipDrawableHasCallback() {
        if (getBackgroundDrawable() == this.insetBackgroundDrawable) goto L5;
        return;
    L5:
        if (this.chipDrawable.getCallback() != null) goto L9;
        this.chipDrawable.setCallback(this.insetBackgroundDrawable);
        return;
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable r0 = this.insetBackgroundDrawable;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.chipDrawable;
    }

    private void updateFrameworkRippleBackground() {
        this.ripple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.chipDrawable.getRippleColor()), getBackgroundDrawable(), null);
        this.chipDrawable.setUseCompatRipple(false);
        ViewCompat.setBackground(this, this.ripple);
        updatePaddingInternal();
    }

    private void unapplyChipDrawable(ChipDrawable r1) {
        if (r1 == null) goto L5;
        r1.setDelegate(null);
        return;
    }

    private void applyChipDrawable(ChipDrawable r1) {
        r1.setDelegate(this);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int r2) {
        int[] r3 = super.onCreateDrawableState(r2 + 2);
        if (isChecked() == false) goto L6;
        mergeDrawableStates(r3, SELECTED_STATE);
    L6:
        if (isCheckable() == false) goto L8;
        mergeDrawableStates(r3, CHECKABLE_STATE_SET);
    L8:
        return r3;
    }

    @Override // android.widget.TextView
    public void setGravity(int r2) {
        if (r2 == 8388627) goto L5;
        Log.w(TAG, "Chip text must be vertically center and start aligned");
        return;
    L5:
        super.setGravity(r2);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList r1) {
        Log.w(TAG, "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode r1) {
        Log.w(TAG, "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        Log.w(TAG, "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int r1) {
        Log.w(TAG, "Do not set the background resource; Chip manages its own background drawable.");
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

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawables(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        if (r1 != null) goto L9;
        if (r3 != null) goto L7;
        super.setCompoundDrawables(r1, r2, r3, r4);
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
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        if (r1 != null) goto L9;
        if (r3 != null) goto L7;
        super.setCompoundDrawablesWithIntrinsicBounds(r1, r2, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
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
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
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
    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getEllipsize();
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

    @Override // android.widget.TextView
    public void setSingleLine(boolean r1) {
        if (r1 == false) goto L6;
        super.setSingleLine(r1);
        return;
    L6:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
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
    public void setMinLines(int r2) {
        if (r2 > 1) goto L7;
        super.setMinLines(r2);
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
    public void setMaxWidth(int r1) {
        super.setMaxWidth(r1);
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setMaxWidth(r1);
        return;
    }

    @Override // com.google.android.material.chip.ChipDrawable.Delegate
    public void onChipDrawableSizeChange() {
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
        requestLayout();
        invalidateOutline();
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

    void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener r1) {
        this.onCheckedChangeListenerInternal = r1;
    }

    public void setOnCloseIconClickListener(View.OnClickListener r1) {
        this.onCloseIconClickListener = r1;
        updateAccessibilityDelegate();
    }

    public boolean performCloseIconClick() {
        boolean r0 = false;
        playSoundEffect(0);
        View.OnClickListener r1 = this.onCloseIconClickListener;
        if (r1 == null) goto L5;
        r1.onClick(this);
        r0 = true;
    L5:
        this.touchHelper.sendEventForVirtualView(1, 1);
        return r0;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r6) {
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
        if (r2 == false) goto L25;
        return true;
    L25:
        if (super.onTouchEvent(r6) == false) goto L28;
        return true;
    L28:
        return false;
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

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r4) {
        int r0 = r4.getActionMasked();
        if (r0 != 7) goto L5;
        setCloseIconHovered(getCloseIconTouchBounds().contains(r4.getX(), r4.getY()));
    L10:
        return super.onHoverEvent(r4);
    L5:
        if (r0 != 10) goto L10;
        setCloseIconHovered(false);
        goto L10
    }

    private boolean handleAccessibilityExit(MotionEvent r9) {
        if (r9.getAction() == 10) goto L17;
    L16:
        return false;
    L17:
        Field r10 = ExploreByTouchHelper.class.getDeclaredField("mHoveredVirtualViewId");     // Catch: NoSuchFieldException -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        r10.setAccessible(true);     // Catch: NoSuchFieldException -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        if (((Integer) r10.get(this.touchHelper)).intValue() == Integer.MIN_VALUE) goto L16;
        Method r11 = ExploreByTouchHelper.class.getDeclaredMethod("updateHoveredVirtualView", new Class[]{Integer.TYPE});     // Catch: NoSuchFieldException -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        r11.setAccessible(true);     // Catch: NoSuchFieldException -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        r11.invoke(this.touchHelper, new Object[]{Integer.MIN_VALUE});     // Catch: NoSuchFieldException -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        return true;
    L12:
        e = move-exception;
        Log.e(TAG, "Unable to send Accessibility Exit event", e);
    L8:
        e = move-exception;
        Log.e(TAG, "Unable to send Accessibility Exit event", e);
    L14:
        e = move-exception;
        Log.e(TAG, "Unable to send Accessibility Exit event", e);
    L10:
        e = move-exception;
        Log.e(TAG, "Unable to send Accessibility Exit event", e);
        goto L16
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent r2) {
        if (handleAccessibilityExit(r2) == false) goto L5;
    L10:
        return true;
    L5:
        if (this.touchHelper.dispatchHoverEvent(r2) == true) goto L10;
        if (super.dispatchHoverEvent(r2) == true) goto L10;
        return false;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent r3) {
        if (this.touchHelper.dispatchKeyEvent(r3) == false) goto L9;
        if (this.touchHelper.getKeyboardFocusedVirtualViewId() == Integer.MIN_VALUE) goto L9;
        return true;
    L9:
        return super.dispatchKeyEvent(r3);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean r1, int r2, Rect r3) {
        super.onFocusChanged(r1, r2, r3);
        this.touchHelper.onFocusChanged(r1, r2, r3);
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect r3) {
        if (this.touchHelper.getKeyboardFocusedVirtualViewId() != 1) goto L5;
    L8:
        r3.set(getCloseIconTouchBoundsInt());
        return;
    L5:
        if (this.touchHelper.getAccessibilityFocusedVirtualViewId() == 1) goto L8;
        super.getFocusedRect(r3);
    }

    private void setCloseIconPressed(boolean r2) {
        if (this.closeIconPressed == r2) goto L6;
        this.closeIconPressed = r2;
        refreshDrawableState();
        return;
    }

    private void setCloseIconHovered(boolean r2) {
        if (this.closeIconHovered == r2) goto L6;
        this.closeIconHovered = r2;
        refreshDrawableState();
        return;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    private int[] createCloseIconDrawableState() {
        ?? r0 = isEnabled();
        int r1 = r0;
        if (this.closeIconFocused == false) goto L5;
        r1 = r0 + 1;
    L5:
        int r2 = r1;
        if (this.closeIconHovered == false) goto L8;
        r2 = r1 + 1;
    L8:
        int r3 = r2;
        if (this.closeIconPressed == false) goto L11;
        r3 = r2 + 1;
    L11:
        int r4 = r3;
        if (isChecked() == false) goto L14;
        r4 = r3 + 1;
    L14:
        int[] r5 = new int[r4];
        int r6 = 0;
        if (isEnabled() == false) goto L18;
        r5[0] = 16842910;
        r6 = 1;
    L18:
        if (this.closeIconFocused == false) goto L21;
        r5[r6] = 16842908;
        r6 = r6 + 1;
    L21:
        if (this.closeIconHovered == false) goto L24;
        r5[r6] = 16843623;
        r6 = r6 + 1;
    L24:
        if (this.closeIconPressed == false) goto L27;
        r5[r6] = 16842919;
        r6 = r6 + 1;
    L27:
        if (isChecked() == false) goto L29;
        r5[r6] = 16842913;
    L29:
        return r5;
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

    private RectF getCloseIconTouchBounds() {
        this.rectF.setEmpty();
        if (hasCloseIcon() == false) goto L8;
        if (this.onCloseIconClickListener == null) goto L8;
        this.chipDrawable.getCloseIconTouchBounds(this.rectF);
    L8:
        return this.rectF;
    }

    private Rect getCloseIconTouchBoundsInt() {
        RectF r0 = getCloseIconTouchBounds();
        this.rect.set((int) r0.left, (int) r0.top, (int) r0.right, (int) r0.bottom);
        return this.rect;
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent r2, int r3) {
        if (getCloseIconTouchBounds().contains(r2.getX(), r2.getY()) == true) goto L5;
        return null;
    L5:
        if (isEnabled() == true) goto L7;
        return null;
    L7:
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    public ColorStateList getChipBackgroundColor() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getChipBackgroundColor();
    }

    public void setChipBackgroundColorResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipBackgroundColorResource(r1);
        return;
    }

    public void setChipBackgroundColor(ColorStateList r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipBackgroundColor(r1);
        return;
    }

    public float getChipMinHeight() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getChipMinHeight();
    }

    public void setChipMinHeightResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipMinHeightResource(r1);
        return;
    }

    public void setChipMinHeight(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipMinHeight(r1);
        return;
    }

    public float getChipCornerRadius() {
        ChipDrawable r1 = this.chipDrawable;
        if (r1 != null) goto L5;
        return 0.0f;
    L5:
        return Math.max(0.0f, r1.getChipCornerRadius());
    }

    @Deprecated
    public void setChipCornerRadiusResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipCornerRadiusResource(r1);
        return;
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel r1) {
        this.chipDrawable.setShapeAppearanceModel(r1);
    }

    @Override // com.google.android.material.shape.Shapeable
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.chipDrawable.getShapeAppearanceModel();
    }

    @Deprecated
    public void setChipCornerRadius(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipCornerRadius(r1);
        return;
    }

    public ColorStateList getChipStrokeColor() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getChipStrokeColor();
    }

    public void setChipStrokeColorResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipStrokeColorResource(r1);
        return;
    }

    public void setChipStrokeColor(ColorStateList r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipStrokeColor(r1);
        return;
    }

    public float getChipStrokeWidth() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getChipStrokeWidth();
    }

    public void setChipStrokeWidthResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipStrokeWidthResource(r1);
        return;
    }

    public void setChipStrokeWidth(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipStrokeWidth(r1);
        return;
    }

    public ColorStateList getRippleColor() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRippleColor();
    }

    public void setRippleColorResource(int r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L8;
        r0.setRippleColorResource(r2);
        if (this.chipDrawable.getUseCompatRipple() == true) goto L9;
        updateFrameworkRippleBackground();
        return;
    L9:
        return;
    }

    public void setRippleColor(ColorStateList r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setRippleColor(r2);
    L6:
        if (this.chipDrawable.getUseCompatRipple() == true) goto L9;
        updateFrameworkRippleBackground();
        return;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Override // android.view.View
    public void setLayoutDirection(int r2) {
        if (this.chipDrawable != null) goto L5;
        return;
    L5:
        super.setLayoutDirection(r2);
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

    @Deprecated
    public void setChipTextResource(int r2) {
        setText(getResources().getString(r2));
    }

    @Deprecated
    public void setChipText(CharSequence r1) {
        setText(r1);
    }

    public void setTextAppearanceResource(int r2) {
        setTextAppearance(getContext(), r2);
    }

    public void setTextAppearance(TextAppearance r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L5;
        r0.setTextAppearance(r2);
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

    @Override // android.widget.TextView
    public void setTextAppearance(int r2) {
        super.setTextAppearance(r2);
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L5;
        r0.setTextAppearanceResource(r2);
    L5:
        updateTextPaintDrawState();
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

    private TextAppearance getTextAppearance() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTextAppearance();
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
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public void setChipIconVisible(int r1) {
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

    @Deprecated
    public void setChipIconEnabledResource(int r1) {
        setChipIconVisible(r1);
    }

    @Deprecated
    public void setChipIconEnabled(boolean r1) {
        setChipIconVisible(r1);
    }

    public Drawable getChipIcon() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getChipIcon();
    }

    public void setChipIconResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconResource(r1);
        return;
    }

    public void setChipIcon(Drawable r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIcon(r1);
        return;
    }

    public ColorStateList getChipIconTint() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getChipIconTint();
    }

    public void setChipIconTintResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconTintResource(r1);
        return;
    }

    public void setChipIconTint(ColorStateList r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconTint(r1);
        return;
    }

    public float getChipIconSize() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getChipIconSize();
    }

    public void setChipIconSizeResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconSizeResource(r1);
        return;
    }

    public void setChipIconSize(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconSize(r1);
        return;
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

    @Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public void setCloseIconVisible(int r2) {
        setCloseIconVisible(getResources().getBoolean(r2));
    }

    public void setCloseIconVisible(boolean r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L5;
        r0.setCloseIconVisible(r2);
    L5:
        updateAccessibilityDelegate();
    }

    @Deprecated
    public void setCloseIconEnabledResource(int r1) {
        setCloseIconVisible(r1);
    }

    @Deprecated
    public void setCloseIconEnabled(boolean r1) {
        setCloseIconVisible(r1);
    }

    public Drawable getCloseIcon() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCloseIcon();
    }

    public void setCloseIconResource(int r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L5;
        r0.setCloseIconResource(r2);
    L5:
        updateAccessibilityDelegate();
    }

    public void setCloseIcon(Drawable r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L5;
        r0.setCloseIcon(r2);
    L5:
        updateAccessibilityDelegate();
    }

    public ColorStateList getCloseIconTint() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCloseIconTint();
    }

    public void setCloseIconTintResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconTintResource(r1);
        return;
    }

    public void setCloseIconTint(ColorStateList r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconTint(r1);
        return;
    }

    public float getCloseIconSize() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getCloseIconSize();
    }

    public void setCloseIconSizeResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconSizeResource(r1);
        return;
    }

    public void setCloseIconSize(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconSize(r1);
        return;
    }

    public void setCloseIconContentDescription(CharSequence r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconContentDescription(r1);
        return;
    }

    public CharSequence getCloseIconContentDescription() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCloseIconContentDescription();
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

    public void setCheckableResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckableResource(r1);
        return;
    }

    public void setCheckable(boolean r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckable(r1);
        return;
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
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public void setCheckedIconVisible(int r1) {
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

    @Deprecated
    public void setCheckedIconEnabledResource(int r1) {
        setCheckedIconVisible(r1);
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean r1) {
        setCheckedIconVisible(r1);
    }

    public Drawable getCheckedIcon() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCheckedIcon();
    }

    public void setCheckedIconResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckedIconResource(r1);
        return;
    }

    public void setCheckedIcon(Drawable r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckedIcon(r1);
        return;
    }

    public ColorStateList getCheckedIconTint() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCheckedIconTint();
    }

    public void setCheckedIconTintResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckedIconTintResource(r1);
        return;
    }

    public void setCheckedIconTint(ColorStateList r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckedIconTint(r1);
        return;
    }

    public MotionSpec getShowMotionSpec() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getShowMotionSpec();
    }

    public void setShowMotionSpecResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setShowMotionSpecResource(r1);
        return;
    }

    public void setShowMotionSpec(MotionSpec r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setShowMotionSpec(r1);
        return;
    }

    public MotionSpec getHideMotionSpec() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHideMotionSpec();
    }

    public void setHideMotionSpecResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setHideMotionSpecResource(r1);
        return;
    }

    public void setHideMotionSpec(MotionSpec r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setHideMotionSpec(r1);
        return;
    }

    public float getChipStartPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getChipStartPadding();
    }

    public void setChipStartPaddingResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipStartPaddingResource(r1);
        return;
    }

    public void setChipStartPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipStartPadding(r1);
        return;
    }

    public float getIconStartPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getIconStartPadding();
    }

    public void setIconStartPaddingResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setIconStartPaddingResource(r1);
        return;
    }

    public void setIconStartPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setIconStartPadding(r1);
        return;
    }

    public float getIconEndPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getIconEndPadding();
    }

    public void setIconEndPaddingResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setIconEndPaddingResource(r1);
        return;
    }

    public void setIconEndPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setIconEndPadding(r1);
        return;
    }

    public float getTextStartPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getTextStartPadding();
    }

    public void setTextStartPaddingResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setTextStartPaddingResource(r1);
        return;
    }

    public void setTextStartPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setTextStartPadding(r1);
        return;
    }

    public float getTextEndPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getTextEndPadding();
    }

    public void setTextEndPaddingResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setTextEndPaddingResource(r1);
        return;
    }

    public void setTextEndPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setTextEndPadding(r1);
        return;
    }

    public float getCloseIconStartPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getCloseIconStartPadding();
    }

    public void setCloseIconStartPaddingResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconStartPaddingResource(r1);
        return;
    }

    public void setCloseIconStartPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconStartPadding(r1);
        return;
    }

    public float getCloseIconEndPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getCloseIconEndPadding();
    }

    public void setCloseIconEndPaddingResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconEndPaddingResource(r1);
        return;
    }

    public void setCloseIconEndPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconEndPadding(r1);
        return;
    }

    public float getChipEndPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getChipEndPadding();
    }

    public void setChipEndPaddingResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipEndPaddingResource(r1);
        return;
    }

    public void setChipEndPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipEndPadding(r1);
        return;
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }

    public void setEnsureMinTouchTargetSize(boolean r1) {
        this.ensureMinTouchTargetSize = r1;
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
    }

    public boolean ensureAccessibleTouchTarget(int r6) {
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
        if (getMinHeight() == r6) goto L38;
        setMinHeight(r6);
    L38:
        if (getMinWidth() == r6) goto L40;
        setMinWidth(r6);
    L40:
        insetChipBackgroundDrawable(r3, r1, r3, r1);
        updateBackgroundDrawable();
        return true;
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

    private void removeBackgroundInset() {
        if (this.insetBackgroundDrawable == null) goto L6;
        this.insetBackgroundDrawable = null;
        setMinWidth(0);
        setMinHeight((int) getChipMinHeight());
        updateBackgroundDrawable();
        return;
    }

    private void insetChipBackgroundDrawable(int r8, int r9, int r10, int r11) {
        this.insetBackgroundDrawable = new InsetDrawable(this.chipDrawable, r8, r9, r10, r11);
    }
}
