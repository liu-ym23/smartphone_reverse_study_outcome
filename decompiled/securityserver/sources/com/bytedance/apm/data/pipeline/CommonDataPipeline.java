package com.bytedance.apm.data.pipeline;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.data.BaseDataPipeline;
import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CommonDataPipeline extends BaseDataPipeline<ITypeData> {
    private static volatile CommonDataPipeline singleton;
    private ICommonDataInnerListener mCommonDataListener;

    private CommonDataPipeline() {
    }

    public static CommonDataPipeline getInstance() {
        if (singleton != null) goto L16;
        monitor-enter(CommonDataPipeline.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (singleton != null) goto L11;
        singleton = new CommonDataPipeline();     // Catch: Throwable -> L9
    L11:
        monitor-exit(CommonDataPipeline.class);     // Catch: Throwable -> L9
    L16:
        return singleton;
    }

    @Override // com.bytedance.apm.data.BaseDataPipeline
    public void handleAfterReady(ITypeData r10) {
        JSONObject r8 = r10.packLog();
        boolean r6 = r10.isSampled(r8);
        if (ApmContext.isDebugMode() == true) goto L16;
    L8:
        if (r6 == false) goto L10;
    L12:
        logSend(r10.getTypeLabel(), r10.getSubTypeLabel(), r8, r6, false);
        ICommonDataInnerListener r9 = this.mCommonDataListener;
        if (r9 == null) goto L18;
        r9.deliver(r10.getTypeLabel(), r10.getSubTypeLabel(), r8);
        return;
    L18:
        return;
    L10:
        if (r10.supportFetch() == true) goto L12;
        return;
    L16:
        Logger.iJson(DebugLogger.TAG_FLOW, new Object[]{"logType: " + r10.getTypeLabel() + ", subType: " + r10.getSubTypeLabel() + "data: " + r8, " ,sample: " + r6});     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public void setCommonDataListener(ICommonDataInnerListener r1) {
        this.mCommonDataListener = r1;
    }
}
