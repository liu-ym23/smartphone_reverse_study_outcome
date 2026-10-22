package com.bytedanceos.cloud;

import android.app.BackgroundServiceStartNotAllowedException;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedanceos.security.Utils;
import com.obric.olog.OLog;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SecurityPackageWhiteListService extends IntentService {
    public static final String ACTION_SYNC = "sync";
    public static final long ONE_DAY_MILLIS = 86400000;
    private static final String TAG = "SecurityPackageWhiteListService";
    private volatile boolean mSyncing;

    private static class VersionInfo {
        public int mCode;
        public String mMd5;
        public String mUpdateUrl;

        public VersionInfo() {
        }

        public VersionInfo(String md5, int code, String updateUrl) {
            this.mMd5 = md5;
            this.mCode = code;
            this.mUpdateUrl = updateUrl;
        }

        public static VersionInfo parse(String versionInfo) {
            if (TextUtils.isEmpty(versionInfo) == false) goto L12;
            return null;
        L12:
            JSONObject r0 = new JSONObject(versionInfo);     // Catch: JSONException -> L9
            if (r0 == JSONObject.NULL) goto L11;
            VersionInfo r2 = new VersionInfo();     // Catch: JSONException -> L9
            r2.mMd5 = r0.getString("md5");     // Catch: JSONException -> L9
            r2.mCode = r0.getInt("version");     // Catch: JSONException -> L9
            r2.mUpdateUrl = r0.getString("uri");     // Catch: JSONException -> L9
            return r2;
        L11:
            return null;
        L9:
            e = move-exception;
            OLog.w(SecurityPackageWhiteListService.TAG, "parse version data exception :" + e.getMessage() + ",versionInfo=" + versionInfo, e);
            goto L11
        }
    }

    public SecurityPackageWhiteListService() {
        super(TAG);
        this.mSyncing = false;
        setIntentRedelivery(true);
    }

    public static void startSync(Context context) {
        Intent r0 = new Intent(context, SecurityPackageWhiteListService.class);     // Catch: BackgroundServiceStartNotAllowedException -> L4
        r0.putExtra("action", ACTION_SYNC);     // Catch: BackgroundServiceStartNotAllowedException -> L4
        context.startService(r0);     // Catch: BackgroundServiceStartNotAllowedException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        if (this.mSyncing == false) goto L5;
        return;
    L5:
        this.mSyncing = true;
        String r6 = intent.getStringExtra("action");
        SecurityPackageWhiteListDataCache.getInstance().setCacheData(SecurityPackageWhiteListData.getDataFromFile(this));
        if (ACTION_SYNC.equals(r6) == true) goto L8;
    L17:
        stopSelf();
        return;
    L8:
        if (Utils.isNetworkAvailable(this) == true) goto L11;
        OLog.d(TAG, "network isn't available , can't sync config data");
        return;
    L11:
        long r1 = PreferenceMgr.getInstance(this).getLong(PreferenceMgr.CLOUD_DATA_SYNC_SUCCES_TIME, -1);
        if (r1 < 0) goto L17;
        if ((System.currentTimeMillis() - r1) > 86400000) goto L17;
        OLog.d(TAG, "the last synchronization time is too short");
        goto L17
    }

    private void update(String newdata) {
        SecurityPackageWhiteListFile.writeToFile(this, newdata);
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x008e: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:22:0x008e */
    private static String executeHttpGet(String r7) {
        HttpURLConnection r3 = null;
        String r4 = null;
        r4 = null;
        r4 = null;
        OLog.i(TAG, "http get start url");     // Catch: Throwable -> L13 Exception -> L15
        HttpURLConnection r5 = (HttpURLConnection) new URL(r7).openConnection();     // Catch: Throwable -> L13 Exception -> L15
    L26:
        r5.setConnectTimeout(5000);     // Catch: Exception -> L11 Throwable -> L21
        r5.setReadTimeout(5000);     // Catch: Exception -> L11 Throwable -> L21
        r5.setUseCaches(false);     // Catch: Exception -> L11 Throwable -> L21
        r5.setRequestMethod(HttpMethodContrants.GET);     // Catch: Exception -> L11 Throwable -> L21
        r5.setRequestProperty("Content-Type", "application/text");     // Catch: Exception -> L11 Throwable -> L21
        r5.addRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);     // Catch: Exception -> L11 Throwable -> L21
        r5.connect();     // Catch: Exception -> L11 Throwable -> L21
        if (r5.getResponseCode() != 200) goto L8;
        r4 = inputStreamToString(r5.getInputStream());     // Catch: Exception -> L11 Throwable -> L21
    L9:
        if (r5 == null) goto L20;
    L10:
        r5.disconnect();
    L20:
        return r4;
    L8:
        OLog.e(TAG, "response error code :" + r5.getResponseCode());     // Catch: Exception -> L11 Throwable -> L21
    L11:
        e = e;
    L17:
        OLog.e(TAG, "open url exception ,url=" + r7 + ",exceptionMessage=" + e.getMessage(), e);     // Catch: Throwable -> L21
        if (r5 == null) goto L20;
    L21:
        th = th;
        r3 = r4;
    L23:
        if (r3 == null) goto L25;
        r3.disconnect();
    L25:
        throw th;
    L15:
        e = e;
        r5 = null;
    L13:
        th = th;
        goto L23
    }

    private static String inputStreamToString(InputStream resource) {
        if (resource != null) goto L6;
        return null;
    L6:
        char[] r2 = new char[1024];
        StringBuffer r3 = new StringBuffer();
        InputStreamReader r4 = new InputStreamReader(resource, "UTF-8");     // Catch: Throwable -> L18 Exception -> L20
    L8:
        int r5 = r4.read(r2);     // Catch: Throwable -> L18 Exception -> L20
        if (r5 <= 0) goto L12;
        r3.append(r2, 0, r5);     // Catch: Throwable -> L18 Exception -> L20
    L12:
        if (resource == null) goto L28;
        resource.close();     // Catch: IOException -> L15
    L15:
        e = e;
        StringBuilder r6 = new StringBuilder("close inputstream exception:");
    L17:
        OLog.w(TAG, r6.append(e.getMessage()).toString(), e);
    L28:
        return r3.toString();
    L20:
        e = move-exception;
        OLog.w(TAG, "inputStreamToString exception:" + e.getMessage(), e);     // Catch: Throwable -> L18
        if (resource == null) goto L28;
        resource.close();     // Catch: IOException -> L25
    L25:
        e = e;
        r6 = new StringBuilder("close inputstream exception:");
    L18:
        th = move-exception;
        if (resource != null) goto L37;
    L34:
        throw th;
    L37:
        resource.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        OLog.w(TAG, "close inputstream exception:" + e.getMessage(), e);
        goto L34
    }
}
