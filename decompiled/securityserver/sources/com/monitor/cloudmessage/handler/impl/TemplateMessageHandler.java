package com.monitor.cloudmessage.handler.impl;

import android.text.TextUtils;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.callback.ITemplateConsumer;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.ConsumerResult;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.internal.file.generator.TemplateFileGenerator;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TemplateMessageHandler extends BaseMessageHandler implements IFileUploadCallback {
    private static final String KEY_TEMPLATE = "template";
    private File mCloudTemplateFile;
    private ITemplateConsumer mTemplateConsumer;

    public TemplateMessageHandler() {
        this.mCloudTemplateFile = null;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return "custom";
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List<String> getUploadFileList() {
        ArrayList r0 = new ArrayList(1);
        File r2 = this.mCloudTemplateFile;
        if (r2 == null) goto L5;
        r0.add(r2.getAbsolutePath());
    L5:
        return r0;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage r14) {
        String r0 = r14.getParams();
        if (this.mTemplateConsumer != null) goto L6;
        return false;
    L6:
        JSONObject r1 = new JSONObject(r0);
        if (checkWifiOnly(r1, r14) == false) goto L9;
        return true;
    L9:
        JSONObject r2 = r1.optJSONObject(KEY_TEMPLATE);
        if (r2 != null) goto L13;
        uploadFailStatus(ErrorMsg.COMMAND_TEMPLATE_FIELD_ERROR, r14);
        return true;
    L13:
        r1.put("cloud_command_id", r14.getCommandId());
        String r3 = this.mTemplateConsumer.handleTemplateMessage(r2);
        ConsumerResult r4 = this.mTemplateConsumer.getConsumerResult();
        if (r4.isSuccess() == true) goto L16;
        uploadFailStatus(r4.getErrMsg(), r4.getSpecificParams(), r14);
    L24:
        return true;
    L16:
        if (TextUtils.isEmpty(r3) == false) goto L18;
        r3 = "{\"result\" : \"no one handle it.\"}";
    L18:
        File r5 = TemplateFileGenerator.generateFile(CloudMessageManager.getInstance().getContext(), r3);
        if (r5 != null) goto L22;
        uploadFailStatus(ErrorMsg.COMMAND_TEMPLATE_FILE_GENERATE_ERROR, r14);
        return true;
    L22:
        this.mCloudTemplateFile = r5;
        CloudMessageUploadManager.upload(new FileUploadInfo(r1.optString("fileContentType", "template_file_type"), 0, false, r14.getCommandId(), this, r4.getSpecificParams()));
        goto L24
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadBegin(String r1) {
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadEnd(String r1, boolean r2) {
    }

    public void setTemplateConsumer(ITemplateConsumer r1) {
        this.mTemplateConsumer = r1;
    }
}
