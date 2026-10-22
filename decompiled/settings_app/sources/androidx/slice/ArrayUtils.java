package androidx.slice;

import androidx.core.util.ObjectsCompat;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
class ArrayUtils {
    public static <T> boolean contains(T[] r4, T r5) {
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (ObjectsCompat.equals(r4[r2], r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static <T> T[] appendElement(Class<T> r3, T[] r4, T r5) {
        int r0 = 0;
        if (r4 == null) goto L5;
        int r1 = r4.length;
        T[] r6 = (T[]) ((Object[]) Array.newInstance(r3, r1 + 1));
        System.arraycopy(r4, 0, r6, 0, r1);
        r0 = r1;
    L6:
        r6[r0] = r5;
        return r6;
    L5:
        r6 = (T[]) ((Object[]) Array.newInstance(r3, 1));
        goto L6
    }

    public static <T> T[] removeElement(Class<T> r4, T[] r5, T r6) {
        if (r5 != null) goto L4;
    L17:
        return r5;
    L4:
        if (contains(r5, r6) == true) goto L6;
        return r5;
    L6:
        int r0 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L17;
        if (ObjectsCompat.equals(r5[r2], r6) == true) goto L11;
        r2 = r2 + 1;
        goto L7
    L11:
        if (r0 != 1) goto L14;
        return null;
    L14:
        T[] r7 = (T[]) ((Object[]) Array.newInstance(r4, r0 - 1));
        System.arraycopy(r5, 0, r7, 0, r2);
        System.arraycopy(r5, r2 + 1, r7, r2, (r0 - r2) - 1);
        return r7;
    }

    private ArrayUtils() {
    }
}
