package com.google.crypto.tink.streamingaead;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class AesGcmHkdfStreamingParameters extends StreamingAeadParameters {
    private final Integer ciphertextSegmentSizeBytes;
    private final Integer derivedAesGcmKeySizeBytes;
    private final HashType hkdfHashType;
    private final Integer keySizeBytes;

    /* JADX INFO: renamed from: com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {

        @Nullable
        private Integer ciphertextSegmentSizeBytes;

        @Nullable
        private Integer derivedAesGcmKeySizeBytes;

        @Nullable
        private HashType hkdfHashType;

        @Nullable
        private Integer keySizeBytes;

        public Builder() {
            this.keySizeBytes = null;
            this.derivedAesGcmKeySizeBytes = null;
            this.hkdfHashType = null;
            this.ciphertextSegmentSizeBytes = null;
        }

        public Builder setKeySizeBytes(int keySizeBytes) {
            this.keySizeBytes = Integer.valueOf(keySizeBytes);
            return this;
        }

        public Builder setDerivedAesGcmKeySizeBytes(int derivedAesGcmKeySizeBytes) {
            this.derivedAesGcmKeySizeBytes = Integer.valueOf(derivedAesGcmKeySizeBytes);
            return this;
        }

        public Builder setHkdfHashType(HashType hkdfHashType) {
            this.hkdfHashType = hkdfHashType;
            return this;
        }

        public Builder setCiphertextSegmentSizeBytes(int ciphertextSegmentSizeBytes) {
            this.ciphertextSegmentSizeBytes = Integer.valueOf(ciphertextSegmentSizeBytes);
            return this;
        }

        public AesGcmHkdfStreamingParameters build() throws GeneralSecurityException {
            if (this.keySizeBytes == null) goto L34;
            Integer r0 = this.derivedAesGcmKeySizeBytes;
            if (r0 == null) goto L32;
            if (this.hkdfHashType == null) goto L30;
            if (this.ciphertextSegmentSizeBytes == null) goto L28;
            if (r0.intValue() == 16) goto L18;
            if (this.derivedAesGcmKeySizeBytes.intValue() == 32) goto L18;
            throw new GeneralSecurityException("derivedAesGcmKeySizeBytes needs to be 16 or 32, not " + this.derivedAesGcmKeySizeBytes);
        L18:
            if (this.keySizeBytes.intValue() < this.derivedAesGcmKeySizeBytes.intValue()) goto L26;
            if (this.ciphertextSegmentSizeBytes.intValue() <= (this.derivedAesGcmKeySizeBytes.intValue() + 24)) goto L24;
            return new AesGcmHkdfStreamingParameters(this.keySizeBytes, this.derivedAesGcmKeySizeBytes, this.hkdfHashType, this.ciphertextSegmentSizeBytes, null);
        L24:
            throw new GeneralSecurityException("ciphertextSegmentSizeBytes needs to be at least derivedAesGcmKeySizeBytes + 25, i.e., " + (this.derivedAesGcmKeySizeBytes.intValue() + 25));
        L26:
            throw new GeneralSecurityException("keySizeBytes needs to be at least derivedAesGcmKeySizeBytes, i.e., " + this.derivedAesGcmKeySizeBytes);
        L28:
            throw new GeneralSecurityException("ciphertextSegmentSizeBytes needs to be set");
        L30:
            throw new GeneralSecurityException("hkdfHashType needs to be set");
        L32:
            throw new GeneralSecurityException("derivedAesGcmKeySizeBytes needs to be set");
        L34:
            throw new GeneralSecurityException("keySizeBytes needs to be set");
        }
    }

    @Immutable
    public static final class HashType {
        public static final HashType SHA1 = null;
        public static final HashType SHA256 = null;
        public static final HashType SHA512 = null;
        private final String name;

        static {
            SHA1 = new HashType("SHA1");
            SHA256 = new HashType("SHA256");
            SHA512 = new HashType("SHA512");
        }

        private HashType(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

    /* synthetic */ AesGcmHkdfStreamingParameters(Integer r1, Integer r2, HashType r3, Integer r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    public static Builder builder() {
        return new Builder();
    }

    private AesGcmHkdfStreamingParameters(Integer keySizeBytes, Integer derivedAesGcmKeySizeBytes, HashType hkdfHashType, Integer ciphertextSegmentSizeBytes) {
        this.keySizeBytes = keySizeBytes;
        this.derivedAesGcmKeySizeBytes = derivedAesGcmKeySizeBytes;
        this.hkdfHashType = hkdfHashType;
        this.ciphertextSegmentSizeBytes = ciphertextSegmentSizeBytes;
    }

    public int getKeySizeBytes() {
        return this.keySizeBytes.intValue();
    }

    public int getDerivedAesGcmKeySizeBytes() {
        return this.derivedAesGcmKeySizeBytes.intValue();
    }

    public HashType getHkdfHashType() {
        return this.hkdfHashType;
    }

    public int getCiphertextSegmentSizeBytes() {
        return this.ciphertextSegmentSizeBytes.intValue();
    }

    public boolean equals(Object o) {
        if ((o instanceof AesGcmHkdfStreamingParameters) == true) goto L5;
        return false;
    L5:
        AesGcmHkdfStreamingParameters r4 = (AesGcmHkdfStreamingParameters) o;
        if (r4.getKeySizeBytes() == getKeySizeBytes()) goto L8;
        return false;
    L8:
        if (r4.getDerivedAesGcmKeySizeBytes() == getDerivedAesGcmKeySizeBytes()) goto L10;
        return false;
    L10:
        if (r4.getHkdfHashType() == getHkdfHashType()) goto L12;
        return false;
    L12:
        if (r4.getCiphertextSegmentSizeBytes() != getCiphertextSegmentSizeBytes()) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{AesGcmHkdfStreamingParameters.class, this.keySizeBytes, this.derivedAesGcmKeySizeBytes, this.hkdfHashType, this.ciphertextSegmentSizeBytes});
    }

    public String toString() {
        return "AesGcmHkdfStreaming Parameters (IKM size: " + this.keySizeBytes + ", " + this.derivedAesGcmKeySizeBytes + "-byte AES GCM key, " + this.hkdfHashType + " for HKDF " + this.ciphertextSegmentSizeBytes + "-byte ciphertexts)";
    }
}
