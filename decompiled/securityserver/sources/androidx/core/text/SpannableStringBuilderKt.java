package androidx.core.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.ColorInt;
import com.bytedance.apm.constant.TraceStatsConsts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SpannableStringBuilderKt {
    @NotNull
    public static final SpannableStringBuilder backgroundColor(@NotNull SpannableStringBuilder r2, @ColorInt int r3, @NotNull Function1<? super SpannableStringBuilder, Unit> r4) {
        Intrinsics.g(r2, "$this$backgroundColor");
        Intrinsics.g(r4, "builderAction");
        BackgroundColorSpan r0 = new BackgroundColorSpan(r3);
        int r5 = r2.length();
        r4.invoke(r2);
        r2.setSpan(r0, r5, r2.length(), 17);
        return r2;
    }

    @NotNull
    public static final SpannableStringBuilder bold(@NotNull SpannableStringBuilder r3, @NotNull Function1<? super SpannableStringBuilder, Unit> r4) {
        Intrinsics.g(r3, "$this$bold");
        Intrinsics.g(r4, "builderAction");
        StyleSpan r0 = new StyleSpan(1);
        int r1 = r3.length();
        r4.invoke(r3);
        r3.setSpan(r0, r1, r3.length(), 17);
        return r3;
    }

    @NotNull
    public static final SpannedString buildSpannedString(@NotNull Function1<? super SpannableStringBuilder, Unit> r1) {
        Intrinsics.g(r1, "builderAction");
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        r1.invoke(r0);
        return new SpannedString(r0);
    }

    @NotNull
    public static final SpannableStringBuilder color(@NotNull SpannableStringBuilder r2, @ColorInt int r3, @NotNull Function1<? super SpannableStringBuilder, Unit> r4) {
        Intrinsics.g(r2, "$this$color");
        Intrinsics.g(r4, "builderAction");
        ForegroundColorSpan r0 = new ForegroundColorSpan(r3);
        int r5 = r2.length();
        r4.invoke(r2);
        r2.setSpan(r0, r5, r2.length(), 17);
        return r2;
    }

    @NotNull
    public static final SpannableStringBuilder inSpans(@NotNull SpannableStringBuilder r5, @NotNull Object[] r6, @NotNull Function1<? super SpannableStringBuilder, Unit> r7) {
        Intrinsics.g(r5, "$this$inSpans");
        Intrinsics.g(r6, TraceStatsConsts.STATS_KEY_SPANS);
        Intrinsics.g(r7, "builderAction");
        int r0 = r5.length();
        r7.invoke(r5);
        int r8 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L5;
        r5.setSpan(r6[r1], r0, r5.length(), 17);
        r1 = r1 + 1;
        goto L3
    L5:
        return r5;
    }

    @NotNull
    public static final SpannableStringBuilder italic(@NotNull SpannableStringBuilder r3, @NotNull Function1<? super SpannableStringBuilder, Unit> r4) {
        Intrinsics.g(r3, "$this$italic");
        Intrinsics.g(r4, "builderAction");
        StyleSpan r0 = new StyleSpan(2);
        int r1 = r3.length();
        r4.invoke(r3);
        r3.setSpan(r0, r1, r3.length(), 17);
        return r3;
    }

    @NotNull
    public static final SpannableStringBuilder scale(@NotNull SpannableStringBuilder r2, float r3, @NotNull Function1<? super SpannableStringBuilder, Unit> r4) {
        Intrinsics.g(r2, "$this$scale");
        Intrinsics.g(r4, "builderAction");
        RelativeSizeSpan r0 = new RelativeSizeSpan(r3);
        int r5 = r2.length();
        r4.invoke(r2);
        r2.setSpan(r0, r5, r2.length(), 17);
        return r2;
    }

    @NotNull
    public static final SpannableStringBuilder strikeThrough(@NotNull SpannableStringBuilder r3, @NotNull Function1<? super SpannableStringBuilder, Unit> r4) {
        Intrinsics.g(r3, "$this$strikeThrough");
        Intrinsics.g(r4, "builderAction");
        StrikethroughSpan r0 = new StrikethroughSpan();
        int r1 = r3.length();
        r4.invoke(r3);
        r3.setSpan(r0, r1, r3.length(), 17);
        return r3;
    }

    @NotNull
    public static final SpannableStringBuilder subscript(@NotNull SpannableStringBuilder r3, @NotNull Function1<? super SpannableStringBuilder, Unit> r4) {
        Intrinsics.g(r3, "$this$subscript");
        Intrinsics.g(r4, "builderAction");
        SubscriptSpan r0 = new SubscriptSpan();
        int r1 = r3.length();
        r4.invoke(r3);
        r3.setSpan(r0, r1, r3.length(), 17);
        return r3;
    }

    @NotNull
    public static final SpannableStringBuilder superscript(@NotNull SpannableStringBuilder r3, @NotNull Function1<? super SpannableStringBuilder, Unit> r4) {
        Intrinsics.g(r3, "$this$superscript");
        Intrinsics.g(r4, "builderAction");
        SuperscriptSpan r0 = new SuperscriptSpan();
        int r1 = r3.length();
        r4.invoke(r3);
        r3.setSpan(r0, r1, r3.length(), 17);
        return r3;
    }

    @NotNull
    public static final SpannableStringBuilder underline(@NotNull SpannableStringBuilder r3, @NotNull Function1<? super SpannableStringBuilder, Unit> r4) {
        Intrinsics.g(r3, "$this$underline");
        Intrinsics.g(r4, "builderAction");
        UnderlineSpan r0 = new UnderlineSpan();
        int r1 = r3.length();
        r4.invoke(r3);
        r3.setSpan(r0, r1, r3.length(), 17);
        return r3;
    }

    @NotNull
    public static final SpannableStringBuilder inSpans(@NotNull SpannableStringBuilder r2, @NotNull Object r3, @NotNull Function1<? super SpannableStringBuilder, Unit> r4) {
        Intrinsics.g(r2, "$this$inSpans");
        Intrinsics.g(r3, "span");
        Intrinsics.g(r4, "builderAction");
        int r0 = r2.length();
        r4.invoke(r2);
        r2.setSpan(r3, r0, r2.length(), 17);
        return r2;
    }
}
