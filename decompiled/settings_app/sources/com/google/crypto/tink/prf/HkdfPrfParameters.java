package com.google.crypto.tink.prf;

import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class HkdfPrfParameters extends PrfParameters {
    private static final int MIN_KEY_SIZE = 16;
    private final HashType hashType;
    private final int keySizeBytes;

    @Nullable
    private final Bytes salt;

    /* JADX INFO: renamed from: com.google.crypto.tink.prf.HkdfPrfParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {

        @Nullable
        private HashType hashType;

        @Nullable
        private Integer keySizeBytes;

        @Nullable
        private Bytes salt;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.keySizeBytes = null;
            this.hashType = null;
            this.salt = null;
        }

        public Builder setKeySizeBytes(int keySizeBytes) throws GeneralSecurityException {
            if (keySizeBytes < 16) goto L7;
            this.keySizeBytes = Integer.valueOf(keySizeBytes);
            return this;
        L7:
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit or larger are supported", new Object[]{Integer.valueOf(keySizeBytes * 8)}));
        }

        public Builder setHashType(HashType hashType) {
            this.hashType = hashType;
            return this;
        }

        public Builder setSalt(Bytes salt) {
            if (salt.size() != 0) goto L6;
            this.salt = null;
            return this;
        L6:
            this.salt = salt;
            return this;
        }

        public HkdfPrfParameters build() throws GeneralSecurityException {
            if (this.keySizeBytes == null) goto L11;
            if (this.hashType == null) goto L9;
            return new HkdfPrfParameters(this.keySizeBytes.intValue(), this.hashType, this.salt, null);
        L9:
            throw new GeneralSecurityException("hash type is not set");
        L11:
            throw new GeneralSecurityException("key size is not set");
        }
    }

    @Immutable
    public static final class HashType {
        public static final HashType SHA1 = null;
        public static final HashType SHA224 = null;
        public static final HashType SHA256 = null;
        public static final HashType SHA384 = null;
        public static final HashType SHA512 = null;
        private final String name;

        static {
            SHA1 = new HashType("SHA1");
            SHA224 = new HashType("SHA224");
            SHA256 = new HashType("SHA256");
            SHA384 = new HashType("SHA384");
            SHA512 = new HashType("SHA512");
        }

        private HashType(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return false;
    }

    /* synthetic */ HkdfPrfParameters(int r1, HashType r2, Bytes r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    private HkdfPrfParameters(int keySizeBytes, HashType hashType, Bytes salt) {
        this.keySizeBytes = keySizeBytes;
        this.hashType = hashType;
        this.salt = salt;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public int getKeySizeBytes() {
        return this.keySizeBytes;
    }

    public HashType getHashType() {
        return this.hashType;
    }

    @Nullable
    public Bytes getSalt() {
        return this.salt;
    }

    public boolean equals(Object o) {
        if ((o instanceof HkdfPrfParameters) == true) goto L5;
        return false;
    L5:
        HkdfPrfParameters r4 = (HkdfPrfParameters) o;
        if (r4.getKeySizeBytes() == getKeySizeBytes()) goto L8;
        return false;
    L8:
        if (r4.getHashType() == getHashType()) goto L10;
        return false;
    L10:
        if (Objects.equals(r4.getSalt(), getSalt()) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{HkdfPrfParameters.class, Integer.valueOf(this.keySizeBytes), this.hashType, this.salt});
    }

    public String toString() {
        return "HKDF PRF Parameters (hashType: " + this.hashType + ", salt: " + this.salt + ", and " + this.keySizeBytes + "-byte key)";
    }
}
