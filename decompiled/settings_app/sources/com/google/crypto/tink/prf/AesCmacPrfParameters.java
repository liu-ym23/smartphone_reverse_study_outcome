package com.google.crypto.tink.prf;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class AesCmacPrfParameters extends PrfParameters {
    private final int keySizeBytes;

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return false;
    }

    public static AesCmacPrfParameters create(int keySizeBytes) throws GeneralSecurityException {
        if (keySizeBytes == 16) goto L10;
        if (keySizeBytes == 32) goto L10;
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit are supported", new Object[]{Integer.valueOf(keySizeBytes * 8)}));
    L10:
        return new AesCmacPrfParameters(keySizeBytes);
    }

    private AesCmacPrfParameters(int keySizeBytes) {
        this.keySizeBytes = keySizeBytes;
    }

    public int getKeySizeBytes() {
        return this.keySizeBytes;
    }

    public boolean equals(Object o) {
        if ((o instanceof AesCmacPrfParameters) == true) goto L6;
        return false;
    L6:
        if (((AesCmacPrfParameters) o).getKeySizeBytes() != getKeySizeBytes()) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{AesCmacPrfParameters.class, Integer.valueOf(this.keySizeBytes)});
    }

    public String toString() {
        return "AesCmac PRF Parameters (" + this.keySizeBytes + "-byte key)";
    }
}
