package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SpannableStringKt {
    @SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(@NotNull Spannable r4) {
        Intrinsics.g(r4, "$this$clearSpans");
        int r2 = 0;
        Object[] r0 = r4.getSpans(0, r4.length(), Object.class);
        Intrinsics.b(r0, "getSpans(start, end, T::class.java)");
        int r1 = r0.length;
    L3:
        if (r2 >= r1) goto L5;
        r4.removeSpan(r0[r2]);
        r2 = r2 + 1;
        goto L3
    }

    public static final void set(@NotNull Spannable r1, int r2, int r3, @NotNull Object r4) {
        Intrinsics.g(r1, "$this$set");
        Intrinsics.g(r4, "span");
        r1.setSpan(r4, r2, r3, 17);
    }

    @NotNull
    public static final Spannable toSpannable(@NotNull CharSequence r1) {
        Intrinsics.g(r1, "$this$toSpannable");
        SpannableString r2 = SpannableString.valueOf(r1);
        Intrinsics.b(r2, "SpannableString.valueOf(this)");
        return r2;
    }

    public static final void set(@NotNull Spannable r2, @NotNull IntRange r3, @NotNull Object r4) {
        Intrinsics.g(r2, "$this$set");
        Intrinsics.g(r3, "range");
        Intrinsics.g(r4, "span");
        r2.setSpan(r4, r3.b, r3.c, 17);
    }
}
