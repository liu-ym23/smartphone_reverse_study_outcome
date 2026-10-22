package ms.bd.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    public static void a() {
        b.c(65537, new d());
        b.c(65544, new e());
        b.c(65538, new f());
        b.c(65539, new g());
        b.c(InputDeviceCompat.SOURCE_TRACKBALL, new h());
        b.c(65541, new i());
        b.c(65542, new j());
        b.c(65543, new k());
        if (c0.h() == false) goto L5;
        b.a r0 = new u();
    L6:
        b.c(196609, r0);
        b.c(196610, r0);
        b.c(196611, r0);
        if (c0.e() == false) goto L9;
        q r1 = new r();
    L10:
        q.f(r1);
        b.c(131073, r1);
        b.c(131074, r1);
        return;
    L9:
        r1 = new p();
        goto L10
    L5:
        r0 = new t();
        goto L6
    }

    static /* synthetic */ boolean b(Context r0, String r1, String r2) {
        return c(r0, r1, r2);
    }

    private static boolean c(Context r17, String r18, String r19) {
        String[] r4 = r17.getAssets().list(r18);     // Catch: Exception -> L20
        if (r4.length <= 0) goto L12;
        new File(r19).mkdirs();     // Catch: Exception -> L20
        int r5 = r4.length;     // Catch: Exception -> L20
        int r6 = 0;
    L6:
        if (r6 >= r5) goto L28;
        String r7 = r4[r6];     // Catch: Exception -> L20
        StringBuilder r8 = new StringBuilder();     // Catch: Exception -> L20
        r8.append(r18);     // Catch: Exception -> L20
        r8.append((String) m.a(16777217, 0, 0, "e6e871", new byte[]{59}));     // Catch: Exception -> L20
        r8.append(r7);     // Catch: Exception -> L20
        String r9 = r8.toString();     // Catch: Exception -> L20
        StringBuilder r10 = new StringBuilder();     // Catch: Exception -> L20
        r10.append(r19);     // Catch: Exception -> L20
        r10.append((String) m.a(16777217, 0, 0, "7bf084", new byte[]{105}));     // Catch: Exception -> L20
        r10.append(r7);     // Catch: Exception -> L20
        c(r17, r9, r10.toString());     // Catch: Exception -> L20
        r6 = r6 + 1;     // Catch: Exception -> L20
        goto L6
    L28:
        return true;
    L12:
        InputStream r11 = r17.getAssets().open(r18);     // Catch: Exception -> L20
        FileOutputStream r12 = new FileOutputStream(r19);     // Catch: Exception -> L20
        e0.a(r11, r12);     // Catch: IOException -> L22 Throwable -> L15
    L15:
        th = move-exception;
        e0.d(r12);     // Catch: Exception -> L20
        e0.d(r11);     // Catch: Exception -> L20
        throw th;     // Catch: Exception -> L20
    L14:
        e0.d(r12);     // Catch: Exception -> L20
        e0.d(r11);     // Catch: Exception -> L20
        return true;
    L20:
        String r0 = (String) m.a(16777217, 0, 0, "855a84", new byte[]{42, 54, 64});
        return false;
    }
}
