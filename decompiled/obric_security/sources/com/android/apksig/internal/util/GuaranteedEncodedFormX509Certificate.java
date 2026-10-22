package com.android.apksig.internal.util;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class GuaranteedEncodedFormX509Certificate extends DelegatingX509Certificate {
    private static final long serialVersionUID = 1;
    private final byte[] mEncodedForm;
    private int mHash;

    public GuaranteedEncodedFormX509Certificate(X509Certificate r1, byte[] r2) {
        super(r1);
        this.mHash = -1;
        if (r2 == null) goto L5;
        byte[] r3 = (byte[]) r2.clone();
    L6:
        this.mEncodedForm = r3;
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if ((r3 instanceof X509Certificate) == true) goto L11;
        return false;
    L11:
        return Arrays.equals(getEncoded(), ((X509Certificate) r3).getEncoded());
    L10:
        return false;
    }

    @Override // com.android.apksig.internal.util.DelegatingX509Certificate, java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        byte[] r0 = this.mEncodedForm;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (byte[]) r0.clone();
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        if (this.mHash != (-1)) goto L8;
        this.mHash = Arrays.hashCode(getEncoded());     // Catch: CertificateEncodingException -> L6
    L6:
        this.mHash = 0;
    L8:
        return this.mHash;
    }
}
