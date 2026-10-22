package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.SsWsApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
class WsChannelSaver implements IWsChannelSaver {
    private static final String TAG = "WsChannelSaver";
    private final Context mContext;

    static {
    }

    WsChannelSaver(Context r1) {
        this.mContext = r1;
    }

    @Override // com.bytedance.common.wschannel.server.IWsChannelSaver
    public Map<Integer, IWsApp> loadWsChannels() {
        LinkedHashMap r2 = new LinkedHashMap();
        String r3 = WsChannelSettings.inst(this.mContext).getWsApp();     // Catch: Exception -> L29
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "load from sp wsAppStr: " + r3);     // Catch: Exception -> L29
    L7:
        if (TextUtils.isEmpty(r3) == false) goto L9;
        return r2;
    L9:
        JSONArray r1 = new JSONArray(r3);     // Catch: Exception -> L29
        int r4 = r1.length();     // Catch: Exception -> L29
        if (r4 > 0) goto L12;
        return r2;
    L12:
        ArrayList<Integer> r5 = WsChannelSettings.inst(this.mContext).getAutoConnectDisabledChannelIds();     // Catch: Exception -> L29
        if (Logger.debug() == false) goto L15;
        Logger.d(TAG, "load from sp disabledList: " + r5);     // Catch: Exception -> L29
    L15:
        int r0 = 0;
    L16:
        if (r0 >= r4) goto L26;
        SsWsApp r6 = new SsWsApp.SsWsAppBuilder().buildFromJson(r1.optJSONObject(r0));     // Catch: Exception -> L29
        if (checkValidWsApp(r6) == false) goto L24;
        if (r5 != null) goto L21;
    L23:
        r2.put(Integer.valueOf(WsChannelService.getClientKey(r6)), r6);     // Catch: Exception -> L29
        goto L24
    L21:
        if (r5.contains(Integer.valueOf(WsChannelService.getClientKey(r6))) == false) goto L23;
    L24:
        r0 = r0 + 1;     // Catch: Exception -> L29
        goto L16
    L26:
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "loadWsChannels final wsApp: " + r2);     // Catch: Exception -> L29
    L31:
        return r2;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    }

    private boolean checkValidWsApp(IWsApp r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.getChannelId() > 0) goto L9;
        return false;
    L9:
        if (r2.getAppId() > 0) goto L12;
        return false;
    L12:
        if (StringUtils.isEmpty(r2.getAppKey()) == false) goto L15;
        return false;
    L15:
        if (r2.getAppVersion() > 0) goto L18;
        return false;
    L18:
        if (r2.getConnectUrls().isEmpty() == false) goto L21;
        return false;
    L21:
        if (StringUtils.isEmpty(r2.getDeviceId()) == false) goto L24;
        return false;
    L24:
        if (r2.getFPID() > 0) goto L27;
        return false;
    L27:
        if (StringUtils.isEmpty(r2.getInstallId()) == false) goto L30;
        return false;
    L30:
        if (r2.getPlatform() == 0) goto L32;
        return false;
    L32:
        return true;
    }

    @Override // com.bytedance.common.wschannel.server.IWsChannelSaver
    public void saveWsChannels(Map<Integer, IWsApp> r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        JSONArray r0 = new JSONArray();
        monitor-enter(WsChannelService.class);
        Iterator<Map.Entry<Integer, IWsApp>> r6 = r5.entrySet().iterator();     // Catch: Throwable -> L22
    L8:
        if (r6.hasNext() == false) goto L16;
        Map.Entry<Integer, IWsApp> r2 = r6.next();     // Catch: Throwable -> L22
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
        goto L8
    L11:
        if (checkValidWsApp(r2.getValue()) == false) goto L8;
        r0.put(r2.getValue().toJson());     // Catch: Exception -> L14 Throwable -> L22
    L16:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L22
        Logger.d(TAG, "save to sp : " + r0.toString());     // Catch: Exception -> L19
        WsChannelSettings.inst(this.mContext).setWsApp(r0.toString());     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L22:
        th = move-exception;
        throw th;
    }
}
