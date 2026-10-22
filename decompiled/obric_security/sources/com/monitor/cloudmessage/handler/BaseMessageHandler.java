package com.monitor.cloudmessage.handler;

import com.bytedance.apm.logging.Logger;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.refactor.CommandReportUtils;
import com.monitor.cloudmessage.refactor.CommandResultUploader;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.entity.UploadInfo;
import com.monitor.cloudmessage.utils.ExceptionUtils;
import com.monitor.cloudmessage.utils.NetworkUtils;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseMessageHandler implements IMessageHandler {
    private static final long COMMAND_INTERNAL = 10000;
    private static ConcurrentHashMap<String, Long> cmdIdMap;

    public abstract String getCloudControlType();

    public abstract boolean handleMessage(CloudMessage r1) throws Exception;

    public BaseMessageHandler() {
    }

    static {
        cmdIdMap = new ConcurrentHashMap();
    }

    @Override // com.monitor.cloudmessage.handler.IMessageHandler
    public synchronized boolean handleCloudMessage(CloudMessage r7) {
        monitor-enter(this);
    L33:
        th = move-exception;
        throw th;
    L6:
        if (getCloudControlType().equals(r7.getType()) == true) goto L37;
        monitor-exit(this);
        return false;
    L37:
    L29:
        e = move-exception;
        uploadFailStatus(e.getMessage(), r7);     // Catch: Throwable -> L33
        return false;
    L25:
        e = move-exception;
        uploadFailStatus(String.format("系统错误：%s", new Object[]{ExceptionUtils.getFullStacktrace(e)}), r7);     // Catch: Throwable -> L33
        return false;
    L11:
        if (isTypeInBlockList() == false) goto L16;
        handleMsgInBlackList(r7);     // Catch: Exception -> L25 CloudMessageException -> L29 Throwable -> L33
        monitor-exit(this);
        return true;
    L16:
        if (checkCmdInterval(r7) == true) goto L18;
    L22:
        Logger.d("cloudmessage", new String[]{"checkCmdInterval false: ignored for now."});     // Catch: Exception -> L25 CloudMessageException -> L29 Throwable -> L33
        monitor-exit(this);
        return false;
    L18:
        if (checkResultCanUpload(r7) == false) goto L22;
        Logger.d("cloudmessage", new String[]{"start handle message:" + r7});     // Catch: Exception -> L25 CloudMessageException -> L29 Throwable -> L33
        boolean r8 = handleMessage(r7);     // Catch: Exception -> L25 CloudMessageException -> L29 Throwable -> L33
        monitor-exit(this);
        return r8;
    }

    protected boolean checkResultCanUpload(CloudMessage r2) {
        if (CommandResultUploader.getInstance().isWifiOnly(r2.getCommandId()) == true) goto L5;
        return true;
    L5:
        if (NetworkUtils.isWifi(CloudMessageManager.getInstance().getContext()) == true) goto L10;
        CommandReportUtils.uploadRunningMessage("产物超过阈值，等待WiFi环境执行", r2);
        return false;
    L10:
        return true;
    }

    protected boolean isTypeInBlockList() {
        if (CloudMessageManager.getBlackListForCloudContrlInf() == null) goto L11;
        String[] r0 = CloudMessageManager.getBlackListForCloudContrlInf();
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        if (getCloudControlType().equals(r0[r3]) == true) goto L8;
        r3 = r3 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    private void handleMsgInBlackList(CloudMessage r7) {
        UploadInfo r6 = new UploadInfo(0, false, r7.getCommandId(), null);
        r6.setCloudMsgResponseCode(3);
        r6.setErrorMsg(ErrorMsg.COMMAND_IN_SDK_BLACK_LIST);
        CloudMessageUploadManager.upload(r6);
    }

    private boolean checkCmdInterval(CloudMessage r5) {
        String r4 = r5.getCommandId();
        if (cmdIdMap.containsKey(r4) == false) goto L9;
        long r0 = cmdIdMap.get(r4).longValue();
        if ((System.currentTimeMillis() - r0) >= 10000) goto L8;
        return false;
    L8:
        cmdIdMap.put(r4, Long.valueOf(System.currentTimeMillis()));
        return true;
    L9:
        cmdIdMap.put(r4, Long.valueOf(System.currentTimeMillis()));
        return true;
    }

    protected boolean checkWifiOnly(JSONObject r8, CloudMessage r9) {
        if (r8.optBoolean("wifiOnly", false) == true) goto L5;
    L8:
        return false;
    L5:
        if (NetworkUtils.isWifi(CloudMessageManager.getInstance().getContext()) == true) goto L8;
        UploadInfo r7 = new UploadInfo(0, false, r9.getCommandId(), null);
        r7.setCloudMsgResponseCode(0);
        r7.setErrorMsg(ErrorMsg.COMMAND_NOT_EXECUTE_IN_4G);
        CloudMessageUploadManager.upload(r7);
        return true;
    }

    protected void uploadFailStatus(String r7, CloudMessage r8) {
        UploadInfo r6 = new UploadInfo(0, false, r8.getCommandId(), null);
        r6.setCloudMsgResponseCode(3);
        r6.setErrorMsg(r7);
        CloudMessageUploadManager.upload(r6);
    }

    protected void uploadSuccessStatus(CloudMessage r7) {
        UploadInfo r6 = new UploadInfo(0, false, r7.getCommandId(), null);
        r6.setCloudMsgResponseCode(2);
        CloudMessageUploadManager.upload(r6);
    }

    protected void uploadFailStatus(String r7, HashMap<String, String> r8, CloudMessage r9) {
        UploadInfo r6 = new UploadInfo(0, false, r9.getCommandId(), r8);
        r6.setCloudMsgResponseCode(3);
        r6.setErrorMsg(r7);
        CloudMessageUploadManager.upload(r6);
    }
}
