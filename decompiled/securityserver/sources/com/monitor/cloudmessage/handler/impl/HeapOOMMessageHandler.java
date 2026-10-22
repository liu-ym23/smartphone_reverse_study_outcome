package com.monitor.cloudmessage.handler.impl;

import android.os.Debug;
import android.text.TextUtils;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HeapOOMMessageHandler extends BaseMessageHandler implements IFileUploadCallback {
    private static final String HEAPOOM_FILE_TYPE = "log_heap_oom";
    private static final String KEY_ISTRYTOCATCH = "isTryToCatch";
    private File mCloudFile;
    private long mLastHandleTime;

    public HeapOOMMessageHandler() {
        this.mCloudFile = null;
        this.mLastHandleTime = 0;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.HEAP_OOM;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List<String> getUploadFileList() {
        ArrayList r0 = new ArrayList(1);
        File r2 = this.mCloudFile;
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
        if ((System.currentTimeMillis() - this.mLastHandleTime) >= 300000) goto L8;
        return false;
    L8:
        this.mLastHandleTime = System.currentTimeMillis();
        boolean r1 = r0.optBoolean(KEY_ISTRYTOCATCH, false);
        String r2 = CloudMessageManager.getDumpFileDir();
        boolean r3 = TextUtils.isEmpty(r2);
        String r4 = ErrorMsg.COMMAND_OOM_DUMP_FILE_NAME_NULL;
        if (r3 == false) goto L12;
        uploadFailStatus(ErrorMsg.COMMAND_OOM_DUMP_FILE_NAME_NULL, r14);
        return true;
    L12:
        if (r1 == true) goto L30;
    L17:
        File r5 = new File(r2);
        if (TextUtils.isEmpty(r2) == true) goto L22;
        r4 = null;
    L22:
        if (r5.exists() == true) goto L25;
        r4 = ErrorMsg.COMMAND_OOM_DUMP_FILE_NOT_EXIST;
    L25:
        if (TextUtils.isEmpty(r4) == true) goto L28;
        uploadFailStatus(r4, r14);
        return true;
    L28:
        this.mCloudFile = r5;
        FileUploadInfo r6 = new FileUploadInfo(HEAPOOM_FILE_TYPE, 0, false, r14.getCommandId(), this, null);
        r6.setCompress(true);
        CloudMessageUploadManager.upload(r6);
        return true;
    L30:
        Debug.dumpHprofData(r2);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadBegin(String r1) {
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadEnd(String r1, boolean r2) {
    }
}
