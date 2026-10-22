package com.obric.security.tls;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TLSCertChainResult {
    private static final String TAG = null;
    private List<X509Certificate> certChain;
    private int errorCode;

    static {
        TAG = TLSCertChainResult.class.getSimpleName();
    }

    public TLSCertChainResult(int errorCode, byte[] certData) {
        this.errorCode = -1000;
        this.errorCode = errorCode;
        this.certChain = convertOutDataToCertificates(certData);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public List<X509Certificate> getCertChain() {
        return this.certChain;
    }

    private List<X509Certificate> convertOutDataToCertificates(byte[] outData) {
        if (outData != null) goto L6;
        Log.e(TAG, "Certificates outData is null");
        return null;
    L6:
        List<X509Certificate> certificates = null;
        ByteArrayInputStream inStream = null;
        inStream = new ByteArrayInputStream(outData);     // Catch: Throwable -> L20 CertificateException -> L22
        CertificateFactory factory = CertificateFactory.getInstance("X.509");     // Catch: Throwable -> L20 CertificateException -> L22
        Collection<? extends Certificate> tempCertificates = factory.generateCertificates(inStream);     // Catch: Throwable -> L20 CertificateException -> L22
        certificates = new ArrayList();     // Catch: Throwable -> L20 CertificateException -> L22
        Iterator<? extends Certificate> r5 = tempCertificates.iterator();     // Catch: Throwable -> L20 CertificateException -> L22
    L9:
        if (r5.hasNext() == false) goto L14;
        Certificate certificate = r5.next();     // Catch: Throwable -> L20 CertificateException -> L22
        if ((certificate instanceof X509Certificate) == false) goto L9;
        certificates.add((X509Certificate) certificate);     // Catch: Throwable -> L20 CertificateException -> L22
        goto L9
    L14:
        Log.d(TAG, "Total certificates parsed: " + certificates.size());     // Catch: Throwable -> L20 CertificateException -> L22
        inStream.close();     // Catch: IOException -> L17
    L29:
        return certificates;
    L17:
        e = e;
        String r4 = TAG;
        StringBuilder r6 = new StringBuilder();
    L19:
        Log.e(r4, r6.append("Error closing ByteArrayInputStream: ").append(e.getMessage()).toString(), e);
        goto L29
    L22:
        e = move-exception;
        Log.e(TAG, "Error parsing outData to certificates: " + e.getMessage(), e);     // Catch: Throwable -> L20
        if (inStream == null) goto L29;
        inStream.close();     // Catch: IOException -> L27
    L27:
        e = e;
        r4 = TAG;
        r6 = new StringBuilder();
    L20:
        th = move-exception;
        if (inStream != null) goto L38;
    L35:
        throw th;
    L38:
        inStream.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        Log.e(TAG, "Error closing ByteArrayInputStream: " + e.getMessage(), e);
        goto L35
    }
}
