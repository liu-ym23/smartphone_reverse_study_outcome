package com.obric.oui.window.bean;

import android.content.res.Resources;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AvailableWindowSize {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f314a;
    public final float b;

    public AvailableWindowSize(float r3, float r4) {
        this.f314a = r3;
        this.b = r4;
        Resources r2 = Resources.getSystem();
        Intrinsics.e(r2, "Resources.getSystem()");
        MathKt.a(TypedValue.applyDimension(1, r3, r2.getDisplayMetrics()));
        Resources r5 = Resources.getSystem();
        Intrinsics.e(r5, "Resources.getSystem()");
        MathKt.a(TypedValue.applyDimension(1, r4, r5.getDisplayMetrics()));
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AvailableWindowSize) == false) goto L10;
        AvailableWindowSize r4 = (AvailableWindowSize) r3;
        float r0 = r4.f314a;
        if (Float.compare(this.f314a, r0) == 0) goto L8;
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
        int r0 = Float.hashCode(this.f314a) * 31;
        return Float.hashCode(this.b) + r0;
    }

    public final String toString() {
        return "AvailableWindowSize(width=" + this.f314a + ", height=" + this.b + ")";
    }
}
