package com.monitor.cloudmessage.handler.impl;

import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.internal.file.generator.DbFileGenerator;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import com.monitor.cloudmessage.upload.entity.UploadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DBMessageHandler extends BaseMessageHandler implements IFileUploadCallback {
    private static final String KEY_DBNAME = "db_name";
    private volatile boolean isProcessingDBFile;
    private File mCloudDBFile;

    public DBMessageHandler() {
        this.mCloudDBFile = null;
        this.isProcessingDBFile = false;
    }

    private void dbCmdNotResponse(CloudMessage r7) {
        UploadInfo r6 = new UploadInfo(0, false, r7.getCommandId(), null);
        r6.setCloudMsgResponseCode(0);
        r6.setErrorMsg(ErrorMsg.COMMAND_DB_FILE_PROCESSING);
        CloudMessageUploadManager.upload(r6);
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.DB;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List<String> getUploadFileList() {
        ArrayList r0 = new ArrayList(1);
        File r2 = this.mCloudDBFile;
        if (r2 == null) goto L5;
        r0.add(r2.getAbsolutePath());
    L5:
        return r0;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage r14) {
        JSONObject r0 = new JSONObject(r14.getParams());
        if (checkWifiOnly(r0, r14) == false) goto L6;
        return true;
    L6:
        if (this.isProcessingDBFile == false) goto L9;
        dbCmdNotResponse(r14);
        return true;
    L9:
        this.isProcessingDBFile = true;
        String r3 = r0.optString(KEY_DBNAME, "");     // Catch: Throwable -> L12
        File r4 = DbFileGenerator.copyDbFiles(CloudMessageManager.getInstance().getContext(), r3);     // Catch: Throwable -> L12
        this.isProcessingDBFile = false;
    L13:
        if (r4 != null) goto L16;
        uploadFailStatus(ErrorMsg.COMMAND_DB_COPY_FAIL, r14);
        return true;
    L16:
        this.mCloudDBFile = r4;
        FileUploadInfo r1 = new FileUploadInfo(r0.optString("fileContentType", "default_db_file_type"), 0, false, r14.getCommandId(), this, null);
        r1.setCompress(false);
        r1.setDelSourceFile(true);
        CloudMessageUploadManager.upload(r1);
        return true;
    L12:
        this.isProcessingDBFile = false;
        r4 = null;
        goto L13
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadBegin(String r1) {
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadEnd(String r1, boolean r2) {
    }
}
