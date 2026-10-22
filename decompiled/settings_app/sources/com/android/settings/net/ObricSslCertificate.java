package com.android.settings.net;

import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import com.android.internal.org.bouncycastle.asn1.x509.X509Name;
import com.android.internal.util.HexDump;
import com.android.settings.R;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.obric.oui.lisitem.OCardListItem;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public class ObricSslCertificate {
    private static String ISO_8601_DATE_FORMAT = "yyyy-MM-dd HH:mm:ssZ";
    private static final String ISSUED_BY = "issued-by";
    private static final String ISSUED_TO = "issued-to";
    private static final String VALID_NOT_AFTER = "valid-not-after";
    private static final String VALID_NOT_BEFORE = "valid-not-before";
    private static final String X509_CERTIFICATE = "x509-certificate";
    private final DName mIssuedBy;
    private final DName mIssuedTo;
    private final Date mValidNotAfter;
    private final Date mValidNotBefore;
    private final X509Certificate mX509Certificate;

    public class DName {
        private String mCName;
        private String mDName;
        private String mOName;
        private String mUName;
        final /* synthetic */ ObricSslCertificate this$0;

        public DName(ObricSslCertificate r4, String r5) {
            this.this$0 = r4;
            if (r5 == null) goto L24;
            this.mDName = r5;
            X509Name r6 = new X509Name(r5);     // Catch: IllegalArgumentException -> L25
            Vector r7 = r6.getValues();     // Catch: IllegalArgumentException -> L25
            Vector r8 = r6.getOIDs();     // Catch: IllegalArgumentException -> L25
            int r0 = 0;
        L6:
            if (r0 >= r8.size()) goto L36;
            if (r8.elementAt(r0).equals(X509Name.CN) == false) goto L14;
            if (this.mCName != null) goto L23;
            this.mCName = (String) r7.elementAt(r0);     // Catch: IllegalArgumentException -> L25
        L23:
            r0 = r0 + 1;
            goto L6
        L14:
            if (r8.elementAt(r0).equals(X509Name.O) == false) goto L19;
            if (this.mOName != null) goto L19;
            this.mOName = (String) r7.elementAt(r0);     // Catch: IllegalArgumentException -> L25
        L19:
            if (r8.elementAt(r0).equals(X509Name.OU) == false) goto L23;
            if (this.mUName != null) goto L23;
            this.mUName = (String) r7.elementAt(r0);     // Catch: IllegalArgumentException -> L25
            goto L23
        L36:
            return;
        L35:
            return;
        }

        public String getDName() {
            String r0 = this.mDName;
            if (r0 != null) goto L7;
            return "";
        L7:
            return r0;
        }

        public String getCName() {
            String r0 = this.mCName;
            if (r0 != null) goto L7;
            return "";
        L7:
            return r0;
        }

        public String getOName() {
            String r0 = this.mOName;
            if (r0 != null) goto L7;
            return "";
        L7:
            return r0;
        }

        public String getUName() {
            String r0 = this.mUName;
            if (r0 != null) goto L7;
            return "";
        L7:
            return r0;
        }
    }

    static {
    }

    public static Bundle saveState(ObricSslCertificate r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Bundle r0 = new Bundle();
        r0.putString(ISSUED_TO, r3.getIssuedTo().getDName());
        r0.putString(ISSUED_BY, r3.getIssuedBy().getDName());
        r0.putString(VALID_NOT_BEFORE, r3.getValidNotBefore());
        r0.putString(VALID_NOT_AFTER, r3.getValidNotAfter());
        X509Certificate r4 = r3.mX509Certificate;
        if (r4 != null) goto L10;
    L8:
        return r0;
    L10:
        r0.putByteArray(X509_CERTIFICATE, r4.getEncoded());     // Catch: CertificateEncodingException -> L9
        goto L8
    }

    public static ObricSslCertificate restoreState(Bundle r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        byte[] r1 = r8.getByteArray(X509_CERTIFICATE);
        if (r1 != null) goto L13;
    L7:
        X509Certificate r7 = null;
    L11:
        return new ObricSslCertificate(r8.getString(ISSUED_TO), r8.getString(ISSUED_BY), parseDate(r8.getString(VALID_NOT_BEFORE)), parseDate(r8.getString(VALID_NOT_AFTER)), r7);
    L13:
        r7 = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(r1));     // Catch: CertificateException -> L12
        goto L11
    }

    @Deprecated
    public ObricSslCertificate(String r7, String r8, String r9, String r10) {
        this(r7, r8, parseDate(r9), parseDate(r10), null);
    }

    @Deprecated
    public ObricSslCertificate(String r7, String r8, Date r9, Date r10) {
        this(r7, r8, r9, r10, null);
    }

    public ObricSslCertificate(X509Certificate r8) {
        this(r8.getSubjectDN().getName(), r8.getIssuerDN().getName(), r8.getNotBefore(), r8.getNotAfter(), r8);
    }

    private ObricSslCertificate(String r2, String r3, Date r4, Date r5, X509Certificate r6) {
        this.mIssuedTo = new DName(this, r2);
        this.mIssuedBy = new DName(this, r3);
        this.mValidNotBefore = cloneDate(r4);
        this.mValidNotAfter = cloneDate(r5);
        this.mX509Certificate = r6;
    }

    public Date getValidNotBeforeDate() {
        return cloneDate(this.mValidNotBefore);
    }

    @Deprecated
    public String getValidNotBefore() {
        return formatDate(this.mValidNotBefore);
    }

    public Date getValidNotAfterDate() {
        return cloneDate(this.mValidNotAfter);
    }

    @Deprecated
    public String getValidNotAfter() {
        return formatDate(this.mValidNotAfter);
    }

    public DName getIssuedTo() {
        return this.mIssuedTo;
    }

    public DName getIssuedBy() {
        return this.mIssuedBy;
    }

    public X509Certificate getX509Certificate() {
        return this.mX509Certificate;
    }

    private static String getSerialNumber(X509Certificate r1) {
        if (r1 != null) goto L5;
        return "";
    L5:
        BigInteger r2 = r1.getSerialNumber();
        if (r2 != null) goto L9;
        return "";
    L9:
        return fingerprint(r2.toByteArray());
    }

    private static String getDigest(X509Certificate r1, String r2) {
        if (r1 != null) goto L8;
        return "";
    L8:
        byte[] r3 = r1.getEncoded();     // Catch: Throwable -> L7
        return fingerprint(MessageDigest.getInstance(r2).digest(r3));
    L7:
        return "";
    }

    private static final String fingerprint(byte[] r4) {
        if (r4 != null) goto L5;
        return "";
    L5:
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L7:
        if (r1 >= r4.length) goto L12;
        HexDump.appendByteAsHex(r0, r4[r1], true);
        r1 = r1 + 1;
        if (r1 == r4.length) goto L7;
        r0.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        goto L7
    L12:
        return r0.toString();
    }

    public String toString() {
        return "Issued to: " + this.mIssuedTo.getDName() + ";\nIssued by: " + this.mIssuedBy.getDName() + ";\n";
    }

    private static Date parseDate(String r2) {
        return new SimpleDateFormat(ISO_8601_DATE_FORMAT).parse(r2);
    L4:
        return null;
    }

    private static String formatDate(Date r2) {
        if (r2 != null) goto L6;
        return "";
    L6:
        return new SimpleDateFormat(ISO_8601_DATE_FORMAT).format(r2);
    }

    private static Date cloneDate(Date r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return (Date) r0.clone();
    }

    public View inflateCertificateView(Context r10) {
        View r0 = LayoutInflater.from(r10).inflate(R.layout.trusted_credential_ssl_certificate, null);
        DName r1 = getIssuedTo();
        if (r1 == null) goto L8;
        setTailString(r0.findViewById(R.id.to_common_header), r1.getCName());
        setTailString(r0.findViewById(R.id.to_org_header), r1.getOName());
        setTailString(r0.findViewById(R.id.to_org_unit_header), r1.getUName());
        OCardListItem r6 = (OCardListItem) r0.findViewById(R.id.to_org_unit_header);
        if (r1.getUName().isEmpty() == false) goto L7;
        r0.findViewById(R.id.to_org_unit_header).setVisibility(8);
        r6.setCardPosition(3);
        goto L8
    L7:
        r6.setCardPosition(2);
    L8:
        setTailString(r0.findViewById(R.id.serial_number_header), getSerialNumber(this.mX509Certificate));
        DName r2 = getIssuedBy();
        if (r2 == null) goto L14;
        setTailString(r0.findViewById(R.id.by_common_header), r2.getCName());
        setTailString(r0.findViewById(R.id.by_org_header), r2.getOName());
        setTailString(r0.findViewById(R.id.by_org_unit_header), r2.getUName());
        OCardListItem r5 = (OCardListItem) r0.findViewById(R.id.by_org_header);
        if (r2.getUName().isEmpty() == false) goto L13;
        r0.findViewById(R.id.by_org_unit_header).setVisibility(8);
        r5.setCardPosition(3);
        goto L14
    L13:
        r5.setCardPosition(2);
    L14:
        String r3 = formatCertificateDate(r10, getValidNotBeforeDate());
        setTailString(r0.findViewById(R.id.issued_on_header), r3);
        String r11 = formatCertificateDate(r10, getValidNotAfterDate());
        setTailString(r0.findViewById(R.id.expires_on_header), r11);
        setTailString(r0.findViewById(R.id.sha256_fingerprint_header), getDigest(this.mX509Certificate, "SHA256"));
        setTailString(r0.findViewById(R.id.sha1_fingerprint_header), getDigest(this.mX509Certificate, "SHA1"));
        return r0;
    }

    private void setTailString(View r1, String r2) {
        if ((r1 instanceof OCardListItem) == false) goto L6;
        OCardListItemUtils.setTrailingMultiText((OCardListItem) r1, r2);
        return;
    }

    private String formatCertificateDate(Context r1, Date r2) {
        if (r2 != null) goto L6;
        return "";
    L6:
        return DateFormat.getMediumDateFormat(r1).format(r2);
    }
}
