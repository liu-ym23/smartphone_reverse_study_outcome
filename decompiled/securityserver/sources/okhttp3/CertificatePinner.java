package okhttp3;

import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CertificatePinner {
    public static final Companion Companion = null;

    @JvmField
    @NotNull
    public static final CertificatePinner DEFAULT = null;

    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;

    @NotNull
    private final Set<Pin> pins;

    @Metadata
    public static final class Builder {

        @NotNull
        private final List<Pin> pins;

        public Builder() {
            this.pins = new ArrayList();
        }

        @NotNull
        public final Builder add(@NotNull String r6, @NotNull String... r7) {
            Intrinsics.f(r6, "pattern");
            Intrinsics.f(r7, "pins");
            int r0 = r7.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            String r2 = r7[r1];
            this.pins.add(new Pin(r6, r2));
            r1 = r1 + 1;
            goto L3
        L5:
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final CertificatePinner build() {
            return new CertificatePinner(CollectionsKt.s(this.pins), null, 2, 0 == true ? 1 : 0);
        }

        @NotNull
        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final String pin(@NotNull Certificate r3) {
            Intrinsics.f(r3, "certificate");
            if ((r3 instanceof X509Certificate) == false) goto L7;
            return "sha256/" + sha256Hash((X509Certificate) r3).base64();
        L7:
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }

        @JvmStatic
        @NotNull
        public final ByteString sha1Hash(@NotNull X509Certificate r7) {
            Intrinsics.f(r7, "$this$sha1Hash");
            ByteString.Companion r0 = ByteString.Companion;
            PublicKey r6 = r7.getPublicKey();
            Intrinsics.e(r6, "publicKey");
            byte[] r1 = r6.getEncoded();
            Intrinsics.e(r1, "publicKey.encoded");
            return ByteString.Companion.of$default(r0, r1, 0, 0, 3, null).sha1();
        }

        @JvmStatic
        @NotNull
        public final ByteString sha256Hash(@NotNull X509Certificate r7) {
            Intrinsics.f(r7, "$this$sha256Hash");
            ByteString.Companion r0 = ByteString.Companion;
            PublicKey r6 = r7.getPublicKey();
            Intrinsics.e(r6, "publicKey");
            byte[] r1 = r6.getEncoded();
            Intrinsics.e(r1, "publicKey.encoded");
            return ByteString.Companion.of$default(r0, r1, 0, 0, 3, null).sha256();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public static final class Pin {

        @NotNull
        private final ByteString hash;

        @NotNull
        private final String hashAlgorithm;

        @NotNull
        private final String pattern;

        public Pin(@NotNull String r6, @NotNull String r7) {
            Intrinsics.f(r6, "pattern");
            Intrinsics.f(r7, "pin");
            if (StringsKt.F(r6, "*.", false) == false) goto L7;
            if (StringsKt.s(r6, "*", 1, false, 4) != (-1)) goto L7;
        L12:
            String r0 = HostnamesKt.toCanonicalHost(r6);
            if (r0 == null) goto L32;
            this.pattern = r0;
            if (StringsKt.F(r7, "sha1/", false) == false) goto L22;
            this.hashAlgorithm = "sha1";
            ByteString.Companion r8 = ByteString.Companion;
            String r1 = r7.substring(5);
            Intrinsics.e(r1, "(this as java.lang.String).substring(startIndex)");
            ByteString r9 = r8.decodeBase64(r1);
            if (r9 == null) goto L20;
            this.hash = r9;
            return;
        L20:
            throw new IllegalArgumentException("Invalid pin hash: ".concat(r7));
        L22:
            if (StringsKt.F(r7, "sha256/", false) == false) goto L30;
            this.hashAlgorithm = "sha256";
            ByteString.Companion r10 = ByteString.Companion;
            String r2 = r7.substring(7);
            Intrinsics.e(r2, "(this as java.lang.String).substring(startIndex)");
            ByteString r11 = r10.decodeBase64(r2);
            if (r11 == null) goto L28;
            this.hash = r11;
            return;
        L28:
            throw new IllegalArgumentException("Invalid pin hash: ".concat(r7));
        L30:
            throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': ".concat(r7));
        L32:
            throw new IllegalArgumentException("Invalid pattern: ".concat(r6));
        L7:
            if (StringsKt.F(r6, "**.", false) == false) goto L11;
            if (StringsKt.s(r6, "*", 2, false, 4) == (-1)) goto L12;
        L11:
            if (StringsKt.s(r6, "*", 0, false, 6) == (-1)) goto L12;
            throw new IllegalArgumentException("Unexpected pattern: ".concat(r6).toString());
        }

        public boolean equals(@Nullable Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Pin) == true) goto L8;
            return false;
        L8:
            Pin r6 = (Pin) r5;
            if ((!Intrinsics.a(this.pattern, r6.pattern)) == false) goto L12;
            return false;
        L12:
            if ((!Intrinsics.a(this.hashAlgorithm, r6.hashAlgorithm)) == false) goto L15;
            return false;
        L15:
            if ((!Intrinsics.a(this.hash, r6.hash)) == false) goto L17;
            return false;
        L17:
            return true;
        }

        @NotNull
        public final ByteString getHash() {
            return this.hash;
        }

        @NotNull
        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        @NotNull
        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            int r0 = this.pattern.hashCode() * 31;
            int r1 = (this.hashAlgorithm.hashCode() + r0) * 31;
            return this.hash.hashCode() + r1;
        }

        public final boolean matchesCertificate(@NotNull X509Certificate r4) {
            Intrinsics.f(r4, "certificate");
            String r0 = this.hashAlgorithm;
            int r1 = r0.hashCode();
            if (r1 == (-903629273)) goto L11;
            if (r1 == 3528965) goto L8;
        L13:
            return false;
        L8:
            if (r0.equals("sha1") == false) goto L13;
            return Intrinsics.a(this.hash, CertificatePinner.Companion.sha1Hash(r4));
        L11:
            if (r0.equals("sha256") == false) goto L13;
            return Intrinsics.a(this.hash, CertificatePinner.Companion.sha256Hash(r4));
        }

        public final boolean matchesHostname(@NotNull String r8) {
            Intrinsics.f(r8, "hostname");
            if (StringsKt.F(this.pattern, "**.", false) == false) goto L11;
            int r0 = this.pattern.length() - 3;
            int r5 = r8.length() - r0;
            if (StringsKt.w(r8, r8.length() - r0, this.pattern, 3, r0) == false) goto L19;
            if (r5 == 0) goto L21;
            if (r8.charAt(r5 - 1) == '.') goto L21;
            return false;
        L21:
            return true;
        L19:
            return false;
        L11:
            if (StringsKt.F(this.pattern, "*.", false) == false) goto L18;
            int r1 = this.pattern.length() - 1;
            int r4 = r8.length() - r1;
            if (StringsKt.w(r8, r8.length() - r1, this.pattern, 1, r1) == true) goto L15;
            return false;
        L15:
            if (StringsKt.v(r8, '.', r4 - 1, 4) == (-1)) goto L21;
            return false;
        L18:
            return r8.equals(this.pattern);
        }

        @NotNull
        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.base64();
        }
    }

    static {
        Companion = new Companion(null);
        DEFAULT = new Builder().build();
    }

    public CertificatePinner(@NotNull Set<Pin> r2, @Nullable CertificateChainCleaner r3) {
        Intrinsics.f(r2, "pins");
        this.pins = r2;
        this.certificateChainCleaner = r3;
    }

    @JvmStatic
    @NotNull
    public static final String pin(@NotNull Certificate r1) {
        return Companion.pin(r1);
    }

    @JvmStatic
    @NotNull
    public static final ByteString sha1Hash(@NotNull X509Certificate r1) {
        return Companion.sha1Hash(r1);
    }

    @JvmStatic
    @NotNull
    public static final ByteString sha256Hash(@NotNull X509Certificate r1) {
        return Companion.sha256Hash(r1);
    }

    public final void check(@NotNull final String r2, @NotNull final List<? extends Certificate> r3) {
        Intrinsics.f(r2, "hostname");
        Intrinsics.f(r3, "peerCertificates");
        check$okhttp(r2, new AnonymousClass1(this, r3, r2));
    }

    public final void check$okhttp(@NotNull String r10, @NotNull Function0<? extends List<? extends X509Certificate>> r11) {
        Intrinsics.f(r10, "hostname");
        Intrinsics.f(r11, "cleanedPeerCertificatesFn");
        List<Pin> r9 = findMatchingPins(r10);
        if (r9.isEmpty() == false) goto L5;
        return;
    L5:
        List r12 = (List) r11.invoke();
        Iterator r0 = r12.iterator();
    L7:
        if (r0.hasNext() == false) goto L31;
        X509Certificate r1 = (X509Certificate) r0.next();
        Iterator<Pin> r2 = r9.iterator();
        ByteString r3 = null;
        ByteString r4 = null;
    L10:
        if (r2.hasNext() == false) goto L7;
        Pin r5 = r2.next();
        String r6 = r5.getHashAlgorithm();
        int r7 = r6.hashCode();
        if (r7 != (-903629273)) goto L14;
        if (r6.equals("sha256") == false) goto L30;
        if (r3 != null) goto L27;
        r3 = Companion.sha256Hash(r1);
    L27:
        if (Intrinsics.a(r5.getHash(), r3) == false) goto L10;
        return;
    L30:
        throw new AssertionError("unsupported hashAlgorithm: " + r5.getHashAlgorithm());
    L14:
        if (r7 != 3528965) goto L30;
        if (r6.equals("sha1") == false) goto L30;
        if (r4 != null) goto L20;
        r4 = Companion.sha1Hash(r1);
    L20:
        if (Intrinsics.a(r5.getHash(), r4) == false) goto L10;
        return;
    L31:
        StringBuilder r8 = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        Iterator r13 = r12.iterator();
    L33:
        if (r13.hasNext() == false) goto L35;
        X509Certificate r14 = (X509Certificate) r13.next();
        r8.append("\n    ");
        r8.append(Companion.pin(r14));
        r8.append(": ");
        Principal r15 = r14.getSubjectDN();
        Intrinsics.e(r15, "element.subjectDN");
        r8.append(r15.getName());
        goto L33
    L35:
        r8.append("\n  Pinned certificates for ");
        r8.append(r10);
        r8.append(":");
        Iterator<Pin> r16 = r9.iterator();
    L37:
        if (r16.hasNext() == false) goto L39;
        Pin r17 = r16.next();
        r8.append("\n    ");
        r8.append(r17);
        goto L37
    L39:
        String r18 = r8.toString();
        Intrinsics.e(r18, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(r18);
    }

    public boolean equals(@Nullable Object r3) {
        if ((r3 instanceof CertificatePinner) == false) goto L9;
        CertificatePinner r4 = (CertificatePinner) r3;
        if (Intrinsics.a(r4.pins, this.pins) == false) goto L9;
        if (Intrinsics.a(r4.certificateChainCleaner, this.certificateChainCleaner) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @NotNull
    public final List<Pin> findMatchingPins(@NotNull String r4) {
        Intrinsics.f(r4, "hostname");
        Set<Pin> r3 = this.pins;
        List r0 = EmptyList.b;
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        Object r1 = r5.next();
        if (((Pin) r1).matchesHostname(r4) == false) goto L4;
        if (r0.isEmpty() == false) goto L10;
        r0 = new ArrayList();
    L10:
        TypeIntrinsics.a(r0).add(r1);
        goto L4
    L11:
        return r0;
    }

    @Nullable
    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    @NotNull
    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int r0 = (this.pins.hashCode() + 1517) * 41;
        CertificateChainCleaner r1 = this.certificateChainCleaner;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    @NotNull
    public final CertificatePinner withCertificateChainCleaner$okhttp(@NotNull CertificateChainCleaner r2) {
        Intrinsics.f(r2, "certificateChainCleaner");
        if (Intrinsics.a(this.certificateChainCleaner, r2) == false) goto L6;
        return this;
    L6:
        return new CertificatePinner(this.pins, r2);
    }

    public /* synthetic */ CertificatePinner(Set r1, CertificateChainCleaner r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    @Deprecated
    public final void check(@NotNull String r2, @NotNull Certificate... r3) {
        Intrinsics.f(r2, "hostname");
        Intrinsics.f(r3, "peerCertificates");
        check(r2, ArraysKt.u(r3));
    }
}
