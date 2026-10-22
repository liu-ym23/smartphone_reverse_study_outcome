package com.bytedance.privacy.pcc;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.privacy.pcc.network.model.CreateChannelResponse;
import com.bytedance.privacy.utils.LogUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public final class EvidenceTokenVerifier {
    private static final String ALG_ES256 = "ES256";
    private static final String FIELD_ALG = "alg";
    private static final String FIELD_APP_ID = "app_id";
    private static final String FIELD_EXP = "exp";
    private static final String FIELD_JWK = "jwk";
    private static final String FIELD_NBF = "nbf";
    private static final String FIELD_OPCC = "opcc";
    private static final String FIELD_REPORT_DATA = "report_data";
    private static final String FIELD_SVC_ID = "svc_id";
    private static final String FIELD_TDX = "tdx";
    private static final String FIELD_TOKEN_SECURITY_LEVEL = "token_security_level";
    private static final String FIELD_USER_DATA = "user_data";
    private static final String FIELD_X5C = "x5c";
    private static final String HASH_ALGORITHM = "SHA-256";
    private static final int SECURITY_LEVEL_SOFTWARE = 1;
    private static final int SECURITY_LEVEL_TDX = 2;
    private static final String SIG_ALGORITHM = "SHA256withECDSA";
    private static final String TAG = "EvidenceTokenVerifier";
    private static final int TDX_REPORT_DATA_COMPARE_LEN = 32;

    static {
    }

    private EvidenceTokenVerifier() {
    }

    public static boolean verify(String r16, String r17, String r18, String r19, String r20, List<CreateChannelResponse.SvcPod> r21, String r22) throws Exception {
        String r2 = TAG;
        LogUtils.d(r2, "verify: start JWT evidence token verification");
        String[] r3 = r16.split("\\.");
        if (r3.length != 3) goto L106;
        String r5 = r3[0];
        String r7 = r3[1];
        String r4 = r3[2];
        String r11 = new String(Base64.decode(r5, 9), StandardCharsets.UTF_8);
        LogUtils.d(r2, "header: ".concat(r11));
        JsonObject r10 = JsonParser.parseString(r11).getAsJsonObject();
        String r13 = "";
        if (r10.has(FIELD_ALG) == false) goto L7;
        String r12 = r10.get(FIELD_ALG).getAsString();
    L9:
        if (ALG_ES256.equals(r12) == false) goto L104;
        LogUtils.d(r2, "verify: header alg=ES256 OK");
        String r14 = new String(Base64.decode(r7, 9), StandardCharsets.UTF_8);
        LogUtils.d(r2, "payload: ".concat(r14));
        JsonObject r15 = JsonParser.parseString(r14).getAsJsonObject();
        LogUtils.d(r2, "verify: payload parsed successfully");
        if (r15.has(FIELD_JWK) == false) goto L102;
        PublicKey r110 = verifyJwkCertChain(r15.getAsJsonObject(FIELD_JWK), r22);
        LogUtils.d(r2, "verify: JWK cert chain verified, leaf public key obtained");
        byte[] r6 = rsToAsn1Der(Base64.decode(r4, 9));
        byte[] r8 = (r5 + LibrarianImpl.Constants.DOT + r7).getBytes(StandardCharsets.UTF_8);
        Signature r9 = Signature.getInstance(SIG_ALGORITHM);
        r9.initVerify(r110);
        r9.update(r8);
        if (r9.verify(r6) == false) goto L100;
        LogUtils.d(r2, "verify: JWT signature valid");
        long r111 = System.currentTimeMillis() / 1000;
        if (r15.has(FIELD_NBF) == false) goto L22;
        long r112 = r15.get(FIELD_NBF).getAsLong();
        if (r111 >= r112) goto L22;
        throw new Exception("JWT not yet valid: nbf=" + r112 + " now=" + r111);
    L22:
        if (r15.has(FIELD_EXP) == false) goto L28;
        long r113 = r15.get(FIELD_EXP).getAsLong();
        if (r111 <= r113) goto L28;
        throw new Exception("JWT expired: exp=" + r113 + " now=" + r111);
    L28:
        LogUtils.d(r2, "verify: time validation OK (now=" + r111 + ")");
        if (r15.has(FIELD_OPCC) == false) goto L98;
        JsonObject r23 = r15.getAsJsonObject(FIELD_OPCC);
        if (r23.has(FIELD_APP_ID) == false) goto L33;
        String r24 = r23.get(FIELD_APP_ID).getAsString();
    L35:
        if (r23.has(FIELD_SVC_ID) == false) goto L38;
        r13 = r23.get(FIELD_SVC_ID).getAsString();
    L38:
        if (r17.equals(r24) == false) goto L96;
        if (r18.equals(r13) == false) goto L94;
        LogUtils.i(r2, "verify: business fields OK (app_id=" + r17 + " svc_id=" + r18 + ")");
        if (r23.has(FIELD_TOKEN_SECURITY_LEVEL) == false) goto L44;
        int r25 = r23.get(FIELD_TOKEN_SECURITY_LEVEL).getAsInt();
    L45:
        String r0 = CryptoUtils.toHex(CryptoUtils.toHex(computeReportData(r17, r18, r19, r20, r21)).getBytes(StandardCharsets.UTF_8));
        if (r25 == 1) goto L48;
        if (r25 != 2) goto L91;
        String r26 = null;
        if (r15.has(FIELD_TDX) == false) goto L60;
        JsonObject r1 = r15.getAsJsonObject(FIELD_TDX);
    L61:
        if (r1 == null) goto L90;
        if (r1.has("quote") == false) goto L65;
        JsonObject r27 = r1.getAsJsonObject("quote");
    L66:
        if (r27 == null) goto L88;
        if (r27.has(ProviderConstants.Sms.BODY) == false) goto L70;
        JsonObject r28 = r27.getAsJsonObject(ProviderConstants.Sms.BODY);
    L71:
        if (r28 == null) goto L86;
        if (r28.has(FIELD_REPORT_DATA) == false) goto L75;
        r26 = r28.get(FIELD_REPORT_DATA).getAsString();
    L75:
        if (r26 == null) goto L84;
        if (TextUtils.equals(r0, r26) == false) goto L82;
        LogUtils.i(r2, "verify: token_security_level=2 tdx.report_data match OK");
    L79:
        LogUtils.i(r2, "verify: JWT evidence token verification completed successfully");
        return true;
    L82:
        throw new Exception("token_security_level=2 tdx.report_data mismatch");
    L84:
        throw new Exception("token_security_level=2 but tdx.quote.body.report_data is missing");
    L86:
        throw new Exception("token_security_level=2 but tdx.quote.body is missing");
    L70:
        r28 = null;
        goto L71
    L88:
        throw new Exception("token_security_level=2 but tdx.quote is missing");
    L65:
        r27 = null;
        goto L66
    L90:
        throw new Exception("token_security_level=2 but tdx is missing");
    L60:
        r1 = null;
        goto L61
    L91:
        LogUtils.e(r2, "verify: unknown token_security_level=" + r25);
        return false;
    L48:
        if (r23.has(FIELD_USER_DATA) == false) goto L55;
        if (TextUtils.equals(r0, r23.get(FIELD_USER_DATA).getAsString()) == false) goto L53;
        LogUtils.d(r2, "verify: token_security_level=1 user_data match OK");
        goto L79
    L53:
        throw new Exception("token_security_level=1 opcc.user_data mismatch");
    L55:
        throw new Exception("token_security_level=1 but opcc.user_data is missing");
    L44:
        r25 = 0;
        goto L45
    L94:
        throw new Exception("opcc.svc_id mismatch: expected=" + r18 + " got=" + r13);
    L96:
        throw new Exception("opcc.app_id mismatch: expected=" + r17 + " got=" + r24);
    L33:
        r24 = "";
        goto L35
    L98:
        throw new Exception("JWT payload missing 'opcc' field");
    L100:
        throw new Exception("JWT ECDSA signature verification failed");
    L102:
        throw new Exception("JWT payload missing 'jwk' field");
    L104:
        throw new Exception("unsupported JWT alg: '" + r12 + "', expected ES256");
    L7:
        r12 = "";
        goto L9
    L106:
        throw new Exception("invalid JWT format: expected 3 parts, got " + r3.length);
    }

    private static PublicKey verifyJwkCertChain(JsonObject r8, String r9) throws Exception {
        if (r8.has(FIELD_X5C) == false) goto L24;
        JsonArray r10 = r8.getAsJsonArray(FIELD_X5C);
        if (r10.size() == 0) goto L22;
        CertificateFactory r0 = CertificateFactory.getInstance("X.509");
        int r1 = r10.size();
        X509Certificate[] r2 = new X509Certificate[r1];
        int r4 = 0;
    L8:
        if (r4 >= r10.size()) goto L10;
        r2[r4] = (X509Certificate) r0.generateCertificate(new ByteArrayInputStream(Base64.decode(r10.get(r4).getAsString(), 0)));
        r4 = r4 + 1;
        goto L8
    L10:
        int r11 = 0;
    L11:
        int r5 = r1 - 1;
        if (r11 >= r5) goto L14;
        int r6 = r11 + 1;
        r2[r11].verify(r2[r6].getPublicKey());
        LogUtils.d(TAG, "verifyJwkCertChain: cert[" + r11 + "] verified by cert[" + r6 + "]");
        r11 = r6;
        goto L11
    L14:
        if (r9 != null) goto L16;
    L18:
        LogUtils.w(TAG, "verifyJwkCertChain: attestation root cert not configured (TODO), skipping root trust anchor check");
    L20:
        return r2[0].getPublicKey();
    L16:
        if (r9.isEmpty() == true) goto L18;
        r2[r5].verify(((X509Certificate) r0.generateCertificate(new ByteArrayInputStream(r9.getBytes(StandardCharsets.UTF_8)))).getPublicKey());
        LogUtils.d(TAG, "verifyJwkCertChain: top cert verified against attestation root");
        goto L20
    L22:
        throw new Exception("JWK x5c array is empty");
    L24:
        throw new Exception("JWK missing 'x5c' field");
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
        if ((r4[r0] & ByteCompanionObject.MIN_VALUE) == 0) goto L13;
        byte[] r1 = new byte[(r4.length - r0) + 1];
        System.arraycopy(r4, r0, r1, 1, r4.length - r0);
        return r1;
    L13:
        return Arrays.copyOfRange(r4, r0, r4.length);
    }

    private static byte[] computeReportData(String r2, String r3, String r4, String r5, List<CreateChannelResponse.SvcPod> r6) throws Exception {
        MessageDigest r0 = MessageDigest.getInstance("SHA-256");
        r0.update(r2.getBytes(StandardCharsets.UTF_8));
        r0.update(r3.getBytes(StandardCharsets.UTF_8));
        r0.update(r4.getBytes(StandardCharsets.UTF_8));
        r0.update(r5.getBytes(StandardCharsets.UTF_8));
        if (r6 == null) goto L18;
        ArrayList r7 = new ArrayList(r6);
        r7.sort(Comparator.comparingInt(new EvidenceTokenVerifier$$ExternalSyntheticLambda0()));
        int r8 = 0;
    L6:
        if (r8 >= r7.size()) goto L18;
        CreateChannelResponse.SvcPod r9 = (CreateChannelResponse.SvcPod) r7.get(r8);
        if (r9.getSvcPodId() == null) goto L11;
        r0.update(r9.getSvcPodId().getBytes(StandardCharsets.UTF_8));
    L11:
        if (r9.getSvcPodKeyVersion() == null) goto L14;
        r0.update(r9.getSvcPodKeyVersion().getBytes(StandardCharsets.UTF_8));
    L14:
        if (r9.getSvcPodPubKey() == null) goto L16;
        r0.update(r9.getSvcPodPubKey().getBytes(StandardCharsets.UTF_8));
    L16:
        r8 = r8 + 1;
    L18:
        return r0.digest();
    }
}
