package com.bytedance.apm.entity;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class UploadLogLegacyCommand {
    public long endTime;
    public long startTime;
    private List<String> uploadTypeList;

    public UploadLogLegacyCommand(long r1, long r3, List<String> r5) {
        this.startTime = r1;
        this.endTime = r3;
        this.uploadTypeList = r5;
    }

    public List<String> getUploadTypeList() {
        return this.uploadTypeList;
    }
}
