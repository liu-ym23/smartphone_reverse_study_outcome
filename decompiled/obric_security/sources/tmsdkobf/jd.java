package tmsdkobf;

import android.content.Context;
import android.os.Environment;
import android.os.Process;

/* JADX INFO: loaded from: classes5.dex */
public abstract class jd {
    public static int a(Context r2, String r3) {
        return r2.checkPermission(r3, Process.myPid(), Process.myUid());
    }

    public static boolean a() {
        monitor-enter(mh.class);
        Context r1 = mh.f353a;     // Catch: Throwable -> L12
        monitor-exit(mh.class);
        if (a(r1, "android.permission.READ_EXTERNAL_STORAGE") == 0) goto L9;
        return false;
    L9:
        return Environment.isExternalStorageLegacy();
    L12:
        th = move-exception;
        throw th;
    }
}
