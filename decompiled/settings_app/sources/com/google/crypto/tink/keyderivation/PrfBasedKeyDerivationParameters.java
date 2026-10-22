package com.google.crypto.tink.keyderivation;

import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.prf.PrfParameters;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class PrfBasedKeyDerivationParameters extends KeyDerivationParameters {
    private final Parameters derivedKeyParameters;
    private final PrfParameters prfParameters;

    /* JADX INFO: renamed from: com.google.crypto.tink.keyderivation.PrfBasedKeyDerivationParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        @Nullable
        private Parameters derivedKeyParameters;

        @Nullable
        private PrfParameters prfParameters;

        public Builder() {
            this.prfParameters = null;
            this.derivedKeyParameters = null;
        }

        public Builder setPrfParameters(PrfParameters prfParameters) {
            this.prfParameters = prfParameters;
            return this;
        }

        public Builder setDerivedKeyParameters(Parameters derivedKeyParameters) {
            this.derivedKeyParameters = derivedKeyParameters;
            return this;
        }

        public PrfBasedKeyDerivationParameters build() throws GeneralSecurityException {
            if (this.prfParameters == null) goto L11;
            if (this.derivedKeyParameters == null) goto L9;
            return new PrfBasedKeyDerivationParameters(this.prfParameters, this.derivedKeyParameters, null);
        L9:
            throw new GeneralSecurityException("DerivedKeyParameters must be set.");
        L11:
            throw new GeneralSecurityException("PrfParameters must be set.");
        }
    }

    /* synthetic */ PrfBasedKeyDerivationParameters(PrfParameters r1, Parameters r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    private PrfBasedKeyDerivationParameters(PrfParameters prfParameters, Parameters derivedKeyParameters) {
        this.prfParameters = prfParameters;
        this.derivedKeyParameters = derivedKeyParameters;
    }

    public static Builder builder() {
        return new Builder();
    }

    public PrfParameters getPrfParameters() {
        return this.prfParameters;
    }

    @Override // com.google.crypto.tink.keyderivation.KeyDerivationParameters
    public Parameters getDerivedKeyParameters() {
        return this.derivedKeyParameters;
    }

    public boolean equals(Object o) {
        if ((o instanceof PrfBasedKeyDerivationParameters) == true) goto L5;
        return false;
    L5:
        PrfBasedKeyDerivationParameters r4 = (PrfBasedKeyDerivationParameters) o;
        if (r4.getPrfParameters().equals(getPrfParameters()) == true) goto L8;
        return false;
    L8:
        if (r4.getDerivedKeyParameters().equals(getDerivedKeyParameters()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{PrfBasedKeyDerivationParameters.class, this.prfParameters, this.derivedKeyParameters});
    }

    public String toString() {
        return String.format("PrfBasedKeyDerivationParameters(%s, %s)", new Object[]{this.prfParameters, this.derivedKeyParameters});
    }
}
