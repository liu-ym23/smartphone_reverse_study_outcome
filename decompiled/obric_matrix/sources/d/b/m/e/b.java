package d.b.m.e;

import android.content.Context;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes.dex */
public class b {
    static {
    }

    public static String a(String r3, String r4) {
        Context r0 = com.bytedance.mpaas.app.a.a();
        Object r5 = r0.getPackageManager().getApplicationInfo(r0.getPackageName(), 128).metaData.get(r3);     // Catch: PackageManager.NameNotFoundException -> L5
    L7:
        if (r5 != null) goto L10;
        return r4;
    L10:
        return String.valueOf(r5);
    L5:
        e = move-exception;
        e.printStackTrace();
        r5 = null;
        goto L7
    }
}
