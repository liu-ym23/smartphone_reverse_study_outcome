package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: loaded from: classes.dex */
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

    public ClearTextEndIconDelegate(@NonNull TextInputLayout r1) {
        super(r1);
        this.clearTextEndIconTextWatcher = new AnonymousClass1(this);
        this.onFocusChangeListener = new AnonymousClass2(this);
        this.clearTextOnEditTextAttachedListener = new AnonymousClass3(this);
        this.endIconChangedListener = new AnonymousClass4(this);
    }

    public static /* synthetic */ boolean access$000(Editable r0) {
        return hasText(r0);
    }

    public static /* synthetic */ void access$100(ClearTextEndIconDelegate r0, boolean r1) {
        r0.animateIcon(r1);
    }

    public static /* synthetic */ View.OnFocusChangeListener access$200(ClearTextEndIconDelegate r0) {
        return r0.onFocusChangeListener;
    }

    public static /* synthetic */ TextWatcher access$300(ClearTextEndIconDelegate r0) {
        return r0.clearTextEndIconTextWatcher;
    }

    private void animateIcon(boolean r2) {
        if (this.textInputLayout.isEndIconVisible() != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r2 == false) goto L10;
        this.iconOutAnim.cancel();
        this.iconInAnim.start();
        if (r0 == false) goto L14;
        this.iconInAnim.end();
        return;
    L14:
        return;
    L10:
        this.iconInAnim.cancel();
        this.iconOutAnim.start();
        if (r0 == false) goto L16;
        this.iconOutAnim.end();
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private ValueAnimator getAlphaAnimator(float... r3) {
        ValueAnimator r4 = ValueAnimator.ofFloat(r3);
        r4.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r4.setDuration(100);
        r4.addUpdateListener(new AnonymousClass8(this));
        return r4;
    }

    private ValueAnimator getScaleAnimator() {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{ANIMATION_SCALE_FROM_VALUE, 1.0f});
        r0.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        r0.setDuration(150);
        r0.addUpdateListener(new AnonymousClass9(this));
        return r0;
    }

    private static boolean hasText(@NonNull Editable r0) {
        if (r0.length() <= 0) goto L5;
        return true;
    L5:
        return false;
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

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        this.textInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.context, R.drawable.mtrl_ic_cancel));
        TextInputLayout r0 = this.textInputLayout;
        r0.setEndIconContentDescription(r0.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.textInputLayout.setEndIconOnClickListener(new AnonymousClass5(this));
        this.textInputLayout.addOnEditTextAttachedListener(this.clearTextOnEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.endIconChangedListener);
        initAnimators();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void onSuffixVisibilityChanged(boolean r2) {
        if (this.textInputLayout.getSuffixText() != null) goto L5;
        return;
    L5:
        animateIcon(r2);
    }
}
