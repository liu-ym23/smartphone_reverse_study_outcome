package com.monitor.cloudmessage.handler.impl;

import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.internal.file.generator.NetworkFileGenerator;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class NetworkMessageHandler extends BaseMessageHandler implements IFileUploadCallback {
    private static final String NETWORK_FILE_TYPE = "json";
    private File mCloudNetFile;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return "network";
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadBegin(String r1) {
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadEnd(String r1, boolean r2) {
    }

    public NetworkMessageHandler() {
        this.mCloudNetFile = null;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage r11) throws Exception {
        if (checkWifiOnly(new JSONObject(r11.getParams()), r11) == false) goto L5;
        return true;
    L5:
        File r0 = NetworkFileGenerator.generateFile(CloudMessageManager.getInstance().getContext(), new JSONObject(r11.getParams()));
        if (r0 != null) goto L9;
        uploadFailStatus("网络信息文件生成失败", r11);
        return true;
    L9:
        this.mCloudNetFile = r0;
        CloudMessageUploadManager.upload(new FileUploadInfo("json", 0, false, r11.getCommandId(), this, null));
        return true;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List<String> getUploadFileList() {
        ArrayList r0 = new ArrayList(1);
        File r2 = this.mCloudNetFile;
        if (r2 == null) goto L5;
        r0.add(r2.getAbsolutePath());
    L5:
        return r0;
    }
}
