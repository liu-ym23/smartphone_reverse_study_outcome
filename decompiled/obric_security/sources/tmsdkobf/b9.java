package tmsdkobf;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b9 {
    public static boolean a(Context r3) {
        if (r3.getPackageManager() != null) goto L5;
        return false;
    L5:
        String r4 = xk.a(xk.l);
        if (TextUtils.isEmpty(r4) == false) goto L10;
        return false;
    L10:
        monitor-enter(mh.class);     // Catch: Throwable -> L25
        Context r2 = mh.f353a;     // Catch: Throwable -> L21
        monitor-exit(mh.class);     // Catch: Throwable -> L25
        if (r2 == null) goto L29;
        PackageInfo r1 = r2.getPackageManager().getPackageInfo(r4, 0);     // Catch: Throwable -> L25
        if (r1 != null) goto L18;
        return false;
    L18:
        if (r4.equals(r1.packageName) == true) goto L32;
        return false;
    L32:
        return true;
    L29:
        return false;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L33:
        return false;
    }

    public static int b(Context r8) {
        boolean r1 = false;
        int r0 = vk.a(0, a(r8), 0);
        String r4 = new String(xj.a(xk.a(xk.n)));     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r4) == true) goto L17;
        String[] r3 = r4.split("\\n");     // Catch: Throwable -> L35
        if (r3 == null) goto L17;
        if (r3.length == 0) goto L17;
        String r5 = r8.getPackageName();     // Catch: Throwable -> L35
        int r6 = r3.length;     // Catch: Throwable -> L35
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L17;
        if (a(r5, r3[r7]) == true) goto L15;
        r7 = r7 + 1;
        goto L12
    L15:
        boolean r9 = true;
    L18:
        int r2 = vk.a(r0, r9, 1);
        Object r10 = new Object();
        AtomicReference r11 = new AtomicReference();
        AtomicBoolean r12 = new AtomicBoolean(false);
        r11.set(Boolean.FALSE);
        new Handler(r8.getMainLooper()).post(new a9(r12, r11, r10));
        monitor-enter(r10);
        r10.wait(100);     // Catch: Throwable -> L23 InterruptedException -> L33
    L23:
        th = move-exception;
        throw th;
    L25:
        monitor-exit(r10);     // Catch: Throwable -> L23
        r12.set(true);
        int r13 = vk.a(r2, ((Boolean) r11.get()).booleanValue(), 2);
        ClassLoader.getSystemClassLoader().loadClass(xk.a(xk.D0));     // Catch: Throwable -> L34
        r1 = true;
    L30:
        return vk.a(r13, r1, 3);
    L17:
        r9 = false;
        goto L18
    }

    public static boolean a(String r4, String r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        int r1 = r5.indexOf(47);
        if (r1 != (-1)) goto L8;
        return false;
    L8:
        String r2 = r5.substring(r1).trim();
        if (r2.startsWith("/data/") == true) goto L12;
        return false;
    L12:
        if (r2.startsWith("/data/data/" + r4 + LibrarianImpl.Constants.SEPARATOR) == false) goto L14;
        return false;
    L14:
        boolean r6 = r2.endsWith(LibrarianImpl.Constants.SO_SUFFIX);
        if (r6 == false) goto L17;
    L19:
        boolean r3 = false;
    L20:
        if (r6 == true) goto L24;
        if (r3 == true) goto L24;
        return false;
    L24:
        if (r5.contains(xk.a(xk.m)) == false) goto L26;
        return true;
    L26:
        return false;
    L17:
        if (r2.endsWith(".jar") == false) goto L19;
        r3 = true;
        goto L20
    }
}
