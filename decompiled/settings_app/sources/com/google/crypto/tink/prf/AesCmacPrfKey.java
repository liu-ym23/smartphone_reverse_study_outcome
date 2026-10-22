package com.google.crypto.tink.prf;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class AesCmacPrfKey extends PrfKey {
    private final SecretBytes keyBytes;
    private final AesCmacPrfParameters parameters;

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return null;
    }

    @Override // com.google.crypto.tink.prf.PrfKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.prf.PrfKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ PrfParameters getParameters() {
        return getParameters();
    }

    private AesCmacPrfKey(AesCmacPrfParameters parameters, SecretBytes keyBytes) {
        this.parameters = parameters;
        this.keyBytes = keyBytes;
    }

    public static AesCmacPrfKey create(AesCmacPrfParameters parameters, SecretBytes keyBytes) throws GeneralSecurityException {
        if (parameters.getKeySizeBytes() != keyBytes.size()) goto L7;
        return new AesCmacPrfKey(parameters, keyBytes);
    L7:
        throw new GeneralSecurityException("Key size mismatch");
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    @Override // com.google.crypto.tink.prf.PrfKey, com.google.crypto.tink.Key
    public AesCmacPrfParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof AesCmacPrfKey) == true) goto L5;
        return false;
    L5:
        AesCmacPrfKey r4 = (AesCmacPrfKey) o;
        if (r4.parameters.equals(this.parameters) == true) goto L8;
        return false;
    L8:
        if (r4.keyBytes.equalsSecretBytes(this.keyBytes) == false) goto L12;
        return true;
    L12:
        return false;
    }
}
