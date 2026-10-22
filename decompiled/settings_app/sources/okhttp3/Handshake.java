package okhttp3;

import android.icu.text.PluralRules;
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
import javax.security.auth.x500.X500Principal;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: Handshake.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B9\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n¢\u0006\u0002\u0010\u000bJ\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\b J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\b!J\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\b\"J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\b#J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b$J\b\u0010%\u001a\u00020\u0017H\u0016R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00078GX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000f8G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0017*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lokhttp3/Handshake;", "", "tlsVersion", "Lokhttp3/TlsVersion;", "cipherSuite", "Lokhttp3/CipherSuite;", "localCertificates", "", "Ljava/security/cert/Certificate;", "peerCertificatesFn", "Lkotlin/Function0;", "(Lokhttp3/TlsVersion;Lokhttp3/CipherSuite;Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "()Lokhttp3/CipherSuite;", "()Ljava/util/List;", "localPrincipal", "Ljava/security/Principal;", "()Ljava/security/Principal;", "peerCertificates", "peerCertificates$delegate", "Lkotlin/Lazy;", "peerPrincipal", "()Lokhttp3/TlsVersion;", "name", "", "getName", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "-deprecated_cipherSuite", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "-deprecated_localCertificates", "-deprecated_localPrincipal", "-deprecated_peerCertificates", "-deprecated_peerPrincipal", "-deprecated_tlsVersion", "toString", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Handshake {
    public static final Companion Companion = null;
    private final CipherSuite cipherSuite;
    private final List<Certificate> localCertificates;
    private final Lazy peerCertificates$delegate;
    private final TlsVersion tlsVersion;

    /* JADX INFO: compiled from: Handshake.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0007J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007J\u0011\u0010\u0010\u001a\u00020\u0004*\u00020\u0006H\u0007¢\u0006\u0002\b\u0003J!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lokhttp3/Handshake$Companion;", "", "()V", "get", "Lokhttp3/Handshake;", "sslSession", "Ljavax/net/ssl/SSLSession;", "-deprecated_get", "tlsVersion", "Lokhttp3/TlsVersion;", "cipherSuite", "Lokhttp3/CipherSuite;", "peerCertificates", "", "Ljava/security/cert/Certificate;", "localCertificates", "handshake", "toImmutableList", "", "([Ljava/security/cert/Certificate;)Ljava/util/List;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Handshake get(SSLSession r5) throws IOException {
            Intrinsics.checkNotNullParameter(r5, "<this>");
            String r0 = r5.getCipherSuite();
            if (r0 == null) goto L26;
            if (Intrinsics.areEqual(r0, "TLS_NULL_WITH_NULL_NULL") == false) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == true) goto L24;
            CipherSuite r2 = CipherSuite.Companion.forJavaName(r0);
            String r3 = r5.getProtocol();
            if (r3 == null) goto L22;
            if (Intrinsics.areEqual("NONE", r3) == true) goto L20;
            TlsVersion r4 = TlsVersion.Companion.forJavaName(r3);
            final List<Certificate> r6 = toImmutableList(r5.getPeerCertificates());     // Catch: SSLPeerUnverifiedException -> L16
        L18:
            return new Handshake(r4, r2, toImmutableList(r5.getLocalCertificates()), new Handshake$Companion$handshake$1(r6));
        L16:
            r6 = CollectionsKt.emptyList();
            goto L18
        L20:
            throw new IOException("tlsVersion == NONE");
        L22:
            throw new IllegalStateException("tlsVersion == null".toString());
        L24:
            throw new IOException(Intrinsics.stringPlus("cipherSuite == ", r0));
        L7:
            r1 = Intrinsics.areEqual(r0, "SSL_NULL_WITH_NULL_NULL");
            goto L8
        L26:
            throw new IllegalStateException("cipherSuite == null".toString());
        }

        private final List<Certificate> toImmutableList(Certificate[] r1) {
            if (r1 == null) goto L5;
            return Util.immutableListOf(Arrays.copyOf(r1, r1.length));
        L5:
            return CollectionsKt.emptyList();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "sslSession.handshake()", imports = {}))
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final Handshake m3134deprecated_get(SSLSession r2) throws IOException {
            Intrinsics.checkNotNullParameter(r2, "sslSession");
            return get(r2);
        }

        @JvmStatic
        public final Handshake get(TlsVersion r2, CipherSuite r3, List<? extends Certificate> r4, List<? extends Certificate> r5) {
            Intrinsics.checkNotNullParameter(r2, "tlsVersion");
            Intrinsics.checkNotNullParameter(r3, "cipherSuite");
            Intrinsics.checkNotNullParameter(r4, "peerCertificates");
            Intrinsics.checkNotNullParameter(r5, "localCertificates");
            final List r1 = Util.toImmutableList(r4);
            return new Handshake(r2, r3, Util.toImmutableList(r5), new Handshake$Companion$get$1(r1));
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final Handshake get(SSLSession r1) throws IOException {
        return Companion.get(r1);
    }

    @JvmStatic
    public static final Handshake get(TlsVersion r1, CipherSuite r2, List<? extends Certificate> r3, List<? extends Certificate> r4) {
        return Companion.get(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(TlsVersion r2, CipherSuite r3, List<? extends Certificate> r4, final Function0<? extends List<? extends Certificate>> r5) {
        Intrinsics.checkNotNullParameter(r2, "tlsVersion");
        Intrinsics.checkNotNullParameter(r3, "cipherSuite");
        Intrinsics.checkNotNullParameter(r4, "localCertificates");
        Intrinsics.checkNotNullParameter(r5, "peerCertificatesFn");
        this.tlsVersion = r2;
        this.cipherSuite = r3;
        this.localCertificates = r4;
        this.peerCertificates$delegate = LazyKt.lazy(new AnonymousClass2(r5));
    }

    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    public final List<Certificate> peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "tlsVersion", imports = {}))
    /* JADX INFO: renamed from: -deprecated_tlsVersion, reason: not valid java name */
    public final TlsVersion m3133deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cipherSuite", imports = {}))
    /* JADX INFO: renamed from: -deprecated_cipherSuite, reason: not valid java name */
    public final CipherSuite m3128deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "peerCertificates", imports = {}))
    /* JADX INFO: renamed from: -deprecated_peerCertificates, reason: not valid java name */
    public final List<Certificate> m3131deprecated_peerCertificates() {
        return peerCertificates();
    }

    public final Principal peerPrincipal() {
        Object r2 = CollectionsKt.firstOrNull(peerCertificates());
        X500Principal r1 = null;
        if ((r2 instanceof X509Certificate) == false) goto L5;
        X509Certificate r3 = (X509Certificate) r2;
    L6:
        if (r3 == null) goto L10;
        r1 = r3.getSubjectX500Principal();
    L10:
        return r1;
    L5:
        r3 = null;
        goto L6
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "peerPrincipal", imports = {}))
    /* JADX INFO: renamed from: -deprecated_peerPrincipal, reason: not valid java name */
    public final Principal m3132deprecated_peerPrincipal() {
        return peerPrincipal();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "localCertificates", imports = {}))
    /* JADX INFO: renamed from: -deprecated_localCertificates, reason: not valid java name */
    public final List<Certificate> m3129deprecated_localCertificates() {
        return this.localCertificates;
    }

    public final Principal localPrincipal() {
        Object r2 = CollectionsKt.firstOrNull(this.localCertificates);
        X500Principal r1 = null;
        if ((r2 instanceof X509Certificate) == false) goto L5;
        X509Certificate r3 = (X509Certificate) r2;
    L6:
        if (r3 == null) goto L10;
        r1 = r3.getSubjectX500Principal();
    L10:
        return r1;
    L5:
        r3 = null;
        goto L6
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "localPrincipal", imports = {}))
    /* JADX INFO: renamed from: -deprecated_localPrincipal, reason: not valid java name */
    public final Principal m3130deprecated_localPrincipal() {
        return localPrincipal();
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof Handshake) == false) goto L13;
        Handshake r4 = (Handshake) r3;
        if (r4.tlsVersion != this.tlsVersion) goto L13;
        if (Intrinsics.areEqual(r4.cipherSuite, this.cipherSuite) == false) goto L13;
        if (Intrinsics.areEqual(r4.peerCertificates(), peerCertificates()) == false) goto L13;
        if (Intrinsics.areEqual(r4.localCertificates, this.localCertificates) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.tlsVersion.hashCode()) * 31) + this.cipherSuite.hashCode()) * 31) + peerCertificates().hashCode()) * 31) + this.localCertificates.hashCode();
    }

    public String toString() {
        List<Certificate> r0 = peerCertificates();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(getName((Certificate) r2.next()));
        goto L4
    L6:
        String r3 = r1.toString();
        StringBuilder r4 = new StringBuilder("Handshake{tlsVersion=").append(this.tlsVersion).append(" cipherSuite=").append(this.cipherSuite).append(" peerCertificates=").append(r3).append(" localCertificates=");
        List<Certificate> r5 = this.localCertificates;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L11;
        r6.add(getName((Certificate) r7.next()));
        goto L8
    L11:
        return r4.append(r6).append('}').toString();
    }

    private final String getName(Certificate r1) {
        if ((r1 instanceof X509Certificate) == true) goto L7;
        String r0 = r1.getType();
        Intrinsics.checkNotNullExpressionValue(r0, "type");
        return r0;
    L7:
        return ((X509Certificate) r1).getSubjectDN().toString();
    }
}
