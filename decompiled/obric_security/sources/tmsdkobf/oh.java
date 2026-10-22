package tmsdkobf;

import android.util.Base64;
import java.io.BufferedWriter;
import java.io.StringWriter;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public abstract class oh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f399a = null;
    public static final String b = null;
    public static final String c = null;
    public static final String d = null;
    public static final /* synthetic */ boolean e = true;

    public static String a(Certificate r10) {
        StringWriter r0 = new StringWriter();
        BufferedWriter r1 = new BufferedWriter(r0);
        r1.write("-----BEGIN CERTIFICATE-----");
        r1.write(IOUtils.LINE_SEPARATOR_UNIX);
        byte[] r11 = Base64.encode(r10.getEncoded(), 2);
        char[] r4 = new char[64];
        int r6 = 0;
    L4:
        if (r6 >= r11.length) goto L12;
        int r7 = 0;
    L6:
        if (r7 == 64) goto L11;
        int r8 = r6 + r7;
        if (r8 >= r11.length) goto L11;
        r4[r7] = (char) r11[r8];
        r7 = r7 + 1;
    L11:
        r1.write(r4, 0, r7);
        r1.write(IOUtils.LINE_SEPARATOR_UNIX);
        r6 = r6 + 64;
        goto L4
    L12:
        r1.write("-----END CERTIFICATE-----");
        r1.write(IOUtils.LINE_SEPARATOR_UNIX);
        r1.close();
        return r0.toString();
    }

    static {
        f399a = xk.a(xk.R0);
        b = xk.a(xk.N0);
        c = xk.a(xk.O0);
        d = xk.a(xk.P0);
    }

    public static void a(X509Certificate r7, t1 r8) {
        byte[] r9 = r7.getExtensionValue(f399a);
        if (r9 == null) goto L30;
        if (r9.length == 0) goto L30;
        byte r0 = "{".getBytes()[0];     // Catch: Exception -> L26
        byte r2 = "}".getBytes()[0];     // Catch: Exception -> L26
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r3 >= r9.length) goto L15;
        byte r6 = r9[r3];     // Catch: Exception -> L26
        if (r6 != r0) goto L12;
        r4 = r3;
    L14:
        r3 = r3 + 1;     // Catch: Exception -> L26
        goto L8
    L12:
        if (r6 != r2) goto L14;
        r5 = r3;
        goto L14
    L15:
        if (r4 <= 0) goto L36;
        if (r4 < r5) goto L18;
        return;
    L18:
        if (e == false) goto L20;
    L24:
        int r10 = (r5 - r4) + 1;     // Catch: Exception -> L26
        byte[] r1 = new byte[r10];     // Catch: Exception -> L26
        System.arraycopy(r9, r4, r1, 0, r10);     // Catch: Exception -> L26
        JSONObject r11 = new JSONObject(new String(r1));     // Catch: Exception -> L26
        r8.c = r11.getString(c);     // Catch: Exception -> L26
        r8.b = r11.getInt(d);     // Catch: Exception -> L26
        r8.f521a = r11.getLong(b);     // Catch: Exception -> L26
        return;
    L20:
        if (r9[r4 - 1] == ((r5 - r4) + 1)) goto L24;
        throw new AssertionError();     // Catch: Exception -> L26
    L36:
        return;
    L26:
        e = move-exception;
        throw new Exception(p.a("C").append(e.getStackTrace()).toString());
    L30:
        throw new Exception("Couldn't find the keystore attestation extension data.");
    }
}
