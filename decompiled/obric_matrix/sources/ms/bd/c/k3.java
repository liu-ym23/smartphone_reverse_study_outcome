package ms.bd.c;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public class k3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f22412a;

    public k3(Context r1) {
        this.f22412a = r1;
    }

    private String a(Cursor r8) {
        String r7 = null;
        if (r8 != null) goto L6;
        return null;
    L6:
        if (r8.isClosed() == false) goto L8;
        return null;
    L8:
        r8.moveToFirst();
        int r0 = r8.getColumnIndex((String) m.a(16777217, 0, 0, "65a1ac", new byte[]{49, 54, 30, 80, 91}));
        if (r0 <= 0) goto L11;
        r7 = r8.getString(r0);
    L11:
        int r1 = r8.getColumnIndex((String) m.a(16777217, 0, 0, "db335e", new byte[]{118, 111, 68, 66}));
        if (r1 <= 0) goto L14;
        r8.getInt(r1);
    L14:
        int r2 = r8.getColumnIndex((String) m.a(16777217, 0, 0, "5da54a", new byte[]{33, 126, 2, 72, 25, 115, 50}));
        if (r2 <= 0) goto L17;
        r8.getLong(r2);
    L17:
        return r7;
    }

    public void b(g3.a r23) {
        PackageManager r9 = this.f22412a.getPackageManager();     // Catch: Exception -> L23
        if (r9 == null) goto L9;
        if (r9.resolveContentProvider((String) m.a(16777217, 0, 0, "566492", new byte[]{39, 59, 72, 14, 11, 32, 63, 13, 114, 42, 34, 56, 92, 77, 3, 107, 57, 7, 98, 106, 45, 48, 86, 68, 13}), 0) == null) goto L9;
        boolean r10 = true;
    L10:
        if (r10 == true) goto L12;
        return;
    L12:
        Uri r11 = Uri.parse((String) m.a(16777217, 0, 0, "8c0fcf", new byte[]{42, 110, 77, 6, 89, 127, 47, 24, 46, 121, 42, 110, 78, 92, 81, 116, 50, 88, 116, 120, 47, 109, 90, 31, 89, 63, 52, 82, 100, 56, 32, 101, 80, 22, 87, 62}));
        Cursor r12 = null;
        ContentResolver r13 = this.f22412a.getContentResolver();
        String[] r14 = new String[1];     // Catch: Throwable -> L20
        r14[0] = (String) m.a(16777217, 0, 0, "e9ced8", new byte[]{123, 58, 25, 21});     // Catch: Throwable -> L20
        r12 = r13.query(r11, null, null, r14, null);     // Catch: Throwable -> L20
        String r0 = a(r12);     // Catch: Throwable -> L20
        if (r23 == null) goto L18;
        r23.a(r0);     // Catch: Throwable -> L20
    L18:
        if (r12 == null) goto L28;
    L21:
        r12.close();
        return;
    L28:
        return;
    L20:
        if (r12 != null) goto L21;
        return;
    L9:
        r10 = false;
        goto L10
    }
}
