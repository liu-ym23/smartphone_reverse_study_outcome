package com.google.crypto.tink.jwt;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.subtle.Base64;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Optional;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class JwtRsaSsaPkcs1PublicKey extends JwtSignaturePublicKey {
    private final Optional<Integer> idRequirement;
    private final Optional<String> kid;
    private final BigInteger modulus;
    private final JwtRsaSsaPkcs1Parameters parameters;

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtRsaSsaPkcs1PublicKey$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private Optional<String> customKid;
        private Optional<Integer> idRequirement;
        private Optional<BigInteger> modulus;
        private Optional<JwtRsaSsaPkcs1Parameters> parameters;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.parameters = Optional.empty();
            this.modulus = Optional.empty();
            this.idRequirement = Optional.empty();
            this.customKid = Optional.empty();
        }

        public Builder setParameters(JwtRsaSsaPkcs1Parameters parameters) {
            this.parameters = Optional.of(parameters);
            return this;
        }

        public Builder setModulus(BigInteger modulus) {
            this.modulus = Optional.of(modulus);
            return this;
        }

        public Builder setIdRequirement(Integer idRequirement) {
            this.idRequirement = Optional.of(idRequirement);
            return this;
        }

        public Builder setCustomKid(String customKid) {
            this.customKid = Optional.of(customKid);
            return this;
        }

        private Optional<String> computeKid() throws GeneralSecurityException {
            if (this.parameters.get().getKidStrategy().equals(JwtRsaSsaPkcs1Parameters.KidStrategy.BASE64_ENCODED_KEY_ID) == false) goto L11;
            if (this.customKid.isPresent() == true) goto L9;
            return Optional.of(Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(this.idRequirement.get().intValue()).array()));
        L9:
            throw new GeneralSecurityException("customKid must not be set for KidStrategy BASE64_ENCODED_KEY_ID");
        L11:
            if (this.parameters.get().getKidStrategy().equals(JwtRsaSsaPkcs1Parameters.KidStrategy.CUSTOM) == false) goto L19;
            if (this.customKid.isPresent() == false) goto L17;
            return this.customKid;
        L17:
            throw new GeneralSecurityException("customKid needs to be set for KidStrategy CUSTOM");
        L19:
            if (this.parameters.get().getKidStrategy().equals(JwtRsaSsaPkcs1Parameters.KidStrategy.IGNORED) == false) goto L27;
            if (this.customKid.isPresent() == true) goto L25;
            return Optional.empty();
        L25:
            throw new GeneralSecurityException("customKid must not be set for KidStrategy IGNORED");
        L27:
            throw new IllegalStateException("Unknown kid strategy");
        }

        public JwtRsaSsaPkcs1PublicKey build() throws GeneralSecurityException {
            if (this.parameters.isPresent() == false) goto L29;
            if (this.modulus.isPresent() == false) goto L27;
            int r0 = this.modulus.get().bitLength();
            int r1 = this.parameters.get().getModulusSizeBits();
            if (r0 != r1) goto L25;
            if (this.parameters.get().hasIdRequirement() == false) goto L16;
            if (this.idRequirement.isPresent() == true) goto L16;
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        L16:
            if (this.parameters.get().hasIdRequirement() == true) goto L23;
            if (this.idRequirement.isPresent() == false) goto L23;
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        L23:
            return new JwtRsaSsaPkcs1PublicKey(this.parameters.get(), this.modulus.get(), this.idRequirement, computeKid(), null);
        L25:
            throw new GeneralSecurityException("Got modulus size " + r0 + ", but parameters requires modulus size " + r1);
        L27:
            throw new GeneralSecurityException("Cannot build without modulus");
        L29:
            throw new GeneralSecurityException("Cannot build without parameters");
        }
    }

    /* synthetic */ JwtRsaSsaPkcs1PublicKey(JwtRsaSsaPkcs1Parameters r1, BigInteger r2, Optional r3, Optional r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePublicKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePublicKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ JwtSignatureParameters getParameters() {
        return getParameters();
    }

    private JwtRsaSsaPkcs1PublicKey(JwtRsaSsaPkcs1Parameters parameters, BigInteger modulus, Optional<Integer> idRequirement, Optional<String> kid) {
        this.parameters = parameters;
        this.modulus = modulus;
        this.idRequirement = idRequirement;
        this.kid = kid;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePublicKey
    public Optional<String> getKid() {
        return this.kid;
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePublicKey, com.google.crypto.tink.Key
    public JwtRsaSsaPkcs1Parameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement.orElse(null);
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof JwtRsaSsaPkcs1PublicKey) == true) goto L5;
        return false;
    L5:
        JwtRsaSsaPkcs1PublicKey r4 = (JwtRsaSsaPkcs1PublicKey) o;
        if (r4.parameters.equals(this.parameters) == true) goto L8;
        return false;
    L8:
        if (r4.modulus.equals(this.modulus) == true) goto L10;
        return false;
    L10:
        if (r4.kid.equals(this.kid) == true) goto L12;
        return false;
    L12:
        if (r4.idRequirement.equals(this.idRequirement) == false) goto L18;
        return true;
    L18:
        return false;
    }
}
