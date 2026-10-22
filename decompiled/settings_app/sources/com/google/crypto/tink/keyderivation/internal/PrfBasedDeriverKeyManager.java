package com.google.crypto.tink.keyderivation.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.keyderivation.PrfBasedKeyDerivationKey;
import com.google.crypto.tink.keyderivation.PrfBasedKeyDerivationParameters;
import com.google.crypto.tink.prf.PrfKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.PrfBasedDeriverKey;
import com.google.crypto.tink.proto.PrfBasedDeriverKeyFormat;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class PrfBasedDeriverKeyManager implements KeyManager<Void> {
    private static final MutableKeyCreationRegistry.KeyCreator<PrfBasedKeyDerivationParameters> KEY_CREATOR = null;
    private static final PrimitiveConstructor<PrfBasedKeyDerivationKey, KeyDeriver> PRIMITIVE_CONSTRUCTOR = null;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.PrfBasedDeriverKey";

    /* JADX INFO: renamed from: $r8$lambda$0OhFvn-FqG3L6hSR6nytWQgj2j4, reason: not valid java name */
    public static /* synthetic */ PrfBasedKeyDerivationKey m939$r8$lambda$0OhFvnFqG3L6hSR6nytWQgj2j4(PrfBasedKeyDerivationParameters r0, Integer r1) {
        return createNewKey(r0, r1);
    }

    @Override // com.google.crypto.tink.KeyManager
    public final String getKeyType() {
        return TYPE_URL;
    }

    @Override // com.google.crypto.tink.KeyManager
    public int getVersion() {
        return 0;
    }

    @Override // com.google.crypto.tink.KeyManager
    public /* bridge */ /* synthetic */ Void getPrimitive(ByteString serializedKey) throws GeneralSecurityException {
        return getPrimitive2(serializedKey);
    }

    @Override // com.google.crypto.tink.KeyManager
    public /* bridge */ /* synthetic */ Void getPrimitive(MessageLite key) throws GeneralSecurityException {
        return getPrimitive2(key);
    }

    static {
        PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrfBasedDeriverKeyManager$$ExternalSyntheticLambda0(), PrfBasedKeyDerivationKey.class, KeyDeriver.class);
        KEY_CREATOR = new PrfBasedDeriverKeyManager$$ExternalSyntheticLambda1();
    }

    private static final PrfBasedKeyDerivationKey createNewKey(PrfBasedKeyDerivationParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        Key r0 = MutableKeyCreationRegistry.globalInstance().createKey(parameters.getPrfParameters(), null);
        if ((r0 instanceof PrfKey) == false) goto L7;
        return PrfBasedKeyDerivationKey.create(parameters, (PrfKey) r0, idRequirement);
    L7:
        throw new GeneralSecurityException("Failed to create PrfKey from parameters" + parameters.getPrfParameters() + ", instead got " + r0.getClass());
    }

    PrfBasedDeriverKeyManager() {
    }

    @Override // com.google.crypto.tink.KeyManager
    /* JADX INFO: renamed from: getPrimitive, reason: avoid collision after fix types in other method */
    public Void getPrimitive2(ByteString serializedKey) throws GeneralSecurityException {
        throw new GeneralSecurityException("Cannot use the KeyManager to get a primitive for KeyDerivation");
    }

    @Override // com.google.crypto.tink.KeyManager
    /* JADX INFO: renamed from: getPrimitive, reason: avoid collision after fix types in other method */
    public final Void getPrimitive2(MessageLite key) throws GeneralSecurityException {
        throw new GeneralSecurityException("Cannot use the KeyManager to get a primitive for KeyDerivation");
    }

    @Override // com.google.crypto.tink.KeyManager
    public final MessageLite newKey(ByteString serializedKeyFormat) throws GeneralSecurityException {
        return PrfBasedDeriverKey.parseFrom(newKeyData(serializedKeyFormat).getValue(), ExtensionRegistryLite.getEmptyRegistry());
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

    private static OutputPrefixType getOutputPrefixTypeFromSerializedKeyFormat(ByteString serializedKeyFormat) throws GeneralSecurityException {
        return PrfBasedDeriverKeyFormat.parseFrom(serializedKeyFormat, ExtensionRegistryLite.getEmptyRegistry()).getParams().getDerivedKeyTemplate().getOutputPrefixType();
    L4:
        e = move-exception;
        throw new GeneralSecurityException("Unexpectedly failed to parse key format", e);
    }

    @Override // com.google.crypto.tink.KeyManager
    public final KeyData newKeyData(ByteString serializedKeyFormat) throws GeneralSecurityException {
        OutputPrefixType r2 = getOutputPrefixTypeFromSerializedKeyFormat(serializedKeyFormat);
        ProtoParametersSerialization r3 = ProtoParametersSerialization.checkedCreate((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(serializedKeyFormat).setOutputPrefixType(r2).build());
        Parameters r4 = MutableSerializationRegistry.globalInstance().parseParameters(r3);
        if (r2.equals(OutputPrefixType.RAW) == true) goto L5;
        Integer r5 = 123;
    L6:
        Key r6 = MutableKeyCreationRegistry.globalInstance().createKey(r4, r5);
        ProtoKeySerialization r7 = (ProtoKeySerialization) MutableSerializationRegistry.globalInstance().serializeKey(r6, ProtoKeySerialization.class, InsecureSecretKeyAccess.get());
        return (KeyData) KeyData.newBuilder().setTypeUrl(r7.getTypeUrl()).setValue(r7.getValue()).setKeyMaterialType(r7.getKeyMaterialType()).build();
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.google.crypto.tink.KeyManager
    public final Class<Void> getPrimitiveClass() {
        return Void.class;
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        KeyManagerRegistry.globalInstance().registerKeyManager(new PrfBasedDeriverKeyManager(), newKeyAllowed);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, PrfBasedKeyDerivationParameters.class);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PRIMITIVE_CONSTRUCTOR);
        PrfBasedKeyDerivationKeyProtoSerialization.register();
    }
}
