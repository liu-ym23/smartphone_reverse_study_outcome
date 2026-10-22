package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class ChaCha20Poly1305Key extends AeadKey {

    @Nullable
    private final Integer idRequirement;
    private final SecretBytes keyBytes;
    private final Bytes outputPrefix;
    private final ChaCha20Poly1305Parameters parameters;

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ AeadParameters getParameters() {
        return getParameters();
    }

    private ChaCha20Poly1305Key(ChaCha20Poly1305Parameters parameters, SecretBytes keyBytes, Bytes outputPrefix, @Nullable Integer idRequirement) {
        this.parameters = parameters;
        this.keyBytes = keyBytes;
        this.outputPrefix = outputPrefix;
        this.idRequirement = idRequirement;
    }

    private static Bytes getOutputPrefix(ChaCha20Poly1305Parameters parameters, @Nullable Integer idRequirement) {
        if (parameters.getVariant() != ChaCha20Poly1305Parameters.Variant.NO_PREFIX) goto L7;
        return OutputPrefixUtil.EMPTY_PREFIX;
    L7:
        if (parameters.getVariant() != ChaCha20Poly1305Parameters.Variant.CRUNCHY) goto L11;
        return OutputPrefixUtil.getLegacyOutputPrefix(idRequirement.intValue());
    L11:
        if (parameters.getVariant() != ChaCha20Poly1305Parameters.Variant.TINK) goto L15;
        return OutputPrefixUtil.getTinkOutputPrefix(idRequirement.intValue());
    L15:
        throw new IllegalStateException("Unknown Variant: " + parameters.getVariant());
    }

    @Override // com.google.crypto.tink.aead.AeadKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    public static ChaCha20Poly1305Key create(SecretBytes secretBytes) throws GeneralSecurityException {
        return create(ChaCha20Poly1305Parameters.Variant.NO_PREFIX, secretBytes, null);
    }

    public static ChaCha20Poly1305Key create(ChaCha20Poly1305Parameters.Variant variant, SecretBytes secretBytes, @Nullable Integer idRequirement) throws GeneralSecurityException {
        if (variant == ChaCha20Poly1305Parameters.Variant.NO_PREFIX) goto L9;
        if (idRequirement != null) goto L9;
        throw new GeneralSecurityException("For given Variant " + variant + " the value of idRequirement must be non-null");
    L9:
        if (variant != ChaCha20Poly1305Parameters.Variant.NO_PREFIX) goto L15;
        if (idRequirement == null) goto L15;
        throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
    L15:
        if (secretBytes.size() != 32) goto L19;
        ChaCha20Poly1305Parameters r2 = ChaCha20Poly1305Parameters.create(variant);
        return new ChaCha20Poly1305Key(r2, secretBytes, getOutputPrefix(r2, idRequirement), idRequirement);
    L19:
        throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + secretBytes.size());
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public ChaCha20Poly1305Parameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof ChaCha20Poly1305Key) == true) goto L5;
        return false;
    L5:
        ChaCha20Poly1305Key r4 = (ChaCha20Poly1305Key) o;
        if (r4.parameters.equals(this.parameters) == true) goto L8;
        return false;
    L8:
        if (r4.keyBytes.equalsSecretBytes(this.keyBytes) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(r4.idRequirement, this.idRequirement) == false) goto L15;
        return true;
    L15:
        return false;
    }
}
