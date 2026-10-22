package com.android.apksig.internal.x509;

import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1Field;
import com.android.apksig.internal.asn1.Asn1OpaqueObject;
import com.android.apksig.internal.asn1.Asn1Type;
import com.android.apksig.internal.pkcs7.AlgorithmIdentifier;
import com.android.apksig.internal.pkcs7.IssuerAndSerialNumber;
import com.android.apksig.internal.pkcs7.SignerIdentifier;
import com.android.apksig.internal.util.ByteBufferUtils;
import com.android.apksig.internal.util.GuaranteedEncodedFormX509Certificate;
import com.android.apksig.internal.util.X509CertificateUtils;
import java.nio.ByteBuffer;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes.dex */
@Asn1Class(type = Asn1Type.SEQUENCE)
public class Certificate {

    @Asn1Field(index = 0, type = Asn1Type.SEQUENCE)
    public TBSCertificate certificate;

    @Asn1Field(index = 2, type = Asn1Type.BIT_STRING)
    public ByteBuffer signature;

    @Asn1Field(index = 1, type = Asn1Type.SEQUENCE)
    public AlgorithmIdentifier signatureAlgorithm;

    public Certificate() {
    }

    public static X509Certificate findCertificate(Collection<X509Certificate> r2, SignerIdentifier r3) {
        Iterator<X509Certificate> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        X509Certificate r0 = r4.next();
        if (isMatchingCerticicate(r0, r3) == false) goto L4;
        return r0;
    L8:
        return null;
    }

    private static boolean isMatchingCerticicate(X509Certificate r3, SignerIdentifier r4) {
        IssuerAndSerialNumber r5 = r4.issuerAndSerialNumber;
        if (r5 != null) goto L5;
        return false;
    L5:
        X500Principal r2 = new X500Principal(ByteBufferUtils.toByteArray(r5.issuer.getEncoded()));
        if (r5.certificateSerialNumber.equals(r3.getSerialNumber()) == true) goto L8;
        return false;
    L8:
        if (r2.equals(r3.getIssuerX500Principal()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static List<X509Certificate> parseCertificates(List<Asn1OpaqueObject> r5) throws CertificateException {
        if (r5.isEmpty() == true) goto L5;
        ArrayList r0 = new ArrayList(r5.size());
        int r1 = 0;
    L8:
        if (r1 >= r5.size()) goto L15;
        byte[] r2 = ByteBufferUtils.toByteArray(r5.get(r1).getEncoded());
        r0.add(new GuaranteedEncodedFormX509Certificate(X509CertificateUtils.generateCertificate(r2), r2));
        r1 = r1 + 1;
    L12:
        e = move-exception;
        throw new CertificateException("Failed to parse certificate #" + (r1 + 1), e);
    L15:
        return r0;
    L5:
        return Collections.emptyList();
    }
}
