package tmsdkobf;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class r8 {
    private static String a(Object r4) {
        StackTraceElement r2 = Thread.currentThread().getStackTrace()[4];     // Catch: Throwable -> L5
        return "[fileInfo:" + ("(" + r2.getFileName() + ":" + r2.getLineNumber() + ") " + r2.getMethodName()) + "] " + b(r4);
    L6:
        return b(r4);
    }

    public static boolean a() {
        return false;
    }

    public static void b(String r2, Object r3) {
        if (a() == false) goto L6;
        Log.e("TMSDK_IN_" + r2, a(r3));
        return;
    }

    public static void c(String r2, Object r3) {
        if (a() == false) goto L6;
        Log.i("TMSDK_IN_" + r2, a(r3));
        return;
    }

    public static void d(String r2, Object r3) {
        if (a() == false) goto L6;
        Log.v("TMSDK_IN_" + r2, a(r3));
        return;
    }

    public static void e(String r2, Object r3) {
        if (a() == false) goto L6;
        Log.w("TMSDK_IN_" + r2, a(r3));
        return;
    }

    public static void a(String r2, Object r3) {
        if (a() == false) goto L6;
        Log.d("TMSDK_IN_" + r2, a(r3));
        return;
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

    public static void a(String r1, String r2, Throwable r3) {
        if (a() == false) goto L8;
        if (r2 != null) goto L6;
        r2 = "(null)";
    L6:
        Log.println(6, "TMSDK_IN_" + r1, a(r2));
        return;
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
}
