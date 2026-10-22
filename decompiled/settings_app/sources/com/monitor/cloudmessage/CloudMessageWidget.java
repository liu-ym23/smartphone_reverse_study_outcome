package com.monitor.cloudmessage;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import com.GlobalProxyLancet;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.BaseApmWidget;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.IMonitorLogManager;
import com.bytedance.services.apm.api.IMonitorLogQueryCallback;
import com.bytedance.services.apm.api.WidgetParams;
import com.bytedance.services.slardar.config.IConfigManager;
import com.bytedance.services.slardar.config.IResponseConfigListener;
import com.monitor.cloudmessage.broadcast_receiver.NetworkBroadcastReceiver;
import com.monitor.cloudmessage.callback.IMonitorLogConsumer;
import com.monitor.cloudmessage.upload.net.CloudMessageUploadService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class CloudMessageWidget extends BaseApmWidget implements IResponseConfigListener, IMonitorLogConsumer {
    private static final String CLOSE_CLOUD_REQUEST = "close_cloud_request";
    private static final long DELAY_MILLS = 2000;
    private Context mContext;
    private boolean mHasReady;
    private NetworkBroadcastReceiver mNetworkBroadcastReceiver;
    private List<String> mUploadTypeListInDefaultReportType;

    @Override // com.bytedance.apm.BaseApmWidget, com.bytedance.services.apm.api.IWidget
    public String getTag() {
        return "CloudMessageWidget";
    }

    @Override // com.bytedance.apm.BaseApmWidget, com.bytedance.services.apm.api.IWidget
    public boolean isOnlyMainProcess() {
        return true;
    }

    public CloudMessageWidget() {
        this.mHasReady = false;
        this.mUploadTypeListInDefaultReportType = Arrays.asList(new String[]{"timer", "count", "disk", "memory", "cpu", "fps", "traffic", "start", "page_load", "image_monitor", "api_all", "api_error", "common_log", "service_monitor", "performance_monitor", "ui_action"});
    }

    @Override // com.bytedance.apm.BaseApmWidget, com.bytedance.services.apm.api.IWidget
    public void init(Context r1) {
        super.init(r1);
        this.mContext = r1;
        CloudMessageManager.init(r1);
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).registerResponseConfigListener(this);
        CloudMessageManager.setMonitorLogConsumerSafely(this);
        ActivityLifeObserver.getInstance().register(this);
        registerConfigService();
    }

    @Override // com.bytedance.apm.BaseApmWidget, com.bytedance.services.apm.api.IWidget
    public void start() {
        super.start();
    }

    @Override // com.bytedance.apm.BaseApmWidget, com.bytedance.services.apm.api.IWidget
    public void stop() {
        super.stop();
    }

    @Override // com.bytedance.apm.BaseApmWidget, com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        super.onReady();
        if (this.mHasReady == false) goto L5;
        return;
    L5:
        this.mHasReady = true;
        if (getServiceSwitch(CLOSE_CLOUD_REQUEST) == false) goto L8;
        return;
    L8:
        if (ApmContext.isMainProcess() == false) goto L12;
        this.mNetworkBroadcastReceiver = new NetworkBroadcastReceiver();
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mNetworkBroadcastReceiver, r0);
        AsyncEventManager.getInstance().post(new AnonymousClass1(this));
        return;
    }

    @Override // com.bytedance.apm.BaseApmWidget, com.bytedance.services.apm.api.IWidget
    public void destroy() {
        super.destroy();
        NetworkBroadcastReceiver r0 = this.mNetworkBroadcastReceiver;     // Catch: Exception -> L7
        if (r0 == null) goto L10;
        this.mContext.unregisterReceiver(r0);     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    @Override // com.bytedance.services.apm.api.IWidget
    public void notifyParams(WidgetParams r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (CollectionUtils.isEmpty(r4.getReportDomain()) == false) goto L11;
        return;
    L11:
        URL r0 = new URL(r4.getReportDomain().get(0));     // Catch: MalformedURLException -> L8
        CloudMessageUploadService.UPLOAD_URL = String.format("%s://%s/%s", new Object[]{r0.getProtocol(), r0.getHost(), CloudMessageUploadService.API_PATH});     // Catch: MalformedURLException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.services.slardar.config.IResponseConfigListener
    public void onResponse(JSONObject r3) {
        if (CloudMessageManager.isFetchDataWithSocket() == true) goto L10;
        JSONArray r2 = r3.optJSONArray("cloud_commands");
        if (r2 == null) goto L12;
        int r4 = 0;
    L8:
        if (r4 >= r2.length()) goto L13;
        String r0 = r2.optString(r4);
        CloudMessageManager.getInstance().handleCloudMessage(r0);
        r4 = r4 + 1;
        goto L8
    L13:
        return;
    L12:
        return;
    }

    @Override // com.monitor.cloudmessage.callback.IMonitorLogConsumer
    public String[] parseLogType(JSONObject r3) {
        JSONArray r4 = r3.optJSONArray("upload_type");
        int r0 = 0;
        if (r4 != null) goto L9;
        String[] r5 = new String[this.mUploadTypeListInDefaultReportType.size()];
    L6:
        if (r0 >= this.mUploadTypeListInDefaultReportType.size()) goto L8;
        r5[r0] = this.mUploadTypeListInDefaultReportType.get(r0);
        r0 = r0 + 1;
        goto L6
    L8:
        return r5;
    L9:
        String[] r2 = new String[r4.length()];
    L11:
        if (r0 >= r4.length()) goto L13;
        r2[r0] = r4.optString(r0);
        r0 = r0 + 1;
        goto L11
    L13:
        return r2;
    }

    @Override // com.monitor.cloudmessage.callback.IMonitorLogConsumer
    public void handleLogData(long r8, long r10, String r12, IMonitorLogQueryCallback r13) {
        ((IMonitorLogManager) ServiceManager.getService(IMonitorLogManager.class)).getLegacyLog(r8 * 1000, r10 * 1000, r12, r13);
    }

    @Override // com.monitor.cloudmessage.callback.IMonitorLogConsumer
    public void notifyLogDataConsumed(String r1, String r2) {
        ((IMonitorLogManager) ServiceManager.getService(IMonitorLogManager.class)).deleteLegacyLogByIds(r1, r2);
    }

    @Override // com.bytedance.apm.BaseApmWidget, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r4) {
        super.onBackground(r4);
        if (getServiceSwitch(CLOSE_CLOUD_REQUEST) == false) goto L5;
        return;
    L5:
        if (ApmContext.isMainProcess() == false) goto L9;
        AsyncEventManager.getInstance().postDelay(new AnonymousClass2(this), DELAY_MILLS);
        return;
    }
}
