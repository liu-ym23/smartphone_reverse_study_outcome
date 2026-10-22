package com.monitor.cloudmessage.handler.impl;

import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.callback.IMonitorLogConsumer;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.internal.file.generator.MonitorLogFileGenerator;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MonitorLogMessageHandler extends BaseMessageHandler implements IFileUploadCallback {
    private static final long DEFAULT_START_TIME_INTERVAL = 18000;
    private static final String KEY_END_TIME = "fetch_end_time";
    private static final String KEY_START_TIME = "fetch_start_time";
    private static final int MAX_QUERY_TIMES = 100;
    private MonitorLogConsumeResult ErrorResult;
    private File mCloudFile;
    private IMonitorLogConsumer mMonitorLogConsumer;
    private ConcurrentLinkedQueue<MonitorLogConsumeResult> queue;

    private class MonitorLogConsumeResult {
        public String logIds;
        public String packLog;
        final /* synthetic */ MonitorLogMessageHandler this$0;

        public MonitorLogConsumeResult(MonitorLogMessageHandler r1, String r2, String r3) {
            this.this$0 = r1;
            this.packLog = r2;
            this.logIds = r3;
        }
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return "monitor_log";
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadBegin(String r1) {
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadEnd(String r1, boolean r2) {
    }

    public MonitorLogMessageHandler() {
        this.mCloudFile = null;
        this.queue = new ConcurrentLinkedQueue();
        this.ErrorResult = new MonitorLogConsumeResult(this, "error_data", "error_ids");
    }

    static /* synthetic */ MonitorLogConsumeResult access$000(MonitorLogMessageHandler r0) {
        return r0.ErrorResult;
    }

    static /* synthetic */ ConcurrentLinkedQueue access$100(MonitorLogMessageHandler r0) {
        return r0.queue;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage r25) throws Exception {
        JSONObject r0 = new JSONObject(r25.getParams());
        if (this.mMonitorLogConsumer != null) goto L6;
        return false;
    L6:
        if (checkWifiOnly(r0, r25) == false) goto L8;
        return true;
    L8:
        long r19 = r0.optLong(KEY_START_TIME, (System.currentTimeMillis() / 1000) - DEFAULT_START_TIME_INTERVAL);
        long r21 = r0.optLong(KEY_END_TIME, System.currentTimeMillis() / 1000);
        String[] r7 = this.mMonitorLogConsumer.parseLogType(r0);
        if (r7 != null) goto L11;
    L33:
        return true;
    L11:
        if (r7.length <= 0) goto L33;
        int r6 = r7.length;
        boolean r1 = false;
        boolean r2 = false;
        int r5 = 0;
    L13:
        if (r5 >= r6) goto L30;
        String r4 = r7[r5];
        int r3 = 0;
    L15:
        r3 = r3 + 1;
        if (r3 > 100) goto L29;
        if (this.queue.isEmpty() == true) goto L20;
        MonitorLogConsumeResult r12 = this.queue.poll();
        if (r12 == this.ErrorResult) goto L24;
        File r8 = MonitorLogFileGenerator.generateFile(CloudMessageManager.getInstance().getContext(), r12.packLog, parseToFileNamePrex(r4));
        this.mCloudFile = r8;
        if (r8 == null) goto L28;
        String r14 = r4;
        FileUploadInfo r13 = new FileUploadInfo(parseToUploadFileType(r4), 0, false, r25.getCommandId(), this, null);
        r13.setCloudMsgResponseCode(1);
        r13.setForceUseState(true);
        CloudMessageUploadManager.upload(r13);
        this.mMonitorLogConsumer.notifyLogDataConsumed(r14, r12.logIds);
        Thread.sleep(100);
        r2 = false;
        r1 = true;
        r4 = r14;
        r5 = r5;
        r6 = r6;
        r7 = r7;
        r3 = r3;
        goto L15
    L28:
        this.queue.clear();
        r1 = false;
        r2 = false;
        goto L29
    L24:
        this.queue.clear();
        r2 = false;
        goto L29
    L20:
        if (r2 == true) goto L15;
        this.mMonitorLogConsumer.handleLogData(r19, r21, r4, new AnonymousClass1(this));
        r2 = true;
    L29:
        r5 = r5 + 1;
        r6 = r6;
        r7 = r7;
        goto L13
    L30:
        if (r1 == false) goto L32;
        uploadSuccessStatus(r25);
        goto L33
    L32:
        uploadFailStatus(ErrorMsg.COMMAND_MONITOR_LOG_NONE, r25);
        goto L33
    }

    public void setMonitorLogConsumer(IMonitorLogConsumer r1) {
        this.mMonitorLogConsumer = r1;
    }

    public String parseToUploadFileType(String r1) {
        if ("block_monitor".equals(r1) == false) goto L5;
        return "log_exception";
    L5:
        return "log_performance";
    }

    public String parseToFileNamePrex(String r2) {
        return "cloudMessage_" + r2;
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
