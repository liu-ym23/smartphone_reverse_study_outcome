package com.bytedance.privacy.pcc;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bytedance.privacy.network.NetworkConfig;
import com.bytedance.privacy.pcc.db.PccChannelDb;
import com.bytedance.privacy.pcc.network.PccNetworkManager;
import com.bytedance.privacy.pcc.network.model.CreateChannelRequest;
import com.bytedance.privacy.pcc.network.model.CreateChannelResponse;
import com.bytedance.privacy.pcc.network.model.UploadChannelRetRequest;
import com.bytedance.privacy.utils.LogUtils;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class PccManager {
    private static final String ATTEST_ROOT_CERT_BOE = "-----BEGIN CERTIFICATE-----\nMIICZzCCAg6gAwIBAgIUGJmXeMuqSaXDKR9SmU6CizMYc9owCgYIKoZIzj0EAwIw\nVzESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMSAwHgYDVQQDExdCeXRlRGFuY2UgU21hcnQgU0lHTiBDQTAeFw0yNjAz\nMDQwODQ0MzNaFw00NDEyMzExNjAwMDBaMGUxEjAQBgNVBAoTCUJ5dGVEYW5jZTEf\nMB0GA1UECxMWQnl0ZURhbmNlIFNtYXJ0IERldmljZTEuMCwGA1UEAxMlQk9FIEJ5\ndGVEYW5jZSBPUENDIEV2aWRlbmNlIFRva2VuIENBMTBZMBMGByqGSM49AgEGCCqG\nSM49AwEHA0IABJ9VunGoIJr4YdiyA4q9VG5SvbOxcwUcsEmyw5HnMcAK4c9D8kAw\nklDUo1lzvxFM0wRKuqQyPm3tudnXYp+YvaqjgakwgaYwDgYDVR0PAQH/BAQDAgGG\nMA8GA1UdEwEB/wQFMAMBAf8wHQYDVR0OBBYEFO4NorzPIpUFhHMoRicKQXOJCO91\nMB8GA1UdIwQYMBaAFCN6HBQRj2cdTtMkScSwgj5mjApMMEMGCCsGAQUFBwEBBDcw\nNTAzBggrBgEFBQcwAYYnaHR0cDovL25leHVzLWJvZS5ieXRlZGFuY2UubmV0L3Bj\nYS9vY3NwMAoGCCqGSM49BAMCA0cAMEQCICi0qfYIv1adG67GjMiDerkvATx+NAJc\nXuWHBw19rAbZAiB4t5TIdN4Blgoi4Z7TSC4ujKiZamCsQAWd/Qm6CjmSKA==\n-----END CERTIFICATE-----";
    private static final String ATTEST_ROOT_CERT_ONLINE = "-----BEGIN CERTIFICATE-----\nMIICajCCAhCgAwIBAgIUGJmZqXIH8jlgen5vodpKCnEWqqgwCgYIKoZIzj0EAwIw\nVzESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMSAwHgYDVQQDExdCeXRlRGFuY2UgU21hcnQgU0lHTiBDQTAeFw0yNjAz\nMDQwOTI0NDFaFw00NTEyMzExNjAwMDBaMGAxEjAQBgNVBAoTCUJ5dGVEYW5jZTEf\nMB0GA1UECxMWQnl0ZURhbmNlIFNtYXJ0IERldmljZTEpMCcGA1UEAxMgQnl0ZURh\nbmNlIE9QQ0MgRXZpZGVuY2UgVG9rZW4gQ0EwWTATBgcqhkjOPQIBBggqhkjOPQMB\nBwNCAARfeJVRuQB8Aj+/XmhaQ4rA8UsmnJr/gxZ9ect9Gbl5DN2hhQ9G8ALPFo0J\nkdWuN+8TTdZ15+zG9p2x1APerD3co4GwMIGtMA4GA1UdDwEB/wQEAwIBhjAPBgNV\nHRMBAf8EBTADAQH/MB0GA1UdDgQWBBTFGPH3KgQVKmcpIHp06m71wC/N2zAfBgNV\nHSMEGDAWgBRgISfbugqIUe075DXEeifDk4vhATBKBggrBgEFBQcBAQQ+MDwwOgYI\nKwYBBQUHMAGGLmh0dHA6Ly9uZXh1cy1wcm9kdWN0aW9uLmJ5dGVkYW5jZS5uZXQv\ncGNhL29jc3AwCgYIKoZIzj0EAwIDSAAwRQIgGrGTErx0YxbhgHBiG/l4zRpllRwk\n5028gMa/djZbR5sCIQDcvK83IKqkzQfvjocLzlRQtuC5Bue2rBR0NAOgs+y2QA==\n-----END CERTIFICATE-----";
    private static final String CLOUD_CERT_BOE = "-----BEGIN CERTIFICATE-----\nMIICNTCCAdqgAwIBAgIUGJmWDf76XK7QEDg7ePQ6Zp5a/QAwCgYIKoZIzj0EAwIw\nVzESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMSAwHgYDVQQDExdCeXRlRGFuY2UgU21hcnQgU0lHTiBDQTAeFw0yNjAz\nMDQwODE4MzVaFw00MTAyMjgwODI4MzRaMGUxEjAQBgNVBAoTCUJ5dGVEYW5jZTEf\nMB0GA1UECxMWQnl0ZURhbmNlIFNtYXJ0IERldmljZTEuMCwGA1UEAxMlQk9FIEJ5\ndGVEYW5jZSBTbWFydCBTaWduIE9QQ0MgR2F0ZXdheTBZMBMGByqGSM49AgEGCCqG\nSM49AwEHA0IABM25nWwFbu/tBeKoSdmqIEFzkGsiNlVBzp++3/y3PSAl3X5JQ98U\nkN8af1gEabmQWsnQ6rfAu+/3N1eLdaeyAH+jdjB0MAwGA1UdEwEB/wQCMAAwHwYD\nVR0jBBgwFoAUI3ocFBGPZx1O0yRJxLCCPmaMCkwwQwYIKwYBBQUHAQEENzA1MDMG\nCCsGAQUFBzABhidodHRwOi8vbmV4dXMtYm9lLmJ5dGVkYW5jZS5uZXQvcGNhL29j\nc3AwCgYIKoZIzj0EAwIDSQAwRgIhANzuvWkxo2IGpnbJNEWvZRuyp/brvmy9u76P\nRj9AkGSzAiEAuxwuHmrS6OmMWFi5ha9DpqLJijiXzNEKcdVYsJuAFTY=\n-----END CERTIFICATE-----";
    private static final String CLOUD_CERT_ONLINE = "-----BEGIN CERTIFICATE-----\nMIICODCCAd2gAwIBAgIUGJmcpAzL0+i5GIb6FxhoxPQSMtswCgYIKoZIzj0EAwIw\nVzESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMSAwHgYDVQQDExdCeXRlRGFuY2UgU21hcnQgU0lHTiBDQTAeFw0yNjAz\nMDQxMDE5MTZaFw00MTAyMjgxMDI5MTZaMGExEjAQBgNVBAoTCUJ5dGVEYW5jZTEf\nMB0GA1UECxMWQnl0ZURhbmNlIFNtYXJ0IERldmljZTEqMCgGA1UEAxMhQnl0ZURh\nbmNlIFNtYXJ0IFNpZ24gT1BDQyBHYXRld2F5MFkwEwYHKoZIzj0CAQYIKoZIzj0D\nAQcDQgAE1eO/rIuiv0g/zgUMel9/Jyv3msFzoimqEuwjFIRJGKKe51ONP9jMv7zP\ng/IuRK5HFR3IMZYjz507Az0wuT8jIKN9MHswDAYDVR0TAQH/BAIwADAfBgNVHSME\nGDAWgBRgISfbugqIUe075DXEeifDk4vhATBKBggrBgEFBQcBAQQ+MDwwOgYIKwYB\nBQUHMAGGLmh0dHA6Ly9uZXh1cy1wcm9kdWN0aW9uLmJ5dGVkYW5jZS5uZXQvcGNh\nL29jc3AwCgYIKoZIzj0EAwIDSQAwRgIhAM5X3JaXiaAD1sFDDFpRB5rNQS3G7mSc\nGDbtKnvJ3SQ4AiEAwH5JexV4T1BLcNoZctl6iOo5JeUbEwZ11lVi0fzXPI0=\n-----END CERTIFICATE-----";
    private static final int MAX_STRING_LENGTH = 512;
    private static final String PCC_CLIENT_VERSION = "1.0.0";
    private static final String PCC_SIGN_KEY_ALIAS = "pcc_sign_key";
    private static final String TAG = "PccManager";
    private static volatile PccManager pccManager;
    private Context appContext;
    private PccChannelDb channelDb;
    private volatile boolean pccInitialized;
    private final Map<String, SessionContext> sessionContextCache;

    private static class SessionContext {
        final String accessToken;
        final AppInfo appInfo;
        final int bizType;
        final KeyPair ephemeralKeyPair;
        final List<CreateChannelResponse.SvcPod> podList;
        final byte[] sessionKey;

        SessionContext(AppInfo r1, int r2, String r3, KeyPair r4, List<CreateChannelResponse.SvcPod> r5, byte[] r6) {
            this.appInfo = r1;
            this.bizType = r2;
            this.accessToken = r3;
            this.ephemeralKeyPair = r4;
            this.podList = r5;
            this.sessionKey = r6;
        }
    }

    static {
    }

    private PccManager() {
        this.pccInitialized = false;
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

    public int init(AppInfo r23) {
        if (this.appContext != null) goto L7;
        LogUtils.e(TAG, "init failed: context not attached");
        return -31;
    L7:
        if (isValidAppInfo(r23) == true) goto L10;
        LogUtils.e(TAG, "init failed: invalid params (null, empty, or exceeds max length)");
        return -2;
    L10:
        String r4 = TAG;
        LogUtils.i(r4, "init called: appId=" + r23.appId + ", appSvcId=" + r23.appSvcId + ", rpdid=" + r23.rpdid + ", rpuid=" + r23.rpuid);
        CreateChannelResponse r6 = queryChannelFromDb(r23);
        if (r6 != null) goto L13;
    L16:
        LogUtils.i(r4, "init: no valid cached channel, proceeding with network flow");
        String r7 = UUID.randomUUID().toString();
        String r9 = PccNetworkManager.getInstance().requestChallenge(r7);
        if (TextUtils.isEmpty(r9) == false) goto L20;
        LogUtils.e(r4, "init failed: get PCC challenge failed");
        return -31;
    L20:
        LogUtils.i(r4, "PCC challenge obtained");
        String r10 = KeyAttestationHelper.generateAndAttestSignKey(this.appContext, PCC_SIGN_KEY_ALIAS, r9, r23.rpdid, r23.rpuid);     // Catch: Exception -> L52
        LogUtils.i(r4, "init: cleaned up " + this.channelDb.deleteOtherRpuidChannels(r23.rpdid, r23.rpuid, r23.appId, r23.appSvcId) + " old channel(s) for other rpuids");
        String r11 = String.valueOf(System.currentTimeMillis());
        byte[] r12 = new byte[8];
        new SecureRandom().nextBytes(r12);
        String r13 = CryptoUtils.toHex(r12);
        String r14 = Base64.encodeToString(new CreateChannelRequest.Payload(PCC_CLIENT_VERSION, r13, r23).toJsonString().getBytes(StandardCharsets.UTF_8), 11);
        CreateChannelResponse r5 = PccNetworkManager.getInstance().createChannel(r7, r11, new CreateChannelRequest(r10, r14, Base64.encodeToString(KeyAttestationHelper.sign(this.appContext, PCC_SIGN_KEY_ALIAS, (r7 + "|" + r11 + "|" + r14).getBytes(StandardCharsets.UTF_8)), 11)).toJsonString());
        if (r5 != null) goto L29;
        LogUtils.e(r4, "init failed: createChannel returned null");
        return -31;
    L29:
        if (verifyCloudSignature(r5) == true) goto L33;
        LogUtils.e(r4, "init failed: cloud response signature verification failed");
        return -31;
    L33:
        if (verifyEvidenceToken(r5, r9, r13, r23) == true) goto L36;
        LogUtils.e(r4, "init warning: evidence token verification failed (non-fatal)");
    L36:
        if (this.channelDb.save(r23.rpdid, r23.rpuid, r23.appId, r23.appSvcId, r5) == true) goto L39;
        LogUtils.e(r4, "init warning: failed to persist channel data to DB");
    L39:
        if (this.channelDb.saveKeyAttestationHistory(r23.rpdid, r23.rpuid, r23.appId, r23.appSvcId, r5) == true) goto L41;
        LogUtils.e(r4, "init warning: failed to save key attestation history");
    L41:
        this.pccInitialized = true;
        LogUtils.i(r4, "init success, channelId=" + r5.getChannelId());
        String r1 = Base64.encodeToString(new UploadChannelRetRequest.Payload(PCC_CLIENT_VERSION, r23, r5.getChannelId(), "0").toJsonString().getBytes(StandardCharsets.UTF_8), 11);
        String r8 = String.valueOf(System.currentTimeMillis());
        LogUtils.i(r4, "init: uploadChannelRet logId=" + PccNetworkManager.getInstance().uploadChannelRet(r7, r8, new UploadChannelRetRequest(r1, Base64.encodeToString(KeyAttestationHelper.sign(this.appContext, PCC_SIGN_KEY_ALIAS, (r7 + "|" + r8 + "|" + r1).getBytes(StandardCharsets.UTF_8)), 11)).toJsonString()));     // Catch: Exception -> L44
        return 0;
    L44:
        e = move-exception;
        LogUtils.e(TAG, "init: uploadChannelRet sign failed (non-fatal): " + e.getMessage());
        return 0;
    L48:
        e = move-exception;
        LogUtils.e(TAG, "init failed: sign request: " + e.getMessage());
        return -31;
    L52:
        e = move-exception;
        LogUtils.e(TAG, "init failed: attestation: " + e.getMessage());
        return -31;
    L13:
        if (isChannelExpired(r6) == true) goto L16;
        this.pccInitialized = true;
        return 0;
    }

    public int openSecuritySession(String r13, AppInfo r14) {
        String r0 = TAG;
        LogUtils.d(r0, "openSecuritySession called: sessionId=" + r13);
        if (isValidString(r13) == true) goto L7;
        LogUtils.e(r0, "openSecuritySession failed: invalid sessionId (null, empty, or exceeds max length)");
        return -2;
    L7:
        if (isValidAppInfo(r14) == true) goto L10;
        LogUtils.e(r0, "openSecuritySession failed: invalid appInfo (null, empty, or exceeds max length)");
        return -2;
    L10:
        CreateChannelResponse r1 = queryChannelFromDb(r14);
        if (r1 != null) goto L13;
    L14:
        LogUtils.d(r0, "openSecuritySession: channel missing or expired, re-initialising");
        int r2 = init(r14);
        if (r2 == 0) goto L18;
        LogUtils.e(r0, "openSecuritySession failed: re-init returned " + r2);
        return r2;
    L18:
        r1 = queryChannelFromDb(r14);
        if (r1 != null) goto L22;
        LogUtils.e(r0, "openSecuritySession failed: channel still null after re-init");
        return -31;
    L22:
        CreateChannelResponse.ServiceInfo r3 = r1.getServiceInfo();
        if (r3 != null) goto L25;
    L35:
        LogUtils.e(r0, "openSecuritySession failed: service pod list is empty");
        return -31;
    L25:
        if (r3.getAppSvcPodList() == null) goto L35;
        if (r3.getAppSvcPodList().isEmpty() == true) goto L35;
        KeyPair r9 = CryptoUtils.generateEphemeralEcKeyPair();     // Catch: Exception -> L32
        byte[] r11 = new byte[32];
        new SecureRandom().nextBytes(r11);
        List<CreateChannelResponse.SvcPod> r4 = r3.getAppSvcPodList();
        this.sessionContextCache.put(r13, new SessionContext(r14, 1, r1.getAccessToken(), r9, r4, r11));
        LogUtils.d(r0, "openSecuritySession success: sessionId=" + r13 + ", podCount=" + r4.size());
        return 0;
    L32:
        e = move-exception;
        LogUtils.e(TAG, "openSecuritySession failed: generate ephemeral key pair: " + e.getMessage());
        return -31;
    L13:
        if (isChannelExpired(r1) == false) goto L22;
        goto L14
    }

    public String dataEncrypt(String r14, byte[] r15) {
        String r5 = TAG;
        LogUtils.d(r5, "dataEncrypt called: sessionId=" + r14);
        if (isValidString(r14) == true) goto L7;
        LogUtils.e(r5, "dataEncrypt failed: invalid sessionId (null, empty, or exceeds max length)");
        return null;
    L7:
        if (isValidBytes(r15) == true) goto L10;
        LogUtils.e(r5, "dataEncrypt failed: invalid data (null or empty)");
        return null;
    L10:
        SessionContext r6 = this.sessionContextCache.get(r14);
        if (r6 != null) goto L34;
        LogUtils.e(r5, "dataEncrypt failed: session not found");
        return null;
    L34:
        LogUtils.d(r5, "dataEncrypt sessionKey=" + CryptoUtils.toHex(r6.sessionKey));     // Catch: Exception -> L29
        byte[] r4 = new byte[12];     // Catch: Exception -> L29
        new SecureRandom().nextBytes(r4);     // Catch: Exception -> L29
        LogUtils.d(r5, "dataEncrypt nonce=" + CryptoUtils.toHex(r4) + " plainLen=" + r15.length);     // Catch: Exception -> L29
        byte[] r16 = CryptoUtils.aesGcmEncrypt(r6.sessionKey, r4, r15);     // Catch: Exception -> L29
        LogUtils.d(r5, "dataEncrypt ciphertextLen=" + r16.length);     // Catch: Exception -> L29
        EncryptedPayloadTlv r2 = new EncryptedPayloadTlv();     // Catch: Exception -> L29
        r2.metaInfo = new EncryptedPayloadTlv.MetaInfo();     // Catch: Exception -> L29
        r2.metaInfo.version = 1;     // Catch: Exception -> L29
        r2.metaInfo.contentType = 1;     // Catch: Exception -> L29
        EncryptedPayloadTlv.BizAttribute r3 = new EncryptedPayloadTlv.BizAttribute();     // Catch: Exception -> L29
        r3.appId = r6.appInfo.appId;     // Catch: Exception -> L29
        r3.serviceId = r6.appInfo.appSvcId;     // Catch: Exception -> L29
        r3.bizType = r6.bizType;     // Catch: Exception -> L29
        r3.sessionKeyId = r14.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L29
        int r9 = 0;
        if (r6.accessToken == null) goto L17;
        byte[] r17 = r6.accessToken.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L29
    L18:
        r3.accessToken = r17;     // Catch: Exception -> L29
        r2.metaInfo.bizAttribute = r3;     // Catch: Exception -> L29
        byte[] r18 = CryptoUtils.ecPubKeyToUncompressed(r6.ephemeralKeyPair.getPublic());     // Catch: Exception -> L29
        LogUtils.d(r5, "dataEncrypt ephemeralDhPK=" + CryptoUtils.toHex(r18));     // Catch: Exception -> L29
        r2.keyEnvelopePayload = new EncryptedPayloadTlv.KeyEnvelopePayload();     // Catch: Exception -> L29
        r2.keyEnvelopePayload.version = 1;     // Catch: Exception -> L29
        r2.keyEnvelopePayload.envelopeType = 1;     // Catch: Exception -> L29
        r2.keyEnvelopePayload.keyEnvelopeList = new ArrayList();     // Catch: Exception -> L29
    L20:
        if (r9 >= r6.podList.size()) goto L22;
        CreateChannelResponse.SvcPod r1 = r6.podList.get(r9);     // Catch: Exception -> L29
        byte[] r7 = new byte[16];     // Catch: Exception -> L29
        new SecureRandom().nextBytes(r7);     // Catch: Exception -> L29
        String r8 = TAG;     // Catch: Exception -> L29
        LogUtils.d(r8, "dataEncrypt pod[" + r9 + "] id=" + r1.getSvcPodId() + " keyType=" + r1.getSvcPodKeyType() + " keyVer=" + r1.getSvcPodKeyVersion() + " salt=" + CryptoUtils.toHex(r7));     // Catch: Exception -> L29
        byte[] r10 = CryptoUtils.eciesWrapKey(r6.ephemeralKeyPair.getPrivate(), r18, r1.getSvcPodPubKey(), r7, r6.sessionKey);     // Catch: Exception -> L29
        LogUtils.d(r8, "dataEncrypt pod[" + r9 + "] encryptedSessionKey=" + CryptoUtils.toHex(r10));     // Catch: Exception -> L29
        EncryptedPayloadTlv.KeyEnvelope r11 = new EncryptedPayloadTlv.KeyEnvelope();     // Catch: Exception -> L29
        r9 = r9 + 1;     // Catch: Exception -> L29
        r11.index = r9;     // Catch: Exception -> L29
        r11.keyIdentify = r1.getSvcPodId().getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L29
        r11.keyVersion = parseKeyVersion(r1.getSvcPodKeyVersion());     // Catch: Exception -> L29
        r11.keyEncryptionAlgorithm = 1;     // Catch: Exception -> L29
        r11.dhPK = r18;     // Catch: Exception -> L29
        r11.salt = r7;     // Catch: Exception -> L29
        r11.encryptedSessionKey = r10;     // Catch: Exception -> L29
        r2.keyEnvelopePayload.keyEnvelopeList.add(r11);     // Catch: Exception -> L29
        goto L20
    L22:
        r2.keyEnvelopePayload.keyEnvelopeListSize = r2.keyEnvelopePayload.keyEnvelopeList.size();     // Catch: Exception -> L29
        r2.contentInfoMeta = new EncryptedPayloadTlv.ContentInfoMeta();     // Catch: Exception -> L29
        r2.contentInfoMeta.contentType = 1;     // Catch: Exception -> L29
        r2.contentInfoMeta.contentEncryptionAlgorithm = 1;     // Catch: Exception -> L29
        EncryptedPayloadTlv.OtherKeyAttribute r19 = new EncryptedPayloadTlv.OtherKeyAttribute();     // Catch: Exception -> L29
        r19.nonce = r4;     // Catch: Exception -> L29
        r2.contentInfoMeta.otherKeyAttribute = r19;     // Catch: Exception -> L29
        byte[] r13 = KeyAttestationHelper.sign(this.appContext, PCC_SIGN_KEY_ALIAS, r2.encodeSignedPortion());     // Catch: Exception -> L26
        EncryptedPayloadTlv.SignContentInfo r110 = new EncryptedPayloadTlv.SignContentInfo();     // Catch: Exception -> L26
        r110.signatureAlgorithm = 1;     // Catch: Exception -> L26
        r110.contentSignature = r13;     // Catch: Exception -> L26
        r2.signContentInfo = r110;     // Catch: Exception -> L26
        String r111 = TAG;     // Catch: Exception -> L29
        LogUtils.d(r111, "dataEncrypt TLV JSON:\n" + r2.toJsonString());     // Catch: Exception -> L29
        byte[] r112 = new EncryptedProtocol(r2, r16).encode();     // Catch: Exception -> L29
        LogUtils.d(r111, "dataEncrypt success: encodedLen=" + r112.length);     // Catch: Exception -> L29
        return Base64.encodeToString(r112, 11);
    L26:
        e = move-exception;
        LogUtils.e(TAG, "dataEncrypt failed: sign TLV: " + e.getMessage());     // Catch: Exception -> L29
        return null;
    L17:
        r17 = new byte[0];     // Catch: Exception -> L29
    L29:
        e = move-exception;
        LogUtils.e(TAG, "dataEncrypt exception: " + Log.getStackTraceString(e));
        return null;
    }

    public byte[] dataDecrypt(String r8, String r9) {
        String r4 = TAG;
        LogUtils.d(r4, "dataDecrypt called: sessionId=" + r8);
        if (isValidString(r8) == true) goto L6;
        LogUtils.e(r4, "dataDecrypt failed: invalid sessionId (null, empty, or exceeds max length)");
        return null;
    L6:
        if (r9 != null) goto L8;
    L35:
        LogUtils.e(r4, "dataDecrypt failed: invalid data (null, empty)");
        return null;
    L8:
        if (r9.length() <= 0) goto L35;
        SessionContext r7 = this.sessionContextCache.get(r8);
        if (r7 != null) goto L37;
        LogUtils.e(r4, "dataDecrypt failed: session not found");
        return null;
    L37:
        byte[] r10 = Base64.decode(r9, 8);     // Catch: Exception -> L32
        LogUtils.d(r4, "dataDecrypt encodedLen=" + r10.length);     // Catch: Exception -> L32
        EncryptedProtocol r11 = EncryptedProtocol.decode(r10);     // Catch: Exception -> L32
        EncryptedPayloadTlv r12 = r11.tlvData;     // Catch: Exception -> L32
        byte[] r13 = r11.body;     // Catch: Exception -> L32
        LogUtils.d(r4, "dataDecrypt TLV JSON:\n" + r12.toJsonString());     // Catch: Exception -> L32
        if (r12.contentInfoMeta != null) goto L18;
    L30:
        LogUtils.e(r4, "dataDecrypt failed: missing ContentInfoMeta or nonce");     // Catch: Exception -> L32
        return null;
    L18:
        if (r12.contentInfoMeta.otherKeyAttribute == null) goto L30;
        if (r12.contentInfoMeta.otherKeyAttribute.nonce == null) goto L30;
        if (r13 != null) goto L24;
    L28:
        LogUtils.e(r4, "dataDecrypt failed: no ciphertext in Body");     // Catch: Exception -> L32
        return null;
    L24:
        if (r13.length == 0) goto L28;
        byte[] r14 = r12.contentInfoMeta.otherKeyAttribute.nonce;     // Catch: Exception -> L32
        LogUtils.d(r4, "dataDecrypt sessionKey=" + CryptoUtils.toHex(r7.sessionKey) + " nonce=" + CryptoUtils.toHex(r14) + " ciphertextLen=" + r13.length);     // Catch: Exception -> L32
        byte[] r15 = CryptoUtils.aesGcmDecrypt(r7.sessionKey, r14, r13);     // Catch: Exception -> L32
        LogUtils.d(r4, "dataDecrypt success: plaintextLen=" + r15.length);     // Catch: Exception -> L32
        return r15;
    L32:
        e = move-exception;
        LogUtils.e(TAG, "dataDecrypt exception: " + e.getMessage());
        return null;
    }

    public int closeSecuritySession(String r4) {
        String r0 = TAG;
        LogUtils.d(r0, "closeSecuritySession called: sessionId=" + r4);
        if (isValidString(r4) == true) goto L6;
        LogUtils.e(r0, "closeSecuritySession failed: invalid sessionId (null, empty, or exceeds max length)");
        return -2;
    L6:
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
        boolean r8 = CryptoUtils.verifyEcdsaSignature(r0, (r6.getResponseId() + "|" + r6.getPayloadJson()).getBytes(StandardCharsets.UTF_8), Base64.decode(r6.getSignature(), 8));     // Catch: Exception -> L19
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

    private boolean verifyEvidenceToken(CreateChannelResponse r10, String r11, String r12, AppInfo r13) {
        CreateChannelResponse.EvidenceInfo r0 = r10.getEvidenceInfo();
        if (r0 != null) goto L6;
        LogUtils.d(TAG, "verifyEvidenceToken: no evidence_info in response, skip");
        return true;
    L6:
        String r2 = r0.getEvidenceToken();
        if (TextUtils.isEmpty(r2) == false) goto L10;
        LogUtils.d(TAG, "verifyEvidenceToken: evidence_token is empty, skip");
        return true;
    L10:
        boolean r1 = NetworkConfig.getInstance().isBoeEnv();
        if (r1 == false) goto L13;
        String r3 = ATTEST_ROOT_CERT_BOE;
    L14:
        String r8 = r3;
        String r4 = TAG;
        if (r1 == false) goto L17;
        String r5 = "BOE";
    L18:
        LogUtils.d(r4, "verifyEvidenceToken: env=".concat(r5));
        CreateChannelResponse.ServiceInfo r14 = r10.getServiceInfo();
        if (r14 == null) goto L21;
        List<CreateChannelResponse.SvcPod> r15 = r14.getAppSvcPodList();
    L28:
        boolean r16 = EvidenceTokenVerifier.verify(r2, r13.appId, r13.appSvcId, r11, r12, r15, r8);     // Catch: Exception -> L25
        LogUtils.d(r4, "verifyEvidenceToken: result=" + r16);     // Catch: Exception -> L25
        return r16;
    L25:
        e = move-exception;
        LogUtils.e(TAG, "verifyEvidenceToken exception: " + Log.getStackTraceString(e));
        return false;
    L21:
        r15 = null;
        goto L28
    L17:
        r5 = "Online";
        goto L18
    L13:
        r3 = ATTEST_ROOT_CERT_ONLINE;
        goto L14
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
