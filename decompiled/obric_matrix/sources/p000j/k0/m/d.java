package p000j.k0.m;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f18116a = null;

    static {
        f18116a = new d();
    }

    private d() {
    }

    public static List<String> a(X509Certificate r4) {
        List<String> r0 = b(r4, 7);
        List<String> r5 = b(r4, 2);
        ArrayList r1 = new ArrayList(r0.size() + r5.size());
        r1.addAll(r0);
        r1.addAll(r5);
        return r1;
    }

    private static List<String> b(X509Certificate r4, int r5) {
        ArrayList r0 = new ArrayList();
        Collection<List<?>> r6 = r4.getSubjectAlternativeNames();     // Catch: CertificateParsingException -> L25
        if (r6 == null) goto L6;
        Iterator<List<?>> r7 = r6.iterator();     // Catch: CertificateParsingException -> L25
    L9:
        if (r7.hasNext() == false) goto L24;
        List<?> r1 = r7.next();     // Catch: CertificateParsingException -> L25
        if (r1 == null) goto L9;
        if (r1.size() < 2) goto L9;
        Integer r2 = (Integer) r1.get(0);     // Catch: CertificateParsingException -> L25
        if (r2 == null) goto L9;
        if (r2.intValue() != r5) goto L9;
        String r3 = (String) r1.get(1);     // Catch: CertificateParsingException -> L25
        if (r3 == null) goto L9;
        r0.add(r3);     // Catch: CertificateParsingException -> L25
        goto L9
    L24:
        return r0;
    L6:
        return Collections.emptyList();
    L26:
        return Collections.emptyList();
    }

    private boolean e(String r2, X509Certificate r3) {
        String r4 = r2.toLowerCase(Locale.US);
        Iterator<String> r5 = b(r3, 2).iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        if (d(r4, r5.next()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private boolean f(String r4, X509Certificate r5) {
        List<String> r3 = b(r5, 7);
        int r6 = r3.size();
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L9;
        if (r4.equalsIgnoreCase(r3.get(r1)) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean c(String r2, X509Certificate r3) {
        if (c.J(r2) == false) goto L6;
        return f(r2, r3);
    L6:
        return e(r2, r3);
    }

    public boolean d(String r7, String r8) {
        if (r7 != null) goto L5;
    L49:
        return false;
    L5:
        if (r7.length() == 0) goto L49;
        if (r7.startsWith(".") == true) goto L49;
        if (r7.endsWith("..") == true) goto L49;
        if (r8 == null) goto L49;
        if (r8.length() == 0) goto L49;
        if (r8.startsWith(".") == true) goto L49;
        if (r8.endsWith("..") == true) goto L49;
        if (r7.endsWith(".") == true) goto L23;
        r7 = r7 + '.';
    L23:
        if (r8.endsWith(".") == true) goto L25;
        r8 = r8 + '.';
    L25:
        String r9 = r8.toLowerCase(Locale.US);
        if (r9.contains("*") == true) goto L30;
        return r7.equals(r9);
    L30:
        if (r9.startsWith("*.") == false) goto L49;
        if (r9.indexOf(42, 1) != (-1)) goto L49;
        if (r7.length() >= r9.length()) goto L38;
        return false;
    L38:
        if ("*.".equals(r9) == false) goto L40;
        return false;
    L40:
        String r10 = r9.substring(1);
        if (r7.endsWith(r10) == true) goto L43;
        return false;
    L43:
        int r0 = r7.length() - r10.length();
        if (r0 > 0) goto L46;
    L48:
        return true;
    L46:
        if (r7.lastIndexOf(46, r0 - 1) == (-1)) goto L48;
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String r2, SSLSession r3) {
        return c(r2, (X509Certificate) r3.getPeerCertificates()[0]);
    L5:
        return false;
    }
}
