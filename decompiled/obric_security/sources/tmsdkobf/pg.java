package tmsdkobf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes5.dex */
public abstract class pg {
    public static void a(String r9, String r10) {
        ZipFile r0 = new ZipFile(r9);
        Enumeration<? extends ZipEntry> r11 = r0.entries();
        byte[] r2 = new byte[1024];
    L4:
        if (r11.hasMoreElements() == false) goto L21;
        ZipEntry r3 = r11.nextElement();
        if (r3.getName().contains("../") == true) goto L4;
        if (r3.isDirectory() == true) goto L10;
        BufferedInputStream r4 = new BufferedInputStream(r0.getInputStream(r3));
        File r5 = new File(r10, r3.getName());
        File r6 = r5.getParentFile();
        if (r6 != null) goto L14;
    L16:
        ga.a("ZipUtils", "file " + r5.getAbsolutePath());
        FileOutputStream r7 = new FileOutputStream(r5);
        BufferedOutputStream r8 = new BufferedOutputStream(r7, 1024);
    L17:
        int r12 = r4.read(r2, 0, 1024);
        if (r12 == (-1)) goto L20;
        r7.write(r2, 0, r12);
        goto L17
    L20:
        r8.flush();
        r8.close();
        r7.close();
        r4.close();
        goto L4
    L14:
        if (r6.exists() == true) goto L16;
        r6.mkdirs();
        goto L16
    L10:
        new File(r10, r3.getName()).mkdirs();
        goto L4
    L21:
        r0.close();
    }
}
