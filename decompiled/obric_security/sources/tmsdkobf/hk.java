package tmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;

/* JADX INFO: loaded from: classes5.dex */
public class hk {
    public hk() {
    }

    void a(c7 r1) {
    }

    public String b(Context r1, String r2) {
        byte[] r0 = a(r1, r2);     // Catch: Exception -> L8
        if (r0 == null) goto L6;
        return uj.a(r0);
    L6:
        return null;
    }

    public String c(Context r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L12;
        return r3;
    L12:
        byte[] r1 = a(Base64.decode(r3, 0), null);     // Catch: Exception -> L11
        if (r1 == null) goto L14;
        return new String(r1, "gbk");
    L14:
        return null;
    L15:
        return null;
    }

    public String d(Context r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L9;
        return r3;
    L9:
        return a(r2, uj.c(r3));
    L7:
        return null;
    }

    public String e(Context r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L11;
        return r2;
    L11:
        byte[] r3 = b(r2.getBytes("gbk"), null);     // Catch: Exception -> L10
        if (r3 == null) goto L13;
        return Base64.encodeToString(r3, 0);
    L13:
        return null;
    L14:
        return null;
    }

    public String a(Context r1, byte[] r2) {
        if (r2 != null) goto L10;
        return null;
    L10:
        byte[] r3 = b(r2, null);     // Catch: Exception -> L9
        if (r3 == null) goto L12;
        return Base64.encodeToString(r3, 0);
    L12:
        return null;
    L13:
        return null;
    }

    private static byte[] b(byte[] r0, byte[] r1) {
        return ek.d(r0, r1);
    }

    public byte[] a(Context r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L9;
        return null;
    L9:
        return a(Base64.decode(r2, 0), null);
    L11:
        return null;
    }

    private static byte[] a(byte[] r0, byte[] r1) {
        return ek.b(r0, r1);
    }
}
