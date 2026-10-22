package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.RegistryConfiguration;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.util.Bytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class LegacyFullAead implements Aead {
    private final byte[] identifier;
    private final Aead rawAead;

    /* JADX INFO: renamed from: com.google.crypto.tink.aead.internal.LegacyFullAead$1, reason: invalid class name */
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

    public static Aead create(LegacyProtoKey key) throws GeneralSecurityException {
        ProtoKeySerialization r0 = key.getSerialization(InsecureSecretKeyAccess.get());
        Aead r1 = (Aead) RegistryConfiguration.get().getLegacyPrimitive((KeyData) KeyData.newBuilder().setTypeUrl(r0.getTypeUrl()).setValue(r0.getValue()).setKeyMaterialType(r0.getKeyMaterialType()).build(), Aead.class);
        OutputPrefixType r2 = r0.getOutputPrefixType();
        int r3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[r2.ordinal()];
        if (r3 != 1) goto L5;
        byte[] r7 = new byte[0];
    L16:
        return new LegacyFullAead(r1, r7);
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

    public static Aead create(Aead rawAead, Bytes outputPrefix) {
        return new LegacyFullAead(rawAead, outputPrefix.toByteArray());
    }

    private LegacyFullAead(Aead rawAead, byte[] identifier) {
        this.rawAead = rawAead;
        if (identifier.length != 0) goto L5;
    L9:
        this.identifier = identifier;
        return;
    L5:
        if (identifier.length == 5) goto L9;
        throw new IllegalArgumentException("identifier has an invalid length");
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(byte[] plaintext, byte[] associatedData) throws GeneralSecurityException {
        byte[] r0 = this.identifier;
        if (r0.length != 0) goto L7;
        return this.rawAead.encrypt(plaintext, associatedData);
    L7:
        return com.google.crypto.tink.subtle.Bytes.concat(new byte[][]{r0, this.rawAead.encrypt(plaintext, associatedData)});
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(byte[] ciphertext, byte[] associatedData) throws GeneralSecurityException {
        byte[] r0 = this.identifier;
        if (r0.length != 0) goto L7;
        return this.rawAead.decrypt(ciphertext, associatedData);
    L7:
        if (Util.isPrefix(r0, ciphertext) == false) goto L11;
        return this.rawAead.decrypt(Arrays.copyOfRange(ciphertext, 5, ciphertext.length), associatedData);
    L11:
        throw new GeneralSecurityException("wrong prefix");
    }
}
