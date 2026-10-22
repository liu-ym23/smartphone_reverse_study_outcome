package com.google.crypto.tink.signature;

import com.google.crypto.tink.ConfigurationV0$$ExternalSyntheticLambda1;
import com.google.crypto.tink.ConfigurationV0$$ExternalSyntheticLambda2;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.PrivateKeyManager;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableKeyDerivationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.signature.internal.Ed25519ProtoSerialization;
import com.google.crypto.tink.subtle.Ed25519Sign;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class Ed25519PrivateKeyManager {
    private static final MutableKeyCreationRegistry.KeyCreator<Ed25519Parameters> KEY_CREATOR = null;
    private static final MutableKeyDerivationRegistry.InsecureKeyCreator<Ed25519Parameters> KEY_DERIVER = null;
    private static final PrimitiveConstructor<Ed25519PrivateKey, PublicKeySign> PUBLIC_KEY_SIGN_PRIMITIVE_CONSTRUCTOR = null;
    private static final PrimitiveConstructor<Ed25519PublicKey, PublicKeyVerify> PUBLIC_KEY_VERIFY_PRIMITIVE_CONSTRUCTOR = null;
    private static final PrivateKeyManager<PublicKeySign> legacyPrivateKeyManager = null;
    private static final KeyManager<PublicKeyVerify> legacyPublicKeyManager = null;

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey";
    }

    static {
        PUBLIC_KEY_SIGN_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda1(), Ed25519PrivateKey.class, PublicKeySign.class);
        PUBLIC_KEY_VERIFY_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda2(), Ed25519PublicKey.class, PublicKeyVerify.class);
        legacyPrivateKeyManager = LegacyKeyManagerImpl.createPrivateKeyManager(getKeyType(), PublicKeySign.class, com.google.crypto.tink.proto.Ed25519PrivateKey.parser());
        legacyPublicKeyManager = LegacyKeyManagerImpl.create(Ed25519PublicKeyManager.getKeyType(), PublicKeyVerify.class, KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, com.google.crypto.tink.proto.Ed25519PublicKey.parser());
        KEY_DERIVER = new Ed25519PrivateKeyManager$$ExternalSyntheticLambda0();
        KEY_CREATOR = new Ed25519PrivateKeyManager$$ExternalSyntheticLambda1();
    }

    static Ed25519PrivateKey createEd25519KeyFromRandomness(Ed25519Parameters parameters, InputStream stream, @Nullable Integer idRequirement, SecretKeyAccess access) throws GeneralSecurityException {
        Ed25519Sign.KeyPair r2 = Ed25519Sign.KeyPair.newKeyPairFromSeed(Util.readIntoSecretBytes(stream, 32, access).toByteArray(access));
        return Ed25519PrivateKey.create(Ed25519PublicKey.create(parameters.getVariant(), Bytes.copyFrom(r2.getPublicKey()), idRequirement), SecretBytes.copyFrom(r2.getPrivateKey(), access));
    }

    static Ed25519PrivateKey createEd25519Key(Ed25519Parameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        Ed25519Sign.KeyPair r0 = Ed25519Sign.KeyPair.newKeyPair();
        return Ed25519PrivateKey.create(Ed25519PublicKey.create(parameters.getVariant(), Bytes.copyFrom(r0.getPublicKey()), idRequirement), SecretBytes.copyFrom(r0.getPrivateKey(), InsecureSecretKeyAccess.get()));
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("ED25519", Ed25519Parameters.create(Ed25519Parameters.Variant.TINK));
        r0.put("ED25519_RAW", Ed25519Parameters.create(Ed25519Parameters.Variant.NO_PREFIX));
        r0.put("ED25519WithRawOutput", Ed25519Parameters.create(Ed25519Parameters.Variant.NO_PREFIX));
        return Collections.unmodifiableMap(r0);
    }

    public static void registerPair(boolean newKeyAllowed) throws GeneralSecurityException {
        if (TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible() == false) goto L7;
        Ed25519ProtoSerialization.register();
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, Ed25519Parameters.class);
        MutableKeyDerivationRegistry.globalInstance().add(KEY_DERIVER, Ed25519Parameters.class);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PUBLIC_KEY_SIGN_PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PUBLIC_KEY_VERIFY_PRIMITIVE_CONSTRUCTOR);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyPrivateKeyManager, newKeyAllowed);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyPublicKeyManager, false);
        return;
    L7:
        throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
    }

    public static final KeyTemplate ed25519Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new Ed25519PrivateKeyManager$$ExternalSyntheticLambda2());
    }

    static /* synthetic */ KeyTemplate lambda$ed25519Template$0() throws Exception {
        return KeyTemplate.createFrom(Ed25519Parameters.create(Ed25519Parameters.Variant.TINK));
    }

    public static final KeyTemplate rawEd25519Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new Ed25519PrivateKeyManager$$ExternalSyntheticLambda3());
    }

    static /* synthetic */ KeyTemplate lambda$rawEd25519Template$1() throws Exception {
        return KeyTemplate.createFrom(Ed25519Parameters.create(Ed25519Parameters.Variant.NO_PREFIX));
    }

    private Ed25519PrivateKeyManager() {
    }
}
