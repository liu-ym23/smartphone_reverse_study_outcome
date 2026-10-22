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
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
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
public final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    private static final Paint DEBUG_DRAW_PAINT = null;
    private static final String ELLIPSIS_NORMAL = "…";
    private static final String TAG = "CollapsingTextHelper";
    private static final boolean USE_SCALING_TEXTURE = false;
    private boolean boundsChanged;
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
    private Typeface collapsedTypeface;
    private final RectF currentBounds;
    private float currentDrawX;
    private float currentDrawY;
    private float currentTextSize;
    private Typeface currentTypeface;
    private boolean drawTitle;
    private final Rect expandedBounds;
    private float expandedDrawX;
    private float expandedDrawY;
    private float expandedFirstLineDrawX;
    private CancelableFontCallback expandedFontCallback;
    private float expandedFraction;
    private float expandedLetterSpacing;
    private ColorStateList expandedShadowColor;
    private float expandedShadowDx;
    private float expandedShadowDy;
    private float expandedShadowRadius;
    private float expandedTextBlend;
    private ColorStateList expandedTextColor;
    private int expandedTextGravity;
    private float expandedTextSize;
    private Bitmap expandedTitleTexture;
    private Typeface expandedTypeface;
    private boolean isRtl;
    private int maxLines;
    private TimeInterpolator positionInterpolator;
    private float scale;
    private int[] state;
    private CharSequence text;
    private StaticLayout textLayout;
    private final TextPaint textPaint;
    private TimeInterpolator textSizeInterpolator;
    private CharSequence textToDraw;
    private CharSequence textToDrawCollapsed;
    private Paint texturePaint;
    private final TextPaint tmpPaint;
    private boolean useTexture;
    private final View view;

    static {
        USE_SCALING_TEXTURE = false;
        DEBUG_DRAW_PAINT = null;
    }

    public CollapsingTextHelper(View r2) {
        this.expandedTextGravity = 16;
        this.collapsedTextGravity = 16;
        this.expandedTextSize = 15.0f;
        this.collapsedTextSize = 15.0f;
        this.maxLines = 1;
        this.view = r2;
        TextPaint r3 = new TextPaint(129);
        this.textPaint = r3;
        this.tmpPaint = new TextPaint(r3);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
    }

    public void setTextSizeInterpolator(TimeInterpolator r1) {
        this.textSizeInterpolator = r1;
        recalculate();
    }

    public void setPositionInterpolator(TimeInterpolator r1) {
        this.positionInterpolator = r1;
        recalculate();
    }

    public void setExpandedTextSize(float r2) {
        if (this.expandedTextSize == r2) goto L6;
        this.expandedTextSize = r2;
        recalculate();
        return;
    }

    public void setCollapsedTextSize(float r2) {
        if (this.collapsedTextSize == r2) goto L6;
        this.collapsedTextSize = r2;
        recalculate();
        return;
    }

    public void setCollapsedTextColor(ColorStateList r2) {
        if (this.collapsedTextColor == r2) goto L6;
        this.collapsedTextColor = r2;
        recalculate();
        return;
    }

    public void setExpandedTextColor(ColorStateList r2) {
        if (this.expandedTextColor == r2) goto L6;
        this.expandedTextColor = r2;
        recalculate();
        return;
    }

    public void setExpandedBounds(int r2, int r3, int r4, int r5) {
        if (rectEquals(this.expandedBounds, r2, r3, r4, r5) == true) goto L6;
        this.expandedBounds.set(r2, r3, r4, r5);
        this.boundsChanged = true;
        onBoundsChanged();
        return;
    }

    public void setExpandedBounds(Rect r4) {
        setExpandedBounds(r4.left, r4.top, r4.right, r4.bottom);
    }

    public void setCollapsedBounds(int r2, int r3, int r4, int r5) {
        if (rectEquals(this.collapsedBounds, r2, r3, r4, r5) == true) goto L6;
        this.collapsedBounds.set(r2, r3, r4, r5);
        this.boundsChanged = true;
        onBoundsChanged();
        return;
    }

    public void setCollapsedBounds(Rect r4) {
        setCollapsedBounds(r4.left, r4.top, r4.right, r4.bottom);
    }

    public void getCollapsedTextActualBounds(RectF r2, int r3, int r4) {
        this.isRtl = calculateIsRtl(this.text);
        r2.left = getCollapsedTextLeftBound(r3, r4);
        r2.top = this.collapsedBounds.top;
        r2.right = getCollapsedTextRightBound(r2, r3, r4);
        r2.bottom = this.collapsedBounds.top + getCollapsedTextHeight();
    }

    private float getCollapsedTextLeftBound(int r3, int r4) {
        if (r4 == 17) goto L23;
        if ((r4 & 7) == 1) goto L23;
        if ((r4 & GravityCompat.END) == 8388613) goto L18;
        if ((r4 & 5) == 5) goto L18;
        if (this.isRtl == false) goto L16;
        return this.collapsedBounds.right - calculateCollapsedTextWidth();
    L16:
        return this.collapsedBounds.left;
    L18:
        if (this.isRtl == false) goto L21;
        return this.collapsedBounds.left;
    L21:
        return this.collapsedBounds.right - calculateCollapsedTextWidth();
    L23:
        return (r3 / 2.0f) - (calculateCollapsedTextWidth() / 2.0f);
    }

    private float getCollapsedTextRightBound(RectF r3, int r4, int r5) {
        if (r5 == 17) goto L23;
        if ((r5 & 7) == 1) goto L23;
        if ((r5 & GravityCompat.END) == 8388613) goto L18;
        if ((r5 & 5) == 5) goto L18;
        if (this.isRtl == false) goto L16;
        return this.collapsedBounds.right;
    L16:
        return calculateCollapsedTextWidth() + r3.left;
    L18:
        if (this.isRtl == false) goto L21;
        return r3.left + calculateCollapsedTextWidth();
    L21:
        return this.collapsedBounds.right;
    L23:
        return (r4 / 2.0f) + (calculateCollapsedTextWidth() / 2.0f);
    }

    public float calculateCollapsedTextWidth() {
        if (this.text != null) goto L6;
        return 0.0f;
    L6:
        getTextPaintCollapsed(this.tmpPaint);
        TextPaint r0 = this.tmpPaint;
        CharSequence r3 = this.text;
        return r0.measureText(r3, 0, r3.length());
    }

    public float getExpandedTextHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getCollapsedTextHeight() {
        getTextPaintCollapsed(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    private void getTextPaintExpanded(TextPaint r2) {
        r2.setTextSize(this.expandedTextSize);
        r2.setTypeface(this.expandedTypeface);
        r2.setLetterSpacing(this.expandedLetterSpacing);
    }

    private void getTextPaintCollapsed(TextPaint r2) {
        r2.setTextSize(this.collapsedTextSize);
        r2.setTypeface(this.collapsedTypeface);
        r2.setLetterSpacing(this.collapsedLetterSpacing);
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

    public void setExpandedTextGravity(int r2) {
        if (this.expandedTextGravity == r2) goto L6;
        this.expandedTextGravity = r2;
        recalculate();
        return;
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public void setCollapsedTextGravity(int r2) {
        if (this.collapsedTextGravity == r2) goto L6;
        this.collapsedTextGravity = r2;
        recalculate();
        return;
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public void setCollapsedTextAppearance(int r4) {
        TextAppearance r0 = new TextAppearance(this.view.getContext(), r4);
        if (r0.textColor == null) goto L6;
        this.collapsedTextColor = r0.textColor;
    L6:
        if (r0.textSize == 0.0f) goto L9;
        this.collapsedTextSize = r0.textSize;
    L9:
        if (r0.shadowColor == null) goto L11;
        this.collapsedShadowColor = r0.shadowColor;
    L11:
        this.collapsedShadowDx = r0.shadowDx;
        this.collapsedShadowDy = r0.shadowDy;
        this.collapsedShadowRadius = r0.shadowRadius;
        this.collapsedLetterSpacing = r0.letterSpacing;
        CancelableFontCallback r5 = this.collapsedFontCallback;
        if (r5 == null) goto L14;
        r5.cancel();
    L14:
        this.collapsedFontCallback = new CancelableFontCallback(new AnonymousClass1(this), r0.getFallbackFont());
        r0.getFontAsync(this.view.getContext(), this.collapsedFontCallback);
        recalculate();
    }

    public void setExpandedTextAppearance(int r4) {
        TextAppearance r0 = new TextAppearance(this.view.getContext(), r4);
        if (r0.textColor == null) goto L6;
        this.expandedTextColor = r0.textColor;
    L6:
        if (r0.textSize == 0.0f) goto L9;
        this.expandedTextSize = r0.textSize;
    L9:
        if (r0.shadowColor == null) goto L11;
        this.expandedShadowColor = r0.shadowColor;
    L11:
        this.expandedShadowDx = r0.shadowDx;
        this.expandedShadowDy = r0.shadowDy;
        this.expandedShadowRadius = r0.shadowRadius;
        this.expandedLetterSpacing = r0.letterSpacing;
        CancelableFontCallback r5 = this.expandedFontCallback;
        if (r5 == null) goto L14;
        r5.cancel();
    L14:
        this.expandedFontCallback = new CancelableFontCallback(new AnonymousClass2(this), r0.getFallbackFont());
        r0.getFontAsync(this.view.getContext(), this.expandedFontCallback);
        recalculate();
    }

    public void setCollapsedTypeface(Typeface r1) {
        if (setCollapsedTypefaceInternal(r1) == false) goto L6;
        recalculate();
        return;
    }

    public void setExpandedTypeface(Typeface r1) {
        if (setExpandedTypefaceInternal(r1) == false) goto L6;
        recalculate();
        return;
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

    public Typeface getCollapsedTypeface() {
        Typeface r0 = this.collapsedTypeface;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return Typeface.DEFAULT;
    }

    public Typeface getExpandedTypeface() {
        Typeface r0 = this.expandedTypeface;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return Typeface.DEFAULT;
    }

    public void setExpansionFraction(float r3) {
        float r4 = MathUtils.clamp(r3, 0.0f, 1.0f);
        if (r4 == this.expandedFraction) goto L6;
        this.expandedFraction = r4;
        calculateCurrentOffsets();
        return;
    }

    public final boolean setState(int[] r1) {
        this.state = r1;
        if (isStateful() == false) goto L6;
        recalculate();
        return true;
    L6:
        return false;
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

    public float getExpansionFraction() {
        return this.expandedFraction;
    }

    public float getCollapsedTextSize() {
        return this.collapsedTextSize;
    }

    public float getExpandedTextSize() {
        return this.expandedTextSize;
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.expandedFraction);
    }

    private void calculateOffsets(float r7) {
        interpolateBounds(r7);
        this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, r7, this.positionInterpolator);
        this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, r7, this.positionInterpolator);
        setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, r7, this.textSizeInterpolator));
        setCollapsedTextBlend(1.0f - lerp(0.0f, 1.0f, 1.0f - r7, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        setExpandedTextBlend(lerp(1.0f, 0.0f, r7, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        if (this.collapsedTextColor == this.expandedTextColor) goto L5;
        this.textPaint.setColor(blendColors(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), r7));
    L6:
        float r0 = this.collapsedLetterSpacing;
        float r1 = this.expandedLetterSpacing;
        if (r0 == r1) goto L9;
        this.textPaint.setLetterSpacing(lerp(r1, r0, r7, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
    L10:
        this.textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, r7, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, r7, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, r7, null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), r7));
        ViewCompat.postInvalidateOnAnimation(this.view);
        return;
    L9:
        this.textPaint.setLetterSpacing(r0);
        goto L10
    L5:
        this.textPaint.setColor(getCurrentCollapsedTextColor());
        goto L6
    }

    private int getCurrentExpandedTextColor() {
        return getCurrentColor(this.expandedTextColor);
    }

    public int getCurrentCollapsedTextColor() {
        return getCurrentColor(this.collapsedTextColor);
    }

    private int getCurrentColor(ColorStateList r2) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        int[] r1 = this.state;
        if (r1 == null) goto L10;
        return r2.getColorForState(r1, 0);
    L10:
        return r2.getDefaultColor();
    }

    private void calculateBaseOffsets() {
        float r0 = this.currentTextSize;
        calculateUsingTextSize(this.collapsedTextSize);
        CharSequence r1 = this.textToDraw;
        if (r1 == null) goto L7;
        StaticLayout r2 = this.textLayout;
        if (r2 == null) goto L7;
        this.textToDrawCollapsed = TextUtils.ellipsize(r1, this.textPaint, r2.getWidth(), TextUtils.TruncateAt.END);
    L7:
        CharSequence r3 = this.textToDrawCollapsed;
        float r4 = 0.0f;
        if (r3 == null) goto L10;
        float r5 = this.textPaint.measureText(r3, 0, r3.length());
    L11:
        int r6 = GravityCompat.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        int r7 = r6 & 112;
        if (r7 == 48) goto L16;
        if (r7 == 80) goto L15;
        this.collapsedDrawY = this.collapsedBounds.centerY() - ((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f);
    L17:
        int r8 = r6 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r8 == 1) goto L22;
        if (r8 == 5) goto L21;
        this.collapsedDrawX = this.collapsedBounds.left;
    L23:
        calculateUsingTextSize(this.expandedTextSize);
        StaticLayout r9 = this.textLayout;
        if (r9 == null) goto L26;
        float r10 = r9.getHeight();
    L27:
        CharSequence r11 = this.textToDraw;
        if (r11 == null) goto L30;
        float r12 = this.textPaint.measureText(r11, 0, r11.length());
    L31:
        StaticLayout r13 = this.textLayout;
        if (r13 != null) goto L34;
    L38:
        StaticLayout r14 = this.textLayout;
        if (r14 == null) goto L41;
        r4 = r14.getLineLeft(0);
    L41:
        this.expandedFirstLineDrawX = r4;
        int r15 = GravityCompat.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
        int r16 = r15 & 112;
        if (r16 == 48) goto L46;
        if (r16 == 80) goto L45;
        this.expandedDrawY = this.expandedBounds.centerY() - (r10 / 2.0f);
    L47:
        int r17 = r15 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r17 == 1) goto L52;
        if (r17 == 5) goto L51;
        this.expandedDrawX = this.expandedBounds.left;
    L53:
        clearTexture();
        setInterpolatedTextSize(r0);
        return;
    L51:
        this.expandedDrawX = this.expandedBounds.right - r12;
        goto L53
    L52:
        this.expandedDrawX = this.expandedBounds.centerX() - (r12 / 2.0f);
        goto L53
    L45:
        this.expandedDrawY = (this.expandedBounds.bottom - r10) + this.textPaint.descent();
        goto L47
    L46:
        this.expandedDrawY = this.expandedBounds.top;
        goto L47
    L34:
        if (this.maxLines <= 1) goto L38;
        if (this.isRtl == true) goto L38;
        r12 = r13.getWidth();
        goto L38
    L30:
        r12 = 0.0f;
        goto L31
    L26:
        r10 = 0.0f;
        goto L27
    L21:
        this.collapsedDrawX = this.collapsedBounds.right - r5;
        goto L23
    L22:
        this.collapsedDrawX = this.collapsedBounds.centerX() - (r5 / 2.0f);
        goto L23
    L15:
        this.collapsedDrawY = this.collapsedBounds.bottom + this.textPaint.ascent();
        goto L17
    L16:
        this.collapsedDrawY = this.collapsedBounds.top;
        goto L17
    L10:
        r5 = 0.0f;
        goto L11
    }

    private void interpolateBounds(float r5) {
        this.currentBounds.left = lerp(this.expandedBounds.left, this.collapsedBounds.left, r5, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, r5, this.positionInterpolator);
        this.currentBounds.right = lerp(this.expandedBounds.right, this.collapsedBounds.right, r5, this.positionInterpolator);
        this.currentBounds.bottom = lerp(this.expandedBounds.bottom, this.collapsedBounds.bottom, r5, this.positionInterpolator);
    }

    private void setCollapsedTextBlend(float r1) {
        this.collapsedTextBlend = r1;
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private void setExpandedTextBlend(float r1) {
        this.expandedTextBlend = r1;
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    public void draw(Canvas r8) {
        int r0 = r8.save();
        if (this.textToDraw != null) goto L5;
        return;
    L5:
        if (this.drawTitle == false) goto L24;
        boolean r3 = false;
        float r1 = (this.currentDrawX + this.textLayout.getLineLeft(0)) - (this.expandedFirstLineDrawX * 2.0f);
        this.textPaint.setTextSize(this.currentTextSize);
        float r2 = this.currentDrawX;
        float r4 = this.currentDrawY;
        if (this.useTexture == true) goto L9;
    L11:
        float r5 = this.scale;
        if (r5 == 1.0f) goto L14;
        r8.scale(r5, r5, r2, r4);
    L14:
        if (r3 == false) goto L18;
        r8.drawBitmap(this.expandedTitleTexture, r2, r4, this.texturePaint);
        r8.restoreToCount(r0);
        return;
    L18:
        if (shouldDrawMultiline() == false) goto L20;
        drawMultinlineTransition(r8, r1, r4);
    L21:
        r8.restoreToCount(r0);
        return;
    L20:
        r8.translate(r2, r4);
        this.textLayout.draw(r8);
        goto L21
    L9:
        if (this.expandedTitleTexture == null) goto L11;
        r3 = true;
        goto L11
    }

    private boolean shouldDrawMultiline() {
        if (this.maxLines > 1) goto L5;
    L9:
        return false;
    L5:
        if (this.isRtl == true) goto L9;
        if (this.useTexture == true) goto L9;
        return true;
    }

    private void drawMultinlineTransition(Canvas r12, float r13, float r14) {
        int r0 = this.textPaint.getAlpha();
        r12.translate(r13, r14);
        float r3 = r0;
        this.textPaint.setAlpha((int) (this.expandedTextBlend * r3));
        this.textLayout.draw(r12);
        this.textPaint.setAlpha((int) (this.collapsedTextBlend * r3));
        int r1 = this.textLayout.getLineBaseline(0);
        CharSequence r5 = this.textToDrawCollapsed;
        float r2 = r1;
        r12.drawText(r5, 0, r5.length(), 0.0f, r2, this.textPaint);
        String r4 = this.textToDrawCollapsed.toString().trim();
        if (r4.endsWith(ELLIPSIS_NORMAL) == false) goto L5;
        r4 = r4.substring(0, r4.length() - 1);
    L5:
        String r6 = r4;
        this.textPaint.setAlpha(r0);
        r12.drawText(r6, 0, Math.min(this.textLayout.getLineEnd(0), r6.length()), 0.0f, r2, this.textPaint);
    }

    private boolean calculateIsRtl(CharSequence r3) {
        if (isDefaultIsRtl() == false) goto L5;
        TextDirectionHeuristicCompat r2 = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
    L7:
        return r2.isRtl(r3, 0, r3.length());
    L5:
        r2 = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        goto L7
    }

    private boolean isDefaultIsRtl() {
        if (ViewCompat.getLayoutDirection(this.view) == 1) goto L7;
        return false;
    L7:
        return true;
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

    private void calculateUsingTextSize(float r9) {
        if (this.text != null) goto L5;
        return;
    L5:
        float r0 = this.collapsedBounds.width();
        float r1 = this.expandedBounds.width();
        boolean r4 = false;
        int r5 = 1;
        if (isClose(r9, this.collapsedTextSize) == false) goto L11;
        float r10 = this.collapsedTextSize;
        this.scale = 1.0f;
        Typeface r2 = this.currentTypeface;
        Typeface r3 = this.collapsedTypeface;
        if (r2 == r3) goto L10;
        this.currentTypeface = r3;
        boolean r6 = true;
    L25:
        if (r0 <= 0.0f) goto L36;
        if (this.currentTextSize == r10) goto L29;
    L33:
        r6 = true;
    L34:
        this.currentTextSize = r10;
        this.boundsChanged = false;
        goto L36
    L29:
        if (this.boundsChanged == true) goto L33;
        if (r6 == true) goto L33;
        r6 = false;
    L36:
        if (this.textToDraw == null) goto L38;
        if (r6 == true) goto L38;
        return;
    L38:
        this.textPaint.setTextSize(this.currentTextSize);
        this.textPaint.setTypeface(this.currentTypeface);
        TextPaint r11 = this.textPaint;
        if (this.scale == 1.0f) goto L41;
        r4 = true;
    L41:
        r11.setLinearText(r4);
        this.isRtl = calculateIsRtl(this.text);
        if (shouldDrawMultiline() == false) goto L44;
        r5 = this.maxLines;
    L44:
        StaticLayout r12 = createStaticLayout(r5, r0, this.isRtl);
        this.textLayout = r12;
        this.textToDraw = r12.getText();
        return;
    L10:
        r6 = false;
        goto L25
    L11:
        float r7 = this.expandedTextSize;
        Typeface r8 = this.currentTypeface;
        Typeface r13 = this.expandedTypeface;
        if (r8 == r13) goto L14;
        this.currentTypeface = r13;
        boolean r14 = true;
    L16:
        if (isClose(r9, r7) == false) goto L18;
        this.scale = 1.0f;
    L19:
        float r15 = this.collapsedTextSize / this.expandedTextSize;
        if ((r1 * r15) <= r0) goto L22;
        r0 = Math.min(r0 / r15, r1);
    L23:
        r10 = r7;
        r6 = r14;
        goto L25
    L22:
        r0 = r1;
        goto L23
    L18:
        this.scale = r9 / this.expandedTextSize;
        goto L19
    L14:
        r14 = false;
        goto L16
    }

    private StaticLayout createStaticLayout(int r2, float r3, boolean r4) {
        StaticLayout r1 = StaticLayoutBuilderCompat.obtain(this.text, this.textPaint, (int) r3).setEllipsize(TextUtils.TruncateAt.END).setIsRtl(r4).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(false).setMaxLines(r2).build();     // Catch: StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException -> L4
    L7:
        return (StaticLayout) Preconditions.checkNotNull(r1);
    L4:
        e = move-exception;
        Log.e(TAG, e.getCause().getMessage(), e);
        r1 = null;
        goto L7
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

    public void recalculate() {
        if (this.view.getHeight() > 0) goto L5;
        return;
    L5:
        if (this.view.getWidth() <= 0) goto L9;
        calculateBaseOffsets();
        calculateCurrentOffsets();
        return;
    }

    public void setText(CharSequence r2) {
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

    public CharSequence getText() {
        return this.text;
    }

    private void clearTexture() {
        Bitmap r0 = this.expandedTitleTexture;
        if (r0 == null) goto L6;
        r0.recycle();
        this.expandedTitleTexture = null;
        return;
    }

    public void setMaxLines(int r2) {
        if (r2 == this.maxLines) goto L6;
        this.maxLines = r2;
        clearTexture();
        recalculate();
        return;
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    private static boolean isClose(float r0, float r1) {
        if (Math.abs(r0 - r1) >= 0.001f) goto L5;
        return true;
    L5:
        return false;
    }

    public ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    private static int blendColors(int r5, int r6, float r7) {
        float r0 = 1.0f - r7;
        return Color.argb((int) ((Color.alpha(r5) * r0) + (Color.alpha(r6) * r7)), (int) ((Color.red(r5) * r0) + (Color.red(r6) * r7)), (int) ((Color.green(r5) * r0) + (Color.green(r6) * r7)), (int) ((Color.blue(r5) * r0) + (Color.blue(r6) * r7)));
    }

    private static float lerp(float r0, float r1, float r2, TimeInterpolator r3) {
        if (r3 == null) goto L5;
        r2 = r3.getInterpolation(r2);
    L5:
        return AnimationUtils.lerp(r0, r1, r2);
    }

    private static boolean rectEquals(Rect r1, int r2, int r3, int r4, int r5) {
        if (r1.left == r2) goto L5;
    L11:
        return false;
    L5:
        if (r1.top != r3) goto L11;
        if (r1.right != r4) goto L11;
        if (r1.bottom != r5) goto L11;
        return true;
    }
}
