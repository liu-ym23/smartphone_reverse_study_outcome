package d.b.b.o;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f13043a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f13044b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Application f13045c;

    static {
    }

    public a() {
    }

    private static Application a(Context r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if ((r1 instanceof Application) == true) goto L10;
        r1 = r1.getApplicationContext();
    L10:
        return (Application) r1;
    }

    public static Application b() {
        return f13045c;
    }

    public static boolean c() {
        if (f13043a == true) goto L5;
    L7:
        return false;
    L5:
        if (f13044b == true) goto L7;
        return true;
    }

    public static boolean d() {
        return f13044b;
    }

    public static void e(Context r0) {
        if (r0 == null) goto L5;
        f13045c = a(r0);
        return;
    }

    public static void f(boolean r0) {
        f13043a = r0;
    }
}
