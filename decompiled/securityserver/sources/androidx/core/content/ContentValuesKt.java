package androidx.core.content;

import android.content.ContentValues;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ContentValuesKt {
    @NotNull
    public static final ContentValues contentValuesOf(@NotNull Pair<String, ? extends Object>... r6) {
        Intrinsics.g(r6, "pairs");
        ContentValues r0 = new ContentValues(r6.length);
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L37;
        Pair<String, ? extends Object> r3 = r6[r2];
        String r4 = (String) r3.b;
        Object r5 = r3.c;
        if (r5 != null) goto L8;
        r0.putNull(r4);
    L34:
        r2 = r2 + 1;
        goto L3
    L8:
        if ((r5 instanceof String) == false) goto L11;
        r0.put(r4, (String) r5);
        goto L34
    L11:
        if ((r5 instanceof Integer) == false) goto L14;
        r0.put(r4, (Integer) r5);
        goto L34
    L14:
        if ((r5 instanceof Long) == false) goto L17;
        r0.put(r4, (Long) r5);
        goto L34
    L17:
        if ((r5 instanceof Boolean) == false) goto L20;
        r0.put(r4, (Boolean) r5);
        goto L34
    L20:
        if ((r5 instanceof Float) == false) goto L23;
        r0.put(r4, (Float) r5);
        goto L34
    L23:
        if ((r5 instanceof Double) == false) goto L26;
        r0.put(r4, (Double) r5);
        goto L34
    L26:
        if ((r5 instanceof byte[]) == false) goto L29;
        r0.put(r4, (byte[]) r5);
        goto L34
    L29:
        if ((r5 instanceof Byte) == false) goto L32;
        r0.put(r4, (Byte) r5);
        goto L34
    L32:
        if ((r5 instanceof Short) == false) goto L36;
        r0.put(r4, (Short) r5);
        goto L34
    L36:
        throw new IllegalArgumentException("Illegal value type " + r5.getClass().getCanonicalName() + " for key \"" + r4 + '\"');
    L37:
        return r0;
    }
}
