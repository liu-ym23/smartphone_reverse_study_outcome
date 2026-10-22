package d.b.i.a.b.i;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f13907a;

    static {
    }

    public static String a(Context r1) {
        String r2 = f13907a;
        if (TextUtils.isEmpty(r2) == true) goto L5;
        return r2;
    L5:
        String r3 = b();
        f13907a = r3;
        return r3;
    }

    private static String b() {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L16
    L5:
        int r3 = r1.read();     // Catch: Throwable -> L16
        if (r3 <= 0) goto L8;
        r2.append((char) r3);     // Catch: Throwable -> L16
        goto L5
    L8:
        String r0 = r2.toString();     // Catch: Throwable -> L16
        r1.close();     // Catch: Exception -> L15
    L10:
        return r0;
    L12:
        if (r1 != null) goto L22;
    L14:
        return null;
    L22:
        r1.close();     // Catch: Exception -> L17
    L11:
        r1 = null;
        goto L12
    }
}
