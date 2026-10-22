package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: loaded from: classes3.dex */
class StartCompoundLayout extends LinearLayout {
    private boolean hintExpanded;
    private CharSequence prefixText;
    private final TextView prefixTextView;
    private View.OnLongClickListener startIconOnLongClickListener;
    private ColorStateList startIconTintList;
    private PorterDuff.Mode startIconTintMode;
    private final CheckableImageButton startIconView;
    private final TextInputLayout textInputLayout;

    StartCompoundLayout(TextInputLayout r5, TintTypedArray r6) {
        super(r5.getContext());
        this.textInputLayout = r5;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        CheckableImageButton r7 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, this, false);
        this.startIconView = r7;
        AppCompatTextView r0 = new AppCompatTextView(getContext());
        this.prefixTextView = r0;
        initStartIconView(r6);
        initPrefixTextView(r6);
        addView(r7);
        addView(r0);
    }

    private void initStartIconView(TintTypedArray r4) {
        if (MaterialResources.isFontScaleAtLeast1_3(getContext()) == false) goto L5;
        MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) this.startIconView.getLayoutParams(), 0);
    L5:
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        if (r4.hasValue(R.styleable.TextInputLayout_startIconTint) == false) goto L9;
        this.startIconTintList = MaterialResources.getColorStateList(getContext(), r4, R.styleable.TextInputLayout_startIconTint);
    L9:
        if (r4.hasValue(R.styleable.TextInputLayout_startIconTintMode) == false) goto L12;
        this.startIconTintMode = ViewUtils.parseTintMode(r4.getInt(R.styleable.TextInputLayout_startIconTintMode, -1), null);
    L12:
        if (r4.hasValue(R.styleable.TextInputLayout_startIconDrawable) == false) goto L18;
        setStartIconDrawable(r4.getDrawable(R.styleable.TextInputLayout_startIconDrawable));
        if (r4.hasValue(R.styleable.TextInputLayout_startIconContentDescription) == false) goto L16;
        setStartIconContentDescription(r4.getText(R.styleable.TextInputLayout_startIconContentDescription));
    L16:
        setStartIconCheckable(r4.getBoolean(R.styleable.TextInputLayout_startIconCheckable, true));
        return;
    }

    private void initPrefixTextView(TintTypedArray r4) {
        this.prefixTextView.setVisibility(8);
        this.prefixTextView.setId(R.id.textinput_prefix_text);
        this.prefixTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(this.prefixTextView, 1);
        setPrefixTextAppearance(r4.getResourceId(R.styleable.TextInputLayout_prefixTextAppearance, 0));
        if (r4.hasValue(R.styleable.TextInputLayout_prefixTextColor) == false) goto L5;
        setPrefixTextColor(r4.getColorStateList(R.styleable.TextInputLayout_prefixTextColor));
    L5:
        setPrefixText(r4.getText(R.styleable.TextInputLayout_prefixText));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        updatePrefixTextViewPadding();
    }

    TextView getPrefixTextView() {
        return this.prefixTextView;
    }

    void setPrefixText(CharSequence r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        CharSequence r0 = null;
    L6:
        this.prefixText = r0;
        this.prefixTextView.setText(r2);
        updateVisibility();
        return;
    L5:
        r0 = r2;
        goto L6
    }

    CharSequence getPrefixText() {
        return this.prefixText;
    }

    void setPrefixTextColor(ColorStateList r1) {
        this.prefixTextView.setTextColor(r1);
    }

    ColorStateList getPrefixTextColor() {
        return this.prefixTextView.getTextColors();
    }

    void setPrefixTextAppearance(int r1) {
        TextViewCompat.setTextAppearance(this.prefixTextView, r1);
    }

    void setStartIconDrawable(Drawable r4) {
        this.startIconView.setImageDrawable(r4);
        if (r4 == null) goto L5;
        IconHelper.applyIconTint(this.textInputLayout, this.startIconView, this.startIconTintList, this.startIconTintMode);
        setStartIconVisible(true);
        refreshStartIconDrawableState();
        return;
    L5:
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription(null);
    }

    Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    void setStartIconOnClickListener(View.OnClickListener r2) {
        IconHelper.setIconOnClickListener(this.startIconView, r2, this.startIconOnLongClickListener);
    }

    void setStartIconOnLongClickListener(View.OnLongClickListener r1) {
        this.startIconOnLongClickListener = r1;
        IconHelper.setIconOnLongClickListener(this.startIconView, r1);
    }

    void setStartIconVisible(boolean r2) {
        if (isStartIconVisible() == r2) goto L10;
        CheckableImageButton r0 = this.startIconView;
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        updatePrefixTextViewPadding();
        updateVisibility();
        return;
    L7:
        r3 = 8;
        goto L8
    }

    boolean isStartIconVisible() {
        if (this.startIconView.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    void refreshStartIconDrawableState() {
        IconHelper.refreshIconDrawableState(this.textInputLayout, this.startIconView, this.startIconTintList);
    }

    void setStartIconCheckable(boolean r1) {
        this.startIconView.setCheckable(r1);
    }

    boolean isStartIconCheckable() {
        return this.startIconView.isCheckable();
    }

    void setStartIconContentDescription(CharSequence r2) {
        if (getStartIconContentDescription() == r2) goto L6;
        this.startIconView.setContentDescription(r2);
        return;
    }

    CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    void setStartIconTintList(ColorStateList r3) {
        if (this.startIconTintList == r3) goto L6;
        this.startIconTintList = r3;
        IconHelper.applyIconTint(this.textInputLayout, this.startIconView, r3, this.startIconTintMode);
        return;
    }

    void setStartIconTintMode(PorterDuff.Mode r3) {
        if (this.startIconTintMode == r3) goto L6;
        this.startIconTintMode = r3;
        IconHelper.applyIconTint(this.textInputLayout, this.startIconView, this.startIconTintList, r3);
        return;
    }

    void setupAccessibilityNodeInfo(AccessibilityNodeInfoCompat r2) {
        if (this.prefixTextView.getVisibility() != 0) goto L5;
        r2.setLabelFor(this.prefixTextView);
        r2.setTraversalAfter(this.prefixTextView);
        return;
    L5:
        r2.setTraversalAfter(this.startIconView);
    }

    void updatePrefixTextViewPadding() {
        EditText r0 = this.textInputLayout.editText;
        if (r0 != null) goto L6;
        return;
    L6:
        if (isStartIconVisible() == false) goto L8;
        int r1 = 0;
    L9:
        ViewCompat.setPaddingRelative(this.prefixTextView, r1, r0.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), r0.getCompoundPaddingBottom());
        return;
    L8:
        r1 = ViewCompat.getPaddingStart(r0);
        goto L9
    }

    void onHintStateChanged(boolean r1) {
        this.hintExpanded = r1;
        updateVisibility();
    }

    private void updateVisibility() {
        int r1 = 8;
        if (this.prefixText != null) goto L5;
    L7:
        int r0 = 8;
    L9:
        if (this.startIconView.getVisibility() == 0) goto L13;
        if (r0 == 0) goto L13;
        boolean r3 = false;
    L14:
        if (r3 == false) goto L16;
        r1 = 0;
    L16:
        setVisibility(r1);
        this.prefixTextView.setVisibility(r0);
        this.textInputLayout.updateDummyDrawables();
        return;
    L13:
        r3 = true;
        goto L14
    L5:
        if (this.hintExpanded == true) goto L7;
        r0 = 0;
        goto L9
    }
}
