package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes.dex */
class DropdownMenuEndIconDelegate extends EndIconDelegate {
    private static final int ANIMATION_FADE_IN_DURATION = 67;
    private static final int ANIMATION_FADE_OUT_DURATION = 50;
    private static final boolean IS_LOLLIPOP = false;
    private final TextInputLayout.AccessibilityDelegate accessibilityDelegate;

    @Nullable
    private AccessibilityManager accessibilityManager;
    private final TextInputLayout.OnEditTextAttachedListener dropdownMenuOnEditTextAttachedListener;
    private long dropdownPopupActivatedAt;
    private boolean dropdownPopupDirty;

    @SuppressLint({"ClickableViewAccessibility"})
    private final TextInputLayout.OnEndIconChangedListener endIconChangedListener;
    private final TextWatcher exposedDropdownEndIconTextWatcher;
    private ValueAnimator fadeInAnim;
    private ValueAnimator fadeOutAnim;
    private StateListDrawable filledPopupBackground;
    private boolean isEndIconChecked;
    private final View.OnFocusChangeListener onFocusChangeListener;
    private MaterialShapeDrawable outlinedPopupBackground;

    static {
        IS_LOLLIPOP = true;
    }

    public DropdownMenuEndIconDelegate(@NonNull TextInputLayout r3) {
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

    public static /* synthetic */ AutoCompleteTextView access$000(DropdownMenuEndIconDelegate r0, EditText r1) {
        return r0.castAutoCompleteTextViewOrThrow(r1);
    }

    public static /* synthetic */ void access$100(DropdownMenuEndIconDelegate r0, boolean r1) {
        r0.setEndIconChecked(r1);
    }

    public static /* synthetic */ View.OnFocusChangeListener access$1000(DropdownMenuEndIconDelegate r0) {
        return r0.onFocusChangeListener;
    }

    public static /* synthetic */ boolean access$1100() {
        return IS_LOLLIPOP;
    }

    public static /* synthetic */ boolean access$1200(DropdownMenuEndIconDelegate r0) {
        return r0.isDropdownPopupActive();
    }

    public static /* synthetic */ long access$1302(DropdownMenuEndIconDelegate r0, long r1) {
        r0.dropdownPopupActivatedAt = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1400(DropdownMenuEndIconDelegate r0) {
        return r0.isEndIconChecked;
    }

    public static /* synthetic */ ValueAnimator access$1500(DropdownMenuEndIconDelegate r0) {
        return r0.fadeInAnim;
    }

    public static /* synthetic */ boolean access$202(DropdownMenuEndIconDelegate r0, boolean r1) {
        r0.dropdownPopupDirty = r1;
        return r1;
    }

    public static /* synthetic */ AccessibilityManager access$300(DropdownMenuEndIconDelegate r0) {
        return r0.accessibilityManager;
    }

    public static /* synthetic */ void access$400(DropdownMenuEndIconDelegate r0, AutoCompleteTextView r1) {
        r0.showHideDropdown(r1);
    }

    public static /* synthetic */ void access$500(DropdownMenuEndIconDelegate r0, AutoCompleteTextView r1) {
        r0.setPopupBackground(r1);
    }

    public static /* synthetic */ void access$600(DropdownMenuEndIconDelegate r0, AutoCompleteTextView r1) {
        r0.addRippleEffect(r1);
    }

    public static /* synthetic */ void access$700(DropdownMenuEndIconDelegate r0, AutoCompleteTextView r1) {
        r0.setUpDropdownShowHideBehavior(r1);
    }

    public static /* synthetic */ TextWatcher access$800(DropdownMenuEndIconDelegate r0) {
        return r0.exposedDropdownEndIconTextWatcher;
    }

    public static /* synthetic */ TextInputLayout.AccessibilityDelegate access$900(DropdownMenuEndIconDelegate r0) {
        return r0.accessibilityDelegate;
    }

    private void addRippleEffect(@NonNull AutoCompleteTextView r6) {
        if (r6.getKeyListener() == null) goto L5;
        return;
    L5:
        int r0 = this.textInputLayout.getBoxBackgroundMode();
        MaterialShapeDrawable r1 = this.textInputLayout.getBoxBackground();
        int r2 = MaterialColors.getColor(r6, R.attr.colorControlHighlight);
        int[][] r3 = {new int[]{android.R.attr.state_pressed}, new int[0]};
        if (r0 != 2) goto L9;
        addRippleEffectOnOutlinedLayout(r6, r2, r3, r1);
        return;
    L9:
        if (r0 != 1) goto L13;
        addRippleEffectOnFilledLayout(r6, r2, r3, r1);
        return;
    }

    private void addRippleEffectOnFilledLayout(@NonNull AutoCompleteTextView r2, int r3, int[][] r4, @NonNull MaterialShapeDrawable r5) {
        int r1 = this.textInputLayout.getBoxBackgroundColor();
        int[] r6 = {MaterialColors.layer(r3, r1, 0.1f), r1};
        if (IS_LOLLIPOP == false) goto L5;
        ViewCompat.setBackground(r2, new RippleDrawable(new ColorStateList(r4, r6), r5, r5));
        return;
    L5:
        MaterialShapeDrawable r7 = new MaterialShapeDrawable(r5.getShapeAppearanceModel());
        r7.setFillColor(new ColorStateList(r4, r6));
        LayerDrawable r8 = new LayerDrawable(new Drawable[]{r5, r7});
        int r9 = ViewCompat.getPaddingStart(r2);
        int r10 = r2.getPaddingTop();
        int r11 = ViewCompat.getPaddingEnd(r2);
        int r0 = r2.getPaddingBottom();
        ViewCompat.setBackground(r2, r8);
        ViewCompat.setPaddingRelative(r2, r9, r10, r11, r0);
    }

    private void addRippleEffectOnOutlinedLayout(@NonNull AutoCompleteTextView r7, int r8, int[][] r9, @NonNull MaterialShapeDrawable r10) {
        int r1 = MaterialColors.getColor(r7, R.attr.colorSurface);
        MaterialShapeDrawable r2 = new MaterialShapeDrawable(r10.getShapeAppearanceModel());
        int r11 = MaterialColors.layer(r8, r1, 0.1f);
        r2.setFillColor(new ColorStateList(r9, new int[]{r11, 0}));
        if (IS_LOLLIPOP == false) goto L5;
        r2.setTint(r1);
        ColorStateList r3 = new ColorStateList(r9, new int[]{r11, r1});
        MaterialShapeDrawable r12 = new MaterialShapeDrawable(r10.getShapeAppearanceModel());
        r12.setTint(-1);
        LayerDrawable r6 = new LayerDrawable(new Drawable[]{new RippleDrawable(r3, r2, r12), r10});
    L6:
        ViewCompat.setBackground(r7, r6);
        return;
    L5:
        r6 = new LayerDrawable(new Drawable[]{r2, r10});
        goto L6
    }

    @NonNull
    private AutoCompleteTextView castAutoCompleteTextViewOrThrow(EditText r1) {
        if ((r1 instanceof AutoCompleteTextView) == false) goto L7;
        return (AutoCompleteTextView) r1;
    L7:
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator getAlphaAnimator(int r3, float... r4) {
        ValueAnimator r5 = ValueAnimator.ofFloat(r4);
        r5.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r5.setDuration(r3);
        r5.addUpdateListener(new AnonymousClass10(this));
        return r5;
    }

    private MaterialShapeDrawable getPopUpMaterialShapeDrawable(float r2, float r3, float r4, int r5) {
        ShapeAppearanceModel r6 = ShapeAppearanceModel.builder().setTopLeftCornerSize(r2).setTopRightCornerSize(r2).setBottomLeftCornerSize(r3).setBottomRightCornerSize(r3).build();
        MaterialShapeDrawable r1 = MaterialShapeDrawable.createWithElevationOverlay(this.context, r4);
        r1.setShapeAppearanceModel(r6);
        r1.setPadding(0, r5, 0, r5);
        return r1;
    }

    private void initAnimators() {
        this.fadeInAnim = getAlphaAnimator(67, new float[]{0.0f, 1.0f});
        ValueAnimator r0 = getAlphaAnimator(50, new float[]{1.0f, 0.0f});
        this.fadeOutAnim = r0;
        r0.addListener(new AnonymousClass9(this));
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

    private void setEndIconChecked(boolean r2) {
        if (this.isEndIconChecked == r2) goto L6;
        this.isEndIconChecked = r2;
        this.fadeInAnim.cancel();
        this.fadeOutAnim.start();
        return;
    }

    private void setPopupBackground(@NonNull AutoCompleteTextView r3) {
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

    @SuppressLint({"ClickableViewAccessibility"})
    private void setUpDropdownShowHideBehavior(@NonNull final AutoCompleteTextView r2) {
        r2.setOnTouchListener(new AnonymousClass7(this, r2));
        r2.setOnFocusChangeListener(this.onFocusChangeListener);
        if (IS_LOLLIPOP == false) goto L6;
        r2.setOnDismissListener(new AnonymousClass8(this));
        return;
    }

    private void showHideDropdown(@Nullable AutoCompleteTextView r3) {
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

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
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
        TextInputLayout r7 = this.textInputLayout;
        r7.setEndIconContentDescription(r7.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.textInputLayout.setEndIconOnClickListener(new AnonymousClass6(this));
        this.textInputLayout.addOnEditTextAttachedListener(this.dropdownMenuOnEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.endIconChangedListener);
        initAnimators();
        ViewCompat.setImportantForAccessibility(this.endIconView, 2);
        this.accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
        return;
    L5:
        r6 = R.drawable.mtrl_ic_arrow_drop_down;
        goto L6
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean isBoxBackgroundModeSupported(int r1) {
        if (r1 == 0) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean shouldTintIconOnError() {
        return true;
    }
}
