package com.ss.ttuploader.net;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.ttuploader.TTUploadLog;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class HTTPDNS extends BaseDNS {
    private static final String TAG = "HTTPDNS";
    private static String mGlobalGoogleDNSParseHost = "";
    private static String mGlobalOwnDNSParseHost = "";
    private static String mGoogleDNSServerPath = "/resolve?name=";
    private static String mTTDNSServerPath = "/q?host=";
    private int mHttpDNSType;
    private Object mSource;
    private long mSourceId;

    static {
    }

    public HTTPDNS(String r1, TTVNetClient r2, int r3, Handler r4) {
        super(r1, r2, r4);
        this.mHttpDNSType = 2;
        this.mHttpDNSType = r3;
    }

    private String _getURL() {
        StringBuilder r0 = new StringBuilder();
        int r1 = this.mHttpDNSType;
        if (r1 != 2) goto L5;
    L10:
        StringBuilder r2 = new StringBuilder();
        r2.append("https://");
        r2.append(mGlobalOwnDNSParseHost);
        String r3 = mTTDNSServerPath;
    L11:
        r2.append(r3);
        r0.append(r2.toString());
    L12:
        r0.append(this.mHostname);
        return r0.toString();
    L5:
        if (r1 == 1) goto L10;
        if (r1 != 3) goto L12;
        r2 = new StringBuilder();
        r2.append("https://");
        r2.append(mGlobalGoogleDNSParseHost);
        r3 = mGoogleDNSServerPath;
        goto L11
    }

    private void _handleResponse(JSONObject r12, Error r13) {
        TTUploadLog.d(TAG, String.format("****http dns id:%s", new Object[]{this.mId}));
        TTUploadDNSInfo r1 = new TTUploadDNSInfo(this.mHttpDNSType, this.mHostname, null, 0, this.mId);
        if (r13 == null) goto L5;
        r1.mErrorStr = r13.errStr;
    L15:
        notifyError(r1);
        return;
    L5:
        if (r12 != null) goto L7;
    L14:
        TTUploadLog.d(TAG, String.format("http dns json is empty type:%d", new Object[]{Integer.valueOf(this.mHttpDNSType)}));
        goto L15
    L7:
        if (r12.length() == 0) goto L14;
        TTUploadDNSInfo r14 = parserResult(r12);
        if (r14 == null) goto L15;
        IPCache.getInstance().put(this.mHostname, r14);
        notifySuccess(r14);
    }

    static /* synthetic */ void access$000(HTTPDNS r0, JSONObject r1, Error r2) {
        r0._handleResponse(r1, r2);
    }

    private TTUploadDNSInfo parserResult(JSONObject r16) {
        int r0 = this.mHttpDNSType;
        String r10 = "";
        int r11 = 60;
        if (r0 == 2) goto L7;
        if (r0 == 1) goto L7;
        long r12 = 0;
        String r1 = null;
    L32:
        if (this.mHttpDNSType != 3) goto L61;
        JSONArray r2 = r16.getJSONArray("Answer");     // Catch: Exception -> L56
        int r7 = 0;
    L35:
        if (r7 >= r2.length()) goto L54;
        JSONObject r8 = r2.getJSONObject(r7);     // Catch: Exception -> L56
        if (r8.has(WsConstants.KEY_CONNECTION_TYPE) == false) goto L53;
        if (r8.getInt(WsConstants.KEY_CONNECTION_TYPE) != 1) goto L53;
        if (r8.has("TTL") == false) goto L44;
        r11 = r8.optInt("TTL");     // Catch: Exception -> L56
    L44:
        if (r8.has("data") == false) goto L47;
        r1 = r8.optString("data");     // Catch: Exception -> L56
    L47:
        if (TextUtils.isEmpty(r1) == true) goto L53;
        if (TextUtils.isEmpty(r10) == false) goto L52;
        StringBuilder r9 = new StringBuilder();     // Catch: Exception -> L56
        r9.append(r10);     // Catch: Exception -> L56
        r9.append(r1);     // Catch: Exception -> L56
    L51:
        r10 = r9.toString();     // Catch: Exception -> L56
        goto L53
    L52:
        r9 = new StringBuilder();     // Catch: Exception -> L56
        r9.append(r10);     // Catch: Exception -> L56
        r9.append(",");     // Catch: Exception -> L56
        r9.append(r1);     // Catch: Exception -> L56
    L53:
        r7 = r7 + 1;     // Catch: Exception -> L56
        goto L35
    L54:
        r12 = System.currentTimeMillis() + ((long) (r11 * 1000));
    L56:
        e = move-exception;
        e.printStackTrace();
        return null;
    L61:
        return new TTUploadDNSInfo(this.mHttpDNSType, this.mHostname, r10, r12, this.mId);
    L7:
        JSONArray r13 = r16.optJSONArray("ips");
        if (r13 != null) goto L10;
    L62:
        TTUploadLog.d(TAG, String.format("no ips in json, type:%d", new Object[]{Integer.valueOf(this.mHttpDNSType)}));
        return null;
    L10:
        if (r13.length() == 0) goto L62;
        if (r16.has("ttl") == false) goto L15;
        r11 = r16.optInt("ttl");
    L15:
        long r14 = ((long) (r11 * 1000)) + System.currentTimeMillis();
        r1 = null;
        int r15 = 0;
    L17:
        if (r15 >= r13.length()) goto L30;
        r1 = r13.getString(r15);     // Catch: Exception -> L20
    L23:
        if (TextUtils.isEmpty(r1) == true) goto L29;
        if (TextUtils.isEmpty(r10) == false) goto L27;
        StringBuilder r17 = new StringBuilder();
        r17.append(r10);
    L28:
        r17.append(r1);
        r10 = r17.toString();
        goto L29
    L27:
        r17 = new StringBuilder();
        r17.append(r10);
        r17.append(",");
    L29:
        r15 = r15 + 1;
    L20:
        e = move-exception;
        e.printStackTrace();
        r1 = null;
        goto L23
    L30:
        r12 = r14;
        goto L32
    }

    public static void setDNSServerHost(String r2, String r3) {
        monitor-enter(HTTPDNS.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L8;
        mGlobalOwnDNSParseHost = r2;     // Catch: Throwable -> L12
    L8:
        if (TextUtils.isEmpty(r3) == true) goto L10;
        mGlobalGoogleDNSParseHost = r3;     // Catch: Throwable -> L12
    L10:
        monitor-exit(HTTPDNS.class);     // Catch: Throwable -> L12
    }

    @Override // com.ss.ttuploader.net.BaseDNS
    public void cancel() {
        if (this.mCancelled == false) goto L5;
        return;
    L5:
        this.mCancelled = true;
        this.mNetClient.cancel();
    }

    @Override // com.ss.ttuploader.net.BaseDNS
    public void start() {
        String r1 = _getURL();
        Method[] r0 = this.mNetClient.getClass().getDeclaredMethods();
        int r2 = r0.length;
        boolean r3 = false;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L10;
        Method r5 = r0[r4];
        if (r5.getName().equals("startTask") == false) goto L9;
        if (r5.getParameterTypes().length != 5) goto L9;
        r3 = true;
    L9:
        r4 = r4 + 1;
    L10:
        TTVNetClient r6 = this.mNetClient;
        if (r3 == false) goto L13;
        r6.startTask(r1, null, null, 0, new AnonymousClass1(this));
        return;
    L13:
        r6.startTask(r1, null, new AnonymousClass2(this));
    }
}
