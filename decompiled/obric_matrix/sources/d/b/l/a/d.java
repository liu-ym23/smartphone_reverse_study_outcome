package d.b.l.a;

import java.io.Closeable;
import java.io.File;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static boolean a(String r1) {
        return new File(r1).mkdirs();
    }

    public static void b(Closeable r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static void c(ZipFile r0) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.close();     // Catch: Throwable -> L6
        return;
    }

    public static void d(String r2, int r3) {
        d.b.l.a.g.a.a("android.os.FileUtils", "setPermissions", new Object[]{r2, Integer.valueOf(r3), -1, -1});
    }
}
