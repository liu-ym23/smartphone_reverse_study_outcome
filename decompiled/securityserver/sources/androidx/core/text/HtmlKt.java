package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class HtmlKt {
    @NotNull
    public static final Spanned parseAsHtml(@NotNull String r1, int r2, @Nullable Html.ImageGetter r3, @Nullable Html.TagHandler r4) {
        Intrinsics.g(r1, "$this$parseAsHtml");
        Spanned r5 = HtmlCompat.fromHtml(r1, r2, r3, r4);
        Intrinsics.b(r5, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
        return r5;
    }

    @NotNull
    public static /* synthetic */ Spanned parseAsHtml$default(String r1, int r2, Html.ImageGetter r3, Html.TagHandler r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        Intrinsics.g(r1, "$this$parseAsHtml");
        Spanned r7 = HtmlCompat.fromHtml(r1, r2, r3, r4);
        Intrinsics.b(r7, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
        return r7;
    }

    @NotNull
    public static final String toHtml(@NotNull Spanned r1, int r2) {
        Intrinsics.g(r1, "$this$toHtml");
        String r3 = HtmlCompat.toHtml(r1, r2);
        Intrinsics.b(r3, "HtmlCompat.toHtml(this, option)");
        return r3;
    }

    @NotNull
    public static /* synthetic */ String toHtml$default(Spanned r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        Intrinsics.g(r0, "$this$toHtml");
        String r4 = HtmlCompat.toHtml(r0, r1);
        Intrinsics.b(r4, "HtmlCompat.toHtml(this, option)");
        return r4;
    }
}
