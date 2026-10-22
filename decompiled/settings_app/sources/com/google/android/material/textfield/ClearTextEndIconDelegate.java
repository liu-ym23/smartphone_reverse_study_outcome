package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: loaded from: classes3.dex */
class ClearTextEndIconDelegate extends EndIconDelegate {
    private static final int ANIMATION_FADE_DURATION = 100;
    private static final int ANIMATION_SCALE_DURATION = 150;
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    private final TextWatcher clearTextEndIconTextWatcher;
    private final TextInputLayout.OnEditTextAttachedListener clearTextOnEditTextAttachedListener;
    private final TextInputLayout.OnEndIconChangedListener endIconChangedListener;
    private AnimatorSet iconInAnim;
    private ValueAnimator iconOutAnim;
    private final View.OnFocusChangeListener onFocusChangeListener;

    static /* synthetic */ boolean access$000(ClearTextEndIconDelegate r0) {
        return r0.shouldBeVisible();
    }

    static /* synthetic */ void access$100(ClearTextEndIconDelegate r0, boolean r1) {
        r0.animateIcon(r1);
    }

    static /* synthetic */ View.OnFocusChangeListener access$200(ClearTextEndIconDelegate r0) {
        return r0.onFocusChangeListener;
    }

    static /* synthetic */ TextWatcher access$300(ClearTextEndIconDelegate r0) {
        return r0.clearTextEndIconTextWatcher;
    }

    ClearTextEndIconDelegate(TextInputLayout r1, int r2) {
        super(r1, r2);
        this.clearTextEndIconTextWatcher = new AnonymousClass1(this);
        this.onFocusChangeListener = new AnonymousClass2(this);
        this.clearTextOnEditTextAttachedListener = new AnonymousClass3(this);
        this.endIconChangedListener = new AnonymousClass4(this);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void initialize() {
        TextInputLayout r0 = this.textInputLayout;
        if (this.customEndIcon != 0) goto L5;
        int r1 = R.drawable.mtrl_ic_cancel;
    L6:
        r0.setEndIconDrawable(r1);
        this.textInputLayout.setEndIconContentDescription(this.textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.textInputLayout.setEndIconCheckable(false);
        this.textInputLayout.setEndIconOnClickListener(new AnonymousClass5(this));
        this.textInputLayout.addOnEditTextAttachedListener(this.clearTextOnEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.endIconChangedListener);
        initAnimators();
        return;
    L5:
        r1 = this.customEndIcon;
        goto L6
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void onSuffixVisibilityChanged(boolean r2) {
        if (this.textInputLayout.getSuffixText() != null) goto L5;
        return;
    L5:
        animateIcon(r2);
    }

    private void animateIcon(boolean r3) {
        if (this.textInputLayout.isEndIconVisible() != r3) goto L5;
        boolean r0 = true;
    L6:
        if (r3 == true) goto L8;
    L12:
        if (r3 == true) goto L19;
        this.iconInAnim.cancel();
        this.iconOutAnim.start();
        if (r0 == false) goto L20;
        this.iconOutAnim.end();
        return;
    L20:
        return;
    L19:
        return;
    L8:
        if (this.iconInAnim.isRunning() == true) goto L12;
        this.iconOutAnim.cancel();
        this.iconInAnim.start();
        if (r0 == false) goto L17;
        this.iconInAnim.end();
        return;
    L17:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void initAnimators() {
        ValueAnimator r0 = getScaleAnimator();
        ValueAnimator r2 = getAlphaAnimator(new float[]{0.0f, 1.0f});
        AnimatorSet r3 = new AnimatorSet();
        this.iconInAnim = r3;
        r3.playTogether(new Animator[]{r0, r2});
        this.iconInAnim.addListener(new AnonymousClass6(this));
        ValueAnimator r1 = getAlphaAnimator(new float[]{1.0f, 0.0f});
        this.iconOutAnim = r1;
        r1.addListener(new AnonymousClass7(this));
    }

    private ValueAnimator getAlphaAnimator(float... r3) {
        ValueAnimator r4 = ValueAnimator.ofFloat(r3);
        r4.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r4.setDuration(100);
        r4.addUpdateListener(new AnonymousClass8(this));
        return r4;
    }

    private ValueAnimator getScaleAnimator() {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        r0.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        r0.setDuration(150);
        r0.addUpdateListener(new AnonymousClass9(this));
        return r0;
    }

    private boolean shouldBeVisible() {
        EditText r0 = this.textInputLayout.getEditText();
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.hasFocus() == true) goto L9;
        if (this.endIconView.hasFocus() == false) goto L11;
    L9:
        if (r0.getText().length() <= 0) goto L11;
        return true;
    }
}
