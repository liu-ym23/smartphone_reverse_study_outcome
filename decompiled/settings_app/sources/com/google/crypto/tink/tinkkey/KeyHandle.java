package com.google.crypto.tink.tinkkey;

import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.TinkProtoParametersFormat;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.KeyTemplateProtoConverter;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.tinkkey.internal.ProtoKey;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public class KeyHandle {
    private final int id;
    private final TinkKey key;
    private final KeyStatusType status;

    public static final enum KeyStatusType extends Enum<KeyStatusType> {
        private static final /* synthetic */ KeyStatusType[] $VALUES = null;
        public static final KeyStatusType DESTROYED = null;
        public static final KeyStatusType DISABLED = null;
        public static final KeyStatusType ENABLED = null;

        private KeyStatusType(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static KeyStatusType valueOf(String name) {
            return (KeyStatusType) Enum.valueOf(KeyStatusType.class, name);
        }

        public static KeyStatusType[] values() {
            return (KeyStatusType[]) $VALUES.clone();
        }

        static {
            KeyStatusType r0 = new KeyStatusType("ENABLED", 0);
            ENABLED = r0;
            KeyStatusType r1 = new KeyStatusType("DISABLED", 1);
            DISABLED = r1;
            KeyStatusType r3 = new KeyStatusType("DESTROYED", 2);
            DESTROYED = r3;
            $VALUES = new KeyStatusType[]{r0, r1, r3};
        }
    }

    private static KeyData newKeyData(KeyTemplate keyTemplate) throws GeneralSecurityException {
        com.google.crypto.tink.proto.KeyTemplate r4 = com.google.crypto.tink.proto.KeyTemplate.parseFrom(TinkProtoParametersFormat.serialize(keyTemplate.toParameters()), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L9
        KeyManager<?> r1 = KeyManagerRegistry.globalInstance().getUntypedKeyManager(r4.getTypeUrl());     // Catch: InvalidProtocolBufferException -> L9
        if (KeyManagerRegistry.globalInstance().isNewKeyAllowed(r4.getTypeUrl()) == false) goto L8;
        return r1.newKeyData(r4.getValue());
    L8:
        throw new GeneralSecurityException("newKey-operation not permitted for key type " + r4.getTypeUrl());     // Catch: InvalidProtocolBufferException -> L9
    L9:
        e = move-exception;
        throw new GeneralSecurityException("Failed to parse serialized parameters", e);
    }

    public static KeyHandle createFromKey(TinkKey key, KeyAccess access) throws GeneralSecurityException {
        KeyHandle r0 = new KeyHandle(key);
        r0.checkAccess(access);
        return r0;
    }

    public static KeyHandle createFromKey(KeyData keyData, KeyTemplate.OutputPrefixType opt) {
        return new KeyHandle(new ProtoKey(keyData, opt));
    }

    private KeyHandle(TinkKey key) {
        this.key = key;
        this.status = KeyStatusType.ENABLED;
        this.id = Util.randKeyId();
    }

    protected KeyHandle(TinkKey key, KeyStatusType status, int keyId) {
        this.key = key;
        this.status = status;
        this.id = keyId;
    }

    public static KeyHandle generateNew(KeyTemplate keyTemplate) throws GeneralSecurityException {
        return new KeyHandle(new ProtoKey(newKeyData(keyTemplate), KeyTemplateProtoConverter.getOutputPrefixType(keyTemplate)));
    }

    public boolean hasSecret() {
        return this.key.hasSecret();
    }

    public KeyStatusType getStatus() {
        return this.status;
    }

    public int getId() {
        return this.id;
    }

    public TinkKey getKey(KeyAccess access) throws GeneralSecurityException {
        checkAccess(access);
        return this.key;
    }

    public KeyTemplate getKeyTemplate() {
        return this.key.getKeyTemplate();
    }

    private void checkAccess(KeyAccess access) throws GeneralSecurityException {
        if (hasSecret() == true) goto L5;
        return;
    L5:
        if (access.canAccessSecret() == false) goto L8;
        return;
    L8:
        throw new GeneralSecurityException("No access");
    }
}
