package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class CanvasKt {
    public static final void withClip(@NotNull Canvas r1, @NotNull Rect r2, @NotNull Function1<? super Canvas, Unit> r3) {
        Intrinsics.g(r1, "$this$withClip");
        Intrinsics.g(r2, "clipRect");
        Intrinsics.g(r3, "block");
        int r0 = r1.save();
        r1.clipRect(r2);
        r3.invoke(r1);     // Catch: Throwable -> L6
        r1.restoreToCount(r0);
        return;
    L6:
        th = move-exception;
        r1.restoreToCount(r0);
        throw th;
    }

    public static final void withMatrix(@NotNull Canvas r1, @NotNull Matrix r2, @NotNull Function1<? super Canvas, Unit> r3) {
        Intrinsics.g(r1, "$this$withMatrix");
        Intrinsics.g(r2, "matrix");
        Intrinsics.g(r3, "block");
        int r0 = r1.save();
        r1.concat(r2);
        r3.invoke(r1);     // Catch: Throwable -> L6
        r1.restoreToCount(r0);
        return;
    L6:
        th = move-exception;
        r1.restoreToCount(r0);
        throw th;
    }

    public static /* synthetic */ void withMatrix$default(Canvas r0, Matrix r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = new Matrix();
    L5:
        Intrinsics.g(r0, "$this$withMatrix");
        Intrinsics.g(r1, "matrix");
        Intrinsics.g(r2, "block");
        int r5 = r0.save();
        r0.concat(r1);
        r2.invoke(r0);     // Catch: Throwable -> L9
        r0.restoreToCount(r5);
        return;
    L9:
        th = move-exception;
        r0.restoreToCount(r5);
        throw th;
    }

    public static final void withRotation(@NotNull Canvas r1, float r2, float r3, float r4, @NotNull Function1<? super Canvas, Unit> r5) {
        Intrinsics.g(r1, "$this$withRotation");
        Intrinsics.g(r5, "block");
        int r0 = r1.save();
        r1.rotate(r2, r3, r4);
        r5.invoke(r1);     // Catch: Throwable -> L6
        r1.restoreToCount(r0);
        return;
    L6:
        th = move-exception;
        r1.restoreToCount(r0);
        throw th;
    }

    public static /* synthetic */ void withRotation$default(Canvas r1, float r2, float r3, float r4, Function1 r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0.0f;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0.0f;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r4 = 0.0f;
    L11:
        Intrinsics.g(r1, "$this$withRotation");
        Intrinsics.g(r5, "block");
        int r8 = r1.save();
        r1.rotate(r2, r3, r4);
        r5.invoke(r1);     // Catch: Throwable -> L15
        r1.restoreToCount(r8);
        return;
    L15:
        th = move-exception;
        r1.restoreToCount(r8);
        throw th;
    }

    public static final void withSave(@NotNull Canvas r1, @NotNull Function1<? super Canvas, Unit> r2) {
        Intrinsics.g(r1, "$this$withSave");
        Intrinsics.g(r2, "block");
        int r0 = r1.save();
        r2.invoke(r1);     // Catch: Throwable -> L6
        r1.restoreToCount(r0);
        return;
    L6:
        th = move-exception;
        r1.restoreToCount(r0);
        throw th;
    }

    public static final void withScale(@NotNull Canvas r1, float r2, float r3, float r4, float r5, @NotNull Function1<? super Canvas, Unit> r6) {
        Intrinsics.g(r1, "$this$withScale");
        Intrinsics.g(r6, "block");
        int r0 = r1.save();
        r1.scale(r2, r3, r4, r5);
        r6.invoke(r1);     // Catch: Throwable -> L6
        r1.restoreToCount(r0);
        return;
    L6:
        th = move-exception;
        r1.restoreToCount(r0);
        throw th;
    }

    public static /* synthetic */ void withScale$default(Canvas r1, float r2, float r3, float r4, float r5, Function1 r6, int r7, Object r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = 1.0f;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = 1.0f;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = 0.0f;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r5 = 0.0f;
    L14:
        Intrinsics.g(r1, "$this$withScale");
        Intrinsics.g(r6, "block");
        int r9 = r1.save();
        r1.scale(r2, r3, r4, r5);
        r6.invoke(r1);     // Catch: Throwable -> L18
        r1.restoreToCount(r9);
        return;
    L18:
        th = move-exception;
        r1.restoreToCount(r9);
        throw th;
    }

    public static final void withSkew(@NotNull Canvas r1, float r2, float r3, @NotNull Function1<? super Canvas, Unit> r4) {
        Intrinsics.g(r1, "$this$withSkew");
        Intrinsics.g(r4, "block");
        int r0 = r1.save();
        r1.skew(r2, r3);
        r4.invoke(r1);     // Catch: Throwable -> L6
        r1.restoreToCount(r0);
        return;
    L6:
        th = move-exception;
        r1.restoreToCount(r0);
        throw th;
    }

    public static /* synthetic */ void withSkew$default(Canvas r1, float r2, float r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0.0f;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r3 = 0.0f;
    L8:
        Intrinsics.g(r1, "$this$withSkew");
        Intrinsics.g(r4, "block");
        int r7 = r1.save();
        r1.skew(r2, r3);
        r4.invoke(r1);     // Catch: Throwable -> L12
        r1.restoreToCount(r7);
        return;
    L12:
        th = move-exception;
        r1.restoreToCount(r7);
        throw th;
    }

    public static final void withTranslation(@NotNull Canvas r1, float r2, float r3, @NotNull Function1<? super Canvas, Unit> r4) {
        Intrinsics.g(r1, "$this$withTranslation");
        Intrinsics.g(r4, "block");
        int r0 = r1.save();
        r1.translate(r2, r3);
        r4.invoke(r1);     // Catch: Throwable -> L6
        r1.restoreToCount(r0);
        return;
    L6:
        th = move-exception;
        r1.restoreToCount(r0);
        throw th;
    }

    public static /* synthetic */ void withTranslation$default(Canvas r1, float r2, float r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0.0f;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r3 = 0.0f;
    L8:
        Intrinsics.g(r1, "$this$withTranslation");
        Intrinsics.g(r4, "block");
        int r7 = r1.save();
        r1.translate(r2, r3);
        r4.invoke(r1);     // Catch: Throwable -> L12
        r1.restoreToCount(r7);
        return;
    L12:
        th = move-exception;
        r1.restoreToCount(r7);
        throw th;
    }

    public static final void withClip(@NotNull Canvas r1, @NotNull RectF r2, @NotNull Function1<? super Canvas, Unit> r3) {
        Intrinsics.g(r1, "$this$withClip");
        Intrinsics.g(r2, "clipRect");
        Intrinsics.g(r3, "block");
        int r0 = r1.save();
        r1.clipRect(r2);
        r3.invoke(r1);     // Catch: Throwable -> L6
        r1.restoreToCount(r0);
        return;
    L6:
        th = move-exception;
        r1.restoreToCount(r0);
        throw th;
    }

    public static final void withClip(@NotNull Canvas r1, int r2, int r3, int r4, int r5, @NotNull Function1<? super Canvas, Unit> r6) {
        Intrinsics.g(r1, "$this$withClip");
        Intrinsics.g(r6, "block");
        int r0 = r1.save();
        r1.clipRect(r2, r3, r4, r5);
        r6.invoke(r1);     // Catch: Throwable -> L6
        r1.restoreToCount(r0);
        return;
    L6:
        th = move-exception;
        r1.restoreToCount(r0);
        throw th;
    }

    public static final void withClip(@NotNull Canvas r1, float r2, float r3, float r4, float r5, @NotNull Function1<? super Canvas, Unit> r6) {
        Intrinsics.g(r1, "$this$withClip");
        Intrinsics.g(r6, "block");
        int r0 = r1.save();
        r1.clipRect(r2, r3, r4, r5);
        r6.invoke(r1);     // Catch: Throwable -> L6
        r1.restoreToCount(r0);
        return;
    L6:
        th = move-exception;
        r1.restoreToCount(r0);
        throw th;
    }

    public static final void withClip(@NotNull Canvas r1, @NotNull Path r2, @NotNull Function1<? super Canvas, Unit> r3) {
        Intrinsics.g(r1, "$this$withClip");
        Intrinsics.g(r2, "clipPath");
        Intrinsics.g(r3, "block");
        int r0 = r1.save();
        r1.clipPath(r2);
        r3.invoke(r1);     // Catch: Throwable -> L6
        r1.restoreToCount(r0);
        return;
    L6:
        th = move-exception;
        r1.restoreToCount(r0);
        throw th;
    }
}
