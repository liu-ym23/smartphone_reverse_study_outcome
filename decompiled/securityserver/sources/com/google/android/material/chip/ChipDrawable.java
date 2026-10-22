package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.AttrRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ChipDrawable extends MaterialShapeDrawable implements TintAwareDrawable, Drawable.Callback, TextDrawableHelper.TextDrawableDelegate {
    private static final boolean DEBUG = false;
    private static final int[] DEFAULT_STATE = null;
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    private static final ShapeDrawable closeIconRippleMask = null;
    private int alpha;
    private boolean checkable;

    @Nullable
    private Drawable checkedIcon;

    @Nullable
    private ColorStateList checkedIconTint;
    private boolean checkedIconVisible;

    @Nullable
    private ColorStateList chipBackgroundColor;
    private float chipCornerRadius;
    private float chipEndPadding;

    @Nullable
    private Drawable chipIcon;
    private float chipIconSize;

    @Nullable
    private ColorStateList chipIconTint;
    private boolean chipIconVisible;
    private float chipMinHeight;
    private final Paint chipPaint;
    private float chipStartPadding;

    @Nullable
    private ColorStateList chipStrokeColor;
    private float chipStrokeWidth;

    @Nullable
    private ColorStateList chipSurfaceColor;

    @Nullable
    private Drawable closeIcon;

    @Nullable
    private CharSequence closeIconContentDescription;
    private float closeIconEndPadding;

    @Nullable
    private Drawable closeIconRipple;
    private float closeIconSize;
    private float closeIconStartPadding;
    private int[] closeIconStateSet;

    @Nullable
    private ColorStateList closeIconTint;
    private boolean closeIconVisible;

    @Nullable
    private ColorFilter colorFilter;

    @Nullable
    private ColorStateList compatRippleColor;

    @NonNull
    private final Context context;
    private boolean currentChecked;

    @ColorInt
    private int currentChipBackgroundColor;

    @ColorInt
    private int currentChipStrokeColor;

    @ColorInt
    private int currentChipSurfaceColor;

    @ColorInt
    private int currentCompatRippleColor;

    @ColorInt
    private int currentCompositeSurfaceBackgroundColor;

    @ColorInt
    private int currentTextColor;

    @ColorInt
    private int currentTint;

    @Nullable
    private final Paint debugPaint;

    @NonNull
    private WeakReference<Delegate> delegate;
    private final Paint.FontMetrics fontMetrics;
    private boolean hasChipIconTint;

    @Nullable
    private MotionSpec hideMotionSpec;
    private float iconEndPadding;
    private float iconStartPadding;
    private boolean isShapeThemingEnabled;
    private int maxWidth;
    private final PointF pointF;
    private final RectF rectF;

    @Nullable
    private ColorStateList rippleColor;
    private final Path shapePath;
    private boolean shouldDrawText;

    @Nullable
    private MotionSpec showMotionSpec;

    @Nullable
    private CharSequence text;

    @NonNull
    private final TextDrawableHelper textDrawableHelper;
    private float textEndPadding;
    private float textStartPadding;

    @Nullable
    private ColorStateList tint;

    @Nullable
    private PorterDuffColorFilter tintFilter;

    @Nullable
    private PorterDuff.Mode tintMode;
    private TextUtils.TruncateAt truncateAt;
    private boolean useCompatRipple;

    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    static {
        DEFAULT_STATE = new int[]{R.attr.state_enabled};
        closeIconRippleMask = new ShapeDrawable(new OvalShape());
    }

    private ChipDrawable(@NonNull Context r2, AttributeSet r3, @AttrRes int r4, @StyleRes int r5) {
        super(r2, r3, r4, r5);
        this.chipCornerRadius = -1.0f;
        this.chipPaint = new Paint(1);
        this.fontMetrics = new Paint.FontMetrics();
        this.rectF = new RectF();
        this.pointF = new PointF();
        this.shapePath = new Path();
        this.alpha = 255;
        this.tintMode = PorterDuff.Mode.SRC_IN;
        this.delegate = new WeakReference(null);
        initializeElevationOverlay(r2);
        this.context = r2;
        TextDrawableHelper r6 = new TextDrawableHelper(this);
        this.textDrawableHelper = r6;
        this.text = "";
        TextPaint r7 = r6.getTextPaint();
        r7.density = r2.getResources().getDisplayMetrics().density;
        this.debugPaint = null;
        int[] r8 = DEFAULT_STATE;
        setState(r8);
        setCloseIconState(r8);
        this.shouldDrawText = true;
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == false) goto L6;
        closeIconRippleMask.setTint(-1);
        return;
    }

    private void applyChildDrawable(@Nullable Drawable r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.setCallback(this);
        DrawableCompat.setLayoutDirection(r3, DrawableCompat.getLayoutDirection(this));
        r3.setLevel(getLevel());
        r3.setVisible(isVisible(), false);
        if (r3 != this.closeIcon) goto L12;
        if (r3.isStateful() == false) goto L9;
        r3.setState(getCloseIconState());
    L9:
        DrawableCompat.setTintList(r3, this.closeIconTint);
        return;
    L12:
        if (r3.isStateful() == false) goto L14;
        r3.setState(getState());
    L14:
        Drawable r0 = this.chipIcon;
        if (r3 == r0) goto L17;
        return;
    L17:
        if (this.hasChipIconTint == false) goto L21;
        DrawableCompat.setTintList(r0, this.chipIconTint);
        return;
    }

    private void calculateChipIconBounds(@NonNull Rect r3, @NonNull RectF r4) {
        r4.setEmpty();
        if (showsChipIcon() == false) goto L5;
    L6:
        float r0 = this.chipStartPadding + this.iconStartPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L9;
        float r1 = r3.left + r0;
        r4.left = r1;
        r4.right = r1 + this.chipIconSize;
    L10:
        float r5 = r3.exactCenterY();
        float r2 = this.chipIconSize;
        float r6 = r5 - (r2 / 2.0f);
        r4.top = r6;
        r4.bottom = r6 + r2;
        return;
    L9:
        float r7 = r3.right - r0;
        r4.right = r7;
        r4.left = r7 - this.chipIconSize;
        goto L10
    L5:
        if (showsCheckedIcon() == true) goto L6;
    }

    private void calculateChipTouchBounds(@NonNull Rect r3, @NonNull RectF r4) {
        r4.set(r3);
        if (showsCloseIcon() == false) goto L9;
        float r0 = (((this.chipEndPadding + this.closeIconEndPadding) + this.closeIconSize) + this.closeIconStartPadding) + this.textEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        r4.right = r3.right - r0;
        return;
    L7:
        r4.left = r3.left + r0;
        return;
    }

    private void calculateCloseIconBounds(@NonNull Rect r3, @NonNull RectF r4) {
        r4.setEmpty();
        if (showsCloseIcon() == false) goto L10;
        float r0 = this.chipEndPadding + this.closeIconEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        float r1 = r3.right - r0;
        r4.right = r1;
        r4.left = r1 - this.closeIconSize;
    L8:
        float r5 = r3.exactCenterY();
        float r2 = this.closeIconSize;
        float r6 = r5 - (r2 / 2.0f);
        r4.top = r6;
        r4.bottom = r6 + r2;
        return;
    L7:
        float r7 = r3.left + r0;
        r4.left = r7;
        r4.right = r7 + this.closeIconSize;
        goto L8
    }

    private void calculateCloseIconTouchBounds(@NonNull Rect r3, @NonNull RectF r4) {
        r4.setEmpty();
        if (showsCloseIcon() == false) goto L10;
        float r0 = (((this.chipEndPadding + this.closeIconEndPadding) + this.closeIconSize) + this.closeIconStartPadding) + this.textEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        float r2 = r3.right;
        r4.right = r2;
        r4.left = r2 - r0;
    L8:
        r4.top = r3.top;
        r4.bottom = r3.bottom;
        return;
    L7:
        int r5 = r3.left;
        r4.left = r5;
        r4.right = r5 + r0;
        goto L8
    }

    private void calculateTextBounds(@NonNull Rect r4, @NonNull RectF r5) {
        r5.setEmpty();
        if (this.text == null) goto L10;
        float r1 = (calculateChipIconWidth() + this.chipStartPadding) + this.textStartPadding;
        float r2 = (calculateCloseIconWidth() + this.chipEndPadding) + this.textEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        r5.left = r4.left + r1;
        r5.right = r4.right - r2;
    L8:
        r5.top = r4.top;
        r5.bottom = r4.bottom;
        return;
    L7:
        r5.left = r4.left + r2;
        r5.right = r4.right - r1;
        goto L8
    }

    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
        Paint.FontMetrics r2 = this.fontMetrics;
        return (r2.descent + r2.ascent) / 2.0f;
    }

    private boolean canShowCheckedIcon() {
        if (this.checkedIconVisible == true) goto L5;
    L9:
        return false;
    L5:
        if (this.checkedIcon == null) goto L9;
        if (this.checkable == false) goto L9;
        return true;
    }

    @NonNull
    public static ChipDrawable createFromAttributes(@NonNull Context r1, @Nullable AttributeSet r2, @AttrRes int r3, @StyleRes int r4) {
        ChipDrawable r0 = new ChipDrawable(r1, r2, r3, r4);
        r0.loadFromAttributes(r2, r3, r4);
        return r0;
    }

    @NonNull
    public static ChipDrawable createFromResource(@NonNull Context r2, @XmlRes int r3) {
        AttributeSet r4 = DrawableUtils.parseDrawableXml(r2, r3, "chip");
        int r0 = r4.getStyleAttribute();
        if (r0 != 0) goto L6;
        r0 = com.google.android.material.R.style.Widget_MaterialComponents_Chip_Entry;
    L6:
        return createFromAttributes(r2, r4, com.google.android.material.R.attr.chipStandaloneStyle, r0);
    }

    private void drawCheckedIcon(@NonNull Canvas r6, @NonNull Rect r7) {
        if (showsCheckedIcon() == false) goto L6;
        calculateChipIconBounds(r7, this.rectF);
        RectF r8 = this.rectF;
        float r0 = r8.left;
        float r9 = r8.top;
        r6.translate(r0, r9);
        this.checkedIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
        this.checkedIcon.draw(r6);
        r6.translate(-r0, -r9);
        return;
    }

    private void drawChipBackground(@NonNull Canvas r3, @NonNull Rect r4) {
        if (this.isShapeThemingEnabled == true) goto L6;
        this.chipPaint.setColor(this.currentChipBackgroundColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.chipPaint.setColorFilter(getTintColorFilter());
        this.rectF.set(r4);
        r3.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        return;
    }

    private void drawChipIcon(@NonNull Canvas r6, @NonNull Rect r7) {
        if (showsChipIcon() == false) goto L6;
        calculateChipIconBounds(r7, this.rectF);
        RectF r8 = this.rectF;
        float r0 = r8.left;
        float r9 = r8.top;
        r6.translate(r0, r9);
        this.chipIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
        this.chipIcon.draw(r6);
        r6.translate(-r0, -r9);
        return;
    }

    private void drawChipStroke(@NonNull Canvas r8, @NonNull Rect r9) {
        if (this.chipStrokeWidth > 0.0f) goto L5;
        return;
    L5:
        if (this.isShapeThemingEnabled == true) goto L12;
        this.chipPaint.setColor(this.currentChipStrokeColor);
        this.chipPaint.setStyle(Paint.Style.STROKE);
        if (this.isShapeThemingEnabled == true) goto L9;
        this.chipPaint.setColorFilter(getTintColorFilter());
    L9:
        RectF r0 = this.rectF;
        float r1 = r9.left;
        float r2 = this.chipStrokeWidth;
        r0.set((r2 / 2.0f) + r1, (r2 / 2.0f) + r9.top, r9.right - (r2 / 2.0f), r9.bottom - (r2 / 2.0f));
        float r10 = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
        r8.drawRoundRect(this.rectF, r10, r10, this.chipPaint);
        return;
    }

    private void drawChipSurface(@NonNull Canvas r3, @NonNull Rect r4) {
        if (this.isShapeThemingEnabled == true) goto L6;
        this.chipPaint.setColor(this.currentChipSurfaceColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.rectF.set(r4);
        r3.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        return;
    }

    private void drawCloseIcon(@NonNull Canvas r6, @NonNull Rect r7) {
        if (showsCloseIcon() == false) goto L10;
        calculateCloseIconBounds(r7, this.rectF);
        RectF r8 = this.rectF;
        float r0 = r8.left;
        float r9 = r8.top;
        r6.translate(r0, r9);
        this.closeIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == false) goto L7;
        this.closeIconRipple.setBounds(this.closeIcon.getBounds());
        this.closeIconRipple.jumpToCurrentState();
        this.closeIconRipple.draw(r6);
    L8:
        r6.translate(-r0, -r9);
        return;
    L7:
        this.closeIcon.draw(r6);
        goto L8
    }

    private void drawCompatRipple(@NonNull Canvas r3, @NonNull Rect r4) {
        this.chipPaint.setColor(this.currentCompatRippleColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.rectF.set(r4);
        if (this.isShapeThemingEnabled == true) goto L5;
        r3.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        return;
    L5:
        calculatePathForSize(new RectF(r4), this.shapePath);
        super.drawShape(r3, this.chipPaint, this.shapePath, getBoundsAsRectF());
    }

    private void drawDebug(@NonNull Canvas r10, @NonNull Rect r11) {
        Paint r0 = this.debugPaint;
        if (r0 == null) goto L17;
        r0.setColor(ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, 127));
        r10.drawRect(r11, this.debugPaint);
        if (showsChipIcon() == false) goto L7;
    L8:
        calculateChipIconBounds(r11, this.rectF);
        r10.drawRect(this.rectF, this.debugPaint);
    L10:
        if (this.text == null) goto L13;
        r10.drawLine(r11.left, r11.exactCenterY(), r11.right, r11.exactCenterY(), this.debugPaint);
    L13:
        if (showsCloseIcon() == false) goto L15;
        calculateCloseIconBounds(r11, this.rectF);
        r10.drawRect(this.rectF, this.debugPaint);
    L15:
        this.debugPaint.setColor(ColorUtils.setAlphaComponent(SupportMenu.CATEGORY_MASK, 127));
        calculateChipTouchBounds(r11, this.rectF);
        r10.drawRect(this.rectF, this.debugPaint);
        this.debugPaint.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
        calculateCloseIconTouchBounds(r11, this.rectF);
        r10.drawRect(this.rectF, this.debugPaint);
        return;
    L7:
        if (showsCheckedIcon() == false) goto L10;
    }

    private void drawText(@NonNull Canvas r10, @NonNull Rect r11) {
        if (this.text == null) goto L22;
        Paint.Align r0 = calculateTextOriginAndAlignment(r11, this.pointF);
        calculateTextBounds(r11, this.rectF);
        if (this.textDrawableHelper.getTextAppearance() == null) goto L7;
        this.textDrawableHelper.getTextPaint().drawableState = getState();
        this.textDrawableHelper.updateTextPaintDrawState(this.context);
    L7:
        this.textDrawableHelper.getTextPaint().setTextAlign(r0);
        int r1 = 0;
        if (Math.round(this.textDrawableHelper.getTextWidth(getText().toString())) <= Math.round(this.rectF.width())) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == false) goto L13;
        r1 = r10.save();
        r10.clipRect(this.rectF);
    L13:
        CharSequence r2 = this.text;
        if (r12 == true) goto L16;
    L18:
        CharSequence r3 = r2;
        int r5 = r3.length();
        PointF r4 = this.pointF;
        r10.drawText(r3, 0, r5, r4.x, r4.y, this.textDrawableHelper.getTextPaint());
        if (r12 == false) goto L23;
        r10.restoreToCount(r1);
        return;
    L23:
        return;
    L16:
        if (this.truncateAt == null) goto L18;
        r2 = TextUtils.ellipsize(r2, this.textDrawableHelper.getTextPaint(), this.rectF.width(), this.truncateAt);
        goto L18
    L10:
        r12 = false;
        goto L11
    }

    @Nullable
    private ColorFilter getTintColorFilter() {
        ColorFilter r0 = this.colorFilter;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.tintFilter;
    }

    private static boolean hasState(@Nullable int[] r4, @AttrRes int r5) {
        if (r4 != null) goto L5;
        return false;
    L5:
        int r1 = r4.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        if (r4[r2] == r5) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private void loadFromAttributes(@Nullable AttributeSet r8, @AttrRes int r9, @StyleRes int r10) {
        TypedArray r11 = ThemeEnforcement.obtainStyledAttributes(this.context, r8, com.google.android.material.R.styleable.Chip, r9, r10, new int[0]);
        this.isShapeThemingEnabled = r11.hasValue(com.google.android.material.R.styleable.Chip_shapeAppearance);
        setChipSurfaceColor(MaterialResources.getColorStateList(this.context, r11, com.google.android.material.R.styleable.Chip_chipSurfaceColor));
        setChipBackgroundColor(MaterialResources.getColorStateList(this.context, r11, com.google.android.material.R.styleable.Chip_chipBackgroundColor));
        setChipMinHeight(r11.getDimension(com.google.android.material.R.styleable.Chip_chipMinHeight, 0.0f));
        if (r11.hasValue(com.google.android.material.R.styleable.Chip_chipCornerRadius) == false) goto L5;
        setChipCornerRadius(r11.getDimension(com.google.android.material.R.styleable.Chip_chipCornerRadius, 0.0f));
    L5:
        setChipStrokeColor(MaterialResources.getColorStateList(this.context, r11, com.google.android.material.R.styleable.Chip_chipStrokeColor));
        setChipStrokeWidth(r11.getDimension(com.google.android.material.R.styleable.Chip_chipStrokeWidth, 0.0f));
        setRippleColor(MaterialResources.getColorStateList(this.context, r11, com.google.android.material.R.styleable.Chip_rippleColor));
        setText(r11.getText(com.google.android.material.R.styleable.Chip_android_text));
        setTextAppearance(MaterialResources.getTextAppearance(this.context, r11, com.google.android.material.R.styleable.Chip_android_textAppearance));
        int r12 = r11.getInt(com.google.android.material.R.styleable.Chip_android_ellipsize, 0);
        if (r12 != 1) goto L8;
        setEllipsize(TextUtils.TruncateAt.START);
    L15:
        setChipIconVisible(r11.getBoolean(com.google.android.material.R.styleable.Chip_chipIconVisible, false));
        if (r8 != null) goto L18;
    L22:
        setChipIcon(MaterialResources.getDrawable(this.context, r11, com.google.android.material.R.styleable.Chip_chipIcon));
        if (r11.hasValue(com.google.android.material.R.styleable.Chip_chipIconTint) == false) goto L25;
        setChipIconTint(MaterialResources.getColorStateList(this.context, r11, com.google.android.material.R.styleable.Chip_chipIconTint));
    L25:
        setChipIconSize(r11.getDimension(com.google.android.material.R.styleable.Chip_chipIconSize, 0.0f));
        setCloseIconVisible(r11.getBoolean(com.google.android.material.R.styleable.Chip_closeIconVisible, false));
        if (r8 != null) goto L28;
    L32:
        setCloseIcon(MaterialResources.getDrawable(this.context, r11, com.google.android.material.R.styleable.Chip_closeIcon));
        setCloseIconTint(MaterialResources.getColorStateList(this.context, r11, com.google.android.material.R.styleable.Chip_closeIconTint));
        setCloseIconSize(r11.getDimension(com.google.android.material.R.styleable.Chip_closeIconSize, 0.0f));
        setCheckable(r11.getBoolean(com.google.android.material.R.styleable.Chip_android_checkable, false));
        setCheckedIconVisible(r11.getBoolean(com.google.android.material.R.styleable.Chip_checkedIconVisible, false));
        if (r8 != null) goto L35;
    L39:
        setCheckedIcon(MaterialResources.getDrawable(this.context, r11, com.google.android.material.R.styleable.Chip_checkedIcon));
        if (r11.hasValue(com.google.android.material.R.styleable.Chip_checkedIconTint) == false) goto L42;
        setCheckedIconTint(MaterialResources.getColorStateList(this.context, r11, com.google.android.material.R.styleable.Chip_checkedIconTint));
    L42:
        setShowMotionSpec(MotionSpec.createFromAttribute(this.context, r11, com.google.android.material.R.styleable.Chip_showMotionSpec));
        setHideMotionSpec(MotionSpec.createFromAttribute(this.context, r11, com.google.android.material.R.styleable.Chip_hideMotionSpec));
        setChipStartPadding(r11.getDimension(com.google.android.material.R.styleable.Chip_chipStartPadding, 0.0f));
        setIconStartPadding(r11.getDimension(com.google.android.material.R.styleable.Chip_iconStartPadding, 0.0f));
        setIconEndPadding(r11.getDimension(com.google.android.material.R.styleable.Chip_iconEndPadding, 0.0f));
        setTextStartPadding(r11.getDimension(com.google.android.material.R.styleable.Chip_textStartPadding, 0.0f));
        setTextEndPadding(r11.getDimension(com.google.android.material.R.styleable.Chip_textEndPadding, 0.0f));
        setCloseIconStartPadding(r11.getDimension(com.google.android.material.R.styleable.Chip_closeIconStartPadding, 0.0f));
        setCloseIconEndPadding(r11.getDimension(com.google.android.material.R.styleable.Chip_closeIconEndPadding, 0.0f));
        setChipEndPadding(r11.getDimension(com.google.android.material.R.styleable.Chip_chipEndPadding, 0.0f));
        setMaxWidth(r11.getDimensionPixelSize(com.google.android.material.R.styleable.Chip_android_maxWidth, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
        r11.recycle();
        return;
    L35:
        if (r8.getAttributeValue(NAMESPACE_APP, "checkedIconEnabled") == null) goto L39;
        if (r8.getAttributeValue(NAMESPACE_APP, "checkedIconVisible") != null) goto L39;
        setCheckedIconVisible(r11.getBoolean(com.google.android.material.R.styleable.Chip_checkedIconEnabled, false));
        goto L39
    L28:
        if (r8.getAttributeValue(NAMESPACE_APP, "closeIconEnabled") == null) goto L32;
        if (r8.getAttributeValue(NAMESPACE_APP, "closeIconVisible") != null) goto L32;
        setCloseIconVisible(r11.getBoolean(com.google.android.material.R.styleable.Chip_closeIconEnabled, false));
        goto L32
    L18:
        if (r8.getAttributeValue(NAMESPACE_APP, "chipIconEnabled") == null) goto L22;
        if (r8.getAttributeValue(NAMESPACE_APP, "chipIconVisible") != null) goto L22;
        setChipIconVisible(r11.getBoolean(com.google.android.material.R.styleable.Chip_chipIconEnabled, false));
        goto L22
    L8:
        if (r12 != 2) goto L10;
        setEllipsize(TextUtils.TruncateAt.MIDDLE);
        goto L15
    L10:
        if (r12 != 3) goto L15;
        setEllipsize(TextUtils.TruncateAt.END);
        goto L15
    }

    private void setChipSurfaceColor(@Nullable ColorStateList r2) {
        if (this.chipSurfaceColor == r2) goto L6;
        this.chipSurfaceColor = r2;
        onStateChange(getState());
        return;
    }

    private boolean showsCheckedIcon() {
        if (this.checkedIconVisible == true) goto L5;
    L9:
        return false;
    L5:
        if (this.checkedIcon == null) goto L9;
        if (this.currentChecked == false) goto L9;
        return true;
    }

    private boolean showsChipIcon() {
        if (this.chipIconVisible == true) goto L5;
    L7:
        return false;
    L5:
        if (this.chipIcon == null) goto L7;
        return true;
    }

    private boolean showsCloseIcon() {
        if (this.closeIconVisible == true) goto L5;
    L7:
        return false;
    L5:
        if (this.closeIcon == null) goto L7;
        return true;
    }

    private void unapplyChildDrawable(@Nullable Drawable r1) {
        if (r1 == null) goto L5;
        r1.setCallback(null);
        return;
    }

    private void updateCompatRippleColor() {
        if (this.useCompatRipple == false) goto L5;
        ColorStateList r0 = RippleUtils.sanitizeRippleDrawableColor(this.rippleColor);
    L6:
        this.compatRippleColor = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    @TargetApi(21)
    private void updateFrameworkCloseIconRipple() {
        this.closeIconRipple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(getRippleColor()), this.closeIcon, closeIconRippleMask);
    }

    public float calculateChipIconWidth() {
        if (showsChipIcon() == true) goto L10;
        if (showsCheckedIcon() == true) goto L10;
        return 0.0f;
    L10:
        return (this.iconStartPadding + this.chipIconSize) + this.iconEndPadding;
    }

    public float calculateCloseIconWidth() {
        if (showsCloseIcon() == true) goto L5;
        return 0.0f;
    L5:
        return (this.closeIconStartPadding + this.closeIconSize) + this.closeIconEndPadding;
    }

    @NonNull
    public Paint.Align calculateTextOriginAndAlignment(@NonNull Rect r4, @NonNull PointF r5) {
        r5.set(0.0f, 0.0f);
        Paint.Align r0 = Paint.Align.LEFT;
        if (this.text == null) goto L9;
        float r2 = (calculateChipIconWidth() + this.chipStartPadding) + this.textStartPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        r5.x = r4.left + r2;
    L8:
        r5.y = r4.centerY() - calculateTextCenterFromBaseline();
        goto L9
    L7:
        r5.x = r4.right - r2;
        r0 = Paint.Align.RIGHT;
    L9:
        return r0;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r9) {
        Rect r0 = getBounds();
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        if (getAlpha() == 0) goto L23;
        int r7 = this.alpha;
        if (r7 >= 255) goto L10;
        int r2 = CanvasCompat.saveLayerAlpha(r9, r0.left, r0.top, r0.right, r0.bottom, r7);
    L11:
        drawChipSurface(r9, r0);
        drawChipBackground(r9, r0);
        if (this.isShapeThemingEnabled == false) goto L14;
        super.draw(r9);
    L14:
        drawChipStroke(r9, r0);
        drawCompatRipple(r9, r0);
        drawChipIcon(r9, r0);
        drawCheckedIcon(r9, r0);
        if (this.shouldDrawText == false) goto L17;
        drawText(r9, r0);
    L17:
        drawCloseIcon(r9, r0);
        drawDebug(r9, r0);
        if (this.alpha >= 255) goto L22;
        r9.restoreToCount(r2);
        return;
    L22:
        return;
    L10:
        r2 = 0;
        goto L11
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        return this.chipBackgroundColor;
    }

    public float getChipCornerRadius() {
        if (this.isShapeThemingEnabled == false) goto L6;
        return getTopLeftCornerResolvedSize();
    L6:
        return this.chipCornerRadius;
    }

    public float getChipEndPadding() {
        return this.chipEndPadding;
    }

    @Nullable
    public Drawable getChipIcon() {
        Drawable r0 = this.chipIcon;
        if (r0 != null) goto L7;
        return null;
    L7:
        return DrawableCompat.unwrap(r0);
    }

    public float getChipIconSize() {
        return this.chipIconSize;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        return this.chipIconTint;
    }

    public float getChipMinHeight() {
        return this.chipMinHeight;
    }

    public float getChipStartPadding() {
        return this.chipStartPadding;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        return this.chipStrokeColor;
    }

    public float getChipStrokeWidth() {
        return this.chipStrokeWidth;
    }

    public void getChipTouchBounds(@NonNull RectF r2) {
        calculateChipTouchBounds(getBounds(), r2);
    }

    @Nullable
    public Drawable getCloseIcon() {
        Drawable r0 = this.closeIcon;
        if (r0 != null) goto L7;
        return null;
    L7:
        return DrawableCompat.unwrap(r0);
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        return this.closeIconContentDescription;
    }

    public float getCloseIconEndPadding() {
        return this.closeIconEndPadding;
    }

    public float getCloseIconSize() {
        return this.closeIconSize;
    }

    public float getCloseIconStartPadding() {
        return this.closeIconStartPadding;
    }

    @NonNull
    public int[] getCloseIconState() {
        return this.closeIconStateSet;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        return this.closeIconTint;
    }

    public void getCloseIconTouchBounds(@NonNull RectF r2) {
        calculateCloseIconTouchBounds(getBounds(), r2);
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public TextUtils.TruncateAt getEllipsize() {
        return this.truncateAt;
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    public float getIconEndPadding() {
        return this.iconEndPadding;
    }

    public float getIconStartPadding() {
        return this.iconStartPadding;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.chipMinHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        float r0 = this.chipStartPadding;
        float r1 = (calculateChipIconWidth() + r0) + this.textStartPadding;
        float r2 = (this.textDrawableHelper.getTextWidth(getText().toString()) + r1) + this.textEndPadding;
        return Math.min(Math.round((calculateCloseIconWidth() + r2) + this.chipEndPadding), this.maxWidth);
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline r9) {
        if (this.isShapeThemingEnabled == false) goto L6;
        super.getOutline(r9);
        return;
    L6:
        Rect r0 = getBounds();
        if (r0.isEmpty() == true) goto L9;
        r9.setRoundRect(r0, this.chipCornerRadius);
    L10:
        r9.setAlpha(getAlpha() / 255.0f);
        return;
    L9:
        r9.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.chipCornerRadius);
        goto L10
    }

    @Nullable
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    @Nullable
    public CharSequence getText() {
        return this.text;
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        return this.textDrawableHelper.getTextAppearance();
    }

    public float getTextEndPadding() {
        return this.textEndPadding;
    }

    public float getTextStartPadding() {
        return this.textStartPadding;
    }

    public boolean getUseCompatRipple() {
        return this.useCompatRipple;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable r1) {
        Drawable.Callback r2 = getCallback();
        if (r2 == null) goto L6;
        r2.invalidateDrawable(this);
        return;
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        return this.checkedIconVisible;
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        return this.chipIconVisible;
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public boolean isCloseIconStateful() {
        return isStateful(this.closeIcon);
    }

    public boolean isCloseIconVisible() {
        return this.closeIconVisible;
    }

    public boolean isShapeThemingEnabled() {
        return this.isShapeThemingEnabled;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (isStateful(this.chipSurfaceColor) == false) goto L5;
    L24:
        return true;
    L5:
        if (isStateful(this.chipBackgroundColor) == true) goto L24;
        if (isStateful(this.chipStrokeColor) == true) goto L24;
        if (this.useCompatRipple == false) goto L13;
        if (isStateful(this.compatRippleColor) == true) goto L24;
    L13:
        if (isStateful(this.textDrawableHelper.getTextAppearance()) == true) goto L24;
        if (canShowCheckedIcon() == true) goto L24;
        if (isStateful(this.chipIcon) == true) goto L24;
        if (isStateful(this.checkedIcon) == true) goto L24;
        if (isStateful(this.tint) == true) goto L24;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int r3) {
        boolean r0 = super.onLayoutDirectionChanged(r3);
        if (showsChipIcon() == false) goto L6;
        r0 = r0 | DrawableCompat.setLayoutDirection(this.chipIcon, r3);
    L6:
        if (showsCheckedIcon() == false) goto L9;
        r0 = r0 | DrawableCompat.setLayoutDirection(this.checkedIcon, r3);
    L9:
        if (showsCloseIcon() == false) goto L11;
        r0 = r0 | DrawableCompat.setLayoutDirection(this.closeIcon, r3);
    L11:
        if (r0 == false) goto L15;
        invalidateSelf();
        return true;
    L15:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r3) {
        boolean r0 = super.onLevelChange(r3);
        if (showsChipIcon() == false) goto L6;
        r0 = r0 | this.chipIcon.setLevel(r3);
    L6:
        if (showsCheckedIcon() == false) goto L9;
        r0 = r0 | this.checkedIcon.setLevel(r3);
    L9:
        if (showsCloseIcon() == false) goto L11;
        r0 = r0 | this.closeIcon.setLevel(r3);
    L11:
        if (r0 == false) goto L13;
        invalidateSelf();
    L13:
        return r0;
    }

    public void onSizeChange() {
        Delegate r0 = this.delegate.get();
        if (r0 == null) goto L6;
        r0.onChipDrawableSizeChange();
        return;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(@NonNull int[] r2) {
        if (this.isShapeThemingEnabled == false) goto L6;
        super.onStateChange(r2);
    L6:
        return onStateChange(r2, getCloseIconState());
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        onSizeChange();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable r1, @NonNull Runnable r2, long r3) {
        Drawable.Callback r4 = getCallback();
        if (r4 == null) goto L6;
        r4.scheduleDrawable(this, r2, r3);
        return;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        if (this.alpha == r2) goto L6;
        this.alpha = r2;
        invalidateSelf();
        return;
    }

    public void setCheckable(boolean r2) {
        if (this.checkable == r2) goto L13;
        this.checkable = r2;
        float r0 = calculateChipIconWidth();
        if (r2 == false) goto L7;
    L9:
        float r3 = calculateChipIconWidth();
        invalidateSelf();
        if (r0 == r3) goto L14;
        onSizeChange();
        return;
    L14:
        return;
    L7:
        if (this.currentChecked == false) goto L9;
        this.currentChecked = false;
        goto L9
    }

    public void setCheckableResource(@BoolRes int r2) {
        setCheckable(this.context.getResources().getBoolean(r2));
    }

    public void setCheckedIcon(@Nullable Drawable r3) {
        if (this.checkedIcon == r3) goto L8;
        float r0 = calculateChipIconWidth();
        this.checkedIcon = r3;
        float r4 = calculateChipIconWidth();
        unapplyChildDrawable(this.checkedIcon);
        applyChildDrawable(this.checkedIcon);
        invalidateSelf();
        if (r0 == r4) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean r1) {
        setCheckedIconVisible(r1);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int r2) {
        setCheckedIconVisible(this.context.getResources().getBoolean(r2));
    }

    public void setCheckedIconResource(@DrawableRes int r2) {
        setCheckedIcon(AppCompatResources.getDrawable(this.context, r2));
    }

    public void setCheckedIconTint(@Nullable ColorStateList r2) {
        if (this.checkedIconTint == r2) goto L9;
        this.checkedIconTint = r2;
        if (canShowCheckedIcon() == false) goto L7;
        DrawableCompat.setTintList(this.checkedIcon, r2);
    L7:
        onStateChange(getState());
        return;
    }

    public void setCheckedIconTintResource(@ColorRes int r2) {
        setCheckedIconTint(AppCompatResources.getColorStateList(this.context, r2));
    }

    public void setCheckedIconVisible(@BoolRes int r2) {
        setCheckedIconVisible(this.context.getResources().getBoolean(r2));
    }

    public void setChipBackgroundColor(@Nullable ColorStateList r2) {
        if (this.chipBackgroundColor == r2) goto L6;
        this.chipBackgroundColor = r2;
        onStateChange(getState());
        return;
    }

    public void setChipBackgroundColorResource(@ColorRes int r2) {
        setChipBackgroundColor(AppCompatResources.getColorStateList(this.context, r2));
    }

    @Deprecated
    public void setChipCornerRadius(float r2) {
        if (this.chipCornerRadius == r2) goto L6;
        this.chipCornerRadius = r2;
        setShapeAppearanceModel(getShapeAppearanceModel().withCornerSize(r2));
        return;
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int r2) {
        setChipCornerRadius(this.context.getResources().getDimension(r2));
    }

    public void setChipEndPadding(float r2) {
        if (this.chipEndPadding == r2) goto L6;
        this.chipEndPadding = r2;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setChipEndPaddingResource(@DimenRes int r2) {
        setChipEndPadding(this.context.getResources().getDimension(r2));
    }

    public void setChipIcon(@Nullable Drawable r3) {
        Drawable r0 = getChipIcon();
        if (r0 == r3) goto L15;
        float r1 = calculateChipIconWidth();
        if (r3 == null) goto L7;
        Drawable r4 = DrawableCompat.wrap(r3).mutate();
    L8:
        this.chipIcon = r4;
        float r5 = calculateChipIconWidth();
        unapplyChildDrawable(r0);
        if (showsChipIcon() == false) goto L11;
        applyChildDrawable(this.chipIcon);
    L11:
        invalidateSelf();
        if (r1 == r5) goto L16;
        onSizeChange();
        return;
    L16:
        return;
    L7:
        r4 = null;
        goto L8
    }

    @Deprecated
    public void setChipIconEnabled(boolean r1) {
        setChipIconVisible(r1);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int r1) {
        setChipIconVisible(r1);
    }

    public void setChipIconResource(@DrawableRes int r2) {
        setChipIcon(AppCompatResources.getDrawable(this.context, r2));
    }

    public void setChipIconSize(float r2) {
        if (this.chipIconSize == r2) goto L8;
        float r0 = calculateChipIconWidth();
        this.chipIconSize = r2;
        float r3 = calculateChipIconWidth();
        invalidateSelf();
        if (r0 == r3) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setChipIconSizeResource(@DimenRes int r2) {
        setChipIconSize(this.context.getResources().getDimension(r2));
    }

    public void setChipIconTint(@Nullable ColorStateList r2) {
        this.hasChipIconTint = true;
        if (this.chipIconTint == r2) goto L9;
        this.chipIconTint = r2;
        if (showsChipIcon() == false) goto L7;
        DrawableCompat.setTintList(this.chipIcon, r2);
    L7:
        onStateChange(getState());
        return;
    }

    public void setChipIconTintResource(@ColorRes int r2) {
        setChipIconTint(AppCompatResources.getColorStateList(this.context, r2));
    }

    public void setChipIconVisible(@BoolRes int r2) {
        setChipIconVisible(this.context.getResources().getBoolean(r2));
    }

    public void setChipMinHeight(float r2) {
        if (this.chipMinHeight == r2) goto L6;
        this.chipMinHeight = r2;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setChipMinHeightResource(@DimenRes int r2) {
        setChipMinHeight(this.context.getResources().getDimension(r2));
    }

    public void setChipStartPadding(float r2) {
        if (this.chipStartPadding == r2) goto L6;
        this.chipStartPadding = r2;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setChipStartPaddingResource(@DimenRes int r2) {
        setChipStartPadding(this.context.getResources().getDimension(r2));
    }

    public void setChipStrokeColor(@Nullable ColorStateList r2) {
        if (this.chipStrokeColor == r2) goto L9;
        this.chipStrokeColor = r2;
        if (this.isShapeThemingEnabled == false) goto L7;
        setStrokeColor(r2);
    L7:
        onStateChange(getState());
        return;
    }

    public void setChipStrokeColorResource(@ColorRes int r2) {
        setChipStrokeColor(AppCompatResources.getColorStateList(this.context, r2));
    }

    public void setChipStrokeWidth(float r2) {
        if (this.chipStrokeWidth == r2) goto L9;
        this.chipStrokeWidth = r2;
        this.chipPaint.setStrokeWidth(r2);
        if (this.isShapeThemingEnabled == false) goto L7;
        super.setStrokeWidth(r2);
    L7:
        invalidateSelf();
        return;
    }

    public void setChipStrokeWidthResource(@DimenRes int r2) {
        setChipStrokeWidth(this.context.getResources().getDimension(r2));
    }

    public void setCloseIcon(@Nullable Drawable r3) {
        Drawable r0 = getCloseIcon();
        if (r0 == r3) goto L18;
        float r1 = calculateCloseIconWidth();
        if (r3 == null) goto L7;
        Drawable r4 = DrawableCompat.wrap(r3).mutate();
    L8:
        this.closeIcon = r4;
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == false) goto L11;
        updateFrameworkCloseIconRipple();
    L11:
        float r5 = calculateCloseIconWidth();
        unapplyChildDrawable(r0);
        if (showsCloseIcon() == false) goto L14;
        applyChildDrawable(this.closeIcon);
    L14:
        invalidateSelf();
        if (r1 == r5) goto L19;
        onSizeChange();
        return;
    L19:
        return;
    L7:
        r4 = null;
        goto L8
    }

    public void setCloseIconContentDescription(@Nullable CharSequence r2) {
        if (this.closeIconContentDescription == r2) goto L6;
        this.closeIconContentDescription = BidiFormatter.getInstance().unicodeWrap(r2);
        invalidateSelf();
        return;
    }

    @Deprecated
    public void setCloseIconEnabled(boolean r1) {
        setCloseIconVisible(r1);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int r1) {
        setCloseIconVisible(r1);
    }

    public void setCloseIconEndPadding(float r2) {
        if (this.closeIconEndPadding == r2) goto L8;
        this.closeIconEndPadding = r2;
        invalidateSelf();
        if (showsCloseIcon() == false) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setCloseIconEndPaddingResource(@DimenRes int r2) {
        setCloseIconEndPadding(this.context.getResources().getDimension(r2));
    }

    public void setCloseIconResource(@DrawableRes int r2) {
        setCloseIcon(AppCompatResources.getDrawable(this.context, r2));
    }

    public void setCloseIconSize(float r2) {
        if (this.closeIconSize == r2) goto L8;
        this.closeIconSize = r2;
        invalidateSelf();
        if (showsCloseIcon() == false) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setCloseIconSizeResource(@DimenRes int r2) {
        setCloseIconSize(this.context.getResources().getDimension(r2));
    }

    public void setCloseIconStartPadding(float r2) {
        if (this.closeIconStartPadding == r2) goto L8;
        this.closeIconStartPadding = r2;
        invalidateSelf();
        if (showsCloseIcon() == false) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setCloseIconStartPaddingResource(@DimenRes int r2) {
        setCloseIconStartPadding(this.context.getResources().getDimension(r2));
    }

    public boolean setCloseIconState(@NonNull int[] r2) {
        if (Arrays.equals(this.closeIconStateSet, r2) == true) goto L8;
        this.closeIconStateSet = r2;
        if (showsCloseIcon() == true) goto L7;
        return false;
    L7:
        return onStateChange(getState(), r2);
    L8:
        return false;
    }

    public void setCloseIconTint(@Nullable ColorStateList r2) {
        if (this.closeIconTint == r2) goto L9;
        this.closeIconTint = r2;
        if (showsCloseIcon() == false) goto L7;
        DrawableCompat.setTintList(this.closeIcon, r2);
    L7:
        onStateChange(getState());
        return;
    }

    public void setCloseIconTintResource(@ColorRes int r2) {
        setCloseIconTint(AppCompatResources.getColorStateList(this.context, r2));
    }

    public void setCloseIconVisible(@BoolRes int r2) {
        setCloseIconVisible(this.context.getResources().getBoolean(r2));
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r2) {
        if (this.colorFilter == r2) goto L6;
        this.colorFilter = r2;
        invalidateSelf();
        return;
    }

    public void setDelegate(@Nullable Delegate r2) {
        this.delegate = new WeakReference(r2);
    }

    public void setEllipsize(@Nullable TextUtils.TruncateAt r1) {
        this.truncateAt = r1;
    }

    public void setHideMotionSpec(@Nullable MotionSpec r1) {
        this.hideMotionSpec = r1;
    }

    public void setHideMotionSpecResource(@AnimatorRes int r2) {
        setHideMotionSpec(MotionSpec.createFromResource(this.context, r2));
    }

    public void setIconEndPadding(float r2) {
        if (this.iconEndPadding == r2) goto L8;
        float r0 = calculateChipIconWidth();
        this.iconEndPadding = r2;
        float r3 = calculateChipIconWidth();
        invalidateSelf();
        if (r0 == r3) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setIconEndPaddingResource(@DimenRes int r2) {
        setIconEndPadding(this.context.getResources().getDimension(r2));
    }

    public void setIconStartPadding(float r2) {
        if (this.iconStartPadding == r2) goto L8;
        float r0 = calculateChipIconWidth();
        this.iconStartPadding = r2;
        float r3 = calculateChipIconWidth();
        invalidateSelf();
        if (r0 == r3) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setIconStartPaddingResource(@DimenRes int r2) {
        setIconStartPadding(this.context.getResources().getDimension(r2));
    }

    public void setMaxWidth(@Px int r1) {
        this.maxWidth = r1;
    }

    public void setRippleColor(@Nullable ColorStateList r2) {
        if (this.rippleColor == r2) goto L6;
        this.rippleColor = r2;
        updateCompatRippleColor();
        onStateChange(getState());
        return;
    }

    public void setRippleColorResource(@ColorRes int r2) {
        setRippleColor(AppCompatResources.getColorStateList(this.context, r2));
    }

    public void setShouldDrawText(boolean r1) {
        this.shouldDrawText = r1;
    }

    public void setShowMotionSpec(@Nullable MotionSpec r1) {
        this.showMotionSpec = r1;
    }

    public void setShowMotionSpecResource(@AnimatorRes int r2) {
        setShowMotionSpec(MotionSpec.createFromResource(this.context, r2));
    }

    public void setText(@Nullable CharSequence r2) {
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        if (TextUtils.equals(this.text, r2) == true) goto L8;
        this.text = r2;
        this.textDrawableHelper.setTextWidthDirty(true);
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setTextAppearance(@Nullable TextAppearance r2) {
        this.textDrawableHelper.setTextAppearance(r2, this.context);
    }

    public void setTextAppearanceResource(@StyleRes int r3) {
        setTextAppearance(new TextAppearance(this.context, r3));
    }

    public void setTextEndPadding(float r2) {
        if (this.textEndPadding == r2) goto L6;
        this.textEndPadding = r2;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setTextEndPaddingResource(@DimenRes int r2) {
        setTextEndPadding(this.context.getResources().getDimension(r2));
    }

    public void setTextResource(@StringRes int r2) {
        setText(this.context.getResources().getString(r2));
    }

    public void setTextStartPadding(float r2) {
        if (this.textStartPadding == r2) goto L6;
        this.textStartPadding = r2;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setTextStartPaddingResource(@DimenRes int r2) {
        setTextStartPadding(this.context.getResources().getDimension(r2));
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList r2) {
        if (this.tint == r2) goto L6;
        this.tint = r2;
        onStateChange(getState());
        return;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode r2) {
        if (this.tintMode == r2) goto L6;
        this.tintMode = r2;
        this.tintFilter = DrawableUtils.updateTintFilter(this, this.tint, r2);
        invalidateSelf();
        return;
    }

    public void setUseCompatRipple(boolean r2) {
        if (this.useCompatRipple == r2) goto L6;
        this.useCompatRipple = r2;
        updateCompatRippleColor();
        onStateChange(getState());
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r3, boolean r4) {
        boolean r0 = super.setVisible(r3, r4);
        if (showsChipIcon() == false) goto L6;
        r0 = r0 | this.chipIcon.setVisible(r3, r4);
    L6:
        if (showsCheckedIcon() == false) goto L9;
        r0 = r0 | this.checkedIcon.setVisible(r3, r4);
    L9:
        if (showsCloseIcon() == false) goto L11;
        r0 = r0 | this.closeIcon.setVisible(r3, r4);
    L11:
        if (r0 == false) goto L13;
        invalidateSelf();
    L13:
        return r0;
    }

    public boolean shouldDrawText() {
        return this.shouldDrawText;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable r1, @NonNull Runnable r2) {
        Drawable.Callback r3 = getCallback();
        if (r3 == null) goto L6;
        r3.unscheduleDrawable(this, r2);
        return;
    }

    public void setCheckedIconVisible(boolean r2) {
        if (this.checkedIconVisible == r2) goto L11;
        boolean r0 = showsCheckedIcon();
        this.checkedIconVisible = r2;
        boolean r3 = showsCheckedIcon();
        if (r0 == r3) goto L12;
        if (r3 == false) goto L8;
        applyChildDrawable(this.checkedIcon);
    L9:
        invalidateSelf();
        onSizeChange();
        return;
    L8:
        unapplyChildDrawable(this.checkedIcon);
        goto L9
    L12:
        return;
    }

    public void setChipIconVisible(boolean r2) {
        if (this.chipIconVisible == r2) goto L11;
        boolean r0 = showsChipIcon();
        this.chipIconVisible = r2;
        boolean r3 = showsChipIcon();
        if (r0 == r3) goto L12;
        if (r3 == false) goto L8;
        applyChildDrawable(this.chipIcon);
    L9:
        invalidateSelf();
        onSizeChange();
        return;
    L8:
        unapplyChildDrawable(this.chipIcon);
        goto L9
    L12:
        return;
    }

    public void setCloseIconVisible(boolean r2) {
        if (this.closeIconVisible == r2) goto L11;
        boolean r0 = showsCloseIcon();
        this.closeIconVisible = r2;
        boolean r3 = showsCloseIcon();
        if (r0 == r3) goto L12;
        if (r3 == false) goto L8;
        applyChildDrawable(this.closeIcon);
    L9:
        invalidateSelf();
        onSizeChange();
        return;
    L8:
        unapplyChildDrawable(this.closeIcon);
        goto L9
    L12:
        return;
    }

    private boolean onStateChange(@NonNull int[] r7, @NonNull int[] r8) {
        boolean r0 = super.onStateChange(r7);
        ColorStateList r1 = this.chipSurfaceColor;
        if (r1 == null) goto L5;
        int r2 = r1.getColorForState(r7, this.currentChipSurfaceColor);
    L6:
        boolean r4 = true;
        if (this.currentChipSurfaceColor == r2) goto L9;
        this.currentChipSurfaceColor = r2;
        r0 = true;
    L9:
        ColorStateList r3 = this.chipBackgroundColor;
        if (r3 == null) goto L12;
        int r5 = r3.getColorForState(r7, this.currentChipBackgroundColor);
    L14:
        if (this.currentChipBackgroundColor == r5) goto L16;
        this.currentChipBackgroundColor = r5;
        r0 = true;
    L16:
        int r6 = MaterialColors.layer(r2, r5);
        if (this.currentCompositeSurfaceBackgroundColor == r6) goto L19;
        boolean r9 = true;
    L21:
        if (getFillColor() != null) goto L23;
        boolean r10 = true;
    L25:
        if ((r9 | r10) == false) goto L27;
        this.currentCompositeSurfaceBackgroundColor = r6;
        setFillColor(ColorStateList.valueOf(r6));
        r0 = true;
    L27:
        ColorStateList r11 = this.chipStrokeColor;
        if (r11 == null) goto L30;
        int r12 = r11.getColorForState(r7, this.currentChipStrokeColor);
    L32:
        if (this.currentChipStrokeColor == r12) goto L35;
        this.currentChipStrokeColor = r12;
        r0 = true;
    L35:
        if (this.compatRippleColor != null) goto L37;
    L39:
        int r13 = 0;
    L41:
        if (this.currentCompatRippleColor == r13) goto L46;
        this.currentCompatRippleColor = r13;
        if (this.useCompatRipple == false) goto L46;
        r0 = true;
    L46:
        if (this.textDrawableHelper.getTextAppearance() != null) goto L48;
    L50:
        int r14 = 0;
    L52:
        if (this.currentTextColor == r14) goto L55;
        this.currentTextColor = r14;
        r0 = true;
    L55:
        if (hasState(getState(), R.attr.state_checked) == true) goto L57;
    L59:
        boolean r15 = false;
    L61:
        if (this.currentChecked != r15) goto L63;
    L68:
        boolean r16 = false;
    L69:
        ColorStateList r17 = this.tint;
        if (r17 == null) goto L72;
        int r18 = r17.getColorForState(r7, this.currentTint);
    L74:
        if (this.currentTint == r18) goto L76;
        this.currentTint = r18;
        this.tintFilter = DrawableUtils.updateTintFilter(this, this.tint, this.tintMode);
    L78:
        if (isStateful(this.chipIcon) == false) goto L81;
        r4 = r4 | this.chipIcon.setState(r7);
    L81:
        if (isStateful(this.checkedIcon) == false) goto L84;
        r4 = r4 | this.checkedIcon.setState(r7);
    L84:
        if (isStateful(this.closeIcon) == false) goto L87;
        int[] r19 = new int[r7.length + r8.length];
        System.arraycopy(r7, 0, r19, 0, r7.length);
        System.arraycopy(r8, 0, r19, r7.length, r8.length);
        r4 = r4 | this.closeIcon.setState(r19);
    L87:
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == true) goto L89;
    L91:
        if (r4 == false) goto L93;
        invalidateSelf();
    L93:
        if (r16 == false) goto L95;
        onSizeChange();
    L95:
        return r4;
    L89:
        if (isStateful(this.closeIconRipple) == false) goto L91;
        r4 = r4 | this.closeIconRipple.setState(r8);
        goto L91
    L76:
        r4 = r0;
        goto L78
    L72:
        r18 = 0;
        goto L74
    L63:
        if (this.checkedIcon == null) goto L68;
        float r20 = calculateChipIconWidth();
        this.currentChecked = r15;
        if (r20 == calculateChipIconWidth()) goto L67;
        r0 = true;
        r16 = true;
        goto L69
    L67:
        r16 = false;
        r0 = true;
        goto L69
    L57:
        if (this.checkable == false) goto L59;
        r15 = true;
        goto L61
    L48:
        if (this.textDrawableHelper.getTextAppearance().textColor == null) goto L50;
        r14 = this.textDrawableHelper.getTextAppearance().textColor.getColorForState(r7, this.currentTextColor);
        goto L52
    L37:
        if (RippleUtils.shouldDrawRippleCompat(r7) == false) goto L39;
        r13 = this.compatRippleColor.getColorForState(r7, this.currentCompatRippleColor);
        goto L41
    L30:
        r12 = 0;
        goto L32
    L23:
        r10 = false;
        goto L25
    L19:
        r9 = false;
        goto L21
    L12:
        r5 = 0;
        goto L14
    L5:
        r2 = 0;
        goto L6
    }

    private static boolean isStateful(@Nullable ColorStateList r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.isStateful() == false) goto L6;
        return true;
    }

    private static boolean isStateful(@Nullable Drawable r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.isStateful() == false) goto L6;
        return true;
    }

    private static boolean isStateful(@Nullable TextAppearance r0) {
        if (r0 == null) goto L8;
        ColorStateList r1 = r0.textColor;
        if (r1 == null) goto L8;
        if (r1.isStateful() == false) goto L8;
        return true;
    L8:
        return false;
    }
}
