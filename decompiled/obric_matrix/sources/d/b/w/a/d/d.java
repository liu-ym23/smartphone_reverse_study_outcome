package d.b.w.a.d;

import android.os.Process;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f15253a = -1;

    static class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r1, String r2) {
            Long.parseLong(r2);     // Catch: NumberFormatException -> L5
            return true;
        L5:
            return false;
        }
    }

    static {
    }

    public static int a() {
        if (f15253a != (-1)) goto L6;
        f15253a = Process.myPid();
    L6:
        return f15253a;
    }

    private static ArrayList<Long> b(String r5) {
        ArrayList<Long> r0 = new ArrayList();
        File[] r6 = new File(r5).listFiles(new a());
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(Long.valueOf(Long.parseLong(r6[r2].getName())));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static ArrayList<Long> c() {
        return b("/proc/self/task/");
    }
}
