package com.google.crypto.tink.tinkkey.internal;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.tinkkey.TinkKey;
import com.google.errorprone.annotations.Immutable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class ProtoKey implements TinkKey {
    private final boolean hasSecret;
    private final KeyData keyData;
    private final KeyTemplate.OutputPrefixType outputPrefixType;

    public ProtoKey(KeyData keyData, KeyTemplate.OutputPrefixType opt) {
        this.hasSecret = isSecret(keyData);
        this.keyData = keyData;
        this.outputPrefixType = opt;
    }

    private static boolean isSecret(KeyData keyData) {
        if (keyData.getKeyMaterialType() != KeyData.KeyMaterialType.UNKNOWN_KEYMATERIAL) goto L5;
    L10:
        return true;
    L5:
        if (keyData.getKeyMaterialType() == KeyData.KeyMaterialType.SYMMETRIC) goto L10;
        if (keyData.getKeyMaterialType() == KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) goto L10;
        return false;
    }

    public KeyData getProtoKey() {
        return this.keyData;
    }

    public KeyTemplate.OutputPrefixType getOutputPrefixType() {
        return this.outputPrefixType;
    }

    @Override // com.google.crypto.tink.tinkkey.TinkKey
    public boolean hasSecret() {
        return this.hasSecret;
    }

    @Override // com.google.crypto.tink.tinkkey.TinkKey
    public KeyTemplate getKeyTemplate() {
        throw new UnsupportedOperationException();
    }
}
