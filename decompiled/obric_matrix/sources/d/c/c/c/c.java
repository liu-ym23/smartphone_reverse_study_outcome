package d.c.c.c;

import d.c.c.d.i;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class c {

    public static class a extends IOException {
        public a(String r1) {
            super(r1);
        }

        public a(String r1, Throwable r2) {
            super(r1);
            initCause(r2);
        }
    }

    public static class b extends IOException {
        public b(String r1) {
            super(r1);
        }
    }

    /* JADX INFO: renamed from: d.c.c.c.c$c, reason: collision with other inner class name */
    public static class C0413c extends FileNotFoundException {
        public C0413c(String r1) {
            super(r1);
        }
    }

    public static class d extends IOException {
        public d(String r1, Throwable r2) {
            super(r1);
            initCause(r2);
        }
    }

    public static void a(File r3) {
        if (r3.exists() == false) goto L13;
        if (r3.isDirectory() == false) goto L8;
        return;
    L8:
        if (r3.delete() == true) goto L13;
        throw new a(r3.getAbsolutePath(), new b(r3.getAbsolutePath()));
    L13:
        if (r3.mkdirs() == false) goto L15;
        return;
    L15:
        if (r3.isDirectory() == false) goto L18;
        return;
    L18:
        throw new a(r3.getAbsolutePath());
    }

    public static void b(File r4, File r5) {
        i.g(r4);
        i.g(r5);
        r5.delete();
        if (r4.renameTo(r5) == false) goto L5;
        return;
    L5:
        Throwable r0 = null;
        if (r5.exists() == false) goto L8;
        r0 = new b(r5.getAbsolutePath());
    L15:
        throw new d("Unknown error renaming " + r4.getAbsolutePath() + " to " + r5.getAbsolutePath(), r0);
    L8:
        if (r4.getParentFile().exists() == true) goto L10;
        r0 = new C0413c(r4.getAbsolutePath());
        goto L15
    L10:
        if (r4.exists() == true) goto L15;
        r0 = new FileNotFoundException(r4.getAbsolutePath());
        goto L15
    }
}
