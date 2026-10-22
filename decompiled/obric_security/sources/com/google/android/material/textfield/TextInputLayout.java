package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
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
    private ValueAnimator animator;
    private MaterialShapeDrawable boxBackground;
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private int boxCollapsedPaddingTopPx;
    private final int boxLabelCutoutPaddingPx;
    private int boxStrokeColor;
    private int boxStrokeWidthDefaultPx;
    private int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    private MaterialShapeDrawable boxUnderline;
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
    private final CheckableImageButton errorIconView;
    private boolean expandedHintEnabled;
    private int focusedFilledBackgroundColor;
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
    private int hoveredFilledBackgroundColor;
    private int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final IndicatorViewController indicatorViewController;
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    private boolean placeholderEnabled;
    private CharSequence placeholderText;
    private int placeholderTextAppearance;
    private ColorStateList placeholderTextColor;
    private TextView placeholderTextView;
    private CharSequence prefixText;
    private final TextView prefixTextView;
    private boolean restoringSavedState;
    private ShapeAppearanceModel shapeAppearanceModel;
    private Drawable startDummyDrawable;
    private int startDummyDrawableWidth;
    private View.OnLongClickListener startIconOnLongClickListener;
    private ColorStateList startIconTintList;
    private PorterDuff.Mode startIconTintMode;
    private final CheckableImageButton startIconView;
    private final LinearLayout startLayout;
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
            CharSequence r0 = r14.getText();
        L6:
            CharSequence r1 = this.layout.getHint();
            CharSequence r2 = this.layout.getError();
            CharSequence r3 = this.layout.getPlaceholderText();
            int r4 = this.layout.getCounterMaxLength();
            CharSequence r5 = this.layout.getCounterOverflowDescription();
            boolean r6 = !TextUtils.isEmpty(r0);
            boolean r8 = !TextUtils.isEmpty(r1);
            boolean r11 = !this.layout.isHintExpanded();
            boolean r9 = !TextUtils.isEmpty(r2);
            if (r9 == false) goto L9;
        L12:
            boolean r10 = true;
        L13:
            if (r8 == false) goto L15;
            String r7 = r1.toString();
        L16:
            if (r6 == false) goto L19;
            r13.setText(r0);
        L27:
            if (TextUtils.isEmpty(r7) == true) goto L29;
            r13.setHintText(r7);
            r13.setShowingHintText(!r6);
        L29:
            if (r0 != null) goto L31;
        L33:
            r4 = -1;
        L34:
            r13.setMaxTextLength(r4);
            if (r10 == false) goto L40;
            if (r9 == true) goto L39;
            r2 = r5;
        L39:
            r13.setError(r2);
        L40:
            if (r14 == null) goto L43;
            r14.setLabelFor(R.id.textinput_helper_text);
            return;
        L43:
            return;
        L31:
            if (r0.length() != r4) goto L33;
        L19:
            if (TextUtils.isEmpty(r7) == true) goto L24;
            r13.setText(r7);
            if (r11 == false) goto L27;
            if (r3 == null) goto L27;
            r13.setText(r7 + ", " + r3);
            goto L27
        L24:
            if (r3 == null) goto L27;
            r13.setText(r3);
            goto L27
        L15:
            r7 = "";
            goto L16
        L9:
            if (TextUtils.isEmpty(r5) == false) goto L12;
            r10 = false;
            goto L13
        L5:
            r0 = null;
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
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + " hint=" + this.hintText + " helperText=" + this.helperText + " placeholderText=" + this.placeholderText + "}";
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

    static {
        DEF_STYLE_RES = R.style.Widget_Design_TextInputLayout;
    }

    public TextInputLayout(Context r2) {
        this(r2, null);
    }

    public TextInputLayout(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.textInputStyle);
    }

    public TextInputLayout(Context r28, AttributeSet r29, int r30) {
        int r9 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r28, r29, r30, r9), r29, r30);
        this.indicatorViewController = new IndicatorViewController(this);
        this.tmpRect = new Rect();
        this.tmpBoundsRect = new Rect();
        this.tmpRectF = new RectF();
        this.editTextAttachedListeners = new LinkedHashSet();
        this.endIconMode = 0;
        SparseArray<EndIconDelegate> r11 = new SparseArray();
        this.endIconDelegates = r11;
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
        LinearLayout r14 = new LinearLayout(r12);
        this.startLayout = r14;
        r14.setOrientation(0);
        r14.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        r2.addView(r14);
        LinearLayout r5 = new LinearLayout(r12);
        this.endLayout = r5;
        r5.setOrientation(0);
        r5.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        r2.addView(r5);
        FrameLayout r4 = new FrameLayout(r12);
        this.endIconFrame = r4;
        r4.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        r1.setTextSizeInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r1.setPositionInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r1.setCollapsedTextGravity(BadgeDrawable.TOP_START);
        TintTypedArray r3 = ThemeEnforcement.obtainTintedStyledAttributes(r12, r29, R.styleable.TextInputLayout, r30, r9, new int[]{R.styleable.TextInputLayout_counterTextAppearance, R.styleable.TextInputLayout_counterOverflowTextAppearance, R.styleable.TextInputLayout_errorTextAppearance, R.styleable.TextInputLayout_helperTextTextAppearance, R.styleable.TextInputLayout_hintTextAppearance});
        this.hintEnabled = r3.getBoolean(R.styleable.TextInputLayout_hintEnabled, true);
        setHint(r3.getText(R.styleable.TextInputLayout_android_hint));
        this.hintAnimationEnabled = r3.getBoolean(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.expandedHintEnabled = r3.getBoolean(R.styleable.TextInputLayout_expandedHintEnabled, true);
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(r12, r29, r30, r9).build();
        this.boxLabelCutoutPaddingPx = r12.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = r3.getDimensionPixelOffset(R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.boxStrokeWidthDefaultPx = r3.getDimensionPixelSize(R.styleable.TextInputLayout_boxStrokeWidth, r12.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.boxStrokeWidthFocusedPx = r3.getDimensionPixelSize(R.styleable.TextInputLayout_boxStrokeWidthFocused, r12.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        float r6 = r3.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float r7 = r3.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float r8 = r3.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float r10 = r3.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        ShapeAppearanceModel.Builder r13 = this.shapeAppearanceModel.toBuilder();
        if (r6 < 0.0f) goto L6;
        r13.setTopLeftCornerSize(r6);
    L6:
        if (r7 < 0.0f) goto L9;
        r13.setTopRightCornerSize(r7);
    L9:
        if (r8 < 0.0f) goto L12;
        r13.setBottomRightCornerSize(r8);
    L12:
        if (r10 < 0.0f) goto L14;
        r13.setBottomLeftCornerSize(r10);
    L14:
        this.shapeAppearanceModel = r13.build();
        ColorStateList r15 = MaterialResources.getColorStateList(r12, r3, R.styleable.TextInputLayout_boxBackgroundColor);
        if (r15 == null) goto L20;
        int r16 = r15.getDefaultColor();
        this.defaultFilledBackgroundColor = r16;
        this.boxBackgroundColor = r16;
        if (r15.isStateful() == false) goto L19;
        int r17 = -1;
        this.disabledFilledBackgroundColor = r15.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = r15.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.hoveredFilledBackgroundColor = r15.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
    L22:
        if (r3.hasValue(R.styleable.TextInputLayout_android_textColorHint) == false) goto L24;
        ColorStateList r18 = r3.getColorStateList(R.styleable.TextInputLayout_android_textColorHint);
        this.focusedTextColor = r18;
        this.defaultHintTextColor = r18;
    L24:
        ColorStateList r19 = MaterialResources.getColorStateList(r12, r3, R.styleable.TextInputLayout_boxStrokeColor);
        this.focusedStrokeColor = r3.getColor(R.styleable.TextInputLayout_boxStrokeColor, 0);
        this.defaultStrokeColor = ContextCompat.getColor(r12, R.color.mtrl_textinput_default_box_stroke_color);
        this.disabledColor = ContextCompat.getColor(r12, R.color.mtrl_textinput_disabled_color);
        this.hoveredStrokeColor = ContextCompat.getColor(r12, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (r19 == null) goto L28;
        setBoxStrokeColorStateList(r19);
    L28:
        if (r3.hasValue(R.styleable.TextInputLayout_boxStrokeErrorColor) == false) goto L31;
        setBoxStrokeErrorColor(MaterialResources.getColorStateList(r12, r3, R.styleable.TextInputLayout_boxStrokeErrorColor));
    L31:
        if (r3.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, r17) == r17) goto L33;
        setHintTextAppearance(r3.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, 0));
    L33:
        int r20 = r3.getResourceId(R.styleable.TextInputLayout_errorTextAppearance, 0);
        CharSequence r21 = r3.getText(R.styleable.TextInputLayout_errorContentDescription);
        boolean r22 = r3.getBoolean(R.styleable.TextInputLayout_errorEnabled, false);
        CheckableImageButton r23 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_end_icon, r5, false);
        this.errorIconView = r23;
        r23.setId(R.id.text_input_error_icon);
        r23.setVisibility(8);
        if (MaterialResources.isFontScaleAtLeast1_3(r12) == false) goto L37;
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) r23.getLayoutParams(), 0);
    L37:
        if (r3.hasValue(R.styleable.TextInputLayout_errorIconDrawable) == false) goto L40;
        setErrorIconDrawable(r3.getDrawable(R.styleable.TextInputLayout_errorIconDrawable));
    L40:
        if (r3.hasValue(R.styleable.TextInputLayout_errorIconTint) == false) goto L43;
        setErrorIconTintList(MaterialResources.getColorStateList(r12, r3, R.styleable.TextInputLayout_errorIconTint));
    L43:
        if (r3.hasValue(R.styleable.TextInputLayout_errorIconTintMode) == false) goto L45;
        setErrorIconTintMode(ViewUtils.parseTintMode(r3.getInt(R.styleable.TextInputLayout_errorIconTintMode, r17), null));
    L45:
        r23.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        ViewCompat.setImportantForAccessibility(r23, 2);
        r23.setClickable(false);
        r23.setPressable(false);
        r23.setFocusable(false);
        int r24 = r3.getResourceId(R.styleable.TextInputLayout_helperTextTextAppearance, 0);
        boolean r110 = r3.getBoolean(R.styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence r25 = r3.getText(R.styleable.TextInputLayout_helperText);
        int r26 = r3.getResourceId(R.styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence r111 = r3.getText(R.styleable.TextInputLayout_placeholderText);
        int r27 = r3.getResourceId(R.styleable.TextInputLayout_prefixTextAppearance, 0);
        CharSequence r112 = r3.getText(R.styleable.TextInputLayout_prefixText);
        int r31 = r3.getResourceId(R.styleable.TextInputLayout_suffixTextAppearance, 0);
        CharSequence r113 = r3.getText(R.styleable.TextInputLayout_suffixText);
        boolean r32 = r3.getBoolean(R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(r3.getInt(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.counterTextAppearance = r3.getResourceId(R.styleable.TextInputLayout_counterTextAppearance, 0);
        this.counterOverflowTextAppearance = r3.getResourceId(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        CheckableImageButton r33 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, r14, false);
        this.startIconView = r33;
        r33.setVisibility(8);
        if (MaterialResources.isFontScaleAtLeast1_3(r12) == false) goto L48;
        MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) r33.getLayoutParams(), 0);
    L48:
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        if (r3.hasValue(R.styleable.TextInputLayout_startIconDrawable) == false) goto L55;
        setStartIconDrawable(r3.getDrawable(R.styleable.TextInputLayout_startIconDrawable));
        if (r3.hasValue(R.styleable.TextInputLayout_startIconContentDescription) == false) goto L53;
        setStartIconContentDescription(r3.getText(R.styleable.TextInputLayout_startIconContentDescription));
    L53:
        setStartIconCheckable(r3.getBoolean(R.styleable.TextInputLayout_startIconCheckable, true));
    L55:
        if (r3.hasValue(R.styleable.TextInputLayout_startIconTint) == false) goto L58;
        setStartIconTintList(MaterialResources.getColorStateList(r12, r3, R.styleable.TextInputLayout_startIconTint));
    L58:
        if (r3.hasValue(R.styleable.TextInputLayout_startIconTintMode) == false) goto L60;
        setStartIconTintMode(ViewUtils.parseTintMode(r3.getInt(R.styleable.TextInputLayout_startIconTintMode, -1), null));
    L60:
        setBoxBackgroundMode(r3.getInt(R.styleable.TextInputLayout_boxBackgroundMode, 0));
        CheckableImageButton r34 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_end_icon, r4, false);
        this.endIconView = r34;
        r4.addView(r34);
        r34.setVisibility(8);
        if (MaterialResources.isFontScaleAtLeast1_3(r12) == false) goto L63;
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) r34.getLayoutParams(), 0);
    L63:
        r11.append(-1, new CustomEndIconDelegate(this));
        r11.append(0, new NoEndIconDelegate(this));
        r11.append(1, new PasswordToggleEndIconDelegate(this));
        r11.append(2, new ClearTextEndIconDelegate(this));
        r11.append(3, new DropdownMenuEndIconDelegate(this));
        if (r3.hasValue(R.styleable.TextInputLayout_endIconMode) == false) goto L73;
        setEndIconMode(r3.getInt(R.styleable.TextInputLayout_endIconMode, 0));
        if (r3.hasValue(R.styleable.TextInputLayout_endIconDrawable) == false) goto L69;
        setEndIconDrawable(r3.getDrawable(R.styleable.TextInputLayout_endIconDrawable));
    L69:
        if (r3.hasValue(R.styleable.TextInputLayout_endIconContentDescription) == false) goto L71;
        setEndIconContentDescription(r3.getText(R.styleable.TextInputLayout_endIconContentDescription));
    L71:
        setEndIconCheckable(r3.getBoolean(R.styleable.TextInputLayout_endIconCheckable, true));
    L81:
        if (r3.hasValue(R.styleable.TextInputLayout_passwordToggleEnabled) == false) goto L83;
    L88:
        AppCompatTextView r35 = new AppCompatTextView(r12);
        this.prefixTextView = r35;
        r35.setId(R.id.textinput_prefix_text);
        r35.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(r35, 1);
        r14.addView(r33);
        r14.addView(r35);
        AppCompatTextView r36 = new AppCompatTextView(r12);
        this.suffixTextView = r36;
        r36.setId(R.id.textinput_suffix_text);
        r36.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        ViewCompat.setAccessibilityLiveRegion(r36, 1);
        r5.addView(r36);
        r5.addView(r23);
        r5.addView(r4);
        setHelperTextEnabled(r110);
        setHelperText(r25);
        setHelperTextTextAppearance(r24);
        setErrorEnabled(r22);
        setErrorTextAppearance(r20);
        setErrorContentDescription(r21);
        setCounterTextAppearance(this.counterTextAppearance);
        setCounterOverflowTextAppearance(this.counterOverflowTextAppearance);
        setPlaceholderText(r111);
        setPlaceholderTextAppearance(r26);
        setPrefixText(r112);
        setPrefixTextAppearance(r27);
        setSuffixText(r113);
        setSuffixTextAppearance(r31);
        if (r3.hasValue(R.styleable.TextInputLayout_errorTextColor) == false) goto L92;
        setErrorTextColor(r3.getColorStateList(R.styleable.TextInputLayout_errorTextColor));
    L92:
        if (r3.hasValue(R.styleable.TextInputLayout_helperTextTextColor) == false) goto L95;
        setHelperTextColor(r3.getColorStateList(R.styleable.TextInputLayout_helperTextTextColor));
    L95:
        if (r3.hasValue(R.styleable.TextInputLayout_hintTextColor) == false) goto L98;
        setHintTextColor(r3.getColorStateList(R.styleable.TextInputLayout_hintTextColor));
    L98:
        if (r3.hasValue(R.styleable.TextInputLayout_counterTextColor) == false) goto L101;
        setCounterTextColor(r3.getColorStateList(R.styleable.TextInputLayout_counterTextColor));
    L101:
        if (r3.hasValue(R.styleable.TextInputLayout_counterOverflowTextColor) == false) goto L104;
        setCounterOverflowTextColor(r3.getColorStateList(R.styleable.TextInputLayout_counterOverflowTextColor));
    L104:
        if (r3.hasValue(R.styleable.TextInputLayout_placeholderTextColor) == false) goto L107;
        setPlaceholderTextColor(r3.getColorStateList(R.styleable.TextInputLayout_placeholderTextColor));
    L107:
        if (r3.hasValue(R.styleable.TextInputLayout_prefixTextColor) == false) goto L110;
        setPrefixTextColor(r3.getColorStateList(R.styleable.TextInputLayout_prefixTextColor));
    L110:
        if (r3.hasValue(R.styleable.TextInputLayout_suffixTextColor) == false) goto L112;
        setSuffixTextColor(r3.getColorStateList(R.styleable.TextInputLayout_suffixTextColor));
    L112:
        setCounterEnabled(r32);
        setEnabled(r3.getBoolean(R.styleable.TextInputLayout_android_enabled, true));
        r3.recycle();
        ViewCompat.setImportantForAccessibility(this, 2);
        ViewCompat.setImportantForAutofill(this, 1);
        return;
    L83:
        if (r3.hasValue(R.styleable.TextInputLayout_endIconTint) == false) goto L86;
        setEndIconTintList(MaterialResources.getColorStateList(r12, r3, R.styleable.TextInputLayout_endIconTint));
    L86:
        if (r3.hasValue(R.styleable.TextInputLayout_endIconTintMode) == false) goto L88;
        setEndIconTintMode(ViewUtils.parseTintMode(r3.getInt(R.styleable.TextInputLayout_endIconTintMode, -1), null));
        goto L88
    L73:
        if (r3.hasValue(R.styleable.TextInputLayout_passwordToggleEnabled) == false) goto L81;
        setEndIconMode(r3.getBoolean(R.styleable.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
        setEndIconDrawable(r3.getDrawable(R.styleable.TextInputLayout_passwordToggleDrawable));
        setEndIconContentDescription(r3.getText(R.styleable.TextInputLayout_passwordToggleContentDescription));
        if (r3.hasValue(R.styleable.TextInputLayout_passwordToggleTint) == false) goto L78;
        setEndIconTintList(MaterialResources.getColorStateList(r12, r3, R.styleable.TextInputLayout_passwordToggleTint));
    L78:
        if (r3.hasValue(R.styleable.TextInputLayout_passwordToggleTintMode) == false) goto L81;
        setEndIconTintMode(ViewUtils.parseTintMode(r3.getInt(R.styleable.TextInputLayout_passwordToggleTintMode, -1), null));
        goto L81
    L19:
        r17 = -1;
        this.focusedFilledBackgroundColor = this.defaultFilledBackgroundColor;
        ColorStateList r37 = AppCompatResources.getColorStateList(r12, R.color.mtrl_filled_background_color);
        this.disabledFilledBackgroundColor = r37.getColorForState(new int[]{-16842910}, -1);
        this.hoveredFilledBackgroundColor = r37.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
        goto L22
    L20:
        r17 = -1;
        this.boxBackgroundColor = 0;
        this.defaultFilledBackgroundColor = 0;
        this.disabledFilledBackgroundColor = 0;
        this.focusedFilledBackgroundColor = 0;
        this.hoveredFilledBackgroundColor = 0;
        goto L22
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
        this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
    L14:
        this.boxUnderline = null;
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

    public float getBoxCornerRadiusTopStart() {
        return this.boxBackground.getTopLeftCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.boxBackground.getTopRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.boxBackground.getBottomLeftCornerResolvedSize();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.boxBackground.getBottomRightCornerResolvedSize();
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
        if (this.editText != null) goto L27;
        if (this.endIconMode != 3) goto L7;
    L9:
        this.editText = r4;
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

    public void setErrorIconDrawable(Drawable r2) {
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

    public Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    public void setErrorIconTintList(ColorStateList r2) {
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

    public void setErrorIconTintMode(PorterDuff.Mode r2) {
        Drawable r0 = this.errorIconView.getDrawable();
        if (r0 == null) goto L6;
        r0 = DrawableCompat.wrap(r0).mutate();
        DrawableCompat.setTintMode(r0, r2);
    L6:
        if (this.errorIconView.getDrawable() == r0) goto L9;
        this.errorIconView.setImageDrawable(r0);
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

    public void setPlaceholderText(CharSequence r2) {
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

    public CharSequence getPlaceholderText() {
        if (this.placeholderEnabled == true) goto L7;
        return null;
    L7:
        return this.placeholderText;
    }

    private void setPlaceholderTextEnabled(boolean r3) {
        if (this.placeholderEnabled != r3) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        AppCompatTextView r0 = new AppCompatTextView(getContext());
        this.placeholderTextView = r0;
        r0.setId(R.id.textinput_placeholder);
        ViewCompat.setAccessibilityLiveRegion(this.placeholderTextView, 1);
        setPlaceholderTextAppearance(this.placeholderTextAppearance);
        setPlaceholderTextColor(this.placeholderTextColor);
        addPlaceholderTextView();
    L8:
        this.placeholderEnabled = r3;
        return;
    L7:
        removePlaceholderTextView();
        this.placeholderTextView = null;
        goto L8
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
        TextView r0 = this.placeholderTextView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.placeholderEnabled == false) goto L9;
        r0.setText(this.placeholderText);
        this.placeholderTextView.setVisibility(0);
        this.placeholderTextView.bringToFront();
        return;
    }

    private void hidePlaceholderText() {
        TextView r0 = this.placeholderTextView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.placeholderEnabled == false) goto L9;
        r0.setText(null);
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

    public void setPrefixText(CharSequence r2) {
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

    public CharSequence getPrefixText() {
        return this.prefixText;
    }

    public TextView getPrefixTextView() {
        return this.prefixTextView;
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

    public void setPrefixTextColor(ColorStateList r1) {
        this.prefixTextView.setTextColor(r1);
    }

    public ColorStateList getPrefixTextColor() {
        return this.prefixTextView.getTextColors();
    }

    public void setPrefixTextAppearance(int r1) {
        TextViewCompat.setTextAppearance(this.prefixTextView, r1);
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

    private Rect calculateCollapsedTextBounds(Rect r5) {
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

    public void setStartIconDrawable(Drawable r2) {
        this.startIconView.setImageDrawable(r2);
        if (r2 == null) goto L5;
        setStartIconVisible(true);
        refreshStartIconDrawableState();
        return;
    L5:
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription(null);
    }

    public Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    public void setStartIconOnClickListener(View.OnClickListener r2) {
        setIconOnClickListener(this.startIconView, r2, this.startIconOnLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener r1) {
        this.startIconOnLongClickListener = r1;
        setIconOnLongClickListener(this.startIconView, r1);
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

    public boolean isStartIconVisible() {
        if (this.startIconView.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void refreshStartIconDrawableState() {
        refreshIconDrawableState(this.startIconView, this.startIconTintList);
    }

    public void setStartIconCheckable(boolean r1) {
        this.startIconView.setCheckable(r1);
    }

    public boolean isStartIconCheckable() {
        return this.startIconView.isCheckable();
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

    public void setStartIconContentDescription(CharSequence r2) {
        if (getStartIconContentDescription() == r2) goto L6;
        this.startIconView.setContentDescription(r2);
        return;
    }

    public CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    public void setStartIconTintList(ColorStateList r2) {
        if (this.startIconTintList == r2) goto L6;
        this.startIconTintList = r2;
        this.hasStartIconTintList = true;
        applyStartIconTint();
        return;
    }

    public void setStartIconTintMode(PorterDuff.Mode r2) {
        if (this.startIconTintMode == r2) goto L6;
        this.startIconTintMode = r2;
        this.hasStartIconTintMode = true;
        applyStartIconTint();
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
        refreshIconDrawableState(this.errorIconView, this.errorIconTintList);
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
        refreshIconDrawableState(this.endIconView, this.endIconTintList);
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

    public void setEndIconDrawable(Drawable r2) {
        this.endIconView.setImageDrawable(r2);
        refreshEndIconDrawableState();
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

    public void setEndIconTintList(ColorStateList r2) {
        if (this.endIconTintList == r2) goto L6;
        this.endIconTintList = r2;
        this.hasEndIconTintList = true;
        applyEndIconTint();
        return;
    }

    public void setEndIconTintMode(PorterDuff.Mode r2) {
        if (this.endIconTintMode == r2) goto L6;
        this.endIconTintMode = r2;
        this.hasEndIconTintMode = true;
        applyEndIconTint();
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
    public void setPasswordVisibilityToggleTintList(ColorStateList r1) {
        this.endIconTintList = r1;
        this.hasEndIconTintList = true;
        applyEndIconTint();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode r1) {
        this.endIconTintMode = r1;
        this.hasEndIconTintMode = true;
        applyEndIconTint();
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

    private void applyStartIconTint() {
        applyIconTint(this.startIconView, this.hasStartIconTintList, this.startIconTintList, this.hasStartIconTintMode, this.startIconTintMode);
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

    private void applyEndIconTint() {
        applyIconTint(this.endIconView, this.hasEndIconTintList, this.endIconTintList, this.hasEndIconTintMode, this.endIconTintMode);
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
        if (getStartIconDrawable() != null) goto L7;
        if (this.prefixText != null) goto L7;
    L9:
        return false;
    L7:
        if (this.startLayout.getMeasuredWidth() <= 0) goto L9;
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

    private void applyIconTint(CheckableImageButton r1, boolean r2, ColorStateList r3, boolean r4, PorterDuff.Mode r5) {
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

    private void updateBoxUnderlineBounds(Rect r4) {
        if (this.boxUnderline == null) goto L6;
        int r0 = r4.bottom - this.boxStrokeWidthFocusedPx;
        this.boxUnderline.setBounds(r4.left, r0, r4.right, r4.bottom);
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r1) {
        super.draw(r1);
        drawHint(r1);
        drawBoxUnderline(r1);
    }

    private void drawHint(Canvas r2) {
        if (this.hintEnabled == false) goto L6;
        this.collapsingTextHelper.draw(r2);
        return;
    }

    private void drawBoxUnderline(Canvas r4) {
        MaterialShapeDrawable r0 = this.boxUnderline;
        if (r0 == null) goto L6;
        Rect r1 = r0.getBounds();
        r1.top = r1.bottom - this.boxStrokeWidthPx;
        this.boxUnderline.draw(r4);
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
        r0.offset(-getPaddingLeft(), -getPaddingTop());
        ((CutoutDrawable) this.boxBackground).setCutout(r0);
    }

    private void closeCutout() {
        if (cutoutEnabled() == false) goto L6;
        ((CutoutDrawable) this.boxBackground).removeCutout();
        return;
    }

    private void applyCutoutPadding(RectF r3) {
        r3.left -= this.boxLabelCutoutPaddingPx;
        r3.top -= this.boxLabelCutoutPaddingPx;
        r3.right += this.boxLabelCutoutPaddingPx;
        r3.bottom += this.boxLabelCutoutPaddingPx;
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
        if (this.boxBackgroundMode == 0) goto L76;
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
        if (isEnabled() == true) goto L29;
        this.boxStrokeColor = this.disabledColor;
    L48:
        if (getErrorIconDrawable() != null) goto L50;
    L54:
        setErrorIconVisible(r1);
        refreshErrorIconDrawableState();
        refreshStartIconDrawableState();
        refreshEndIconDrawableState();
        if (getEndIconDelegate().shouldTintIconOnError() == false) goto L57;
        tintEndIconOnError(this.indicatorViewController.errorShouldBeShown());
    L57:
        if (r2 == true) goto L59;
    L61:
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
    L63:
        if (this.boxBackgroundMode == 1) goto L65;
    L73:
        applyBoxAttributes();
        return;
    L65:
        if (isEnabled() == true) goto L67;
        this.boxBackgroundColor = this.disabledFilledBackgroundColor;
        goto L73
    L67:
        if (r4 == false) goto L70;
        if (r2 == true) goto L70;
        this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
    L70:
        if (r2 == false) goto L72;
        this.boxBackgroundColor = this.focusedFilledBackgroundColor;
        goto L73
    L72:
        this.boxBackgroundColor = this.defaultFilledBackgroundColor;
        goto L73
    L59:
        if (isEnabled() == false) goto L61;
        this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
        goto L63
    L50:
        if (this.indicatorViewController.isErrorEnabled() == false) goto L54;
        if (this.indicatorViewController.errorShouldBeShown() == false) goto L54;
        r1 = true;
        goto L54
    L29:
        if (this.indicatorViewController.errorShouldBeShown() == false) goto L35;
        if (this.strokeErrorColor == null) goto L33;
        updateStrokeErrorColor(r2, r4);
        goto L48
    L33:
        this.boxStrokeColor = this.indicatorViewController.getErrorViewCurrentTextColor();
        goto L48
    L35:
        if (this.counterOverflowed == false) goto L42;
        TextView r5 = this.counterView;
        if (r5 == null) goto L42;
        if (this.strokeErrorColor == null) goto L41;
        updateStrokeErrorColor(r2, r4);
        goto L48
    L41:
        this.boxStrokeColor = r5.getCurrentTextColor();
    L42:
        if (r2 == false) goto L44;
        this.boxStrokeColor = this.focusedStrokeColor;
        goto L48
    L44:
        if (r4 == false) goto L46;
        this.boxStrokeColor = this.hoveredStrokeColor;
        goto L48
    L46:
        this.boxStrokeColor = this.defaultStrokeColor;
        goto L48
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

    private boolean isErrorIconVisible() {
        if (this.errorIconView.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
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

    private int[] mergeIconState(CheckableImageButton r4) {
        int[] r3 = getDrawableState();
        int[] r5 = r4.getDrawableState();
        int r0 = r3.length;
        int[] r6 = Arrays.copyOf(r3, r3.length + r5.length);
        System.arraycopy(r5, 0, r6, r0, r5.length);
        return r6;
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
