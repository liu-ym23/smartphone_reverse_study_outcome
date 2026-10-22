package ms.bd.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public class w implements y.a {

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ZipFile f22529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ZipEntry f22530b;

        public a(ZipFile r1, ZipEntry r2) {
            this.f22529a = r1;
            this.f22530b = r2;
        }
    }

    public w() {
    }

    private a a(Context r17, String[] r18, String r19, z r20) {
        String[] r1 = d(r17);
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        ZipFile r5 = null;
        if (r4 >= r2) goto L27;
        String r6 = r1[r4];
        int r7 = r3;
    L6:
        int r8 = r7 + 1;
        if (r7 >= 5) goto L11;
        r5 = new ZipFile(new File(r6), 1);     // Catch: IOException -> L10
    L10:
        r7 = r8;
    L11:
        if (r5 == null) goto L26;
        int r9 = r3;
    L14:
        int r10 = r9 + 1;
        if (r9 >= 5) goto L31;
        int r11 = r18.length;
        int r12 = r3;
    L17:
        if (r12 >= r11) goto L23;
        String r13 = "lib" + File.separatorChar + r18[r12] + File.separatorChar + r19;
        Object[] r14 = new Object[2];
        r14[r3] = r13;
        r14[1] = r6;
        r20.getClass();
        String.format(Locale.US, "Looking for %s in APK %s...", r14);
        ZipEntry r15 = r5.getEntry(r13);
        if (r15 != null) goto L21;
        r12 = r12 + 1;
        r3 = 0;
        goto L17
    L21:
        return new a(r5, r15);
    L23:
        r9 = r10;
        goto L14
    L31:
        r5.close();     // Catch: IOException -> L28
    L26:
        r4 = r4 + 1;
        r3 = 0;
        goto L3
    L27:
        return null;
    }

    private void c(Closeable r1) {
        if (r1 == null) goto L8;
        r1.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    private String[] d(Context r4) {
        ApplicationInfo r3 = r4.getApplicationInfo();
        if (Build.VERSION.SDK_INT < 21) goto L11;
        String[] r5 = r3.splitSourceDirs;
        if (r5 == null) goto L11;
        if (r5.length == 0) goto L11;
        String[] r2 = new String[r5.length + 1];
        r2[0] = r3.sourceDir;
        System.arraycopy(r5, 0, r2, 1, r5.length);
        return r2;
    L11:
        return new String[]{r3.sourceDir};
    }

    private String[] e(Context r8, String r9) {
        Pattern r10 = Pattern.compile("lib" + File.separatorChar + "([^\\" + File.separatorChar + "]*)" + File.separatorChar + r9);
        HashSet r0 = new HashSet();
        String[] r7 = d(r8);
        int r11 = r7.length;
        ZipFile r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r11) goto L14;
        ZipFile r4 = new ZipFile(new File(r7[r2]), 1);     // Catch: IOException -> L18
        Enumeration<? extends ZipEntry> r3 = r4.entries();
    L8:
        if (r3.hasMoreElements() == false) goto L12;
        Matcher r5 = r10.matcher(r3.nextElement().getName());
        if (r5.matches() == false) goto L8;
        r0.add(r5.group(1));
        goto L8
    L12:
        r1 = r4;
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        if (r1 == null) goto L17;
        r1.close();     // Catch: IOException -> L19
    L17:
        return (String[]) r0.toArray(new String[r0.size()]);
    }

    public void b(Context r10, String[] r11, String r12, File r13, z r14) {
        a r0 = null;
        Closeable r1 = null;
        r1 = null;
        a r15 = a(r10, r11, r12, r14);     // Catch: Throwable -> L57
        if (r15 == null) goto L81;
        int r16 = 0;
    L7:
        int r17 = r16 + 1;
        if (r16 < 5) goto L10;
        ZipFile r9 = r15.f22529a;     // Catch: IOException -> L68
        if (r9 == null) goto L94;
        r9.close();     // Catch: IOException -> L68
        return;
    L94:
        return;
    L95:
        return;
    L10:
        String.format(Locale.US, "Found %s! Extracting...", new Object[]{r12});     // Catch: Throwable -> L51
        if (r13.exists() == true) goto L86;
        if (r13.createNewFile() == false) goto L44;
    L86:
        InputStream r18 = r15.f22529a.getInputStream(r15.f22530b);     // Catch: Throwable -> L37 Throwable -> L41
        FileOutputStream r3 = new FileOutputStream(r13);     // Catch: Throwable -> L35 Throwable -> L65
        long r4 = 0;
        byte[] r6 = new byte[4096];     // Catch: Throwable -> L33 Throwable -> L64
    L20:
        int r7 = r18.read(r6);     // Catch: Throwable -> L33 Throwable -> L64
        if (r7 == (-1)) goto L22;
        r3.write(r6, 0, r7);     // Catch: Throwable -> L33 Throwable -> L64 Throwable -> L64
        r4 = r4 + ((long) r7);
        goto L20
    L22:
        r3.flush();     // Catch: Throwable -> L33 Throwable -> L64
        r3.getFD().sync();     // Catch: Throwable -> L33 Throwable -> L64
        if (r4 != r13.length()) goto L43;
        c(r18);     // Catch: Throwable -> L51
        c(r3);     // Catch: Throwable -> L51
        r13.setReadable(true, false);     // Catch: Throwable -> L51
        r13.setExecutable(true, false);     // Catch: Throwable -> L51
        r13.setWritable(true);     // Catch: Throwable -> L51
        ZipFile r19 = r15.f22529a;     // Catch: IOException -> L63
        if (r19 == null) goto L92;
        r19.close();     // Catch: IOException -> L63
        return;
    L92:
        return;
    L93:
        return;
    L33:
        Throwable th = th;
        r1 = r3;
    L39:
        c(r18);     // Catch: Throwable -> L51
        c(r1);     // Catch: Throwable -> L51
        throw th;     // Catch: Throwable -> L51
    L43:
        c(r18);     // Catch: Throwable -> L51
        c(r3);     // Catch: Throwable -> L51
        goto L44
    L35:
        th = th;
    L42:
        r3 = null;
        goto L43
    L41:
        r18 = null;
    L37:
        th = move-exception;
        th = th;
        r18 = null;
    L44:
        r16 = r17;
        goto L7
    L81:
        String[] r20 = e(r10, r12);     // Catch: Throwable -> L51 Exception -> L53
    L56:
        throw new x(r12, r11, r20);     // Catch: Throwable -> L51
    L53:
        e = move-exception;
        r20 = new String[]{e.toString()};     // Catch: Throwable -> L51
    L51:
        th = th;
        r0 = r15;
    L58:
        if (r0 != null) goto L71;
    L62:
        throw th;
    L71:
        ZipFile r110 = r0.f22529a;     // Catch: IOException -> L67
        if (r110 == null) goto L62;
        r110.close();     // Catch: IOException -> L67
    L57:
        th = th;
        goto L58
    }
}
