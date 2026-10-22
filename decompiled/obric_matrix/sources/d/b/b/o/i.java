package d.b.b.o;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f13052a;

    static {
        f13052a = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable r1) {
        f13052a.post(r1);
    }

    public static byte[] b(String r1) {
        if (r1 != null) goto L10;
    L8:
        return null;
    L10:
        if (r1.length() <= 0) goto L8;
        return r1.getBytes("UTF-8");
    L12:
        return r1.getBytes();
    }
}
