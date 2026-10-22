package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ContextKt {
    private static final <T> T getSystemService(@NotNull Context r0) {
        Intrinsics.l();
        throw null;
    }

    public static final void withStyledAttributes(@NotNull Context r1, @Nullable AttributeSet r2, @NotNull int[] r3, @AttrRes int r4, @StyleRes int r5, @NotNull Function1<? super TypedArray, Unit> r6) {
        Intrinsics.g(r1, "$this$withStyledAttributes");
        Intrinsics.g(r3, "attrs");
        Intrinsics.g(r6, "block");
        TypedArray r7 = r1.obtainStyledAttributes(r2, r3, r4, r5);
        r6.invoke(r7);
        r7.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context r1, AttributeSet r2, int[] r3, int r4, int r5, Function1 r6, int r7, Object r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        Intrinsics.g(r1, "$this$withStyledAttributes");
        Intrinsics.g(r3, "attrs");
        Intrinsics.g(r6, "block");
        TypedArray r9 = r1.obtainStyledAttributes(r2, r3, r4, r5);
        r6.invoke(r9);
        r9.recycle();
    }

    public static final void withStyledAttributes(@NotNull Context r1, @StyleRes int r2, @NotNull int[] r3, @NotNull Function1<? super TypedArray, Unit> r4) {
        Intrinsics.g(r1, "$this$withStyledAttributes");
        Intrinsics.g(r3, "attrs");
        Intrinsics.g(r4, "block");
        TypedArray r5 = r1.obtainStyledAttributes(r2, r3);
        r4.invoke(r5);
        r5.recycle();
    }
}
