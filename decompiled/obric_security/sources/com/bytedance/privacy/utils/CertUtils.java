package com.bytedance.privacy.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.cert.CertPathValidator;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes.dex */
public class CertUtils {
    private static final String TAG = "CertUtils";

    static {
    }

    public CertUtils() {
    }

    public static String certsToPemString(List<Certificate> r7, int r8) throws Exception {
        if (r7 == null) goto L25;
        if (r7.isEmpty() == true) goto L25;
        if (r8 <= 0) goto L25;
        if (r8 > r7.size()) goto L25;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        Iterator<Certificate> r9 = r7.iterator();
        int r2 = 0;
    L10:
        if (r9.hasNext() == false) goto L23;
        Certificate r3 = r9.next();
        if (r2 >= r8) goto L23;
        if (r3 == null) goto L21;
        r0.write("-----BEGIN CERTIFICATE-----\\n".getBytes());
        String r4 = Base64.getEncoder().encodeToString(r3.getEncoded());
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
        throw new IllegalArgumentException("Certificate is null at index " + r2);
    L23:
        return r0.toString();
    L25:
        throw new IllegalArgumentException("Certificate list is null, empty, or certNum is invalid");
    }

    public static List<X509Certificate> convertToX509Certificates(byte[] r4) {
        ArrayList r0 = new ArrayList();
        Iterator<? extends Certificate> r5 = CertificateFactory.getInstance("X.509").generateCertificates(new ByteArrayInputStream(r4)).iterator();     // Catch: CertificateException -> L10
    L5:
        if (r5.hasNext() == false) goto L12;
        Certificate r1 = r5.next();     // Catch: CertificateException -> L10
        if ((r1 instanceof X509Certificate) == false) goto L5;
        r0.add((X509Certificate) r1);     // Catch: CertificateException -> L10
    L12:
        return r0;
    L10:
        e = move-exception;
        LogUtils.e(TAG, "convertToX509Certificates failed, exception: " + e.getMessage());
        goto L12
    }

    public static X509Certificate pemStringToX509(String r3) {
        return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(Base64.getDecoder().decode(r3.replace("-----BEGIN CERTIFICATE-----", "").replace("-----END CERTIFICATE-----", "").replace(IOUtils.LINE_SEPARATOR_UNIX, ""))));
    L5:
        e = move-exception;
        LogUtils.e(TAG, "pemStringToX509 failed, exception: " + e.getMessage());
        return null;
    }

    public static boolean validateCertChain(X509Certificate r4, List<X509Certificate> r5) {
        if (r4 == null) goto L15;
        if (r5 == null) goto L15;
        if (r5.isEmpty() == true) goto L15;
        HashSet r1 = new HashSet();
        r1.add(new TrustAnchor(r4, null));
        PKIXParameters r6 = new PKIXParameters(r1);     // Catch: Exception -> L12
        r6.setRevocationEnabled(false);     // Catch: Exception -> L12
        CertPathValidator.getInstance("PKIX").validate(CertificateFactory.getInstance("X.509").generateCertPath(r5), r6);     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        LogUtils.e(TAG, "validateCertChain failed, exception: " + e.getMessage());
        return false;
    L15:
        LogUtils.e(TAG, "Invalid params.");
        return false;
    }
}
