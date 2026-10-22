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

/* JADX INFO: loaded from: classes.dex */
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

    public AlogMessageHandler() {
        this.mAlogFileList = new ArrayList();
        this.mLastHandleTIme = 0;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.ALOG;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public synchronized boolean handleMessage(CloudMessage r14) {
        monitor-enter(this);
        JSONObject r6 = new JSONObject(r14.getParams());     // Catch: Throwable -> L9
        if (this.mAlogConsumer != null) goto L18;
        boolean r0 = ApmContext.isMainProcess();     // Catch: Throwable -> L9
        String r1 = ApmContext.getCurrentProcessName();     // Catch: Throwable -> L9
        if (r1 != null) goto L11;
        r1 = "";
    L11:
        if (r0 == false) goto L13;
        String r2 = MSG_MAINPROCESS_NOT_SET_ALOG_CONSUMER;
    L14:
        CommandReportUtils.uploadRunningMessage(r2, r14);     // Catch: Throwable -> L9
        monitor-exit(this);
        return false;
    L13:
        r2 = MSG_SUBPROCESS_NOT_SET_ALOG_CONSUMER.replace("$processName", r1);     // Catch: Throwable -> L9
        goto L14
    L18:
        if ((System.currentTimeMillis() - this.mLastHandleTIme) >= 180000) goto L22;
        UploadInfo r3 = new UploadInfo(0, false, r14.getCommandId(), null);     // Catch: Throwable -> L9
        r3.setCloudMsgResponseCode(0);     // Catch: Throwable -> L9
        r3.setErrorMsg(ErrorMsg.COMMAND_NOT_EXECUTE_IN_3_MINS);     // Catch: Throwable -> L9
        CloudMessageUploadManager.upload(r3);     // Catch: Throwable -> L9
        monitor-exit(this);
        return false;
    L22:
        this.mLastHandleTIme = System.currentTimeMillis();     // Catch: Throwable -> L9
        List<String> r4 = this.mAlogConsumer.handleAlogData(r6.optLong(KEY_START_TIME, (System.currentTimeMillis() / 1000) - 18000), r6.optLong(KEY_END_TIME, System.currentTimeMillis() / 1000), r6);     // Catch: Throwable -> L9
        ConsumerResult r5 = this.mAlogConsumer.getConsumerResult();     // Catch: Throwable -> L9
        if (r4 != null) goto L25;
    L26:
        IAlogConsumer r7 = this.mAlogConsumer;     // Catch: Throwable -> L9
        if ((r7 instanceof IAdvanceAlogConsumer) == false) goto L33;
        r4 = ((IAdvanceAlogConsumer) r7).getBackupAlogData();     // Catch: Throwable -> L9
        if (r4 == null) goto L33;
        if (r4.size() == 0) goto L33;
        r5 = ConsumerResult.build(true, MSG_BACKUP_DATA, r5.getSpecificParams());     // Catch: Throwable -> L9
    L33:
        if (r4 == null) goto L50;
        if (r4.size() == 0) goto L50;
        if (r5.isSuccess() == false) goto L50;
        this.mAlogFileList.clear();     // Catch: Throwable -> L9
        this.mAlogFileList.addAll(r4);     // Catch: Throwable -> L9
        File r8 = CommandResultUploader.getInstance().getPendingDir();     // Catch: Throwable -> L9
        if (r8 == null) goto L48;
        File r9 = new File(r8, r14.getCommandId() + "temp");     // Catch: Throwable -> L9
        if (r9.exists() == false) goto L43;
        FileUtils.deleteFile(r9);     // Catch: Throwable -> L9
    L43:
        r9.mkdirs();     // Catch: Throwable -> L9
        File r10 = new File(r9, r14.getCommandId() + "-cloudMsg.zip");     // Catch: Throwable -> L9
        if (r10.exists() == false) goto L46;
        r10.delete();     // Catch: Throwable -> L9
    L46:
        String[] r11 = (String[]) r4.toArray(new String[r4.size()]);     // Catch: Throwable -> L9
        FileUtils.compress(r10.getAbsolutePath(), r11);     // Catch: Throwable -> L9
        CommandReportUtils.uploadRunningMessage("Alog回捞:" + Arrays.toString(r11) + " ErrMsg=" + r5.getErrMsg(), r14, r5.getSpecificParams());     // Catch: Throwable -> L9
        CommandResultUploader.getInstance().upload(r14, r9, ALOG_FILE_TYPE);     // Catch: Throwable -> L9
    L52:
        monitor-exit(this);
        return true;
    L48:
        throw new CloudMessageException("pending目录因拿不到context而未设置");     // Catch: Throwable -> L9
    L50:
        if (r5.isSuccess() == true) goto L52;
        uploadFailStatus(r5.getErrMsg(), r5.getSpecificParams(), r14);     // Catch: Throwable -> L9
        goto L52
    L25:
        if (r4.size() != 0) goto L33;
    L9:
        th = move-exception;
        throw th;
    }

    public void setAlogConsumer(IAlogConsumer r1) {
        this.mAlogConsumer = r1;
    }
}
