package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SpannedStringKt {
    private static final <T> T[] getSpans(@NotNull Spanned r0, int r1, int r2) {
        Intrinsics.l();
        throw null;
    }

    public static Object[] getSpans$default(Spanned r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r0.length();
    L5:
        Intrinsics.l();
        throw null;
    }

    @NotNull
    public static final Spanned toSpanned(@NotNull CharSequence r1) {
        Intrinsics.g(r1, "$this$toSpanned");
        SpannedString r2 = SpannedString.valueOf(r1);
        Intrinsics.b(r2, "SpannedString.valueOf(this)");
        return r2;
    }
}
