package com.google.crypto.tink.keyderivation;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;

/* JADX INFO: loaded from: classes4.dex */
public abstract class KeyDerivationKey extends Key {
    @Override // com.google.crypto.tink.Key
    public abstract KeyDerivationParameters getParameters();

    public KeyDerivationKey() {
    }

    @Override // com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }
}
