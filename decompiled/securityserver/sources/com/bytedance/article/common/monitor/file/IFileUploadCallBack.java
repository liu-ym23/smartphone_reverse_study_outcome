package com.bytedance.article.common.monitor.file;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface IFileUploadCallBack {
    List<String> getUploadFileList();

    void notifyUploadBegin(String r1);

    void notifyUploadEnd(String r1, boolean r2);
}
