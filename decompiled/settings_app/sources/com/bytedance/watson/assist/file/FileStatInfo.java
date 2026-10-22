package com.bytedance.watson.assist.file;

/* JADX INFO: loaded from: classes3.dex */
public interface FileStatInfo {
    void calculateDelta(FileStatInfo r1);

    void merge(FileStatInfo r1);
}
