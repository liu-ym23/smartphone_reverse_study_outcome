package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatTextView extends TextView implements TintableBackgroundView, TintableCompoundDrawablesView, AutoSizeableTextView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;

    @Nullable
    private Future<PrecomputedTextCompat> mPrecomputedTextFuture;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatTextView(@NonNull Context r2) {
        this(r2, null);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<PrecomputedTextCompat> r0 = this.mPrecomputedTextFuture;
        if (r0 != null) goto L8;
        return;
    L8:
        this.mPrecomputedTextFuture = null;     // Catch: Throwable -> L7
        TextViewCompat.setPrecomputedText(this, r0.get());     // Catch: Throwable -> L7
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L5;
        r0.applySupportBackgroundTint();
    L5:
        AppCompatTextHelper r1 = this.mTextHelper;
        if (r1 == null) goto L9;
        r1.applyCompoundDrawablesTints();
        return;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMaxTextSize() {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r1 = this.mTextHelper;
        if (r1 != null) goto L9;
        return -1;
    L9:
        return r1.getAutoSizeMaxTextSize();
    L5:
        return super.getAutoSizeMaxTextSize();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMinTextSize() {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r1 = this.mTextHelper;
        if (r1 != null) goto L9;
        return -1;
    L9:
        return r1.getAutoSizeMinTextSize();
    L5:
        return super.getAutoSizeMinTextSize();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeStepGranularity() {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r1 = this.mTextHelper;
        if (r1 != null) goto L9;
        return -1;
    L9:
        return r1.getAutoSizeStepGranularity();
    L5:
        return super.getAutoSizeStepGranularity();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] getAutoSizeTextAvailableSizes() {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r1 = this.mTextHelper;
        if (r1 == null) goto L11;
        return r1.getAutoSizeTextAvailableSizes();
    L11:
        return new int[0];
    L5:
        return super.getAutoSizeTextAvailableSizes();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeTextType() {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r2 = this.mTextHelper;
        if (r2 != null) goto L11;
        return 0;
    L11:
        return r2.getAutoSizeTextType();
    L5:
        if (super.getAutoSizeTextType() == 1) goto L7;
        return 0;
    L7:
        return 1;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.getFirstBaselineToTopHeight(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.getLastBaselineToBottomHeight(this);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.getCompoundDrawableTintList();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.getCompoundDrawableTintMode();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    @Override // android.widget.TextView
    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
        return super.getTextClassifier();
    }

    @NonNull
    public PrecomputedTextCompat.Params getTextMetricsParamsCompat() {
        return TextViewCompat.getTextMetricsParams(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r2) {
        return AppCompatHintHelper.onCreateInputConnection(super.onCreateInputConnection(r2), r2, this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        super.onLayout(r7, r8, r9, r10, r11);
        AppCompatTextHelper r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.onLayout(r7, r8, r9, r10, r11);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r1, int r2) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        super.onTextChanged(r1, r2, r3, r4);
        AppCompatTextHelper r5 = this.mTextHelper;
        if (r5 != null) goto L5;
        return;
    L5:
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == false) goto L7;
        return;
    L7:
        if (r5.isAutoSizeEnabled() == false) goto L12;
        this.mTextHelper.autoSizeText();
        return;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithConfiguration(int r2, int r3, int r4, int r5) {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == false) goto L5;
        super.setAutoSizeTextTypeUniformWithConfiguration(r2, r3, r4, r5);
        return;
    L5:
        AppCompatTextHelper r1 = this.mTextHelper;
        if (r1 == null) goto L10;
        r1.setAutoSizeTextTypeUniformWithConfiguration(r2, r3, r4, r5);
        return;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] r2, int r3) {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == false) goto L5;
        super.setAutoSizeTextTypeUniformWithPresetSizes(r2, r3);
        return;
    L5:
        AppCompatTextHelper r1 = this.mTextHelper;
        if (r1 == null) goto L10;
        r1.setAutoSizeTextTypeUniformWithPresetSizes(r2, r3);
        return;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeWithDefaults(int r2) {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == false) goto L5;
        super.setAutoSizeTextTypeWithDefaults(r2);
        return;
    L5:
        AppCompatTextHelper r1 = this.mTextHelper;
        if (r1 == null) goto L10;
        r1.setAutoSizeTextTypeWithDefaults(r2);
        return;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r1) {
        super.setBackgroundDrawable(r1);
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.onSetBackgroundDrawable(r1);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int r1) {
        super.setBackgroundResource(r1);
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.onSetBackgroundResource(r1);
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable r1, @Nullable Drawable r2, @Nullable Drawable r3, @Nullable Drawable r4) {
        super.setCompoundDrawables(r1, r2, r3, r4);
        AppCompatTextHelper r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.onSetCompoundDrawables();
        return;
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelative(@Nullable Drawable r1, @Nullable Drawable r2, @Nullable Drawable r3, @Nullable Drawable r4) {
        super.setCompoundDrawablesRelative(r1, r2, r3, r4);
        AppCompatTextHelper r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.onSetCompoundDrawables();
        return;
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable r1, @Nullable Drawable r2, @Nullable Drawable r3, @Nullable Drawable r4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        AppCompatTextHelper r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.onSetCompoundDrawables();
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable r1, @Nullable Drawable r2, @Nullable Drawable r3, @Nullable Drawable r4) {
        super.setCompoundDrawablesWithIntrinsicBounds(r1, r2, r3, r4);
        AppCompatTextHelper r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.onSetCompoundDrawables();
        return;
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r1) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r1));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(@IntRange(from = 0) @Px int r1) {
        super.setFirstBaselineToTopHeight(r1);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(@IntRange(from = 0) @Px int r1) {
        super.setLastBaselineToBottomHeight(r1);
    }

    @Override // android.widget.TextView
    public void setLineHeight(@IntRange(from = 0) @Px int r1) {
        TextViewCompat.setLineHeight(this, r1);
    }

    public void setPrecomputedText(@NonNull PrecomputedTextCompat r1) {
        TextViewCompat.setPrecomputedText(this, r1);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList r1) {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.setSupportBackgroundTintList(r1);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r1) {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.setSupportBackgroundTintMode(r1);
        return;
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList r2) {
        this.mTextHelper.setCompoundDrawableTintList(r2);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode r2) {
        this.mTextHelper.setCompoundDrawableTintMode(r2);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context r1, int r2) {
        super.setTextAppearance(r1, r2);
        AppCompatTextHelper r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.onSetTextAppearance(r1, r2);
        return;
    }

    @Override // android.widget.TextView
    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier r1) {
        super.setTextClassifier(r1);
    }

    public void setTextFuture(@Nullable Future<PrecomputedTextCompat> r1) {
        this.mPrecomputedTextFuture = r1;
        if (r1 == null) goto L6;
        requestLayout();
        return;
    }

    public void setTextMetricsParamsCompat(@NonNull PrecomputedTextCompat.Params r1) {
        TextViewCompat.setTextMetricsParams(this, r1);
    }

    @Override // android.widget.TextView
    public void setTextSize(int r2, float r3) {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == false) goto L5;
        super.setTextSize(r2, r3);
        return;
    L5:
        AppCompatTextHelper r1 = this.mTextHelper;
        if (r1 == null) goto L10;
        r1.setTextSize(r2, r3);
        return;
    }

    @Override // android.widget.TextView
    public void setTypeface(@Nullable Typeface r2, int r3) {
        if (r2 == null) goto L5;
        if (r3 <= 0) goto L5;
        Typeface r0 = TypefaceCompat.create(getContext(), r2, r3);
    L6:
        if (r0 == null) goto L8;
        r2 = r0;
    L8:
        super.setTypeface(r2, r3);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public AppCompatTextView(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.textViewStyle);
    }

    public AppCompatTextView(@NonNull Context r1, @Nullable AttributeSet r2, int r3) {
        super(TintContextWrapper.wrap(r1), r2, r3);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper r4 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r4;
        r4.loadFromAttributes(r2, r3);
        AppCompatTextHelper r5 = new AppCompatTextHelper(this);
        this.mTextHelper = r5;
        r5.loadFromAttributes(r2, r3);
        r5.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int r3, int r4, int r5, int r6) {
        Context r0 = getContext();
        Drawable r1 = null;
        if (r3 == 0) goto L5;
        Drawable r7 = AppCompatResources.getDrawable(r0, r3);
    L6:
        if (r4 == 0) goto L8;
        Drawable r8 = AppCompatResources.getDrawable(r0, r4);
    L9:
        if (r5 == 0) goto L11;
        Drawable r9 = AppCompatResources.getDrawable(r0, r5);
    L12:
        if (r6 == 0) goto L14;
        r1 = AppCompatResources.getDrawable(r0, r6);
    L14:
        setCompoundDrawablesRelativeWithIntrinsicBounds(r7, r8, r9, r1);
        AppCompatTextHelper r2 = this.mTextHelper;
        if (r2 == null) goto L18;
        r2.onSetCompoundDrawables();
        return;
    L18:
        return;
    L11:
        r9 = null;
        goto L12
    L8:
        r8 = null;
        goto L9
    L5:
        r7 = null;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int r3, int r4, int r5, int r6) {
        Context r0 = getContext();
        Drawable r1 = null;
        if (r3 == 0) goto L5;
        Drawable r7 = AppCompatResources.getDrawable(r0, r3);
    L6:
        if (r4 == 0) goto L8;
        Drawable r8 = AppCompatResources.getDrawable(r0, r4);
    L9:
        if (r5 == 0) goto L11;
        Drawable r9 = AppCompatResources.getDrawable(r0, r5);
    L12:
        if (r6 == 0) goto L14;
        r1 = AppCompatResources.getDrawable(r0, r6);
    L14:
        setCompoundDrawablesWithIntrinsicBounds(r7, r8, r9, r1);
        AppCompatTextHelper r2 = this.mTextHelper;
        if (r2 == null) goto L18;
        r2.onSetCompoundDrawables();
        return;
    L18:
        return;
    L11:
        r9 = null;
        goto L12
    L8:
        r8 = null;
        goto L9
    L5:
        r7 = null;
        goto L6
    }
}
