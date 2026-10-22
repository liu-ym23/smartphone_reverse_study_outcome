package com.obric.common.oea.foundation.graphics.smoothcorner.impl;

import a.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ControlPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f143a;
    public final float b;
    public final float c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f144d;
    public final float e;
    public final float f;

    public ControlPoint(float r1, float r2, float r3, float r4, float r5, float r6) {
        this.f143a = r1;
        this.b = r2;
        this.c = r3;
        this.f144d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ControlPoint) == false) goto L18;
        ControlPoint r4 = (ControlPoint) r3;
        float r0 = r4.f143a;
        if (Float.compare(this.f143a, r0) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.b, r4.b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.c, r4.c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f144d, r4.f144d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.e, r4.e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f, r4.f) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r0 = Float.hashCode(this.f143a) * 31;
        int r1 = a.b(this.b, r0, 31);
        int r2 = a.b(this.c, r1, 31);
        int r3 = a.b(this.f144d, r2, 31);
        int r4 = a.b(this.e, r3, 31);
        return Float.hashCode(this.f) + r4;
    }

    public final String toString() {
        return "ControlPoint(handleLarge=" + this.f143a + ", distanceOuter=" + this.b + ", distanceInner=" + this.c + ", handleMedium=" + this.f144d + ", curveInner=" + this.e + ", curveOuter=" + this.f + ")";
    }
}
