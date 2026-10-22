package com.bytedance.privacy.pseudoid.network;

import com.bytedance.privacy.network.NetworkConfig;
import com.bytedance.privacy.pseudoid.PseudoManager;
import com.bytedance.privacy.pseudoid.account.AccountApi;
import com.bytedance.privacy.utils.LogUtils;
import com.obric.safecheck.dataSync.miitAntiFraud.GxbAttestationHeaders;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    private Request buildOkHttpRequest(NetworkRequest r8) {
        RequestBody r0 = RequestBody.create(MediaType.parse("application/json"), "{}");
        Map<String, String> r1 = AccountApi.INSTANCE.getXttTokenMap();
        Iterator<Map.Entry<String, String>> r2 = r1.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        Map.Entry<String, String> r3 = r2.next();
        LogUtils.d(TAG, "xttTokenMap entry key:" + r3.getKey() + " value:" + r3.getValue());
        goto L4
    L7:
        return new Request.Builder().url(r8.getRequestUrl()).method(r8.getRequestType(), r0).headers(Headers.of(r1)).addHeader("Content-Type", "application/json").addHeader(GxbAttestationHeaders.HEADER_CERT_CHAIN, r8.getCertChain()).build();
    }

    public NetworkResponse executeRequest(NetworkRequest r13) {
        String r1 = TAG;
        LogUtils.d(r1, "executeRequest enter");
        Request r14 = buildOkHttpRequest(r13);
        LogUtils.d(r1, "PseudoID Request:" + r14.toString());
        LogUtils.d(r1, "PseudoID Request body:" + r14.body());
        NetworkResponse r2 = new NetworkResponse(400, "", null);
        int r3 = 1;
    L4:
        if (r3 > 3) goto L49;
        Response r6 = client.newCall(r14).execute();     // Catch: Exception -> L37 IOException -> L39 ConnectException -> L41 SocketTimeoutException -> L43
    L30:
        th = move-exception;
        if (r6 != null) goto L53;
    L36:
        throw th;     // Catch: Exception -> L37 IOException -> L39 ConnectException -> L41 SocketTimeoutException -> L43
    L53:
        r6.close();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L37 IOException -> L39 ConnectException -> L41 SocketTimeoutException -> L43
        goto L36
    L7:
        if (r6.body() == null) goto L9;
        String r7 = r6.body().string();     // Catch: Throwable -> L30
    L12:
        if (r6.isSuccessful() == true) goto L13;
        String r8 = TAG;     // Catch: Throwable -> L30
        LogUtils.e(r8, "PseudoID Attempt " + r3 + ": Response failed, code = " + r6.code());     // Catch: Throwable -> L30
        LogUtils.e(r8, "PseudoID Response body:" + r7);     // Catch: Throwable -> L30
        NetworkResponse r9 = new NetworkResponse(r6.code(), r6.message(), null);     // Catch: Throwable -> L30
        if (r6 != null) goto L58;
    L29:
        r2 = r9;
    L45:
        if (r3 >= 3) goto L48;
        Thread.sleep(500);     // Catch: InterruptedException -> L50
    L48:
        r3 = r3 + 1;
        goto L4
    L58:
        r6.close();     // Catch: Exception -> L21 IOException -> L23 ConnectException -> L25 SocketTimeoutException -> L27
    L25:
        e = e;
        r2 = r9;
    L42:
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": ConnectException (connect timeout): " + e.getMessage());
    L27:
        e = e;
        r2 = r9;
    L44:
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": SocketTimeoutException (read/write timeout): " + e.getMessage());
    L23:
        e = e;
        r2 = r9;
    L40:
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": IOException: " + e.getMessage());
    L21:
        e = e;
        r2 = r9;
    L38:
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": Unexpected exception: " + e.getMessage());
        goto L45
    L13:
        String r10 = TAG;     // Catch: Throwable -> L30
        LogUtils.d(r10, "PseudoID Response received successfully");     // Catch: Throwable -> L30
        LogUtils.d(r10, "PseudoID Response body:" + r7);     // Catch: Throwable -> L30
        r2 = buildNetworkResponse(r7);     // Catch: Throwable -> L30
        if (r6 == null) goto L49;
        r6.close();     // Catch: Exception -> L37 IOException -> L39 ConnectException -> L41 SocketTimeoutException -> L43
        goto L49
    L9:
        r7 = "";
    L41:
        e = e;
    L43:
        e = e;
    L39:
        e = e;
    L37:
        e = e;
    L49:
        return r2;
    }
}
