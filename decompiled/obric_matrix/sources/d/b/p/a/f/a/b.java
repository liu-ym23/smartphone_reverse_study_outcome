package d.b.p.a.f.a;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static void a(Context r2, String... r3) {
        b(r2);
        c(r2);
        j(r2);
        k(r2);
        i(r2);
        int r4 = r3.length;
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L5;
        d(r3[r0]);
        r0 = r0 + 1;
        goto L3
    }

    public static void b(Context r0) {
        h(r0.getCacheDir());
    }

    public static void c(Context r2) {
        if (Environment.getExternalStorageState().equals("mounted") == false) goto L6;
        h(r2.getExternalCacheDir());
        return;
    }

    public static void d(String r1) {
        h(new File(r1));
    }

    public static void e(Context r0, String r1) {
        r0.deleteDatabase(r1);
    }

    public static boolean f(File r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.exists() == true) goto L6;
        return false;
    L6:
        if (r1.isFile() == false) goto L13;
        r1.delete();
        return true;
    L13:
        return false;
    }

    public static void g(File r1) {
        if (r1.isDirectory() == false) goto L5;
        h(r1);
        return;
    L5:
        f(r1);
    }

    public static void h(File r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.exists() == true) goto L6;
        return;
    L6:
        if (r4.isDirectory() == false) goto L26;
        File[] r5 = r4.listFiles();
        if (r5 == null) goto L25;
        int r0 = r5.length;
        int r1 = 0;
    L11:
        if (r1 >= r0) goto L27;
        File r2 = r5[r1];
        if (r2.isDirectory() == false) goto L17;
        h(r2);
    L15:
        r2.delete();
    L19:
        r1 = r1 + 1;
        goto L11
    L17:
        if (r2.isFile() == false) goto L19;
    L27:
        return;
    L25:
        return;
    }

    public static void i(Context r0) {
        h(r0.getFilesDir());
    }

    public static void j(Context r3) {
        h(new File("/data/data/" + r3.getPackageName() + "/databases"));
    }

    public static void k(Context r3) {
        h(new File("/data/data/" + r3.getPackageName() + "/shared_prefs"));
    }
}
