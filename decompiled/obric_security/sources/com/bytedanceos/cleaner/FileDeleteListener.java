package com.bytedanceos.cleaner;

/* JADX INFO: loaded from: classes2.dex */
public interface FileDeleteListener {
    void onDeleteFinish(long totalDeletedSize);

    void onFileDeleted(long deletedFileSize);
}
