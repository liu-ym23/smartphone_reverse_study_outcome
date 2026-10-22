package cz.msebera.android.httpclient;

import com.android.settingslib.accessibility.AccessibilityUtils;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpHost implements Cloneable, Serializable {
    public static final String DEFAULT_SCHEME_NAME = "http";
    private static final long serialVersionUID = -7529410654042457626L;
    protected final InetAddress address;
    protected final String hostname;
    protected final String lcHostname;
    protected final int port;
    protected final String schemeName;

    public HttpHost(String r2, int r3, String r4) {
        this.hostname = (String) Args.containsNoBlanks(r2, "Host name");
        this.lcHostname = r2.toLowerCase(Locale.ROOT);
        if (r4 == null) goto L5;
        this.schemeName = r4.toLowerCase(Locale.ROOT);
    L6:
        this.port = r3;
        this.address = null;
        return;
    L5:
        this.schemeName = "http";
        goto L6
    }

    public HttpHost(String r2, int r3) {
        this(r2, r3, null);
    }

    public static HttpHost create(String r4) {
        Args.containsNoBlanks(r4, "HTTP Host");
        int r0 = r4.indexOf("://");
        if (r0 <= 0) goto L5;
        String r2 = r4.substring(0, r0);
        r4 = r4.substring(r0 + 3);
    L6:
        int r1 = r4.lastIndexOf(":");
        if (r1 > 0) goto L16;
        int r3 = -1;
    L15:
        return new HttpHost(r4, r3, r2);
    L16:
        r3 = Integer.parseInt(r4.substring(r1 + 1));     // Catch: NumberFormatException -> L11
        r4 = r4.substring(0, r1);
    L12:
        throw new IllegalArgumentException("Invalid HTTP host: " + r4);
    L5:
        r2 = null;
        goto L6
    }

    public HttpHost(String r3) {
        this(r3, -1, null);
    }

    public HttpHost(InetAddress r2, int r3, String r4) {
        this((InetAddress) Args.notNull(r2, "Inet address"), r2.getHostName(), r3, r4);
    }

    public HttpHost(InetAddress r2, String r3, int r4, String r5) {
        this.address = (InetAddress) Args.notNull(r2, "Inet address");
        String r6 = (String) Args.notNull(r3, "Hostname");
        this.hostname = r6;
        this.lcHostname = r6.toLowerCase(Locale.ROOT);
        if (r5 == null) goto L5;
        this.schemeName = r5.toLowerCase(Locale.ROOT);
    L6:
        this.port = r4;
        return;
    L5:
        this.schemeName = "http";
        goto L6
    }

    public HttpHost(InetAddress r2, int r3) {
        this(r2, r3, null);
    }

    public HttpHost(InetAddress r3) {
        this(r3, -1, null);
    }

    public HttpHost(HttpHost r2) {
        Args.notNull(r2, "HTTP host");
        this.hostname = r2.hostname;
        this.lcHostname = r2.lcHostname;
        this.schemeName = r2.schemeName;
        this.port = r2.port;
        this.address = r2.address;
    }

    public String getHostName() {
        return this.hostname;
    }

    public int getPort() {
        return this.port;
    }

    public String getSchemeName() {
        return this.schemeName;
    }

    public InetAddress getAddress() {
        return this.address;
    }

    public String toURI() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.schemeName);
        r0.append("://");
        r0.append(this.hostname);
        if (this.port == (-1)) goto L6;
        r0.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        r0.append(Integer.toString(this.port));
    L6:
        return r0.toString();
    }

    public String toHostString() {
        if (this.port == (-1)) goto L7;
        StringBuilder r0 = new StringBuilder(this.hostname.length() + 6);
        r0.append(this.hostname);
        r0.append(":");
        r0.append(Integer.toString(this.port));
        return r0.toString();
    L7:
        return this.hostname;
    }

    public String toString() {
        return toURI();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof HttpHost) == false) goto L23;
        HttpHost r6 = (HttpHost) r5;
        if (this.lcHostname.equals(r6.lcHostname) == false) goto L22;
        if (this.port != r6.port) goto L22;
        if (this.schemeName.equals(r6.schemeName) == false) goto L22;
        InetAddress r4 = this.address;
        if (r4 != null) goto L19;
        if (r6.address != null) goto L22;
        return true;
    L19:
        if (r4.equals(r6.address) == false) goto L22;
        return true;
    L22:
        return false;
    L23:
        return false;
    }

    public int hashCode() {
        int r0 = LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.lcHostname), this.port), this.schemeName);
        InetAddress r2 = this.address;
        if (r2 != null) goto L5;
        return r0;
    L5:
        return LangUtils.hashCode(r0, r2);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
