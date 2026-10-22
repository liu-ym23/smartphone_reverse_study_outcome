package kotlin.math;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MathKt extends MathKt__MathJVMKt {
    public static int a(float r1) {
        if (Float.isNaN(r1) == true) goto L7;
        return Math.round(r1);
    L7:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }
}
