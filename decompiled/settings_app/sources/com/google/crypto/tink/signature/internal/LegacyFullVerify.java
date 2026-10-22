package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class LegacyFullVerify implements PublicKeyVerify {
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;
    private final PublicKeyVerify rawVerifier;

    /* JADX INFO: renamed from: com.google.crypto.tink.signature.internal.LegacyFullVerify$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = null;

        static {
            int[] r0 = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = r0;
            r0[OutputPrefixType.LEGACY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.TINK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static PublicKeyVerify create(LegacyProtoKey key) throws GeneralSecurityException {
        ProtoKeySerialization r3 = key.getSerialization(InsecureSecretKeyAccess.get());
        return new LegacyFullVerify((PublicKeyVerify) Registry.getPrimitive((KeyData) KeyData.newBuilder().setTypeUrl(r3.getTypeUrl()).setValue(r3.getValue()).setKeyMaterialType(r3.getKeyMaterialType()).build(), PublicKeyVerify.class), getOutputPrefix(r3), getMessageSuffix(r3));
    }

    static byte[] getOutputPrefix(ProtoKeySerialization key) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[key.getOutputPrefixType().ordinal()];
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L13;
        return new byte[0];
    L13:
        throw new GeneralSecurityException("unknown output prefix type");
    L15:
        return ByteBuffer.allocate(5).put((byte) 1).putInt(key.getIdRequirementOrNull().intValue()).array();
    L17:
        return ByteBuffer.allocate(5).put((byte) 0).putInt(key.getIdRequirementOrNull().intValue()).array();
    }

    static byte[] getMessageSuffix(ProtoKeySerialization key) {
        if (key.getOutputPrefixType().equals(OutputPrefixType.LEGACY) == false) goto L7;
        return new byte[]{0};
    L7:
        return new byte[0];
    }

    private LegacyFullVerify(PublicKeyVerify rawVerifier, byte[] outputPrefix, byte[] messageSuffix) {
        this.rawVerifier = rawVerifier;
        this.outputPrefix = outputPrefix;
        this.messageSuffix = messageSuffix;
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(byte[] signature, byte[] data) throws GeneralSecurityException {
        byte[] r0 = this.outputPrefix;
        if (r0.length != 0) goto L9;
        if (this.messageSuffix.length != 0) goto L9;
        this.rawVerifier.verify(signature, data);
        return;
    L9:
        if (Util.isPrefix(r0, signature) == false) goto L16;
        byte[] r1 = this.messageSuffix;
        if (r1.length == 0) goto L13;
        data = Bytes.concat(new byte[][]{data, r1});
    L13:
        this.rawVerifier.verify(Arrays.copyOfRange(signature, this.outputPrefix.length, signature.length), data);
        return;
    L16:
        throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
    }
}
