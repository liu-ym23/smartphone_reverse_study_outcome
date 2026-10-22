package cz.msebera.android.httpclient.conn.ssl;

import cz.msebera.android.httpclient.conn.util.DomainType;
import cz.msebera.android.httpclient.conn.util.InetAddressUtils;
import cz.msebera.android.httpclient.conn.util.PublicSuffixMatcher;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.net.InetAddress;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes5.dex */
public final class DefaultHostnameVerifier implements HostnameVerifier {
    public HttpClientAndroidLog log;
    private final PublicSuffixMatcher publicSuffixMatcher;

    /* JADX INFO: renamed from: cz.msebera.android.httpclient.conn.ssl.DefaultHostnameVerifier$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cz$msebera$android$httpclient$conn$ssl$DefaultHostnameVerifier$HostNameType = null;

        static {
            int[] r0 = new int[HostNameType.values().length];
            $SwitchMap$cz$msebera$android$httpclient$conn$ssl$DefaultHostnameVerifier$HostNameType = r0;
            r0[HostNameType.IPv4.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$cz$msebera$android$httpclient$conn$ssl$DefaultHostnameVerifier$HostNameType[HostNameType.IPv6.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static final enum HostNameType extends Enum<HostNameType> {
        private static final /* synthetic */ HostNameType[] $VALUES = null;
        public static final HostNameType DNS = null;
        public static final HostNameType IPv4 = null;
        public static final HostNameType IPv6 = null;
        final int subjectType;

        public static HostNameType valueOf(String r1) {
            return (HostNameType) Enum.valueOf(HostNameType.class, r1);
        }

        public static HostNameType[] values() {
            return (HostNameType[]) $VALUES.clone();
        }

        static {
            HostNameType r0 = new HostNameType("IPv4", 0, 7);
            IPv4 = r0;
            HostNameType r1 = new HostNameType("IPv6", 1, 7);
            IPv6 = r1;
            HostNameType r3 = new HostNameType("DNS", 2, 2);
            DNS = r3;
            $VALUES = new HostNameType[]{r0, r1, r3};
        }

