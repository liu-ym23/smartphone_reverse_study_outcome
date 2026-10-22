package d.b.a.a.a.e;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static String a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return null;
    L6:
        byte[] r0 = r4.getBytes("UTF-8");     // Catch: Exception -> L12
        int r2 = 0;
    L8:
        if (r2 >= r0.length) goto L10;
        r0[r2] = (byte) (r0[r2] ^ 5);     // Catch: Exception -> L12
        r2 = r2 + 1;     // Catch: Exception -> L12
        goto L8
    L10:
        return d.b.a.a.a.d.a.c(r0, 0, r0.length);
    L16:
        return r4;
    }

    public static boolean b(String r1, String r2) {
        if (c(r1) == true) goto L5;
    L6:
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.equals(r2) == false) goto L10;
    L9:
        return true;
    L5:
        if (c(r2) == true) goto L9;
        goto L6
    }

    public static boolean c(String r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        if (r0.length() == 0) goto L10;
        return false;
    L10:
        return true;
    }
}
