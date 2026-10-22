package com.android.apksig.internal.util;

import com.android.apksig.internal.asn1.Asn1BerParser;
import com.android.apksig.internal.asn1.Asn1DerEncoder;
import com.android.apksig.internal.x509.Certificate;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

/* JADX INFO: loaded from: classes.dex */
public class X509CertificateUtils {
    public static final byte[] BEGIN_CERT_HEADER = null;
    public static final byte[] END_CERT_FOOTER = null;
    private static CertificateFactory sCertFactory;

    static {
        BEGIN_CERT_HEADER = "-----BEGIN CERTIFICATE-----".getBytes();
        END_CERT_FOOTER = "-----END CERTIFICATE-----".getBytes();
        sCertFactory = null;
    }

    public X509CertificateUtils() {
    }

    private static void buildCertFactory() {
        if (sCertFactory == null) goto L10;
        return;
    L10:
        sCertFactory = CertificateFactory.getInstance("X.509");     // Catch: CertificateException -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException("Failed to create X.509 CertificateFactory", e);
    }

    public static X509Certificate generateCertificate(byte[] r1) throws CertificateException {
        if (sCertFactory != null) goto L6;
        buildCertFactory();
    L6:
        return generateCertificate(r1, sCertFactory);
    }

    private static ByteBuffer getNextDEREncodedCertificateBlock(ByteBuffer r4) throws CertificateException {
        if (r4 == null) goto L45;
        if (r4.remaining() >= BEGIN_CERT_HEADER.length) goto L6;
        return r4;
    L6:
        r4.mark();
        int r0 = 0;
    L7:
        byte[] r1 = BEGIN_CERT_HEADER;
        if (r0 >= r1.length) goto L14;
        if (r4.get() != r1[r0]) goto L11;
        r0 = r0 + 1;
        goto L7
    L11:
        r4.reset();
        return r4;
    L14:
        StringBuilder r2 = new StringBuilder();
    L16:
        if (r4.hasRemaining() == false) goto L24;
        char r3 = (char) r4.get();
        if (r3 == '-') goto L24;
        if (Character.isWhitespace(r3) == true) goto L16;
        r2.append(r3);
    L24:
        int r5 = 1;
    L25:
        byte[] r6 = END_CERT_FOOTER;
        if (r5 >= r6.length) goto L36;
        if (r4.hasRemaining() == false) goto L35;
        if (r4.get() != r6[r5]) goto L33;
        r5 = r5 + 1;
        goto L25
    L33:
        throw new CertificateException("The provided input contains the PEM certificate header without a valid certificate footer");
    L35:
        throw new CertificateException("The provided input contains the PEM certificate header but does not contain sufficient data for the footer");
    L36:
        byte[] r7 = Base64.getDecoder().decode(r2.toString());
        int r8 = r4.position();
    L38:
        if (r4.hasRemaining() == false) goto L42;
        if (Character.isWhitespace((char) r4.get()) == false) goto L42;
        r8 = r8 + 1;
    L42:
        r4.position(r8);
        return ByteBuffer.wrap(r7);
    L45:
        throw new NullPointerException("The certificateBuffer cannot be null");
    }

    public static X509Certificate generateCertificate(byte[] r3, CertificateFactory r4) throws CertificateException {
        return (X509Certificate) r4.generateCertificate(new ByteArrayInputStream(r3));
    L4:
        ByteBuffer r5 = getNextDEREncodedCertificateBlock(ByteBuffer.wrap(r3));     // Catch: Throwable -> L6
        int r0 = r5.position();     // Catch: Throwable -> L6
        X509Certificate r6 = (X509Certificate) r4.generateCertificate(new ByteArrayInputStream(Asn1DerEncoder.encode((Certificate) Asn1BerParser.parse(r5, Certificate.class))));     // Catch: Throwable -> L6
        byte[] r1 = new byte[r5.position() - r0];     // Catch: Throwable -> L6
        r5.position(r0);     // Catch: Throwable -> L6
        r5.get(r1);     // Catch: Throwable -> L6
        return new GuaranteedEncodedFormX509Certificate(r6, r1);
    L6:
        e = move-exception;
        throw new CertificateException("Failed to parse certificate", e);
    }
}
