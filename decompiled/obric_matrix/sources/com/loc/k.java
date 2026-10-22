package com.loc;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7461a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7462b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7463c = null;

    static {
        f7461a = u5.u("SYmFja3Vwcw");
        f7462b = u5.u("SLmFkaXU");
        f7463c = u5.u("JIw");
    }

    private static String a(Context r9) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 31) goto L5;
    L22:
        File r10 = r9.getApplicationContext().getExternalFilesDir("");
    L21:
        return r10.getAbsolutePath();
    L5:
        if (r9.getApplicationInfo().targetSdkVersion < 30) goto L9;
        if (r0 >= 30) goto L22;
    L9:
        if (r0 < 9) goto L11;
        StorageManager r11 = (StorageManager) r9.getSystemService("storage");
    L23:
        Class<?> r1 = Class.forName(u5.u("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));     // Catch: Throwable -> L19
        Method r2 = r11.getClass().getMethod(u5.u("FZ2V0Vm9sdW1lTGlzdA"), new Class[0]);     // Catch: Throwable -> L19
        Method r3 = r1.getMethod(u5.u("ZZ2V0UGF0aA"), new Class[0]);     // Catch: Throwable -> L19
        Method r4 = r1.getMethod(u5.u("AaXNSZW1vdmFibGUK"), new Class[0]);     // Catch: Throwable -> L19
        Object r12 = r2.invoke(r11, new Object[0]);     // Catch: Throwable -> L19
        int r5 = Array.getLength(r12);     // Catch: Throwable -> L19
        int r6 = 0;
    L13:
        if (r6 >= r5) goto L18;
        Object r7 = Array.get(r12, r6);     // Catch: Throwable -> L19
        String r8 = (String) r3.invoke(r7, new Object[0]);     // Catch: Throwable -> L19
        if (((Boolean) r4.invoke(r7, new Object[0])).booleanValue() == false) goto L16;
        r6 = r6 + 1;
        goto L13
    L16:
        return r8;
    L18:
        return null;
    L19:
        r10 = Environment.getExternalStorageDirectory();
        goto L21
    L11:
        r11 = null;
        goto L23
    }

    public static synchronized void b(Context r3, String r4, String r5) {
        monitor-enter(k.class);
    L45:
        th = move-exception;
        throw th;
    L5:
        if (Build.VERSION.SDK_INT < 19) goto L13;
        if (r3 != null) goto L8;
    L11:
        monitor-exit(k.class);
        return;
    L8:
        if (r3.checkCallingOrSelfPermission(u5.u("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX0VYVEVSTkFMX1NUT1JBR0U=")) != 0) goto L11;
        if (r3.checkCallingOrSelfPermission(u5.u("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ==")) != 0) goto L11;
    L13:
        String r6 = a(r3);     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r6) == false) goto L17;
        monitor-exit(k.class);
        return;
    L17:
        String r7 = r4 + f7463c + r5;     // Catch: Throwable -> L45
        File r8 = new File(r6 + File.separator + f7461a);     // Catch: Throwable -> L45
        File r9 = new File(r8, f7462b);     // Catch: Throwable -> L45
        FileLock r1 = null;
    L37:
        FileChannel r10 = null;
        RandomAccessFile r11 = null;
    L38:
        if (r1 != null) goto L62;
    L40:
        if (r10 != null) goto L53;
    L42:
        c(r11);     // Catch: Throwable -> L45
        monitor-exit(k.class);
        return;
    L53:
        r10.close();     // Catch: IOException -> L52 Throwable -> L45
        goto L42
    L62:
        r1.release();     // Catch: IOException -> L51 Throwable -> L45
        goto L40
    L20:
        if (r8.exists() == true) goto L22;
    L23:
        r8.mkdirs();     // Catch: Throwable -> L37
    L24:
        r9.createNewFile();     // Catch: Throwable -> L37
        r11 = new RandomAccessFile(r9, "rws");     // Catch: Throwable -> L37
        r10 = r11.getChannel();     // Catch: Throwable -> L36
        r1 = r10.tryLock();     // Catch: Throwable -> L50
        if (r1 == null) goto L29;
        r10.write(ByteBuffer.wrap(r7.getBytes("UTF-8")));     // Catch: Throwable -> L50
    L29:
        if (r1 != null) goto L66;
    L31:
        if (r10 != null) goto L57;
    L33:
        c(r11);     // Catch: Throwable -> L45
        monitor-exit(k.class);
        return;
    L57:
        r10.close();     // Catch: IOException -> L49 Throwable -> L45
        goto L33
    L66:
        r1.release();     // Catch: IOException -> L48 Throwable -> L45
    L36:
        r10 = null;
        goto L38
    L22:
        if (r8.isDirectory() == false) goto L24;
        goto L23
    }

    private static void c(Closeable r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }
}
