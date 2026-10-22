package com.monitor.cloudmessage.handler.impl;

import androidx.core.os.EnvironmentCompat;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.refactor.CommandReportUtils;
import com.monitor.cloudmessage.refactor.CommandResultUploader;
import com.monitor.cloudmessage.utils.FileUtils;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class FileUploadMessageHandler extends BaseMessageHandler {
    private static final long DIR_SIZE_THRESHOLD = 134217728;
    private static final String KEY_RELATIVE_FILENAME = "relativeFilename";
    private static final String KEY_ROOT_NODE = "rootNode";
    private static final String KEY_SYSTEM_SO = "systemlib_so";
    private static final String SUFFIX_ART = ".art";
    private static final String SUFFIX_JAR = ".jar";
    private static final String SUFFIX_ODEX = ".odex";
    private static final String SUFFIX_SO = ".so";
    private static final String SUFFIX_VDEX = ".vdex";
    private long mLastHandleTime;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.UPLOAD;
    }

    public FileUploadMessageHandler() {
        this.mLastHandleTime = 0;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage r8) throws Exception {
        JSONObject r0 = r8.getParamsJson();
        if ((System.currentTimeMillis() - this.mLastHandleTime) >= 120000) goto L6;
        CommandReportUtils.uploadRunningMessage("2分钟不重复处理文件回捞", r8);
        return false;
    L6:
        this.mLastHandleTime = System.currentTimeMillis();
        String r7 = r0.optString(KEY_ROOT_NODE);
        String r1 = r0.optString(KEY_RELATIVE_FILENAME);
        if (r1.contains("../") == true) goto L50;
        if (KEY_SYSTEM_SO.equals(r7) == true) goto L11;
        File r9 = FileUtils.joinFile(r7, r1);
    L25:
        if (r9 == null) goto L48;
        CommandReportUtils.uploadRunningMessage("handling file upload:" + r9.getAbsolutePath(), r8);
        if (r9.exists() == false) goto L46;
        if (r9.canRead() == false) goto L44;
        if (r9.isDirectory() == true) goto L33;
    L37:
        File r2 = CommandResultUploader.getInstance().getPendingDir();
        if (r2 == null) goto L42;
        File r3 = new File(r2, r8.getCommandId() + "_temp");
        FileUtils.ensureDirectoryClean(r3);
        FileUtils.compress(new File(r3, "result.zip").getAbsolutePath(), new String[]{r9.getAbsolutePath()});
        CommandResultUploader.getInstance().upload(r8, r3, r0.optString("fileContentType", EnvironmentCompat.MEDIA_UNKNOWN));
        return true;
    L42:
        throw new CloudMessageException("pending目录因拿不到context而未设置");
    L33:
        if (CommonMonitorUtil.getFileDirSize(r9) <= 134217728) goto L37;
        throw new CloudMessageException("回捞目录过大，禁止回捞");
    L44:
        throw new CloudMessageException("文件或目录无可读权限");
    L46:
        throw new CloudMessageException("文件或目录不存在");
    L48:
        throw new CloudMessageException("目录参数解析失败");
    L11:
        if (r1.endsWith(".so") == false) goto L13;
    L23:
        r9 = new File(r1);
        goto L25
    L13:
        if (r1.endsWith(SUFFIX_ODEX) == true) goto L23;
        if (r1.endsWith(SUFFIX_JAR) == true) goto L23;
        if (r1.endsWith(SUFFIX_VDEX) == true) goto L23;
        if (r1.endsWith(SUFFIX_ART) == true) goto L23;
        throw new CloudMessageException("非so, jar, odex, vdex, art 文件无权回捞");
    L50:
        throw new CloudMessageException("it's not allowed to use the form `../` to route in path");
    }
}
