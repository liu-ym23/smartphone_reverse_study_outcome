package ms.bd.c;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes2.dex */
public class j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f22411a;

    public static String a(Context r1) {
        if (r1 == null) goto L6;
        new DisplayMetrics();     // Catch: Throwable -> L7
        f22411a = r1.getResources().getDisplayMetrics().densityDpi;     // Catch: Throwable -> L7
    L6:
        return "" + f22411a;
    }
}
