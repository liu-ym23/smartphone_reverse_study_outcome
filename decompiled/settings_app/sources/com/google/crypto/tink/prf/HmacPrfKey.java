package com.google.crypto.tink.prf;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class HmacPrfKey extends PrfKey {
    private final SecretBytes keyBytes;
    private final HmacPrfParameters parameters;

    /* JADX INFO: renamed from: com.google.crypto.tink.prf.HmacPrfKey$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {

        @Nullable
        private SecretBytes keyBytes;

        @Nullable
        private HmacPrfParameters parameters;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.parameters = null;
            this.keyBytes = null;
        }

        public Builder setParameters(HmacPrfParameters parameters) {
            this.parameters = parameters;
            return this;
        }

        public Builder setKeyBytes(SecretBytes keyBytes) {
            this.keyBytes = keyBytes;
            return this;
        }

        public HmacPrfKey build() throws GeneralSecurityException {
            HmacPrfParameters r0 = this.parameters;
            if (r0 == null) goto L13;
            if (this.keyBytes == null) goto L13;
            if (r0.getKeySizeBytes() != this.keyBytes.size()) goto L11;
            return new HmacPrfKey(this.parameters, this.keyBytes, null);
        L11:
            throw new GeneralSecurityException("Key size mismatch");
        L13:
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
    }

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

    /* synthetic */ HmacPrfKey(HmacPrfParameters r1, SecretBytes r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    private HmacPrfKey(HmacPrfParameters parameters, SecretBytes keyBytes) {
        this.parameters = parameters;
        this.keyBytes = keyBytes;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    @Override // com.google.crypto.tink.prf.PrfKey, com.google.crypto.tink.Key
    public HmacPrfParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof HmacPrfKey) == true) goto L5;
        return false;
    L5:
        HmacPrfKey r4 = (HmacPrfKey) o;
        if (r4.parameters.equals(this.parameters) == true) goto L8;
        return false;
    L8:
        if (r4.keyBytes.equalsSecretBytes(this.keyBytes) == false) goto L12;
        return true;
    L12:
        return false;
    }
}
