package com.google.crypto.tink.jwt;

import com.android.settings.revone.TabletDpiSettingsFragment;
import com.bytedance.privacy.utils.PrivacyConst;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.internal.JsonParser;
import com.google.crypto.tink.subtle.Base64;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import java.util.Iterator;
import java.util.Optional;

/* JADX INFO: loaded from: classes4.dex */
public final class JwkSetConverter {
    public static String fromPublicKeysetHandle(KeysetHandle handle) throws IOException, GeneralSecurityException {
        KeysetHandle r5 = KeysetHandle.newBuilder(handle).build();
        JsonArray r0 = new JsonArray();
        int r1 = 0;
    L4:
        if (r1 >= r5.size()) goto L20;
        KeysetHandle.Entry r2 = r5.getAt(r1);
        if (r2.getStatus() != KeyStatus.ENABLED) goto L17;
        Key r3 = r2.getKey();
        if ((r3 instanceof JwtEcdsaPublicKey) == false) goto L12;
        r0.add(convertJwtEcdsaKey((JwtEcdsaPublicKey) r3));
        goto L17
    L12:
        if ((r3 instanceof JwtRsaSsaPkcs1PublicKey) == false) goto L15;
        r0.add(convertJwtRsaSsaPkcs1Key((JwtRsaSsaPkcs1PublicKey) r3));
        goto L17
    L15:
        if ((r3 instanceof JwtRsaSsaPssPublicKey) == false) goto L19;
        r0.add(convertJwtRsaSsaPssKey((JwtRsaSsaPssPublicKey) r3));
        goto L17
    L19:
        throw new GeneralSecurityException("unsupported key with parameters " + r3.getParameters());
    L17:
        r1 = r1 + 1;
        goto L4
    L20:
        JsonObject r6 = new JsonObject();
        r6.add("keys", r0);
        return r6.toString();
    }

