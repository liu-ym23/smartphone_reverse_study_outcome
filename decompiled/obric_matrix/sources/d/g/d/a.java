package d.g.d;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build;
import d.g.d.b.b.l;
import d.g.d.f.f.b;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f16757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f16758g = null;

    static {
        f16758g = new a();
    }

    private a() {
    }

    private final Application a() {
        return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
    L5:
        e = move-exception;
        b.c("OUISdk", "getApplicationReflect failed", e);
        return null;
    }

    public final void b() {
    L12:
        e = move-exception;
        b.c("OUISdk", "init failed", e);
        return;
    L4:
        if (f16757f == true) goto L10;
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L12
        Application r3 = a();     // Catch: Exception -> L12
        if (r3 == null) goto L8;
        r3.registerComponentCallbacks(this);     // Catch: Exception -> L12
    L8:
        f16757f = true;     // Catch: Exception -> L12
        String r5 = "init success, cost: " + (System.currentTimeMillis() - r1) + " ms";     // Catch: Exception -> L12
    L9:
        b.a("OUISdk", r5);     // Catch: Exception -> L12
        return;
    L10:
        r5 = "init already";
        goto L9
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        o.f(r1, "newConfig");
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        l.f16798e.g();
        return;
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r1) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        l.f16798e.g();
        return;
    }
}
