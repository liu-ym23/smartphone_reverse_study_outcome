package tmsdkobf;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: loaded from: classes5.dex */
public abstract class x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f612a = null;

    public interface a {
        boolean a(File r1);
    }

    static {
        f612a = new byte[]{77, 68, 53};
    }

    public static String a(byte[] r6) {
        char[] r0 = {DeepCleanSAFEngine.DetailPath.KEY, DeepCleanSAFEngine.DetailPath.DETAIL_PATH, DeepCleanSAFEngine.DetailPath.FILENAME, DeepCleanSAFEngine.DetailPath.FILESIZE, DeepCleanSAFEngine.DetailPath.CTIME, DeepCleanSAFEngine.DetailPath.MTIME, DeepCleanSAFEngine.DetailPath.ATIME, DeepCleanSAFEngine.DetailPath.IMPORTANT, '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] r1 = new char[r6.length * 2];
        int r2 = 0;
    L4:
        if (r2 >= r6.length) goto L7;
        byte r3 = r6[r2];
        int r4 = r2 * 2;
        r1[r4] = r0[(r3 >>> 4) & 15];
        r1[r4 + 1] = r0[r3 & 15];
        r2 = r2 + 1;
        goto L4
    L7:
        return new String(r1);
    }

    public static String a(File r1) {
        return a(new FileInputStream(r1));
    L4:
        return null;
    }

    public static String a(InputStream r5) {
        String r0 = null;
        if (r5 != null) goto L14;
    L9:
        if (r5 != null) goto L16;
    L11:
        return r0;
    L16:
        r5.close();     // Catch: IOException -> L12
        goto L11
    L14:
        MessageDigest r1 = MessageDigest.getInstance(new String(f612a));     // Catch: Throwable -> L13
        byte[] r2 = new byte[8192];     // Catch: Throwable -> L13
    L5:
        int r3 = r5.read(r2);     // Catch: Throwable -> L13
        if (r3 == (-1)) goto L8;
        r1.update(r2, 0, r3);     // Catch: Throwable -> L13
        goto L5
    L8:
        r0 = a(r1.digest());     // Catch: Throwable -> L13
        goto L9
    }

    public static boolean a(String r6, FileFilter r7, a r8) {
        File r0 = new File(r6);
        if (r0.exists() == false) goto L21;
        if (r8 == null) goto L21;
        File[] r9 = r0.listFiles(r7);
        if (r9 == null) goto L21;
        if (r9.length == 0) goto L21;
        int r1 = r9.length;
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L21;
        File r3 = r9[r2];
        if (r3.isDirectory() == false) goto L18;
        if (a(r3.getAbsolutePath(), r7, r8) == false) goto L20;
        return true;
    L20:
        r2 = r2 + 1;
        goto L11
    L18:
        if (r8.a(r3) == false) goto L20;
        return true;
    L21:
        return false;
    }
}
