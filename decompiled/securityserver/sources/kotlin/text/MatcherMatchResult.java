package kotlin.text;

import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class MatcherMatchResult implements MatchResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matcher f357a;
    public final CharSequence b;

    public MatcherMatchResult(Matcher r2, CharSequence r3) {
        Intrinsics.f(r3, "input");
        this.f357a = r2;
        this.b = r3;
    }

    @Override // kotlin.text.MatchResult
    public final String getValue() {
        String r1 = this.f357a.group();
        Intrinsics.e(r1, "matchResult.group()");
        return r1;
    }

    @Override // kotlin.text.MatchResult
    public final MatchResult next() {
        Matcher r0 = this.f357a;
        int r1 = r0.end();
        if (r0.end() != r0.start()) goto L5;
        int r2 = 1;
    L6:
        int r3 = r1 + r2;
        CharSequence r4 = this.b;
        if (r3 > r4.length()) goto L13;
        Matcher r5 = r0.pattern().matcher(r4);
        Intrinsics.e(r5, "matcher.pattern().matcher(input)");
        if (r5.find(r3) == true) goto L12;
        return null;
    L12:
        return new MatcherMatchResult(r5, r4);
    L13:
        return null;
    L5:
        r2 = 0;
        goto L6
    }
}
