package cz.msebera.android.httpclient.client.config;

import cz.msebera.android.httpclient.HttpHost;
import java.net.InetAddress;
import java.util.Collection;

/* JADX INFO: loaded from: classes5.dex */
public class RequestConfig implements Cloneable {
    public static final RequestConfig DEFAULT = null;
    private final boolean authenticationEnabled;
    private final boolean circularRedirectsAllowed;
    private final int connectTimeout;
    private final int connectionRequestTimeout;
    private final boolean contentCompressionEnabled;
    private final String cookieSpec;
    private final boolean expectContinueEnabled;
    private final InetAddress localAddress;
    private final int maxRedirects;
    private final boolean normalizeUri;
    private final HttpHost proxy;
    private final Collection<String> proxyPreferredAuthSchemes;
    private final boolean redirectsEnabled;
    private final boolean relativeRedirectsAllowed;
    private final int socketTimeout;
    private final boolean staleConnectionCheckEnabled;
    private final Collection<String> targetPreferredAuthSchemes;

    public static class Builder {
        private boolean authenticationEnabled;
        private boolean circularRedirectsAllowed;
        private int connectTimeout;
        private int connectionRequestTimeout;
        private boolean contentCompressionEnabled;
        private String cookieSpec;
        private boolean expectContinueEnabled;
        private InetAddress localAddress;
        private int maxRedirects;
        private boolean normalizeUri;
        private HttpHost proxy;
        private Collection<String> proxyPreferredAuthSchemes;
        private boolean redirectsEnabled;
        private boolean relativeRedirectsAllowed;
        private int socketTimeout;
        private boolean staleConnectionCheckEnabled;
        private Collection<String> targetPreferredAuthSchemes;

        Builder() {
            this.staleConnectionCheckEnabled = false;
            this.redirectsEnabled = true;
            this.maxRedirects = 50;
            this.relativeRedirectsAllowed = true;
            this.authenticationEnabled = true;
            this.connectionRequestTimeout = -1;
            this.connectTimeout = -1;
            this.socketTimeout = -1;
            this.contentCompressionEnabled = true;
            this.normalizeUri = true;
        }

        public Builder setExpectContinueEnabled(boolean r1) {
            this.expectContinueEnabled = r1;
            return this;
        }

        public Builder setProxy(HttpHost r1) {
            this.proxy = r1;
            return this;
        }

        public Builder setLocalAddress(InetAddress r1) {
            this.localAddress = r1;
            return this;
        }

        @Deprecated
        public Builder setStaleConnectionCheckEnabled(boolean r1) {
            this.staleConnectionCheckEnabled = r1;
            return this;
        }

        public Builder setCookieSpec(String r1) {
            this.cookieSpec = r1;
            return this;
        }

        public Builder setRedirectsEnabled(boolean r1) {
            this.redirectsEnabled = r1;
            return this;
        }

        public Builder setRelativeRedirectsAllowed(boolean r1) {
            this.relativeRedirectsAllowed = r1;
            return this;
        }

        public Builder setCircularRedirectsAllowed(boolean r1) {
            this.circularRedirectsAllowed = r1;
            return this;
        }

        public Builder setMaxRedirects(int r1) {
            this.maxRedirects = r1;
            return this;
        }

        public Builder setAuthenticationEnabled(boolean r1) {
            this.authenticationEnabled = r1;
            return this;
        }

        public Builder setTargetPreferredAuthSchemes(Collection<String> r1) {
            this.targetPreferredAuthSchemes = r1;
            return this;
        }

        public Builder setProxyPreferredAuthSchemes(Collection<String> r1) {
            this.proxyPreferredAuthSchemes = r1;
            return this;
        }

        public Builder setConnectionRequestTimeout(int r1) {
            this.connectionRequestTimeout = r1;
            return this;
        }

        public Builder setConnectTimeout(int r1) {
            this.connectTimeout = r1;
            return this;
        }

        public Builder setSocketTimeout(int r1) {
            this.socketTimeout = r1;
            return this;
        }

        @Deprecated
        public Builder setDecompressionEnabled(boolean r1) {
            this.contentCompressionEnabled = r1;
            return this;
        }

        public Builder setContentCompressionEnabled(boolean r1) {
            this.contentCompressionEnabled = r1;
            return this;
        }

        public Builder setNormalizeUri(boolean r1) {
            this.normalizeUri = r1;
            return this;
        }

        public RequestConfig build() {
            return new RequestConfig(this.expectContinueEnabled, this.proxy, this.localAddress, this.staleConnectionCheckEnabled, this.cookieSpec, this.redirectsEnabled, this.relativeRedirectsAllowed, this.circularRedirectsAllowed, this.maxRedirects, this.authenticationEnabled, this.targetPreferredAuthSchemes, this.proxyPreferredAuthSchemes, this.connectionRequestTimeout, this.connectTimeout, this.socketTimeout, this.contentCompressionEnabled, this.normalizeUri);
        }
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    protected /* bridge */ /* synthetic */ Object m1499clone() throws CloneNotSupportedException {
        return clone();
    }

    static {
        DEFAULT = new Builder().build();
    }

    protected RequestConfig() {
        this(false, null, null, false, null, false, false, false, 0, false, null, null, 0, 0, 0, true, true);
    }

