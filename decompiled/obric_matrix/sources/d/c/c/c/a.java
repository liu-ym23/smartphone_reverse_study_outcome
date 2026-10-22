package d.c.c.c;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static boolean a(File r4) {
        File[] r5 = r4.listFiles();
        boolean r0 = true;
        if (r5 == null) goto L7;
        int r1 = r5.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        r0 = r0 & b(r5[r2]);
        r2 = r2 + 1;
    L7:
        return r0;
    }

    public static boolean b(File r1) {
        if (r1.isDirectory() == false) goto L6;
        a(r1);
    L6:
        return r1.delete();
    }

    public static void c(File r5, b r6) {
        r6.b(r5);
        File[] r0 = r5.listFiles();
        if (r0 == null) goto L11;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L11;
        File r3 = r0[r2];
        if (r3.isDirectory() == false) goto L9;
        c(r3, r6);
    L10:
        r2 = r2 + 1;
        goto L5
    L9:
        r6.a(r3);
    L11:
        r6.c(r5);
    }
}
