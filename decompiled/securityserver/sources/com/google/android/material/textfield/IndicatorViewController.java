package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class IndicatorViewController {
    private static final int CAPTION_OPACITY_FADE_ANIMATION_DURATION = 167;
    private static final int CAPTION_STATE_ERROR = 1;
    private static final int CAPTION_STATE_HELPER_TEXT = 2;
    private static final int CAPTION_STATE_NONE = 0;
    private static final int CAPTION_TRANSLATE_Y_ANIMATION_DURATION = 217;
    static final int COUNTER_INDEX = 2;
    static final int ERROR_INDEX = 0;
    static final int HELPER_INDEX = 1;

    @Nullable
    private Animator captionAnimator;
    private FrameLayout captionArea;
    private int captionDisplayed;
    private int captionToShow;
    private final float captionTranslationYPx;
    private int captionViewsAdded;
    private final Context context;
    private boolean errorEnabled;

    @Nullable
    private CharSequence errorText;
    private int errorTextAppearance;

    @Nullable
    private TextView errorView;

    @Nullable
    private CharSequence errorViewContentDescription;

    @Nullable
    private ColorStateList errorViewTextColor;
    private CharSequence helperText;
    private boolean helperTextEnabled;
    private int helperTextTextAppearance;

    @Nullable
    private TextView helperTextView;

    @Nullable
    private ColorStateList helperTextViewTextColor;
    private LinearLayout indicatorArea;
    private int indicatorsAdded;

    @NonNull
    private final TextInputLayout textInputView;
    private Typeface typeface;

    public IndicatorViewController(@NonNull TextInputLayout r2) {
        Context r0 = r2.getContext();
        this.context = r0;
        this.textInputView = r2;
        this.captionTranslationYPx = r0.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    public static /* synthetic */ int access$002(IndicatorViewController r0, int r1) {
        r0.captionDisplayed = r1;
        return r1;
    }

    public static /* synthetic */ Animator access$102(IndicatorViewController r0, Animator r1) {
        r0.captionAnimator = r1;
        return r1;
    }

    public static /* synthetic */ TextView access$200(IndicatorViewController r0) {
        return r0.errorView;
    }

    private boolean canAdjustIndicatorPadding() {
        if (this.indicatorArea != null) goto L5;
    L7:
        return false;
    L5:
        if (this.textInputView.getEditText() == null) goto L7;
        return true;
    }

    private void createCaptionAnimators(@NonNull List<Animator> r1, boolean r2, @Nullable TextView r3, int r4, int r5, int r6) {
        if (r3 == null) goto L14;
        if (r2 == false) goto L17;
        if (r4 == r6) goto L7;
        if (r4 == r5) goto L7;
        return;
    L7:
        if (r6 != r4) goto L9;
        boolean r7 = true;
    L10:
        r1.add(createCaptionOpacityAnimator(r3, r7));
        if (r6 != r4) goto L16;
        r1.add(createCaptionTranslationYAnimator(r3));
        return;
    L16:
        return;
    L9:
        r7 = false;
        goto L10
    L17:
        return;
    }

    private ObjectAnimator createCaptionOpacityAnimator(TextView r3, boolean r4) {
        if (r4 == false) goto L4;
        float r2 = 1.0f;
    L5:
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r3, View.ALPHA, new float[]{r2});
        r5.setDuration(167);
        r5.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return r5;
    L4:
        r2 = 0.0f;
        goto L5
    }

    private ObjectAnimator createCaptionTranslationYAnimator(TextView r4) {
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r4, View.TRANSLATION_Y, new float[]{-this.captionTranslationYPx, 0.0f});
        r3.setDuration(217);
        r3.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        return r3;
    }

    @Nullable
    private TextView getCaptionViewFromDisplayState(int r2) {
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L9;
        return null;
    L9:
        return this.helperTextView;
    L11:
        return this.errorView;
    }

    private boolean isCaptionStateError(int r2) {
        if (r2 == 1) goto L5;
    L9:
        return false;
    L5:
        if (this.errorView == null) goto L9;
        if (TextUtils.isEmpty(this.errorText) == true) goto L9;
        return true;
    }

    private boolean isCaptionStateHelperText(int r2) {
        if (r2 == 2) goto L5;
    L9:
        return false;
    L5:
        if (this.helperTextView == null) goto L9;
        if (TextUtils.isEmpty(this.helperText) == true) goto L9;
        return true;
    }

    private void setCaptionViewVisibilities(int r3, int r4) {
        if (r3 != r4) goto L4;
        return;
    L4:
        if (r4 == 0) goto L8;
        TextView r0 = getCaptionViewFromDisplayState(r4);
        if (r0 == null) goto L8;
        r0.setVisibility(0);
        r0.setAlpha(1.0f);
    L8:
        if (r3 == 0) goto L14;
        TextView r1 = getCaptionViewFromDisplayState(r3);
        if (r1 == null) goto L14;
        r1.setVisibility(4);
        if (r3 != 1) goto L14;
        r1.setText(null);
    L14:
        this.captionDisplayed = r4;
    }

    private void setTextViewTypeface(@Nullable TextView r1, Typeface r2) {
        if (r1 == null) goto L5;
        r1.setTypeface(r2);
        return;
    }

    private void setViewGroupGoneIfEmpty(@NonNull ViewGroup r1, int r2) {
        if (r2 != 0) goto L5;
        r1.setVisibility(8);
        return;
    }

    private boolean shouldAnimateCaptionView(@Nullable TextView r2, @Nullable CharSequence r3) {
        if (ViewCompat.isLaidOut(this.textInputView) == true) goto L5;
    L12:
        return false;
    L5:
        if (this.textInputView.isEnabled() == false) goto L12;
        if (this.captionToShow != this.captionDisplayed) goto L11;
        if (r2 == null) goto L11;
        if (TextUtils.equals(r2.getText(), r3) == true) goto L12;
    L11:
        return true;
    }

    private void updateCaptionViewsVisibility(final int r14, final int r15, boolean r16) {
        if (r14 != r15) goto L5;
        return;
    L5:
        if (r16 == false) goto L7;
        AnimatorSet r11 = new AnimatorSet();
        this.captionAnimator = r11;
        ArrayList r12 = new ArrayList();
        createCaptionAnimators(r12, this.helperTextEnabled, this.helperTextView, 2, r14, r15);
        createCaptionAnimators(r12, this.errorEnabled, this.errorView, 1, r14, r15);
        AnimatorSetCompat.playTogether(r11, r12);
        final TextView r3 = getCaptionViewFromDisplayState(r14);
        final TextView r5 = getCaptionViewFromDisplayState(r15);
        r11.addListener(new AnonymousClass1(this, r15, r3, r14, r5));
        r11.start();
    L8:
        this.textInputView.updateEditTextBackground();
        this.textInputView.updateLabelState(r16);
        this.textInputView.updateTextInputBoxState();
        return;
    L7:
        setCaptionViewVisibilities(r14, r15);
        goto L8
    }

    public void addIndicator(TextView r6, int r7) {
        if (this.indicatorArea != null) goto L10;
        if (this.captionArea != null) goto L10;
        LinearLayout r0 = new LinearLayout(this.context);
        this.indicatorArea = r0;
        r0.setOrientation(0);
        this.textInputView.addView(this.indicatorArea, -1, -2);
        this.captionArea = new FrameLayout(this.context);
        this.indicatorArea.addView(this.captionArea, new LinearLayout.LayoutParams(0, -2, 1.0f));
        if (this.textInputView.getEditText() == null) goto L10;
        adjustIndicatorPadding();
    L10:
        if (isCaptionView(r7) == false) goto L12;
        this.captionArea.setVisibility(0);
        this.captionArea.addView(r6);
        this.captionViewsAdded++;
    L13:
        this.indicatorArea.setVisibility(0);
        this.indicatorsAdded++;
        return;
    L12:
        this.indicatorArea.addView(r6, new LinearLayout.LayoutParams(-2, -2));
        goto L13
    }

    public void adjustIndicatorPadding() {
        if (canAdjustIndicatorPadding() == false) goto L6;
        ViewCompat.setPaddingRelative(this.indicatorArea, ViewCompat.getPaddingStart(this.textInputView.getEditText()), 0, ViewCompat.getPaddingEnd(this.textInputView.getEditText()), 0);
        return;
    }

    public void cancelCaptionAnimator() {
        Animator r0 = this.captionAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public boolean errorIsDisplayed() {
        return isCaptionStateError(this.captionDisplayed);
    }

    public boolean errorShouldBeShown() {
        return isCaptionStateError(this.captionToShow);
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.errorViewContentDescription;
    }

    @Nullable
    public CharSequence getErrorText() {
        return this.errorText;
    }

    @ColorInt
    public int getErrorViewCurrentTextColor() {
        TextView r0 = this.errorView;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getCurrentTextColor();
    }

    @Nullable
    public ColorStateList getErrorViewTextColors() {
        TextView r0 = this.errorView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTextColors();
    }

    public CharSequence getHelperText() {
        return this.helperText;
    }

    @Nullable
    public ColorStateList getHelperTextViewColors() {
        TextView r0 = this.helperTextView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTextColors();
    }

    @ColorInt
    public int getHelperTextViewCurrentTextColor() {
        TextView r0 = this.helperTextView;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getCurrentTextColor();
    }

    public boolean helperTextIsDisplayed() {
        return isCaptionStateHelperText(this.captionDisplayed);
    }

    public boolean helperTextShouldBeShown() {
        return isCaptionStateHelperText(this.captionToShow);
    }

    public void hideError() {
        this.errorText = null;
        cancelCaptionAnimator();
        if (this.captionDisplayed == 1) goto L5;
    L10:
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, null));
        return;
    L5:
        if (this.helperTextEnabled == true) goto L7;
    L9:
        this.captionToShow = 0;
        goto L10
    L7:
        if (TextUtils.isEmpty(this.helperText) == true) goto L9;
        this.captionToShow = 2;
        goto L10
    }

    public void hideHelperText() {
        cancelCaptionAnimator();
        int r0 = this.captionDisplayed;
        if (r0 != 2) goto L5;
        this.captionToShow = 0;
    L5:
        updateCaptionViewsVisibility(r0, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, null));
    }

    public boolean isCaptionView(int r1) {
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public boolean isErrorEnabled() {
        return this.errorEnabled;
    }

    public boolean isHelperTextEnabled() {
        return this.helperTextEnabled;
    }

    public void removeIndicator(TextView r2, int r3) {
        if (this.indicatorArea != null) goto L6;
        return;
    L6:
        if (isCaptionView(r3) == false) goto L10;
        FrameLayout r4 = this.captionArea;
        if (r4 == null) goto L10;
        int r0 = this.captionViewsAdded - 1;
        this.captionViewsAdded = r0;
        setViewGroupGoneIfEmpty(r4, r0);
        this.captionArea.removeView(r2);
    L11:
        int r5 = this.indicatorsAdded - 1;
        this.indicatorsAdded = r5;
        setViewGroupGoneIfEmpty(this.indicatorArea, r5);
        return;
    L10:
        this.indicatorArea.removeView(r2);
        goto L11
    }

    public void setErrorContentDescription(@Nullable CharSequence r1) {
        this.errorViewContentDescription = r1;
        TextView r0 = this.errorView;
        if (r0 == null) goto L6;
        r0.setContentDescription(r1);
        return;
    }

    public void setErrorEnabled(boolean r4) {
        if (this.errorEnabled != r4) goto L5;
        return;
    L5:
        cancelCaptionAnimator();
        if (r4 == false) goto L11;
        AppCompatTextView r1 = new AppCompatTextView(this.context);
        this.errorView = r1;
        r1.setId(R.id.textinput_error);
        this.errorView.setTextAlignment(5);
        Typeface r2 = this.typeface;
        if (r2 == null) goto L10;
        this.errorView.setTypeface(r2);
    L10:
        setErrorTextAppearance(this.errorTextAppearance);
        setErrorViewTextColor(this.errorViewTextColor);
        setErrorContentDescription(this.errorViewContentDescription);
        this.errorView.setVisibility(4);
        ViewCompat.setAccessibilityLiveRegion(this.errorView, 1);
        addIndicator(this.errorView, 0);
    L12:
        this.errorEnabled = r4;
        return;
    L11:
        hideError();
        removeIndicator(this.errorView, 0);
        this.errorView = null;
        this.textInputView.updateEditTextBackground();
        this.textInputView.updateTextInputBoxState();
        goto L12
    }

    public void setErrorTextAppearance(@StyleRes int r2) {
        this.errorTextAppearance = r2;
        TextView r0 = this.errorView;
        if (r0 == null) goto L6;
        this.textInputView.setTextAppearanceCompatWithErrorFallback(r0, r2);
        return;
    }

    public void setErrorViewTextColor(@Nullable ColorStateList r1) {
        this.errorViewTextColor = r1;
        TextView r0 = this.errorView;
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        r0.setTextColor(r1);
        return;
    L8:
        return;
    }

    public void setHelperTextAppearance(@StyleRes int r1) {
        this.helperTextTextAppearance = r1;
        TextView r0 = this.helperTextView;
        if (r0 == null) goto L6;
        TextViewCompat.setTextAppearance(r0, r1);
        return;
    }

    public void setHelperTextEnabled(boolean r4) {
        if (this.helperTextEnabled != r4) goto L5;
        return;
    L5:
        cancelCaptionAnimator();
        if (r4 == false) goto L11;
        AppCompatTextView r1 = new AppCompatTextView(this.context);
        this.helperTextView = r1;
        r1.setId(R.id.textinput_helper_text);
        this.helperTextView.setTextAlignment(5);
        Typeface r2 = this.typeface;
        if (r2 == null) goto L10;
        this.helperTextView.setTypeface(r2);
    L10:
        this.helperTextView.setVisibility(4);
        ViewCompat.setAccessibilityLiveRegion(this.helperTextView, 1);
        setHelperTextAppearance(this.helperTextTextAppearance);
        setHelperTextViewTextColor(this.helperTextViewTextColor);
        addIndicator(this.helperTextView, 1);
    L12:
        this.helperTextEnabled = r4;
        return;
    L11:
        hideHelperText();
        removeIndicator(this.helperTextView, 1);
        this.helperTextView = null;
        this.textInputView.updateEditTextBackground();
        this.textInputView.updateTextInputBoxState();
        goto L12
    }

    public void setHelperTextViewTextColor(@Nullable ColorStateList r1) {
        this.helperTextViewTextColor = r1;
        TextView r0 = this.helperTextView;
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        r0.setTextColor(r1);
        return;
    L8:
        return;
    }

    public void setTypefaces(Typeface r2) {
        if (r2 == this.typeface) goto L6;
        this.typeface = r2;
        setTextViewTypeface(this.errorView, r2);
        setTextViewTypeface(this.helperTextView, r2);
        return;
    }

    public void showError(CharSequence r4) {
        cancelCaptionAnimator();
        this.errorText = r4;
        this.errorView.setText(r4);
        int r0 = this.captionDisplayed;
        if (r0 == 1) goto L5;
        this.captionToShow = 1;
    L5:
        updateCaptionViewsVisibility(r0, this.captionToShow, shouldAnimateCaptionView(this.errorView, r4));
    }

    public void showHelper(CharSequence r4) {
        cancelCaptionAnimator();
        this.helperText = r4;
        this.helperTextView.setText(r4);
        int r0 = this.captionDisplayed;
        if (r0 == 2) goto L5;
        this.captionToShow = 2;
    L5:
        updateCaptionViewsVisibility(r0, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, r4));
    }
}
