package com.google.crypto.tink.jwt;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.PrivateKey;
import com.google.errorprone.annotations.Immutable;
import java.util.Optional;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public abstract class JwtSignaturePrivateKey extends Key implements PrivateKey {
    @Override // com.google.crypto.tink.Key
    public abstract JwtSignatureParameters getParameters();

    public abstract JwtSignaturePublicKey getPublicKey();

    @Override // com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    public /* bridge */ /* synthetic */ Key getPublicKey() {
        return getPublicKey();
    }

    public JwtSignaturePrivateKey() {
    }

    public Optional<String> getKid() {
        return getPublicKey().getKid();
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return getPublicKey().getIdRequirementOrNull();
    }
}
