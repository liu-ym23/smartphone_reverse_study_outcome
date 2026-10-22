package kotlin.u0;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\b\u001a\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002¨\u0006\u0014"}, d2 = {"fromInt", "", "T", "Lkotlin/text/FlagEnum;", "", "value", "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", TypedValues.TransitionType.S_FROM, "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class j {
    public static final /* synthetic */ g a(Matcher r0, int r1, CharSequence r2) {
        return d(r0, r1, r2);
    }

    public static final /* synthetic */ g b(Matcher r0, CharSequence r1) {
        return e(r0, r1);
    }

    public static final /* synthetic */ kotlin.r0.d c(MatchResult r0, int r1) {
        return f(r0, r1);
    }

    private static final g d(Matcher r0, int r1, CharSequence r2) {
        if (r0.find(r1) == true) goto L6;
        return null;
    L6:
        return new h(r0, r2);
    }

    private static final g e(Matcher r1, CharSequence r2) {
        if (r1.matches() == true) goto L6;
        return null;
    L6:
        return new h(r1, r2);
    }

    private static final kotlin.r0.d f(MatchResult r1, int r2) {
        return kotlin.r0.e.m(r1.start(r2), r1.end(r2));
    }
}
