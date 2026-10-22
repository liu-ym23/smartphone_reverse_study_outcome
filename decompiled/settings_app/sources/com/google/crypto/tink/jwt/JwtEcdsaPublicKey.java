package com.google.crypto.tink.jwt;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.crypto.tink.subtle.Base64;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import java.util.Optional;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class JwtEcdsaPublicKey extends JwtSignaturePublicKey {
    private final Optional<Integer> idRequirement;
    private final Optional<String> kid;
    private final JwtEcdsaParameters parameters;
    private final ECPoint publicPoint;

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtEcdsaPublicKey$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private Optional<String> customKid;
        private Optional<Integer> idRequirement;
        private Optional<JwtEcdsaParameters> parameters;
        private Optional<ECPoint> publicPoint;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.parameters = Optional.empty();
            this.publicPoint = Optional.empty();
            this.idRequirement = Optional.empty();
            this.customKid = Optional.empty();
        }

        public Builder setParameters(JwtEcdsaParameters parameters) {
            this.parameters = Optional.of(parameters);
            return this;
        }

        public Builder setPublicPoint(ECPoint publicPoint) {
            this.publicPoint = Optional.of(publicPoint);
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
            if (this.parameters.get().getKidStrategy().equals(JwtEcdsaParameters.KidStrategy.BASE64_ENCODED_KEY_ID) == false) goto L11;
            if (this.customKid.isPresent() == true) goto L9;
            return Optional.of(Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(this.idRequirement.get().intValue()).array()));
        L9:
            throw new GeneralSecurityException("customKid must not be set for KidStrategy BASE64_ENCODED_KEY_ID");
        L11:
            if (this.parameters.get().getKidStrategy().equals(JwtEcdsaParameters.KidStrategy.CUSTOM) == false) goto L19;
            if (this.customKid.isPresent() == false) goto L17;
            return this.customKid;
        L17:
            throw new GeneralSecurityException("customKid needs to be set for KidStrategy CUSTOM");
        L19:
            if (this.parameters.get().getKidStrategy().equals(JwtEcdsaParameters.KidStrategy.IGNORED) == false) goto L27;
            if (this.customKid.isPresent() == true) goto L25;
            return Optional.empty();
        L25:
            throw new GeneralSecurityException("customKid must not be set for KidStrategy IGNORED");
        L27:
            throw new IllegalStateException("Unknown kid strategy");
        }

        public JwtEcdsaPublicKey build() throws GeneralSecurityException {
            if (this.parameters.isPresent() == false) goto L25;
            if (this.publicPoint.isPresent() == false) goto L23;
            EllipticCurvesUtil.checkPointOnCurve(this.publicPoint.get(), this.parameters.get().getAlgorithm().getECParameterSpec().getCurve());
            if (this.parameters.get().hasIdRequirement() == false) goto L14;
            if (this.idRequirement.isPresent() == true) goto L14;
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        L14:
            if (this.parameters.get().hasIdRequirement() == true) goto L21;
            if (this.idRequirement.isPresent() == false) goto L21;
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        L21:
            return new JwtEcdsaPublicKey(this.parameters.get(), this.publicPoint.get(), computeKid(), this.idRequirement, null);
        L23:
            throw new GeneralSecurityException("Cannot build without public point");
        L25:
            throw new GeneralSecurityException("Cannot build without parameters");
        }
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePublicKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePublicKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ JwtSignatureParameters getParameters() {
        return getParameters();
    }

    /* synthetic */ JwtEcdsaPublicKey(JwtEcdsaParameters r1, ECPoint r2, Optional r3, Optional r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    private JwtEcdsaPublicKey(JwtEcdsaParameters parameters, ECPoint publicPoint, Optional<String> kid, Optional<Integer> idRequirement) {
        this.parameters = parameters;
        this.publicPoint = publicPoint;
        this.kid = kid;
        this.idRequirement = idRequirement;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public ECPoint getPublicPoint() {
        return this.publicPoint;
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePublicKey
    public Optional<String> getKid() {
        return this.kid;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement.orElse(null);
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePublicKey, com.google.crypto.tink.Key
    public JwtEcdsaParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof JwtEcdsaPublicKey) == true) goto L5;
        return false;
    L5:
        JwtEcdsaPublicKey r4 = (JwtEcdsaPublicKey) o;
        if (r4.parameters.equals(this.parameters) == true) goto L8;
        return false;
    L8:
        if (r4.publicPoint.equals(this.publicPoint) == true) goto L10;
        return false;
    L10:
        if (r4.kid.equals(this.kid) == false) goto L15;
        return true;
    L15:
        return false;
    }
}
