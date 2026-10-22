package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class NoSecretKeysetHandle {
    @Deprecated
    public static final KeysetHandle parseFrom(final byte[] serialized) throws GeneralSecurityException {
        Keyset r1 = Keyset.parseFrom(serialized, ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L4
        validate(r1);     // Catch: InvalidProtocolBufferException -> L4
        return KeysetHandle.fromKeyset(r1);
    L5:
        throw new GeneralSecurityException("invalid keyset");
    }

    public static final KeysetHandle read(KeysetReader reader) throws GeneralSecurityException, IOException {
        Keyset r0 = reader.read();
        validate(r0);
        return KeysetHandle.fromKeyset(r0);
    }

    private static void validate(Keyset keyset) throws GeneralSecurityException {
        Iterator<Keyset.Key> r3 = keyset.getKeyList().iterator();
    L4:
        if (r3.hasNext() == false) goto L14;
        Keyset.Key r0 = r3.next();
        if (r0.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.UNKNOWN_KEYMATERIAL) goto L13;
        if (r0.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.SYMMETRIC) goto L13;
        if (r0.getKeyData().getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) goto L4;
    L13:
        throw new GeneralSecurityException("keyset contains secret key material");
    }

    private NoSecretKeysetHandle() {
    }
}
