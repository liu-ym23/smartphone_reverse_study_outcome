package com.bytedance.crash;

import androidx.annotation.Nullable;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NpthApi {
    private static NpthApi sImpl;
    private static RetraceDataCallback sRetraceDataCallback;

    public interface CustomDataCallback {
        Map<String, String> getData();
    }

    public interface RetraceDataCallback {
        JSONObject getData();
    }

    public NpthApi() {
        sImpl = this;
    }

    public static void addCustomData(CustomDataCallback r1) {
        NpthApi r0 = sImpl;
        if (r0 == null) goto L6;
        r0.addCustomInner(r1);
        return;
    }

    public static void addTags(Map<String, String> r1) {
        NpthApi r0 = sImpl;
        if (r0 == null) goto L6;
        r0.addTagsInner(r1);
        return;
    }

    public static void checkInnerSoFile(String r1) {
        NpthApi r0 = sImpl;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.checkInnerSo(r1);
    }

    public static String getByTraceID() {
        NpthApi r0 = sImpl;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getByTraceIDInner();
    }

    @Nullable
    public static JSONObject getRetraceParams() {
        RetraceDataCallback r0 = sRetraceDataCallback;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getData();
    }

    public static void registerSDKVersion(String r1, String r2) {
        NpthApi r0 = sImpl;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.registerSDK(r1, r2);
    }

    public static void setRetraceData(RetraceDataCallback r0) {
        sRetraceDataCallback = r0;
    }

    public static void startMonitor() {
        NpthApi r0 = sImpl;
        if (r0 == null) goto L6;
        r0.startMonitorInner();
        return;
    }

    public void addCustomInner(CustomDataCallback r1) {
    }

    public void addTagsInner(Map<String, String> r1) {
    }

    public void checkInnerSo(String r1) {
    }

    public String getByTraceIDInner() {
        return "";
    }

    public void registerSDK(String r1, String r2) {
    }

    public void startMonitorInner() {
    }
}
