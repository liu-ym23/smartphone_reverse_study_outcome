package u;

import android.util.Log;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22181a = null;

    static {
        f22181a = new a();
    }

    public static void a() {
        f22181a.getClass();
    }

    public static void b(String r5) {
        f22181a.getClass();
        HashSet r10 = a.f22180a;
        if (r10.contains(r5) == true) goto L7;
        Log.w("LOTTIE", r5, null);
        r10.add(r5);
        return;
    }
}
