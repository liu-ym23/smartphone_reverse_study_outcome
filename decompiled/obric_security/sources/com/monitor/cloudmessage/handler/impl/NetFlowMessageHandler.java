package com.monitor.cloudmessage.handler.impl;

import com.bytedance.apm.util.TrafficUtils;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.internal.file.generator.NetFlowFileGenerator;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NetFlowMessageHandler extends BaseMessageHandler implements IFileUploadCallback {
    private static final String KEY_END_TIME = "fetch_end_time";
    private static final String KEY_START_TIME = "fetch_start_time";
    private static final String NET_FLOW_FILE_TYPE = "json";
    private static final String NET_STATS_MOBILE = "netStatsMobile";
    private static final String NET_STATS_TOTAL = "netStatsTotal";
    private static final String NET_STATS_WIFI = "netStatsWifi";
    private File mCloudFile;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.NET_FLOW;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadBegin(String r1) {
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadEnd(String r1, boolean r2) {
    }

    public NetFlowMessageHandler() {
        this.mCloudFile = null;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage r20) throws Exception {
        JSONObject r0 = new JSONObject(r20.getParams());
        if (checkWifiOnly(r0, r20) == false) goto L5;
        return true;
    L5:
        long r2 = r0.optLong(KEY_START_TIME, (System.currentTimeMillis() / 1000) - 18000);
        long r10 = r0.optLong(KEY_END_TIME, System.currentTimeMillis() / 1000);
        long r3 = r2 * 1000;
        long r4 = 1000 * r10;
        long r11 = TrafficUtils.getNetStats(CloudMessageManager.getInstance().getContext(), r3, r4, 1);
        long r5 = TrafficUtils.getNetStats(CloudMessageManager.getInstance().getContext(), r3, r4, 0);
        JSONObject r6 = new JSONObject();
        r6.put(NET_STATS_WIFI, r11);     // Catch: JSONException -> L8
        r6.put(NET_STATS_MOBILE, r5);     // Catch: JSONException -> L8
        r6.put(NET_STATS_TOTAL, r5 + r11);     // Catch: JSONException -> L8
    L10:
        File r1 = NetFlowFileGenerator.generateFile(CloudMessageManager.getInstance().getContext(), r6);
        if (r1 != null) goto L14;
        uploadFailStatus(ErrorMsg.COMMAND_NET_FLOW_FILE_GENERATE_FAIL, r20);
        return true;
    L14:
        this.mCloudFile = r1;
        CloudMessageUploadManager.upload(new FileUploadInfo("json", 0, false, r20.getCommandId(), this, null));
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List<String> getUploadFileList() {
        ArrayList r0 = new ArrayList();
        File r1 = this.mCloudFile;
        if (r1 == null) goto L5;
        r0.add(r1.getAbsolutePath());
    L5:
        return r0;
    }
}
