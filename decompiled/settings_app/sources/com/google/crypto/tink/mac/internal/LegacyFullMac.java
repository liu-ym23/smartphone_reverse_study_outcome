package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.RegistryConfiguration;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class LegacyFullMac implements Mac {
    private static final byte[] FORMAT_VERSION = null;
    static final int MIN_TAG_SIZE_IN_BYTES = 10;
    private final byte[] identifier;
    private final OutputPrefixType outputPrefixType;
    private final Mac rawMac;

    /* JADX INFO: renamed from: com.google.crypto.tink.mac.internal.LegacyFullMac$1, reason: invalid class name */
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

    static {
        FORMAT_VERSION = new byte[]{0};
    }

    public static Mac create(LegacyProtoKey key) throws GeneralSecurityException {
        ProtoKeySerialization r0 = key.getSerialization(InsecureSecretKeyAccess.get());
        KeyData r1 = (KeyData) KeyData.newBuilder().setTypeUrl(r0.getTypeUrl()).setValue(r0.getValue()).setKeyMaterialType(r0.getKeyMaterialType()).build();
        Mac r2 = (Mac) RegistryConfiguration.get().getLegacyPrimitive(r1, Mac.class);
        OutputPrefixType r3 = r0.getOutputPrefixType();
        int r4 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[r3.ordinal()];
        if (r4 != 1) goto L5;
        byte[] r7 = new byte[0];
    L16:
        return new LegacyFullMac(r2, r3, r7);
    L5:
        if (r4 != 2) goto L7;
    L13:
        r7 = ByteBuffer.allocate(5).put((byte) 0).putInt(key.getIdRequirementOrNull().intValue()).array();
        goto L16
    L7:
        if (r4 == 3) goto L13;
        if (r4 != 4) goto L12;
        r7 = ByteBuffer.allocate(5).put((byte) 1).putInt(key.getIdRequirementOrNull().intValue()).array();
        goto L16
    L12:
        throw new GeneralSecurityException("unknown output prefix type");
    }

    private LegacyFullMac(Mac rawMac, OutputPrefixType outputPrefixType, byte[] identifier) {
        this.rawMac = rawMac;
        this.outputPrefixType = outputPrefixType;
        this.identifier = identifier;
    }

    @Override // com.google.crypto.tink.Mac
    public byte[] computeMac(byte[] data) throws GeneralSecurityException {
        if (this.outputPrefixType.equals(OutputPrefixType.LEGACY) == false) goto L6;
        data = Bytes.concat(new byte[][]{data, FORMAT_VERSION});
    L6:
        return Bytes.concat(new byte[][]{this.identifier, this.rawMac.computeMac(data)});
    }

    @Override // com.google.crypto.tink.Mac
    public void verifyMac(byte[] mac, byte[] data) throws GeneralSecurityException {
        if (mac.length < 10) goto L17;
        if (this.outputPrefixType.equals(OutputPrefixType.LEGACY) == false) goto L7;
        data = Bytes.concat(new byte[][]{data, FORMAT_VERSION});
    L7:
        byte[] r0 = new byte[0];
        if (this.outputPrefixType.equals(OutputPrefixType.RAW) == true) goto L11;
        byte[] r1 = Arrays.copyOf(mac, 5);
        mac = Arrays.copyOfRange(mac, 5, mac.length);
        r0 = r1;
    L11:
        if (Arrays.equals(this.identifier, r0) == false) goto L15;
        this.rawMac.verifyMac(mac, data);
        return;
    L15:
        throw new GeneralSecurityException("wrong prefix");
    L17:
        throw new GeneralSecurityException("tag too short");
    }
}
