package com.bytedance.platform.godzilla.anr.sp;

/* JADX INFO: loaded from: classes3.dex */
public final class QueuedWorkProxyWrapper {
    private QueuedWorkProxyWrapper() {
    }

    public static void hookQueuedWork() {
        QueuedWorkProxyAboveOrEqualsAndroid0.replacesFinishersAndsWork();
    }
}
