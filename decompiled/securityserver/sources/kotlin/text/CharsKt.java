package kotlin.text;

import a.a;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CharsKt extends CharsKt__CharKt {
    public static void c(int r6) {
        if (new IntRange(2, 36, 1).b(r6) == false) goto L5;
        return;
    L5:
        StringBuilder r7 = a.p(r6, "radix ", " was not in valid range ");
        r7.append(new IntRange(2, 36, 1));
        throw new IllegalArgumentException(r7.toString());
    }
}
