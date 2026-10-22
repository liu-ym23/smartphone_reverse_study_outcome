package com.ss.ttuploader;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTVideoUploaderAbstractListener {
    public static final int netType4G = 2;
    public static final int netTypeWIFI = 1;
    public static final int vidContextTypeRoutALL = 3;
    public static final int vidContextTypeRoutError = 4;
    public static final int vidContextTypeRoutFirst = 2;
    public static final int vidContextTypeSpeedTestFailed = 1;
    public static final int vidContextTypeSpeedTestSuccess = 0;

    public TTVideoUploaderAbstractListener() {
    }

    public void onEventLog(JSONObject r1) {
    }

    public void onEventLogMap(Map<String, String> r1) {
    }

    public void onSpeedVidContext(int r1, int r2, String r3) {
    }

    public void onVidContext(String r1) {
    }

    public boolean switchNetType(int r1) {
        return false;
    }
}
