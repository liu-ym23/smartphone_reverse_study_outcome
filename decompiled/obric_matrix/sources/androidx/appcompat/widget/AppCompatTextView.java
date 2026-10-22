package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
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
import androidx.annotation.UiThread;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatTextView extends TextView implements TintableBackgroundView, TintableCompoundDrawablesView, AutoSizeableTextView, EmojiCompatConfigurationView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;

    @NonNull
    private AppCompatEmojiTextHelper mEmojiTextViewHelper;
    private boolean mIsSetTypefaceProcessing;

    @Nullable
    private Future<PrecomputedTextCompat> mPrecomputedTextFuture;

    @Nullable
    private SuperCaller mSuperCaller;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    private interface SuperCaller {
        int getAutoSizeMaxTextSize();

        int getAutoSizeMinTextSize();

        int getAutoSizeStepGranularity();

        int[] getAutoSizeTextAvailableSizes();

        int getAutoSizeTextType();

        TextClassifier getTextClassifier();

        void setAutoSizeTextTypeUniformWithConfiguration(int r1, int r2, int r3, int r4);

        void setAutoSizeTextTypeUniformWithPresetSizes(int[] r1, int r2);

        void setAutoSizeTextTypeWithDefaults(int r1);

        void setFirstBaselineToTopHeight(@Px int r1);

        void setLastBaselineToBottomHeight(@Px int r1);

        void setTextClassifier(@Nullable TextClassifier r1);
    }

    @RequiresApi(api = 26)
    class SuperCallerApi26 implements SuperCaller {
        final /* synthetic */ AppCompatTextView this$0;

        SuperCallerApi26(AppCompatTextView r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public int getAutoSizeMaxTextSize() {
            return AppCompatTextView.access$001(this.this$0);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public int getAutoSizeMinTextSize() {
            return AppCompatTextView.access$101(this.this$0);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public int getAutoSizeStepGranularity() {
            return AppCompatTextView.access$201(this.this$0);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public int[] getAutoSizeTextAvailableSizes() {
            return AppCompatTextView.access$301(this.this$0);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public int getAutoSizeTextType() {
            return AppCompatTextView.access$401(this.this$0);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public TextClassifier getTextClassifier() {
            return AppCompatTextView.access$501(this.this$0);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setAutoSizeTextTypeUniformWithConfiguration(int r1, int r2, int r3, int r4) {
            AppCompatTextView.access$601(this.this$0, r1, r2, r3, r4);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setAutoSizeTextTypeUniformWithPresetSizes(int[] r1, int r2) {
            AppCompatTextView.access$701(this.this$0, r1, r2);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setAutoSizeTextTypeWithDefaults(int r1) {
            AppCompatTextView.access$801(this.this$0, r1);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setFirstBaselineToTopHeight(int r1) {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setLastBaselineToBottomHeight(int r1) {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setTextClassifier(@Nullable TextClassifier r1) {
            AppCompatTextView.access$901(this.this$0, r1);
        }
    }

    @RequiresApi(api = 28)
    class SuperCallerApi28 extends SuperCallerApi26 {
        final /* synthetic */ AppCompatTextView this$0;

        SuperCallerApi28(AppCompatTextView r1) {
            this.this$0 = r1;
            super(r1);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCallerApi26, androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setFirstBaselineToTopHeight(@Px int r1) {
            AppCompatTextView.access$1001(this.this$0, r1);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCallerApi26, androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setLastBaselineToBottomHeight(@Px int r1) {
            AppCompatTextView.access$1101(this.this$0, r1);
        }
    }

    public AppCompatTextView(@NonNull Context r2) {
        this(r2, null);
    }

    public AppCompatTextView(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.textViewStyle);
    }

    public AppCompatTextView(@NonNull Context r1, @Nullable AttributeSet r2, int r3) {
        super(TintContextWrapper.wrap(r1), r2, r3);
        this.mIsSetTypefaceProcessing = false;
        this.mSuperCaller = null;
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper r4 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r4;
        r4.loadFromAttributes(r2, r3);
        AppCompatTextHelper r5 = new AppCompatTextHelper(this);
        this.mTextHelper = r5;
        r5.loadFromAttributes(r2, r3);
        r5.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
        getEmojiTextViewHelper().loadFromAttributes(r2, r3);
    }

    static /* synthetic */ int access$001(AppCompatTextView r0) {
        return super.getAutoSizeMaxTextSize();
    }

    static /* synthetic */ void access$1001(AppCompatTextView r0, int r1) {
        super.setFirstBaselineToTopHeight(r1);
    }

    static /* synthetic */ int access$101(AppCompatTextView r0) {
        return super.getAutoSizeMinTextSize();
    }

    static /* synthetic */ void access$1101(AppCompatTextView r0, int r1) {
        super.setLastBaselineToBottomHeight(r1);
    }

    static /* synthetic */ int access$201(AppCompatTextView r0) {
        return super.getAutoSizeStepGranularity();
    }

    static /* synthetic */ int[] access$301(AppCompatTextView r0) {
        return super.getAutoSizeTextAvailableSizes();
    }

    static /* synthetic */ int access$401(AppCompatTextView r0) {
        return super.getAutoSizeTextType();
    }

    static /* synthetic */ TextClassifier access$501(AppCompatTextView r0) {
        return super.getTextClassifier();
    }

    static /* synthetic */ void access$601(AppCompatTextView r0, int r1, int r2, int r3, int r4) {
        super.setAutoSizeTextTypeUniformWithConfiguration(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$701(AppCompatTextView r0, int[] r1, int r2) {
        super.setAutoSizeTextTypeUniformWithPresetSizes(r1, r2);
    }

    static /* synthetic */ void access$801(AppCompatTextView r0, int r1) {
        super.setAutoSizeTextTypeWithDefaults(r1);
    }

    static /* synthetic */ void access$901(AppCompatTextView r0, TextClassifier r1) {
        super.setTextClassifier(r1);
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

    @NonNull
    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.mEmojiTextViewHelper != null) goto L6;
        this.mEmojiTextViewHelper = new AppCompatEmojiTextHelper(this);
    L6:
        return this.mEmojiTextViewHelper;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
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
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r1 = this.mTextHelper;
        if (r1 != null) goto L9;
        return -1;
    L9:
        return r1.getAutoSizeMaxTextSize();
    L5:
        return getSuperCaller().getAutoSizeMaxTextSize();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMinTextSize() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r1 = this.mTextHelper;
        if (r1 != null) goto L9;
        return -1;
    L9:
        return r1.getAutoSizeMinTextSize();
    L5:
        return getSuperCaller().getAutoSizeMinTextSize();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeStepGranularity() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r1 = this.mTextHelper;
        if (r1 != null) goto L9;
        return -1;
    L9:
        return r1.getAutoSizeStepGranularity();
    L5:
        return getSuperCaller().getAutoSizeStepGranularity();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] getAutoSizeTextAvailableSizes() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r1 = this.mTextHelper;
        if (r1 == null) goto L11;
        return r1.getAutoSizeTextAvailableSizes();
    L11:
        return new int[0];
    L5:
        return getSuperCaller().getAutoSizeTextAvailableSizes();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeTextType() {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r2 = this.mTextHelper;
        if (r2 != null) goto L11;
        return 0;
    L11:
        return r2.getAutoSizeTextType();
    L5:
        if (getSuperCaller().getAutoSizeTextType() == 1) goto L7;
        return 0;
    L7:
        return 1;
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.getFirstBaselineToTopHeight(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.getLastBaselineToBottomHeight(this);
    }

    @RequiresApi(api = 26)
    @UiThread
    SuperCaller getSuperCaller() {
        if (this.mSuperCaller != null) goto L12;
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L9;
        SuperCaller r1 = new SuperCallerApi28(this);
    L7:
        this.mSuperCaller = r1;
        goto L12
    L9:
        if (r0 < 26) goto L12;
        r1 = new SuperCallerApi26(this);
    L12:
        return this.mSuperCaller;
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
        if (Build.VERSION.SDK_INT >= 28) goto L10;
        AppCompatTextClassifierHelper r0 = this.mTextClassifierHelper;
        if (r0 == null) goto L10;
        return r0.getTextClassifier();
    L10:
        return getSuperCaller().getTextClassifier();
    }

    @NonNull
    public PrecomputedTextCompat.Params getTextMetricsParamsCompat() {
        return TextViewCompat.getTextMetricsParams(this);
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().isEnabled();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r3) {
        InputConnection r0 = super.onCreateInputConnection(r3);
        this.mTextHelper.populateSurroundingTextIfNeeded(this, r0, r3);
        return AppCompatHintHelper.onCreateInputConnection(r0, r3, this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        super.onLayout(r7, r8, r9, r10, r11);
        AppCompatTextHelper r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.onLayout(r7, r8, r9, r10, r11);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int r1, int r2) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        super.onTextChanged(r1, r2, r3, r4);
        AppCompatTextHelper r5 = this.mTextHelper;
        if (r5 != null) goto L5;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == false) goto L13;
        this.mTextHelper.autoSizeText();
        return;
    L13:
        return;
    L5:
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L9;
        if (r5.isAutoSizeEnabled() == false) goto L9;
        r6 = true;
        goto L10
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean r1) {
        super.setAllCaps(r1);
        getEmojiTextViewHelper().setAllCaps(r1);
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithConfiguration(int r2, int r3, int r4, int r5) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == false) goto L5;
        getSuperCaller().setAutoSizeTextTypeUniformWithConfiguration(r2, r3, r4, r5);
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
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == false) goto L5;
        getSuperCaller().setAutoSizeTextTypeUniformWithPresetSizes(r2, r3);
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
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == false) goto L5;
        getSuperCaller().setAutoSizeTextTypeWithDefaults(r2);
        return;
    L5:
        AppCompatTextHelper r1 = this.mTextHelper;
        if (r1 == null) goto L10;
        r1.setAutoSizeTextTypeWithDefaults(r2);
        return;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable r1) {
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
    @RequiresApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable r1, @Nullable Drawable r2, @Nullable Drawable r3, @Nullable Drawable r4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        AppCompatTextHelper r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.onSetCompoundDrawables();
        return;
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

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable r1, @Nullable Drawable r2, @Nullable Drawable r3, @Nullable Drawable r4) {
        super.setCompoundDrawablesWithIntrinsicBounds(r1, r2, r3, r4);
        AppCompatTextHelper r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.onSetCompoundDrawables();
        return;
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback r1) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r1));
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public void setEmojiCompatEnabled(boolean r1) {
        getEmojiTextViewHelper().setEnabled(r1);
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] r2) {
        super.setFilters(getEmojiTextViewHelper().getFilters(r2));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(@IntRange(from = 0) @Px int r3) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        getSuperCaller().setFirstBaselineToTopHeight(r3);
        return;
    L5:
        TextViewCompat.setFirstBaselineToTopHeight(this, r3);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(@IntRange(from = 0) @Px int r3) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        getSuperCaller().setLastBaselineToBottomHeight(r3);
        return;
    L5:
        TextViewCompat.setLastBaselineToBottomHeight(this, r3);
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
    public void setTextClassifier(@Nullable TextClassifier r3) {
        if (Build.VERSION.SDK_INT >= 28) goto L9;
        AppCompatTextClassifierHelper r0 = this.mTextClassifierHelper;
        if (r0 == null) goto L9;
        r0.setTextClassifier(r3);
        return;
    L9:
        getSuperCaller().setTextClassifier(r3);
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
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == false) goto L5;
        super.setTextSize(r2, r3);
        return;
    L5:
        AppCompatTextHelper r1 = this.mTextHelper;
        if (r1 == null) goto L10;
        r1.setTextSize(r2, r3);
        return;
    }

    @Override // android.widget.TextView
    public void setTypeface(@Nullable Typeface r3, int r4) {
        if (this.mIsSetTypefaceProcessing == false) goto L5;
        return;
    L5:
        Typeface r0 = null;
        if (r3 == null) goto L9;
        if (r4 <= 0) goto L9;
        r0 = TypefaceCompat.create(getContext(), r3, r4);
    L9:
        this.mIsSetTypefaceProcessing = true;
        if (r0 == null) goto L19;
        r3 = r0;
    L19:
        super.setTypeface(r3, r4);     // Catch: Throwable -> L16
        this.mIsSetTypefaceProcessing = false;
        return;
    L16:
        th = move-exception;
        this.mIsSetTypefaceProcessing = false;
        throw th;
    }
}
