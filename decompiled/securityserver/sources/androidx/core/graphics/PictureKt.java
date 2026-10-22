package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PictureKt {
    @NotNull
    public static final Picture record(@NotNull Picture r1, int r2, int r3, @NotNull Function1<? super Canvas, Unit> r4) {
        Intrinsics.g(r1, "$this$record");
        Intrinsics.g(r4, "block");
        Canvas r5 = r1.beginRecording(r2, r3);
        Intrinsics.b(r5, "c");     // Catch: Throwable -> L6
        r4.invoke(r5);     // Catch: Throwable -> L6
        r1.endRecording();
        return r1;
    L6:
        th = move-exception;
        r1.endRecording();
        throw th;
    }
}
