package kotlin.collections;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
class MapsKt__MapsKt extends MapsKt__MapsJVMKt {
    public static final void a(LinkedHashMap r4, Pair[] r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Pair r2 = r5[r1];
        r4.put(r2.b, r2.c);
        r1 = r1 + 1;
        goto L3
    }
}
