package com.bytedance.privacy.network;

import com.bytedance.privacy.utils.LogUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ChallengeManager {
    private static final String GET_CHALLENGE_URL = "https://ocean-secret.oceancloudapi.com/api/auth/challenge";
    private static final String GET_CHALLENGE_URL_BOE = "https://ocean-secret-boe.bytedance.net/api/auth/challenge";
    private static final String JSON_TAG_CODE = "code";
    private static final String JSON_TAG_DATA = "data";
    private static final String JSON_TAG_NONCE = "nonce";
    private static final int MAX_RETRY = 3;
    private static final String TAG = "ChallengeManager";
    private static final OkHttpClient client = null;

    public ChallengeManager() {
    }

    static {
        client = new OkHttpClient();
    }

    public static String requestChallenge() {
        return getChallengeFromServer();
    }

    private static String getRequestUrl() {
        if (NetworkConfig.getInstance().isBoeEnv() == false) goto L6;
        return GET_CHALLENGE_URL_BOE;
    L6:
        return GET_CHALLENGE_URL;
    }

    private static String getChallengeFromServer() {
        Request r1 = new Request.Builder().url(getRequestUrl()).get().build();
        String r2 = TAG;
        LogUtils.d(r2, "Challenge Request:" + r1.toString());
        LogUtils.d(r2, "Challenge Request body:" + r1.body());
        int r3 = 1;
        String r4 = "";
    L4:
        if (r3 > 3) goto L40;
        Response r6 = client.newCall(r1).execute();     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
    L21:
        th = move-exception;
        if (r6 != null) goto L44;
    L27:
        throw th;     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
    L44:
        r6.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
        goto L27
    L7:
        if (r6.body() == null) goto L9;
        String r7 = r6.body().string();     // Catch: Throwable -> L21
    L12:
        if (r6.isSuccessful() == true) goto L13;
        String r8 = TAG;     // Catch: Throwable -> L21
        LogUtils.e(r8, "Challenge Attempt " + r3 + ": Response failed, code = " + r6.code());     // Catch: Throwable -> L21
        LogUtils.e(r8, "Challenge Response body:" + r7);     // Catch: Throwable -> L21
        if (r6 == null) goto L36;
        r6.close();     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
    L36:
        if (r3 >= 3) goto L39;
        Thread.sleep(500);     // Catch: InterruptedException -> L41
    L39:
        r3 = r3 + 1;
        goto L4
    L13:
        String r9 = TAG;     // Catch: Throwable -> L21
        LogUtils.d(r9, "Challenge Response received successfully");     // Catch: Throwable -> L21
        LogUtils.d(r9, "Challenge Response body:" + r7);     // Catch: Throwable -> L21
        r4 = parseChallenge(r7);     // Catch: Throwable -> L21
        if (r6 == null) goto L40;
        r6.close();     // Catch: Exception -> L28 IOException -> L30 ConnectException -> L32 SocketTimeoutException -> L34
        goto L40
    L9:
        r7 = "";
    L32:
        e = move-exception;
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": ConnectException (connect timeout): " + e.getMessage());
    L34:
        e = move-exception;
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": SocketTimeoutException (read/write timeout): " + e.getMessage());
    L30:
        e = move-exception;
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": IOException: " + e.getMessage());
    L28:
        e = move-exception;
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": Unexpected exception: ", e);
        e.printStackTrace();
    L40:
        return r4;
    }

    private static int getResponseCode(String r3) {
        return new JSONObject(r3).getInt("code");
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getResponseCode exception: " + e.getMessage());
        return 400;
    }

    private static String getChallenge(String r3) {
        return new JSONObject(new JSONObject(r3).getString("data")).getString(JSON_TAG_NONCE);
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getChallenge exception: " + e.getMessage());
        return "";
    }

    private static String parseChallenge(String r4) {
        int r0 = getResponseCode(r4);
        if (r0 >= 200) goto L5;
        return "";
    L5:
        if (r0 >= 300) goto L14;
        return getChallenge(r4);
    L8:
        e = move-exception;
        LogUtils.e(TAG, "parseChallenge exception: " + e.getMessage());
        return "";
    L14:
        return "";
    }
}
