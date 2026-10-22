package com.obric.common.oea.foundation.graphics.smoothcorner.impl;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Point {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f146a;
    public final float b;

    public Point(float r1, float r2) {
        this.f146a = r1;
        this.b = r2;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof Point) == false) goto L10;
        Point r4 = (Point) r3;
        float r0 = r4.f146a;
        if (Float.compare(this.f146a, r0) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.b, r4.b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r0 = Float.hashCode(this.f146a) * 31;
        return Float.hashCode(this.b) + r0;
    }

    public final String toString() {
        return "Point(x=" + this.f146a + ", y=" + this.b + ")";
    }
}
