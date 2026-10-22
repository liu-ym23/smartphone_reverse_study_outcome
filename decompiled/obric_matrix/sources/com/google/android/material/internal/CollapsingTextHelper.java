package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;

    @NonNull
    private static final Paint DEBUG_DRAW_PAINT = null;
    private static final String ELLIPSIS_NORMAL = "…";
    private static final float FADE_MODE_THRESHOLD_FRACTION_RELATIVE = 0.5f;
    private static final String TAG = "CollapsingTextHelper";
    private static final boolean USE_SCALING_TEXTURE = false;
    private boolean boundsChanged;

    @NonNull
    private final Rect collapsedBounds;
    private float collapsedDrawX;
    private float collapsedDrawY;
    private CancelableFontCallback collapsedFontCallback;
    private float collapsedLetterSpacing;
    private ColorStateList collapsedShadowColor;
    private float collapsedShadowDx;
    private float collapsedShadowDy;
    private float collapsedShadowRadius;
    private float collapsedTextBlend;
    private ColorStateList collapsedTextColor;
    private int collapsedTextGravity;
    private float collapsedTextSize;
    private float collapsedTextWidth;
    private Typeface collapsedTypeface;

    @NonNull
    private final RectF currentBounds;
    private float currentDrawX;
    private float currentDrawY;
    private int currentOffsetY;
    private float currentTextSize;
    private Typeface currentTypeface;
    private boolean drawTitle;

    @NonNull
    private final Rect expandedBounds;
    private float expandedDrawX;
    private float expandedDrawY;
    private float expandedFirstLineDrawX;
    private CancelableFontCallback expandedFontCallback;
    private float expandedFraction;
    private float expandedLetterSpacing;
    private int expandedLineCount;
    private ColorStateList expandedShadowColor;
    private float expandedShadowDx;
    private float expandedShadowDy;
    private float expandedShadowRadius;
    private float expandedTextBlend;
    private ColorStateList expandedTextColor;
    private int expandedTextGravity;
    private float expandedTextSize;

    @Nullable
    private Bitmap expandedTitleTexture;
    private Typeface expandedTypeface;
    private boolean fadeModeEnabled;
    private float fadeModeStartFraction;
    private float fadeModeThresholdFraction;
    private int hyphenationFrequency;
    private boolean isRtl;
    private boolean isRtlTextDirectionHeuristicsEnabled;
    private float lineSpacingAdd;
    private float lineSpacingMultiplier;
    private int maxLines;
    private TimeInterpolator positionInterpolator;
    private float scale;
    private int[] state;

    @Nullable
    private CharSequence text;
    private StaticLayout textLayout;

    @NonNull
    private final TextPaint textPaint;
    private TimeInterpolator textSizeInterpolator;

    @Nullable
    private CharSequence textToDraw;
    private CharSequence textToDrawCollapsed;
    private Paint texturePaint;

    @NonNull
    private final TextPaint tmpPaint;
    private boolean useTexture;
    private final View view;

    static {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        boolean r0 = true;
    L6:
        USE_SCALING_TEXTURE = r0;
        Paint r1 = null;
        DEBUG_DRAW_PAINT = null;
        if (0 == 0) goto L10;
        r1.setAntiAlias(true);
        r1.setColor(-65281);
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public CollapsingTextHelper(View r2) {
        this.expandedTextGravity = 16;
        this.collapsedTextGravity = 16;
        this.expandedTextSize = 15.0f;
        this.collapsedTextSize = 15.0f;
        this.isRtlTextDirectionHeuristicsEnabled = true;
        this.maxLines = 1;
        this.lineSpacingAdd = 0.0f;
        this.lineSpacingMultiplier = 1.0f;
        this.hyphenationFrequency = StaticLayoutBuilderCompat.DEFAULT_HYPHENATION_FREQUENCY;
        this.view = r2;
        TextPaint r3 = new TextPaint(129);
        this.textPaint = r3;
        this.tmpPaint = new TextPaint(r3);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
    }

    private static int blendColors(int r5, int r6, float r7) {
        float r0 = 1.0f - r7;
        return Color.argb((int) ((Color.alpha(r5) * r0) + (Color.alpha(r6) * r7)), (int) ((Color.red(r5) * r0) + (Color.red(r6) * r7)), (int) ((Color.green(r5) * r0) + (Color.green(r6) * r7)), (int) ((Color.blue(r5) * r0) + (Color.blue(r6) * r7)));
    }

    private void calculateBaseOffsets(boolean r13) {
        float r0 = this.currentTextSize;
        calculateUsingTextSize(this.collapsedTextSize, r13);
        CharSequence r1 = this.textToDraw;
        if (r1 == null) goto L7;
        StaticLayout r2 = this.textLayout;
        if (r2 == null) goto L7;
        this.textToDrawCollapsed = TextUtils.ellipsize(r1, this.textPaint, r2.getWidth(), TextUtils.TruncateAt.END);
    L7:
        float r3 = 0.0f;
        if (this.textToDrawCollapsed == null) goto L13;
        TextPaint r4 = new TextPaint(this.textPaint);
        if (Build.VERSION.SDK_INT < 21) goto L12;
        r4.setLetterSpacing(this.collapsedLetterSpacing);
    L12:
        CharSequence r5 = this.textToDrawCollapsed;
        this.collapsedTextWidth = r4.measureText(r5, 0, r5.length());
    L14:
        int r6 = GravityCompat.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        int r7 = r6 & 112;
        if (r7 == 48) goto L19;
        if (r7 == 80) goto L18;
        this.collapsedDrawY = this.collapsedBounds.centerY() - ((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f);
    L21:
        int r8 = r6 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r8 == 1) goto L26;
        if (r8 == 5) goto L25;
        float r9 = this.collapsedBounds.left;
    L28:
        this.collapsedDrawX = r9;
        calculateUsingTextSize(this.expandedTextSize, r13);
        StaticLayout r14 = this.textLayout;
        if (r14 == null) goto L31;
        float r15 = r14.getHeight();
    L32:
        StaticLayout r10 = this.textLayout;
        if (r10 == null) goto L35;
        int r11 = r10.getLineCount();
    L36:
        this.expandedLineCount = r11;
        CharSequence r12 = this.textToDraw;
        if (r12 == null) goto L39;
        float r16 = this.textPaint.measureText(r12, 0, r12.length());
    L40:
        StaticLayout r17 = this.textLayout;
        if (r17 != null) goto L43;
    L45:
        StaticLayout r18 = this.textLayout;
        if (r18 != null) goto L48;
    L51:
        this.expandedFirstLineDrawX = r3;
        int r19 = GravityCompat.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
        int r20 = r19 & 112;
        if (r20 == 48) goto L57;
        if (r20 == 80) goto L56;
        float r21 = this.expandedBounds.centerY() - (r15 / 2.0f);
    L55:
        this.expandedDrawY = r21;
    L58:
        int r110 = r19 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r110 == 1) goto L63;
        if (r110 == 5) goto L62;
        float r111 = this.expandedBounds.left;
    L65:
        this.expandedDrawX = r111;
        clearTexture();
        setInterpolatedTextSize(r0);
        return;
    L62:
        float r112 = this.expandedBounds.right;
    L64:
        r111 = r112 - r16;
        goto L65
    L63:
        r112 = this.expandedBounds.centerX();
        r16 = r16 / 2.0f;
        goto L64
    L56:
        r21 = (this.expandedBounds.bottom - r15) + this.textPaint.descent();
        goto L55
    L57:
        this.expandedDrawY = this.expandedBounds.top;
        goto L58
    L48:
        if (this.maxLines <= 1) goto L50;
        r3 = r18.getLineStart(0);
        goto L51
    L50:
        r3 = r18.getLineLeft(0);
        goto L51
    L43:
        if (this.maxLines <= 1) goto L45;
        r16 = r17.getWidth();
        goto L45
    L39:
        r16 = 0.0f;
        goto L40
    L35:
        r11 = 0;
        goto L36
    L31:
        r15 = 0.0f;
        goto L32
    L25:
        float r22 = this.collapsedBounds.right;
        float r113 = this.collapsedTextWidth;
    L27:
        r9 = r22 - r113;
        goto L28
    L26:
        r22 = this.collapsedBounds.centerX();
        r113 = this.collapsedTextWidth / 2.0f;
        goto L27
    L18:
        float r23 = this.collapsedBounds.bottom + this.textPaint.ascent();
    L20:
        this.collapsedDrawY = r23;
        goto L21
    L19:
        r23 = this.collapsedBounds.top;
        goto L20
    L13:
        this.collapsedTextWidth = 0.0f;
        goto L14
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.expandedFraction);
    }

    private float calculateFadeModeTextAlpha(@FloatRange(from = 0.0d, to = 1.0d) float r5) {
        float r0 = this.fadeModeThresholdFraction;
        if (r5 > r0) goto L7;
        return AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, r0, r5);
    L7:
        return AnimationUtils.lerp(0.0f, 1.0f, r0, 1.0f, r5);
    }

    private float calculateFadeModeThresholdFraction() {
        float r2 = this.fadeModeStartFraction;
        return r2 + ((1.0f - r2) * 0.5f);
    }

    private boolean calculateIsRtl(@NonNull CharSequence r3) {
        boolean r0 = isDefaultIsRtl();
        if (this.isRtlTextDirectionHeuristicsEnabled == true) goto L5;
        return r0;
    L5:
        return isTextDirectionHeuristicsIsRtl(r3, r0);
    }

    private void calculateOffsets(float r7) {
        interpolateBounds(r7);
        if (this.fadeModeEnabled == true) goto L5;
        this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, r7, this.positionInterpolator);
        this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, r7, this.positionInterpolator);
        setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, r7, this.textSizeInterpolator));
        float r0 = r7;
    L9:
        TimeInterpolator r4 = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        setCollapsedTextBlend(1.0f - lerp(0.0f, 1.0f, 1.0f - r7, r4));
        setExpandedTextBlend(lerp(1.0f, 0.0f, r7, r4));
        if (this.collapsedTextColor == this.expandedTextColor) goto L12;
        this.textPaint.setColor(blendColors(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), r0));
    L14:
        if (Build.VERSION.SDK_INT < 21) goto L19;
        float r1 = this.collapsedLetterSpacing;
        float r2 = this.expandedLetterSpacing;
        if (r1 == r2) goto L18;
        this.textPaint.setLetterSpacing(lerp(r2, r1, r7, r4));
        goto L19
    L18:
        this.textPaint.setLetterSpacing(r1);
    L19:
        this.textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, r7, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, r7, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, r7, null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), r7));
        if (this.fadeModeEnabled == false) goto L22;
        this.textPaint.setAlpha((int) (calculateFadeModeTextAlpha(r7) * this.textPaint.getAlpha()));
    L22:
        ViewCompat.postInvalidateOnAnimation(this.view);
        return;
    L12:
        this.textPaint.setColor(getCurrentCollapsedTextColor());
        goto L14
    L5:
        if (r7 >= this.fadeModeThresholdFraction) goto L7;
        this.currentDrawX = this.expandedDrawX;
        this.currentDrawY = this.expandedDrawY;
        setInterpolatedTextSize(this.expandedTextSize);
        r0 = 0.0f;
        goto L9
    L7:
        this.currentDrawX = this.collapsedDrawX;
        this.currentDrawY = this.collapsedDrawY - Math.max(0, this.currentOffsetY);
        setInterpolatedTextSize(this.collapsedTextSize);
        r0 = 1.0f;
        goto L9
    }

    private void calculateUsingTextSize(float r2) {
        calculateUsingTextSize(r2, false);
    }

    private void calculateUsingTextSize(float r9, boolean r10) {
        if (this.text != null) goto L5;
        return;
    L5:
        float r0 = this.collapsedBounds.width();
        float r1 = this.expandedBounds.width();
        boolean r4 = false;
        int r5 = 1;
        if (isClose(r9, this.collapsedTextSize) == false) goto L11;
        float r11 = this.collapsedTextSize;
        this.scale = 1.0f;
        Typeface r12 = this.currentTypeface;
        Typeface r2 = this.collapsedTypeface;
        if (r12 == r2) goto L10;
        this.currentTypeface = r2;
        boolean r13 = true;
    L27:
        if (r0 <= 0.0f) goto L38;
        if (this.currentTextSize == r11) goto L31;
    L35:
        r13 = true;
    L36:
        this.currentTextSize = r11;
        this.boundsChanged = false;
        goto L38
    L31:
        if (this.boundsChanged == true) goto L35;
        if (r13 == true) goto L35;
        r13 = false;
    L38:
        if (this.textToDraw == null) goto L40;
        if (r13 == true) goto L40;
        return;
    L40:
        this.textPaint.setTextSize(this.currentTextSize);
        this.textPaint.setTypeface(this.currentTypeface);
        TextPaint r14 = this.textPaint;
        if (this.scale == 1.0f) goto L43;
        r4 = true;
    L43:
        r14.setLinearText(r4);
        this.isRtl = calculateIsRtl(this.text);
        if (shouldDrawMultiline() == false) goto L46;
        r5 = this.maxLines;
    L46:
        StaticLayout r15 = createStaticLayout(r5, r0, this.isRtl);
        this.textLayout = r15;
        this.textToDraw = r15.getText();
        return;
    L10:
        r13 = false;
        goto L27
    L11:
        float r3 = this.expandedTextSize;
        Typeface r6 = this.currentTypeface;
        Typeface r7 = this.expandedTypeface;
        if (r6 == r7) goto L14;
        this.currentTypeface = r7;
        boolean r8 = true;
    L16:
        if (isClose(r9, r3) == false) goto L18;
        this.scale = 1.0f;
    L19:
        float r16 = this.collapsedTextSize / this.expandedTextSize;
        float r17 = r1 * r16;
        if (r10 == false) goto L24;
    L21:
        r0 = r1;
    L22:
        r11 = r3;
        r13 = r8;
        goto L27
    L24:
        if (r17 <= r0) goto L21;
        r0 = Math.min(r0 / r16, r1);
        goto L22
    L18:
        this.scale = r9 / this.expandedTextSize;
        goto L19
    L14:
        r8 = false;
        goto L16
    }

    private void clearTexture() {
        Bitmap r0 = this.expandedTitleTexture;
        if (r0 == null) goto L6;
        r0.recycle();
        this.expandedTitleTexture = null;
        return;
    }

    private StaticLayout createStaticLayout(int r3, float r4, boolean r5) {
        StaticLayout r2 = StaticLayoutBuilderCompat.obtain(this.text, this.textPaint, (int) r4).setEllipsize(TextUtils.TruncateAt.END).setIsRtl(r5).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(false).setMaxLines(r3).setLineSpacing(this.lineSpacingAdd, this.lineSpacingMultiplier).setHyphenationFrequency(this.hyphenationFrequency).build();     // Catch: StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException -> L4
    L7:
        return (StaticLayout) Preconditions.checkNotNull(r2);
    L4:
        e = move-exception;
        Log.e(TAG, e.getCause().getMessage(), e);
        r2 = null;
        goto L7
    }

    private void drawMultilineTransition(@NonNull Canvas r13, float r14, float r15) {
        int r0 = this.textPaint.getAlpha();
        r13.translate(r14, r15);
        float r1 = r0;
        this.textPaint.setAlpha((int) (this.expandedTextBlend * r1));
        this.textLayout.draw(r13);
        this.textPaint.setAlpha((int) (this.collapsedTextBlend * r1));
        int r16 = this.textLayout.getLineBaseline(0);
        CharSequence r2 = this.textToDrawCollapsed;
        float r10 = r16;
        r13.drawText(r2, 0, r2.length(), 0.0f, r10, this.textPaint);
        if (this.fadeModeEnabled == true) goto L9;
        String r17 = this.textToDrawCollapsed.toString().trim();
        if (r17.endsWith(ELLIPSIS_NORMAL) == false) goto L7;
        r17 = r17.substring(0, r17.length() - 1);
    L7:
        String r6 = r17;
        this.textPaint.setAlpha(r0);
        r13.drawText(r6, 0, Math.min(this.textLayout.getLineEnd(0), r6.length()), 0.0f, r10, this.textPaint);
        return;
    }

    private void ensureExpandedTexture() {
        if (this.expandedTitleTexture == null) goto L5;
        return;
    L5:
        if (this.expandedBounds.isEmpty() == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.textToDraw) == true) goto L21;
        calculateOffsets(0.0f);
        int r0 = this.textLayout.getWidth();
        int r1 = this.textLayout.getHeight();
        if (r0 <= 0) goto L19;
        if (r1 <= 0) goto L22;
        this.expandedTitleTexture = Bitmap.createBitmap(r0, r1, Bitmap.Config.ARGB_8888);
        Canvas r2 = new Canvas(this.expandedTitleTexture);
        this.textLayout.draw(r2);
        if (this.texturePaint != null) goto L20;
        this.texturePaint = new Paint(3);
        return;
    L20:
        return;
    L22:
        return;
    L19:
        return;
    }

    private float getCollapsedTextLeftBound(int r3, int r4) {
        if (r4 == 17) goto L23;
        if ((r4 & 7) == 1) goto L23;
        if ((r4 & GravityCompat.END) == 8388613) goto L18;
        if ((r4 & 5) == 5) goto L18;
        if (this.isRtl == false) goto L16;
        return this.collapsedBounds.right - this.collapsedTextWidth;
    L16:
        return this.collapsedBounds.left;
    L18:
        if (this.isRtl == false) goto L21;
        return this.collapsedBounds.left;
    L21:
        return this.collapsedBounds.right - this.collapsedTextWidth;
    L23:
        return (r3 / 2.0f) - (this.collapsedTextWidth / 2.0f);
    }

    private float getCollapsedTextRightBound(@NonNull RectF r3, int r4, int r5) {
        if (r5 == 17) goto L23;
        if ((r5 & 7) == 1) goto L23;
        if ((r5 & GravityCompat.END) == 8388613) goto L18;
        if ((r5 & 5) == 5) goto L18;
        if (this.isRtl == false) goto L16;
        return this.collapsedBounds.right;
    L16:
        return this.collapsedTextWidth + r3.left;
    L18:
        if (this.isRtl == false) goto L21;
        return r3.left + this.collapsedTextWidth;
    L21:
        return this.collapsedBounds.right;
    L23:
        return (r4 / 2.0f) + (this.collapsedTextWidth / 2.0f);
    }

    @ColorInt
    private int getCurrentColor(@Nullable ColorStateList r2) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        int[] r1 = this.state;
        if (r1 == null) goto L10;
        return r2.getColorForState(r1, 0);
    L10:
        return r2.getDefaultColor();
    }

    @ColorInt
    private int getCurrentExpandedTextColor() {
        return getCurrentColor(this.expandedTextColor);
    }

    private void getTextPaintCollapsed(@NonNull TextPaint r3) {
        r3.setTextSize(this.collapsedTextSize);
        r3.setTypeface(this.collapsedTypeface);
        if (Build.VERSION.SDK_INT < 21) goto L6;
        r3.setLetterSpacing(this.collapsedLetterSpacing);
        return;
    }

    private void getTextPaintExpanded(@NonNull TextPaint r3) {
        r3.setTextSize(this.expandedTextSize);
        r3.setTypeface(this.expandedTypeface);
        if (Build.VERSION.SDK_INT < 21) goto L6;
        r3.setLetterSpacing(this.expandedLetterSpacing);
        return;
    }

    private void interpolateBounds(float r5) {
        if (this.fadeModeEnabled == false) goto L9;
        RectF r0 = this.currentBounds;
        if (r5 >= this.fadeModeThresholdFraction) goto L7;
        Rect r4 = this.expandedBounds;
    L8:
        r0.set(r4);
        return;
    L7:
        r4 = this.collapsedBounds;
        goto L8
    L9:
        this.currentBounds.left = lerp(this.expandedBounds.left, this.collapsedBounds.left, r5, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, r5, this.positionInterpolator);
        this.currentBounds.right = lerp(this.expandedBounds.right, this.collapsedBounds.right, r5, this.positionInterpolator);
        this.currentBounds.bottom = lerp(this.expandedBounds.bottom, this.collapsedBounds.bottom, r5, this.positionInterpolator);
    }

    private static boolean isClose(float r0, float r1) {
        if (Math.abs(r0 - r1) >= 0.001f) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isDefaultIsRtl() {
        if (ViewCompat.getLayoutDirection(this.view) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isTextDirectionHeuristicsIsRtl(@NonNull CharSequence r2, boolean r3) {
        if (r3 == false) goto L4;
        TextDirectionHeuristicCompat r1 = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
    L6:
        return r1.isRtl(r2, 0, r2.length());
    L4:
        r1 = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        goto L6
    }

    private static float lerp(float r0, float r1, float r2, @Nullable TimeInterpolator r3) {
        if (r3 == null) goto L5;
        r2 = r3.getInterpolation(r2);
    L5:
        return AnimationUtils.lerp(r0, r1, r2);
    }

    private static boolean rectEquals(@NonNull Rect r1, int r2, int r3, int r4, int r5) {
        if (r1.left == r2) goto L5;
    L11:
        return false;
    L5:
        if (r1.top != r3) goto L11;
        if (r1.right != r4) goto L11;
        if (r1.bottom != r5) goto L11;
        return true;
    }

    private void setCollapsedTextBlend(float r1) {
        this.collapsedTextBlend = r1;
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private boolean setCollapsedTypefaceInternal(Typeface r2) {
        CancelableFontCallback r0 = this.collapsedFontCallback;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (this.collapsedTypeface == r2) goto L9;
        this.collapsedTypeface = r2;
        return true;
    L9:
        return false;
    }

    private void setExpandedTextBlend(float r1) {
        this.expandedTextBlend = r1;
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private boolean setExpandedTypefaceInternal(Typeface r2) {
        CancelableFontCallback r0 = this.expandedFontCallback;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (this.expandedTypeface == r2) goto L9;
        this.expandedTypeface = r2;
        return true;
    L9:
        return false;
    }

    private void setInterpolatedTextSize(float r2) {
        calculateUsingTextSize(r2);
        if (USE_SCALING_TEXTURE == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.useTexture = r3;
        if (r3 == false) goto L11;
        ensureExpandedTexture();
    L11:
        ViewCompat.postInvalidateOnAnimation(this.view);
        return;
    L5:
        if (this.scale == 1.0f) goto L7;
        r3 = true;
        goto L8
    }

    private boolean shouldDrawMultiline() {
        if (this.maxLines > 1) goto L5;
    L11:
        return false;
    L5:
        if (this.isRtl == false) goto L9;
        if (this.fadeModeEnabled == false) goto L11;
    L9:
        if (this.useTexture == true) goto L11;
        return true;
    }

    public void draw(@NonNull Canvas r8) {
        int r0 = r8.save();
        if (this.textToDraw != null) goto L5;
        return;
    L5:
        if (this.drawTitle == false) goto L35;
        boolean r2 = true;
        if (this.maxLines <= 1) goto L9;
        float r1 = this.textLayout.getLineStart(0);
    L10:
        float r4 = (this.currentDrawX + r1) - (this.expandedFirstLineDrawX * 2.0f);
        this.textPaint.setTextSize(this.currentTextSize);
        float r3 = this.currentDrawX;
        float r5 = this.currentDrawY;
        if (this.useTexture == true) goto L13;
    L15:
        r2 = false;
    L16:
        float r6 = this.scale;
        if (r6 != 1.0f) goto L19;
    L21:
        if (r2 == false) goto L25;
        r8.drawBitmap(this.expandedTitleTexture, r3, r5, this.texturePaint);
        r8.restoreToCount(r0);
        return;
    L25:
        if (shouldDrawMultiline() == true) goto L27;
    L31:
        r8.translate(r3, r5);
        this.textLayout.draw(r8);
    L32:
        r8.restoreToCount(r0);
        return;
    L27:
        if (this.fadeModeEnabled == true) goto L29;
    L30:
        drawMultilineTransition(r8, r4, r5);
        goto L32
    L29:
        if (this.expandedFraction <= this.fadeModeThresholdFraction) goto L31;
    L19:
        if (this.fadeModeEnabled == true) goto L21;
        r8.scale(r6, r6, r3, r5);
        goto L21
    L13:
        if (this.expandedTitleTexture == null) goto L15;
    L9:
        r1 = this.textLayout.getLineLeft(0);
        goto L10
    }

    public void getCollapsedTextActualBounds(@NonNull RectF r2, int r3, int r4) {
        this.isRtl = calculateIsRtl(this.text);
        r2.left = getCollapsedTextLeftBound(r3, r4);
        r2.top = this.collapsedBounds.top;
        r2.right = getCollapsedTextRightBound(r2, r3, r4);
        r2.bottom = this.collapsedBounds.top + getCollapsedTextHeight();
    }

    public ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public float getCollapsedTextHeight() {
        getTextPaintCollapsed(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getCollapsedTextSize() {
        return this.collapsedTextSize;
    }

    public Typeface getCollapsedTypeface() {
        Typeface r0 = this.collapsedTypeface;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return Typeface.DEFAULT;
    }

    @ColorInt
    public int getCurrentCollapsedTextColor() {
        return getCurrentColor(this.collapsedTextColor);
    }

    public int getExpandedLineCount() {
        return this.expandedLineCount;
    }

    public ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public float getExpandedTextFullHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return (-this.tmpPaint.ascent()) + this.tmpPaint.descent();
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public float getExpandedTextHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getExpandedTextSize() {
        return this.expandedTextSize;
    }

    public Typeface getExpandedTypeface() {
        Typeface r0 = this.expandedTypeface;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return Typeface.DEFAULT;
    }

    public float getExpansionFraction() {
        return this.expandedFraction;
    }

    public float getFadeModeThresholdFraction() {
        return this.fadeModeThresholdFraction;
    }

    @RequiresApi(23)
    public int getHyphenationFrequency() {
        return this.hyphenationFrequency;
    }

    public int getLineCount() {
        StaticLayout r0 = this.textLayout;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getLineCount();
    }

    @RequiresApi(23)
    public float getLineSpacingAdd() {
        return this.textLayout.getSpacingAdd();
    }

    @RequiresApi(23)
    public float getLineSpacingMultiplier() {
        return this.textLayout.getSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    @Nullable
    public TimeInterpolator getPositionInterpolator() {
        return this.positionInterpolator;
    }

    @Nullable
    public CharSequence getText() {
        return this.text;
    }

    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.isRtlTextDirectionHeuristicsEnabled;
    }

    public final boolean isStateful() {
        ColorStateList r0 = this.collapsedTextColor;
        if (r0 != null) goto L5;
    L6:
        ColorStateList r1 = this.expandedTextColor;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.isStateful() == false) goto L11;
    L10:
        return true;
    L5:
        if (r0.isStateful() == true) goto L10;
        goto L6
    }

    void onBoundsChanged() {
        if (this.collapsedBounds.width() > 0) goto L5;
    L11:
        boolean r0 = false;
    L12:
        this.drawTitle = r0;
        return;
    L5:
        if (this.collapsedBounds.height() <= 0) goto L11;
        if (this.expandedBounds.width() <= 0) goto L11;
        if (this.expandedBounds.height() <= 0) goto L11;
        r0 = true;
        goto L12
    }

    public void recalculate() {
        recalculate(false);
    }

    public void recalculate(boolean r2) {
        if (this.view.getHeight() > 0) goto L5;
    L6:
        if (r2 == false) goto L9;
    L7:
        calculateBaseOffsets(r2);
        calculateCurrentOffsets();
        return;
    L9:
        return;
    L5:
        if (this.view.getWidth() > 0) goto L7;
        goto L6
    }

    public void setCollapsedBounds(int r2, int r3, int r4, int r5) {
        if (rectEquals(this.collapsedBounds, r2, r3, r4, r5) == true) goto L6;
        this.collapsedBounds.set(r2, r3, r4, r5);
        this.boundsChanged = true;
        onBoundsChanged();
        return;
    }

    public void setCollapsedBounds(@NonNull Rect r4) {
        setCollapsedBounds(r4.left, r4.top, r4.right, r4.bottom);
    }

    public void setCollapsedTextAppearance(int r4) {
        TextAppearance r0 = new TextAppearance(this.view.getContext(), r4);
        if (r0.getTextColor() == null) goto L6;
        this.collapsedTextColor = r0.getTextColor();
    L6:
        if (r0.getTextSize() == 0.0f) goto L8;
        this.collapsedTextSize = r0.getTextSize();
    L8:
        ColorStateList r5 = r0.shadowColor;
        if (r5 == null) goto L11;
        this.collapsedShadowColor = r5;
    L11:
        this.collapsedShadowDx = r0.shadowDx;
        this.collapsedShadowDy = r0.shadowDy;
        this.collapsedShadowRadius = r0.shadowRadius;
        this.collapsedLetterSpacing = r0.letterSpacing;
        CancelableFontCallback r6 = this.collapsedFontCallback;
        if (r6 == null) goto L14;
        r6.cancel();
    L14:
        this.collapsedFontCallback = new CancelableFontCallback(new AnonymousClass1(this), r0.getFallbackFont());
        r0.getFontAsync(this.view.getContext(), this.collapsedFontCallback);
        recalculate();
    }

    public void setCollapsedTextColor(ColorStateList r2) {
        if (this.collapsedTextColor == r2) goto L6;
        this.collapsedTextColor = r2;
        recalculate();
        return;
    }

    public void setCollapsedTextGravity(int r2) {
        if (this.collapsedTextGravity == r2) goto L6;
        this.collapsedTextGravity = r2;
        recalculate();
        return;
    }

    public void setCollapsedTextSize(float r2) {
        if (this.collapsedTextSize == r2) goto L6;
        this.collapsedTextSize = r2;
        recalculate();
        return;
    }

    public void setCollapsedTypeface(Typeface r1) {
        if (setCollapsedTypefaceInternal(r1) == false) goto L6;
        recalculate();
        return;
    }

    public void setCurrentOffsetY(int r1) {
        this.currentOffsetY = r1;
    }

    public void setExpandedBounds(int r2, int r3, int r4, int r5) {
        if (rectEquals(this.expandedBounds, r2, r3, r4, r5) == true) goto L6;
        this.expandedBounds.set(r2, r3, r4, r5);
        this.boundsChanged = true;
        onBoundsChanged();
        return;
    }

    public void setExpandedBounds(@NonNull Rect r4) {
        setExpandedBounds(r4.left, r4.top, r4.right, r4.bottom);
    }

    public void setExpandedTextAppearance(int r4) {
        TextAppearance r0 = new TextAppearance(this.view.getContext(), r4);
        if (r0.getTextColor() == null) goto L6;
        this.expandedTextColor = r0.getTextColor();
    L6:
        if (r0.getTextSize() == 0.0f) goto L8;
        this.expandedTextSize = r0.getTextSize();
    L8:
        ColorStateList r5 = r0.shadowColor;
        if (r5 == null) goto L11;
        this.expandedShadowColor = r5;
    L11:
        this.expandedShadowDx = r0.shadowDx;
        this.expandedShadowDy = r0.shadowDy;
        this.expandedShadowRadius = r0.shadowRadius;
        this.expandedLetterSpacing = r0.letterSpacing;
        CancelableFontCallback r6 = this.expandedFontCallback;
        if (r6 == null) goto L14;
        r6.cancel();
    L14:
        this.expandedFontCallback = new CancelableFontCallback(new AnonymousClass2(this), r0.getFallbackFont());
        r0.getFontAsync(this.view.getContext(), this.expandedFontCallback);
        recalculate();
    }

    public void setExpandedTextColor(ColorStateList r2) {
        if (this.expandedTextColor == r2) goto L6;
        this.expandedTextColor = r2;
        recalculate();
        return;
    }

    public void setExpandedTextGravity(int r2) {
        if (this.expandedTextGravity == r2) goto L6;
        this.expandedTextGravity = r2;
        recalculate();
        return;
    }

    public void setExpandedTextSize(float r2) {
        if (this.expandedTextSize == r2) goto L6;
        this.expandedTextSize = r2;
        recalculate();
        return;
    }

    public void setExpandedTypeface(Typeface r1) {
        if (setExpandedTypefaceInternal(r1) == false) goto L6;
        recalculate();
        return;
    }

    public void setExpansionFraction(float r3) {
        float r4 = MathUtils.clamp(r3, 0.0f, 1.0f);
        if (r4 == this.expandedFraction) goto L6;
        this.expandedFraction = r4;
        calculateCurrentOffsets();
        return;
    }

    public void setFadeModeEnabled(boolean r1) {
        this.fadeModeEnabled = r1;
    }

    public void setFadeModeStartFraction(float r1) {
        this.fadeModeStartFraction = r1;
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
    }

    @RequiresApi(23)
    public void setHyphenationFrequency(int r1) {
        this.hyphenationFrequency = r1;
    }

    @RequiresApi(23)
    public void setLineSpacingAdd(float r1) {
        this.lineSpacingAdd = r1;
    }

    @RequiresApi(23)
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float r1) {
        this.lineSpacingMultiplier = r1;
    }

    public void setMaxLines(int r2) {
        if (r2 == this.maxLines) goto L6;
        this.maxLines = r2;
        clearTexture();
        recalculate();
        return;
    }

    public void setPositionInterpolator(TimeInterpolator r1) {
        this.positionInterpolator = r1;
        recalculate();
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean r1) {
        this.isRtlTextDirectionHeuristicsEnabled = r1;
    }

    public final boolean setState(int[] r1) {
        this.state = r1;
        if (isStateful() == false) goto L6;
        recalculate();
        return true;
    L6:
        return false;
    }

    public void setText(@Nullable CharSequence r2) {
        if (r2 != null) goto L4;
    L5:
        this.text = r2;
        this.textToDraw = null;
        clearTexture();
        recalculate();
        return;
    L4:
        if (TextUtils.equals(this.text, r2) == false) goto L5;
    }

    public void setTextSizeInterpolator(TimeInterpolator r1) {
        this.textSizeInterpolator = r1;
        recalculate();
    }

    public void setTypefaces(Typeface r2) {
        boolean r0 = setCollapsedTypefaceInternal(r2);
        boolean r3 = setExpandedTypefaceInternal(r2);
        if (r0 == true) goto L5;
        if (r3 == true) goto L5;
        return;
    L5:
        recalculate();
    }
}
