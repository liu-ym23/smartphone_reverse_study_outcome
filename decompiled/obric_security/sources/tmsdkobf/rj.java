package tmsdkobf;

import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public abstract class rj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f486a = -1;

    static {
    }

    public static String a(Context r0) {
        return "000000000000000";
    }

    public static int b(Context r2) {
        int r0 = f486a;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r3 = a(a(r2));
        f486a = r3;
        return r3;
    }

    public static int a(String r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        if (r2.startsWith("46000") == false) goto L8;
        return 0;
    L8:
        if (r2.startsWith("46002") == false) goto L10;
        return 0;
    L10:
        if (r2.startsWith("46007") == false) goto L13;
        return 0;
    L13:
        if (r2.startsWith("46001") == false) goto L17;
        return 1;
    L17:
        if (r2.startsWith("46003") == false) goto L20;
        return 2;
    L20:
        return -1;
    }
}
