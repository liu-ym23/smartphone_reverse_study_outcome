package d.b.w.a.d;

import android.util.Log;
import com.bytedance.keva.KevaImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class c {

    public interface a {
        boolean a(String r1);
    }

    public static void a(BufferedReader r0) {
        if (r0 == null) goto L10;
        r0.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        b.c(Log.getStackTraceString(e));
        return;
    }

    public static BufferedReader b(File r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.exists() == true) goto L11;
        StringBuilder r1 = new StringBuilder();
        r1.append("file:");
        r1.append(r3.getName());
        String r4 = " not exist";
    L8:
        r1.append(r4);
        b.g(r1.toString());
        return null;
    L11:
        if (r3.canRead() == true) goto L18;
        r1 = new StringBuilder();
        r1.append("file:");
        r1.append(r3.getName());
        r4 = " can not read";
        goto L8
    L18:
        return new BufferedReader(new FileReader(r3), KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
    L15:
        e = move-exception;
        b.c(Log.getStackTraceString(e));
        return null;
    }

    public static void c(File r1, a r2) {
        if (r1 == null) goto L23;
        if (r2 == null) goto L24;
        BufferedReader r3 = b(r1);
        if (r3 != null) goto L8;
        return;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L16;
        String r4 = r3.readLine();     // Catch: IOException -> L14
        if (r4 == null) goto L16;
        r0 = r2.a(r4);     // Catch: IOException -> L14
    L14:
        e = move-exception;
        b.c(Log.getStackTraceString(e));
    L16:
        a(r3);
        return;
    L24:
        return;
    }

    public static void d(String r1, a r2) {
        if (r1 == null) goto L7;
        if (r2 == null) goto L8;
        c(new File(r1), r2);
        return;
    L8:
        return;
    }
}
