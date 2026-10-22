package okhttp3;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Handshake {
    public static final Companion Companion = null;

    @NotNull
    private final CipherSuite cipherSuite;

    @NotNull
    private final List<Certificate> localCertificates;

    @NotNull
    private final Lazy peerCertificates$delegate;

    @NotNull
    private final TlsVersion tlsVersion;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final List<Certificate> toImmutableList(Certificate[] r1) {
            if (r1 == null) goto L5;
            return Util.immutableListOf((Certificate[]) Arrays.copyOf(r1, r1.length));
        L5:
            return EmptyList.b;
        }

        @Deprecated
        @JvmName
        @NotNull
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final Handshake m92deprecated_get(@NotNull SSLSession r2) {
            Intrinsics.f(r2, "sslSession");
            return get(r2);
        }

        @JvmStatic
        @JvmName
        @NotNull
        public final Handshake get(@NotNull SSLSession r5) {
            Intrinsics.f(r5, "$this$handshake");
            String r0 = r5.getCipherSuite();
            if (r0 == null) goto L31;
            int r1 = r0.hashCode();
            if (r1 == 1019404634) goto L13;
            if (r1 == 1208658923) goto L10;
        L14:
            CipherSuite r2 = CipherSuite.Companion.forJavaName(r0);
            String r3 = r5.getProtocol();
            if (r3 == null) goto L27;
            if ("NONE".equals(r3) == true) goto L25;
            TlsVersion r4 = TlsVersion.Companion.forJavaName(r3);
            final List<Certificate> r6 = toImmutableList(r5.getPeerCertificates());     // Catch: SSLPeerUnverifiedException -> L21
        L23:
            return new Handshake(r4, r2, toImmutableList(r5.getLocalCertificates()), new Handshake$Companion$handshake$1(r6));
        L21:
            r6 = EmptyList.b;
            goto L23
        L25:
            throw new IOException("tlsVersion == NONE");
        L27:
            throw new IllegalStateException("tlsVersion == null".toString());
        L10:
            if (r0.equals("SSL_NULL_WITH_NULL_NULL") == false) goto L14;
        L29:
            throw new IOException("cipherSuite == ".concat(r0));
        L13:
            if (r0.equals("TLS_NULL_WITH_NULL_NULL") == true) goto L29;
        L31:
            throw new IllegalStateException("cipherSuite == null".toString());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Handshake get(@NotNull TlsVersion r2, @NotNull CipherSuite r3, @NotNull List<? extends Certificate> r4, @NotNull List<? extends Certificate> r5) {
            Intrinsics.f(r2, "tlsVersion");
            Intrinsics.f(r3, "cipherSuite");
            Intrinsics.f(r4, "peerCertificates");
            Intrinsics.f(r5, "localCertificates");
            final List r1 = Util.toImmutableList(r4);
            return new Handshake(r2, r3, Util.toImmutableList(r5), new Handshake$Companion$get$1(r1));
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(@NotNull TlsVersion r2, @NotNull CipherSuite r3, @NotNull List<? extends Certificate> r4, @NotNull final Function0<? extends List<? extends Certificate>> r5) {
        Intrinsics.f(r2, "tlsVersion");
        Intrinsics.f(r3, "cipherSuite");
        Intrinsics.f(r4, "localCertificates");
        Intrinsics.f(r5, "peerCertificatesFn");
        this.tlsVersion = r2;
        this.cipherSuite = r3;
        this.localCertificates = r4;
        this.peerCertificates$delegate = LazyKt.b(new AnonymousClass2(r5));
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final Handshake get(@NotNull SSLSession r1) {
        return Companion.get(r1);
    }

    private final String getName(Certificate r1) {
        if ((r1 instanceof X509Certificate) == true) goto L7;
        String r0 = r1.getType();
        Intrinsics.e(r0, "type");
        return r0;
    L7:
        return ((X509Certificate) r1).getSubjectDN().toString();
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_cipherSuite, reason: not valid java name */
    public final CipherSuite m86deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_localCertificates, reason: not valid java name */
    public final List<Certificate> m87deprecated_localCertificates() {
        return this.localCertificates;
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_localPrincipal, reason: not valid java name */
    public final Principal m88deprecated_localPrincipal() {
        return localPrincipal();
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_peerCertificates, reason: not valid java name */
    public final List<Certificate> m89deprecated_peerCertificates() {
        return peerCertificates();
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_peerPrincipal, reason: not valid java name */
    public final Principal m90deprecated_peerPrincipal() {
        return peerPrincipal();
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_tlsVersion, reason: not valid java name */
    public final TlsVersion m91deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    @JvmName
    @NotNull
    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public boolean equals(@Nullable Object r3) {
        if ((r3 instanceof Handshake) == false) goto L13;
        Handshake r4 = (Handshake) r3;
        if (r4.tlsVersion != this.tlsVersion) goto L13;
        if (Intrinsics.a(r4.cipherSuite, this.cipherSuite) == false) goto L13;
        if (Intrinsics.a(r4.peerCertificates(), peerCertificates()) == false) goto L13;
        if (Intrinsics.a(r4.localCertificates, this.localCertificates) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public int hashCode() {
        int r0 = (this.tlsVersion.hashCode() + 527) * 31;
        int r1 = (this.cipherSuite.hashCode() + r0) * 31;
        int r2 = (peerCertificates().hashCode() + r1) * 31;
        return this.localCertificates.hashCode() + r2;
    }

    @JvmName
    @NotNull
    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    @JvmName
    @Nullable
    public final Principal localPrincipal() {
        List<Certificate> r2 = this.localCertificates;
        Intrinsics.f(r2, "<this>");
        if (r2.isEmpty() == false) goto L5;
        Certificate r3 = null;
    L7:
        if ((r3 instanceof X509Certificate) == true) goto L9;
        r3 = null;
    L9:
        X509Certificate r4 = (X509Certificate) r3;
        if (r4 != null) goto L12;
        return null;
    L12:
        return r4.getSubjectX500Principal();
    L5:
        r3 = r2.get(0);
        goto L7
    }

    @JvmName
    @NotNull
    public final List<Certificate> peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    @JvmName
    @Nullable
    public final Principal peerPrincipal() {
        List<Certificate> r2 = peerCertificates();
        Intrinsics.f(r2, "<this>");
        if (r2.isEmpty() == false) goto L5;
        Certificate r3 = null;
    L7:
        if ((r3 instanceof X509Certificate) == true) goto L9;
        r3 = null;
    L9:
        X509Certificate r4 = (X509Certificate) r3;
        if (r4 != null) goto L12;
        return null;
    L12:
        return r4.getSubjectX500Principal();
    L5:
        r3 = r2.get(0);
        goto L7
    }

    @JvmName
    @NotNull
    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    @NotNull
    public String toString() {
        List<Certificate> r0 = peerCertificates();
        ArrayList r1 = new ArrayList(CollectionsKt.e(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(getName((Certificate) r2.next()));
        goto L4
    L6:
        String r3 = r1.toString();
        StringBuilder r4 = new StringBuilder("Handshake{tlsVersion=");
        r4.append(this.tlsVersion);
        r4.append(" cipherSuite=");
        r4.append(this.cipherSuite);
        r4.append(" peerCertificates=");
        r4.append(r3);
        r4.append(" localCertificates=");
        List<Certificate> r5 = this.localCertificates;
        ArrayList r6 = new ArrayList(CollectionsKt.e(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        r6.add(getName((Certificate) r7.next()));
        goto L8
    L10:
        r4.append(r6);
        r4.append('}');
        return r4.toString();
    }

    @JvmStatic
    @NotNull
    public static final Handshake get(@NotNull TlsVersion r1, @NotNull CipherSuite r2, @NotNull List<? extends Certificate> r3, @NotNull List<? extends Certificate> r4) {
        return Companion.get(r1, r2, r3, r4);
    }
}
