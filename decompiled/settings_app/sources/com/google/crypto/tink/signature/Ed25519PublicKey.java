package com.google.crypto.tink.signature;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class Ed25519PublicKey extends SignaturePublicKey {

    @Nullable
    private final Integer idRequirement;
    private final Bytes outputPrefix;
    private final Ed25519Parameters parameters;
    private final Bytes publicKeyBytes;

    @Override // com.google.crypto.tink.signature.SignaturePublicKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.signature.SignaturePublicKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ SignatureParameters getParameters() {
        return getParameters();
    }

    private Ed25519PublicKey(Ed25519Parameters parameters, Bytes publicKeyBytes, Bytes outputPrefix, @Nullable Integer idRequirement) {
        this.parameters = parameters;
        this.publicKeyBytes = publicKeyBytes;
        this.outputPrefix = outputPrefix;
        this.idRequirement = idRequirement;
    }

    private static Bytes createOutputPrefix(Ed25519Parameters parameters, @Nullable Integer idRequirement) {
        if (parameters.getVariant() != Ed25519Parameters.Variant.NO_PREFIX) goto L7;
        return OutputPrefixUtil.EMPTY_PREFIX;
    L7:
        if (parameters.getVariant() == Ed25519Parameters.Variant.CRUNCHY) goto L18;
        if (parameters.getVariant() == Ed25519Parameters.Variant.LEGACY) goto L18;
        if (parameters.getVariant() != Ed25519Parameters.Variant.TINK) goto L16;
        return OutputPrefixUtil.getTinkOutputPrefix(idRequirement.intValue());
    L16:
        throw new IllegalStateException("Unknown Variant: " + parameters.getVariant());
    L18:
        return OutputPrefixUtil.getLegacyOutputPrefix(idRequirement.intValue());
    }

    @Override // com.google.crypto.tink.signature.SignaturePublicKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    public static Ed25519PublicKey create(Bytes publicKeyBytes) throws GeneralSecurityException {
        return create(Ed25519Parameters.Variant.NO_PREFIX, publicKeyBytes, null);
    }

    public static Ed25519PublicKey create(Ed25519Parameters.Variant variant, Bytes publicKeyBytes, @Nullable Integer idRequirement) throws GeneralSecurityException {
        Ed25519Parameters r0 = Ed25519Parameters.create(variant);
        if (variant.equals(Ed25519Parameters.Variant.NO_PREFIX) == true) goto L9;
        if (idRequirement != null) goto L9;
        throw new GeneralSecurityException("For given Variant " + variant + " the value of idRequirement must be non-null");
    L9:
        if (variant.equals(Ed25519Parameters.Variant.NO_PREFIX) == false) goto L15;
        if (idRequirement == null) goto L15;
        throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
    L15:
        if (publicKeyBytes.size() != 32) goto L19;
        return new Ed25519PublicKey(r0, publicKeyBytes, createOutputPrefix(r0, idRequirement), idRequirement);
    L19:
        throw new GeneralSecurityException("Ed25519 key must be constructed with key of length 32 bytes, not " + publicKeyBytes.size());
    }

    public Bytes getPublicKeyBytes() {
        return this.publicKeyBytes;
    }

    @Override // com.google.crypto.tink.signature.SignaturePublicKey, com.google.crypto.tink.Key
    public Ed25519Parameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof Ed25519PublicKey) == true) goto L5;
        return false;
    L5:
        Ed25519PublicKey r4 = (Ed25519PublicKey) o;
        if (r4.parameters.equals(this.parameters) == true) goto L8;
        return false;
    L8:
        if (r4.publicKeyBytes.equals(this.publicKeyBytes) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(r4.idRequirement, this.idRequirement) == false) goto L15;
        return true;
    L15:
        return false;
    }
}
