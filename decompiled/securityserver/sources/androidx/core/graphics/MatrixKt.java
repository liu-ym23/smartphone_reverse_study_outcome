package androidx.core.graphics;

import android.graphics.Matrix;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class MatrixKt {
    @NotNull
    public static final Matrix rotationMatrix(float r1, float r2, float r3) {
        Matrix r0 = new Matrix();
        r0.setRotate(r1, r2, r3);
        return r0;
    }

    @NotNull
    public static /* synthetic */ Matrix rotationMatrix$default(float r1, float r2, float r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0.0f;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = 0.0f;
    L9:
        return rotationMatrix(r1, r2, r3);
    }

    @NotNull
    public static final Matrix scaleMatrix(float r1, float r2) {
        Matrix r0 = new Matrix();
        r0.setScale(r1, r2);
        return r0;
    }

    @NotNull
    public static /* synthetic */ Matrix scaleMatrix$default(float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 1.0f;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = 1.0f;
    L9:
        return scaleMatrix(r1, r2);
    }

    @NotNull
    public static final Matrix times(@NotNull Matrix r1, @NotNull Matrix r2) {
        Intrinsics.g(r1, "$this$times");
        Intrinsics.g(r2, "m");
        Matrix r0 = new Matrix(r1);
        r0.preConcat(r2);
        return r0;
    }

    @NotNull
    public static final Matrix translationMatrix(float r1, float r2) {
        Matrix r0 = new Matrix();
        r0.setTranslate(r1, r2);
        return r0;
    }

    @NotNull
    public static /* synthetic */ Matrix translationMatrix$default(float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0.0f;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = 0.0f;
    L9:
        return translationMatrix(r1, r2);
    }

    @NotNull
    public static final float[] values(@NotNull Matrix r1) {
        Intrinsics.g(r1, "$this$values");
        float[] r0 = new float[9];
        r1.getValues(r0);
        return r0;
    }
}
