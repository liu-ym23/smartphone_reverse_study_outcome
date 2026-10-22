package com.bytedance.privacy.pcc;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bytedance.bdlocation.exception.BDLocationException;
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
    private com.bytedance.privacy.pcc.g.a channelDb;
    private volatile boolean pccInitialized;
    private final Map<String, a> sessionContextCache;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f5406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f5407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f5408c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final KeyPair f5409d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final List<com.bytedance.privacy.pcc.h.b.c.d> f5410e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final byte[] f5411f;

        a(b r1, int r2, String r3, KeyPair r4, List<com.bytedance.privacy.pcc.h.b.c.d> r5, byte[] r6) {
            this.f5406a = r1;
            this.f5407b = r2;
            this.f5408c = r3;
            this.f5409d = r4;
            this.f5410e = r5;
            this.f5411f = r6;
        }
    }

    static {
    }

    private PccManager() {
        this.pccInitialized = false;
        this.sessionContextCache = new ConcurrentHashMap();
    }

    private void attachContext(Context r2) {
        if (r2 == null) goto L5;
        this.appContext = r2.getApplicationContext();
        this.channelDb = new com.bytedance.privacy.pcc.g.a(this.appContext);
        return;
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

    private boolean isChannelExpired(com.bytedance.privacy.pcc.h.b.c r8) {
        String r7 = r8.c();
        if (TextUtils.isEmpty(r7) == false) goto L13;
        return true;
    L13:
        if ((System.currentTimeMillis() / 1000) >= Long.parseLong(r7)) goto L15;
        return false;
    L15:
        return true;
    L11:
        com.bytedance.privacy.f.b.b(TAG, "isChannelExpired: invalid expiry format: " + r7);
        return true;
    }

    private static boolean isValidAppInfo(b r1) {
        if (r1 != null) goto L4;
    L12:
        return false;
    L4:
        if (isValidString(r1.f5413a) == false) goto L12;
        if (isValidString(r1.f5414b) == false) goto L12;
        if (isValidString(r1.f5415c) == false) goto L12;
        if (isValidString(r1.f5416d) == false) goto L12;
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

    private static boolean isValidString(String r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.length() <= 0) goto L8;
        if (r1.length() >= 512) goto L8;
        return true;
    }

    private static int parseKeyVersion(String r4) {
        if (r4 != null) goto L5;
    L10:
        return 0;
    L5:
        if (r4.isEmpty() == true) goto L10;
        return Integer.parseInt(r4);
    L9:
        com.bytedance.privacy.f.b.b(TAG, "parseKeyVersion: non-integer '" + r4 + "', defaulting to 0");
        goto L10
    }

    private com.bytedance.privacy.pcc.h.b.c queryChannelFromDb(b r4) {
        com.bytedance.privacy.pcc.g.a r3 = this.channelDb;
        if (r3 != null) goto L7;
        com.bytedance.privacy.f.b.b(TAG, "queryChannelFromDb: DB not ready");
        return null;
    L7:
        return r3.a(r4.f5413a, r4.f5414b, r4.f5415c, r4.f5416d);
    }

    private boolean verifyCloudSignature(com.bytedance.privacy.pcc.h.b.c r6) {
        boolean r5 = com.bytedance.privacy.e.b.a().c();
        if (r5 == false) goto L5;
        String r0 = CLOUD_CERT_BOE;
    L6:
        String r1 = TAG;
        StringBuilder r2 = new StringBuilder();
        r2.append("verifyCloudSignature: env=");
        if (r5 == false) goto L9;
        String r7 = "BOE";
    L10:
        r2.append(r7);
        com.bytedance.privacy.f.b.a(r1, r2.toString());
        if (TextUtils.isEmpty(r6.i()) == false) goto L22;
        com.bytedance.privacy.f.b.b(r1, "verifyCloudSignature: server signature is empty");
        return false;
    L22:
        boolean r8 = c.i(r0, (r6.g() + "|" + r6.f()).getBytes(StandardCharsets.UTF_8), Base64.decode(r6.i(), 8));     // Catch: Exception -> L19
        if (r8 == true) goto L17;
        com.bytedance.privacy.f.b.b(r1, "verifyCloudSignature: ECDSA verification failed");     // Catch: Exception -> L19
    L18:
        return r8;
    L17:
        com.bytedance.privacy.f.b.d(r1, "verifyCloudSignature: signature valid");     // Catch: Exception -> L19
    L19:
        e = move-exception;
        com.bytedance.privacy.f.b.b(TAG, "verifyCloudSignature exception: " + e.getMessage());
        return false;
    L9:
        r7 = "Online";
        goto L10
    L5:
        r0 = CLOUD_CERT_ONLINE;
        goto L6
    }

    private boolean verifyEvidenceToken(com.bytedance.privacy.pcc.h.b.c r9, String r10, String r11, b r12) {
        com.bytedance.privacy.pcc.h.b.c.a r8 = r9.e();
        if (r8 != null) goto L7;
        String r13 = TAG;
        String r14 = "verifyEvidenceToken: no evidence_info in response, skip";
    L5:
        com.bytedance.privacy.f.b.a(r13, r14);
        return true;
    L7:
        String r1 = r8.b();
        if (TextUtils.isEmpty(r1) == false) goto L10;
        r13 = TAG;
        r14 = "verifyEvidenceToken: evidence_token is empty, skip";
        goto L5
    L10:
        boolean r15 = com.bytedance.privacy.e.b.a().c();
        if (r15 == false) goto L13;
        String r0 = ATTEST_ROOT_CERT_BOE;
    L14:
        String r7 = r0;
        String r2 = TAG;
        StringBuilder r3 = new StringBuilder();
        r3.append("verifyEvidenceToken: env=");
        if (r15 == false) goto L17;
        String r16 = "BOE";
    L18:
        r3.append(r16);
        com.bytedance.privacy.f.b.a(r2, r3.toString());
        List<com.bytedance.privacy.pcc.h.b.c.d> r17 = null;
        com.bytedance.privacy.pcc.h.b.c.C0174c r18 = r9.h();
        if (r18 == null) goto L27;
        r17 = r18.b();
    L27:
        boolean r19 = e.d(r1, r12.f5415c, r12.f5416d, r10, r11, r17, r7);     // Catch: Exception -> L24
        com.bytedance.privacy.f.b.a(r2, "verifyEvidenceToken: result=" + r19);     // Catch: Exception -> L24
        return r19;
    L24:
        e = move-exception;
        com.bytedance.privacy.f.b.b(TAG, "verifyEvidenceToken exception: " + Log.getStackTraceString(e));
        return false;
    L17:
        r16 = "Online";
        goto L18
    L13:
        r0 = ATTEST_ROOT_CERT_ONLINE;
        goto L14
    }

    public int closeSecuritySession(String r4) {
        String r0 = TAG;
        com.bytedance.privacy.f.b.a(r0, "closeSecuritySession called: sessionId=" + r4);
        if (isValidString(r4) == true) goto L6;
        com.bytedance.privacy.f.b.b(r0, "closeSecuritySession failed: invalid sessionId (null, empty, or exceeds max length)");
        return -2;
    L6:
        this.sessionContextCache.remove(r4);
        com.bytedance.privacy.f.b.a(r0, "closeSecuritySession success: sessionId=" + r4);
        return 0;
    }

    public byte[] dataDecrypt(String r5, String r6) {
        String r0 = TAG;
        com.bytedance.privacy.f.b.a(r0, "dataDecrypt called: sessionId=" + r5);
        if (isValidString(r5) == true) goto L7;
        com.bytedance.privacy.f.b.b(r0, "dataDecrypt failed: invalid sessionId (null, empty, or exceeds max length)");
        return null;
    L7:
        if (isValidString(r6) == true) goto L10;
        com.bytedance.privacy.f.b.b(r0, "dataDecrypt failed: invalid data (null, empty, or exceeds max length)");
        return null;
    L10:
        a r4 = this.sessionContextCache.get(r5);
        if (r4 != null) goto L35;
        com.bytedance.privacy.f.b.b(r0, "dataDecrypt failed: session not found");
        return null;
    L35:
        byte[] r7 = Base64.decode(r6, 8);     // Catch: Exception -> L32
        com.bytedance.privacy.f.b.a(r0, "dataDecrypt encodedLen=" + r7.length);     // Catch: Exception -> L32
        d r8 = d.a(r7);     // Catch: Exception -> L32
        EncryptedPayloadTlv r9 = r8.f5418a;     // Catch: Exception -> L32
        byte[] r10 = r8.f5419b;     // Catch: Exception -> L32
        com.bytedance.privacy.f.b.a(r0, "dataDecrypt TLV JSON:\n" + r9.u());     // Catch: Exception -> L32
        EncryptedPayloadTlv.c r11 = r9.f5375c;     // Catch: Exception -> L32
        if (r11 == null) goto L30;
        EncryptedPayloadTlv.g r12 = r11.f5384c;     // Catch: Exception -> L32
        if (r12 == null) goto L30;
        byte[] r13 = r12.f5399a;     // Catch: Exception -> L32
        if (r13 == null) goto L30;
        if (r10 != null) goto L24;
    L28:
        com.bytedance.privacy.f.b.b(r0, "dataDecrypt failed: no ciphertext in Body");     // Catch: Exception -> L32
        return null;
    L24:
        if (r10.length == 0) goto L28;
        com.bytedance.privacy.f.b.a(r0, "dataDecrypt sessionKey=" + c.h(r4.f5411f) + " nonce=" + c.h(r13) + " ciphertextLen=" + r10.length);     // Catch: Exception -> L32
        byte[] r14 = c.a(r4.f5411f, r13, r10);     // Catch: Exception -> L32
        StringBuilder r15 = new StringBuilder();     // Catch: Exception -> L32
        r15.append("dataDecrypt success: plaintextLen=");     // Catch: Exception -> L32
        r15.append(r14.length);     // Catch: Exception -> L32
        com.bytedance.privacy.f.b.a(r0, r15.toString());     // Catch: Exception -> L32
        return r14;
    L30:
        com.bytedance.privacy.f.b.b(r0, "dataDecrypt failed: missing ContentInfoMeta or nonce");     // Catch: Exception -> L32
        return null;
    L32:
        e = move-exception;
        com.bytedance.privacy.f.b.b(TAG, "dataDecrypt exception: " + e.getMessage());
        return null;
    }

    public String dataEncrypt(String r14, byte[] r15) {
        String r1 = TAG;
        com.bytedance.privacy.f.b.a(r1, "dataEncrypt called: sessionId=" + r14);
        if (isValidString(r14) == true) goto L7;
        com.bytedance.privacy.f.b.b(r1, "dataEncrypt failed: invalid sessionId (null, empty, or exceeds max length)");
        return null;
    L7:
        if (isValidBytes(r15) == true) goto L10;
        com.bytedance.privacy.f.b.b(r1, "dataEncrypt failed: invalid data (null or empty)");
        return null;
    L10:
        a r2 = this.sessionContextCache.get(r14);
        if (r2 != null) goto L34;
        com.bytedance.privacy.f.b.b(r1, "dataEncrypt failed: session not found");
        return null;
    L34:
        com.bytedance.privacy.f.b.a(r1, "dataEncrypt sessionKey=" + c.h(r2.f5411f));     // Catch: Exception -> L29
        byte[] r4 = new byte[12];     // Catch: Exception -> L29
        new SecureRandom().nextBytes(r4);     // Catch: Exception -> L29
        com.bytedance.privacy.f.b.a(r1, "dataEncrypt nonce=" + c.h(r4) + " plainLen=" + r15.length);     // Catch: Exception -> L29
        byte[] r16 = c.b(r2.f5411f, r4, r15);     // Catch: Exception -> L29
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L29
        r5.append("dataEncrypt ciphertextLen=");     // Catch: Exception -> L29
        r5.append(r16.length);     // Catch: Exception -> L29
        com.bytedance.privacy.f.b.a(r1, r5.toString());     // Catch: Exception -> L29
        EncryptedPayloadTlv r6 = new EncryptedPayloadTlv();     // Catch: Exception -> L29
        EncryptedPayloadTlv.f r7 = new EncryptedPayloadTlv.f();     // Catch: Exception -> L29
        r6.f5373a = r7;     // Catch: Exception -> L29
        r7.f5396a = 1;     // Catch: Exception -> L29
        r7.f5397b = 1;     // Catch: Exception -> L29
        EncryptedPayloadTlv.b r8 = new EncryptedPayloadTlv.b();     // Catch: Exception -> L29
        b r9 = r2.f5406a;     // Catch: Exception -> L29
        r8.f5377a = r9.f5415c;     // Catch: Exception -> L29
        r8.f5378b = r9.f5416d;     // Catch: Exception -> L29
        r8.f5379c = r2.f5407b;     // Catch: Exception -> L29
        r8.f5380d = r14.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L29
        String r17 = r2.f5408c;     // Catch: Exception -> L29
        int r10 = 0;
        if (r17 == null) goto L17;
        byte[] r18 = r17.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L29
    L18:
        r8.f5381e = r18;     // Catch: Exception -> L29
        r6.f5373a.f5398c = r8;     // Catch: Exception -> L29
        byte[] r19 = c.c(r2.f5409d.getPublic());     // Catch: Exception -> L29
        com.bytedance.privacy.f.b.a(r1, "dataEncrypt ephemeralDhPK=" + c.h(r19));     // Catch: Exception -> L29
        EncryptedPayloadTlv.e r3 = new EncryptedPayloadTlv.e();     // Catch: Exception -> L29
        r6.f5374b = r3;     // Catch: Exception -> L29
        r3.f5392a = 1;     // Catch: Exception -> L29
        r3.f5393b = 1;     // Catch: Exception -> L29
        r3.f5395d = new ArrayList();     // Catch: Exception -> L29
    L20:
        if (r10 >= r2.f5410e.size()) goto L22;
        com.bytedance.privacy.pcc.h.b.c.d r11 = r2.f5410e.get(r10);     // Catch: Exception -> L29
        byte[] r12 = new byte[16];     // Catch: Exception -> L29
        new SecureRandom().nextBytes(r12);     // Catch: Exception -> L29
        String r13 = TAG;     // Catch: Exception -> L29
        com.bytedance.privacy.f.b.a(r13, "dataEncrypt pod[" + r10 + "] id=" + r11.a() + " keyType=" + r11.c() + " keyVer=" + r11.d() + " salt=" + c.h(r12));     // Catch: Exception -> L29
        byte[] r110 = c.d(r2.f5409d.getPrivate(), r19, r11.e(), r12, r2.f5411f);     // Catch: Exception -> L29
        StringBuilder r111 = new StringBuilder();     // Catch: Exception -> L29
        r111.append("dataEncrypt pod[");     // Catch: Exception -> L29
        r111.append(r10);     // Catch: Exception -> L29
        r111.append("] encryptedSessionKey=");     // Catch: Exception -> L29
        r111.append(c.h(r110));     // Catch: Exception -> L29
        com.bytedance.privacy.f.b.a(r13, r111.toString());     // Catch: Exception -> L29
        EncryptedPayloadTlv.d r20 = new EncryptedPayloadTlv.d();     // Catch: Exception -> L29
        r10 = r10 + 1;     // Catch: Exception -> L29
        r20.f5385a = r10;     // Catch: Exception -> L29
        r20.f5386b = r11.a().getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L29
        r20.f5387c = parseKeyVersion(r11.d());     // Catch: Exception -> L29
        r20.f5388d = 1;     // Catch: Exception -> L29
        r20.f5389e = r19;     // Catch: Exception -> L29
        r20.f5390f = r12;     // Catch: Exception -> L29
        r20.f5391g = r110;     // Catch: Exception -> L29
        r6.f5374b.f5395d.add(r20);     // Catch: Exception -> L29
        goto L20
    L22:
        EncryptedPayloadTlv.e r112 = r6.f5374b;     // Catch: Exception -> L29
        r112.f5394c = r112.f5395d.size();     // Catch: Exception -> L29
        EncryptedPayloadTlv.c r113 = new EncryptedPayloadTlv.c();     // Catch: Exception -> L29
        r6.f5375c = r113;     // Catch: Exception -> L29
        r113.f5382a = 1;     // Catch: Exception -> L29
        r113.f5383b = 1;     // Catch: Exception -> L29
        EncryptedPayloadTlv.g r0 = new EncryptedPayloadTlv.g();     // Catch: Exception -> L29
        r0.f5399a = r4;     // Catch: Exception -> L29
        r113.f5384c = r0;     // Catch: Exception -> L29
        byte[] r114 = f.c(this.appContext, PCC_SIGN_KEY_ALIAS, r6.r());     // Catch: Exception -> L26
        EncryptedPayloadTlv.h r115 = new EncryptedPayloadTlv.h();     // Catch: Exception -> L26
        r115.f5401a = 1;     // Catch: Exception -> L26
        r115.f5402b = r114;     // Catch: Exception -> L26
        r6.f5376d = r115;     // Catch: Exception -> L26
        String r116 = TAG;     // Catch: Exception -> L29
        com.bytedance.privacy.f.b.a(r116, "dataEncrypt TLV JSON:\n" + r6.u());     // Catch: Exception -> L29
        byte[] r117 = new d(r6, r16).b();     // Catch: Exception -> L29
        com.bytedance.privacy.f.b.a(r116, "dataEncrypt success: encodedLen=" + r117.length);     // Catch: Exception -> L29
        return Base64.encodeToString(r117, 11);
    L26:
        e = move-exception;
        com.bytedance.privacy.f.b.b(TAG, "dataEncrypt failed: sign TLV: " + e.getMessage());     // Catch: Exception -> L29
        return null;
    L17:
        r18 = new byte[0];     // Catch: Exception -> L29
    L29:
        e = move-exception;
        com.bytedance.privacy.f.b.b(TAG, "dataEncrypt exception: " + Log.getStackTraceString(e));
        return null;
    }

    public int init(b r23) {
        if (this.appContext != null) goto L7;
        com.bytedance.privacy.f.b.b(TAG, "init failed: context not attached");
        return -31;
    L7:
        if (isValidAppInfo(r23) == true) goto L10;
        com.bytedance.privacy.f.b.b(TAG, "init failed: invalid params (null, empty, or exceeds max length)");
        return -2;
    L10:
        String r3 = TAG;
        com.bytedance.privacy.f.b.d(r3, "init called: appId=" + r23.f5415c + ", appSvcId=" + r23.f5416d);
        com.bytedance.privacy.pcc.h.b.c r5 = queryChannelFromDb(r23);
        if (r5 != null) goto L13;
    L16:
        com.bytedance.privacy.f.b.d(r3, "init: no valid cached channel, proceeding with network flow");
        String r6 = UUID.randomUUID().toString();
        String r8 = com.bytedance.privacy.pcc.h.a.d().e(r6);
        if (TextUtils.isEmpty(r8) == false) goto L20;
        com.bytedance.privacy.f.b.b(r3, "init failed: get PCC challenge failed");
        return -31;
    L20:
        com.bytedance.privacy.f.b.d(r3, "PCC challenge obtained");
        String r9 = f.b(this.appContext, PCC_SIGN_KEY_ALIAS, r8, r23.f5413a, r23.f5414b);     // Catch: Exception -> L49
        String r10 = String.valueOf(System.currentTimeMillis());
        byte[] r11 = new byte[8];
        new SecureRandom().nextBytes(r11);
        String r12 = c.h(r11);
        String r13 = Base64.encodeToString(new com.bytedance.privacy.pcc.h.b.b.a(PCC_CLIENT_VERSION, r12, r23).a().getBytes(StandardCharsets.UTF_8), 11);
        com.bytedance.privacy.pcc.h.b.c r4 = com.bytedance.privacy.pcc.h.a.d().c(r6, r10, new com.bytedance.privacy.pcc.h.b.b(r9, r13, Base64.encodeToString(f.c(this.appContext, PCC_SIGN_KEY_ALIAS, (r6 + "|" + r10 + "|" + r13).getBytes(StandardCharsets.UTF_8)), 11)).a());
        if (r4 != null) goto L29;
        com.bytedance.privacy.f.b.b(r3, "init failed: createChannel returned null");
        return -31;
    L29:
        if (verifyCloudSignature(r4) == true) goto L33;
        com.bytedance.privacy.f.b.b(r3, "init failed: cloud response signature verification failed");
        return -31;
    L33:
        if (verifyEvidenceToken(r4, r8, r12, r23) == true) goto L36;
        com.bytedance.privacy.f.b.b(r3, "init warning: evidence token verification failed (non-fatal)");
    L36:
        if (this.channelDb.b(r23.f5413a, r23.f5414b, r23.f5415c, r23.f5416d, r4) == true) goto L38;
        com.bytedance.privacy.f.b.b(r3, "init warning: failed to persist channel data to DB");
    L38:
        this.pccInitialized = true;
        com.bytedance.privacy.f.b.d(r3, "init success, channelId=" + r4.d());
        String r1 = Base64.encodeToString(new com.bytedance.privacy.pcc.h.b.d.a(PCC_CLIENT_VERSION, r23, r4.d(), BDLocationException.ERROR_TIMEOUT).a().getBytes(StandardCharsets.UTF_8), 11);
        String r7 = String.valueOf(System.currentTimeMillis());
        com.bytedance.privacy.f.b.d(r3, "init: uploadChannelRet logId=" + com.bytedance.privacy.pcc.h.a.d().f(r6, r7, new com.bytedance.privacy.pcc.h.b.d(r1, Base64.encodeToString(f.c(this.appContext, PCC_SIGN_KEY_ALIAS, (r6 + "|" + r7 + "|" + r1).getBytes(StandardCharsets.UTF_8)), 11)).a()));     // Catch: Exception -> L41
        return 0;
    L41:
        e = move-exception;
        com.bytedance.privacy.f.b.b(TAG, "init: uploadChannelRet sign failed (non-fatal): " + e.getMessage());
        return 0;
    L45:
        e = e;
        String r2 = TAG;
        StringBuilder r14 = new StringBuilder();
        String r15 = "init failed: sign request: ";
    L47:
        r14.append(r15);
        r14.append(e.getMessage());
        com.bytedance.privacy.f.b.b(r2, r14.toString());
        return -31;
    L49:
        e = e;
        r2 = TAG;
        r14 = new StringBuilder();
        r15 = "init failed: attestation: ";
        goto L47
    L13:
        if (isChannelExpired(r5) == true) goto L16;
        this.pccInitialized = true;
        return 0;
    }

    public int openSecuritySession(String r13, b r14) {
        String r0 = TAG;
        com.bytedance.privacy.f.b.a(r0, "openSecuritySession called: sessionId=" + r13);
        if (isValidString(r13) == true) goto L7;
        com.bytedance.privacy.f.b.b(r0, "openSecuritySession failed: invalid sessionId (null, empty, or exceeds max length)");
        return -2;
    L7:
        if (isValidAppInfo(r14) == true) goto L10;
        com.bytedance.privacy.f.b.b(r0, "openSecuritySession failed: invalid appInfo (null, empty, or exceeds max length)");
        return -2;
    L10:
        com.bytedance.privacy.pcc.h.b.c r1 = queryChannelFromDb(r14);
        if (r1 != null) goto L13;
    L14:
        com.bytedance.privacy.f.b.a(r0, "openSecuritySession: channel missing or expired, re-initialising");
        int r2 = init(r14);
        if (r2 == 0) goto L18;
        com.bytedance.privacy.f.b.b(r0, "openSecuritySession failed: re-init returned " + r2);
        return r2;
    L18:
        r1 = queryChannelFromDb(r14);
        if (r1 != null) goto L22;
        com.bytedance.privacy.f.b.b(r0, "openSecuritySession failed: channel still null after re-init");
        return -31;
    L22:
        com.bytedance.privacy.pcc.h.b.c.C0174c r3 = r1.h();
        if (r3 != null) goto L25;
    L35:
        com.bytedance.privacy.f.b.b(r0, "openSecuritySession failed: service pod list is empty");
        return -31;
    L25:
        if (r3.b() == null) goto L35;
        if (r3.b().isEmpty() == true) goto L35;
        KeyPair r9 = c.e();     // Catch: Exception -> L32
        byte[] r11 = new byte[32];
        new SecureRandom().nextBytes(r11);
        List<com.bytedance.privacy.pcc.h.b.c.d> r4 = r3.b();
        this.sessionContextCache.put(r13, new a(r14, 1, r1.b(), r9, r4, r11));
        com.bytedance.privacy.f.b.a(r0, "openSecuritySession success: sessionId=" + r13 + ", podCount=" + r4.size());
        return 0;
    L32:
        e = move-exception;
        com.bytedance.privacy.f.b.b(TAG, "openSecuritySession failed: generate ephemeral key pair: " + e.getMessage());
        return -31;
    L13:
        if (isChannelExpired(r1) == false) goto L22;
        goto L14
    }
}
