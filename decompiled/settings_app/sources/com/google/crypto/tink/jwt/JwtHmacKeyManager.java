package com.google.crypto.tink.jwt;

import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.mac.HmacKey;
import com.google.crypto.tink.mac.HmacParameters;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.PrfMac;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import com.google.gson.JsonObject;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class JwtHmacKeyManager {
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private static final MutableKeyCreationRegistry.KeyCreator<JwtHmacParameters> KEY_CREATOR = null;
    private static final PrimitiveConstructor<JwtHmacKey, JwtMac> PRIMITIVE_CONSTRUCTOR = null;
    private static final KeyManager<Void> legacyKeyManager = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtHmacKeyManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    @Immutable
    private static final class JwtHmac implements JwtMac {
        private final String algorithm;
        private final JwtHmacKey jwtHmacKey;
        private final Mac mac;

        /* synthetic */ JwtHmac(Mac r1, JwtHmacKey r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private JwtHmac(Mac plainMac, JwtHmacKey jwtHmacKey) {
            this.algorithm = jwtHmacKey.getParameters().getAlgorithm().getStandardName();
            this.mac = plainMac;
            this.jwtHmacKey = jwtHmacKey;
        }

        @Override // com.google.crypto.tink.jwt.JwtMac
        public String computeMacAndEncode(RawJwt rawJwt) throws GeneralSecurityException {
            String r3 = JwtFormat.createUnsignedCompact(this.algorithm, this.jwtHmacKey.getKid(), rawJwt);
            return JwtFormat.createSignedCompact(r3, this.mac.computeMac(r3.getBytes(StandardCharsets.US_ASCII)));
        }

        @Override // com.google.crypto.tink.jwt.JwtMac
        public VerifiedJwt verifyMacAndDecode(String compact, JwtValidator validator) throws GeneralSecurityException {
            JwtFormat.Parts r5 = JwtFormat.splitSignedCompact(compact);
            this.mac.verifyMac(r5.signatureOrMac, r5.unsignedCompact.getBytes(StandardCharsets.US_ASCII));
            JsonObject r0 = JsonUtil.parseJson(r5.header);
            JwtFormat.validateHeader(r0, this.jwtHmacKey.getParameters().getAlgorithm().getStandardName(), this.jwtHmacKey.getKid(), this.jwtHmacKey.getParameters().allowKidAbsent());
            return validator.validate(RawJwt.fromJsonPayload(JwtFormat.getTypeHeader(r0), r5.payload));
        }
    }

    public static /* synthetic */ JwtMac $r8$lambda$2JiT4ggpPekoGD2Wh52HUOMXvlE(JwtHmacKey r0) {
        return createFullJwtHmac(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$6wVf_dr0sGE5nYM5-YkUOx-7Id4, reason: not valid java name */
    public static /* synthetic */ JwtHmacKey m932$r8$lambda$6wVf_dr0sGE5nYM5YkUOx7Id4(JwtHmacParameters r0, Integer r1) {
        return createKey(r0, r1);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtHmacKey";
    }

    private static void validate(JwtHmacParameters parameters) throws GeneralSecurityException {
        if (parameters.getAlgorithm().equals(JwtHmacParameters.Algorithm.HS256) == false) goto L5;
        int r0 = 32;
    L7:
        if (parameters.getAlgorithm().equals(JwtHmacParameters.Algorithm.HS384) == false) goto L10;
        r0 = 48;
    L10:
        if (parameters.getAlgorithm().equals(JwtHmacParameters.Algorithm.HS512) == false) goto L13;
        r0 = 64;
    L13:
        if (parameters.getKeySizeBytes() < r0) goto L16;
        return;
    L16:
        throw new GeneralSecurityException("Key size must be at least " + r0);
    L5:
        r0 = Integer.MAX_VALUE;
        goto L7
    }

    private static int getTagLength(JwtHmacParameters.Algorithm algorithm) throws GeneralSecurityException {
        if (algorithm.equals(JwtHmacParameters.Algorithm.HS256) == false) goto L7;
        return 32;
    L7:
        if (algorithm.equals(JwtHmacParameters.Algorithm.HS384) == false) goto L11;
        return 48;
    L11:
        if (algorithm.equals(JwtHmacParameters.Algorithm.HS512) == false) goto L15;
        return 64;
    L15:
        throw new GeneralSecurityException("Unsupported algorithm: " + algorithm);
    }

    private static HmacParameters.HashType getHmacHashType(JwtHmacParameters.Algorithm algorithm) throws GeneralSecurityException {
        if (algorithm.equals(JwtHmacParameters.Algorithm.HS256) == false) goto L7;
        return HmacParameters.HashType.SHA256;
    L7:
        if (algorithm.equals(JwtHmacParameters.Algorithm.HS384) == false) goto L11;
        return HmacParameters.HashType.SHA384;
    L11:
        if (algorithm.equals(JwtHmacParameters.Algorithm.HS512) == false) goto L15;
        return HmacParameters.HashType.SHA512;
    L15:
        throw new GeneralSecurityException("Unsupported algorithm: " + algorithm);
    }

    static {
        legacyKeyManager = LegacyKeyManagerImpl.create("type.googleapis.com/google.crypto.tink.JwtHmacKey", Void.class, KeyData.KeyMaterialType.SYMMETRIC, com.google.crypto.tink.proto.JwtHmacKey.parser());
        PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new JwtHmacKeyManager$$ExternalSyntheticLambda3(), JwtHmacKey.class, JwtMac.class);
        KEY_CREATOR = new JwtHmacKeyManager$$ExternalSyntheticLambda4();
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    private static JwtMac createFullJwtHmac(JwtHmacKey key) throws GeneralSecurityException {
        validate(key.getParameters());
        return new JwtHmac(PrfMac.create(HmacKey.builder().setParameters(HmacParameters.builder().setKeySizeBytes(key.getParameters().getKeySizeBytes()).setHashType(getHmacHashType(key.getParameters().getAlgorithm())).setTagSizeBytes(getTagLength(key.getParameters().getAlgorithm())).build()).setKeyBytes(key.getKeyBytes()).build()), key, null);
    }

    private static JwtHmacKey createKey(JwtHmacParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        validate(parameters);
        JwtHmacKey.Builder r0 = JwtHmacKey.builder().setParameters(parameters).setKeyBytes(SecretBytes.randomBytes(parameters.getKeySizeBytes()));
        if (parameters.hasIdRequirement() == false) goto L9;
        if (idRequirement == null) goto L7;
        r0.setIdRequirement(idRequirement.intValue());
        goto L9
    L7:
        throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
    L9:
        return r0.build();
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("JWT_HS256_RAW", JwtHmacParameters.builder().setKeySizeBytes(32).setAlgorithm(JwtHmacParameters.Algorithm.HS256).setKidStrategy(JwtHmacParameters.KidStrategy.IGNORED).build());
        r0.put("JWT_HS256", JwtHmacParameters.builder().setKeySizeBytes(32).setAlgorithm(JwtHmacParameters.Algorithm.HS256).setKidStrategy(JwtHmacParameters.KidStrategy.BASE64_ENCODED_KEY_ID).build());
        r0.put("JWT_HS384_RAW", JwtHmacParameters.builder().setKeySizeBytes(48).setAlgorithm(JwtHmacParameters.Algorithm.HS384).setKidStrategy(JwtHmacParameters.KidStrategy.IGNORED).build());
        r0.put("JWT_HS384", JwtHmacParameters.builder().setKeySizeBytes(48).setAlgorithm(JwtHmacParameters.Algorithm.HS384).setKidStrategy(JwtHmacParameters.KidStrategy.BASE64_ENCODED_KEY_ID).build());
        r0.put("JWT_HS512_RAW", JwtHmacParameters.builder().setKeySizeBytes(64).setAlgorithm(JwtHmacParameters.Algorithm.HS512).setKidStrategy(JwtHmacParameters.KidStrategy.IGNORED).build());
        r0.put("JWT_HS512", JwtHmacParameters.builder().setKeySizeBytes(64).setAlgorithm(JwtHmacParameters.Algorithm.HS512).setKidStrategy(JwtHmacParameters.KidStrategy.BASE64_ENCODED_KEY_ID).build());
        return Collections.unmodifiableMap(r0);
    }

    public TinkFipsUtil.AlgorithmFipsCompatibility fipsStatus() {
        return FIPS;
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        TinkFipsUtil.AlgorithmFipsCompatibility r0 = FIPS;
        if (r0.isCompatible() == false) goto L7;
        JwtHmacProtoSerialization.register();
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, JwtHmacParameters.class);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyKeyManager, r0, newKeyAllowed);
        return;
    L7:
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }

    public static final KeyTemplate hs256Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new JwtHmacKeyManager$$ExternalSyntheticLambda1());
    }

    static /* synthetic */ KeyTemplate lambda$hs256Template$0() throws Exception {
        return KeyTemplate.createFrom(JwtHmacParameters.builder().setKeySizeBytes(32).setKidStrategy(JwtHmacParameters.KidStrategy.IGNORED).setAlgorithm(JwtHmacParameters.Algorithm.HS256).build());
    }

    public static final KeyTemplate hs384Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new JwtHmacKeyManager$$ExternalSyntheticLambda2());
    }

    static /* synthetic */ KeyTemplate lambda$hs384Template$1() throws Exception {
        return KeyTemplate.createFrom(JwtHmacParameters.builder().setKeySizeBytes(48).setKidStrategy(JwtHmacParameters.KidStrategy.IGNORED).setAlgorithm(JwtHmacParameters.Algorithm.HS384).build());
    }

    public static final KeyTemplate hs512Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new JwtHmacKeyManager$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ KeyTemplate lambda$hs512Template$2() throws Exception {
        return KeyTemplate.createFrom(JwtHmacParameters.builder().setKeySizeBytes(64).setKidStrategy(JwtHmacParameters.KidStrategy.IGNORED).setAlgorithm(JwtHmacParameters.Algorithm.HS512).build());
    }

    private JwtHmacKeyManager() {
    }
}
