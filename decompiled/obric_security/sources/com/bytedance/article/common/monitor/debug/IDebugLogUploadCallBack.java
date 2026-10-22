package com.bytedance.article.common.monitor.debug;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface IDebugLogUploadCallBack {
    List<String> getUploadContentFileNameList();

    void notifyBeginUpload(String r1);

    void notifyEndUpload(String r1, boolean r2);
}
