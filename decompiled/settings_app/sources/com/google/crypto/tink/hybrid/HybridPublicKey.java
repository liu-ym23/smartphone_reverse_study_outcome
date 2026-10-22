package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public abstract class HybridPublicKey extends Key {
    public abstract Bytes getOutputPrefix();

    @Override // com.google.crypto.tink.Key
    public abstract HybridParameters getParameters();

    @Override // com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    public HybridPublicKey() {
    }
}
