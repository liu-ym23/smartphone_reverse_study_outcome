package com.google.crypto.tink.prf;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PrfKey extends Key {
    @Override // com.google.crypto.tink.Key
    public abstract PrfParameters getParameters();

    public PrfKey() {
    }

    @Override // com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }
}
