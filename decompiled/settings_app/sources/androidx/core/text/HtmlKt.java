package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import com.android.launcher3.icons.cache.BaseIconCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Html.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0086\b\u001a\u0017\u0010\t\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0086\b¨\u0006\u000b"}, d2 = {"parseAsHtml", "Landroid/text/Spanned;", "", BaseIconCache.IconDB.COLUMN_FLAGS, "", "imageGetter", "Landroid/text/Html$ImageGetter;", "tagHandler", "Landroid/text/Html$TagHandler;", "toHtml", "option", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class HtmlKt {
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
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Spanned r7 = HtmlCompat.fromHtml(r1, r2, r3, r4);
        Intrinsics.checkNotNullExpressionValue(r7, "fromHtml(this, flags, imageGetter, tagHandler)");
        return r7;
    }

    public static final Spanned parseAsHtml(String r1, int r2, Html.ImageGetter r3, Html.TagHandler r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Spanned r5 = HtmlCompat.fromHtml(r1, r2, r3, r4);
        Intrinsics.checkNotNullExpressionValue(r5, "fromHtml(this, flags, imageGetter, tagHandler)");
        return r5;
    }

    public static /* synthetic */ String toHtml$default(Spanned r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        String r4 = HtmlCompat.toHtml(r0, r1);
        Intrinsics.checkNotNullExpressionValue(r4, "toHtml(this, option)");
        return r4;
    }

    public static final String toHtml(Spanned r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r3 = HtmlCompat.toHtml(r1, r2);
        Intrinsics.checkNotNullExpressionValue(r3, "toHtml(this, option)");
        return r3;
    }
}
