package com.google.crypto.tink.keyderivation;

import com.google.crypto.tink.Parameters;

/* JADX INFO: loaded from: classes4.dex */
public abstract class KeyDerivationParameters extends Parameters {
    public abstract Parameters getDerivedKeyParameters();

    public KeyDerivationParameters() {
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return getDerivedKeyParameters().hasIdRequirement();
    }
}
