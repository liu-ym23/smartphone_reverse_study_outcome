package d.b.b.o.n;

import android.os.Process;
import d.b.b.o.d;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public class a {
    static {
    }

    public static long a() {
        BufferedReader r1 = null;
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);     // Catch: Throwable -> L10
        String r0 = r2.readLine();     // Catch: Throwable -> L7
        r2.close();     // Catch: Throwable -> L7
        String[] r3 = r0.split(" ");     // Catch: Throwable -> L7
        long r4 = Long.parseLong(r3[13]) + Long.parseLong(r3[14]);
        d.b(r2);
        return r4;
    L7:
        r1 = r2;
    L8:
        d.b(r1);
        return -1;
    }
}
