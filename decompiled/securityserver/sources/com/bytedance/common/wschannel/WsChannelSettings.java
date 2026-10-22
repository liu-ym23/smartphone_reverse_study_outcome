package com.bytedance.common.wschannel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelSettings {
    private static final String TAG = "com.bytedance.common.wschannel.WsChannelSettings";

    @SuppressLint({"CI_StaticFieldLeak"})
    private static volatile WsChannelSettings mInstance;
    private static OkOpaqueCallback sOkOpaqueCallback;
    private final WsChannelMultiProcessSharedProvider.MultiProcessShared multiProcessShared;

    public interface OkOpaqueCallback {
        Map<String, String> onCallToWSPayloadOpaque(Map<String, String> r1);

        Map<String, String> onCallToWsRequestOpaque(String r1, Map<String, List<String>> r2);
    }

    private WsChannelSettings(@NonNull Context r1) {
        this.multiProcessShared = WsChannelMultiProcessSharedProvider.getMultiprocessShared(r1.getApplicationContext());
    }

    public static OkOpaqueCallback getOkOpaqueCallback() {
        return sOkOpaqueCallback;
    }

    public static WsChannelSettings inst(Context r2) {
        if (mInstance != null) goto L16;
        monitor-enter(WsChannelSettings.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L11;
        mInstance = new WsChannelSettings(r2);     // Catch: Throwable -> L9
    L11:
        monitor-exit(WsChannelSettings.class);     // Catch: Throwable -> L9
    L16:
        return mInstance;
    }

    public static void setOkOpaqueCallback(OkOpaqueCallback r0) {
        sOkOpaqueCallback = r0;
    }

    public ArrayList<Integer> getAutoConnectDisabledChannelIds() {
        ArrayList<Integer> r0 = new ArrayList();
        String r3 = this.multiProcessShared.getString(WsConstants.KEY_AUTO_CONNECT_DISABLED, "");
        if (TextUtils.isEmpty(r3) == false) goto L17;
        return r0;
    L17:
        JSONArray r1 = new JSONArray(r3);     // Catch: JSONException -> L9
        int r4 = 0;
    L7:
        if (r4 >= r1.length()) goto L12;
        r0.add(Integer.valueOf(r1.getInt(r4)));     // Catch: JSONException -> L9
        r4 = r4 + 1;     // Catch: JSONException -> L9
        goto L7
    L12:
        if (Logger.debug() == false) goto L16;
        Logger.d(TAG, "getAutoConnectDisabledChannelIds: " + r0);     // Catch: JSONException -> L9
    L16:
        return r0;
    L9:
        e = move-exception;
        Logger.e(TAG, e.getMessage());
        goto L16
    }

    public long getRetryDelay() {
        return this.multiProcessShared.getLong(WsConstants.KEY_RETRY_SEND_MSG_DELAY, 0);
    }

    public long getSocketReadLimitSize() {
        return this.multiProcessShared.getLong(WsConstants.KEY_IO_LIMIT, WsConstants.DEFAULT_IO_LIMIT);
    }

    public String getWsApp() {
        return this.multiProcessShared.getString(WsConstants.KEY_WS_APPS, "");
    }

    public boolean isEnable() {
        return this.multiProcessShared.getBoolean(WsConstants.KEY_FRONTIER_ENABLED, true);
    }

    public boolean isEnableOfflineDetect() {
        return this.multiProcessShared.getBoolean(WsConstants.KEY_ENABLE_OFFLINE_DETECT, false);
    }

    public boolean isOkChannelEnable() {
        return this.multiProcessShared.getBoolean(WsConstants.KEY_OK_IMPL_ENABLE, true);
    }

    public boolean isReportAppStateEnable() {
        return this.multiProcessShared.getBoolean(WsConstants.KEY_ENABLE_REPORT_APP_STATE, false);
    }

    public void setAutoConnectDisabledChannelIds(ArrayList<Integer> r3) {
        if (r3 != null) goto L16;
        return;
    L16:
        JSONArray r0 = new JSONArray();     // Catch: Exception -> L8
        Iterator<Integer> r4 = r3.iterator();     // Catch: Exception -> L8
    L6:
        if (r4.hasNext() == false) goto L10;
        r0.put(r4.next().intValue());     // Catch: Exception -> L8
        goto L6
    L10:
        this.multiProcessShared.edit().putString(WsConstants.KEY_AUTO_CONNECT_DISABLED, r0.toString()).commit();     // Catch: Exception -> L8
        if (Logger.debug() == false) goto L19;
        Logger.d(TAG, "setAutoConnectDisabledChannelIds: " + r0);     // Catch: Exception -> L8
        return;
    L19:
        return;
    L8:
        e = move-exception;
        Logger.e(TAG, e.getMessage());
    }

    public void setEnable(boolean r2) {
        this.multiProcessShared.edit().putBoolean(WsConstants.KEY_FRONTIER_ENABLED, r2).commit();
    }

    public void setEnableOfflineDetect(boolean r2) {
        this.multiProcessShared.edit().putBoolean(WsConstants.KEY_ENABLE_OFFLINE_DETECT, r2).commit();
    }

    public void setOKChannelEnable(boolean r2) {
        this.multiProcessShared.edit().putBoolean(WsConstants.KEY_OK_IMPL_ENABLE, r2).commit();
    }

    public void setReportAppStateEnable(boolean r2) {
        this.multiProcessShared.edit().putBoolean(WsConstants.KEY_ENABLE_REPORT_APP_STATE, r2).apply();
    }

    public void setRetrySendMsgDelay(long r2) {
        this.multiProcessShared.edit().putLong(WsConstants.KEY_RETRY_SEND_MSG_DELAY, r2).commit();
    }

    public void setSocketReadLimitSize(long r3) {
        if (r3 > 0) goto L5;
        return;
    L5:
        this.multiProcessShared.edit().putLong(WsConstants.KEY_IO_LIMIT, r3).commit();
    }

    public void setWsApp(String r2) {
        this.multiProcessShared.edit().putString(WsConstants.KEY_WS_APPS, r2).commit();
    }
}
