package androidx.core.text;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class CharSequenceKt {
    public static final boolean isDigitsOnly(@NotNull CharSequence r1) {
        Intrinsics.g(r1, "$this$isDigitsOnly");
        return TextUtils.isDigitsOnly(r1);
    }

    public static final int trimmedLength(@NotNull CharSequence r1) {
        Intrinsics.g(r1, "$this$trimmedLength");
        return TextUtils.getTrimmedLength(r1);
    }
}
