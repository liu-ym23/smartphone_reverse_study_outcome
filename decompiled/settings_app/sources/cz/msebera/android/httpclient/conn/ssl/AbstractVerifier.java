package cz.msebera.android.httpclient.conn.ssl;

import com.android.settings.ApnEditor;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import cz.msebera.android.httpclient.conn.util.InetAddressUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class AbstractVerifier implements X509HostnameVerifier {
    static final String[] BAD_COUNTRY_2LDS = null;
    public HttpClientAndroidLog log;

    public AbstractVerifier() {
        this.log = new HttpClientAndroidLog(getClass());
    }

    static {
        String[] r0 = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", ApmTrafficStats.KEY_TRAFFIC_STATUS_NET, "or", "org"};
        BAD_COUNTRY_2LDS = r0;
        Arrays.sort(r0);
    }

    @Override // cz.msebera.android.httpclient.conn.ssl.X509HostnameVerifier
    public final void verify(String r2, SSLSocket r3) throws IOException {
        Args.notNull(r2, "Host");
        SSLSession r0 = r3.getSession();
        if (r0 != null) goto L7;
        r3.getInputStream().available();
        r0 = r3.getSession();
        if (r0 != null) goto L7;
        r3.startHandshake();
        r0 = r3.getSession();
    L7:
        verify(r2, (X509Certificate) r0.getPeerCertificates()[0]);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String r2, SSLSession r3) {
        verify(r2, (X509Certificate) r3.getPeerCertificates()[0]);     // Catch: SSLException -> L6
        return true;
    L6:
        e = move-exception;
        if (this.log.isDebugEnabled() == false) goto L10;
        this.log.debug(e.getMessage(), e);
    L10:
        return false;
    }

    @Override // cz.msebera.android.httpclient.conn.ssl.X509HostnameVerifier
    public final void verify(String r6, X509Certificate r7) throws SSLException {
        List<SubjectName> r0 = DefaultHostnameVerifier.getSubjectAltNames(r7);
        ArrayList r1 = new ArrayList();
        if (InetAddressUtils.isIPv4Address(r6) == false) goto L5;
    L13:
        Iterator<SubjectName> r2 = r0.iterator();
    L15:
        if (r2.hasNext() == false) goto L19;
        SubjectName r3 = r2.next();
        if (r3.getType() != 7) goto L15;
        r1.add(r3.getValue());
    L19:
        String r8 = new DistinguishedNameParser(r7.getSubjectX500Principal()).findMostSpecific("cn");
        String[] r4 = null;
        if (r8 == null) goto L22;
        String[] r5 = {r8};
    L24:
        if (r1.isEmpty() == true) goto L26;
        r4 = (String[]) r1.toArray(new String[r1.size()]);
    L26:
        verify(r6, r5, r4);
        return;
    L22:
        r5 = null;
        goto L24
    L5:
        if (InetAddressUtils.isIPv6Address(r6) == true) goto L13;
        Iterator<SubjectName> r9 = r0.iterator();
    L9:
        if (r9.hasNext() == false) goto L19;
        SubjectName r10 = r9.next();
        if (r10.getType() != 2) goto L9;
        r1.add(r10.getValue());
        goto L9
    }

    public final void verify(String r4, String[] r5, String[] r6, boolean r7) throws SSLException {
        List r3 = null;
        if (r5 != null) goto L5;
    L7:
        String r8 = null;
    L8:
        if (r6 == null) goto L13;
        if (r6.length <= 0) goto L13;
        r3 = Arrays.asList(r6);
    L13:
        if (InetAddressUtils.isIPv6Address(r4) == false) goto L15;
        String r9 = DefaultHostnameVerifier.normaliseAddress(r4.toLowerCase(Locale.ROOT));
    L17:
        if (r3 == null) goto L29;
        Iterator r10 = r3.iterator();
    L20:
        if (r10.hasNext() == false) goto L28;
        String r1 = (String) r10.next();
        if (InetAddressUtils.isIPv6Address(r1) == false) goto L25;
        r1 = DefaultHostnameVerifier.normaliseAddress(r1);
    L25:
        if (matchIdentity(r9, r1, r7) == false) goto L20;
        return;
    L28:
        throw new SSLException("Certificate for <" + r4 + "> doesn't match any of the subject alternative names: " + r3);
    L29:
        if (r8 == null) goto L40;
        if (InetAddressUtils.isIPv6Address(r8) == false) goto L33;
        String r11 = DefaultHostnameVerifier.normaliseAddress(r8);
    L35:
        if (matchIdentity(r9, r11, r7) == false) goto L38;
        return;
    L38:
        throw new SSLException("Certificate for <" + r4 + "> doesn't match common name of the certificate subject: " + r8);
    L33:
        r11 = r8;
        goto L35
    L40:
        throw new SSLException("Certificate subject for <" + r4 + "> doesn't contain a common name and does not have alternative names");
    L15:
        r9 = r4;
        goto L17
    L5:
        if (r5.length <= 0) goto L7;
        r8 = r5[0];
        goto L8
    }

    private static boolean matchIdentity(String r5, String r6, boolean r7) {
        if (r5 != null) goto L5;
        return false;
    L5:
        String r8 = r5.toLowerCase(Locale.ROOT);
        String r9 = r6.toLowerCase(Locale.ROOT);
        String[] r1 = r9.split("\\.");
        if (r1.length >= 3) goto L8;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L31;
        String r3 = r1[0];
        if (r3.length() <= 1) goto L23;
        String r4 = r3.substring(0, r3.length() - 1);
        String r10 = r9.substring(r3.length());
        String r11 = r8.substring(r4.length());
        if (r8.startsWith(r4) == true) goto L20;
    L22:
        boolean r12 = false;
    L24:
        if (r12 == false) goto L32;
        if (r7 == false) goto L29;
        if (countDots(r8) == countDots(r9)) goto L29;
        return false;
    L29:
        return true;
    L32:
        return false;
    L20:
        if (r11.endsWith(r10) == false) goto L22;
        r12 = true;
        goto L24
    L23:
        r12 = r8.endsWith(r9.substring(1));
        goto L24
    L31:
        return r8.equals(r9);
    L8:
        if (r1[0].endsWith(ApnEditor.APN_TYPE_ALL) == false) goto L13;
        if (r7 == true) goto L11;
    L12:
        r2 = true;
        goto L14
    L11:
        if (validCountryWildcard(r1) == false) goto L13;
        goto L12
    }

    private static boolean validCountryWildcard(String[] r3) {
        if (r3.length == 3) goto L5;
        return true;
    L5:
        if (r3[2].length() == 2) goto L8;
        return true;
    L8:
        if (Arrays.binarySearch(BAD_COUNTRY_2LDS, r3[1]) < 0) goto L14;
        return false;
    L14:
        return true;
    }

    public static boolean acceptableCountryWildcard(String r1) {
        return validCountryWildcard(r1.split("\\."));
    }

    public static String[] getCNs(X509Certificate r2) {
        String r3 = new DistinguishedNameParser(r2.getSubjectX500Principal()).findMostSpecific("cn");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new String[]{r3};
    }

    public static String[] getDNSSubjectAlts(X509Certificate r5) {
        List<SubjectName> r6 = DefaultHostnameVerifier.getSubjectAltNames(r5);
        if (r6 != null) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList();
        Iterator<SubjectName> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L12;
        SubjectName r2 = r7.next();
        if (r2.getType() != 2) goto L7;
        r1.add(r2.getValue());
        goto L7
    L12:
        if (r1.isEmpty() == true) goto L14;
        return null;
    L14:
        return (String[]) r1.toArray(new String[r1.size()]);
    }

    public static int countDots(String r4) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= r4.length()) goto L9;
        if (r4.charAt(r0) != '.') goto L8;
        r1 = r1 + 1;
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        return r1;
    }
}
