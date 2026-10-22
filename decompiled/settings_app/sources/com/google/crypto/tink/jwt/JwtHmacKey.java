package com.google.crypto.tink.jwt;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.subtle.Base64;
import com.google.crypto.tink.util.SecretBytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Optional;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class JwtHmacKey extends JwtMacKey {
    private final Optional<Integer> idRequirement;
    private final SecretBytes key;
    private final Optional<String> kid;
    private final JwtHmacParameters parameters;

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtHmacKey$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private Optional<String> customKid;
        private Optional<Integer> idRequirement;
        private Optional<SecretBytes> keyBytes;
        private Optional<JwtHmacParameters> parameters;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.parameters = Optional.empty();
            this.keyBytes = Optional.empty();
            this.idRequirement = Optional.empty();
            this.customKid = Optional.empty();
        }

        public Builder setParameters(JwtHmacParameters parameters) {
            this.parameters = Optional.of(parameters);
            return this;
        }

        public Builder setKeyBytes(SecretBytes keyBytes) {
            this.keyBytes = Optional.of(keyBytes);
            return this;
        }

        public Builder setIdRequirement(int idRequirement) {
            this.idRequirement = Optional.of(Integer.valueOf(idRequirement));
            return this;
        }

        public Builder setCustomKid(String customKid) {
            this.customKid = Optional.of(customKid);
            return this;
        }

        private Optional<String> computeKid() throws GeneralSecurityException {
            if (this.parameters.get().getKidStrategy().equals(JwtHmacParameters.KidStrategy.BASE64_ENCODED_KEY_ID) == false) goto L11;
            byte[] r0 = ByteBuffer.allocate(4).putInt(this.idRequirement.get().intValue()).array();
            if (this.customKid.isPresent() == true) goto L9;
            return Optional.of(Base64.urlSafeEncode(r0));
        L9:
            throw new GeneralSecurityException("customKid must not be set for KidStrategy BASE64_ENCODED_KEY_ID");
        L11:
            if (this.parameters.get().getKidStrategy().equals(JwtHmacParameters.KidStrategy.CUSTOM) == false) goto L19;
            if (this.customKid.isPresent() == false) goto L17;
            return this.customKid;
        L17:
            throw new GeneralSecurityException("customKid needs to be set for KidStrategy CUSTOM");
        L19:
            if (this.parameters.get().getKidStrategy().equals(JwtHmacParameters.KidStrategy.IGNORED) == false) goto L27;
            if (this.customKid.isPresent() == true) goto L25;
            return Optional.empty();
        L25:
            throw new GeneralSecurityException("customKid must not be set for KidStrategy IGNORED");
        L27:
            throw new IllegalStateException("Unknown kid strategy");
        }

        public JwtHmacKey build() throws GeneralSecurityException {
            if (this.parameters.isPresent() == false) goto L29;
            if (this.keyBytes.isPresent() == false) goto L27;
            if (this.parameters.get().getKeySizeBytes() != this.keyBytes.get().size()) goto L25;
            if (this.parameters.get().hasIdRequirement() == false) goto L16;
            if (this.idRequirement.isPresent() == true) goto L16;
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        L16:
            if (this.parameters.get().hasIdRequirement() == true) goto L23;
            if (this.idRequirement.isPresent() == false) goto L23;
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        L23:
            return new JwtHmacKey(this.parameters.get(), this.keyBytes.get(), this.idRequirement, computeKid(), null);
        L25:
            throw new GeneralSecurityException("Key size mismatch");
        L27:
            throw new GeneralSecurityException("KeyBytes are required");
        L29:
            throw new GeneralSecurityException("Parameters are required");
        }
    }

    /* synthetic */ JwtHmacKey(JwtHmacParameters r1, SecretBytes r2, Optional r3, Optional r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    @Override // com.google.crypto.tink.jwt.JwtMacKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.jwt.JwtMacKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ JwtMacParameters getParameters() {
        return getParameters();
    }

    public static Builder builder() {
        return new Builder(null);
    }

    private JwtHmacKey(JwtHmacParameters parameters, SecretBytes key, Optional<Integer> idRequirement, Optional<String> kid) {
        this.parameters = parameters;
        this.key = key;
        this.idRequirement = idRequirement;
        this.kid = kid;
    }

    public SecretBytes getKeyBytes() {
        return this.key;
    }

    @Override // com.google.crypto.tink.jwt.JwtMacKey
    public Optional<String> getKid() {
        return this.kid;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement.orElse(null);
    }

    @Override // com.google.crypto.tink.jwt.JwtMacKey, com.google.crypto.tink.Key
    public JwtHmacParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof JwtHmacKey) == true) goto L5;
        return false;
    L5:
        JwtHmacKey r4 = (JwtHmacKey) o;
        if (r4.parameters.equals(this.parameters) == true) goto L8;
        return false;
    L8:
        if (r4.key.equalsSecretBytes(this.key) == true) goto L10;
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
