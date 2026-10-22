package com.bytedance.privacy.pcc.network;

import com.bytedance.privacy.network.NetworkConfig;
import com.bytedance.privacy.pcc.network.model.ChallengeResponse;
import com.bytedance.privacy.pcc.network.model.CreateChannelResponse;
import com.bytedance.privacy.pcc.network.model.UploadChannelRetResponse;
import com.bytedance.privacy.utils.LogUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class PccNetworkManager {
    private static final String HEADER_REQUEST_ID = "x-requestId";
    private static final String HEADER_RESPONSE_ID = "x-responseId";
    private static final String HEADER_TIMESTAMP = "x-timestamp";
    private static final String HEADER_TT_ENV = "x-tt-env";
    private static final String HEADER_USE_PPE = "x-use-ppe";
    private static final int MAX_RETRY = 3;
    private static final String PATH_CREATE_CHANNEL = "/opcc/v1/auth/create/channel";
    private static final String PATH_GET_CHALLENGE = "/opcc/v1/auth/get/challenge";
    private static final String PATH_TEST_DECRYPT = "/test/v1/decrypt";
    private static final String PATH_UPLOAD_CHANNEL_RET = "/opcc/v1/auth/upload/channelRet";
    private static final String PCC_BASE_URL_BOE = "https://opcc-gateway-boe.bytedance.net";
    private static final String PCC_BASE_URL_PPE = "https://opcc-gateway.obriccloud.com";
    private static final String TAG = "PccNetworkManager";
    private static final OkHttpClient client = null;
    private static volatile PccNetworkManager instance;

    private static Request.Builder addEnvHeaders(Request.Builder r0) {
        return r0;
    }

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

    public String requestChallenge(String r8) {
        String r0 = baseUrl() + PATH_GET_CHALLENGE;
        Request r9 = addEnvHeaders(new Request.Builder().url(r0).get().addHeader(HEADER_REQUEST_ID, r8).addHeader(HEADER_TIMESTAMP, String.valueOf(System.currentTimeMillis()))).build();
        LogUtils.d(TAG, "PCC GetChallenge request: " + r0);
        int r1 = 1;
    L3:
        String r2 = "";
        if (r1 > 3) goto L42;
        Response r3 = client.newCall(r9).execute();     // Catch: Exception -> L30 IOException -> L32 ConnectException -> L34 SocketTimeoutException -> L36
        if (r3.body() == null) goto L10;
        r2 = r3.body().string();     // Catch: Throwable -> L23
    L10:
        if (r3.isSuccessful() == false) goto L19;
        String r4 = TAG;     // Catch: Throwable -> L23
        LogUtils.d(r4, "PCC GetChallenge response: " + r2);     // Catch: Throwable -> L23
        String r5 = ChallengeResponse.parse(r2).getNonce();     // Catch: Throwable -> L23
        if (r5 != null) goto L14;
    L18:
        LogUtils.e(r4, "PCC GetChallenge attempt " + r1 + ": nonce empty in response");     // Catch: Throwable -> L23
    L20:
        if (r3 == null) goto L38;
        r3.close();     // Catch: Exception -> L30 IOException -> L32 ConnectException -> L34 SocketTimeoutException -> L36
    L38:
        if (r1 >= 3) goto L41;
        Thread.sleep(500);     // Catch: InterruptedException -> L43
    L41:
        r1 = r1 + 1;
        goto L3
    L14:
        if (r5.isEmpty() == true) goto L18;
        if (r3 == null) goto L17;
        r3.close();     // Catch: Exception -> L30 IOException -> L32 ConnectException -> L34 SocketTimeoutException -> L36
    L17:
        return r5;
    L19:
        LogUtils.e(TAG, "PCC GetChallenge attempt " + r1 + ": HTTP " + r3.code() + " body=" + r2);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (r3 != null) goto L44;
    L29:
        throw th;     // Catch: Exception -> L30 IOException -> L32 ConnectException -> L34 SocketTimeoutException -> L36
    L44:
        r3.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L30 IOException -> L32 ConnectException -> L34 SocketTimeoutException -> L36
    L34:
        e = move-exception;
        LogUtils.e(TAG, "PCC GetChallenge attempt " + r1 + ": ConnectException: " + e.getMessage());
    L36:
        e = move-exception;
        LogUtils.e(TAG, "PCC GetChallenge attempt " + r1 + ": SocketTimeoutException: " + e.getMessage());
    L32:
        e = move-exception;
        LogUtils.e(TAG, "PCC GetChallenge attempt " + r1 + ": IOException: " + e.getMessage());
    L30:
        e = move-exception;
        LogUtils.e(TAG, "PCC GetChallenge attempt " + r1 + ": unexpected exception: ", e);
        goto L38
    L42:
        return "";
    }

    public CreateChannelResponse createChannel(String r7, String r8, String r9) {
        String r0 = baseUrl() + PATH_CREATE_CHANNEL;
        Request r10 = addEnvHeaders(new Request.Builder().url(r0).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r9)).addHeader("Content-Type", "application/json").addHeader(HEADER_REQUEST_ID, r7).addHeader(HEADER_TIMESTAMP, r8)).build();
        String r11 = TAG;
        LogUtils.d(r11, "PCC CreateChannel request: " + r0);
        LogUtils.d(r11, "PCC CreateChannel request body: " + r9);
        int r12 = 1;
    L4:
        if (r12 > 3) goto L40;
        Response r1 = client.newCall(r10).execute();     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
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
        LogUtils.e(TAG, "PCC CreateChannel attempt " + r12 + ": HTTP " + r1.code() + " body=" + r2);     // Catch: Throwable -> L21
        if (r1 == null) goto L36;
        r1.close();     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
    L36:
        if (r12 >= 3) goto L39;
        Thread.sleep(500);     // Catch: InterruptedException -> L42
    L39:
        r12 = r12 + 1;
        goto L4
    L13:
        LogUtils.d(TAG, "PCC CreateChannel response: " + r2);     // Catch: Throwable -> L21
        CreateChannelResponse r4 = CreateChannelResponse.parse(r2, r3);     // Catch: Throwable -> L21
        if (r1 == null) goto L16;
        r1.close();     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
    L16:
        return r4;
    L10:
        r2 = "";
    L32:
        e = move-exception;
        LogUtils.e(TAG, "PCC CreateChannel attempt " + r12 + ": ConnectException: " + e.getMessage());
    L34:
        e = move-exception;
        LogUtils.e(TAG, "PCC CreateChannel attempt " + r12 + ": SocketTimeoutException: " + e.getMessage());
    L30:
        e = move-exception;
        LogUtils.e(TAG, "PCC CreateChannel attempt " + r12 + ": IOException: " + e.getMessage());
    L28:
        e = move-exception;
        LogUtils.e(TAG, "PCC CreateChannel attempt " + r12 + ": unexpected exception: ", e);
        goto L36
    L40:
        return null;
    }

    public String uploadChannelRet(String r6, String r7, String r8) {
        String r0 = baseUrl() + PATH_UPLOAD_CHANNEL_RET;
        Request r9 = addEnvHeaders(new Request.Builder().url(r0).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r8)).addHeader("Content-Type", "application/json").addHeader(HEADER_REQUEST_ID, r6).addHeader(HEADER_TIMESTAMP, r7)).build();
        String r10 = TAG;
        LogUtils.d(r10, "PCC UploadChannelRet request: " + r0);
        LogUtils.d(r10, "PCC UploadChannelRet body: " + r8);
        int r11 = 1;
    L3:
        String r12 = "";
        if (r11 > 3) goto L38;
        Response r1 = client.newCall(r9).execute();     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
    L19:
        th = move-exception;
        if (r1 != null) goto L44;
    L25:
        throw th;     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
    L44:
        r1.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
        goto L25
    L7:
        if (r1.body() == null) goto L10;
        r12 = r1.body().string();     // Catch: Throwable -> L19
    L10:
        if (r1.isSuccessful() == true) goto L11;
        LogUtils.e(TAG, "PCC UploadChannelRet attempt " + r11 + ": HTTP " + r1.code() + " body=" + r12);     // Catch: Throwable -> L19
        if (r1 == null) goto L34;
        r1.close();     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
    L34:
        if (r11 >= 3) goto L37;
        Thread.sleep(500);     // Catch: InterruptedException -> L39
    L37:
        r11 = r11 + 1;
        goto L3
    L11:
        LogUtils.d(TAG, "PCC UploadChannelRet response: " + r12);     // Catch: Throwable -> L19
        String r13 = UploadChannelRetResponse.parse(r12).getLogId();     // Catch: Throwable -> L19
        if (r1 == null) goto L14;
        r1.close();     // Catch: Exception -> L26 IOException -> L28 ConnectException -> L30 SocketTimeoutException -> L32
    L14:
        return r13;
    L30:
        e = move-exception;
        LogUtils.e(TAG, "PCC UploadChannelRet attempt " + r11 + ": ConnectException: " + e.getMessage());
    L32:
        e = move-exception;
        LogUtils.e(TAG, "PCC UploadChannelRet attempt " + r11 + ": SocketTimeoutException: " + e.getMessage());
    L28:
        e = move-exception;
        LogUtils.e(TAG, "PCC UploadChannelRet attempt " + r11 + ": IOException: " + e.getMessage());
    L26:
        e = move-exception;
        LogUtils.e(TAG, "PCC UploadChannelRet attempt " + r11 + ": unexpected exception: ", e);
        goto L34
    L38:
        return "";
    }

    public String testDecrypt(String r5, String r6, String r7) {
        String r0 = baseUrl() + PATH_TEST_DECRYPT;
        Request r8 = addEnvHeaders(new Request.Builder().url(r0).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "{\"cipherText\":\"" + r7 + "\"}")).addHeader("Content-Type", "application/json").addHeader(HEADER_REQUEST_ID, r5).addHeader(HEADER_TIMESTAMP, r6)).build();
        String r9 = TAG;
        LogUtils.d(r9, "PCC TestDecrypt request: " + r0);
        LogUtils.d(r9, "PCC TestDecrypt cipherText length: " + r7.length());
        Response r10 = client.newCall(r8).execute();     // Catch: Exception -> L19 IOException -> L21 ConnectException -> L23 SocketTimeoutException -> L25
    L12:
        th = move-exception;
        if (r10 != null) goto L29;
    L18:
        throw th;     // Catch: Exception -> L19 IOException -> L21 ConnectException -> L23 SocketTimeoutException -> L25
    L29:
        r10.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L19 IOException -> L21 ConnectException -> L23 SocketTimeoutException -> L25
        goto L18
    L5:
        if (r10.body() == null) goto L7;
        String r11 = r10.body().string();     // Catch: Throwable -> L12
    L8:
        LogUtils.d(r9, "PCC TestDecrypt response HTTP " + r10.code() + ": " + r11);     // Catch: Throwable -> L12
        if (r10 == null) goto L11;
        r10.close();     // Catch: Exception -> L19 IOException -> L21 ConnectException -> L23 SocketTimeoutException -> L25
    L11:
        return r11;
    L7:
        r11 = "";
    L23:
        e = move-exception;
        LogUtils.e(TAG, "PCC TestDecrypt: ConnectException: " + e.getMessage());
        return null;
    L25:
        e = move-exception;
        LogUtils.e(TAG, "PCC TestDecrypt: SocketTimeoutException: " + e.getMessage());
        return null;
    L21:
        e = move-exception;
        LogUtils.e(TAG, "PCC TestDecrypt: IOException: " + e.getMessage());
        return null;
    L19:
        e = move-exception;
        LogUtils.e(TAG, "PCC TestDecrypt: unexpected exception: ", e);
        return null;
    }
}
