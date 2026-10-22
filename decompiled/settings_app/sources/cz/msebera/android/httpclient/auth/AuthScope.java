package cz.msebera.android.httpclient.auth;

import com.android.settingslib.accessibility.AccessibilityUtils;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.message.TokenParser;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class AuthScope {
    public static final AuthScope ANY = null;
    public static final String ANY_HOST = null;
    public static final int ANY_PORT = -1;
    public static final String ANY_REALM = null;
    public static final String ANY_SCHEME = null;
    private final String host;
    private final HttpHost origin;
    private final int port;
    private final String realm;
    private final String scheme;

    static {
        ANY = new AuthScope(null, -1, null, null);
    }

    public AuthScope(String r2, int r3, String r4, String r5) {
        if (r2 != null) goto L5;
        String r6 = ANY_HOST;
    L6:
        this.host = r6;
        if (r3 >= 0) goto L9;
        r3 = -1;
    L9:
        this.port = r3;
        if (r4 != null) goto L12;
        r4 = ANY_REALM;
    L12:
        this.realm = r4;
        if (r5 != null) goto L15;
        String r7 = ANY_SCHEME;
    L16:
        this.scheme = r7;
        this.origin = null;
        return;
    L15:
        r7 = r5.toUpperCase(Locale.ROOT);
        goto L16
    L5:
        r6 = r2.toLowerCase(Locale.ROOT);
        goto L6
    }

    public AuthScope(HttpHost r3, String r4, String r5) {
        Args.notNull(r3, "Host");
        this.host = r3.getHostName().toLowerCase(Locale.ROOT);
        if (r3.getPort() >= 0) goto L5;
        int r0 = -1;
    L6:
        this.port = r0;
        if (r4 != null) goto L9;
        r4 = ANY_REALM;
    L9:
        this.realm = r4;
        if (r5 != null) goto L12;
        String r6 = ANY_SCHEME;
    L13:
        this.scheme = r6;
        this.origin = r3;
        return;
    L12:
        r6 = r5.toUpperCase(Locale.ROOT);
        goto L13
    L5:
        r0 = r3.getPort();
        goto L6
    }

    public AuthScope(HttpHost r3) {
        this(r3, ANY_REALM, ANY_SCHEME);
    }

    public AuthScope(String r2, int r3, String r4) {
        this(r2, r3, r4, ANY_SCHEME);
    }

    public AuthScope(String r3, int r4) {
        this(r3, r4, ANY_REALM, ANY_SCHEME);
    }

    public AuthScope(AuthScope r2) {
        Args.notNull(r2, "Scope");
        this.host = r2.getHost();
        this.port = r2.getPort();
        this.realm = r2.getRealm();
        this.scheme = r2.getScheme();
        this.origin = r2.getOrigin();
    }

    public HttpHost getOrigin() {
        return this.origin;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getRealm() {
        return this.realm;
    }

    public String getScheme() {
        return this.scheme;
    }

    public int match(AuthScope r5) {
        if (LangUtils.equals(this.scheme, r5.scheme) == false) goto L5;
        int r0 = 1;
    L12:
        if (LangUtils.equals(this.realm, r5.realm) == false) goto L14;
        r0 = r0 + 2;
    L19:
        int r2 = this.port;
        int r3 = r5.port;
        if (r2 != r3) goto L22;
        r0 = r0 + 4;
    L26:
        if (LangUtils.equals(this.host, r5.host) == true) goto L33;
        String r4 = this.host;
        String r6 = ANY_HOST;
        if (r4 != r6) goto L31;
        return r0;
    L31:
        if (r5.host == r6) goto L35;
        return -1;
    L35:
        return r0;
    L33:
        return r0 + 8;
    L22:
        if (r2 == (-1)) goto L26;
        if (r3 == (-1)) goto L26;
        return -1;
    L14:
        String r7 = this.realm;
        String r8 = ANY_REALM;
        if (r7 == r8) goto L19;
        if (r5.realm == r8) goto L19;
        return -1;
    L5:
        String r1 = this.scheme;
        String r9 = ANY_SCHEME;
        if (r1 != r9) goto L8;
    L10:
        r0 = 0;
        goto L12
    L8:
        if (r5.scheme == r9) goto L10;
        return -1;
    }

    public boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5 != this) goto L9;
        return true;
    L9:
        if ((r5 instanceof AuthScope) == false) goto L11;
        AuthScope r6 = (AuthScope) r5;
        if (LangUtils.equals(this.host, r6.host) == true) goto L15;
        return false;
    L15:
        if (this.port == r6.port) goto L17;
        return false;
    L17:
        if (LangUtils.equals(this.realm, r6.realm) == true) goto L19;
        return false;
    L19:
        if (LangUtils.equals(this.scheme, r6.scheme) == true) goto L21;
        return false;
    L21:
        return true;
    L11:
        return super.equals(r5);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.scheme;
        if (r1 == null) goto L6;
        r0.append(r1.toUpperCase(Locale.ROOT));
        r0.append(TokenParser.SP);
    L6:
        if (this.realm == null) goto L8;
        r0.append('\'');
        r0.append(this.realm);
        r0.append('\'');
    L10:
        if (this.host == null) goto L15;
        r0.append('@');
        r0.append(this.host);
        if (this.port < 0) goto L15;
        r0.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        r0.append(this.port);
    L15:
        return r0.toString();
    L8:
        r0.append("<any realm>");
        goto L10
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.host), this.port), this.realm), this.scheme);
    }
}
