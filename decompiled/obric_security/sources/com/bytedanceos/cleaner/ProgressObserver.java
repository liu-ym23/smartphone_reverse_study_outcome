package com.bytedanceos.cleaner;

/* JADX INFO: loaded from: classes2.dex */
public interface ProgressObserver {
    void onFinished(Object obj);

    void onStart();

    void updateProgress(IProgress progress);
}
