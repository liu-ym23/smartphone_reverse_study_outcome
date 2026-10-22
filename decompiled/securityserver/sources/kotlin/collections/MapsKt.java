package kotlin.collections;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MapsKt extends MapsKt___MapsKt {
    public static /* bridge */ /* synthetic */ Map b() {
        return EmptyMap.b;
    }

    public static int c(int r1) {
        if (r1 >= 0) goto L5;
        return r1;
    L5:
        if (r1 >= 3) goto L8;
        return r1 + 1;
    L8:
        if (r1 < 1073741824) goto L13;
        return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    L13:
        return (int) ((r1 / 0.75f) + 1.0f);
    }

    public static Map d(Pair... r2) {
        if (r2.length <= 0) goto L6;
        LinkedHashMap r0 = new LinkedHashMap(c(r2.length));
        MapsKt__MapsKt.a(r0, r2);
        return r0;
    L6:
        return EmptyMap.b;
    }

    public static LinkedHashMap e(Pair... r2) {
        LinkedHashMap r0 = new LinkedHashMap(c(r2.length));
        MapsKt__MapsKt.a(r0, r2);
        return r0;
    }

    public static Map f(ArrayList r3) {
        EmptyMap r0 = EmptyMap.b;
        int r1 = r3.size();
        if (r1 != 0) goto L5;
        return r0;
    L5:
        if (r1 == 1) goto L10;
        LinkedHashMap r2 = new LinkedHashMap(c(r3.size()));
        Iterator r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        Pair r5 = (Pair) r4.next();
        r2.put(r5.b, r5.c);
        goto L8
    L14:
        return r2;
    L10:
        Pair r6 = (Pair) r3.get(0);
        Intrinsics.f(r6, "pair");
        Map r7 = Collections.singletonMap(r6.b, r6.c);
        Intrinsics.e(r7, "singletonMap(pair.first, pair.second)");
        return r7;
    }

    public static Map g(LinkedHashMap r2) {
        int r0 = r2.size();
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L10;
        Map.Entry r3 = (Map.Entry) r2.entrySet().iterator().next();
        Map r1 = Collections.singletonMap(r3.getKey(), r3.getValue());
        Intrinsics.e(r1, "with(entries.iterator().…ingletonMap(key, value) }");
        return r1;
    L10:
        return new LinkedHashMap(r2);
    L9:
        return EmptyMap.b;
    }
}
