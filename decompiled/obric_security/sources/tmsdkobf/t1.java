package tmsdkobf;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class t1 {
    public static final String e = null;
    public static final String f = null;
    public static final String g = null;
    public static final String h = null;
    public static final String i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f521a;
    public int b;
    public String c;
    public ArrayList d;

    static {
        e = xk.a(xk.M0);
        f = xk.a(xk.N0);
        g = xk.a(xk.O0);
        h = xk.a(xk.P0);
        i = xk.a(xk.Q0);
    }

    public t1(String r5, String r6) {
        this.f521a = -1;
        this.b = -1;
        this.c = "";
        this.d = null;
        JSONObject r7 = new JSONObject(r5);     // Catch: Exception -> L12
        String r8 = i;     // Catch: Exception -> L12
        if (r7.has(r8) == false) goto L10;
        JSONArray r9 = r7.optJSONArray(r8);     // Catch: Exception -> L12
        r9.length();     // Catch: Exception -> L12
        this.d = new ArrayList();     // Catch: Exception -> L12
        int r1 = 0;
    L7:
        if (r1 >= r9.length()) goto L9;
        this.d.add(r9.getString(r1));     // Catch: Exception -> L12
        r1 = r1 + 1;     // Catch: Exception -> L12
        goto L7
    L9:
        a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(((String) this.d.get(0)).getBytes())));     // Catch: Exception -> L12
        r7.put(g, this.c);     // Catch: Exception -> L12
        r7.put(h, this.b);     // Catch: Exception -> L12
        r7.put(f, this.f521a);     // Catch: Exception -> L12
        r7.toString();     // Catch: Exception -> L12
        return;
    L10:
        this.f521a = r7.optLong(f);     // Catch: Exception -> L12
        this.b = r7.optInt(h);     // Catch: Exception -> L12
        this.c = r7.optString(g);     // Catch: Exception -> L12
        r7.optString(e);     // Catch: Exception -> L12
        return;
    }

    public final void a(X509Certificate r1) {
        oh.a(r1, this);     // Catch: Exception -> L4
        return;
    }

    public t1(Certificate[] r7) {
        this.f521a = -1;
        this.b = -1;
        this.c = "";
        this.d = null;
        if (r7 == null) goto L19;
        ArrayList r0 = new ArrayList();     // Catch: Exception -> L13
        JSONArray r1 = new JSONArray();     // Catch: Exception -> L13
        int r2 = 0;
    L6:
        if (r2 >= r7.length) goto L11;
        Certificate r3 = r7[r2];     // Catch: Exception -> L13
        Base64.encodeToString(r3.getEncoded(), 2);     // Catch: Exception -> L13
        String r4 = oh.a(r3);     // Catch: Exception -> L13
        if (r2 != 0) goto L10;
        a((X509Certificate) r3);     // Catch: Exception -> L13
    L10:
        r1.put(r4);     // Catch: Exception -> L13
        r0.add(r4);     // Catch: Exception -> L13
        r2 = r2 + 1;     // Catch: Exception -> L13
        goto L6
    L11:
        this.d = r0;     // Catch: Exception -> L13
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L13
        r8.put(i, r1);     // Catch: Exception -> L13
        r8.put(g, this.c);     // Catch: Exception -> L13
        r8.put(h, this.b);     // Catch: Exception -> L13
        r8.put(f, this.f521a);     // Catch: Exception -> L13
        r8.toString();     // Catch: Exception -> L13
        return;
    L20:
        return;
    }
}