        private HostNameType(String r1, int r2, int r3) {
            super(r1, r2);
            this.subjectType = r3;
        }
    }

    public DefaultHostnameVerifier(PublicSuffixMatcher r3) {
        this.log = new HttpClientAndroidLog(getClass());
        this.publicSuffixMatcher = r3;
    }

    public DefaultHostnameVerifier() {
        this(null);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String r2, SSLSession r3) {
        verify(r2, (X509Certificate) r3.getPeerCertificates()[0]);     // Catch: SSLException -> L6
        return true;
    L6:
        e = move-exception;
        if (this.log.isDebugEnabled() == false) goto L10;
        this.log.debug(e.getMessage(), e);
    L10:
        return false;
    }

    public void verify(String r4, X509Certificate r5) throws SSLException {
        HostNameType r0 = determineHostFormat(r4);
        List<SubjectName> r1 = getSubjectAltNames(r5);
        if (r1 != null) goto L5;
    L13:
        String r6 = new DistinguishedNameParser(r5.getSubjectX500Principal()).findMostSpecific("cn");
        if (r6 == null) goto L18;
        matchCN(r4, r6, this.publicSuffixMatcher);
        return;
    L18:
        throw new SSLException("Certificate subject for <" + r4 + "> doesn't contain a common name and does not have alternative names");
    L5:
        if (r1.isEmpty() == true) goto L13;
        int r7 = AnonymousClass1.$SwitchMap$cz$msebera$android$httpclient$conn$ssl$DefaultHostnameVerifier$HostNameType[r0.ordinal()];
        if (r7 != 1) goto L9;
        matchIPAddress(r4, r1);
        return;
    L9:
        if (r7 == 2) goto L11;
        matchDNSName(r4, r1, this.publicSuffixMatcher);
        return;
    L11:
        matchIPv6Address(r4, r1);
    }

    static void matchIPAddress(String r4, List<SubjectName> r5) throws SSLException {
        int r0 = 0;
    L4:
        if (r0 >= r5.size()) goto L12;
        SubjectName r1 = r5.get(r0);
        if (r1.getType() != 7) goto L10;
        if (r4.equals(r1.getValue()) == false) goto L10;
        return;
    L10:
        r0 = r0 + 1;
        goto L4
    L12:
        throw new SSLPeerUnverifiedException("Certificate for <" + r4 + "> doesn't match any of the subject alternative names: " + r5);
    }

    static void matchIPv6Address(String r5, List<SubjectName> r6) throws SSLException {
        String r0 = normaliseAddress(r5);
        int r1 = 0;
    L4:
        if (r1 >= r6.size()) goto L12;
        SubjectName r2 = r6.get(r1);
        if (r2.getType() != 7) goto L10;
        if (r0.equals(normaliseAddress(r2.getValue())) == false) goto L10;
        return;
    L10:
        r1 = r1 + 1;
        goto L4
    L12:
        throw new SSLPeerUnverifiedException("Certificate for <" + r5 + "> doesn't match any of the subject alternative names: " + r6);
    }

    static void matchDNSName(String r5, List<SubjectName> r6, PublicSuffixMatcher r7) throws SSLException {
        String r0 = r5.toLowerCase(Locale.ROOT);
        int r1 = 0;
    L4:
        if (r1 >= r6.size()) goto L12;
        SubjectName r2 = r6.get(r1);
        if (r2.getType() != 2) goto L10;
        if (matchIdentityStrict(r0, r2.getValue().toLowerCase(Locale.ROOT), r7) == false) goto L10;
        return;
    L10:
        r1 = r1 + 1;
        goto L4
    L12:
        throw new SSLPeerUnverifiedException("Certificate for <" + r5 + "> doesn't match any of the subject alternative names: " + r6);
    }

    static void matchCN(String r2, String r3, PublicSuffixMatcher r4) throws SSLException {
        if (matchIdentityStrict(r2.toLowerCase(Locale.ROOT), r3.toLowerCase(Locale.ROOT), r4) == false) goto L6;
        return;
    L6:
        throw new SSLPeerUnverifiedException("Certificate for <" + r2 + "> doesn't match common name of the certificate subject: " + r3);
    }

    static boolean matchDomainRoot(String r4, String r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r4.endsWith(r5) == true) goto L8;
        return false;
    L8:
        if (r4.length() == r5.length()) goto L12;
        if (r4.charAt((r4.length() - r5.length()) - 1) == '.') goto L12;
        return false;
    L12:
        return true;
    }

    private static boolean matchIdentity(String r4, String r5, PublicSuffixMatcher r6, boolean r7) {
        if (r6 != null) goto L5;
    L9:
        int r8 = r5.indexOf(42);
        if (r8 == (-1)) goto L27;
        String r2 = r5.substring(0, r8);
        String r9 = r5.substring(r8 + 1);
        if (r2.isEmpty() == true) goto L17;
        if (r4.startsWith(r2) == true) goto L17;
        return false;
    L17:
        if (r9.isEmpty() == false) goto L19;
    L21:
        if (r7 == true) goto L23;
    L25:
        return true;
    L23:
        if (r4.substring(r2.length(), r4.length() - r9.length()).contains(".") == false) goto L25;
        return false;
    L19:
        if (r4.endsWith(r9) == true) goto L21;
        return false;
    L27:
        return r4.equalsIgnoreCase(r5);
    L5:
        if (r4.contains(".") == false) goto L9;
        if (matchDomainRoot(r4, r6.getDomainRoot(r5, DomainType.ICANN)) == true) goto L9;
        return false;
    }

    static boolean matchIdentity(String r1, String r2, PublicSuffixMatcher r3) {
        return matchIdentity(r1, r2, r3, false);
    }

    static boolean matchIdentity(String r2, String r3) {
        return matchIdentity(r2, r3, null, false);
    }

    static boolean matchIdentityStrict(String r1, String r2, PublicSuffixMatcher r3) {
        return matchIdentity(r1, r2, r3, true);
    }

    static boolean matchIdentityStrict(String r2, String r3) {
        return matchIdentity(r2, r3, null, true);
    }

    static HostNameType determineHostFormat(String r2) {
        if (InetAddressUtils.isIPv4Address(r2) == false) goto L7;
        return HostNameType.IPv4;
    L7:
        if (r2.startsWith("[") == false) goto L12;
        if (r2.endsWith("]") == false) goto L12;
        r2 = r2.substring(1, r2.length() - 1);
    L12:
        if (InetAddressUtils.isIPv6Address(r2) == false) goto L16;
        return HostNameType.IPv6;
    L16:
        return HostNameType.DNS;
    }

    static List<SubjectName> getSubjectAltNames(X509Certificate r5) {
        Collection<List<?>> r6 = r5.getSubjectAlternativeNames();     // Catch: CertificateParsingException -> L24
        if (r6 == null) goto L5;
        ArrayList r0 = new ArrayList();     // Catch: CertificateParsingException -> L24
        Iterator<List<?>> r7 = r6.iterator();     // Catch: CertificateParsingException -> L24
    L8:
        if (r7.hasNext() == false) goto L23;
        List<?> r1 = r7.next();     // Catch: CertificateParsingException -> L24
        if (r1.size() < 2) goto L12;
        Integer r2 = (Integer) r1.get(0);     // Catch: CertificateParsingException -> L24
    L13:
        if (r2 == null) goto L8;
        if (r2.intValue() == 2) goto L18;
        if (r2.intValue() != 7) goto L8;
    L18:
        Object r3 = r1.get(1);     // Catch: CertificateParsingException -> L24
        if ((r3 instanceof String) == true) goto L20;
        boolean r4 = r3 instanceof byte[];     // Catch: CertificateParsingException -> L24
        goto L8
    L20:
        r0.add(new SubjectName((String) r3, r2.intValue()));     // Catch: CertificateParsingException -> L24
        goto L8
    L12:
        r2 = null;
        goto L13
    L23:
        return r0;
    L5:
        return Collections.emptyList();
    L25:
        return Collections.emptyList();
    }

    static String normaliseAddress(String r1) {
        if (r1 != null) goto L7;
        return r1;
    L7:
        return InetAddress.getByName(r1).getHostAddress();
    L9:
        return r1;
    }
}
