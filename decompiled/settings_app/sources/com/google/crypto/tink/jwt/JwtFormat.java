package com.google.crypto.tink.jwt;

import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Base64;
import com.google.gson.JsonObject;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Optional;

/* JADX INFO: loaded from: classes4.dex */
final class JwtFormat {

    static class Parts {
        String header;
        String payload;
        byte[] signatureOrMac;
        String unsignedCompact;

        Parts(String unsignedCompact, byte[] signatureOrMac, String header, String payload) {
            this.unsignedCompact = unsignedCompact;
            this.signatureOrMac = signatureOrMac;
            this.header = header;
            this.payload = payload;
        }
    }

    static boolean isValidUrlsafeBase64Char(char c) {
        if (c < 'a') goto L7;
        if (c > 'z') goto L7;
    L20:
        return true;
    L7:
        if (c < 'A') goto L11;
        if (c <= 'Z') goto L20;
    L11:
        if (c < '0') goto L15;
        if (c <= '9') goto L20;
    L15:
        if (c == '-') goto L20;
        if (c == '_') goto L20;
        return false;
    }

    private JwtFormat() {
    }

    static void validateUtf8(byte[] data) throws JwtInvalidException {
        CharsetDecoder r0 = Util.UTF_8.newDecoder();
        r0.decode(ByteBuffer.wrap(data));     // Catch: CharacterCodingException -> L5
        return;
    L5:
        e = move-exception;
        throw new JwtInvalidException(e.getMessage());
    }

    static byte[] strictUrlSafeDecode(String encodedData) throws JwtInvalidException {
        int r0 = 0;
    L4:
        if (r0 < encodedData.length()) goto L6;
        return Base64.urlSafeDecode(encodedData);
    L12:
        e = move-exception;
        throw new JwtInvalidException("invalid encoding: " + e);
    L6:
        if (isValidUrlsafeBase64Char(encodedData.charAt(r0)) == false) goto L9;
        r0 = r0 + 1;
        goto L4
    L9:
        throw new JwtInvalidException("invalid encoding");
    }

    private static void validateAlgorithm(String algo) throws InvalidAlgorithmParameterException {
        algo.hashCode();
        byte r1 = -1;
        switch(algo.hashCode()) {
            case 66245349: goto L50;
            case 66246401: goto L46;
            case 66248104: goto L42;
            case 69015912: goto L38;
            case 69016964: goto L34;
            case 69018667: goto L30;
            case 76404080: goto L26;
            case 76405132: goto L22;
            case 76406835: goto L18;
            case 78251122: goto L14;
            case 78252174: goto L10;
            case 78253877: goto L6;
            default: goto L53;
        };
    L53:
        switch(r1) {
            case 0: goto L56;
            case 1: goto L56;
            case 2: goto L56;
            case 3: goto L56;
            case 4: goto L56;
            case 5: goto L56;
            case 6: goto L56;
            case 7: goto L56;
            case 8: goto L56;
            case 9: goto L56;
            case 10: goto L56;
            case 11: goto L56;
            default: goto L55;
        };
    L56:
        return;
    L55:
        throw new InvalidAlgorithmParameterException("invalid algorithm: " + algo);
    L6:
        if (algo.equals("RS512") == false) goto L53;
        r1 = 11;
        goto L53
    L10:
        if (algo.equals("RS384") == false) goto L53;
        r1 = 10;
        goto L53
    L14:
        if (algo.equals("RS256") == false) goto L53;
        r1 = 9;
        goto L53
    L18:
        if (algo.equals("PS512") == false) goto L53;
        r1 = 8;
        goto L53
    L22:
        if (algo.equals("PS384") == false) goto L53;
        r1 = 7;
        goto L53
    L26:
        if (algo.equals("PS256") == false) goto L53;
        r1 = 6;
        goto L53
    L30:
        if (algo.equals("HS512") == false) goto L53;
        r1 = 5;
        goto L53
    L34:
        if (algo.equals("HS384") == false) goto L53;
        r1 = 4;
        goto L53
    L38:
        if (algo.equals("HS256") == false) goto L53;
        r1 = 3;
        goto L53
    L42:
        if (algo.equals("ES512") == false) goto L53;
        r1 = 2;
        goto L53
    L46:
        if (algo.equals("ES384") == false) goto L53;
        r1 = 1;
        goto L53
    L50:
        if (algo.equals("ES256") == false) goto L53;
        r1 = 0;
        goto L53
    }

