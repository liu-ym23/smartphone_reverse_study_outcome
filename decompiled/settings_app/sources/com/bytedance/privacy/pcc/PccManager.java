package com.bytedance.privacy.pcc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.android.settings.search.Index;
import com.bytedance.privacy.network.NetworkConfig;
import com.bytedance.privacy.pcc.db.LaneTypeInfo;
import com.bytedance.privacy.pcc.db.PccChannelDb;
import com.bytedance.privacy.pcc.network.PccNetworkManager;
import com.bytedance.privacy.pcc.network.model.ChallengeResponse;
import com.bytedance.privacy.pcc.network.model.CreateChannelRequest;
import com.bytedance.privacy.pcc.network.model.CreateChannelResponse;
import com.bytedance.privacy.pcc.network.model.UploadChannelRetRequest;
import com.bytedance.privacy.utils.LogUtils;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class PccManager {
    private static final String CLOUD_CERT_BOE = "-----BEGIN CERTIFICATE-----\nMIICNTCCAdqgAwIBAgIUGJmWDf76XK7QEDg7ePQ6Zp5a/QAwCgYIKoZIzj0EAwIw\nVzESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMSAwHgYDVQQDExdCeXRlRGFuY2UgU21hcnQgU0lHTiBDQTAeFw0yNjAz\nMDQwODE4MzVaFw00MTAyMjgwODI4MzRaMGUxEjAQBgNVBAoTCUJ5dGVEYW5jZTEf\nMB0GA1UECxMWQnl0ZURhbmNlIFNtYXJ0IERldmljZTEuMCwGA1UEAxMlQk9FIEJ5\ndGVEYW5jZSBTbWFydCBTaWduIE9QQ0MgR2F0ZXdheTBZMBMGByqGSM49AgEGCCqG\nSM49AwEHA0IABM25nWwFbu/tBeKoSdmqIEFzkGsiNlVBzp++3/y3PSAl3X5JQ98U\nkN8af1gEabmQWsnQ6rfAu+/3N1eLdaeyAH+jdjB0MAwGA1UdEwEB/wQCMAAwHwYD\nVR0jBBgwFoAUI3ocFBGPZx1O0yRJxLCCPmaMCkwwQwYIKwYBBQUHAQEENzA1MDMG\nCCsGAQUFBzABhidodHRwOi8vbmV4dXMtYm9lLmJ5dGVkYW5jZS5uZXQvcGNhL29j\nc3AwCgYIKoZIzj0EAwIDSQAwRgIhANzuvWkxo2IGpnbJNEWvZRuyp/brvmy9u76P\nRj9AkGSzAiEAuxwuHmrS6OmMWFi5ha9DpqLJijiXzNEKcdVYsJuAFTY=\n-----END CERTIFICATE-----";
    private static final String CLOUD_CERT_ONLINE = "-----BEGIN CERTIFICATE-----\nMIICODCCAd2gAwIBAgIUGJmcpAzL0+i5GIb6FxhoxPQSMtswCgYIKoZIzj0EAwIw\nVzESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMSAwHgYDVQQDExdCeXRlRGFuY2UgU21hcnQgU0lHTiBDQTAeFw0yNjAz\nMDQxMDE5MTZaFw00MTAyMjgxMDI5MTZaMGExEjAQBgNVBAoTCUJ5dGVEYW5jZTEf\nMB0GA1UECxMWQnl0ZURhbmNlIFNtYXJ0IERldmljZTEqMCgGA1UEAxMhQnl0ZURh\nbmNlIFNtYXJ0IFNpZ24gT1BDQyBHYXRld2F5MFkwEwYHKoZIzj0CAQYIKoZIzj0D\nAQcDQgAE1eO/rIuiv0g/zgUMel9/Jyv3msFzoimqEuwjFIRJGKKe51ONP9jMv7zP\ng/IuRK5HFR3IMZYjz507Az0wuT8jIKN9MHswDAYDVR0TAQH/BAIwADAfBgNVHSME\nGDAWgBRgISfbugqIUe075DXEeifDk4vhATBKBggrBgEFBQcBAQQ+MDwwOgYIKwYB\nBQUHMAGGLmh0dHA6Ly9uZXh1cy1wcm9kdWN0aW9uLmJ5dGVkYW5jZS5uZXQvcGNh\nL29jc3AwCgYIKoZIzj0EAwIDSQAwRgIhAM5X3JaXiaAD1sFDDFpRB5rNQS3G7mSc\nGDbtKnvJ3SQ4AiEAwH5JexV4T1BLcNoZctl6iOo5JeUbEwZ11lVi0fzXPI0=\n-----END CERTIFICATE-----";
    private static final int DATA_PROTOCOL_VERSION = 2;
    public static final String HEADER_LANE_TYPE = "rpc-persist-lane-c-ocean-secure";
    private static final int KEY_ENVELOPE_VERSION = 2;
    public static final String KEY_ERROR_CODE = "error_code";
    public static final String KEY_LANE_TYPE = "lane_type";

    @Deprecated
    public static final int LANE_TYPE_CPU_NORMAL = 1;

    @Deprecated
    public static final int LANE_TYPE_CPU_TEE = 2;

    @Deprecated
    public static final int LANE_TYPE_GPU_TEE = 3;

    @Deprecated
    public static final int LANE_TYPE_IGNORE = 0;
    private static final int MAX_STRING_LENGTH = 512;
    private static final String PCC_CLIENT_VERSION = "2.0.0";
    private static final String PCC_PROTOCOL_VERSION = "2.0";
    private static final String PCC_SIGN_KEY_ALIAS = "pcc_sign_key";
    private static final String TAG = "PccManager";
    private static volatile PccManager pccManager;
    private Context appContext;
    private PccChannelDb channelDb;
    private final Map<String, SessionContext> sessionContextCache;

    private static class SessionContext {
        final String accessToken;
        final AppInfo appInfo;
        final int bizType;
        final KeyPair ephemeralKeyPair;
        final CreateChannelResponse.SvcKeyInfo keyInfo;
        final byte[] sessionKey;

        SessionContext(AppInfo r1, int r2, String r3, KeyPair r4, CreateChannelResponse.SvcKeyInfo r5, byte[] r6) {
            this.appInfo = r1;
            this.bizType = r2;
            this.accessToken = r3;
            this.ephemeralKeyPair = r4;
            this.keyInfo = r5;
            this.sessionKey = r6;
        }
    }

    static {
    }

    public String getVersion() {
        return PCC_PROTOCOL_VERSION;
    }

    private PccManager() {
        this.sessionContextCache = new ConcurrentHashMap();
    }

    public static PccManager getInstance(Context r2) {
        if (pccManager != null) goto L15;
        monitor-enter(PccManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (pccManager != null) goto L9;
        pccManager = new PccManager();     // Catch: Throwable -> L11
        pccManager.attachContext(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(PccManager.class);     // Catch: Throwable -> L11
    L15:
        return pccManager;
    }

    private void attachContext(Context r2) {
        if (r2 == null) goto L5;
        this.appContext = r2.getApplicationContext();
        this.channelDb = new PccChannelDb(this.appContext);
        return;
    }

    private static boolean isValidString(String r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.length() <= 0) goto L8;
        if (r1.length() >= 512) goto L8;
        return true;
    }

    private static boolean isValidBytes(byte[] r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.length <= 0) goto L6;
        return true;
    }

    private static boolean isValidAppInfo(AppInfo r1) {
        if (r1 != null) goto L4;
    L12:
        return false;
    L4:
        if (isValidString(r1.rpdid) == false) goto L12;
        if (isValidString(r1.rpuid) == false) goto L12;
        if (isValidString(r1.appId) == false) goto L12;
        if (isValidString(r1.appSvcId) == false) goto L12;
        return true;
    }

    public Bundle init(AppInfo r29, Bundle r30) {
        if (this.appContext != null) goto L7;
        LogUtils.e(TAG, "init failed: context not attached");
        return createResultBundle(-31, 1);
    L7:
        if (isValidAppInfo(r29) == true) goto L10;
        LogUtils.e(TAG, "init failed: invalid params (null, empty, or exceeds max length)");
        return createResultBundle(-2, 1);
    L10:
        LaneType r5 = LaneType.CPU_NORMAL;
        if (r30.containsKey(KEY_LANE_TYPE) == false) goto L17;
        int r2 = r30.getInt(KEY_LANE_TYPE, LaneType.CPU_NORMAL.getValue());
        if (LaneType.isValid(r2) == true) goto L16;
        LogUtils.e(TAG, "init failed: invalid lane_type=" + r2 + " (must be 0-3)");
        return createResultBundle(-2, LaneType.CPU_NORMAL);
    L16:
        r5 = LaneType.fromValue(r2);
    L17:
        String r3 = TAG;
        LogUtils.i(r3, "init called: appId=" + r29.appId + ", appSvcId=" + r29.appSvcId + ", rpdid=" + r29.rpdid + ", rpuid=" + r29.rpuid + ", clientLaneType=" + r5);
        CreateChannelResponse r6 = queryChannelFromDb(r29);
        if (r6 != null) goto L20;
    L31:
        LogUtils.i(r3, "init: no valid cached channel, proceeding with network flow");
        HashMap r7 = new HashMap();
        r7.put(HEADER_LANE_TYPE, String.valueOf(r5.getValue()));
        String r9 = UUID.randomUUID().toString();
        ChallengeResponse r11 = PccNetworkManager.getInstance().requestChallenge(r9, r7);
        if (r11 != null) goto L34;
    L71:
        LogUtils.e(r3, "init failed: get PCC challenge failed");
        return createResultBundle(-31, r5);
    L34:
        if (TextUtils.isEmpty(r11.getNonce()) == true) goto L71;
        String r12 = r11.getNonce();
        LaneType r13 = LaneType.fromValue(r11.getType());
        LaneType r14 = LaneType.negotiate(r5, r13);
        LogUtils.i(r3, "Lane routing decision: client=" + r5 + ", server=" + r13 + ", final=" + r14);
        r7.put(HEADER_LANE_TYPE, String.valueOf(r14.getValue()));
        String r10 = KeyAttestationHelper.generateAndAttestSignKey(this.appContext, PCC_SIGN_KEY_ALIAS, r12, r29.rpdid, r29.rpuid);     // Catch: Exception -> L68
        LogUtils.i(r3, "init: cleaned up " + this.channelDb.deleteOtherRpuidChannels(r29.rpdid, r29.rpuid, r29.appId, r29.appSvcId) + " old channel(s) for other rpuids");
        String r4 = String.valueOf(System.currentTimeMillis());
        byte[] r8 = new byte[8];
        new SecureRandom().nextBytes(r8);
        String r15 = CryptoUtils.toHex(r8);
        String r16 = Base64.encodeToString(new CreateChannelRequest.Payload(PCC_CLIENT_VERSION, r15, r29).toJsonString().getBytes(StandardCharsets.UTF_8), 11);
        CreateChannelResponse r17 = PccNetworkManager.getInstance().createChannel(r9, r4, new CreateChannelRequest(r10, r16, Base64.encodeToString(KeyAttestationHelper.sign(this.appContext, PCC_SIGN_KEY_ALIAS, (r9 + Index.ENTRIES_SEPARATOR + r4 + Index.ENTRIES_SEPARATOR + r16).getBytes(StandardCharsets.UTF_8)), 11)).toJsonString(), r7);
        if (r17 != null) goto L45;
        LogUtils.e(r3, "init failed: createChannel returned null");
        return createResultBundle(-31, r14);
    L45:
        if (verifyCloudSignature(r17) == true) goto L49;
        LogUtils.e(r3, "init failed: cloud response signature verification failed");
        return createResultBundle(-31, r14);
    L49:
        if (verifyEvidenceToken(r17, r12, r15, r29) == true) goto L53;
        LogUtils.e(r3, "init failed: evidence token verification failed");
        return createResultBundle(-31, r14);
    L53:
        if (this.channelDb.save(r29.rpdid, r29.rpuid, r29.appId, r29.appSvcId, r17, 2, new LaneTypeInfo(r5.getValue(), r13.getValue(), r14.getValue())) == true) goto L56;
        LogUtils.e(r3, "init warning: failed to persist channel data to DB");
    L56:
        if (this.channelDb.saveKeyAttestationHistory(r29.rpdid, r29.rpuid, r29.appId, r29.appSvcId, r17) == true) goto L58;
        LogUtils.e(r3, "init warning: failed to save key attestation history");
    L58:
        LogUtils.i(r3, "init success, channelId=" + r17.getChannelId() + ", finalLaneType=" + r14 + " (value=" + r14.getValue() + ")");
        String r0 = Base64.encodeToString(new UploadChannelRetRequest.Payload(PCC_CLIENT_VERSION, r29, r17.getChannelId(), "0").toJsonString().getBytes(StandardCharsets.UTF_8), 11);
        String r18 = String.valueOf(System.currentTimeMillis());
        LogUtils.i(r3, "init: uploadChannelRet logId=" + PccNetworkManager.getInstance().uploadChannelRet(r9, r18, new UploadChannelRetRequest(r0, Base64.encodeToString(KeyAttestationHelper.sign(this.appContext, PCC_SIGN_KEY_ALIAS, (r9 + Index.ENTRIES_SEPARATOR + r18 + Index.ENTRIES_SEPARATOR + r0).getBytes(StandardCharsets.UTF_8)), 11)).toJsonString()));     // Catch: Exception -> L61
    L64:
        return createResultBundle(0, r14);
    L61:
        e = move-exception;
        LogUtils.e(TAG, "init: uploadChannelRet sign failed (non-fatal): " + e.getMessage());
    L65:
        e = move-exception;
        LogUtils.e(TAG, "init failed: sign request: " + e.getMessage());
        return createResultBundle(-31, r14);
    L68:
        e = move-exception;
        LogUtils.e(TAG, "init failed: attestation: " + e.getMessage());
        return createResultBundle(-31, r14);
    L20:
        if (isChannelExpired(r6) == true) goto L31;
        if (r6.getProtocolVersion() != 2) goto L31;
        LaneTypeInfo r19 = this.channelDb.getLaneTypeInfo(r29.rpdid, r29.rpuid, r29.appId, r29.appSvcId);
        if (r19 != null) goto L26;
    L28:
        if (r19 == null) goto L31;
        LogUtils.i(r3, "init: using valid cached V2 channel " + r19);
        return createResultBundle(0, LaneType.fromValue(r19.finalLaneType));
    L26:
        if (r19.clientLaneType == r5.getValue()) goto L28;
        LogUtils.i(r3, "init: client lane_type changed (cached=" + r19.clientLaneType + ", requested=" + r5.getValue() + "), deleting old channel and re-negotiating");
        this.channelDb.delete(r29.rpdid, r29.rpuid, r29.appId, r29.appSvcId);
        goto L31
    }

    private Bundle createResultBundle(int r1, LaneType r2) {
        return createResultBundle(r1, r2.getValue());
    }

    private Bundle createResultBundle(int r2, int r3) {
        Bundle r1 = new Bundle();
        r1.putInt("error_code", r2);
        r1.putInt(KEY_LANE_TYPE, r3);
        return r1;
    }

    public Bundle openSecuritySession(String r16, AppInfo r17, Bundle r18) {
        String r9 = TAG;
        LogUtils.d(r9, "openSecuritySession called: sessionId=" + r16);
        if (isValidString(r16) == true) goto L7;
        LogUtils.e(r9, "openSecuritySession failed: invalid sessionId (null, empty, or exceeds max length)");
        return createResultBundle(-2, LaneType.CPU_NORMAL);
    L7:
        if (isValidAppInfo(r17) == true) goto L10;
        LogUtils.e(r9, "openSecuritySession failed: invalid appInfo (null, empty, or exceeds max length)");
        return createResultBundle(-2, LaneType.CPU_NORMAL);
    L10:
        LaneType r4 = LaneType.CPU_NORMAL;
        if (r18.containsKey(KEY_LANE_TYPE) == false) goto L17;
        int r5 = r18.getInt(KEY_LANE_TYPE, LaneType.CPU_NORMAL.getValue());
        if (LaneType.isValid(r5) == true) goto L16;
        LogUtils.e(r9, "openSecuritySession failed: invalid lane_type=" + r5 + " (must be 0-3)");
        return createResultBundle(-2, LaneType.CPU_NORMAL);
    L16:
        r4 = LaneType.fromValue(r5);
    L17:
        CreateChannelResponse r6 = queryChannelFromDb(r17);
        boolean r7 = true;
        if (r6 != null) goto L20;
    L31:
        LogUtils.d(r9, "openSecuritySession: channel missing or expired, re-initialising");
    L32:
        LaneType r8 = r4;
    L34:
        if (r7 == false) goto L43;
        Bundle r2 = init(r17, r18);
        int r10 = r2.getInt("error_code", -31);
        if (r10 == 0) goto L39;
        LogUtils.e(r9, "openSecuritySession failed: re-init returned " + r10);
        return r2;
    L39:
        r8 = LaneType.fromValue(r2.getInt(KEY_LANE_TYPE, r4.getValue()));
        r6 = queryChannelFromDb(r17);
        if (r6 != null) goto L43;
        LogUtils.e(r9, "openSecuritySession failed: channel still null after re-init");
        return createResultBundle(-31, r8);
    L43:
        LaneType r12 = r8;
        CreateChannelResponse.ServiceInfo r3 = r6.getServiceInfo();
        if (r3 != null) goto L46;
    L54:
        LogUtils.e(r9, "openSecuritySession failed: service key info is empty");
        return createResultBundle(-31, r12);
    L46:
        if (r3.getAppSvcKeyInfo() == null) goto L54;
        KeyPair r11 = CryptoUtils.generateEphemeralEcKeyPair();     // Catch: Exception -> L51
        byte[] r13 = new byte[32];
        new SecureRandom().nextBytes(r13);
        this.sessionContextCache.put(r16, new SessionContext(r17, 1, r6.getAccessToken(), r11, r3.getAppSvcKeyInfo(), r13));
        LogUtils.d(r9, "openSecuritySession success: sessionId=" + r16 + ", finalLaneType=" + r12.getValue());
        return createResultBundle(0, r12);
    L51:
        e = move-exception;
        LogUtils.e(TAG, "openSecuritySession failed: generate ephemeral key pair: " + e.getMessage());
        return createResultBundle(-31, r12);
    L20:
        if (isChannelExpired(r6) == true) goto L31;
        LaneTypeInfo r14 = this.channelDb.getLaneTypeInfo(r17.rpdid, r17.rpuid, r17.appId, r17.appSvcId);
        if (r14 != null) goto L25;
    L27:
        if (r14 == null) goto L29;
        r8 = LaneType.fromValue(r14.finalLaneType);
    L30:
        r7 = false;
        goto L34
    L29:
        r8 = r4;
        goto L30
    L25:
        if (r14.clientLaneType == r4.getValue()) goto L27;
        LogUtils.i(r9, "openSecuritySession: client lane_type changed (cached=" + r14.clientLaneType + ", requested=" + r4.getValue() + "), re-initialising");
        goto L32
    }

    public byte[] dataEncryptBytes(String r14, byte[] r15) {
        String r6 = TAG;
        LogUtils.d(r6, "dataEncryptBytes called: sessionId=" + r14);
        if (isValidString(r14) == true) goto L6;
        LogUtils.e(r6, "dataEncryptBytes failed: invalid sessionId (null, empty, or exceeds max length)");
        return null;
    L6:
        if (r15 != null) goto L9;
        LogUtils.e(r6, "dataEncryptBytes failed: data is null");
        return null;
    L9:
        SessionContext r7 = this.sessionContextCache.get(r14);
        if (r7 != null) goto L38;
        LogUtils.e(r6, "dataEncryptBytes failed: session not found");
        return null;
    L38:
        byte[] r9 = new byte[12];     // Catch: Exception -> L33
        new SecureRandom().nextBytes(r9);     // Catch: Exception -> L33
        LogUtils.d(r6, "dataEncryptBytes plainLen=" + r15.length);     // Catch: Exception -> L33
        byte[] r16 = CryptoUtils.aesGcmEncrypt(r7.sessionKey, r9, r15);     // Catch: Exception -> L33
        LogUtils.d(r6, "dataEncryptBytes ciphertextLen=" + r16.length);     // Catch: Exception -> L33
        EncryptedPayloadTlv r4 = new EncryptedPayloadTlv();     // Catch: Exception -> L33
        r4.metaInfo = new EncryptedPayloadTlv.MetaInfo();     // Catch: Exception -> L33
        r4.metaInfo.version = 2;     // Catch: Exception -> L33
        r4.metaInfo.contentType = 1;     // Catch: Exception -> L33
        EncryptedPayloadTlv.BizAttribute r5 = new EncryptedPayloadTlv.BizAttribute();     // Catch: Exception -> L33
        r5.appId = r7.appInfo.appId;     // Catch: Exception -> L33
        r5.serviceId = r7.appInfo.appSvcId;     // Catch: Exception -> L33
        r5.bizType = r7.bizType;     // Catch: Exception -> L33
        r5.sessionKeyId = r14.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L33
        if (r7.accessToken == null) goto L17;
        byte[] r17 = r7.accessToken.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L33
    L18:
        r5.accessToken = r17;     // Catch: Exception -> L33
        r4.metaInfo.bizAttribute = r5;     // Catch: Exception -> L33
        byte[] r18 = CryptoUtils.ecPubKeyToUncompressed(r7.ephemeralKeyPair.getPublic());     // Catch: Exception -> L33
        r4.keyEnvelopePayload = new EncryptedPayloadTlv.KeyEnvelopePayload();     // Catch: Exception -> L33
        r4.keyEnvelopePayload.version = 2;     // Catch: Exception -> L33
        r4.keyEnvelopePayload.envelopeType = 1;     // Catch: Exception -> L33
        r4.keyEnvelopePayload.keyEnvelopeList = new ArrayList();     // Catch: Exception -> L33
        CreateChannelResponse.SvcKeyInfo r8 = r7.keyInfo;     // Catch: Exception -> L33
        byte[] r10 = new byte[16];     // Catch: Exception -> L33
        new SecureRandom().nextBytes(r10);     // Catch: Exception -> L33
        LogUtils.i(r6, "dataEncryptBytes keyId=" + r8.getSvcKeyId() + " keyType=" + r8.getSvcKeyType() + " keyVer=" + r8.getSvcKeyVersion());     // Catch: Exception -> L33
        if (r8.getSvcKeyId() != null) goto L23;
        LogUtils.e(r6, "dataEncryptBytes failed: svcKeyId is null");     // Catch: Exception -> L33
        return null;
    L23:
        if (r8.getSvcPubKey() != null) goto L26;
        LogUtils.e(r6, "dataEncryptBytes failed: svcPubKey is null (keyId=" + r8.getSvcKeyId() + ")");     // Catch: Exception -> L33
        return null;
    L26:
        byte[] r2 = CryptoUtils.eciesWrapKey(r7.ephemeralKeyPair.getPrivate(), r18, r8.getSvcPubKey(), r10, r7.sessionKey);     // Catch: Exception -> L33
        EncryptedPayloadTlv.KeyEnvelope r3 = new EncryptedPayloadTlv.KeyEnvelope();     // Catch: Exception -> L33
        r3.index = 1;     // Catch: Exception -> L33
        r3.keyIdentify = r8.getSvcKeyId().getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L33
        r3.keyVersion = parseKeyVersion(r8.getSvcKeyVersion());     // Catch: Exception -> L33
        r3.keyEncryptionAlgorithm = 1;     // Catch: Exception -> L33
        r3.dhPK = r18;     // Catch: Exception -> L33
        r3.salt = r10;     // Catch: Exception -> L33
        r3.encryptedSessionKey = r2;     // Catch: Exception -> L33
        r4.keyEnvelopePayload.keyEnvelopeList.add(r3);     // Catch: Exception -> L33
        r4.keyEnvelopePayload.keyEnvelopeListSize = 1;     // Catch: Exception -> L33
        r4.contentInfoMeta = new EncryptedPayloadTlv.ContentInfoMeta();     // Catch: Exception -> L33
        r4.contentInfoMeta.contentType = 1;     // Catch: Exception -> L33
        r4.contentInfoMeta.contentEncryptionAlgorithm = 1;     // Catch: Exception -> L33
        EncryptedPayloadTlv.OtherKeyAttribute r19 = new EncryptedPayloadTlv.OtherKeyAttribute();     // Catch: Exception -> L33
        r19.nonce = r9;     // Catch: Exception -> L33
        r4.contentInfoMeta.otherKeyAttribute = r19;     // Catch: Exception -> L33
        byte[] r13 = KeyAttestationHelper.sign(this.appContext, PCC_SIGN_KEY_ALIAS, r4.encodeSignedPortion());     // Catch: Exception -> L30
        EncryptedPayloadTlv.SignContentInfo r110 = new EncryptedPayloadTlv.SignContentInfo();     // Catch: Exception -> L30
        r110.signatureAlgorithm = 1;     // Catch: Exception -> L30
        r110.contentSignature = r13;     // Catch: Exception -> L30
        r4.signContentInfo = r110;     // Catch: Exception -> L30
        byte[] r111 = new EncryptedProtocol(r4, r16).encode();     // Catch: Exception -> L33
        LogUtils.d(r6, "dataEncryptBytes success: encodedLen=" + r111.length);     // Catch: Exception -> L33
        return r111;
    L30:
        e = move-exception;
        LogUtils.e(TAG, "dataEncryptBytes failed: sign TLV: " + e.getMessage());     // Catch: Exception -> L33
        return null;
    L17:
        r17 = new byte[0];     // Catch: Exception -> L33
    L33:
        e = move-exception;
        LogUtils.e(TAG, "dataEncryptBytes exception: " + Log.getStackTraceString(e));
        return null;
    }

    public String dataEncrypt(String r1, byte[] r2) {
        byte[] r0 = dataEncryptBytes(r1, r2);
        if (r0 != null) goto L6;
        return null;
    L6:
        return Base64.encodeToString(r0, 11);
    }

    public byte[] dataDecryptBytes(String r7, byte[] r8) {
        String r3 = TAG;
        LogUtils.d(r3, "dataDecryptBytes called: sessionId=" + r7);
        if (isValidString(r7) == true) goto L6;
        LogUtils.e(r3, "dataDecryptBytes failed: invalid sessionId (null, empty, or exceeds max length)");
        return null;
    L6:
        if (r8 != null) goto L8;
    L34:
        LogUtils.e(r3, "dataDecryptBytes failed: invalid data (null, empty)");
        return null;
    L8:
        if (r8.length == 0) goto L34;
        SessionContext r6 = this.sessionContextCache.get(r7);
        if (r6 != null) goto L36;
        LogUtils.e(r3, "dataDecryptBytes failed: session not found");
        return null;
    L36:
        LogUtils.d(r3, "dataDecryptBytes encodedLen=" + r8.length);     // Catch: Exception -> L31
        EncryptedProtocol r9 = EncryptedProtocol.decode(r8);     // Catch: Exception -> L31
        EncryptedPayloadTlv r10 = r9.tlvData;     // Catch: Exception -> L31
        byte[] r11 = r9.body;     // Catch: Exception -> L31
        if (r10.contentInfoMeta != null) goto L17;
    L29:
        LogUtils.e(r3, "dataDecryptBytes failed: missing ContentInfoMeta or nonce");     // Catch: Exception -> L31
        return null;
    L17:
        if (r10.contentInfoMeta.otherKeyAttribute == null) goto L29;
        if (r10.contentInfoMeta.otherKeyAttribute.nonce == null) goto L29;
        if (r11 != null) goto L23;
    L27:
        LogUtils.e(r3, "dataDecryptBytes failed: no ciphertext in Body");     // Catch: Exception -> L31
        return null;
    L23:
        if (r11.length == 0) goto L27;
        byte[] r12 = r10.contentInfoMeta.otherKeyAttribute.nonce;     // Catch: Exception -> L31
        LogUtils.d(r3, "dataDecryptBytes ciphertextLen=" + r11.length);     // Catch: Exception -> L31
        byte[] r13 = CryptoUtils.aesGcmDecrypt(r6.sessionKey, r12, r11);     // Catch: Exception -> L31
        LogUtils.d(r3, "dataDecryptBytes success: plaintextLen=" + r13.length);     // Catch: Exception -> L31
        return r13;
    L31:
        e = move-exception;
        LogUtils.e(TAG, "dataDecryptBytes exception: " + e.getMessage());
        return null;
    }

    public byte[] dataDecrypt(String r3, String r4) {
        if (r4 != null) goto L5;
    L13:
        LogUtils.e(TAG, "dataDecrypt failed: invalid data (null, empty)");
        return null;
    L5:
        if (r4.length() == 0) goto L13;
        return dataDecryptBytes(r3, Base64.decode(r4, 8));
    L10:
        e = move-exception;
        LogUtils.e(TAG, "dataDecrypt failed: invalid Base64 data: " + e.getMessage());
        return null;
    }

    public int closeSecuritySession(String r4) {
        String r0 = TAG;
        LogUtils.d(r0, "closeSecuritySession called: sessionId=" + r4);
        if (isValidString(r4) == true) goto L7;
        LogUtils.e(r0, "closeSecuritySession failed: invalid sessionId (null, empty, or exceeds max length)");
        return -2;
    L7:
        if (this.sessionContextCache.get(r4) != null) goto L10;
        LogUtils.e(r0, "closeSecuritySession failed: session not found, sessionId=" + r4);
        return -32;
    L10:
        this.sessionContextCache.remove(r4);
        LogUtils.d(r0, "closeSecuritySession success: sessionId=" + r4);
        return 0;
    }

    private CreateChannelResponse queryChannelFromDb(AppInfo r4) {
        PccChannelDb r3 = this.channelDb;
        if (r3 != null) goto L7;
        LogUtils.e(TAG, "queryChannelFromDb: DB not ready");
        return null;
    L7:
        return r3.query(r4.rpdid, r4.rpuid, r4.appId, r4.appSvcId);
    }

    private boolean verifyCloudSignature(CreateChannelResponse r6) {
        boolean r5 = NetworkConfig.getInstance().isBoeEnv();
        if (r5 == false) goto L5;
        String r0 = CLOUD_CERT_BOE;
    L6:
        String r1 = TAG;
        if (r5 == false) goto L9;
        String r7 = "BOE";
    L10:
        LogUtils.d(r1, "verifyCloudSignature: env=".concat(r7));
        if (TextUtils.isEmpty(r6.getSignature()) == false) goto L22;
        LogUtils.e(r1, "verifyCloudSignature: server signature is empty");
        return false;
    L22:
        boolean r8 = CryptoUtils.verifyEcdsaSignature(r0, (r6.getResponseId() + Index.ENTRIES_SEPARATOR + r6.getPayloadJson()).getBytes(StandardCharsets.UTF_8), Base64.decode(r6.getSignature(), 8));     // Catch: Exception -> L19
        if (r8 == true) goto L17;
        LogUtils.e(r1, "verifyCloudSignature: ECDSA verification failed");     // Catch: Exception -> L19
    L18:
        return r8;
    L17:
        LogUtils.i(r1, "verifyCloudSignature: signature valid");     // Catch: Exception -> L19
    L19:
        e = move-exception;
        LogUtils.e(TAG, "verifyCloudSignature exception: " + e.getMessage());
        return false;
    L9:
        r7 = "Online";
        goto L10
    L5:
        r0 = CLOUD_CERT_ONLINE;
        goto L6
    }

    private boolean isChannelExpired(CreateChannelResponse r8) {
        String r7 = r8.getChannelExpiryTime();
        if (TextUtils.isEmpty(r7) == false) goto L13;
        return true;
    L13:
        if ((System.currentTimeMillis() / 1000) >= Long.parseLong(r7)) goto L15;
        return false;
    L15:
        return true;
    L11:
        LogUtils.e(TAG, "isChannelExpired: invalid expiry format: " + r7);
        return true;
    }

    private boolean verifyEvidenceToken(CreateChannelResponse r9, String r10, String r11, AppInfo r12) {
        CreateChannelResponse.EvidenceInfo r0 = r9.getEvidenceInfo();
        if (r0 != null) goto L6;
        LogUtils.e(TAG, "verifyEvidenceToken: evidence_info is missing");
        return false;
    L6:
        String r2 = r0.getEvidenceToken();
        if (TextUtils.isEmpty(r2) == false) goto L10;
        LogUtils.e(TAG, "verifyEvidenceToken: evidence_token is empty");
        return false;
    L10:
        CreateChannelResponse.ServiceInfo r13 = r9.getServiceInfo();
        if (r13 == null) goto L13;
        CreateChannelResponse.SvcKeyInfo r14 = r13.getAppSvcKeyInfo();
    L20:
        boolean r15 = EvidenceTokenVerifier.verify(r2, r12.appId, r12.appSvcId, r10, r11, r14);     // Catch: Exception -> L17
        LogUtils.d(TAG, "verifyEvidenceToken: result=" + r15);     // Catch: Exception -> L17
        return r15;
    L17:
        e = move-exception;
        LogUtils.e(TAG, "verifyEvidenceToken exception: " + Log.getStackTraceString(e));
        return false;
    L13:
        r14 = null;
        goto L20
    }

    private static int parseKeyVersion(String r4) {
        if (r4 != null) goto L5;
    L10:
        return 0;
    L5:
        if (r4.isEmpty() == true) goto L10;
        return Integer.parseInt(r4);
    L9:
        LogUtils.e(TAG, "parseKeyVersion: non-integer '" + r4 + "', defaulting to 0");
        goto L10
    }
}
