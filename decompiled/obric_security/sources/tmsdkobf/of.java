package tmsdkobf;

import android.content.Context;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import tmsdk.common.creator.ManagerCreatorC;
import tmsdk.common.module.qscanner.impl.AmScannerV2;
import tmsdk.common.module.update.UpdateConfig;

/* JADX INFO: loaded from: classes5.dex */
public abstract class of {
    private static int a(String r4) {
        return Integer.parseInt(r4.substring(0, r4.lastIndexOf(LibrarianImpl.Constants.DOT)));
    L5:
        e = move-exception;
        q8.b("UpdateManager", "fileName: " + r4 + " e: " + e.getMessage());
        return 0;
    }

    public static e2 b(String r6) {
        byte[] r0 = a(r6, 0, 24);     // Catch: IOException -> L6
        e2 r2 = new e2();
        byte[] r4 = new byte[4];
        System.arraycopy(r0, 4, r4, 0, 4);
        r2.c = c3.b(r4);
        byte[] r5 = new byte[16];
        System.arraycopy(r0, 8, r5, 0, 16);
        r2.b = r5;
        r2.f170a = a(new File(r6).getName());
        return r2;
    L6:
        e = move-exception;
        q8.c("UpdateManager", e.getMessage());
        return null;
    }

    public static yf c(Context r1, String r2) {
        if (new File(r2).exists() == true) goto L7;
        return null;
    L7:
        return AmScannerV2.a(r1, r2);
    }

    public static e2 a(Context r4, long r5) {
        if (r5 != 1073741824) goto L6;
        return b(r4, b(r4, r5));
    L6:
        if (r5 != 2) goto L9;
        return a(50001, a(r4, 50001, ".sdb"));
    L9:
        if (r5 != 1152921504606846976L) goto L14;
        e2 r6 = c(40461, a(r4, 40461, ".sdb"));
        if (r6 == null) goto L17;
        q8.c("gjj", "fileId:" + r6.f170a + " timestamp:" + r6.c + " pfutimestamp:" + r6.d + " version:" + r6.f);
        return r6;
    L17:
        return r6;
    L14:
        return b(b(r4, r5));
    }

    public static String b(Context r2, long r3) {
        String r0 = r2.getFilesDir().getAbsolutePath();
        String r4 = UpdateConfig.getFileNameIdByFlag(r3);
        if (r4 != null) goto L6;
        return null;
    L6:
        String r5 = r0 + File.separator + r4;
        if (new File(r5).exists() == true) goto L9;
        z4.a(r2, r4, r0);
    L9:
        return r5;
    }

    public static e2 c(int r5, String r6) {
        e2 r0 = new e2();
        byte[] r7 = a(r6, 0, 24);     // Catch: IOException -> L6
        r0.f = r7[0];
        byte[] r3 = new byte[4];
        System.arraycopy(r7, 4, r3, 0, 4);
        r0.c = c3.b(r3);
        byte[] r4 = new byte[16];
        System.arraycopy(r7, 8, r4, 0, 16);
        r0.b = r4;
        r0.d = r0.c;
        r0.f170a = r5;
        return r0;
    L6:
        e = move-exception;
        q8.c("UpdateManager", e.getMessage());
        r0.f170a = r5;
        r0.b = new byte[0];
        r0.c = 0;
        if (r0.b != null) goto L10;
        r0.b = c3.a("");
    L10:
        return r0;
    }

    private static byte[] a(String r2, int r3, int r4) {
        byte[] r5 = new byte[r4];
        RandomAccessFile r0 = new RandomAccessFile(r2, "r");
        r0.skipBytes(r3);     // Catch: Throwable -> L6
        r0.read(r5);     // Catch: Throwable -> L6
        r0.close();
        return r5;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    public static e2 b(int r0, String r1) {
        ua.a(ManagerCreatorC.getManager(p9.class));
        throw null;
    }

    public static String a(Context r2, int r3, String r4) {
        if (r4 == null) goto L9;
        if (r2 == null) goto L11;
        String r0 = r2.getFilesDir().getAbsolutePath();
        String r5 = Integer.toString(r3) + r4;
        String r6 = r0 + File.separator + r5;
        if (new File(r6).exists() == true) goto L8;
        z4.a(r2, r5, r0);
    L8:
        return r6;
    L11:
        return null;
    L9:
        return null;
    }

    public static e2 b(Context r2, String r3) {
        File r0 = new File(r3);
        if (r0.exists() == false) goto L7;
        yf r4 = AmScannerV2.a(r2, r3);
        if (r4 == null) goto L7;
        e2 r5 = new e2();
        r5.f170a = UpdateConfig.getFileIdByFileName(r0.getName());
        r5.c = r4.f641a;
        r5.f = r4.b;
        return r5;
    L7:
        return null;
    }

    public static String a(Context r2, String r3) {
        if (r3 == null) goto L10;
        if (r2 == null) goto L10;
        String r4 = r2.getFilesDir().getAbsolutePath() + File.separator + r3;
        if (new File(r4).exists() == true) goto L9;
        return null;
    L9:
        return r4;
    L10:
        return null;
    }

    public static e2 a(int r6, String r7) {
        e2 r0 = new e2();
        byte[] r8 = a(r7, 0, 48);     // Catch: IOException -> L6
        r0.f = r8[0];
        byte[] r3 = new byte[4];
        System.arraycopy(r8, 4, r3, 0, 4);
        r0.c = c3.b(r3);
        byte[] r4 = new byte[16];
        System.arraycopy(r8, 8, r4, 0, 16);
        r0.b = r4;
        byte[] r5 = new byte[4];
        System.arraycopy(r8, 44, r5, 0, 4);
        r0.d = c3.b(r5);
        r0.f170a = r6;
        return r0;
    L6:
        e = move-exception;
        q8.c("UpdateManager", e.getMessage());
        r0.f170a = r6;
        r0.b = new byte[0];
        r0.c = 0;
        if (r0.b != null) goto L10;
        r0.b = c3.a("");
    L10:
        return r0;
    }
}
