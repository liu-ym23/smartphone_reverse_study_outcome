package com.google.crypto.tink.daead;

import com.google.crypto.tink.proto.AesSivKeyFormat;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class DeterministicAeadKeyTemplates {
    public static final KeyTemplate AES256_SIV = null;

    static {
        AES256_SIV = createAesSivKeyTemplate(64);
    }

    public static KeyTemplate createAesSivKeyTemplate(int keySize) {
        AesSivKeyFormat r1 = (AesSivKeyFormat) AesSivKeyFormat.newBuilder().setKeySize(keySize).build();
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(r1.toByteString()).setTypeUrl(AesSivKeyManager.getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).build();
    }

    private DeterministicAeadKeyTemplates() {
    }
}
