package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.ttnet.org.chromium.net.NetError;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public class TextInputLayout extends LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int DEF_STYLE_RES = 0;
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final String LOG_TAG = "TextInputLayout";
    private static final int NO_WIDTH = -1;
    private static final long PLACEHOLDER_FADE_DURATION = 87;
    private static final long PLACEHOLDER_START_DELAY = 67;
    private ValueAnimator animator;

    @Nullable
    private MaterialShapeDrawable boxBackground;

    @ColorInt
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private int boxCollapsedPaddingTopPx;
    private final int boxLabelCutoutPaddingPx;

    @ColorInt
    private int boxStrokeColor;
    private int boxStrokeWidthDefaultPx;
    private int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;

    @Nullable
    private MaterialShapeDrawable boxUnderline;
    final CollapsingTextHelper collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private int counterOverflowTextAppearance;

    @Nullable
    private ColorStateList counterOverflowTextColor;
    private boolean counterOverflowed;
    private int counterTextAppearance;

    @Nullable
    private ColorStateList counterTextColor;

    @Nullable
    private TextView counterView;

    @ColorInt
    private int defaultFilledBackgroundColor;
    private ColorStateList defaultHintTextColor;

    @ColorInt
    private int defaultStrokeColor;

    @ColorInt
    private int disabledColor;

    @ColorInt
    private int disabledFilledBackgroundColor;
    EditText editText;
    private final LinkedHashSet<OnEditTextAttachedListener> editTextAttachedListeners;

    @Nullable
    private Drawable endDummyDrawable;
    private int endDummyDrawableWidth;
    private final LinkedHashSet<OnEndIconChangedListener> endIconChangedListeners;
    private final SparseArray<EndIconDelegate> endIconDelegates;

    @NonNull
    private final FrameLayout endIconFrame;
    private int endIconMode;
    private View.OnLongClickListener endIconOnLongClickListener;
    private ColorStateList endIconTintList;
    private PorterDuff.Mode endIconTintMode;

    @NonNull
    private final CheckableImageButton endIconView;

    @NonNull
    private final LinearLayout endLayout;
    private View.OnLongClickListener errorIconOnLongClickListener;
    private ColorStateList errorIconTintList;

    @NonNull
    private final CheckableImageButton errorIconView;
    private boolean expandedHintEnabled;

    @ColorInt
    private int focusedFilledBackgroundColor;

    @ColorInt
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private boolean hasEndIconTintList;
    private boolean hasEndIconTintMode;
    private boolean hasStartIconTintList;
    private boolean hasStartIconTintMode;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;

    @ColorInt
    private int hoveredFilledBackgroundColor;

    @ColorInt
    private int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final IndicatorViewController indicatorViewController;

    @NonNull
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private int maxWidth;
    private int minWidth;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    private boolean placeholderEnabled;

    @Nullable
    private Fade placeholderFadeIn;

    @Nullable
    private Fade placeholderFadeOut;
    private CharSequence placeholderText;
    private int placeholderTextAppearance;

    @Nullable
    private ColorStateList placeholderTextColor;
    private TextView placeholderTextView;

    @Nullable
    private CharSequence prefixText;

    @NonNull
    private final TextView prefixTextView;
    private boolean restoringSavedState;

    @NonNull
    private ShapeAppearanceModel shapeAppearanceModel;

    @Nullable
    private Drawable startDummyDrawable;
    private int startDummyDrawableWidth;
    private View.OnLongClickListener startIconOnLongClickListener;
    private ColorStateList startIconTintList;
    private PorterDuff.Mode startIconTintMode;

    @NonNull
    private final CheckableImageButton startIconView;

    @NonNull
    private final LinearLayout startLayout;
    private ColorStateList strokeErrorColor;

    @Nullable
    private CharSequence suffixText;

    @NonNull
    private final TextView suffixTextView;
    private final Rect tmpBoundsRect;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final TextInputLayout layout;

        public AccessibilityDelegate(@NonNull TextInputLayout r1) {
            this.layout = r1;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NonNull View r14, @NonNull AccessibilityNodeInfoCompat r15) {
            int r0 = Build.VERSION.SDK_INT;
            super.onInitializeAccessibilityNodeInfo(r14, r15);
            EditText r16 = this.layout.getEditText();
            if (r16 == null) goto L5;
            CharSequence r1 = r16.getText();
        L6:
            CharSequence r2 = this.layout.getHint();
            CharSequence r3 = this.layout.getError();
            CharSequence r4 = this.layout.getPlaceholderText();
            int r5 = this.layout.getCounterMaxLength();
            CharSequence r6 = this.layout.getCounterOverflowDescription();
            boolean r7 = !TextUtils.isEmpty(r1);
            boolean r9 = !TextUtils.isEmpty(r2);
            boolean r13 = !this.layout.isHintExpanded();
            boolean r10 = !TextUtils.isEmpty(r3);
            if (r10 == false) goto L9;
        L12:
            boolean r11 = true;
        L13:
            if (r9 == false) goto L15;
            String r8 = r2.toString();
        L17:
            if (r7 == false) goto L20;
            r15.setText(r1);
        L28:
            if (TextUtils.isEmpty(r8) == false) goto L30;
        L36:
            if (r1 != null) goto L38;
        L40:
            r5 = -1;
        L41:
            r15.setMaxTextLength(r5);
            if (r11 == false) goto L48;
            if (r10 == true) goto L46;
            r3 = r6;
        L46:
            r15.setError(r3);
        L48:
            if (r0 < 17) goto L52;
            if (r16 == null) goto L53;
            r16.setLabelFor(R.id.textinput_helper_text);
            return;
        L53:
            return;
        L52:
            return;
        L38:
            if (r1.length() != r5) goto L40;
        L30:
            if (r0 < 26) goto L32;
            r15.setHintText(r8);
        L35:
            r15.setShowingHintText(!r7);
            goto L36
        L32:
            if (r7 == false) goto L34;
            r8 = r1 + ", " + r8;
        L34:
            r15.setText(r8);
            goto L35
        L20:
            if (TextUtils.isEmpty(r8) == true) goto L25;
            r15.setText(r8);
            if (r13 == false) goto L28;
            if (r4 == null) goto L28;
            r15.setText(r8 + ", " + r4);
            goto L28
        L25:
            if (r4 == null) goto L28;
            r15.setText(r4);
            goto L28
        L15:
            r8 = "";
            goto L17
        L9:
            if (TextUtils.isEmpty(r6) == false) goto L12;
            r11 = false;
            goto L13
        L5:
            r1 = null;
            goto L6
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface EndIconMode {
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(@NonNull TextInputLayout r1);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(@NonNull TextInputLayout r1, int r2);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        @Nullable
        CharSequence error;

        @Nullable
        CharSequence helperText;

        @Nullable
        CharSequence hintText;
        boolean isEndIconChecked;

        @Nullable
        CharSequence placeholderText;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(@NonNull Parcel r2, ClassLoader r3) {
            super(r2, r3);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r2);
            boolean r0 = true;
            if (r2.readInt() == 1) goto L6;
            r0 = false;
        L6:
            this.isEndIconChecked = r0;
            this.hintText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r2);
            this.helperText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r2);
            this.placeholderText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r2);
        }

        SavedState(Parcelable r1) {
            super(r1);
        }

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + " hint=" + this.hintText + " helperText=" + this.helperText + " placeholderText=" + this.placeholderText + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            TextUtils.writeToParcel(this.error, r2, r3);
            r2.writeInt(this.isEndIconChecked ? 1 : 0);
            TextUtils.writeToParcel(this.hintText, r2, r3);
            TextUtils.writeToParcel(this.helperText, r2, r3);
            TextUtils.writeToParcel(this.placeholderText, r2, r3);
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_TextInputLayout;
    }

    public TextInputLayout(@NonNull Context r2) {
        this(r2, null);
    }

    public TextInputLayout(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.textInputStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v153 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47, types: [boolean, int] */
    public TextInputLayout(@NonNull Context r24, @Nullable AttributeSet r25, int r26) {
        int r9 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r24, r25, r26, r9), r25, r26);
        this.minWidth = -1;
        this.maxWidth = -1;
        this.indicatorViewController = new IndicatorViewController(this);
        this.tmpRect = new Rect();
        this.tmpBoundsRect = new Rect();
        this.tmpRectF = new RectF();
        this.editTextAttachedListeners = new LinkedHashSet();
        this.endIconMode = 0;
        this.endIconDelegates = new SparseArray();
        this.endIconChangedListeners = new LinkedHashSet();
        CollapsingTextHelper r1 = new CollapsingTextHelper(this);
        this.collapsingTextHelper = r1;
        Context r12 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout r2 = new FrameLayout(r12);
        this.inputFrame = r2;
        r2.setAddStatesFromChildren(true);
        addView(r2);
        LinearLayout r3 = new LinearLayout(r12);
        this.startLayout = r3;
        r3.setOrientation(0);
        r3.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        r2.addView(r3);
        LinearLayout r15 = new LinearLayout(r12);
        this.endLayout = r15;
        r15.setOrientation(0);
        r15.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        r2.addView(r15);
        FrameLayout r4 = new FrameLayout(r12);
        this.endIconFrame = r4;
        r4.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        TimeInterpolator r5 = AnimationUtils.LINEAR_INTERPOLATOR;
        r1.setTextSizeInterpolator(r5);
        r1.setPositionInterpolator(r5);
        r1.setCollapsedTextGravity(BadgeDrawable.TOP_START);
        int[] r6 = R.styleable.TextInputLayout;
        int r7 = R.styleable.TextInputLayout_counterTextAppearance;
        int r8 = R.styleable.TextInputLayout_counterOverflowTextAppearance;
        int r10 = R.styleable.TextInputLayout_errorTextAppearance;
        int r14 = R.styleable.TextInputLayout_helperTextTextAppearance;
        int r11 = R.styleable.TextInputLayout_hintTextAppearance;
        TintTypedArray r13 = ThemeEnforcement.obtainTintedStyledAttributes(r12, r25, r6, r26, r9, new int[]{r7, r8, r10, r14, r11});
        this.hintEnabled = r13.getBoolean(R.styleable.TextInputLayout_hintEnabled, true);
        setHint(r13.getText(R.styleable.TextInputLayout_android_hint));
        this.hintAnimationEnabled = r13.getBoolean(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.expandedHintEnabled = r13.getBoolean(R.styleable.TextInputLayout_expandedHintEnabled, true);
        int r16 = R.styleable.TextInputLayout_android_minWidth;
        if (r13.hasValue(r16) == false) goto L5;
        setMinWidth(r13.getDimensionPixelSize(r16, -1));
    L5:
        int r17 = R.styleable.TextInputLayout_android_maxWidth;
        if (r13.hasValue(r17) == false) goto L8;
        setMaxWidth(r13.getDimensionPixelSize(r17, -1));
    L8:
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(r12, r25, r26, r9).build();
        this.boxLabelCutoutPaddingPx = r12.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = r13.getDimensionPixelOffset(R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.boxStrokeWidthDefaultPx = r13.getDimensionPixelSize(R.styleable.TextInputLayout_boxStrokeWidth, r12.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.boxStrokeWidthFocusedPx = r13.getDimensionPixelSize(R.styleable.TextInputLayout_boxStrokeWidthFocused, r12.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        float r18 = r13.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float r19 = r13.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float r20 = r13.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float r21 = r13.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        ShapeAppearanceModel.Builder r22 = this.shapeAppearanceModel.toBuilder();
        if (r18 < 0.0f) goto L12;
        r22.setTopLeftCornerSize(r18);
    L12:
        if (r19 < 0.0f) goto L15;
        r22.setTopRightCornerSize(r19);
    L15:
        if (r20 < 0.0f) goto L18;
        r22.setBottomRightCornerSize(r20);
    L18:
        if (r21 < 0.0f) goto L20;
        r22.setBottomLeftCornerSize(r21);
    L20:
        this.shapeAppearanceModel = r22.build();
        ColorStateList r23 = MaterialResources.getColorStateList(r12, r13, R.styleable.TextInputLayout_boxBackgroundColor);
        if (r23 == null) goto L27;
        int r27 = r23.getDefaultColor();
        this.defaultFilledBackgroundColor = r27;
        this.boxBackgroundColor = r27;
        if (r23.isStateful() == false) goto L25;
        this.disabledFilledBackgroundColor = r23.getColorForState(new int[]{-16842910}, -1);
        int r28 = 2;
        this.focusedFilledBackgroundColor = r23.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        int r29 = r23.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
    L26:
        this.hoveredFilledBackgroundColor = r29;
    L28:
        int r30 = R.styleable.TextInputLayout_android_textColorHint;
        if (r13.hasValue(r30) == false) goto L31;
        ColorStateList r31 = r13.getColorStateList(r30);
        this.focusedTextColor = r31;
        this.defaultHintTextColor = r31;
    L31:
        int r32 = R.styleable.TextInputLayout_boxStrokeColor;
        ColorStateList r33 = MaterialResources.getColorStateList(r12, r13, r32);
        this.focusedStrokeColor = r13.getColor(r32, 0);
        this.defaultStrokeColor = ContextCompat.getColor(r12, R.color.mtrl_textinput_default_box_stroke_color);
        this.disabledColor = ContextCompat.getColor(r12, R.color.mtrl_textinput_disabled_color);
        this.hoveredStrokeColor = ContextCompat.getColor(r12, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (r33 == null) goto L34;
        setBoxStrokeColorStateList(r33);
    L34:
        int r34 = R.styleable.TextInputLayout_boxStrokeErrorColor;
        if (r13.hasValue(r34) == false) goto L38;
        setBoxStrokeErrorColor(MaterialResources.getColorStateList(r12, r13, r34));
    L38:
        if (r13.getResourceId(r11, -1) == (-1)) goto L40;
        ?? r35 = 0;
        setHintTextAppearance(r13.getResourceId(r11, 0));
    L41:
        int r36 = r13.getResourceId(r10, r35);
        CharSequence r37 = r13.getText(R.styleable.TextInputLayout_errorContentDescription);
        boolean r38 = r13.getBoolean(R.styleable.TextInputLayout_errorEnabled, r35);
        LayoutInflater r39 = LayoutInflater.from(getContext());
        int r40 = R.layout.design_text_input_end_icon;
        CheckableImageButton r41 = (CheckableImageButton) r39.inflate(r40, r15, r35);
        this.errorIconView = r41;
        r41.setId(R.id.text_input_error_icon);
        r41.setVisibility(8);
        if (MaterialResources.isFontScaleAtLeast1_3(r12) == false) goto L44;
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) r41.getLayoutParams(), r35);
    L44:
        int r42 = R.styleable.TextInputLayout_errorIconDrawable;
        if (r13.hasValue(r42) == false) goto L47;
        setErrorIconDrawable(r13.getDrawable(r42));
    L47:
        int r43 = R.styleable.TextInputLayout_errorIconTint;
        if (r13.hasValue(r43) == false) goto L50;
        setErrorIconTintList(MaterialResources.getColorStateList(r12, r13, r43));
    L50:
        int r44 = R.styleable.TextInputLayout_errorIconTintMode;
        if (r13.hasValue(r44) == false) goto L53;
        setErrorIconTintMode(ViewUtils.parseTintMode(r13.getInt(r44, -1), null));
    L53:
        r41.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        ViewCompat.setImportantForAccessibility(r41, r28);
        r41.setClickable(false);
        r41.setPressable(false);
        r41.setFocusable(false);
        int r45 = r13.getResourceId(r14, 0);
        boolean r110 = r13.getBoolean(R.styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence r111 = r13.getText(R.styleable.TextInputLayout_helperText);
        int r46 = r13.getResourceId(R.styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence r112 = r13.getText(R.styleable.TextInputLayout_placeholderText);
        int r113 = r13.getResourceId(R.styleable.TextInputLayout_prefixTextAppearance, 0);
        CharSequence r47 = r13.getText(R.styleable.TextInputLayout_prefixText);
        int r114 = r13.getResourceId(R.styleable.TextInputLayout_suffixTextAppearance, 0);
        CharSequence r48 = r13.getText(R.styleable.TextInputLayout_suffixText);
        boolean r115 = r13.getBoolean(R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(r13.getInt(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.counterTextAppearance = r13.getResourceId(r7, 0);
        this.counterOverflowTextAppearance = r13.getResourceId(r8, 0);
        CheckableImageButton r49 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, this.startLayout, false);
        this.startIconView = r49;
        r49.setVisibility(8);
        if (MaterialResources.isFontScaleAtLeast1_3(r12) == false) goto L56;
        MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) r49.getLayoutParams(), 0);
    L56:
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        int r50 = R.styleable.TextInputLayout_startIconDrawable;
        if (r13.hasValue(r50) == false) goto L62;
        setStartIconDrawable(r13.getDrawable(r50));
        int r51 = R.styleable.TextInputLayout_startIconContentDescription;
        if (r13.hasValue(r51) == false) goto L61;
        setStartIconContentDescription(r13.getText(r51));
    L61:
        setStartIconCheckable(r13.getBoolean(R.styleable.TextInputLayout_startIconCheckable, true));
    L62:
        int r52 = R.styleable.TextInputLayout_startIconTint;
        if (r13.hasValue(r52) == false) goto L65;
        setStartIconTintList(MaterialResources.getColorStateList(r12, r13, r52));
    L65:
        int r53 = R.styleable.TextInputLayout_startIconTintMode;
        if (r13.hasValue(r53) == false) goto L68;
        setStartIconTintMode(ViewUtils.parseTintMode(r13.getInt(r53, -1), null));
    L68:
        setBoxBackgroundMode(r13.getInt(R.styleable.TextInputLayout_boxBackgroundMode, 0));
        this.endIconView = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(r40, this.endIconFrame, false);
        this.endIconFrame.addView(this.endIconView);
        this.endIconView.setVisibility(8);
        if (MaterialResources.isFontScaleAtLeast1_3(r12) == false) goto L71;
        int r54 = 0;
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.endIconView.getLayoutParams(), 0);
    L72:
        int r55 = r13.getResourceId(R.styleable.TextInputLayout_endIconDrawable, r54);
        this.endIconDelegates.append(-1, new CustomEndIconDelegate(this, r55));
        this.endIconDelegates.append(r54, new NoEndIconDelegate(this));
        SparseArray<EndIconDelegate> r56 = this.endIconDelegates;
        if (r55 != 0) goto L75;
        int r116 = r13.getResourceId(R.styleable.TextInputLayout_passwordToggleDrawable, r54);
    L76:
        r56.append(1, new PasswordToggleEndIconDelegate(this, r116));
        this.endIconDelegates.append(2, new ClearTextEndIconDelegate(this, r55));
        this.endIconDelegates.append(3, new DropdownMenuEndIconDelegate(this, r55));
        int r57 = R.styleable.TextInputLayout_endIconMode;
        if (r13.hasValue(r57) == false) goto L82;
        setEndIconMode(r13.getInt(r57, 0));
        int r58 = R.styleable.TextInputLayout_endIconContentDescription;
        if (r13.hasValue(r58) == false) goto L81;
        setEndIconContentDescription(r13.getText(r58));
    L81:
        setEndIconCheckable(r13.getBoolean(R.styleable.TextInputLayout_endIconCheckable, true));
    L91:
        if (r13.hasValue(R.styleable.TextInputLayout_passwordToggleEnabled) == true) goto L98;
        int r59 = R.styleable.TextInputLayout_endIconTint;
        if (r13.hasValue(r59) == false) goto L95;
        setEndIconTintList(MaterialResources.getColorStateList(r12, r13, r59));
    L95:
        int r60 = R.styleable.TextInputLayout_endIconTintMode;
        if (r13.hasValue(r60) == false) goto L98;
        setEndIconTintMode(ViewUtils.parseTintMode(r13.getInt(r60, -1), null));
    L98:
        AppCompatTextView r61 = new AppCompatTextView(r12);
        this.prefixTextView = r61;
        r61.setId(R.id.textinput_prefix_text);
        r61.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(r61, 1);
        this.startLayout.addView(this.startIconView);
        this.startLayout.addView(r61);
        AppCompatTextView r62 = new AppCompatTextView(r12);
        this.suffixTextView = r62;
        r62.setId(R.id.textinput_suffix_text);
        r62.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        ViewCompat.setAccessibilityLiveRegion(r62, 1);
        this.endLayout.addView(this.suffixTextView);
        this.endLayout.addView(this.errorIconView);
        this.endLayout.addView(this.endIconFrame);
        setHelperTextEnabled(r110);
        setHelperText(r111);
        setHelperTextTextAppearance(r45);
        setErrorEnabled(r38);
        setErrorTextAppearance(r36);
        setErrorContentDescription(r37);
        setCounterTextAppearance(this.counterTextAppearance);
        setCounterOverflowTextAppearance(this.counterOverflowTextAppearance);
        setPlaceholderText(r112);
        setPlaceholderTextAppearance(r46);
        setPrefixText(r47);
        setPrefixTextAppearance(r113);
        setSuffixText(r48);
        setSuffixTextAppearance(r114);
        int r63 = R.styleable.TextInputLayout_errorTextColor;
        if (r13.hasValue(r63) == false) goto L101;
        setErrorTextColor(r13.getColorStateList(r63));
    L101:
        int r64 = R.styleable.TextInputLayout_helperTextTextColor;
        if (r13.hasValue(r64) == false) goto L104;
        setHelperTextColor(r13.getColorStateList(r64));
    L104:
        int r65 = R.styleable.TextInputLayout_hintTextColor;
        if (r13.hasValue(r65) == false) goto L107;
        setHintTextColor(r13.getColorStateList(r65));
    L107:
        int r66 = R.styleable.TextInputLayout_counterTextColor;
        if (r13.hasValue(r66) == false) goto L110;
        setCounterTextColor(r13.getColorStateList(r66));
    L110:
        int r67 = R.styleable.TextInputLayout_counterOverflowTextColor;
        if (r13.hasValue(r67) == false) goto L113;
        setCounterOverflowTextColor(r13.getColorStateList(r67));
    L113:
        int r68 = R.styleable.TextInputLayout_placeholderTextColor;
        if (r13.hasValue(r68) == false) goto L116;
        setPlaceholderTextColor(r13.getColorStateList(r68));
    L116:
        int r69 = R.styleable.TextInputLayout_prefixTextColor;
        if (r13.hasValue(r69) == false) goto L119;
        setPrefixTextColor(r13.getColorStateList(r69));
    L119:
        int r70 = R.styleable.TextInputLayout_suffixTextColor;
        if (r13.hasValue(r70) == false) goto L122;
        setSuffixTextColor(r13.getColorStateList(r70));
    L122:
        setCounterEnabled(r115);
        setEnabled(r13.getBoolean(R.styleable.TextInputLayout_android_enabled, true));
        r13.recycle();
        ViewCompat.setImportantForAccessibility(this, 2);
        if (Build.VERSION.SDK_INT < 26) goto L126;
        ViewCompat.setImportantForAutofill(this, 1);
        return;
    L126:
        return;
    L82:
        int r71 = R.styleable.TextInputLayout_passwordToggleEnabled;
        if (r13.hasValue(r71) == false) goto L91;
        setEndIconMode(r13.getBoolean(r71, false) ? 1 : 0);
        setEndIconContentDescription(r13.getText(R.styleable.TextInputLayout_passwordToggleContentDescription));
        int r72 = R.styleable.TextInputLayout_passwordToggleTint;
        if (r13.hasValue(r72) == false) goto L87;
        setEndIconTintList(MaterialResources.getColorStateList(r12, r13, r72));
    L87:
        int r73 = R.styleable.TextInputLayout_passwordToggleTintMode;
        if (r13.hasValue(r73) == false) goto L91;
        setEndIconTintMode(ViewUtils.parseTintMode(r13.getInt(r73, -1), null));
        goto L91
    L75:
        r116 = r55;
        goto L76
    L71:
        r54 = 0;
        goto L72
    L40:
        r35 = 0;
        goto L41
    L25:
        r28 = 2;
        this.focusedFilledBackgroundColor = this.defaultFilledBackgroundColor;
        ColorStateList r74 = AppCompatResources.getColorStateList(r12, R.color.mtrl_filled_background_color);
        this.disabledFilledBackgroundColor = r74.getColorForState(new int[]{-16842910}, -1);
        r29 = r74.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
        goto L26
    L27:
        r28 = 2;
        this.boxBackgroundColor = 0;
        this.defaultFilledBackgroundColor = 0;
        this.disabledFilledBackgroundColor = 0;
        this.focusedFilledBackgroundColor = 0;
        this.hoveredFilledBackgroundColor = 0;
        goto L28
    }

    static /* synthetic */ boolean access$000(TextInputLayout r0) {
        return r0.restoringSavedState;
    }

    static /* synthetic */ boolean access$100(TextInputLayout r0) {
        return r0.placeholderEnabled;
    }

    static /* synthetic */ void access$200(TextInputLayout r0, int r1) {
        r0.updatePlaceholderText(r1);
    }

    static /* synthetic */ CheckableImageButton access$300(TextInputLayout r0) {
        return r0.endIconView;
    }

    private void addPlaceholderTextView() {
        TextView r0 = this.placeholderTextView;
        if (r0 == null) goto L6;
        this.inputFrame.addView(r0);
        this.placeholderTextView.setVisibility(0);
        return;
    }

    private void adjustFilledEditTextPaddingForLargeFont() {
        if (this.editText != null) goto L5;
        return;
    L5:
        if (this.boxBackgroundMode == 1) goto L8;
        return;
    L8:
        if (MaterialResources.isFontScaleAtLeast2_0(getContext()) == false) goto L12;
        EditText r0 = this.editText;
        int r1 = ViewCompat.getPaddingStart(r0);
        int r2 = getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top);
        int r3 = ViewCompat.getPaddingEnd(this.editText);
        Resources r5 = getResources();
        int r4 = R.dimen.material_filled_edittext_font_2_0_padding_bottom;
    L10:
        ViewCompat.setPaddingRelative(r0, r1, r2, r3, r5.getDimensionPixelSize(r4));
        return;
    L12:
        if (MaterialResources.isFontScaleAtLeast1_3(getContext()) == false) goto L16;
        r0 = this.editText;
        r1 = ViewCompat.getPaddingStart(r0);
        r2 = getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top);
        r3 = ViewCompat.getPaddingEnd(this.editText);
        r5 = getResources();
        r4 = R.dimen.material_filled_edittext_font_1_3_padding_bottom;
        goto L10
    }

    private void applyBoxAttributes() {
        MaterialShapeDrawable r0 = this.boxBackground;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setShapeAppearanceModel(this.shapeAppearanceModel);
        if (canDrawOutlineStroke() == false) goto L8;
        this.boxBackground.setStroke(this.boxStrokeWidthPx, this.boxStrokeColor);
    L8:
        int r1 = calculateBoxBackgroundColor();
        this.boxBackgroundColor = r1;
        this.boxBackground.setFillColor(ColorStateList.valueOf(r1));
        if (this.endIconMode != 3) goto L11;
        this.editText.getBackground().invalidateSelf();
    L11:
        applyBoxUnderlineAttributes();
        invalidate();
    }

    private void applyBoxUnderlineAttributes() {
        if (this.boxUnderline != null) goto L6;
        return;
    L6:
        if (canDrawStroke() == false) goto L8;
        this.boxUnderline.setFillColor(ColorStateList.valueOf(this.boxStrokeColor));
    L8:
        invalidate();
    }

    private void applyCutoutPadding(@NonNull RectF r3) {
        float r0 = r3.left;
        int r2 = this.boxLabelCutoutPaddingPx;
        r3.left = r0 - r2;
        r3.right += r2;
    }

    private void applyEndIconTint() {
        applyIconTint(this.endIconView, this.hasEndIconTintList, this.endIconTintList, this.hasEndIconTintMode, this.endIconTintMode);
    }

    private void applyIconTint(@NonNull CheckableImageButton r1, boolean r2, ColorStateList r3, boolean r4, PorterDuff.Mode r5) {
        Drawable r0 = r1.getDrawable();
        if (r0 == null) goto L12;
        if (r2 == true) goto L6;
        if (r4 == false) goto L12;
    L6:
        r0 = DrawableCompat.wrap(r0).mutate();
        if (r2 == false) goto L9;
        DrawableCompat.setTintList(r0, r3);
    L9:
        if (r4 == false) goto L12;
        DrawableCompat.setTintMode(r0, r5);
    L12:
        if (r1.getDrawable() == r0) goto L15;
        r1.setImageDrawable(r0);
        return;
    }

    private void applyStartIconTint() {
        applyIconTint(this.startIconView, this.hasStartIconTintList, this.startIconTintList, this.hasStartIconTintMode, this.startIconTintMode);
    }

    private void assignBoxBackgroundByMode() {
        int r0 = this.boxBackgroundMode;
        if (r0 != 0) goto L5;
        this.boxBackground = null;
    L19:
        this.boxUnderline = null;
        return;
    L5:
        if (r0 != 1) goto L7;
        this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
        this.boxUnderline = new MaterialShapeDrawable();
        return;
    L7:
        if (r0 != 2) goto L16;
        if (this.hintEnabled == true) goto L11;
    L13:
        MaterialShapeDrawable r1 = new MaterialShapeDrawable(this.shapeAppearanceModel);
    L14:
        this.boxBackground = r1;
        goto L19
    L11:
        if ((this.boxBackground instanceof CutoutDrawable) == true) goto L13;
        r1 = new CutoutDrawable(this.shapeAppearanceModel);
        goto L14
    L16:
        throw new IllegalArgumentException(this.boxBackgroundMode + " is illegal; only @BoxBackgroundMode constants are supported.");
    }

    private int calculateBoxBackgroundColor() {
        int r0 = this.boxBackgroundColor;
        if (this.boxBackgroundMode == 1) goto L5;
        return r0;
    L5:
        return MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface, 0), this.boxBackgroundColor);
    }

    @NonNull
    private Rect calculateCollapsedTextBounds(@NonNull Rect r5) {
        if (this.editText == null) goto L19;
        Rect r0 = this.tmpBoundsRect;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L7;
        boolean r1 = true;
    L8:
        r0.bottom = r5.bottom;
        int r3 = this.boxBackgroundMode;
        if (r3 != 1) goto L11;
        r0.left = getLabelLeftBoundAlightWithPrefix(r5.left, r1);
        r0.top = r5.top + this.boxCollapsedPaddingTopPx;
        r0.right = getLabelRightBoundAlignedWithSuffix(r5.right, r1);
        return r0;
    L11:
        if (r3 == 2) goto L14;
        r0.left = getLabelLeftBoundAlightWithPrefix(r5.left, r1);
        r0.top = getPaddingTop();
        r0.right = getLabelRightBoundAlignedWithSuffix(r5.right, r1);
        return r0;
    L14:
        r0.left = r5.left + this.editText.getPaddingLeft();
        r0.top = r5.top - calculateLabelMarginTop();
        r0.right = r5.right - this.editText.getPaddingRight();
        return r0;
    L7:
        r1 = false;
        goto L8
    L19:
        throw new IllegalStateException();
    }

    private int calculateExpandedLabelBottom(@NonNull Rect r2, @NonNull Rect r3, float r4) {
        if (isSingleLineFilledTextField() == false) goto L7;
        return (int) (r3.top + r4);
    L7:
        return r2.bottom - this.editText.getCompoundPaddingBottom();
    }

    private int calculateExpandedLabelTop(@NonNull Rect r2, float r3) {
        if (isSingleLineFilledTextField() == false) goto L7;
        return (int) (r2.centerY() - (r3 / 2.0f));
    L7:
        return r2.top + this.editText.getCompoundPaddingTop();
    }

    @NonNull
    private Rect calculateExpandedTextBounds(@NonNull Rect r5) {
        if (this.editText == null) goto L7;
        Rect r0 = this.tmpBoundsRect;
        float r1 = this.collapsingTextHelper.getExpandedTextHeight();
        r0.left = r5.left + this.editText.getCompoundPaddingLeft();
        r0.top = calculateExpandedLabelTop(r5, r1);
        r0.right = r5.right - this.editText.getCompoundPaddingRight();
        r0.bottom = calculateExpandedLabelBottom(r5, r0, r1);
        return r0;
    L7:
        throw new IllegalStateException();
    }

    private int calculateLabelMarginTop() {
        if (this.hintEnabled == true) goto L5;
        return 0;
    L5:
        int r0 = this.boxBackgroundMode;
        if (r0 != 0) goto L8;
    L15:
        float r3 = this.collapsingTextHelper.getCollapsedTextHeight();
    L14:
        return (int) r3;
    L8:
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L12;
        return 0;
    L12:
        r3 = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        goto L14
    }

    private boolean canDrawOutlineStroke() {
        if (this.boxBackgroundMode == 2) goto L5;
    L7:
        return false;
    L5:
        if (canDrawStroke() == false) goto L7;
        return true;
    }

    private boolean canDrawStroke() {
        if (this.boxStrokeWidthPx > (-1)) goto L5;
    L7:
        return false;
    L5:
        if (this.boxStrokeColor == 0) goto L7;
        return true;
    }

    private void closeCutout() {
        if (cutoutEnabled() == false) goto L6;
        ((CutoutDrawable) this.boxBackground).removeCutout();
        return;
    }

    private void collapseHint(boolean r2) {
        ValueAnimator r0 = this.animator;
        if (r0 == null) goto L8;
        if (r0.isRunning() == false) goto L8;
        this.animator.cancel();
    L8:
        if (r2 == true) goto L10;
    L12:
        this.collapsingTextHelper.setExpansionFraction(1.0f);
    L13:
        this.hintExpanded = false;
        if (cutoutEnabled() == false) goto L16;
        openCutout();
    L16:
        updatePlaceholderText();
        updatePrefixTextVisibility();
        updateSuffixTextVisibility();
        return;
    L10:
        if (this.hintAnimationEnabled == false) goto L12;
        animateToExpansionFraction(1.0f);
        goto L13
    }

    private Fade createPlaceholderFadeTransition() {
        Fade r2 = new Fade();
        r2.setDuration(PLACEHOLDER_FADE_DURATION);
        r2.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return r2;
    }

    private boolean cutoutEnabled() {
        if (this.hintEnabled == true) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(this.hint) == true) goto L9;
        if ((this.boxBackground instanceof CutoutDrawable) == false) goto L9;
        return true;
    }

    private void dispatchOnEditTextAttached() {
        Iterator<OnEditTextAttachedListener> r0 = this.editTextAttachedListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onEditTextAttached(this);
        goto L4
    }

    private void dispatchOnEndIconChanged(int r3) {
        Iterator<OnEndIconChangedListener> r0 = this.endIconChangedListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onEndIconChanged(this, r3);
        goto L4
    }

    private void drawBoxUnderline(Canvas r4) {
        MaterialShapeDrawable r0 = this.boxUnderline;
        if (r0 == null) goto L6;
        Rect r1 = r0.getBounds();
        r1.top = r1.bottom - this.boxStrokeWidthPx;
        this.boxUnderline.draw(r4);
        return;
    }

    private void drawHint(@NonNull Canvas r2) {
        if (this.hintEnabled == false) goto L6;
        this.collapsingTextHelper.draw(r2);
        return;
    }

    private void expandHint(boolean r2) {
        ValueAnimator r0 = this.animator;
        if (r0 == null) goto L8;
        if (r0.isRunning() == false) goto L8;
        this.animator.cancel();
    L8:
        if (r2 == true) goto L10;
    L12:
        this.collapsingTextHelper.setExpansionFraction(0.0f);
    L14:
        if (cutoutEnabled() == true) goto L16;
    L18:
        this.hintExpanded = true;
        hidePlaceholderText();
        updatePrefixTextVisibility();
        updateSuffixTextVisibility();
        return;
    L16:
        if (((CutoutDrawable) this.boxBackground).hasCutout() == false) goto L18;
        closeCutout();
        goto L18
    L10:
        if (this.hintAnimationEnabled == false) goto L12;
        animateToExpansionFraction(0.0f);
        goto L14
    }

    private EndIconDelegate getEndIconDelegate() {
        EndIconDelegate r0 = this.endIconDelegates.get(this.endIconMode);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.endIconDelegates.get(0);
    }

    @Nullable
    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.errorIconView.getVisibility() != 0) goto L7;
        return this.errorIconView;
    L7:
        if (hasEndIcon() == true) goto L9;
        return null;
    L9:
        if (isEndIconVisible() == true) goto L11;
        return null;
    L11:
        return this.endIconView;
    }

    private int getLabelLeftBoundAlightWithPrefix(int r2, boolean r3) {
        int r4 = r2 + this.editText.getCompoundPaddingLeft();
        if (this.prefixText == null) goto L7;
        if (r3 == false) goto L6;
        return r4;
    L6:
        return (r4 - this.prefixTextView.getMeasuredWidth()) + this.prefixTextView.getPaddingLeft();
    L7:
        return r4;
    }

    private int getLabelRightBoundAlignedWithSuffix(int r2, boolean r3) {
        int r4 = r2 - this.editText.getCompoundPaddingRight();
        if (this.prefixText == null) goto L7;
        if (r3 == true) goto L6;
        return r4;
    L6:
        return r4 + (this.prefixTextView.getMeasuredWidth() - this.prefixTextView.getPaddingRight());
    L7:
        return r4;
    }

    private boolean hasEndIcon() {
        if (this.endIconMode == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void hidePlaceholderText() {
        TextView r0 = this.placeholderTextView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.placeholderEnabled == false) goto L9;
        r0.setText(null);
        TransitionManager.beginDelayedTransition(this.inputFrame, this.placeholderFadeOut);
        this.placeholderTextView.setVisibility(4);
        return;
    }

    private boolean isErrorIconVisible() {
        if (this.errorIconView.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isSingleLineFilledTextField() {
        if (this.boxBackgroundMode == 1) goto L5;
    L9:
        return false;
    L5:
        if (Build.VERSION.SDK_INT >= 16) goto L7;
        return true;
    L7:
        if (this.editText.getMinLines() > 1) goto L9;
        return true;
    }

    private int[] mergeIconState(CheckableImageButton r4) {
        int[] r3 = getDrawableState();
        int[] r5 = r4.getDrawableState();
        int r0 = r3.length;
        int[] r6 = Arrays.copyOf(r3, r3.length + r5.length);
        System.arraycopy(r5, 0, r6, r0, r5.length);
        return r6;
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        setEditTextBoxBackground();
        updateTextInputBoxState();
        updateBoxCollapsedPaddingTop();
        adjustFilledEditTextPaddingForLargeFont();
        if (this.boxBackgroundMode == 0) goto L6;
        updateInputLayoutMargins();
        return;
    }

    private void openCutout() {
        if (cutoutEnabled() == true) goto L5;
        return;
    L5:
        RectF r0 = this.tmpRectF;
        this.collapsingTextHelper.getCollapsedTextActualBounds(r0, this.editText.getWidth(), this.editText.getGravity());
        applyCutoutPadding(r0);
        r0.offset(-getPaddingLeft(), ((-getPaddingTop()) - (r0.height() / 2.0f)) + this.boxStrokeWidthPx);
        ((CutoutDrawable) this.boxBackground).setCutout(r0);
    }

    private void recalculateCutout() {
        if (cutoutEnabled() == true) goto L5;
        return;
    L5:
        if (this.hintExpanded == true) goto L9;
        closeCutout();
        openCutout();
        return;
    }

    private static void recursiveSetEnabled(@NonNull ViewGroup r4, boolean r5) {
        int r0 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        View r2 = r4.getChildAt(r1);
        r2.setEnabled(r5);
        if ((r2 instanceof ViewGroup) == false) goto L7;
        recursiveSetEnabled((ViewGroup) r2, r5);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    private void refreshIconDrawableState(CheckableImageButton r3, ColorStateList r4) {
        Drawable r0 = r3.getDrawable();
        if (r3.getDrawable() == null) goto L10;
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.isStateful() == false) goto L12;
        int r2 = r4.getColorForState(mergeIconState(r3), r4.getDefaultColor());
        Drawable r5 = DrawableCompat.wrap(r0).mutate();
        DrawableCompat.setTintList(r5, ColorStateList.valueOf(r2));
        r3.setImageDrawable(r5);
        return;
    L12:
        return;
    }

    private void removePlaceholderTextView() {
        TextView r1 = this.placeholderTextView;
        if (r1 == null) goto L6;
        r1.setVisibility(8);
        return;
    }

    private void setEditText(EditText r4) {
        if (this.editText != null) goto L27;
        if (this.endIconMode != 3) goto L7;
    L9:
        this.editText = r4;
        setMinWidth(this.minWidth);
        setMaxWidth(this.maxWidth);
        onApplyBoxBackgroundMode();
        setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
        this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
        this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
        int r0 = this.editText.getGravity();
        this.collapsingTextHelper.setCollapsedTextGravity((r0 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 48);
        this.collapsingTextHelper.setExpandedTextGravity(r0);
        this.editText.addTextChangedListener(new AnonymousClass1(this));
        if (this.defaultHintTextColor != null) goto L13;
        this.defaultHintTextColor = this.editText.getHintTextColors();
    L13:
        if (this.hintEnabled == false) goto L19;
        if (TextUtils.isEmpty(this.hint) == false) goto L17;
        CharSequence r1 = this.editText.getHint();
        this.originalHint = r1;
        setHint(r1);
        this.editText.setHint(null);
    L17:
        this.isProvidingHint = true;
    L19:
        if (this.counterView == null) goto L21;
        updateCounter(this.editText.getText().length());
    L21:
        updateEditTextBackground();
        this.indicatorViewController.adjustIndicatorPadding();
        this.startLayout.bringToFront();
        this.endLayout.bringToFront();
        this.endIconFrame.bringToFront();
        this.errorIconView.bringToFront();
        dispatchOnEditTextAttached();
        updatePrefixTextViewPadding();
        updateSuffixTextViewPadding();
        if (isEnabled() == true) goto L24;
        r4.setEnabled(false);
    L24:
        updateLabelState(false, true);
        return;
    L7:
        if ((r4 instanceof TextInputEditText) == true) goto L9;
        Log.i(LOG_TAG, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        goto L9
    L27:
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setEditTextBoxBackground() {
        if (shouldUseEditTextBackgroundForBoxBackground() == false) goto L6;
        ViewCompat.setBackground(this.editText, this.boxBackground);
        return;
    }

    private void setErrorIconVisible(boolean r5) {
        CheckableImageButton r0 = this.errorIconView;
        int r1 = 0;
        if (r5 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        FrameLayout r2 = this.endIconFrame;
        if (r5 == false) goto L9;
        r1 = 8;
    L9:
        r2.setVisibility(r1);
        updateSuffixTextViewPadding();
        if (hasEndIcon() == true) goto L13;
        updateDummyDrawables();
        return;
    L13:
        return;
    L5:
        r3 = 8;
        goto L6
    }

    private void setHintInternal(CharSequence r2) {
        if (TextUtils.equals(r2, this.hint) == true) goto L8;
        this.hint = r2;
        this.collapsingTextHelper.setText(r2);
        if (this.hintExpanded == true) goto L9;
        openCutout();
        return;
    L9:
        return;
    }

    private static void setIconClickable(@NonNull CheckableImageButton r3, @Nullable View.OnLongClickListener r4) {
        boolean r0 = ViewCompat.hasOnClickListeners(r3);
        boolean r1 = false;
        int r2 = 1;
        if (r4 == null) goto L5;
        boolean r5 = true;
    L6:
        if (r0 == true) goto L8;
        if (r5 == true) goto L8;
    L9:
        r3.setFocusable(r1);
        r3.setClickable(r0);
        r3.setPressable(r0);
        r3.setLongClickable(r5);
        if (r1 == true) goto L13;
        r2 = 2;
    L13:
        ViewCompat.setImportantForAccessibility(r3, r2);
        return;
    L8:
        r1 = true;
        goto L9
    L5:
        r5 = false;
        goto L6
    }

    private static void setIconOnClickListener(@NonNull CheckableImageButton r0, @Nullable View.OnClickListener r1, @Nullable View.OnLongClickListener r2) {
        r0.setOnClickListener(r1);
        setIconClickable(r0, r2);
    }

    private static void setIconOnLongClickListener(@NonNull CheckableImageButton r0, @Nullable View.OnLongClickListener r1) {
        r0.setOnLongClickListener(r1);
        setIconClickable(r0, r1);
    }

    private void setPlaceholderTextEnabled(boolean r4) {
        if (this.placeholderEnabled != r4) goto L5;
        return;
    L5:
        if (r4 == false) goto L7;
        AppCompatTextView r0 = new AppCompatTextView(getContext());
        this.placeholderTextView = r0;
        r0.setId(R.id.textinput_placeholder);
        Fade r1 = createPlaceholderFadeTransition();
        this.placeholderFadeIn = r1;
        r1.setStartDelay(PLACEHOLDER_START_DELAY);
        this.placeholderFadeOut = createPlaceholderFadeTransition();
        ViewCompat.setAccessibilityLiveRegion(this.placeholderTextView, 1);
        setPlaceholderTextAppearance(this.placeholderTextAppearance);
        setPlaceholderTextColor(this.placeholderTextColor);
        addPlaceholderTextView();
    L8:
        this.placeholderEnabled = r4;
        return;
    L7:
        removePlaceholderTextView();
        this.placeholderTextView = null;
        goto L8
    }

    private boolean shouldUpdateEndDummyDrawable() {
        if (this.errorIconView.getVisibility() == 0) goto L11;
        if (hasEndIcon() == false) goto L9;
        if (isEndIconVisible() == true) goto L11;
    L9:
        if (this.suffixText != null) goto L11;
    L13:
        return false;
    L11:
        if (this.endLayout.getMeasuredWidth() <= 0) goto L13;
        return true;
    }

    private boolean shouldUpdateStartDummyDrawable() {
        if (getStartIconDrawable() != null) goto L7;
        if (this.prefixText != null) goto L7;
    L9:
        return false;
    L7:
        if (this.startLayout.getMeasuredWidth() <= 0) goto L9;
        return true;
    }

    private boolean shouldUseEditTextBackgroundForBoxBackground() {
        EditText r0 = this.editText;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (this.boxBackground == null) goto L11;
        if (r0.getBackground() != null) goto L11;
        if (this.boxBackgroundMode == 0) goto L11;
        return true;
    }

    private void showPlaceholderText() {
        TextView r0 = this.placeholderTextView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.placeholderEnabled == false) goto L9;
        r0.setText(this.placeholderText);
        TransitionManager.beginDelayedTransition(this.inputFrame, this.placeholderFadeIn);
        this.placeholderTextView.setVisibility(0);
        this.placeholderTextView.bringToFront();
        return;
    }

    private void tintEndIconOnError(boolean r2) {
        if (r2 == true) goto L4;
    L6:
        applyEndIconTint();
        return;
    L4:
        if (getEndIconDrawable() == null) goto L6;
        Drawable r3 = DrawableCompat.wrap(getEndIconDrawable()).mutate();
        DrawableCompat.setTint(r3, this.indicatorViewController.getErrorViewCurrentTextColor());
        this.endIconView.setImageDrawable(r3);
    }

    private void updateBoxCollapsedPaddingTop() {
        if (this.boxBackgroundMode == 1) goto L5;
        return;
    L5:
        if (MaterialResources.isFontScaleAtLeast2_0(getContext()) == false) goto L9;
        Resources r0 = getResources();
        int r1 = R.dimen.material_font_2_0_box_collapsed_padding_top;
    L7:
        this.boxCollapsedPaddingTopPx = r0.getDimensionPixelSize(r1);
        return;
    L9:
        if (MaterialResources.isFontScaleAtLeast1_3(getContext()) == false) goto L13;
        r0 = getResources();
        r1 = R.dimen.material_font_1_3_box_collapsed_padding_top;
        goto L7
    }

    private void updateBoxUnderlineBounds(@NonNull Rect r4) {
        MaterialShapeDrawable r0 = this.boxUnderline;
        if (r0 == null) goto L6;
        int r1 = r4.bottom;
        int r3 = r1 - this.boxStrokeWidthFocusedPx;
        r0.setBounds(r4.left, r3, r4.right, r1);
        return;
    }

    private void updateCounter() {
        if (this.counterView == null) goto L10;
        EditText r0 = this.editText;
        if (r0 != null) goto L7;
        int r1 = 0;
    L8:
        updateCounter(r1);
        return;
    L7:
        r1 = r0.getText().length();
        goto L8
    }

    private static void updateCounterContentDescription(@NonNull Context r2, @NonNull TextView r3, int r4, int r5, boolean r6) {
        if (r6 == false) goto L4;
        int r7 = R.string.character_counter_overflowed_content_description;
    L5:
        r3.setContentDescription(r2.getString(r7, new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)}));
        return;
    L4:
        r7 = R.string.character_counter_content_description;
        goto L5
    }

    private void updateCounterTextAppearanceAndColor() {
        TextView r0 = this.counterView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.counterOverflowed == false) goto L7;
        int r1 = this.counterOverflowTextAppearance;
    L8:
        setTextAppearanceCompatWithErrorFallback(r0, r1);
        if (this.counterOverflowed == true) goto L14;
        ColorStateList r2 = this.counterTextColor;
        if (r2 == null) goto L14;
        this.counterView.setTextColor(r2);
    L14:
        if (this.counterOverflowed == false) goto L20;
        ColorStateList r3 = this.counterOverflowTextColor;
        if (r3 == null) goto L21;
        this.counterView.setTextColor(r3);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r1 = this.counterTextAppearance;
        goto L8
    }

    private boolean updateDummyDrawables() {
        if (this.editText != null) goto L5;
        return false;
    L5:
        boolean r5 = true;
        if (shouldUpdateStartDummyDrawable() == false) goto L16;
        int r0 = this.startLayout.getMeasuredWidth() - this.editText.getPaddingLeft();
        if (this.startDummyDrawable != null) goto L10;
    L11:
        ColorDrawable r6 = new ColorDrawable();
        this.startDummyDrawable = r6;
        this.startDummyDrawableWidth = r0;
        r6.setBounds(0, 0, r0, 1);
    L12:
        Drawable[] r1 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
        Drawable r7 = r1[0];
        Drawable r8 = this.startDummyDrawable;
        if (r7 == r8) goto L19;
        TextViewCompat.setCompoundDrawablesRelative(this.editText, r8, r1[1], r1[2], r1[3]);
    L18:
        boolean r2 = true;
    L21:
        if (shouldUpdateEndDummyDrawable() == false) goto L37;
        int r3 = this.suffixTextView.getMeasuredWidth() - this.editText.getPaddingRight();
        CheckableImageButton r9 = getEndIconToUpdateDummyDrawable();
        if (r9 == null) goto L25;
        r3 = (r3 + r9.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r9.getLayoutParams());
    L25:
        Drawable[] r10 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
        Drawable r11 = this.endDummyDrawable;
        if (r11 != null) goto L28;
    L30:
        if (r11 != null) goto L32;
        ColorDrawable r12 = new ColorDrawable();
        this.endDummyDrawable = r12;
        this.endDummyDrawableWidth = r3;
        r12.setBounds(0, 0, r3, 1);
    L32:
        Drawable r4 = r10[2];
        Drawable r13 = this.endDummyDrawable;
        if (r4 == r13) goto L35;
        this.originalEditTextEndDrawable = r10[2];
        TextViewCompat.setCompoundDrawablesRelative(this.editText, r10[0], r10[1], r13, r10[3]);
    L44:
        return r5;
    L35:
        r5 = r2;
        goto L44
    L28:
        if (this.endDummyDrawableWidth == r3) goto L30;
        this.endDummyDrawableWidth = r3;
        r11.setBounds(0, 0, r3, 1);
        TextViewCompat.setCompoundDrawablesRelative(this.editText, r10[0], r10[1], this.endDummyDrawable, r10[3]);
        goto L44
    L37:
        if (this.endDummyDrawable == null) goto L45;
        Drawable[] r14 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
        if (r14[2] != this.endDummyDrawable) goto L41;
        TextViewCompat.setCompoundDrawablesRelative(this.editText, r14[0], r14[1], this.originalEditTextEndDrawable, r14[3]);
    L42:
        this.endDummyDrawable = null;
        goto L44
    L41:
        r5 = r2;
        goto L42
    L45:
        return r2;
    L19:
        r2 = false;
        goto L21
    L10:
        if (this.startDummyDrawableWidth == r0) goto L12;
    L16:
        if (this.startDummyDrawable == null) goto L19;
        Drawable[] r15 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
        TextViewCompat.setCompoundDrawablesRelative(this.editText, null, r15[1], r15[2], r15[3]);
        this.startDummyDrawable = null;
        goto L18
    }

    private boolean updateEditTextHeightBasedOnIcon() {
        if (this.editText != null) goto L5;
        return false;
    L5:
        int r0 = Math.max(this.endLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight());
        if (this.editText.getMeasuredHeight() >= r0) goto L9;
        this.editText.setMinimumHeight(r0);
        return true;
    L9:
        return false;
    }

    private void updateInputLayoutMargins() {
        if (this.boxBackgroundMode == 1) goto L8;
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
        int r1 = calculateLabelMarginTop();
        if (r1 == r0.topMargin) goto L9;
        r0.topMargin = r1;
        this.inputFrame.requestLayout();
        return;
    L9:
        return;
    }

    private void updateLabelState(boolean r9, boolean r10) {
        boolean r0 = isEnabled();
        EditText r1 = this.editText;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        EditText r4 = this.editText;
        if (r4 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        boolean r6 = this.indicatorViewController.errorShouldBeShown();
        ColorStateList r7 = this.defaultHintTextColor;
        if (r7 == null) goto L17;
        this.collapsingTextHelper.setCollapsedTextColor(r7);
        this.collapsingTextHelper.setExpandedTextColor(this.defaultHintTextColor);
    L17:
        if (r0 == true) goto L23;
        ColorStateList r3 = this.defaultHintTextColor;
        if (r3 == null) goto L21;
        int r8 = r3.getColorForState(new int[]{-16842910}, this.disabledColor);
    L22:
        this.collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf(r8));
        this.collapsingTextHelper.setExpandedTextColor(ColorStateList.valueOf(r8));
    L35:
        if (r2 == false) goto L37;
    L46:
        if (r10 == false) goto L48;
    L49:
        collapseHint(r9);
        return;
    L48:
        if (this.hintExpanded == true) goto L49;
        return;
    L37:
        if (this.expandedHintEnabled == false) goto L46;
        if (isEnabled() == false) goto L42;
        if (r5 == true) goto L46;
    L42:
        if (r10 == false) goto L44;
    L45:
        expandHint(r9);
        return;
    L44:
        if (this.hintExpanded == false) goto L45;
        return;
    L21:
        r8 = this.disabledColor;
        goto L22
    L23:
        if (r6 == false) goto L26;
        this.collapsingTextHelper.setCollapsedTextColor(this.indicatorViewController.getErrorViewTextColors());
        goto L35
    L26:
        if (this.counterOverflowed == false) goto L31;
        TextView r11 = this.counterView;
        if (r11 == null) goto L31;
        CollapsingTextHelper r12 = this.collapsingTextHelper;
        ColorStateList r13 = r11.getTextColors();
    L30:
        r12.setCollapsedTextColor(r13);
    L31:
        if (r5 == false) goto L35;
        r13 = this.focusedTextColor;
        if (r13 == null) goto L35;
        r12 = this.collapsingTextHelper;
        goto L30
    L11:
        if (r4.hasFocus() == false) goto L13;
        r5 = true;
        goto L14
    L5:
        if (TextUtils.isEmpty(r1.getText()) == true) goto L7;
        r2 = true;
        goto L8
    }

    private void updatePlaceholderMeasurementsBasedOnEditText() {
        if (this.placeholderTextView == null) goto L8;
        EditText r0 = this.editText;
        if (r0 == null) goto L9;
        int r1 = r0.getGravity();
        this.placeholderTextView.setGravity(r1);
        this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
        return;
    L9:
        return;
    }

    private void updatePlaceholderText() {
        EditText r0 = this.editText;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        updatePlaceholderText(r1);
        return;
    L5:
        r1 = r0.getText().length();
        goto L6
    }

    private void updatePlaceholderText(int r1) {
        if (r1 == 0) goto L4;
    L6:
        hidePlaceholderText();
        return;
    L4:
        if (this.hintExpanded == true) goto L6;
        showPlaceholderText();
    }

    private void updatePrefixTextViewPadding() {
        if (this.editText != null) goto L6;
        return;
    L6:
        if (isStartIconVisible() == false) goto L8;
        int r0 = 0;
    L9:
        ViewCompat.setPaddingRelative(this.prefixTextView, r0, this.editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.editText.getCompoundPaddingBottom());
        return;
    L8:
        r0 = ViewCompat.getPaddingStart(this.editText);
        goto L9
    }

    private void updatePrefixTextVisibility() {
        TextView r0 = this.prefixTextView;
        if (this.prefixText != null) goto L5;
    L7:
        int r1 = 8;
    L8:
        r0.setVisibility(r1);
        updateDummyDrawables();
        return;
    L5:
        if (isHintExpanded() == true) goto L7;
        r1 = 0;
        goto L8
    }

    private void updateStrokeErrorColor(boolean r5, boolean r6) {
        int r0 = this.strokeErrorColor.getDefaultColor();
        int r1 = this.strokeErrorColor.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, r0);
        int r2 = this.strokeErrorColor.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, r0);
        if (r5 == false) goto L5;
        this.boxStrokeColor = r2;
        return;
    L5:
        if (r6 == false) goto L7;
        this.boxStrokeColor = r1;
        return;
    L7:
        this.boxStrokeColor = r0;
    }

    private void updateSuffixTextViewPadding() {
        if (this.editText != null) goto L6;
        return;
    L6:
        if (isEndIconVisible() == false) goto L8;
    L11:
        int r0 = 0;
    L12:
        ViewCompat.setPaddingRelative(this.suffixTextView, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.editText.getPaddingTop(), r0, this.editText.getPaddingBottom());
        return;
    L8:
        if (isErrorIconVisible() == true) goto L11;
        r0 = ViewCompat.getPaddingEnd(this.editText);
        goto L12
    }

    private void updateSuffixTextVisibility() {
        int r0 = this.suffixTextView.getVisibility();
        int r2 = 0;
        if (this.suffixText != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        TextView r3 = this.suffixTextView;
        if (r1 == true) goto L12;
        r2 = 8;
    L12:
        r3.setVisibility(r2);
        if (r0 == this.suffixTextView.getVisibility()) goto L15;
        getEndIconDelegate().onSuffixVisibilityChanged(r1);
    L15:
        updateDummyDrawables();
        return;
    L5:
        if (isHintExpanded() == true) goto L7;
        r1 = true;
        goto L8
    }

    public void addOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener r2) {
        this.editTextAttachedListeners.add(r2);
        if (this.editText == null) goto L6;
        r2.onEditTextAttached(this);
        return;
    }

    public void addOnEndIconChangedListener(@NonNull OnEndIconChangedListener r1) {
        this.endIconChangedListeners.add(r1);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View r2, int r3, @NonNull ViewGroup.LayoutParams r4) {
        if ((r2 instanceof EditText) == false) goto L5;
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(r4);
        r5.gravity = (r5.gravity & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 16;
        this.inputFrame.addView(r2, r5);
        this.inputFrame.setLayoutParams(r4);
        updateInputLayoutMargins();
        setEditText((EditText) r2);
        return;
    L5:
        super.addView(r2, r3, r4);
    }

    @VisibleForTesting
    void animateToExpansionFraction(float r5) {
        if (this.collapsingTextHelper.getExpansionFraction() != r5) goto L6;
        return;
    L6:
        if (this.animator != null) goto L8;
        ValueAnimator r0 = new ValueAnimator();
        this.animator = r0;
        r0.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.animator.setDuration(167);
        this.animator.addUpdateListener(new AnonymousClass4(this));
    L8:
        this.animator.setFloatValues(new float[]{this.collapsingTextHelper.getExpansionFraction(), r5});
        this.animator.start();
    }

    public void clearOnEditTextAttachedListeners() {
        this.editTextAttachedListeners.clear();
    }

    public void clearOnEndIconChangedListeners() {
        this.endIconChangedListeners.clear();
    }

    @VisibleForTesting
    boolean cutoutIsOpen() {
        if (cutoutEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (((CutoutDrawable) this.boxBackground).hasCutout() == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure r5, int r6) {
        EditText r0 = this.editText;
        if (r0 != null) goto L6;
        super.dispatchProvideAutofillStructure(r5, r6);
        return;
    L6:
        int r2 = 0;
        if (this.originalHint == null) goto L14;
        boolean r1 = this.isProvidingHint;
        this.isProvidingHint = false;
        CharSequence r3 = r0.getHint();
        this.editText.setHint(this.originalHint);
        super.dispatchProvideAutofillStructure(r5, r6);     // Catch: Throwable -> L11
        this.editText.setHint(r3);
        this.isProvidingHint = r1;
        return;
    L11:
        th = move-exception;
        this.editText.setHint(r3);
        this.isProvidingHint = r1;
        throw th;
    L14:
        r5.setAutofillId(getAutofillId());
        onProvideAutofillStructure(r5, r6);
        onProvideAutofillVirtualStructure(r5, r6);
        r5.setChildCount(this.inputFrame.getChildCount());
    L16:
        if (r2 >= this.inputFrame.getChildCount()) goto L27;
        View r4 = this.inputFrame.getChildAt(r2);
        ViewStructure r7 = r5.newChild(r2);
        r4.dispatchProvideAutofillStructure(r7, r6);
        if (r4 != this.editText) goto L20;
        r7.setHint(getHint());
    L20:
        r2 = r2 + 1;
        goto L16
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> r2) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(r2);
        this.restoringSavedState = false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r1) {
        super.draw(r1);
        drawHint(r1);
        drawBoxUnderline(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.inDrawableStateChanged == false) goto L5;
        return;
    L5:
        boolean r0 = true;
        this.inDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] r1 = getDrawableState();
        CollapsingTextHelper r2 = this.collapsingTextHelper;
        if (r2 == null) goto L8;
        boolean r3 = r2.setState(r1) | false;
    L10:
        if (this.editText != null) goto L12;
    L18:
        updateEditTextBackground();
        updateTextInputBoxState();
        if (r3 == false) goto L21;
        invalidate();
    L21:
        this.inDrawableStateChanged = false;
        return;
    L12:
        if (ViewCompat.isLaidOut(this) == true) goto L14;
    L16:
        r0 = false;
    L17:
        updateLabelState(r0);
        goto L18
    L14:
        if (isEnabled() == false) goto L16;
    L8:
        r3 = false;
        goto L10
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText r0 = this.editText;
        if (r0 == null) goto L7;
        return (r0.getBaseline() + getPaddingTop()) + calculateLabelMarginTop();
    L7:
        return super.getBaseline();
    }

    @NonNull
    MaterialShapeDrawable getBoxBackground() {
        int r0 = this.boxBackgroundMode;
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L10;
        throw new IllegalStateException();
    L10:
        return this.boxBackground;
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.boxCollapsedPaddingTopPx;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.boxBackground.getBottomLeftCornerResolvedSize();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.boxBackground.getBottomRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.boxBackground.getTopRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.boxBackground.getTopLeftCornerResolvedSize();
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.strokeErrorColor;
    }

    public int getBoxStrokeWidth() {
        return this.boxStrokeWidthDefaultPx;
    }

    public int getBoxStrokeWidthFocused() {
        return this.boxStrokeWidthFocusedPx;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    @Nullable
    CharSequence getCounterOverflowDescription() {
        if (this.counterEnabled == true) goto L5;
        return null;
    L5:
        if (this.counterOverflowed == false) goto L12;
        TextView r1 = this.counterView;
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getContentDescription();
    L12:
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.counterTextColor;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    @Nullable
    public EditText getEditText() {
        return this.editText;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    public int getEndIconMode() {
        return this.endIconMode;
    }

    @NonNull
    CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    @Nullable
    public CharSequence getError() {
        if (this.indicatorViewController.isErrorEnabled() == true) goto L7;
        return null;
    L7:
        return this.indicatorViewController.getErrorText();
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.indicatorViewController.getErrorContentDescription();
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    @VisibleForTesting
    final int getErrorTextCurrentColor() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    @Nullable
    public CharSequence getHelperText() {
        if (this.indicatorViewController.isHelperTextEnabled() == true) goto L7;
        return null;
    L7:
        return this.indicatorViewController.getHelperText();
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.getHelperTextViewCurrentTextColor();
    }

    @Nullable
    public CharSequence getHint() {
        if (this.hintEnabled == true) goto L7;
        return null;
    L7:
        return this.hint;
    }

    @VisibleForTesting
    final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    @VisibleForTesting
    final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    @Px
    public int getMinWidth() {
        return this.minWidth;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.placeholderEnabled == true) goto L7;
        return null;
    L7:
        return this.placeholderText;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.placeholderTextAppearance;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.prefixText;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.prefixTextView.getTextColors();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.prefixTextView;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.suffixText;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.suffixTextView.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.suffixTextView;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.typeface;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public boolean isEndIconCheckable() {
        return this.endIconView.isCheckable();
    }

    public boolean isEndIconVisible() {
        if (this.endIconFrame.getVisibility() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.endIconView.getVisibility() != 0) goto L7;
        return true;
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.isErrorEnabled();
    }

    public boolean isExpandedHintEnabled() {
        return this.expandedHintEnabled;
    }

    @VisibleForTesting
    final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.helperTextIsDisplayed();
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.isHelperTextEnabled();
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    @VisibleForTesting
    final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    @Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        if (this.endIconMode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public boolean isStartIconCheckable() {
        return this.startIconView.isCheckable();
    }

    public boolean isStartIconVisible() {
        if (this.startIconView.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        EditText r6 = this.editText;
        if (r6 == null) goto L12;
        Rect r7 = this.tmpRect;
        DescendantOffsetUtils.getDescendantRect(this, r6, r7);
        updateBoxUnderlineBounds(r7);
        if (this.hintEnabled == false) goto L13;
        this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
        int r8 = this.editText.getGravity();
        this.collapsingTextHelper.setCollapsedTextGravity((r8 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 48);
        this.collapsingTextHelper.setExpandedTextGravity(r8);
        this.collapsingTextHelper.setCollapsedBounds(calculateCollapsedTextBounds(r7));
        this.collapsingTextHelper.setExpandedBounds(calculateExpandedTextBounds(r7));
        this.collapsingTextHelper.recalculate();
        if (cutoutEnabled() == true) goto L9;
        return;
    L9:
        if (this.hintExpanded == true) goto L15;
        openCutout();
        return;
    L15:
        return;
    L13:
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        boolean r3 = updateEditTextHeightBasedOnIcon();
        boolean r4 = updateDummyDrawables();
        if (r3 == true) goto L5;
        if (r4 == true) goto L5;
    L6:
        updatePlaceholderMeasurementsBasedOnEditText();
        updatePrefixTextViewPadding();
        updateSuffixTextViewPadding();
        return;
    L5:
        this.editText.post(new AnonymousClass3(this));
        goto L6
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@Nullable Parcelable r3) {
        if ((r3 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r3);
        return;
    L6:
        SavedState r4 = (SavedState) r3;
        super.onRestoreInstanceState(r4.getSuperState());
        setError(r4.error);
        if (r4.isEndIconChecked == false) goto L9;
        this.endIconView.post(new AnonymousClass2(this));
    L9:
        setHint(r4.hintText);
        setHelperText(r4.helperText);
        setPlaceholderText(r4.placeholderText);
        requestLayout();
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.errorShouldBeShown() == false) goto L6;
        r1.error = getError();
    L6:
        if (hasEndIcon() == true) goto L8;
    L10:
        boolean r0 = false;
    L11:
        r1.isEndIconChecked = r0;
        r1.hintText = getHint();
        r1.helperText = getHelperText();
        r1.placeholderText = getPlaceholderText();
        return r1;
    L8:
        if (this.endIconView.isChecked() == false) goto L10;
        r0 = true;
        goto L11
    }

    @Deprecated
    public void passwordVisibilityToggleRequested(boolean r3) {
        if (this.endIconMode != 1) goto L8;
        this.endIconView.performClick();
        if (r3 == false) goto L9;
        this.endIconView.jumpDrawablesToCurrentState();
        return;
    L9:
        return;
    }

    public void refreshEndIconDrawableState() {
        refreshIconDrawableState(this.endIconView, this.endIconTintList);
    }

    public void refreshErrorIconDrawableState() {
        refreshIconDrawableState(this.errorIconView, this.errorIconTintList);
    }

    public void refreshStartIconDrawableState() {
        refreshIconDrawableState(this.startIconView, this.startIconTintList);
    }

    public void removeOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener r1) {
        this.editTextAttachedListeners.remove(r1);
    }

    public void removeOnEndIconChangedListener(@NonNull OnEndIconChangedListener r1) {
        this.endIconChangedListeners.remove(r1);
    }

    public void setBoxBackgroundColor(@ColorInt int r2) {
        if (this.boxBackgroundColor == r2) goto L6;
        this.boxBackgroundColor = r2;
        this.defaultFilledBackgroundColor = r2;
        this.focusedFilledBackgroundColor = r2;
        this.hoveredFilledBackgroundColor = r2;
        applyBoxAttributes();
        return;
    }

    public void setBoxBackgroundColorResource(@ColorRes int r2) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), r2));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList r4) {
        int r0 = r4.getDefaultColor();
        this.defaultFilledBackgroundColor = r0;
        this.boxBackgroundColor = r0;
        this.disabledFilledBackgroundColor = r4.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = r4.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.hoveredFilledBackgroundColor = r4.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        applyBoxAttributes();
    }

    public void setBoxBackgroundMode(int r2) {
        if (r2 != this.boxBackgroundMode) goto L5;
        return;
    L5:
        this.boxBackgroundMode = r2;
        if (this.editText == null) goto L9;
        onApplyBoxBackgroundMode();
        return;
    }

    public void setBoxCollapsedPaddingTop(int r1) {
        this.boxCollapsedPaddingTopPx = r1;
    }

    public void setBoxCornerRadii(float r2, float r3, float r4, float r5) {
        MaterialShapeDrawable r0 = this.boxBackground;
        if (r0 != null) goto L5;
    L12:
        this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCornerSize(r2).setTopRightCornerSize(r3).setBottomRightCornerSize(r5).setBottomLeftCornerSize(r4).build();
        applyBoxAttributes();
        return;
    L5:
        if (r0.getTopLeftCornerResolvedSize() != r2) goto L12;
        if (this.boxBackground.getTopRightCornerResolvedSize() != r3) goto L12;
        if (this.boxBackground.getBottomRightCornerResolvedSize() != r5) goto L12;
        if (this.boxBackground.getBottomLeftCornerResolvedSize() != r4) goto L12;
    }

    public void setBoxCornerRadiiResources(@DimenRes int r2, @DimenRes int r3, @DimenRes int r4, @DimenRes int r5) {
        setBoxCornerRadii(getContext().getResources().getDimension(r2), getContext().getResources().getDimension(r3), getContext().getResources().getDimension(r5), getContext().getResources().getDimension(r4));
    }

    public void setBoxStrokeColor(@ColorInt int r2) {
        if (this.focusedStrokeColor == r2) goto L6;
        this.focusedStrokeColor = r2;
        updateTextInputBoxState();
        return;
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList r4) {
        if (r4.isStateful() == false) goto L7;
        this.defaultStrokeColor = r4.getDefaultColor();
        this.disabledColor = r4.getColorForState(new int[]{-16842910}, -1);
        this.hoveredStrokeColor = r4.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        int r5 = r4.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
    L5:
        this.focusedStrokeColor = r5;
    L9:
        updateTextInputBoxState();
        return;
    L7:
        if (this.focusedStrokeColor == r4.getDefaultColor()) goto L9;
        r5 = r4.getDefaultColor();
        goto L5
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList r2) {
        if (this.strokeErrorColor == r2) goto L6;
        this.strokeErrorColor = r2;
        updateTextInputBoxState();
        return;
    }

    public void setBoxStrokeWidth(int r1) {
        this.boxStrokeWidthDefaultPx = r1;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocused(int r1) {
        this.boxStrokeWidthFocusedPx = r1;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int r2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(r2));
    }

    public void setBoxStrokeWidthResource(@DimenRes int r2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(r2));
    }

    public void setCounterEnabled(boolean r4) {
        if (this.counterEnabled != r4) goto L5;
        return;
    L5:
        if (r4 == false) goto L10;
        AppCompatTextView r1 = new AppCompatTextView(getContext());
        this.counterView = r1;
        r1.setId(R.id.textinput_counter);
        Typeface r2 = this.typeface;
        if (r2 == null) goto L9;
        this.counterView.setTypeface(r2);
    L9:
        this.counterView.setMaxLines(1);
        this.indicatorViewController.addIndicator(this.counterView, 2);
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.counterView.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
        updateCounterTextAppearanceAndColor();
        updateCounter();
    L11:
        this.counterEnabled = r4;
        return;
    L10:
        this.indicatorViewController.removeIndicator(this.counterView, 2);
        this.counterView = null;
        goto L11
    }

    public void setCounterMaxLength(int r2) {
        if (this.counterMaxLength == r2) goto L11;
        if (r2 > 0) goto L7;
        r2 = -1;
    L7:
        this.counterMaxLength = r2;
        if (this.counterEnabled == false) goto L12;
        updateCounter();
        return;
    L12:
        return;
    }

    public void setCounterOverflowTextAppearance(int r2) {
        if (this.counterOverflowTextAppearance == r2) goto L6;
        this.counterOverflowTextAppearance = r2;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList r2) {
        if (this.counterOverflowTextColor == r2) goto L6;
        this.counterOverflowTextColor = r2;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public void setCounterTextAppearance(int r2) {
        if (this.counterTextAppearance == r2) goto L6;
        this.counterTextAppearance = r2;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public void setCounterTextColor(@Nullable ColorStateList r2) {
        if (this.counterTextColor == r2) goto L6;
        this.counterTextColor = r2;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList r1) {
        this.defaultHintTextColor = r1;
        this.focusedTextColor = r1;
        if (this.editText == null) goto L6;
        updateLabelState(false);
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        recursiveSetEnabled(this, r1);
        super.setEnabled(r1);
    }

    public void setEndIconActivated(boolean r1) {
        this.endIconView.setActivated(r1);
    }

    public void setEndIconCheckable(boolean r1) {
        this.endIconView.setCheckable(r1);
    }

    public void setEndIconContentDescription(@StringRes int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = getResources().getText(r2);
    L5:
        setEndIconContentDescription(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setEndIconContentDescription(@Nullable CharSequence r2) {
        if (getEndIconContentDescription() == r2) goto L6;
        this.endIconView.setContentDescription(r2);
        return;
    }

    public void setEndIconDrawable(@DrawableRes int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), r2);
    L5:
        setEndIconDrawable(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setEndIconDrawable(@Nullable Drawable r2) {
        this.endIconView.setImageDrawable(r2);
        if (r2 == null) goto L6;
        applyEndIconTint();
        refreshEndIconDrawableState();
        return;
    }

    public void setEndIconMode(int r4) {
        int r0 = this.endIconMode;
        this.endIconMode = r4;
        dispatchOnEndIconChanged(r0);
        if (r4 == 0) goto L5;
        boolean r1 = true;
    L6:
        setEndIconVisible(r1);
        if (getEndIconDelegate().isBoxBackgroundModeSupported(this.boxBackgroundMode) == false) goto L11;
        getEndIconDelegate().initialize();
        applyEndIconTint();
        return;
    L11:
        throw new IllegalStateException("The current box background mode " + this.boxBackgroundMode + " is not supported by the end icon mode " + r4);
    L5:
        r1 = false;
        goto L6
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener r2) {
        setIconOnClickListener(this.endIconView, r2, this.endIconOnLongClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener r1) {
        this.endIconOnLongClickListener = r1;
        setIconOnLongClickListener(this.endIconView, r1);
    }

    public void setEndIconTintList(@Nullable ColorStateList r2) {
        if (this.endIconTintList == r2) goto L6;
        this.endIconTintList = r2;
        this.hasEndIconTintList = true;
        applyEndIconTint();
        return;
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode r2) {
        if (this.endIconTintMode == r2) goto L6;
        this.endIconTintMode = r2;
        this.hasEndIconTintMode = true;
        applyEndIconTint();
        return;
    }

    public void setEndIconVisible(boolean r2) {
        if (isEndIconVisible() == r2) goto L10;
        CheckableImageButton r0 = this.endIconView;
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        updateSuffixTextViewPadding();
        updateDummyDrawables();
        return;
    L7:
        r3 = 8;
        goto L8
    }

    public void setError(@Nullable CharSequence r2) {
        if (this.indicatorViewController.isErrorEnabled() == false) goto L5;
    L8:
        boolean r0 = TextUtils.isEmpty(r2);
        IndicatorViewController r1 = this.indicatorViewController;
        if (r0 == true) goto L11;
        r1.showError(r2);
        return;
    L11:
        r1.hideError();
        return;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return;
    L7:
        setErrorEnabled(true);
        goto L8
    }

    public void setErrorContentDescription(@Nullable CharSequence r1) {
        this.indicatorViewController.setErrorContentDescription(r1);
    }

    public void setErrorEnabled(boolean r1) {
        this.indicatorViewController.setErrorEnabled(r1);
    }

    public void setErrorIconDrawable(@DrawableRes int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), r2);
    L5:
        setErrorIconDrawable(r3);
        refreshErrorIconDrawableState();
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setErrorIconDrawable(@Nullable Drawable r2) {
        this.errorIconView.setImageDrawable(r2);
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        setErrorIconVisible(r3);
        return;
    L5:
        if (this.indicatorViewController.isErrorEnabled() == false) goto L7;
        r3 = true;
        goto L8
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener r2) {
        setIconOnClickListener(this.errorIconView, r2, this.errorIconOnLongClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener r1) {
        this.errorIconOnLongClickListener = r1;
        setIconOnLongClickListener(this.errorIconView, r1);
    }

    public void setErrorIconTintList(@Nullable ColorStateList r2) {
        this.errorIconTintList = r2;
        Drawable r0 = this.errorIconView.getDrawable();
        if (r0 == null) goto L6;
        r0 = DrawableCompat.wrap(r0).mutate();
        DrawableCompat.setTintList(r0, r2);
    L6:
        if (this.errorIconView.getDrawable() == r0) goto L9;
        this.errorIconView.setImageDrawable(r0);
        return;
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode r2) {
        Drawable r0 = this.errorIconView.getDrawable();
        if (r0 == null) goto L6;
        r0 = DrawableCompat.wrap(r0).mutate();
        DrawableCompat.setTintMode(r0, r2);
    L6:
        if (this.errorIconView.getDrawable() == r0) goto L9;
        this.errorIconView.setImageDrawable(r0);
        return;
    }

    public void setErrorTextAppearance(@StyleRes int r1) {
        this.indicatorViewController.setErrorTextAppearance(r1);
    }

    public void setErrorTextColor(@Nullable ColorStateList r1) {
        this.indicatorViewController.setErrorViewTextColor(r1);
    }

    public void setExpandedHintEnabled(boolean r2) {
        if (this.expandedHintEnabled == r2) goto L6;
        this.expandedHintEnabled = r2;
        updateLabelState(false);
        return;
    }

    public void setHelperText(@Nullable CharSequence r2) {
        if (TextUtils.isEmpty(r2) == false) goto L8;
        if (isHelperTextEnabled() == false) goto L12;
        setHelperTextEnabled(false);
        return;
    L12:
        return;
    L8:
        if (isHelperTextEnabled() == true) goto L10;
        setHelperTextEnabled(true);
    L10:
        this.indicatorViewController.showHelper(r2);
    }

    public void setHelperTextColor(@Nullable ColorStateList r1) {
        this.indicatorViewController.setHelperTextViewTextColor(r1);
    }

    public void setHelperTextEnabled(boolean r1) {
        this.indicatorViewController.setHelperTextEnabled(r1);
    }

    public void setHelperTextTextAppearance(@StyleRes int r1) {
        this.indicatorViewController.setHelperTextAppearance(r1);
    }

    public void setHint(@StringRes int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = getResources().getText(r2);
    L5:
        setHint(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setHint(@Nullable CharSequence r2) {
        if (this.hintEnabled == false) goto L6;
        setHintInternal(r2);
        sendAccessibilityEvent(2048);
        return;
    }

    public void setHintAnimationEnabled(boolean r1) {
        this.hintAnimationEnabled = r1;
    }

    public void setHintEnabled(boolean r3) {
        if (r3 == this.hintEnabled) goto L23;
        this.hintEnabled = r3;
        if (r3 == true) goto L12;
        this.isProvidingHint = false;
        if (TextUtils.isEmpty(this.hint) == false) goto L9;
    L11:
        setHintInternal(null);
    L20:
        if (this.editText == null) goto L24;
        updateInputLayoutMargins();
        return;
    L24:
        return;
    L9:
        if (TextUtils.isEmpty(this.editText.getHint()) == false) goto L11;
        this.editText.setHint(this.hint);
        goto L11
    L12:
        CharSequence r4 = this.editText.getHint();
        if (TextUtils.isEmpty(r4) == false) goto L15;
    L18:
        this.isProvidingHint = true;
        goto L20
    L15:
        if (TextUtils.isEmpty(this.hint) == false) goto L17;
        setHint(r4);
    L17:
        this.editText.setHint(null);
        goto L18
    }

    public void setHintTextAppearance(@StyleRes int r2) {
        this.collapsingTextHelper.setCollapsedTextAppearance(r2);
        this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
        if (this.editText == null) goto L6;
        updateLabelState(false);
        updateInputLayoutMargins();
        return;
    }

    public void setHintTextColor(@Nullable ColorStateList r2) {
        if (this.focusedTextColor != r2) goto L5;
        return;
    L5:
        if (this.defaultHintTextColor != null) goto L7;
        this.collapsingTextHelper.setCollapsedTextColor(r2);
    L7:
        this.focusedTextColor = r2;
        if (this.editText == null) goto L12;
        updateLabelState(false);
        return;
    }

    public void setMaxWidth(@Px int r2) {
        this.maxWidth = r2;
        EditText r1 = this.editText;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 == (-1)) goto L9;
        r1.setMaxWidth(r2);
        return;
    }

    public void setMaxWidthResource(@DimenRes int r2) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(r2));
    }

    public void setMinWidth(@Px int r2) {
        this.minWidth = r2;
        EditText r1 = this.editText;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 == (-1)) goto L9;
        r1.setMinWidth(r2);
        return;
    }

    public void setMinWidthResource(@DimenRes int r2) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(r2));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = getResources().getText(r2);
    L5:
        setPasswordVisibilityToggleContentDescription(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence r1) {
        this.endIconView.setContentDescription(r1);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), r2);
    L5:
        setPasswordVisibilityToggleDrawable(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable r1) {
        this.endIconView.setImageDrawable(r1);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean r3) {
        if (r3 == true) goto L4;
    L6:
        if (r3 == true) goto L10;
        setEndIconMode(0);
        return;
    L10:
        return;
    L4:
        if (this.endIconMode == 1) goto L6;
        setEndIconMode(1);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList r1) {
        this.endIconTintList = r1;
        this.hasEndIconTintList = true;
        applyEndIconTint();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode r1) {
        this.endIconTintMode = r1;
        this.hasEndIconTintMode = true;
        applyEndIconTint();
    }

    public void setPlaceholderText(@Nullable CharSequence r2) {
        if (this.placeholderEnabled == false) goto L8;
        if (TextUtils.isEmpty(r2) == false) goto L8;
        setPlaceholderTextEnabled(false);
    L11:
        updatePlaceholderText();
        return;
    L8:
        if (this.placeholderEnabled == true) goto L10;
        setPlaceholderTextEnabled(true);
    L10:
        this.placeholderText = r2;
        goto L11
    }

    public void setPlaceholderTextAppearance(@StyleRes int r1) {
        this.placeholderTextAppearance = r1;
        TextView r0 = this.placeholderTextView;
        if (r0 == null) goto L6;
        TextViewCompat.setTextAppearance(r0, r1);
        return;
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList r2) {
        if (this.placeholderTextColor == r2) goto L9;
        this.placeholderTextColor = r2;
        TextView r1 = this.placeholderTextView;
        if (r1 == null) goto L10;
        if (r2 == null) goto L11;
        r1.setTextColor(r2);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setPrefixText(@Nullable CharSequence r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        CharSequence r0 = null;
    L6:
        this.prefixText = r0;
        this.prefixTextView.setText(r2);
        updatePrefixTextVisibility();
        return;
    L5:
        r0 = r2;
        goto L6
    }

    public void setPrefixTextAppearance(@StyleRes int r1) {
        TextViewCompat.setTextAppearance(this.prefixTextView, r1);
    }

    public void setPrefixTextColor(@NonNull ColorStateList r1) {
        this.prefixTextView.setTextColor(r1);
    }

    public void setStartIconCheckable(boolean r1) {
        this.startIconView.setCheckable(r1);
    }

    public void setStartIconContentDescription(@StringRes int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = getResources().getText(r2);
    L5:
        setStartIconContentDescription(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setStartIconContentDescription(@Nullable CharSequence r2) {
        if (getStartIconContentDescription() == r2) goto L6;
        this.startIconView.setContentDescription(r2);
        return;
    }

    public void setStartIconDrawable(@DrawableRes int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), r2);
    L5:
        setStartIconDrawable(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setStartIconDrawable(@Nullable Drawable r2) {
        this.startIconView.setImageDrawable(r2);
        if (r2 == null) goto L5;
        applyStartIconTint();
        setStartIconVisible(true);
        refreshStartIconDrawableState();
        return;
    L5:
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription(null);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener r2) {
        setIconOnClickListener(this.startIconView, r2, this.startIconOnLongClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener r1) {
        this.startIconOnLongClickListener = r1;
        setIconOnLongClickListener(this.startIconView, r1);
    }

    public void setStartIconTintList(@Nullable ColorStateList r2) {
        if (this.startIconTintList == r2) goto L6;
        this.startIconTintList = r2;
        this.hasStartIconTintList = true;
        applyStartIconTint();
        return;
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode r2) {
        if (this.startIconTintMode == r2) goto L6;
        this.startIconTintMode = r2;
        this.hasStartIconTintMode = true;
        applyStartIconTint();
        return;
    }

    public void setStartIconVisible(boolean r2) {
        if (isStartIconVisible() == r2) goto L10;
        CheckableImageButton r0 = this.startIconView;
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        updatePrefixTextViewPadding();
        updateDummyDrawables();
        return;
    L7:
        r3 = 8;
        goto L8
    }

    public void setSuffixText(@Nullable CharSequence r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        CharSequence r0 = null;
    L6:
        this.suffixText = r0;
        this.suffixTextView.setText(r2);
        updateSuffixTextVisibility();
        return;
    L5:
        r0 = r2;
        goto L6
    }

    public void setSuffixTextAppearance(@StyleRes int r1) {
        TextViewCompat.setTextAppearance(this.suffixTextView, r1);
    }

    public void setSuffixTextColor(@NonNull ColorStateList r1) {
        this.suffixTextView.setTextColor(r1);
    }

    void setTextAppearanceCompatWithErrorFallback(@NonNull TextView r3, @StyleRes int r4) {
        boolean r0 = true;
        TextViewCompat.setTextAppearance(r3, r4);     // Catch: Exception -> L13
        if (Build.VERSION.SDK_INT < 23) goto L9;
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L10;
    L9:
        r0 = false;
    L10:
        if (r0 == false) goto L16;
        TextViewCompat.setTextAppearance(r3, R.style.TextAppearance_AppCompat_Caption);
        r3.setTextColor(ContextCompat.getColor(getContext(), R.color.design_error));
        return;
    }

    public void setTextInputAccessibilityDelegate(@Nullable AccessibilityDelegate r1) {
        EditText r0 = this.editText;
        if (r0 == null) goto L6;
        ViewCompat.setAccessibilityDelegate(r0, r1);
        return;
    }

    public void setTypeface(@Nullable Typeface r2) {
        if (r2 == this.typeface) goto L8;
        this.typeface = r2;
        this.collapsingTextHelper.setTypefaces(r2);
        this.indicatorViewController.setTypefaces(r2);
        TextView r1 = this.counterView;
        if (r1 == null) goto L9;
        r1.setTypeface(r2);
        return;
    L9:
        return;
    }

    void updateCounter(int r9) {
        boolean r0 = this.counterOverflowed;
        int r1 = this.counterMaxLength;
        if (r1 != (-1)) goto L6;
        this.counterView.setText(String.valueOf(r9));
        this.counterView.setContentDescription(null);
        this.counterOverflowed = false;
    L14:
        if (this.editText != null) goto L16;
        return;
    L16:
        if (r0 == this.counterOverflowed) goto L20;
        updateLabelState(false);
        updateTextInputBoxState();
        updateEditTextBackground();
        return;
    L20:
        return;
    L6:
        if (r9 <= r1) goto L8;
        boolean r2 = true;
    L9:
        this.counterOverflowed = r2;
        updateCounterContentDescription(getContext(), this.counterView, r9, this.counterMaxLength, this.counterOverflowed);
        if (r0 == this.counterOverflowed) goto L12;
        updateCounterTextAppearanceAndColor();
    L12:
        this.counterView.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(R.string.character_counter_pattern, new Object[]{Integer.valueOf(r9), Integer.valueOf(this.counterMaxLength)})));
        goto L14
    L8:
        r2 = false;
        goto L9
    }

    void updateEditTextBackground() {
        EditText r0 = this.editText;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.boxBackgroundMode != 0) goto L26;
        Drawable r1 = r0.getBackground();
        if (r1 != null) goto L11;
        return;
    L11:
        if (DrawableUtils.canSafelyMutateDrawable(r1) == false) goto L14;
        r1 = r1.mutate();
    L14:
        if (this.indicatorViewController.errorShouldBeShown() == false) goto L18;
        int r2 = this.indicatorViewController.getErrorViewCurrentTextColor();
    L16:
        r1.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(r2, PorterDuff.Mode.SRC_IN));
        return;
    L18:
        if (this.counterOverflowed == false) goto L22;
        TextView r3 = this.counterView;
        if (r3 == null) goto L22;
        r2 = r3.getCurrentTextColor();
    L22:
        DrawableCompat.clearColorFilter(r1);
        this.editText.refreshDrawableState();
        return;
    }

    void updateLabelState(boolean r2) {
        updateLabelState(r2, false);
    }

    void updateTextInputBoxState() {
        if (this.boxBackground != null) goto L5;
        return;
    L5:
        if (this.boxBackgroundMode == 0) goto L84;
        boolean r1 = false;
        if (isFocused() == true) goto L15;
        EditText r0 = this.editText;
        if (r0 != null) goto L12;
    L14:
        boolean r2 = false;
    L17:
        if (isHovered() == true) goto L24;
        EditText r3 = this.editText;
        if (r3 != null) goto L21;
    L23:
        boolean r4 = false;
    L26:
        if (isEnabled() == true) goto L30;
        int r5 = this.disabledColor;
    L28:
        this.boxStrokeColor = r5;
    L49:
        if (getErrorIconDrawable() != null) goto L51;
    L55:
        setErrorIconVisible(r1);
        refreshErrorIconDrawableState();
        refreshStartIconDrawableState();
        refreshEndIconDrawableState();
        if (getEndIconDelegate().shouldTintIconOnError() == false) goto L58;
        tintEndIconOnError(this.indicatorViewController.errorShouldBeShown());
    L58:
        int r6 = this.boxStrokeWidthPx;
        if (r2 == true) goto L61;
    L63:
        int r7 = this.boxStrokeWidthDefaultPx;
    L64:
        this.boxStrokeWidthPx = r7;
        if (this.boxStrokeWidthPx == r6) goto L70;
        if (this.boxBackgroundMode != 2) goto L70;
        recalculateCutout();
    L70:
        if (this.boxBackgroundMode == 1) goto L72;
    L81:
        applyBoxAttributes();
        return;
    L72:
        if (isEnabled() == true) goto L75;
        int r8 = this.disabledFilledBackgroundColor;
    L74:
        this.boxBackgroundColor = r8;
        goto L81
    L75:
        if (r4 == false) goto L78;
        if (r2 == true) goto L78;
        r8 = this.hoveredFilledBackgroundColor;
    L78:
        if (r2 == false) goto L80;
        r8 = this.focusedFilledBackgroundColor;
        goto L74
    L80:
        r8 = this.defaultFilledBackgroundColor;
        goto L74
    L61:
        if (isEnabled() == false) goto L63;
        r7 = this.boxStrokeWidthFocusedPx;
        goto L64
    L51:
        if (this.indicatorViewController.isErrorEnabled() == false) goto L55;
        if (this.indicatorViewController.errorShouldBeShown() == false) goto L55;
        r1 = true;
        goto L55
    L30:
        if (this.indicatorViewController.errorShouldBeShown() == false) goto L36;
        if (this.strokeErrorColor == null) goto L34;
    L33:
        updateStrokeErrorColor(r2, r4);
        goto L49
    L34:
        r5 = this.indicatorViewController.getErrorViewCurrentTextColor();
        goto L28
    L36:
        if (this.counterOverflowed == false) goto L43;
        TextView r9 = this.counterView;
        if (r9 == null) goto L43;
        if (this.strokeErrorColor != null) goto L33;
        r5 = r9.getCurrentTextColor();
    L43:
        if (r2 == false) goto L45;
        r5 = this.focusedStrokeColor;
        goto L28
    L45:
        if (r4 == false) goto L47;
        r5 = this.hoveredStrokeColor;
        goto L28
    L47:
        r5 = this.defaultStrokeColor;
        goto L28
    L21:
        if (r3.isHovered() == false) goto L23;
    L24:
        r4 = true;
        goto L26
    L12:
        if (r0.hasFocus() == false) goto L14;
    L15:
        r2 = true;
        goto L17
    }
}
