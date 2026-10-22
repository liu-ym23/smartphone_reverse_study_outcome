package com.bytedance.framwork.core.sdkmonitor;

import android.text.TextUtils;
import com.bytedance.framwork.core.sdklib.thread.AsyncEventManager;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class CacheData {
    private int MAX_LIMIT_SIZE;
    private final LinkedList<ApiData> mApiData;
    private final LinkedList<CommonLogData> mCommonLogData;
    private boolean mHasHandleCache;
    private final LinkedList<ServiceMonitorData> mServiceMonitorData;

    public CacheData() {
        this.mServiceMonitorData = new LinkedList();
        this.mCommonLogData = new LinkedList();
        this.mApiData = new LinkedList();
        this.MAX_LIMIT_SIZE = 200;
    }

    static /* synthetic */ LinkedList access$000(CacheData r0) {
        return r0.mServiceMonitorData;
    }

    static /* synthetic */ void access$100(CacheData r0, SDKMonitor r1, ServiceMonitorData r2) {
        r0.handleServiceMonitorData(r1, r2);
    }

    static /* synthetic */ LinkedList access$200(CacheData r0) {
        return r0.mCommonLogData;
    }

    static /* synthetic */ void access$300(CacheData r0, SDKMonitor r1, CommonLogData r2) {
        r0.handleCommonLogData(r1, r2);
    }

    static /* synthetic */ LinkedList access$400(CacheData r0) {
        return r0.mApiData;
    }

    static /* synthetic */ void access$500(CacheData r0, SDKMonitor r1, ApiData r2) {
        r0.handleApiData(r1, r2);
    }

    public void insertServiceMonitorData(ServiceMonitorData r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        LinkedList<ServiceMonitorData> r0 = this.mServiceMonitorData;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.mServiceMonitorData.size() <= this.MAX_LIMIT_SIZE) goto L9;
        this.mServiceMonitorData.poll();     // Catch: Throwable -> L12
    L9:
        this.mServiceMonitorData.add(r4);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public void insertCommonLogData(CommonLogData r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        LinkedList<CommonLogData> r0 = this.mCommonLogData;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.mCommonLogData.size() <= this.MAX_LIMIT_SIZE) goto L9;
        this.mCommonLogData.poll();     // Catch: Throwable -> L12
    L9:
        this.mCommonLogData.add(r4);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public void insertApiData(ApiData r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        LinkedList<ApiData> r0 = this.mApiData;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.mApiData.size() <= this.MAX_LIMIT_SIZE) goto L9;
        this.mApiData.poll();     // Catch: Throwable -> L12
    L9:
        this.mApiData.add(r4);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public void handleCacheData(final SDKMonitor r3) {
        if (this.mHasHandleCache == false) goto L5;
        return;
    L5:
        this.mHasHandleCache = true;
        AsyncEventManager.getInstance().post(new AnonymousClass1(this, r3));
    }

    private void handleServiceMonitorData(SDKMonitor r10, ServiceMonitorData r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11.serviceName) == true) goto L9;
        r10.monitorService(r11.serviceName, r11.status, r11.value, r11.category, r11.metric, r11.extrJson, r11.timestamp);
        return;
    }

    private void handleCommonLogData(SDKMonitor r4, CommonLogData r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        r4.monitorCommonLogInternal(r5.logType, r5.logData, r5.timestamp);
    }

    private void handleApiData(SDKMonitor r11, ApiData r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r12.apiType) == false) goto L7;
        return;
    L7:
        if (r12.apiType.equals("api_error") == false) goto L10;
        r11.monitorApiError(r12.duration, r12.sendTime, r12.sendUrl, r12.sendIp, r12.traceCode, r12.status, r12.extJson);
        return;
    L10:
        if (r12.apiType.equals("api_all") == false) goto L15;
        r11.monitorSLA(r12.duration, r12.sendTime, r12.sendUrl, r12.sendIp, r12.traceCode, r12.status, r12.extJson);
        return;
    }
}
