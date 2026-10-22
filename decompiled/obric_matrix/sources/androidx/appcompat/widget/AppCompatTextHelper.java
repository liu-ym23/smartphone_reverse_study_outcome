package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class AppCompatTextHelper {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
    private boolean mAsyncFontPending;

    @NonNull
    private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableEndTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableStartTint;
    private TintInfo mDrawableTint;
    private TintInfo mDrawableTopTint;
    private Typeface mFontTypeface;
    private int mFontWeight;
    private int mStyle;

    @NonNull
    private final TextView mView;

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static Drawable[] getCompoundDrawablesRelative(TextView r0) {
            return r0.getCompoundDrawablesRelative();
        }

        @DoNotInline
        static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r0, Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
            r0.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        }

        @DoNotInline
        static void setTextLocale(TextView r0, Locale r1) {
            r0.setTextLocale(r1);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static Locale forLanguageTag(String r0) {
            return Locale.forLanguageTag(r0);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static LocaleList forLanguageTags(String r0) {
            return LocaleList.forLanguageTags(r0);
        }

        @DoNotInline
        static void setTextLocales(TextView r0, LocaleList r1) {
            r0.setTextLocales(r1);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static int getAutoSizeStepGranularity(TextView r0) {
            return r0.getAutoSizeStepGranularity();
        }

        @DoNotInline
        static void setAutoSizeTextTypeUniformWithConfiguration(TextView r0, int r1, int r2, int r3, int r4) {
            r0.setAutoSizeTextTypeUniformWithConfiguration(r1, r2, r3, r4);
        }

        @DoNotInline
        static void setAutoSizeTextTypeUniformWithPresetSizes(TextView r0, int[] r1, int r2) {
            r0.setAutoSizeTextTypeUniformWithPresetSizes(r1, r2);
        }

        @DoNotInline
        static boolean setFontVariationSettings(TextView r0, String r1) {
            return r0.setFontVariationSettings(r1);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Typeface create(Typeface r0, int r1, boolean r2) {
            return Typeface.create(r0, r1, r2);
        }
    }

    AppCompatTextHelper(@NonNull TextView r2) {
        this.mStyle = 0;
        this.mFontWeight = -1;
        this.mView = r2;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(r2);
    }

    private void applyCompoundDrawableTint(Drawable r1, TintInfo r2) {
        if (r1 == null) goto L6;
        if (r2 == null) goto L7;
        AppCompatDrawableManager.tintDrawable(r1, r2, this.mView.getDrawableState());
        return;
    L7:
        return;
    }

    private static TintInfo createTintInfo(Context r0, AppCompatDrawableManager r1, int r2) {
        ColorStateList r3 = r1.getTintList(r0, r2);
        if (r3 == null) goto L6;
        TintInfo r4 = new TintInfo();
        r4.mHasTintList = true;
        r4.mTintList = r3;
        return r4;
    L6:
        return null;
    }

    private void setCompoundDrawables(Drawable r7, Drawable r8, Drawable r9, Drawable r10, Drawable r11, Drawable r12) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 17) goto L20;
        if (r11 != null) goto L6;
        if (r12 == null) goto L20;
    L6:
        Drawable[] r13 = Api17Impl.getCompoundDrawablesRelative(this.mView);
        TextView r6 = this.mView;
        if (r11 != null) goto L10;
        r11 = r13[0];
    L10:
        if (r8 != null) goto L13;
        r8 = r13[1];
    L13:
        if (r12 != null) goto L16;
        r12 = r13[2];
    L16:
        if (r10 != null) goto L19;
        r10 = r13[3];
    L19:
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(r6, r11, r8, r12, r10);
        return;
    L20:
        if (r7 != null) goto L24;
        if (r8 != null) goto L24;
        if (r9 != null) goto L24;
        if (r10 != null) goto L24;
        return;
    L24:
        if (r0 < 17) goto L39;
        Drawable[] r14 = Api17Impl.getCompoundDrawablesRelative(this.mView);
        if (r14[0] == null) goto L28;
    L29:
        TextView r15 = this.mView;
        Drawable r16 = r14[0];
        if (r8 != null) goto L33;
        r8 = r14[1];
    L33:
        Drawable r17 = r14[2];
        if (r10 != null) goto L37;
        r10 = r14[3];
    L37:
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(r15, r16, r8, r17, r10);
        return;
    L28:
        if (r14[2] != null) goto L29;
    L39:
        Drawable[] r18 = this.mView.getCompoundDrawables();
        TextView r19 = this.mView;
        if (r7 != null) goto L43;
        r7 = r18[0];
    L43:
        if (r8 != null) goto L46;
        r8 = r18[1];
    L46:
        if (r9 != null) goto L49;
        r9 = r18[2];
    L49:
        if (r10 != null) goto L52;
        r10 = r18[3];
    L52:
        r19.setCompoundDrawablesWithIntrinsicBounds(r7, r8, r9, r10);
    }

    private void setCompoundTints() {
        TintInfo r0 = this.mDrawableTint;
        this.mDrawableLeftTint = r0;
        this.mDrawableTopTint = r0;
        this.mDrawableRightTint = r0;
        this.mDrawableBottomTint = r0;
        this.mDrawableStartTint = r0;
        this.mDrawableEndTint = r0;
    }

    private void setTextSizeInternal(int r1, float r2) {
        this.mAutoSizeTextHelper.setTextSizeInternal(r1, r2);
    }

    private void updateTypefaceAndStyle(Context r11, TintTypedArray r12) {
        int r0 = Build.VERSION.SDK_INT;
        this.mStyle = r12.getInt(R.styleable.TextAppearance_android_textStyle, this.mStyle);
        boolean r4 = false;
        if (r0 < 28) goto L7;
        int r5 = r12.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
        this.mFontWeight = r5;
        if (r5 == (-1)) goto L7;
        this.mStyle = (this.mStyle & 2) | 0;
    L7:
        int r6 = R.styleable.TextAppearance_android_fontFamily;
        if (r12.hasValue(r6) == false) goto L10;
    L25:
        this.mFontTypeface = null;
        int r7 = R.styleable.TextAppearance_fontFamily;
        if (r12.hasValue(r7) == false) goto L28;
        r6 = r7;
    L28:
        final int r8 = this.mFontWeight;
        final int r9 = this.mStyle;
        if (r11.isRestricted() == true) goto L48;
        final WeakReference r13 = new WeakReference(this.mView);
        Typeface r14 = r12.getFont(r6, this.mStyle, new AnonymousClass1(this, r8, r9, r13));     // Catch: Throwable -> L61
        if (r14 == null) goto L43;
        if (r0 >= 28) goto L35;
    L41:
        this.mFontTypeface = r14;     // Catch: Throwable -> L61
        goto L43
    L35:
        if (this.mFontWeight == (-1)) goto L41;
        Typeface r15 = Typeface.create(r14, 0);     // Catch: Throwable -> L61
        int r10 = this.mFontWeight;     // Catch: Throwable -> L61
        if ((this.mStyle & 2) == 0) goto L39;
        boolean r16 = true;
    L40:
        r14 = Api28Impl.create(r15, r10, r16);     // Catch: Throwable -> L61
        goto L41
    L39:
        r16 = false;
    L43:
        if (this.mFontTypeface != null) goto L45;
        boolean r17 = true;
    L46:
        this.mAsyncFontPending = r17;     // Catch: Throwable -> L61
        goto L48
    L45:
        r17 = false;
    L48:
        if (this.mFontTypeface != null) goto L66;
        String r18 = r12.getString(r6);
        if (r18 == null) goto L67;
        if (r0 >= 28) goto L53;
    L58:
        Typeface r19 = Typeface.create(r18, this.mStyle);
    L59:
        this.mFontTypeface = r19;
        return;
    L53:
        if (this.mFontWeight == (-1)) goto L58;
        Typeface r110 = Typeface.create(r18, 0);
        int r111 = this.mFontWeight;
        if ((this.mStyle & 2) == 0) goto L57;
        r4 = true;
    L57:
        r19 = Api28Impl.create(r110, r111, r4);
        goto L59
    L67:
        return;
    L66:
        return;
    L10:
        if (r12.hasValue(R.styleable.TextAppearance_fontFamily) == true) goto L25;
        int r112 = R.styleable.TextAppearance_android_typeface;
        if (r12.hasValue(r112) == false) goto L64;
        this.mAsyncFontPending = false;
        int r113 = r12.getInt(r112, 1);
        if (r113 == 1) goto L22;
        if (r113 != 2) goto L18;
        Typeface r114 = Typeface.SERIF;
    L23:
        this.mFontTypeface = r114;
        return;
    L18:
        if (r113 != 3) goto L65;
        r114 = Typeface.MONOSPACE;
        goto L23
    L65:
        return;
    L22:
        r114 = Typeface.SANS_SERIF;
        goto L23
    }

    void applyCompoundDrawablesTints() {
        if (this.mDrawableLeftTint == null) goto L5;
    L10:
        Drawable[] r0 = this.mView.getCompoundDrawables();
        applyCompoundDrawableTint(r0[0], this.mDrawableLeftTint);
        applyCompoundDrawableTint(r0[1], this.mDrawableTopTint);
        applyCompoundDrawableTint(r0[2], this.mDrawableRightTint);
        applyCompoundDrawableTint(r0[3], this.mDrawableBottomTint);
    L12:
        if (Build.VERSION.SDK_INT >= 17) goto L14;
        return;
    L14:
        if (this.mDrawableStartTint == null) goto L16;
    L17:
        Drawable[] r1 = Api17Impl.getCompoundDrawablesRelative(this.mView);
        applyCompoundDrawableTint(r1[0], this.mDrawableStartTint);
        applyCompoundDrawableTint(r1[2], this.mDrawableEndTint);
        return;
    L16:
        if (this.mDrawableEndTint != null) goto L17;
        return;
    L5:
        if (this.mDrawableTopTint != null) goto L10;
        if (this.mDrawableRightTint != null) goto L10;
        if (this.mDrawableBottomTint == null) goto L12;
        goto L10
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    @Nullable
    ColorStateList getCompoundDrawableTintList() {
        TintInfo r0 = this.mDrawableTint;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mTintList;
    }

    @Nullable
    PorterDuff.Mode getCompoundDrawableTintMode() {
        TintInfo r0 = this.mDrawableTint;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mTintMode;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    @SuppressLint({"NewApi"})
    void loadFromAttributes(@Nullable AttributeSet r24, int r25) {
        Context r10 = this.mView.getContext();
        AppCompatDrawableManager r11 = AppCompatDrawableManager.get();
        int[] r2 = R.styleable.AppCompatTextHelper;
        TintTypedArray r13 = TintTypedArray.obtainStyledAttributes(r10, r24, r2, r25, 0);
        TextView r0 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r0, r0.getContext(), r2, r24, r13.getWrappedTypeArray(), r25, 0);
        int r1 = r13.getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        int r3 = R.styleable.AppCompatTextHelper_android_drawableLeft;
        if (r13.hasValue(r3) == false) goto L5;
        this.mDrawableLeftTint = createTintInfo(r10, r11, r13.getResourceId(r3, 0));
    L5:
        int r4 = R.styleable.AppCompatTextHelper_android_drawableTop;
        if (r13.hasValue(r4) == false) goto L8;
        this.mDrawableTopTint = createTintInfo(r10, r11, r13.getResourceId(r4, 0));
    L8:
        int r5 = R.styleable.AppCompatTextHelper_android_drawableRight;
        if (r13.hasValue(r5) == false) goto L11;
        this.mDrawableRightTint = createTintInfo(r10, r11, r13.getResourceId(r5, 0));
    L11:
        int r6 = R.styleable.AppCompatTextHelper_android_drawableBottom;
        if (r13.hasValue(r6) == false) goto L14;
        this.mDrawableBottomTint = createTintInfo(r10, r11, r13.getResourceId(r6, 0));
    L14:
        int r7 = Build.VERSION.SDK_INT;
        if (r7 < 17) goto L22;
        int r8 = R.styleable.AppCompatTextHelper_android_drawableStart;
        if (r13.hasValue(r8) == false) goto L19;
        this.mDrawableStartTint = createTintInfo(r10, r11, r13.getResourceId(r8, 0));
    L19:
        int r9 = R.styleable.AppCompatTextHelper_android_drawableEnd;
        if (r13.hasValue(r9) == false) goto L22;
        this.mDrawableEndTint = createTintInfo(r10, r11, r13.getResourceId(r9, 0));
    L22:
        r13.recycle();
        boolean r12 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (r1 == (-1)) goto L55;
        TintTypedArray r14 = TintTypedArray.obtainStyledAttributes(r10, r1, R.styleable.TextAppearance);
        if (r12 == true) goto L29;
        int r15 = R.styleable.TextAppearance_textAllCaps;
        if (r14.hasValue(r15) == false) goto L29;
        boolean r16 = r14.getBoolean(r15, false);
        boolean r17 = true;
    L30:
        updateTypefaceAndStyle(r10, r14);
        if (r7 >= 23) goto L43;
        int r18 = R.styleable.TextAppearance_android_textColor;
        if (r14.hasValue(r18) == false) goto L35;
        ColorStateList r19 = r14.getColorStateList(r18);
    L36:
        int r110 = R.styleable.TextAppearance_android_textColorHint;
        if (r14.hasValue(r110) == false) goto L39;
        ColorStateList r111 = r14.getColorStateList(r110);
    L40:
        int r112 = R.styleable.TextAppearance_android_textColorLink;
        if (r14.hasValue(r112) == false) goto L44;
        ColorStateList r113 = r14.getColorStateList(r112);
    L45:
        int r20 = R.styleable.TextAppearance_textLocale;
        if (r14.hasValue(r20) == false) goto L48;
        String r21 = r14.getString(r20);
    L49:
        if (r7 < 26) goto L53;
        int r22 = R.styleable.TextAppearance_fontVariationSettings;
        if (r14.hasValue(r22) == false) goto L53;
        String r23 = r14.getString(r22);
    L54:
        r14.recycle();
    L56:
        TintTypedArray r26 = TintTypedArray.obtainStyledAttributes(r10, r24, R.styleable.TextAppearance, r25, 0);
        if (r12 == true) goto L61;
        int r114 = R.styleable.TextAppearance_textAllCaps;
        if (r26.hasValue(r114) == false) goto L61;
        r16 = r26.getBoolean(r114, false);
        int r27 = 23;
        r17 = true;
    L62:
        if (r7 >= r27) goto L72;
        int r28 = R.styleable.TextAppearance_android_textColor;
        if (r26.hasValue(r28) == false) goto L66;
        r19 = r26.getColorStateList(r28);
    L66:
        int r29 = R.styleable.TextAppearance_android_textColorHint;
        if (r26.hasValue(r29) == false) goto L69;
        r111 = r26.getColorStateList(r29);
    L69:
        int r30 = R.styleable.TextAppearance_android_textColorLink;
        if (r26.hasValue(r30) == false) goto L72;
        r113 = r26.getColorStateList(r30);
    L72:
        int r31 = R.styleable.TextAppearance_textLocale;
        if (r26.hasValue(r31) == false) goto L76;
        r21 = r26.getString(r31);
    L76:
        if (r7 < 26) goto L80;
        int r32 = R.styleable.TextAppearance_fontVariationSettings;
        if (r26.hasValue(r32) == false) goto L80;
        String r33 = r26.getString(r32);
    L82:
        if (r7 < 28) goto L88;
        int r115 = R.styleable.TextAppearance_android_textSize;
        if (r26.hasValue(r115) == false) goto L88;
        AppCompatDrawableManager r116 = r11;
        if (r26.getDimensionPixelSize(r115, -1) != 0) goto L89;
        this.mView.setTextSize(0, 0.0f);
    L89:
        updateTypefaceAndStyle(r10, r26);
        r26.recycle();
        if (r19 == null) goto L92;
        this.mView.setTextColor(r19);
    L92:
        if (r111 == null) goto L94;
        this.mView.setHintTextColor(r111);
    L94:
        if (r113 == null) goto L96;
        this.mView.setLinkTextColor(r113);
    L96:
        if (r12 == true) goto L99;
        if (r17 == false) goto L99;
        setAllCaps(r16);
    L99:
        Typeface r34 = this.mFontTypeface;
        if (r34 != null) goto L102;
    L105:
        if (r33 == null) goto L107;
        Api26Impl.setFontVariationSettings(this.mView, r33);
    L107:
        if (r21 != null) goto L109;
    L114:
        this.mAutoSizeTextHelper.loadFromAttributes(r24, r25);
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L117;
    L124:
        TintTypedArray r35 = TintTypedArray.obtainStyledAttributes(r10, r24, R.styleable.AppCompatTextView);
        int r36 = r35.getResourceId(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
        AppCompatDrawableManager r37 = r116;
        if (r36 == (-1)) goto L127;
        Drawable r38 = r37.getDrawable(r10, r36);
    L128:
        int r39 = r35.getResourceId(R.styleable.AppCompatTextView_drawableTopCompat, -1);
        if (r39 == (-1)) goto L131;
        Drawable r40 = r37.getDrawable(r10, r39);
    L132:
        int r41 = r35.getResourceId(R.styleable.AppCompatTextView_drawableRightCompat, -1);
        if (r41 == (-1)) goto L135;
        Drawable r42 = r37.getDrawable(r10, r41);
    L136:
        int r43 = r35.getResourceId(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
        if (r43 == (-1)) goto L139;
        Drawable r44 = r37.getDrawable(r10, r43);
    L140:
        int r45 = r35.getResourceId(R.styleable.AppCompatTextView_drawableStartCompat, -1);
        if (r45 == (-1)) goto L143;
        Drawable r46 = r37.getDrawable(r10, r45);
    L144:
        int r47 = r35.getResourceId(R.styleable.AppCompatTextView_drawableEndCompat, -1);
        if (r47 == (-1)) goto L147;
        Drawable r117 = r37.getDrawable(r10, r47);
    L148:
        setCompoundDrawables(r38, r40, r42, r44, r46, r117);
        int r48 = R.styleable.AppCompatTextView_drawableTint;
        if (r35.hasValue(r48) == false) goto L151;
        TextViewCompat.setCompoundDrawableTintList(this.mView, r35.getColorStateList(r48));
    L151:
        int r49 = R.styleable.AppCompatTextView_drawableTintMode;
        if (r35.hasValue(r49) == false) goto L154;
        int r50 = -1;
        TextViewCompat.setCompoundDrawableTintMode(this.mView, DrawableUtils.parseTintMode(r35.getInt(r49, -1), null));
    L155:
        int r51 = r35.getDimensionPixelSize(R.styleable.AppCompatTextView_firstBaselineToTopHeight, r50);
        int r52 = r35.getDimensionPixelSize(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, r50);
        int r53 = r35.getDimensionPixelSize(R.styleable.AppCompatTextView_lineHeight, r50);
        r35.recycle();
        if (r51 == r50) goto L158;
        TextViewCompat.setFirstBaselineToTopHeight(this.mView, r51);
    L158:
        if (r52 == r50) goto L160;
        TextViewCompat.setLastBaselineToBottomHeight(this.mView, r52);
    L160:
        if (r53 == r50) goto L163;
        TextViewCompat.setLineHeight(this.mView, r53);
        return;
    L163:
        return;
    L154:
        r50 = -1;
        goto L155
    L147:
        r117 = null;
        goto L148
    L143:
        r46 = null;
        goto L144
    L139:
        r44 = null;
        goto L140
    L135:
        r42 = null;
        goto L136
    L131:
        r40 = null;
        goto L132
    L127:
        r38 = null;
        goto L128
    L117:
        if (this.mAutoSizeTextHelper.getAutoSizeTextType() == 0) goto L124;
        int[] r54 = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
        if (r54.length <= 0) goto L124;
        if (Api26Impl.getAutoSizeStepGranularity(this.mView) == (-1.0f)) goto L123;
        Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(this.mView, this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
        goto L124
    L123:
        Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(this.mView, r54, 0);
        goto L124
    L109:
        if (r7 < 24) goto L112;
        Api24Impl.setTextLocales(this.mView, Api24Impl.forLanguageTags(r21));
        goto L114
    L112:
        if (r7 < 21) goto L114;
        Api17Impl.setTextLocale(this.mView, Api21Impl.forLanguageTag(r21.split(",")[0]));
        goto L114
    L102:
        if (this.mFontWeight != (-1)) goto L104;
        this.mView.setTypeface(r34, this.mStyle);
        goto L105
    L104:
        this.mView.setTypeface(r34);
    L88:
        r116 = r11;
    L80:
        r33 = r23;
    L61:
        r27 = 23;
    L53:
        r23 = null;
        goto L54
    L48:
        r21 = null;
    L44:
        r113 = null;
        goto L45
    L39:
        r111 = null;
        goto L40
    L35:
        r19 = null;
        goto L36
    L43:
        r19 = null;
        r111 = null;
    L29:
        r16 = false;
        r17 = false;
        goto L30
    L55:
        r16 = false;
        r17 = false;
        r23 = null;
        r19 = null;
        r21 = null;
        r111 = null;
        r113 = null;
        goto L56
    }

    void onAsyncTypefaceReceived(WeakReference<TextView> r3, final Typeface r4) {
        if (this.mAsyncFontPending == false) goto L11;
        this.mFontTypeface = r4;
        final TextView r5 = r3.get();
        if (r5 != null) goto L7;
        return;
    L7:
        if (ViewCompat.isAttachedToWindow(r5) == false) goto L9;
        final int r0 = this.mStyle;
        r5.post(new AnonymousClass2(this, r5, r4, r0));
        return;
    L9:
        r5.setTypeface(r4, this.mStyle);
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L6;
        autoSizeText();
        return;
    }

    void onSetCompoundDrawables() {
        applyCompoundDrawablesTints();
    }

    void onSetTextAppearance(Context r5, int r6) {
        TintTypedArray r7 = TintTypedArray.obtainStyledAttributes(r5, r6, R.styleable.TextAppearance);
        int r0 = R.styleable.TextAppearance_textAllCaps;
        if (r7.hasValue(r0) == false) goto L5;
        setAllCaps(r7.getBoolean(r0, false));
    L5:
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 23) goto L22;
        int r2 = R.styleable.TextAppearance_android_textColor;
        if (r7.hasValue(r2) == false) goto L12;
        ColorStateList r3 = r7.getColorStateList(r2);
        if (r3 == null) goto L12;
        this.mView.setTextColor(r3);
    L12:
        int r4 = R.styleable.TextAppearance_android_textColorLink;
        if (r7.hasValue(r4) == false) goto L17;
        ColorStateList r8 = r7.getColorStateList(r4);
        if (r8 == null) goto L17;
        this.mView.setLinkTextColor(r8);
    L17:
        int r9 = R.styleable.TextAppearance_android_textColorHint;
        if (r7.hasValue(r9) == false) goto L22;
        ColorStateList r10 = r7.getColorStateList(r9);
        if (r10 == null) goto L22;
        this.mView.setHintTextColor(r10);
    L22:
        int r11 = R.styleable.TextAppearance_android_textSize;
        if (r7.hasValue(r11) == true) goto L25;
    L27:
        updateTypefaceAndStyle(r5, r7);
        if (r1 < 26) goto L34;
        int r12 = R.styleable.TextAppearance_fontVariationSettings;
        if (r7.hasValue(r12) == false) goto L34;
        String r13 = r7.getString(r12);
        if (r13 == null) goto L34;
        Api26Impl.setFontVariationSettings(this.mView, r13);
    L34:
        r7.recycle();
        Typeface r14 = this.mFontTypeface;
        if (r14 == null) goto L38;
        this.mView.setTypeface(r14, this.mStyle);
        return;
    L38:
        return;
    L25:
        if (r7.getDimensionPixelSize(r11, -1) != 0) goto L27;
        this.mView.setTextSize(0, 0.0f);
        goto L27
    }

    void populateSurroundingTextIfNeeded(@NonNull TextView r2, @Nullable InputConnection r3, @NonNull EditorInfo r4) {
        if (Build.VERSION.SDK_INT >= 30) goto L7;
        if (r3 == null) goto L8;
        EditorInfoCompat.setInitialSurroundingText(r4, r2.getText());
        return;
    L8:
        return;
    }

    void setAllCaps(boolean r1) {
        this.mView.setAllCaps(r1);
    }

    void setAutoSizeTextTypeUniformWithConfiguration(int r1, int r2, int r3, int r4) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(r1, r2, r3, r4);
    }

    void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] r1, int r2) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(r1, r2);
    }

    void setAutoSizeTextTypeWithDefaults(int r1) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(r1);
    }

    void setCompoundDrawableTintList(@Nullable ColorStateList r2) {
        if (this.mDrawableTint != null) goto L5;
        this.mDrawableTint = new TintInfo();
    L5:
        TintInfo r0 = this.mDrawableTint;
        r0.mTintList = r2;
        if (r2 == null) goto L8;
        boolean r3 = true;
    L9:
        r0.mHasTintList = r3;
        setCompoundTints();
        return;
    L8:
        r3 = false;
        goto L9
    }

    void setCompoundDrawableTintMode(@Nullable PorterDuff.Mode r2) {
        if (this.mDrawableTint != null) goto L5;
        this.mDrawableTint = new TintInfo();
    L5:
        TintInfo r0 = this.mDrawableTint;
        r0.mTintMode = r2;
        if (r2 == null) goto L8;
        boolean r3 = true;
    L9:
        r0.mHasTintMode = r3;
        setCompoundTints();
        return;
    L8:
        r3 = false;
        goto L9
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void setTextSize(int r2, float r3) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == false) goto L5;
        return;
    L5:
        if (isAutoSizeEnabled() == true) goto L9;
        setTextSizeInternal(r2, r3);
        return;
    }
}
