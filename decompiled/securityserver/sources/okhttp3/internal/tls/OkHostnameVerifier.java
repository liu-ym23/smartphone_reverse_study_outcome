package okhttp3.internal.tls;

import com.bytedance.librarian.LibrarianImpl;
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
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = null;

    static {
        INSTANCE = new OkHostnameVerifier();
    }

    private OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String r2) {
        if (isAscii(r2) == false) goto L9;
        Locale r1 = Locale.US;
        Intrinsics.e(r1, "Locale.US");
        if (r2 == null) goto L8;
        String r3 = r2.toLowerCase(r1);
        Intrinsics.e(r3, "(this as java.lang.String).toLowerCase(locale)");
        return r3;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L9:
        return r2;
    }

    private final List<String> getSubjectAltNames(X509Certificate r5, int r6) {
        EmptyList r4 = EmptyList.b;
        Collection<List<?>> r7 = r5.getSubjectAlternativeNames();     // Catch: CertificateParsingException -> L22
        if (r7 == null) goto L21;
        ArrayList r0 = new ArrayList();     // Catch: CertificateParsingException -> L22
        Iterator<List<?>> r8 = r7.iterator();     // Catch: CertificateParsingException -> L22
    L7:
        if (r8.hasNext() == false) goto L20;
        List<?> r1 = r8.next();     // Catch: CertificateParsingException -> L22
        if (r1 == null) goto L7;
        if (r1.size() < 2) goto L7;
        if ((!Intrinsics.a(r1.get(0), Integer.valueOf(r6))) == true) goto L7;
        Object r2 = r1.get(1);     // Catch: CertificateParsingException -> L22
        if (r2 == null) goto L7;
        r0.add((String) r2);     // Catch: CertificateParsingException -> L22
    L20:
        return r0;
    L21:
        return r4;
    }

    private final boolean isAscii(String r4) {
        if (r4.length() != ((int) Utf8.size$default(r4, 0, 0, 3, null))) goto L6;
        return true;
    L6:
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

    private final boolean verifyIpAddress(String r2, X509Certificate r3) {
        String r4 = HostnamesKt.toCanonicalHost(r2);
        List<String> r1 = getSubjectAltNames(r3, 7);
        if ((r1 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r5 = r1.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        if (Intrinsics.a(r4, HostnamesKt.toCanonicalHost((String) r5.next())) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r1.isEmpty() == false) goto L7;
        return false;
    }

    @NotNull
    public final List<String> allSubjectAltNames(@NotNull X509Certificate r3) {
        Intrinsics.f(r3, "certificate");
        return CollectionsKt.n(getSubjectAltNames(r3, 7), getSubjectAltNames(r3, 2));
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(@NotNull String r3, @NotNull SSLSession r4) {
        Intrinsics.f(r3, "host");
        Intrinsics.f(r4, "session");
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

    public final boolean verify(@NotNull String r2, @NotNull X509Certificate r3) {
        Intrinsics.f(r2, "host");
        Intrinsics.f(r3, "certificate");
        if (Util.canParseAsIpAddress(r2) == false) goto L6;
        return verifyIpAddress(r2, r3);
    L6:
        return verifyHostname(r2, r3);
    }

    private final boolean verifyHostname(String r7, String r8) {
        if (r7 != null) goto L5;
    L51:
        return false;
    L5:
        if (r7.length() == 0) goto L51;
        if (StringsKt.F(r7, LibrarianImpl.Constants.DOT, false) == true) goto L51;
        if (StringsKt.o(r7, "..") == true) goto L51;
        if (r8 == null) goto L51;
        if (r8.length() == 0) goto L51;
        if (StringsKt.F(r8, LibrarianImpl.Constants.DOT, false) == true) goto L51;
        if (StringsKt.o(r8, "..") == true) goto L51;
        if (StringsKt.o(r7, LibrarianImpl.Constants.DOT) == true) goto L25;
        r7 = r7.concat(LibrarianImpl.Constants.DOT);
    L25:
        if (StringsKt.o(r8, LibrarianImpl.Constants.DOT) == true) goto L27;
        r8 = r8.concat(LibrarianImpl.Constants.DOT);
    L27:
        String r6 = asciiToLowercase(r8);
        if (StringsKt.m("*", false, r6) == true) goto L32;
        return Intrinsics.a(r7, r6);
    L32:
        if (StringsKt.F(r6, "*.", false) == false) goto L51;
        if (StringsKt.r(r6, '*', 1, false, 4) != (-1)) goto L51;
        if (r7.length() >= r6.length()) goto L40;
        return false;
    L40:
        if ("*.".equals(r6) == false) goto L42;
        return false;
    L42:
        String r9 = r6.substring(1);
        Intrinsics.e(r9, "(this as java.lang.String).substring(startIndex)");
        if (StringsKt.o(r7, r9) == true) goto L45;
        return false;
    L45:
        int r10 = r7.length() - r9.length();
        if (r10 > 0) goto L48;
    L50:
        return true;
    L48:
        if (StringsKt.v(r7, '.', r10 - 1, 4) == (-1)) goto L50;
        return false;
    }
}
