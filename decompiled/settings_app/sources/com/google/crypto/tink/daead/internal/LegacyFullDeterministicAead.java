package com.google.crypto.tink.daead.internal;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.RegistryConfiguration;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class LegacyFullDeterministicAead implements DeterministicAead {
    private final byte[] identifier;
    private final OutputPrefixType outputPrefixType;
    private final DeterministicAead rawDaead;

    /* JADX INFO: renamed from: com.google.crypto.tink.daead.internal.LegacyFullDeterministicAead$1, reason: invalid class name */
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

    public static DeterministicAead create(LegacyProtoKey key) throws GeneralSecurityException {
        ProtoKeySerialization r0 = key.getSerialization(InsecureSecretKeyAccess.get());
        DeterministicAead r1 = (DeterministicAead) RegistryConfiguration.get().getLegacyPrimitive((KeyData) KeyData.newBuilder().setTypeUrl(r0.getTypeUrl()).setValue(r0.getValue()).setKeyMaterialType(r0.getKeyMaterialType()).build(), DeterministicAead.class);
        OutputPrefixType r2 = r0.getOutputPrefixType();
        int r3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[r2.ordinal()];
        if (r3 != 1) goto L5;
        byte[] r7 = new byte[0];
    L16:
        return new LegacyFullDeterministicAead(r1, r2, r7);
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
        throw new GeneralSecurityException("unknown output prefix type " + r2.getNumber());
    }

    private LegacyFullDeterministicAead(DeterministicAead rawDaead, OutputPrefixType outputPrefixType, byte[] identifier) {
        this.rawDaead = rawDaead;
        this.outputPrefixType = outputPrefixType;
        this.identifier = identifier;
    }

    @Override // com.google.crypto.tink.DeterministicAead
    public byte[] encryptDeterministically(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        if (this.outputPrefixType != OutputPrefixType.RAW) goto L7;
        return this.rawDaead.encryptDeterministically(plaintext, associatedData);
    L7:
        return Bytes.concat(new byte[][]{this.identifier, this.rawDaead.encryptDeterministically(plaintext, associatedData)});
    }

    @Override // com.google.crypto.tink.DeterministicAead
    public byte[] decryptDeterministically(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        if (this.outputPrefixType != OutputPrefixType.RAW) goto L7;
        return this.rawDaead.decryptDeterministically(ciphertext, associatedData);
    L7:
        if (Util.isPrefix(this.identifier, ciphertext) == false) goto L11;
        return this.rawDaead.decryptDeterministically(Arrays.copyOfRange(ciphertext, 5, ciphertext.length), associatedData);
    L11:
        throw new GeneralSecurityException("wrong prefix");
    }
}
