package com.obric.common.oea.foundation.graphics.smoothcorner.impl;

import android.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: QuadraticSmoothCornerImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/QuadraticSmoothCornerImpl;", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/ISmoothCornerImpl;", "safeRadiusFactor", "", "(F)V", "CORNER_CORRECTION_FACTOR", "type", "", "getType", "()Ljava/lang/String;", "buildPath", "Landroid/graphics/Path;", "left", "top", "right", "bottom", "radius", "canDraw", "", "minDimension", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class QuadraticSmoothCornerImpl extends ISmoothCornerImpl {
    private final float CORNER_CORRECTION_FACTOR;
    private final float safeRadiusFactor;
    private final String type;

    public QuadraticSmoothCornerImpl() {
        float r2 = 0.0f;
        this(r2, 1, null);
    }

    public QuadraticSmoothCornerImpl(float r1) {
        this.safeRadiusFactor = r1;
        this.CORNER_CORRECTION_FACTOR = 1.175f;
        this.type = "QuadraticSmoothCornerImpl";
    }

    public /* synthetic */ QuadraticSmoothCornerImpl(float r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0.375f;
    L5:
        this(r1);
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public String getType() {
        return this.type;
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public boolean canDraw(float r1, float r2) {
        if (r1 >= (this.safeRadiusFactor * r2)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public Path buildPath(float r10, float r11, float r12, float r13, float r14) {
        float r0 = Math.min(r12 - r10, r13 - r11);
        if (r14 == 0.0f) goto L10;
        if (r14 >= (this.safeRadiusFactor * r0)) goto L10;
        float r9 = Math.min(r0 / 2.0f, r14 * this.CORNER_CORRECTION_FACTOR);
        float r1 = r11 + r9;
        Point r15 = new Point(r12, r1);
        float r2 = r13 - r9;
        Point r3 = new Point(r12, r2);
        Point r4 = new Point(r12, r13);
        float r5 = r12 - r9;
        Point r6 = new Point(r5, r13);
        float r16 = r9 + r10;
        Point r7 = new Point(r16, r13);
        Point r8 = new Point(r10, r13);
        Point r17 = new Point(r10, r2);
        Point r18 = new Point(r10, r1);
        Point r19 = new Point(r10, r11);
        Point r110 = new Point(r16, r11);
        Point r20 = new Point(r5, r11);
        Point r21 = new Point(r12, r11);
        Point r111 = new Point(r12, r1);
        Path r112 = new Path();
        r112.moveTo(r15.getX(), r15.getY());
        r112.lineTo(r3.getX(), r3.getY());
        r112.quadTo(r4.getX(), r4.getY(), r6.getX(), r6.getY());
        r112.lineTo(r7.getX(), r7.getY());
        r112.quadTo(r8.getX(), r8.getY(), r17.getX(), r17.getY());
        r112.lineTo(r18.getX(), r18.getY());
        r112.quadTo(r19.getX(), r19.getY(), r110.getX(), r110.getY());
        r112.lineTo(r20.getX(), r20.getY());
        r112.quadTo(r21.getX(), r21.getY(), r111.getX(), r111.getY());
        r112.close();
        return r112;
    L10:
        return buildRoundRect(r10, r11, r12, r13, r14);
    }
}
