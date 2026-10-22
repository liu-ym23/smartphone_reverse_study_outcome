package d.b.k.a;

import android.net.Uri;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final o f14019a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile r f14020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f14021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f14022d;

    static {
        f14019a = b();
    }

    static void a(s r1) {
        if (f14021c == true) goto L6;
        Log.e("Lighten:", "display, lighten is not initialized, call Lighten.init");
        return;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        f14019a.display(r1);
    }

    private static o b() {
        o r0 = d.b.k.a.x.b.a();
        if (r0 == null) goto L5;
        return r0;
    L5:
        o r1 = d.b.k.a.x.c.a();
        if (r1 == null) goto L8;
        return r1;
    L8:
        o r2 = d.b.k.a.x.d.a();
        if (r2 == null) goto L12;
        return r2;
    L12:
        return d.b.k.a.x.a.a();
    }

    public static r c() {
        if (f14020b == null) goto L7;
        return f14020b;
    L7:
        throw new IllegalStateException("Lighten:lighten is not initialized, call Lighten.init");
    }

    public static void d(@NonNull r r1) {
        if (f14021c == false) goto L5;
        return;
    L5:
        f14021c = true;
        f14020b = r1;
        f14022d = r1.c().getPackageName();
        f14019a.init(r1);
    }

    public static t e(@DrawableRes int r1) {
        return f14019a.load(r1);
    }

    public static t f(@NonNull Uri r1) {
        return f14019a.load(r1);
    }
}
