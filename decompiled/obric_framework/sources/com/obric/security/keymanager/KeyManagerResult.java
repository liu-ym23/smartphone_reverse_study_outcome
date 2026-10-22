package com.obric.security.keymanager;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class KeyManagerResult {
    private static final String TAG = null;
    private List<Certificate> certChainResult;
    private byte[] mOutData;
    private int mResultCode;

    static {
        TAG = KeyManagerResult.class.getSimpleName();
    }

    public KeyManagerResult(int code, byte[] outData) {
        this.mResultCode = -1000;
        this.mResultCode = code;
        this.mOutData = outData;
    }

    public KeyManagerResult(int code, byte[] outData, boolean isCertChain) {
        this.mResultCode = -1000;
        this.mResultCode = code;
        this.mOutData = outData;
        if (isCertChain == false) goto L9;
        List<Certificate> certificates = convertOutDataToCertificates(outData);
        if (certificates == null) goto L7;
        this.certChainResult = new ArrayList(certificates);
        return;
    L7:
        this.certChainResult = null;
        return;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public byte[] getOutData() {
        return this.mOutData;
    }

    public List<Certificate> getCertChain() {
        return this.certChainResult;
    }

    private List<Certificate> convertOutDataToCertificates(byte[] outData) {
        if (outData != null) goto L6;
        Log.e(TAG, "Certificates outData is null");
        return null;
    L6:
        List<Certificate> certificates = null;
        ByteArrayInputStream inStream = null;
        inStream = new ByteArrayInputStream(outData);     // Catch: Throwable -> L13 CertificateException -> L15
        CertificateFactory factory = CertificateFactory.getInstance("X.509");     // Catch: Throwable -> L13 CertificateException -> L15
        certificates = new ArrayList(factory.generateCertificates(inStream));     // Catch: Throwable -> L13 CertificateException -> L15
        Log.d(TAG, "Total certificates parsed: " + certificates.size());     // Catch: Throwable -> L13 CertificateException -> L15
        inStream.close();     // Catch: IOException -> L10
    L29:
    L22:
        return certificates;
    L10:
        e = e;
        String r4 = TAG;
        StringBuilder r5 = new StringBuilder();
    L12:
        Log.e(r4, r5.append("Error closing ByteArrayInputStream: ").append(e.getMessage()).toString(), e);
        goto L22
    L13:
        th = move-exception;
        if (inStream != null) goto L34;
    L28:
        throw th;
    L34:
        inStream.close();     // Catch: IOException -> L26
    L26:
        e = move-exception;
        Log.e(TAG, "Error closing ByteArrayInputStream: " + e.getMessage(), e);
    L15:
        e = move-exception;
        Log.e(TAG, "Error parsing outData to certificates: " + e.getMessage(), e);     // Catch: Throwable -> L13
        if (inStream == null) goto L29;
        inStream.close();     // Catch: IOException -> L20
    L20:
        e = e;
        r4 = TAG;
        r5 = new StringBuilder();
        goto L12
    }
}
