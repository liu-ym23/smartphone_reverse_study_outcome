package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes2.dex */
class DropdownMenuEndIconDelegate extends EndIconDelegate {
    private static final int ANIMATION_FADE_IN_DURATION = 67;
    private static final int ANIMATION_FADE_OUT_DURATION = 50;
    private static final boolean IS_LOLLIPOP = false;
    private final TextInputLayout.AccessibilityDelegate accessibilityDelegate;
    private AccessibilityManager accessibilityManager;
    private final TextInputLayout.OnEditTextAttachedListener dropdownMenuOnEditTextAttachedListener;
    private long dropdownPopupActivatedAt;
    private boolean dropdownPopupDirty;
    private final TextInputLayout.OnEndIconChangedListener endIconChangedListener;
    private final TextWatcher exposedDropdownEndIconTextWatcher;
    private ValueAnimator fadeInAnim;
    private ValueAnimator fadeOutAnim;
    private StateListDrawable filledPopupBackground;
    private boolean isEndIconChecked;
    private final View.OnFocusChangeListener onFocusChangeListener;
    private MaterialShapeDrawable outlinedPopupBackground;

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean isBoxBackgroundModeSupported(int r1) {
        if (r1 == 0) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean shouldTintIconOnError() {
        return true;
    }

    static /* synthetic */ AutoCompleteTextView access$000(EditText r0) {
        return castAutoCompleteTextViewOrThrow(r0);
    }

    static /* synthetic */ AccessibilityManager access$100(DropdownMenuEndIconDelegate r0) {
        return r0.accessibilityManager;
    }

    static /* synthetic */ TextInputLayout.AccessibilityDelegate access$1000(DropdownMenuEndIconDelegate r0) {
        return r0.accessibilityDelegate;
    }

    static /* synthetic */ View.OnFocusChangeListener access$1100(DropdownMenuEndIconDelegate r0) {
        return r0.onFocusChangeListener;
    }

    static /* synthetic */ boolean access$1200() {
        return IS_LOLLIPOP;
    }

    static /* synthetic */ boolean access$1300(DropdownMenuEndIconDelegate r0) {
        return r0.isDropdownPopupActive();
    }

    static /* synthetic */ long access$1402(DropdownMenuEndIconDelegate r0, long r1) {
        r0.dropdownPopupActivatedAt = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1500(DropdownMenuEndIconDelegate r0) {
        return r0.isEndIconChecked;
    }

    static /* synthetic */ ValueAnimator access$1600(DropdownMenuEndIconDelegate r0) {
        return r0.fadeInAnim;
    }

    static /* synthetic */ boolean access$200(EditText r0) {
        return isEditable(r0);
    }

    static /* synthetic */ void access$300(DropdownMenuEndIconDelegate r0, boolean r1) {
        r0.setEndIconChecked(r1);
    }

    static /* synthetic */ boolean access$402(DropdownMenuEndIconDelegate r0, boolean r1) {
        r0.dropdownPopupDirty = r1;
        return r1;
    }

    static /* synthetic */ void access$500(DropdownMenuEndIconDelegate r0, AutoCompleteTextView r1) {
        r0.showHideDropdown(r1);
    }

    static /* synthetic */ void access$600(DropdownMenuEndIconDelegate r0, AutoCompleteTextView r1) {
        r0.setPopupBackground(r1);
    }

    static /* synthetic */ void access$700(DropdownMenuEndIconDelegate r0, AutoCompleteTextView r1) {
        r0.addRippleEffect(r1);
    }

    static /* synthetic */ void access$800(DropdownMenuEndIconDelegate r0, AutoCompleteTextView r1) {
        r0.setUpDropdownShowHideBehavior(r1);
    }

    static /* synthetic */ TextWatcher access$900(DropdownMenuEndIconDelegate r0) {
        return r0.exposedDropdownEndIconTextWatcher;
    }

    static {
        IS_LOLLIPOP = true;
    }

    DropdownMenuEndIconDelegate(TextInputLayout r3) {
        super(r3);
        this.exposedDropdownEndIconTextWatcher = new AnonymousClass1(this);
        this.onFocusChangeListener = new AnonymousClass2(this);
        final TextInputLayout r0 = this.textInputLayout;
        this.accessibilityDelegate = new AnonymousClass3(this, r0);
        this.dropdownMenuOnEditTextAttachedListener = new AnonymousClass4(this);
        this.endIconChangedListener = new AnonymousClass5(this);
        this.dropdownPopupDirty = false;
        this.isEndIconChecked = false;
        this.dropdownPopupActivatedAt = Long.MAX_VALUE;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void initialize() {
        float r0 = this.context.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float r1 = this.context.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int r2 = this.context.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable r3 = getPopUpMaterialShapeDrawable(r0, r0, r1, r2);
        MaterialShapeDrawable r4 = getPopUpMaterialShapeDrawable(0.0f, r0, r1, r2);
        this.outlinedPopupBackground = r3;
        StateListDrawable r5 = new StateListDrawable();
        this.filledPopupBackground = r5;
        r5.addState(new int[]{android.R.attr.state_above_anchor}, r3);
        this.filledPopupBackground.addState(new int[0], r4);
        if (IS_LOLLIPOP == false) goto L5;
        int r6 = R.drawable.mtrl_dropdown_arrow;
    L6:
        this.textInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.context, r6));
        this.textInputLayout.setEndIconContentDescription(this.textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.textInputLayout.setEndIconOnClickListener(new AnonymousClass6(this));
        this.textInputLayout.addOnEditTextAttachedListener(this.dropdownMenuOnEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.endIconChangedListener);
        initAnimators();
        this.accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
        return;
    L5:
        r6 = R.drawable.mtrl_ic_arrow_drop_down;
        goto L6
    }

    private void showHideDropdown(AutoCompleteTextView r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (isDropdownPopupActive() == false) goto L8;
        this.dropdownPopupDirty = false;
    L8:
        if (this.dropdownPopupDirty == false) goto L10;
        this.dropdownPopupDirty = false;
        return;
    L10:
        if (IS_LOLLIPOP == false) goto L12;
        setEndIconChecked(!this.isEndIconChecked);
    L14:
        if (this.isEndIconChecked == false) goto L16;
        r3.requestFocus();
        r3.showDropDown();
        return;
    L16:
        r3.dismissDropDown();
        return;
    L12:
        this.isEndIconChecked = !this.isEndIconChecked;
        this.endIconView.toggle();
        goto L14
    }

    private void setPopupBackground(AutoCompleteTextView r3) {
        if (IS_LOLLIPOP == false) goto L11;
        int r0 = this.textInputLayout.getBoxBackgroundMode();
        if (r0 != 2) goto L8;
        r3.setDropDownBackgroundDrawable(this.outlinedPopupBackground);
        return;
    L8:
        if (r0 != 1) goto L13;
        r3.setDropDownBackgroundDrawable(this.filledPopupBackground);
        return;
    L13:
        return;
    }

    private void addRippleEffect(AutoCompleteTextView r10) {
        if (isEditable(r10) == false) goto L5;
        return;
    L5:
        int r0 = this.textInputLayout.getBoxBackgroundMode();
        MaterialShapeDrawable r1 = this.textInputLayout.getBoxBackground();
        int r2 = MaterialColors.getColor(r10, R.attr.colorControlHighlight);
        int[][] r4 = {new int[]{android.R.attr.state_pressed}, new int[0]};
        if (r0 != 2) goto L8;
        addRippleEffectOnOutlinedLayout(r10, r2, r4, r1);
        return;
    L8:
        if (r0 != 1) goto L12;
        addRippleEffectOnFilledLayout(r10, r2, r4, r1);
        return;
    }

    private void addRippleEffectOnOutlinedLayout(AutoCompleteTextView r7, int r8, int[][] r9, MaterialShapeDrawable r10) {
        int r6 = MaterialColors.getColor(r7, R.attr.colorSurface);
        MaterialShapeDrawable r0 = new MaterialShapeDrawable(r10.getShapeAppearanceModel());
        int r11 = MaterialColors.layer(r8, r6, 0.1f);
        r0.setFillColor(new ColorStateList(r9, new int[]{r11, 0}));
        if (IS_LOLLIPOP == false) goto L5;
        r0.setTint(r6);
        ColorStateList r12 = new ColorStateList(r9, new int[]{r11, r6});
        MaterialShapeDrawable r13 = new MaterialShapeDrawable(r10.getShapeAppearanceModel());
        r13.setTint(-1);
        LayerDrawable r14 = new LayerDrawable(new Drawable[]{new RippleDrawable(r12, r0, r13), r10});
    L6:
        ViewCompat.setBackground(r7, r14);
        return;
    L5:
        r14 = new LayerDrawable(new Drawable[]{r0, r10});
        goto L6
    }

    private void addRippleEffectOnFilledLayout(AutoCompleteTextView r5, int r6, int[][] r7, MaterialShapeDrawable r8) {
        int r4 = this.textInputLayout.getBoxBackgroundColor();
        int[] r1 = {MaterialColors.layer(r6, r4, 0.1f), r4};
        if (IS_LOLLIPOP == false) goto L5;
        ViewCompat.setBackground(r5, new RippleDrawable(new ColorStateList(r7, r1), r8, r8));
        return;
    L5:
        MaterialShapeDrawable r9 = new MaterialShapeDrawable(r8.getShapeAppearanceModel());
        r9.setFillColor(new ColorStateList(r7, r1));
        LayerDrawable r10 = new LayerDrawable(new Drawable[]{r8, r9});
        int r11 = ViewCompat.getPaddingStart(r5);
        int r12 = r5.getPaddingTop();
        int r13 = ViewCompat.getPaddingEnd(r5);
        int r0 = r5.getPaddingBottom();
        ViewCompat.setBackground(r5, r10);
        ViewCompat.setPaddingRelative(r5, r11, r12, r13, r0);
    }

    private void setUpDropdownShowHideBehavior(final AutoCompleteTextView r2) {
        r2.setOnTouchListener(new AnonymousClass7(this, r2));
        r2.setOnFocusChangeListener(this.onFocusChangeListener);
        if (IS_LOLLIPOP == false) goto L6;
        r2.setOnDismissListener(new AnonymousClass8(this));
        return;
    }

    private MaterialShapeDrawable getPopUpMaterialShapeDrawable(float r2, float r3, float r4, int r5) {
        ShapeAppearanceModel r6 = ShapeAppearanceModel.builder().setTopLeftCornerSize(r2).setTopRightCornerSize(r2).setBottomLeftCornerSize(r3).setBottomRightCornerSize(r3).build();
        MaterialShapeDrawable r1 = MaterialShapeDrawable.createWithElevationOverlay(this.context, r4);
        r1.setShapeAppearanceModel(r6);
        r1.setPadding(0, r5, 0, r5);
        return r1;
    }

    private boolean isDropdownPopupActive() {
        long r0 = System.currentTimeMillis() - this.dropdownPopupActivatedAt;
        if (r0 >= 0) goto L5;
    L8:
        return true;
    L5:
        if (r0 > 300) goto L8;
        return false;
    }

    private static AutoCompleteTextView castAutoCompleteTextViewOrThrow(EditText r1) {
        if ((r1 instanceof AutoCompleteTextView) == false) goto L7;
        return (AutoCompleteTextView) r1;
    L7:
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private static boolean isEditable(EditText r0) {
        if (r0.getKeyListener() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void setEndIconChecked(boolean r2) {
        if (this.isEndIconChecked == r2) goto L6;
        this.isEndIconChecked = r2;
        this.fadeInAnim.cancel();
        this.fadeOutAnim.start();
        return;
    }

    private void initAnimators() {
        this.fadeInAnim = getAlphaAnimator(67, new float[]{0.0f, 1.0f});
        ValueAnimator r0 = getAlphaAnimator(50, new float[]{1.0f, 0.0f});
        this.fadeOutAnim = r0;
        r0.addListener(new AnonymousClass9(this));
    }

    private ValueAnimator getAlphaAnimator(int r3, float... r4) {
        ValueAnimator r5 = ValueAnimator.ofFloat(r4);
        r5.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r5.setDuration(r3);
        r5.addUpdateListener(new AnonymousClass10(this));
        return r5;
    }
}
