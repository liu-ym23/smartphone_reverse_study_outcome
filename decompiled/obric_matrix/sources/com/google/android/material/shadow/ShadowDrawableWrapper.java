package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class ShadowDrawableWrapper extends DrawableWrapper {
    static final double COS_45 = 0.0d;
    static final float SHADOW_BOTTOM_SCALE = 1.0f;
    static final float SHADOW_HORIZ_SCALE = 0.5f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    static final float SHADOW_TOP_SCALE = 0.25f;
    private boolean addPaddingForCorners;

    @NonNull
    final RectF contentBounds;
    float cornerRadius;

    @NonNull
    final Paint cornerShadowPaint;
    Path cornerShadowPath;
    private boolean dirty;

    @NonNull
    final Paint edgeShadowPaint;
    float maxShadowSize;
    private boolean printedShadowClipWarning;
    float rawMaxShadowSize;
    float rawShadowSize;
    private float rotation;
    private final int shadowEndColor;
    private final int shadowMiddleColor;
    float shadowSize;
    private final int shadowStartColor;

    static {
        COS_45 = Math.cos(Math.toRadians(45.0d));
    }

    public ShadowDrawableWrapper(Context r2, Drawable r3, float r4, float r5, float r6) {
        super(r3);
        this.dirty = true;
        this.addPaddingForCorners = true;
        this.printedShadowClipWarning = false;
        this.shadowStartColor = ContextCompat.getColor(r2, R.color.design_fab_shadow_start_color);
        this.shadowMiddleColor = ContextCompat.getColor(r2, R.color.design_fab_shadow_mid_color);
        this.shadowEndColor = ContextCompat.getColor(r2, R.color.design_fab_shadow_end_color);
        Paint r7 = new Paint(5);
        this.cornerShadowPaint = r7;
        r7.setStyle(Paint.Style.FILL);
        this.cornerRadius = Math.round(r4);
        this.contentBounds = new RectF();
        Paint r8 = new Paint(r7);
        this.edgeShadowPaint = r8;
        r8.setAntiAlias(false);
        setShadowSize(r5, r6);
    }

    private void buildComponents(@NonNull Rect r7) {
        float r0 = this.rawMaxShadowSize;
        float r1 = SHADOW_MULTIPLIER * r0;
        this.contentBounds.set(r7.left + r0, r7.top + r1, r7.right - r0, r7.bottom - r1);
        Drawable r8 = getWrappedDrawable();
        RectF r2 = this.contentBounds;
        r8.setBounds((int) r2.left, (int) r2.top, (int) r2.right, (int) r2.bottom);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float r2 = this.cornerRadius;
        RectF r1 = new RectF(-r2, -r2, r2, r2);
        RectF r3 = new RectF(r1);
        float r4 = this.shadowSize;
        r3.inset(-r4, -r4);
        Path r5 = this.cornerShadowPath;
        if (r5 != null) goto L5;
        this.cornerShadowPath = new Path();
    L6:
        this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.cornerShadowPath.moveTo(-this.cornerRadius, 0.0f);
        this.cornerShadowPath.rLineTo(-this.shadowSize, 0.0f);
        this.cornerShadowPath.arcTo(r3, 180.0f, 90.0f, false);
        this.cornerShadowPath.arcTo(r1, 270.0f, -90.0f, false);
        this.cornerShadowPath.close();
        float r11 = -r3.top;
        if (r11 <= 0.0f) goto L9;
        float r6 = this.cornerRadius / r11;
        this.cornerShadowPaint.setShader(new RadialGradient(0.0f, 0.0f, r11, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, r6, ((1.0f - r6) / 2.0f) + r6, 1.0f}, Shader.TileMode.CLAMP));
    L9:
        this.edgeShadowPaint.setShader(new LinearGradient(0.0f, r1.top, 0.0f, r3.top, new int[]{this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.edgeShadowPaint.setAntiAlias(false);
        return;
    L5:
        r5.reset();
        goto L6
    }

    public static float calculateHorizontalPadding(float r6, float r7, boolean r8) {
        if (r8 == true) goto L4;
        return r6;
    L4:
        return (float) (((double) r6) + ((1.0d - COS_45) * ((double) r7)));
    }

    public static float calculateVerticalPadding(float r6, float r7, boolean r8) {
        float r9 = r6 * SHADOW_MULTIPLIER;
        if (r8 == true) goto L5;
        return r9;
    L5:
        return (float) (((double) r9) + ((1.0d - COS_45) * ((double) r7)));
    }

    private void drawShadow(@NonNull Canvas r21) {
        int r8 = r21.save();
        r21.rotate(this.rotation, this.contentBounds.centerX(), this.contentBounds.centerY());
        float r9 = this.cornerRadius;
        float r10 = (-r9) - this.shadowSize;
        float r11 = r9 * 2.0f;
        if ((this.contentBounds.width() - r11) <= 0.0f) goto L5;
        boolean r12 = true;
    L7:
        if ((this.contentBounds.height() - r11) <= 0.0f) goto L9;
        boolean r13 = true;
    L10:
        float r1 = this.rawShadowSize;
        float r15 = r9 / ((r1 - (0.5f * r1)) + r9);
        float r6 = r9 / ((r1 - (SHADOW_TOP_SCALE * r1)) + r9);
        float r5 = r9 / ((r1 - (r1 * 1.0f)) + r9);
        int r4 = r21.save();
        RectF r2 = this.contentBounds;
        r21.translate(r2.left + r9, r2.top + r9);
        r21.scale(r15, r6);
        r21.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (r12 == false) goto L14;
        r21.scale(1.0f / r15, 1.0f);
        r21.drawRect(0.0f, r10, this.contentBounds.width() - r11, -this.cornerRadius, this.edgeShadowPaint);
    L14:
        r21.restoreToCount(r4);
        int r14 = r21.save();
        RectF r3 = this.contentBounds;
        r21.translate(r3.right - r9, r3.bottom - r9);
        r21.scale(r15, r5);
        r21.rotate(180.0f);
        r21.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (r12 == false) goto L18;
        r21.scale(1.0f / r15, 1.0f);
        r21.drawRect(0.0f, r10, this.contentBounds.width() - r11, (-this.cornerRadius) + this.shadowSize, this.edgeShadowPaint);
    L18:
        r21.restoreToCount(r14);
        int r16 = r21.save();
        RectF r7 = this.contentBounds;
        r21.translate(r7.left + r9, r7.bottom - r9);
        r21.scale(r15, r6);
        r21.rotate(270.0f);
        r21.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (r13 == false) goto L21;
        r21.scale(1.0f / r5, 1.0f);
        r21.drawRect(0.0f, r10, this.contentBounds.height() - r11, -this.cornerRadius, this.edgeShadowPaint);
    L21:
        r21.restoreToCount(r16);
        int r17 = r21.save();
        RectF r18 = this.contentBounds;
        r21.translate(r18.right - r9, r18.top + r9);
        r21.scale(r15, r6);
        r21.rotate(90.0f);
        r21.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (r13 == false) goto L24;
        r21.scale(1.0f / r6, 1.0f);
        r21.drawRect(0.0f, r10, this.contentBounds.height() - r11, -this.cornerRadius, this.edgeShadowPaint);
    L24:
        r21.restoreToCount(r17);
        r21.restoreToCount(r8);
        return;
    L9:
        r13 = false;
        goto L10
    L5:
        r12 = false;
        goto L7
    }

    private static int toEven(float r2) {
        int r3 = Math.round(r2);
        if ((r3 % 2) == 1) goto L5;
        return r3;
    L5:
        return r3 - 1;
    }

    public void draw(@NonNull Canvas r2) {
        if (this.dirty == false) goto L5;
        buildComponents(getBounds());
        this.dirty = false;
    L5:
        drawShadow(r2);
        super.draw(r2);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public float getMaxShadowSize() {
        return this.rawMaxShadowSize;
    }

    public float getMinHeight() {
        float r0 = this.rawMaxShadowSize;
        return (Math.max(r0, this.cornerRadius + ((r0 * SHADOW_MULTIPLIER) / 2.0f)) * 2.0f) + ((this.rawMaxShadowSize * SHADOW_MULTIPLIER) * 2.0f);
    }

    public float getMinWidth() {
        float r0 = this.rawMaxShadowSize;
        return (Math.max(r0, this.cornerRadius + (r0 / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * 2.0f);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(@NonNull Rect r4) {
        int r0 = (int) Math.ceil(calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        int r3 = (int) Math.ceil(calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        r4.set(r3, r0, r3, r0);
        return true;
    }

    public float getShadowSize() {
        return this.rawShadowSize;
    }

    protected void onBoundsChange(Rect r1) {
        this.dirty = true;
    }

    public void setAddPaddingForCorners(boolean r1) {
        this.addPaddingForCorners = r1;
        invalidateSelf();
    }

    public void setAlpha(int r2) {
        super.setAlpha(r2);
        this.cornerShadowPaint.setAlpha(r2);
        this.edgeShadowPaint.setAlpha(r2);
    }

    public void setCornerRadius(float r2) {
        float r3 = Math.round(r2);
        if (this.cornerRadius != r3) goto L5;
        return;
    L5:
        this.cornerRadius = r3;
        this.dirty = true;
        invalidateSelf();
    }

    public void setMaxShadowSize(float r2) {
        setShadowSize(this.rawShadowSize, r2);
    }

    public final void setRotation(float r2) {
        if (this.rotation == r2) goto L6;
        this.rotation = r2;
        invalidateSelf();
        return;
    }

    public void setShadowSize(float r2) {
        setShadowSize(r2, this.rawMaxShadowSize);
    }

    public void setShadowSize(float r3, float r4) {
        if (r3 < 0.0f) goto L20;
        if (r4 < 0.0f) goto L20;
        float r5 = toEven(r3);
        float r6 = toEven(r4);
        if (r5 <= r6) goto L13;
        if (this.printedShadowClipWarning == true) goto L11;
        this.printedShadowClipWarning = true;
    L11:
        r5 = r6;
    L13:
        if (this.rawShadowSize == r5) goto L15;
    L17:
        this.rawShadowSize = r5;
        this.rawMaxShadowSize = r6;
        this.shadowSize = Math.round(r5 * SHADOW_MULTIPLIER);
        this.maxShadowSize = r6;
        this.dirty = true;
        invalidateSelf();
        return;
    L15:
        if (this.rawMaxShadowSize != r6) goto L17;
        return;
    L20:
        throw new IllegalArgumentException("invalid shadow size");
    }
}
