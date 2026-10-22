package d.b.l.a.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import d.b.l.a.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<String> f14100a;

    static {
        f14100a = new ArrayList();
    }

    private static File a(Context r1, String r2) {
        String r3 = System.mapLibraryName(r2);
        File r4 = b(r1);
        if (r4 != null) goto L5;
        return null;
    L5:
        return new File(r4, r3);
    }

    private static File b(Context r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.getFilesDir() == null) goto L12;
        File r0 = new File(r2.getFilesDir(), "libso");
        if (r0.exists() == true) goto L9;
        d.a(r0.getAbsolutePath());
    L9:
        return r0;
    L12:
        return null;
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static synchronized boolean c(Context r6, String r7) {
        monitor-enter(b.class);
    L32:
        th = move-exception;
        throw th;
    L6:
        if (f14100a.contains(r7) == false) goto L38;
        monitor-exit(b.class);
        return true;
    L38:
        System.loadLibrary(r7);     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L14
        f14100a.add(r7);     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L14
    L28:
        monitor-exit(b.class);
        return true;
    L14:
        e = move-exception;
        File r4 = a(r6, r7);     // Catch: Throwable -> L32
        if (r4 != null) goto L20;
        return false;
    L20:
        if (r4.exists() == false) goto L22;
        r4.delete();     // Catch: Throwable -> L32
    L22:
        String r8 = d(r6, r7, r4);     // Catch: Throwable -> L32
        if (r8 == null) goto L35;
        Log.e("loadLibrary", e.getMessage() + "[" + r8 + "]");     // Catch: Throwable -> L32
        return false;
    L35:
        System.load(r4.getAbsolutePath());     // Catch: Throwable -> L30
        f14100a.add(r7);     // Catch: Throwable -> L30
    L31:
        return false;
    L13:
        return false;
    }

    public static String d(Context r8, String r9, File r10) {
        FileOutputStream r2 = null;
        ZipFile r3 = new ZipFile(new File(r8.getApplicationInfo().sourceDir), 1);     // Catch: Throwable -> L33
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L31
        r11.append("lib/");     // Catch: Throwable -> L31
        String r4 = Build.CPU_ABI;     // Catch: Throwable -> L31
        r11.append(r4);     // Catch: Throwable -> L31
        r11.append("/");     // Catch: Throwable -> L31
        r11.append(System.mapLibraryName(r9));     // Catch: Throwable -> L31
        ZipEntry r12 = r3.getEntry(r11.toString());     // Catch: Throwable -> L31
        if (r12 != null) goto L17;
        int r13 = r4.indexOf(45);     // Catch: Throwable -> L31
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L31
        r6.append("lib/");     // Catch: Throwable -> L31
        if (r13 > 0) goto L10;
        r13 = r4.length();     // Catch: Throwable -> L31
    L10:
        r6.append(r4.substring(0, r13));     // Catch: Throwable -> L31
        r6.append("/");     // Catch: Throwable -> L31
        r6.append(System.mapLibraryName(r9));     // Catch: Throwable -> L31
        String r14 = r6.toString();     // Catch: Throwable -> L31
        ZipEntry r15 = r3.getEntry(r14);     // Catch: Throwable -> L31
        if (r15 != null) goto L16;
        String r16 = "Library entry not found:" + r14;     // Catch: Throwable -> L31
        d.b(null);
        d.b(null);
    L14:
        d.c(r3);
        return r16;
    L16:
        r12 = r15;
    L17:
        r10.createNewFile();     // Catch: Throwable -> L31
        InputStream r17 = r3.getInputStream(r12);     // Catch: Throwable -> L31
        FileOutputStream r18 = new FileOutputStream(r10);     // Catch: Throwable -> L29
        byte[] r0 = new byte[4096];     // Catch: Throwable -> L27
    L21:
        int r1 = r17.read(r0);     // Catch: Throwable -> L27
        if (r1 <= 0) goto L24;
        r18.write(r0, 0, r1);     // Catch: Throwable -> L27
        goto L21
    L24:
        d.d(r10.getAbsolutePath(), 493);     // Catch: Throwable -> L27
        d.b(r18);
        d.b(r17);
        d.c(r3);
        return null;
    L27:
        th = move-exception;
        r2 = r18;
        InputStream r19 = r17;
        th = th;
    L45:
        r16 = th.getMessage();     // Catch: Throwable -> L37
        d.b(r2);
        d.b(r19);
    L37:
        th = move-exception;
        d.b(r2);
        d.b(r19);
        d.c(r3);
        throw th;
    L29:
        th = move-exception;
        r19 = r17;
        th = th;
    L31:
        th = th;
        r19 = null;
    L33:
        th = th;
        r19 = null;
        r3 = null;
        goto L45
    }
}
