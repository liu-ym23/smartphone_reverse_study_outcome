package d.b.b.e.a;

import android.app.Application;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Properties f12593a;

    public static String a() {
        return String.valueOf(b("release_build"));
    }

    private static Object b(String r2) {
        c();
        Properties r1 = f12593a;     // Catch: Exception -> L9
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.containsKey(r2) == false) goto L13;
        return f12593a.get(r2);
    L13:
        return null;
    L14:
        return null;
    }

    private static void c() {
        Application r0 = d.b.b.o.a.b();
        if (f12593a != null) goto L15;
        f12593a = new Properties();
        InputStream r1 = r0.getApplicationContext().getAssets().open("slardar.properties");     // Catch: Throwable -> L8
        f12593a.load(r1);     // Catch: Throwable -> L16
    L10:
        d.b.b.o.d.a(r1);
        return;
    L21:
        f12593a = null;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        d.b.b.o.d.a(r1);
        throw th;
    L8:
        r1 = null;
        goto L21
    }
}
