package com.obric.matrix.r.e;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static void a(File r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.exists() == true) goto L6;
        return;
    L6:
        if (r4.isDirectory() == false) goto L26;
        File[] r5 = r4.listFiles();
        if (r5 == null) goto L25;
        int r0 = r5.length;
        int r1 = 0;
    L11:
        if (r1 >= r0) goto L27;
        File r2 = r5[r1];
        if (r2.isDirectory() == false) goto L17;
        a(r2);
    L15:
        r2.delete();
    L19:
        r1 = r1 + 1;
        goto L11
    L17:
        if (r2.isFile() == false) goto L19;
    L27:
        return;
    L25:
        return;
    }
}
