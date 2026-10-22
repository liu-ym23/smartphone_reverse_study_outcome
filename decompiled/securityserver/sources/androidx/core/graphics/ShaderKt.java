package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ShaderKt {
    public static final void transform(@NotNull Shader r1, @NotNull Function1<? super Matrix, Unit> r2) {
        Intrinsics.g(r1, "$this$transform");
        Intrinsics.g(r2, "block");
        Matrix r0 = new Matrix();
        r1.getLocalMatrix(r0);
        r2.invoke(r0);
        r1.setLocalMatrix(r0);
    }
}
