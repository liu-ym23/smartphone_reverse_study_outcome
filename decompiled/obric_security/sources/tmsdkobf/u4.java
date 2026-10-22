package tmsdkobf;

import android.content.Context;
import android.os.Build;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public abstract class u4 {
    private static void a(Context r1, File r2) {
        if (a() == false) goto L8;
        return;
    L8:
        new o4(r1.getContentResolver(), r2).a();     // Catch: Throwable -> L7
        return;
    }

    public static void a(Context r2, String r3) {
        File r0 = new File(r3);
        r0.delete();
        if (vc.a() > 18) goto L5;
        return;
    L5:
        if (r0.exists() == true) goto L7;
        return;
    L7:
        if (r0.isDirectory() == true) goto L12;
        a(r2, r0);
        return;
    }

    static boolean a() {
        return "oneplus".equals(Build.BRAND.toLowerCase());
    }
}
