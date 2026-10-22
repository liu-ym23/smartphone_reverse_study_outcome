package d.b.p.a.c.f;

import android.app.Application;
import d.b.p.a.d.h;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public a() {
    }

    public boolean a(Application r3) {
        Field r2 = Class.forName("android.app.ActivityThread").getDeclaredField("mInitialApplication");     // Catch: Exception -> L4
        r2.setAccessible(true);     // Catch: Exception -> L4
        r2.set(d.b.p.a.d.a.c(), r3);     // Catch: Exception -> L4
        return true;
    L4:
        h.c("HookActivityThreadSetInitialApplication", "WebView hook fix ANR fail.");
        return false;
    }
}
