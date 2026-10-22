package com.monitor.cloudmessage.handler.impl;

import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.internal.file.generator.PermissionFileGenerator;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import com.monitor.cloudmessage.upload.entity.UploadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PermissionMessageHandler extends BaseMessageHandler implements IFileUploadCallback {
    private static final String PERMISSION_FILE_TYPE = "txt";
    private File mCloudPermissionFile;

    public PermissionMessageHandler() {
        this.mCloudPermissionFile = null;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.PERMISSION;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List<String> getUploadFileList() {
        ArrayList r0 = new ArrayList(1);
        File r2 = this.mCloudPermissionFile;
        if (r2 == null) goto L5;
        r0.add(r2.getAbsolutePath());
    L5:
        return r0;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage r11) {
        if (checkWifiOnly(new JSONObject(r11.getParams()), r11) == false) goto L5;
        return true;
    L5:
        File r0 = PermissionFileGenerator.writePermissionInfo(CloudMessageManager.getInstance().getContext());
        if (r0 != null) goto L9;
        UploadInfo r10 = new UploadInfo(0, false, r11.getCommandId(), null);
        r10.setCloudMsgResponseCode(3);
        r10.setErrorMsg("网络信息文件生成失败");
        CloudMessageUploadManager.upload(r10);
        return true;
    L9:
        this.mCloudPermissionFile = r0;
        CloudMessageUploadManager.upload(new FileUploadInfo(PERMISSION_FILE_TYPE, 0, false, r11.getCommandId(), this, null));
        return true;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadBegin(String r1) {
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadEnd(String r1, boolean r2) {
    }
}
