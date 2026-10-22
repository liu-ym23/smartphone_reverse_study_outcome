package b.a.a.a;

import android.util.Log;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static int a(String r0, int r1, int r2, String r3, String r4, int r5, int r6) {
        String r7 = r0.substring(r1, r2);
        o.b(r7, r3);
        Log.d(r4, r7);
        return r5 + r6;
    }

    public static String b(String r1, char r2, String r3) {
        return r1 + r2 + r3;
    }

    public static String c(String r1, int r2) {
        return r1 + r2;
    }

    public static String d(StringBuilder r0, String r1, String r2) {
        r0.append(r1);
        r0.append(r2);
        return r0.toString();
    }

    public static StringBuilder e(String r1) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r1);
        return r0;
    }

    public static void f(String r0, int r1, int r2, String r3, String r4) {
        String r5 = r0.substring(r1, r2);
        o.b(r5, r3);
        Log.d(r4, r5);
    }
}
