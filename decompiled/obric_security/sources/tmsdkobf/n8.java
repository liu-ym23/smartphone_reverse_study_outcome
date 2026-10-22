package tmsdkobf;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class n8 {
    private static n8 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o3 f364a;

    private n8() {
        this.f364a = ((me) qd.a(9)).a("QQSecureProvider");
    }

    public static n8 a() {
        if (b != null) goto L6;
        b = new n8();
    L6:
        return b;
    }

    public ArrayList b() {
        ArrayList r0 = new ArrayList();
        Cursor r1 = this.f364a.e("SELECT info1 FROM dcr_info");
        if (r1 != null) goto L19;
    L16:
        this.f364a.close();
        return r0;
    L19:
        int r2 = r1.getColumnIndex("info1");     // Catch: Throwable -> L9 Exception -> L11
    L6:
        if (r1.moveToNext() == false) goto L13;
        r0.add(r1.getString(r2));     // Catch: Throwable -> L9 Exception -> L11
    L13:
        r1.close();
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r1.close();
        throw th;
    }

    public Map a(String r1, boolean r2) {
        return bc.a().a(r1, r2);
    }

    public byte[] a(String r4) {
        Cursor r5 = this.f364a.e("SELECT info2 FROM dcr_info WHERE info1='" + r4 + "'");
        byte[] r0 = null;
        if (r5 != null) goto L18;
    L16:
        this.f364a.close();
        return r0;
    L18:
        int r1 = r5.getColumnIndex("info2");     // Catch: Throwable -> L9 Exception -> L11
    L6:
        if (r5.moveToNext() == false) goto L13;
        r0 = r5.getBlob(r1);     // Catch: Throwable -> L9 Exception -> L11
    L13:
        r5.close();
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r5.close();
        throw th;
    }
}
