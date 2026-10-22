package ms.bd.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 {
    public static long a(InputStream r5, OutputStream r6) {
        byte[] r0 = new byte[256];
        long r1 = 0;
    L3:
        int r3 = r5.read(r0);
        if (r3 <= 0) goto L6;
        r6.write(r0, 0, r3);
        r1 = r1 + ((long) r3);
        goto L3
    L6:
        r6.flush();
        return r1;
    }

    public static Boolean b(Context r29) {
        if (r29 == null) goto L14;
        ConnectivityManager r0 = (ConnectivityManager) r29.getSystemService((String) m.a(16777217, 0, 0, "c20059", new byte[]{113, 63, 77, 74, 15, 45, 116, 26, 119, 105, 102, 41}));     // Catch: Throwable -> L15
        Method r1 = r0.getClass().getDeclaredMethod((String) m.a(16777217, 0, 0, "4d5aff", new byte[]{34, 99, 82, 52, 90, 101, 62, 83, 97, 31, 32, 114, 81, 26, 75, 122, 30, 75, 98, 62}), new Class[0]);     // Catch: Throwable -> L15
        r1.setAccessible(true);     // Catch: Throwable -> L15
        NetworkInfo r2 = (NetworkInfo) r1.invoke(r0, new Object[0]);     // Catch: Throwable -> L15
        if (r2 == null) goto L14;
        Method r3 = r2.getClass().getDeclaredMethod((String) m.a(16777217, 0, 0, "66cf34", new byte[]{46, 39, 49, 4, 13, 42, 57, 22, 48, 58, 34}), new Class[0]);     // Catch: Throwable -> L15
        r3.setAccessible(true);     // Catch: Throwable -> L15
        return Boolean.valueOf(((Boolean) r3.invoke(r2, new Object[0])).booleanValue());
    L14:
        return Boolean.FALSE;
    }

    public static String c(int r2, int r3, String r4, String r5) {
        if (r3 != 0) goto L8;
        Class<?> r6 = Class.forName(r4);     // Catch: Exception -> L16
        Method r7 = r6.getDeclaredMethod(r5, new Class[0]);     // Catch: Exception -> L16
        if (r2 != 1) goto L7;
        Object r8 = r7.invoke(r6, new Object[]{a.a().c()});     // Catch: Exception -> L16
    L12:
        return (String) r8;
    L7:
        r8 = r7.invoke(r6, new Object[0]);     // Catch: Exception -> L16
        goto L12
    L8:
        if (r3 != 1) goto L14;
        Class<?> r9 = Class.forName(r4);     // Catch: Exception -> L16
        Field r10 = r9.getDeclaredField(r5);     // Catch: Exception -> L16
        if (r10.getType() != String.class) goto L14;
        r10.setAccessible(true);     // Catch: Exception -> L16
        r8 = r10.get(r9);     // Catch: Exception -> L16
    L14:
        return null;
    }

    public static void d(Closeable r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static boolean e() {
        return f(new String[]{(String) m.a(16777217, 0, 0, "41c458", new byte[]{36, 61, 20, 82, 5, 38, 51, 94, 34, 97, 55, 62, 25, 83, 25, 38, 56, 30, 124, 69, 6, 16, 53, 115, 57, 16, 0, 57, 20, 77, 26, 0, 36, 97, 62, 10})});
    }

    public static boolean f(String... r7) {
        Context r1 = a.a().c();     // Catch: Throwable -> L11
        int r2 = r7.length;     // Catch: Throwable -> L11
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L9;
        if (r1.checkPermission(r7[r3], Process.myPid(), Process.myUid()) != 0) goto L7;
        r3 = r3 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    L11:
        return false;
    }

    public static byte[] g(String r7) {
        int r0 = r7.length();
        byte[] r1 = new byte[r0 / 2];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2 / 2] = (byte) ((Character.digit(r7.charAt(r2), 16) << 4) + Character.digit(r7.charAt(r2 + 1), 16));
        r2 = r2 + 2;
        goto L3
    L5:
        return r1;
    }
}
