package com.monitor.cloudmessage.handler.impl;

import android.text.TextUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.utils.FileUtils;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DataClearMessageHandler extends BaseMessageHandler {
    private static final String KEY_DELETE_STRATEGY = "deleteStrategy";
    private static final String KEY_EXPIRATION_TIME = "expiration_time";
    private static final String KEY_RELATIVEDIRNAME = "relativeDirName";
    private static final String KEY_ROOTNODE = "rootNode";
    private static final int STRATEGY_DELETE_ALL = 0;
    private static final int STRATEGY_DELETE_BY_TIME = 1;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.DATA_CLEAR;
    }

    public DataClearMessageHandler() {
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage r18) throws Exception {
        JSONObject r2 = new JSONObject(r18.getParams());
        if (checkWifiOnly(r2, r18) == false) goto L5;
        return true;
    L5:
        String r3 = FileUtils.getFullPath(r2.optString(KEY_ROOTNODE), r2.optString(KEY_RELATIVEDIRNAME));
        String r6 = null;
        if (TextUtils.isEmpty(r3) == false) goto L8;
        File r5 = null;
        r6 = ErrorMsg.COMMAND_DIRNAME_EMPTY;
    L12:
        if (TextUtils.isEmpty(r6) == true) goto L15;
        uploadFailStatus(r6, r18);
        return true;
    L15:
        boolean r7 = false;
        int r4 = r2.optInt(KEY_DELETE_STRATEGY, 0);
        if (r4 == 0) goto L43;
        if (r4 == 1) goto L20;
        uploadFailStatus(ErrorMsg.COMMAND_DATA_DELETE_STRATEGY_NOT_FOUND, r18);
        return true;
    L20:
        long r8 = r2.optLong(KEY_EXPIRATION_TIME, -1);
        if (r8 >= 0) goto L24;
        uploadFailStatus(ErrorMsg.COMMAND_EXPIRATION_TIME_NULL, r18);
    L41:
        boolean r12 = true;
    L46:
        if (r12 == true) goto L48;
        uploadFailStatus(ErrorMsg.COMMAND_DATA_DELETE_FAIL, r18);
    L49:
        return true;
    L48:
        uploadSuccessStatus(r18);
        goto L49
    L24:
        if (r5.isDirectory() == false) goto L36;
        File[] r9 = r5.listFiles();
        int r10 = r9.length;
        r12 = true;
        int r11 = 0;
    L26:
        if (r11 >= r10) goto L46;
        if (r9[r11].lastModified() >= (r8 * 1000)) goto L34;
        if (r12 == true) goto L31;
    L33:
        r12 = false;
        goto L34
    L31:
        if (r5.delete() == false) goto L33;
        r12 = true;
    L34:
        r11 = r11 + 1;
        goto L26
    L36:
        if (r5.lastModified() >= (r8 * 1000)) goto L41;
        if (r5.delete() == false) goto L40;
        r7 = true;
    L40:
        r12 = r7;
        goto L46
    L43:
        if (r5.isDirectory() == false) goto L45;
        r12 = FileUtils.removeDir(r5.getAbsolutePath());
        goto L46
    L45:
        r12 = r5.delete();
        goto L46
    L8:
        r5 = new File(r3);
        if (r5.exists() == true) goto L12;
        r6 = ErrorMsg.COMMAND_DIR_FILE_NOT_EXIST;
        goto L12
    }
}
