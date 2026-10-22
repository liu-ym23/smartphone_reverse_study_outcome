package tmsdkobf;

import android.text.TextUtils;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class q8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f436a = "";
    private static boolean b = false;
    private static boolean c = false;
    private static c d;

    static {
        d = new o9();
    }

    private static String a(Object r0) {
        return b(r0);
    L5:
        return b(r0);
    }

    public static void b(String r1, Object r2) {
        d.b(r1, a(r2));
    }

    public static void c(String r1, Object r2) {
        d.c(r1, a(r2));
    }

    public static void d(String r1, Object r2) {
        d.d(r1, a(r2));
    }

    public static void e(String r1, Object r2) {
        d.e(r1, a(r2));
    }

    public static void a(String r6, String r7) {
        if (c == false) goto L9;
        String r0 = TMSDKContext.getStrFromEnvMap(TMSDKContext.PRE_TCP_SERVER_ADDRESS) + "-xxx";
        if (TextUtils.isEmpty(f436a) == true) goto L7;
        Log.println(4, f436a, "[net][" + r0 + "]" + r7 + "[TMSDK_" + r6 + "]");
        return;
    L7:
        Log.println(4, "TMSDK_" + r6, "[net][" + r0 + "]" + r7);
        return;
    }

    public static void b(String r4, String r5) {
        if (c == false) goto L9;
        ve.e();
        if (TextUtils.isEmpty(f436a) == true) goto L7;
        Log.println(4, f436a, "[net][]" + r5 + "[TMSDK_" + r4 + "]");
        return;
    L7:
        Log.println(4, "TMSDK_" + r4, "[net][]" + r5);
        return;
    }

    public static void c(String r1, String r2, Throwable r3) {
        d.c(r1, a(r2), r3);
    }

    public static void a(String r1, Object r2) {
        d.a(r1, a(r2));
    }

    public static void b(String r1, String r2, Throwable r3) {
        d.b(r1, a(r2), r3);
    }

    public static void a(String r1, String r2, Throwable r3) {
        d.a(r1, a(r2), r3);
    }

    public static void b(boolean r0) {
        c = r0;
    }

    public static String a(Throwable r2) {
        if (r2 != null) goto L5;
        return "(Null stack trace)";
    L5:
        StringWriter r0 = new StringWriter();
        PrintWriter r1 = new PrintWriter(r0);
        r2.printStackTrace(r1);
        r1.flush();
        String r3 = r0.toString();
        r1.close();
        return r3;
    }

    private static String b(Object r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if ((r1 instanceof String) == false) goto L10;
        return (String) r1;
    L10:
        if ((r1 instanceof Throwable) == false) goto L14;
        return a((Throwable) r1);
    L14:
        return r1.toString();
    }

    public static boolean a() {
        return b;
    }

    public static void a(boolean r0) {
        b = r0;
        if (r0 == false) goto L5;
        c r1 = new s8();
    L6:
        d = r1;
        return;
    L5:
        r1 = new o9();
        goto L6
    }

    public static void a(String r0) {
        f436a = r0;
    }
}
