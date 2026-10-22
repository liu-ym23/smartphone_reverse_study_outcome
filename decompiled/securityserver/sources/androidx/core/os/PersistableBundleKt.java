package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PersistableBundleKt {
    @RequiresApi(21)
    @NotNull
    public static final PersistableBundle persistableBundleOf(@NotNull Pair<String, ? extends Object>... r9) {
        Intrinsics.g(r9, "pairs");
        PersistableBundle r0 = new PersistableBundle(r9.length);
        int r1 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L48;
        Pair<String, ? extends Object> r3 = r9[r2];
        String r4 = (String) r3.b;
        Object r5 = r3.c;
        if (r5 != null) goto L8;
        r0.putString(r4, null);
    L41:
        r2 = r2 + 1;
        goto L3
    L8:
        if ((r5 instanceof Boolean) == false) goto L11;
        r0.putBoolean(r4, ((Boolean) r5).booleanValue());
        goto L41
    L11:
        if ((r5 instanceof Double) == false) goto L14;
        r0.putDouble(r4, ((Number) r5).doubleValue());
        goto L41
    L14:
        if ((r5 instanceof Integer) == false) goto L17;
        r0.putInt(r4, ((Number) r5).intValue());
        goto L41
    L17:
        if ((r5 instanceof Long) == false) goto L20;
        r0.putLong(r4, ((Number) r5).longValue());
        goto L41
    L20:
        if ((r5 instanceof String) == false) goto L23;
        r0.putString(r4, (String) r5);
        goto L41
    L23:
        if ((r5 instanceof boolean[]) == false) goto L26;
        r0.putBooleanArray(r4, (boolean[]) r5);
        goto L41
    L26:
        if ((r5 instanceof double[]) == false) goto L29;
        r0.putDoubleArray(r4, (double[]) r5);
        goto L41
    L29:
        if ((r5 instanceof int[]) == false) goto L32;
        r0.putIntArray(r4, (int[]) r5);
        goto L41
    L32:
        if ((r5 instanceof long[]) == false) goto L35;
        r0.putLongArray(r4, (long[]) r5);
        goto L41
    L35:
        if ((r5 instanceof Object[]) == false) goto L47;
        Class<?> r6 = r5.getClass().getComponentType();
        if (r6 == null) goto L44;
        if (String.class.isAssignableFrom(r6) == false) goto L43;
        r0.putStringArray(r4, (String[]) r5);
        goto L41
    L43:
        throw new IllegalArgumentException("Illegal value array type " + r6.getCanonicalName() + " for key \"" + r4 + '\"');
    L44:
        Intrinsics.k();
        throw null;
    L47:
        throw new IllegalArgumentException("Illegal value type " + r5.getClass().getCanonicalName() + " for key \"" + r4 + '\"');
    L48:
        return r0;
    }
}
