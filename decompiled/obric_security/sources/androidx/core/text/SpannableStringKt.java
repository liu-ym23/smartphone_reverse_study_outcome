package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import com.bytedance.apm.constant.TraceStatsConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: SpannableString.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a%\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\u001d\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\r\u0010\u000b\u001a\u00020\u0002*\u00020\fH\u0086\b¨\u0006\r"}, d2 = {"clearSpans", "", "Landroid/text/Spannable;", "set", "start", "", TraceStatsConsts.STATS_KEY_END, "span", "", "range", "Lkotlin/ranges/IntRange;", "toSpannable", "", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SpannableStringKt {
    public static final Spannable toSpannable(CharSequence r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        SpannableString r2 = SpannableString.valueOf(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "valueOf(this)");
        return r2;
    }

    public static final void clearSpans(Spannable r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Spannable r0 = r4;
        int r3 = 0;
        Object[] r1 = r0.getSpans(0, r0.length(), Object.class);
        Intrinsics.checkNotNullExpressionValue(r1, "getSpans(start, end, T::class.java)");
        int r2 = r1.length;
    L3:
        if (r3 >= r2) goto L5;
        r4.removeSpan(r1[r3]);
        r3 = r3 + 1;
        goto L3
    }

    public static final void set(Spannable r1, int r2, int r3, Object r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r4, "span");
        r1.setSpan(r4, r2, r3, 17);
    }

    public static final void set(Spannable r2, IntRange r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "range");
        Intrinsics.checkNotNullParameter(r4, "span");
        r2.setSpan(r4, r3.getStart().intValue(), r3.getEndInclusive().intValue(), 17);
    }
}
