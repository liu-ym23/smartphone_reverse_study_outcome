package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class LegacyFullSign implements PublicKeySign {
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;
    private final PublicKeySign rawSigner;

    public static PublicKeySign create(LegacyProtoKey key) throws GeneralSecurityException {
        ProtoKeySerialization r3 = key.getSerialization(InsecureSecretKeyAccess.get());
        return new LegacyFullSign((PublicKeySign) Registry.getPrimitive((KeyData) KeyData.newBuilder().setTypeUrl(r3.getTypeUrl()).setValue(r3.getValue()).setKeyMaterialType(r3.getKeyMaterialType()).build(), PublicKeySign.class), LegacyFullVerify.getOutputPrefix(r3), LegacyFullVerify.getMessageSuffix(r3));
    }

    private LegacyFullSign(PublicKeySign rawSigner, byte[] outputPrefix, byte[] messageSuffix) {
        this.rawSigner = rawSigner;
        this.outputPrefix = outputPrefix;
        this.messageSuffix = messageSuffix;
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(byte[] data) throws GeneralSecurityException {
        byte[] r0 = this.messageSuffix;
        if (r0.length != 0) goto L5;
        byte[] r7 = this.rawSigner.sign(data);
    L6:
        byte[] r6 = this.outputPrefix;
        if (r6.length != 0) goto L10;
        return r7;
    L10:
        return Bytes.concat(new byte[][]{r6, r7});
    L5:
        r7 = this.rawSigner.sign(Bytes.concat(new byte[][]{data, r0}));
        goto L6
    }
}
