package com.monitor.cloudmessage.handler.impl;

import android.content.Context;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.util.ParseUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.internal.file.generator.DirTreeFileGenerator;
import com.monitor.cloudmessage.refactor.CommandReportUtils;
import com.monitor.cloudmessage.refactor.CommandResultUploader;
import com.monitor.cloudmessage.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class CacheMessageHandler extends BaseMessageHandler {
    private static final String CACHE_FILE_TYPE = "log_dir_tree";
    private static final String EXTERNAL_PREFIX = "external";
    private static final String INTERNAL_PREFIX = "internal";
    private static final String KEY_RELATIVE_DIRNAME = "relativeDirName";
    private static final String KEY_ROOT_NODE = "rootNode";

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.CACHE;
    }

    public CacheMessageHandler() {
    }

    static /* synthetic */ void access$000(CacheMessageHandler r0, JSONObject r1, boolean r2, CloudMessage r3) throws Exception {
        r0.parseConfig(r1, r2, r3);
    }

    static /* synthetic */ void access$100(CacheMessageHandler r0, String r1, CloudMessage r2) {
        r0.uploadFailStatus(r1, r2);
    }

    static /* synthetic */ void access$200(CacheMessageHandler r0, String r1, CloudMessage r2) {
        r0.uploadFailStatus(r1, r2);
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(final CloudMessage r2) throws Exception {
        IConfigListener r0 = new AnonymousClass1(this, r2);
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).registerConfigListener(r0);
        return true;
    }

    private void parseConfig(JSONObject r4, boolean r5, CloudMessage r6) throws Exception {
        JSONObject r7 = r4.optJSONObject("performance_modules");
        if (r7 != null) goto L5;
        return;
    L5:
        JSONObject r8 = r7.optJSONObject("disk");
        if (r8 != null) goto L8;
        return;
    L8:
        List<String> r3 = toAbsolutePath(ParseUtils.parseList(r8, "compliance_relative_paths"));
        JSONObject r9 = r6.getParamsJson();
        File r10 = FileUtils.joinFile(r9.optString(KEY_ROOT_NODE), r9.optString(KEY_RELATIVE_DIRNAME));
        if (r10 == null) goto L25;
        CommandReportUtils.uploadRunningMessage("handling dir upload:" + r10.getAbsolutePath(), r6);
        if (r10.exists() == false) goto L23;
        File r11 = CommandResultUploader.getInstance().getPendingDir();
        if (r11 == null) goto L21;
        File r0 = new File(r11, r6.getCommandId() + "_temp");
        FileUtils.ensureDirectoryClean(r0);
        boolean r12 = DirTreeFileGenerator.writeDirTreeInfo(r10, new File(r0, "dir_tree.txt"), r3);
        Logger.d("cloudmessage", new String[]{"dir tree generate result " + r12});
        if (r12 == false) goto L19;
        CommandResultUploader.getInstance().upload(r6, r0, CACHE_FILE_TYPE);
        return;
    L19:
        throw new CloudMessageException("目录树文件生成失败");
    L21:
        throw new CloudMessageException("pending目录因拿不到context而未设置");
    L23:
        throw new CloudMessageException("目录不存在");
    L25:
        throw new CloudMessageException("目录参数解析失败");
    }

    private List<String> toAbsolutePath(List<String> r5) {
        ArrayList r4 = new ArrayList();
        if (ListUtils.isEmpty(r5) == false) goto L5;
        return r4;
    L5:
        Context r0 = CloudMessageManager.getInstance().getContext();
        Iterator<String> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L14;
        String r1 = r6.next();
        if (r1.contains(INTERNAL_PREFIX) == true) goto L10;
        if (r1.contains(EXTERNAL_PREFIX) == false) goto L7;
        r4.add(r1.replace(EXTERNAL_PREFIX, r0.getExternalFilesDir(null).getParentFile().getAbsolutePath()));
        goto L7
    L10:
        r4.add(r1.replace(INTERNAL_PREFIX, r0.getFilesDir().getParentFile().getAbsolutePath()));
        goto L7
    L14:
        return r4;
    }
}
