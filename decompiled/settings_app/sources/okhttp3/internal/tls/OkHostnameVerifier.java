package okhttp3.internal.tls;

import com.android.settings.ApnEditor;
import com.android.settings.wifi.WifiAuthorizeUtils;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Utf8;

/* JADX INFO: compiled from: OkHostnameVerifier.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\f\u0010\u0017\u001a\u00020\b*\u00020\bH\u0002J\f\u0010\u0018\u001a\u00020\u000e*\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/tls/OkHostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "()V", "ALT_DNS_NAME", "", "ALT_IPA_NAME", "allSubjectAltNames", "", "", "certificate", "Ljava/security/cert/X509Certificate;", "getSubjectAltNames", "type", "verify", "", WifiAuthorizeUtils.AUTO_LOGIN_HOST, "session", "Ljavax/net/ssl/SSLSession;", "verifyHostname", "hostname", "pattern", "verifyIpAddress", "ipAddress", "asciiToLowercase", "isAscii", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = null;

    static {
        INSTANCE = new OkHostnameVerifier();
    }

    private OkHostnameVerifier() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String r3, SSLSession r4) {
        Intrinsics.checkNotNullParameter(r3, WifiAuthorizeUtils.AUTO_LOGIN_HOST);
        Intrinsics.checkNotNullParameter(r4, "session");
        if (isAscii(r3) == false) goto L13;
        Certificate r5 = r4.getPeerCertificates()[0];     // Catch: SSLException -> L11
        if (r5 == null) goto L9;
        return verify(r3, (X509Certificate) r5);
    L9:
        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");     // Catch: SSLException -> L11
    L14:
        return false;
    L13:
        return false;
    }

    public final boolean verify(String r2, X509Certificate r3) {
        Intrinsics.checkNotNullParameter(r2, WifiAuthorizeUtils.AUTO_LOGIN_HOST);
        Intrinsics.checkNotNullParameter(r3, "certificate");
        if (Util.canParseAsIpAddress(r2) == false) goto L6;
        return verifyIpAddress(r2, r3);
    L6:
        return verifyHostname(r2, r3);
    }

    private final boolean verifyIpAddress(String r2, X509Certificate r3) {
        String r4 = HostnamesKt.toCanonicalHost(r2);
        List<String> r1 = getSubjectAltNames(r3, 7);
        if ((r1 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r5 = r1.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(r4, HostnamesKt.toCanonicalHost((String) r5.next())) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r1.isEmpty() == false) goto L7;
        return false;
    }

    private final boolean verifyHostname(String r3, X509Certificate r4) {
        String r5 = asciiToLowercase(r3);
        List<String> r2 = getSubjectAltNames(r4, 2);
        if ((r2 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r6 = r2.iterator();
    L9:
        if (r6.hasNext() == false) goto L18;
        String r7 = (String) r6.next();
        if (INSTANCE.verifyHostname(r5, r7) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r2.isEmpty() == false) goto L7;
        return false;
    }

    private final String asciiToLowercase(String r2) {
        if (isAscii(r2) == false) goto L6;
        Locale r1 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r1, "US");
        String r3 = r2.toLowerCase(r1);
        Intrinsics.checkNotNullExpressionValue(r3, "this as java.lang.String).toLowerCase(locale)");
        return r3;
    L6:
        return r2;
    }

    private final boolean isAscii(String r4) {
        if (r4.length() != ((int) Utf8.size$default(r4, 0, 0, 3, null))) goto L6;
        return true;
    L6:
        return false;
    }

    private final boolean verifyHostname(String r13, String r14) {
        String r0 = r13;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
    L58:
        return false;
    L11:
        if (StringsKt.startsWith$default(r13, ".", false, 2, null) == true) goto L58;
        if (StringsKt.endsWith$default(r13, "..", false, 2, null) == true) goto L58;
        String r6 = r14;
        if (r6 != null) goto L18;
    L21:
        boolean r7 = true;
    L22:
        if (r7 == true) goto L58;
        if (StringsKt.startsWith$default(r14, ".", false, 2, null) == true) goto L58;
        if (StringsKt.endsWith$default(r14, "..", false, 2, null) == true) goto L58;
        if (StringsKt.endsWith$default(r13, ".", false, 2, null) == true) goto L32;
        r13 = Intrinsics.stringPlus(r13, ".");
    L32:
        if (StringsKt.endsWith$default(r14, ".", false, 2, null) == true) goto L34;
        r14 = Intrinsics.stringPlus(r14, ".");
    L34:
        String r12 = asciiToLowercase(r14);
        String r5 = r12;
        if (StringsKt.contains$default(r5, ApnEditor.APN_TYPE_ALL, false, 2, null) == true) goto L39;
        return Intrinsics.areEqual(r13, r12);
    L39:
        if (StringsKt.startsWith$default(r12, "*.", false, 2, null) == false) goto L58;
        if (StringsKt.indexOf$default(r5, '*', 1, false, 4, null) != (-1)) goto L58;
        if (r13.length() >= r12.length()) goto L47;
        return false;
    L47:
        if (Intrinsics.areEqual("*.", r12) == false) goto L49;
        return false;
    L49:
        String r15 = r12.substring(1);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).substring(startIndex)");
        if (StringsKt.endsWith$default(r13, r15, false, 2, null) == true) goto L52;
        return false;
    L52:
        int r16 = r13.length() - r15.length();
        if (r16 > 0) goto L55;
    L57:
        return true;
    L55:
        if (StringsKt.lastIndexOf$default(r13, '.', r16 - 1, false, 4, null) == (-1)) goto L57;
        return false;
    L18:
        if (r6.length() == 0) goto L21;
        r7 = false;
        goto L22
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final List<String> allSubjectAltNames(X509Certificate r3) {
        Intrinsics.checkNotNullParameter(r3, "certificate");
        List<String> r0 = getSubjectAltNames(r3, 7);
        return CollectionsKt.plus(r0, getSubjectAltNames(r3, 2));
    }

    private final List<String> getSubjectAltNames(X509Certificate r4, int r5) {
        Collection<List<?>> r3 = r4.getSubjectAlternativeNames();     // Catch: CertificateParsingException -> L23
        if (r3 == null) goto L5;
        ArrayList r6 = new ArrayList();     // Catch: CertificateParsingException -> L23
        Iterator<List<?>> r7 = r3.iterator();     // Catch: CertificateParsingException -> L23
    L8:
        if (r7.hasNext() == false) goto L22;
        List<?> r0 = r7.next();     // Catch: CertificateParsingException -> L23
        if (r0 == null) goto L8;
        if (r0.size() < 2) goto L8;
        if (Intrinsics.areEqual(r0.get(0), Integer.valueOf(r5)) == false) goto L8;
        Object r1 = r0.get(1);     // Catch: CertificateParsingException -> L23
        if (r1 == null) goto L8;
        r6.add((String) r1);     // Catch: CertificateParsingException -> L23
        goto L8
    L22:
        return r6;
    L5:
        return CollectionsKt.emptyList();
    L24:
        return CollectionsKt.emptyList();
    }
}
