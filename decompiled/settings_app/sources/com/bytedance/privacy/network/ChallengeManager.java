package com.bytedance.privacy.network;

import com.bytedance.privacy.utils.LogUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
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
        int r3 = 1;
        String r4 = "";
    L4:
        if (r3 > 3) goto L39;
        Response r6 = client.newCall(r1).execute();     // Catch: Exception -> L27 IOException -> L29 ConnectException -> L31 SocketTimeoutException -> L33
    L20:
        th = move-exception;
        if (r6 != null) goto L41;
    L26:
        throw th;     // Catch: Exception -> L27 IOException -> L29 ConnectException -> L31 SocketTimeoutException -> L33
    L41:
        r6.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L27 IOException -> L29 ConnectException -> L31 SocketTimeoutException -> L33
        goto L26
    L7:
        if (r6.body() == null) goto L9;
        String r7 = r6.body().string();     // Catch: Throwable -> L20
    L11:
        if (r6.isSuccessful() == true) goto L12;
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": Response failed, code = " + r6.code());     // Catch: Throwable -> L20
        if (r6 == null) goto L35;
        r6.close();     // Catch: Exception -> L27 IOException -> L29 ConnectException -> L31 SocketTimeoutException -> L33
    L35:
        if (r3 >= 3) goto L38;
        Thread.sleep(500);     // Catch: InterruptedException -> L40
    L38:
        r3 = r3 + 1;
        goto L4
    L12:
        LogUtils.d(TAG, "Challenge Response received successfully");     // Catch: Throwable -> L20
        r4 = parseChallenge(r7);     // Catch: Throwable -> L20
        if (r6 == null) goto L39;
        r6.close();     // Catch: Exception -> L27 IOException -> L29 ConnectException -> L31 SocketTimeoutException -> L33
        goto L39
    L9:
        r7 = "";
    L31:
        e = move-exception;
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": ConnectException (connect timeout): " + e.getMessage());
    L33:
        e = move-exception;
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": SocketTimeoutException (read/write timeout): " + e.getMessage());
    L29:
        e = move-exception;
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": IOException: " + e.getMessage());
    L27:
        e = move-exception;
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": Unexpected exception: ", e);
    L39:
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
