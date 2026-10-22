package com.monitor.cloudmessage.upload.callback;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IFileUploadCallback {
    List<String> getUploadFileList();

    void notifyUploadBegin(String r1);

    void notifyUploadEnd(String r1, boolean r2);
}
