package com.google.crypto.tink.keyderivation;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.prf.PrfKey;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class PrfBasedKeyDerivationKey extends KeyDerivationKey {
    private final Integer idRequirementOrNull;
    private final PrfBasedKeyDerivationParameters parameters;
    private final PrfKey prfKey;

    @Override // com.google.crypto.tink.keyderivation.KeyDerivationKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.keyderivation.KeyDerivationKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ KeyDerivationParameters getParameters() {
        return getParameters();
    }

    public static PrfBasedKeyDerivationKey create(PrfBasedKeyDerivationParameters parameters, PrfKey prfKey, @Nullable Integer idRequirement) throws GeneralSecurityException {
        if (parameters.getPrfParameters().equals(prfKey.getParameters()) == false) goto L19;
        if (parameters.getDerivedKeyParameters().hasIdRequirement() == false) goto L11;
        if (idRequirement != null) goto L11;
        throw new GeneralSecurityException("Derived key has an ID requirement, but no idRequirement was passed in on creation of this key");
    L11:
        if (parameters.getDerivedKeyParameters().hasIdRequirement() == true) goto L17;
        if (idRequirement == null) goto L17;
        throw new GeneralSecurityException("Derived key has no ID requirement, but idRequirement was passed in on creation of this key");
    L17:
        return new PrfBasedKeyDerivationKey(parameters, prfKey, idRequirement);
    L19:
        throw new GeneralSecurityException("PrfParameters of passed in PrfBasedKeyDerivationParameters and passed in prfKey parameters object must match. DerivationParameters gave: " + parameters.getPrfParameters() + ", key gives: " + prfKey.getParameters());
    }

    private PrfBasedKeyDerivationKey(PrfBasedKeyDerivationParameters parameters, PrfKey prfKey, @Nullable Integer idRequirement) {
        this.parameters = parameters;
        this.prfKey = prfKey;
        this.idRequirementOrNull = idRequirement;
    }

    public PrfKey getPrfKey() {
        return this.prfKey;
    }

    @Override // com.google.crypto.tink.keyderivation.KeyDerivationKey, com.google.crypto.tink.Key
    public PrfBasedKeyDerivationParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirementOrNull;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key other) {
        if ((other instanceof PrfBasedKeyDerivationKey) == true) goto L5;
        return false;
    L5:
        PrfBasedKeyDerivationKey r4 = (PrfBasedKeyDerivationKey) other;
        if (r4.getParameters().equals(getParameters()) == true) goto L8;
        return false;
    L8:
        if (r4.prfKey.equalsKey(this.prfKey) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(r4.idRequirementOrNull, this.idRequirementOrNull) == false) goto L15;
        return true;
    L15:
        return false;
    }
}
