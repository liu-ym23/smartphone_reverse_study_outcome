package com.obric.common.oea.foundation.graphics.smoothcorner.impl;

import android.graphics.Path;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: QuadraticSmoothCornerExImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J0\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J8\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/QuadraticSmoothCornerExImpl;", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/ISmoothCornerImpl;", "()V", "CP_OFFSET", "", "MAX_CORNER_CORRECTION_FACTOR", "R_JOINT_OFFSET", "type", "", "getType", "()Ljava/lang/String;", "buildHorizontalCapsule", "Landroid/graphics/Path;", "left", "top", "right", "bottom", "cornerSize", "cornerSizeOptimized", "buildPath", "radius", "buildVerticalCapsule", "canDraw", "", "minDimension", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class QuadraticSmoothCornerExImpl extends ISmoothCornerImpl {
    private final float CP_OFFSET;
    private final float MAX_CORNER_CORRECTION_FACTOR;
    private final float R_JOINT_OFFSET;
    private final String type;

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public boolean canDraw(float r1, float r2) {
        if (r1 != (r2 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }

    public QuadraticSmoothCornerExImpl() {
        this.type = "QuadraticSmoothCornerExImpl";
        this.CP_OFFSET = 0.585786f;
        this.R_JOINT_OFFSET = 0.292893f;
        this.MAX_CORNER_CORRECTION_FACTOR = 1.175f;
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public String getType() {
        return this.type;
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public Path buildPath(float r9, float r10, float r11, float r12, float r13) {
        float r1 = r11 - r9;
        float r2 = r12 - r10;
        float r3 = Math.min(r1, r2);
        float r4 = Math.max(r1, r2);
        if (r13 == 0.0f) goto L22;
        float r5 = r3 * 0.5f;
        if (r13 != r5) goto L22;
        if (r13 != r5) goto L13;
        if (r1 != r2) goto L13;
        return buildRoundRect(r9, r10, r11, r12, r13);
    L13:
        if (r1 <= r2) goto L15;
        boolean r6 = true;
    L16:
        float r7 = RangesKt.coerceAtMost(r13, r5);
        float r8 = Math.min(this.MAX_CORNER_CORRECTION_FACTOR * r7, r4 * 0.5f);
        if (r6 == false) goto L20;
        return buildHorizontalCapsule(r9, r10, r11, r12, r7, r8);
    L20:
        return buildVerticalCapsule(r9, r10, r11, r12, r7, r8);
    L15:
        r6 = false;
    L22:
        return buildRoundRect(r9, r10, r11, r12, r13);
    }

    private final Path buildHorizontalCapsule(float r17, float r18, float r19, float r20, float r21, float r22) {
        float r5 = this.CP_OFFSET * r21;
        float r0 = this.R_JOINT_OFFSET * r21;
        float r7 = r17 + r22;
        Point r6 = new Point(r7, r18);
        float r9 = 2.0f * r21;
        RectF r8 = new RectF(r17, r18, r17 + r9, r20);
        RectF r10 = new RectF(r19 - r9, r18, r19, r20);
        float r11 = r19 - r22;
        Point r12 = new Point(r11, r18);
        float r13 = r19 - r5;
        Point r14 = new Point(r13, r18);
        float r3 = r19 - r0;
        float r15 = r18 + r0;
        Point r16 = new Point(r3, r15);
        float r110 = r20 - r0;
        new Point(r3, r110);
        Point r4 = new Point(r13, r20);
        Point r23 = new Point(r11, r20);
        Point r111 = new Point(r7, r20);
        float r24 = r5 + r17;
        Point r112 = new Point(r24, r20);
        float r1 = r0 + r17;
        Point r25 = new Point(r1, r110);
        new Point(r1, r15);
        Point r2 = new Point(r24, r18);
        Point r26 = new Point(r7, r18);
        Path r27 = new Path();
        r27.moveTo(r6.getX(), r6.getY());
        r27.lineTo(r12.getX(), r12.getY());
        r27.quadTo(r14.getX(), r14.getY(), r16.getX(), r16.getY());
        r27.arcTo(r10, -45.0f, 90.0f);
        r27.quadTo(r4.getX(), r4.getY(), r23.getX(), r23.getY());
        r27.lineTo(r111.getX(), r111.getY());
        r27.quadTo(r112.getX(), r112.getY(), r25.getX(), r25.getY());
        r27.arcTo(r8, 135.0f, 90.0f);
        r27.quadTo(r2.getX(), r2.getY(), r26.getX(), r26.getY());
        r27.close();
        return r27;
    }

    private final Path buildVerticalCapsule(float r17, float r18, float r19, float r20, float r21, float r22) {
        float r5 = this.CP_OFFSET * r21;
        float r0 = this.R_JOINT_OFFSET * r21;
        float r7 = r18 + r22;
        Point r6 = new Point(r19, r7);
        float r9 = 2.0f * r21;
        RectF r8 = new RectF(r17, r18, r19, r18 + r9);
        RectF r10 = new RectF(r17, r20 - r9, r19, r20);
        float r11 = r20 - r22;
        Point r12 = new Point(r19, r11);
        float r13 = r20 - r5;
        Point r14 = new Point(r19, r13);
        float r15 = r19 - r0;
        float r4 = r20 - r0;
        Point r16 = new Point(r15, r4);
        float r110 = r17 + r0;
        new Point(r110, r4);
        Point r23 = new Point(r17, r13);
        Point r24 = new Point(r17, r11);
        Point r111 = new Point(r17, r7);
        float r25 = r5 + r18;
        Point r112 = new Point(r17, r25);
        float r1 = r0 + r18;
        Point r2 = new Point(r110, r1);
        new Point(r15, r1);
        Point r3 = new Point(r19, r25);
        Point r26 = new Point(r19, r7);
        Path r27 = new Path();
        r27.moveTo(r6.getX(), r6.getY());
        r27.lineTo(r12.getX(), r12.getY());
        r27.quadTo(r14.getX(), r14.getY(), r16.getX(), r16.getY());
        r27.arcTo(r10, 45.0f, 90.0f);
        r27.quadTo(r23.getX(), r23.getY(), r24.getX(), r24.getY());
        r27.lineTo(r111.getX(), r111.getY());
        r27.quadTo(r112.getX(), r112.getY(), r2.getX(), r2.getY());
        r27.arcTo(r8, 225.0f, 90.0f);
        r27.quadTo(r3.getX(), r3.getY(), r26.getX(), r26.getY());
        r27.close();
        return r27;
    }
}
