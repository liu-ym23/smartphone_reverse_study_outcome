package androidx.navigation;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/util/regex/Pattern;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class NavDeepLink$pattern$2 extends q implements kotlin.n0.c.a<Pattern> {
    final /* synthetic */ NavDeepLink this$0;

    NavDeepLink$pattern$2(NavDeepLink r1) {
        this.this$0 = r1;
        super(0);
    }

    @Override // kotlin.n0.c.a
    public /* bridge */ /* synthetic */ Pattern invoke() {
        return invoke2();
    }

    @Override // kotlin.n0.c.a
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pattern invoke2() {
        String r1 = NavDeepLink.access$getPatternFinalRegex$p(this.this$0);
        if (r1 != null) goto L7;
        return null;
    L7:
        return Pattern.compile(r1, 2);
    }
}
