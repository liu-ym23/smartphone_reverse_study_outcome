package com.bytedanceos.cleaner;

/* JADX INFO: loaded from: classes2.dex */
public interface TaskProgress {
    void addObserver(ProgressObserver po);

    boolean contains(Object obj);

    void notifyFinished(Object result);

    void notifyProgress(IProgress progress);

    void notifyStart();

    void removeObserver(ProgressObserver po);
}
