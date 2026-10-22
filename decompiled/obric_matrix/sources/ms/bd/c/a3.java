package ms.bd.c;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes2.dex */
public class a3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f22315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f22316b;

    public static String a(Context r3) {
        Display r4 = ((WindowManager) r3.getSystemService("window")).getDefaultDisplay();     // Catch: Throwable -> L14
        Point r0 = new Point();     // Catch: Throwable -> L14
        int r1 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L14
        if (r1 < 17) goto L7;
        r4.getRealSize(r0);     // Catch: Throwable -> L14
    L5:
        f22315a = r0.x;     // Catch: Throwable -> L14
        int r5 = r0.y;     // Catch: Throwable -> L14
    L11:
        f22316b = r5;     // Catch: Throwable -> L14
        goto L13
    L7:
        if (r1 < 13) goto L10;
        r4.getSize(r0);     // Catch: Throwable -> L14
        goto L5
    L10:
        f22315a = r4.getWidth();     // Catch: Throwable -> L14
        r5 = r4.getHeight();     // Catch: Throwable -> L14
    L13:
        return f22315a + "*" + f22316b;
    }
}
