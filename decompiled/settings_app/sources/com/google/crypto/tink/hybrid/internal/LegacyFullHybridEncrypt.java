package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class LegacyFullHybridEncrypt implements HybridEncrypt {
    private final byte[] outputPrefix;
    private final HybridEncrypt rawHybridEncrypt;

    /* JADX INFO: renamed from: com.google.crypto.tink.hybrid.internal.LegacyFullHybridEncrypt$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = null;

        static {
            int[] r0 = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = r0;
            r0[OutputPrefixType.RAW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.TINK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static HybridEncrypt create(LegacyProtoKey key) throws GeneralSecurityException {
        ProtoKeySerialization r0 = key.getSerialization(InsecureSecretKeyAccess.get());
        HybridEncrypt r1 = (HybridEncrypt) Registry.getPrimitive((KeyData) KeyData.newBuilder().setTypeUrl(r0.getTypeUrl()).setValue(r0.getValue()).setKeyMaterialType(r0.getKeyMaterialType()).build(), HybridEncrypt.class);
        OutputPrefixType r2 = r0.getOutputPrefixType();
        int r3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[r2.ordinal()];
        if (r3 != 1) goto L5;
        byte[] r7 = new byte[0];
    L16:
        return new LegacyFullHybridEncrypt(r1, r7);
    L5:
        if (r3 != 2) goto L7;
    L13:
        r7 = ByteBuffer.allocate(5).put((byte) 0).putInt(key.getIdRequirementOrNull().intValue()).array();
        goto L16
    L7:
        if (r3 == 3) goto L13;
        if (r3 != 4) goto L12;
        r7 = ByteBuffer.allocate(5).put((byte) 1).putInt(key.getIdRequirementOrNull().intValue()).array();
        goto L16
    L12:
        throw new GeneralSecurityException("unknown output prefix type " + r2);
    }

    private LegacyFullHybridEncrypt(HybridEncrypt rawHybridEncrypt, byte[] outputPrefix) {
        this.rawHybridEncrypt = rawHybridEncrypt;
        this.outputPrefix = outputPrefix;
    }

    @Override // com.google.crypto.tink.HybridEncrypt
    public byte[] encrypt(final byte[] plaintext, final byte[] contextInfo) throws GeneralSecurityException {
        byte[] r0 = this.outputPrefix;
        if (r0.length != 0) goto L7;
        return this.rawHybridEncrypt.encrypt(plaintext, contextInfo);
    L7:
        return Bytes.concat(new byte[][]{r0, this.rawHybridEncrypt.encrypt(plaintext, contextInfo)});
    }
}
