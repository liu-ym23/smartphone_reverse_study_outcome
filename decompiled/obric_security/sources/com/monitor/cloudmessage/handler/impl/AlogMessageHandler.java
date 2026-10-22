package com.monitor.cloudmessage.handler.impl;

import com.bytedance.apm.ApmContext;
import com.monitor.cloudmessage.callback.IAdvanceAlogConsumer;
import com.monitor.cloudmessage.callback.IAlogConsumer;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.entity.ConsumerResult;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.refactor.CommandReportUtils;
import com.monitor.cloudmessage.refactor.CommandResultUploader;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.entity.UploadInfo;
import com.monitor.cloudmessage.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AlogMessageHandler extends BaseMessageHandler {
    private static final String ALOG_FILE_TYPE = "log_agile";
    private static final String KEY_END_TIME = "fetch_end_time";
    private static final String KEY_START_TIME = "fetch_start_time";
    private static final String MSG_BACKUP_DATA = "兜底策略数据";
    private static final String MSG_MAINPROCESS_NOT_SET_ALOG_CONSUMER = "主进程收到命令，未设置ALog回捞组件。请宿主应用检查是否在合适时机设置ALog回捞组件。";
    private static final String MSG_SUBPROCESS_NOT_SET_ALOG_CONSUMER = "子进程\"$processName\"收到命令，等待主进程活跃后上报。";
    private IAlogConsumer mAlogConsumer;
    private List<String> mAlogFileList;
    private volatile long mLastHandleTIme;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.ALOG;
    }

    public AlogMessageHandler() {
        this.mAlogFileList = new ArrayList();
        this.mLastHandleTIme = 0;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public synchronized boolean handleMessage(CloudMessage r14) throws Exception {
        monitor-enter(this);
        JSONObject r6 = new JSONObject(r14.getParams());     // Catch: Throwable -> L52
        if (this.mAlogConsumer != null) goto L16;
        boolean r0 = ApmContext.isMainProcess();     // Catch: Throwable -> L52
        String r1 = ApmContext.getCurrentProcessName();     // Catch: Throwable -> L52
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        if (r0 == false) goto L11;
        String r2 = MSG_MAINPROCESS_NOT_SET_ALOG_CONSUMER;
    L12:
        CommandReportUtils.uploadRunningMessage(r2, r14);     // Catch: Throwable -> L52
        monitor-exit(this);
        return false;
    L11:
        r2 = MSG_SUBPROCESS_NOT_SET_ALOG_CONSUMER.replace("$processName", r1);     // Catch: Throwable -> L52
        goto L12
    L16:
        if ((System.currentTimeMillis() - this.mLastHandleTIme) >= 180000) goto L20;
        UploadInfo r3 = new UploadInfo(0, false, r14.getCommandId(), null);     // Catch: Throwable -> L52
        r3.setCloudMsgResponseCode(0);     // Catch: Throwable -> L52
        r3.setErrorMsg(ErrorMsg.COMMAND_NOT_EXECUTE_IN_3_MINS);     // Catch: Throwable -> L52
        CloudMessageUploadManager.upload(r3);     // Catch: Throwable -> L52
        monitor-exit(this);
        return false;
    L20:
        this.mLastHandleTIme = System.currentTimeMillis();     // Catch: Throwable -> L52
        List<String> r4 = this.mAlogConsumer.handleAlogData(r6.optLong(KEY_START_TIME, (System.currentTimeMillis() / 1000) - 18000), r6.optLong(KEY_END_TIME, System.currentTimeMillis() / 1000), r6);     // Catch: Throwable -> L52
        ConsumerResult r5 = this.mAlogConsumer.getConsumerResult();     // Catch: Throwable -> L52
        if (r4 != null) goto L23;
    L24:
        IAlogConsumer r7 = this.mAlogConsumer;     // Catch: Throwable -> L52
        if ((r7 instanceof IAdvanceAlogConsumer) == false) goto L31;
        r4 = ((IAdvanceAlogConsumer) r7).getBackupAlogData();     // Catch: Throwable -> L52
        if (r4 == null) goto L31;
        if (r4.size() == 0) goto L31;
        r5 = ConsumerResult.build(true, MSG_BACKUP_DATA, r5.getSpecificParams());     // Catch: Throwable -> L52
    L31:
        if (r4 == null) goto L48;
        if (r4.size() == 0) goto L48;
        if (r5.isSuccess() == false) goto L48;
        this.mAlogFileList.clear();     // Catch: Throwable -> L52
        this.mAlogFileList.addAll(r4);     // Catch: Throwable -> L52
        File r8 = CommandResultUploader.getInstance().getPendingDir();     // Catch: Throwable -> L52
        if (r8 == null) goto L46;
        File r9 = new File(r8, r14.getCommandId() + "temp");     // Catch: Throwable -> L52
        if (r9.exists() == false) goto L41;
        FileUtils.deleteFile(r9);     // Catch: Throwable -> L52
    L41:
        r9.mkdirs();     // Catch: Throwable -> L52
        File r10 = new File(r9, r14.getCommandId() + "-cloudMsg.zip");     // Catch: Throwable -> L52
        if (r10.exists() == false) goto L44;
        r10.delete();     // Catch: Throwable -> L52
    L44:
        String[] r11 = (String[]) r4.toArray(new String[r4.size()]);     // Catch: Throwable -> L52
        FileUtils.compress(r10.getAbsolutePath(), r11);     // Catch: Throwable -> L52
        CommandReportUtils.uploadRunningMessage("Alog回捞:" + Arrays.toString(r11) + " ErrMsg=" + r5.getErrMsg(), r14, r5.getSpecificParams());     // Catch: Throwable -> L52
        CommandResultUploader.getInstance().upload(r14, r9, ALOG_FILE_TYPE);     // Catch: Throwable -> L52
    L50:
        monitor-exit(this);
        return true;
    L46:
        throw new CloudMessageException("pending目录因拿不到context而未设置");     // Catch: Throwable -> L52
    L48:
        if (r5.isSuccess() == true) goto L50;
        uploadFailStatus(r5.getErrMsg(), r5.getSpecificParams(), r14);     // Catch: Throwable -> L52
        goto L50
    L23:
        if (r4.size() != 0) goto L31;
    L52:
        th = move-exception;
        throw th;
    }

    public void setAlogConsumer(IAlogConsumer r1) {
        this.mAlogConsumer = r1;
    }
}
