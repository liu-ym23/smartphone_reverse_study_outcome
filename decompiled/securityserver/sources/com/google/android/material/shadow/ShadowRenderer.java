package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ShadowRenderer {
    private static final int COLOR_ALPHA_END = 0;
    private static final int COLOR_ALPHA_MIDDLE = 20;
    private static final int COLOR_ALPHA_START = 68;
    private static final int[] cornerColors = null;
    private static final float[] cornerPositions = null;
    private static final int[] edgeColors = null;
    private static final float[] edgePositions = null;

    @NonNull
    private final Paint cornerShadowPaint;

    @NonNull
    private final Paint edgeShadowPaint;
    private final Path scratch;
    private int shadowEndColor;
    private int shadowMiddleColor;

    @NonNull
    private final Paint shadowPaint;
    private int shadowStartColor;
    private Paint transparentPaint;

    static {
        edgeColors = new int[3];
        edgePositions = new float[]{0.0f, 0.5f, 1.0f};
        cornerColors = new int[4];
        cornerPositions = new float[]{0.0f, 0.0f, 0.5f, 1.0f};
    }

    public ShadowRenderer() {
        this(ViewCompat.MEASURED_STATE_MASK);
    }

    public void drawCornerShadow(@NonNull Canvas r21, @Nullable Matrix r22, @NonNull RectF r23, int r24, float r25, float r26) {
        if (r26 >= 0.0f) goto L5;
        boolean r5 = true;
    L6:
        Path r9 = this.scratch;
        if (r5 == false) goto L9;
        int[] r12 = cornerColors;
        r12[0] = 0;
        r12[1] = this.shadowEndColor;
        r12[2] = this.shadowMiddleColor;
        r12[3] = this.shadowStartColor;
    L10:
        float r16 = r23.width() / 2.0f;
        if (r16 > 0.0f) goto L13;
        return;
    L13:
        float r2 = 1.0f - (r24 / r16);
        float[] r18 = cornerPositions;
        r18[1] = r2;
        r18[2] = ((1.0f - r2) / 2.0f) + r2;
        this.cornerShadowPaint.setShader(new RadialGradient(r23.centerX(), r23.centerY(), r16, cornerColors, r18, Shader.TileMode.CLAMP));
        r21.save();
        r21.concat(r22);
        if (r5 == true) goto L16;
        r21.clipPath(r9, Region.Op.DIFFERENCE);
        r21.drawPath(r9, this.transparentPaint);
    L16:
        r21.drawArc(r23, r25, r26, true, this.cornerShadowPaint);
        r21.restore();
        return;
    L9:
        r9.rewind();
        r9.moveTo(r23.centerX(), r23.centerY());
        r9.arcTo(r23, r25, r26);
        r9.close();
        float r13 = -r24;
        r23.inset(r13, r13);
        int[] r14 = cornerColors;
        r14[0] = 0;
        r14[1] = this.shadowStartColor;
        r14[2] = this.shadowMiddleColor;
        r14[3] = this.shadowEndColor;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    public void drawEdgeShadow(@NonNull Canvas r10, @Nullable Matrix r11, @NonNull RectF r12, int r13) {
        r12.bottom += r13;
        r12.offset(0.0f, -r13);
        int[] r6 = edgeColors;
        r6[0] = this.shadowEndColor;
        r6[1] = this.shadowMiddleColor;
        r6[2] = this.shadowStartColor;
        Paint r14 = this.edgeShadowPaint;
        float r4 = r12.left;
        r14.setShader(new LinearGradient(r4, r12.top, r4, r12.bottom, r6, edgePositions, Shader.TileMode.CLAMP));
        r10.save();
        r10.concat(r11);
        r10.drawRect(r12, this.edgeShadowPaint);
        r10.restore();
    }

    @NonNull
    public Paint getShadowPaint() {
        return this.shadowPaint;
    }

    public void setShadowColor(int r2) {
        this.shadowStartColor = ColorUtils.setAlphaComponent(r2, COLOR_ALPHA_START);
        this.shadowMiddleColor = ColorUtils.setAlphaComponent(r2, 20);
        this.shadowEndColor = ColorUtils.setAlphaComponent(r2, 0);
        this.shadowPaint.setColor(this.shadowStartColor);
    }

    public ShadowRenderer(int r2) {
        this.scratch = new Path();
        this.transparentPaint = new Paint();
        this.shadowPaint = new Paint();
        setShadowColor(r2);
        this.transparentPaint.setColor(0);
        Paint r3 = new Paint(4);
        this.cornerShadowPaint = r3;
        r3.setStyle(Paint.Style.FILL);
        this.edgeShadowPaint = new Paint(r3);
    }
}
