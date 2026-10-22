package com.bytedance.privacy.utils;

import a.a;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.cert.Certificate;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CertUtils {
    public static String a(List r7, int r8) {
        if (r7 == null) goto L25;
        if (r7.isEmpty() == true) goto L25;
        if (r8 <= 0) goto L25;
        if (r8 > r7.size()) goto L25;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        Iterator r9 = r7.iterator();
        int r2 = 0;
    L10:
        if (r9.hasNext() == false) goto L23;
        Certificate r3 = (Certificate) r9.next();
        if (r2 >= r8) goto L23;
        if (r3 == null) goto L21;
        r0.write("-----BEGIN CERTIFICATE-----\\n".getBytes());
        String r4 = Base64.encodeToString(r3.getEncoded(), 2);
        int r5 = 0;
    L17:
        if (r5 >= r4.length()) goto L19;
        int r6 = r5 + 64;
        r0.write(r4.substring(r5, Math.min(r6, r4.length())).getBytes());
        r5 = r6;
        goto L17
    L19:
        r0.write("\\n".getBytes());
        r0.write("-----END CERTIFICATE-----\\n".getBytes());
        r2 = r2 + 1;
        goto L10
    L21:
        throw new IllegalArgumentException(a.e(r2, "Certificate is null at index "));
    L23:
        return r0.toString();
    L25:
        throw new IllegalArgumentException("Certificate list is null, empty, or certNum is invalid");
    }
}
