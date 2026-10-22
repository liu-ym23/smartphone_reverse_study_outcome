package androidx.core.text;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class StringKt {
    @NotNull
    public static final String htmlEncode(@NotNull String r1) {
        Intrinsics.g(r1, "$this$htmlEncode");
        String r2 = TextUtils.htmlEncode(r1);
        Intrinsics.b(r2, "TextUtils.htmlEncode(this)");
        return r2;
    }
}
