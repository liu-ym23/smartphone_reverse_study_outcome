package com.obric.oui.common.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PaddingSpan extends ReplacementSpan {
    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Intrinsics.f(r1, "canvas");
        Intrinsics.f(r9, "paint");
        r9.measureText(r2, r3, r4);
        throw null;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Intrinsics.f(r1, "paint");
        return MathKt.a((0.0f * 2) + r1.measureText(r2, r3, r4));
    }
}