    public static KeysetHandle toPublicKeysetHandle(String jwkSet) throws IOException, GeneralSecurityException {
        JsonObject r8 = JsonParser.parse(jwkSet).getAsJsonObject();     // Catch: Throwable -> L32
        KeysetHandle.Builder r0 = KeysetHandle.newBuilder();
        Iterator<JsonElement> r9 = r8.get("keys").getAsJsonArray().iterator();
    L4:
        byte r2 = 0;
        if (r9.hasNext() == false) goto L27;
        JsonObject r1 = r9.next().getAsJsonObject();
        String r4 = getStringItem(r1, "alg").substring(0, 2);
        r4.hashCode();
        switch(r4.hashCode()) {
            case 2222: goto L18;
            case 2563: goto L14;
            case 2625: goto L10;
            default: goto L8;
        };
    L8:
        r2 = -1;
    L20:
        switch(r2) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L23;
            default: goto L22;
        };
    L22:
        throw new GeneralSecurityException("unexpected alg value: " + getStringItem(r1, "alg"));
    L24:
        r0.addEntry(KeysetHandle.importKey(convertToRsaSsaPssKey(r1)).withRandomId());
        goto L4
    L25:
        r0.addEntry(KeysetHandle.importKey(convertToEcdsaKey(r1)).withRandomId());
        goto L4
    L23:
        r0.addEntry(KeysetHandle.importKey(convertToRsaSsaPkcs1Key(r1)).withRandomId());
        goto L4
    L10:
        if (r4.equals("RS") == false) goto L46;
        r2 = 2;
        goto L20
    L46:
        r2 = -1;
        goto L20
    L14:
        if (r4.equals("PS") == false) goto L47;
        r2 = 1;
        goto L20
    L47:
        r2 = -1;
        goto L20
    L18:
        if (r4.equals("ES") == true) goto L20;
        r2 = -1;
        goto L20
    L27:
        if (r0.size() <= 0) goto L31;
        r0.getAt(0).makePrimary();
        return r0.build();
    L31:
        throw new GeneralSecurityException("empty keyset");
    L32:
        e = move-exception;
        throw new GeneralSecurityException("JWK set is invalid JSON", e);
    }

    private static JsonObject convertJwtEcdsaKey(JwtEcdsaPublicKey key) throws GeneralSecurityException {
        JwtEcdsaParameters.Algorithm r0 = key.getParameters().getAlgorithm();
        if (r0.equals(JwtEcdsaParameters.Algorithm.ES256) == false) goto L6;
        String r1 = "ES256";
        String r2 = "P-256";
        int r3 = 32;
    L11:
        JsonObject r4 = new JsonObject();
        r4.addProperty("kty", PrivacyConst.ALGORITHM_EC);
        r4.addProperty("crv", r2);
        BigInteger r5 = key.getPublicPoint().getAffineX();
        BigInteger r6 = key.getPublicPoint().getAffineY();
        r4.addProperty(MaterialConfigFormatNames.X, Base64.urlSafeEncode(BigIntegerEncoding.toBigEndianBytesOfFixedLength(r5, r3)));
        r4.addProperty("y", Base64.urlSafeEncode(BigIntegerEncoding.toBigEndianBytesOfFixedLength(r6, r3)));
        r4.addProperty("use", "sig");
        r4.addProperty("alg", r1);
        JsonArray r7 = new JsonArray();
        r7.add("verify");
        r4.add("key_ops", r7);
        Optional<String> r8 = key.getKid();
        if (r8.isPresent() == false) goto L14;
        r4.addProperty("kid", r8.get());
    L14:
        return r4;
    L6:
        if (r0.equals(JwtEcdsaParameters.Algorithm.ES384) == false) goto L9;
        r1 = "ES384";
        r2 = "P-384";
        r3 = 48;
        goto L11
    L9:
        if (r0.equals(JwtEcdsaParameters.Algorithm.ES512) == false) goto L16;
        r1 = "ES512";
        r2 = "P-521";
        r3 = 66;
        goto L11
    L16:
        throw new GeneralSecurityException("unknown algorithm");
    }

    private static byte[] base64urlUInt(BigInteger n) {
        if (n.equals(BigInteger.ZERO) == false) goto L7;
        return new byte[]{0};
    L7:
        return BigIntegerEncoding.toUnsignedBigEndianBytes(n);
    }

    private static JsonObject convertJwtRsaSsaPkcs1Key(JwtRsaSsaPkcs1PublicKey key) throws GeneralSecurityException {
        String r0 = key.getParameters().getAlgorithm().getStandardName();
        JsonObject r1 = new JsonObject();
        r1.addProperty("kty", "RSA");
        r1.addProperty("n", Base64.urlSafeEncode(base64urlUInt(key.getModulus())));
        r1.addProperty("e", Base64.urlSafeEncode(base64urlUInt(key.getParameters().getPublicExponent())));
        r1.addProperty("use", "sig");
        r1.addProperty("alg", r0);
        JsonArray r2 = new JsonArray();
        r2.add("verify");
        r1.add("key_ops", r2);
        Optional<String> r4 = key.getKid();
        if (r4.isPresent() == false) goto L5;
        r1.addProperty("kid", r4.get());
    L5:
        return r1;
    }

    private static JsonObject convertJwtRsaSsaPssKey(JwtRsaSsaPssPublicKey key) throws GeneralSecurityException {
        String r0 = key.getParameters().getAlgorithm().getStandardName();
        JsonObject r1 = new JsonObject();
        r1.addProperty("kty", "RSA");
        r1.addProperty("n", Base64.urlSafeEncode(base64urlUInt(key.getModulus())));
        r1.addProperty("e", Base64.urlSafeEncode(base64urlUInt(key.getParameters().getPublicExponent())));
        r1.addProperty("use", "sig");
        r1.addProperty("alg", r0);
        JsonArray r2 = new JsonArray();
        r2.add("verify");
        r1.add("key_ops", r2);
        Optional<String> r4 = key.getKid();
        if (r4.isPresent() == false) goto L5;
        r1.addProperty("kid", r4.get());
    L5:
        return r1;
    }

    private static String getStringItem(JsonObject obj, String name) throws GeneralSecurityException {
        if (obj.has(name) == false) goto L13;
        if (obj.get(name).isJsonPrimitive() == false) goto L11;
        if (obj.get(name).getAsJsonPrimitive().isString() == false) goto L11;
        return obj.get(name).getAsString();
    L11:
        throw new GeneralSecurityException(name + " is not a string");
    L13:
        throw new GeneralSecurityException(name + " not found");
    }

    private static void expectStringItem(JsonObject obj, String name, String expectedValue) throws GeneralSecurityException {
        String r2 = getStringItem(obj, name);
        if (r2.equals(expectedValue) == false) goto L6;
        return;
    L6:
        throw new GeneralSecurityException("unexpected " + name + " value: " + r2);
    }

    private static void validateUseIsSig(JsonObject jsonKey) throws GeneralSecurityException {
        if (jsonKey.has("use") == true) goto L5;
        return;
    L5:
        expectStringItem(jsonKey, "use", "sig");
    }

    private static void validateKeyOpsIsVerify(JsonObject jsonKey) throws GeneralSecurityException {
        if (jsonKey.has("key_ops") == true) goto L6;
        return;
    L6:
        if (jsonKey.get("key_ops").isJsonArray() == false) goto L23;
        JsonArray r4 = jsonKey.get("key_ops").getAsJsonArray();
        if (r4.size() != 1) goto L21;
        if (r4.get(0).isJsonPrimitive() == false) goto L19;
        if (r4.get(0).getAsJsonPrimitive().isString() == false) goto L19;
        if (r4.get(0).getAsString().equals("verify") == false) goto L17;
        return;
    L17:
        throw new GeneralSecurityException("unexpected keyOps value: " + r4.get(0).getAsString());
    L19:
        throw new GeneralSecurityException("key_ops is not a string");
    L21:
        throw new GeneralSecurityException("key_ops must contain exactly one element");
    L23:
        throw new GeneralSecurityException("key_ops is not an array");
    }

    private static JwtRsaSsaPkcs1PublicKey convertToRsaSsaPkcs1Key(JsonObject jsonKey) throws GeneralSecurityException {
        String r1 = getStringItem(jsonKey, "alg");
        r1.hashCode();
        byte r4 = -1;
        switch(r1.hashCode()) {
            case 78251122: goto L14;
            case 78252174: goto L10;
            case 78253877: goto L6;
            default: goto L17;
        };
    L17:
        switch(r4) {
            case 0: goto L22;
            case 1: goto L21;
            case 2: goto L20;
            default: goto L19;
        };
    L20:
        JwtRsaSsaPkcs1Parameters.Algorithm r0 = JwtRsaSsaPkcs1Parameters.Algorithm.RS512;
    L24:
        if (jsonKey.has("p") == true) goto L42;
        if (jsonKey.has("q") == true) goto L42;
        if (jsonKey.has(TabletDpiSettingsFragment.UNIT) == true) goto L42;
        if (jsonKey.has("dq") == true) goto L42;
        if (jsonKey.has("d") == true) goto L42;
        if (jsonKey.has("qi") == true) goto L42;
        expectStringItem(jsonKey, "kty", "RSA");
        validateUseIsSig(jsonKey);
        validateKeyOpsIsVerify(jsonKey);
        BigInteger r2 = new BigInteger(1, Base64.urlSafeDecode(getStringItem(jsonKey, "e")));
        BigInteger r3 = new BigInteger(1, Base64.urlSafeDecode(getStringItem(jsonKey, "n")));
        if (jsonKey.has("kid") == false) goto L40;
        return JwtRsaSsaPkcs1PublicKey.builder().setParameters(JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(r3.bitLength()).setPublicExponent(r2).setAlgorithm(r0).setKidStrategy(JwtRsaSsaPkcs1Parameters.KidStrategy.CUSTOM).build()).setModulus(r3).setCustomKid(getStringItem(jsonKey, "kid")).build();
    L40:
        return JwtRsaSsaPkcs1PublicKey.builder().setParameters(JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(r3.bitLength()).setPublicExponent(r2).setAlgorithm(r0).setKidStrategy(JwtRsaSsaPkcs1Parameters.KidStrategy.IGNORED).build()).setModulus(r3).build();
    L42:
        throw new UnsupportedOperationException("importing RSA private keys is not implemented");
    L21:
        r0 = JwtRsaSsaPkcs1Parameters.Algorithm.RS384;
        goto L24
    L22:
        r0 = JwtRsaSsaPkcs1Parameters.Algorithm.RS256;
        goto L24
    L19:
        throw new GeneralSecurityException("Unknown Rsa Algorithm: " + getStringItem(jsonKey, "alg"));
    L6:
        if (r1.equals("RS512") == false) goto L17;
        r4 = 2;
        goto L17
    L10:
        if (r1.equals("RS384") == false) goto L17;
        r4 = 1;
        goto L17
    L14:
        if (r1.equals("RS256") == false) goto L17;
        r4 = 0;
        goto L17
    }

    private static JwtRsaSsaPssPublicKey convertToRsaSsaPssKey(JsonObject jsonKey) throws GeneralSecurityException {
        String r1 = getStringItem(jsonKey, "alg");
        r1.hashCode();
        byte r4 = -1;
        switch(r1.hashCode()) {
            case 76404080: goto L14;
            case 76405132: goto L10;
            case 76406835: goto L6;
            default: goto L17;
        };
    L17:
        switch(r4) {
            case 0: goto L22;
            case 1: goto L21;
            case 2: goto L20;
            default: goto L19;
        };
    L20:
        JwtRsaSsaPssParameters.Algorithm r0 = JwtRsaSsaPssParameters.Algorithm.PS512;
    L24:
        if (jsonKey.has("p") == true) goto L42;
        if (jsonKey.has("q") == true) goto L42;
        if (jsonKey.has("dq") == true) goto L42;
        if (jsonKey.has("dq") == true) goto L42;
        if (jsonKey.has("d") == true) goto L42;
        if (jsonKey.has("qi") == true) goto L42;
        expectStringItem(jsonKey, "kty", "RSA");
        validateUseIsSig(jsonKey);
        validateKeyOpsIsVerify(jsonKey);
        BigInteger r2 = new BigInteger(1, Base64.urlSafeDecode(getStringItem(jsonKey, "e")));
        BigInteger r3 = new BigInteger(1, Base64.urlSafeDecode(getStringItem(jsonKey, "n")));
        if (jsonKey.has("kid") == false) goto L40;
        return JwtRsaSsaPssPublicKey.builder().setParameters(JwtRsaSsaPssParameters.builder().setModulusSizeBits(r3.bitLength()).setPublicExponent(r2).setAlgorithm(r0).setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.CUSTOM).build()).setModulus(r3).setCustomKid(getStringItem(jsonKey, "kid")).build();
    L40:
        return JwtRsaSsaPssPublicKey.builder().setParameters(JwtRsaSsaPssParameters.builder().setModulusSizeBits(r3.bitLength()).setPublicExponent(r2).setAlgorithm(r0).setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.IGNORED).build()).setModulus(r3).build();
    L42:
        throw new UnsupportedOperationException("importing RSA private keys is not implemented");
    L21:
        r0 = JwtRsaSsaPssParameters.Algorithm.PS384;
        goto L24
    L22:
        r0 = JwtRsaSsaPssParameters.Algorithm.PS256;
        goto L24
    L19:
        throw new GeneralSecurityException("Unknown Rsa Algorithm: " + getStringItem(jsonKey, "alg"));
    L6:
        if (r1.equals("PS512") == false) goto L17;
        r4 = 2;
        goto L17
    L10:
        if (r1.equals("PS384") == false) goto L17;
        r4 = 1;
        goto L17
    L14:
        if (r1.equals("PS256") == false) goto L17;
        r4 = 0;
        goto L17
    }

    private static JwtEcdsaPublicKey convertToEcdsaKey(JsonObject jsonKey) throws GeneralSecurityException {
        String r1 = getStringItem(jsonKey, "alg");
        r1.hashCode();
        byte r4 = -1;
        switch(r1.hashCode()) {
            case 66245349: goto L14;
            case 66246401: goto L10;
            case 66248104: goto L6;
            default: goto L18;
        };
    L6:
        if (r1.equals("ES512") == false) goto L18;
        r4 = 2;
        goto L18
    L10:
        if (r1.equals("ES384") == false) goto L18;
        r4 = 1;
        goto L18
    L14:
        if (r1.equals("ES256") == false) goto L18;
        r4 = 0;
    L18:
        switch(r4) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            default: goto L20;
        };
    L21:
        expectStringItem(jsonKey, "crv", "P-521");
        JwtEcdsaParameters.Algorithm r0 = JwtEcdsaParameters.Algorithm.ES512;
    L25:
        if (jsonKey.has("d") == true) goto L33;
        expectStringItem(jsonKey, "kty", PrivacyConst.ALGORITHM_EC);
        validateUseIsSig(jsonKey);
        validateKeyOpsIsVerify(jsonKey);
        ECPoint r3 = new ECPoint(new BigInteger(1, Base64.urlSafeDecode(getStringItem(jsonKey, MaterialConfigFormatNames.X))), new BigInteger(1, Base64.urlSafeDecode(getStringItem(jsonKey, "y"))));
        if (jsonKey.has("kid") == false) goto L31;
        return JwtEcdsaPublicKey.builder().setParameters(JwtEcdsaParameters.builder().setKidStrategy(JwtEcdsaParameters.KidStrategy.CUSTOM).setAlgorithm(r0).build()).setPublicPoint(r3).setCustomKid(getStringItem(jsonKey, "kid")).build();
    L31:
        return JwtEcdsaPublicKey.builder().setParameters(JwtEcdsaParameters.builder().setKidStrategy(JwtEcdsaParameters.KidStrategy.IGNORED).setAlgorithm(r0).build()).setPublicPoint(r3).build();
    L33:
        throw new UnsupportedOperationException("importing ECDSA private keys is not implemented");
    L22:
        expectStringItem(jsonKey, "crv", "P-384");
        r0 = JwtEcdsaParameters.Algorithm.ES384;
        goto L25
    L23:
        expectStringItem(jsonKey, "crv", "P-256");
        r0 = JwtEcdsaParameters.Algorithm.ES256;
        goto L25
    L20:
        throw new GeneralSecurityException("Unknown Ecdsa Algorithm: " + getStringItem(jsonKey, "alg"));
    }

    @Deprecated
    public static String fromKeysetHandle(KeysetHandle handle, KeyAccess keyAccess) throws IOException, GeneralSecurityException {
        return fromPublicKeysetHandle(handle);
    }

    @Deprecated
    public static KeysetHandle toKeysetHandle(String jwkSet, KeyAccess keyAccess) throws IOException, GeneralSecurityException {
        return toPublicKeysetHandle(jwkSet);
    }

    private JwkSetConverter() {
    }
}
