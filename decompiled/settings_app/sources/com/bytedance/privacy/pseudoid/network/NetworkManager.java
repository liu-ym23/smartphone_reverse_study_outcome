package com.bytedance.privacy.pseudoid.network;

import com.bytedance.privacy.network.NetworkConfig;
import com.bytedance.privacy.pseudoid.PseudoManager;
import com.bytedance.privacy.pseudoid.account.AccountApi;
import com.bytedance.privacy.utils.LogUtils;
import com.loopj.android.http.RequestParams;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkManager {
    private static final String JSON_TAG_CODE = "code";
    private static final String JSON_TAG_DATA = "data";
    private static final String JSON_TAG_MSG = "msg";
    private static final String JSON_TAG_RP_DID = "rpdid";
    private static final String JSON_TAG_RP_UID = "rpuid";
    private static final int MAX_RETRY = 3;
    private static String PSEUDO_ID_BOE_URL = "https://ocean-secret-boe.bytedance.net/api/identity/pseudonymize";
    private static String PSEUDO_ID_URL = "https://ocean-secret.oceancloudapi.com/api/identity/pseudonymize";
    public static final String REQUEST_TYPE_POST = "POST";
    private static final String TAG = "NetworkManager";
    private static final OkHttpClient client = null;
    private static volatile NetworkManager networkManager;

    public NetworkManager() {
    }

    static {
        client = new OkHttpClient();
    }

    public static NetworkManager getInstance() {
        if (networkManager != null) goto L15;
        monitor-enter(PseudoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (networkManager != null) goto L9;
        networkManager = new NetworkManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PseudoManager.class);     // Catch: Throwable -> L11
    L15:
        return networkManager;
    }

    public static String getPseudoIDUrl() {
        if (NetworkConfig.getInstance().isBoeEnv() == false) goto L7;
        return PSEUDO_ID_BOE_URL;
    L7:
        return PSEUDO_ID_URL;
    }

    private int getResponseCode(String r3) {
        return new JSONObject(r3).getInt("code");
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getResponseCode exception: " + e.getMessage());
        return 400;
    }

    private String getResponseMsg(String r3) {
        return new JSONObject(r3).getString("msg");
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getResponseMsg exception: " + e.getMessage());
        return "";
    }

    private PseudoID getPseudoID(String r3) {
        JSONObject r0 = new JSONObject(new JSONObject(r3).getString("data"));     // Catch: Exception -> L5
        return new PseudoID(r0.optString(JSON_TAG_RP_DID, ""), r0.optString(JSON_TAG_RP_UID, ""));
    L5:
        e = move-exception;
        LogUtils.e(TAG, "getPseudoID exception: " + e.getMessage());
        return null;
    }

    private NetworkResponse buildNetworkResponse(String r6) {
        int r0 = getResponseCode(r6);
        String r1 = getResponseMsg(r6);
        PseudoID r3 = null;
        if (r0 < 200) goto L11;
        if (r0 >= 300) goto L11;
        r3 = getPseudoID(r6);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        LogUtils.e(TAG, "buildNetworkResponse exception: " + e.getMessage());
    L11:
        return new NetworkResponse(r0, r1, r3);
    }

    private Request buildOkHttpRequest(NetworkRequest r5) {
        RequestBody r0 = RequestBody.create(MediaType.parse(RequestParams.APPLICATION_JSON), "{}");
        Headers r1 = Headers.of(AccountApi.INSTANCE.getXttTokenMap());
        return new Request.Builder().url(r5.getRequestUrl()).method(r5.getRequestType(), r0).headers(r1).addHeader("Content-Type", RequestParams.APPLICATION_JSON).addHeader("x-att-certchain", r5.getCertChain()).build();
    }

    public NetworkResponse executeRequest(NetworkRequest r11) {
        LogUtils.d(TAG, "executeRequest enter");
        Request r12 = buildOkHttpRequest(r11);
        NetworkResponse r1 = new NetworkResponse(400, "", null);
        int r2 = 1;
    L4:
        if (r2 > 3) goto L48;
        Response r6 = client.newCall(r12).execute();     // Catch: Exception -> L36 IOException -> L38 ConnectException -> L40 SocketTimeoutException -> L42
    L29:
        th = move-exception;
        if (r6 != null) goto L54;
    L35:
        throw th;     // Catch: Exception -> L36 IOException -> L38 ConnectException -> L40 SocketTimeoutException -> L42
    L54:
        r6.close();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L36 IOException -> L38 ConnectException -> L40 SocketTimeoutException -> L42
        goto L35
    L7:
        if (r6.body() == null) goto L9;
        String r7 = r6.body().string();     // Catch: Throwable -> L29
    L11:
        if (r6.isSuccessful() == true) goto L12;
        LogUtils.e(TAG, "PseudoID Attempt " + r2 + ": Response failed, code = " + r6.code());     // Catch: Throwable -> L29
        NetworkResponse r8 = new NetworkResponse(r6.code(), r6.message(), null);     // Catch: Throwable -> L29
        if (r6 != null) goto L56;
    L28:
        r1 = r8;
    L44:
        if (r2 >= 3) goto L47;
        Thread.sleep(500);     // Catch: InterruptedException -> L49
    L47:
        r2 = r2 + 1;
        goto L4
    L56:
        r6.close();     // Catch: Exception -> L20 IOException -> L22 ConnectException -> L24 SocketTimeoutException -> L26
    L24:
        e = e;
        r1 = r8;
    L41:
        LogUtils.e(TAG, "Challenge Attempt " + r2 + ": ConnectException (connect timeout): " + e.getMessage());
    L26:
        e = e;
        r1 = r8;
    L43:
        LogUtils.e(TAG, "Challenge Attempt " + r2 + ": SocketTimeoutException (read/write timeout): " + e.getMessage());
    L22:
        e = e;
        r1 = r8;
    L39:
        LogUtils.e(TAG, "Challenge Attempt " + r2 + ": IOException: " + e.getMessage());
    L20:
        e = e;
        r1 = r8;
    L37:
        LogUtils.e(TAG, "Challenge Attempt " + r2 + ": Unexpected exception: " + e.getMessage());
        goto L44
    L12:
        LogUtils.d(TAG, "PseudoID Response received successfully");     // Catch: Throwable -> L29
        r1 = buildNetworkResponse(r7);     // Catch: Throwable -> L29
        if (r6 == null) goto L48;
        r6.close();     // Catch: Exception -> L36 IOException -> L38 ConnectException -> L40 SocketTimeoutException -> L42
        goto L48
    L9:
        r7 = "";
    L40:
        e = e;
    L42:
        e = e;
    L38:
        e = e;
    L36:
        e = e;
    L48:
        return r1;
    }
}
