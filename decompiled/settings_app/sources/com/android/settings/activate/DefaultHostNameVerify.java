package com.android.settings.activate;

import com.android.settings.ApnEditor;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import java.io.IOException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultHostNameVerify implements X509HostnameVerifier {
    private static final String[] BAD_COUNTRY_2LDS = null;

    public DefaultHostNameVerify() {
    }

    static {
        String[] r0 = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", ApmTrafficStats.KEY_TRAFFIC_STATUS_NET, "or", "org"};
        BAD_COUNTRY_2LDS = r0;
        Arrays.sort(r0);
    }

    @Override // org.apache.http.conn.ssl.X509HostnameVerifier, javax.net.ssl.HostnameVerifier
    public boolean verify(String r2, SSLSession r3) {
        return verifyHostName(r2, ((X509Certificate) r3.getPeerCertificates()[0]).getSubjectDN().getName().split(",")[0].substring(3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // org.apache.http.conn.ssl.X509HostnameVerifier
    public void verify(String r2, SSLSocket r3) throws IOException {
        if (r2 == null) goto L6;
        verify(r2, (X509Certificate) r3.getSession().getPeerCertificates()[0]);
        return;
    L6:
        throw new NullPointerException("host to verify is null");
    }

    @Override // org.apache.http.conn.ssl.X509HostnameVerifier
    public void verify(String r2, X509Certificate r3) throws SSLException {
        verify(r2, getCNs(r3), getDNSSubjectAlts(r3));
    }

    @Override // org.apache.http.conn.ssl.X509HostnameVerifier
    public void verify(String r2, String[] r3, String[] r4) throws SSLException {
        verify(r2, r3, r4, false);
    }

    public static boolean verifyHostName(String r5, String r6) {
        if (r5 != null) goto L5;
    L29:
        return false;
    L5:
        if (r5.isEmpty() == true) goto L29;
        if (r6 == null) goto L29;
        if (r6.isEmpty() == true) goto L29;
        String r7 = r6.toLowerCase(Locale.US);
        if (r7.contains(ApnEditor.APN_TYPE_ALL) == true) goto L15;
        return r5.equals(r7);
    L15:
        if (r7.startsWith("*.") == true) goto L17;
    L19:
        int r1 = r7.indexOf(42);
        if (r1 <= r7.indexOf(46)) goto L23;
        return false;
    L23:
        if (r5.regionMatches(0, r7, 0, r1) == true) goto L25;
        return false;
    L25:
        int r2 = r1 + 1;
        int r3 = r7.length() - r2;
        if (r5.regionMatches(r5.length() - r3, r7, r2, r3) == true) goto L28;
        return false;
    L28:
        return true;
    L17:
        if (r5.regionMatches(0, r7, 2, r7.length() - 2) == false) goto L19;
        return true;
    }

    public final void verify(String r5, String[] r6, String[] r7, boolean r8) throws SSLException {
        LinkedList r4 = new LinkedList();
        if (r6 != null) goto L5;
    L9:
        if (r7 == null) goto L17;
        int r9 = r7.length;
        int r1 = 0;
    L11:
        if (r1 >= r9) goto L17;
        String r2 = r7[r1];
        if (r2 == null) goto L15;
        r4.add(r2);
    L15:
        r1 = r1 + 1;
    L17:
        if (r4.isEmpty() == true) goto L51;
        StringBuilder r10 = new StringBuilder();
        String r11 = r5.trim().toLowerCase(Locale.ENGLISH);
        Iterator r12 = r4.iterator();
        boolean r3 = false;
    L20:
        if (r12.hasNext() == false) goto L46;
        String r13 = ((String) r12.next()).toLowerCase(Locale.ENGLISH);
        r10.append(" <");
        r10.append(r13);
        r10.append('>');
        if (r12.hasNext() == false) goto L24;
        r10.append(" OR");
    L24:
        boolean r14 = true;
        if (r13.startsWith("*.") == true) goto L27;
    L33:
        boolean r15 = false;
    L34:
        if (r15 == false) goto L44;
        boolean r16 = r11.endsWith(r13.substring(1));
        if (r16 == false) goto L43;
        if (r8 == false) goto L43;
        if (countDots(r11) == countDots(r13)) goto L42;
        r14 = false;
    L42:
        r3 = r14;
    L45:
        if (r3 == false) goto L20;
    L43:
        r3 = r16;
        goto L45
    L44:
        r3 = r11.equals(r13);
        goto L45
    L27:
        if (r13.lastIndexOf(46) < 0) goto L33;
        if (acceptableCountryWildcard(r13) == false) goto L33;
        if (isValidIPV4Address(r5) == true) goto L33;
        r15 = true;
    L46:
        if (r3 == false) goto L49;
        return;
    L49:
        throw new SSLException("hostname in certificate didn't match: <" + r5 + "> !=" + r10);
    L51:
        throw new SSLException("Certificate for <" + r5 + "> doesn't contain CN or DNS subjectAlt");
    L5:
        if (r6.length <= 0) goto L9;
        String r17 = r6[0];
        if (r17 == null) goto L9;
        r4.add(r17);
        goto L9
    }

    private static boolean isValidIPV4Address(String r7) {
        if (r7.matches("\\p{Digit}+(\\.\\p{Digit}+)*") == true) goto L5;
        return false;
    L5:
        String[] r8 = r7.split("\\.");
        int r0 = r8.length;
        if (r0 >= 1) goto L8;
    L31:
        return false;
    L8:
        if (r0 > 4) goto L31;
        if (r0 == 1) goto L12;
        int r3 = 0;
    L16:
        if (r3 >= r0) goto L30;
        if (r0 != 2) goto L22;
        if (r3 != 1) goto L22;
        int r4 = 16777215;
    L27:
        if (Integer.parseInt(r8[r3]) > r4) goto L28;
        r3 = r3 + 1;
        goto L16
    L28:
        return false;
    L22:
        if (r0 != 3) goto L25;
        if (r3 != 2) goto L25;
        r4 = 65535;
    L25:
        r4 = 255;
        goto L27
    L30:
        return true;
    L12:
        if (Long.parseLong(r8[0]) <= 4294967295L) goto L14;
        return false;
    L14:
        return true;
    }

    public static boolean acceptableCountryWildcard(String r4) {
        int r0 = r4.length();
        if (r0 >= 7) goto L5;
        return true;
    L5:
        if (r0 > 9) goto L14;
        int r1 = r0 - 3;
        if (r4.charAt(r1) == '.') goto L9;
        return true;
    L9:
        if (Arrays.binarySearch(BAD_COUNTRY_2LDS, r4.substring(2, r1)) < 0) goto L16;
        return false;
    L16:
        return true;
    L14:
        return true;
    }

    public static String[] getCNs(X509Certificate r3) {
        LinkedList r0 = new LinkedList();
        StringTokenizer r1 = new StringTokenizer(r3.getSubjectX500Principal().toString(), ",");
    L4:
        if (r1.hasMoreTokens() == false) goto L9;
        String r4 = r1.nextToken();
        int r2 = r4.indexOf("CN=");
        if (r2 < 0) goto L4;
        r0.add(r4.substring(r2 + 3));
        goto L4
    L9:
        if (r0.isEmpty() == true) goto L12;
        String[] r5 = new String[r0.size()];
        r0.toArray(r5);
        return r5;
    L12:
        return null;
    }

    public static String[] getDNSSubjectAlts(X509Certificate r5) {
        LinkedList r0 = new LinkedList();
        Collection<List<?>> r6 = r5.getSubjectAlternativeNames();     // Catch: CertificateParsingException -> L5
    L7:
        if (r6 == null) goto L15;
        Iterator<List<?>> r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L15;
        List<?> r2 = r7.next();
        if (((Integer) r2.get(0)).intValue() != 2) goto L10;
        r0.add((String) r2.get(1));
    L15:
        if (r0.isEmpty() == true) goto L18;
        String[] r8 = new String[r0.size()];
        r0.toArray(r8);
        return r8;
    L18:
        return null;
    L5:
        e = move-exception;
        Logger.getLogger(DefaultHostNameVerify.class.getName()).log(Level.FINE, "Error parsing certificate.", e);
        r6 = null;
        goto L7
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
