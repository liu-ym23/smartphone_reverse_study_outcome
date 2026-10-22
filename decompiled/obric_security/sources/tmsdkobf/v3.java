package tmsdkobf;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import tmsdk.common.tcc.TccCryptor;

/* JADX INFO: loaded from: classes5.dex */
public class v3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    o3 f567a;
    boolean b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f568a;
        public String b;

        a(String r1, String r2) {
            this.f568a = r1;
            this.b = r2;
        }
    }

    public v3(boolean r3) {
        this.f567a = null;
        this.b = false;
        this.f567a = ((me) qd.a(9)).a("QQSecureProvider");
        this.b = r3;
    }

    private static String a(byte[] r1) {
        if (r1 == null) goto L8;
        byte[] r2 = TccCryptor.decrypt(r1, null);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new String(r2);
    L8:
        return null;
    }

    public List a(String r10) {
        ArrayList r1 = null;
        String r0 = "SELECT * FROM dcp_info WHERE info2=(x'" + y5.a(TccCryptor.encrypt(r10.getBytes(), null)) + "')";
        q8.a("fgtDatabaseParse", getClass().getSimpleName() + " getRootPaths pkg:" + r10);
        Cursor r11 = this.f567a.e(r0);
        if (r11 != null) goto L26;
    L24:
        this.f567a.close();
        return r1;
    L26:
        int r2 = r11.getColumnIndex("info1");     // Catch: Throwable -> L17 Exception -> L19
        int r3 = r11.getColumnIndex("info3");     // Catch: Throwable -> L17 Exception -> L19
        int r4 = r11.getColumnIndex("info4");     // Catch: Throwable -> L17 Exception -> L19
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L17 Exception -> L19
    L28:
        if (r11.moveToNext() == false) goto L14;
        String r6 = r11.getString(r2);     // Catch: Exception -> L15 Throwable -> L17
        if (this.b == false) goto L10;
        String r7 = a(r11.getBlob(r4));     // Catch: Exception -> L15 Throwable -> L17
    L11:
        if (r6 == null) goto L28;
        q8.a("fgtDatabaseParse", "add root path:" + r6);     // Catch: Exception -> L15 Throwable -> L17
        r5.add(new a(r6, r7));     // Catch: Exception -> L15 Throwable -> L17
        goto L28
    L10:
        r7 = a(r11.getBlob(r3));     // Catch: Exception -> L15 Throwable -> L17
        goto L11
    L14:
        r11.close();
        r1 = r5;
    L15:
        e = e;
        r1 = r5;
    L20:
        e.printStackTrace();     // Catch: Throwable -> L17
        r11.close();
    L19:
        e = e;
    L17:
        th = move-exception;
        r11.close();
        throw th;
    }
}
