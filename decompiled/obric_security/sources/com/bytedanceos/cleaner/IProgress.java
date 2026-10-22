package com.bytedanceos.cleaner;

/* JADX INFO: loaded from: classes2.dex */
public interface IProgress {
    long getCurrentItemSize();

    String getDescription();

    long getItemRemainsize();

    int getPassedPercent();

    long getPassedSize();

    long getProcessedSize();

    boolean isFinal();

    void setItemRemainSize(long size);

    void setProcessedSize(long size);
}
