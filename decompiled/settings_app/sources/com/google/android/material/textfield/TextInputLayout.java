package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes3.dex */
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
    private boolean areCornerRadiiRtl;
    private MaterialShapeDrawable boxBackground;
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private int boxCollapsedPaddingTopPx;
    private final int boxLabelCutoutPaddingPx;
    private int boxStrokeColor;
    private int boxStrokeWidthDefaultPx;
    private int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    private MaterialShapeDrawable boxUnderlineDefault;
    private MaterialShapeDrawable boxUnderlineFocused;
    final CollapsingTextHelper collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private int counterOverflowTextAppearance;
    private ColorStateList counterOverflowTextColor;
    private boolean counterOverflowed;
    private int counterTextAppearance;
    private ColorStateList counterTextColor;
    private TextView counterView;
    private int defaultFilledBackgroundColor;
    private ColorStateList defaultHintTextColor;
    private int defaultStrokeColor;
    private int disabledColor;
    private int disabledFilledBackgroundColor;
    EditText editText;
    private final LinkedHashSet<OnEditTextAttachedListener> editTextAttachedListeners;
    private Drawable endDummyDrawable;
    private int endDummyDrawableWidth;
    private final LinkedHashSet<OnEndIconChangedListener> endIconChangedListeners;
    private final SparseArray<EndIconDelegate> endIconDelegates;
    private final FrameLayout endIconFrame;
    private int endIconMode;
    private View.OnLongClickListener endIconOnLongClickListener;
    private ColorStateList endIconTintList;
    private PorterDuff.Mode endIconTintMode;
    private final CheckableImageButton endIconView;
    private final LinearLayout endLayout;
    private View.OnLongClickListener errorIconOnLongClickListener;
    private ColorStateList errorIconTintList;
    private PorterDuff.Mode errorIconTintMode;
    private final CheckableImageButton errorIconView;
    private boolean expandedHintEnabled;
    private int focusedFilledBackgroundColor;
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;
    private int hoveredFilledBackgroundColor;
    private int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final IndicatorViewController indicatorViewController;
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private int maxEms;
    private int maxWidth;
    private int minEms;
    private int minWidth;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    private boolean placeholderEnabled;
    private Fade placeholderFadeIn;
    private Fade placeholderFadeOut;
    private CharSequence placeholderText;
    private int placeholderTextAppearance;
    private ColorStateList placeholderTextColor;
    private TextView placeholderTextView;
    private boolean restoringSavedState;
    private ShapeAppearanceModel shapeAppearanceModel;
    private Drawable startDummyDrawable;
    private int startDummyDrawableWidth;
    private final StartCompoundLayout startLayout;
    private ColorStateList strokeErrorColor;
    private CharSequence suffixText;
    private final TextView suffixTextView;
    private final Rect tmpBoundsRect;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final TextInputLayout layout;

        public AccessibilityDelegate(TextInputLayout r1) {
            this.layout = r1;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r12, AccessibilityNodeInfoCompat r13) {
            super.onInitializeAccessibilityNodeInfo(r12, r13);
            EditText r14 = this.layout.getEditText();
            if (r14 == null) goto L5;
            CharSequence r15 = r14.getText();
        L6:
            CharSequence r0 = this.layout.getHint();
            CharSequence r1 = this.layout.getError();
            CharSequence r2 = this.layout.getPlaceholderText();
            int r3 = this.layout.getCounterMaxLength();
            CharSequence r4 = this.layout.getCounterOverflowDescription();
            boolean r5 = !TextUtils.isEmpty(r15);
            boolean r7 = !TextUtils.isEmpty(r0);
            boolean r8 = !this.layout.isHintExpanded();
            boolean r9 = !TextUtils.isEmpty(r1);
            if (r9 == false) goto L9;
        L12:
            boolean r10 = true;
        L13:
            if (r7 == false) goto L15;
            String r6 = r0.toString();
        L16:
            TextInputLayout.access$400(this.layout).setupAccessibilityNodeInfo(r13);
            if (r5 == false) goto L20;
            r13.setText(r15);
        L28:
            if (TextUtils.isEmpty(r6) == true) goto L30;
            r13.setHintText(r6);
            r13.setShowingHintText(!r5);
        L30:
            if (r15 != null) goto L32;
        L34:
            r3 = -1;
        L35:
            r13.setMaxTextLength(r3);
            if (r10 == false) goto L41;
            if (r9 == true) goto L40;
            r1 = r4;
        L40:
            r13.setError(r1);
        L41:
            View r11 = TextInputLayout.access$500(this.layout).getHelperTextView();
            if (r11 == null) goto L45;
            r13.setLabelFor(r11);
            return;
        L45:
            return;
        L32:
            if (r15.length() != r3) goto L34;
        L20:
            if (TextUtils.isEmpty(r6) == true) goto L25;
            r13.setText(r6);
            if (r8 == false) goto L28;
            if (r2 == null) goto L28;
            r13.setText(r6 + ", " + r2);
            goto L28
        L25:
            if (r2 == null) goto L28;
            r13.setText(r2);
            goto L28
        L15:
            r6 = "";
            goto L16
        L9:
            if (TextUtils.isEmpty(r4) == false) goto L12;
            r10 = false;
            goto L13
        L5:
            r15 = null;
            goto L6
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface EndIconMode {
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(TextInputLayout r1);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(TextInputLayout r1, int r2);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        CharSequence error;
        CharSequence helperText;
        CharSequence hintText;
        boolean isEndIconChecked;
        CharSequence placeholderText;

        SavedState(Parcelable r1) {
            super(r1);
        }

        SavedState(Parcel r2, ClassLoader r3) {
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

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            TextUtils.writeToParcel(this.error, r2, r3);
            r2.writeInt(this.isEndIconChecked ? 1 : 0);
            TextUtils.writeToParcel(this.hintText, r2, r3);
            TextUtils.writeToParcel(this.helperText, r2, r3);
            TextUtils.writeToParcel(this.placeholderText, r2, r3);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + " hint=" + this.hintText + " helperText=" + this.helperText + " placeholderText=" + this.placeholderText + VectorFormat.DEFAULT_SUFFIX;
        }

        static {
            CREATOR = new AnonymousClass1();
        }
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

    static /* synthetic */ StartCompoundLayout access$400(TextInputLayout r0) {
        return r0.startLayout;
    }

    static /* synthetic */ IndicatorViewController access$500(TextInputLayout r0) {
        return r0.indicatorViewController;
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_TextInputLayout;
    }

    public TextInputLayout(Context r2) {
        this(r2, null);
    }

    public TextInputLayout(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.textInputStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v42 */
    public TextInputLayout(Context r28, AttributeSet r29, int r30) {
        int r9 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r28, r29, r30, r9), r29, r30);
        this.minEms = -1;
        this.maxEms = -1;
        this.minWidth = -1;
        this.maxWidth = -1;
        this.indicatorViewController = new IndicatorViewController(this);
        this.tmpRect = new Rect();
        this.tmpBoundsRect = new Rect();
        this.tmpRectF = new RectF();
        this.editTextAttachedListeners = new LinkedHashSet();
        this.endIconMode = 0;
        SparseArray<EndIconDelegate> r12 = new SparseArray();
        this.endIconDelegates = r12;
        this.endIconChangedListeners = new LinkedHashSet();
        CollapsingTextHelper r1 = new CollapsingTextHelper(this);
        this.collapsingTextHelper = r1;
        Context r13 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout r15 = new FrameLayout(r13);
        this.inputFrame = r15;
        FrameLayout r6 = new FrameLayout(r13);
        this.endIconFrame = r6;
        LinearLayout r5 = new LinearLayout(r13);
        this.endLayout = r5;
        AppCompatTextView r4 = new AppCompatTextView(r13);
        this.suffixTextView = r4;
        r5.setVisibility(8);
        r6.setVisibility(8);
        r4.setVisibility(8);
        LayoutInflater r2 = LayoutInflater.from(r13);
        CheckableImageButton r3 = (CheckableImageButton) r2.inflate(R.layout.design_text_input_end_icon, r5, false);
        this.errorIconView = r3;
        CheckableImageButton r10 = (CheckableImageButton) r2.inflate(R.layout.design_text_input_end_icon, r6, false);
        this.endIconView = r10;
        r15.setAddStatesFromChildren(true);
        r5.setOrientation(0);
        r5.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        r6.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        r1.setTextSizeInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r1.setPositionInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r1.setCollapsedTextGravity(8388659);
        TintTypedArray r7 = ThemeEnforcement.obtainTintedStyledAttributes(r13, r29, R.styleable.TextInputLayout, r30, r9, new int[]{R.styleable.TextInputLayout_counterTextAppearance, R.styleable.TextInputLayout_counterOverflowTextAppearance, R.styleable.TextInputLayout_errorTextAppearance, R.styleable.TextInputLayout_helperTextTextAppearance, R.styleable.TextInputLayout_hintTextAppearance});
        StartCompoundLayout r8 = new StartCompoundLayout(this, r7);
        this.startLayout = r8;
        this.hintEnabled = r7.getBoolean(R.styleable.TextInputLayout_hintEnabled, true);
        setHint(r7.getText(R.styleable.TextInputLayout_android_hint));
        this.hintAnimationEnabled = r7.getBoolean(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.expandedHintEnabled = r7.getBoolean(R.styleable.TextInputLayout_expandedHintEnabled, true);
        if (r7.hasValue(R.styleable.TextInputLayout_android_minEms) == false) goto L5;
        int r11 = -1;
        setMinEms(r7.getInt(R.styleable.TextInputLayout_android_minEms, -1));
    L9:
        if (r7.hasValue(R.styleable.TextInputLayout_android_maxEms) == false) goto L12;
        setMaxEms(r7.getInt(R.styleable.TextInputLayout_android_maxEms, r11));
    L14:
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(r13, r29, r30, r9).build();
        this.boxLabelCutoutPaddingPx = r13.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = r7.getDimensionPixelOffset(R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.boxStrokeWidthDefaultPx = r7.getDimensionPixelSize(R.styleable.TextInputLayout_boxStrokeWidth, r13.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.boxStrokeWidthFocusedPx = r7.getDimensionPixelSize(R.styleable.TextInputLayout_boxStrokeWidthFocused, r13.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        float r14 = r7.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float r16 = r7.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float r17 = r7.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float r18 = r7.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        ShapeAppearanceModel.Builder r19 = this.shapeAppearanceModel.toBuilder();
        if (r14 < 0.0f) goto L18;
        r19.setTopLeftCornerSize(r14);
    L18:
        if (r16 < 0.0f) goto L21;
        r19.setTopRightCornerSize(r16);
    L21:
        if (r17 < 0.0f) goto L24;
        r19.setBottomRightCornerSize(r17);
    L24:
        if (r18 < 0.0f) goto L26;
        r19.setBottomLeftCornerSize(r18);
    L26:
        this.shapeAppearanceModel = r19.build();
        ColorStateList r20 = MaterialResources.getColorStateList(r13, r7, R.styleable.TextInputLayout_boxBackgroundColor);
        if (r20 == null) goto L32;
        int r21 = r20.getDefaultColor();
        this.defaultFilledBackgroundColor = r21;
        this.boxBackgroundColor = r21;
        if (r20.isStateful() == false) goto L31;
        this.disabledFilledBackgroundColor = r20.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = r20.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.hoveredFilledBackgroundColor = r20.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
    L34:
        if (r7.hasValue(R.styleable.TextInputLayout_android_textColorHint) == false) goto L36;
        ColorStateList r22 = r7.getColorStateList(R.styleable.TextInputLayout_android_textColorHint);
        this.focusedTextColor = r22;
        this.defaultHintTextColor = r22;
    L36:
        ColorStateList r23 = MaterialResources.getColorStateList(r13, r7, R.styleable.TextInputLayout_boxStrokeColor);
        this.focusedStrokeColor = r7.getColor(R.styleable.TextInputLayout_boxStrokeColor, 0);
        this.defaultStrokeColor = ContextCompat.getColor(r13, R.color.mtrl_textinput_default_box_stroke_color);
        this.disabledColor = ContextCompat.getColor(r13, R.color.mtrl_textinput_disabled_color);
        this.hoveredStrokeColor = ContextCompat.getColor(r13, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (r23 == null) goto L40;
        setBoxStrokeColorStateList(r23);
    L40:
        if (r7.hasValue(R.styleable.TextInputLayout_boxStrokeErrorColor) == false) goto L43;
        setBoxStrokeErrorColor(MaterialResources.getColorStateList(r13, r7, R.styleable.TextInputLayout_boxStrokeErrorColor));
    L43:
        if (r7.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, -1) == (-1)) goto L45;
        ?? r24 = 0;
        setHintTextAppearance(r7.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, 0));
    L46:
        int r25 = r7.getResourceId(R.styleable.TextInputLayout_errorTextAppearance, r24);
        CharSequence r26 = r7.getText(R.styleable.TextInputLayout_errorContentDescription);
        boolean r27 = r7.getBoolean(R.styleable.TextInputLayout_errorEnabled, r24);
        r3.setId(R.id.text_input_error_icon);
        if (MaterialResources.isFontScaleAtLeast1_3(r13) == false) goto L50;
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) r3.getLayoutParams(), r24);
    L50:
        if (r7.hasValue(R.styleable.TextInputLayout_errorIconTint) == false) goto L53;
        this.errorIconTintList = MaterialResources.getColorStateList(r13, r7, R.styleable.TextInputLayout_errorIconTint);
    L53:
        if (r7.hasValue(R.styleable.TextInputLayout_errorIconTintMode) == false) goto L56;
        this.errorIconTintMode = ViewUtils.parseTintMode(r7.getInt(R.styleable.TextInputLayout_errorIconTintMode, -1), null);
    L56:
        if (r7.hasValue(R.styleable.TextInputLayout_errorIconDrawable) == false) goto L58;
        setErrorIconDrawable(r7.getDrawable(R.styleable.TextInputLayout_errorIconDrawable));
    L58:
        r3.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        ViewCompat.setImportantForAccessibility(r3, 2);
        r3.setClickable(false);
        r3.setPressable(false);
        r3.setFocusable(false);
        int r31 = r7.getResourceId(R.styleable.TextInputLayout_helperTextTextAppearance, 0);
        boolean r110 = r7.getBoolean(R.styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence r32 = r7.getText(R.styleable.TextInputLayout_helperText);
        int r111 = r7.getResourceId(R.styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence r33 = r7.getText(R.styleable.TextInputLayout_placeholderText);
        int r34 = r7.getResourceId(R.styleable.TextInputLayout_suffixTextAppearance, 0);
        CharSequence r35 = r7.getText(R.styleable.TextInputLayout_suffixText);
        boolean r36 = r7.getBoolean(R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(r7.getInt(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.counterTextAppearance = r7.getResourceId(R.styleable.TextInputLayout_counterTextAppearance, 0);
        this.counterOverflowTextAppearance = r7.getResourceId(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        setBoxBackgroundMode(r7.getInt(R.styleable.TextInputLayout_boxBackgroundMode, 0));
        if (MaterialResources.isFontScaleAtLeast1_3(r13) == false) goto L61;
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) r10.getLayoutParams(), 0);
    L61:
        int r37 = r7.getResourceId(R.styleable.TextInputLayout_endIconDrawable, 0);
        r12.append(-1, new CustomEndIconDelegate(this, r37));
        r12.append(0, new NoEndIconDelegate(this));
        if (r37 != 0) goto L64;
        int r112 = r7.getResourceId(R.styleable.TextInputLayout_passwordToggleDrawable, 0);
    L65:
        r12.append(1, new PasswordToggleEndIconDelegate(this, r112));
        r12.append(2, new ClearTextEndIconDelegate(this, r37));
        r12.append(3, new DropdownMenuEndIconDelegate(this, r37));
        if (r7.hasValue(R.styleable.TextInputLayout_passwordToggleEnabled) == true) goto L74;
        if (r7.hasValue(R.styleable.TextInputLayout_endIconTint) == false) goto L71;
        this.endIconTintList = MaterialResources.getColorStateList(r13, r7, R.styleable.TextInputLayout_endIconTint);
    L71:
        if (r7.hasValue(R.styleable.TextInputLayout_endIconTintMode) == false) goto L74;
        this.endIconTintMode = ViewUtils.parseTintMode(r7.getInt(R.styleable.TextInputLayout_endIconTintMode, -1), null);
    L74:
        if (r7.hasValue(R.styleable.TextInputLayout_endIconMode) == false) goto L80;
        setEndIconMode(r7.getInt(R.styleable.TextInputLayout_endIconMode, 0));
        if (r7.hasValue(R.styleable.TextInputLayout_endIconContentDescription) == false) goto L78;
        setEndIconContentDescription(r7.getText(R.styleable.TextInputLayout_endIconContentDescription));
    L78:
        setEndIconCheckable(r7.getBoolean(R.styleable.TextInputLayout_endIconCheckable, true));
    L88:
        r4.setId(R.id.textinput_suffix_text);
        r4.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        ViewCompat.setAccessibilityLiveRegion(r4, 1);
        setErrorContentDescription(r26);
        setCounterOverflowTextAppearance(this.counterOverflowTextAppearance);
        setHelperTextTextAppearance(r31);
        setErrorTextAppearance(r25);
        setCounterTextAppearance(this.counterTextAppearance);
        setPlaceholderText(r33);
        setPlaceholderTextAppearance(r111);
        setSuffixTextAppearance(r34);
        if (r7.hasValue(R.styleable.TextInputLayout_errorTextColor) == false) goto L92;
        setErrorTextColor(r7.getColorStateList(R.styleable.TextInputLayout_errorTextColor));
    L92:
        if (r7.hasValue(R.styleable.TextInputLayout_helperTextTextColor) == false) goto L95;
        setHelperTextColor(r7.getColorStateList(R.styleable.TextInputLayout_helperTextTextColor));
    L95:
        if (r7.hasValue(R.styleable.TextInputLayout_hintTextColor) == false) goto L98;
        setHintTextColor(r7.getColorStateList(R.styleable.TextInputLayout_hintTextColor));
    L98:
        if (r7.hasValue(R.styleable.TextInputLayout_counterTextColor) == false) goto L101;
        setCounterTextColor(r7.getColorStateList(R.styleable.TextInputLayout_counterTextColor));
    L101:
        if (r7.hasValue(R.styleable.TextInputLayout_counterOverflowTextColor) == false) goto L104;
        setCounterOverflowTextColor(r7.getColorStateList(R.styleable.TextInputLayout_counterOverflowTextColor));
    L104:
        if (r7.hasValue(R.styleable.TextInputLayout_placeholderTextColor) == false) goto L107;
        setPlaceholderTextColor(r7.getColorStateList(R.styleable.TextInputLayout_placeholderTextColor));
    L107:
        if (r7.hasValue(R.styleable.TextInputLayout_suffixTextColor) == false) goto L109;
        setSuffixTextColor(r7.getColorStateList(R.styleable.TextInputLayout_suffixTextColor));
    L109:
        setEnabled(r7.getBoolean(R.styleable.TextInputLayout_android_enabled, true));
        r7.recycle();
        ViewCompat.setImportantForAccessibility(this, 2);
        ViewCompat.setImportantForAutofill(this, 1);
        r6.addView(r10);
        r5.addView(r4);
        r5.addView(r3);
        r5.addView(r6);
        r15.addView(r8);
        r15.addView(r5);
        addView(r15);
        setHelperTextEnabled(r110);
        setErrorEnabled(r27);
        setCounterEnabled(r36);
        setHelperText(r32);
        setSuffixText(r35);
        return;
    L80:
        if (r7.hasValue(R.styleable.TextInputLayout_passwordToggleEnabled) == false) goto L88;
        if (r7.hasValue(R.styleable.TextInputLayout_passwordToggleTint) == false) goto L85;
        this.endIconTintList = MaterialResources.getColorStateList(r13, r7, R.styleable.TextInputLayout_passwordToggleTint);
    L85:
        if (r7.hasValue(R.styleable.TextInputLayout_passwordToggleTintMode) == false) goto L87;
        this.endIconTintMode = ViewUtils.parseTintMode(r7.getInt(R.styleable.TextInputLayout_passwordToggleTintMode, -1), null);
    L87:
        setEndIconMode(r7.getBoolean(R.styleable.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
        setEndIconContentDescription(r7.getText(R.styleable.TextInputLayout_passwordToggleContentDescription));
        goto L88
    L64:
        r112 = r37;
        goto L65
    L45:
        r24 = 0;
        goto L46
    L31:
        this.focusedFilledBackgroundColor = this.defaultFilledBackgroundColor;
        ColorStateList r38 = AppCompatResources.getColorStateList(r13, R.color.mtrl_filled_background_color);
        this.disabledFilledBackgroundColor = r38.getColorForState(new int[]{-16842910}, -1);
        this.hoveredFilledBackgroundColor = r38.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
        goto L34
    L32:
        this.boxBackgroundColor = 0;
        this.defaultFilledBackgroundColor = 0;
        this.disabledFilledBackgroundColor = 0;
        this.focusedFilledBackgroundColor = 0;
        this.hoveredFilledBackgroundColor = 0;
        goto L34
    L12:
        if (r7.hasValue(R.styleable.TextInputLayout_android_maxWidth) == false) goto L14;
        setMaxWidth(r7.getDimensionPixelSize(R.styleable.TextInputLayout_android_maxWidth, r11));
        goto L14
    L5:
        r11 = -1;
        if (r7.hasValue(R.styleable.TextInputLayout_android_minWidth) == false) goto L9;
        setMinWidth(r7.getDimensionPixelSize(R.styleable.TextInputLayout_android_minWidth, -1));
        goto L9
    }

    @Override // android.view.ViewGroup
    public void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
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

    MaterialShapeDrawable getBoxBackground() {
        int r0 = this.boxBackgroundMode;
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L10;
        throw new IllegalStateException();
    L10:
        return this.boxBackground;
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

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
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

    private void assignBoxBackgroundByMode() {
        int r0 = this.boxBackgroundMode;
        if (r0 != 0) goto L5;
        this.boxBackground = null;
        this.boxUnderlineDefault = null;
        this.boxUnderlineFocused = null;
        return;
    L5:
        if (r0 != 1) goto L7;
        this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
        this.boxUnderlineDefault = new MaterialShapeDrawable();
        this.boxUnderlineFocused = new MaterialShapeDrawable();
        return;
    L7:
        if (r0 != 2) goto L16;
        if (this.hintEnabled == true) goto L11;
    L13:
        this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
    L14:
        this.boxUnderlineDefault = null;
        this.boxUnderlineFocused = null;
        return;
    L11:
        if ((this.boxBackground instanceof CutoutDrawable) == true) goto L13;
        this.boxBackground = new CutoutDrawable(this.shapeAppearanceModel);
        goto L14
    L16:
        throw new IllegalArgumentException(this.boxBackgroundMode + " is illegal; only @BoxBackgroundMode constants are supported.");
    }

    private void setEditTextBoxBackground() {
        if (shouldUseEditTextBackgroundForBoxBackground() == false) goto L6;
        ViewCompat.setBackground(this.editText, this.boxBackground);
        return;
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

    private void updateBoxCollapsedPaddingTop() {
        if (this.boxBackgroundMode == 1) goto L5;
        return;
    L5:
        if (MaterialResources.isFontScaleAtLeast2_0(getContext()) == false) goto L8;
        this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
        return;
    L8:
        if (MaterialResources.isFontScaleAtLeast1_3(getContext()) == false) goto L13;
        this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
        return;
    }

    private void adjustFilledEditTextPaddingForLargeFont() {
        if (this.editText != null) goto L5;
        return;
    L5:
        if (this.boxBackgroundMode == 1) goto L8;
        return;
    L8:
        if (MaterialResources.isFontScaleAtLeast2_0(getContext()) == false) goto L11;
        EditText r0 = this.editText;
        ViewCompat.setPaddingRelative(r0, ViewCompat.getPaddingStart(r0), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.getPaddingEnd(this.editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
        return;
    L11:
        if (MaterialResources.isFontScaleAtLeast1_3(getContext()) == false) goto L16;
        EditText r1 = this.editText;
        ViewCompat.setPaddingRelative(r1, ViewCompat.getPaddingStart(r1), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.getPaddingEnd(this.editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        return;
    }

    public void setBoxCollapsedPaddingTop(int r1) {
        this.boxCollapsedPaddingTopPx = r1;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.boxCollapsedPaddingTopPx;
    }

    public void setBoxStrokeWidthResource(int r2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(r2));
    }

    public void setBoxStrokeWidth(int r1) {
        this.boxStrokeWidthDefaultPx = r1;
        updateTextInputBoxState();
    }

    public int getBoxStrokeWidth() {
        return this.boxStrokeWidthDefaultPx;
    }

    public void setBoxStrokeWidthFocusedResource(int r2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(r2));
    }

    public void setBoxStrokeWidthFocused(int r1) {
        this.boxStrokeWidthFocusedPx = r1;
        updateTextInputBoxState();
    }

    public int getBoxStrokeWidthFocused() {
        return this.boxStrokeWidthFocusedPx;
    }

    public void setBoxStrokeColor(int r2) {
        if (this.focusedStrokeColor == r2) goto L6;
        this.focusedStrokeColor = r2;
        updateTextInputBoxState();
        return;
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public void setBoxStrokeColorStateList(ColorStateList r4) {
        if (r4.isStateful() == false) goto L6;
        this.defaultStrokeColor = r4.getDefaultColor();
        this.disabledColor = r4.getColorForState(new int[]{-16842910}, -1);
        this.hoveredStrokeColor = r4.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        this.focusedStrokeColor = r4.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
    L8:
        updateTextInputBoxState();
        return;
    L6:
        if (this.focusedStrokeColor == r4.getDefaultColor()) goto L8;
        this.focusedStrokeColor = r4.getDefaultColor();
        goto L8
    }

    public void setBoxStrokeErrorColor(ColorStateList r2) {
        if (this.strokeErrorColor == r2) goto L6;
        this.strokeErrorColor = r2;
        updateTextInputBoxState();
        return;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.strokeErrorColor;
    }

    public void setBoxBackgroundColorResource(int r2) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), r2));
    }

    public void setBoxBackgroundColor(int r2) {
        if (this.boxBackgroundColor == r2) goto L6;
        this.boxBackgroundColor = r2;
        this.defaultFilledBackgroundColor = r2;
        this.focusedFilledBackgroundColor = r2;
        this.hoveredFilledBackgroundColor = r2;
        applyBoxAttributes();
        return;
    }

    public void setBoxBackgroundColorStateList(ColorStateList r4) {
        int r0 = r4.getDefaultColor();
        this.defaultFilledBackgroundColor = r0;
        this.boxBackgroundColor = r0;
        this.disabledFilledBackgroundColor = r4.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = r4.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.hoveredFilledBackgroundColor = r4.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        applyBoxAttributes();
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public void setBoxCornerRadiiResources(int r2, int r3, int r4, int r5) {
        setBoxCornerRadii(getContext().getResources().getDimension(r2), getContext().getResources().getDimension(r3), getContext().getResources().getDimension(r5), getContext().getResources().getDimension(r4));
    }

    public void setBoxCornerRadii(float r3, float r4, float r5, float r6) {
        boolean r0 = ViewUtils.isLayoutRtl(this);
        this.areCornerRadiiRtl = r0;
        if (r0 == false) goto L5;
        float r1 = r4;
    L6:
        if (r0 == true) goto L9;
        r3 = r4;
    L9:
        if (r0 == false) goto L11;
        float r7 = r6;
    L12:
        if (r0 == true) goto L15;
        r5 = r6;
    L15:
        MaterialShapeDrawable r8 = this.boxBackground;
        if (r8 != null) goto L18;
    L25:
        this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCornerSize(r1).setTopRightCornerSize(r3).setBottomLeftCornerSize(r7).setBottomRightCornerSize(r5).build();
        applyBoxAttributes();
        return;
    L18:
        if (r8.getTopLeftCornerResolvedSize() != r1) goto L25;
        if (this.boxBackground.getTopRightCornerResolvedSize() != r3) goto L25;
        if (this.boxBackground.getBottomLeftCornerResolvedSize() != r7) goto L25;
        if (this.boxBackground.getBottomRightCornerResolvedSize() != r5) goto L25;
        return;
    L11:
        r7 = r5;
        goto L12
    L5:
        r1 = r3;
        goto L6
    }

    public float getBoxCornerRadiusTopStart() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L6;
        return this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.tmpRectF);
    L6:
        return this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.tmpRectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L6;
        return this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.tmpRectF);
    L6:
        return this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.tmpRectF);
    }

    public float getBoxCornerRadiusBottomEnd() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L6;
        return this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.tmpRectF);
    L6:
        return this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.tmpRectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L6;
        return this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.tmpRectF);
    L6:
        return this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.tmpRectF);
    }

    public void setTypeface(Typeface r2) {
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

    public Typeface getTypeface() {
        return this.typeface;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure r5, int r6) {
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

    private void setEditText(EditText r4) {
        if (this.editText != null) goto L35;
        if (this.endIconMode != 3) goto L7;
    L9:
        this.editText = r4;
        int r0 = this.minEms;
        if (r0 == (-1)) goto L12;
        setMinEms(r0);
    L13:
        int r1 = this.maxEms;
        if (r1 == (-1)) goto L16;
        setMaxEms(r1);
    L17:
        onApplyBoxBackgroundMode();
        setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
        this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
        this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
        this.collapsingTextHelper.setExpandedLetterSpacing(this.editText.getLetterSpacing());
        int r2 = this.editText.getGravity();
        this.collapsingTextHelper.setCollapsedTextGravity((r2 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) | 48);
        this.collapsingTextHelper.setExpandedTextGravity(r2);
        this.editText.addTextChangedListener(new AnonymousClass1(this));
        if (this.defaultHintTextColor != null) goto L21;
        this.defaultHintTextColor = this.editText.getHintTextColors();
    L21:
        if (this.hintEnabled == false) goto L27;
        if (TextUtils.isEmpty(this.hint) == false) goto L25;
        CharSequence r3 = this.editText.getHint();
        this.originalHint = r3;
        setHint(r3);
        this.editText.setHint(null);
    L25:
        this.isProvidingHint = true;
    L27:
        if (this.counterView == null) goto L29;
        updateCounter(this.editText.getText().length());
    L29:
        updateEditTextBackground();
        this.indicatorViewController.adjustIndicatorPadding();
        this.startLayout.bringToFront();
        this.endLayout.bringToFront();
        this.endIconFrame.bringToFront();
        this.errorIconView.bringToFront();
        dispatchOnEditTextAttached();
        updateSuffixTextViewPadding();
        if (isEnabled() == true) goto L32;
        r4.setEnabled(false);
    L32:
        updateLabelState(false, true);
        return;
    L16:
        setMaxWidth(this.maxWidth);
        goto L17
    L12:
        setMinWidth(this.minWidth);
        goto L13
    L7:
        if ((r4 instanceof TextInputEditText) == true) goto L9;
        Log.i(LOG_TAG, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        goto L9
    L35:
        throw new IllegalArgumentException("We already have an EditText, can only have one");
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

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText r0 = this.editText;
        if (r0 == null) goto L7;
        return (r0.getBaseline() + getPaddingTop()) + calculateLabelMarginTop();
    L7:
        return super.getBaseline();
    }

    void updateLabelState(boolean r2) {
        updateLabelState(r2, false);
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
    L34:
        if (r2 == false) goto L36;
    L45:
        if (r10 == false) goto L47;
    L48:
        collapseHint(r9);
        return;
    L47:
        if (this.hintExpanded == true) goto L48;
        return;
    L36:
        if (this.expandedHintEnabled == false) goto L45;
        if (isEnabled() == false) goto L41;
        if (r5 == true) goto L45;
    L41:
        if (r10 == false) goto L43;
    L44:
        expandHint(r9);
        return;
    L43:
        if (this.hintExpanded == false) goto L44;
        return;
    L21:
        r8 = this.disabledColor;
        goto L22
    L23:
        if (r6 == false) goto L26;
        this.collapsingTextHelper.setCollapsedTextColor(this.indicatorViewController.getErrorViewTextColors());
        goto L34
    L26:
        if (this.counterOverflowed == false) goto L30;
        TextView r11 = this.counterView;
        if (r11 == null) goto L30;
        this.collapsingTextHelper.setCollapsedTextColor(r11.getTextColors());
    L30:
        if (r5 == false) goto L34;
        ColorStateList r12 = this.focusedTextColor;
        if (r12 == null) goto L34;
        this.collapsingTextHelper.setCollapsedTextColor(r12);
        goto L34
    L11:
        if (r4.hasFocus() == false) goto L13;
        r5 = true;
        goto L14
    L5:
        if (TextUtils.isEmpty(r1.getText()) == true) goto L7;
        r2 = true;
        goto L8
    }

    public EditText getEditText() {
        return this.editText;
    }

    public void setMinEms(int r2) {
        this.minEms = r2;
        EditText r1 = this.editText;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 == (-1)) goto L9;
        r1.setMinEms(r2);
        return;
    }

    public int getMinEms() {
        return this.minEms;
    }

    public void setMaxEms(int r2) {
        this.maxEms = r2;
        EditText r1 = this.editText;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 == (-1)) goto L9;
        r1.setMaxEms(r2);
        return;
    }

    public int getMaxEms() {
        return this.maxEms;
    }

    public void setMinWidth(int r2) {
        this.minWidth = r2;
        EditText r1 = this.editText;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 == (-1)) goto L9;
        r1.setMinWidth(r2);
        return;
    }

    public void setMinWidthResource(int r2) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(r2));
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    public void setMaxWidth(int r2) {
        this.maxWidth = r2;
        EditText r1 = this.editText;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 == (-1)) goto L9;
        r1.setMaxWidth(r2);
        return;
    }

    public void setMaxWidthResource(int r2) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(r2));
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public void setHint(CharSequence r2) {
        if (this.hintEnabled == false) goto L6;
        setHintInternal(r2);
        sendAccessibilityEvent(2048);
        return;
    }

    public void setHint(int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = getResources().getText(r2);
    L5:
        setHint(r3);
        return;
    L4:
        r3 = null;
        goto L5
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

    public CharSequence getHint() {
        if (this.hintEnabled == true) goto L7;
        return null;
    L7:
        return this.hint;
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

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public void setHintTextAppearance(int r2) {
        this.collapsingTextHelper.setCollapsedTextAppearance(r2);
        this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
        if (this.editText == null) goto L6;
        updateLabelState(false);
        updateInputLayoutMargins();
        return;
    }

    public void setHintTextColor(ColorStateList r2) {
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

    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    public void setDefaultHintTextColor(ColorStateList r1) {
        this.defaultHintTextColor = r1;
        this.focusedTextColor = r1;
        if (this.editText == null) goto L6;
        updateLabelState(false);
        return;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    public void setErrorEnabled(boolean r1) {
        this.indicatorViewController.setErrorEnabled(r1);
    }

    public void setErrorTextAppearance(int r1) {
        this.indicatorViewController.setErrorTextAppearance(r1);
    }

    public void setErrorTextColor(ColorStateList r1) {
        this.indicatorViewController.setErrorViewTextColor(r1);
    }

    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public void setHelperTextTextAppearance(int r1) {
        this.indicatorViewController.setHelperTextAppearance(r1);
    }

    public void setHelperTextColor(ColorStateList r1) {
        this.indicatorViewController.setHelperTextViewTextColor(r1);
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.isErrorEnabled();
    }

    public void setHelperTextEnabled(boolean r1) {
        this.indicatorViewController.setHelperTextEnabled(r1);
    }

    public void setHelperText(CharSequence r2) {
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

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.isHelperTextEnabled();
    }

    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.getHelperTextViewCurrentTextColor();
    }

    public void setErrorContentDescription(CharSequence r1) {
        this.indicatorViewController.setErrorContentDescription(r1);
    }

    public CharSequence getErrorContentDescription() {
        return this.indicatorViewController.getErrorContentDescription();
    }

    public void setError(CharSequence r2) {
        if (this.indicatorViewController.isErrorEnabled() == true) goto L9;
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return;
    L7:
        setErrorEnabled(true);
    L9:
        if (TextUtils.isEmpty(r2) == true) goto L11;
        this.indicatorViewController.showError(r2);
        return;
    L11:
        this.indicatorViewController.hideError();
    }

    public void setErrorIconDrawable(int r2) {
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

    public void setErrorIconDrawable(Drawable r3) {
        this.errorIconView.setImageDrawable(r3);
        updateErrorIconVisibility();
        IconHelper.applyIconTint(this, this.errorIconView, this.errorIconTintList, this.errorIconTintMode);
    }

    public Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    public void setErrorIconTintList(ColorStateList r3) {
        if (this.errorIconTintList == r3) goto L6;
        this.errorIconTintList = r3;
        IconHelper.applyIconTint(this, this.errorIconView, r3, this.errorIconTintMode);
        return;
    }

    public void setErrorIconTintMode(PorterDuff.Mode r3) {
        if (this.errorIconTintMode == r3) goto L6;
        this.errorIconTintMode = r3;
        IconHelper.applyIconTint(this, this.errorIconView, this.errorIconTintList, r3);
        return;
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

    public void setCounterTextAppearance(int r2) {
        if (this.counterTextAppearance == r2) goto L6;
        this.counterTextAppearance = r2;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public void setCounterTextColor(ColorStateList r2) {
        if (this.counterTextColor == r2) goto L6;
        this.counterTextColor = r2;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    public void setCounterOverflowTextAppearance(int r2) {
        if (this.counterOverflowTextAppearance == r2) goto L6;
        this.counterOverflowTextAppearance = r2;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public void setCounterOverflowTextColor(ColorStateList r2) {
        if (this.counterOverflowTextColor == r2) goto L6;
        this.counterOverflowTextColor = r2;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.counterTextColor;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public void setCounterMaxLength(int r2) {
        if (this.counterMaxLength == r2) goto L11;
        if (r2 <= 0) goto L6;
        this.counterMaxLength = r2;
    L8:
        if (this.counterEnabled == false) goto L12;
        updateCounter();
        return;
    L12:
        return;
    L6:
        this.counterMaxLength = -1;
        goto L8
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

    private static void updateCounterContentDescription(Context r2, TextView r3, int r4, int r5, boolean r6) {
        if (r6 == false) goto L4;
        int r7 = R.string.character_counter_overflowed_content_description;
    L5:
        r3.setContentDescription(r2.getString(r7, new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)}));
        return;
    L4:
        r7 = R.string.character_counter_content_description;
        goto L5
    }

    public void setPlaceholderText(CharSequence r4) {
        if (this.placeholderTextView != null) goto L6;
        AppCompatTextView r0 = new AppCompatTextView(getContext());
        this.placeholderTextView = r0;
        r0.setId(R.id.textinput_placeholder);
        ViewCompat.setImportantForAccessibility(this.placeholderTextView, 2);
        Fade r1 = createPlaceholderFadeTransition();
        this.placeholderFadeIn = r1;
        r1.setStartDelay(PLACEHOLDER_START_DELAY);
        this.placeholderFadeOut = createPlaceholderFadeTransition();
        setPlaceholderTextAppearance(this.placeholderTextAppearance);
        setPlaceholderTextColor(this.placeholderTextColor);
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        setPlaceholderTextEnabled(false);
    L12:
        updatePlaceholderText();
        return;
    L9:
        if (this.placeholderEnabled == true) goto L11;
        setPlaceholderTextEnabled(true);
    L11:
        this.placeholderText = r4;
        goto L12
    }

    public CharSequence getPlaceholderText() {
        if (this.placeholderEnabled == true) goto L7;
        return null;
    L7:
        return this.placeholderText;
    }

    private void setPlaceholderTextEnabled(boolean r2) {
        if (this.placeholderEnabled != r2) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        addPlaceholderTextView();
    L8:
        this.placeholderEnabled = r2;
        return;
    L7:
        removePlaceholderTextView();
        this.placeholderTextView = null;
        goto L8
    }

    private Fade createPlaceholderFadeTransition() {
        Fade r2 = new Fade();
        r2.setDuration(PLACEHOLDER_FADE_DURATION);
        r2.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return r2;
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

    private void showPlaceholderText() {
        if (this.placeholderTextView != null) goto L5;
        return;
    L5:
        if (this.placeholderEnabled == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.placeholderText) == true) goto L12;
        this.placeholderTextView.setText(this.placeholderText);
        TransitionManager.beginDelayedTransition(this.inputFrame, this.placeholderFadeIn);
        this.placeholderTextView.setVisibility(0);
        this.placeholderTextView.bringToFront();
        announceForAccessibility(this.placeholderText);
        return;
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

    private void addPlaceholderTextView() {
        TextView r0 = this.placeholderTextView;
        if (r0 == null) goto L6;
        this.inputFrame.addView(r0);
        this.placeholderTextView.setVisibility(0);
        return;
    }

    private void removePlaceholderTextView() {
        TextView r1 = this.placeholderTextView;
        if (r1 == null) goto L6;
        r1.setVisibility(8);
        return;
    }

    public void setPlaceholderTextColor(ColorStateList r2) {
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

    public ColorStateList getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    public void setPlaceholderTextAppearance(int r1) {
        this.placeholderTextAppearance = r1;
        TextView r0 = this.placeholderTextView;
        if (r0 == null) goto L6;
        TextViewCompat.setTextAppearance(r0, r1);
        return;
    }

    public int getPlaceholderTextAppearance() {
        return this.placeholderTextAppearance;
    }

    public void setPrefixText(CharSequence r1) {
        this.startLayout.setPrefixText(r1);
    }

    public CharSequence getPrefixText() {
        return this.startLayout.getPrefixText();
    }

    public TextView getPrefixTextView() {
        return this.startLayout.getPrefixTextView();
    }

    public void setPrefixTextColor(ColorStateList r1) {
        this.startLayout.setPrefixTextColor(r1);
    }

    public ColorStateList getPrefixTextColor() {
        return this.startLayout.getPrefixTextColor();
    }

    public void setPrefixTextAppearance(int r1) {
        this.startLayout.setPrefixTextAppearance(r1);
    }

    public void setSuffixText(CharSequence r2) {
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

    public CharSequence getSuffixText() {
        return this.suffixText;
    }

    public TextView getSuffixTextView() {
        return this.suffixTextView;
    }

    private void updateSuffixTextVisibility() {
        int r0 = this.suffixTextView.getVisibility();
        boolean r2 = false;
        if (this.suffixText != null) goto L5;
    L7:
        int r1 = 8;
    L8:
        if (r0 == r1) goto L13;
        EndIconDelegate r3 = getEndIconDelegate();
        if (r1 != 0) goto L12;
        r2 = true;
    L12:
        r3.onSuffixVisibilityChanged(r2);
    L13:
        updateEndLayoutVisibility();
        this.suffixTextView.setVisibility(r1);
        updateDummyDrawables();
        return;
    L5:
        if (isHintExpanded() == true) goto L7;
        r1 = 0;
        goto L8
    }

    public void setSuffixTextColor(ColorStateList r1) {
        this.suffixTextView.setTextColor(r1);
    }

    public ColorStateList getSuffixTextColor() {
        return this.suffixTextView.getTextColors();
    }

    public void setSuffixTextAppearance(int r1) {
        TextViewCompat.setTextAppearance(this.suffixTextView, r1);
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

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        recursiveSetEnabled(this, r1);
        super.setEnabled(r1);
    }

    private static void recursiveSetEnabled(ViewGroup r4, boolean r5) {
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

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

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

    void setTextAppearanceCompatWithErrorFallback(TextView r3, int r4) {
        boolean r0 = true;
        TextViewCompat.setTextAppearance(r3, r4);     // Catch: Exception -> L11
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L8;
        r0 = false;
    L8:
        if (r0 == false) goto L14;
        TextViewCompat.setTextAppearance(r3, R.style.TextAppearance_AppCompat_Caption);
        r3.setTextColor(ContextCompat.getColor(getContext(), R.color.design_error));
        return;
    }

    private int calculateLabelMarginTop() {
        if (this.hintEnabled == true) goto L5;
        return 0;
    L5:
        int r0 = this.boxBackgroundMode;
        if (r0 != 0) goto L8;
        float r3 = this.collapsingTextHelper.getCollapsedTextHeight();
    L12:
        return (int) r3;
    L8:
        if (r0 == 2) goto L10;
        return 0;
    L10:
        r3 = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        goto L12
    }

    private Rect calculateCollapsedTextBounds(Rect r5) {
        if (this.editText == null) goto L15;
        Rect r0 = this.tmpBoundsRect;
        boolean r1 = ViewUtils.isLayoutRtl(this);
        r0.bottom = r5.bottom;
        int r2 = this.boxBackgroundMode;
        if (r2 != 1) goto L7;
        r0.left = getLabelLeftBoundAlightWithPrefix(r5.left, r1);
        r0.top = r5.top + this.boxCollapsedPaddingTopPx;
        r0.right = getLabelRightBoundAlignedWithSuffix(r5.right, r1);
        return r0;
    L7:
        if (r2 == 2) goto L10;
        r0.left = getLabelLeftBoundAlightWithPrefix(r5.left, r1);
        r0.top = getPaddingTop();
        r0.right = getLabelRightBoundAlignedWithSuffix(r5.right, r1);
        return r0;
    L10:
        r0.left = r5.left + this.editText.getPaddingLeft();
        r0.top = r5.top - calculateLabelMarginTop();
        r0.right = r5.right - this.editText.getPaddingRight();
        return r0;
    L15:
        throw new IllegalStateException();
    }

    private int getLabelLeftBoundAlightWithPrefix(int r2, boolean r3) {
        int r4 = r2 + this.editText.getCompoundPaddingLeft();
        if (getPrefixText() == null) goto L7;
        if (r3 == false) goto L6;
        return r4;
    L6:
        return (r4 - getPrefixTextView().getMeasuredWidth()) + getPrefixTextView().getPaddingLeft();
    L7:
        return r4;
    }

    private int getLabelRightBoundAlignedWithSuffix(int r2, boolean r3) {
        int r4 = r2 - this.editText.getCompoundPaddingRight();
        if (getPrefixText() == null) goto L7;
        if (r3 == true) goto L6;
        return r4;
    L6:
        return r4 + (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight());
    L7:
        return r4;
    }

    private Rect calculateExpandedTextBounds(Rect r5) {
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

    private int calculateExpandedLabelTop(Rect r2, float r3) {
        if (isSingleLineFilledTextField() == false) goto L7;
        return (int) (r2.centerY() - (r3 / 2.0f));
    L7:
        return r2.top + this.editText.getCompoundPaddingTop();
    }

    private int calculateExpandedLabelBottom(Rect r2, Rect r3, float r4) {
        if (isSingleLineFilledTextField() == false) goto L7;
        return (int) (r3.top + r4);
    L7:
        return r2.bottom - this.editText.getCompoundPaddingBottom();
    }

    private boolean isSingleLineFilledTextField() {
        if (this.boxBackgroundMode == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.editText.getMinLines() > 1) goto L7;
        return true;
    }

    private int calculateBoxBackgroundColor() {
        int r0 = this.boxBackgroundColor;
        if (this.boxBackgroundMode == 1) goto L5;
        return r0;
    L5:
        return MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface, 0), this.boxBackgroundColor);
    }

    private void applyBoxAttributes() {
        MaterialShapeDrawable r0 = this.boxBackground;
        if (r0 != null) goto L5;
        return;
    L5:
        ShapeAppearanceModel r1 = r0.getShapeAppearanceModel();
        ShapeAppearanceModel r2 = this.shapeAppearanceModel;
        if (r1 == r2) goto L9;
        this.boxBackground.setShapeAppearanceModel(r2);
        updateDropdownMenuBackground();
    L9:
        if (canDrawOutlineStroke() == false) goto L11;
        this.boxBackground.setStroke(this.boxStrokeWidthPx, this.boxStrokeColor);
    L11:
        int r3 = calculateBoxBackgroundColor();
        this.boxBackgroundColor = r3;
        this.boxBackground.setFillColor(ColorStateList.valueOf(r3));
        if (this.endIconMode != 3) goto L14;
        this.editText.getBackground().invalidateSelf();
    L14:
        applyBoxUnderlineAttributes();
        invalidate();
    }

    private void applyBoxUnderlineAttributes() {
        if (this.boxUnderlineDefault != null) goto L5;
        return;
    L5:
        if (this.boxUnderlineFocused != null) goto L8;
        return;
    L8:
        if (canDrawStroke() == false) goto L14;
        MaterialShapeDrawable r0 = this.boxUnderlineDefault;
        if (this.editText.isFocused() == false) goto L12;
        ColorStateList r1 = ColorStateList.valueOf(this.defaultStrokeColor);
    L13:
        r0.setFillColor(r1);
        this.boxUnderlineFocused.setFillColor(ColorStateList.valueOf(this.boxStrokeColor));
        goto L14
    L12:
        r1 = ColorStateList.valueOf(this.boxStrokeColor);
    L14:
        invalidate();
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

    private void updateDropdownMenuBackground() {
        if (this.endIconMode == 3) goto L5;
        return;
    L5:
        if (this.boxBackgroundMode != 2) goto L9;
        ((DropdownMenuEndIconDelegate) this.endIconDelegates.get(3)).updateOutlinedRippleEffect((AutoCompleteTextView) this.editText);
        return;
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
        if (this.indicatorViewController.errorShouldBeShown() == false) goto L17;
        r1.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.indicatorViewController.getErrorViewCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        return;
    L17:
        if (this.counterOverflowed == false) goto L21;
        TextView r2 = this.counterView;
        if (r2 == null) goto L21;
        r1.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(r2.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        return;
    L21:
        DrawableCompat.clearColorFilter(r1);
        this.editText.refreshDrawableState();
        return;
    }

    @Override // android.view.View
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

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r3) {
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

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> r2) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(r2);
        this.restoringSavedState = false;
    }

    public CharSequence getError() {
        if (this.indicatorViewController.isErrorEnabled() == true) goto L7;
        return null;
    L7:
        return this.indicatorViewController.getErrorText();
    }

    public CharSequence getHelperText() {
        if (this.indicatorViewController.isHelperTextEnabled() == true) goto L7;
        return null;
    L7:
        return this.indicatorViewController.getHelperText();
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public void setHintAnimationEnabled(boolean r1) {
        this.hintAnimationEnabled = r1;
    }

    public boolean isExpandedHintEnabled() {
        return this.expandedHintEnabled;
    }

    public void setExpandedHintEnabled(boolean r2) {
        if (this.expandedHintEnabled == r2) goto L6;
        this.expandedHintEnabled = r2;
        updateLabelState(false);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int r6) {
        super.onRtlPropertiesChanged(r6);
        boolean r0 = false;
        if (r6 != 1) goto L5;
        boolean r7 = true;
    L6:
        boolean r2 = this.areCornerRadiiRtl;
        if (r7 == r2) goto L24;
        if (r7 == false) goto L11;
        if (r2 == true) goto L11;
        r0 = true;
    L11:
        float r8 = this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.tmpRectF);
        float r1 = this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.tmpRectF);
        float r3 = this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.tmpRectF);
        float r4 = this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.tmpRectF);
        if (r0 == false) goto L14;
        float r5 = r8;
    L15:
        if (r0 == false) goto L17;
        r8 = r1;
    L17:
        if (r0 == false) goto L19;
        float r9 = r3;
    L20:
        if (r0 == false) goto L22;
        r3 = r4;
    L22:
        setBoxCornerRadii(r5, r8, r9, r3);
        return;
    L19:
        r9 = r4;
        goto L20
    L14:
        r5 = r1;
        goto L15
    L24:
        return;
    L5:
        r7 = false;
        goto L6
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
        updateSuffixTextViewPadding();
        return;
    L5:
        this.editText.post(new AnonymousClass3(this));
        goto L6
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

    public void setStartIconDrawable(int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), r2);
    L5:
        setStartIconDrawable(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setStartIconDrawable(Drawable r1) {
        this.startLayout.setStartIconDrawable(r1);
    }

    public Drawable getStartIconDrawable() {
        return this.startLayout.getStartIconDrawable();
    }

    public void setStartIconOnClickListener(View.OnClickListener r1) {
        this.startLayout.setStartIconOnClickListener(r1);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener r1) {
        this.startLayout.setStartIconOnLongClickListener(r1);
    }

    public void setStartIconVisible(boolean r1) {
        this.startLayout.setStartIconVisible(r1);
    }

    public boolean isStartIconVisible() {
        return this.startLayout.isStartIconVisible();
    }

    public void refreshStartIconDrawableState() {
        this.startLayout.refreshStartIconDrawableState();
    }

    public void setStartIconCheckable(boolean r1) {
        this.startLayout.setStartIconCheckable(r1);
    }

    public boolean isStartIconCheckable() {
        return this.startLayout.isStartIconCheckable();
    }

    public void setStartIconContentDescription(int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = getResources().getText(r2);
    L5:
        setStartIconContentDescription(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setStartIconContentDescription(CharSequence r1) {
        this.startLayout.setStartIconContentDescription(r1);
    }

    public CharSequence getStartIconContentDescription() {
        return this.startLayout.getStartIconContentDescription();
    }

    public void setStartIconTintList(ColorStateList r1) {
        this.startLayout.setStartIconTintList(r1);
    }

    public void setStartIconTintMode(PorterDuff.Mode r1) {
        this.startLayout.setStartIconTintMode(r1);
    }

    public void setEndIconMode(int r4) {
        int r0 = this.endIconMode;
        if (r0 != r4) goto L5;
        return;
    L5:
        this.endIconMode = r4;
        dispatchOnEndIconChanged(r0);
        if (r4 == 0) goto L8;
        boolean r1 = true;
    L9:
        setEndIconVisible(r1);
        if (getEndIconDelegate().isBoxBackgroundModeSupported(this.boxBackgroundMode) == false) goto L14;
        getEndIconDelegate().initialize();
        IconHelper.applyIconTint(this, this.endIconView, this.endIconTintList, this.endIconTintMode);
        return;
    L14:
        throw new IllegalStateException("The current box background mode " + this.boxBackgroundMode + " is not supported by the end icon mode " + r4);
    L8:
        r1 = false;
        goto L9
    }

    public int getEndIconMode() {
        return this.endIconMode;
    }

    public void setEndIconOnClickListener(View.OnClickListener r2) {
        setIconOnClickListener(this.endIconView, r2, this.endIconOnLongClickListener);
    }

    public void setErrorIconOnClickListener(View.OnClickListener r2) {
        setIconOnClickListener(this.errorIconView, r2, this.errorIconOnLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener r1) {
        this.endIconOnLongClickListener = r1;
        setIconOnLongClickListener(this.endIconView, r1);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener r1) {
        this.errorIconOnLongClickListener = r1;
        setIconOnLongClickListener(this.errorIconView, r1);
    }

    public void refreshErrorIconDrawableState() {
        IconHelper.refreshIconDrawableState(this, this.errorIconView, this.errorIconTintList);
    }

    public void setEndIconVisible(boolean r2) {
        if (isEndIconVisible() == r2) goto L10;
        CheckableImageButton r0 = this.endIconView;
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        updateEndLayoutVisibility();
        updateSuffixTextViewPadding();
        updateDummyDrawables();
        return;
    L7:
        r3 = 8;
        goto L8
    }

    public boolean isEndIconVisible() {
        if (this.endIconFrame.getVisibility() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.endIconView.getVisibility() != 0) goto L7;
        return true;
    }

    public void setEndIconActivated(boolean r1) {
        this.endIconView.setActivated(r1);
    }

    public void refreshEndIconDrawableState() {
        IconHelper.refreshIconDrawableState(this, this.endIconView, this.endIconTintList);
    }

    public void setEndIconCheckable(boolean r1) {
        this.endIconView.setCheckable(r1);
    }

    public boolean isEndIconCheckable() {
        return this.endIconView.isCheckable();
    }

    public void setEndIconDrawable(int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), r2);
    L5:
        setEndIconDrawable(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setEndIconDrawable(Drawable r3) {
        this.endIconView.setImageDrawable(r3);
        if (r3 == null) goto L6;
        IconHelper.applyIconTint(this, this.endIconView, this.endIconTintList, this.endIconTintMode);
        refreshEndIconDrawableState();
        return;
    }

    public Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    public void setEndIconContentDescription(int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = getResources().getText(r2);
    L5:
        setEndIconContentDescription(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setEndIconContentDescription(CharSequence r2) {
        if (getEndIconContentDescription() == r2) goto L6;
        this.endIconView.setContentDescription(r2);
        return;
    }

    public CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    public void setEndIconTintList(ColorStateList r3) {
        if (this.endIconTintList == r3) goto L6;
        this.endIconTintList = r3;
        IconHelper.applyIconTint(this, this.endIconView, r3, this.endIconTintMode);
        return;
    }

    public void setEndIconTintMode(PorterDuff.Mode r3) {
        if (this.endIconTintMode == r3) goto L6;
        this.endIconTintMode = r3;
        IconHelper.applyIconTint(this, this.endIconView, this.endIconTintList, r3);
        return;
    }

    public void addOnEndIconChangedListener(OnEndIconChangedListener r1) {
        this.endIconChangedListeners.add(r1);
    }

    public void removeOnEndIconChangedListener(OnEndIconChangedListener r1) {
        this.endIconChangedListeners.remove(r1);
    }

    public void clearOnEndIconChangedListeners() {
        this.endIconChangedListeners.clear();
    }

    public void addOnEditTextAttachedListener(OnEditTextAttachedListener r2) {
        this.editTextAttachedListeners.add(r2);
        if (this.editText == null) goto L6;
        r2.onEditTextAttached(this);
        return;
    }

    public void removeOnEditTextAttachedListener(OnEditTextAttachedListener r1) {
        this.editTextAttachedListeners.remove(r1);
    }

    public void clearOnEditTextAttachedListeners() {
        this.editTextAttachedListeners.clear();
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int r2) {
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
    public void setPasswordVisibilityToggleDrawable(Drawable r1) {
        this.endIconView.setImageDrawable(r1);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int r2) {
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
    public void setPasswordVisibilityToggleContentDescription(CharSequence r1) {
        this.endIconView.setContentDescription(r1);
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        if (this.endIconMode == 1) goto L7;
        return false;
    L7:
        return true;
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
    public void setPasswordVisibilityToggleTintList(ColorStateList r3) {
        this.endIconTintList = r3;
        IconHelper.applyIconTint(this, this.endIconView, r3, this.endIconTintMode);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode r3) {
        this.endIconTintMode = r3;
        IconHelper.applyIconTint(this, this.endIconView, this.endIconTintList, r3);
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

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate r1) {
        EditText r0 = this.editText;
        if (r0 == null) goto L6;
        ViewCompat.setAccessibilityDelegate(r0, r1);
        return;
    }

    private void updateEndLayoutVisibility() {
        FrameLayout r0 = this.endIconFrame;
        int r2 = 8;
        if (this.endIconView.getVisibility() == 0) goto L5;
    L7:
        int r1 = 8;
    L8:
        r0.setVisibility(r1);
        if (this.suffixText != null) goto L11;
    L13:
        char r3 = '\b';
    L15:
        if (isEndIconVisible() == false) goto L17;
    L21:
        boolean r4 = true;
    L22:
        LinearLayout r5 = this.endLayout;
        if (r4 == false) goto L25;
        r2 = 0;
    L25:
        r5.setVisibility(r2);
        return;
    L17:
        if (isErrorIconVisible() == true) goto L21;
        if (r3 == 0) goto L21;
        r4 = false;
        goto L22
    L11:
        if (isHintExpanded() == true) goto L13;
        r3 = 0;
        goto L15
    L5:
        if (isErrorIconVisible() == true) goto L7;
        r1 = 0;
        goto L8
    }

    CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    private EndIconDelegate getEndIconDelegate() {
        EndIconDelegate r0 = this.endIconDelegates.get(this.endIconMode);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.endIconDelegates.get(0);
    }

    private void dispatchOnEditTextAttached() {
        Iterator<OnEditTextAttachedListener> r0 = this.editTextAttachedListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onEditTextAttached(this);
        goto L4
    }

    private boolean hasEndIcon() {
        if (this.endIconMode == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void dispatchOnEndIconChanged(int r3) {
        Iterator<OnEndIconChangedListener> r0 = this.endIconChangedListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onEndIconChanged(this, r3);
        goto L4
    }

    private void tintEndIconOnError(boolean r3) {
        if (r3 == true) goto L4;
    L6:
        IconHelper.applyIconTint(this, this.endIconView, this.endIconTintList, this.endIconTintMode);
        return;
    L4:
        if (getEndIconDrawable() == null) goto L6;
        Drawable r4 = DrawableCompat.wrap(getEndIconDrawable()).mutate();
        DrawableCompat.setTint(r4, this.indicatorViewController.getErrorViewCurrentTextColor());
        this.endIconView.setImageDrawable(r4);
    }

    boolean updateDummyDrawables() {
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
        this.originalEditTextEndDrawable = r4;
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

    private boolean shouldUpdateStartDummyDrawable() {
        if (getStartIconDrawable() != null) goto L9;
        if (getPrefixText() != null) goto L7;
    L11:
        return false;
    L7:
        if (getPrefixTextView().getVisibility() != 0) goto L11;
    L9:
        if (this.startLayout.getMeasuredWidth() <= 0) goto L11;
        return true;
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

    private static void setIconOnClickListener(CheckableImageButton r0, View.OnClickListener r1, View.OnLongClickListener r2) {
        r0.setOnClickListener(r1);
        setIconClickable(r0, r2);
    }

    private static void setIconOnLongClickListener(CheckableImageButton r0, View.OnLongClickListener r1) {
        r0.setOnLongClickListener(r1);
        setIconClickable(r0, r1);
    }

    private static void setIconClickable(CheckableImageButton r3, View.OnLongClickListener r4) {
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

    private void updateBoxUnderlineBounds(Rect r6) {
        if (this.boxUnderlineDefault == null) goto L6;
        int r0 = r6.bottom - this.boxStrokeWidthDefaultPx;
        this.boxUnderlineDefault.setBounds(r6.left, r0, r6.right, r6.bottom);
    L6:
        if (this.boxUnderlineFocused == null) goto L9;
        int r1 = r6.bottom - this.boxStrokeWidthFocusedPx;
        this.boxUnderlineFocused.setBounds(r6.left, r1, r6.right, r6.bottom);
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r1) {
        super.draw(r1);
        drawHint(r1);
        drawBoxUnderline(r1);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        this.collapsingTextHelper.maybeUpdateFontWeightAdjustment(r1);
    }

    private void drawHint(Canvas r2) {
        if (this.hintEnabled == false) goto L6;
        this.collapsingTextHelper.draw(r2);
        return;
    }

    private void drawBoxUnderline(Canvas r6) {
        if (this.boxUnderlineFocused == null) goto L10;
        MaterialShapeDrawable r0 = this.boxUnderlineDefault;
        if (r0 == null) goto L11;
        r0.draw(r6);
        if (this.editText.isFocused() == false) goto L12;
        Rect r1 = this.boxUnderlineFocused.getBounds();
        Rect r2 = this.boxUnderlineDefault.getBounds();
        float r3 = this.collapsingTextHelper.getExpansionFraction();
        int r4 = r2.centerX();
        r1.left = AnimationUtils.lerp(r4, r2.left, r3);
        r1.right = AnimationUtils.lerp(r4, r2.right, r3);
        this.boxUnderlineFocused.draw(r6);
        return;
    L12:
        return;
    L11:
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
        this.startLayout.onHintStateChanged(false);
        updateSuffixTextVisibility();
        return;
    L10:
        if (this.hintAnimationEnabled == false) goto L12;
        animateToExpansionFraction(1.0f);
        goto L13
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

    private void closeCutout() {
        if (cutoutEnabled() == false) goto L6;
        ((CutoutDrawable) this.boxBackground).removeCutout();
        return;
    }

    private void applyCutoutPadding(RectF r3) {
        r3.left -= this.boxLabelCutoutPaddingPx;
        r3.right += this.boxLabelCutoutPaddingPx;
    }

    boolean cutoutIsOpen() {
        if (cutoutEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (((CutoutDrawable) this.boxBackground).hasCutout() == false) goto L7;
        return true;
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

    void updateTextInputBoxState() {
        if (this.boxBackground != null) goto L5;
        return;
    L5:
        if (this.boxBackgroundMode == 0) goto L73;
        boolean r1 = false;
        if (isFocused() == true) goto L15;
        EditText r0 = this.editText;
        if (r0 != null) goto L12;
    L14:
        boolean r2 = false;
    L17:
        if (isHovered() == true) goto L22;
        EditText r3 = this.editText;
        if (r3 == null) goto L24;
        if (r3.isHovered() == true) goto L22;
    L24:
        if (isEnabled() == true) goto L27;
        this.boxStrokeColor = this.disabledColor;
    L45:
        updateErrorIconVisibility();
        refreshErrorIconDrawableState();
        refreshStartIconDrawableState();
        refreshEndIconDrawableState();
        if (getEndIconDelegate().shouldTintIconOnError() == false) goto L49;
        tintEndIconOnError(this.indicatorViewController.errorShouldBeShown());
    L49:
        if (this.boxBackgroundMode != 2) goto L60;
        int r4 = this.boxStrokeWidthPx;
        if (r2 == true) goto L53;
    L55:
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
    L57:
        if (this.boxStrokeWidthPx == r4) goto L60;
        recalculateCutout();
        goto L60
    L53:
        if (isEnabled() == false) goto L55;
        this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
    L60:
        if (this.boxBackgroundMode == 1) goto L62;
    L70:
        applyBoxAttributes();
        return;
    L62:
        if (isEnabled() == true) goto L64;
        this.boxBackgroundColor = this.disabledFilledBackgroundColor;
        goto L70
    L64:
        if (r1 == false) goto L67;
        if (r2 == true) goto L67;
        this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
    L67:
        if (r2 == false) goto L69;
        this.boxBackgroundColor = this.focusedFilledBackgroundColor;
        goto L70
    L69:
        this.boxBackgroundColor = this.defaultFilledBackgroundColor;
        goto L70
    L27:
        if (this.indicatorViewController.errorShouldBeShown() == false) goto L33;
        if (this.strokeErrorColor == null) goto L31;
        updateStrokeErrorColor(r2, r1);
        goto L45
    L31:
        this.boxStrokeColor = this.indicatorViewController.getErrorViewCurrentTextColor();
        goto L45
    L33:
        if (this.counterOverflowed == false) goto L40;
        TextView r5 = this.counterView;
        if (r5 == null) goto L40;
        if (this.strokeErrorColor == null) goto L39;
        updateStrokeErrorColor(r2, r1);
        goto L45
    L39:
        this.boxStrokeColor = r5.getCurrentTextColor();
    L40:
        if (r2 == false) goto L42;
        this.boxStrokeColor = this.focusedStrokeColor;
        goto L45
    L42:
        if (r1 == false) goto L44;
        this.boxStrokeColor = this.hoveredStrokeColor;
        goto L45
    L44:
        this.boxStrokeColor = this.defaultStrokeColor;
    L22:
        r1 = true;
        goto L24
    L12:
        if (r0.hasFocus() == false) goto L14;
    L15:
        r2 = true;
        goto L17
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

    private void updateErrorIconVisibility() {
        int r1 = 0;
        if (getErrorIconDrawable() != null) goto L5;
    L9:
        boolean r0 = false;
    L10:
        CheckableImageButton r2 = this.errorIconView;
        if (r0 == true) goto L14;
        r1 = 8;
    L14:
        r2.setVisibility(r1);
        updateEndLayoutVisibility();
        updateSuffixTextViewPadding();
        if (hasEndIcon() == true) goto L18;
        updateDummyDrawables();
        return;
    L18:
        return;
    L5:
        if (this.indicatorViewController.isErrorEnabled() == false) goto L9;
        if (this.indicatorViewController.errorShouldBeShown() == false) goto L9;
        r0 = true;
        goto L10
    }

    private boolean isErrorIconVisible() {
        if (this.errorIconView.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
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
        this.startLayout.onHintStateChanged(true);
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

    final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.helperTextIsDisplayed();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    final int getErrorTextCurrentColor() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }
}
