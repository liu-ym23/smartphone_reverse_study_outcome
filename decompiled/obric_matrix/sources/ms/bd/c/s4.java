package ms.bd.c;

import android.content.Context;
import android.webkit.WebSettings;

/* JADX INFO: loaded from: classes2.dex */
public class s4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f22490a;

    public static synchronized String a(Context r2) {
        monitor-enter(s4.class);
        String r1 = f22490a;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        monitor-exit(s4.class);
        return r1;
    L8:
        String r3 = WebSettings.getDefaultUserAgent(r2);     // Catch: Throwable -> L11
        f22490a = r3;     // Catch: Throwable -> L11
        monitor-exit(s4.class);
        return r3;
    L11:
        th = move-exception;
        throw th;
    }
}
