package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CharDirectionality$Companion$directionalityMap$2 extends Lambda implements Function0<Map<Integer, ? extends CharDirectionality>> {
    public static final CharDirectionality$Companion$directionalityMap$2 b = null;

    static {
        b = new CharDirectionality$Companion$directionalityMap$2(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        CharDirectionality[] r5 = CharDirectionality.values();
        int r0 = MapsKt.c(r5.length);
        if (r0 >= 16) goto L5;
        r0 = 16;
    L5:
        LinkedHashMap r1 = new LinkedHashMap(r0);
        int r2 = r5.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        CharDirectionality r4 = r5[r3];
        r1.put(Integer.valueOf(r4.b), r4);
        r3 = r3 + 1;
        goto L6
    L8:
        return r1;
    }
}
