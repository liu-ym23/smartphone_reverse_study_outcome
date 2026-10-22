package kotlin.collections.builders;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ListBuilderKt {
    public static final void a(Object[] r1, int r2, int r3) {
        Intrinsics.f(r1, "<this>");
    L3:
        if (r2 >= r3) goto L5;
        r1[r2] = null;
        r2 = r2 + 1;
        goto L3
    }
}
