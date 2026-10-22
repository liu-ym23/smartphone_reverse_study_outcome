package tmsdkobf;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ik {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f277a = 4;
    public static String b = null;
    public static boolean c = false;
    public static byte d = 4;
    public static byte e = 9;
    public static int f = 22;

    static {
    }

    private static boolean a(int r1) {
        if (r1 == 2) goto L7;
        if (r1 == 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static int b(Context r1) {
        cj.b("ENA", "ENAfalse");
        return 22;
    }

    public static void c(Context r6) {
        NetworkInfo r1 = bl.a();     // Catch: NullPointerException -> L5
    L31:
        f277a = 0;     // Catch: Exception -> L28
        d = 4;     // Catch: Exception -> L28
        if (r1 == null) goto L10;
        int r4 = r1.getType();     // Catch: Exception -> L28
        f277a = 0;     // Catch: Exception -> L28
    L12:
        if (r4 != 1) goto L14;
        f277a = 4;     // Catch: Exception -> L28
        d = 3;     // Catch: Exception -> L28
        e = 9;     // Catch: Exception -> L28
        goto L26
    L14:
        a(null);     // Catch: Exception -> L28
        f277a = 0;     // Catch: Exception -> L28
        if (a(0) == false) goto L26;
        b = Proxy.getDefaultHost();     // Catch: Exception -> L28
        Proxy.getDefaultPort();     // Catch: Exception -> L28
        String r0 = b;     // Catch: Exception -> L28
        if (r0 == null) goto L19;
        b = r0.trim();     // Catch: Exception -> L28
    L19:
        String r2 = b;     // Catch: Exception -> L28
        if (r2 != null) goto L23;
    L25:
        f277a = 1;     // Catch: Exception -> L28
        goto L26
    L23:
        if ("".equals(r2) == true) goto L25;
        f277a = 2;     // Catch: Exception -> L28
        goto L26
    L10:
        r4 = -1;
    L26:
        f = a(r6, r1);
        return;
    L5:
        r1 = null;
        goto L31
    }

    public static void a(Context r2) {
        monitor-enter(ik.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (c == false) goto L8;
        monitor-exit(ik.class);     // Catch: Throwable -> L11
        return;
    L8:
        c(r2);     // Catch: Throwable -> L11
        c = true;     // Catch: Throwable -> L11
        monitor-exit(ik.class);     // Catch: Throwable -> L11
    }

    private static void a(String r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.contains("cmwap") == false) goto L8;
        e = 0;
        return;
    L8:
        if (r1.contains("cmnet") == false) goto L11;
        e = 1;
        return;
    L11:
        if (r1.contains("3gwap") == false) goto L14;
        e = 2;
        return;
    L14:
        if (r1.contains("3gnet") == false) goto L17;
        e = 3;
        return;
    L17:
        if (r1.contains("uniwap") == false) goto L20;
        e = 4;
        return;
    L20:
        if (r1.contains("uninet") == false) goto L23;
        e = 5;
        return;
    L23:
        if (r1.contains("ctwap") == false) goto L26;
        e = 6;
        return;
    L26:
        if (r1.contains("ctnet") == false) goto L29;
        e = 7;
        return;
    L29:
        if (r1.contains("#777") == false) goto L40;
        e = 8;
        return;
    }

    private static int a(Context r3, NetworkInfo r4) {
        if (r4 != null) goto L13;
        return 0;
    L13:
        if (1 != r4.getType()) goto L9;
        return 1;
    L9:
        if (r4.getType() != 0) goto L16;
        return b(r3);
    L16:
        return 0;
    L17:
        return 0;
    }
}
