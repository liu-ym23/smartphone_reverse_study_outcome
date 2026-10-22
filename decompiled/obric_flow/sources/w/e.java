package w;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f22670a = null;

    static {
        f22670a = Charset.forName("US-ASCII");
        Charset.forName("UTF-8");
    }

    public static void a(File r5) {
        File[] r10 = r5.listFiles();
        if (r10 == null) goto L16;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L14;
        File r13 = r10[r12];
        if (r13.isDirectory() == false) goto L10;
        a(r13);
    L10:
        if (r13.delete() == false) goto L13;
        r12 = r12 + 1;
        goto L5
    L13:
        throw new IOException("failed to delete file: " + r13);
    L14:
        return;
    L16:
        throw new IOException("not a readable directory: " + r5);
    }
}
