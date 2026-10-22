package ms.bd.c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f22444a;

    public o3(Context r1) {
        this.f22444a = r1;
    }

    private boolean b() {
        String r2 = (String) m.a(16777217, 0, 0, "16f1f9", new byte[]{48, 49, 7, 86, 80, 61, 38, 89, 36, 120, 51, 122, 28, 65, 92, 32, 38, 30, 49, 104, 37, 38, 28, 65, 23, 61, 39, 7, 39, 110, 50, 32, 16, 65});
        String r4 = (String) m.a(16777217, 0, 0, "507550", new byte[]{116});
        Class<?> r5 = Class.forName((String) m.a(16777217, 0, 0, "270b1d", new byte[]{34, 59, 71, 4, 1, 122, 53, 88, 110, 33, 109, 6, 90, 5, 26, 118, 60, 38, 115, 61, 51, 48, 81, 2, 7, 118, 34}));     // Catch: Exception -> L11
        Method r0 = r5.getMethod((String) m.a(16777217, 0, 0, "cdc407", new byte[]{117, 99, 4}), new Class[]{String.class, String.class});     // Catch: Exception -> L11
        Object[] r9 = new Object[2];     // Catch: Exception -> L11
        r9[0] = r2;     // Catch: Exception -> L11
        r9[1] = (String) m.a(16777217, 0, 0, "36087a", new byte[]{55, 58, 72, 66, 7, 97, 62});     // Catch: Exception -> L11
        r4 = (String) r0.invoke(r5, r9);     // Catch: Exception -> L11
    L10:
        return r4.equals((String) m.a(16777217, 0, 0, "d285cc", new byte[]{36}));
    }

    public String a() {
        String r1 = null;
        if (b() == true) goto L5;
        return null;
    L5:
        Cursor r12 = this.f22444a.getContentResolver().query(Uri.parse((String) m.a(16777217, 0, 0, "bf5672", new byte[]{112, 107, 72, 86, 13, 43, 117, 29, 43, 41, 112, 107, 75, 12, 30, 44, 119, 72, 42, 112, 126, 119, 8, 107, 12, 21, 115, 72, 114, 111, 119, 97, 84, 13, 33, 33, 100, 73, 112, 111, 117, 109, 67, 80, 33, 33, 46, 104, 69, 79, 87})), null, null, null, null);
        if (r12 != null) goto L27;
    L20:
        if (r12 != null) goto L25;
    L22:
        return r1;
    L25:
        r12.close();     // Catch: Throwable -> L23
        goto L22
    L27:
        if (r12.moveToNext() == false) goto L20;
        r1 = r12.getString(r12.getColumnIndex((String) m.a(16777217, 0, 0, "4eecc1", new byte[]{51, 102, 26, 2, 89})));     // Catch: Throwable -> L13
    L29:
        String r0 = (String) m.a(16777217, 0, 0, "ea7fdc", new byte[]{98, 108});     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L24
    L19:
        throw th;
    }
}
