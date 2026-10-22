package com.monitor.cloudmessage.handler.impl;

import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.internal.file.generator.PrefFileGenerator;
import com.monitor.cloudmessage.refactor.CommandResultUploader;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class SPMessageHandler extends BaseMessageHandler {
    private static final String SP_FILE_TYPE = "default_sp_file_type";

    public SPMessageHandler() {
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.SP;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public synchronized boolean handleMessage(CloudMessage r5) {
        monitor-enter(this);
        File r0 = PrefFileGenerator.copySPFiles(CloudMessageManager.getInstance().getContext());     // Catch: Throwable -> L8
        if (r0 != null) goto L10;
        uploadFailStatus(ErrorMsg.COMMAND_SP_COPY_FAIL, r5);     // Catch: Throwable -> L8
        monitor-exit(this);
        return true;
    L10:
        CommandResultUploader.getInstance().upload(r5, r0.getParentFile(), SP_FILE_TYPE);     // Catch: Throwable -> L8
        monitor-exit(this);
        return true;
    L8:
        th = move-exception;
        throw th;
    }
}
