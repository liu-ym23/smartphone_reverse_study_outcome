package com.bytedance.framwork.core.sdklib.net;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class MonitorLogSender {
    private static final ConcurrentHashMap<String, ILogSendImpl> mapAidLogSendImpl = null;
    private static final ConcurrentHashMap<String, ISendLog> mapAidSendLog = null;

    static {
        mapAidSendLog = new ConcurrentHashMap();
        mapAidLogSendImpl = new ConcurrentHashMap();
    }

    public MonitorLogSender() {
    }

    public static ISendLog getISendLog(String r1) {
        return mapAidSendLog.get(r1);
    }

    public static ILogSendImpl getImpl(String r1) {
        return mapAidLogSendImpl.get(r1);
    }

    public static boolean send(String r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        return mapAidLogSendImpl.get(r1).send(r2);
    }

    public static void setISendLog(String r1, ISendLog r2) {
        mapAidSendLog.put(r1, r2);
    }

    public static void setImpl(String r1, ILogSendImpl r2) {
        mapAidLogSendImpl.put(r1, r2);
    }
}
