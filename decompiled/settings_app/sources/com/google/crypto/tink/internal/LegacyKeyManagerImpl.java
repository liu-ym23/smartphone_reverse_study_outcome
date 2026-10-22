package com.google.crypto.tink.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.PrivateKey;
import com.google.crypto.tink.PrivateKeyManager;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public class LegacyKeyManagerImpl<P> implements KeyManager<P> {
    final KeyData.KeyMaterialType keyMaterialType;
    final Class<P> primitiveClass;
    final Parser<? extends MessageLite> protobufKeyParser;
    final String typeUrl;

    private static class LegacyPrivateKeyManagerImpl<P> extends LegacyKeyManagerImpl<P> implements PrivateKeyManager<P> {
        protected LegacyPrivateKeyManagerImpl(String typeUrl, Class<P> primitiveClass, Parser<? extends MessageLite> protobufKeyParser) {
            super(typeUrl, primitiveClass, KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE, protobufKeyParser);
        }

        @Override // com.google.crypto.tink.PrivateKeyManager
        public KeyData getPublicKeyData(ByteString serializedKey) throws GeneralSecurityException {
            ProtoKeySerialization r3 = ProtoKeySerialization.create(this.typeUrl, serializedKey, this.keyMaterialType, OutputPrefixType.RAW, null);
            Object r4 = MutableSerializationRegistry.globalInstance().parseKey(r3, InsecureSecretKeyAccess.get());
            if ((r4 instanceof PrivateKey) == false) goto L7;
            Key r5 = ((PrivateKey) r4).getPublicKey();
            ProtoKeySerialization r6 = (ProtoKeySerialization) MutableSerializationRegistry.globalInstance().serializeKey(r5, ProtoKeySerialization.class, InsecureSecretKeyAccess.get());
            return (KeyData) KeyData.newBuilder().setTypeUrl(r6.getTypeUrl()).setValue(r6.getValue()).setKeyMaterialType(r6.getKeyMaterialType()).build();
        L7:
            throw new GeneralSecurityException("Key not private key");
        }
    }

    @Override // com.google.crypto.tink.KeyManager
    public int getVersion() {
        return 0;
    }

    public static <P> KeyManager<P> create(String typeUrl, Class<P> primitiveClass, KeyData.KeyMaterialType keyMaterialType, Parser<? extends MessageLite> protobufKeyParser) {
        return new LegacyKeyManagerImpl(typeUrl, primitiveClass, keyMaterialType, protobufKeyParser);
    }

    LegacyKeyManagerImpl(String typeUrl, Class<P> primitiveClass, KeyData.KeyMaterialType keyMaterialType, Parser<? extends MessageLite> protobufKeyParser) {
        this.protobufKeyParser = protobufKeyParser;
        this.typeUrl = typeUrl;
        this.primitiveClass = primitiveClass;
        this.keyMaterialType = keyMaterialType;
    }

    @Override // com.google.crypto.tink.KeyManager
    public P getPrimitive(ByteString r5) throws GeneralSecurityException {
        ProtoKeySerialization r6 = ProtoKeySerialization.create(this.typeUrl, r5, this.keyMaterialType, OutputPrefixType.RAW, null);
        Key r7 = MutableSerializationRegistry.globalInstance().parseKey(r6, InsecureSecretKeyAccess.get());
        return (P) MutablePrimitiveRegistry.globalInstance().getPrimitive(r7, this.primitiveClass);
    }

    @Override // com.google.crypto.tink.KeyManager
    public final P getPrimitive(MessageLite key) throws GeneralSecurityException {
        return getPrimitive(key.toByteString());
    }

    @Override // com.google.crypto.tink.KeyManager
    public final MessageLite newKey(ByteString serializedKeyFormat) throws GeneralSecurityException {
        KeyData r2 = newKeyData(serializedKeyFormat);
        return this.protobufKeyParser.parseFrom(r2.getValue(), ExtensionRegistryLite.getEmptyRegistry());
    L6:
        throw new GeneralSecurityException("Unexpectedly failed to parse key");
    }

    @Override // com.google.crypto.tink.KeyManager
    public final MessageLite newKey(MessageLite keyFormat) throws GeneralSecurityException {
        return newKey(keyFormat.toByteString());
    }

    @Override // com.google.crypto.tink.KeyManager
    public final boolean doesSupport(String typeUrl) {
        return typeUrl.equals(getKeyType());
    }

    @Override // com.google.crypto.tink.KeyManager
    public final String getKeyType() {
        return this.typeUrl;
    }

    @Override // com.google.crypto.tink.KeyManager
    public final KeyData newKeyData(ByteString serializedKeyFormat) throws GeneralSecurityException {
        ProtoParametersSerialization r2 = ProtoParametersSerialization.checkedCreate((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(this.typeUrl).setValue(serializedKeyFormat).setOutputPrefixType(OutputPrefixType.RAW).build());
        Parameters r3 = MutableSerializationRegistry.globalInstance().parseParameters(r2);
        Key r4 = MutableKeyCreationRegistry.globalInstance().createKey(r3, null);
        ProtoKeySerialization r5 = (ProtoKeySerialization) MutableSerializationRegistry.globalInstance().serializeKey(r4, ProtoKeySerialization.class, InsecureSecretKeyAccess.get());
        return (KeyData) KeyData.newBuilder().setTypeUrl(r5.getTypeUrl()).setValue(r5.getValue()).setKeyMaterialType(r5.getKeyMaterialType()).build();
    }

    @Override // com.google.crypto.tink.KeyManager
    public final Class<P> getPrimitiveClass() {
        return this.primitiveClass;
    }

    public static <P> PrivateKeyManager<P> createPrivateKeyManager(String typeUrl, Class<P> primitiveClass, Parser<? extends MessageLite> protobufKeyParser) {
        return new LegacyPrivateKeyManagerImpl(typeUrl, primitiveClass, protobufKeyParser);
    }
}
