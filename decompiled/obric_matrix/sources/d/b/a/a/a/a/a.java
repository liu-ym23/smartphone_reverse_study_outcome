package d.b.a.a.a.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    static {
    }

    public static boolean a(String r3, String r4, String r5) {
        if (d.b.a.a.a.e.a.c(r3) == false) goto L5;
    L37:
        return false;
    L5:
        if (d.b.a.a.a.e.a.c(r4) == true) goto L37;
        if (d.b.a.a.a.e.a.c(r5) == true) goto L37;
        FileInputStream r0 = null;
        FileInputStream r2 = new FileInputStream(r3);     // Catch: Throwable -> L21 Exception -> L23
        boolean r6 = c(r2, r4, r5);     // Catch: Throwable -> L17 Exception -> L19
        r2.close();     // Catch: Exception -> L14
    L16:
        return r6;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L19:
        e = e;
        r0 = r2;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L21
        if (r0 != null) goto L40;
    L30:
        return false;
    L40:
        r0.close();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = th;
        r0 = r2;
    L31:
        if (r0 != null) goto L42;
    L36:
        throw th;
    L42:
        r0.close();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = e;
    L21:
        th = th;
        goto L31
    }

    public static void b(String r4) {
        File r0 = new File(r4);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        if (r0.isDirectory() == false) goto L19;
        File[] r5 = r0.listFiles();
        int r1 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        if (r5[r2].isDirectory() == false) goto L11;
        b(r5[r2].getAbsolutePath());
    L12:
        r2 = r2 + 1;
        goto L7
    L11:
        r5[r2].delete();
        goto L12
    L13:
        r0.delete();
        return;
    }

    public static boolean c(InputStream r4, String r5, String r6) {
        if (r4 != null) goto L5;
        return false;
    L5:
        FileOutputStream r1 = null;
        File r2 = new File(r5);     // Catch: Throwable -> L35 Exception -> L37
        if (r2.exists() == false) goto L9;
    L16:
        FileOutputStream r7 = new FileOutputStream(new File(r2, r6));     // Catch: Throwable -> L35 Exception -> L37
        byte[] r8 = new byte[1024];     // Catch: Throwable -> L31 Exception -> L33
    L19:
        int r3 = r4.read(r8);     // Catch: Throwable -> L31 Exception -> L33
        if (r3 == (-1)) goto L22;
        r7.write(r8, 0, r3);     // Catch: Throwable -> L31 Exception -> L33
        goto L19
    L22:
        r7.flush();     // Catch: Throwable -> L31 Exception -> L33
        r7.close();     // Catch: Throwable -> L31 Exception -> L33
        r4.close();     // Catch: Throwable -> L35 Exception -> L37
        if (r4 == null) goto L76;
        r4.close();     // Catch: Exception -> L27
        return true;
    L27:
        e = move-exception;
        e.printStackTrace();
        return true;
    L76:
        return true;
    L33:
        e = e;
        r1 = r7;
    L38:
        d.b.a.a.a.b.a.c("FileUtils", "save inputstream error: " + e);     // Catch: Throwable -> L35
        if (r1 != null) goto L67;
    L41:
        if (r4 != null) goto L60;
    L46:
        return false;
    L60:
        r4.close();     // Catch: Exception -> L44
    L44:
        e = move-exception;
        e.printStackTrace();
        goto L46
    L67:
        r1.close();     // Catch: Exception -> L56
    L31:
        th = th;
        r1 = r7;
    L47:
        if (r1 != null) goto L69;
    L49:
        if (r4 == null) goto L74;
        r4.close();     // Catch: Exception -> L52
        throw th;
    L52:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L74:
        throw th;
    L69:
        r1.close();     // Catch: Exception -> L55
        goto L49
    L9:
        if (r2.mkdirs() == true) goto L16;
        if (r4 != null) goto L57;
    L15:
        return false;
    L57:
        r4.close();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L35:
        th = th;
    L37:
        e = e;
        goto L38
    }
}
