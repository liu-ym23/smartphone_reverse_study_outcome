package cz.msebera.android.httpclient.impl.client;

import com.ttnet.org.chromium.net.HttpNegotiateConstants;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.NTCredentials;
import cz.msebera.android.httpclient.auth.UsernamePasswordCredentials;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.util.Args;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import obric.time.HttpHeadTimeFetcher;

/* JADX INFO: loaded from: classes5.dex */
public class SystemDefaultCredentialsProvider implements CredentialsProvider {
    private static final Map<String, String> SCHEME_MAP = null;
    private final BasicCredentialsProvider internal;

    static {
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        SCHEME_MAP = r0;
        r0.put("Basic".toUpperCase(Locale.ROOT), "Basic");
        r0.put("Digest".toUpperCase(Locale.ROOT), "Digest");
        r0.put("NTLM".toUpperCase(Locale.ROOT), "NTLM");
        r0.put("Negotiate".toUpperCase(Locale.ROOT), HttpNegotiateConstants.SPNEGO_FEATURE);
        r0.put("Kerberos".toUpperCase(Locale.ROOT), "Kerberos");
    }

    private static String translateScheme(String r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        String r0 = SCHEME_MAP.get(r1);
        if (r0 != null) goto L8;
        return r1;
    L8:
        return r0;
    }

    public SystemDefaultCredentialsProvider() {
        this.internal = new BasicCredentialsProvider();
    }

    @Override // cz.msebera.android.httpclient.client.CredentialsProvider
    public void setCredentials(AuthScope r1, Credentials r2) {
        this.internal.setCredentials(r1, r2);
    }

    private static PasswordAuthentication getSystemCreds(String r8, AuthScope r9, Authenticator.RequestorType r10) {
        return Authenticator.requestPasswordAuthentication(r9.getHost(), null, r9.getPort(), r8, null, translateScheme(r9.getScheme()), null, r10);
    }

    @Override // cz.msebera.android.httpclient.client.CredentialsProvider
    public Credentials getCredentials(AuthScope r5) {
        Args.notNull(r5, "Auth scope");
        Credentials r4 = this.internal.getCredentials(r5);
        if (r4 == null) goto L6;
        return r4;
    L6:
        if (r5.getHost() == null) goto L32;
        HttpHost r6 = r5.getOrigin();
        if (r6 == null) goto L11;
        String r7 = r6.getSchemeName();
    L14:
        PasswordAuthentication r3 = getSystemCreds(r7, r5, Authenticator.RequestorType.SERVER);
        if (r3 != null) goto L17;
        r3 = getSystemCreds(r7, r5, Authenticator.RequestorType.PROXY);
    L17:
        if (r3 != null) goto L21;
        r3 = getProxyCredentials("http", r5);
        if (r3 != null) goto L21;
        r3 = getProxyCredentials(HttpHeadTimeFetcher.FETCHER_TYPE, r5);
    L21:
        if (r3 == null) goto L32;
        String r8 = System.getProperty("http.auth.ntlm.domain");
        if (r8 == null) goto L27;
        return new NTCredentials(r3.getUserName(), new String(r3.getPassword()), null, r8);
    L27:
        if ("NTLM".equalsIgnoreCase(r5.getScheme()) == false) goto L29;
        Credentials r9 = new NTCredentials(r3.getUserName(), new String(r3.getPassword()), null, null);
    L31:
        return r9;
    L29:
        r9 = new UsernamePasswordCredentials(r3.getUserName(), new String(r3.getPassword()));
        goto L31
    L11:
        if (r5.getPort() != 443) goto L13;
        r7 = HttpHeadTimeFetcher.FETCHER_TYPE;
        goto L14
    L13:
        r7 = "http";
    L32:
        return null;
    }

    private static PasswordAuthentication getProxyCredentials(String r4, AuthScope r5) {
        String r0 = System.getProperty(r4 + ".proxyHost");
        if (r0 != null) goto L5;
        return null;
    L5:
        String r2 = System.getProperty(r4 + ".proxyPort");
        if (r2 != null) goto L21;
        return null;
    L21:
        if (r5.match(new AuthScope(r0, Integer.parseInt(r2))) < 0) goto L19;
        String r6 = System.getProperty(r4 + ".proxyUser");     // Catch: NumberFormatException -> L20
        if (r6 != null) goto L13;
        return null;
    L13:
        String r7 = System.getProperty(r4 + ".proxyPassword");     // Catch: NumberFormatException -> L20
        if (r7 == null) goto L16;
        char[] r8 = r7.toCharArray();     // Catch: NumberFormatException -> L20
    L17:
        return new PasswordAuthentication(r6, r8);
    L16:
        r8 = new char[0];     // Catch: NumberFormatException -> L20
    L19:
        return null;
    }

    @Override // cz.msebera.android.httpclient.client.CredentialsProvider
    public void clear() {
        this.internal.clear();
    }
}
