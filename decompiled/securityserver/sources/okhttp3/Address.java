package okhttp3;

import a.a;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Address {

    @Nullable
    private final CertificatePinner certificatePinner;

    @NotNull
    private final List<ConnectionSpec> connectionSpecs;

    @NotNull
    private final Dns dns;

    @Nullable
    private final HostnameVerifier hostnameVerifier;

    @NotNull
    private final List<Protocol> protocols;

    @Nullable
    private final Proxy proxy;

    @NotNull
    private final Authenticator proxyAuthenticator;

    @NotNull
    private final ProxySelector proxySelector;

    @NotNull
    private final SocketFactory socketFactory;

    @Nullable
    private final SSLSocketFactory sslSocketFactory;

    @NotNull
    private final HttpUrl url;

    public Address(@NotNull String r2, int r3, @NotNull Dns r4, @NotNull SocketFactory r5, @Nullable SSLSocketFactory r6, @Nullable HostnameVerifier r7, @Nullable CertificatePinner r8, @NotNull Authenticator r9, @Nullable Proxy r10, @NotNull List<? extends Protocol> r11, @NotNull List<ConnectionSpec> r12, @NotNull ProxySelector r13) {
        Intrinsics.f(r2, "uriHost");
        Intrinsics.f(r4, MultiProcessFileUtils.KEY_DNS);
        Intrinsics.f(r5, "socketFactory");
        Intrinsics.f(r9, "proxyAuthenticator");
        Intrinsics.f(r11, "protocols");
        Intrinsics.f(r12, "connectionSpecs");
        Intrinsics.f(r13, "proxySelector");
        this.dns = r4;
        this.socketFactory = r5;
        this.sslSocketFactory = r6;
        this.hostnameVerifier = r7;
        this.certificatePinner = r8;
        this.proxyAuthenticator = r9;
        this.proxy = r10;
        this.proxySelector = r13;
        HttpUrl.Builder r14 = new HttpUrl.Builder();
        if (r6 == null) goto L5;
        String r15 = "https";
    L6:
        this.url = r14.scheme(r15).host(r2).port(r3).build();
        this.protocols = Util.toImmutableList(r11);
        this.connectionSpecs = Util.toImmutableList(r12);
        return;
    L5:
        r15 = HttpHost.DEFAULT_SCHEME_NAME;
        goto L6
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_certificatePinner, reason: not valid java name */
    public final CertificatePinner m45deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_connectionSpecs, reason: not valid java name */
    public final List<ConnectionSpec> m46deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_dns, reason: not valid java name */
    public final Dns m47deprecated_dns() {
        return this.dns;
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_hostnameVerifier, reason: not valid java name */
    public final HostnameVerifier m48deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_protocols, reason: not valid java name */
    public final List<Protocol> m49deprecated_protocols() {
        return this.protocols;
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_proxy, reason: not valid java name */
    public final Proxy m50deprecated_proxy() {
        return this.proxy;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_proxyAuthenticator, reason: not valid java name */
    public final Authenticator m51deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_proxySelector, reason: not valid java name */
    public final ProxySelector m52deprecated_proxySelector() {
        return this.proxySelector;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_socketFactory, reason: not valid java name */
    public final SocketFactory m53deprecated_socketFactory() {
        return this.socketFactory;
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_sslSocketFactory, reason: not valid java name */
    public final SSLSocketFactory m54deprecated_sslSocketFactory() {
        return this.sslSocketFactory;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final HttpUrl m55deprecated_url() {
        return this.url;
    }

    @JvmName
    @Nullable
    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @JvmName
    @NotNull
    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    @JvmName
    @NotNull
    public final Dns dns() {
        return this.dns;
    }

    public boolean equals(@Nullable Object r3) {
        if ((r3 instanceof Address) == false) goto L9;
        Address r4 = (Address) r3;
        if (Intrinsics.a(this.url, r4.url) == false) goto L9;
        if (equalsNonHost$okhttp(r4) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean equalsNonHost$okhttp(@NotNull Address r3) {
        Intrinsics.f(r3, "that");
        if (Intrinsics.a(this.dns, r3.dns) == true) goto L5;
    L23:
        return false;
    L5:
        if (Intrinsics.a(this.proxyAuthenticator, r3.proxyAuthenticator) == false) goto L23;
        if (Intrinsics.a(this.protocols, r3.protocols) == false) goto L23;
        if (Intrinsics.a(this.connectionSpecs, r3.connectionSpecs) == false) goto L23;
        if (Intrinsics.a(this.proxySelector, r3.proxySelector) == false) goto L23;
        if (Intrinsics.a(this.proxy, r3.proxy) == false) goto L23;
        if (Intrinsics.a(this.sslSocketFactory, r3.sslSocketFactory) == false) goto L23;
        if (Intrinsics.a(this.hostnameVerifier, r3.hostnameVerifier) == false) goto L23;
        if (Intrinsics.a(this.certificatePinner, r3.certificatePinner) == false) goto L23;
        if (this.url.port() != r3.url.port()) goto L23;
        return true;
    }

    public int hashCode() {
        int r0 = (this.url.hashCode() + 527) * 31;
        int r1 = (this.dns.hashCode() + r0) * 31;
        int r2 = (this.proxyAuthenticator.hashCode() + r1) * 31;
        int r3 = (this.protocols.hashCode() + r2) * 31;
        int r4 = (this.connectionSpecs.hashCode() + r3) * 31;
        int r5 = (this.proxySelector.hashCode() + r4) * 31;
        int r6 = (Objects.hashCode(this.proxy) + r5) * 31;
        int r7 = (Objects.hashCode(this.sslSocketFactory) + r6) * 31;
        int r8 = (Objects.hashCode(this.hostnameVerifier) + r7) * 31;
        return Objects.hashCode(this.certificatePinner) + r8;
    }

    @JvmName
    @Nullable
    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @JvmName
    @NotNull
    public final List<Protocol> protocols() {
        return this.protocols;
    }

    @JvmName
    @Nullable
    public final Proxy proxy() {
        return this.proxy;
    }

    @JvmName
    @NotNull
    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @JvmName
    @NotNull
    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    @JvmName
    @NotNull
    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    @JvmName
    @Nullable
    public final SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    @NotNull
    public String toString() {
        StringBuilder r0 = new StringBuilder("Address{");
        r0.append(this.url.host());
        r0.append(':');
        r0.append(this.url.port());
        r0.append(", ");
        if (this.proxy == null) goto L6;
        StringBuilder r1 = new StringBuilder("proxy=");
        Object r3 = this.proxy;
    L5:
        r1.append(r3);
        return a.o(r0, r1.toString(), "}");
    L6:
        r1 = new StringBuilder("proxySelector=");
        r3 = this.proxySelector;
        goto L5
    }

    @JvmName
    @NotNull
    public final HttpUrl url() {
        return this.url;
    }
}
