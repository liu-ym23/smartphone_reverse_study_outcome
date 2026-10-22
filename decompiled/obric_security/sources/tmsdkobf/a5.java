package tmsdkobf;

import android.os.Environment;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a5 {
    public static int a() {
        if (z4.a() == true) goto L7;
        return 1;
    L7:
        if (b() == true) goto L10;
        return 2;
    L10:
        return 0;
    }

    public static boolean b() {
        String r0 = Environment.getExternalStorageDirectory().toString() + "/DCIM";
        File r1 = new File(r0);
        if (r1.isDirectory() == false) goto L5;
    L7:
        File r2 = new File(r0, ".probe");
    L17:
        return false;
    L9:
        if (r2.exists() == false) goto L12;
        r2.delete();     // Catch: IOException -> L17
    L12:
        if (r2.createNewFile() == true) goto L14;
        return false;
    L14:
        r2.delete();     // Catch: IOException -> L17
        return true;
    L5:
        if (r1.mkdirs() == true) goto L7;
        return false;
    }

    public static boolean a(File r7, File r8) {
        int r1 = 0;
        if (r7.isFile() == false) goto L53;
        BufferedInputStream r0 = null;
        FileInputStream r2 = new FileInputStream(r7);     // Catch: Throwable -> L32 Exception -> L43
    L101:
        FileOutputStream r9 = new FileOutputStream(r8);     // Catch: Throwable -> L29 Exception -> L31
        BufferedInputStream r10 = new BufferedInputStream(r2);     // Catch: Throwable -> L26 Exception -> L28
        BufferedOutputStream r3 = new BufferedOutputStream(r9);     // Catch: Throwable -> L22 Exception -> L24
    L103:
        byte[] r4 = new byte[8192];     // Catch: Throwable -> L20 Exception -> L69
    L11:
        int r5 = r10.read(r4);     // Catch: Throwable -> L20 Exception -> L69
        if (r5 == (-1)) goto L14;
        r3.write(r4, 0, r5);     // Catch: Throwable -> L20 Exception -> L69
        goto L11
    L14:
        r3.flush();     // Catch: Throwable -> L20 Exception -> L69
        r10.close();     // Catch: Exception -> L61
    L83:
        r3.close();     // Catch: Exception -> L62
    L81:
        r2.close();     // Catch: Exception -> L63
    L77:
        r9.close();     // Catch: Exception -> L64
        return true;
    L112:
        return true;
    L20:
        th = move-exception;
        r0 = r10;
        Throwable th = th;
    L34:
        if (r0 != null) goto L87;
    L36:
        if (r3 != null) goto L91;
    L38:
        if (r2 != null) goto L75;
    L40:
        if (r9 == null) goto L107;
        r9.close();     // Catch: Exception -> L68
        throw th;
    L108:
        throw th;
    L107:
        throw th;
    L75:
        r2.close();     // Catch: Exception -> L67
        goto L40
    L91:
        r3.close();     // Catch: Exception -> L66
        goto L38
    L87:
        r0.close();     // Catch: Exception -> L65
    L25:
        r0 = r10;
    L44:
        if (r0 != null) goto L79;
    L46:
        if (r3 != null) goto L89;
    L48:
        if (r2 != null) goto L93;
    L50:
        if (r9 != null) goto L77;
        return true;
    L93:
        r2.close();     // Catch: Exception -> L72
        goto L50
    L89:
        r3.close();     // Catch: Exception -> L71
        goto L48
    L79:
        r0.close();     // Catch: Exception -> L70
    L24:
        r3 = null;
    L22:
        th = move-exception;
        r3 = null;
        r0 = r10;
        th = th;
        goto L34
    L28:
        r3 = null;
    L26:
        th = th;
        r3 = null;
        goto L34
    L31:
        r9 = null;
        r3 = null;
    L29:
        th = move-exception;
        th = th;
        r9 = null;
        r3 = null;
    L43:
        r9 = null;
        r2 = null;
        r3 = null;
    L32:
        th = move-exception;
        th = th;
        r9 = null;
        r2 = null;
        r3 = null;
        goto L34
    L53:
        if (r7.isDirectory() == false) goto L109;
        File[] r11 = r7.listFiles();
        r8.mkdir();
        if (r11 != null) goto L57;
        return true;
    L57:
        if (r1 >= r11.length) goto L113;
        a(r11[r1].getAbsoluteFile(), new File(r8.getAbsoluteFile() + File.separator + r11[r1].getName()));
        r1 = r1 + 1;
        goto L57
    L113:
        return true;
    L109:
        return true;
    }

    public static boolean a(File r8) {
        boolean r1 = false;
        if (r8.isDirectory() == false) goto L10;
        String[] r0 = r8.list();
        int r3 = r0.length;
        int r4 = 0;
        boolean r5 = true;
    L5:
        if (r4 >= r3) goto L11;
        if (a(new File(r8, r0[r4])) == true) goto L9;
        r5 = false;
    L9:
        r4 = r4 + 1;
    L11:
        boolean r2 = r8.delete();
        if (r5 == false) goto L15;
        if (r2 == false) goto L15;
        r1 = true;
    L15:
        if (r1 == true) goto L17;
        q8.c("FileUtil", "delete failed: " + r8.getAbsolutePath());
    L17:
        return r1;
    L10:
        r5 = true;
        goto L11
    }
}