    RequestConfig(boolean r3, HttpHost r4, InetAddress r5, boolean r6, String r7, boolean r8, boolean r9, boolean r10, int r11, boolean r12, Collection<String> r13, Collection<String> r14, int r15, int r16, int r17, boolean r18, boolean r19) {
        this.expectContinueEnabled = r3;
        this.proxy = r4;
        this.localAddress = r5;
        this.staleConnectionCheckEnabled = r6;
        this.cookieSpec = r7;
        this.redirectsEnabled = r8;
        this.relativeRedirectsAllowed = r9;
        this.circularRedirectsAllowed = r10;
        this.maxRedirects = r11;
        this.authenticationEnabled = r12;
        this.targetPreferredAuthSchemes = r13;
        this.proxyPreferredAuthSchemes = r14;
        this.connectionRequestTimeout = r15;
        this.connectTimeout = r16;
        this.socketTimeout = r17;
        this.contentCompressionEnabled = r18;
        this.normalizeUri = r19;
    }

    public boolean isExpectContinueEnabled() {
        return this.expectContinueEnabled;
    }

    public HttpHost getProxy() {
        return this.proxy;
    }

    public InetAddress getLocalAddress() {
        return this.localAddress;
    }

    @Deprecated
    public boolean isStaleConnectionCheckEnabled() {
        return this.staleConnectionCheckEnabled;
    }

    public String getCookieSpec() {
        return this.cookieSpec;
    }

    public boolean isRedirectsEnabled() {
        return this.redirectsEnabled;
    }

    public boolean isRelativeRedirectsAllowed() {
        return this.relativeRedirectsAllowed;
    }

    public boolean isCircularRedirectsAllowed() {
        return this.circularRedirectsAllowed;
    }

    public int getMaxRedirects() {
        return this.maxRedirects;
    }

    public boolean isAuthenticationEnabled() {
        return this.authenticationEnabled;
    }

    public Collection<String> getTargetPreferredAuthSchemes() {
        return this.targetPreferredAuthSchemes;
    }

    public Collection<String> getProxyPreferredAuthSchemes() {
        return this.proxyPreferredAuthSchemes;
    }

    public int getConnectionRequestTimeout() {
        return this.connectionRequestTimeout;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    @Deprecated
    public boolean isDecompressionEnabled() {
        return this.contentCompressionEnabled;
    }

    public boolean isContentCompressionEnabled() {
        return this.contentCompressionEnabled;
    }

    public boolean isNormalizeUri() {
        return this.normalizeUri;
    }

    protected RequestConfig clone() throws CloneNotSupportedException {
        return (RequestConfig) super.clone();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[expectContinueEnabled=");
        r0.append(this.expectContinueEnabled);
        r0.append(", proxy=").append(this.proxy);
        r0.append(", localAddress=").append(this.localAddress);
        r0.append(", cookieSpec=").append(this.cookieSpec);
        r0.append(", redirectsEnabled=").append(this.redirectsEnabled);
        r0.append(", relativeRedirectsAllowed=").append(this.relativeRedirectsAllowed);
        r0.append(", maxRedirects=").append(this.maxRedirects);
        r0.append(", circularRedirectsAllowed=").append(this.circularRedirectsAllowed);
        r0.append(", authenticationEnabled=").append(this.authenticationEnabled);
        r0.append(", targetPreferredAuthSchemes=").append(this.targetPreferredAuthSchemes);
        r0.append(", proxyPreferredAuthSchemes=").append(this.proxyPreferredAuthSchemes);
        r0.append(", connectionRequestTimeout=").append(this.connectionRequestTimeout);
        r0.append(", connectTimeout=").append(this.connectTimeout);
        r0.append(", socketTimeout=").append(this.socketTimeout);
        r0.append(", contentCompressionEnabled=").append(this.contentCompressionEnabled);
        r0.append(", normalizeUri=").append(this.normalizeUri);
        r0.append("]");
        return r0.toString();
    }

    public static Builder custom() {
        return new Builder();
    }

    public static Builder copy(RequestConfig r2) {
        return new Builder().setExpectContinueEnabled(r2.isExpectContinueEnabled()).setProxy(r2.getProxy()).setLocalAddress(r2.getLocalAddress()).setStaleConnectionCheckEnabled(r2.isStaleConnectionCheckEnabled()).setCookieSpec(r2.getCookieSpec()).setRedirectsEnabled(r2.isRedirectsEnabled()).setRelativeRedirectsAllowed(r2.isRelativeRedirectsAllowed()).setCircularRedirectsAllowed(r2.isCircularRedirectsAllowed()).setMaxRedirects(r2.getMaxRedirects()).setAuthenticationEnabled(r2.isAuthenticationEnabled()).setTargetPreferredAuthSchemes(r2.getTargetPreferredAuthSchemes()).setProxyPreferredAuthSchemes(r2.getProxyPreferredAuthSchemes()).setConnectionRequestTimeout(r2.getConnectionRequestTimeout()).setConnectTimeout(r2.getConnectTimeout()).setSocketTimeout(r2.getSocketTimeout()).setDecompressionEnabled(r2.isDecompressionEnabled()).setContentCompressionEnabled(r2.isContentCompressionEnabled());
    }
}