    static String createHeader(String algorithm, Optional<String> typeHeader, Optional<String> kid) throws InvalidAlgorithmParameterException {
        validateAlgorithm(algorithm);
        JsonObject r0 = new JsonObject();
        if (kid.isPresent() == false) goto L5;
        r0.addProperty("kid", kid.get());
    L5:
        r0.addProperty("alg", algorithm);
        if (typeHeader.isPresent() == false) goto L9;
        r0.addProperty("typ", typeHeader.get());
    L9:
        return Base64.urlSafeEncode(r0.toString().getBytes(Util.UTF_8));
    }

    private static void validateKidInHeader(String expectedKid, JsonObject parsedHeader) throws JwtInvalidException {
        if (getStringHeader(parsedHeader, "kid").equals(expectedKid) == false) goto L6;
        return;
    L6:
        throw new JwtInvalidException("invalid kid in header");
    }

    static void validateHeader(JsonObject parsedHeader, String algorithmFromKey, Optional<String> kidFromKey, boolean allowKidAbsent) throws GeneralSecurityException {
        String r0 = getStringHeader(parsedHeader, "alg");
        if (r0.equals(algorithmFromKey) == false) goto L26;
        if (parsedHeader.has("crit") == true) goto L24;
        boolean r1 = parsedHeader.has("kid");
        if (r1 == true) goto L10;
        if (allowKidAbsent == false) goto L10;
        return;
    L10:
        if (r1 == true) goto L16;
        if (allowKidAbsent == true) goto L16;
        throw new JwtInvalidException("missing kid in header");
    L16:
        if (kidFromKey.isPresent() == true) goto L19;
        return;
    L19:
        if (getStringHeader(parsedHeader, "kid").equals(kidFromKey.get()) == false) goto L22;
        return;
    L22:
        throw new JwtInvalidException("invalid kid in header");
    L24:
        throw new JwtInvalidException("all tokens with crit headers are rejected");
    L26:
        throw new InvalidAlgorithmParameterException(String.format("invalid algorithm; expected %s, got %s", new Object[]{algorithmFromKey, r0}));
    }

    static void validateHeader(String expectedAlgorithm, Optional<String> tinkKid, Optional<String> customKid, JsonObject parsedHeader) throws InvalidAlgorithmParameterException, JwtInvalidException {
        validateAlgorithm(expectedAlgorithm);
        String r0 = getStringHeader(parsedHeader, "alg");
        if (r0.equals(expectedAlgorithm) == false) goto L27;
        if (parsedHeader.has("crit") == true) goto L25;
        if (tinkKid.isPresent() == true) goto L9;
    L13:
        boolean r2 = parsedHeader.has("kid");
        if (tinkKid.isPresent() == false) goto L20;
        if (r2 == false) goto L18;
        validateKidInHeader(tinkKid.get(), parsedHeader);
        goto L20
    L18:
        throw new JwtInvalidException("missing kid in header");
    L20:
        if (customKid.isPresent() == false) goto L28;
        if (r2 == false) goto L29;
        validateKidInHeader(customKid.get(), parsedHeader);
        return;
    L29:
        return;
    L28:
        return;
    L9:
        if (customKid.isPresent() == false) goto L13;
        throw new JwtInvalidException("custom_kid can only be set for RAW keys.");
    L25:
        throw new JwtInvalidException("all tokens with crit headers are rejected");
    L27:
        throw new InvalidAlgorithmParameterException(String.format("invalid algorithm; expected %s, got %s", new Object[]{expectedAlgorithm, r0}));
    }

