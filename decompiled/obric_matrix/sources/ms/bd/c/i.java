package ms.bd.c;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
final class i extends b.a {
    i() {
    }

    @Override // ms.bd.c.b.a
    protected Object b(int r11, long r12, String r14, Object r15) {
        Context r10 = a.a().c();
        AssetManager r13 = r10.getAssets();
        if (r14.startsWith((String) m.a(16777217, 0, 0, "7297e9", new byte[]{104})) == true) goto L5;
        r14 = ((String) m.a(16777217, 0, 0, "42975a", new byte[]{107})) + r14;
    L5:
        String[] r16 = r13.list("");
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L7:
        if (r1 >= r16.length) goto L34;
        if (r16[r1].endsWith(r14) == false) goto L33;
        String r2 = r16[r1];
        String r3 = File.createTempFile((String) m.a(16777217, 0, 0, "de9b75", new byte[]{120, 116, 79, 14, 28}), "").getAbsolutePath();
        FileOutputStream r4 = null;
        InputStream r5 = r13.open(r2);     // Catch: Throwable -> L23 IOException -> L25
        FileOutputStream r6 = new FileOutputStream(r3);     // Catch: IOException -> L21 Throwable -> L30
    L50:
    L19:
        IOException e2 = e;
        r4 = r6;
    L27:
        e2.printStackTrace();     // Catch: Throwable -> L30
        r6 = r4;
    L29:
        e0.d(r5);
        e0.d(r6);
    L17:
        th = th;
        r4 = r6;
    L31:
        e0.d(r5);
        e0.d(r4);
        throw th;
    L14:
        if (e0.a(r5, r6) <= 0) goto L29;
        r0.add(r3);     // Catch: Throwable -> L17 IOException -> L19
    L30:
        th = th;
    L21:
        e2 = e;
        goto L27
    L25:
        e = move-exception;
        e2 = e;
        r5 = null;
    L23:
        th = th;
        r5 = null;
    L33:
        r1 = r1 + 1;
        goto L7
    L34:
        File[] r17 = new File(r10.getFilesDir(), (String) m.a(16777217, 0, 0, "3834bd", new byte[]{108, 55, 83, 68, 92, 103, 49, 38, 110, 103})).listFiles();
        if (r17 == null) goto L45;
        int r18 = r17.length;
        int r19 = 0;
    L37:
        if (r19 >= r18) goto L45;
        File r110 = r17[r19];
        if (r110.isFile() == false) goto L43;
        if (r110.getName().endsWith(r14) == false) goto L43;
        r0.add(r110.getAbsolutePath());
    L43:
        r19 = r19 + 1;
    L45:
        return r0.toArray(new String[0]);
    }
}
