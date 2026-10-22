package d.b.k.a;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f14012a;

    public static Context a() {
        return f14012a;
    }

    public static void b(Context r0) {
        f14012a = r0.getApplicationContext();
    }
}
