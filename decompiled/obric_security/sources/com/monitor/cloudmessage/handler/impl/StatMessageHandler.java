package com.monitor.cloudmessage.handler.impl;

import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.internal.data.stat.SystemInfoDataProvider;
import com.monitor.cloudmessage.internal.file.generator.StatFileGenerator;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class StatMessageHandler extends BaseMessageHandler implements IFileUploadCallback {
    private static final String KEY_TYPE = "type";
    private static final String STAT_FILE_TYPE = "json";
    private static final String TYPE_ALL = "all";
    private static final String TYPE_STACK_IFNO = "stack_info";
    private static final String TYPE_SYSTEM_INFO = "system_info";
    private File mCloudFile;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.STAT;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadBegin(String r1) {
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadEnd(String r1, boolean r2) {
    }

    public StatMessageHandler() {
        this.mCloudFile = null;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage r13) throws Exception {
        JSONObject r0 = new JSONObject(r13.getParams());
        String r1 = r0.optString("type", TYPE_SYSTEM_INFO);
        if (checkWifiOnly(r0, r13) == false) goto L5;
        return true;
    L5:
        JSONObject r2 = new JSONObject();
        if ("all".equals(r1) == false) goto L9;
        r2.put("all", new SystemInfoDataProvider().provideData2());
    L14:
        File r3 = StatFileGenerator.generateFile(CloudMessageManager.getInstance().getContext(), r2);
        if (r3 != null) goto L18;
        uploadFailStatus(ErrorMsg.COMMAND_STAT_FILE_GENERATE_FAIL, r13);
        return true;
    L18:
        this.mCloudFile = r3;
        CloudMessageUploadManager.upload(new FileUploadInfo("json", 0, false, r13.getCommandId(), this, null));
        return true;
    L9:
        if (TYPE_STACK_IFNO.equals(r1) == true) goto L14;
        if (TYPE_SYSTEM_INFO.equals(r1) == false) goto L14;
        r2.put(TYPE_SYSTEM_INFO, new SystemInfoDataProvider().provideData2());
        goto L14
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
