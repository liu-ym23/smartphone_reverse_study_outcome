package tmsdkobf;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ca {
    public static Object a(SparseArray r1, int r2, Class r3) {
        if (r1 != null) goto L5;
        return null;
    L5:
        Object r4 = r1.get(r2);
        if (r3.isInstance(r4) == true) goto L8;
        return null;
    L8:
        return r3.cast(r4);
    }

    public static int b(SparseArray r2) {
        Integer r3 = (Integer) a(r2, 0, Integer.class);
        if (r3 != null) goto L6;
        return -1;
    L6:
        return r3.intValue();
    }

    public static byte[] a(SparseArray r2) {
        byte[] r3 = (byte[]) a(r2, 1, byte[].class);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return new byte[0];
    }
}