    static Optional<String> getTypeHeader(JsonObject header) throws JwtInvalidException {
        if (header.has("typ") == false) goto L7;
        return Optional.of(getStringHeader(header, "typ"));
    L7:
        return Optional.empty();
    }

    static String getStringHeader(JsonObject header, String name) throws JwtInvalidException {
        if (header.has(name) == false) goto L13;
        if (header.get(name).isJsonPrimitive() == false) goto L11;
        if (header.get(name).getAsJsonPrimitive().isString() == false) goto L11;
        return header.get(name).getAsString();
    L11:
        throw new JwtInvalidException("header " + name + " is not a string");
    L13:
        throw new JwtInvalidException("header " + name + " does not exist");
    }

    static String decodeHeader(String headerStr) throws JwtInvalidException {
        byte[] r2 = strictUrlSafeDecode(headerStr);
        validateUtf8(r2);
        return new String(r2, Util.UTF_8);
    }

    static String encodePayload(String jsonPayload) {
        return Base64.urlSafeEncode(jsonPayload.getBytes(Util.UTF_8));
    }

    static String decodePayload(String payloadStr) throws JwtInvalidException {
        byte[] r2 = strictUrlSafeDecode(payloadStr);
        validateUtf8(r2);
        return new String(r2, Util.UTF_8);
    }

    static String encodeSignature(byte[] signature) {
        return Base64.urlSafeEncode(signature);
    }

    static byte[] decodeSignature(String signatureStr) throws JwtInvalidException {
        return strictUrlSafeDecode(signatureStr);
    }

    static Optional<String> getKid(int keyId, OutputPrefixType prefix) throws JwtInvalidException {
        if (prefix != OutputPrefixType.RAW) goto L7;
        return Optional.empty();
    L7:
        if (prefix != OutputPrefixType.TINK) goto L11;
        return Optional.of(Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(keyId).array()));
    L11:
        throw new JwtInvalidException("unsupported output prefix type");
    }

    static Optional<Integer> getKeyId(String kid) {
        byte[] r2 = Base64.urlSafeDecode(kid);
        if (r2.length == 4) goto L7;
        return Optional.empty();
    L7:
        return Optional.of(Integer.valueOf(ByteBuffer.wrap(r2).getInt()));
    }

    static Parts splitSignedCompact(String signedCompact) throws JwtInvalidException {
        validateASCII(signedCompact);
        int r1 = signedCompact.lastIndexOf(46);
        if (r1 < 0) goto L15;
        String r4 = signedCompact.substring(0, r1);
        byte[] r5 = decodeSignature(signedCompact.substring(r1 + 1));
        int r2 = r4.indexOf(46);
        if (r2 < 0) goto L13;
        String r3 = r4.substring(0, r2);
        String r6 = r4.substring(r2 + 1);
        if (r6.indexOf(46) > 0) goto L11;
        return new Parts(r4, r5, decodeHeader(r3), decodePayload(r6));
    L11:
        throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
    L13:
        throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
    L15:
        throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
    }

    static String createUnsignedCompact(String algorithm, Optional<String> kid, RawJwt rawJwt) throws InvalidAlgorithmParameterException, JwtInvalidException {
        String r0 = rawJwt.getJsonPayload();
        if (rawJwt.hasTypeHeader() == false) goto L5;
        Optional r4 = Optional.of(rawJwt.getTypeHeader());
    L7:
        return createHeader(algorithm, r4, kid) + "." + encodePayload(r0);
    L5:
        r4 = Optional.empty();
        goto L7
    }

    static String createSignedCompact(String unsignedCompact, byte[] signature) {
        return unsignedCompact + "." + encodeSignature(signature);
    }

    static void validateASCII(String data) throws JwtInvalidException {
        int r0 = 0;
    L4:
        if (r0 >= data.length()) goto L10;
        if ((data.charAt(r0) & 128) > 0) goto L9;
        r0 = r0 + 1;
        goto L4
    L9:
        throw new JwtInvalidException("Non ascii character");
    }
}
