package com.bytedance.privacy.pcc;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.privacy.network.NetworkConfig;
import com.bytedance.privacy.pcc.network.model.CreateChannelResponse;
import com.bytedance.privacy.utils.LogUtils;
import com.bytedance.ttnet.TTNetInit;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class EvidenceTokenVerifier {
    private static final String ALG_ES256 = "ES256";
    private static final String FIELD_ALG = "alg";
    private static final String FIELD_APP_ID = "app_id";
    private static final String FIELD_DCAP_VERIFY_RESULT = "dcap_verify_result";
    private static final String FIELD_EXP = "exp";
    private static final String FIELD_EXTRA = "extra";
    private static final String FIELD_IAT = "iat";
    private static final String FIELD_ISS = "iss";
    private static final String FIELD_IS_TRUSTED = "is_trusted";
    private static final String FIELD_JTI = "jti";
    private static final String FIELD_KID = "kid";
    private static final String FIELD_NBF = "nbf";
    private static final String FIELD_POLICIES_MATCHED = "policies_matched";
    private static final String FIELD_QUOTE = "quote";
    private static final String FIELD_QUOTE_BODY = "body";
    private static final String FIELD_RELATED_SERVICES = "related_services";
    private static final String FIELD_REPORT_DATA = "report_data";
    private static final String FIELD_SERVICE_ID = "service_id";
    private static final String FIELD_SVC_ID = "svc_id";
    private static final String FIELD_TDX = "tdx";
    private static final String FIELD_TLOG = "tlog";
    private static final String FIELD_TYP = "typ";
    private static final String FIELD_USER_DATA = "user_data";
    private static final String FIELD_VER = "ver";
    private static final String HASH_ALGORITHM = "SHA-256";
    private static final String ISS_NON_TEE = "TKMS-Auth-Center";
    private static final String ISS_TEE = "TKMS-Auth-Center-TEE";
    private static final String KEY_ALGORITHM = "EC";
    private static final Map<String, String> ROOT_KEY_MAP = null;
    private static final String SIG_ALGORITHM = "SHA256withECDSA";
    private static final String TAG = "EvidenceTokenVerifier";
    private static final String TYPE_JWT = "JWT";
    private static final int VER_TKMS_1100 = 1100;

    static {
        ROOT_KEY_MAP = new AnonymousClass1();
    }

    private EvidenceTokenVerifier() {
    }

    public static boolean verify(String r17, String r18, String r19, String r20, String r21, CreateChannelResponse.SvcKeyInfo r22) throws Exception {
        if (NetworkConfig.getInstance().isBoeEnv() == false) goto L5;
        String r2 = TTNetInit.DOMAIN_BOE_KEY;
    L6:
        String r3 = TAG;
        LogUtils.d(r3, "verify: start V2 JWT evidence token verification (env=" + r2 + ")");
        String[] r4 = r17.split("\\.");
        if (r4.length != 3) goto L164;
        String r7 = r4[0];
        String r9 = r4[1];
        String r5 = r4[2];
        JsonObject r11 = JsonParser.parseString(new String(Base64.decode(r7, 11), StandardCharsets.UTF_8)).getAsJsonObject();
        String r14 = "";
        if (r11.has(FIELD_TYP) == false) goto L11;
        String r12 = r11.get(FIELD_TYP).getAsString();
    L13:
        if (TYPE_JWT.equals(r12) == false) goto L162;
        if (r11.has(FIELD_ALG) == false) goto L18;
        r14 = r11.get(FIELD_ALG).getAsString();
    L18:
        if (ALG_ES256.equals(r14) == false) goto L160;
        if (r11.has(FIELD_VER) == false) goto L22;
        int r13 = r11.get(FIELD_VER).getAsInt();
    L24:
        if (r13 != 1100) goto L158;
        if (r11.has(FIELD_KID) == false) goto L156;
        String r15 = r11.get(FIELD_KID).getAsString();
        LogUtils.d(r3, "verify: header parsed");
        JsonObject r16 = JsonParser.parseString(new String(Base64.decode(r9, 11), StandardCharsets.UTF_8)).getAsJsonObject();
        LogUtils.d(r3, "verify: payload parsed successfully");
        if (r16.has(FIELD_ISS) == false) goto L154;
        String r110 = r16.get(FIELD_ISS).getAsString();
        LogUtils.i(r3, "verify: issuer parsed");
        if (ISS_TEE.equals(r110) == false) goto L32;
    L36:
        String r6 = r2 + "_" + r110 + "_" + r15;
        LogUtils.d(r3, "verify: looking up verification key");
        Map<String, String> r111 = ROOT_KEY_MAP;
        if (r111.containsKey(r6) == false) goto L152;
        PublicKey r112 = pemStringToPublicKey(r111.get(r6));
        if (r112 == null) goto L150;
        LogUtils.d(r3, "verify: public key obtained");
        byte[] r8 = rsToAsn1Der(Base64.decode(r5, 11));
        byte[] r10 = (r7 + "." + r9).getBytes(StandardCharsets.UTF_8);
        Signature r23 = Signature.getInstance(SIG_ALGORITHM);
        r23.initVerify(r112);
        r23.update(r10);
        if (r23.verify(r8) == false) goto L148;
        LogUtils.d(r3, "verify: JWT signature valid");
        long r24 = System.currentTimeMillis() / 1000;
        if (r16.has(FIELD_NBF) == false) goto L51;
        long r113 = r16.get(FIELD_NBF).getAsLong();
        if (r24 >= r113) goto L51;
        throw new Exception("JWT not yet valid: nbf=" + r113 + " now=" + r24);
    L51:
        if (r16.has(FIELD_EXP) == false) goto L57;
        long r114 = r16.get(FIELD_EXP).getAsLong();
        if (r24 <= r114) goto L57;
        throw new Exception("JWT expired: exp=" + r114 + " now=" + r24);
    L57:
        LogUtils.d(r3, "verify: time validation OK (now=" + r24 + ")");
        if (r16.has(FIELD_SERVICE_ID) == false) goto L146;
        String r25 = r16.get(FIELD_SERVICE_ID).getAsString();
        if (r25.equals(r19) == true) goto L62;
        LogUtils.w(r3, "service_id mismatch: expected=" + r19 + " got=" + r25);
        LogUtils.w(r3, "verify: service_id validation skipped (known issue in current server implementation)");
    L62:
        LogUtils.i(r3, "verify: service_id=" + r25 + " (expected appSvcId=" + r19 + ")");
        String r26 = CryptoUtils.toHex(CryptoUtils.toHex(computeReportData(r18, r19, r20, r21, r22)).getBytes(StandardCharsets.UTF_8));
        if (ISS_NON_TEE.equals(r110) == false) goto L94;
        LogUtils.i(r3, "verify: Non-TEE cluster, verifying extra fields");
        if (r16.has("extra") == false) goto L92;
        JsonObject r27 = r16.getAsJsonObject("extra");
        if (r27.has("app_id") == false) goto L90;
        String r28 = r27.get("app_id").getAsString();
        LogUtils.d(r3, "verify: extra.app_id=" + r28 + " (expected=" + r18 + ")");
        if (r28.equals(r18) == false) goto L88;
        LogUtils.i(r3, "verify: extra.app_id match OK");
        if (r27.has(FIELD_SVC_ID) == false) goto L86;
        String r0 = r27.get(FIELD_SVC_ID).getAsString();
        LogUtils.d(r3, "verify: extra.svc_id=" + r0 + " (expected=" + r19 + ")");
        if (r0.equals(r19) == false) goto L84;
        LogUtils.i(r3, "verify: extra.svc_id match OK");
        if (r27.has(FIELD_USER_DATA) == false) goto L82;
        if (TextUtils.equals(r26, r27.get(FIELD_USER_DATA).getAsString()) == false) goto L80;
        LogUtils.i(r3, "verify: extra.user_data match OK");
    L143:
        LogUtils.i(r3, "verify: V2 JWT evidence token verification completed successfully");
        return true;
    L80:
        throw new Exception("extra.user_data mismatch");
    L82:
        throw new Exception("JWT extra missing 'user_data' field");
    L84:
        throw new Exception("extra.svc_id mismatch");
    L86:
        throw new Exception("JWT extra missing 'svc_id' field");
    L88:
        throw new Exception("extra.app_id mismatch");
    L90:
        throw new Exception("JWT extra missing 'app_id' field");
    L92:
        throw new Exception("JWT payload missing 'extra' field for Non-TEE issuer");
    L94:
        if (ISS_TEE.equals(r110) == false) goto L143;
        LogUtils.i(r3, "verify: TEE cluster, verifying tdx fields");
        if (r16.has(FIELD_TDX) == false) goto L142;
        JsonObject r1 = r16.getAsJsonObject(FIELD_TDX);
        if (r1.has(FIELD_QUOTE) == false) goto L115;
        JsonObject r29 = r1.getAsJsonObject(FIELD_QUOTE);
        if (r29 == null) goto L115;
        if (r29.isJsonNull() == true) goto L115;
        if (r29.has(FIELD_QUOTE_BODY) == false) goto L115;
        JsonObject r30 = r29.getAsJsonObject(FIELD_QUOTE_BODY);
        if (r30 == null) goto L115;
        if (r30.isJsonNull() == true) goto L115;
        if (r30.has("reportdata") == false) goto L113;
        String r31 = r30.get("reportdata").getAsString();
        String r32 = "tdx.quote.body.reportdata";
    L116:
        if (r31 == null) goto L118;
    L120:
        StringBuilder r33 = new StringBuilder("verify: report_data source=").append(r32).append(" (len=");
        if (r31 == null) goto L123;
        int r34 = r31.length();
    L124:
        LogUtils.i(r3, r33.append(r34).append(")").toString());
        if (r31 != null) goto L127;
    L136:
        if (r31 != null) goto L138;
        String r35 = "field is null";
    L140:
        throw new Exception("JWT tdx.report_data missing or empty (" + r35 + ") for TEE issuer");
    L138:
        r35 = "field is empty string";
        goto L140
    L127:
        if (r31.isEmpty() == true) goto L136;
        if (TextUtils.equals(r26, r31) == false) goto L135;
        LogUtils.i(r3, "verify: tdx.report_data match OK");
        if (r1.has(FIELD_DCAP_VERIFY_RESULT) == false) goto L143;
        LogUtils.i(r3, "verify: tdx.dcap_verify_result=" + r1.get(FIELD_DCAP_VERIFY_RESULT).getAsString());
        goto L143
    L135:
        throw new Exception("tdx.report_data mismatch");
    L123:
        r34 = 0;
        goto L124
    L118:
        if (r1.has(FIELD_REPORT_DATA) == false) goto L120;
        r31 = r1.get(FIELD_REPORT_DATA).getAsString();
        r32 = "tdx.report_data";
        goto L120
    L113:
        if (r30.has(FIELD_REPORT_DATA) == false) goto L115;
        r31 = r30.get(FIELD_REPORT_DATA).getAsString();
        r32 = "tdx.quote.body.report_data";
    L115:
        r31 = null;
        r32 = null;
        goto L116
    L142:
        throw new Exception("JWT payload missing 'tdx' field for TEE issuer");
    L146:
        throw new Exception("JWT payload missing 'service_id' field");
    L148:
        throw new Exception("JWT ECDSA signature verification failed");
    L150:
        throw new Exception("failed to parse public key for: " + r6);
    L152:
        throw new Exception("public key not found for evidence token");
    L32:
        if (ISS_NON_TEE.equals(r110) == true) goto L36;
        throw new Exception("unknown issuer: '" + r110 + "', expected TKMS-Auth-Center-TEE or TKMS-Auth-Center");
    L154:
        throw new Exception("JWT payload missing 'iss' field");
    L156:
        throw new Exception("JWT header missing 'kid' field");
    L158:
        throw new Exception("unsupported JWT ver: " + r13 + ", expected 1100");
    L22:
        r13 = 0;
        goto L24
    L160:
        throw new Exception("unsupported JWT alg: '" + r14 + "', expected ES256");
    L162:
        throw new Exception("invalid JWT typ: '" + r12 + "', expected JWT");
    L11:
        r12 = "";
        goto L13
    L164:
        throw new Exception("invalid JWT format: expected 3 parts, got " + r4.length);
    L5:
        r2 = "prod";
        goto L6
    }

    private static PublicKey pemStringToPublicKey(String r3) {
        return KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(Base64.decode(r3.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replace("\n", "").replace("\r", "").trim(), 0)));
    L5:
        e = move-exception;
        LogUtils.e(TAG, "pemStringToPublicKey failed: " + e.getMessage());
        return null;
    }

    private static byte[] rsToAsn1Der(byte[] r6) {
        int r0 = r6.length / 2;
        byte[] r3 = derEncodeInt(Arrays.copyOfRange(r6, 0, r0));
        byte[] r7 = derEncodeInt(Arrays.copyOfRange(r6, r0, r6.length));
        int r1 = ((r3.length + 2) + 2) + r7.length;
        byte[] r4 = new byte[r1 + 2];
        r4[0] = 48;
        r4[1] = (byte) r1;
        r4[2] = 2;
        r4[3] = (byte) r3.length;
        System.arraycopy(r3, 0, r4, 4, r3.length);
        int r5 = 4 + r3.length;
        int r2 = r5 + 1;
        r4[r5] = 2;
        r4[r2] = (byte) r7.length;
        System.arraycopy(r7, 0, r4, r2 + 1, r7.length);
        return r4;
    }

    private static byte[] derEncodeInt(byte[] r4) {
        int r0 = 0;
    L4:
        if (r0 >= (r4.length - 1)) goto L9;
        if (r4[r0] != 0) goto L9;
        r0 = r0 + 1;
    L9:
        if ((r4[r0] & 128) == 0) goto L13;
        byte[] r1 = new byte[(r4.length - r0) + 1];
        System.arraycopy(r4, r0, r1, 1, r4.length - r0);
        return r1;
    L13:
        return Arrays.copyOfRange(r4, r0, r4.length);
    }

    private static byte[] computeReportData(String r2, String r3, String r4, String r5, CreateChannelResponse.SvcKeyInfo r6) throws Exception {
        MessageDigest r0 = MessageDigest.getInstance("SHA-256");
        r0.update(r2.getBytes(StandardCharsets.UTF_8));
        r0.update(r3.getBytes(StandardCharsets.UTF_8));
        r0.update(r4.getBytes(StandardCharsets.UTF_8));
        r0.update(r5.getBytes(StandardCharsets.UTF_8));
        if (r6 == null) goto L14;
        if (r6.getSvcKeyId() == null) goto L8;
        r0.update(r6.getSvcKeyId().getBytes(StandardCharsets.UTF_8));
    L8:
        if (r6.getSvcKeyVersion() == null) goto L11;
        r0.update(r6.getSvcKeyVersion().getBytes(StandardCharsets.UTF_8));
    L11:
        if (r6.getSvcPubKey() == null) goto L14;
        r0.update(r6.getSvcPubKey().getBytes(StandardCharsets.UTF_8));
    L14:
        return r0.digest();
    }
}
