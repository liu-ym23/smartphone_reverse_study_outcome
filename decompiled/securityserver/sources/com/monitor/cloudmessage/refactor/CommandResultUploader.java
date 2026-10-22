package com.monitor.cloudmessage.refactor;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.utils.FileUtils;
import com.monitor.cloudmessage.utils.NetworkUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CommandResultUploader {
    private static final long IGNORE_WIFI_ONLY_PARAMS_THRESHOLD = 2097152;
    private static final String PENDING_UPLOAD_DIR = "cloud_uploading";
    private volatile File pendingDir;
    private final Map<String, Boolean> wifiOnlyResultMap;

    public static class InnerHolder {
        private static final CommandResultUploader instance = null;

        static {
            instance = new CommandResultUploader();
        }

        private InnerHolder() {
        }

        public static /* synthetic */ CommandResultUploader access$000() {
            return instance;
        }
    }

    public CommandResultUploader() {
        this.wifiOnlyResultMap = new HashMap();
    }

    private void ensureDirExist() {
        if (this.pendingDir != null) goto L5;
        return;
    L5:
        if (this.pendingDir.exists() == true) goto L9;
        this.pendingDir.mkdirs();
        return;
    }

    public static CommandResultUploader getInstance() {
        return InnerHolder.access$000();
    }

    public File getPendingDir() {
        if (this.pendingDir == null) goto L5;
    L9:
        ensureDirExist();
        return this.pendingDir;
    L5:
        if (ApmContext.getContext() == null) goto L7;
        this.pendingDir = new File(ApmContext.getContext().getFilesDir(), PENDING_UPLOAD_DIR);
        goto L9
    L7:
        return null;
    }

    public boolean isWifiOnly(String r1) {
        if (this.wifiOnlyResultMap.get(r1) != Boolean.TRUE) goto L5;
        return true;
    L5:
        return false;
    }

    public synchronized void upload(CloudMessage r11, File r12, String r13) {
        monitor-enter(this);
        CommandReportUtils.uploadRunningMessage("命令产物已生成，等待上传", r11);     // Catch: Throwable -> L9
        ensureDirExist();     // Catch: Throwable -> L9
        String r1 = r11.getCommandId();     // Catch: Throwable -> L9
        File r2 = getPendingDir();     // Catch: Throwable -> L9
        if (r2 == null) goto L40;
        File r3 = new File(r2, r1);     // Catch: Throwable -> L9
        if (r3.exists() == false) goto L11;
        FileUtils.deleteFile(r3);     // Catch: Throwable -> L9
    L11:
        r12.renameTo(r3);     // Catch: Throwable -> L9
        long r4 = CommonMonitorUtil.getFileDirSize(r3);     // Catch: Throwable -> L9
        boolean r6 = true;
        if (r11.isWifiOnly() == true) goto L14;
    L16:
        boolean r14 = false;
    L17:
        this.wifiOnlyResultMap.put(r1, Boolean.valueOf(r14));     // Catch: Throwable -> L9
        if (r14 == true) goto L20;
    L24:
        File[] r15 = r3.listFiles(new AnonymousClass1(this));     // Catch: Throwable -> L9
        int r0 = r15.length;     // Catch: Throwable -> L9
        int r5 = 0;
    L25:
        if (r5 >= r0) goto L34;
        File r7 = r15[r5];     // Catch: Throwable -> L9
        boolean r8 = CommandReportUtils.uploadFile(r1, r7, r13, "正在上传:" + r7.getName());     // Catch: Throwable -> L9
        StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L9
        r9.append("文件上传");     // Catch: Throwable -> L9
        if (r8 == false) goto L29;
        String r10 = "成功";
    L30:
        r9.append(r10);     // Catch: Throwable -> L9
        r9.append(":");     // Catch: Throwable -> L9
        r9.append(r7.getName());     // Catch: Throwable -> L9
        CommandReportUtils.uploadRunningMessage(r9.toString(), r11);     // Catch: Throwable -> L9
        if (r8 == true) goto L33;
        r6 = false;
    L33:
        r5 = r5 + 1;     // Catch: Throwable -> L9
        goto L25
    L29:
        r10 = "失败";
        goto L30
    L34:
        if (r6 == false) goto L36;
        CommandReportUtils.uploadSuccessMessage(r1);     // Catch: Throwable -> L9
    L36:
        FileUtils.deleteFile(r3);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L20:
        if (NetworkUtils.isWifi(CloudMessageManager.getInstance().getContext()) == true) goto L24;
        CommandReportUtils.uploadRunningMessage("产物超过阈值，等待WiFi环境执行. fileTotalSize=" + r4, r11);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L14:
        if (r4 <= 2097152) goto L16;
        r14 = true;
        goto L17
    L40:
        throw new CloudMessageException("pending目录因拿不到context而未设置");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }
}
