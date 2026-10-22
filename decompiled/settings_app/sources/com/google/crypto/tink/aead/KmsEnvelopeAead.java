package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.TinkProtoParametersFormat;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class KmsEnvelopeAead implements Aead {
    private static final byte[] EMPTY_AAD = null;
    private static final int LENGTH_ENCRYPTED_DEK = 4;
    private static final Set<String> supportedDekKeyTypes = null;
    private final Parameters parametersForNewKeys;
    private final Aead remote;
    private final String typeUrlForParsing;

    static {
        EMPTY_AAD = new byte[0];
        supportedDekKeyTypes = listSupportedDekKeyTypes();
    }

    private static Set<String> listSupportedDekKeyTypes() {
        HashSet r0 = new HashSet();
        r0.add("type.googleapis.com/google.crypto.tink.AesGcmKey");
        r0.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        r0.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        r0.add("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        r0.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        r0.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        return Collections.unmodifiableSet(r0);
    }

    public static boolean isSupportedDekKeyType(String dekKeyTypeUrl) {
        return supportedDekKeyTypes.contains(dekKeyTypeUrl);
    }

    private Parameters getRawParameters(KeyTemplate dekTemplate) throws GeneralSecurityException {
        return TinkProtoParametersFormat.parse(((KeyTemplate) KeyTemplate.newBuilder(dekTemplate).setOutputPrefixType(OutputPrefixType.RAW).build()).toByteArray());
    }

    @Deprecated
    public KmsEnvelopeAead(KeyTemplate dekTemplate, Aead remote) throws GeneralSecurityException {
        if (isSupportedDekKeyType(dekTemplate.getTypeUrl()) == false) goto L7;
        this.typeUrlForParsing = dekTemplate.getTypeUrl();
        this.parametersForNewKeys = getRawParameters(dekTemplate);
        this.remote = remote;
        return;
    L7:
        throw new IllegalArgumentException("Unsupported DEK key type: " + dekTemplate.getTypeUrl() + ". Only Tink AEAD key types are supported.");
    }

    public static Aead create(AeadParameters dekParameters, Aead remote) throws GeneralSecurityException {
        return new KmsEnvelopeAead(KeyTemplate.parseFrom(TinkProtoParametersFormat.serialize(dekParameters), ExtensionRegistryLite.getEmptyRegistry()), remote);
    L5:
        e = move-exception;
        throw new GeneralSecurityException(e);
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        Key r0 = MutableKeyCreationRegistry.globalInstance().createKey(this.parametersForNewKeys, null);
        byte[] r1 = ((ProtoKeySerialization) MutableSerializationRegistry.globalInstance().serializeKey(r0, ProtoKeySerialization.class, InsecureSecretKeyAccess.get())).getValue().toByteArray();
        return buildCiphertext(this.remote.encrypt(r1, EMPTY_AAD), ((Aead) MutablePrimitiveRegistry.globalInstance().getPrimitive(r0, Aead.class)).encrypt(plaintext, associatedData));
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        ByteBuffer r1 = ByteBuffer.wrap(ciphertext);     // Catch: Throwable -> L11
        int r2 = r1.getInt();     // Catch: Throwable -> L11
        if (r2 <= 0) goto L10;
        if (r2 > (ciphertext.length - 4)) goto L10;
        byte[] r6 = new byte[r2];     // Catch: Throwable -> L11
        r1.get(r6, 0, r2);     // Catch: Throwable -> L11
        byte[] r3 = new byte[r1.remaining()];     // Catch: Throwable -> L11
        r1.get(r3, 0, r1.remaining());     // Catch: Throwable -> L11
        return ((Aead) MutablePrimitiveRegistry.globalInstance().getPrimitive(MutableSerializationRegistry.globalInstance().parseKey(ProtoKeySerialization.create(this.typeUrlForParsing, ByteString.copyFrom(this.remote.decrypt(r6, EMPTY_AAD)), KeyData.KeyMaterialType.SYMMETRIC, OutputPrefixType.RAW, null), InsecureSecretKeyAccess.get()), Aead.class)).decrypt(r3, associatedData);
    L10:
        throw new GeneralSecurityException("invalid ciphertext");     // Catch: Throwable -> L11
    L11:
        e = move-exception;
        throw new GeneralSecurityException("invalid ciphertext", e);
    }

    private byte[] buildCiphertext(final byte[] encryptedDek, final byte[] payload) {
        return ByteBuffer.allocate((encryptedDek.length + 4) + payload.length).putInt(encryptedDek.length).put(encryptedDek).put(payload).array();
    }
}
