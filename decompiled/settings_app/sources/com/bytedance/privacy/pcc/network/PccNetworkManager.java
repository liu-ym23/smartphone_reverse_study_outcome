package com.bytedance.privacy.pcc.network;

import com.bytedance.privacy.network.NetworkConfig;
import com.bytedance.privacy.pcc.network.model.ChallengeResponse;
import com.bytedance.privacy.pcc.network.model.CreateChannelResponse;
import com.bytedance.privacy.pcc.network.model.QueryEvidenceResponse;
import com.bytedance.privacy.pcc.network.model.UploadChannelRetResponse;
import com.bytedance.privacy.utils.LogUtils;
import com.loopj.android.http.RequestParams;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public class PccNetworkManager {
    private static final String HEADER_REQUEST_ID = "x-requestId";
    private static final String HEADER_RESPONSE_ID = "x-responseId";
    private static final String HEADER_TIMESTAMP = "x-timestamp";
    private static final String HEADER_TT_ENV = "x-tt-env";
    private static final String HEADER_USE_PPE = "x-use-ppe";
    private static final int MAX_RETRY = 3;
    private static final String PATH_CREATE_CHANNEL = "/opcc/v2/auth/create/channel";
    private static final String PATH_GET_CHALLENGE = "/opcc/v2/auth/get/challenge";
    private static final String PATH_QUERY_EVIDENCE = "/opcc/v1/query/evidence";
    private static final String PATH_TEST_DECRYPT = "/test/v1/decrypt";
    private static final String PATH_UPLOAD_CHANNEL_RET = "/opcc/v2/auth/upload/channelRet";
    private static final String PCC_BASE_URL_BOE = "https://opcc-gateway-boe.bytedance.net";
    private static final String PCC_BASE_URL_PPE = "https://opcc-gateway.obriccloud.com";
    private static final String TAG = "PccNetworkManager";
    private static final OkHttpClient client = null;
    private static volatile PccNetworkManager instance;

    static {
        client = new OkHttpClient();
    }

    public static PccNetworkManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(PccNetworkManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new PccNetworkManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PccNetworkManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private PccNetworkManager() {
    }

    private static String baseUrl() {
        if (NetworkConfig.getInstance().isBoeEnv() == false) goto L5;
        return PCC_BASE_URL_BOE;
    L5:
        return PCC_BASE_URL_PPE;
    }

    private static Request.Builder addEnvHeaders(Request.Builder r1) {
        NetworkConfig.getInstance().isBoeEnv();
        return r1;
    }

    public ChallengeResponse requestChallenge(String r6, Map<String, String> r7) {
        String r0 = baseUrl() + PATH_GET_CHALLENGE;
        Request.Builder r8 = addEnvHeaders(new Request.Builder().url(r0).get().addHeader(HEADER_REQUEST_ID, r6).addHeader(HEADER_TIMESTAMP, String.valueOf(System.currentTimeMillis())));
        if (r7 == null) goto L8;
        Iterator<Map.Entry<String, String>> r9 = r7.entrySet().iterator();
    L6:
        if (r9.hasNext() == false) goto L8;
        Map.Entry<String, String> r1 = r9.next();
        r8.addHeader(r1.getKey(), r1.getValue());
    L8:
        Request r10 = r8.build();
        LogUtils.d(TAG, "PCC GetChallenge request: " + r0);
        int r11 = 1;
    L10:
        if (r11 > 3) goto L51;
        Response r2 = client.newCall(r10).execute();     // Catch: Exception -> L39 IOException -> L41 ConnectException -> L43 SocketTimeoutException -> L45
        if (r2.body() == null) goto L15;
        String r3 = r2.body().string();     // Catch: Throwable -> L32
    L17:
        if (r2.isSuccessful() == false) goto L28;
        ChallengeResponse r4 = ChallengeResponse.parse(r3);     // Catch: Throwable -> L32
        if (r4 != null) goto L21;
    L27:
        LogUtils.e(TAG, "PCC GetChallenge attempt " + r11 + ": nonce empty in response");     // Catch: Throwable -> L32
    L29:
        if (r2 == null) goto L47;
        r2.close();     // Catch: Exception -> L39 IOException -> L41 ConnectException -> L43 SocketTimeoutException -> L45
    L47:
        if (r11 >= 3) goto L50;
        Thread.sleep(500);     // Catch: InterruptedException -> L53
    L50:
        r11 = r11 + 1;
        goto L10
    L21:
        if (r4.getNonce() == null) goto L27;
        if (r4.getNonce().isEmpty() == true) goto L27;
        if (r2 == null) goto L26;
        r2.close();     // Catch: Exception -> L39 IOException -> L41 ConnectException -> L43 SocketTimeoutException -> L45
    L26:
        return r4;
    L28:
        LogUtils.e(TAG, "PCC GetChallenge attempt " + r11 + ": HTTP " + r2.code());     // Catch: Throwable -> L32
        goto L29
    L15:
        r3 = "";
    L32:
        th = move-exception;
        if (r2 != null) goto L58;
    L38:
        throw th;     // Catch: Exception -> L39 IOException -> L41 ConnectException -> L43 SocketTimeoutException -> L45
    L58:
        r2.close();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L39 IOException -> L41 ConnectException -> L43 SocketTimeoutException -> L45
    L43:
        e = move-exception;
        LogUtils.e(TAG, "PCC GetChallenge attempt " + r11 + ": ConnectException: " + e.getMessage());
    L45:
        e = move-exception;
        LogUtils.e(TAG, "PCC GetChallenge attempt " + r11 + ": SocketTimeoutException: " + e.getMessage());
    L41:
        e = move-exception;
        LogUtils.e(TAG, "PCC GetChallenge attempt " + r11 + ": IOException: " + e.getMessage());
    L39:
        e = move-exception;
        LogUtils.e(TAG, "PCC GetChallenge attempt " + r11 + ": unexpected exception: ", e);
        goto L47
    L51:
        return null;
    }

    public CreateChannelResponse createChannel(String r4, String r5, String r6, Map<String, String> r7) {
        String r0 = baseUrl() + PATH_CREATE_CHANNEL;
        Request.Builder r8 = addEnvHeaders(new Request.Builder().url(r0).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r6)).addHeader("Content-Type", RequestParams.APPLICATION_JSON).addHeader(HEADER_REQUEST_ID, r4).addHeader(HEADER_TIMESTAMP, r5));
        if (r7 == null) goto L8;
        Iterator<Map.Entry<String, String>> r9 = r7.entrySet().iterator();
    L6:
        if (r9.hasNext() == false) goto L8;
        Map.Entry<String, String> r10 = r9.next();
        r8.addHeader(r10.getKey(), r10.getValue());
    L8:
        Request r11 = r8.build();
        LogUtils.d(TAG, "PCC CreateChannel request: " + r0);
        int r12 = 1;
    L10:
        if (r12 > 3) goto L46;
        Response r13 = client.newCall(r11).execute();     // Catch: Exception -> L34 IOException -> L36 ConnectException -> L38 SocketTimeoutException -> L40
    L27:
        th = move-exception;
        if (r13 != null) goto L49;
    L33:
        throw th;     // Catch: Exception -> L34 IOException -> L36 ConnectException -> L38 SocketTimeoutException -> L40
    L49:
        r13.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L34 IOException -> L36 ConnectException -> L38 SocketTimeoutException -> L40
        goto L33
    L14:
        if (r13.body() == null) goto L16;
        String r1 = r13.body().string();     // Catch: Throwable -> L27
    L17:
        String r2 = r13.header(HEADER_RESPONSE_ID, "");     // Catch: Throwable -> L27
        if (r13.isSuccessful() == true) goto L19;
        LogUtils.e(TAG, "PCC CreateChannel attempt " + r12 + ": HTTP " + r13.code());     // Catch: Throwable -> L27
        if (r13 == null) goto L42;
        r13.close();     // Catch: Exception -> L34 IOException -> L36 ConnectException -> L38 SocketTimeoutException -> L40
    L42:
        if (r12 >= 3) goto L45;
        Thread.sleep(500);     // Catch: InterruptedException -> L48
    L45:
        r12 = r12 + 1;
        goto L10
    L19:
        CreateChannelResponse r3 = CreateChannelResponse.parse(r1, r2);     // Catch: Throwable -> L27
        if (r13 == null) goto L22;
        r13.close();     // Catch: Exception -> L34 IOException -> L36 ConnectException -> L38 SocketTimeoutException -> L40
    L22:
        return r3;
    L16:
        r1 = "";
    L38:
        e = move-exception;
        LogUtils.e(TAG, "PCC CreateChannel attempt " + r12 + ": ConnectException: " + e.getMessage());
    L40:
        e = move-exception;
        LogUtils.e(TAG, "PCC CreateChannel attempt " + r12 + ": SocketTimeoutException: " + e.getMessage());
    L36:
        e = move-exception;
        LogUtils.e(TAG, "PCC CreateChannel attempt " + r12 + ": IOException: " + e.getMessage());
    L34:
        e = move-exception;
        LogUtils.e(TAG, "PCC CreateChannel attempt " + r12 + ": unexpected exception: ", e);
        goto L42
    L46:
        return null;
    }

    public CreateChannelResponse createChannel(String r2, String r3, String r4) {
        return createChannel(r2, r3, r4, null);
    }

    public String uploadChannelRet(String r5, String r6, String r7) {
        String r0 = baseUrl() + PATH_UPLOAD_CHANNEL_RET;
        Request r8 = addEnvHeaders(new Request.Builder().url(r0).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r7)).addHeader("Content-Type", RequestParams.APPLICATION_JSON).addHeader(HEADER_REQUEST_ID, r5).addHeader(HEADER_TIMESTAMP, r6)).build();
        LogUtils.d(TAG, "PCC UploadChannelRet request: " + r0);
        int r9 = 1;
    L3:
        String r10 = "";
        if (r9 > 3) goto L38;
        Response r1 = client.newCall(r8).execute();     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
    L19:
        th = move-exception;
        if (r1 != null) goto L42;
    L25:
        throw th;     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
    L42:
        r1.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
        goto L25
    L7:
        if (r1.body() == null) goto L10;
        r10 = r1.body().string();     // Catch: Throwable -> L19
    L10:
        if (r1.isSuccessful() == true) goto L11;
        LogUtils.e(TAG, "PCC UploadChannelRet attempt " + r9 + ": HTTP " + r1.code());     // Catch: Throwable -> L19
        if (r1 == null) goto L34;
        r1.close();     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
    L34:
        if (r9 >= 3) goto L37;
        Thread.sleep(500);     // Catch: InterruptedException -> L39
    L37:
        r9 = r9 + 1;
        goto L3
    L11:
        String r11 = UploadChannelRetResponse.parse(r10).getLogId();     // Catch: Throwable -> L19
        if (r1 == null) goto L14;
        r1.close();     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
    L14:
        return r11;
    L30:
        e = move-exception;
        LogUtils.e(TAG, "PCC UploadChannelRet attempt " + r9 + ": ConnectException: " + e.getMessage());
    L32:
        e = move-exception;
        LogUtils.e(TAG, "PCC UploadChannelRet attempt " + r9 + ": SocketTimeoutException: " + e.getMessage());
    L28:
        e = move-exception;
        LogUtils.e(TAG, "PCC UploadChannelRet attempt " + r9 + ": IOException: " + e.getMessage());
    L26:
        e = move-exception;
        LogUtils.e(TAG, "PCC UploadChannelRet attempt " + r9 + ": unexpected exception: ", e);
        goto L34
    L38:
        return "";
    }

    public QueryEvidenceResponse queryEvidence(String r5, String r6, String r7) {
        String r0 = baseUrl() + PATH_QUERY_EVIDENCE;
        Request r8 = addEnvHeaders(new Request.Builder().url(r0).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r7)).addHeader("Content-Type", RequestParams.APPLICATION_JSON).addHeader(HEADER_REQUEST_ID, r5).addHeader(HEADER_TIMESTAMP, r6)).build();
        LogUtils.d(TAG, "PCC QueryEvidence request: " + r0);
        int r9 = 1;
    L4:
        if (r9 > 3) goto L40;
        Response r1 = client.newCall(r8).execute();     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
    L21:
        th = move-exception;
        if (r1 != null) goto L47;
    L27:
        throw th;     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
    L47:
        r1.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
        goto L27
    L8:
        if (r1.body() == null) goto L10;
        String r2 = r1.body().string();     // Catch: Throwable -> L21
    L11:
        String r3 = r1.header(HEADER_RESPONSE_ID, "");     // Catch: Throwable -> L21
        if (r1.isSuccessful() == true) goto L13;
        LogUtils.e(TAG, "PCC QueryEvidence attempt " + r9 + ": HTTP " + r1.code());     // Catch: Throwable -> L21
        if (r1 == null) goto L36;
        r1.close();     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
    L36:
        if (r9 >= 3) goto L39;
        Thread.sleep(500);     // Catch: InterruptedException -> L42
    L39:
        r9 = r9 + 1;
        goto L4
    L13:
        QueryEvidenceResponse r4 = QueryEvidenceResponse.parse(r2, r3);     // Catch: Throwable -> L21
        if (r1 == null) goto L16;
        r1.close();     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
    L16:
        return r4;
    L10:
        r2 = "";
    L32:
        e = move-exception;
        LogUtils.e(TAG, "PCC QueryEvidence attempt " + r9 + ": ConnectException: " + e.getMessage());
    L34:
        e = move-exception;
        LogUtils.e(TAG, "PCC QueryEvidence attempt " + r9 + ": SocketTimeoutException: " + e.getMessage());
    L30:
        e = move-exception;
        LogUtils.e(TAG, "PCC QueryEvidence attempt " + r9 + ": IOException: " + e.getMessage());
    L28:
        e = move-exception;
        LogUtils.e(TAG, "PCC QueryEvidence attempt " + r9 + ": unexpected exception: ", e);
        goto L36
    L40:
        return null;
    }

    public String testDecrypt(String r4, String r5, String r6, Map<String, String> r7) {
        String r3 = baseUrl() + PATH_TEST_DECRYPT;
        Request.Builder r8 = addEnvHeaders(new Request.Builder().url(r3).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "{\"cipherText\":\"" + r6 + "\"}")).addHeader("Content-Type", RequestParams.APPLICATION_JSON).addHeader(HEADER_REQUEST_ID, r4).addHeader(HEADER_TIMESTAMP, r5));
        if (r7 == null) goto L8;
        Iterator<Map.Entry<String, String>> r9 = r7.entrySet().iterator();
    L6:
        if (r9.hasNext() == false) goto L8;
        Map.Entry<String, String> r10 = r9.next();
        r8.addHeader(r10.getKey(), r10.getValue());
    L8:
        Request r11 = r8.build();
        String r12 = TAG;
        LogUtils.d(r12, "PCC TestDecrypt request: " + r3);
        LogUtils.d(r12, "PCC TestDecrypt cipherText length: " + r6.length());
        Response r13 = client.newCall(r11).execute();     // Catch: Exception -> L25 IOException -> L27 ConnectException -> L29 SocketTimeoutException -> L31
    L18:
        th = move-exception;
        if (r13 != null) goto L35;
    L24:
        throw th;     // Catch: Exception -> L25 IOException -> L27 ConnectException -> L29 SocketTimeoutException -> L31
    L35:
        r13.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L25 IOException -> L27 ConnectException -> L29 SocketTimeoutException -> L31
        goto L24
    L11:
        if (r13.body() == null) goto L13;
        String r14 = r13.body().string();     // Catch: Throwable -> L18
    L14:
        LogUtils.d(r12, "PCC TestDecrypt response HTTP " + r13.code());     // Catch: Throwable -> L18
        if (r13 == null) goto L17;
        r13.close();     // Catch: Exception -> L25 IOException -> L27 ConnectException -> L29 SocketTimeoutException -> L31
    L17:
        return r14;
    L13:
        r14 = "";
    L29:
        e = move-exception;
        LogUtils.e(TAG, "PCC TestDecrypt: ConnectException: " + e.getMessage());
        return null;
    L31:
        e = move-exception;
        LogUtils.e(TAG, "PCC TestDecrypt: SocketTimeoutException: " + e.getMessage());
        return null;
    L27:
        e = move-exception;
        LogUtils.e(TAG, "PCC TestDecrypt: IOException: " + e.getMessage());
        return null;
    L25:
        e = move-exception;
        LogUtils.e(TAG, "PCC TestDecrypt: unexpected exception: ", e);
        return null;
    }

    public String testDecrypt(String r2, String r3, String r4) {
        return testDecrypt(r2, r3, r4, null);
    }
}
