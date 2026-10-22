package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.ConfigurationV0$$ExternalSyntheticLambda17;
import com.google.crypto.tink.ConfigurationV0$$ExternalSyntheticLambda18;
import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.PrivateKeyManager;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.hybrid.HpkeParameters;
import com.google.crypto.tink.hybrid.HpkePrivateKey;
import com.google.crypto.tink.hybrid.HpkeProtoSerialization;
import com.google.crypto.tink.hybrid.HpkePublicKey;
import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.X25519;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class HpkePrivateKeyManager {
    private static final PrimitiveConstructor<HpkePrivateKey, HybridDecrypt> HYBRID_DECRYPT_PRIMITIVE_CONSTRUCTOR = null;
    private static final PrimitiveConstructor<HpkePublicKey, HybridEncrypt> HYBRID_ENCRYPT_PRIMITIVE_CONSTRUCTOR = null;
    private static final MutableKeyCreationRegistry.KeyCreator<HpkeParameters> KEY_CREATOR = null;
    private static final PrivateKeyManager<HybridDecrypt> legacyPrivateKeyManager = null;
    private static final KeyManager<HybridEncrypt> legacyPublicKeyManager = null;

    public static /* synthetic */ HpkePrivateKey $r8$lambda$iB8Z3NFgqzPh9Aqn8VIOXCErgf0(HpkeParameters r0, Integer r1) {
        return createKey(r0, r1);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HpkePrivateKey";
    }

    static {
        HYBRID_DECRYPT_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda18(), HpkePrivateKey.class, HybridDecrypt.class);
        HYBRID_ENCRYPT_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda17(), HpkePublicKey.class, HybridEncrypt.class);
        legacyPrivateKeyManager = LegacyKeyManagerImpl.createPrivateKeyManager(getKeyType(), HybridDecrypt.class, com.google.crypto.tink.proto.HpkePrivateKey.parser());
        legacyPublicKeyManager = LegacyKeyManagerImpl.create(HpkePublicKeyManager.getKeyType(), HybridEncrypt.class, KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, com.google.crypto.tink.proto.HpkePublicKey.parser());
        KEY_CREATOR = new HpkePrivateKeyManager$$ExternalSyntheticLambda0();
    }

    private static HpkePrivateKey createKey(HpkeParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        if (parameters.getKemId().equals(HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256) == false) goto L6;
        byte[] r0 = X25519.generatePrivateKey();
        SecretBytes r1 = SecretBytes.copyFrom(r0, InsecureSecretKeyAccess.get());
        Bytes r2 = Bytes.copyFrom(X25519.publicFromPrivate(r0));
    L16:
        return HpkePrivateKey.create(HpkePublicKey.create(parameters, r2, idRequirement), r1);
    L6:
        if (parameters.getKemId().equals(HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) == false) goto L8;
    L14:
        EllipticCurves.CurveType r3 = HpkeUtil.nistHpkeKemToCurve(parameters.getKemId());
        KeyPair r4 = EllipticCurves.generateKeyPair(r3);
        r2 = Bytes.copyFrom(EllipticCurves.pointEncode(r3, EllipticCurves.PointFormatType.UNCOMPRESSED, ((ECPublicKey) r4.getPublic()).getW()));
        r1 = SecretBytes.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(((ECPrivateKey) r4.getPrivate()).getS(), HpkeUtil.getEncodedPrivateKeyLength(parameters.getKemId())), InsecureSecretKeyAccess.get());
        goto L16
    L8:
        if (parameters.getKemId().equals(HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) == true) goto L14;
        if (parameters.getKemId().equals(HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) == true) goto L14;
        throw new GeneralSecurityException("Unknown KEM ID");
    }

    public static void registerPair(boolean newKeyAllowed) throws GeneralSecurityException {
        if (TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible() == false) goto L7;
        HpkeProtoSerialization.register();
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(HYBRID_DECRYPT_PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(HYBRID_ENCRYPT_PRIMITIVE_CONSTRUCTOR);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, HpkeParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyPrivateKeyManager, newKeyAllowed);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyPublicKeyManager, false);
        return;
    L7:
        throw new GeneralSecurityException("Registering HPKE Hybrid Encryption is not supported in FIPS mode");
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", HpkeParameters.builder().setVariant(HpkeParameters.Variant.TINK).setKemId(HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256).setKdfId(HpkeParameters.KdfId.HKDF_SHA256).setAeadId(HpkeParameters.AeadId.AES_128_GCM).build());
        r0.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", HpkeParameters.builder().setVariant(HpkeParameters.Variant.NO_PREFIX).setKemId(HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256).setKdfId(HpkeParameters.KdfId.HKDF_SHA256).setAeadId(HpkeParameters.AeadId.AES_128_GCM).build());
        r0.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", HpkeParameters.builder().setVariant(HpkeParameters.Variant.TINK).setKemId(HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256).setKdfId(HpkeParameters.KdfId.HKDF_SHA256).setAeadId(HpkeParameters.AeadId.AES_256_GCM).build());
        r0.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", HpkeParameters.builder().setVariant(HpkeParameters.Variant.NO_PREFIX).setKemId(HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256).setKdfId(HpkeParameters.KdfId.HKDF_SHA256).setAeadId(HpkeParameters.AeadId.AES_256_GCM).build());
        r0.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", HpkeParameters.builder().setVariant(HpkeParameters.Variant.TINK).setKemId(HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256).setKdfId(HpkeParameters.KdfId.HKDF_SHA256).setAeadId(HpkeParameters.AeadId.CHACHA20_POLY1305).build());
        r0.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", HpkeParameters.builder().setVariant(HpkeParameters.Variant.NO_PREFIX).setKemId(HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256).setKdfId(HpkeParameters.KdfId.HKDF_SHA256).setAeadId(HpkeParameters.AeadId.CHACHA20_POLY1305).build());
        r0.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", HpkeParameters.builder().setVariant(HpkeParameters.Variant.TINK).setKemId(HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256).setKdfId(HpkeParameters.KdfId.HKDF_SHA256).setAeadId(HpkeParameters.AeadId.AES_128_GCM).build());
        r0.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", HpkeParameters.builder().setVariant(HpkeParameters.Variant.NO_PREFIX).setKemId(HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256).setKdfId(HpkeParameters.KdfId.HKDF_SHA256).setAeadId(HpkeParameters.AeadId.AES_128_GCM).build());
        r0.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", HpkeParameters.builder().setVariant(HpkeParameters.Variant.TINK).setKemId(HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256).setKdfId(HpkeParameters.KdfId.HKDF_SHA256).setAeadId(HpkeParameters.AeadId.AES_256_GCM).build());
        r0.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", HpkeParameters.builder().setVariant(HpkeParameters.Variant.NO_PREFIX).setKemId(HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256).setKdfId(HpkeParameters.KdfId.HKDF_SHA256).setAeadId(HpkeParameters.AeadId.AES_256_GCM).build());
        r0.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", HpkeParameters.builder().setVariant(HpkeParameters.Variant.TINK).setKemId(HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384).setKdfId(HpkeParameters.KdfId.HKDF_SHA384).setAeadId(HpkeParameters.AeadId.AES_128_GCM).build());
        r0.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", HpkeParameters.builder().setVariant(HpkeParameters.Variant.NO_PREFIX).setKemId(HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384).setKdfId(HpkeParameters.KdfId.HKDF_SHA384).setAeadId(HpkeParameters.AeadId.AES_128_GCM).build());
        r0.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", HpkeParameters.builder().setVariant(HpkeParameters.Variant.TINK).setKemId(HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384).setKdfId(HpkeParameters.KdfId.HKDF_SHA384).setAeadId(HpkeParameters.AeadId.AES_256_GCM).build());
        r0.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", HpkeParameters.builder().setVariant(HpkeParameters.Variant.NO_PREFIX).setKemId(HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384).setKdfId(HpkeParameters.KdfId.HKDF_SHA384).setAeadId(HpkeParameters.AeadId.AES_256_GCM).build());
        r0.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", HpkeParameters.builder().setVariant(HpkeParameters.Variant.TINK).setKemId(HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512).setKdfId(HpkeParameters.KdfId.HKDF_SHA512).setAeadId(HpkeParameters.AeadId.AES_128_GCM).build());
        r0.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", HpkeParameters.builder().setVariant(HpkeParameters.Variant.NO_PREFIX).setKemId(HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512).setKdfId(HpkeParameters.KdfId.HKDF_SHA512).setAeadId(HpkeParameters.AeadId.AES_128_GCM).build());
        r0.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", HpkeParameters.builder().setVariant(HpkeParameters.Variant.TINK).setKemId(HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512).setKdfId(HpkeParameters.KdfId.HKDF_SHA512).setAeadId(HpkeParameters.AeadId.AES_256_GCM).build());
        r0.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", HpkeParameters.builder().setVariant(HpkeParameters.Variant.NO_PREFIX).setKemId(HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512).setKdfId(HpkeParameters.KdfId.HKDF_SHA512).setAeadId(HpkeParameters.AeadId.AES_256_GCM).build());
        return Collections.unmodifiableMap(r0);
    }

    private HpkePrivateKeyManager() {
    }
}
