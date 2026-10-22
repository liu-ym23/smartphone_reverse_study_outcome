package com.bytedance.privacy.pcc;

import a.a;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.privacy.network.NetworkConfig;
import com.bytedance.privacy.pcc.db.LaneTypeInfo;
import com.bytedance.privacy.pcc.db.PccChannelDb;
import com.bytedance.privacy.pcc.network.PccNetworkManager;
import com.bytedance.privacy.pcc.network.model.ChallengeResponse;
import com.bytedance.privacy.pcc.network.model.CreateChannelRequest;
import com.bytedance.privacy.pcc.network.model.CreateChannelResponse;
import com.bytedance.privacy.pcc.network.model.UploadChannelRetRequest;
import com.bytedance.privacy.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.matrix.push.common.CommonConstants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
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

    public static class SessionContext {
    }

    private PccManager() {
        this.sessionContextCache = new ConcurrentHashMap();
    }

    private void attachContext(Context r2) {
        if (r2 == null) goto L5;
        Context r3 = r2.getApplicationContext();
        this.appContext = r3;
        this.channelDb = new PccChannelDb(r3);
        return;
    }

    private Bundle createResultBundle(int r1, LaneType r2) {
        return createResultBundle(r1, r2.getValue());
    }

    public static PccManager getInstance(Context r2) {
        if (pccManager != null) goto L16;
        monitor-enter(PccManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (pccManager != null) goto L11;
        pccManager = new PccManager();     // Catch: Throwable -> L9
        pccManager.attachContext(r2);     // Catch: Throwable -> L9
    L11:
        monitor-exit(PccManager.class);     // Catch: Throwable -> L9
    L16:
        return pccManager;
    }

    private boolean isChannelExpired(CreateChannelResponse r8) {
        CreateChannelResponse.Payload r7 = r8.f18a;
        if (r7 == null) goto L5;
        String r9 = r7.e;
    L7:
        if (TextUtils.isEmpty(r9) == false) goto L17;
        return true;
    L17:
        if ((System.currentTimeMillis() / 1000) >= Long.parseLong(r9)) goto L19;
        return false;
    L19:
        return true;
    L15:
        LogUtils.b(TAG, "isChannelExpired: invalid expiry format: " + r9);
        return true;
    L5:
        r9 = "";
        goto L7
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
        LogUtils.b(TAG, "parseKeyVersion: non-integer '" + r4 + "', defaulting to 0");
        goto L10
    }

    private CreateChannelResponse queryChannelFromDb(AppInfo r13) {
        PccChannelDb r12 = this.channelDb;
        if (r12 != null) goto L6;
        LogUtils.b(TAG, "queryChannelFromDb: DB not ready");
        return null;
    L6:
        String r1 = r13.rpdid;
        String r2 = r13.rpuid;
        String r3 = r13.appId;
        String r14 = r13.appSvcId;
        r12.getClass();
        String[] r8 = {r1, r2, r3, r14};
        Cursor r15 = r12.f15a.getReadableDatabase().query("pcc_channel", null, "rpdid=? AND rpuid=? AND app_id=? AND svc_id=?", r8, null, null, null);     // Catch: Exception -> L14
        if (r15 != null) goto L30;
    L22:
        if (r15 == null) goto L33;
        r15.close();     // Catch: Exception -> L14
        return null;
    L33:
        return null;
    L30:
    L16:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: Exception -> L14
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L14
        goto L21
    L10:
        if (r15.moveToFirst() == false) goto L22;
        CreateChannelResponse r16 = CreateChannelResponse.a(r15.getString(r15.getColumnIndexOrThrow("service_info")), r15.getString(r15.getColumnIndexOrThrow("evidence_info")), r15.getString(r15.getColumnIndexOrThrow("access_token")), r15.getString(r15.getColumnIndexOrThrow(WsConstants.KEY_CHANNEL_ID)), r15.getString(r15.getColumnIndexOrThrow("channel_expiry_time")), r15.getString(r15.getColumnIndexOrThrow("payload_json")), r15.getString(r15.getColumnIndexOrThrow("response_id")), r15.getString(r15.getColumnIndexOrThrow("signature")), r15.getInt(r15.getColumnIndexOrThrow("protocol_version")));     // Catch: Throwable -> L16
        r15.close();     // Catch: Exception -> L14
        return r16;
    L14:
        e = move-exception;
        a.w(e, new StringBuilder("query exception: "), "PccChannelDb");
        return null;
    }

    private boolean verifyCloudSignature(CreateChannelResponse r6) {
        boolean r5 = NetworkConfig.a().b();
        if (r5 == false) goto L5;
        String r0 = CLOUD_CERT_BOE;
    L6:
        String r1 = TAG;
        if (r5 == false) goto L9;
        String r7 = "BOE";
    L10:
        LogUtils.a(r1, "verifyCloudSignature: env=".concat(r7));
        if (TextUtils.isEmpty(r6.f19d) == false) goto L23;
        LogUtils.b(r1, "verifyCloudSignature: server signature is empty");
        return false;
    L23:
        String r8 = r6.c;     // Catch: Exception -> L17
        String r3 = r6.b;     // Catch: Exception -> L17
        String r9 = r6.f19d;     // Catch: Exception -> L17
        String r10 = r8 + "|" + r3;     // Catch: Exception -> L17
        Charset r4 = StandardCharsets.UTF_8;     // Catch: Exception -> L17
        byte[] r11 = r10.getBytes(r4);     // Catch: Exception -> L17
        byte[] r12 = Base64.decode(r9, 8);     // Catch: Exception -> L17
        X509Certificate r2 = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(r0.getBytes(r4)));     // Catch: Exception -> L17
        Signature r13 = Signature.getInstance("SHA256withECDSA");     // Catch: Exception -> L17
        r13.initVerify(r2.getPublicKey());     // Catch: Exception -> L17
        r13.update(r11);     // Catch: Exception -> L17
        boolean r14 = r13.verify(r12);     // Catch: Exception -> L17
        if (r14 == true) goto L19;
        LogUtils.b(r1, "verifyCloudSignature: ECDSA verification failed");     // Catch: Exception -> L17
    L20:
        return r14;
    L19:
        LogUtils.d(r1, "verifyCloudSignature: signature valid");     // Catch: Exception -> L17
    L17:
        e = move-exception;
        a.w(e, new StringBuilder("verifyCloudSignature exception: "), TAG);
        return false;
    L9:
        r7 = "Online";
        goto L10
    L5:
        r0 = CLOUD_CERT_ONLINE;
        goto L6
    }

    private boolean verifyEvidenceToken(CreateChannelResponse r3, String r4, String r5, AppInfo r6) {
        CreateChannelResponse.Payload r2 = r3.f18a;
        if (r2 == null) goto L5;
        CreateChannelResponse.EvidenceInfo r7 = r2.b;
    L7:
        if (r7 != null) goto L11;
        LogUtils.a(TAG, "verifyEvidenceToken: no evidence_info in response, skip");
        return true;
    L11:
        if (TextUtils.isEmpty(null) == false) goto L14;
        LogUtils.a(TAG, "verifyEvidenceToken: evidence_token is empty, skip");
        return true;
    L14:
        r3.b();
        EvidenceTokenVerifier.a(r6.appId, r6.appSvcId, r4, r5);     // Catch: Exception -> L17
        throw null;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        LogUtils.b(TAG, "verifyEvidenceToken exception: " + Log.getStackTraceString(e));
        return false;
    L5:
        r7 = null;
        goto L7
    }

    public int closeSecuritySession(@NotNull String r4) {
        String r0 = TAG;
        LogUtils.a(r0, "closeSecuritySession called: sessionId=" + r4);
        if (isValidString(r4) == true) goto L7;
        LogUtils.b(r0, "closeSecuritySession failed: invalid sessionId (null, empty, or exceeds max length)");
        return -2;
    L7:
        if (this.sessionContextCache.get(r4) != null) goto L10;
        LogUtils.b(r0, "closeSecuritySession failed: session not found, sessionId=" + r4);
        return -32;
    L10:
        this.sessionContextCache.remove(r4);
        LogUtils.a(r0, "closeSecuritySession success: sessionId=" + r4);
        return 0;
    }

    public byte[] dataDecrypt(@NotNull String r4, @NotNull String r5) {
        String r0 = TAG;
        LogUtils.a(r0, "dataDecrypt called: sessionId=" + r4);
        if (isValidString(r4) == true) goto L6;
        LogUtils.b(r0, "dataDecrypt failed: invalid sessionId (null, empty, or exceeds max length)");
        return null;
    L6:
        if (r5 != null) goto L8;
    L19:
        LogUtils.b(r0, "dataDecrypt failed: invalid data (null, empty)");
        return null;
    L8:
        if (r5.length() <= 0) goto L19;
        if (this.sessionContextCache.get(r4) != null) goto L21;
        LogUtils.b(r0, "dataDecrypt failed: session not found");
        return null;
    L21:
        throw null;     // Catch: Exception -> L16
    L16:
        e = move-exception;
        a.w(e, new StringBuilder("dataDecrypt exception: "), TAG);
        return null;
    }

    public String dataEncrypt(@NotNull String r4, @NotNull byte[] r5) {
        String r0 = TAG;
        LogUtils.a(r0, "dataEncrypt called: sessionId=" + r4);
        if (isValidString(r4) == true) goto L6;
        LogUtils.b(r0, "dataEncrypt failed: invalid sessionId (null, empty, or exceeds max length)");
        return null;
    L6:
        if (r5 != null) goto L10;
        LogUtils.b(r0, "dataEncrypt failed: data is null");
        return null;
    L10:
        if (this.sessionContextCache.get(r4) != null) goto L13;
        LogUtils.b(r0, "dataEncrypt failed: session not found");
        return null;
    L13:
        throw null;
    }

    public String getVersion() {
        return PCC_PROTOCOL_VERSION;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public Bundle init(@NotNull AppInfo r44, @NotNull Bundle r45) {
        if (this.appContext != null) goto L7;
        LogUtils.b(TAG, "init failed: context not attached");
        return createResultBundle(-31, 1);
    L7:
        if (isValidAppInfo(r44) == true) goto L10;
        LogUtils.b(TAG, "init failed: invalid params (null, empty, or exceeds max length)");
        return createResultBundle(-2, 1);
    L10:
        LaneType r4 = LaneType.CPU_NORMAL;
        if (r45.containsKey(KEY_LANE_TYPE) == false) goto L17;
        int r0 = r45.getInt(KEY_LANE_TYPE, r4.getValue());
        if (LaneType.isValid(r0) == true) goto L16;
        LogUtils.b(TAG, "init failed: invalid lane_type=" + r0 + " (must be 0-3)");
        return createResultBundle(-2, r4);
    L16:
        r4 = LaneType.fromValue(r0);
    L17:
        String r1 = TAG;
        LogUtils.d(r1, "init called: appId=" + r44.appId + ", appSvcId=" + r44.appSvcId + ", rpdid=" + r44.rpdid + ", rpuid=" + r44.rpuid + ", clientLaneType=" + r4);
        CreateChannelResponse r7 = queryChannelFromDb(r44);
        String r9 = " rpuid=";
        String r12 = " svcId=";
        String r13 = "pcc_channel";
        String r14 = "PccChannelDb";
        if (r7 != null) goto L20;
    L41:
        String r17 = ")";
    L42:
        LogUtils.d(TAG, "init: no valid cached channel, proceeding with network flow");
        HashMap r3 = new HashMap();
        r3.put(HEADER_LANE_TYPE, String.valueOf(r4.getValue()));
        String r6 = UUID.randomUUID().toString();
        PccNetworkManager.b().getClass();
        if (NetworkConfig.a().b() == false) goto L45;
        String r2 = "https://opcc-gateway-boe.bytedance.net";
    L46:
        String r5 = r2.concat("/opcc/v2/auth/get/challenge");
        String r10 = "x-requestId";
        String r8 = "x-timestamp";
        Request.Builder r11 = new Request.Builder().url(r5).get().addHeader("x-requestId", r6).addHeader("x-timestamp", String.valueOf(System.currentTimeMillis()));
        PccNetworkManager.a(r11);
        Iterator r15 = r3.entrySet().iterator();
    L48:
        if (r15.hasNext() == false) goto L50;
        Map.Entry r20 = (Map.Entry) r15.next();
        Iterator r23 = r15;
        r11.addHeader((String) r20.getKey(), (String) r20.getValue());
        r8 = r8;
        r15 = r23;
        goto L48
    L50:
        String r22 = r8;
        Request r16 = r11.build();
        LogUtils.a("PccNetworkManager", "PCC GetChallenge request: " + r5);
        int r18 = 1;
    L51:
        String r21 = r10;
        String r25 = r6;
        String r26 = r14;
        String r27 = r9;
        String r28 = r12;
        String r29 = r13;
        String r30 = "";
        if (r18 > 3) goto L109;
        Response r31 = PccNetworkManager.f16a.newCall(r16).execute();     // Catch: Exception -> L94 IOException -> L96 ConnectException -> L98 SocketTimeoutException -> L100
    L82:
        th = th;
    L80:
        Throwable r19 = th;
    L87:
        if (r31 == null) goto L368;
        r31.close();     // Catch: Throwable -> L90
        throw r19;     // Catch: Exception -> L71 IOException -> L73 ConnectException -> L75 SocketTimeoutException -> L77
    L90:
        th = move-exception;
        r19.addSuppressed(th);     // Catch: Exception -> L71 IOException -> L73 ConnectException -> L75 SocketTimeoutException -> L77
        throw r19;     // Catch: Exception -> L71 IOException -> L73 ConnectException -> L75 SocketTimeoutException -> L77
    L368:
        throw r19;     // Catch: Exception -> L71 IOException -> L73 ConnectException -> L75 SocketTimeoutException -> L77
    L55:
        if (r31.body() != null) goto L349;
        String r24 = r30;
    L62:
        if (r31.isSuccessful() == false) goto L84;
        StringBuilder r32 = new StringBuilder();     // Catch: Throwable -> L82
        r32.append("PCC GetChallenge response: ");     // Catch: Throwable -> L79
        r32.append(r24);     // Catch: Throwable -> L79
        LogUtils.a("PccNetworkManager", r32.toString());     // Catch: Throwable -> L79
        ChallengeResponse r33 = ChallengeResponse.a(r24);     // Catch: Throwable -> L79
        String r34 = r33.f17a;     // Catch: Throwable -> L79
        if (r34 != null) goto L68;
    L81:
        LogUtils.b("PccNetworkManager", "PCC GetChallenge attempt " + r18 + ": nonce empty in response");     // Catch: Throwable -> L79
    L356:
        r31.close();     // Catch: Exception -> L71 IOException -> L73 ConnectException -> L75 SocketTimeoutException -> L77
    L106:
        if (r18 >= 3) goto L108;
        Thread.sleep(500);     // Catch: InterruptedException -> L301
    L108:
        r18 = r18 + 1;
        r10 = r21;
        r6 = r25;
        r14 = r26;
        r9 = r27;
        r12 = r28;
        r13 = r29;
        r16 = r16;
    L75:
        e = e;
    L104:
        StringBuilder r35 = a.p(r18, "PCC GetChallenge attempt ", ": ConnectException: ");
        r35.append(e.getMessage());
        LogUtils.b("PccNetworkManager", r35.toString());
    L77:
        e = e;
    L105:
        StringBuilder r36 = a.p(r18, "PCC GetChallenge attempt ", ": SocketTimeoutException: ");
        r36.append(e.getMessage());
        LogUtils.b("PccNetworkManager", r36.toString());
    L73:
        e = e;
    L103:
        StringBuilder r37 = a.p(r18, "PCC GetChallenge attempt ", ": IOException: ");
        r37.append(e.getMessage());
        LogUtils.b("PccNetworkManager", r37.toString());
    L71:
        e = e;
    L102:
        LogUtils.c("PccNetworkManager", "PCC GetChallenge attempt " + r18 + ": unexpected exception: ", e);
        goto L106
    L68:
        if (r34.isEmpty() == true) goto L81;
        r31.close();     // Catch: Exception -> L71 IOException -> L73 ConnectException -> L75 SocketTimeoutException -> L77
    L110:
        if (r33 == null) goto L113;
        String r38 = r33.f17a;
        if (TextUtils.isEmpty(r38) == true) goto L113;
        LaneType r39 = LaneType.fromValue(r33.b);
        LaneType r40 = LaneType.negotiate(r4, r39);
        String r41 = TAG;
        Object r310 = ": SocketTimeoutException: ";
        LogUtils.d(r41, "Lane routing decision: client=" + r4 + ", server=" + r39 + ", final=" + r40);
        StringBuilder r110 = new StringBuilder("PCC challenge obtained, nonce=");
        r110.append(r38);
        LogUtils.d(r41, r110.toString());
        r3.put(HEADER_LANE_TYPE, String.valueOf(r40.getValue()));
        KeyAttestationHelper.a(this.appContext, r38, r44.rpdid, r44.rpuid);     // Catch: Exception -> L295
        PccChannelDb r42 = this.channelDb;
        String r43 = r44.rpdid;
        String r111 = r44.rpuid;
        String r46 = r44.appId;
        LaneType r311 = r4;
        String r47 = r44.appSvcId;
        r42.getClass();
        String r312 = ": ConnectException: ";
        String r48 = r29;
        int r49 = r42.f15a.getWritableDatabase().delete(r48, "app_id=? AND svc_id=? AND (rpdid!=? OR rpuid!=?)", new String[]{r46, r47, r43, r111});     // Catch: Exception -> L135
        StringBuilder r50 = new StringBuilder("deleteOtherRpuidChannels: deleted ");     // Catch: Exception -> L135
        r50.append(r49);     // Catch: Exception -> L135
        r50.append(" rows for appId=");     // Catch: Exception -> L135
        r50.append(r46);     // Catch: Exception -> L135
        String r51 = r28;
        r50.append(r51);     // Catch: Exception -> L133
        r50.append(r47);     // Catch: Exception -> L133
        r50.append(" (keeping rpdid=");     // Catch: Exception -> L133
        r50.append(r43);     // Catch: Exception -> L133
        r50.append(r27);     // Catch: Exception -> L133
        r50.append(r111);     // Catch: Exception -> L133
        String r52 = r17;
        r50.append(r52);     // Catch: Exception -> L131
        String r53 = r26;
        LogUtils.d(r53, r50.toString());     // Catch: Exception -> L129
    L143:
        LogUtils.d(TAG, "init: cleaned up " + r49 + " old channel(s) for other rpuids");
        String r54 = String.valueOf(System.currentTimeMillis());
        byte[] r55 = new byte[8];
        new SecureRandom().nextBytes(r55);
        StringBuilder r56 = new StringBuilder(r55.length * 2);
        int r112 = r55.length;
        int r113 = 0;
    L144:
        if (r113 >= r112) goto L146;
        r56.append(String.format("%02x", new Object[]{Integer.valueOf(r55[r113] & 255)}));
        r113 = r113 + 1;
        r112 = r112;
        r55 = r55;
        goto L144
    L146:
        String r57 = r56.toString();
        String r58 = new GsonBuilder().disableHtmlEscaping().create().toJson(new CreateChannelRequest.Payload());
        Charset r114 = StandardCharsets.UTF_8;
        String r59 = Base64.encodeToString(r58.getBytes(r114), 11);
        StringBuilder r115 = new StringBuilder();
        String r210 = r52;
        r115.append(r25);
        String r211 = r51;
        r115.append("|");
        r115.append(r54);
        r115.append("|");
        r115.append(r59);
        Base64.encodeToString(KeyAttestationHelper.b(this.appContext, r115.toString().getBytes(r114)), 11);     // Catch: Exception -> L292
        String r60 = new GsonBuilder().disableHtmlEscaping().create().toJson(new CreateChannelRequest());
        PccNetworkManager.b().getClass();
        if (NetworkConfig.a().b() == false) goto L151;
        String r116 = "https://opcc-gateway-boe.bytedance.net";
    L152:
        String r61 = r116.concat("/opcc/v2/auth/create/channel");
        String r212 = r53;
        String r213 = r48;
        Request.Builder r62 = new Request.Builder().url(r61).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r60)).addHeader("Content-Type", "application/json").addHeader(r21, r25).addHeader(r22, r54);
        PccNetworkManager.a(r62);
        Iterator r63 = r3.entrySet().iterator();
    L154:
        if (r63.hasNext() == false) goto L156;
        Map.Entry r64 = (Map.Entry) r63.next();
        r62.addHeader((String) r64.getKey(), (String) r64.getValue());
        goto L154
    L156:
        Request r65 = r62.build();
        LogUtils.a("PccNetworkManager", "PCC CreateChannel request: " + r61);
        LogUtils.a("PccNetworkManager", "PCC CreateChannel request body: " + r60);
        int r66 = 1;
        int r67 = 3;
    L157:
        if (r66 > r67) goto L217;
        Response r68 = PccNetworkManager.f16a.newCall(r65).execute();     // Catch: Exception -> L200 IOException -> L202 ConnectException -> L204 SocketTimeoutException -> L206
    L163:
        th = th;
    L165:
        Throwable r69 = th;
        if (r68 == null) goto L370;
        r68.close();     // Catch: Throwable -> L196
        throw r69;     // Catch: Exception -> L176 IOException -> L178 ConnectException -> L180 SocketTimeoutException -> L182
    L196:
        th = move-exception;
        r69.addSuppressed(th);     // Catch: Exception -> L176 IOException -> L178 ConnectException -> L180 SocketTimeoutException -> L182
        throw r69;     // Catch: Exception -> L176 IOException -> L178 ConnectException -> L180 SocketTimeoutException -> L182
    L370:
        throw r69;     // Catch: Exception -> L176 IOException -> L178 ConnectException -> L180 SocketTimeoutException -> L182
    L161:
        if (r68.body() == null) goto L166;
        String r70 = r68.body().string();     // Catch: Throwable -> L163
    L168:
        String r71 = r30;
        String r72 = r68.header("x-responseId", r71);     // Catch: Throwable -> L186
        if (r68.isSuccessful() == true) goto L171;
        Request r117 = r65;
        LogUtils.b("PccNetworkManager", "PCC CreateChannel attempt " + r66 + ": HTTP " + r68.code() + " body=" + r70);     // Catch: Throwable -> L184
        r68.close();     // Catch: Exception -> L176 IOException -> L178 ConnectException -> L180 SocketTimeoutException -> L182
    L191:
        r310 = r310;
        r312 = r312;
    L214:
        if (r66 >= 3) goto L216;
        Thread.sleep(500);     // Catch: InterruptedException -> L300
    L216:
        r66 = r66 + 1;
        r312 = r312;
        r310 = r310;
        r67 = 3;
        r30 = r71;
        r65 = r117;
    L180:
        e = e;
    L181:
        r312 = r312;
        StringBuilder r73 = a.p(r66, "PCC CreateChannel attempt ", r312);
        r73.append(e.getMessage());
        LogUtils.b("PccNetworkManager", r73.toString());
        r310 = r310;
    L182:
        e = e;
    L213:
        StringBuilder r74 = a.p(r66, "PCC CreateChannel attempt ", r310);
        r74.append(e.getMessage());
        LogUtils.b("PccNetworkManager", r74.toString());
    L178:
        e = e;
    L209:
        StringBuilder r75 = a.p(r66, "PCC CreateChannel attempt ", ": IOException: ");
        r75.append(e.getMessage());
        LogUtils.b("PccNetworkManager", r75.toString());
    L176:
        e = e;
    L208:
        LogUtils.c("PccNetworkManager", "PCC CreateChannel attempt " + r66 + ": unexpected exception: ", e);
    L184:
        th = th;
        goto L165
    L171:
        StringBuilder r118 = new StringBuilder();     // Catch: Throwable -> L186
        r118.append("PCC CreateChannel response: ");     // Catch: Throwable -> L184
        r118.append(r70);     // Catch: Throwable -> L184
        LogUtils.a("PccNetworkManager", r118.toString());     // Catch: Throwable -> L184
        CreateChannelResponse r76 = CreateChannelResponse.c(r70, r72);     // Catch: Throwable -> L184
        r68.close();     // Catch: Exception -> L176 IOException -> L178 ConnectException -> L180 SocketTimeoutException -> L182
        CreateChannelResponse r77 = r76;
    L218:
        if (r77 != null) goto L221;
        LogUtils.b(TAG, "init failed: createChannel returned null");
        return createResultBundle(-31, r40);
    L221:
        CreateChannelResponse.Payload r78 = r77.f18a;
        if (verifyCloudSignature(r77) == true) goto L226;
        LogUtils.b(TAG, "init failed: cloud response signature verification failed");
        return createResultBundle(-31, r40);
    L226:
        if (verifyEvidenceToken(r77, r38, r57, r44) == true) goto L228;
        LogUtils.b(TAG, "init warning: evidence token verification failed (non-fatal)");
    L228:
        int r79 = r311.getValue();
        int r80 = r39.getValue();
        int r119 = r40.getValue();
        LaneTypeInfo r81 = new LaneTypeInfo(r79, r80, r119);
        PccChannelDb r120 = this.channelDb;
        String r121 = r44.rpdid;
        String r122 = r44.rpuid;
        String r123 = r44.appId;
        String r124 = r44.appSvcId;
        r120.getClass();
        String r313 = r71;
        if (r77.b() == null) goto L241;
        String r214 = r25;
        CreateChannelResponse.ServiceInfo r82 = r77.b();     // Catch: Exception -> L239
        r82.getClass();     // Catch: Exception -> L236
        LaneType r314 = r40;
        String r83 = new Gson().toJson(r82);     // Catch: Exception -> L270
    L242:
        if (r78 == null) goto L244;
        CreateChannelResponse.EvidenceInfo r84 = r78.b;     // Catch: Exception -> L270
    L245:
        if (r84 == null) goto L250;
        if (r78 == null) goto L248;
        CreateChannelResponse.EvidenceInfo r85 = r78.b;     // Catch: Exception -> L270
    L249:
        r85.getClass();     // Catch: Exception -> L270
        String r86 = new Gson().toJson(r85);     // Catch: Exception -> L270
    L251:
        ContentValues r87 = new ContentValues();     // Catch: Exception -> L270
        r87.put("rpdid", r121);     // Catch: Exception -> L270
        r87.put("rpuid", r122);     // Catch: Exception -> L270
        r87.put(CommonConstants.APP_ID, r123);     // Catch: Exception -> L270
        r87.put("svc_id", r124);     // Catch: Exception -> L270
        if (r78 == null) goto L254;
        String r125 = r78.c;     // Catch: Exception -> L270
    L255:
        r87.put("access_token", r125);     // Catch: Exception -> L270
        if (r78 == null) goto L258;
        String r126 = r78.f21d;     // Catch: Exception -> L270
    L259:
        r87.put(WsConstants.KEY_CHANNEL_ID, r126);     // Catch: Exception -> L270
        if (r78 == null) goto L262;
        String r127 = r78.e;     // Catch: Exception -> L270
    L263:
        r87.put("channel_expiry_time", r127);     // Catch: Exception -> L270
        r87.put("service_info", r83);     // Catch: Exception -> L270
        r87.put("evidence_info", r86);     // Catch: Exception -> L270
        r87.put("payload_json", r77.b);     // Catch: Exception -> L270
        r87.put("response_id", r77.c);     // Catch: Exception -> L270
        r87.put("signature", r77.f19d);     // Catch: Exception -> L270
        r87.put("protocol_version", 2);     // Catch: Exception -> L270
        r87.put("client_lane_type", Integer.valueOf(r79));     // Catch: Exception -> L270
        r87.put("server_lane_type", Integer.valueOf(r80));     // Catch: Exception -> L270
        r87.put("final_lane_type", Integer.valueOf(r119));     // Catch: Exception -> L270
        int r88 = (r120.f15a.getWritableDatabase().insertWithOnConflict(r213, null, r87, 5) > (-1) ? 1 : (r120.f15a.getWritableDatabase().insertWithOnConflict(r213, null, r87, 5) == (-1) ? 0 : -1));
        if (r88 == 0) goto L267;
        LogUtils.d(r212, "save success: rpdid=" + r121 + " appId=" + r123 + r211 + r124 + " protocolVersion=2 " + r81);     // Catch: Exception -> L268
    L279:
        if (this.channelDb.b(r44.rpdid, r44.rpuid, r44.appId, r44.appSvcId, r77) == true) goto L281;
        LogUtils.b(TAG, "init warning: failed to save key attestation history");
    L281:
        String r89 = TAG;
        StringBuilder r90 = new StringBuilder("init success, channelId=");
        if (r78 == null) goto L284;
        String r91 = r78.f21d;
    L285:
        r90.append(r91);
        r90.append(", finalLaneType=");
        LaneType r92 = r314;
        r90.append(r92);
        r90.append(" (value=");
        r90.append(r92.getValue());
        r90.append(r210);
        LogUtils.d(r89, r90.toString());
        String r93 = new Gson().toJson(new UploadChannelRetRequest.Payload());
        Charset r94 = StandardCharsets.UTF_8;
        String r95 = Base64.encodeToString(r93.getBytes(r94), 11);
        String r96 = String.valueOf(System.currentTimeMillis());
        StringBuilder r97 = new StringBuilder();
        String r98 = r214;
        r97.append(r98);
        r97.append("|");
        r97.append(r96);
        r97.append("|");
        r97.append(r95);
        Base64.encodeToString(KeyAttestationHelper.b(this.appContext, r97.toString().getBytes(r94)), 11);     // Catch: Exception -> L288
        String r99 = new Gson().toJson(new UploadChannelRetRequest());     // Catch: Exception -> L288
        PccNetworkManager.b().getClass();     // Catch: Exception -> L288
        LogUtils.d(r89, "init: uploadChannelRet logId=" + PccNetworkManager.c(r98, r96, r99));     // Catch: Exception -> L288
    L291:
        return createResultBundle(0, r92);
    L288:
        e = move-exception;
        a.w(e, new StringBuilder("init: uploadChannelRet sign failed (non-fatal): "), TAG);
        goto L291
    L284:
        r91 = r313;
        goto L285
    L267:
        LogUtils.b(r212, "save: insertWithOnConflict returned -1");     // Catch: Exception -> L268
    L277:
        LogUtils.b(TAG, "init warning: failed to persist channel data to DB");
    L268:
        e = e;
        String r100 = r88;
    L276:
        a.w(e, new StringBuilder("save exception: "), r100);
        goto L277
    L262:
        r127 = r313;
        goto L263
    L258:
        r126 = r313;
        goto L259
    L254:
        r125 = r313;
        goto L255
    L248:
        r85 = null;
        goto L249
    L250:
        r86 = r313;
        goto L251
    L244:
        r84 = null;
    L270:
        e = e;
    L238:
        r100 = r212;
    L236:
        e = e;
    L240:
        r314 = r40;
    L239:
        e = e;
        goto L240
    L241:
        r214 = r25;
        r314 = r40;
        r83 = r313;
    L274:
        e = e;
        r214 = r25;
    L186:
        th = th;
        goto L165
    L166:
        r70 = r30;
        goto L168
    L206:
        e = e;
        r117 = r65;
        r71 = r30;
    L211:
        e = e;
        r117 = r65;
        r71 = r30;
    L204:
        e = e;
        r117 = r65;
        r71 = r30;
    L202:
        e = e;
        r117 = r65;
        r71 = r30;
    L200:
        e = e;
        r117 = r65;
        r71 = r30;
        goto L208
    L217:
        r71 = r30;
        r77 = null;
        goto L218
    L151:
        r116 = "https://opcc-gateway.obriccloud.com";
    L292:
        e = move-exception;
        a.w(e, new StringBuilder("init failed: sign request: "), TAG);
        return createResultBundle(-31, r40);
    L129:
        e = e;
    L142:
        a.w(e, new StringBuilder("deleteOtherRpuidChannels exception: "), r53);
        r49 = 0;
    L131:
        e = e;
    L132:
        r53 = r26;
    L133:
        e = e;
        r52 = r17;
    L135:
        e = e;
        r52 = r17;
        r53 = r26;
        r51 = r28;
    L137:
        e = e;
        r312 = ": ConnectException: ";
        r52 = r17;
        r53 = r26;
        r51 = r28;
        r48 = r29;
    L295:
        e = move-exception;
        a.w(e, new StringBuilder("init failed: attestation: "), TAG);
        return createResultBundle(-31, r40);
    L113:
        LaneType r315 = r4;
        LogUtils.b(TAG, "init failed: get PCC challenge failed");
        return createResultBundle(-31, r315);
    L79:
        th = th;
        goto L80
    L84:
        LogUtils.b("PccNetworkManager", "PCC GetChallenge attempt " + r18 + ": HTTP " + r31.code() + " body=" + r24);     // Catch: Throwable -> L79
        goto L356
    L349:
        r24 = r31.body().string();     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        r19 = th;
        goto L87
    L98:
        e = e;
        r16 = r16;
    L100:
        e = e;
        r16 = r16;
    L96:
        e = e;
        r16 = r16;
    L94:
        e = e;
        r16 = r16;
        goto L102
    L109:
        r33 = null;
        goto L110
    L45:
        r2 = "https://opcc-gateway.obriccloud.com";
        goto L46
    L20:
        if (isChannelExpired(r7) == true) goto L41;
        if (r7.e != 2) goto L41;
        LaneTypeInfo r101 = this.channelDb.a(r44.rpdid, r44.rpuid, r44.appId, r44.appSvcId);
        if (r101 == null) goto L37;
        int r102 = r4.getValue();
        int r103 = r101.f14a;
        if (r103 == r102) goto L37;
        StringBuilder r104 = a.p(r103, "init: client lane_type changed (cached=", ", requested=");
        r104.append(r4.getValue());
        r104.append("), deleting old channel and re-negotiating");
        LogUtils.d(r1, r104.toString());
        PccChannelDb r105 = this.channelDb;
        String r106 = r44.rpdid;
        String r107 = r44.rpuid;
        String r108 = r44.appId;
        String r128 = r44.appSvcId;
        r105.getClass();
        r17 = ")";
        LogUtils.d("PccChannelDb", "delete: deleted " + r105.f15a.getWritableDatabase().delete("pcc_channel", "rpdid=? AND rpuid=? AND app_id=? AND svc_id=?", new String[]{r106, r107, r108, r128}) + " rows for rpdid=" + r106 + " rpuid=" + r107 + " appId=" + r108 + " svcId=" + r128);     // Catch: Exception -> L32
    L32:
        e = move-exception;
        a.w(e, new StringBuilder("delete exception: "), "PccChannelDb");
    L37:
        r17 = ")";
        if (r101 == null) goto L42;
        LogUtils.d(r1, "init: using valid cached V2 channel " + r101);
        return createResultBundle(0, LaneType.fromValue(r101.c));
    }

    public Bundle openSecuritySession(@NotNull String r10, @NotNull AppInfo r11, @NotNull Bundle r12) {
        String r0 = TAG;
        LogUtils.a(r0, "openSecuritySession called: sessionId=" + r10);
        if (isValidString(r10) == true) goto L7;
        LogUtils.b(r0, "openSecuritySession failed: invalid sessionId (null, empty, or exceeds max length)");
        return createResultBundle(-2, LaneType.CPU_NORMAL);
    L7:
        if (isValidAppInfo(r11) == true) goto L10;
        LogUtils.b(r0, "openSecuritySession failed: invalid appInfo (null, empty, or exceeds max length)");
        return createResultBundle(-2, LaneType.CPU_NORMAL);
    L10:
        LaneType r13 = LaneType.CPU_NORMAL;
        if (r12.containsKey(KEY_LANE_TYPE) == false) goto L17;
        int r3 = r12.getInt(KEY_LANE_TYPE, r13.getValue());
        if (LaneType.isValid(r3) == true) goto L16;
        LogUtils.b(r0, "openSecuritySession failed: invalid lane_type=" + r3 + " (must be 0-3)");
        return createResultBundle(-2, r13);
    L16:
        r13 = LaneType.fromValue(r3);
    L17:
        CreateChannelResponse r1 = queryChannelFromDb(r11);
        boolean r4 = true;
        if (r1 != null) goto L20;
    L31:
        LogUtils.a(r0, "openSecuritySession: channel missing or expired, re-initialising");
    L27:
        LaneType r5 = r13;
    L33:
        if (r4 == false) goto L42;
        Bundle r14 = init(r11, r12);
        int r2 = r14.getInt("error_code", -31);
        if (r2 == 0) goto L38;
        LogUtils.b(r0, "openSecuritySession failed: re-init returned " + r2);
        return r14;
    L38:
        r5 = LaneType.fromValue(r14.getInt(KEY_LANE_TYPE, r13.getValue()));
        r1 = queryChannelFromDb(r11);
        if (r1 != null) goto L42;
        LogUtils.b(r0, "openSecuritySession failed: channel still null after re-init");
        return createResultBundle(-31, r5);
    L42:
        r1.b();
        LogUtils.b(r0, "openSecuritySession failed: service key info is empty");
        return createResultBundle(-31, r5);
    L20:
        if (isChannelExpired(r1) == true) goto L31;
        LaneTypeInfo r6 = this.channelDb.a(r11.rpdid, r11.rpuid, r11.appId, r11.appSvcId);
        if (r6 == null) goto L28;
        int r7 = r13.getValue();
        int r8 = r6.f14a;
        if (r8 == r7) goto L28;
        LogUtils.d(r0, "openSecuritySession: client lane_type changed (cached=" + r8 + ", requested=" + r13.getValue() + "), re-initialising");
    L28:
        r4 = false;
        if (r6 == null) goto L27;
        r5 = LaneType.fromValue(r6.c);
        goto L33
    }

    private Bundle createResultBundle(int r2, int r3) {
        Bundle r1 = new Bundle();
        r1.putInt("error_code", r2);
        r1.putInt(KEY_LANE_TYPE, r3);
        return r1;
    }
}
