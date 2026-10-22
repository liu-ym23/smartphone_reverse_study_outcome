package com.bytedance.common.wschannel.client;

import android.content.Context;
import android.os.Parcelable;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes3.dex */
public interface WsChannelApi {

    public static class ServiceHolder {
        String key;
        Parcelable obj;
        int what;

        public ServiceHolder() {
        }
    }

    void onEnterToBackground(Context r1);

    void onEnterToForeground(Context r1);

    void onParameterChange(Context r1, SsWsApp r2);

    void onTrimMemory(Context r1, int r2);

    void registerApp(Context r1, SsWsApp r2);

    void registerServiceId(Context r1, int r2, int r3);

    void sendPayload(Context r1, WsChannelMsg r2);

    void tryStartPushProcess(Context r1, boolean r2);

    void tryStartPushProcess(Context r1, boolean r2, boolean r3);

    void unRegisterApp(Context r1, int r2);

    void unregisterServiceId(Context r1, int r2, int r3);
}
