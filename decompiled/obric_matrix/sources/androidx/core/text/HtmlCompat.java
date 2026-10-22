package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"InlinedApi"})
public final class HtmlCompat {
    public static final int FROM_HTML_MODE_COMPACT = 63;
    public static final int FROM_HTML_MODE_LEGACY = 0;
    public static final int FROM_HTML_OPTION_USE_CSS_COLORS = 256;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_BLOCKQUOTE = 32;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_DIV = 16;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_HEADING = 2;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST = 8;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST_ITEM = 4;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH = 1;
    public static final int TO_HTML_PARAGRAPH_LINES_CONSECUTIVE = 0;
    public static final int TO_HTML_PARAGRAPH_LINES_INDIVIDUAL = 1;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static Spanned fromHtml(String r0, int r1) {
            return Html.fromHtml(r0, r1);
        }

        @DoNotInline
        static Spanned fromHtml(String r0, int r1, Html.ImageGetter r2, Html.TagHandler r3) {
            return Html.fromHtml(r0, r1, r2, r3);
        }

        @DoNotInline
        static String toHtml(Spanned r0, int r1) {
            return Html.toHtml(r0, r1);
        }
    }

    private HtmlCompat() {
    }

    @NonNull
    public static Spanned fromHtml(@NonNull String r2, int r3) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.fromHtml(r2, r3);
    L7:
        return Html.fromHtml(r2);
    }

    @NonNull
    public static Spanned fromHtml(@NonNull String r2, int r3, @Nullable Html.ImageGetter r4, @Nullable Html.TagHandler r5) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.fromHtml(r2, r3, r4, r5);
    L7:
        return Html.fromHtml(r2, r4, r5);
    }

    @NonNull
    public static String toHtml(@NonNull Spanned r2, int r3) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.toHtml(r2, r3);
    L7:
        return Html.toHtml(r2);
    }
}
