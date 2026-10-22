package tmsdkobf;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class i8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f266a = null;
    public static final String b = null;
    public static boolean c;

    static {
        f266a = xk.a(xk.A0);
        b = xk.a(xk.B0);
        c = false;
    }

    public static void a(Context r9, d5 r10) {
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (c == false) goto L6;
        return;
    L6:
        c = true;     // Catch: Throwable -> L13
        long r2 = r10.a(r9, "502");     // Catch: Throwable -> L13
        int r4 = Process.myUid();     // Catch: Throwable -> L13
        if (r2 == 0) goto L18;
        if (r4 != 0) goto L10;
        return;
    L10:
        if (r4 == r2) goto L20;
        r10.a(r9, "101", "", true);     // Catch: Throwable -> L13
        r10.b(r9, 0);     // Catch: Throwable -> L13
        HashMap r11 = new HashMap();     // Catch: Throwable -> L13
        r11.put("901", "");     // Catch: Throwable -> L13
        d5.a(r9, r11);     // Catch: Throwable -> L13
        new File(a(r9)).delete();     // Catch: Throwable -> L13
        return;
    L20:
        return;
    }

    public static String a(Context r4) {
        File r5 = r4.getDir(f266a, 0);
        if (r5 != null) goto L5;
        return "";
    L5:
        StringBuilder r6 = new StringBuilder().append(r5.getAbsolutePath());
        String r2 = File.separator;
        File r1 = new File(r6.append(r2).append("1").toString());
        if (r1.exists() == true) goto L11;
        if (r1.mkdirs() == true) goto L11;
        return "";
    L11:
        return r1.getAbsolutePath() + r2 + b;
    }
}
