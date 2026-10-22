package ms.bd.c;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class f4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f22358a = null;

    static {
        f22358a = (String) m.a(16777217, 0, 0, "187653", new byte[]{45, 63, 74, 67, 68, 39, 40, 21});
    }

    public static int a(Context r14) {
        int r0 = 3;
        ByteArrayOutputStream r3 = null;
        int r5 = 255;
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L49
        r6.append(r14.getFilesDir().getAbsolutePath());     // Catch: Throwable -> L49
        r6.append((String) m.a(16777217, 0, 0, "06963b", new byte[]{110}));     // Catch: Throwable -> L49
        String r7 = f22358a;     // Catch: Throwable -> L49
        r6.append(r7);     // Catch: Throwable -> L49
        String r8 = r6.toString();     // Catch: Throwable -> L49
        File r9 = new File(r8);     // Catch: Throwable -> L49
        if (r9.exists() == true) goto L60;
    L10:
        InputStream r15 = r14.getResources().getAssets().open(r7);     // Catch: Throwable -> L49
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();     // Catch: Throwable -> L45
        byte[] r11 = new byte[4096];     // Catch: Throwable -> L26
    L14:
        int r12 = r15.read(r11, 0, 4096);     // Catch: Throwable -> L26
        if (r12 == (-1)) goto L17;
        r10.write(r11, 0, r12);     // Catch: Throwable -> L26
        goto L14
    L17:
        FileOutputStream r4 = new FileOutputStream(r8);     // Catch: Throwable -> L26
        r4.write(r10.toByteArray());     // Catch: Throwable -> L26
        r4.close();     // Catch: Throwable -> L26
        if (r10.size() <= 0) goto L68;
        if (new File(r8).exists() == false) goto L23;
        r0 = 0;
        goto L68
    L23:
        r0 = r5;
    L68:
        r15.close();     // Catch: Throwable -> L43
    L50:
        r10.close();     // Catch: Throwable -> L44
    L36:
        return r0;
    L26:
        r3 = r10;
    L54:
        String r1 = (String) m.a(16777217, 0, 0, "286194", new byte[]{34, 57, 122, 66});     // Catch: Throwable -> L37
        if (r15 != null) goto L64;
    L32:
        if (r3 == null) goto L71;
        r10 = r3;
        r0 = r5;
        goto L50
    L71:
        return r5;
    L64:
        r15.close();     // Catch: Throwable -> L46
    L37:
        th = move-exception;
        if (r15 != null) goto L62;
    L40:
        if (r3 == null) goto L72;
        r3.close();     // Catch: Throwable -> L48
        throw th;
    L73:
        throw th;
    L72:
        throw th;
    L62:
        r15.close();     // Catch: Throwable -> L47
        goto L40
    L60:
        r9.delete();     // Catch: Throwable -> L9
        r5 = 2;
    L9:
        r5 = 2;
    L27:
        r15 = null;
        goto L54
    }
}
