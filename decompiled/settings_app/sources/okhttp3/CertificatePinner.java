package okhttp3;

import android.icu.text.PluralRules;
import com.android.settings.ApnEditor;
import com.android.settings.search.IndexDatabaseHelper;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: CertificatePinner.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0003!\"#B!\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011H\u0000¢\u0006\u0002\b\u0014J)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016\"\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006$"}, d2 = {"Lokhttp3/CertificatePinner;", "", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "(Ljava/util/Set;Lokhttp3/internal/tls/CertificateChainCleaner;)V", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "getPins", "()Ljava/util/Set;", "check", "", "hostname", "", "cleanedPeerCertificatesFn", "Lkotlin/Function0;", "", "Ljava/security/cert/X509Certificate;", "check$okhttp", "peerCertificates", "", "Ljava/security/cert/Certificate;", "(Ljava/lang/String;[Ljava/security/cert/Certificate;)V", "equals", "", PluralRules.KEYWORD_OTHER, "findMatchingPins", "hashCode", "", "withCertificateChainCleaner", "withCertificateChainCleaner$okhttp", "Builder", "Companion", "Pin", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CertificatePinner {
    public static final Companion Companion = null;
    public static final CertificatePinner DEFAULT = null;
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    /* JADX INFO: compiled from: CertificatePinner.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000b\"\u00020\n¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lokhttp3/CertificatePinner$Builder;", "", "()V", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "getPins", "()Ljava/util/List;", "add", "pattern", "", "", "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$Builder;", IndexDatabaseHelper.MetaColumns.BUILD, "Lokhttp3/CertificatePinner;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private final List<Pin> pins;

        public Builder() {
            this.pins = new ArrayList();
        }

        public final List<Pin> getPins() {
            return this.pins;
        }

        public final Builder add(String r6, String... r7) {
            Intrinsics.checkNotNullParameter(r6, "pattern");
            Intrinsics.checkNotNullParameter(r7, "pins");
            int r0 = r7.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            String r2 = r7[r1];
            r1 = r1 + 1;
            getPins().add(new Pin(r6, r2));
            goto L3
        L5:
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final CertificatePinner build() {
            return new CertificatePinner(CollectionsKt.toSet(this.pins), null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: CertificatePinner.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0007J\f\u0010\f\u001a\u00020\n*\u00020\u000bH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/CertificatePinner$Companion;", "", "()V", "DEFAULT", "Lokhttp3/CertificatePinner;", "pin", "", "certificate", "Ljava/security/cert/Certificate;", "sha1Hash", "Lokio/ByteString;", "Ljava/security/cert/X509Certificate;", "sha256Hash", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ByteString sha1Hash(X509Certificate r7) {
            Intrinsics.checkNotNullParameter(r7, "<this>");
            ByteString.Companion r0 = ByteString.Companion;
            byte[] r1 = r7.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(r1, "publicKey.encoded");
            return ByteString.Companion.of$default(r0, r1, 0, 0, 3, null).sha1();
        }

        @JvmStatic
        public final ByteString sha256Hash(X509Certificate r7) {
            Intrinsics.checkNotNullParameter(r7, "<this>");
            ByteString.Companion r0 = ByteString.Companion;
            byte[] r1 = r7.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(r1, "publicKey.encoded");
            return ByteString.Companion.of$default(r0, r1, 0, 0, 3, null).sha256();
        }

        @JvmStatic
        public final String pin(Certificate r2) {
            Intrinsics.checkNotNullParameter(r2, "certificate");
            if ((r2 instanceof X509Certificate) == false) goto L7;
            return Intrinsics.stringPlus("sha256/", sha256Hash((X509Certificate) r2).base64());
        L7:
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }
    }

    /* JADX INFO: compiled from: CertificatePinner.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0003J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lokhttp3/CertificatePinner$Pin;", "", "pattern", "", "pin", "(Ljava/lang/String;Ljava/lang/String;)V", "hash", "Lokio/ByteString;", "getHash", "()Lokio/ByteString;", "hashAlgorithm", "getHashAlgorithm", "()Ljava/lang/String;", "getPattern", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "matchesCertificate", "certificate", "Ljava/security/cert/X509Certificate;", "matchesHostname", "hostname", "toString", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Pin {
        private final ByteString hash;
        private final String hashAlgorithm;
        private final String pattern;

        public Pin(String r12, String r13) {
            Intrinsics.checkNotNullParameter(r12, "pattern");
            Intrinsics.checkNotNullParameter(r13, "pin");
            if (StringsKt.startsWith$default(r12, "*.", false, 2, null) == false) goto L7;
            if (StringsKt.indexOf$default(r12, ApnEditor.APN_TYPE_ALL, 1, false, 4, null) != (-1)) goto L7;
        L12:
            boolean r0 = true;
        L14:
            if (r0 == false) goto L37;
            String r1 = HostnamesKt.toCanonicalHost(r12);
            if (r1 == null) goto L35;
            this.pattern = r1;
            if (StringsKt.startsWith$default(r13, "sha1/", false, 2, null) == false) goto L25;
            this.hashAlgorithm = "sha1";
            ByteString.Companion r14 = ByteString.Companion;
            String r2 = r13.substring(5);
            Intrinsics.checkNotNullExpressionValue(r2, "this as java.lang.String).substring(startIndex)");
            ByteString r15 = r14.decodeBase64(r2);
            if (r15 == null) goto L23;
            this.hash = r15;
            return;
        L23:
            throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid pin hash: ", r13));
        L25:
            if (StringsKt.startsWith$default(r13, "sha256/", false, 2, null) == false) goto L33;
            this.hashAlgorithm = "sha256";
            ByteString.Companion r16 = ByteString.Companion;
            String r3 = r13.substring(7);
            Intrinsics.checkNotNullExpressionValue(r3, "this as java.lang.String).substring(startIndex)");
            ByteString r17 = r16.decodeBase64(r3);
            if (r17 == null) goto L31;
            this.hash = r17;
            return;
        L31:
            throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid pin hash: ", r13));
        L33:
            throw new IllegalArgumentException(Intrinsics.stringPlus("pins must start with 'sha256/' or 'sha1/': ", r13));
        L35:
            throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid pattern: ", r12));
        L37:
            throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected pattern: ", r12).toString());
        L7:
            if (StringsKt.startsWith$default(r12, "**.", false, 2, null) == false) goto L11;
            if (StringsKt.indexOf$default(r12, ApnEditor.APN_TYPE_ALL, 2, false, 4, null) == (-1)) goto L12;
        L11:
            if (StringsKt.indexOf$default(r12, ApnEditor.APN_TYPE_ALL, 0, false, 6, null) == (-1)) goto L12;
            r0 = false;
            goto L14
        }

        public final String getPattern() {
            return this.pattern;
        }

        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final ByteString getHash() {
            return this.hash;
        }

        public final boolean matchesHostname(String r12) {
            Intrinsics.checkNotNullParameter(r12, "hostname");
            if (StringsKt.startsWith$default(this.pattern, "**.", false, 2, null) == false) goto L11;
            int r7 = this.pattern.length() - 3;
            int r0 = r12.length() - r7;
            if (StringsKt.regionMatches$default(r12, r12.length() - r7, this.pattern, 3, r7, false, 16, null) == false) goto L19;
            if (r0 == 0) goto L21;
            if (r12.charAt(r0 - 1) == '.') goto L21;
            return false;
        L21:
            return true;
        L19:
            return false;
        L11:
            if (StringsKt.startsWith$default(this.pattern, "*.", false, 2, null) == false) goto L18;
            int r8 = this.pattern.length() - 1;
            int r1 = r12.length() - r8;
            if (StringsKt.regionMatches$default(r12, r12.length() - r8, this.pattern, 1, r8, false, 16, null) == true) goto L15;
            return false;
        L15:
            if (StringsKt.lastIndexOf$default(r12, '.', r1 - 1, false, 4, null) == (-1)) goto L21;
            return false;
        L18:
            return Intrinsics.areEqual(r12, this.pattern);
        }

        public final boolean matchesCertificate(X509Certificate r3) {
            Intrinsics.checkNotNullParameter(r3, "certificate");
            String r0 = this.hashAlgorithm;
            if (Intrinsics.areEqual(r0, "sha256") == false) goto L6;
            return Intrinsics.areEqual(this.hash, CertificatePinner.Companion.sha256Hash(r3));
        L6:
            if (Intrinsics.areEqual(r0, "sha1") == true) goto L11;
            return false;
        L11:
            return Intrinsics.areEqual(this.hash, CertificatePinner.Companion.sha1Hash(r3));
        }

        public String toString() {
            return this.hashAlgorithm + IOUtils.DIR_SEPARATOR_UNIX + this.hash.base64();
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Pin) == true) goto L8;
            return false;
        L8:
            Pin r6 = (Pin) r5;
            if (Intrinsics.areEqual(this.pattern, r6.pattern) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.hashAlgorithm, r6.hashAlgorithm) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.hash, r6.hash) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }
    }

    @JvmStatic
    public static final String pin(Certificate r1) {
        return Companion.pin(r1);
    }

    @JvmStatic
    public static final ByteString sha1Hash(X509Certificate r1) {
        return Companion.sha1Hash(r1);
    }

    @JvmStatic
    public static final ByteString sha256Hash(X509Certificate r1) {
        return Companion.sha256Hash(r1);
    }

    public CertificatePinner(Set<Pin> r2, CertificateChainCleaner r3) {
        Intrinsics.checkNotNullParameter(r2, "pins");
        this.pins = r2;
        this.certificateChainCleaner = r3;
    }

    public /* synthetic */ CertificatePinner(Set r1, CertificateChainCleaner r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final Set<Pin> getPins() {
        return this.pins;
    }

    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final void check(final String r2, final List<? extends Certificate> r3) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(r2, "hostname");
        Intrinsics.checkNotNullParameter(r3, "peerCertificates");
        check$okhttp(r2, new AnonymousClass1(this, r3, r2));
    }

    public final void check$okhttp(String r9, Function0<? extends List<? extends X509Certificate>> r10) {
        Intrinsics.checkNotNullParameter(r9, "hostname");
        Intrinsics.checkNotNullParameter(r10, "cleanedPeerCertificatesFn");
        List<Pin> r8 = findMatchingPins(r9);
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        List<? extends X509Certificate> r11 = r10.invoke();
        Iterator<? extends X509Certificate> r0 = r11.iterator();
    L7:
        if (r0.hasNext() == false) goto L27;
        X509Certificate r1 = r0.next();
        Iterator<Pin> r2 = r8.iterator();
        ByteString r3 = null;
        ByteString r4 = null;
    L10:
        if (r2.hasNext() == false) goto L7;
        Pin r5 = r2.next();
        String r6 = r5.getHashAlgorithm();
        if (Intrinsics.areEqual(r6, "sha256") == true) goto L13;
        if (Intrinsics.areEqual(r6, "sha1") == false) goto L26;
        if (r4 != null) goto L23;
        r4 = Companion.sha1Hash(r1);
    L23:
        if (Intrinsics.areEqual(r5.getHash(), r4) == false) goto L10;
        return;
    L26:
        throw new AssertionError(Intrinsics.stringPlus("unsupported hashAlgorithm: ", r5.getHashAlgorithm()));
    L13:
        if (r3 != null) goto L16;
        r3 = Companion.sha256Hash(r1);
    L16:
        if (Intrinsics.areEqual(r5.getHash(), r3) == false) goto L10;
        return;
    L27:
        StringBuilder r7 = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        Iterator<? extends X509Certificate> r12 = r11.iterator();
    L29:
        if (r12.hasNext() == false) goto L31;
        X509Certificate r13 = r12.next();
        r7.append("\n    ");
        r7.append(Companion.pin(r13));
        r7.append(": ");
        r7.append(r13.getSubjectDN().getName());
        goto L29
    L31:
        r7.append("\n  Pinned certificates for ");
        r7.append(r9);
        r7.append(":");
        Iterator<Pin> r14 = r8.iterator();
    L33:
        if (r14.hasNext() == false) goto L35;
        Pin r15 = r14.next();
        r7.append("\n    ");
        r7.append(r15);
        goto L33
    L35:
        String r16 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r16, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(r16);
    }

    @Deprecated(message = "replaced with {@link #check(String, List)}.", replaceWith = @ReplaceWith(expression = "check(hostname, peerCertificates.toList())", imports = {}))
    public final void check(String r2, Certificate... r3) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(r2, "hostname");
        Intrinsics.checkNotNullParameter(r3, "peerCertificates");
        check(r2, ArraysKt.toList(r3));
    }

    public final List<Pin> findMatchingPins(String r4) {
        Intrinsics.checkNotNullParameter(r4, "hostname");
        Set<Pin> r3 = this.pins;
        ArrayList r0 = CollectionsKt.emptyList();
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        Object r1 = r5.next();
        if (((Pin) r1).matchesHostname(r4) == false) goto L4;
        if (r0.isEmpty() == false) goto L10;
        r0 = new ArrayList();
    L10:
        TypeIntrinsics.asMutableList(r0).add(r1);
        goto L4
    L11:
        return r0;
    }

    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner r2) {
        Intrinsics.checkNotNullParameter(r2, "certificateChainCleaner");
        if (Intrinsics.areEqual(this.certificateChainCleaner, r2) == false) goto L6;
        return this;
    L6:
        return new CertificatePinner(this.pins, r2);
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof CertificatePinner) == false) goto L9;
        CertificatePinner r4 = (CertificatePinner) r3;
        if (Intrinsics.areEqual(r4.pins, this.pins) == false) goto L9;
        if (Intrinsics.areEqual(r4.certificateChainCleaner, this.certificateChainCleaner) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        int r1 = (1517 + this.pins.hashCode()) * 41;
        CertificateChainCleaner r2 = this.certificateChainCleaner;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r1 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    static {
        Companion = new Companion(null);
        DEFAULT = new Builder().build();
    }
}
