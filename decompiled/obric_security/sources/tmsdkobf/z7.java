package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public abstract class z7 {
    private static JceInputStream a(byte[] r1) {
        JceInputStream r0 = new JceInputStream(r1);
        r0.setServerEncoding("UTF-8");
        return r0;
    }

    public static JceStruct b(byte[] r1, JceStruct r2, boolean r3) {
        if (r1 == null) goto L13;
        if (r2 == null) goto L13;
        if (r3 == true) goto L15;
    L11:
        r2.recyle();     // Catch: Exception -> L14
        r2.readFrom(a(r1));     // Catch: Exception -> L14
        return r2;
    L15:
        JceStruct r4 = r2.newInit();     // Catch: Exception -> L14
        if (r4 == null) goto L11;
        r2 = r4;
    L13:
        return null;
    }

    public static JceStruct a(byte[] r1, JceStruct r2, boolean r3) {
        if (r1 == null) goto L10;
        if (r2 == null) goto L10;
        if (r3 == true) goto L12;
    L8:
        r2.recyle();     // Catch: Exception -> L11
        r2.readFrom(a(r1));     // Catch: Exception -> L11
        return r2;
    L12:
        r2 = r2.newInit();     // Catch: Exception -> L11
    L10:
        return null;
    }

    public static byte[] a(JceStruct r3) {
        if (r3 != null) goto L8;
        return null;
    L8:
        JceOutputStream r1 = new JceOutputStream();     // Catch: Exception -> L7
        r1.setServerEncoding("UTF-8");     // Catch: Exception -> L7
        r3.writeTo(r1);     // Catch: Exception -> L7
        return r1.toByteArray();
    L7:
        return null;
    }
}
